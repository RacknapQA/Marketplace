package mainMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminConstants {
	//WebDriver driver;
	public static WebElement username(WebDriver driver) {
		WebElement username1=driver.findElement(By.cssSelector("#login_username"));
		return username1;	
	}
	
	public static WebElement password(WebDriver driver) {
		WebElement password1=driver.findElement(By.id("login_password"));
		return password1;	
	}
	
	public static WebElement signin(WebDriver driver) {
		WebElement signin1=driver.findElement(By.id("kt_login_signin_submit_form"));
		return signin1;	
	}	
		
	
	
	
	
	
}
