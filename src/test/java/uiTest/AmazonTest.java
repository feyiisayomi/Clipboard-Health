package uiTest;
//This is a class to converts our scripts to automation test
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import common.Utils;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.AmazonTestMethods;

import java.io.IOException;

public class AmazonTest {

    WebDriver driver;

    //This Test will run before all the @Test, it starts up the browser and sends a URL
    @BeforeTest
    public void Setup()
    {
        driver= Utils.startBrowser("chrome","https://www.amazon.in/");

    }

    /**This test uses PageFactory to call the AmazonTestMethods class and call methods from that class
    - Asserts that "About Us Section" is present
    - Logs the Feature of the Television in a Reporter **/
    @Test
    public void AutomationTest() throws InterruptedException {

        AmazonTestMethods mainMethod = PageFactory.initElements(driver,AmazonTestMethods.class);
        mainMethod.SortbyBrand();
        mainMethod.ListPrice();
        Assert.assertTrue(mainMethod.isAboutPresent());
        mainMethod.ListFeatures();
        Reporter.log(mainMethod.ListFeatures());
    }

    //This test is carried out after every @Test to quit the browser
    @AfterTest
    public void CloseBrowser()
    {
        Utils.CloseBrowser();
    }
}

