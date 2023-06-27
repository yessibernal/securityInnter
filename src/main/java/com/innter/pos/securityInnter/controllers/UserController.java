package com.innter.pos.securityInnter.controllers;

import com.innter.pos.securityInnter.DTOs.UserRequest;
import com.innter.pos.securityInnter.services.IUserService;
import com.innter.pos.securityInnter.utils.ResponseUtils;
import com.innter.pos.securityInnter.utils.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private ResponseUtils responseUtils;

    @Autowired
    private UserDetailsService userDetailsService;


    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUser(@RequestBody UserRequest userRequest) {
        SuccessResponse responseSuccess = responseUtils.successResponseCreate(userService.saveUser(userRequest),
                "El usuario se creo exitosamente.");
        return new ResponseEntity<>(responseSuccess, HttpStatus.OK);

    }


    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserByUsername( @RequestParam String username) {
        SuccessResponse responseSuccess = responseUtils.successResponseOK(userService.getUserByUsername(username),
                "El Username: " + username.toLowerCase() + " se encontro exitosamente.");
        return new ResponseEntity<>(responseSuccess, HttpStatus.FOUND);

    }

    @GetMapping(value = "/token", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getToken( @RequestParam String username) {
        SuccessResponse responseSuccess = responseUtils.successResponseOK(userDetailsService.loadUserByUsername(username),
                "El Username: " + username.toLowerCase() + " se encontro exitosamente.");
        return new ResponseEntity<>(responseSuccess, HttpStatus.FOUND);

    }
}
