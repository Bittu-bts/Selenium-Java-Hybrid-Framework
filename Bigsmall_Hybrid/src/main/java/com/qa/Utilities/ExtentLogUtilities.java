package com.qa.Utilities;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentLogUtilities {
	
	public static void pass(WebDriver Driver, ExtentTest test, String msg, Logger log) throws IOException {
		test.log(LogStatus.PASS, msg);
		log.debug(msg);
		String path=new ScreenShot(Driver, System.getProperty("user.dir") + "/ScreenShots/pass/").saveScreenShots();
		test.log(LogStatus.PASS,msg+":"+test.addScreenCapture(path));
	}

	public static void fail(WebDriver Driver, ExtentTest test, String msg, Logger log) throws IOException {
		test.log(LogStatus.FAIL, msg);
		log.error(msg);
		String path=new ScreenShot(Driver, System.getProperty("user.dir") + "/ScreenShots/fail/").saveScreenShots();
		test.log(LogStatus.FAIL,msg+":"+test.addScreenCapture(path));
	}

}
