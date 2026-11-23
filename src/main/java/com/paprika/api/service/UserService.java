package com.paprika.api.service;

import java.util.List;
import com.paprika.api.domain.Role;
import com.paprika.api.domain.User;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRole (String username, String roleName);
    User getUserByUsername(String username);
    List<User> getUsers();

    User createAdminUser();
}
