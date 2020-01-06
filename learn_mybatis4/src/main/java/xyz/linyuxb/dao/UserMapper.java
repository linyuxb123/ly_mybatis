package xyz.linyuxb.dao;

import org.apache.ibatis.annotations.Param;
import xyz.linyuxb.pojo.User;

import java.util.List;

/**
 * @author linyuxb
 * @desc
 * @create 2020-01-03 14:26
 */
public interface UserMapper {
    /**
     * 登录（直接使用注解指定传入参数名称）
     *
     * @param userName
     * @param password
     * @return
     */
    User login(@Param("userName") String userName, @Param("password") String password);

    /**
     * 根据表名查询用户信息（直接使用注解指定传入参数名称）
     *
     * @param tableName
     * @return
     */
    List<User> queryUserByTableName(@Param("tableName") String tableName);

    /**
     * 根据Id查询用户信息
     *
     * @param id
     * @return
     */
    User queryUserById(Integer id);

    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<User> queryUserAll();

    /**
     * 新增用户信息
     *
     * @param user
     */
    void insertUser(User user);

    /**
     * 根据id更新用户信息
     *
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据id删除用户信息
     *
     * @param id
     */
    void deleteUserById(Integer id);

    /**
     * 查询男性用户，如果输入了姓名则按照姓名模糊查找，否则如果输入了年龄则按照年龄查找，否则查找姓名为“鹏程”的用户。
     *
     * @param name
     * @param age
     * @return
     */
    List<User> queryUserListByNameOrAge(@Param("name") String name, @Param("age") Integer age);

    /**
     * 查询男性用户，如果输入了姓名则按照姓名模糊查找，否则如果输入了年龄则按照年龄查找，否则查找姓名为“鹏程”的用户。
     *
     * @param name
     * @param age
     * @return
     */
    List<User> queryUserListByNameAndAge(@Param("name") String name, @Param("age") Integer age);

    /**
     * 按多个Id查询
     *
     * @param ids
     * @return
     */
    List<User> queryUserListByIds(@Param("ids") Integer[] ids);

}
