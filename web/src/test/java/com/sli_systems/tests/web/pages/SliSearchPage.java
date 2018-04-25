package com.sli_systems.tests.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SliSearchPage {
	
	WebDriver driver;

    @FindBy(xpath="//div[@id='sli_search_box']//input[@class='search-field']")
    WebElement searchField;
    
    @FindBy(xpath="//div[@id='sli_search_box']//input[@class='serch_submit']")
    WebElement searchSubmit;
    
    
    public SliSearchPage(WebDriver driver){
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    }
    
    public void enterSearchText(String input){
    	this.searchField.sendKeys(input);
    }
    
    public void clickSearch(){
    	this.searchSubmit.click();
    }
    
    public void performSearch(String input){
    	this.enterSearchText(input);
    	this.clickSearch();
    }

}
