package com.qa.testCases;

import java.io.IOException;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Utilities.Exceltakesvalue;
import com.qa.Utilities.ExtentLogUtilities;
import com.qa.baseClass.baseClass;
import com.qa.pageObject.dropDownpageObject;
import com.qa.pageObject.searchBarpageObject;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class runnerCases extends baseClass {
	
	static ExtentTest test;
	static ExtentReports report = new ExtentReports(System.getProperty("user.dir") + "\\reports\\" + "AutomationReport"
	                                                  + System.currentTimeMillis() + "-.html");
	public static Logger Log=Logger.getLogger(baseClass.class.getName());
	
	@BeforeMethod
	public void Dinit() throws InterruptedException {
		driver=BaseSettings();
		Log.info(driver.getTitle());
		driver.get(prop.getProperty("url"));
		
//		Thread.sleep(3000);
//		driver.get(prop.getProperty("ur2"));
//		A.SSO().click();
	}
	
	@Test(priority=1)
	public void ClicOnDropdown() throws IOException, InterruptedException {
		test = report.startTest("Dropdown");
		test.log(LogStatus.PASS, "Click on drodown");
		ExtentLogUtilities.pass(driver, test, "Task done", Log);
		Log.info(driver.getTitle());
		dropDownpageObject dd = new dropDownpageObject(driver);
		dd.getdropdown().click();
		Log.info("Click on dropDown");
		report.endTest(test);
		report.flush();
		Thread.sleep(3000);	
	}
	
	@Test(dataProvider="getvalue1", priority=2)
	public void ClickOnSearchIcon(String  pr) throws IOException, InterruptedException {
		test = report.startTest("Searchbar");
		test.log(LogStatus.PASS, "Entering value in searchbar");
		ExtentLogUtilities.pass(driver, test, "Task done", Log);
		Log.info(driver.getTitle());
		searchBarpageObject sb = new searchBarpageObject(driver);
		sb.clicksearhicon().click();
		Log.info("Click on search icon");
		sb.searchbar().sendKeys(pr, Keys.ENTER);
		Log.info("Entering value");
		report.endTest(test);
		report.flush();
		Thread.sleep(3000);
	}
	
	@DataProvider
	public Object[] getvalue1() {
		String path = System.getProperty("user.dir");
		Exceltakesvalue exc = new Exceltakesvalue(path+"\\ExcelSheet\\ExcelComp1.xlsx","Sheet1");
		Object[] ob = new Object[1];
		ob[0] = exc.getData(0, 0);
		System.out.print(Arrays.toString(ob));
		return ob;
	}
//	@DataProvider
//	public Object[] getvalue1() {
//		String path = System.getProperty("user.dir");
//		Exceltakesvalue exc = new Exceltakesvalue(path+"\\ExcelSheet\\ExcelComp1.xlsx","Sheet1");
//		Object[][] ob = exc.getMulData();
//		searchb= create req, input form = abcd
//		
//		return ob;
//	}
	
	@AfterMethod
	public void dclose() {
		driver.quit();
	}

}
