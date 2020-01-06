package xyz.linyuxb.test;

import xyz.linyuxb.service.BaseService;
import xyz.linyuxb.service.impl.Dog;
import xyz.linyuxb.service.impl.Person;
import xyz.linyuxb.util.ProxyFactory;

/**
 * @Desc:
 * @Author: linyuxb
 * @Date: 2020/1/5 下午2:31
 */
public class TestMain {
    public static void main(String[] args) throws Exception {

        BaseService dog= ProxyFactory.Builder(Dog.class);
        //专门负责监控mike的代理对象
        dog.eat();

        BaseService mike= ProxyFactory.Builder(Person.class);
        mike.eat();

    }
}
