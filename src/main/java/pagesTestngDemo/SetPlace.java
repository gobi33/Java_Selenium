package pagesTestngDemo;

import java.rmi.server.ExportException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SetPlace {
    WebDriver driver;
    WebDriverWait wait;
    public SetPlace(WebDriver driver){
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        this.driver=driver;
    }
    public void fromPlace(String fromcity){
    
    // Click current city
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@data-testid='originId']"))).click();

    // Type in the search input that appear
        WebElement cityInput =wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//input[@class='outline-none w-full bg-transparent placeholder:text-disabled pt-3 focus:caret-selection text-primary placeholder:opacity-0 focus:placeholder:opacity-100 font-medium text-lg !pt-5']")));

        cityInput.sendKeys(fromcity);

        // Select city
         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class,'text-primary text-sm')and text()='BLR']")))
        .click();

    }
    public void ToCity(String ToCity){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='absolute top-20' and text()='To']"))).click();

     WebElement TocityInput =wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@class='outline-none w-full bg-transparent placeholder:text-disabled pt-3 focus:caret-selection text-primary placeholder:opacity-0 focus:placeholder:opacity-100 font-medium text-lg !pt-5']")));
                TocityInput.sendKeys(ToCity);  
             
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class,'text-primary text-sm')and text()='CCU']")))
        .click();

     }
        
    
}
