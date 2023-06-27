package com.innter.pos.securityInnter.exceptions;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorDto {
    private String code;
    private String message;
}
