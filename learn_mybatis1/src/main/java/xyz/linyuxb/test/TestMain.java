package xyz.linyuxb.test;

import xyz.linyuxb.service.SqlSession;
import xyz.linyuxb.service.impl.DeptMapper;
import xyz.linyuxb.util.SqlSessionFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc:
 * @Author: linyuxb
 * @Date: 2020/1/5 下午2:47
 */
public class TestMain {
    public static void main(String[] args) throws Exception {

        Map<String,String> statementMapper = new HashMap<>(1);
        statementMapper.put("user.save",
                "        INSERT INTO test_user (\n" +
                "        user_name,\n" +
                "        user_age\n" +
                "        )\n" +
                "        VALUES\n" +
                "        (\n" +
                "        'lao22',\n" +
                "        20\n" +
                "        );");

        SqlSession dao = SqlSessionFactory.Builder(DeptMapper.class);
        int save = dao.save(statementMapper.get("user.save"));
        System.out.println("成功插入"+save);
    }
}
