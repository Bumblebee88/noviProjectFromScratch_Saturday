@calendarEvents
Feature: as a user i want to be able to create calendar events


  @CalendarEvent @smoke
  Scenario: Create calendar event with default time
    Given user is on the login page
    And user logs in as a "store manager"
    And user navigates to "Activities" and "Calendar Event"
    And user clicks on create calendar button
    When user adds new calendar event information
      |Title|B20 Graduation Party                            |
      |Description|All B20 friends are invited for this party|
    And user clicks on save and close button
    Then user verifies that new calendar event is displayed
      |Title|B20 Graduation Party                            |
      |Description|All B20 friends are invited for this party|


  @TC1
  Scenario: Verify that "view", "edit" and "delete" options are available
    Given user is on the login page
    And user logs in as a "store manager"
    And user navigates to "Activities" and "Calendar Event"
    And Hover on three dots for "Test Event" calendar event
    Then Verify that "View", "Edit" and "Delete" options are available

  @TC2
  Scenario: deselecting options
    Given user is on the login page
    And user logs in as a "store manager"
    And user navigates to "Activities" and "Calendar Event"
    When Click on "Grid Options" button
    And Deselect all options except "Title"
    Then "Title" column still displayed

    @TC3
  Scenario: Expand and save and close button

      Given user is on the login page
      And user logs in as a "store manager"
      And user navigates to "Activities" and "Calendar Event"
      And user clicks on create calendar button
      And user expand Save And Close menu
      Then Verify that "Save And Close", "Save And New" and "Save" options are ava

      @TC4
      Scenario: click Cancel Button
        Given user is on the login page
        And user logs in as a "store manager"
        And user navigates to "Activities" and "Calendar Event"
        And user clicks on create calendar button
        And click on cancel button
        Then verify that "All Calendar Events" page subtitle is displayed

        @TC5
      Scenario: difference between end and start time
          Given user is on the login page
          And user logs in as a "store manager"
          And user navigates to "Activities" and "Calendar Event"
          And user clicks on create calendar button
          Then difference between end and start time is exactly 1 hour

       @TC6
       Scenario: time equal to 10 pm
         Given user is on the login page
         And user logs in as a "store manager"
         And user navigates to "Activities" and "Calendar Event"
         And user clicks on create calendar button
         And user select "9:00 PM" as a start time
         Then Verity that ent time is equal to "10:00 PM"

