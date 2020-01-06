package xyz.linyuxb;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import xyz.linyuxb.dao.OrderMapper;
import xyz.linyuxb.pojo.Order;

import java.io.InputStream;

/**
 * @author linyuxb
 * @desc
 * @create 2020-01-03 18:14
 */
public class OrderMapperTest {
    public static SqlSessionFactory sqlSessionFactory;
    public static SqlSession sqlSession;
    public static OrderMapper orderMapper;

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
        orderMapper = sqlSession.getMapper(OrderMapper.class);

    }

    @Test
    public void queryOrderUserByOrderNumber() throws Exception {
        Order order = orderMapper.queryOrderUserByOrderNumber("201807010001");
        System.out.println(order);
    }

    @Test
    public void queryOrderWithUserByOrderNumber() throws Exception {
        Order order = orderMapper.queryOrderWithUserByOrderNumber("201807010001");
        System.out.println(order.getUser());
    }

    @Test
    public void queryOrderWithUserAndDetailByOrderNumber() throws Exception {
        Order order = orderMapper.queryOrderWithUserAndDetailByOrderNumber("201807010001");
        System.out.println(order.getUser());
        System.out.println(order.getDetailList());
    }

    @Test
    public void queryOrderWithUserAndDetailItemByOrderNumber() throws Exception {
        Order order = orderMapper.queryOrderWithUserAndDetailItemByOrderNumber("201807010001");
        System.out.println(JSON.toJSONString(order));
//        System.out.println(order);
//        System.out.println(order.getUser());
//        System.out.println(order.getDetailList());
    }

    /**
     * 测试延迟加载
     */
    @Test
    public void testQueryOrderAndUserByOrderNumberLazy() {
        Order order = orderMapper.queryOrderAndUserByOrderNumberLazy("201807010001");
//        System.out.println(JSON.toJSONString(order));
        System.out.println(order.getOrderNumber());
        System.out.println(
                "============="
        );
        System.out.println(order.getUser());
    }

}
