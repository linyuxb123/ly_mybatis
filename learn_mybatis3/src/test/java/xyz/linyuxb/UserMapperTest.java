package xyz.linyuxb;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import xyz.linyuxb.dao.UserMapper;
import xyz.linyuxb.pojo.User;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author linyuxb
 * @desc
 * @create 2020-01-03 14:27
 */
public class UserMapperTest {
    public static SqlSessionFactory sqlSessionFactory;
    public static SqlSession sqlSession;
    public static UserMapper userMapper;

    @BeforeAll
    public static void setUp() throws Exception {
        // mybatis-config.xml
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream is = Resources.getResourceAsStream(resource);
        // 构建SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 获取sqlSession
        // 获取sqlSession
        sqlSession = sqlSessionFactory.openSession(true);
        // 1. 映射文件的命名空间（namespace）必须是mapper接口的全路径
        // 2. 映射文件的statement的id必须和mapper接口的方法名保持一致
        // 3. Statement的resultType必须和mapper接口方法的返回类型一致
        // 4. statement的parameterType必须和mapper接口方法的参数类型一致（不一定）
        userMapper = sqlSession.getMapper(UserMapper.class);

    }

    @Test
    public void testQueryUserByTableName() {
        List<User> userList = userMapper.queryUserByTableName("tb_user");
        for (User user : userList) {
            System.out.println(user);
        }
    }

    /**
     * 测试一级缓存
     */
    @Test
    public void testLogin() {
        System.out.println(userMapper.login("Jinjin", "123456"));
        sqlSession.clearCache();
        System.out.println(userMapper.login("Jinjin", "123456"));
    }

    @Test
    public void testQueryUserById() {
        System.out.println(userMapper.queryUserById(2));
    }

    @Test
    public void testQueryUserAll() {
        List<User> userList = userMapper.queryUserAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setAge(20);
        user.setBirthday(new Date());
        user.setName("大神");
        user.setPassword("123456");
        user.setSex(2);
        user.setUserName("bigGod222");
        userMapper.insertUser(user);
        System.out.println(user.getId());
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setBirthday(new Date());
        user.setName("真傻");
        user.setPassword("123456");
        user.setSex(0);
        user.setUserName("zhensha");
        user.setId(3);
        userMapper.updateUser(user);
    }

    @Test
    public void testDeleteUserById() {
        userMapper.deleteUserById(1);
    }

    @Test
    public void queryUserListByNameOrAge() throws Exception {
        List<User> users = userMapper.queryUserListByNameOrAge("静", 16);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void queryUserListByNameAndAge() throws Exception {
        List<User> users = userMapper.queryUserListByNameAndAge("真", 16);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void queryUserListByIds() throws Exception {
        List<User> users = userMapper.queryUserListByIds(new Integer[]{1, 2});
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试二级缓存
     */
    @Test
    public void testCache() throws Exception{
        System.out.println(userMapper.queryUserById(2));

        sqlSession.close();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);

        System.out.println(userMapper.queryUserById(2));
        Thread.sleep(5000);
        System.out.println(userMapper.queryUserById(2));
    }

    @AfterAll
    public static void end(){
        if(sqlSession!=null){
            sqlSession.close();
        }
    }

}
