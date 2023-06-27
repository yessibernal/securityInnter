package com.innter.pos.securityInnter.services;

import com.innter.pos.securityInnter.DTOs.UserRequest;
import com.innter.pos.securityInnter.DTOs.UserResponse;

public interface IUserService {
    UserResponse saveUser(UserRequest newUser);
    UserResponse getUserByUsername (String username);
}
