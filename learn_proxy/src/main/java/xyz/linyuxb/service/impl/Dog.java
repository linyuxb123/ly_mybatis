package xyz.linyuxb.service.impl;

import xyz.linyuxb.service.BaseService;

/**
 * @Desc:
 * @Author: linyuxb
 * @Date: 2020/1/5 下午2:13
 */
public class Dog implements BaseService {
    @Override
    public void eat() {
        System.out.println("在窝里趴着吃");
    }

    @Override
    public void wc() {
        System.out.println("随地大小便");

    }
}
