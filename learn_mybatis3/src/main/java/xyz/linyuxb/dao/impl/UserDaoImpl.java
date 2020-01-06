package xyz.linyuxb.dao.impl;

import org.apache.ibatis.session.SqlSession;
import xyz.linyuxb.dao.UserDao;
import xyz.linyuxb.pojo.User;

import java.util.List;

/**
 * @author linyuxb
 * @desc
 * @create 2020-01-03 11:19
 */
public class UserDaoImpl implements UserDao {

    public SqlSession sqlSession;

    public UserDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public User queryUserById(Long id) {
        return this.sqlSession.selectOne("UserDao.queryUserById", id);
    }

    @Override
    public List<User> queryUserAll() {
        return this.sqlSession.selectList("UserDao.queryUserAll");
    }

    @Override
    public void insertUser(User user) {
        this.sqlSession.insert("UserDao.insertUser", user);
    }

    @Override
    public void updateUser(User user) {
        this.sqlSession.update("UserDao.updateUser", user);
    }

    @Override
    public void deleteUser(Integer id) {
        this.sqlSession.delete("UserDao.deleteUser", id);
    }
}
