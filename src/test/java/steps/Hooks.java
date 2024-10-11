package steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.BasePage;

import java.io.ByteArrayInputStream;

public class Hooks extends BasePage {

    public Hooks() {
        super(driver);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("FailedScreenshot", new ByteArrayInputStream(screenshot));
        }
    }
}
