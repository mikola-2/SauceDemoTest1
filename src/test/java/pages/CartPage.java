package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CartPage extends BasePage {
    public static final String SAVE_PRICE_IN_CART = "//div[@class=\"inventory_item_price\"]";
    public static final String SAVE_NAME_PRODUCT = "//a[div[@class=\"inventory_item_name\"]]/div";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open site")
    public void open() {
        log.info("Open site");
        driver.get("https://www.saucedemo.com/cart.html");

    }

    @Step("Get price of product from shopping cart")
    public String getPriceOfProductFromCart() {
        log.debug("Get price of product from shopping cart");
        return driver.findElement(By.xpath(SAVE_PRICE_IN_CART)).getText();
    }

    @Step("Get name of product from shopping cart")
    public String getNameFromCart() {
        log.debug("Get name of product from shopping cart");
        return driver.findElement(By.xpath(SAVE_NAME_PRODUCT)).getText();

    }

}
