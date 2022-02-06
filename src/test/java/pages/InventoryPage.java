package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class InventoryPage extends BasePage {

    public static final String ADD_PRODUCT_BUTTON = "//div[div[div[a[div[@class=\"inventory_item_name\"][text()=\"%s\"]]]]]//button";
    public static final String SAVE_PRICE = "//div[div[div[a[div[@class=\"inventory_item_name\" and text()=\"%s\"]]]]]/div[@class=\"inventory_item_description\"]/div[@class='pricebar']/div[@class=\"inventory_item_price\"]";
    public static final String SORT_CONTAINER = "product_sort_container";
    public static final String SAVE_NAME_FIRST_PRODUCT = "//div[@class='inventory_list']/div[1]/div[@class='inventory_item_description']/div[@class='inventory_item_label']/a/div";
    public static final String SAVE_PRICE_FIRST_PRODUCT = "//div[@class='inventory_list']/div[1]/div[@class='inventory_item_description']/div[@class='pricebar']/div";
    public static final String BURGER_MENU_BUTTON = "//div[@class=\"bm-burger-button\"]";
    public static final String BURGER_MENU_ABOUT = "//nav[@class=\"bm-item-list\"]/a[@id=\"about_sidebar_link\"]";

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        log.info("Open site");
        driver.get("https://www.saucedemo.com/inventory.html");
    }

    @Step("Check if products title is displayed")
    public boolean isProductsDisplayed() {
        log.info("Check if products title is displayed");
        return driver.findElement(By.cssSelector(".title")).isDisplayed();

    }

    @Step("Add product to cart")
    public void addToCart(String nameProduct) {
        log.info("Add product to cart");
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_BUTTON, nameProduct))).click();
    }

    @Step("Get price of product from inventory page")
    public String getPriceByNameFromInventory(String nameProduct) {
        log.debug("Get price of product from inventory page");
        return driver.findElement(By.xpath(String.format(SAVE_PRICE, nameProduct))).getText();
    }

    @Step("Click for sort by name")
    public void sortByName() {
        log.info("Click for sort by name");
        driver.findElement(By.className(SORT_CONTAINER)).click();
        driver.findElement(By.cssSelector("[value='za']")).click();
    }

    @Step("Get name of first product")
    public String getFirstName() {
        log.debug("Get name of first product");
        return driver.findElement(By.xpath(SAVE_NAME_FIRST_PRODUCT)).getText();
    }

    @Step("Click for sort by price")
    public void sortByPrice() {
        log.info("Click for sort by price");
        driver.findElement(By.className(SORT_CONTAINER)).click();
        driver.findElement(By.cssSelector("[value='lohi']")).click();
    }

    @Step("Get price of first product")
    public String GetPrice() {
        log.debug("Get price of first product");
        return driver.findElement(By.xpath(SAVE_PRICE_FIRST_PRODUCT)).getText();
    }


    @Step("Check if burger button is displayed")
    public boolean burgerButtonIsDisplayed() {
        log.info("Check if burger button is displayed");
        driver.findElement(By.xpath(BURGER_MENU_BUTTON)).isDisplayed();
        return true;
    }

    @Step("Click option 'About' in menu")
    public void choseMenuAbout() {
        log.info("Click option 'About' in menu");
        driver.findElement(By.xpath(BURGER_MENU_BUTTON)).click();
        driver.findElement(By.xpath(BURGER_MENU_ABOUT)).click();

    }
}




