package com.serb.pages;

import com.serb.utils.BrowserUtils;
import com.serb.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

public class CalendarEventPage extends BasePage{

    @FindBy(css = "[title='Create Calendar event']")
private WebElement createCalendarEventBTN;

    @FindBy(name = "oro_calendar_event_form[title]")
    private WebElement titleInbox;

    @FindBy(id = "tinymce")
    private WebElement descriptionInputBox;

    @FindBy(xpath = "//table//tr[1]//td[9]/div[1]")
    private  WebElement threeDots;

    @FindBy(xpath = "label[.='Title']")
    private WebElement titleName;

    @FindBy(xpath = "//*[@title='View']")
    private WebElement eyeIcon;

    @FindBy(xpath = "//*[@title='Edit']")
    private WebElement editIcon;

    @FindBy(xpath = "//*[@title='Delete']")
    private WebElement deleteIcon;

    @FindBy(xpath = "//i[@class='fa-cog hide-text']")
    private WebElement clickOnGridSettings;
                    //"//label[contains(text(),'Title')]")
     @FindBy(xpath = "//tbody[@class='ui-sortable']/tr/td/input")
     private List<WebElement> gridOptionsCheckBoxes;

    @FindBy(xpath = "//tbody[@class='ui-sortable']/tr/td/label")
    private List<WebElement> gridOptionsTitles;

    @FindBy(xpath = "//table//tbody//tr//td//label")
    private List<WebElement> uncheckingOptions;

    @FindBy(xpath = "//a[@class='btn-success btn dropdown-toggle']")
    private WebElement saveAndClickDropdown;

    @FindBy(xpath = "//form//div//ul//li[1]//button")
    private WebElement dropSaveAndClose;
    @FindBy(xpath = "//form//div//ul//li[2]//button")
    private WebElement dropSaveAndNew;
    @FindBy(xpath = "//form//div//ul//li[3]//button")
    private WebElement dropSave;

    @FindBy(xpath = "//a[@class='btn back icons-holder-text ']")
    private WebElement closeButton;

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    private WebElement displayedAllCalendarEvents;

    @FindBy(xpath = "//input[contains(@id, 'time_selector_oro_calendar_event_form_start')]")
    private WebElement startTime;
    @FindBy(xpath = "//input[contains(@id, 'time_selector_oro_calendar_event_form_end')]")
    private WebElement endTime;
    @FindBy(xpath = "//body/div[6]/ul/li[1]")
    private WebElement pickedTime;
    @FindBy(xpath = "//li[contains(@class,'timepicker-selected')]")
    private WebElement pickedTime2;


    @FindBy(xpath = "//body//form//div//input[2]")
    private WebElement selectStartBox;

    @FindBy(xpath = "//body/div[7]//ul")
    private List<WebElement> displayedTime;

    @FindBy(xpath = "//li[contains(text(),'9:00 PM')]")
    private WebElement clickOn9PM;
    @FindBy(xpath = "//body//form//fieldset[1]/div[2]/div/div[2]//input[2]")
    private WebElement displayedEndBox;
    @FindBy(xpath = "//div[@class='fields-row']")
    private WebElement page;

    public void setSelect9pm  (String start){
        BrowserUtils.clickOnElement(selectStartBox);
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(selectStartBox));
        JavascriptExecutor js=(JavascriptExecutor)Driver.getDriver();

        js.executeScript("arguments[0].scrollIntoView(true)",clickOn9PM);
        BrowserUtils.clickOnElement(clickOn9PM);

        for (WebElement each:displayedTime){
            if(each.getText().equalsIgnoreCase(start)){
                BrowserUtils.wait(2);
                BrowserUtils.clickOnElement(each);
                return;
            }

        }

    }

    public String displayedtime(String string){
        BrowserUtils.wait(3);
        BrowserUtils.clickOnElement(displayedEndBox);
        BrowserUtils.wait(3);
        if(displayedEndBox.isSelected()){
            BrowserUtils.wait(3);
          
        }
        return displayedEndBox.getText();

    }


    public void meetingLastingTime(Integer n){

        String startingTime="";
        String endingTime="";
        int start = 0;
        int end = 0;

        BrowserUtils.clickOnElement(endTime);
        endingTime = pickedTime2.getText();
        startingTime = pickedTime.getText();
        System.out.println("endingTime = " + endingTime);
        System.out.println("startingTime = " + startingTime);

        endingTime = endingTime.replace(":","").substring(0,endingTime.length()-4);
        startingTime = startingTime.replace(":","").substring(0,startingTime.length()-4);
        end = Integer.parseInt(endingTime);
        start = Integer.parseInt(startingTime);

        Integer time = (end-start);
        if (time==-1100){
            n-=1101;
        }else {
            n = n * 100;
        }
        System.out.println("time = " + time);
        Assert.assertEquals(n,time);


    }



    public void AllCalendarEventsDisplayed(String string){
        Assert.assertTrue(string,displayedAllCalendarEvents.isDisplayed());
    }


    public void closeButton(){
        BrowserUtils.clickOnElement(closeButton);
    }



    public void dropSaveAndClose(String string,String string1, String string2) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
        wait.until(ExpectedConditions.elementToBeClickable(dropSaveAndClose));

        Assert.assertTrue(dropSaveAndClose.isEnabled());
        Assert.assertTrue(dropSaveAndNew.isEnabled());
        Assert.assertTrue(dropSave.isEnabled());

    }




    public void dropdownSaveAndClick(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
        wait.until(ExpectedConditions.elementToBeClickable(saveAndClickDropdown));
        BrowserUtils.clickOnElement(saveAndClickDropdown);
    }


    public void checkIfOptionIsSelected(String str){
        String s = "";
        for (WebElement each : gridOptionsTitles) {
            if (!each.getText().equals(str)){
                continue;
            }
            s=each.getAttribute("for");
        }
        for (WebElement each : gridOptionsCheckBoxes){
            if (!each.getAttribute("id").equals(s)){
                continue;
            }
            Assert.assertTrue(each.isSelected());
            return;
        }
        throw new RuntimeException("option wasn't found");
    }


    public void setUncheckingOptions(String checkbox) {

        for (WebElement each: uncheckingOptions){
            if(each.getText().equalsIgnoreCase(checkbox)){
                continue;
            }
            BrowserUtils.clickOnElement(each);
        }

    }






    public void clickOnGrid(){
        BrowserUtils.clickOnElement(clickOnGridSettings);

    }


    public void optionsDisp(String view,String edit, String delete) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
        wait.until(ExpectedConditions.elementToBeClickable(eyeIcon));

        Assert.assertEquals(view,eyeIcon.getAttribute("title"));
        Assert.assertEquals(edit,editIcon.getAttribute("title"));
        Assert.assertEquals(delete,deleteIcon.getAttribute("title"));
    }

    public void hoverOverDots(String str){
        Actions actions = new Actions(Driver.getDriver());
        WebElement dots = Driver.getDriver().findElement(By.xpath("//td[.='"+str+"']/following-sibling::td[7]"));
        actions.moveToElement(dots).perform();
    }




    public  void clickOnCalendarEventBTN(){
        BrowserUtils.clickOnElement(createCalendarEventBTN);
    }

    public void enterTitleInput(String string){
        BrowserUtils.enterText(titleInbox,string);

    }

    public void enterDescriptionInput(String string){
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),30);
        //exit from all frames
        Driver.getDriver().switchTo().defaultContent();
        //wait for frame and switch to it
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
        //enter text
        descriptionInputBox.sendKeys(string);
        //exit from the frame
        Driver.getDriver().switchTo().defaultContent();


    }

    public String getDateaFromGeneralInfo(String parametarName){
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),20);
        String xpath = "//label[text()='" + parametarName + "']/../div/div";
        WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return element.getText().trim();


    }






}
