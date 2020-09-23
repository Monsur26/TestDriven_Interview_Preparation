package home;

import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import static webelements.HomePageWebElements.*;

public class HomePage extends WebAPI {
    @FindBy(xpath=draggableMenu) public WebElement dragMenu;
    @FindBy(id=dragItem) public WebElement draggableItem;
    @FindBy(xpath=datePickerS) public WebElement dateSelect;

    public void dragMenuClick(){
        dragMenu.click();
    }
    public void dragItem(){
        dragAndDropByPixel(draggableItem,2,3);
    }

    public void DragNDrop(){
        dragMenuClick();
        implicitWait(5);
        dragItem();
    }
    public void datePicker() throws InterruptedException {
        driver.navigate().to("http://demo.guru99.com/test/");
        dateSelect.sendKeys("09102020");
        sleepFor(2);
        dateSelect.sendKeys(Keys.TAB);
        dateSelect.sendKeys("1153PM");
    }
    public void refreshCurrentWindow(){
        //method 1
        driver.get(driver.getCurrentUrl());
        //method 2
        driver.navigate().to(driver.getCurrentUrl());
        //method 3
        dragMenu.sendKeys(Keys.F5);
        //method 4
        dragMenu.sendKeys("\\uE035");
    }
    public void adBlocker(){
        ChromeOptions options=new ChromeOptions();
        options.addExtensions(new File("C:\\crx\\extension_4_20_0_0.crx"));
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY,options);
        options.merge(capabilities);
        ChromeDriver driver1=new ChromeDriver(options);
        driver1.get("http://demo.guru99.com/test/simple_context_menu.html");
        driver1.manage().window().maximize();
        driver1.close();
    }
    public void incognitoMode(){
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--incognito");
        DesiredCapabilities capabilities=new DesiredCapabilities(options);
        capabilities.setCapability(ChromeOptions.CAPABILITY,options);
        options.merge(capabilities);
        ChromeDriver d=new ChromeDriver(options);
        d.get("http://demo.guru99.com/test/simple_context_menu.html");
        d.manage().window().maximize();
        d.quit();
    }
    public void headlessBrowser(){
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--headless");
        DesiredCapabilities capabilities=new DesiredCapabilities(options);
        capabilities.setCapability(ChromeOptions.CAPABILITY,options);
        options.merge(capabilities);
        ChromeDriver div=new ChromeDriver(options);
        div.get("https://jqueryui.com/");
        String title=div.getTitle();
        System.out.println(title);
        div.quit();
    }
    public void allOrBrokenLinks(){
        String homepage="http://www.zlti.com";
        String url="";
        HttpURLConnection hcon=null;
        int responseCode=200;
        driver.get(homepage);
        List<WebElement> links=driver.findElements(By.tagName("a"));
        Iterator <WebElement> it=links.iterator();
        while (it.hasNext()){
            url=it.next().getAttribute("href");
            System.out.println(url);
        }
        if (url==null || url.isEmpty()){
            System.out.println("url not configured with tag or is empty");

        }
        if (!url.startsWith(homepage)){
            System.out.println("url belongs to another domain");
        }
        try{
            hcon=(HttpURLConnection)(new URL(url).openConnection());
            hcon.setRequestMethod("HEAD");
            hcon.connect();
            responseCode=hcon.getResponseCode();
            if (responseCode >= 400){
                System.out.println(url+"is a broken link");
            } else {
                System.out.println(url+" is a valid link");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void robotClass() throws AWTException, InterruptedException {
        driver.get("https://spreadsheetpage.com/chart/sales/");
        driver.findElement(By.xpath("//a[contains(text(),'Download this template for free')]")).click();
        implicitWait(5);
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(5);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(5);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(5);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(5);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(5);
    }
    public void robotMouseEvent() throws AWTException, InterruptedException {
        driver.get("http://dummy.restapiexample.com/");
        Robot robot=new Robot();
        robot.mouseMove(600,400);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(2);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(2);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
    }
}
