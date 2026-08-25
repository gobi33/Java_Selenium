package pagesDemPract;

import java.time.Duration;
import java.util.ArrayList;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Desktop {
    WebDriverWait wait;
    WebDriver driver;
    public Desktop(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        
    }
    public void goTo(){

        Actions action = new Actions(driver);
      WebElement computer =  driver.findElement(By.xpath("//ul[@class='top-menu']/li//a[contains(@href,'computer')]"));
        action.moveToElement(computer).perform();
        WebElement desktop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='top-menu']/li//a[contains(@href,'desktop')]")));
        desktop.click();
    }
    public void LowestPrice(){
        List<WebElement>products=driver.findElements(By.xpath("//h2[@class='product-title']"));
        List<WebElement> elements=driver.findElements(By.xpath("//span[@class='price actual-price']"));
        List<WebElement>addtocart=driver.findElements(By.xpath("//input[@class='button-2 product-box-add-to-cart-button']"));
        double min_value=Double.MAX_VALUE;
        int id=0;

        for(int i=0;i<Math.min(elements.size(),addtocart.size());i++){
            String pricetext=elements.get(i).getText().replaceAll("[^0-9.]","");
            double pricevalue=Double.parseDouble(pricetext);
            boolean AddToCart=addtocart.get(i).isDisplayed();
            if(AddToCart && min_value>pricevalue){
                min_value=pricevalue;
                id=i;    
            }
        } 
        addtocart.get(id).click();   
        WebElement ProdName=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-name']")));
        String Name_of_Product = ProdName.getText();
        System.out.println("The Product name: "+ Name_of_Product);
        String Price_value=driver.findElement(By.xpath("//span[@class='price-value-75']")).getText();
        System.out.println("The value of the product : "+Price_value);

    }
    public void addtocart(){
        driver.findElement(By.id("product_attribute_75_5_31_96")).click();
        driver.findElement(By.id("product_attribute_75_8_35_107")).click();
        driver.findElement(By.id("add-to-cart-button-75")).click();
       WebElement shoppingcart= driver.findElement(By.xpath("//a[@class='ico-cart']/span[@class='cart-label']"));
       
       shoppingcart.click();
    }
    
}
