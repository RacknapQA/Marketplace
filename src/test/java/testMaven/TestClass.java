package testMaven;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;    

public class TestClass {
	//invoking the browser
	public static void main(String[] args) {  
	//System.setProperty("webdriver.chrome.driver","C:\\Users\\lokesh\\eclipse-workspace\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("http://www.google.com/");
	}
	
	
}
