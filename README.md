# Keep Younger 
# DEMO for OAuth2 SSO project

---

# Module:
* keep-younger-zone
    > eureka registry center  
       eureka 注册中心
    
* keep-younger-server
    > sso server  
      oauth2 单点登陆
    
* keep-younger-client
    > customer  
      客户端 消费者

* keep-younger-service-one
    > service api server  
      api服务 与 keep-younger-service-two 是同一项目
    
* keep-younger-service-two
    > service api server  
      api服务 与 keep-younger-service-one 是同一项目
    
* keep-younger-ribbon
    > ribbon  
      负载均衡 api服务的转接  
      ribbon的转接服务也可直接嵌入到 keep-younger-client 中  
      单独立项目可为多个api服务转接