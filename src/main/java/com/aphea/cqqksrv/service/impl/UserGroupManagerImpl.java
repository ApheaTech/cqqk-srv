package com.aphea.cqqksrv.service.impl;

import org.activiti.api.runtime.shared.identity.UserGroupManager;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author 航
 * @date 2022/7/31 20:00
 */
@Service
@Primary
public class UserGroupManagerImpl implements UserGroupManager {

    @Override
    public List<String> getUserGroups(String s) {
        return null;
    }

    @Override
    public List<String> getUserRoles(String s) {
        return null;
    }

    @Override
    public List<String> getGroups() {
        return null;
    }

    @Override
    public List<String> getUsers() {
        return null;
    }
}