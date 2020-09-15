package com.ribbonCustom;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @PROJECT_NAME: springcloud1
 * @PACKAGE_NAME: com.ribbonCustom
 * @ClassName: TestConfig
 * @User: ZARD
 * @Author:tenghw
 * @Description:
 * @CreateDate:2020/9/9 0009 11:48
 * @Day: 星期三
 */
@Configuration
public class TestConfig {
    @Autowired
    private IClientConfig iClientConfig;
    /**
    * @Description:  创建Ribbon负载均衡自定义算法的方法
    * @Author: tenghw
    * @Date: 2020/9/9 0009
    * @Param:
    * @return:
    */
    @Bean
    public IRule ribbonRule(IClientConfig Config){
    return  new RandomRule();//Ribbon负载均衡返回随机算法
    }



}
