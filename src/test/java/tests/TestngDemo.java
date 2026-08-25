package tests;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pagesTestngDemo.SetPlace;
import pagesTestngDemo.SetDate;

public class TestngDemo {
        WebDriver driver;

        @BeforeTest
        public void setup(){
            driver=new ChromeDriver();
            driver.get("https://www.ixigo.com/");
        }
        
        @Test(priority = 1)
        public void ChoseCity(){
            SetPlace place=new SetPlace(driver);
            place.fromPlace("bangalore");
            place.ToCity("kolkata");
        }
        @Test(priority = 2)
        public void SelectDate() throws InterruptedException {
            SetDate date=new SetDate(driver);
            date.StartDate();
            date.ReturnDate();
        }
        @AfterTest
        public void teardown() throws InterruptedException {
            Thread.sleep(4000);
            driver.quit();
        }
 }    

