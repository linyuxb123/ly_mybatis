package xyz.linyuxb.test;

import xyz.linyuxb.mapper.UserMapper;
import xyz.linyuxb.pojo.User;
import xyz.linyuxb.sql.SqlSession;

/**
 * @Desc:
 * @Author: linyuxb
 * @Date: 2020/1/5 下午4:04
 */
public class AopTest {
    public static void main(String[] args) {
        // 使用动态代理技术虚拟查询
        UserMapper userMapper = SqlSession.getMapper(UserMapper.class);
        User selectUser = userMapper.selectUser("lisi", 13);
        System.out.println(
                "结果{userName" + selectUser.getUserName() +
                        ";age" + selectUser.getUserAge() +
                        ";id:" + selectUser.getId() +
                        "}");
//        // 使用动态代理技术虚拟新增
//        int count = userMapper.insertUser("mengqi", 22);
//        System.out.println("成功新增:" + count + "条记录");
    }
}
