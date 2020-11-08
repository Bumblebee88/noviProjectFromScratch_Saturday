package com.serb.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class Driver {

    private Driver(){}

    private static WebDriver driver;



    public static WebDriver getDriver() {
       if(driver==null){
           String browser=ConfigurationReader.getProperty("browser");
           switch (browser){
               case "chrome":
                   WebDriverManager.chromedriver().setup();
                   driver= new ChromeDriver();
                   break;
               case "firefox":
                   WebDriverManager.firefoxdriver().setup();
                   driver=new FirefoxDriver();
                   break;
               case "remote-chrome":
                   try {
//                    ChromeOptions chromeOptions = new ChromeOptions();
                       DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                       desiredCapabilities.setBrowserName("chrome");
                       URL gridUrl = new URL("http://52.91.199.38:4444/wd/hub");
                       //52.91.199.38 vs-3.82.5.142
                       driver = new RemoteWebDriver(gridUrl, desiredCapabilities);
                   }catch (Exception e){
                       e.printStackTrace();
                   }
                   break;
               default:
                 throw new  RuntimeException ("No browser founded");
           }


       }

        return driver;
    }
    public static void closeDriver(){
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
