package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Log4j2
public class ProductsCriticalPathTest extends BaseTest {
    @Test (description = "Add product to cart.")
    public void productShouldBeAddedIntoCart() {
        log.info("Add product to cart.");
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addToCart("Sauce Labs Bike Light");
        String priceByName = inventoryPage.getPriceByNameFromInventory("Sauce Labs Bike Light");
        cartPage.open();
        assertEquals(cartPage.getPriceOfProductFromCart(),
                priceByName,
                "The price of the product did not match");
        assertEquals(cartPage.getNameFromCart(),
                "Sauce Labs Bike Light",
                "The name of the product did not match");

    }


}
