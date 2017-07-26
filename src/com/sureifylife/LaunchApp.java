package com.sureifylife;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class LaunchApp 
{	
	WebDriver driver = null;
	public static String[] planAmounts = 
		{
				"$250,000",
				"$500,000",
				"$750,000",
				"$100,000"
		};
	public static String planAmount = null;


	public LaunchApp(WebDriver driver){
		this.driver = driver;
	}

	/*public static void main(String[] args) throws Exception
	{
		launchapp.sitelaunch(driver);
		launchapp.lifeinsurance(driver);
		launchapp.learnmore(driver);
		launchapp.trysureify(driver);
		launchapp.startsaving(driver);
		launchapp.getrate(driver);
		launchapp.getstarted(driver);
		launchapp.getaquote(driver);
		launchapp.savings(driver);
		launchapp.learnmore_savings(driver);
		launchapp.getaquote_savings(driver);
		launchapp.pro_savings(driver);
		launchapp.plancomparision_savings(driver);
		launchapp.clogo(driver);
		launchapp.devices(driver);
		launchapp.learnmore_devices(driver);
		launchapp.getaquote_devices(driver);
		launchapp.pro_devices(driver);
		launchapp.dlogo(driver);
		launchapp.blog(driver);
		launchapp.blogo(driver);
		launchapp.getQuotebutton2(driver);

	}*/

	public void lifeinsurance() throws InterruptedException {
		Reporter.log("\tTitle: Click on Life Insurance link",true);
		Reporter.log("\tInput: N/A",true);
		String url_before_test = driver.getCurrentUrl();
		Thread.sleep(5000);
		Reporter.log("\tUrl_Before_Test: " + url_before_test,true);

		if(driver.findElement(By.id("how_it_works_link")).isDisplayed()){
			driver.findElement(By.id("how_it_works_link")).click();
			Thread.sleep(5000);
			Reporter.log("\tStatus: Clicked on Life Insurance link",true);
			Reporter.log("\tTEST - PASSED",true);

			String url_after_test= driver.getCurrentUrl();

			Reporter.log("\tTitle: Redirect to  Life Insurance Page ",true);
			Reporter.log("\tInput: N/A",true);
			if( url_before_test.matches(url_after_test)){
				Reporter.log("\tStatus: Not redirected to  Get Quote Page",true );
				Reporter.log("\tTEST - FAILED",true);
			}else{
				Reporter.log("\tUrl_After_Test: " + url_after_test,true);
				Reporter.log("\tStatus: Redirected to  Life Insurance Page",true);
				Reporter.log("\tTEST- PASSED",true);	
			}
		}else{
			Reporter.log("\tStatus: Not Clicked on Life Insurance Link" ,true );
			Reporter.log("\tTEST - FAILED",true);
		
		}
	}	


	public void learnmore() throws InterruptedException{

		Reporter.log("\tTitle: Click on Learn More Button in Life Insurance Page ",true);
		Reporter.log("\tInput: N/A" ,true);
		if(driver.findElement(By.id("learn")).isDisplayed()){
			driver.findElement(By.id("learn")).click();
			Thread.sleep(5000);
			Reporter.log("\tStatus: Clicked on Life Insurance link & Redirected to Try Sureify Scene." ,true );
			Reporter.log("\tTest - PASSED",true);
		}else{
			Reporter.log("\tStatus: Not Clicked on Life Insurance link & Not Redirected to Try Sureify Scene."  );
			Reporter.log("\tTest - FAILED",true);
		}	
	} 

	public void trysureify() throws InterruptedException{
		Reporter.log("\tTitle: Click on Try Sureify Button Should Redirect Basic Info Page ",true);
		Reporter.log("\tInput: N/A" ,true);
		String url_before_test= driver.getCurrentUrl();
		Reporter.log("\tUrl_Before_Test: " + url_before_test,true);
		if(driver.findElement(By.id("try")).isDisplayed()){

			driver.findElement(By.id("try")).click();
			Thread.sleep(3000);
			Reporter.log("\tInput: N/A",true );
			String url_after_test= driver.getCurrentUrl();
			Reporter.log("\tUrl_After_Test: " + url_after_test,true);
			Reporter.log("\tStatus: Redirected to Basic Info Page ",true);
			Reporter.log("\tTest - PASSED",true);
			Thread.sleep(5000);
			/*
			 * Navigate back to Life Insurance Page
			 */

			Reporter.log("\tTitle: Navigate back to Life Insurance Page",true);
			Reporter.log("\tInput: N/A" ,true);
			url_before_test= driver.getCurrentUrl();
			Reporter.log("\tUrl_Before_Test: " + url_before_test,true);

			driver.navigate().back();
			url_after_test= driver.getCurrentUrl();
			Reporter.log("\tUrl_After_Test: " + url_after_test,true);

			Reporter.log("\tStatus: Navigated back to Life Insurance Page",true);
			Reporter.log("\tTest - PASSED",true);		
		}else{
			Reporter.log("\tStatus: Not Clicked on Try Sureify Button "  ,true);
			Reporter.log("\tTest - FAILED");
		}

	}

	public void startsaving() throws InterruptedException{
		Reporter.log("\tTitle: Click on Start Savings Button",true);
		Reporter.log("\tInput: N/A",true );
		String url_before_test= driver.getCurrentUrl();
		Reporter.log("\tUrl_Before_Test: " + url_before_test,true);
		WebElement e = driver.findElement(By.id("start"));
		//adding script
		(new Actions(driver)).moveToElement(e).perform();
		if(e.isDisplayed()){
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click();", e); 
			Thread.sleep(3000);
			url_before_test= driver.getCurrentUrl();
			Reporter.log("\tUrl_Before_Test: " + url_before_test,true);
			Reporter.log("\tStatus: Clicked on Start Savings Button " ,true );
			Reporter.log("\tTest - PASSED",true);
			/*
			 * Navigate back to Life Insurance Page
			 */

			Reporter.log("\tTitle: Navigate back to Life Insurance Page",true);
			Reporter.log("\tInput: N/A" ,true);
			url_before_test= driver.getCurrentUrl();
			Reporter.log("\tUrl_Before_Test: " + url_before_test,true);
			driver.navigate().back();
			String url_after_test= driver.getCurrentUrl();
			Reporter.log("\tUrl_After_Test: " + url_after_test,true);
			Reporter.log("\tStatus: Navigated back to Life Insurance Page",true);
			Reporter.log("\tTest - PASSED");

		}else{
			Reporter.log("\tStatus: Not Clicked on Start Savings Button " ,true );
			Reporter.log("\tTest - FAILED",true);

		}
	}

	public void getrate() throws InterruptedException{

		Reporter.log("\tTitle: Click on Get Your Rate Button",true);
		Reporter.log("\tInput: N/A" ,true);
		String url_before_test= driver.getCurrentUrl();
		Reporter.log("\tUrl_Before_Test: " + url_before_test,true);

		WebElement e = driver.findElement(By.id("getrate"));
		//adding script
		(new Actions(driver)).moveToElement(e).perform();
		if(e.isDisplayed()){
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click();", e); 
			Thread.sleep(7000);
			url_before_test= driver.getCurrentUrl();
			Reporter.log("\tUrl_Before_Test: " + url_before_test,true);
			Reporter.log("\tStatus: Clicked on Get Your Rate Button " ,true );
			Reporter.log("\tTest - PASSED",true);
			/*
			 * Navigate back to Life Insurance Page
			 */

			Reporter.log("\tTitle: Navigate back to Life Insurance Page",true);
			Reporter.log("\tInput: N/A" ,true);
			url_before_test= driver.getCurrentUrl();
			Reporter.log("\tUrl_Before_Test: " + url_before_test,true);

			driver.navigate().back();
			String url_after_test= driver.getCurrentUrl();
			Reporter.log("\tUrl_After_Test: " + url_after_test,true);

			Reporter.log("\tStatus: Navigated back to Life Insurance Page",true);
			Reporter.log("\tTest - PASSED",true);

		}else{
			Reporter.log("\tStatus: Not Clicked on Get Your Rate Button " ,true );
			Reporter.log("\tTest - FAILED",true);

		}
	}

	public void getstarted() throws InterruptedException{
		Reporter.log("\tTitle: Click on Get Started Button",true);
		Reporter.log("\tInput: N/A" ,true);
		String  url_before_test= driver.getCurrentUrl();
		Reporter.log("\tUrl_Before_Test: " + url_before_test,true);

		WebElement e = driver.findElement(By.id("getstart"));
		//adding script
		(new Actions(driver)).moveToElement(e).perform();
		if(e.isDisplayed()){
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click();", e); 
			Thread.sleep(7000);
			url_before_test= driver.getCurrentUrl();
			Reporter.log("\tUrl_Before_Test: " + url_before_test,true);
			Reporter.log("\tStatus: Clicked on Get Started Button " ,true );
			Reporter.log("\tTest - PASSED",true);
			/*
			 * Navigate back to Life Insurance Page
			 */

			Reporter.log("\tTitle: Navigate back to Life Insurance Page",true);
			Reporter.log("\tInput: N/A" ,true);
			url_before_test= driver.getCurrentUrl();
			Reporter.log("\tUrl_Before_Test: " + url_before_test,true);

			driver.navigate().back();
			String url_after_test= driver.getCurrentUrl();
			Reporter.log("\tUrl_After_Test: " + url_after_test,true);
			Reporter.log("\tStatus: Navigated back to Life Insurance Page",true);
			Reporter.log("\tTest - PASSED");
		}else{
			Reporter.log("\tStatus: Not Clicked on Get Started Button " ,true );
			Reporter.log("\tTest - FAILED");

		}
	}

	public void getaquote() throws InterruptedException{
		Reporter.log("\tTitle: Click on Get a Quote Button",true);
		Reporter.log("\tInput: N/A",true );
		String url_before_test= driver.getCurrentUrl();
		Reporter.log("\tUrl_Before_Test: " + url_before_test,true);

		WebElement e = driver.findElement(By.id("getquote1"));
		//adding script
		(new Actions(driver)).moveToElement(e).perform();
		if(e.isDisplayed()){
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click();", e); 
			Thread.sleep(7000);
			url_before_test = driver.getCurrentUrl();
			Reporter.log("\tUrl_Before_Test: " + url_before_test,true);
			Reporter.log("\tStatus: Clicked on Get a Quote Button " ,true );
			Reporter.log("\tTest - PASSED",true);	
			/*
			 * Navigate back to Life Insurance Page
			 */

			Reporter.log("\tTitle: Navigate back to Home Page",true);
			Reporter.log("\tInput: N/A" ,true);
			url_before_test= driver.getCurrentUrl();
			Reporter.log("\tUrl_Before_Test: " + url_before_test,true);
			driver.findElement(By.id("header_logo")).click();
			//driver.navigate().back();
			String url_after_test= driver.getCurrentUrl();
			Reporter.log("\tUrl_After_Test: " + url_after_test,true);
			Reporter.log("\tStatus: Navigated back to Home Page",true);
			Reporter.log("\tTest - PASSED",true);
		}else{
			Reporter.log("\tStatus: Not Clicked on Get a Quote Button ",true  );
			Reporter.log("\tTest - FAILED",true);
		}
	}

	public void savings() throws InterruptedException{
		Reporter.log("\tTitle: Click on Savings link",true);
		Reporter.log("\tInput: N/A" ,true);
		String 	url_before_test= driver.getCurrentUrl();
		Reporter.log("\tUrl_Before_Test: " + url_before_test,true);

		if(driver.findElement(By.id("how_you_save_link")).isDisplayed()){
			driver.findElement(By.id("how_you_save_link")).click();
			Thread.sleep(3000);
			Reporter.log("\tStatus: Clicked on Savings link",true  );
			Reporter.log("\tTest - PASSED",true);	
			String  url_after_test= driver.getCurrentUrl();
			Reporter.log("\tTitle: Redirect to  Savings Page ",true);
			Reporter.log("\tInput: N/A",true );
			if( url_before_test.matches(url_after_test)){
				Reporter.log("\tStatus: Not redirected to  Savings Page" ,true );
				Reporter.log("\tTest - FAILED",true);
			}else{
				Reporter.log("\tUrl_After_Test: " + url_after_test,true);
				Reporter.log("\tStatus: Redirected to  Life Insurance Page"  );
				Reporter.log("\tTest - PASSED",true);
			}
		}else{
			Reporter.log("\tStatus: Not Clicked on Savings Link" ,true );
			Reporter.log("\tTest - FAILED",true);
		}

	}

	public void learnmore_savings( ) throws InterruptedException{
		Reporter.log("\tTitle: Click on Learn More Button in Savings Page ",true);
		Reporter.log("\tInput: N/A" ,true);
		if(driver.findElement(By.id("learn3")).isDisplayed()){
			driver.findElement(By.id("learn3")).click();
			Thread.sleep(3000);

			Reporter.log("\tStatus: Clicked on Learn More link & Redirected to Policy issues Scene." ,true );
			Reporter.log("\tTest - PASSED",true);
		}else{
			Reporter.log("\tStatus: Not Clicked on Savings link & Not Redirected to Policy issues Scene." ,true );
			Reporter.log("\tTest - FAILED",true);

		}
	}

	public void getaquote_savings() throws InterruptedException{
		Reporter.log("\tTitle: Click on Get a Quote Button In Savings page",true);
		Reporter.log("\tInput: N/A" ,true);
		WebElement e = driver.findElement(By.id("get_a_qte"));
		if(e.isDisplayed()){
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click();", e); 
			Thread.sleep(7000);
			Reporter.log("\tStatus: Clicked on Get a Quote Button In Savings page & Redirected to *Ready to pick a policy scene?*" ,true );
			Reporter.log("\tTest - PASSED",true);
		}else{
			Reporter.log("\tStatus: Not Clicked on Get a Quote Button In Savings page "  ,true);
			Reporter.log("\tTest - FAILED",true);
		}
	}

	public void pro_savings() throws InterruptedException{
		Thread.sleep(3000);
		Reporter.log("\tTitle: Click on 500k policy In Savings page",true);
		Reporter.log("\tInput: N/A",true );
		String[] planButtonIDs = 
			{
					"quote_platinum1",
					"quote_platinum2",
					"quote_platinum3",
					"quote_platinum4"
			};
		WebElement e = driver.findElement(By.xpath("//a[@id = '"+planButtonIDs[1]+"']"));
		//adding script
		(new Actions(driver)).moveToElement(e).perform();
		if(e.isDisplayed()){
			planAmount = planAmounts[1];
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click();", e); 
			Thread.sleep(7000);	
			Reporter.log("\tStatus: Clicked on 500k policy In Savings page & Redirected to *Basic Info Page*" ,true );
			Reporter.log("\tTest - PASSED",true);
		}else{
			Reporter.log("\tStatus: Not Clicked on Get a Quote Button In Savings page " ,true );
			Reporter.log("\tTest - FAILED",true);
		}
	}

	public void plancomparision_savings() throws InterruptedException{
        Thread.sleep(3000);
		Reporter.log("\tTitle: Click on 500k policy In Savings page",true);
		Reporter.log("\tInput: N/A" ,true);
		Select e = new Select(driver.findElement(By.id("coverage_amount")));
		Reporter.log("\t"+e.getFirstSelectedOption().getText(),true);
		if(planAmount != null){
			if(planAmount.equals(e.getFirstSelectedOption().getText())){
				Reporter.log("\tStatus: The Selected plan is appearing in Basic Info page",true);
				Reporter.log("\tTest - PASSED",true);
			}else{
				Reporter.log("\tStatus: The Selected plan is not appearing in Basic Info page",true);
				Reporter.log("\tTest  FAILED",true);
			}
		}
	}

	public void clogo() throws InterruptedException{
		Reporter.log("\tTitle: Navigate back to Home Page",true);
		Reporter.log("\tInput: N/A" ,true);
		String url_before_test= driver.getCurrentUrl();
		Reporter.log("\tUrl_Before_Test: " + url_before_test,true);
		driver.findElement(By.id("header_logo")).click();
		//driver.navigate().back();
		String url_after_test= driver.getCurrentUrl();
		Reporter.log("\tUrl_After_Test: " + url_after_test,true);

		Reporter.log("\tStatus: Navigated back to Home Page",true);
		Reporter.log("\tTest - PASSED",true);

	}

	public void devices() throws InterruptedException{
		Reporter.log("\tTitle: Click on Devices link",true);
		Reporter.log("\tInput: N/A" ,true);
		String url_before_test= driver.getCurrentUrl();
		Reporter.log("\tUrl_Before_Test: " + url_before_test,true);
		if(driver.findElement(By.id("millenial_products_link")).isDisplayed()){
			driver.findElement(By.id("millenial_products_link")).click();
			Thread.sleep(3000);
			Reporter.log("\tStatus: Clicked on Devices link" ,true );
			Reporter.log("\tTest - PASSED",true);
			String url_after_test= driver.getCurrentUrl();
			Reporter.log("\tTitle: Redirect to  Devices Page ",true);
			Reporter.log("\tInput: N/A",true );
			if( url_before_test.matches(url_after_test)){
				Reporter.log("\tStatus: Not redirected to  Devices Page" ,true );
				Reporter.log("\tTest - FAILED",true);
			}else{
				Reporter.log("\tUrl_After_Test: " + url_after_test);
				Reporter.log("\tStatus: Redirected to  Devices Page" ,true );
				Reporter.log("\tTest - PASSED",true);
			}
		}else{
			Reporter.log("\tStatus: Not Clicked on Devices Link" ,true );
			Reporter.log("\tTest - FAILED",true);
		}
	}

	public void learnmore_devices() throws InterruptedException{
		Reporter.log("\tTitle: Click on Learn More Button in Devices Page ",true);
		Reporter.log("\tInput: N/A" ,true);
		if(driver.findElement(By.id("get_quote1_v2b")).isDisplayed()){
			driver.findElement(By.id("get_quote1_v2b")).click();
			Thread.sleep(3000);
			Reporter.log("\tStatus: Clicked on Learn More link & Redirected to FITbit Scene."  ,true);
			Reporter.log("\tTest - PASSED",true);
		}else{
			Reporter.log("\tStatus: Not Clicked on Devices link & Not Redirected to Fitbit Scene." ,true );
			Reporter.log("\tTest - FAILED",true);
		}
	}

	public void getaquote_devices() throws InterruptedException{
		Reporter.log("\tTitle: Click on Get a Quote Button In Savings page",true);
		Reporter.log("\tInput: N/A" ,true);
		WebElement e = driver.findElement(By.id("getaqte"));
		if(e.isDisplayed()){
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click();", e); 
			Thread.sleep(7000);
			Reporter.log("\tStatus: Clicked on Get a Quote Button In Devices page & Redirected to *Ready to pick a policy scene?*" ,true );
			Reporter.log("\tTest - PASSED",true);
		}else{
			Reporter.log("\tStatus: Not Clicked on Get a Quote Button In Savings page "  );
			Reporter.log("\tTest - FAILED",true);
		}
	}

	public void pro_devices() throws InterruptedException{
		Reporter.log("\tTitle: Click on 700k policy In Savings page",true);
		Reporter.log("\tInput: N/A" ,true);
		String[] planButtonIDs = 
			{
					"quote_platinum1",
					"quote_platinum2",
					"quote_platinum3",
					"quote_platinum4"
			};
		WebElement e = driver.findElement(By.id(planButtonIDs[2]));
		if(e.isDisplayed()){
			planAmount = planAmounts[2];
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click();", e); 
			Thread.sleep(7000);	
			Reporter.log("\tStatus: Clicked on 700k policy In Savings page & Redirected to *Basic Info Page*" ,true );
			Reporter.log("\tTest - PASSED",true);	
		}else{
			Reporter.log("\tStatus: Not Clicked on Get a Quote Button In Savings page " ,true );
			Reporter.log("\tTest - FAILED",true);
		}
	}

	public void dlogo() throws InterruptedException{
		Reporter.log("\tTitle: Navigate back to Home Page",true);
		Reporter.log("\tInput: N/A",true );
		String url_before_test= driver.getCurrentUrl();
		Reporter.log("\tUrl_Before_Test: " + url_before_test,true);
		driver.findElement(By.id("header_logo")).click();
		//driver.navigate().back();
		String url_after_test= driver.getCurrentUrl();
		Reporter.log("\tUrl_After_Test: " + url_after_test,true);
		Reporter.log("\tStatus: Navigated back to Home Page",true);
		Reporter.log("\tTest - PASSED",true);
	}

	public void blog() throws InterruptedException{
		Reporter.log("\tTitle: Click on Blog link");
		Reporter.log("\tInput: N/A" );
		String url_before_test= driver.getCurrentUrl();
		Reporter.log("\tUrl_Before_Test: " + url_before_test,true);
		if(driver.findElement(By.xpath("html/body/div[2]/div/div[3]/div/nav/ul/li[4]/a")).isDisplayed()){
			driver.findElement(By.xpath("html/body/div[2]/div/div[3]/div/nav/ul/li[4]/a")).click();
			Thread.sleep(3000);
			Reporter.log("\tStatus: Clicked on Blog link" ,true );
			Reporter.log("\tTest - PASSED",true);	
			String url_after_test= driver.getCurrentUrl();
			Reporter.log("\tTitle: Redirect to  Blog Page ",true);
			Reporter.log("\tInput: N/A" ,true);
			if( url_before_test.matches(url_after_test)){
				Reporter.log("\tStatus: Not redirected to  Blog Page" ,true );
				Reporter.log("\tTest - FAILED");
			}else{
				Reporter.log("\tUrl_After_Test: " + url_after_test,true);
				Reporter.log("\tStatus: Redirected to  Blog Page" ,true );
				Reporter.log("\tTest - PASSED",true);	
			}
		}else{
			Reporter.log("\tStatus: Not Clicked on Blog Link" ,true );
			Reporter.log("\tTest - FAILED",true);
		}
	}

	public void blogo() throws InterruptedException{
		Reporter.log("\tTitle: Navigate back to Home Page",true);
		Reporter.log("\tInput: N/A",true );
		String url_before_test= driver.getCurrentUrl();
		Reporter.log("\tUrl_Before_Test: " + url_before_test,true);
		//driver.findElement(By.xpath("html/body/div[2]/header/div/div/div[1]/a/img[1]")).click();
		driver.navigate().back();
		Thread.sleep(5000);
		String url_after_test= driver.getCurrentUrl();
		Reporter.log("\tUrl_After_Test: " + url_after_test,true);
		Reporter.log("\tStatus: Navigated back to Home Page",true);
		Reporter.log("\tTest - PASSED",true);
	}


	public void getQuotebutton2() throws InterruptedException{
		Reporter.log("\tTitle: Click on Get Quote Button ",true);
		Reporter.log("\tInput: N/A" ,true);
		String url_before_test= driver.getCurrentUrl();

		if(driver.findElement(By.id("header_get a quote4")).isDisplayed()){

			driver.findElement(By.id("header_get a quote4")).click();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			Reporter.log("\tStatus: Clicked on Get Quote Button" ,true );
			Reporter.log("\tTest - PASSED",true);
			String url_after_test= driver.getCurrentUrl();
			Reporter.log("\tTitle: Redirect to Basic Info Page ",true);
			Reporter.log("\tInput: N/A" ,true);
			if( url_before_test.matches(url_after_test)){
				Reporter.log("\tStatus: Not redirected to  Basic Info Page" ,true );
				Reporter.log("\tTest - FAILED",true);

			}else{
				Reporter.log("\tStatus: Redirected to  Basic Info Page" ,true );
				Reporter.log("\tTest - PASSED",true);	
			}
		}else
		{
			Reporter.log("\tStatus: Not Clicked on Get Quote Button" ,true );
			Reporter.log("\tTest - FAILED",true);
		}

		/*Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMM-dd-yyyy h:mm:ss a");
		String formattedDate = sdf.format(date);
		Reporter.log("***********************************************************");
		Reporter.log("*\tTest Summary");
		Reporter.log("*\tTest Completion Time: " +formattedDate);
		Reporter.log("*\tNum of Tests:"+ testnum);
		Reporter.log("*\tNum of PASSED Tests:"+ passcount);
		Reporter.log("*\tNum of FAILED Tests:"+ failcount);
		Reporter.log("***********************************************************");
		driver.close();*/
	}

	
}
