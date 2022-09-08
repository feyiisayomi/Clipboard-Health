# Clipboard-Health

## This is a Selenium Java Automation

### Description
##### This is an automation script that selects a category and sub category from amazon India
##### * filters the search result by brand
##### * Sorts the filtered results from highest to lowest price
##### * Selects the second most expensive product and logs the features of the products

#### Technologies
* Language: Java
* Automation Framework: Selenium
* Test Framework: TESTNG
* Build Automation Tool: Maven
* Design Pattern: Page Object Model (POM)
* IDE: IntelliJ IDEA (Eclipse can be used too but ensure maven is installed)

#### Depedencies installed
* selenium: https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.4.0
* webdrivermanager: https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager/5.3.0
* testng: https://mvnrepository.com/artifact/org.testng/testng/7.6.1
* Apache commons-io: https://mvnrepository.com/artifact/commons-io/commons-io/2.11.0

#### Instructions on how to run on localhost
* Fork this repository
* Clone your forked repository
* Build the project on your IDE (***Please ensure that maven is downloaded***)
* Right click on the testng.xml file 
* Click Run
* After script has finished runnning navigate to the test-output folder
* open the UI Suite folder
* click emailable-report.html to see the content of the Reporter

