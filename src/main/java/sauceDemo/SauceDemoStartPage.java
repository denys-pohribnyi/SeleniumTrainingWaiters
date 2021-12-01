package sauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SauceDemoStartPage {
    private final WebDriver driver;

    public SauceDemoStartPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By userNameField = By.xpath("//input[@id='user-name']");
    private final By userPasswordField = By.xpath("//input[@id='password']");
    private final By loginButton = By.xpath("//input[@id='login-button']");

    public SauceDemoStartPage enterUserName(String username) {
        driver.findElement(userNameField).sendKeys(username);
        return this;
    }

    public SauceDemoStartPage enterUserPassword(String userPass) {
        driver.findElement(userPasswordField).sendKeys(userPass);
        return this;
    }

    public SauceDemoInventoryPage loginAction() {
        driver.findElement(loginButton).click();
        return new SauceDemoInventoryPage(driver);
    }
}
//1. Open “https://www.saucedemo.com/“
//2. Login with standard_user
//3. Add to cart first 4 products
//4. Navigate to cart
//5. Tap Checkout
//6. Fill user data (First Name / Last Name / Zip)
//7. Tap Continue
//8. Tap Finish
//9. Tap Back To Home