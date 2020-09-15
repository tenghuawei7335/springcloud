package config;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
//自定义Feign配置
@Configuration
public class FeignCustom {
    @Bean
    public Contract  feignContract(){
        return new feign.Contract.Default();//使用的是springMVC的契约
    }
}
