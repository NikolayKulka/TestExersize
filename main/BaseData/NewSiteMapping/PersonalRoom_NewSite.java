package BaseData.NewSiteMapping;

import BaseData.ConstantData;
import Core.Driver.Drivers;
import org.json.JSONObject;
import org.openqa.selenium.*;
import org.testng.Assert;


public class PersonalRoom_NewSite extends  Drivers{

    private static final By logInTxt = By.id("login-email");
    private static final By passwordTxt = By.id("login-password");
    private static final By continueBtn = By.xpath("//button[@type = 'submit' and @ng-disabled]");
    private static final By errorMsg = By.xpath("//p[@class= 'font-w300 ng-binding'][. !='']");
    private static final By someButton = By.xpath("//button[@data-ng-click= 'brand.settings.dynamic.sidebarOpenXs = ! brand.settings.dynamic.sidebarOpenXs']");

    public void logIN(JSONObject data, boolean positive) {
        navigateUrl(new ConstantData().getNewSite());
        if(positive)
        {
        waitClickable(logInTxt).sendKeys(data.getJSONObject("personal_information").getString("main_email_real"));
        waitClickable(passwordTxt).sendKeys(data.getJSONObject("personal_information").getString("password_real"));
        waitClickable(continueBtn).click();
        Assert.assertTrue(elementPresent(someButton));
        }
        else {
            waitClickable(logInTxt).sendKeys(data.getJSONObject("personal_information").getString("main_email"));
            waitClickable(passwordTxt).sendKeys(data.getJSONObject("personal_information").getString("password"));
            waitClickable(continueBtn).click();
            Assert.assertTrue(waitClickable(errorMsg).getText().contains("Некорректны пароль или email"));}
    }

}