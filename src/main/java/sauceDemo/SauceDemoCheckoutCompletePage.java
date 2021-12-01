package sauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SauceDemoCheckoutCompletePage {
    private final WebDriver driver;

    public SauceDemoCheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By bachHomeButton = By.xpath("//button[@id='back-to-products']");

    public SauceDemoInventoryPage backToInventoryPage() {
        driver.findElement(bachHomeButton).click();
        return new SauceDemoInventoryPage(driver);
    }

}
