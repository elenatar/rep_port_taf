package com.taf.business.api;

import io.restassured.response.ValidatableResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
public class ApiTestContext {
    ApiClient apiClient = new ApiClient();
    Request request = new Request();
    @Setter
    ValidatableResponse response;
    @Setter
    Map<String, String> variables;

    public void addVariable(String name, String value) {
        variables.put(name, value);
    }
}
