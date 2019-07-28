package BaseData.GenerateData;

import BaseData.ConstantData;
import org.json.JSONObject;


public class TestData {


    public  JSONObject dataForTest = new JSONObject();

    public  JSONObject CreateAllDate() {
        JSONObject mainInformation=new JSONObject();

        mainInformation.put("main_email",  new ConstantData().getMainEmail());
        mainInformation.put("password",  new ConstantData().getPassword());
        mainInformation.put("main_email_real",  new ConstantData().getEmailReal());
        mainInformation.put("password_real",  new ConstantData().getPasswordReal());

        dataForTest.put("personal_information", mainInformation);
        return dataForTest;
    }


}
