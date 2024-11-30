package com.myorg.company.service;

import com.myorg.company.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User updateUserById(long uId, User user);

    User deleteUserById(long uId);

    List<User> getAllUsers();

    User getUserById(long uId);
}
