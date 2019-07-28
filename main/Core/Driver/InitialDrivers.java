package Core.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import static Core.Driver.DriversCapabilities.*;
import static Core.TestMethods.XmlReader.readXML;


public class InitialDrivers {

    private static volatile InitialDrivers instance;

    public static InitialDrivers getInstance() {
        InitialDrivers localInstance = instance;
        if (localInstance == null) {
            synchronized (InitialDrivers.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new InitialDrivers();
                }
            }
        }
        return localInstance;
    }

    public static final int waitTimeConst = Integer.parseInt(readXML("baseData","waiterTime"));

    public WebDriver CurrentDriver() {
         driver =getDriver();
        return driver;}

    protected  WebDriver  getDriver() {
        {
            if (driver == null)
            {
                driver = selectDriver();
            }
            return driver;
        }
    }

    public   WebDriver driver;
    public WebDriver selectDriver() {
        String osName = System.getProperty("os.name").toLowerCase();
        String swtFileName =
                osName.contains("win") ? "win" : osName.contains("mac") ? "macosx" :
                        osName.contains("linux") || osName.contains("nix") ? "linux_gtk" : null;
        Drivers driverName = Drivers.valueOf(readXML("baseData","driver"));
        String path = System.getProperty("user.dir");
        String newPath = path + "\\resources\\Drivers";

        switch (driverName) {
            case MobileChrome: {
                System.setProperty("webdriver.chrome.driver", newPath + "\\chromedriver.exe");
                driver =new ChromeDriver(chromeOptions());
                break;
            }
            case Chrome: {
               assert swtFileName != null;
                if(swtFileName.contains("win"))
                {
                    System.setProperty("webdriver.chrome.driver", newPath + "\\chromedriver.exe");
                }
                else {
                    System.out.println("This is Unix or Linux OS");
                    System.setProperty("webdriver.chrome.driver", "");
                }
               driver =new ChromeDriver(chromeOptions());
               break;
            }
            case Firefox: {
                System.setProperty("webdriver.gecko.driver", newPath + "\\geckodriver.exe");
                driver = new FirefoxDriver(firefoxOptions());
                break;
            }
            default:driver=new ChromeDriver(chromeOptions());

        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        return driver;
    }

    public enum Drivers {Chrome, Firefox, MobileChrome}
}