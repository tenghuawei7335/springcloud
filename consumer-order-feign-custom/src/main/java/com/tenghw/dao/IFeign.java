package com.tenghw.dao;

import com.tenghw.pojo1.User;
import config.FeignCustom;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @PROJECT_NAME: springcloud1
 * @PACKAGE_NAME: com.tenghw.dao
 * @ClassName: IFeign
 * @User: ZARD
 * @Author:tenghw
 * @Description:
 * @CreateDate:2020/9/12 0012 12:24
 * @Day: 星期六
 */
@FeignClient(value = "provider-user",configuration = FeignCustom.class)
public interface IFeign {

       @RequestLine("GET /user/{id}")//这是一个Feign组合注解，第一个是请求方式，空一格，后边的是绑定的提供者上的请求方法
       User getOrder(@Param("id") Long id);

        @RequestLine("GET /user/get-user")
        User getOrderUser1(User user);//不管你Feign客户端配置什么请求方式，它都会以post方式发给提供者provider-user
}
