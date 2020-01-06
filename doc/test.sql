-- learn_mybatis1-2
DROP TABLE IF EXISTS test_user;
CREATE TABLE test_user (
                       id bigint NOT NULL AUTO_INCREMENT,
                       user_name varchar(32) DEFAULT NULL,
                       user_age varchar(32) DEFAULT NULL,
                       PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO test_user ( user_name, user_age) VALUES ( 'zhangsan', 15);
INSERT INTO test_user ( user_name, user_age) VALUES ( 'lisi', 13);


-- learn_mybatis3
DROP TABLE IF EXISTS tb_user;
CREATE TABLE tb_user (
                       id char(32) NOT NULL AUTO_INCREMENT,
                       user_name varchar(32) DEFAULT NULL,
                       password varchar(32) DEFAULT NULL,
                       name varchar(32) DEFAULT NULL,
                       age int(10) DEFAULT NULL,
                       sex int(2) DEFAULT NULL,
                       birthday date DEFAULT NULL,
                       created datetime DEFAULT NULL,
                       updated datetime DEFAULT NULL,
                       PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tb_user ( user_name, password, name, age, sex, birthday, created, updated) VALUES ( 'zpc', '123456', '鹏程', '22', '1', '1990-09-02', sysdate(), sysdate());
INSERT INTO tb_user ( user_name, password, name, age, sex, birthday, created, updated) VALUES ( 'hj', '123456', '静静', '22', '1', '1993-09-05', sysdate(), sysdate());


DROP TABLE IF EXISTS tb_order;
CREATE TABLE tb_order (
                        id int(11) NOT NULL AUTO_INCREMENT,
                        user_id int(11) DEFAULT NULL,
                        order_number varchar(255) DEFAULT NULL,
                        created datetime DEFAULT NULL,
                        updated datetime DEFAULT NULL,
                        PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
INSERT INTO tb_order VALUES ('1', '2', '201807010001', '2018-07-01 19:38:35', '2018-07-01 19:38:40');

DROP TABLE IF EXISTS tb_item;
CREATE TABLE tb_item (
                       id int(11) NOT NULL,
                       itemName varchar(255) DEFAULT NULL,
                       itemPrice decimal(10,2) DEFAULT NULL,
                       itemDetail varchar(255) DEFAULT NULL,
                       PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO tb_item VALUES ('1', '袜子', '29.90', '香香的袜子');
INSERT INTO tb_item VALUES ('2', '套子', '99.99', '冈本001');

DROP TABLE IF EXISTS tb_orderdetail;
CREATE TABLE tb_orderdetail (
                              id int(11) NOT NULL AUTO_INCREMENT,
                              order_id int(11) DEFAULT NULL,
                              total_price decimal(10,0) DEFAULT NULL,
                              item_id int(11) DEFAULT NULL,
                              status int(10) unsigned zerofill DEFAULT NULL COMMENT '0成功非0失败',
                              PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
INSERT INTO tb_orderdetail VALUES ('1', '1', '10000', '1', '0000000001');
INSERT INTO tb_orderdetail VALUES ('2', '1', '2000', '2', '0000000000');
