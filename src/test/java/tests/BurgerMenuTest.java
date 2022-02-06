package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import utils.AllureUtils;

import static org.testng.Assert.*;

@Log4j2
public class BurgerMenuTest extends BaseTest {
    @Test (description = "Check menu display.")
    public void isBurgerMenuDisplayed() {
        log.info("Check menu display.");
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(inventoryPage.burgerButtonIsDisplayed(), "Menu is not displayed.");
    }

    @Test (description = "Checking menu selection.")
    public void pageAboutInBurgerMenu() throws InterruptedException {
        log.info("Checking menu selection.");
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.choseMenuAbout();
        Thread.sleep(2000);
        assertTrue(sauceLabsPage.pictureSauceLabsIsDisplayed(), "The transition to the page did not occur.");
        AllureUtils.takeScreenshot(driver);
    }
}
