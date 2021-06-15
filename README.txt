模块简介：
    cloud-api-commons: 所有项目的共有的工具类，已经安装到maven仓库

    cloud-eureka-server-7001
    cloud-eureka-server-7002：Eureka 注册中心，和 7001构成集群

    cloud-provider-payment8001:  同8002.另外包含了 Sleuth+zipkin 链路监控
    cloud-provider-payment8002： 服务提供方，含有mybatis持久层操作，8001的controller有一个用于测试Feign超时的方法
    cloud- consumer-order80 : 消费者，有测试Ribbon的其它负载均衡方式，CAX自旋锁重写了轮询方式的负载均衡

    cloud-provider-payment8004 ： 测试基于Zookeeper的服务注册
    cloud-consumerzk-order80 ： 测试基于Zookeeper的服务消费

    cloud-providerconsul-payment8006 ： 测试基于Consul的服务注册
    cloud-consumerconsul-order80 ： 测试基于Consul的服务消费

    cloud-provider-hystrix-payment8001 : 测试基于 hystrix 的服务降级、熔断，服务端，
                        但是看起来和普通的Eureka的中心没啥不同，就是引入了 hystrix的依赖
    cloud-consumer-feign-hystrix-order80 ： 用于测试基于 Feign和 hystrix 的服务降级和熔断
    cloud-consumer-hystrix-dashboard9001 ： hystrix的图形化界面

    cloud-consumer-feign-order80 ： 用于测试 Feign 消费端

    cloud-gateway-gateway9527 : 用于测试 gateway网关

    cloud-config-center-3344 : 分布式配置中心Config，总控中心（windows下修改hosts文件，增加映射，127.0.0.1 config-3344.com）
    cloud-config-client-3355 : 分布式配置中心Config，客户端（实际的微服务）
    cloud-config-client-3366 : 分布式配置中心Config，Bus动态刷新全局广播，动态刷新（发送post请求）

    cloud-stream-rabbitmq-provider8801 ： SpringCloud-Stream 的作为生产者进行发消息模块
    cloud-stream-rabbitmq-provider8802 ： SpringCloud-Stream 的作为消息接收模块
    cloud-stream-rabbitmq-provider8803 ： SpringCloud-Stream 的作为消息接收模块

    cloudalibaba-provider-payment9001/9002: Alibaba的nacos注册中心
    cloudalibaba-consumer-nacos-order83： Alibaba nacos消费者

    cloudalibaba-config-nacos-client3377： nacos配置中心

    cloudalibaba-consumer-nacos-order84 ： sentinel+Ribbon 的服务降级和熔断，兜底等
                                           sentinel+OpenFeign



