package com.mao.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * 权限认证服务
 * @author mao by 11:43 2020/3/18
 */
@Configuration
@EnableAuthorizationServer
public class KyAuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {

    private KyClientDetailService kyClientDetailService;
    private RedisConnectionFactory redisConnectionFactory;

    @Autowired
    public void setKyClientDetailService(KyClientDetailService kyClientDetailService){
        this.kyClientDetailService = kyClientDetailService;
    }
    @Autowired
    public void setRedisConnectionFactory(RedisConnectionFactory redisConnectionFactory){
        this.redisConnectionFactory = redisConnectionFactory;
    }

    /**
     * 客户端注册
     * @param clients 客户端注册器
     * @throws Exception e
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(kyClientDetailService);
    }

    /**
     * .tokenStore()                            //token生成方式
     * .authenticationManager()                 //授权管理器
     * .allowedTokenEndpointRequestMethods()    //请求方式过滤
     * .reuseRefreshTokens()                    //开启刷新token
     * @param endpoints 授权服务
     * @throws Exception e
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore());

    }

    /**
     * 安全配置
     * @param security 认证服务器安全配置器
     * @throws Exception e
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();
    }


    /**
     * token储存方式
     * 基于jwt实现令牌（Access Token）
     * @return JwtTokenStore
     */
    @Bean
    public TokenStore tokenStore(){
        return new RedisTokenStore(redisConnectionFactory);
    }

    /*@Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey("ky");   //  Sets the JWT signing key
        return jwtAccessTokenConverter;
    }*/

}