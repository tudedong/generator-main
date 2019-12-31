package ${packageName}.controller;

import ${packageName}.entity.${className};
import ${packageName}.service.${className}Service;
import ${packageName}.util.ParamsData;
import ${packageName}.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/${className?uncap_first}")
public class ${className}Controller {

    @Autowired
    private ${className}Service ${className?uncap_first}Service;

    @RequestMapping("/queryList")
    @ResponseBody
    public Result queryList(@RequestBody ParamsData<${className}.Query,${className}.Order> paramsData){
        return Result.successResult(${className?uncap_first}Service.getPageList(paramsData));
    }

    @RequestMapping("/load/{id}")
    @ResponseBody
    public Result load(@PathVariable ${primaryKeyType} id){
        return Result.successResult(${className?uncap_first}Service.getById(id));
    }

    @RequestMapping("/save")
    @ResponseBody
    public Result save(@RequestBody ${className} ${className?uncap_first}){
        boolean b = ${className?uncap_first}Service.insert(${className?uncap_first});
        if(b){
            return Result.successResult();
        }
        return Result.successResult();
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result update(@RequestBody ${className} ${className?uncap_first}){
        boolean b = ${className?uncap_first}Service.updateById(${className?uncap_first});
        if(b){
            return Result.successResult();
        }
        return Result.errorResult("系统异常");
    }

    @RequestMapping("/deleteArray")
    @ResponseBody
    public Result delete(@RequestBody List<${className}> list){
        String msg="";
        for(${className} ${className?uncap_first}:list){
            try{
                boolean b = ${className?uncap_first}Service.deleteById(${className?uncap_first}.getId());
                if(!b){
                msg+=${className?uncap_first}.getEntityId()+"删除失败;";
                }
            }catch (Exception e){
                e.printStackTrace();
                msg+=${className?uncap_first}.getEntityId()+"删除失败;";
            }
        }
        if(StringUtils.isEmpty(msg)){
            return Result.successResult();
        }
        return Result.errorResult(msg);
    }

}