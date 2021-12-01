import amazon.AmazonDealsPage;
import amazon.AmazonStartPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TaskD extends BaseTest {
    AmazonStartPage amazonStartPage;
    AmazonDealsPage amazonDealsPage;

    @BeforeMethod
    public void setUp() {
        amazonStartPage = new AmazonStartPage(getDriver());
        amazonDealsPage = new AmazonDealsPage(getDriver());
    }

    @Test
    public void amazonTest() {
        openURL(Props.getProperty("amazonURL"));
        amazonStartPage.openTodaysDealsPage();
        amazonDealsPage
                .addItem()
                .chooseItem1()
                .chooseItem2()
                .addingToCart()
                .proceedCheckout();
    }
}
//D)
//1. Open Amazon.com
//2. Click Today’s Deals
//3. Choose First Product
//4. Click Add To Cart
//5. Click Proceed To Checkout