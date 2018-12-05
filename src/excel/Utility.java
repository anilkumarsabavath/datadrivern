package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utility {
	XSSFWorkbook wb;
	XSSFSheet sheet1;

	public Utility(String path) {
		try {
			File src = new File(path);

			FileInputStream fis = new FileInputStream(src);

			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
public String getdata(int sheet,int row,int coloum) {
	sheet1=wb.getSheetAt(0);
	String data=sheet1.getRow(row).getCell(coloum).getStringCellValue();
	return data;
	
}
public int getrownum(int sheetnum) {
	int row=wb.getSheetAt(0).getLastRowNum();
	row=row+1;
	return row;
	
}
public static void add() {
	System.out.println("anilkumar");
}
}
