package com.td.generator.utils;

/**
 * @author tudedong
 * @description
 * @date 2019-12-30 14:45:44
 */
public class JoinTable {

    private String tableName;

    private String tableSubName;

    private String joinField;

    private String tableJoinName;

    private String tableJoinField;

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

    public String getJoinField() {
        return joinField;
    }

    public void setJoinField(String joinField) {
        this.joinField = joinField;
    }

    public String getTableJoinName() {
        return tableJoinName;
    }

    public void setTableJoinName(String tableJoinName) {
        this.tableJoinName = tableJoinName;
    }

    public String getTableJoinField() {
        return tableJoinField;
    }

    public void setTableJoinField(String tableJoinField) {
        this.tableJoinField = tableJoinField;
    }
}
