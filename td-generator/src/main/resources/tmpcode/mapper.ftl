package ${packageName}.mapper;

import ${packageName}.entity.${className};
import ${packageName}.util.ParamsData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ${className}Mapper {

    List<${className}> getList(@Param("param") ParamsData<${className}.Query,${className}.Order> paramOrderPage);

    ${className} getById(${primaryKeyType} id);

    int insert(${className} ${className?uncap_first});

    int updateById(${className} ${className?uncap_first});

    int updateByColumn(@Param("entity") ${className} ${className?uncap_first},@Param("columns")List<String> columns);

    int deleteById(@Param("id") ${primaryKeyType} id);

    int deleteByParam(@Param("param") ParamsData<${className}.Query,${className}.Order> paramOrderPage);

}