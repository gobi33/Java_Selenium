package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.*;

public class BookingPage {
     WebDriver driver;

    public BookingPage(WebDriver driver){
        this.driver=driver;
    }
    public void selectplace(String from,String to){
       WebElement FromCity= WaitUtil.WebForElement(driver,By.xpath("//input[@placeholder='Leaving From']"));
       FromCity.click();
       FromCity.sendKeys(from);
       WaitUtil.WebForElement(driver,By.xpath("//*[contains(text(),'Erode')]")).click();

       WebElement ToCity= WaitUtil.WebForElement(driver,By.xpath("//input[@placeholder='Going To']"));
       ToCity.click();
       ToCity.clear();
       ToCity.sendKeys(to);
       WaitUtil.WebForElement(driver,By.xpath("//*[contains(text(),'Coimbatore')]")).click();
    }
    public void selectdate(){
        WaitUtil.WebForElement(driver,By.xpath("//input[@placeholder='Onward Journey Date']")).click();
        WaitUtil.WebForElement(driver,By.xpath("//*[text()='25']")).click();
        WaitUtil.WebForElement(driver,By.xpath("//*[@id='search-button']/a/span[2]")).click();
    }
    public String bookticket(){
       String TravelsName= WaitUtil.WebForElement(driver,By.xpath("(//span[@class='title'])[1]")).getText();
       return TravelsName;
    }
}
