package com.taf.business.services;

import com.taf.business.api.ApiClient;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class DashboardApiService extends ApiClient {

    private static final String DASHBOARD_API_PATH = "api/v1/rptestuser_personal/dashboard";

    public DashboardApiService() {
        super();
        getReqSpec().basePath(DASHBOARD_API_PATH);
    }

    @Override
    public ValidatableResponse executeGetRequest() {
        return given().spec(getReqSpec())
                .when()
                .get()
                .then();
    }

    @Override
    public ValidatableResponse executeGetRequest(String dashboardId) {
        return given().spec(getReqSpec())
                .when()
                .get(dashboardId)
                .then();
    }

    @Override
    public ValidatableResponse executePostRequest(String body) {
        return given().spec(getReqSpec())
                .body(body)
                .when()
                .post()
                .then();
    }

    @Override
    public ValidatableResponse executePutRequest(String body, String dashboardId) {
        return given().spec(getReqSpec())
                .body(body)
                .when()
                .put(dashboardId)
                .then();
    }

    @Override
    public ValidatableResponse executeDeleteRequest(String dashboardId) {
        return given().spec(getReqSpec())
                .when()
                .delete(dashboardId)
                .then();
    }
}
