package base;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import utils.WaitUtil;

// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.chrome.ChromeDriver;

// public class BaseClass {

//     public static WebDriver driver;

//     public void setup() {
//         driver = new ChromeDriver();

//         driver.manage().window().maximize();

//         driver.get(
//              "https://demowebshop.tricentis.com/");
//     }

//     public void tearDown() {
//         driver.quit();
//     }
// }
public class base{
    public static void main(String[]args){
        ChromeOptions options =new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.abhibus.com/");

        // Locators for the elements on the page
        By flight_button=By.xpath("//span[contains(text(),'Flight')]");
        By click_from=By.xpath("//p[@data-testid='originId']");
        By clear_data_in_from=By.xpath("//*[local-name()='svg' and @data-testid='CloseIcon']");
        By select_city_from=By.xpath("(//span[contains(text(),'Mumbai')])[1]");
        By send_data_to_To_city=By.xpath("//label[contains(text(),'To')]/following-sibling::input");
        By select_city_to=By.xpath("//span[contains(text(),'Kolkata')]");
        By select_date=By.xpath("//*[text()='10']");
        By click_done=By.xpath("//button[text()='Done']");
        By click_search=By.xpath("//button[text()='Search']");

        // Use WaitUtil to interact with the elements
        WaitUtil.WebForElement(driver,flight_button).click();
        WaitUtil.WebForElement(driver, click_from).click();
        WaitUtil.WebForElement(driver, clear_data_in_from).click();
       WaitUtil.WebForElement(driver,select_city_from).click();
       WaitUtil.WebForElement(driver, send_data_to_To_city).sendKeys("Kolkata");
       WaitUtil.WebForElement(driver, select_city_to).click();
        WaitUtil.ClickForElement(driver,select_date).click();
         WaitUtil.WebForElement(driver,click_done).click();
         WaitUtil.WebForElement(driver,click_search).click();

    }
}