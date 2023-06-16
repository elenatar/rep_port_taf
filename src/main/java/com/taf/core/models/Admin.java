package com.taf.core.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Admin extends User {

    public Admin(@JsonProperty("admin.login") String login, @JsonProperty("admin.password") String password) {
        super(login, password);
    }
}
