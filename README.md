# Keep Younger 
# DEMO for Spring Cloud project

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
      
# START
#### start redis first, and start in sequence projects:
#### 先启动redis，再依次启动项目:
* keep-younger-zone
* keep-younger-service-one
* keep-younger-service-two
* keep-younger-ribbon
* keep-younger-server
* keep-younger-client

# TEST
* 浏览器打开：http://127.0.0.1:9000 注册中心
* 浏览器打开：http://127.0.0.1:1000 客户端
* 点击 src 会跳转至登陆服务【admin、admin】
* 登陆成功后跳转至 src，点击按钮进行测试。
