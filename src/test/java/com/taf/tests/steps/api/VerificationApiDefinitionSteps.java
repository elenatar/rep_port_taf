package com.taf.tests.steps.api;

import com.taf.business.models.dto.DashboardDto;
import com.taf.business.models.response.CreateDashboardResponse;
import com.taf.business.models.response.GetDashboardsResponse;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.response.ValidatableResponse;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class VerificationApiDefinitionSteps extends BasicApiDefinitionSteps {

    @Then("System returns {int} response status code")
    public void systemReturnsStatusCode(final int responseCode) {
        final ValidatableResponse response = context.getResponse();
        response.statusCode(responseCode);
    }

    @And("Response body contains the following dashboards")
    public void responseBodyContainsFollowingDashboards(final DataTable dataTable) {
        final List<String> dashboardNames = dataTable.asList();
        final ValidatableResponse response = context.getResponse();
        final List<String> loadedDashboardNames = response.extract()
                .as(GetDashboardsResponse.class)
                .getContent().stream()
                .map(DashboardDto::getName)
                .collect(Collectors.toList());
        assertThat(loadedDashboardNames)
                .as("Dashboards should contain '%s'".formatted(dashboardNames))
                .containsAll(dashboardNames);
    }

    @And("Response body contains dashboard id")
    public void responseBodyContainsDashboardId() {
        final ValidatableResponse response = context.getResponse();
        final CreateDashboardResponse createDashboardResponse = response.extract()
                .as(CreateDashboardResponse.class);
        assertThat(createDashboardResponse.getId())
                .isNotNull();
        context.setDashboardId(String.valueOf(createDashboardResponse.getId()));
    }

    @And("Response body contains the following dashboards with descriptions")
    public void responseBodyContainsDashboardWithDescription(final DataTable dataTable) {
        Map<String, String> dashboardsToCheck = dataTable.asMap(String.class, String.class);
        final ValidatableResponse response = context.getResponse();
        Map<String, DashboardDto> loadedDashboards = response.extract()
                .as(GetDashboardsResponse.class)
                .getContent().stream()
                .collect(Collectors.toMap(DashboardDto::getName, Function.identity()));
        assertThat(loadedDashboards.keySet())
                .as("Dashboards should contain '%s' but contains only '%s'".formatted(
                        dashboardsToCheck.keySet(), loadedDashboards.keySet()))
                .containsAll(dashboardsToCheck.keySet());
        dashboardsToCheck.forEach((key, value) -> {
            DashboardDto loadedDashboard = loadedDashboards.get(key);
            assertThat(loadedDashboard.getDescription())
                    .as("Dashboard '%s' should contain description '%s' but contains '%s'".formatted(
                            loadedDashboard.getName(), value, loadedDashboard.getDescription()))
                    .isEqualTo(value);
        });
    }
}
