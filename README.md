## SpringCloud集成Nacos和Sentinel和seata
### 版本
* jdk 1.80_271
* Spring Boot 2.2.4.RELEASE
* Spring Cloud Hoxton.SR1
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

`sh /Applications/seata/bin/seata-server.sh -p 8091`

http://localhost:8662/test2?userId=1001&money=100

http://localhost:8662/create?userId=1001&commodityCode=1&count=1

http://localhost:8662/create?userId=1111&commodityCode=1&count=1