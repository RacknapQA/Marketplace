package mainMaven;

	import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
	import java.io.IOException;

	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


	//How to read excel files using Apache POI
	public class ExcelUtil {
		public String ReadExcelData(int row, int cell, String sheetName) throws IOException{
	                        //I have placed an excel file 'Test.xlsx' in my D Driver 
				FileInputStream fis = new FileInputStream("..\\MavenTest\\TestData.xlsx");
				XSSFWorkbook workbook = new XSSFWorkbook(fis);
				XSSFSheet sheet = workbook.getSheet(sheetName);
	                        //I have added test data in the cell A1 as "SoftwareTestingMaterial.com"
	                        //Cell A1 = row 0 and column 0. It reads first row as 0 and Column A as 0.
				//int rowCount=sheet.getLastRowNum()-sh	eet.getFirstRowNum();
				//for(int i=row;i<rowCount;i++) {
				Row row1 = sheet.getRow(row);
				Cell cell1 = row1.getCell(cell);
					//String[] data = {};
					//int cellcount=row1.getLastCellNum();
	                  
				
					//System.out.println("Trying to read excel file.");
					//System.out.println(cell1.getStringCellValue());
					return cell1.getStringCellValue();
				
				//return data;
			
		}
		
		public static void writeDataToExcel(String filePath, int rowNum, int colNum, String data) {
			 try (FileInputStream inputStream = new FileInputStream(filePath);
		             XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {

		            // Get the existing sheet
		            Sheet sheet = workbook.getSheet("Sheet1");

		            // Create a new row or get the existing row
		            Row row = sheet.getRow(rowNum);
		            if (row == null) {
		                row = sheet.createRow(rowNum);
		            }

		            // Create a cell and set the data
		            Cell cell = row.createCell(colNum);
		            cell.setCellValue(data);

		            // Write the workbook back to the file
		            try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
		                workbook.write(outputStream);
		                workbook.close();
		            }

		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }

		
		public void ReadExcelData1() throws IOException{
            //I have placed an excel file 'Test.xlsx' in my D Driver 
			FileInputStream fis = new FileInputStream("..\\MavenTest\\TestData.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
            //I have added test data in the cell A1 as "SoftwareTestingMaterial.com"
            //Cell A1 = row 0 and column 0. It reads first row as 0 and Column A as 0.
			//int rowCount=sheet.getLastRowNum()-sh	eet.getFirstRowNum();
			//for(int i=row;i<rowCount;i++) {

				int lastRow=sheet.getLastRowNum();
				//int LastCell=row.getLastCellNum();
				for (int i=0;i<sheet.getLastRowNum();i++) {
				Row row=sheet.getRow(i);
					for(Cell cell: row) {
						System.out.println(cell.getStringCellValue());
				
				}


//return data;

}
		}
	}
		

	
		
		
	

