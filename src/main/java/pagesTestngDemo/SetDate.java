package pagesTestngDemo;
import java.time.Duration;
import java.util.*;

import javax.swing.plaf.synth.SynthLookAndFeel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SetDate {
    WebDriver driver;
    WebDriverWait wait;

    public SetDate(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver,Duration.ofSeconds(5));
    }
    public void StartDate()
    throws InterruptedException{
       driver.findElement(By.xpath("//p[@data-testid='departureDate']")).click();
       wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='body-xs']")));

       List<WebElement> dates=driver.findElements(By.xpath("//button[contains(@class,'react-calendar__tile')]//abbr"));
       List<WebElement> fares=driver.findElements(By.xpath("//div[@class='body-xs']"));

          System.out.println("Size : " + dates.size());
          int min=Integer.MAX_VALUE;
          int index=-1;
          for (int i=0;i<fares.size();i++) {
            String price = fares.get(i).getText().trim();

            if (!price.equals("--")&& !price.isEmpty()) {
                int num=Integer.parseInt(price);
                
                if(num<min){
                    min=num;
                    index=i;
                }
            }
        }
        System.out.println("The Index: "+ index);
        System.out.println("The minimum Price :"+ min);
      WebElement FromDate=  dates.get(index);
      
      String textDate= FromDate.getText();
      System.out.println("The Date With Minimum price : "+ textDate);
      FromDate.click();
    }
    public void ReturnDate(){
       wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='bg-charcoal-40 border-charcoal-40 hover:bg-neutral-subtle-over hover:border-contrast w-full']")));
       driver.findElement(By.xpath("//div[@class='bg-charcoal-40 border-charcoal-40 hover:bg-neutral-subtle-over hover:border-contrast w-full']")).click();

        List<WebElement> fares=driver.findElements(By.xpath("//div[@class='body-xs']"));
          int min=Integer.MAX_VALUE;
          int index=-1;
          System.out.println("The size :"+fares.size());
          for (int i=0;i<fares.size();i++) {
            String price = fares.get(i).getText().trim();

            if (!price.equals("--")&& !price.isEmpty()) {
                int num=Integer.parseInt(price);
                
                if(num<min){
                    min=num;
                    index=i;
                }
            }
        }
        System.out.println("The minimum Price to return : "+min);

    }
}
