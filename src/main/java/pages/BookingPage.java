package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.nio.file.WatchEvent;
import java.util.*;
import utils.*;

public class BookingPage {
     WebDriver driver;

    public BookingPage(WebDriver driver){
        this.driver=driver;
    }
    public void selectplace(String from,String to){
         

       WebElement FromCity= WaitUtil.WebForElement(driver,By.xpath("//input[@placeholder='Leaving From']"));
       FromCity.click();
       FromCity.clear();
       FromCity.sendKeys(from);
       WaitUtil.WebForElement(driver,By.xpath("//*[contains(text(),'"+from+"')]")).click();

       WebElement ToCity= WaitUtil.WebForElement(driver,By.xpath("//input[@placeholder='Going To']"));
       ToCity.click();
       ToCity.clear();
       ToCity.sendKeys(to);
       WaitUtil.WebForElement(driver,By.xpath("//*[contains(text(),'"+to+"')]")).click();
    }
    public void selectdate(){
        WaitUtil.WebForElement(driver,By.xpath("//input[@placeholder='Onward Journey Date']")).click();
        WaitUtil.WebForElement(driver,By.xpath("//*[text()='11']")).click();
        WaitUtil.WebForElement(driver,By.xpath("//*[@id='search-button']/a/span[2]")).click();
    }
    public String bookticket(){
       String TravelsName= WaitUtil.WebForElement(driver,By.xpath("(//span[@class='title'])[1]")).getText();
       return TravelsName;
    }
    public void selectflight(){
        driver.navigate().back();
        WebElement flight=WaitUtil.WebForElement(driver,By.xpath("//span[text()='Flights']"));
        String parentWindow=driver.getWindowHandle();
        Actions action=new Actions(driver);
        action.keyDown(Keys.CONTROL).click(flight).keyUp(Keys.CONTROL).perform();
        Set<String>windows=driver.getWindowHandles(); 
        System.out.println("Window Count: " + windows.size());
        for(String window:windows){
            if(!window.equals(parentWindow)){
               driver.switchTo().window(window);
               System.out.println(driver.getCurrentUrl());
               break;
            }
        }  
    }
    public void select_flightplace(String source, String destination){

        String proof=WaitUtil.WebForElement(driver, By.xpath("//h1[@class='body-lg text-primary']")).getText();
        System.out.println("Need to fill the details  "+ proof);
       WaitUtil.WebForElement(driver, By.xpath("//p[@data-testid='originId']")).click();
       WaitUtil.WebForElement(driver, By.xpath("//*[local-name()='svg' and @data-testid='CloseIcon']")).click();
       WaitUtil.WebForElement(driver, By.xpath("//label[contains(text(),'From')]/following-sibling::input")).sendKeys(source);
       WaitUtil.WebForElement(driver,By.xpath("(//span[contains(text(),'"+source+"')])[1]")).click();
       WaitUtil.WebForElement(driver, By.xpath("//label[contains(text(),'To')]/following-sibling::input")).sendKeys(destination);
       WaitUtil.WebForElement(driver, By.xpath("//span[contains(text(),'"+destination+"')]")).click();
       WaitUtil.ClickForElement(driver,By.xpath("//*[text()='10']")).click();

    }
    public void flight_details(){
        System.out.println("Need to complete the details");
        WaitUtil.WebForElement(driver,By.xpath("//button[text()='Done']")).click();
         WaitUtil.WebForElement(driver,By.xpath("//button[text()='Search']")).click();
    }
    public void book_ticket(){
        System.out.println("Ticket booking completed ");
    }
}
