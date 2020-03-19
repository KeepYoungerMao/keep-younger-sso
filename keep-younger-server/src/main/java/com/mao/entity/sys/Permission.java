package com.mao.entity.sys;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author mao by 11:36 2020/3/18
 */
@Getter
@Setter
@ToString
public class Permission implements GrantedAuthority {

    private Long id;
    private String name;
    private String intro;

    @Override
    public String getAuthority() {
        return name;
    }

}