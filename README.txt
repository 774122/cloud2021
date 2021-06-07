模块简介：
    cloud-api-commons: 所有项目的共有的工具类，已经安装到maven仓库

    cloud-eureka-server-7001
    cloud-eureka-server-7002：Eureka 注册中心，和 7001构成集群

    cloud-provider-payment8001
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


