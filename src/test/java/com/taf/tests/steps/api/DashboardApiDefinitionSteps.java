package com.taf.tests.steps.api;

import com.taf.business.api.ApiClient;
import com.taf.business.services.DashboardApiService;
import com.taf.core.utils.JsonFileUtil;
import com.taf.core.utils.ResourcesFilePathUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.restassured.response.ValidatableResponse;

import java.util.Map;

public class DashboardApiDefinitionSteps extends BasicApiDefinitionSteps {

    ApiClient apiClient = new DashboardApiService();

    @Given("User gets all dashboards")
    public void userGetsAllDashboards() {
        ValidatableResponse response = apiClient.executeGetRequest();
        context.setResponse(response);
    }

    @Given("User gets dashboards by type {}")
    public void userGetsSharedDashboards(String dashboardType) {
        ValidatableResponse response = apiClient.executeGetRequest(dashboardType);
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
        ValidatableResponse response = apiClient.executePostRequest(context.getRequestBody());
        context.setResponse(response);
    }

    @Given("User update existing dashboard")
    public void userUpdateDashboard() {
        ValidatableResponse response = apiClient.executePutRequest(context.getRequestBody(), context.getDashboardId());
        context.setResponse(response);
    }

    @Given("User delete dashboard")
    public void userDeleteDashboard() {
        ValidatableResponse response = apiClient.executeDeleteRequest(context.getDashboardId());
        context.setResponse(response);
    }

    @Given("User set dashboard id {}")
    public void userSetDashboardId(String dashBoardId) {
        context.setDashboardId(dashBoardId);
    }
}
