package base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

public class BaseTest {

    @BeforeMethod
    public void setup(){
        PlaywrightFactory.init();
        PlaywrightFactory.getPage().navigate(ConfigReader.getKey("baseUrl"));

    }

    @AfterMethod
    public void tearDown(){
        PlaywrightFactory.clear();
    }
}
