package stepdefinitions;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Map;


public class DataTable {

    private WebDriver driver = null;

    private By search = By.name("q");

    /**
     * Constructor to get driver instance from Hooks
     */
    public DataTable() {
        this.driver = Hooks.getDriver();
    }


    private WebElement element(By by) {
        return driver.findElement(by);
    }


    @When("^I navigate to website")
    public void i_navigate_to_website(Map<String, String> dataMap) {
        String website = dataMap.get("website");
        driver.get(website);
    }


    @Then("^I validate the website title as mentioned below$")
    public void i_validate_the_website_title_as_mentioned_below(Map<String, String> dataMap) throws Exception {
        String title = dataMap.get("title");
        Assert.assertTrue(driver.getTitle().contains(title));
        Thread.sleep(1000);
    }


    @And("^I type text to search text field$")
    public void i_Type_Text_To_Search_Text_Field(Map<String, String> dataMap) throws Exception {
        element(search).sendKeys(dataMap.get("text1"));
        Thread.sleep(1000);
        element(search).clear();
        element(search).sendKeys(dataMap.get("text2"));
        Thread.sleep(2000);
    }


}

