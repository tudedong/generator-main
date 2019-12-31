package com.td.generator.utils;

import org.springframework.util.StringUtils;

/**
 * @author tudedong
 * @description
 * @date 2019-12-30 14:48:20
 */
public class MysqlStructure {

    private Long id;

    private String tableName;

    private String javaTableName;

    private String columnName;

    private String javaColumnName;

    private String dataType;

    private String javaDataType;

    private String columnKey;

    private String extra;

    private String columnComment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJavaTableName() {
        return javaTableName;
    }

    public void setJavaTableName(String javaTableName) {
        this.javaTableName = javaTableName;
    }

    public String getJavaColumnName() {
        return javaColumnName;
    }

    public void setJavaColumnName(String javaColumnName) {
        this.javaColumnName = javaColumnName;
    }

    public String getJavaDataType() {
        return javaDataType;
    }

    public void setJavaDataType(String javaDataType) {
        this.javaDataType = javaDataType;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
        setJavaTableName(camelName(tableName));
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName=columnName;
        setJavaColumnName(camelName(columnName));
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
        setJavaDataType(mysqlType2JavaType(dataType));
    }

    public String getColumnKey() {
        return columnKey;
    }

    public void setColumnKey(String columnKey) {
        this.columnKey = columnKey;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }


    public  String mysqlType2JavaType(String mysqlType){
        String javaType="";
        switch (mysqlType){
            case "varchar":
                javaType="String";
                break;
            case "char":
                javaType="String";
                break;
            case "int":
                javaType="Integer";
                break;
            case "bigint":
                javaType="Long";
                break;
            case "tinyint":
                javaType="Integer";
                break;
            case "double":
                javaType="Double";
                break;
            case "float":
                javaType="Float";
                break;
        }
        return StringUtils.isEmpty(javaType) ? mysqlType : javaType;
    }


    public  String camelName(String name) {
        StringBuilder result = new StringBuilder();
        // 快速检查
        if (name == null || name.isEmpty()) {
            // 没必要转换
            return "";
        } else if (!name.contains("_")) {
            // 不含下划线，仅将首字母小写
            name = name.toLowerCase();
            return name.substring(0, 1).toLowerCase() + name.substring(1);
        }
        name = name.toLowerCase();
        // 用下划线将原始字符串分割
        String camels[] = name.split("_");
        for (String camel :  camels) {
            // 跳过原始字符串中开头、结尾的下换线或双重下划线
            if (camel.isEmpty()) {
                continue;
            }
            // 处理真正的驼峰片段
            if (result.length() == 0) {
                // 第一个驼峰片段，全部字母都小写
                result.append(camel.toLowerCase());
            } else {
                // 其他的驼峰片段，首字母大写
                result.append(camel.substring(0, 1).toUpperCase());
                result.append(camel.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }
}
