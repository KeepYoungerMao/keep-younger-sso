# Keep Younger 
# DEMO for OAuth2 SSO project

---

# Module:
* keep-younger-zone [ 9000 ]
    > eureka registry center  
       eureka 注册中心
    
* keep-younger-server [ 11000 ]
    > sso server  
      oauth2 单点登陆
    
* keep-younger-client [ 10000 ]
    > customer  
      客户端 消费者

* keep-younger-service-one [ 20001 ]
    > service api server  
      api服务 与 keep-younger-service-two 是同一项目
    
* keep-younger-service-two [ 20002 ]
    > service api server  
      api服务 与 keep-younger-service-one 是同一项目
    
* keep-younger-ribbon [ 20000 ]
    > ribbon  
      负载均衡 api服务的转接  
      ribbon的转接服务也可直接嵌入到 keep-younger-client 中  
      单独立项目可为多个api服务转接