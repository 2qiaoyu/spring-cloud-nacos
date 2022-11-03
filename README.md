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

## sentinel

`java -Dserver.port=8080 -Dcsp.sentinel.dashboard.server=localhost:8080 -Dproject.name=sentinel-dashboard -jar /Applications/sentinel-dashboard-1.8.0.jar`

http://localhost:8080
sentinel
sentinel

### 本地配置模式

在spring-cloud-nacos-provider里面簇点链路里面设置test/sentinel接口限流1QPS，用浏览器刷新下面的url

http://localhost:8661/test/sentinel?name=joham

### 配置进入nacos

[
    {
        "maxQueueingTimeMs":500,
        "resource":"/test/sentinel",
        "extendMap":{
        },
        "grade":1,
        "clusterConfig":{
            "fallbackToLocalWhenFail":true,
            "extendMap":{
            },
            "flowId":10001,
            "thresholdType":1
        },
        "controlBehavior":0,
        "count":1,
        "limitApp":"default",
        "strategy":0,
        "warmUpPeriodSec":10,
        "clusterMode":true
    }
]

SentinelResource如何没有配置，则返回429状态码

## seata

`sh /Applications/seata/bin/seata-server.sh -p 8091`

http://localhost:8662/test2?userId=1001&money=100

正常模式

http://localhost:8662/create?userId=1001&commodityCode=1&count=1

模拟seata生效场景

http://localhost:8662/create?userId=1111&commodityCode=1&count=1