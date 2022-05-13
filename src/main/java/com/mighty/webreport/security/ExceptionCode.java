package com.mighty.webreport.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionCode {
    WRONG_PASSWORD("000","wrongPassword"),
    WRONG_TYPE_TOKEN("001","wrongTypeToken"),
    EXPIRED_TOKEN("002","expiredToken"),
    UNSUPPORTED_TOKEN("003","unsupportedToken"),
    WRONG_TOKEN("004","wrongToken"),
    ACCESS_DENIED("005","accessDenied"),
    UNKNOWN_ERROR("010","unknownError");

    private String code;

    private String message;

}
