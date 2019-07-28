package Core.Driver;


import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


interface DriversCapabilities {


    static ChromeOptions chromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
       // options.addArguments("--headless");
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
        capability.setBrowserName("chrome");
        capability.setPlatform(Platform.ANY);
        return options;
    }

    static FirefoxOptions firefoxOptions() {
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(true);
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.helperApps.alwaysAsk.force", false);
        capability.setCapability(FirefoxDriver.PROFILE, profile);
        options.addArguments("start-maximized");
        return options;
    }


}