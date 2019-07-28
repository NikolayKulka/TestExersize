package Site;

import BaseData.GenerateData.TestData;
import BaseData.NewSiteMapping.PersonalRoom_NewSite;
import BaseData.StartDriver;
import org.json.JSONObject;
import org.testng.annotations.Test;


public class SiteTests extends StartDriver {

    @Test()
    public void  LoginPositive() {
        JSONObject data = new TestData().CreateAllDate();
        new PersonalRoom_NewSite().logIN(data,true);
    }

    @Test()
    public void  LoginNegative() {
        JSONObject data = new TestData().CreateAllDate();
        new PersonalRoom_NewSite().logIN(data,false);
    }

}