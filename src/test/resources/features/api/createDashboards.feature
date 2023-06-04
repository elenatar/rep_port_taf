@api
Feature: Create dashboards
  As an user I want to create dashboards for specified project

  @positive
  Scenario: User creates new dashboard
    Given User prepares request body dashboardBody with the following parameters
      | dashboardName        | SOME DASHBOARD 1   |
      | dashboardDescription | SOME DESCRIPTION 1 |
    When User creates new dashboard
    Then System returns 201 response status code
    And Response body contains dashboard id
    When User gets all dashboards
    Then System returns 200 response status code
    And Response body contains the following dashboards with descriptions
      | SOME DASHBOARD 1 | SOME DESCRIPTION 1 |
      | DEMO DASHBOARD   | Dashboard for demo |
      | TEST DASHBOARD   | Dashboard for test |
        # Delete created dashboard
    And User delete dashboard
    And System returns 200 response status code

  @negative
  Scenario: User should not be able to create dashboard with already existed name
    Given User prepares request body dashboardBody with the following parameters
      | dashboardName        | SOME DASHBOARD 2   |
      | dashboardDescription | SOME DESCRIPTION 2 |
    When User creates new dashboard
    Then System returns 201 response status code
    And Response body contains dashboard id
    And User prepares request body dashboardBody with the following parameters
      | dashboardName        | SOME DASHBOARD 2   |
      | dashboardDescription | SOME DESCRIPTION 2 |
    When User creates new dashboard
    Then System returns 409 response status code
        # Delete created dashboard
    And User delete dashboard
    And System returns 200 response status code

  @negative
  Scenario: User should not be able to create dashboard with empty name
    Given User prepares request body dashboardBody with the following parameters
      | dashboardName        | "" |
      | dashboardDescription | "" |
    When User creates new dashboard
    Then System returns 400 response status code