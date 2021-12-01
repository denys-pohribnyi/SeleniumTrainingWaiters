package webDriverUniversity;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriveruniversityStartPage {
    private final WebDriver driver;

    public WebdriveruniversityStartPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By toDoField = By.xpath("//input[@placeholder='Add new todo']");
    private final By toDoPracticeMagic = By.xpath("//li[normalize-space()='Practice magic']");
    private final By toDoBuyNewRobes = By.xpath("//li[normalize-space()='Buy new robes']");
    private final By toDoBuyNewRobesDelete = By.xpath("//li[normalize-space()='Buy new robes']//i[@class='fa fa-trash']");


    public void hoverToElement(WebElement element) {
        Actions hover = new Actions(driver);
        hover.moveToElement(element).build().perform();
    }

    public WebdriveruniversityStartPage fillFirstToDo(String toDo) {
        driver.findElement(toDoField).sendKeys(toDo);
        driver.findElement(toDoField).sendKeys(Keys.ENTER);
        return this;
    }

    public WebdriveruniversityStartPage fillSecondToDo(String toDo) {
        driver.findElement(toDoField).sendKeys(toDo);
        driver.findElement(toDoField).sendKeys(Keys.ENTER);
        return this;
    }

    public WebdriveruniversityStartPage practiceMagicResolver() {
        Actions hover = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 1);
        hover.moveToElement(driver.findElement(toDoPracticeMagic), 24, 0);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(toDoPracticeMagic))).click();
        return this;
    }


    public WebdriveruniversityStartPage removeToDo() {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        hoverToElement(driver.findElement(toDoBuyNewRobes));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(toDoBuyNewRobesDelete))).click();
        return this;
    }

}
//1. Open “http://webdriveruniversity.com/To-Do-List/index.html”
//2. Add new ToDo “MAKE HOMEWORK”
//3. Add new ToDo “Practice Automation”
//4. Mark Practice magic as resolver
//5. Если получится - удалить из списка “Buy New Robes” (там нужен будет
//mouse hover)
