package sauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SauceDemoCheckoutStep1Page {
    private final WebDriver driver;

    public SauceDemoCheckoutStep1Page(WebDriver driver) {
        this.driver = driver;
    }

    private final By firstNameField = By.xpath("//input[@id='first-name']");
    private final By lastNameFIeld = By.xpath("//input[@id='last-name']");
    private final By zipCodeField = By.xpath("//input[@id='postal-code']");
    private final By continueButton = By.xpath("//input[@id='continue']");

    public SauceDemoCheckoutStep1Page fillingFormName(String userName) {
        driver.findElement(firstNameField).sendKeys(userName);
        return this;
    }

    public SauceDemoCheckoutStep1Page fillingFormLastName(String userLastName) {
        driver.findElement(lastNameFIeld).sendKeys(userLastName);
        return this;
    }

    public SauceDemoCheckoutStep1Page fillingFormZipCode(String zipCode) {
        driver.findElement(zipCodeField).sendKeys(zipCode);
        return this;
    }

    public SauceDemoCheckoutStep2Page proceedingCheckout() {
        driver.findElement(continueButton).click();
        return new SauceDemoCheckoutStep2Page(driver);
    }
}
