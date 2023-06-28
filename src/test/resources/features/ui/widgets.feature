Feature: Widgets feature
  As an user
  I want to see widgets when a dashboard is selected

  Background: User is able to login to Report Portal
    Given User logins to Report Portal with a member user

  @ui @selenium
  Scenario: User is able to navigate to widgets
    Given Dashboards page is displayed
    When Choose project name
    Then Dashboards table should contain items
    When Choose dashboard name
    Then Widgets should be displayed

  @ui @selenium
  Scenario: User is able to resize the widget
    Given Dashboards page is displayed
    When Choose project name
    Then Dashboards table should contain items
    When Choose dashboard name
    And Widgets should be displayed
    Then Resize widget with index 0
