package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.LoginPage;
import utils.*;

public class LoginSteps {

    WebDriver driver;
    LoginPage login;

    @Given("User is on login page")
    public void openLoginPage() {
        driver =Hooks.driver;
        driver.get(ConfigReader.getProperty("url"));
        login = new LoginPage(driver);
    }

    @When("User enters valid username and password")
    public void enterCredentials() {

        login.enterCredentials();
    }

    @When("User clicks login button")
    public void clickLogin() {

        login.clickLogin();
    }

    @Then("User should login successfully")
    public void verifyLogin() {

        System.out.println("Login Successful");

    }

    @When("User enters invalid username and password")
    public void InvalidCredentials(){
        login.InvalidCredentials();
    }

    @Then("User returns login error message")
    public void ErrorMsg(){
        login.ErrorMsg();

        System.out.println("The Test completed sucessfully");
    }
    
    @When("User enters {string} and {string}")
    public void enterCredentials(String email, String password) {
             login.enterCredentials(email,password);   
    }

    @Then("User display the result")
    public void displayResult(){
        login.displayResult();
    }
    
    @Given("User is on register page")
    public void registerPage(){
        driver=Hooks.driver;
        driver.get(ConfigReader.getProperty("registerurl"));
        login=new LoginPage(driver);
    }

    @When("User enters valid details {string} , {string} and {string}, {string}")
    public void registerDetails(String firstname, String lastname, String pass,String confpass){
         login.registerDetails(firstname,lastname,pass,confpass);
    }

    @When("User clicks the register button")
    public void clickRegister(){
        login.clickregister();
    }

    @Then("User returns the result")
    public void result(){
        System.out.println("The Registration Process completed ");
    }

    @When("the user is on the Home Page")
    public void homePage(){
        login.homepage();
    }
    @When("the user searches for {string}")
    public void search(String productName){
        login.search(productName);
    }
    @When("the user adds the product to the cart")
    public void addCart(){
        login.addCart();
    }
    @When("the user proceeds to checkout")
    public void checkout(){
        login.checkout();
    }
    @Then("the order should be placed successfully")
    public void placeorder(){
        login.placeorder();
    }
}