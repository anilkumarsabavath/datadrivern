package excel1;

import excel.Utility;

public class excel_util {
public static void main(String[] args) {
	Utility obj= new Utility("data/New Microsoft Excel Worksheet.xlsx");
	System.out.println(obj.getdata(0, 2, 0));
}
}
