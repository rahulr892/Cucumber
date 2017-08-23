package stepdefinitions;


import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Map;


public class DataTables {

    private WebDriver driver;

    private By search = By.name("q");
    private By registerLink = By.linkText("REGISTER");
    private By userName = By.cssSelector("input#email");
    private By password = By.cssSelector("input[name='password']");
    private By confirmPassword = By.cssSelector("input[name='confirmPassword']");
    private By submit = By.cssSelector("input[name='register']");
    private By signOff = By.cssSelector("td:nth-child(1) > a");


    /**
     * Constructor to get driver instance from Hooks via PicoContainer DI
     */
    public DataTables(Hooks hook) {
        driver = hook.setUp();
    }


    private WebElement element(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }


    // Scenario: Check title of website

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


    // Scenario: Register on newtours

    @Then("^I click on register link$")
    public void i_Click_On_Register_Link() {
        element(registerLink).click();
    }

    @Then("^I enter valid data using datatable and raw$")
    public void i_enter_valid_data_using_datatable_and_raw(DataTable userDetails) {
        List<List<String>> data = userDetails.raw();

        element(userName).sendKeys(data.get(0).get(1));
        element(password).sendKeys(data.get(1).get(1));
        element(confirmPassword).sendKeys(data.get(2).get(1));
    }

    @Then("^I enter valid data using datatable and map$")
    public void i_enter_valid_data_using_datatable_and_map(DataTable userDetails) {
        for (Map<String, String> user : userDetails.asMaps(String.class, String.class)) {
            element(userName).sendKeys(user.get("username"));
            element(password).sendKeys(user.get("password"));
            element(confirmPassword).sendKeys(user.get("confirmPassword"));
        }
    }

    @Then("^I enter valid data using datatable and pojo$")
    public void i_enter_valid_data_using_datatable_and_pojo(List<UserData> details) {
        for (UserData user : details) {
            element(userName).sendKeys(user.getUserName());
            element(password).sendKeys(user.getPassword());
            element(confirmPassword).sendKeys(user.getConfirmPassword());
        }
    }


    @Then("^I click on submit$")
    public void i_click_on_submit() {
        element(submit).click();
    }

    @Then("^I click signOff$")
    public void i_click_signOff() {
        element(signOff).click();
    }

}

