package stepdefinitions;
import org.openqa.selenium.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Tha;
import pages.BookingPage;
import utils.ConfigReader;

public class BookingSteps {
    WebDriver driver;
    BookingPage book;

    @Given("the user is on the Booking page")
    public void bookingpage(){
        driver=Hooks.driver;
        driver.get(ConfigReader.getProperty("Bookingurl"));
        book=new BookingPage(driver);      
    }
    @When("the user selects the source and destination locations")
    public void selectplace(){
        book.selectplace("Erode","Coimbatore");       
    }
    @When("the user selects the journey date")
    public void selectdate(){
        book.selectdate();
    }
    @Then("the user should be able to book the ticket")
    public void bookticket(){
      System.out.println("The travels name : "+book.bookticket());
    }

}
