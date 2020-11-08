package com.serb.step_definitions;

import com.serb.pages.LoginPage;
import com.serb.utils.BrowserUtils;
import com.serb.utils.ConfigurationReader;
import com.serb.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

public class Login_StepDefinitions {

LoginPage loginPage=new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
     Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }


    @When("user logs in")
    public void user_logs_in() throws InterruptedException {
        loginPage.login();
        Thread.sleep(5000);


    }
    @Then("user should see dashboard page")
    public void user_should_see_dashboard_page() {
        String expected = "Dashboard";
        String actual = loginPage.getPageSubTitleText().trim();

        Assert.assertEquals("Title is not correct!", expected, actual);
        System.out.println("I see the Dashboard page!");
        Driver.closeDriver();
    }

    @Then("user should see {string}")
    public void user_should_see(String string) {
        String actual = loginPage.getPageSubTitleText().trim();
        Assert.assertEquals("Page title is not correct!", string, actual);
    }


    //When user logs in as a "driver" --> public void user_logs_in_as_a(String string) -> loginPage.login(string); -> public void login(String role) { if role == "" do this..}
    //When user logs in as a "sales manager"
    //When user logs in as a "store manager"
    @When("user logs in as a {string}")
    public void user_logs_in_as_a(String string) {
        loginPage.login(string);
    }

    //  String string = "storemanager85";
//  String string2 =  "wrong";
    //When user logs in with "storemanager85" username and "wrong" password
    @When("user logs in with {string} username and {string} password")
    public void user_logs_in_with_username_and_password(String string, String string2) {
        loginPage.login(string, string2);
    }

    //    String expected = "Invalid user name or password."
//    Then user verifies that "Invalid user name or password." message is displayed
    @Then("user verifies that {string} message is displayed")
    public void user_verifies_that_message_is_displayed(String expected) {
        String actualResult = loginPage.getWarningMessageText();
        Assert.assertEquals(expected, actualResult);
    }







    }


