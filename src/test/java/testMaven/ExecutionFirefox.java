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

	public class ExecutionFirefox extends Repository{
		

		@Test
		public void launchUrl2() throws IOException {
			launchURLFirefox();
			}
		
		
		@Test(priority=2)
		public void readExcel1() throws IOException {
			ReadExcelDataLoop();
			}
		
		
		@Test(priority=3)
		public void navigateToCustSummary1() throws IOException, InterruptedException {
			navigateToCustSummary();
			}
	//	
//		@Test(priority=4)
//		public void memberpoperation1() throws IOException, InterruptedException {
//			memberpoperation();
//			}
	//
//		@Test(priority=5)
//		public void writeIntoExcel1() throws IOException {
//			//launchURL();
//			writeIntoExcel();
//			}

	}	
		

		


