## SpringCloud集成Nacos和Sentinel
### 版本
* jdk 1.80_231
* Spring Boot 2.1.9.RELEASE
* Spring Cloud Greenwich.SR5
* Mysql 5.6

### 模块
* spring-cloud-nacos-consumer 集成Nacos，服务消费者
* spring-cloud-nacos-provider 集成Nacos，服务提供者

###
`sh /Applications/nacos/bin/startup.sh -m standalone`

http://localhost:8848/nacos
- nacos
- nacos

http://localhost:8661/helloNacos?name=joham

http://localhost:8662/test1?name=joham

`java -Dserver.port=8080 -Dcsp.sentinel.dashboard.server=localhost:8080 -Dproject.name=sentinel-dashboard -jar /Applications/sentinel-dashboard-1.8.0.jar`

http://localhost:8080
sentinel
sentinel

http://localhost:8661/test/sentinel?name=joham