package com.qa.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.baseClass.baseClass;
import com.qa.uiStore.dropDownuiStore;

public class dropDownpageObject extends baseClass{
	
	//WebDriver initialize
	public WebDriver driver;
	
	public dropDownpageObject (WebDriver driver) {
		//parameterized constructor
		this.driver = driver;
	}
	
	public WebElement getdropdown() {
		return driver.findElement(dropDownuiStore.dropdown);
		
	}

}
