package com.taf.tests.hooks;

import com.taf.business.api.ApiClient;
import com.taf.business.api.ApiTestContext;
import com.taf.business.api.ApiTestContextManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ApiCucumberHooks {

    @Before("@api")
    public void prepareTestContext() {
        ApiTestContext context = ApiTestContextManager.getInstance().getContext();
        ApiClient apiClient = context.getApiClient();
        apiClient.setAfterRequestCallBack(() -> context.getRequest().clean());
        apiClient.prepareAuthHeader();
    }

    @After("@api")
    public void clear() {
        ApiTestContextManager.getInstance().clear();
    }
}
