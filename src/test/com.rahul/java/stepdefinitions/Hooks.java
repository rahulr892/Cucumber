package stepdefinitions;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Hooks {

    private WebDriver driver;

    /**
     * Launch chrome browser and maximize window
     *
     * @return driver
     */
    @Before
    public WebDriver setUp() {
        ChromeDriverManager.getInstance().setup();
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("ignore-certifcate-errors");
        chromeOptions.addArguments("disable-infobars");
        caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        if (driver == null)
            driver = new ChromeDriver(caps);
        driver.manage().window().maximize();
        return driver;
    }

    /**
     * @param scenario Get current scenario name and its status
     *                 and quit the browser
     */
    @After
    public void tearDown(Scenario scenario) {
        System.out.println("=================================");
        System.out.println(scenario.getName() + " : Status : " + scenario.getStatus());
        System.out.println("=================================");

        if (scenario.isFailed()) {
            scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
            scenario.write("Scenario Failed");
        } else {
            scenario.write("Scenario Passed");
        }
        driver.close();
        driver.quit();
        driver = null;
    }


}

