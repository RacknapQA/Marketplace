package testMaven;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class GetAttribute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0;
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.znetlive.lab.dotbricks.net/");
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		System.out.println("Total links: "+links.size());
		for(WebElement link: links) {
			String href=link.getAttribute("href");
			System.out.println(href);
			if(href==null||href.isEmpty()) {
				i++;
				System.out.println("Broken link "+i+" : "+link.getText());
			}
		}
		System.out.println("count brocken: "+i);
		// Get the status code

		driver.quit();
		
	}

}
