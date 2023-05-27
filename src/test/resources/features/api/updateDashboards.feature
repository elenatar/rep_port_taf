@api
Feature: Post dashboards
  As an user I want to be able to update existing dashboards for specified project

  Background: User saves test data variables
    Given User saves the following variables
      | projectName | rptestuser_personal |

  @positive
  Scenario: User update dashboard for specified project
    Given User prepares request body dashboardBody with the following parameters
      | dashboardName        | SOME DASHBOARD 4   |
      | dashboardDescription | SOME DESCRIPTION 4 |
    When User sends POST request to api/v1/{projectName}/dashboard
    Then System returns 201 response status code
    And Response body contains dashboard id
    When User sends GET request to api/v1/{projectName}/dashboard
    Then System returns 200 response status code
    And Response body contains the following dashboards with descriptions
      | SOME DASHBOARD 4 | SOME DESCRIPTION 4 |
      | DEMO DASHBOARD   | Dashboard for demo |
      | TEST DASHBOARD   | Dashboard for test |
    When User prepares request body dashboardBody with the following parameters
      | dashboardName        | UPDATED DASHBOARD   |
      | dashboardDescription | UPDATED DESCRIPTION |
    And User sends PUT request to api/v1/{projectName}/dashboard/{dashboardId}
    Then System returns 200 response status code
    When User sends GET request to api/v1/{projectName}/dashboard
    Then System returns 200 response status code
    And Response body contains the following dashboards with descriptions
      | UPDATED DASHBOARD | UPDATED DESCRIPTION |
      | DEMO DASHBOARD    | Dashboard for demo  |
      | TEST DASHBOARD    | Dashboard for test  |
        # Delete created dashboard
    And User sends DELETE request to api/v1/{projectName}/dashboard/{dashboardId}
    And System returns 200 response status code

  @negative
  Scenario: User should not be able to update not existing dashboard
    Given User prepares request body dashboardBody with the following parameters
      | dashboardName        | DASHBOARD   |
      | dashboardDescription | DESCRIPTION |
    And User set dashboard id -1
    When User sends PUT request to api/v1/{projectName}/dashboard/{dashboardId}
    Then System returns 404 response status code

  @negative
  Scenario: User should not be able to update dashboard without a body in request
    Given User set dashboard id -1
    When User sends PUT request to api/v1/{projectName}/dashboard/{dashboardId}
    Then System returns 400 response status code