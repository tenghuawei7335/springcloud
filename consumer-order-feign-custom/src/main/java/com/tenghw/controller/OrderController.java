package com.tenghw.controller;

import com.tenghw.dao.IFeign;
import com.tenghw.dao.IFeignOne;
import com.tenghw.pojo1.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PROJECT_NAME: springcloud1
 * @PACKAGE_NAME: com.tenghw.controller
 * @ClassName: OrderController
 * @User: ZARD
 * @Author:tenghw
 * @Description:
 * @CreateDate:2020/9/12 0012 12:30
 * @Day: 星期六
 */
@Slf4j
@RestController
public class OrderController {
   @Autowired
   private IFeign iFeign;
   @Autowired
   private IFeignOne iFeignOne;

    @GetMapping(value = "/order/{id}")
    public User getOrder(@PathVariable Long id){
        User user = iFeign.getOrder(id);
        return user;
    }

    @GetMapping(value = "/order/get-user")
    public User getOrderUser(User user){
        User user1 = iFeign.getOrderUser1(user);
        return user1;
    }


    @GetMapping(value = "/{servicename}")
    public String  getServiceInfo(@PathVariable("servicename") String servicename){
        log.debug("============开启FeignCustom1日志-servicename===========");
        log.info("============开启FeignCustom1日志-servicename===========");
        String serviceInfo = iFeignOne.getServiceInfo(servicename);
        return serviceInfo;
    }

}
