package com.mao.config.auth;

import com.mao.entity.sys.Client;
import com.mao.service.sys.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Component;

/**
 * spring security 登客户端身份认证
 * @author mao by 11:03 2020/3/19
 */
@Component
public class KyClientDetailService implements ClientDetailsService {

    private SystemService systemService;

    @Autowired
    public void setSystemService(SystemService systemService){
        this.systemService = systemService;
    }

    @Override
    public ClientDetails loadClientByClientId(String client_id) throws ClientRegistrationException {
        Client client = systemService.getClientById(client_id);
        if (null == client) throw new ClientRegistrationException("client not found");
        return client;
    }

}