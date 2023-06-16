@api
Feature: Post dashboards
  As an user I want to be able to update existing dashboards for specified project

  @positive
  Scenario: User update dashboard for specified project
    Given User prepares request body dashboardBody with the following parameters
      | dashboardName        | SOME DASHBOARD 4   |
      | dashboardDescription | SOME DESCRIPTION 4 |
    When User creates new dashboard
    Then System returns 201 response status code
    And Response body contains dashboard id
    When User gets all dashboards
    Then System returns 200 response status code
    And Response body contains the following dashboards with descriptions
      | SOME DASHBOARD 4 | SOME DESCRIPTION 4 |
      | DEMO DASHBOARD   | Dashboard for demo |
      | TEST DASHBOARD   | Dashboard for test |
    When User prepares request body dashboardBody with the following parameters
      | dashboardName        | UPDATED DASHBOARD   |
      | dashboardDescription | UPDATED DESCRIPTION |
    And User update existing dashboard
    Then System returns 200 response status code
    When User gets all dashboards
    Then System returns 200 response status code
    And Response body contains the following dashboards with descriptions
      | UPDATED DASHBOARD | UPDATED DESCRIPTION |
      | DEMO DASHBOARD    | Dashboard for demo  |
      | TEST DASHBOARD    | Dashboard for test  |
        # Delete created dashboard
    And User delete dashboard
    And System returns 200 response status code

  @negative
  Scenario: User should not be able to update not existing dashboard
    Given User prepares request body dashboardBody with the following parameters
      | dashboardName        | DASHBOARD   |
      | dashboardDescription | DESCRIPTION |
    And User set dashboard id -1
    When User update existing dashboard
    Then System returns 404 response status code

  @negative
  Scenario: User should not be able to update dashboard without a body in request
    Given User prepares empty request body
    And User set dashboard id -1
    When User update existing dashboard
    Then System returns 400 response status code