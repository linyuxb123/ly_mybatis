package xyz.linyuxb.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author linyuxb
 * @desc
 * @create 2020-01-03 18:22
 */
@Setter
@Getter
@ToString
public class OrderDetail {
    private Integer id;
    private Integer orderId;
    private Double totalPrice;
    private Integer status;
    private Integer itemId;

    private Item item;
}
