package xyz.linyuxb.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * @author linyuxb
 * @desc
 * @create 2020-01-03 18:09
 */
@Getter
@Setter
@ToString
public class Order {
    private Integer id;
    private Long userId;
    private String orderNumber;
    private Date created;
    private Date updated;

    private OrderUser user;
    private List<OrderDetail> detailList;
}
