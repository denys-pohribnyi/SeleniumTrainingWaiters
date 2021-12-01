import demoQA.DemoQABookStore;
import demoQA.DemoQAProfilePage;
import demoQA.DemoQAStartPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TaskA extends BaseTest {
    private DemoQAStartPage demoqaStartPage;
    private DemoQAProfilePage demoQAProfilePage;
    private DemoQABookStore demoQABookStore;

    @BeforeMethod
    public void setUp() {
        demoqaStartPage = new DemoQAStartPage(getDriver());
        demoQAProfilePage = new DemoQAProfilePage(getDriver());
        demoQABookStore = new DemoQABookStore(getDriver());
    }

    @Test
    public void login(){
        openURL(Props.getProperty("demoqaURL"));
        demoqaStartPage.loginAction(Props.getProperty("demoqaLogin"), Props.getProperty("demoQAPassword"));
        demoQAProfilePage
                .checkSuccessEntrance()
                .openBookStore();
        demoQABookStore
                .addingFirstBook()
                .addingSecondBook()
                .addedBooksArePresent()
                .deleteBooks();
    }
}