package ${packageName}.service;

import ${packageName}.entity.${className};
import ${packageName}.mapper.${className}Mapper;
import ${packageName}.util.ParamsData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ${className}Service {

    @Autowired
    private ${className}Mapper ${className?uncap_first}Mapper;


    public List<${className}> getList(ParamsData<${className}.Query,${className}.Order> paramOrderPage){
    List<${className}> list = ${className?uncap_first}Mapper.getList(paramOrderPage);
        return list;
    }

    public PageInfo<${className}> getPageList(ParamsData<${className}.Query,${className}.Order> paramOrderPage){
        PageInfo pageInfo = paramOrderPage.getPageInfo();
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize());
        List<${className}> list = ${className?uncap_first}Mapper.getList(paramOrderPage);
        PageInfo<${className}> result=new PageInfo<${className}>(list);
        return result;
    }

    public ${className} getById(${primaryKeyType} id){
        return ${className?uncap_first}Mapper.getById(id);
    }

    @Transactional
    public boolean insert(${className} ${className?uncap_first}){
        int num = ${className?uncap_first}Mapper.insert(${className?uncap_first});
        System.out.println("生成id:"+${className?uncap_first}.getId());
        if(num>0){
            return true;
        }
        return false;
    }

    @Transactional
    public boolean updateById(${className} ${className?uncap_first}){
        int num = ${className?uncap_first}Mapper.updateById(${className?uncap_first});
        if(num>0){
            return true;
        }
        return false;
    }

    @Transactional
    public boolean deleteById(${primaryKeyType} id){
        int num = ${className?uncap_first}Mapper.deleteById(id);
        if(num>0){
            return true;
        }
        return false;
    }

}