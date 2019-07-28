package BaseData;

import Core.Driver.InitialDrivers;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import java.lang.reflect.Method;

public class StartDriver {


    @AfterMethod(alwaysRun = true)
    public void StopTest(ITestResult result, Method method) {
        if(InitialDrivers.getInstance().driver!=null)
        {InitialDrivers.getInstance().driver.quit();}
        InitialDrivers.getInstance().driver=null;
        }

}