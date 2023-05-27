@api
Feature: Get dashboards
  As an user I want to see all available dashboards for specified project

  Background: User saves test data variables
    Given User saves the following variables
      | projectName | rptestuser_personal |

  @positive
  Scenario: User gets all permitted dashboards
    Given User sends GET request to api/v1/{projectName}/dashboard
    Then System returns 200 response status code
    And Response body contains the following dashboards
      | DEMO DASHBOARD |
      | TEST DASHBOARD |

  @positive
  Scenario: User gets the names of shared dashboards
    Given User sends GET request to api/v1/{projectName}/dashboard/shared
    Then System returns 200 response status code
    And Response body contains the following dashboards
      | DEMO DASHBOARD |

  @negative
  Scenario: User should not be able to get dashboards for not available project
    Given User sends GET request to api/v1/not_available/dashboard
    Then System returns 403 response status code




