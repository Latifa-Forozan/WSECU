@ui @task
Feature: Online Banking Sign in Functionality

#Requirements
#Using your IDE of choice (preferably in C#), please create an automation project that demonstrates
#your knowledge of how to build a test automation framework using best practices, with the following
#criteria:
#1. Create code within a project that uses Selenium WebDriver to perform the following steps:
#a. Navigate to https://www.wsecu.org.
#b. In the “Online Banking” dialogue, enter an incorrect username of thisuserwillnotwork and click “Sign in”.
#c. Verify that the user is redirected to the WSECU Online Banking web site hosted at
#https://digital.wsecu.org/banking/signin.
#d. In the WSECU Online Banking web site, enter an incorrect password of thispasswillfailforsure
# and click “Sign In”.
#e. Verify that an error message is received that states “Sorry, incorrect username.

  Scenario Outline: Validate user is not able to sign in with invalid credentials
    Given user is on the WSECU homepage
    When user enters user name "thisuserwillnotwork"
    And user clicks sign in button
    Then user has to be redirected to "https://digital.wsecu.org/banking/signin" page
    When user enters "password" "<password>"
    And user clicks sign in button2
    Then user should see "Sorry, incorrect username." message

    Examples:
      | password                |
      | thispasswillfailforsure |

