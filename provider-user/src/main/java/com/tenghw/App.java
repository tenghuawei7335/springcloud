package com.tenghw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @EnableDiscoveryClient和@EnableEurekaClient共同点就是：都是能够让注册中心能够发现自己，扫描到自己。
 *如果选用的注册中心是eureka，那么就推荐@EnableEurekaClient，使用场景较为单一。如果是其他的注册中心，
 * 那么推荐使用@EnableDiscoveryClient。
 */
@SpringBootApplication
@EnableEurekaClient/**标记其是一个EurekaClient*/
public class App
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
