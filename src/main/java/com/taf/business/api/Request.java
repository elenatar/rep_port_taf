package com.taf.business.api;

import io.restassured.http.Method;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public class Request {

    private String requestUri;
    private Method method;
    private Map<String, ?> queryParams;
    private String body;

    public void clean() {
        requestUri = null;
        method = null;
        queryParams = null;
        body = null;
    }
}
