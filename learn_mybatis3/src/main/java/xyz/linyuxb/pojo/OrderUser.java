package xyz.linyuxb.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author linyuxb
 * @desc
 * @create 2020-01-03 18:11
 */
@Getter
@Setter
@ToString
public class OrderUser  extends Order {
    private String userName;
    private String password;
    private String name;
    private Integer age;
    private Integer sex;
    private Date birthday;
    private Date created;
    private Date updated;
}