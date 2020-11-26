package com.excelRead;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelRead {
	static String cdir = System.getProperty("user.dir");
	public static void main(String[] args) {
		
		String s =ExcelRead.readExcel("getData", "A1");
		System.out.println(s);
	}
	public static String readExcel(String SheetName, String cellNumber) {
		String cellValue = null;
		try {
			DataFormatter f = new DataFormatter();
			InputStream file = new FileInputStream(cdir + "//src//test//resources//TestData//MyDataFileRead.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(SheetName);
			CellAddress cellRefe = new CellAddress(cellNumber);
			Row row = sheet.getRow(cellRefe.getRow());
			Cell cell = row.getCell(cellRefe.getColumn());
			cellValue = f.formatCellValue(cell);
			workbook.close();
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

		return cellValue;

	}



}
