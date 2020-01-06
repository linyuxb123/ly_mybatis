package xyz.linyuxb.annotation;

import java.lang.annotation.*;

/**
 * @Desc:
 * @Author: linyuxb
 * @Date: 2020/1/5 下午3:28
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface LyParam {
    String value();
}
