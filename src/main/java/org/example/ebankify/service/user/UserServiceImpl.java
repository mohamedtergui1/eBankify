package org.example.ebankify.service.user;

import org.example.ebankify.entity.User;
import org.example.ebankify.exception.DeleteUpdateException;
import org.example.ebankify.exception.NotFoundException;
import org.example.ebankify.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {

        if (!userRepository.existsById(id)) {
            throw new DeleteUpdateException("User with id  " + id + " not deleted cause not found");
        }
        userRepository.deleteById(id);

    }

    @Override
    @Transactional
    public User updateUser(User user) {

        Optional<User> userFromDbOptional = userRepository.findById(user.getId());
        if (userFromDbOptional.isEmpty()) {
            throw new NotFoundException("User with id " + user.getId() + " not found for update");
        }

        User userFromDb = userFromDbOptional.get();

        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            user.setPassword(userFromDb.getPassword());
        }

        return userRepository.save(user);
    }


}