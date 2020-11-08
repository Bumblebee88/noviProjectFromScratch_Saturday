package com.serb.step_definitions;

import com.serb.pages.BasePage;
import com.serb.pages.CreateCarePage;
import com.serb.utils.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.Map;

public class CreateCarStepDefinition extends BasePage {

    CreateCarePage createCarePage=new CreateCarePage();





    @Given("user clicks on create car button")
    public void user_clicks_on_create_car_button() {
      createCarePage.clickOnCreateCar();
        BrowserUtils.wait(5);

    }


    @When("user adds new vehicle information")
    public void user_adds_new_vehicle_information(Map<String, String> dataTable) {
        
        dataTable.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));
        String licence_plate = dataTable.get("License Plate");
        String model_year = dataTable.get("Model Year");

        createCarePage.enterLicensePlate(licence_plate);
        createCarePage.enterModelYear(model_year);

    }




}
