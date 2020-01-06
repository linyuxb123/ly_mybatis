package xyz.linyuxb.service.impl;

import xyz.linyuxb.service.BaseService;

/**
 * @Desc:
 * @Author: linyuxb
 * @Date: 2020/1/5 下午2:13
 */
public class Person implements BaseService {
    //主要业务，代理模式要求开发人员只关心主要业务
    @Override
    public void eat() {
        System.out.println("去餐厅吃饭");
    }

    @Override
    public void wc() {
        System.out.println("去洗手间小解");
    }
}
