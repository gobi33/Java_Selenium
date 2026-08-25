package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart {

    WebDriver driver;
     public Cart(WebDriver driver){
        this.driver=driver;
    }
    public void addtocart(){
        driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
    }
    public void clickcart(){
        driver.findElement(By.xpath("//a[@href='/cart']//span[@class='cart-label']")).click();
    }

    
}
