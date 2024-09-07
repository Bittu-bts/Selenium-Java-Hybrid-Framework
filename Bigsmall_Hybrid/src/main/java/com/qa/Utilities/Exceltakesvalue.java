package com.qa.Utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceltakesvalue {
	
	static XSSFWorkbook work;
	static XSSFSheet sheet;

	public Exceltakesvalue(String excelPath, String Sheetname) {
		try {
			work = new XSSFWorkbook(new FileInputStream(excelPath));
			sheet = work.getSheet(Sheetname);
		} catch (Exception exp) {
			exp.getStackTrace();
		}
	}

	public static String getData(int rowNum, int colNum) {
		String searchValue = "";
		try {
			searchValue = sheet.getRow(rowNum).getCell(colNum).toString();
			System.out.println(searchValue);

		} catch (Exception ex) {
			ex.getMessage();
		}
		return searchValue;
	}

}
