package stepdefinitions;
import org.openqa.selenium.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Tha;
import pages.BookingPage;
import utils.ConfigReader;
import utils.ExcelUtil;

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
    @When("the user need to select flight option")
    public void selectflight(){
        book.selectflight();
    }
    @When("the user selects the {string} and {string} locations for flight")
    public void select_flightPlace(String source, String destinstion){
        book.select_flightplace(source,destinstion);
    }
    @When("the user selects the details about the journey")
    public void flight_details(){
         book.flight_details();
    }
    @Then("the user able to book the flight")
    public void book_ticket(){
        book.book_ticket();
    }

    @When("the user selects flight locations from excel")
    public void selectFlightLocationsFromExcel() throws Exception {
    ExcelUtil.loadExcel();
    int rowCount =ExcelUtil.getRowCount();
    for(int i = 1; i <= rowCount; i++) {
        String source =ExcelUtil.getCellData(i, 0);
        String destination =ExcelUtil.getCellData(i, 1);
        System.out.println(source + " -> " + destination);
        book.select_flightplace(source, destination);
        }
    ExcelUtil.closeExcel();
    }

}
