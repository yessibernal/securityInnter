package com.innter.pos.securityInnter.utils;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SuccessResponse {
    @JsonProperty(value = "message")
    private String message;

    @JsonProperty(value = "uuid")
    private String UUID;

    @JsonProperty(value = "code")
    private Integer code;

    @JsonProperty(value = "data")
    private Object data;
}
