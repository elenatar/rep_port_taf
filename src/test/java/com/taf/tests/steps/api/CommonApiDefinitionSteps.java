package com.taf.tests.steps.api;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

import java.util.HashMap;
import java.util.Map;

public class CommonApiDefinitionSteps extends BasicApiDefinitionSteps {
    @Given("User saves the following variables")
    public void userSavesTheFollowingVariables(DataTable dataTable) {
        Map<String, String> unmodifybleDataTableMap = dataTable.asMap(String.class, String.class);
        context.setVariables(new HashMap<>(unmodifybleDataTableMap));
    }
}
