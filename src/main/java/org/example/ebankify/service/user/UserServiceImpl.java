package org.example.ebankify.service.user;

import org.example.ebankify.entity.User;
import org.example.ebankify.exception.DeleteUpdateException;
import org.example.ebankify.exception.NotFoundException;
import org.example.ebankify.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with id " + id));
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new DeleteUpdateException("User with id not " + id + " deleted cause not found  " );
        }
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public User updateUser(User user) {

        if (!userRepository.existsById(user.getId())) {
            throw new DeleteUpdateException("User with id not " + user.getId() + " updated cause not found  " );
        }
        return userRepository.save(user);
    }
}
