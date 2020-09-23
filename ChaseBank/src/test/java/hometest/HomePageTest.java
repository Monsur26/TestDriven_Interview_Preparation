package hometest;

import common.WebAPI;
import home.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class HomePageTest extends WebAPI {
    static HomePage homePage;
    public static void getInitElements(){
        homePage= PageFactory.initElements(driver,HomePage.class);
    }
   /* @Test(priority = 1)
    public void testOfMenuOptions(){
        getInitElements();
        homePage.testOfMenuOption();
    }*/
   /* @Test(priority = 2)
    public void testFacebookTultip(){
        getInitElements();
        homePage.FaceBookTultip();
        homePage.assertFB();
    }*/
    @Test(priority = 3)
    public void testChaseIconImage(){
        getInitElements();
        homePage.chaseIcon();
    }

}
