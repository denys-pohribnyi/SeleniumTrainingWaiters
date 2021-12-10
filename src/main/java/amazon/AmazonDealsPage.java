package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonDealsPage {
    private final WebDriver driver;

    public AmazonDealsPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By firstItem = By.xpath("//*[@id=\"slot-5\"]/div/div/div[2]/div[3]/div/div");
    private final By firstItemSpec1 = By.xpath("//*[@id=\"octopus-dlp-asin-stream\"]/ul/li");
    private final By openCartButton = By.xpath("//*[@id=\"nav-cart\"]");
    private final By addToCartButton = By.xpath("//input[@id='add-to-cart-button']");
    private final By proceedToCheckoutButton = By.xpath("//*[@id=\"sc-buy-box-ptc-button\"]/span/input");

    public AmazonDealsPage addItem() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(firstItem));
        wait.until(ExpectedConditions.elementToBeClickable(firstItem)).click();
        //driver.findElement(firstItem).click();
        return this;
    }

    public AmazonDealsPage chooseItem1() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(firstItemSpec1)).click();
        //driver.findElement(firstItemSpec1).click();
        return this;
    }

    public AmazonDealsPage addingToCart() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
        //driver.findElement(addToCartButton).click();
        return this;
    }

    public AmazonDealsPage openCartPage(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(openCartButton)).click();
        return this;
    }
    public AmazonDealsPage proceedCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton)).click();
        //driver.findElement(proceedToCheckoutButton).click();
        return this;
    }

}