package com.innter.pos.securityInnter.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorParameterDto {
    private String code;
    private String codeTwo;
    private String message;
    private String messageTwo;
}
