package com.myorg.company.service;

import com.myorg.company.exception.ResourceNotFoundException;
import com.myorg.company.model.User;
import com.myorg.company.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUserById(long uId, User user) {
        Optional<User> u = userRepository.findById(uId);
        if(u.isPresent()){
            User userToUpdate = u.get();
            userToUpdate.setUId(user.getUId());
            userToUpdate.setUName(user.getUName());
            userToUpdate.setUContactNo(user.getUContactNo());
            userToUpdate.setUEmail(user.getUEmail());
            userToUpdate.setURole(user.getURole());
            return userRepository.save(userToUpdate);
        } else {
            throw new ResourceNotFoundException("User not found with id : " + uId);
        }
    }

    @Override
    public User deleteUserById(long uId) {
        Optional<User> u = userRepository.findById(uId);
        if(u.isPresent()){
            userRepository.deleteById(uId);
            return u.get();
        } else {
            throw new ResourceNotFoundException("User not found with id : " + uId);
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long uId) {
        Optional<User> u = userRepository.findById(uId);
        if(u.isPresent()){
            return u.get();
        } else {
            throw new ResourceNotFoundException("User not found with id : " + uId);
        }
    }
}
