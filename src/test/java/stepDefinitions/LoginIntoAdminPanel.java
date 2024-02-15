package stepDefinitions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mainMaven.AdminConstants;
import mainMaven.ExcelUtil;

public class LoginIntoAdminPanel {
	
	public WebDriver driver;
	ExcelUtil xf1= new ExcelUtil();
	ExcelUtil xf2= new ExcelUtil();
	String username;
	String password;
	
	@Given("Open the chrome and start application")
	public void open_the_chrome_and_start_application() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	    driver=new ChromeDriver();
		
		String url=xf1.ReadExcelData(1,3, "Sheet1");
		driver.get(url);
		//Driver1 driver1=new Driver1();
		//driver1.chromeDriver(driver);
		driver.manage().window().maximize();

		
	}

	@When("I enter valid username and valid password")
	public void i_enter_valid_username_and_valid_password() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		username=xf1.ReadExcelData(1,1, "Sheet1");
		password=xf1.ReadExcelData(1,2, "Sheet1");
		AdminConstants.username(driver).sendKeys(username);
		AdminConstants.password(driver).sendKeys(password);
	}

	@Then("user should be able to login successfully")
	public void user_should_be_able_to_login_successfully() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		AdminConstants.signin(driver).click();
	}


}
