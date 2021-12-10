package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonStartPage {
    private final WebDriver driver;
    public AmazonStartPage(WebDriver driver){
        this.driver = driver;
    }

    private final By dealsLink = By.xpath("//*[@id=\"nav-xshop\"]/a[1]");

    public AmazonDealsPage openTodaysDealsPage(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(dealsLink)).click();
        //driver.findElement(dealsLink).click();
        return new AmazonDealsPage(driver);
    }
}
