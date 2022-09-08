package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AmazonTestMethods {
    WebDriver driver;

    public AmazonTestMethods(WebDriver driver)
    {
        this.driver=driver;

    }
    //Element location and PageObjects creation using PageFactory
    @FindBy(xpath ="//*[@id=\"nav-hamburger-menu\"]" )
    WebElement hamburgerMenu;

    @FindBy(css = "#hmenu-content > ul.hmenu.hmenu-visible > li:nth-child(14) > div" )
    WebElement categoryTitle;

    @FindBy(xpath = "//ul[@class='hmenu hmenu-visible']//li[16]//a[1]")
    WebElement category;

    @FindBy(xpath = "//a[normalize-space()='Televisions']")
    WebElement subCategory;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[21]/div[1]")
    WebElement brandFilterSection;

    @FindBy(xpath = "//span[@class='a-size-base a-color-base'][normalize-space()='Samsung']")
    WebElement brandSamsung;

    @FindBy(xpath = "//select[@name='s']")
    WebElement sortDropDown;

    @FindAll({@FindBy(className ="a-price-whole" )})
    List<WebElement> price;

    @FindBy(id = "feature-bullets")
    WebElement aboutSection;

    @FindBy(xpath = "//h1[@class='a-size-base-plus a-text-bold']")
    WebElement aboutSectionHeading;

    @FindAll({@FindBy(xpath ="//*[@id=\"feature-bullets\"]/ul/li/span")})
    List<WebElement> aboutSectionFeatures;


    //Method to filter amazon television by brand(Samsung) and sort product list from highest to lowest
    public void SortbyBrand() throws InterruptedException {

        hamburgerMenu.click();
        //script to scroll down to the element specified
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",categoryTitle);
        category.click();
        subCategory.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView", brandFilterSection);
        brandSamsung.click();
        //Thread.sleep used to stop the execution of the current thread so the sort filter will be effective
        Thread.sleep(5000);
        Select sortby = new Select(sortDropDown);
        sortby.selectByValue("price-desc-rank");
    }

    //Method to store the sorted television prices and pick the second most expensive
    public void ListPrice() {
        List<WebElement> priceList = price;
        priceList.get(1).click();
        //For loop that switches to that loops opened tab and switch to the new tab
        for (String newTab : driver.getWindowHandles()) {
            driver.switchTo().window(newTab);

        }

    }

    //Method to List all Features of the television and save the features into a string
    public String ListFeatures(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView", aboutSectionHeading);
        List<WebElement> Features = aboutSectionFeatures;
        StringBuilder About = new StringBuilder();
        About.append(aboutSectionHeading.getText());
        for (WebElement feature : Features) {
            About.append("\n").append(feature.getText());
        }
        return About.toString();
    }

    //Method to check if "About this Item" Section is present
    public boolean isAboutPresent(){
        //Assertion
        return aboutSection.isDisplayed();
    }
}