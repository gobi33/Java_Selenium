package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
public class SearchProduct {

     WebDriver driver;
     public SearchProduct(WebDriver driver) {
        this.driver = driver;   
     }

     public void searchproduct(String name){
       WebElement searchbox = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
      searchbox.click();
      searchbox.sendKeys(name);
     }

     public void clickSearchButton(){
        driver.findElement(By.xpath("//input[@value='Search']")).click();;
        
     }
    
}

