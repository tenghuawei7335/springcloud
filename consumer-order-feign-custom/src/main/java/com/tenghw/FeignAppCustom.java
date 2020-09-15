package com.tenghw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @PROJECT_NAME: springcloud1
 * @PACKAGE_NAME: com.tenghw
 * @ClassName: FeignApp
 * @User: ZARD
 * @Author:tenghw
 * @Description:
 * @CreateDate:2020/9/12 0012 12:22
 * @Day: 星期六
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class FeignAppCustom {
    public static void main(String[] args) {
        SpringApplication.run(FeignAppCustom.class, args);
    }
}
