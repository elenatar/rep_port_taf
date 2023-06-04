@api
Feature: Delete dashboards
  As an user I want to have the possibility to delete dashboards for specified project

  @positive
  Scenario: User can delete created dashboard
    Given User prepares request body dashboardBody with the following parameters
      | dashboardName        | SOME DASHBOARD 3   |
      | dashboardDescription | SOME DESCRIPTION 3 |
    When User creates new dashboard
    Then System returns 201 response status code
    And Response body contains dashboard id
    When User delete dashboard
    Then System returns 200 response status code

  @negative
  Scenario: User should not be able to delete not existing dashboard
    Given User set dashboard id -1
    When User delete dashboard
    Then System returns 404 response status code