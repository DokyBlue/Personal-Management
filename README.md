# 基于Java的企业人事管理系统



[TOC]

## 软件环境

通过IntelliJ IDEA 2022进行Java部分代码的编写，通过HBuilder进行html部分代码的编写，前端使用layui框架，通过jQuery实现前后端交互，后端主要使用Spring-boot+MyBatis-Plus实现系统与数据库的交互

## 数据库

数据库部分通过Mysql+DataGrip实现可视化便捷管理

## 配置参数

### 前端部分

前端使用layui框架的css样式，存储在项目的src/main/resources/static/layui/css中，部分内容如下

![image-20230218111821625](C:\Users\zy\AppData\Roaming\Typora\typora-user-images\image-20230218111821625.png)

主要作用为实现前端菜单等内容以及美化前端网页

### 后端部分

#### 依赖配置

项目通过maven配置依赖，存储在项目的pom.xml中

![image-20230218112026534](C:\Users\zy\AppData\Roaming\Typora\typora-user-images\image-20230218112026534.png)

#### 数据库及mybatis配置

后端与数据库的链接写在application.yml中，存放在resources目录下

```java
server:
  port: 8086
  context-path: /demo

spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/staff?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=UTC
    username: root
    password: 6579896965
  thymeleaf:
    prefix: classpath:/templates/
    suffix: .html
  mvc:
    servlet:
      load-on-startup: 1
mybatis-plus:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
```

#### 项目config配置

在项目目录下新建目录config用于存放各类配置，包括跨域问题的配置以及MyBatis-Plus配置

跨域问题配置：CrossConfig.java

```Java
package com.software.personalmanagement.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrossConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowCredentials(true)
                .allowedMethods("GET","POST","DELETE","PUT","PATCH")
                .maxAge(3600);
    }
}
```

MyBatis-Plus配置：MyBatisPlusConfig.java

```Java
package com.software.personalmanagement.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisPlusConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}
```

#### 项目结构

config层存放配置文件

controller层存放控制器文件

entity层存放实体类文件，即后端数据库中存放的实体类

mapper层存放数据库交互文件

service层存放业务逻辑文件，其中包括impl：对service层逻辑的实现文件

vo层存放可视性实体类文件，即在前端具体显示的实体类

静态资源中static部分存放前端html配置格式以及一些图片

templates存放前端的各个网页

![image-20230218112721027](C:\Users\zy\AppData\Roaming\Typora\typora-user-images\image-20230218112721027.png)

## 界面展示

登录界面

![image-20230218114037555](C:\Users\zy\AppData\Roaming\Typora\typora-user-images\image-20230218114037555.png)



主界面

![image-20230218114049452](C:\Users\zy\AppData\Roaming\Typora\typora-user-images\image-20230218114049452.png)



查看员工信息界面

![image-20230218114058255](C:\Users\zy\AppData\Roaming\Typora\typora-user-images\image-20230218114058255.png)



新增员工界面

![image-20230218114106586](C:\Users\zy\AppData\Roaming\Typora\typora-user-images\image-20230218114106586.png)



考勤打卡界面

![image-20230218114200273](C:\Users\zy\AppData\Roaming\Typora\typora-user-images\image-20230218114200273.png)