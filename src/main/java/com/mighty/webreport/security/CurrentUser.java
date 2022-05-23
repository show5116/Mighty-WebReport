package com.mighty.webreport.security;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.lang.annotation.*;


@Target({ElementType.LOCAL_VARIABLE, ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@AuthenticationPrincipal(expression = "accountContext")
public @interface CurrentUser {

}
