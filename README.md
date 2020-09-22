# my-springcloud-test
springcloud练习demo
### SpringCloud demo启动

---

## 测试Eureka整合openfeign调用

启动eureka7001注册中心

启动providefeign8003服务提供者

启动consumerfeign服务消费者

测试

http://localhost:8100/con/feign

http://localhost:8100/con/feign/timeout

## 测试Consul整合RestTemplate+@loadblance调用

命令行consul agent -dev

启动consul服务端	localhost:8500

启动providerconsul8002服务提供者

启动consumerconsul服务消费者

测试http://localhost:8100/con/consul

## 测试Zookeeper整合RestTemplate+@loadblance调用

启动zookeeper服务端

启动provider1服务提供者

启动consumer1服务消费者

测试http://localhost:8100/con/get

## 测试Eureka整合Hystrix，Zipkin

测试服务端降级	使用RestTemplate+@loadbalance方式

启动eureka7001注册中心

启动Zipkin	访问localhost:9411

启动providereureka8002服务提供者

启动consumereureka服务消费者

测试http://localhost:8100/con/hystrix/timeout/1

---

测试客户端降级	使用openfeign方式

启动eureka7001注册中心

启动providerhystrix8001服务提供者

启动consumerfeignhystrix服务消费者

测试http://localhost:8100/con/hystrix/timeout/1

## 测试Eureka整合Turbine监控

启动eureka7001注册中心

启动providerhystrix8001实现对象

启动hystrixdashboardturbine监控

访问监控页面	localhost:8989/hystrix

输入localhost:8989/turbine.stream

测试http://localhost:8001/hystrix/circuitBreaker/-1

## 测试Eureka整合Config，Bus实现通知

启动eureka7001注册中心

启动Rabbitmq	localhost:15672

启动configcenter3344

启动configclient3355

启动configclient3366

测试http://localhost:3355/configinfo

http://localhost:3366/configinfo

http://localhost:3344/master/config-dev.yml

修改gitee值

3344刷新自动更改了

curl -X POST "http://localhost:3344/actuator/bus-refresh"

3355和3366刷新更改成功





