package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LoginPage extends BasePage {

    public static final By USERNAME_INPUT = By.cssSelector("[placeholder='Username']");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON_INPUT = By.id("login-button");
    public static final By ERROR_MESSAGE = By.cssSelector(".error-message-container");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open site")
    public void open() {
        log.info("Open site");
        driver.get("https://www.saucedemo.com/");
    }

    @Step("Login as user '{userName}' use password '{password}'")
    public void login(String userName, String password) {
        log.debug("Login as user '{userName}' use password '{password}'");
        driver.findElement(USERNAME_INPUT).sendKeys(userName);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON_INPUT).click();
    }

    @Step("Getting error message")
    public String getErrorMessage() {
        log.info("Getting error message");
        return driver.findElement(ERROR_MESSAGE).getText();
    }

}
