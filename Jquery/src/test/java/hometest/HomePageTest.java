package hometest;

import common.WebAPI;
import home.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.awt.*;

public class HomePageTest extends WebAPI {
    static HomePage homePage;
    public static void initElements(){
        homePage=PageFactory.initElements(driver,HomePage.class);
    }
    /*@Test(priority = 1)
    public void testDragNDropByPixel(){
        initElements();
        homePage.DragNDrop();
    }*/
   /* @Test(priority = 2)
    public void testDatePicker() throws InterruptedException {
        initElements();
        homePage.datePicker();
    }*/
   /* @Test(priority = 3)
    public void testRefresh() {
        initElements();
        homePage.refreshCurrentWindow();
    }*/
   /* @Test(priority = 4)
    public void testadBlocker() {
        initElements();
        homePage.adBlocker();
    }*/
   /* @Test(priority = 5)
    public void testIncognito() {
        initElements();
        homePage.incognitoMode();
    }*/
   /* @Test(priority = 6)
    public void testHeadlessBrowser() {
        initElements();
        homePage.headlessBrowser();
    }*/
   /* @Test(priority = 6)
    public void testAllOrBrokenLinks() {
        initElements();
        homePage.allOrBrokenLinks();
    }*/
    /*@Test(priority = 7)
    public void testRobotClass() throws AWTException, InterruptedException {
        initElements();
        homePage.robotClass(); ;
    }*/
    @Test(priority = 8)
    public void testRobotClassMouse() throws AWTException, InterruptedException {
        initElements();
        homePage.robotMouseEvent();
    }

}
