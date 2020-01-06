package xyz.linyuxb.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author linyuxb
 * @desc
 * @create 2020-01-03 18:31
 */
@Setter
@Getter
@ToString
public class Item {
    private Integer id;
    private String itemName;
    private Float itemPrice;
    private String itemDetail;
}
