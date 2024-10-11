package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {
    protected static WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    private Alert alert;

    static {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public static void navigateTo(String url) {
        driver.get(url);
    }

    private WebElement Find(String locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    private List<WebElement> Finds(String locator) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        return driver.findElements(By.xpath(locator));
    }

    protected void clickElement(String locator) {
        Find(locator).click();
    }

    public static void closeBrowser() {
        driver.quit();
    }

    public void write(String locator, String texto) {
        //Find(locator).clear();
        Find(locator).sendKeys(texto);
    }

    protected String getText(String locator) {
        return Find(locator).getText();
    }

    protected void aceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        alert.accept();
        driver.switchTo().defaultContent();
    }

    protected List<String> getTextElements(String locator) {
        List<String> listNombres = new ArrayList<>();
        for (var nombres : Finds(locator)) {
            listNombres.add(nombres.getText());
        }
        return listNombres;
    }
}
