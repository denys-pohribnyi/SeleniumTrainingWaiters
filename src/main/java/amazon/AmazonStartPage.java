package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonStartPage {
    private final WebDriver driver;
    public AmazonStartPage(WebDriver driver){
        this.driver = driver;
    }

    private final By dealsLink = By.xpath("//*[@id=\"nav-xshop\"]/a[1]");

    public AmazonDealsPage openTodaysDealsPage(){

        driver.findElement(dealsLink).click();
        return new AmazonDealsPage(driver);
    }
}
