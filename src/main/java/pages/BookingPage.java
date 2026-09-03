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
     private By bus_leaving_from = By.xpath("//input[@placeholder='Leaving From']");
     private By bus_going_to = By.xpath("//input[@placeholder='Going To']");
     private By onward_journey_date = By.xpath("//input[@placeholder='Onward Journey Date']");
     private By date_select = By.xpath("//*[text()='11']");
     private By search_button = By.xpath("//*[@id='search-button']/a/span[2]");
     private By book_ticket_button = By.xpath("(//span[@class='title'])[1]");
     private By flight_button=By.xpath("//span[contains(text(),'Flight')]");
     private By flight_proof=By.xpath("//h1[@class='body-lg text-primary']");
     private By flight_from=By.xpath("//p[@data-testid='originId']");
     private By fight_from_clear=By.xpath("//*[local-name()='svg' and @data-testid='CloseIcon']");
     private By flight_from_sendkeys=By.xpath("//label[contains(text(),'From')]/following-sibling::input");
     private By flight_to_sendkeys=By.xpath("//label[contains(text(),'To')]/following-sibling::input");
     private By fight_date=By.xpath("//*[text()='10']");
     private By flight_details_done=By.xpath("//button[text()='Done']");
     private By flight_details_search=By.xpath("//button[text()='Search']");

     public By bus_from_city_click(String city){
         return By.xpath("//*[contains(text(),'"+city+"')]");
     }

    public BookingPage(WebDriver driver){
        this.driver=driver;
    }
    public void selectplace(String from,String to){
       WebElement FromCity= WaitUtil.WebForElement(driver,bus_leaving_from);
       FromCity.click();
       FromCity.clear();
       FromCity.sendKeys(from);
       WaitUtil.WebForElement(driver,bus_from_city_click(from)).click();

       WebElement ToCity= WaitUtil.WebForElement(driver,bus_going_to);
       ToCity.click();
       ToCity.clear();
       ToCity.sendKeys(to);
       WaitUtil.WebForElement(driver,bus_from_city_click(to)).click();
    }
    public void selectdate(){
        WaitUtil.WebForElement(driver,onward_journey_date).click();
        WaitUtil.WebForElement(driver,date_select).click();
        WaitUtil.WebForElement(driver,search_button).click();
    }
    public String bookticket(){
       String TravelsName= WaitUtil.WebForElement(driver,book_ticket_button).getText();
       return TravelsName;
    }
    public void selectflight(){
        driver.navigate().back();
        WebElement flight=WaitUtil.WebForElement(driver,flight_button);
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

        String proof=WaitUtil.WebForElement(driver, flight_proof).getText();
        System.out.println("Need to fill the details  "+ proof);
       WaitUtil.WebForElement(driver, flight_from).click();
       WaitUtil.WebForElement(driver, fight_from_clear).click();
       WaitUtil.WebForElement(driver, flight_from_sendkeys).sendKeys(source);
       WaitUtil.WebForElement(driver,By.xpath("(//span[contains(text(),'"+source+"')])[1]")).click();
       WaitUtil.WebForElement(driver, flight_to_sendkeys).sendKeys(destination);
       WaitUtil.WebForElement(driver, bus_from_city_click(destination)).click();
       WaitUtil.ClickForElement(driver, fight_date).click();

    }
    public void flight_details(){
        System.out.println("Need to complete the details");
        WaitUtil.WebForElement(driver,flight_details_done).click();
        WaitUtil.WebForElement(driver,flight_details_search).click();
    }
    public void book_ticket(){
        System.out.println("Ticket booking completed ");
    }
}
