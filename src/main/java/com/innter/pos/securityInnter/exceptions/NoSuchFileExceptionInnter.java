package com.innter.pos.securityInnter.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class NoSuchFileExceptionInnter extends NotFoundInnter{
    private String code;
    private HttpStatus status;

    public NoSuchFileExceptionInnter(String code, HttpStatus status, String message) {

        super(code, status, message);
        this.code = code;
        this.status = status;
    }
}
