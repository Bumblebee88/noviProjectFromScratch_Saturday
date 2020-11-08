@login
Feature: As user i want to be able to login under different role
#this is a comment

  Background: got to login page
    Given user is on the login page


  Scenario: Login as a sales manager

    When user logs in
    Then user should see dashboard page

  @parametrized_test @smoke_test
  Scenario: Parametrized login

    When user logs in as a "store manager"
    Then user should see dashboard page

  @parametrized_test @smoke_test
  Scenario: Parametrized login

    When user logs in as a "sales manager"
    Then user should see dashboard page

  @s_o
  Scenario Outline:  Parametrized login as <role>

    When user logs in as a "<role>"
    Then user should see dashboard page

    Examples:
      | role          |
      | sales manager |
      | store manager |
      | driver        |


  @s_o @with_two_columns
  Scenario Outline:  Parametrized login as <role>

    When user logs in as a "<role>"
    Then user should see "<page_title>"

    Examples:
      | role          | page_title |
      | sales manager | Dashboard  |
      | store manager | Dashboard  |
      | driver        | Dashboard  |

     #    role - variable. You can name parameters as you want.
#   1st row always reserved for parameters
# auto-formatting on mac:     command + option + L
# auto-formatting on windows: control + alt + L
#"driver" - is a parameter. "" allows to do test parametrization which helps to re-use test steps

  @negative_login

  Scenario: Invalid password
    Given user is on the login page
    When user logs in with "storemanager85" username and "wrong" password
    Then user verifies that "Invalid user name or password." message is displayed

  @negative_scenario_outline
  Scenario Outline: Invalid login
    Given user is on the login page
    When user logs in with "<username>" username and "<password>" password
    Then user verifies that "<message>" message is displayed

    Examples: data set
      | username | password | message                        |
      | wrong    | bad      | Invalid user name or password. |
      | wrong213 | bad      | Invalid user name or password. |
      | wrong32  | bad      | Invalid user name or password. |
      | wrong12  | bad      | Invalid user name or password. |

















