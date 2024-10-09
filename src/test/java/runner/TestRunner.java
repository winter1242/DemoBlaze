package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = "steps")
public class TestRunner {
    @AfterClass
    public static void cleanDriver() {
        //BasePage.closeBrowser();
    }
}
