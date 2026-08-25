package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConformOrder {
    WebDriver driver;
    WebDriverWait wait;
    public ConformOrder(WebDriver driver){
        this.driver=driver;
    }
    public void billingaddress(){
        driver.findElement(By.xpath("(//input[@type='button'])[2]")).click();
    } 
    public void shippingaddress(){

    wait =
        new WebDriverWait(driver, Duration.ofSeconds(10));

    WebElement continueBtn =
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("(//input[@type='button'])[3]")));

    continueBtn.click();

    }
    public void shippingmethod(){
    
        wait =new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement shipmethod=
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='button'])[4]")));

        shipmethod.click();
    }
    public void paymentmethod(){
        wait =new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement paymethod=
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='button'])[5]")));

        paymethod.click();
    }
    public void paymentinfo(){
       wait =new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement payinfo=
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='button'])[6]")));

        payinfo.click();
    }
    public void confirmorder(){
       wait =new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement conforder=
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='button'])[7]")));

        conforder.click();
    }
}
