package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class AmazonDealsPage {
    private final WebDriver driver;

    public AmazonDealsPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By firstItem = By.xpath("//img[@alt='Up to 64% off OtterBox Products']");
    private final By firstItemSpec1 = By.xpath("//*[contains(text(),'iPhone 12')]");
    private final By firstItemSpec2 = By.xpath("//span[contains(text(),'OTTERBOX COMMUTER SERIES Case for iPhone 12 & iPho')]");
    private final By addToCartButton = By.xpath("//input[@id='add-to-cart-button']");
    private final By proceedToCheckoutButton = By.xpath("//*[@id=\"hlb-ptc-btn-native\"]");

    public AmazonDealsPage addItem() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(firstItem));
        driver.findElement(firstItem).click();
        return this;
    }

    public AmazonDealsPage chooseItem1() {
        driver.findElement(firstItemSpec1).click();
        return this;
    }

    public AmazonDealsPage chooseItem2() {
        driver.findElement(firstItemSpec2).click();
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