package com.taf.business.api;

import com.taf.business.services.DashboardApiService;
import io.restassured.response.ValidatableResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
public class ApiTestContext {
    ApiClient apiClient = new DashboardApiService();
    @Setter
    String requestBody = null;
    @Setter
    String dashboardId = null;
    @Setter
    ValidatableResponse response;
}