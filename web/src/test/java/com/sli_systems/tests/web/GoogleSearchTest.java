package com.sli_systems.tests.web;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;;


@RunWith(Parameterized.class)
public class GoogleSearchTest {
	public String keyword;
	public String output;
	public int thirdParam;
	
	private static ChromeDriver driver;
 	WebElement element;
	
	public GoogleSearchTest(String keyword, String output, int thirdDummy){
		this.keyword = keyword;
		this.output = output;
		this.thirdParam = thirdDummy;
	}
	
	@Parameters
	public static Collection<Object[]> parameter(){
		Object[][] data = new Object[2][3];
		data[0][0] = "red";
		data[0][1] = "Valentine";
		data[0][2] = 1;
		data[1][0] = "wiki";
		data[1][1] = "wikipedia";
		data[1][2]=2;
		return Arrays.asList(data);
	}
	
	@Test
	public void searchKeywordTest(){
		System.out.println("Key is: "+keyword +" and output is: "+output);
		driver.get("http://www.sli-systems.com/");
	}
	

	@BeforeClass
	public static void beforeClassTestMethod(){
		System.out.println("beforeClassTestMethod();");
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@AfterClass
	public static void afterClassTestMethod(){
		System.out.println("afterClassTestMethod();");
	}
	@Before
	public void beforeTestMethod(){
		System.out.println("beforeTestMethod();");
	}
	@After
	public void afterTestMethod(){
		System.out.println("afterTestMethod();");
	}

	@Test
	public void testMethodOne(){
		System.out.println("testMethodOne();");
		assertEquals(true, 1>0);
	}
	@Test
	public void testMethodTwo(){
		System.out.println("testMethodTwo();");
		assertEquals(false, 1<0);
	}
	@Test
	public void testMethodThree(){
		System.out.println("testMethodThree();");
		assertEquals(true, 1<0);
	}
}
