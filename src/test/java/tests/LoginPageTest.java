package tests;

import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.TmsLink;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Log4j2
public class LoginPageTest extends BaseTest {

    @Link("http://google.com")
    @Issue("")
    @TmsLink("")
    @Test (description = "Input correct username and password.")
    public void inputValidData() {
        log.info("Input correct username and password.");
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(inventoryPage.isProductsDisplayed(), "Couldn't log in to the site");

    }

    @Test (description = "Input correct username and empty password.")
    public void emptyPassword() {
        log.info("Input correct username and empty password.");
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "Error message is wrong");

    }

    @Test (description = "Input empty username and correct password.")
    public void emptyUserName() {
        log.info("Input empty username and correct password.");
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Error message is wrong");
    }

    @Test (description = "Input incorrect username and password.")
    public void wrongUserNameAndPassword() {
        log.info("Input incorrect username and password.");
        loginPage.open();
        loginPage.login("fhg", "dgd");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Error message is wrong");
    }

    @Test (description = "Input blocked username and password.")
    public void lockedUser() {
        log.info("Input blocked username and password.");
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Sorry, this user has been locked out.",
                "Error message is wrong");
    }

}
