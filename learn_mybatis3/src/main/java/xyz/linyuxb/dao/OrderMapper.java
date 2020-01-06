package xyz.linyuxb.dao;

import org.apache.ibatis.annotations.Param;
import xyz.linyuxb.pojo.Order;

/**
 * @author linyuxb
 * @desc
 * @create 2020-01-03 18:12
 */
public interface OrderMapper {
    Order queryOrderUserByOrderNumber(@Param("number") String number);

    /**
     * 根据订单号查询订单用户的信息
     *
     * @param number
     * @return
     */
    Order queryOrderWithUserByOrderNumber(@Param("number") String number);

    /**
     * 根据订单号查询订单用户的信息及订单详情
     *
     * @param number
     * @return
     */
    Order queryOrderWithUserAndDetailByOrderNumber(@Param("number") String number);

    /**
     * 根据订单号查询订单用户的信息及订单详情及订单详情对应的商品信息
     *
     * @param number
     * @return
     */
    Order queryOrderWithUserAndDetailItemByOrderNumber(@Param("number") String number);

    /**
     * 测试延迟加载
     *
     * @param number
     * @return
     */
    Order queryOrderAndUserByOrderNumberLazy(@Param("number") String number);
}
