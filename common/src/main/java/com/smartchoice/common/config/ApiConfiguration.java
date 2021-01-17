package com.smartchoice.common.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiConfiguration {
    private String partnerId;
    private String url;
    private String username;
    private String password;
    private String refreshToken;
}
