package demoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DemoQAStartPage {
   private final WebDriver driver;

    public DemoQAStartPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By userNameField = By.xpath("//input[@id='userName']");
    private final By userPasswordField = By.xpath("//input[@id='password']");
    private final By loginButton = By.xpath("//button[@id='login']");



    public DemoQAProfilePage loginAction(String login, String password) {
        driver.findElement(userNameField).sendKeys(login);
        driver.findElement(userPasswordField).sendKeys(password);
        driver.findElement(loginButton).click();
        return new DemoQAProfilePage(driver);
    }
}
// private final By typeOfUserForLogin = By.xpath("//button[normalize-space()='Customer Login']");
//A)
//1. Open “https://demoqa.com/login”
//2. Login (create your own user before)
//3. Go to Book Store (Here you can catch ElementClickIntercepted Exception, to
//avoid this use scroll or click using JavaScriptExecutor)
//4. Choose Git Pocket Guide
//5. Click “Add to your Collection”
//6. Handle alert similar as from last lesson (Tap Ok)
//7. Click Back To Store
//8. Click "You Don’t Know JS”
//9. “Add to your Collection”
//10.Handle Alert
//11. Go to “Profile”
//12.Click “Delete All Books"