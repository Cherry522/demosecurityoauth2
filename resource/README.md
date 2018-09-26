# 资源子系统说明
本项目主要用于测试SpringSe+OAuth2是否生效。是一个资源系统，在我们平时开发中，可能是多个

## 项目说明
本项目主要提供了以下几个资源：
* 测试hello访问，这个页面没有加入认证，所有人都可以访问
    get请求：/hello
* 获取网络列表，拥有"network_list"权限的用户可以访问：
    get请求：/network
* 创建网络，拥有"network_create"权限的用户可以访问：    
    post请求：/network
* 获取网络列表，拥有"vm_list"权限的用户可以访问：
    get请求：/vm
* 创建网络，拥有"vm_create"权限的用户可以访问：  
    post请求：/vm  

## 配置文件说明
application.yml
### 指定认证地址
```
#使用auth-server进行认证授权，在它的配置文件指定用户信息在auth-server的地址即可：
security:
  oauth2:
    resource:
      id: resource-service
      user-info-uri: http://localhost:8080/user
      prefer-token-info: false

```

## 代码说明
### CustomAuthenticationEntryPoint
    用来配置如果没有权限访问接口时我们返回的错误码以及错误内容
### ResourceServerConfiguration
    OAuth2配置
     * 配置资源服务器，控制哪些资源需要验证后可以访问，哪些资源不需要验证就能访问
     
## 项目启动
项目目前后端没有配置数据库，只有Controller，直接启动就可以。

