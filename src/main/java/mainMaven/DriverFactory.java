package mainMaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	
	public WebDriver launchChrome() {
		WebDriver driver;
		driver=new ChromeDriver();
		return driver;
	}
	public WebDriver launchFirefox() {
		WebDriver driver1;
		driver1=new FirefoxDriver();
		return driver1;
	}


}
