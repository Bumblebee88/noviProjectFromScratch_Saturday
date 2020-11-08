package com.serb.step_definitions;

import com.serb.pages.BasePage;
import com.serb.pages.CalendarEventPage;
import com.serb.utils.BrowserUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class CreateCalendarEventStep extends BasePage  {

    CalendarEventPage calendarEventPage=new CalendarEventPage();

    @Given("user clicks on create calendar button")
    public void user_clicks_on_create_calendar_button() {
    calendarEventPage.clickOnCalendarEventBTN();
    }



    @When("user adds new calendar event information")
    public void user_adds_new_calendar_event_information(Map<String,String>data) {

        data.forEach((key,value)-> System.out.println("Key: " + key + ", value: " + value));

        String title = data.get("Title");
        String description = data.get("Description");

        calendarEventPage.enterTitleInput(title);
        calendarEventPage.enterDescriptionInput(description);

    }


    @Then("user verifies that new calendar event is displayed")
    public void user_verifies_that_new_calendar_event_is_displayed(Map<String, String> dataTable) {
        String title=dataTable.get("Title");
        String Description=dataTable.get("Description");

        Assert.assertEquals(title, calendarEventPage.getDateaFromGeneralInfo("Title"));
        Assert.assertEquals(Description,calendarEventPage.getDateaFromGeneralInfo("Description"));

    }


    @Given("Hover on three dots for {string} calendar event")
    public void hover_on_three_dots_for_calendar_event(String string) {
           calendarEventPage.hoverOverDots(string);
    }




    @Then("Verify that {string}, {string} and {string} options are available")
    public void verify_that_and_options_are_available(String string, String string2, String string3) {

        BrowserUtils.wait(3);
        calendarEventPage.optionsDisp(string,string2,string3);


    }


    @When("Click on {string} button")
    public void click_on_button(String string) {
      calendarEventPage.clickOnGrid();
    }




    @When("Deselect all options except {string}")
    public void deselect_all_options_except(String string) {
       calendarEventPage.setUncheckingOptions(string);
    }


    @Then("{string} column still displayed")
    public void column_still_displayed(String string) {

        Assert.assertEquals(string,calendarEventPage.isTitleDisplayed());

    }

    //TC3

    @And("user expand Save And Close menu")
    public void user_expand_save_and_close_menu() {
    calendarEventPage.dropdownSaveAndClick();
    }



    @Then("Verify that {string}, {string} and {string} options are ava")
    public void verify_that_save_and_new_and_options_are_available(String string, String string1, String string2) {
        calendarEventPage.dropSaveAndClose(string,string1,string2);
    }

    //TC4

    @And("click on cancel button")
    public void click_on_cancel_button() {
       calendarEventPage.closeButton();
    }



    @Then("verify that {string} page subtitle is displayed")
    public void verify_that_page_subtitle_is_displayed(String string) {
    calendarEventPage.AllCalendarEventsDisplayed(string);
    }

    //TC5

    @Then("difference between end and start time is exactly {int} hour")
    public void difference_between_end_and_start_time_is_exactly_hour(Integer int1) {
    calendarEventPage.meetingLastingTime(1);
    }

    //TC6

    @And("user select {string} as a start time")
    public void user_select_as_a_start_time(String string) {
    calendarEventPage.setSelect9pm(string);
    BrowserUtils.wait(2);
    }


    @Then("Verity that ent time is equal to {string}")
    public void verity_that_ent_time_is_equal_to(String string) {
       String expected="10:00 PM";
       String actual=calendarEventPage.displayedtime(string);
       Assert.assertEquals(expected,actual);


    }









}
