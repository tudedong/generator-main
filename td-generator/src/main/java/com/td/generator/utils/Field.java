package com.td.generator.utils;

/**
 * @author tudedong
 * @description
 * @date 2019-12-30 14:43:48
 */
public class Field {

    private String tableField;

    private String name;

    private String originalField;

    private String javaType;

    private String comment;

    private String isAuto;

    private String isMainField;

    public String getIsMainField() {
        return isMainField;
    }

    public void setIsMainField(String isMainField) {
        this.isMainField = isMainField;
    }

    public String getIsAuto() {
        return isAuto;
    }

    public void setIsAuto(String isAuto) {
        this.isAuto = isAuto;
    }

    public String getTableField() {
        return tableField;
    }

    public void setTableField(String tableField) {
        this.tableField = tableField;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginalField() {
        return originalField;
    }

    public void setOriginalField(String originalField) {
        this.originalField = originalField;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
