package stepdefinitions;


import com.cucumber.listener.Reporter;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class GoogleSearch {

    private WebDriver driver = null;

    private By search = By.name("q");
    private By email = By.name("email");

    /**
     * Constructor to get driver instance from Hooks
     */
    public GoogleSearch() {
        this.driver = Hooks.getDriver();
    }

    private WebElement element(By by) {
        return driver.findElement(by);
    }

    @Given("^I open a browser$")
    public void i_open_a_browser() {
        Reporter.addStepLog("Chrome Browser Opened");
    }

    @When("^I navigate to google$")
    public void i_navigate_to_google() {
        driver.get("https://www.google.co.in/");
    }

    @Then("^I validate the search text field$")
    public void i_validate_the_search_text_field() throws Exception {
        element(search).sendKeys("Google test");
        Thread.sleep(2000);
    }

    @When("^I navigate to facebook$")
    public void i_navigate_to_facebook() {
        driver.get("https://www.facebook.com/");
    }

    @Then("^I validate the facebook page$")
    public void i_validate_the_facebook_page() throws Exception {
        element(email).sendKeys("FB test");
        Thread.sleep(2000);
    }

    @Then("^I type \"([^\"]*)\" to search text field$")
    public void i_type_to_search_text_field(String arg1) throws Exception {
        element(email).sendKeys(arg1);
        Thread.sleep(2000);
    }


}

