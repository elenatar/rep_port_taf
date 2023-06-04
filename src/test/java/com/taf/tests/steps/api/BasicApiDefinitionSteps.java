package com.taf.tests.steps.api;

import com.taf.business.api.ApiTestContext;
import com.taf.business.api.ApiTestContextManager;

abstract class BasicApiDefinitionSteps {

    protected ApiTestContext context = ApiTestContextManager.getInstance().getContext();
}