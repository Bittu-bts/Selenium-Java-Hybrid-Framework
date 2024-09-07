package com.qa.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.baseClass.baseClass;
import com.qa.uiStore.searchBaruiStore;

public class searchBarpageObject extends baseClass {
	
	//WebDriver initialize
	public WebDriver driver;
	
	public searchBarpageObject (WebDriver driver) {
		//parameterized constructor
		this.driver = driver;
	}
	
	public WebElement clicksearhicon() {
		return driver.findElement(searchBaruiStore.searchbarclick);
	}
	
	public WebElement searchbar() {
		return driver.findElement(searchBaruiStore.searchbar);
	}

}
