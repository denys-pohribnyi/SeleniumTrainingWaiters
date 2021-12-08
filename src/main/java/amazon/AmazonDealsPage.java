package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class AmazonDealsPage {
    private final WebDriver driver;

    public AmazonDealsPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By firstItem = By.xpath("//div[normalize-space()='Up to 16% off Samsung Watch 4 and Watch 4 Classic']");
    private final By firstItemSpec1 = By.xpath("//a[@title='Samsung Electronics Galaxy Watch 4 44mm Smartwatch with ECG Monitor Tracker for Health Fitness Running Sleep Cycles GPS Fall Detection Bluetooth US Version, Black'][contains(text(),'Samsung Electronics Galaxy Watch 4 44mm Smartwatch')]");
    //private final By firstItemSpec2 = By.xpath("");
    private final By addToCartButton = By.xpath("//input[@id='add-to-cart-button']");
    private final By proceedToCheckoutButton = By.xpath("//input[@aria-labelledby='attach-sidesheet-checkout-button-announce']");

    public AmazonDealsPage addItem() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(firstItem));
        driver.findElement(firstItem).click();
        return this;
    }

    public AmazonDealsPage chooseItem1() {
        driver.findElement(firstItemSpec1).click();
        return this;
    }

    public AmazonDealsPage addingToCart() {
        driver.findElement(addToCartButton).click();
        return this;
    }

    public AmazonDealsPage proceedCheckout() {
        driver.findElement(proceedToCheckoutButton).click();
        return this;
    }

}