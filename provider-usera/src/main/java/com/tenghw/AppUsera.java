package com.tenghw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @PROJECT_NAME: springcloud1
 * @PACKAGE_NAME: com.tenghw.pojo1
 * @ClassName: AppUsera
 * @User: ZARD
 * @Author:tenghw
 * @Description:
 * @CreateDate:2020/9/8 0008 14:44
 * @Day: 星期二
 */
/**
 * @EnableDiscoveryClient和@EnableEurekaClient共同点就是：都是能够让注册中心能够发现自己，扫描到自己。
 *如果选用的注册中心是eureka，那么就推荐@EnableEurekaClient，使用场景较为单一。如果是其他的注册中心，
 * 那么推荐使用@EnableDiscoveryClient。
 */
@SpringBootApplication
@EnableEurekaClient/**标记其是一个EurekaClient*/
public class AppUsera
{
    public static void main(String[] args) {
        SpringApplication.run(AppUsera.class, args);
    }
}
