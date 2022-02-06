package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class SauceLabsPage extends BasePage {
    public SauceLabsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open site")
    public void open() {
        log.info("Open site");
        driver.get("https://saucelabs.com/");
    }

    @Step("Check if picture SauseLabs is displayed")
    public boolean pictureSauceLabsIsDisplayed() {
        log.info("Check if picture SauseLabs is displayed");
        return driver.findElement(By.xpath("//div[@class='nav-image']")).isDisplayed();

    }

}
