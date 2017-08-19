package stepdefinitions;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Hooks {

    private static WebDriver driver;

    /**
     * @return driver
     */
    public static WebDriver getDriver() {
        return driver;
    }

    /**
     * launch chrome browser and maximize window
     *
     * @param scenario Get current scenario name
     *                 open browser and maximize the window
     */
    @Before
    public void setUp(Scenario scenario) {
        System.out.println("=================================");
        System.out.println("Starting : " + scenario.getName());
        System.out.println("=================================");

        ChromeDriverManager.getInstance().setup();
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("ignore-certifcate-errors");
        chromeOptions.addArguments("disable-infobars");
        caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        driver = new ChromeDriver(caps);
        driver.manage().window().maximize();
    }

    /**
     * @param scenario Get current scenario name and status
     *                 and quit the browser
     */
    @After
    public void tearDown(Scenario scenario) {
        System.out.println("=================================");
        System.out.println(scenario.getName() + " : Status : " + scenario.getStatus());
        System.out.println("=================================");

        driver.close();
        driver.quit();
    }


}

