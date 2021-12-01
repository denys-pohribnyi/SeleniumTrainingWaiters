import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sauceDemo.*;

public class TaskB extends BaseTest {
    SauceDemoStartPage sauceDemoStartPage;
    SauceDemoInventoryPage sauceDemoInventoryPage;
    SauceDemoCartPage sauceDemoCartPage;
    SauceDemoCheckoutStep1Page sauceDemoCheckoutStep1Page;
    SauceDemoCheckoutStep2Page sauceDemoCheckoutStep2Page;
    SauceDemoCheckoutCompletePage sauceDemoCheckoutCompletePage;

    @BeforeMethod
    public void setUp() {
        sauceDemoStartPage = new SauceDemoStartPage(getDriver());
        sauceDemoInventoryPage = new SauceDemoInventoryPage(getDriver());
        sauceDemoCartPage = new SauceDemoCartPage(getDriver());
        sauceDemoCheckoutStep1Page = new SauceDemoCheckoutStep1Page(getDriver());
        sauceDemoCheckoutStep2Page = new SauceDemoCheckoutStep2Page(getDriver());
        sauceDemoCheckoutCompletePage = new SauceDemoCheckoutCompletePage(getDriver());
    }

    @Test
    public void sauceTest() {
        openURL(Props.getProperty("saucedemoURL"));
        sauceDemoStartPage
                .enterUserName(Props.getProperty("sauceLogin"))
                .enterUserPassword(Props.getProperty("saucePassword"))
                .loginAction();
        sauceDemoInventoryPage
                .addingToCard4Items()
                .openCartPage();
        sauceDemoCartPage.checkoutStep1();
        sauceDemoCheckoutStep1Page
                .fillingFormName(Props.getProperty("sauceUserFirstName"))
                .fillingFormLastName(Props.getProperty("sauceUserLastName"))
                .fillingFormZipCode(Props.getProperty("sauceZip"))
                .proceedingCheckout();
        sauceDemoCheckoutStep2Page.completePurchase();
        sauceDemoCheckoutCompletePage.backToInventoryPage();
        sauceDemoInventoryPage.finish();
    }

}
//1. Open “https://www.saucedemo.com/“
//2. Login with standard_user
//3. Add to cart first 4 products
//4. Navigate to cart
//5. Tap Checkout
//6. Fill user data (First Name / Last Name / Zip)
//7. Tap Continue
//8. Tap Finish
//9. Tap Back To Home