package runner;


import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;


/**
 * Runs all scenarios with tags as "@DataTable" on it and logs failed tests in target/rerun.txt
 * Then those failed tests can be run by running ReRunner
 */
@CucumberOptions(features = {"src/test/java/features"},
        glue = {"stepdefinitions"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:", "rerun:target/rerun.txt", "pretty"},
        tags = {"@POJODataTable"},
        snippets = SnippetType.UNDERSCORE,
        dryRun = false,
        strict = false
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
        Reporter.loadXMLConfig(new File("src/main/resources/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", System.getProperty("os.name"));
        Reporter.setSystemInfo("Selenium", "3.4.0");
        Reporter.setSystemInfo("Cucumber", "1.2.5");
    }

}

/*
 *
 * AND operator - runs scenarios with both tags present
 * tags = {"sanity", "@smoke"}
 *
 * OR operator - runs scenarios with either of tags present
 * tags = {"@sanity, @smoke"}
 *
 * NEGATION operator - excludes tags with ~ sign
 * tags = {~@sanity}
 *
 * dryRun - true checks if all stepdefinitions are defined and wont run actual tests
 *
 * strict - false means that undefined steps are skipped. Test does not fail
 *
 */

