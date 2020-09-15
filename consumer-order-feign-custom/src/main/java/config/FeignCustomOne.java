package config;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sun.rmi.runtime.Log;

/**
 * @PROJECT_NAME: springcloud1
 * @PACKAGE_NAME: config
 * @ClassName: FeignCustom
 * @User: ZARD
 * @Author:tenghw
 * @Description:
 * @CreateDate:2020/9/13 0013 11:46
 * @Day: 星期日
 */
//@Slf4j
@Configuration
public class FeignCustomOne {
    /**
     * 自定义Feign配置,创建url配置请求方式下的用户名和密码的对象
     */
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("ZARD", "123456");
    }
    /** 
    * 配置日志的输出内容
    */
    @Bean
    Logger.Level feignLoggerLevel(){
        /* NONE, 不记录日志 (默认)。
        BASIC, 只记录请求方法和URL以及响应状态代码和执行时间。
        HEADERS, 记录请求和应答的头的基本信息。
        FULL, 记录请求和响应的头信息，正文和元数据。*/
       //log.debug("============开启FeignCustom1日志===========");
        return Logger.Level.FULL;
    }

}
