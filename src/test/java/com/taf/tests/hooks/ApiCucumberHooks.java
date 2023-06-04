package com.taf.tests.hooks;

import com.taf.business.api.ApiTestContextManager;
import io.cucumber.java.After;

public class ApiCucumberHooks {

    @After("@api")
    public void clear() {
        ApiTestContextManager.getInstance().clear();
    }
}
