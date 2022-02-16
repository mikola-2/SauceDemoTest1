package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import pages.SauceLabsPage;
import java.util.concurrent.TimeUnit;

@Log4j2
@Listeners(TestListener.class)
public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    SauceLabsPage sauceLabsPage;

    @Parameters({"browser"}) //параметр из файла regression_multi_browser.xml (для запуска тестов в нескольких браузерах параллельно)
    @BeforeMethod(description = "Setup and start browser")
    public void setup(@Optional("chrome") String browser, ITestContext context) {
        log.info("Setup settings");
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new ChromeDriver();
                break;
        }
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        context.setAttribute("driver", driver);
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        sauceLabsPage = new SauceLabsPage(driver);
    }

    @AfterMethod(alwaysRun = true, description="Close browser")
    public void tearDown() {
        log.info("Close browser");
        driver.quit();
    }
}
