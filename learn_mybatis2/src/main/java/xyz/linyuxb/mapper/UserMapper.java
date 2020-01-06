package xyz.linyuxb.mapper;

import xyz.linyuxb.annotation.LyInsert;
import xyz.linyuxb.annotation.LyParam;
import xyz.linyuxb.annotation.LySelect;
import xyz.linyuxb.pojo.User;

/**
 * @Desc:
 * @Author: linyuxb
 * @Date: 2020/1/5 下午3:26
 */
public interface UserMapper {
    @LyInsert("insert into test_user(user_name,user_age) values(#{userName},#{userAge})")
    int insertUser(@LyParam("userName") String userName, @LyParam("userAge") Integer userAge);

    @LySelect("select id,user_name userName,user_age userAge from test_user where user_name=#{userName} and user_age=#{userAge}")
    User selectUser(@LyParam("userName") String name, @LyParam("userAge") Integer userAge);
}
