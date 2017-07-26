package com.sureifylife;

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class QuotePage 
{
	public static int Totaltests = 1;
	public int passcount = 0;
	public int failcount = 0;
	public static String url = "http://stg.sureify.com/login/";
	public static String url_before_test;
	public static String url_after_test;
	public int testnum;
	
	public QuotePage()
	{
		
	}
	
	public QuotePage(int testnum,int passcount,int failcount)
	{
		this.testnum = testnum ;
		this.passcount = passcount;
		this.failcount = failcount;
	}
	
	
	
	public static void main(String[] args)throws Exception 
	{	
		QuotePage quotepage = new QuotePage();
		WebDriver obj = new FirefoxDriver();
		quotepage.getQuotebutton2(obj);
	}
		
	
		
	public void getQuotebutton2( WebDriver obj) throws InterruptedException
	{
		testnum++;
		System.out.println("\nTest " + testnum);
		System.out.println("\tTitle: Click on Get Quote Button ");
		System.out.println("\tInput: N/A" );
		url_before_test= obj.getCurrentUrl();


		if(obj.findElement(By.xpath("html/body/div[3]/div[1]/div/center/div[2]/a")).isDisplayed())
		{
			obj.findElement(By.xpath("html/body/div[3]/div[1]/div/center/div[2]/a")).click();
			Thread.sleep(5000);
			System.out.println("\tStatus: Clicked on Get Quote Button"  );
    		System.out.println("\tTest" + Totaltests + "- PASSED");
    		passcount++;
			url_after_test= obj.getCurrentUrl();
			
			Totaltests++;
			System.out.println("\nTest " + Totaltests);
			System.out.println("\tTitle: Redirect to  Get Quote Page ");
			System.out.println("\tInput: N/A" );
			if( url_before_test.matches(url_after_test))
			{
				System.out.println("\tStatus: Not redirected to  Get Quote Page"  );
	    		System.out.println("\tTest" + Totaltests + "- FAILED");
	    		failcount++;

			}
			else
			{
				System.out.println("\tStatus: Redirected to  Get Quote Page"  );
	    		System.out.println("\tTest" + Totaltests + "- Passed");
	    		passcount++;	
			}
		}
		else
		{
			System.out.println("\tStatus: Not Clicked on Get Quote Button"  );
    		System.out.println("\tTest" + Totaltests + "- FAILED");
    		failcount++;
		}

	}
	
	public int[] callAllMethodsQP(WebDriver obj) throws InterruptedException
	{
		getQuotebutton2(obj);
		int countarray[] = new int[3];
		countarray[0] = this.testnum;
		countarray[1] = this.passcount;
		countarray[2] = this.failcount;
 		return countarray;
	}

	}


