import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {
   public static WebDriver driver;
    private static final ThreadLocal<WebDriver> WEBDRIVER_CONTAINER = new ThreadLocal<WebDriver>();

    public void openURL(String url) {
        driver.get(url);
    }

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WEBDRIVER_CONTAINER.set(driver);
    }

    public static WebDriver getDriver() {
        return WEBDRIVER_CONTAINER.get();
    }

//    @AfterClass
//    public void quit() {
//
//        if (driver != null) {
//            driver.manage().deleteAllCookies();
//            driver.quit();
//            WEBDRIVER_CONTAINER.remove();
//        }
//    }
}
