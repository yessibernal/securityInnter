package com.innter.pos.securityInnter.mappers;

import com.innter.pos.securityInnter.DTOs.UserRequest;
import com.innter.pos.securityInnter.DTOs.UserResponse;
import com.innter.pos.securityInnter.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements IUserMapper{
    @Override
    public UserResponse userToUserResponse(UserEntity user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setEnabled(user.getEnabled());
        userResponse.setPassword(user.getPassword());
        userResponse.setUsername(user.getUsername());
        userResponse.setName(user.getName());
        userResponse.setLastName(user.getLastName());
        userResponse.setEmail(user.getEmail());
        return userResponse;
    }

    @Override
    public UserEntity userRequestToUser(UserRequest userRequest) {
        UserEntity user = new UserEntity();
        user.setEnabled(userRequest.getEnabled());
        user.setPassword(userRequest.getPassword());
        user.setUsername(userRequest.getUsername());
        user.setName(userRequest.getName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        return user;
    }
}
