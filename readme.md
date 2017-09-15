# ZEN-SCAFFOLD

## 概述
ZEN-SCAFFOLD - 一个基于Spring Boot的微服务脚手架

## 特性
- 使用SpringBoot系列框架
- Maven构建，微服务各自独立，使用聚合而非继承
- Git版本控制，遵循集团开发流程
- 使用Spring MVC提供REST服务
- 持久层框架使用Spring Data JPA/JDBC
- 数据源默认使用HikariCP
- 使用SpringFox生成API文档
- 提供Swagger-UI可测试API界面
- 提供独立的HTML静态文档生成模块
- logback分别打印-info与-error双日志
- ExceptionHandler统一异常处理
- Hystrix服务融断及降级
- 选用较繁琐的filter方式处理controller日志，可打印response内容
- Feign声明式REST调用
- Service层仅做单元测试（mokito）
- Controller层仅做集成测试(testRestTemplate)
- Lombok简化domain层开发
- 业务无关代码抽离成common模块，多个微服务共享
- 允许不同微服务间的少量业务代码冗余，目的是降低耦合
- 引入DTO层，应对前端及服务间调用
- 使用ModelMapper简化模型属性映射
- 使用PostMan+NewMan做REST接口回归测试
- 同时支持Oracle(开发/测试/生产)，MySQL(本地)，以及H2(内嵌)
- 集成测试使用H2内存库，以避免数据问题造成的不稳定
- 提供简易Thymeleaf起始页，链接至Hystrix-Dashboard、H2-Console等
- 集成spring-boot-devtools，提高本机WEB调试时的应用重加载速度

## 项目依赖
- [spring-boot-starter-web](https://spring.io) - MVC集成
- [spring-boot-starter-test](https://spring.io) - 单元测试
- [spring-boot-starter-actuator](https://spring.io) - 应用监控
- [spring-boot-configuration-processor](https://spring.io) - 注解配置
- [spring-cloud-starter-hystrix](https://spring.io) - Hystrix集成
- [spring-boot-starter-jdbc](https://spring.io) - JdbcTemplate集成
- [SpringFox](http://springfox.github.io/springfox) - API文档生成

## 开发环境
- [Maven](https://maven.apache.org) - 项目构建工具
- [Nexus](http://www.sonatype.org/nexus) - Maven私服
- [Git](https://git-scm.com) - 分布式版本控制系统
- [IntelliJ IDEA](https://www.jetbrains.com/idea) - 可选，推荐的IDE

## DevOps
- [Gitlab](https://gitlab.com) - 版本库
- [Jenkins](https://jenkins.io) - 持续集成
- [SonarQube](https://www.sonarqube.org) - 代码质量管理
- [Jacoco](http://www.eclemma.org/jacoco) - 单元测试覆盖率检测
- [Docker](https://www.docker.com) - 应用容器
- [Marathon](https://mesosphere.github.io/marathon) - Docker集群管理
- [Swagger](http://swagger.io) - 服务契约
- [Hystrix](https://github.com/Netflix/Hystrix) - 服务熔断及降级
- [Kong](https://getkong.org) - 服务API管理
- [ELK](https://www.elastic.co/products) - 业务日志
- [Pinpoint](https://github.com/naver/pinpoint) - 调用链日志
