package com.taf.core.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ConfigDTO {
    private String url;
    private String login;
    private String password;
}
