package com.innter.pos.securityInnter.DTOs;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.innter.pos.securityInnter.entities.RolEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    @JsonProperty("user_id")
    private Long id;

    @JsonProperty("enabled")
    private short enabled;

    @JsonProperty("password")
    private String password;

    @JsonProperty("username")
    private String username;

    @JsonProperty("name")
    private String name;

    @JsonProperty("last_name")
    private String lastName;


    @JsonProperty("email")
    private String email;


    @JsonProperty("rols")
    private List<RolEntity> rols;
}
