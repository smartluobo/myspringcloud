package com.smart.luobo.hystrixwebsite.config;

import com.netflix.hystrix.*;

import java.net.URL;

public class SmsSendCommand extends HystrixCommand<String> {
    public SmsSendCommand() {
        super(
                //必填项指定命令分组名称主要意义是用于统计,建议使用服务名称
                Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("smsGroup"))
                        //依赖名称（如果是服务调用，这里就写具体的接口名称如果是自定义操作这里就是自己定义名称，默认是command实现类的类名，熔断配置就是根据这个名称）
                    .andCommandKey(HystrixCommandKey.Factory.asKey("smsCommandKey"))
                        //线程池命名，默认是HystrixCommandGroupKey的名称 线程池配置就是根据这个名称进行配置
                    .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("smsThreadPool"))
                        //command熔断相关参数配置
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        //配置隔离方式：默认使用线程池进行隔离还有一种信号量隔离方式
                       // .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE)
                                //超时时间5000ms
                         //   .withExecutionTimeoutInMilliseconds(5000)
                                //信号量的隔离模式下，最大的请求数量，和线程池大小的意义一样
                         //   .withExecutionIsolationSemaphoreMaxConcurrentRequests(2)
                                //熔断时间（熔断开启后，5秒后进入半开启状态，试探是否恢复正常）
                          //  .withCircuitBreakerSleepWindowInMilliseconds(5000)
                )
                        //设置线程池参数
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                        //配置线程池大小
                        .withCoreSize(1)
                        //配置等待队列大小
                        .withMaxQueueSize(1)
                )


        );
    }

    @Override
    public String run() throws Exception {
        System.out.println("*****************************" + Thread.currentThread().getName() + "执行run方法");
        URL url = new URL("http://localhost:9001/sms/query/1");
        byte[] result = new byte[1024];
        url.openStream().read(result);
        String resultStr = new String(result);
        System.out.println("接口返回结果》》" + resultStr);
        return resultStr;
    }

    @Override
    protected String getFallback() {
        System.out.println("=================================服务降级了");
        return "降级";
    }
}
