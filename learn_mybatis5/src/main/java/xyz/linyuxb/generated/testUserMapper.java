package xyz.linyuxb.generated;

import xyz.linyuxb.generated.testUser;

public interface testUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(testUser record);

    int insertSelective(testUser record);

    testUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(testUser record);

    int updateByPrimaryKey(testUser record);
}