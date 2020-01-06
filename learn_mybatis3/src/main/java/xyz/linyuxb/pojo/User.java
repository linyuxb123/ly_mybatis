package xyz.linyuxb.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author linyuxb
 * @desc
 * @create 2020-01-03 11:20
 */
@Getter
@Setter
@ToString
public class User implements Serializable {
    private static final long serialVersionUID = -7770673162126255319L;
    private Integer id;
    private String userName;
    private String password;
    private String name;
    private Integer age;
    private Integer sex;
    private Date birthday;
    private String created;
    private String updated;
}
