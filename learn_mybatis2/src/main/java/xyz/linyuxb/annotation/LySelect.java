package xyz.linyuxb.annotation;

import java.lang.annotation.*;

/**
 * @Desc: 查询注解
 * @Author: linyuxb
 * @Date: 2020/1/5 下午3:29
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LySelect {
    String value();
}
