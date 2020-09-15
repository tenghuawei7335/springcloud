package com.tenghw.springcolud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @PROJECT_NAME: springcloud1
 * @PACKAGE_NAME: com.tenghw.springcolud
 * @ClassName: EurekaApp
 * @User: ZARD
 * @Author:tenghw
 * @Description:
 * @CreateDate:2020/9/7 0007 11:39
 * @Day: 星期一
 */
@SpringBootApplication
@EnableEurekaServer/**将当前项目标记为Eureka-Server*/
public class EurekaApp {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApp.class);
    }
}
