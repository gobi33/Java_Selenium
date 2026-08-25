package pagesMakemytrip;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectPlaces {
     WebDriver driver;
     WebDriverWait wait;
     public SelectPlaces(WebDriver driver){
    this.driver=driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
     }

     public void fromandto(){
        WebElement from =wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(
            By.xpath("//input[@placeholder='Leaving From']"))));
            from.click();
            from.clear();
            from.sendKeys("Erode");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Erode')]"))).click();

        
        WebElement to=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@placeholder='Going To']"))));
         to.click();
         to.clear();
        to.sendKeys("coimbatore");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Coimbatore')]"))).click();
       
        WebElement Date=driver.findElement(By.xpath("//input[@placeholder='Onward Journey Date']"));
        Date.click();
        String date = "20";
        driver.findElement(By.xpath("//*[text()='" + date + "']")).click();
     }
     public void search(){
        driver.findElement(By.xpath("//*[@id='search-button']/a/span[2]")).click();
     }
}