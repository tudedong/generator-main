package com.td.generator.service.impl;

import com.td.generator.mapper.TableMapper;
import com.td.generator.service.TableService;
import com.td.generator.utils.MysqlStructure;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tudedong
 * @description
 * @date 2019-12-31 14:19:06
 */
@Service
public class TableServiceImpl implements TableService {

    @Resource
    private TableMapper tableMapper;

    @Override
    public List<String> getTables(){
        return tableMapper.getTables();
    }

    @Override
    public List<MysqlStructure> getTableInfo(String tableName){
        List<MysqlStructure> tableInfo = tableMapper.getTableInfo(tableName);
        return tableInfo;
    }

}
