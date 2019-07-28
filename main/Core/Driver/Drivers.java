package Core.Driver;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Core.Driver.InitialDrivers.waitTimeConst;


public abstract class Drivers  {

    private WebDriver driver= InitialDrivers.getInstance().CurrentDriver();


    protected  void navigateUrl(String url){
        driver.navigate().to(url);
    }


    protected  WebElement waitClickable(By selector) {
        return new WebDriverWait(driver,waitTimeConst).until(ExpectedConditions.elementToBeClickable(selector));
    }


    protected  boolean elementPresent(By selector) {
         new WebDriverWait(driver,waitTimeConst).until(ExpectedConditions.presenceOfElementLocated(selector));
         return true;
    }


}