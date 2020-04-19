package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility 
{
	static FileInputStream file;
	static FileOutputStream fileOut;
	static XSSFWorkbook work;
	static XSSFSheet sheet;
	
	public static String readExcelCellData(String path, int i, int j) throws IOException
	{
		String cellValue="";
		file= new FileInputStream(new File(path));
		work= new XSSFWorkbook(file);
		sheet= work.getSheet("Sheet1");
		
		Cell cell= sheet.getRow(i).getCell(j);
		if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC)
		{
			cellValue+= cell.getNumericCellValue();
		}
		else if(cell.getCellType()==Cell.CELL_TYPE_STRING)
		{
			cellValue= cell.getStringCellValue();
		}
		else
		{
			cellValue= "";
		}

		return cellValue;
	}
}
