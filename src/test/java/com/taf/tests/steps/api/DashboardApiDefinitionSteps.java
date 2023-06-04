package com.taf.tests.steps.api;

import com.taf.core.utils.JsonFileUtil;
import com.taf.core.utils.ResourcesFilePathUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.restassured.response.ValidatableResponse;

import java.util.Map;

public class DashboardApiDefinitionSteps extends BasicApiDefinitionSteps {

    @Given("User gets all dashboards")
    public void userGetsAllDashboards() {
        ValidatableResponse response = context.getApiClient().executeGetRequest();
        context.setResponse(response);
    }

    @Given("User gets dashboards by type {}")
    public void userGetsSharedDashboards(String dashboardType) {
        ValidatableResponse response = context.getApiClient().executeGetRequest(dashboardType);
        context.setResponse(response);
    }

    @Given("User prepares request body {} with the following parameters")
    public void userPreparesRequestBody(String fileName, DataTable replaceParamsDataTable) {
        Map<String, String> replaceParams = replaceParamsDataTable.asMap(String.class, String.class);
        String filePath = ResourcesFilePathUtil.getJsonBodyFilePathByName(fileName);
        String body = JsonFileUtil.loadFileAsString(filePath, replaceParams);
        context.setRequestBody(body);
    }

    @Given("User prepares empty request body")
    public void userPreparesEmptyRequestBody() {
        context.setRequestBody("");
    }

    @Given("User creates new dashboard")
    public void userCreatesNewDashboard() {
        ValidatableResponse response = context.getApiClient().executePostRequest(context.getRequestBody());
        context.setResponse(response);
    }

    @Given("User update existing dashboard")
    public void userUpdateDashboard() {
        ValidatableResponse response = context.getApiClient().executePutRequest(context.getRequestBody(), context.getDashboardId());
        context.setResponse(response);
    }

    @Given("User delete dashboard")
    public void userDeleteDashboard() {
        ValidatableResponse response = context.getApiClient().executeDeleteRequest(context.getDashboardId());
        context.setResponse(response);
    }

    @Given("User set dashboard id {}")
    public void userSetDashboardId(String dashBoardId) {
        context.setDashboardId(dashBoardId);
    }
}
