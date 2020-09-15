package com.tenghw.dao;

import com.tenghw.pojo1.User;
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
@FeignClient(value = "provider-user")
public interface IFeign {
   @GetMapping(value = "/user/{id}")
       /**必须添加@PathVariable("id")，"id"不可省*/
       User getOrder(@PathVariable("id") Long id);

    @GetMapping(value = "/user/get-user")
        /**如果消费者发送的不是上面那种简单数据，而是封装的复杂对象，Feign都会以post请求发送出去,
         * 并且默认了application/json格式，自动把消费者的user对象转为了user字符串形式
         * 解决办法：消费者还是getMappring发送方式，提供者那边修改为postMapping
         * */
        User getOrderUser1(User user);
}
