package sauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SauceDemoCheckoutStep2Page {
    private final WebDriver driver;

    public SauceDemoCheckoutStep2Page(WebDriver driver) {
        this.driver = driver;
    }

    private final By finishButton = By.xpath("//button[@id='finish']");

    public SauceDemoCheckoutCompletePage completePurchase() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(finishButton));
        driver.findElement(finishButton).click();
        return new SauceDemoCheckoutCompletePage(driver);
    }

}
//scroll to finish button
//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(product4));