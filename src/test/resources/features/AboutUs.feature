Feature: About Us Functionality
  @ui @wip
  Scenario: About Us Functionality and Title Verification
    Given user is on the WSECU homepage
    When user selects "About Us" menu
    And user selects "Financial Wellness Overview" submenu
    Then verify title contains "Financial Wellness"