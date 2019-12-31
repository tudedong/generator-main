package com.td.generator.utils;

import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ClassUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
/**
 * @author tudedong
 * @description
 * @date 2019-12-30 14:45:24
 */
@Configuration
public class GencodeUtil {

    @Value("${output}")
    private String output;

    @Value("${templatePath}")
    private String templatePath;

    public String gencode(GenJson genJson) throws Exception {
        Map<String, Object> root = new HashMap<String, Object>();
        root.put("packageName", genJson.getPackageName());
        root.put("className", genJson.getClassName());
        root.put("tableName", genJson.getTableName());
        root.put("tableSubName", genJson.getTableSubName());
        root.put("primaryKey", genJson.getPrimaryKey());
        root.put("primaryKeyOri", genJson.getPrimaryKeyOri());
        root.put("primaryKeyType", genJson.getPrimaryKeyType());
        root.put("primaryKeyIsAuto", genJson.getPrimaryKeyIsAuto());
        root.put("otherFieldNum", genJson.getOtherFieldNum());
        root.put("joinTables", genJson.getJoinTables());
        root.put("fields", genJson.getFields());
        root.put("sign", "#");
        root.put("ordername", "${order.name}");
        root.put("ordertype", "${order.type}");
        root.put("queryname", "${query.name}");
        root.put("queryopt", "${query.opt}");
        root.put("queryvalue", "${query.value}");
        root.put("queryvalueori", "query.value");
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        makeFile("controller", genJson.getClassName(), root, "Controller.java",uuid);
        makeFile("entity", genJson.getClassName(), root, ".java",uuid);
        makeFile("mapper", genJson.getClassName(), root, "Mapper.java",uuid);
        makeFile("mapperxml", genJson.getClassName(), root, "Mapper.xml",uuid);
        makeFile("service", genJson.getClassName(), root, "Service.java",uuid);
        String className=genJson.getClassName();
        List<File> list=new ArrayList<File>();
        File controlFile=new File(output+uuid+"/",className + "Controller.java");
        File entityFile=new File(output+uuid+"/",className + ".java");
        File mapperFile=new File(output+uuid+"/",className + "Mapper.java");
        File xmlFile=new File(output+uuid+"/",className + "Mapper.xml");
        File serviceFile=new File(output+uuid+"/",className + "Service.java");
        list.add(controlFile);
        list.add(entityFile);
        list.add(mapperFile);
        list.add(xmlFile);
        list.add(serviceFile);
        OutputStream fos = new FileOutputStream(new File(output+uuid+"/", uuid+".zip"));
        ZipUtil.toZip(list,fos);
        return uuid;
    }

    public void makeFile(String templateName, String className, Map<String, Object> root, String suffix,String uuid) throws Exception {
        //获取模板
        Template temp = getDefinedTemplate(templateName + ".ftl");
        //设置根值
        File file=new File(output+uuid);
        if(!file.exists()){
            file.mkdir();
        }
        OutputStream fos = new FileOutputStream(new File(output+uuid+"/", className + suffix));
        Writer out = new OutputStreamWriter(fos);
        temp.process(root, out);
        fos.flush();
        fos.close();
    }

    public Template getDefinedTemplate(String templateName) throws Exception {
        freemarker.template.Configuration cfg = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_22);
        cfg.setDirectoryForTemplateLoading(new File(templatePath));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        return cfg.getTemplate(templateName);
    }
}
