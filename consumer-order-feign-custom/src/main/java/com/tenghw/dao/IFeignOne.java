package com.tenghw.dao;
import config.FeignCustomOne;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
@FeignClient(name="thw",url = "http://localhost:9888",configuration = FeignCustomOne.class)
public interface IFeignOne {
    @RequestMapping(value = "/eureka/apps/{servicename}",method = RequestMethod.GET)
    String getServiceInfo(@PathVariable("servicename")String servicename);

}
