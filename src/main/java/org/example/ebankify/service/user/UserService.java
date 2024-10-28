package org.example.ebankify.service.user;

import org.example.ebankify.entity.User;

public interface UserService {
    User getUserById(Long id);
    User saveUser(User user);
    void deleteUser(Long id);
    User updateUser(User user);

}
