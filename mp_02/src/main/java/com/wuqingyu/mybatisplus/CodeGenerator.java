package com.wuqingyu.mybatisplus;

import cn.hutool.setting.Setting;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * @author ：wuqy
 * @date ：Created in 2019/6/20 17:02
 * @description： 代码生成器
 * @modified By：
 * @version:
 */
public class CodeGenerator {

    public static void main(String[] args) {
        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        globalConfig.setActiveRecord(true) // 是否开启AR模式
                .setAuthor("wuqy")// 作者
                .setIdType(IdType.AUTO) // 主键生成策略
                .setFileOverride(true)   //文件覆盖
                .setServiceName("%sService")   // 设置生成的service接口名字的首字母为I   IEmployeeService
                .setControllerName("%sController")
                .setMapperName("%sMapper")
                .setServiceImplName("%sServiceImpl")
                .setXmlName("%sMapper")
                .setBaseResultMap(true)
                .setBaseColumnList(true)
                .setOpen(true) //是否打开输出目录
                .setOutputDir("K:\\");
        //.setOutputDir(projectPath + "/src/main/java"); // 输出目录

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        Setting setting = new Setting("classpath:db.properties");
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setDriverName(setting.get("jdbc.driver"))
                .setUrl(setting.get("jdbc.url"))
                .setUsername(setting.get("jdbc.username"))
                .setPassword(setting.get("jdbc.password"));

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true) // 全局大写命名
                .setTablePrefix("tbl_") //表前缀
                .setNaming(NamingStrategy.underline_to_camel) //数据库表映射到实体的策略
                .setEntityLombokModel(true)
                .setRestControllerStyle(true)
                .setControllerMappingHyphenStyle(true)
                .entityTableFieldAnnotationEnable(true); //是否生成实体时，生成字段注解

        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.wuqingyu.mybatisplus")  // 申明父包
                .setMapper("mapper").setEntity("entity")
                .setService("service").setController("controller");
        //.setServiceImpl("service.impl");
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig).setDataSource(dataSourceConfig).setStrategy(strategyConfig).setPackageInfo(packageConfig);
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
        autoGenerator.execute();
    }
}
