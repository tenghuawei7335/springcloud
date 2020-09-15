package com.tenghw.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.tenghw.pojo1.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PROJECT_NAME: springcloud1
 * @PACKAGE_NAME: com.tenghw.controller
 * @ClassName: UserController
 * @User: ZARD
 * @Author:tenghw
 * @Description:
 * @CreateDate:2020/8/27 0027 00:22
 * @Day: 星期四
 */
@RestController
public class UserController {

    @Autowired
    private  EurekaClient eurekaClient;

    @GetMapping(value = "/user/{id}")
    public User testUser(@PathVariable("id") Long id){
        return new User(id);
    }
    /**返回提供者地址"http://ZARD:7900/"*/
    @GetMapping(value = "/eurekaInfo")
    public String eurekaInfo(){
        InstanceInfo instanceInfo=eurekaClient.getNextServerFromEureka("PROVIDER-USER", false);
        return instanceInfo.getHomePageUrl();
    }
}
