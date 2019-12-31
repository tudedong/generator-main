package com.td.generator.mapper;

import com.td.generator.utils.MysqlStructure;

import java.util.List;

/**
 * @author tudedong
 * @description 数据库操作类
 * @date 2019-12-30 15:22:38
 */
public interface TableMapper {

    List<String> getTables();

    List<MysqlStructure> getTableInfo(String tableName);

}
