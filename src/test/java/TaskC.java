import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import webDriverUniversity.WebdriveruniversityStartPage;

public class TaskC extends BaseTest {
    WebdriveruniversityStartPage webdriveruniversityStartPage;

    @BeforeMethod
    public void setUp() {
        webdriveruniversityStartPage = new WebdriveruniversityStartPage(getDriver());
    }

    @Test
    public void enteringToDo() {
        openURL(Props.getProperty("wduniversityURL"));
        webdriveruniversityStartPage
                .fillFirstToDo(Props.getProperty("addFirst"))
                .fillSecondToDo(Props.getProperty("addSecond"))
                .practiceMagicResolver()
                .removeToDo();
    }

}
//C)
//1. Open “http://webdriveruniversity.com/To-Do-List/index.html”
//2. Add new ToDo “MAKE HOMEWORK”
//3. Add new ToDo “Practice Automation”
//4. Mark Practice magic as resolver
//5. Если получится - удалить из списка “Buy New Robes” (там нужен будет
//mouse hover)