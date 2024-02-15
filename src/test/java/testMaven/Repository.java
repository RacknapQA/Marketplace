package testMaven;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.HTMLReporter;
import com.relevantcodes.extentreports.LogStatus;

import mainMaven.AdminConstants;
import mainMaven.DriverFactory;
import mainMaven.ExcelUtil;


public class Repository extends DriverFactory{
	
	WebDriver driver;
	ExcelUtil xf1= new ExcelUtil();
	ExcelUtil xf2= new ExcelUtil();
	String username;
	String password;
	protected static HTMLReporter htmlReporter;
    protected static ExtentReports report;
    protected static ExtentTest test;
	
	public void startExcent1() {
		report = new ExtentReports(System.getProperty("user.dir")+"ExtentReportResults.html");
		test = report.startTest("ExtentDemo");
	}
	public void endExcent1() {
		report.endTest(test);
		report.flush();
	}
	
	public void launchURLChrome() throws IOException {
		
		//Logger logger = LoggerFactory.getLogger(getClass());
		//test = extent.createTest("My Test Method", "Description of the test method");
		driver=super.launchChrome();
		
		String url=xf1.ReadExcelData(1,3, "Sheet1");
		driver.get(url);
		test.log(LogStatus.PASS, "Navigated to the specified URL");
		//Driver1 driver1=new Driver1();
		//driver1.chromeDriver(driver);
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Browser maximized.");
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		username=xf1.ReadExcelData(1,1, "Sheet1");
		password=xf1.ReadExcelData(1,2, "Sheet1");
		AdminConstants.username(driver).sendKeys(username);
		AdminConstants.password(driver).sendKeys(password);
		AdminConstants.signin(driver).click();
		test.log(LogStatus.PASS, "Login into admin panel.");
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String methodName = stackTrace[2].getMethodName();
		
		File destinationFile = new File("..\\MavenTest\\test-output\\screengrabs\\screengrabs_"+methodName+"_"+timestamp+".png");
		try {
            // Copy the captured screenshot to the destination file
            FileUtils.copyFile(sourceFile,destinationFile);
            //System.out.println("Screenshot saved to: " + destinationFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Unable to capture screenshot: " + e.getMessage());
            test.log(LogStatus.FAIL, "Screenshot failed.");
        }
	}
	
	public void launchURLFirefox() throws IOException {
		//Logger logger = LoggerFactory.getLogger(getClass());
		driver=super.launchFirefox();
		
		String url=xf1.ReadExcelData(1,3, "Sheet1");
		driver.get(url);
		//Driver1 driver1=new Driver1();
		//driver1.chromeDriver(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		username=xf1.ReadExcelData(1,1, "Sheet1");
		password=xf1.ReadExcelData(1,2, "Sheet1");
		AdminConstants.username(driver).sendKeys(username);
		AdminConstants.password(driver).sendKeys(password);
		AdminConstants.signin(driver).click();
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String methodName = stackTrace[2].getMethodName();
		
		File destinationFile = new File("..\\MavenTest\\test-output\\screengrabs\\screengrabs_"+methodName+"_"+timestamp+".png");
		try {
            // Copy the captured screenshot to the destination file
            FileUtils.copyFile(sourceFile,destinationFile);
            //System.out.println("Screenshot saved to: " + destinationFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Unable to capture screenshot: " + e.getMessage());
        }
		
	}
	
	public void navigateToCustSummary() throws InterruptedException {
		Actions act=new Actions(driver);
		WebElement webe=driver.findElement(By.xpath("//span[@class='kt-menu__link-text']"));
		act.click(webe).perform();
		WebElement custLink=driver.findElement(By.xpath("//span[text()='Customers']"));
		act.moveToElement(custLink).perform();
		WebElement custList=driver.findElement(By.xpath("//span[@class='kt-menu__link-text'][text()='List']"));
		
		act.click(custList).click().perform();	
		//Thread.sleep(2000);
		//WebDriverWait wait = new WebDriverWait(driver,30);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Customer ID/Name']")));
		//driver.navigate().to("https://manage.qa5.dotbricks.net/adminp/clients/client-summary/V2UyQnVXcHRka1FwaEdBL2V6VDBmdEVLQmtmU1VWRGU4aHMveDhDMm9iaz0%3D");
		
		//Actions act=new Actions(driver);
		Wait<WebDriver> wait =
			        new FluentWait<>(driver)
			            .withTimeout(Duration.ofSeconds(2))
			            .pollingEvery(Duration.ofMillis(300))
			            .ignoring(ElementNotInteractableException.class);
		 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Customer ID/Name']")));		
		
		driver.findElement(By.xpath("//input[@placeholder='Customer ID/Name']")).sendKeys("1922");
		driver.findElement(By.xpath("//a[@id='side_search_btn']")).click();
		WebElement ele=driver.findElement(By.xpath("//a/i[@class='fas fa-sign-in-alt']"));
		act.click(ele).perform();
		Thread.sleep(4000);
	}
	
	public void memberpoperation() throws InterruptedException {
		String parent=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		for(String window:windows) {
			if(!window.equals(parent)) {
				driver.switchTo().window(window);
				System.out.println("Window switched.");
				break;
			}
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@class='btn m-btn btn-header  m--margin-left-15']")).click();
		driver.switchTo().window(parent);		
	}
	

	
	public void writeIntoExcel() {
		String data = "Lokesh";
		
        // Specify the path for the Excel file
        String filePath = "C:\\Users\\lokesh\\eclipse-workspace\\MavenTest\\TestData.xlsx";

        // Write data to Excel file using Apache POI
        xf1.writeDataToExcel(filePath, 3, 0, data);
	}



	public void ReadExcelDataLoop() throws IOException {
		xf2.ReadExcelData1();
		
	}
}


