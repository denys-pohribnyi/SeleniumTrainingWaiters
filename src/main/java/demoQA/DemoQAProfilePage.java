package demoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DemoQAProfilePage {
   private final WebDriver driver;

    public DemoQAProfilePage(WebDriver driver) {
        this.driver = driver;
    }
    private final By bookStorePage = By.xpath("//span[normalize-space()='Book Store']");
    private final By userName = By.xpath("//*[@id=\"userName-value\"]");


    public DemoQAProfilePage checkSuccessEntrance(){
        String name = driver.findElement(userName).getText();
        Assert.assertEquals(name,"DenysPohribnyi");
        return this;
    }
    public DemoQABookStore openBookStore(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");
        driver.findElement(bookStorePage).click();
        return new DemoQABookStore(driver);
    }
}
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
//12.Click “Delete All Books