package common;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

//This class will be used to save all our common methods like Start browser,Quit browser and save test screenshot
public class Utils {

    //Declare your driver
    static WebDriver driver;

    /**This method accepts your argument, setup and launch the browser based on the browser
     entered from the main automation class**/
    public static WebDriver startBrowser(String browserName, String url)
    {
        switch (browserName) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            case "safari" -> {
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
            }
            case "IE" -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
        }
        //Implicitly wait allows all element to load before any thing is done
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);

        return driver;
    }

    //This method is used to quit the driver opened when running a test
    public static void CloseBrowser()
    {
        driver.quit();
    }

    /* This method is to take screenshot
    * Get the date the screenshot is taken
    * Convert the date to a string and replace some characters with "-"
    * Then it creates a new folder and saves the screenshot in the new folder as the date taken*/
    public void takeScreenshot() throws IOException {

        Date runDate = new Date();
        String screenShotname = runDate.toString().replace(" ","-").replace(":","-");
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File("./screenshot/"+screenShotname+".png"));
    }
}
