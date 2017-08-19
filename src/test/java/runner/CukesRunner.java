package runner;


import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;


@CucumberOptions(features = {"src/test/java/features"},
        glue = {"stepdefinitions"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:", "pretty"},
        tags = {"@DataTable"}
)
public class CukesRunner extends AbstractTestNGCucumberTests {

    /**
     * Passing path for extent reports
     */
    @BeforeSuite
    public static void setup() {
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        extentProperties.setReportPath("ExtentReports/myreport.html");
    }


    /**
     * Passing additional config details to extent reports
     */
    @AfterSuite
    public static void teardown() {
        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", System.getProperty("os.name"));
        Reporter.setSystemInfo("Selenium", "3.4.0");
        Reporter.setSystemInfo("Cucumber", "1.2.5");
    }

}

