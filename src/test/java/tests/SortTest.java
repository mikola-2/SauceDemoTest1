package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Log4j2
public class SortTest extends BaseTest {
    @Test (description = "Checking sorting by product name.")
    public void checkSortByName() {
        log.info("Checking sorting by product name.");
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.sortByName();
        assertEquals(inventoryPage.getFirstName(), "Test.allTheThings() T-Shirt (Red)",
                "Sorting is not performed correctly");

    }
    @Test (description = "Checking sorting by price name.")
    public void checkSortByPrice() {
        log.info("Checking sorting by price name.");
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.sortByPrice();
        assertEquals(inventoryPage.GetPrice(),
                "$7.99",
                "Sorting is not performed correctly");

    }

}
