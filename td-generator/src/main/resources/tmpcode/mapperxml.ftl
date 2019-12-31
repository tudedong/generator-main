<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${packageName}.mapper.${className}Mapper" >

    <sql id="column">
        <#list fields as field>
          <#if (field_index+1)==fields?size>
              ${field.tableField} as ${field.name}
          <#else>
              ${field.tableField} as ${field.name},
          </#if>
        </#list>
    </sql>

    <sql id="normalColumn">
    <#list fields as field>
        <#if (field_index+1)==(fields?size-otherFieldNum)>
            <#if field.isAuto!='auto_increment'&&field.isMainField=='yes'>
                ${field.originalField}
            </#if>
        <#else>
            <#if field.isAuto!='auto_increment'&&field.isMainField=='yes'>
                ${field.originalField},
            </#if>
        </#if>
    </#list>
    </sql>

    <sql id="tableName">
    ${tableName} ${tableSubName}
    </sql>

    <sql id="normalTable">
    ${tableName}
    </sql>

    <sql id="tableJoin">
        <#list joinTables as tables>
            left join ${tables.tableName} ${tables.tableSubName} on ${tables.tableSubName}.${tables.joinField}=${tables.tableJoinName}.${tables.tableJoinField}
        </#list>
    </sql>

    <sql id="whereClause">
        <where>
            <foreach collection="param.querys" item="query" >
                and ${queryname} ${queryopt}
                <choose>
                    <when test="query.opt.trim=='in'">
                        <foreach collection="${queryvalueori}" item="sub" open="(" close=")" separator=",">
                        ${sign}{sub}
                        </foreach>
                    </when>
                    <otherwise>
                    ${queryvalue}
                    </otherwise>
                </choose>
            </foreach>
        </where>
    </sql>

    <sql id="orderClause">
        <if test="param.orders.size>0">
            order by
            <foreach collection="param.orders" item="order" index="indexnum">
                <choose>
                    <when test="(param.orders.size-1)==indexnum">
                    ${ordername} ${ordertype}
                    </when>
                    <otherwise>
                    ${ordername} ${ordertype},
                    </otherwise>
                </choose>
            </foreach>
        </if>
    </sql>

    <select id="getList" resultType="${packageName}.entity.${className}" >
        select
        <include refid="column"/>
        from
        <include refid="tableName"/>
        <include refid="tableJoin"/>
        <include refid="whereClause"/>
        <include refid="orderClause"/>
    </select>

    <insert id="insert" parameterType="${packageName}.entity.${className}">
        <#if primaryKeyIsAuto=='auto_increment'>
            <selectKey keyProperty="${primaryKey}" order="AFTER" resultType="${primaryKeyType}">
                select LAST_INSERT_ID()
            </selectKey>
        </#if>
        insert into
        <include refid="normalTable"/>
        (
        <include refid="normalColumn"/>
        )
        values (
    <#list fields as field>
        <#if (field_index+1)==(fields?size-otherFieldNum)>
            <#if field.isAuto!='auto_increment'&&field.isMainField=='yes'>
                ${sign}{${field.name}}
            </#if>
        <#else>
            <#if field.isAuto!='auto_increment'&&field.isMainField=='yes'>
                ${sign}{${field.name}},
            </#if>
        </#if>
    </#list>
        )
    </insert>


    <update id="updateById" parameterType="${packageName}.entity.${className}">
        update
        <include refid="normalTable"/>
        <set>
    <#list fields as field>
            <#if field.name!=primaryKey&&field.isMainField=='yes'>
                ${field.originalField} = ${sign}{${field.name}},
            </#if>
    </#list>
        </set>
        where ${primaryKeyOri} = ${sign}{${primaryKey}}
    </update>

    <update id="updateByColumn" parameterType="${packageName}.entity.${className}">
        update
        <include refid="normalTable"/>
        <set>
    <#list fields as field>
        <#if field.name!=primaryKey&&field.isMainField=='yes'>
            <if test="columns.contains('${field.tableField}')">
                ${field.originalField} = ${sign}{entity.${field.name}},
            </if>
        </#if>
    </#list>
        </set>
        where ${primaryKeyOri} = ${sign}{entity.${primaryKey}}
    </update>


    <delete id="deleteById">
        delete from  <include refid="normalTable"/> where ${primaryKeyOri}=${sign}{${primaryKey}}
    </delete>

    <delete id="deleteByParam">
        delete  ${tableSubName}.* from
        <include refid="tableName"/>
        <include refid="tableJoin"/>
        <include refid="whereClause"/>
    </delete>

    <select id="getById" resultType="${packageName}.entity.${className}">
        select
        <include refid="column"/>
        from
        <include refid="tableName"/>
        <include refid="tableJoin"/>
        where ${tableSubName}.${primaryKeyOri}=${sign}{${primaryKey}}
    </select>

</mapper>