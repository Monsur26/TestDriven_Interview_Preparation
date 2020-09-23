package home;

import common.WebAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import static webelements.HomePageWebElements.*;

public class HomePage extends WebAPI {
    @FindBy(how = How.ID, using = sideMenu)  public WebElement menu;
    @FindBy(xpath = fbIcon)public  WebElement faceBookIcon;
    @FindBy(xpath = chaseIcon)public  WebElement chaseIconImage;

    public void menuClicking(){
        menu.click();
    }
    public void menuText(){
        menu.getText();
    }
    public void fbIconCheck(){faceBookIcon.getAttribute("title");}
    public void chaseIconCheck(){chaseIconImage.click();}

    public void assertFB(){
        String actual=faceBookIcon.getText();
        Assert.assertEquals(actual,"Facebook\n" +
                "(Opens Overlay)","Not Successful");

    }

    public void testOfMenuOption(){
        menuClicking();
        menuText();
    }
    public void FaceBookTultip(){
        fbIconCheck();
    }
    public  void chaseIcon(){
        chaseIconCheck();
        if (
        driver.getTitle().equals("chase-logo-icon")){
            System.out.println("We are back at homepage");
        } else {
            System.out.println("We are not back at homepage");
        }
    }
}
