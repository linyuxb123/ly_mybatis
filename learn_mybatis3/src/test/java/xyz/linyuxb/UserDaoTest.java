package xyz.linyuxb;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import xyz.linyuxb.dao.UserDao;
import xyz.linyuxb.dao.impl.UserDaoImpl;
import xyz.linyuxb.pojo.User;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author linyuxb
 * @desc
 * @create 2020-01-03 11:33
 */
public class UserDaoTest {
    public static UserDao userDao;
    public static SqlSession sqlSession;

    @BeforeAll
    public static void setUp() throws Exception {
        // mybatis-config.xml
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream is = Resources.getResourceAsStream(resource);
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 获取sqlSession
        sqlSession = sqlSessionFactory.openSession();
        userDao = new UserDaoImpl(sqlSession);
    }

    @Test
    public void test(){
        System.out.println(userDao.queryUserById(1L));
    }

    @Test
    public void queryUserAll() throws Exception {
        List<User> userList = userDao.queryUserAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void insertUser() throws Exception {
        User user = new User();
        user.setAge(16);
        user.setBirthday(new Date("1990/09/02"));
        user.setName("大鹏1");
        user.setPassword("123456");
        user.setSex(1);
        user.setUserName("evan");
        userDao.insertUser(user);
        sqlSession.commit();
    }

    @Test
    public void updateUser() throws Exception {
        User user = new User();
        user.setBirthday(new Date());
        user.setName("鹏程1");
        user.setPassword("654321");
        user.setSex(1);
        user.setUserName("evanjin");
        user.setId(3);
        userDao.updateUser(user);
        sqlSession.commit();
    }

    @Test
    public void deleteUser() throws Exception {
        userDao.deleteUser(1);
        sqlSession.commit();
    }
}
