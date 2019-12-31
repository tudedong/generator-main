# generator-main
代码生成工具

#数据准备
1.配置项目jdk
2.配置maven本地环境
3.准备数据库数据

#环境搭建
1.在generator-main下面新建springboot项目td-generator
2.在pom.xml中引入相关依赖
3.在resources文件夹下配置application.yml文件(包括服务名称端口、数据源、mybatis、静态资源路径、生成代码的输出位置等)
4.在java文件目录下创建后台文件（包括controller、service、mapper、utils、exception等）
5.在resources文件目录下创建代码模板tmpcode和前端展示文件
6.配置启动类TdGeneratorApplication.java

#使用说明
1.启动项目：运行TdGeneratorApplication.java，在浏览器中输入http://localhost:8080/gencode/index，访问首页
2.生成代码：
先选择要生成代码的数据表（例如sys_user）,然后点击“插入主表”按钮，后面点击“生成”按钮，
最后填写包路径和类名，点击“确定”按钮，若生成成功则在gencode文件夹下生成对应的文件（包括：
SysUser.java、SysUserMapper.java、SysUserMapper.xml、SysUserController.java、SysUserService.java）
3.下载代码
当代码生成成功后，在页面上点击“下载”按钮即可以将代码下载下来使用，下载下来的文件为：SysUser-TdGenerator.zip