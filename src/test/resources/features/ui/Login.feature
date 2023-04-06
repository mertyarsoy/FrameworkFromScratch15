@QA_regression
Feature: Testing Login Functionality of OpenMRS Web Application

  Scenario: Positive Login Functionality
    Given User provides username, password and 'Laboratory'
    Then User validates the 'Home' and 'https://demo.openmrs.org/openmrs/referenceapplication/home.page'

  @QA_smoke
  Scenario Outline: Negative Login Functionality
    Given User provides '<username>', '<password>' and '<location>'
    Then User validates 'Invalid username/password. Please try again.' message
    Examples:
      | username    | password    | location   |
      | admin       | Admin12     | Laboratory |
      | Mert        | Admin123    | Laboratory |
      | fasdf       |             | Laboratory |
      |             | Admin12     | Laboratory |
      | admin123    | Admin12321  | Laboratory |
      | @#@#$$@#$@# | !$#!#!@#!#! | Laboratory |


