package ${packageName}.entity;

import ${packageName}.util.Base;
import ${packageName}.util.GenField;

import java.lang.reflect.Field;
import java.util.Date;

public class ${className}{

        public static Query getQuery(String name,String opt,Object value){
            Query query = new Query();
            query.setName(name);
            query.setOpt(opt);
            query.setValue(value);
            return query;
        }

        public static Order getOrder(String name,String type){
            Order order = new Order();
            order.setName(name);
            order.setType(type);
            return order;
        }

        public static class Query extends Base.Query {
            public Query() {
            }
            public void setName(String name) {
                super.setName(Base.getFieldName(name, ${className}.class));
            }
            public void setValue(Object value) {
                super.setValue(Base.getFormatValue(value, super.getOpt()));
            }

        }
        public static class Order extends Base.Order {
            public Order() {
            }
            public void setName(String name) {
                super.setName(Base.getFieldName(name, ${className}.class));
            }
        }


    <#list fields as field>
        /**
         * ${field.comment}
         */
        @GenField(name="${field.tableField}")
        private <#if field.javaType=="datetime"||field.javaType=="timestamp"||field.javaType=="time"> Date <#else> ${field.javaType} </#if> ${field.name};
    </#list>

    <#list fields as field>
    public <#if field.javaType=="datetime"||field.javaType=="timestamp"||field.javaType=="time"> Date <#else> ${field.javaType} </#if> get${field.name?cap_first}() {
        return ${field.name};
    }

    public void set${field.name?cap_first}(<#if field.javaType=="datetime"||field.javaType=="timestamp"||field.javaType=="time"> Date <#else> ${field.javaType} </#if> ${field.name}) {
        this.${field.name} = ${field.name};
    }
    </#list>

    public ${primaryKeyType} getEntityId(){
        return get${primaryKey?cap_first}();
    }

}