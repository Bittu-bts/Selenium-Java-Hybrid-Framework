package com.qa.Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	
	WebDriver driver;
	String path;

	public ScreenShot(WebDriver driver, String path) {
		this.path = path;
		this.driver = driver;
	}

	public String saveScreenShots() throws IOException {
		TakesScreenshot shot = (TakesScreenshot) driver;
		File SrcFile = shot.getScreenshotAs(OutputType.FILE);
		String path1 = path + System.currentTimeMillis() + ".png";
		File DestFile = new File(path1);
		FileUtils.copyFile(SrcFile, DestFile);  
		return path1;
	}

}
