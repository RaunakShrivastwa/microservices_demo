package com.User.service;

import com.User.entity.User;

import java.util.List;

public interface UserService {
//    creating the User
    User saveUSer(User user);

//    getAll User
    List<User> getAllUser();

//    getSingle User
    User getSingleUser(int id);
}
