_**`Automation Framework with Cucumber`**_

* This is simple framework with Cucumber BDD approach(Page Object Module) with jUnit that I get my
* (annotations and assertions), used Gherkin language.
* I have used Java as it has strong support for cucumber framework.
* I used selenium WebDriver, Maven project in intelliJ IDEA, as it is user-friendly and easy to use.
* I only use the test package of maven.

* * Adding Related Dependencies and classes
    Selenium, Junit, Cucumber, Faker, Webdrivermanager, API related dependencies etc

* Cucumber layers:
* 1- Features
* 2- Step Definitions:

  ┌────────────┐                 ┌──────────────┐                 ┌───────────┐
  │   Feature  │                 │     Step     │                 │           │
  │ in Gherkin ├──matched with──>│ Definitions  ├───manipulates──>│  System   │
  │            │                 │              │                 │           │
  └────────────┘                 └──────────────┘                 └───────────┘

* Cucumber Maven Project:
* ReadMe file: General information about framework
* Configuration.properties file: Store common test data to increase maintainability, re-usability etc and avoid hard coding.
* POM.xml: add, manage and delete the dependencies and versions
  Folder structure : Utilities package
  Pages package
  Step_definitions package
  Runners package
  Directories: feature files
  Different files
*
* Hooks
  Hook is a commonly used term in cucumber to illustrate the idea of running some code right before and after each scenario.
  In this project we have @Befor that opens the url and @After that tear down the driver and take screen shot method
