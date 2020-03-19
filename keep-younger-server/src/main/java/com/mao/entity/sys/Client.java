package com.mao.entity.sys;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 客户端数据
 * @author mao by 11:05 2020/3/19
 */
@Getter
@Setter
public class Client implements ClientDetails {

    private String clientId;                            //客户端id
    private String clientSecret;                        //
    private Set<String> resourceIds;                    //
    private boolean secretRequired;                     //
    private boolean scoped;                             //
    private Set<String> scope;                          //
    private Set<String> authorizedGrantTypes;           //
    private Set<String> registeredRedirectUri;          //
    private List<GrantedAuthority> authorities;         //
    private Integer accessTokenValiditySeconds;         //
    private Integer refreshTokenValiditySeconds;        //
    private Map<String, Object> additionalInformation;  //

    @Override
    public boolean isAutoApprove(String s) {
        return true;
    }

}