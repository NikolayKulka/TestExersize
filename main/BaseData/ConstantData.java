package BaseData;

import org.apache.commons.lang3.RandomStringUtils;

import static Core.TestMethods.XmlReader.readXML;


public class ConstantData {


    public String getNewSite() {
        return readXML("baseData","mainUrl");
    }

    public  String getMainEmail() {
        return RandomStringUtils.randomAlphabetic(8)+ "@test.com";
    }

    public String getPassword()
    {
        return  RandomStringUtils.randomAlphabetic(4) + RandomStringUtils.randomNumeric(4);
    }

    public String getPasswordReal()
    {
        return readXML("testData","password");
    }

    public String getEmailReal()
    {
        return readXML("testData","email");
    }




}