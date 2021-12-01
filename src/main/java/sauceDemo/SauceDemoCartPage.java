package sauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SauceDemoCartPage {
    private final WebDriver driver;

    public SauceDemoCartPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By checkoutButton = By.xpath("//*[@id=\"checkout\"]");

    public SauceDemoCheckoutStep1Page checkoutStep1() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(checkoutButton));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(checkoutButton))).click();
        return new SauceDemoCheckoutStep1Page(driver);
    }
}
