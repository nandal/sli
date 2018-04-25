package com.sli_systems.tests.web.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SliResultPage {

	WebDriver driver;

    @FindBy(xpath="//main[contains(@class, 'index_main') and contains(@class ,'sli_container')]//div[@class='sli_list_content']")
    List<WebElement> resultDivs;
    
    public SliResultPage(WebDriver driver){
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    }

    public String getResultDivHeading(WebElement resultDiv){
    	if(resultDiv == null)return "";

    	WebElement headingAnchor = resultDiv.findElement(By.xpath("./h2[@class='sli_h2']/a"));
    	if(headingAnchor != null){
    		return headingAnchor.getText();
    	}else{
    		return "";
    	}
    }
    public String getResultDivParagraph(WebElement resultDiv){
    	if(resultDiv == null)return "";

    	WebElement paragraph = resultDiv.findElement(By.xpath("./p"));
    	if(paragraph != null){
    		return paragraph.getText();
    	}else{
    		return "";
    	}
    }
    
    public boolean checkIfResultFound(int rank, String keyword){
    	int i=0;
    	for(WebElement ele: resultDivs){
    		if(i >= rank)break;
    		i++;
    		if(this.getResultDivHeading(ele).toLowerCase().contains(keyword.toLowerCase()) &&
    				this.getResultDivParagraph(ele).toLowerCase().contains(keyword.toLowerCase())){
    			return true;
    		}
    	}
    	return false;
    }
   
}
