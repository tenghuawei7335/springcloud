package com.tenghw.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.tenghw.pojo1.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping(value = "/order/{id}")
    public User testUser(@PathVariable("id") Long id){
        //User user = restTemplate.getForObject(url +id, User.class);消费者获取提供者url静态，写死在yml配置文件中

        //消费者RPC访问提供者,获取数据。url不再是在消费者的application.yml中写死，而是消费者动态获取提供者的url，
        // 适合单机EurekaServer,provider非集群
//        InstanceInfo instanceInfo=eurekaClient.getNextServerFromEureka("PROVIDER-USER", false);
//        String homePageUrl = instanceInfo.getHomePageUrl();//"http://localhost:7900"
//        User user = restTemplate.getForObject(homePageUrl+ "/user/"+id, User.class);
        /**
         * 消费者不再关心提供者url，我只找提供者的服务名 http://PROVIDER-USER即可
         * 如果PROVIDER-USER是一个集群，Ribbon通过负载均衡算法，轮询随机RPC一台提供者
         * http://PROVIDER-USER = http://localhost:7900
         * */
        User user = restTemplate.getForObject("http://PROVIDER-USER" + "/user/"+id, User.class);
        return user;
    }

    /**查找Ribbon通过负载均衡算法，调用的是Provider集群中的哪一个Provider实例。*/
    @GetMapping(value = "/test")
    public void  chooseProviders(){
        ServiceInstance choose = loadBalancerClient.choose("PROVIDER-USER");
        System.out.println("host---"+choose.getHost()+"\nport---"+choose.getPort()+"\nuri---"+
                choose.getUri()+"\nServiceId---"+choose.getServiceId());

        ServiceInstance choose1 = loadBalancerClient.choose("PROVIDER-USER1");
        System.out.println("host---"+choose1.getHost()+"\nport---"+choose1.getPort()+"\nuri---"+
                choose1.getUri()+"\nServiceId---"+choose1.getServiceId());

        System.out.println("=============test  end=========================");
    }




}
