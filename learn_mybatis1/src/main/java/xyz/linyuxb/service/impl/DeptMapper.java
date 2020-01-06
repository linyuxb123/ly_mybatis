package xyz.linyuxb.service.impl;

import xyz.linyuxb.service.SqlSession;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Desc:
 * @Author: linyuxb
 * @Date: 2020/1/5 下午2:35
 */
public class DeptMapper implements SqlSession {
    PreparedStatement ps;
    /**
     * JDBC主要业务 输送sql
     * @param sql
     * @return
     * @throws SQLException
     */
    @Override
    public int save(String sql) throws SQLException {
        return ps.executeUpdate(sql);
    }
}
