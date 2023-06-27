package com.innter.pos.securityInnter.DTOs;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.ToString;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RolResponse {

    @JsonProperty("rol_id")
    private Long id;

    @JsonProperty("name")
    private String name;
}
