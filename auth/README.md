# 认证子系统说明
## token的两种存储方式
1.数据库方式存储
2.redis方式存储。
两者选其一就行
### 数据方式存储 
#### 数据库准备
* 从阿里镜像库下载官方镜像
    `docker pull mysql:5.7`
* 在服务器上运行mysql容器
（如果想开机启动可以将`-rm`替换成：`--restart=always`）<br>
`docker run --rm --name mysql  -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_DATABASE=demo_security_auth -d mysql:5.7 --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci --max_connections=500 --max_allowed_packet=5M`<br>
如果想数据外挂，可以添加如下命令：`-v /demo/mysql/data:/var/lib/mysql `
* 执行初始化脚本auth_data.sql

#### redis方式存储：
* 从官网上拉取redis镜像：
`docker pull redis`
* 启动redis,默认redis密码为空
`docker run --rm -d --name redis -p 6379:6379 redis`
* 测试redis是否启动成功，访问已经启动的redis，使用redis-cli工具：
`docker run --rm -it \
 --link redis:redis redis:latest redis-cli \
 -h redis \
 -p 6379 \
 -a ''
 `
 参数解释：
 -h redis服务端主机地址
 -p redis服务端端口号
 -a redis服务端的密码，默认为空
 
## 配置文件说明
application.yml
### 配置redis
```
spring:
  #redis
  redis:
    # Redis服务器地址
    host: localhost
    # Redis数据库索引（默认为0）
    database: 0
    # Redis服务器连接端口
    port: 6379
    # Redis服务器连接密码（默认为空）
    password: ''
    # 连接池最大连接数（使用负值表示没有限制）
    pool.max-active: 8
    # 连接池最大阻塞等待时间（使用负值表示没有限制）
    pool.max-wait: -1
    # 连接池中的最大空闲连接
    pool.max-idle: 8
    # 连接池中的最小空闲连接
    pool.min-idle: 0
    # 连接超时时间（毫秒）
    timeout: 0
```
### 配置SpringSecurity里的资源拦截器放到Oauth2认证服务之后
```
# 将我们的资源拦截的过滤器运行顺序放到第3个执行，也就是在oauth2的认证服务器后面执行
security:
  oauth2:
    resource:
      filter-order: 3
```
 
## 代码说明
### 代码配置说明
* AuthorizationServerConfigurer
    配置OAuth2.0 授权服务机制，需要仔细看看这个类
* MyUserDetailsService
    实现UserDetailsService接口，用来做认证和获取权限的时候调用
* ResourceServerConfig
    资源服务配置，每个资源服务器都需要这个类。
    因为auth子系统也对外提供很多服务，比如获取token等，所以也需要配置这个。
* RestTemplateConfig
    用于调用RESTful接口的时候用，这里主要用于调用user子系统里的获取用户信息和权限信息的时候调用。如果需需要可以不写
* RevokeTokenEndpoint
    在注销的时候调用
* SecurityConfiguration
    SpringSecurity配置
 
### 提供认证用户的接口
```
@RestController
public class UserController {

    @GetMapping("/user")
    public Principal user(Principal user){
        return user;
    }
}
```
   
## 运行
* 启动redis或者mysql
* 启动项目