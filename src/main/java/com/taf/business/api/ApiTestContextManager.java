package com.taf.business.api;

import io.restassured.response.ValidatableResponse;

import java.util.HashMap;
import java.util.Map;

public class ApiTestContextManager {

    public static final String REQUEST_BODY = "requestBody";
    public static final String DASHBOARD_ID = "dashboardId";
    public static final String RESPONSE = "response";

    private static ApiTestContextManager instance;

    private final ThreadLocal<Map<String, Object>> contextContainer = ThreadLocal.withInitial(HashMap::new);

    public static ApiTestContextManager getInstance() {
        if (instance == null) {
            instance = new ApiTestContextManager();
        }
        return instance;
    }

    public String getRequestBody() {
        return (String) contextContainer.get().get(REQUEST_BODY);
    }

    public void setRequestBody(String requestBody) {
        contextContainer.get().put(REQUEST_BODY, requestBody);
    }

    public String getDashboardId() {
        return (String) contextContainer.get().get(DASHBOARD_ID);
    }

    public void setDashboardId(String dashboardId) {
        contextContainer.get().put(DASHBOARD_ID, dashboardId);
    }

    public ValidatableResponse getResponse() {
        return (ValidatableResponse) contextContainer.get().get(RESPONSE);
    }

    public void setResponse(ValidatableResponse response) {
        contextContainer.get().put(RESPONSE, response);
    }

    public void clear() {
        contextContainer.remove();
    }
}
