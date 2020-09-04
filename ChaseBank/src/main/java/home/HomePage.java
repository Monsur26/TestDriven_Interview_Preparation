package home;

import common.WebAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static webelements.HomePageWebElements.*;

public class HomePage extends WebAPI {
    @FindBy(how = How.ID, using = sideMenu)  public WebElement menu;

    public void menuClicking(){
        menu.click();
    }
    public void menuText(){
        menu.getText();
    }

    public void testOfMenuOption(){
        menuClicking();
        menuText();

    }
}
