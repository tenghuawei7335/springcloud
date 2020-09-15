package com.tenghw.annotations;

import java.lang.annotation.*;

/**
 * @PROJECT_NAME: springcloud1
 * @PACKAGE_NAME: com.tenghw.annotations
 * @ClassName: FilterConfig
 * @User: ZARD
 * @Author:tenghw
 * @Description:
 * @CreateDate:2020/9/11 0011 10:02
 * @Day: 星期五
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FilterConfig {

}
