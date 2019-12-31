package com.td.generator.service;

import com.td.generator.mapper.TableMapper;
import com.td.generator.utils.MysqlStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author tudedong
 * @description 代码生成服务类
 * @date 2019-12-30 15:25:13
 */
public interface TableService {

    List<MysqlStructure> getTableInfo(String tableName);

    List<String> getTables();
}
