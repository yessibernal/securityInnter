package com.innter.pos.securityInnter.mappers;

import com.innter.pos.securityInnter.DTOs.UserRequest;
import com.innter.pos.securityInnter.DTOs.UserResponse;
import com.innter.pos.securityInnter.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface IUserMapper {
    UserResponse userToUserResponse(UserEntity user);

    UserEntity userRequestToUser(UserRequest usersRequest);
}
