package com.tm

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

// Excel imports
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.format.CellDateFormatter
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.lang.String

public class Excel {

	@Keyword
	def excelDemo () {
		FileInputStream file = new FileInputStream (new File("C:\\Users\\Andre\\Downloads\\TestData-Demo (2).xlsx"));
		// create new excel workbook from the file input
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");

		// read data
		String cellData=sheet.getRow(1).getCell(1).getStringCellValue();
		println("Data from cell 1:1= " + cellData)

		// write data
		String text = "DemoUpdate_" + System.currentTimeMillis().toString();
		println("Data to add = " + text);
		sheet.getRow(1).createCell(1).setCellValue(text);

		file.close();

		// save/write the file - same name will overwrite
		FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\Andre\\Downloads\\TestData-Demo (2).xlsx"));
		workbook.write(outFile);
		outFile.close();
	}

}
