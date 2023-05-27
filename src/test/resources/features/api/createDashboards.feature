@api
Feature: Post dashboards
  As an user I want to create dashboards for specified project

  Background: User saves test data variables
    Given User saves the following variables
      | projectName | rptestuser_personal |

  @positive
  Scenario: User creates dashboard for specified project
    Given User prepares request body dashboardBody with the following parameters
      | dashboardName        | SOME DASHBOARD 1   |
      | dashboardDescription | SOME DESCRIPTION 1 |
    When User sends POST request to api/v1/{projectName}/dashboard
    Then System returns 201 response status code
    And Response body contains dashboard id
    When User sends GET request to api/v1/{projectName}/dashboard
    Then System returns 200 response status code
    And Response body contains the following dashboards with descriptions
      | SOME DASHBOARD 1 | SOME DESCRIPTION 1 |
      | DEMO DASHBOARD   | Dashboard for demo |
      | TEST DASHBOARD   | Dashboard for test |
        # Delete created dashboard
    And User sends DELETE request to api/v1/{projectName}/dashboard/{dashboardId}
    And System returns 200 response status code

  @negative
  Scenario: User should not  be able to create dashboard with already existed name
    Given User prepares request body dashboardBody with the following parameters
      | dashboardName        | SOME DASHBOARD 2   |
      | dashboardDescription | SOME DESCRIPTION 2 |
    When User sends POST request to api/v1/{projectName}/dashboard
    Then System returns 201 response status code
    And Response body contains dashboard id
    And User prepares request body dashboardBody with the following parameters
      | dashboardName        | SOME DASHBOARD 2   |
      | dashboardDescription | SOME DESCRIPTION 2 |
    When User sends POST request to api/v1/{projectName}/dashboard
    Then System returns 409 response status code
        # Delete created dashboard
    And User sends DELETE request to api/v1/{projectName}/dashboard/{dashboardId}
    And System returns 200 response status code

  @negative
  Scenario: User should not be able to create dashboard with empty name
    Given User prepares request body dashboardBody with the following parameters
      | dashboardName        | "" |
      | dashboardDescription | "" |
    When User sends POST request to api/v1/{projectName}/dashboard
    Then System returns 400 response status code