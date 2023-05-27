package com.taf.business.api;

import com.codeborne.selenide.Configuration;
import com.taf.core.ConfigManager;
import com.taf.core.models.User;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class ApiClient {

    private String bearerSsoToken;
    @Setter
    private Runnable afterRequestCallBack;

    private String retrieveBearerSsoToken() {
        final User user = ConfigManager.getConfig().getUser();
        final User admin = ConfigManager.getConfig().getAdmin();
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

    public void prepareAuthHeader() {
        this.bearerSsoToken = retrieveBearerSsoToken();
    }

    public ValidatableResponse sendRequest(Request request, Map<String, String> variables) {
        ValidatableResponse response = prepareRequestSpecification(request, variables)
                .auth().oauth2(bearerSsoToken)
                .when()
                .request(request.getMethod(), request.getRequestUri())
                .then()
                .log().all();
        applyAfterRequestCallback();
        return response;
    }

    private void applyAfterRequestCallback() {
        if (Objects.nonNull(afterRequestCallBack)) {
            afterRequestCallBack.run();
        }
    }

    private RequestSpecification getRequestSpec() {
        return given()
                .baseUri(Configuration.baseUrl)
                .contentType(ContentType.JSON);
    }

    private RequestSpecification prepareRequestSpecification(final Request request, Map<String, String> variables) {
        RequestSpecification requestSpec = getRequestSpec();
        addPathParams(requestSpec, request.getRequestUri(), variables);
        addBodyIfNeeded(requestSpec, request.getBody());
        return requestSpec;
    }

    private void addPathParams(final RequestSpecification reqSpec,
                               final String requestUri, Map<String, String> variables) {
        variables.keySet().forEach(key -> {
            String pathParam = "{%s}".formatted(key);
            if (requestUri.contains(pathParam)) {
                reqSpec.pathParam(key, variables.get(key));
            }
        });
    }

    private void addBodyIfNeeded(final RequestSpecification reqSpec, final String body) {
        if (StringUtils.isNotEmpty(body)) {
            reqSpec.body(body);
        }
    }
}
