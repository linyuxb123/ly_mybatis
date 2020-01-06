package xyz.linyuxb.service;

/**
 * @Desc:
 * @Author: linyuxb
 * @Date: 2020/1/5 下午2:34
 */
public interface SqlSession {
    /**
     * save操作
     * @param sql
     * @return
     * @throws Exception
     */
    int save(String sql)throws Exception;
}
