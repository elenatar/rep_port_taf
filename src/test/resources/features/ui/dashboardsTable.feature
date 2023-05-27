@ui
Feature: Dashboards feature
  As an user
  I want to see a dashboards table on Dashboard Page with correct columns and items on it

  Background: User is able to login to Report Portal
    Given User logins to Report Portal

  Scenario: User is able to see items on dashboards table
    Given Dashboards page is opened
    When Choose dashboard
    Then Dashboards table should have items

#  @ui
#  Scenario Outline: User is able to see column headers on dashboards table
#    Given Dashboards page is opened
#    When Choose dashboard
#    Then Dashboards table columns should have headers <columnHeader>
#
#    Examples:
#      | columnHeader   |
#      | DASHBOARD NAME |
#      | DESCRIPTION    |
#      | OWNER          |
#      | SHARED         |
#      | EDIT           |
#      | DELETE         |

  Scenario Outline: User is able to see dashboard names on dashboards table
    Given Dashboards page is opened
    When Choose dashboard
    And Dashboards table should have items
    Then Dashboards table should have name <dashboardName>

    Examples:
      | dashboardName  |
      | DEMO DASHBOARD |
      | TEST DASHBOARD |

  Scenario Outline: User is able to see dashboard descriptions on dashboards table
    Given Dashboards page is opened
    When Choose dashboard
    And Dashboards table should have items
    Then Dashboards table should have description <descriptionName>

    Examples:
      | descriptionName    |
      | Dashboard for demo |
      | Dashboard for test |

  Scenario: User is able to see dashboard owner on dashboards table
    Given Dashboards page is opened
    When Choose dashboard
    And Dashboards table should have items
    Then Dashboards table should have owner 'superadmin'
