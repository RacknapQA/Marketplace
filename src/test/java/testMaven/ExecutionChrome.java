package testMaven;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.TestNG;

import mainMaven.ExcelUtil;

public class ExecutionChrome extends Repository{
	
	@BeforeClass
	public void startExcent() {
		startExcent1();
	}
	
	@Test
	public void launchUrl1() throws IOException {
		launchURLChrome();
		}


	@Test
	public void readExcel1() throws IOException {
		ReadExcelDataLoop();
		}
	
	@Test
	public void navigateToCustSummary1() throws IOException, InterruptedException {
		navigateToCustSummary();
		}
	
	@AfterClass
	public void endExcent() {
		endExcent1();
	}
//	
//	@Test(priority=4)
//	public void memberpoperation1() throws IOException, InterruptedException {
//		memberpoperation();
//		}
//
//	@Test(priority=5)
//	public void writeIntoExcel1() throws IOException {
//		//launchURL();
//		writeIntoExcel();
//		}

}	
	

	

