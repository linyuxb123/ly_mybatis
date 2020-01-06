package xyz.linyuxb.sql;

import xyz.linyuxb.aop.MyInvocationHandlerMbatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Desc:
 * @Author: linyuxb
 * @Date: 2020/1/5 下午3:38
 */
public class SqlSession {
    // 加载Mapper接口
    public static <T> T getMapper(Class classz) {
        return (T) Proxy.newProxyInstance(
                classz.getClassLoader(),
                new Class[]{classz},
                new MyInvocationHandlerMbatis(classz));
    }

}
