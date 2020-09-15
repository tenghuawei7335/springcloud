package com.tenghw;

import com.tenghw.annotations.FilterConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;
import sun.awt.SunHints;

/**
 * Hello world!
 *
 * @author ZARD
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "PROVIDER-USER",configuration = TestConfig.class)/**启用Ribbon,并对PROVIDER-USER进行负载均衡*/
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {FilterConfig.class})})
public class AppOrder{
    @Bean
    @LoadBalanced
    /**@LoadBalanced注解为RestTemplate添加了一个LoadBalancerInterceptor拦截器。
     * 可以将消费者RPC提供者的"http://PROVIDER-USER/USER/1"拦截，解析成"http://localhost:7900/USER/1"
     */
    public RestTemplate getRestTemplate() {
    return new RestTemplate();
    }


    public static void main( String[] args )
    {

        SpringApplication.run(AppOrder.class);
    }
}
