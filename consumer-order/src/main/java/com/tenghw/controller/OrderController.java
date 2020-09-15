package com.tenghw.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.tenghw.pojo1.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @PROJECT_NAME: springcloud1
 * @PACKAGE_NAME: com.tenghw.controller
 * @ClassName: OrderController
 * @User: ZARD
 * @Author:tenghw
 * @Description:
 * @CreateDate:2020/8/27 0027 00:41
 * @Day: 星期四
 */
@RestController
public class OrderController {
    /**spring提供的用于访问rest风格接口的模板对象*/
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient eurekaClient;
    @Value("${user.url:null}")
    String url;
    @GetMapping(value = "/order/{id}")
    public User testUser(@PathVariable("id") Long id){
        //User user = restTemplate.getForObject(url +id, User.class);消费者获取提供者url静态，写死在yml配置文件中

        //消费者RPC访问提供者,获取数据。url不再是在消费者的application.yml中写死，而是消费者动态获取提供者的url
        InstanceInfo instanceInfo=eurekaClient.getNextServerFromEureka("PROVIDER-USER", false);
        String homePageUrl = instanceInfo.getHomePageUrl();
        User user = restTemplate.getForObject(homePageUrl + "/user/"+id, User.class);
        return user;
    }
}
