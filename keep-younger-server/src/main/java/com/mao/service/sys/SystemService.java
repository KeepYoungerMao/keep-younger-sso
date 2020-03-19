package com.mao.service.sys;

import com.mao.entity.sys.Client;
import com.mao.entity.sys.User;

/**
 * @author mao by 11:31 2020/3/18
 */
public interface SystemService {

    User getUserByName(String name);

    Client getClientById(String id);

}