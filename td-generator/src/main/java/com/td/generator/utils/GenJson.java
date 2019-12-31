package com.td.generator.utils;

import java.util.List;

/**
 * @author tudedong
 * @description
 * @date 2019-12-30 14:44:38
 */
public class GenJson {

    private String packageName;

    private String className;

    private String tableName;

    private String tableSubName;

    private String primaryKey;

    private String primaryKeyOri;

    private String primaryKeyType;

    private String primaryKeyIsAuto;

    private Integer otherFieldNum;

    private List<JoinTable> joinTables;

    private List<Field> fields;

    public Integer getOtherFieldNum() {
        return otherFieldNum;
    }

    public void setOtherFieldNum(Integer otherFieldNum) {
        this.otherFieldNum = otherFieldNum;
    }

    public String getPrimaryKeyIsAuto() {
        return primaryKeyIsAuto;
    }

    public void setPrimaryKeyIsAuto(String primaryKeyIsAuto) {
        this.primaryKeyIsAuto = primaryKeyIsAuto;
    }

    public String getPrimaryKeyType() {
        return primaryKeyType;
    }

    public void setPrimaryKeyType(String primaryKeyType) {
        this.primaryKeyType = primaryKeyType;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableSubName() {
        return tableSubName;
    }

    public void setTableSubName(String tableSubName) {
        this.tableSubName = tableSubName;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getPrimaryKeyOri() {
        return primaryKeyOri;
    }

    public void setPrimaryKeyOri(String primaryKeyOri) {
        this.primaryKeyOri = primaryKeyOri;
    }

    public List<JoinTable> getJoinTables() {
        return joinTables;
    }

    public void setJoinTables(List<JoinTable> joinTables) {
        this.joinTables = joinTables;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }
}
