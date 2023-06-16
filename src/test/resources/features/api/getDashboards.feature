@api
Feature: Get dashboards
  As an user I want to get all available dashboard resources for specified project

  @positive
  Scenario: User gets all permitted dashboards
    Given User gets all dashboards
    When System returns 200 response status code
    Then Response body contains the following dashboards
      | DEMO DASHBOARD |
      | TEST DASHBOARD |

  @positive
  Scenario: User gets the names of shared dashboards
    Given User gets dashboards by type shared
    When System returns 200 response status code
    Then Response body contains the following dashboards
      | DEMO DASHBOARD |

  @negative
  Scenario: User should not be able to get shared dashboards by wrong dashboard type
    Given User gets dashboards by type all
    Then System returns 400 response status code