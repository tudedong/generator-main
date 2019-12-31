package com.td.generator.controller;

import com.td.generator.service.TableService;
import com.td.generator.utils.GenJson;
import com.td.generator.utils.GencodeUtil;
import com.td.generator.utils.MysqlStructure;
import com.td.generator.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
/**
 * @author tudedong
 * @description 代码生成控制器
 * @date 2019-12-30 15:26:56
 */
@Controller
@RequestMapping("/index")
public class GenCodeController {

    @Autowired
    private TableService tableService;

    @Autowired
    private GencodeUtil gencodeUtil;

    @Value("${output}")
    private String output;

    /**
     * 访问首页
     * @return
     */
    @RequestMapping("")
    public String toIndex(){
        return "index";
    }

    /**
     * 获取所有table
     * @return
     */
    @RequestMapping("/getTables")
    @ResponseBody
    public Result getTables(){
        List<String> tables = tableService.getTables();
        return Result.successResult(tables);
    }

    /**
     * 获取表信息
     * @param tableName
     * @return
     */
    @RequestMapping("/getTableInfo/{tableName}")
    @ResponseBody
    public Result getTableInfo(@PathVariable String tableName){
        List<MysqlStructure> tableInfo = tableService.getTableInfo(tableName);
        return Result.successResult(tableInfo);
    }

    /**
     * 生成代码
     * @param genJson
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/genCode")
    @ResponseBody
    public Result genCode(@RequestBody GenJson genJson, HttpServletRequest request)throws Exception{
        String uuid = gencodeUtil.gencode(genJson);
        request.getSession().setAttribute("uuid",uuid);
        return Result.successResult();
    }

    /**
     * 下载代码
     * @param res
     * @param request
     */
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void download(HttpServletResponse res,HttpServletRequest request) {
        String uuid =(String) request.getSession().getAttribute("uuid");
        String fileName = uuid+".zip";
        res.setHeader("content-type", "application/octet-stream");
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = res.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new File(output+uuid+"/", uuid+".zip")));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
