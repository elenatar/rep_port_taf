@api
Feature: Post dashboards
  As an user I want to have the possibility to delete dashboards for specified project

  Background: User saves test data variables
    Given User saves the following variables
      | projectName | rptestuser_personal |

  @positive
  Scenario: User can delete created dashboard
    Given User prepares request body dashboardBody with the following parameters
      | dashboardName        | SOME DASHBOARD 3   |
      | dashboardDescription | SOME DESCRIPTION 3 |
    When User sends POST request to api/v1/{projectName}/dashboard
    Then System returns 201 response status code
    And Response body contains dashboard id
    When User sends DELETE request to api/v1/{projectName}/dashboard/{dashboardId}
    Then System returns 200 response status code

  @negative
  Scenario: User should not be able to delete not existing dashboard
    Given User set dashboard id -1
    When User sends DELETE request to api/v1/{projectName}/dashboard/{dashboardId}
    Then System returns 404 response status code