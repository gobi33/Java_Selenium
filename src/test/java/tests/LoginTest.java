package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPagecucu;
import pages.SearchProduct;
import pages.Cart;
import pages.Checkout;
import pages.ConformOrder;

public class LoginTest {

    public static void main(String[] args)
            throws InterruptedException {

       WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demowebshop.tricentis.com/");

        LoginPagecucu login =new LoginPagecucu(driver);

        login.clickLoginLink();

        login.enterEmail("john.xyz@gmail.com");

        login.enterPassword("John@123");

        login.clickLoginButton();
        System.out.println(driver.getTitle());
         

                                                    //SearchProduct

      SearchProduct search = new SearchProduct(driver);
      search.searchproduct("laptop");
      search.clickSearchButton();
                                                       //Cart

     Cart cart=new Cart(driver);
     cart.addtocart();
     cart.clickcart();
                                                       //checkout
     Checkout checkout=new Checkout(driver);
     checkout.agreeterms();
     checkout.clickcheckout();
                                                       //conformorder

    ConformOrder order=new ConformOrder(driver);
    order.billingaddress();
    order.shippingaddress();
    order.shippingmethod();
    order.paymentmethod();
    order.paymentinfo();
    order.confirmorder();
      Thread.sleep(5000);
     driver.quit();
    }
}