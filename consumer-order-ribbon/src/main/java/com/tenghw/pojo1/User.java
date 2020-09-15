package com.tenghw.pojo1;

import java.util.Date;

/**
 * @PROJECT_NAME: springcloud1
 * @PACKAGE_NAME: com.tenghw.pojo
 * @ClassName: User
 * @User: ZARD
 * @Author:tenghw
 * @Description:
 * @CreateDate:2020/8/27 0027 00:20
 * @Day: 星期四
 */
public class User {
    private Long id;
    private Date date;

    public User(){

    }

    public User(Long id) {
        this.id = id;
        this.date=new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
