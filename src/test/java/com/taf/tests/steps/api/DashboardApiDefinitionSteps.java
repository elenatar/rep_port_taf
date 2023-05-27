package com.taf.tests.steps.api;

import com.taf.business.api.Request;
import com.taf.core.utils.JsonFileUtil;
import com.taf.core.utils.ResourcesFilePathUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.restassured.http.Method;
import io.restassured.response.ValidatableResponse;

import java.util.Map;

public class DashboardApiDefinitionSteps extends BasicApiDefinitionSteps {

    @Given("User sends {} request to {}")
    public void userSendsRequest(final Method method, final String endpoint) {
        Request request = context.getRequest();
        request.setMethod(method);
        request.setRequestUri(endpoint);
        ValidatableResponse response = context.getApiClient().sendRequest(request, context.getVariables());
        context.setResponse(response);
    }

    @Given("User prepares request body {} with the following parameters")
    public void userPreparesRequestBody(String fileName, DataTable replaceParamsDataTable) {
        Request request = context.getRequest();
        Map<String, String> replaceParams = replaceParamsDataTable.asMap(String.class, String.class);
        String filePath = ResourcesFilePathUtil.getJsonBodyFilePathByName(fileName);
        String body = JsonFileUtil.loadFileAsString(filePath, replaceParams);
        request.setBody(body);
    }

    @Given("User set dashboard id {int}")
    public void userSetDashboardId(int dashBoardId) {
        context.addVariable(DASHBOARD_ID, String.valueOf(dashBoardId));
    }
}
