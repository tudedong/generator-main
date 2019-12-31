package com.td.generator.utils;

import org.springframework.util.StringUtils;

import java.lang.reflect.Field;

/**
 * @author tudedong
 * @description
 * @date 2019-12-30 14:43:02
 */
public class Base {

    public static String getFieldName(String name,Class clazz){
        String tableColumn="";
        try{
            Field field = clazz.getDeclaredField(name);
            GenField genField = (GenField)field.getAnnotation(GenField.class);
            tableColumn = genField.name();
        }catch (Exception e){
            //表示无该字段注解
        }
        return StringUtils.isEmpty(tableColumn) ? name : tableColumn;
    }

    public static Object getFormatValue(Object value,String opt){
        if(value!=null){
            if(opt.trim().equals("like")){
                if(!value.toString().startsWith("'%")&&!value.toString().endsWith("%'")){
                    value = "%"+value+"%";
                }
            }
            if(value instanceof String){
                if(!value.toString().startsWith("'")&&!value.toString().endsWith("'")) {
                    value = "'" + value + "'";
                }
            }
        }
        return value;
    }


    public  static  class Query {
        public static  Base.Query newInstance(){
            return new Query();
        }
        public Query() {
        }
        private String name;

        private String opt;

        private Object value;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOpt() {
            return opt;
        }

        public void setOpt(String opt) {
            this.opt = opt.toLowerCase();
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value =value;
        }

    }


    public  static  class Order {
        public static  Base.Order newInstance(){
            return new Order();
        }
        public Order() {
        }

        private String name;

        private String type;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

}
