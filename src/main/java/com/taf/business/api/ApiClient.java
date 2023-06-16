package com.taf.business.api;

import com.codeborne.selenide.Configuration;
import com.taf.core.UserConfigManager;
import com.taf.core.models.User;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;

import static io.restassured.RestAssured.given;

public abstract class ApiClient {

    @Getter
    private RequestSpecification reqSpec;

    protected ApiClient() {
        this.reqSpec = given()
                .baseUri(Configuration.baseUrl)
                .auth().oauth2(retrieveBearerSsoToken())
                .contentType(ContentType.JSON);
    }

    private String retrieveBearerSsoToken() {
        final User user = UserConfigManager.getUserConfig().getUser();
        final User admin = UserConfigManager.getUserConfig().getAdmin();
        return given()
                .baseUri(Configuration.baseUrl)
                .contentType(ContentType.URLENC)
                .auth().basic(admin.getLogin(), admin.getPassword())
                .formParam("grant_type", "password")
                .formParam("username", user.getLogin())
                .formParam("password", user.getPassword())
                .post("/uat/sso/oauth/token")
                .then()
                .extract()
                .path("access_token");
    }

    public abstract ValidatableResponse executeGetRequest();

    public abstract ValidatableResponse executeGetRequest(String dashboardId);

    public abstract ValidatableResponse executePostRequest(String body);

    public abstract ValidatableResponse executePutRequest(String body, String dashboardId);

    public abstract ValidatableResponse executeDeleteRequest(String dashboardId);
}
