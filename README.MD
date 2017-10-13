# HR - 医院人事系统

### 开发环境

    OS + IDEA + MySQL + Gradle

### 框架

    Spring + SpringMVC + MyBatis

    MyBatis-Plugins 插件 高效、简洁的 CRUD 操作

    Drurid 数据库缓存

### 推荐插件 MyBatis-Plugins
    
  [baomidou GitHub 链接](https://github.com/baomidou/mybatis-plus)


  [中文 API 文档](http://baomidou.oschina.io/mybatis-plus-doc/#/)

### 注:


    SQL 语法错误.
    
    Caused by: com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: You have an error in your SQL syntax; 
    check the manual that corresponds to your MySQL server version for the right syntax to use near ****
    
    
    原因排查:
    1. xml 文件是否错误
    2. serviceImpl 调用 new EntityWrapper() 是否错误
    3. sql 文件是否错误
    
    
    如果以上问题都不存在, 恭喜你使用了 MySql 保留字 [捂脸]
    
 
