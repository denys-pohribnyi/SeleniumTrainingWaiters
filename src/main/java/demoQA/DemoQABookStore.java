package demoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DemoQABookStore {
    private final WebDriver driver;

    public DemoQABookStore(WebDriver driver) {
        this.driver = driver;
    }

    private final By firstBookInTheList = By.xpath("//*[contains (text(),'Git Pocket Guide')]");
    private final By addBookButton = By.xpath("//*[contains (text(),'Add To Your Collection')]");
    private final By backToStoreButton = By.xpath("//*[contains (text(),'Back To Book Store')]");
    private final By secondBookInTheList = By.xpath("//*[contains (text(),'Know JS')]");
    private final By searchField = By.xpath("//*[@id=\"searchBox\"]");
    private final By modalAlert = By.xpath("//*[@id=\"closeSmallModal-ok\"]");
    private final By deleteAllBooks = By.xpath("//*[contains (text(),'Delete All Books')]");

    public DemoQABookStore addingFirstBook() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.findElement(searchField).sendKeys("Git");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(firstBookInTheList)));
        driver.findElement(firstBookInTheList).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(addBookButton));
        driver.findElement(addBookButton).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        driver.findElement(backToStoreButton).click();
        return this;
    }

    public DemoQABookStore addingSecondBook() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.findElement(searchField).sendKeys("Know JS");
        driver.findElement(secondBookInTheList).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(addBookButton));
        driver.findElement(addBookButton).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        driver.findElement(backToStoreButton).click();
        return this;
    }

    public DemoQABookStore addedBooksArePresent() {
        driver.get("https://demoqa.com/profile");
        Assert.assertTrue(driver.findElement(firstBookInTheList).isDisplayed());
        Assert.assertTrue(driver.findElement(secondBookInTheList).isDisplayed());
        return this;
    }

    public DemoQAProfilePage deleteBooks() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(deleteAllBooks));
        driver.findElement(deleteAllBooks).click();
        driver.findElement(modalAlert).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        return new DemoQAProfilePage(driver);
    }
}
