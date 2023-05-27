package com.taf.core.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String login;
    private String password;

    public User(@JsonProperty("user.login") String login, @JsonProperty("user.password") String password) {
        this.login = login;
        this.password = password;
    }
}
