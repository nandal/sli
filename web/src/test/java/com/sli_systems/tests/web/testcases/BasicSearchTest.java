package com.sli_systems.tests.web.testcases;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sli_systems.tests.web.pages.SliResultPage;
import com.sli_systems.tests.web.pages.SliSearchPage;

@RunWith(Parameterized.class)
public class BasicSearchTest {
	
	public WebDriver driver;
	public SliSearchPage searchPageObject;
	public SliResultPage resultPageObject;
	
	public String keyword;
	public String output;
	

	public BasicSearchTest(String keyword, String output) {
		this.keyword = keyword;
		this.output = output;
	}
	
	@Parameters
	public static Collection<Object[]> parameter() {
		Object[][] data = new Object[3][2];
		data[0][0] = "red";
		data[0][1] = "Valentine";
		data[1][0] = "Best";
		data[1][1] = "P.A.R. Checklist";
		data[2][0] = "water";
		data[2][1] = "WaterFilters.net";
		return Arrays.asList(data);
	}

	@BeforeClass
	public static void beforeClassTestMethod(){
		System.out.println("beforeClassTestMethod();");
	}

	@Before
	public void beforeTestMethod(){
		System.out.println("beforeTestMethod();");
		//driver = new FirefoxDriver();
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.sli-systems.com/");
	}

	@Test
	public void searchKeywordTest() {
		System.out.println("Key is: " + keyword + " and output is: " + output);
		this.searchPageObject = new SliSearchPage(driver);
		this.searchPageObject.performSearch(keyword);
		this.resultPageObject = new SliResultPage(driver);
		assertTrue(this.resultPageObject.checkIfResultFound(1, output));
	}
	
	@After
	public void afterTestMethod(){
		System.out.println("afterTestMethod();");
		if (driver != null) {
			driver.quit();
		}
	}
	
	@AfterClass
	public static void afterClassTestMethod(){
		System.out.println("afterClassTestMethod();");
		
	}

}
