package mainMaven;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class JavaScriptUtil {
	
	
	public static void flash_the_element(WebDriver driver, WebElement element)
	{
		
		String bgcolour = element.getCssValue("backgroundColor");
		for (int i=0; i<500; i++)
		{
			changeColor(driver,"#000000", element);
			changeColor(driver, bgcolour, element);
		}
	}
	
	
	private static void changeColor(WebDriver driver, String color, WebElement element)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = ' " + color + " ' ", element);
		
		try 
		{
			Thread.sleep(20);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	public static void drawBorder(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border = '4px solid red' ", element);
		
	}
	
	
	
	public static String getTitleByJS(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String title = js.executeScript("return document.title;").toString();
		return title;	
		
	}
	
	
	public static void clickElementByJS(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
	}
	
	
	public static void generateAlert(WebDriver driver, String message)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('"+ message +"')");
	}
	
	
	public static void refreshBrowserByJS(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
	}
	
	
	
	
	public static void sendtextByJS(WebDriver driver,WebElement element,String message)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementById('"+element+"').setAttribute('value', '"+message+"')");
	}
	
	
	public static void scrollIntoView(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	
	public static void scrollPageDown(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
	}
	
	
	
    
    public static void scrollPageByPixel(WebDriver driver)
	{
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(180,280)");
	}
   
    
    public static void waitForPageToLoad(WebDriver driver)
   	{
    	JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("return document.readyState").toString().equals("complete");
   	}
	
	

}
