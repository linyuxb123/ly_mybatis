package xyz.linyuxb.test;

import xyz.linyuxb.util.JDBCUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @Desc:
 * @Author: linyuxb
 * @Date: 2020/1/5 下午3:49
 */
public class JdbcTest {
    public static void main(String[] args) throws SQLException {
        // 查询语句
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add("lisi");
        arrayList.add(13);
        ResultSet res = JDBCUtils.query("select * from test_user where user_name=? and user_age=? ", arrayList);
        while (res.next()) {
            int id = res.getInt("id");
            String userName = res.getString("user_name");
            int userAge = res.getInt("user_age");
            System.out.println("查询结果{id:" + id + ";userName:" + userName+";userAge:"+userAge+"}");
        }
    }
}
