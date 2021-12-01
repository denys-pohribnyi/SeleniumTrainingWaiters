package sauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SauceDemoInventoryPage {
    private final WebDriver driver;

    public SauceDemoInventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By product1 = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    private final By product2 = By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']");
    private final By product3 = By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']");
    private final By product4 = By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']");
    private final By cartLink = By.xpath("//a[@class='shopping_cart_link']");
    private final By headerVisible = By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div");

    public SauceDemoInventoryPage finish() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(headerVisible));
        return this;
    }

    public SauceDemoInventoryPage addingToCard4Items() {
        driver.findElement(product1).click();
        driver.findElement(product2).click();
        driver.findElement(product3).click();
        driver.findElement(product4).click();
        return this;
    }

    public SauceDemoCartPage openCartPage() {
        driver.findElement(cartLink).click();
        return new SauceDemoCartPage(driver);
    }
}
