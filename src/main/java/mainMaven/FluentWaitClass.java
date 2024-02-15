package mainMaven;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FluentWaitClass {
	
	public static WebDriver clickWhenElementIsVisible(WebDriver driver, By locator, int duration, String message) {
	    (new WebDriverWait(driver, Duration.ofSeconds(duration)))
		    .withTimeout(Duration.ofSeconds(duration))
		    .withMessage(message)
		    .ignoring(StaleElementReferenceException.class)
		    .ignoring(ElementClickInterceptedException.class)
		    .pollingEvery(Duration.ofSeconds(5))
		    .until(ExpectedConditions.visibilityOfElementLocated(locator));
	    try {
	        WebElement element = driver.findElement(locator);
	        JavaScriptUtil.clickElementByJS(driver, element);
	    } catch (NoSuchElementException e) {
	        System.out.println("Error: Element not found. Message: " + e.getMessage());
	        return null;
	    } catch (ElementNotInteractableException e) {
	        System.out.println("Error: Element not interactable. Message: " + e.getMessage());
	        return null;
	    }
	    return driver;
	}

}
