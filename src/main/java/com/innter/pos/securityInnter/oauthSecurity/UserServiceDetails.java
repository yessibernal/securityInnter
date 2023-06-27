package com.innter.pos.securityInnter.oauthSecurity;

import com.innter.pos.securityInnter.DAOs.UserDAO;
import com.innter.pos.securityInnter.entities.UserEntity;
import com.innter.pos.securityInnter.exceptions.NotFoundInnter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceDetails  implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userDAO.getByUsername(username);

        if (user == null) {
            throw new NotFoundInnter("P-404", HttpStatus.NOT_FOUND, "El usuario " + username + " no existe en el sistema.");
        }

        List<GrantedAuthority> authorities = user.getRols()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());


        System.out.println("Usuario : " + username + " autenticado.");

        return new User(user.getUsername(), user.getPassword(), true, true,
                true, true, authorities);
    }
}
