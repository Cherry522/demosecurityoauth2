# 用户子系统说明
本项目主要用于对auth项目提供用户相关的认证，权限支持。

## 项目说明
本项目主要提供两个方法：
* 根据用户名获取用户对象
    /user/{username}
* 根据用户名获取权限列表：
    /permission/{username}
    

## 项目启动
* 创建数据库
`docker run --rm --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_DATABASE=demo_security_user -d mysql:5.7 --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci --max_connections=500 --max_allowed_packet=5M`
* 运行测试类生成用户测试数据
运行UserJpaTest.class里的addUser测试方法，生成测试数据。
生成的密码是通过SpringSecurity里的PasswordEncoder加密的。
* 运行项目

