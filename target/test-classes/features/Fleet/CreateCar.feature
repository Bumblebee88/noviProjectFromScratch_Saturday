Feature: As user, I want to be able to create new cars

  @add_car
  Scenario: 1. Add some car
    Given user is on the login page
    And user logs in as a "store manager"
    And user navigates to "Fleet" and "Vehicles"
    And user clicks on create car button
    When user adds new vehicle information
      | License Plate | SDET |
      | Model Year    | 2021 |
    And user clicks on save and close button

  @add_car_scenario_outline
  Scenario Outline: 1. Add some car with <licence plate> plates and <model year>
    Given user is on the login page
    And user logs in as a "<role>"
    And user navigates to "Fleet" and "Vehicles"
    And user clicks on create car button
    When user adds new vehicle information
      | License Plate | <licence plate> |
      | Model Year    | <model year> |
    And user clicks on save and close button

    Examples: auto test data
    |licence plate|model year|role|
    |Baljevac      |2020      |store manager|
    |Brvenica     |2021      |store manager|
    |Studenica    |2022      |store manager|
    |4TRUMP       |2020      |store manager|
