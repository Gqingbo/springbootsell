# SpringBoot
[TOC]
#项目描述

#开发环境
[虚拟机centos7.3](media/15406958426809/centos7.3.ova)

```json
账号:root,密码:123456
软件:jdk1.8,nginx1.11.7,mysql5.7.17,redis3.2.8
JDK:/usr/local/jdk1.8.0_111
```
##日志框架
###框架能力
* 定制输出目标
* 定制输出格式 方便后期加工处理
* 携带上下文信息:时间戳、类路径、线程等
* 运行时的选择性输出:系统正常,只关心正常日志,如系统响应特别慢,可以只关心数据库访问层
* 灵活的配置,优异的性能

###**常见日志框架**

日志门面 | 日志实现 
--------- | -------------
JCL | Log4j
SLF4j(同logbak同一作者,) | Log4j2(Apache对log4j的二次开发,框架支持度不高,最求性能,可能有过度设计嫌疑)
jboss-logging (商业应用非服务大众)|** Logback**(作者对log4j的升级)
 | JUL(java官方,实现太过简陋)
###**日志使用**

```java
1、Logger logger = LoggerFactory.getLogger(LoggerTest.class);
2、lombok的注解: @slf4j

输出参数:logger.info(“name:{} ,password:{}",name,password);
```
###**Logback配置:**
* 区分info和error日志
* 每天产生一个日志文件

第一种方式:直接配置在application.yml:
```json
logging:
  pattern:
    console: "%d - %msg%n"
  path: /Users/gaoqingbo/logs/tomcat/
  level: debug
```

第二种方式: 单独用xml文件配置

```xml
<?xml version="1.0" encoding="UTF-8" ?>

<configuration>
    <appender name="comsoleLog" class="ch.qos.logback.core.ConsoleAppender">
        <layout class="ch.qos.logback.classic.PatternLayout">
            <pattern>
                %msg%n
            </pattern>
        </layout>
    </appender>
    <appender name="fileInfoLog" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <filter class="ch.qos.logback.classic.filter.LevelFilter">
            <level>ERROR</level>
            <onMatch>DENY</onMatch>
            <onMismatch>ACCEPT</onMismatch>
        </filter>
        <encoder>
            <pattern> %msg%n</pattern>
        </encoder>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>/Users/gaoqingbo/logs/tomcat/sell/info.%d.log</fileNamePattern>
        </rollingPolicy>
    </appender>
    <appender name="fileErrorLog" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <filter class="ch.qos.logback.classic.filter.ThresholdFilter">
            <level>ERROR</level>
        </filter>
        <encoder>
            <pattern> %msg%n</pattern>
        </encoder>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>/Users/gaoqingbo/logs/tomcat/sell/error.%d.log</fileNamePattern>
        </rollingPolicy>
    </appender>
    <root level="info">
        <appender-ref ref="comsoleLog"/>
        <appender-ref ref="fileInfoLog"/>
        <appender-ref ref="fileErrorLog"/>
    </root>
</configuration>
```