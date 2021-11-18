package stepdefs;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_Stepdefs {
    
    WebDriver driver = BaseClass.driver;
    
    @Given("^User has navigated to the login page$")
    public void user_has_navigated_to_the_login_page() throws Throwable {
       
        
        driver.get("https://www.simplilearn.com/");
        
        driver.manage().window().maximize();  

        
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
        
        
        WebElement LoginLink = driver.findElement(By.linkText("Log in"));
        
        WebDriverWait wait = new WebDriverWait(driver,30);
        
        wait.until(ExpectedConditions.visibilityOf(LoginLink));
        
        LoginLink.click(); 

    }

    @When("^User enters the correct username and password$")
    public void user_enters_the_correct_username_and_password() throws Throwable {
        WebElement UserName = driver.findElement(By.name("user_login"));
        UserName.sendKeys("abc@xyz.com");
        
        WebElement Password = driver.findElement(By.id("password"));
        Password.sendKeys("Kas@12232");
    }

    @Then("^user should be navigated to the Home Page$")
    public void user_should_be_navigated_to_the_home_page() throws Throwable {
        
    }

    @And("^User clicks on the logn button$")
    public void user_clicks_on_the_logn_button() throws Throwable {
        WebElement LoginButtton = driver.findElement(By.name("btn_login"));
        LoginButtton.click();
    }
    
    @When("^User enters the correct username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_enters_the_correct_username_something_and_password_something(String UserNameVal, String PasswordVal) throws Throwable {
    
    	WebElement UserName = driver.findElement(By.name("user_login"));
        UserName.sendKeys(UserNameVal);
        
        WebElement Password = driver.findElement(By.id("password"));
        Password.sendKeys(PasswordVal);
    }
    @Then("^user should be get error message \"([^\"]*)\"$")
    public void user_should_be_get_error_message_something(String error) throws Throwable {
     
    	WebElement Error = driver.findElement(By.id("msg_box"));
		
		String actualMsg = Error.getText();
		
		
		Assert.assertEquals(error, actualMsg);
    
    }
}