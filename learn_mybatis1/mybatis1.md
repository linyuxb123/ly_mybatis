一。JDBC开发步骤

    1.加载驱动
    2.建立连接通道
    3.建立PreparedStament
    4.输送sql命令到数据库中执行，并带回运行结果
    5.销毁链接通道，PreparedStament
    
 二。JDBC主要业务与次要业务分析   
 
    1.加载驱动[次要业务]
    2.建立连接通道[次要业务]
    3.建立PreparedStament[次要业务]
    4.输送sql命令到数据库中执行，并带回运行结果【主要业务】
    5.销毁链接通道，PreparedStament[次要业务]