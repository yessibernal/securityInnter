package com.innter.pos.securityInnter.services.impl;

import com.innter.pos.securityInnter.DAOs.RolDAO;
import com.innter.pos.securityInnter.DAOs.UserDAO;
import com.innter.pos.securityInnter.DTOs.RolRequest;
import com.innter.pos.securityInnter.DTOs.UserRequest;
import com.innter.pos.securityInnter.DTOs.UserResponse;
import com.innter.pos.securityInnter.entities.RolEntity;
import com.innter.pos.securityInnter.entities.UserEntity;
import com.innter.pos.securityInnter.exceptions.NotFoundInnter;
import com.innter.pos.securityInnter.mappers.UserMapper;
import com.innter.pos.securityInnter.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserService implements IUserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RolDAO rolDAO;

    @Autowired
    private UserMapper userMapper;


    @Override
    @Transactional
    public UserResponse saveUser(UserRequest newUser) {
        try {
            UserEntity user = userMapper.userRequestToUser(newUser);
            List<RolRequest> roles = newUser.getRols();
            for (RolRequest listDto : roles) {
                RolEntity rolEntities = rolDAO.findByRolName(listDto.getName());//Se busca el rol por nombre y como parámetro se pide el nombre.
                //Se inserta el nombre del rol (lista que se recorre) que viene con el newUser.
                if (rolEntities == null) {
                    System.out.println("NO entra");
                } else if (listDto.getName().equals(rolEntities.getName())) {  //Y si el nombre de la lista del usuario viene lleno(porque lo encontró en el @Query del repositorio)
                    user.getRols().add(rolEntities);                           //Se le agrega el rol a la lista en la entidad de usuario.
                }
            }
            userDAO.save(user);
            UserResponse userResponse = userMapper.userToUserResponse(user);
            userResponse.setRols(user.getRols());
            return userResponse;
        } catch (Exception e) {
            throw new NotFoundInnter("P-404", HttpStatus.NOT_FOUND, "El usuario no se pudo crear correctamente.");
        }
    }

    @Override
    @Transactional
    public UserResponse getUserByUsername(String username) {
        try {
            UserEntity user = userDAO.getByUsername(username.toLowerCase());

            UserResponse userR = new UserResponse();
            UserResponse userResponse = userMapper.userToUserResponse(user);
            System.out.println( userResponse);
            userResponse.setRols(user.getRols());
            return userResponse;
        } catch (Exception e) {
            throw new NotFoundInnter("P-404", HttpStatus.NOT_FOUND, "El username que ingresaste no es valido.");
        }
    }

}
