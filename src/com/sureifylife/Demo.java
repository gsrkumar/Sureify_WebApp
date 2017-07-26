package com.sureifylife;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Demo 
{
	public int testnum = 0;
	public int passcount = 0;
	public int failcount = 0;

	public Demo(){

	}

	public Demo(int testnum, int passcount, int failcount)
	{
		this.testnum = testnum ;
		this.passcount = passcount;
		this.failcount = failcount;
	}


	//public String url = "https://stg.sureify.com/login/";
	public String msgemail = "* Email is required";
	public String msgpwd = "* Password is required";
	public String str_em;
	public String str_pswd;
	public String url_before_test;
	public String url_after_test;
	public String status;

	public int exists(String URLName){
		try {
			HttpURLConnection.setFollowRedirects(false);
			HttpURLConnection con = (HttpURLConnection) new URL(URLName).openConnection();
			//con.setRequestMethod("HEAD");

			//System.out.println(con.getResponseCode());
			Thread.sleep(5000);


			return con.getResponseCode();
		}
		catch (Exception e) {
			//e.printStackTrace();

			return 0;
		}

	}


	public static void main(String[] args) 
	{	 
		WebDriver obj=new FirefoxDriver();
		Demo demo = new Demo();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMM-dd-yyyy h:mm:ss a");
		String formattedDate = sdf.format(date);

		System.out.println("***********************************************************");
		System.out.println("*\tSelenium Automation Testing Log");
		System.out.println("*\tApplication : Existing User Flow");
		System.out.println("*\tExecution Start Time: " +formattedDate);
		System.out.println("*\tBuild Number: Not Available");
		System.out.println("***********************************************************");
		//demo.testnum++;
		

		System.out.println("\nTest " + demo.testnum);
		System.out.println("\tTitle: Launch Sureify Login page");
		String url = "https://stg.sureify.com/login/"; 
		System.out.println("\tInput:" + url);
		int status = demo.exists(url);

		if( status == 200 )
		{
			demo.testnum++;
			obj.get(url);
			obj.manage().window().maximize();
			System.out.println("\tStatus: " + url + " Launched" );
			System.out.println("\tTest" + demo.testnum + "- PASSED");
			demo.passcount++;
			
    		//TEST 1
			/*demo.ChkEmail(obj);
			
    		demo.ChkPwd(obj);
			
    		demo.Chklogin(obj);
			
    		demo.loginEmpty(obj);
			
			demo.loginEmailEmpty( obj);
			
			demo.loginPWDEmpty(obj);
			
			demo.loginInvalid(obj);
			
			demo.loginValid(obj);
		
			demo.connect(obj);
			demo.connectfitbit(obj);
			demo.email(obj);
			demo.password1(obj);
			demo.login(obj);
			demo.allow(obj);
			demo.sync(obj);
			demo.settings(obj);
			demo.disconnect(obj);
			demo.editProfile(obj);
			
			demo.uploadPic(obj);
			
			demo.uploadPic1(obj);
			
			demo.changepwd(obj);
			
			demo.changepwd1(obj);
			
			demo.changepwd2(obj);
			
			demo.backtodashboard(obj);
			
			demo.viewbill(obj);
			
			demo.paybill(obj);
			
			demo.paynow(obj);
			
			demo.history(obj);
			
			demo.payment(obj);
			
			demo.add(obj);
			
			//demo.cancel1(obj);
			
			demo.BacktoDashboard(obj);
			
			demo.MONTH(obj);
			
			demo.YEAR(obj);
			
			demo.LIFETIME(obj);
			
    		demo.stepsback(obj);
			
    		demo.stepsfar(obj);
			
    		demo.weightsback(obj);
			
    		demo.weightsfar(obj);
			
    		demo.activityback(obj);
			
    		demo.activityfar(obj);
			
    		demo.activity_showall(obj);
			
    		demo.Acceptnchallange(obj);
			demo.Activity(obj);
			
			
			//demo.quitchallange(obj);
			
			
			demo.SyncFitbit(obj);
			
			demo.Logout(obj);
			
			demo.ForgotPassword(obj);
			
			demo.login_textbox(obj);
			
			demo.Cancel(obj);
			*/
			
			
   		 //System.out.println("\tTotal Test Cases " +testnum);
			         }
		else
		{
			System.out.println("\tURL: " + url + " is Incorrect" );
			System.err.println("\tERROR: Cannot access '" + url );
			System.out.println("\tTest" + demo.testnum + "- FAILED");
			demo.failcount++;
		}

	}



	//Test 2
	/*public void loginEmpty( WebDriver obj) 
	{
		testnum++;

		System.out.println("\nTest" + testnum);
		System.out.println("\tTitle: Click Login Button With out entering Email and Password");
		url_before_test= obj.getCurrentUrl();

		//System.out.println("\tUrl_Before_Test: " + url_before_test);
		obj.findElement(By.name("email")).sendKeys("");
		obj.findElement(By.name("password")).sendKeys("");
		System.out.println("\tInput: email: "+"");
		System.out.println("\tInput: password:" +"");
		obj.findElement(By.xpath(".//*[@id='login_form']/div[5]/input")).click();
		url_after_test= obj.getCurrentUrl();

		//System.out.println("\tUrl_After_Test: " + url_after_test);

		if( url_before_test.matches(url_after_test))
		{
			str_em = obj.findElement(By.xpath("html/body/div[3]/div/div[2]/form/div[3]/div[2]")).getText();
			str_pswd = obj.findElement(By.xpath("html/body/div[3]/div/div[2]/form/div[3]/div[6]")).getText();

			System.out.println("\tStatus: " +" Should show Error messages like " + str_em + str_pswd );
			System.out.println("\tTest" + testnum + "- PASSED");
			passcount++;
		}
			else
			{
				System.out.println("\tTest" + testnum + "- FAILED");
				failcount++;
			}
		}*/
	
	public static void checkNumbers(Demo demo){
		System.out.println("Total Tests : "+demo.testnum);
		System.out.println("Pass Tests : "+demo.passcount);
		System.out.println("Fail Tests : "+demo.failcount);
	}
	//Check Email Field is available or not?
	public void ChkEmail( WebDriver obj)
	{
		testnum++;
		try{

			System.out.println("\nTest" + testnum);
			System.out.println("\tTitle: Check Email Field available or not?");

			if( obj.findElement(By.xpath("html/body/div[3]/div/div[2]/form/div[3]/div[2]/input")).isDisplayed())
			{

				System.out.println("\tStatus: Email Field is avilable ");
				System.out.println("\tTest" + testnum + "- PASSED");
				passcount++;
			}
			else
			{
				System.out.println("\tStatus: Email Field is not avilable");
				System.out.println("\tTest" + testnum + "- FAILED");
				failcount++;
			}
		}
		catch(Exception e)
		{
			System.out.println("\tStatus: Email Field is not avilable");
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}
	}
	//Check Password Field is available or not?
	public void ChkPwd( WebDriver obj) 
	{
		try{
			testnum++;
			System.out.println("\nTest" + testnum);
			System.out.println("\tTitle: Check Password Field available or not?");

			if( obj.findElement(By.xpath("html/body/div[3]/div/div[2]/form/div[3]/div[5]/input")).isDisplayed())
			{
				System.out.println("\tStatus: Password Field is avilable ");
				System.out.println("\tTest" + testnum + "- PASSED");
				passcount++;
			}
			else
			{
				System.out.println("\tStatus: Password Field is not avilable");
				System.out.println("\tTest" + testnum + "- FAILED");
				failcount++;
			}
		}
		catch(Exception e)
		{
			System.out.println("\tStatus: Password Field is not avilable");
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}
	}
	//Check Login button is available or not?
	public void Chklogin( WebDriver obj) 
	{	try
	{


		testnum++;
		System.out.println("\nTest" + testnum);
		System.out.println("\tTitle: Check Login Button available or not?");

		if( obj.findElement(By.name("login")).isDisplayed())
		{
			System.out.println("\tStatus: Login Button is avilable ");
			System.out.println("\tTest" + testnum + "- PASSED");
			passcount++;
		}
		else
		{
			System.out.println("\tStatus: Login Button is not avilable");
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}
	}
	catch(Exception e)
	{
		System.out.println("\tStatus: Login Button is not avilable");
		System.out.println("\tTest" + testnum + "- FAILED");
		failcount++;
	}
	}
	public void loginEmpty( WebDriver obj) 
	{
		try{
			testnum++;

			System.out.println("\nTest" + testnum);
			System.out.println("\tTitle: Click Login Button With out entering Email and Password");
			url_before_test= obj.getCurrentUrl();

			//System.out.println("\tUrl_Before_Test: " + url_before_test);
			obj.findElement(By.name("email")).sendKeys("");
			obj.findElement(By.name("password")).sendKeys("");
			System.out.println("\tInput: email: "+"");
			System.out.println("\tInput: password:" +"");
			obj.findElement(By.xpath(".//*[@id='login_form']/div[5]/input")).click();
			url_after_test= obj.getCurrentUrl();

			//System.out.println("\tUrl_After_Test: " + url_after_test);

			if( url_before_test.matches(url_after_test))
			{
				str_em = obj.findElement(By.xpath("html/body/div[3]/div/div[2]/form/div[3]/div[2]")).getText();
				str_pswd = obj.findElement(By.xpath("html/body/div[3]/div/div[2]/form/div[3]/div[6]")).getText();

				System.out.println("\tStatus: " +" Should show Error messages like " + str_em + str_pswd );
				System.out.println("\tTest" + testnum + "- PASSED");
				passcount++;
			}
			else
			{
				System.out.println("\tTest" + testnum + "- FAILED");
				failcount++;
			}
		}
		catch(Exception e)
		{
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}
	}

	//Test 3
	public void loginEmailEmpty( WebDriver obj )
	{
		try{
			testnum++;
			System.out.println("\nTest" + testnum);
			System.out.println("\tTitle: Click Login Button With out entering Email ");
			System.out.println("\tInput: email: ");
			System.out.println("\tInput: password: vendus123");
			obj.findElement(By.name("email")).sendKeys("");
			obj.findElement(By.name("password")).sendKeys("vendus123");
			obj.findElement(By.xpath(".//*[@id='login_form']/div[5]/input")).click();

			str_em = obj.findElement(By.xpath("html/body/div[3]/div/div[2]/form/div[3]/div[2]")).getText();
			str_pswd = obj.findElement(By.xpath("html/body/div[3]/div/div[2]/form/div[3]/div[6]")).getText();

			if(("").equals(str_pswd) && msgemail.equals(str_em))
			{
				System.out.println("\tStatus: " +" Should show Error message like Email Required" );
				System.out.println("\tTest" + testnum + "- PASSED");
				passcount++;
			}
			else
			{

				System.out.println("\tTest" + testnum + "- FAILED");
				failcount++;
			}
			obj.findElement(By.name("password")).clear();
		}
		catch(Exception e)
		{
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}
	}

	//Test 4
	public void loginPWDEmpty( WebDriver obj)
	{
		try
		{
			testnum++;

			System.out.println("\nTest " + testnum);
			System.out.println("\tTitle: Click Login Button With out entering Password ");
			System.out.println("\tInput: email: vijay@vendus.com ");
			System.out.println("\tInput: password:");

			obj.findElement(By.name("email")).sendKeys("vijay@vendus.com");
			obj.findElement(By.name("password")).sendKeys("");
			obj.findElement(By.xpath(".//*[@id='login_form']/div[5]/input")).click();

			str_em = obj.findElement(By.xpath("html/body/div[3]/div/div[2]/form/div[3]/div[2]/input")).getText();
			str_pswd = obj.findElement(By.xpath("html/body/div[3]/div/div[2]/form/div[3]/div[5]")).getText();

			if(("").equals(str_em) && (msgpwd).equals(str_pswd))
			{
				System.out.println("\tStatus: " +" Should show Error message like Password Required" );
				System.out.println("\tTest" + testnum + "- PASSED");
				passcount++;
			}
			else
			{
				System.out.println("\tTest" + testnum + "- FAILED");
				failcount++;
			}
		}
		catch(Exception e)
		{
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}
	}
	//Test-5
	public void  loginInvalid( WebDriver obj) 
	{
		try
		{
			testnum++;
			System.out.println("\nTest " + testnum);
			System.out.println("\tTitle: Login with Invalid Email & InvalidPassword");

			obj.findElement(By.name("email")).clear();
			obj.findElement(By.name("password")).clear();
			System.out.println("\tInput: email: test@vendus.com ");
			System.out.println("\tInput: password: test123");

			String url_before_test =obj.getCurrentUrl();

			obj.findElement(By.name("email")).sendKeys("test@vendus.com");
			obj.findElement(By.name("password")).sendKeys("test123");
			obj.findElement(By.xpath("html/body/div[3]/div/div[2]/form/div[5]/input")).click();
			obj.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String url_after_test=obj.getCurrentUrl();
			if( url_before_test.matches(url_after_test))
			{
				str_em = obj.findElement(By.xpath("html/body/div[3]/div/div[2]/form/div[2]")).getText();

				System.out.println("\tStatus: " +" Should show Error messages like: " + str_em );

				System.out.println("\tTest" + testnum + "- PASSED");
				passcount++;

			}
			else
			{
				System.out.println("\tStatus: " +" Login  FAILED " );
				System.out.println("\tTest" + testnum + "- FAILED");
				failcount++;

			}
		}
		catch(Exception e)
		{
			System.out.println("\tStatus: " +" Login  FAILED " );
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}
	}	


	//TEst 6
	public void  loginValid( WebDriver obj) 
	{
		try{


			testnum++;
			System.out.println("\nTest " + testnum);
			System.out.println("\tTitle: Login with valid Email & Password");

			obj.findElement(By.name("email")).clear();
			obj.findElement(By.name("password")).clear();
			System.out.println("\tInput: email: swati8591@gmail.com ");
			System.out.println("\tInput: password: swathi123");

			String homeurl=obj.getCurrentUrl();
			//System.out.println("\tUrl_Before_Test: " + homeurl);
			obj.findElement(By.name("email")).sendKeys("swati8591@gmail.com");
			obj.findElement(By.name("password")).sendKeys("Vendus@123");
			obj.findElement(By.xpath("html/body/div[3]/div/div[2]/form/div[5]/input")).click();
			Thread.sleep(5000);
			String dashboardurl=obj.getCurrentUrl();
			//System.out.println("\tUrl_After_Test: " + dashboardurl);
			if(homeurl!=dashboardurl)
			{
				System.out.println("\tStatus: " +" Should Login sucessfully & Redirected to Dashboard page" );
				System.out.println("\tTest" + testnum + "- PASSED");
				passcount++;

			}
			else
			{
				System.out.println("\tStatus: " +" Login  FAILED +" );
				System.out.println("\tTest" + testnum + "- FAILED");
				failcount++;

			}
		}
		catch(Exception e)
		{
			System.out.println("\tStatus: " +" Login  FAILED +" );
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}
	}	

	public void  connect( WebDriver obj) 
	{
		try{


			testnum++;
			System.out.println("\nTest " + testnum);
			System.out.println("\tTitle: Click on Connect Devices button");

			
			/*String homeurl=obj.getCurrentUrl();
			//System.out.println("\tUrl_Before_Test: " + homeurl);
			obj.findElement(By.name("email")).sendKeys("swati.gangisetty@gmail.com");
			obj.findElement(By.name("password")).sendKeys("abc@123");
			obj.findElement(By.xpath("html/body/div[3]/div/div[2]/form/div[5]/input")).click();
			String dashboardurl=obj.getCurrentUrl();*/
			//System.out.println("\tUrl_After_Test: " + dashboardurl);
			
			/*WebElement e = obj.findElement(By.xpath("html/body/div[4]/center/form/div/div[2]/div/div[7]/div[1]/div/a/img"));
	        if(e.isDisplayed())
			*/if(obj.findElement(By.id("connect")).isDisplayed())
				{
				
				obj.findElement(By.id("connect")).click();
				Thread.sleep(5000);
				/*obj.navigate().back();
				Thread.sleep(5000);*/
				System.out.println("\tStatus: " +" Clicked on Connect Devices button" );
				System.out.println("\tTest" + testnum + "- PASSED");
				passcount++;

			}
			else
			{
				System.out.println("\tStatus: Not Clicked on Connect Devices button  " );
				System.out.println("\tTest" + testnum + "- FAILED");
				failcount++;

			}
		}
		catch(Exception e)
		{
			System.out.println("\tStatus: " +" Not Clicked on Connect fitbit button " );
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}
	}	
	public void connectfitbit(WebDriver obj)
	{
		try{
			testnum++;
			System.out.println("\nTest " + testnum);
			System.out.println("\tTitle: Click on Connect button for Fitbit in the Devices list ");
			obj.findElement(By.xpath("html/body/div[3]/div/div[2]/div/div/div[4]/div[4]/div/input")).click();
			Thread.sleep(5000);
			System.out.println("\tStatus: Clicked on Connect button for Fitbit in the Devices list ");
			System.out.println("\tTest" + testnum + "- PASSED");
			passcount++;
		}
		catch (Exception e)
		{
			System.out.println("\tStatus: " +" Not Clicked on Connect button " );
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}
	}
	
	public void email(WebDriver obj)
	{
		try{
			testnum++;
			System.out.println("\nTest " + testnum);
			System.out.println("\tTitle: Enter Email ");
			obj.findElement(By.xpath("html/body/div[1]/section[1]/div[4]/div[1]/div/div[3]/form/fieldset/dl/dd[1]/input")).sendKeys("vijay@vendus.com");
			Thread.sleep(3000);
			System.out.println("\tStatus: Email Entered ");
			System.out.println("\tTest" + testnum + "- PASSED");
			passcount++;
		}
		catch (Exception e)
		{
			System.out.println("\tStatus: " +" Not Entered Email " );
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}
	}
	public void password1(WebDriver obj)
	{
		try{
			testnum++;
			System.out.println("\nTest " + testnum);
			System.out.println("\tTitle: Enter Password ");
			obj.findElement(By.xpath("html/body/div[1]/section[1]/div[4]/div[1]/div/div[3]/form/fieldset/dl/dd[2]/input")).sendKeys("vendus123");
			Thread.sleep(3000);
			System.out.println("\tStatus: Password Entered ");
			System.out.println("\tTest" + testnum + "- PASSED");
			passcount++;
		}
		catch (Exception e)
		{
			System.out.println("\tStatus: " +" Not Entered Password " );
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}
	}
	
	public void login(WebDriver obj)
	{
		try{
			testnum++;
			System.out.println("\nTest " + testnum);
			System.out.println("\tTitle: Click on Login ");
			obj.findElement(By.xpath("html/body/div[1]/section[1]/div[4]/div[1]/div/div[3]/form/div[1]/button")).click();
			Thread.sleep(3000);
			System.out.println("\tStatus: Clicked on Login ");
			System.out.println("\tTest" + testnum + "- PASSED");
			passcount++;
		}
		catch (Exception e)
		{
			System.out.println("\tStatus: " +" Not Clicked on Login " );
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}
	}
	
	public void allow(WebDriver obj)
	{
		try{
			testnum++;
			System.out.println("\nTest " + testnum);
			System.out.println("\tTitle: Click on Allow ");
			obj.findElement(By.id("allow-button")).click();
			Thread.sleep(3000);
			System.out.println("\tStatus: Clicked on Login ");
			System.out.println("\tTest" + testnum + "- PASSED");
			passcount++;
		}
		catch (Exception e)
		{
			System.out.println("\tStatus: " +" Not Clicked on Login " );
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}
	}
	public void sync(WebDriver obj)
	{
		try{
			testnum++;
			System.out.println("\nTest " + testnum);
			System.out.println("\tTitle: Click on Sync ");
			obj.findElement(By.id("sync_button")).click();
			Thread.sleep(3000);
			System.out.println("\tStatus: Clicked on Sync ");
			System.out.println("\tTest" + testnum + "- PASSED");
			passcount++;
		}
		catch (Exception e)
		{
			System.out.println("\tStatus: " +" Not Clicked on Sync " );
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}
	}
	public void settings(WebDriver obj)
	{
		try{
			testnum++;
			System.out.println("\nTest " + testnum);
			System.out.println("\tTitle: Click on Settings Icon In Left side menu ");
			obj.findElement(By.xpath("html/body/div[3]/div[1]/div[1]/div[10]/div[2]/a/div")).click();
			Thread.sleep(3000);
			System.out.println("\tStatus: Clicked on Settings Icon In Left side menu ");
			System.out.println("\tTest" + testnum + "- PASSED");
			passcount++;
		}
		catch (Exception e)
		{
			System.out.println("\tStatus: " +" Not Clicked on Settings Icon In Left side menu " );
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}
	}
	public void disconnect(WebDriver obj)
	{
		try{
			testnum++;
			System.out.println("\nTest " + testnum);
			System.out.println("\tTitle: Click on Disconnect ");
			obj.findElement(By.xpath("html/body/div[3]/div/div[2]/div/div/div[4]/div[4]/div/input")).click();
			Thread.sleep(5000);
			System.out.println("\tStatus: Clicked on Disconnect ");
			System.out.println("\tTest" + testnum + "- PASSED");
			passcount++;
		}
		catch (Exception e)
		{
			System.out.println("\tStatus: " +" Not Clicked on Disconnect " );
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}
	}
	//Test 6
	public void  editProfile( WebDriver obj) 
	{
		try{
			testnum++;
			System.out.println("\nTest " + testnum);
			System.out.println("\tTitle: Click on Etitprofile Button ");
			WebDriverWait wait = new WebDriverWait(obj,10);
			url_before_test= obj.getCurrentUrl();
			System.out.println("\tUrl_Before_Test: " + url_before_test);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit_profile"))).click();
			Thread.sleep(3000);
			url_after_test= obj.getCurrentUrl();
			System.out.println("\tUrl_Before_Test: " + url_after_test);
			if(url_before_test!=url_after_test)
			{
				System.out.println("\tStatus: " +" Edit Profile Page opened " );
				System.out.println("\tTest" + testnum + "- PASSED");
				passcount++;
			}
			else
			{
				System.out.println("\tStatus: " + " Edit Profile Page not opened   " );
				System.out.println("\tTest" + testnum + "- FAILED");
				failcount++;
			}
		}
		catch(Exception e)
		{
			System.out.println("\tStatus: " + " Edit Profile Page not opened   " );
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}
		// Test 6.1

		testnum++;
		try
		{
			if(obj.findElement(By.id("location")).isDisplayed())
			{

				obj.findElement(By.id("location")).clear();
				Thread.sleep(1000);
				System.out.println("\nTest" + testnum);
				System.out.println("\tTitle: Clear Location ");
				System.out.println("\tStatus: " +" Location Cleared" );
				System.out.println("\tTest" + testnum + "- PASSED");
				System.out.println("\tTitle: Enter Location ");
				System.out.println("\tInput: India");
				obj.findElement(By.id("location")).sendKeys("India");
				System.out.println("\tStatus: " +"  Location Entered" );
				System.out.println("\tTest" + testnum + "- PASSED");

				passcount++;
			}
			else
			{
				System.out.println("\tStatus: " +" Location is not cleared" );
				System.out.println("\tTest" + testnum + "- FAILED");
				failcount++;
			}
		}
		catch(Exception e)
		{
			System.out.println("\tStatus: " +" Location is not cleared" );
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}


		// Test 6.2	
		testnum++;
		try
		{
			System.out.println("\nTest" + testnum);
			System.out.println("\tTitle: Clear Mobile number");
			Actions a = new Actions(obj);
			a.sendKeys(Keys.TAB).build().perform();
			if(obj.findElement(By.id("phone_number")).isDisplayed())
			{

				obj.findElement(By.id("phone_number")).clear();
				System.out.println("\tStatus: " +" Mobile number cleared" );
				System.out.println("\tTest" + testnum + "- PASSED");
				System.out.println("\tTitle: Enter Mobile number");
				System.out.println("\tInput: 8977238999");
				obj.findElement(By.id("phone_number")).sendKeys("8977238999");
				System.out.println("\tStatus: " +" Mobile number entered" );
				System.out.println("\tTest" + testnum + "- PASSED");
				passcount++;
			}
			else
			{
				System.out.println("\tStatus: " +" Mobile number is not entered " );
				System.out.println("\tTest" + testnum + "- FAILED");
				failcount++;
			}
		}
		catch(Exception e)
		{
			System.out.println("\tStatus: " +" Mobile number is not entered " );
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}
	}
	// Test 7		
	public void  uploadPic(WebDriver obj)
	{	


		try{
			testnum++;
			System.out.println("\nTest" + testnum );
			System.out.println("\tTitle: Upload Profile Pic");
			if(obj.findElement(By.xpath("html/body/div[3]/div/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div")).isDisplayed())
			{
				obj.findElement(By.xpath("html/body/div[3]/div/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div")).click();
				Thread.sleep(2000);
			}
			else
			{
				System.out.println("\tTitle: Chanage photo button is not appered");
			}
			if(obj.findElement(By.name("file")).isDisplayed())
			{
				obj.findElement(By.name("file")).click();
				//System.out.println("\t Input C:\\Users\\Swathi\\Downloads\\testpng.png");
				//String img_before = "/assets/uploadedfiles/profile_pictures/dusty.png";
				StringSelection s = new StringSelection("C:\\Users\\Swathi\\Downloads\\dusty.png");
				Thread.sleep(5000);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_CONTROL);
				r.keyPress(KeyEvent.VK_V);
				r.keyRelease(KeyEvent.VK_V);
				r.keyRelease(KeyEvent.VK_CONTROL);
				r.delay(3000);
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(5000);
				obj.findElement(By.id("submit_button")).click();
				//obj.findElement(By.xpath("//input[@type='submit'][@class='col-md-offset-2 col-md-8 pt5 pb5 ok_btn f14 fw700 col-md-12 mt10 mb10']")).click();
				Thread.sleep(5000);   
				
				obj.findElement(By.xpath("html/body/div[3]/div/div[2]/div[5]/div/div/div/center/a")).click();
				Thread.sleep(6000);
				
				Thread.sleep(3000);
				System.out.println("\tTest" +testnum  + "- PASSED ");
				//obj.findElement(By.xpath("html/body/div[3]/div/div[2]/div[1]/div[1]/div[2]/a")).click();
				Thread.sleep(5000);
				passcount++;
			}
			else
			{
				System.out.println("\tStatus: " +" Save Button is not working" );
				System.out.println("\tTest" +testnum  + "- FAILED");
				failcount++;
			}

		}
		catch(Exception e)
		{
			System.out.println("\tStatus: " +" Save Button is not working" );
			System.out.println("\tTest" +testnum  + "- FAILED");
			failcount++;
		}
	}
	public void  uploadPic1(WebDriver obj)
	{	


		try{
			testnum++;
			System.out.println("\nTest" + testnum );
			System.out.println("\tTitle: Upload Profile Pic");
			if(obj.findElement(By.xpath("html/body/div[3]/div/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div")).isDisplayed())
			{
				obj.findElement(By.xpath("html/body/div[3]/div/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div")).click();
				Thread.sleep(2000);
				
			}
			else
			{
				System.out.println("\tTitle: Chanage photo button is not appered");
				
			}
			if(obj.findElement(By.name("file")).isDisplayed())
			{
				obj.findElement(By.name("file")).click();
				//System.out.println("\t Input C:\\Users\\Swathi\\Downloads\\testpng.png");
				//String img_before = "/assets/uploadedfiles/profile_pictures/dusty.png";
				StringSelection s = new StringSelection("C:\\Users\\Swathi\\Downloads\\tumblr_nyxrlsrDsI1s5f7v4o1_1280.gif");
				Thread.sleep(5000);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_CONTROL);
				r.keyPress(KeyEvent.VK_V);
				r.keyRelease(KeyEvent.VK_V);
				r.keyRelease(KeyEvent.VK_CONTROL);
				r.delay(3000);
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(5000);
				obj.findElement(By.id("submit_button")).click();
				Thread.sleep(5000);
				//obj.findElement(By.xpath("//input[@type='submit'][@class='col-md-offset-2 col-md-8 pt5 pb5 ok_btn f14 fw700 col-md-12 mt10 mb10']")).click();
				/*   
				String msg=obj.findElement(By.xpath("//label[@for='file']")).getText();*/
				//String msg = obj.findElement(By.xpath("html/body/div[3]/div/div[2]/div[2]/div/div/div/div[2]/form/div/label")).getText();
				//System.out.println(msg);
				System.out.println("\tStatus: " +" Save Button is  working" );
				obj.findElement(By.xpath("html/body/div[3]/div/div[2]/div[2]/div/div/div/div[2]/form/center/input")).click();
											
				Thread.sleep(6000);
				System.out.println("\tStatus: " +" Invalid file " );
				obj.findElement(By.xpath("html/body/div[3]/div/div[2]/div[2]/div/div/div/div[1]/a/img")).click();
				//html/body/div[3]/div/div[2]/div[2]/div/div/div/div[1]/a/img
				Thread.sleep(5000);
				System.out.println("\tTest" +testnum  + "- PASSED ");
				//obj.findElement(By.xpath("html/body/div[3]/div/div[2]/div[1]/div[1]/div[2]/a")).click();
				
				passcount++;
			}
			else
			{
				System.out.println("\tStatus: " +" Save Button is not working" );
				System.out.println("\tTest" +testnum  + "- FAILED");
				failcount++;
			}

		}
		catch(Exception e)
		{
			System.out.println("\tStatus: " +" Save Button is not working" );
			System.out.println("\tTest" +testnum  + "- FAILED");
			failcount++;
		}
	}

	public void  changepwd(WebDriver obj)
	{
		try
		{
			testnum++;
			System.out.println("\nTest" + testnum );
			System.out.println("\tTitle: Click on change password");
			if(obj.findElement(By.id("change_password")).isDisplayed())
			{
				obj.findElement(By.id("change_password")).click();
				System.out.println("\tStatus: " +" Clicked on Change password Button is  Successfully" );
				Thread.sleep(5000);
				WebElement e = obj.findElement(By.id("old_password"));
				if(e.isDisplayed())
				{
					e.sendKeys("Vendus@123");
					Thread.sleep(5000);
					Actions a = new Actions(obj);
					a.sendKeys(Keys.TAB);
					//obj.findElement(By.name("new_password")).sendKeys("vendus123");
					obj.findElement(By.name("password")).sendKeys("Vendus@123");
					a.sendKeys(Keys.TAB);
					//obj.findElement(By.name("r_new_password")).sendKeys("vendus123");
					obj.findElement(By.name("passconf")).sendKeys("Vendus@123");
					a.sendKeys(Keys.TAB);
					obj.findElement(By.xpath("html/body/div[3]/div/div[2]/div[3]/div/div/div/div[2]/form/center/input")).click();
					Thread.sleep(5000);

					String msg = obj.findElement(By.id("success_msg")).getText();
					System.out.println("\tStatus: " +msg );
					obj.findElement(By.linkText("OK")).click();
					Thread.sleep(5000);
					System.out.println("\tTest" +testnum  + "- PASSED ");
					passcount++;

					

				}
			}
			else
			{
				System.out.println("\tStatus: " +" Not  Clicked on Change password Button is  Successfully" );
				System.out.println("\tTest" +testnum  + "- FAILED");
				failcount++;

			}
		}
		catch(Exception e)
		{
			System.out.println("\tStatus: " +" Not  Clicked on Change password Button is  Successfully" );
			System.out.println("\tTest" +testnum  + "- FAILED");
			failcount++;
		}
	}

//input different pwds in  new password and confirm password
	public void  changepwd1(WebDriver obj)
	{
		try
		{
			testnum++;
			System.out.println("\nTest" + testnum );
			System.out.println("\tTitle: Click on change password");
			if(obj.findElement(By.id("change_password")).isDisplayed())
			{
				obj.findElement(By.id("change_password")).click();
				System.out.println("\tStatus: " +" Clicked on Change password Button is  Successfully" );
				Thread.sleep(5000);
				WebElement e = obj.findElement(By.id("old_password"));
				if(e.isDisplayed())
				{
					e.sendKeys("Vendus@123");
					Thread.sleep(5000);
					Actions a = new Actions(obj);
					a.sendKeys(Keys.TAB);
					obj.findElement(By.name("password")).sendKeys("Vendus@123");
					a.sendKeys(Keys.TAB);
					obj.findElement(By.name("passconf")).sendKeys("Vendus@321");
					a.sendKeys(Keys.TAB);
					obj.findElement(By.xpath("html/body/div[3]/div/div[2]/div[3]/div/div/div/div[2]/form/center/input")).click();
					Thread.sleep(5000);

					String msg = obj.findElement(By.xpath("html/body/div[3]/div/div[2]/div[3]/div/div/div/div[2]/form/div[3]/label")).getText();
					System.out.println("\tStatus: " +msg );
					obj.findElement(By.id("close")).click();
					Thread.sleep(5000);
					System.out.println("\tTest" +testnum  + "- PASSED ");
					passcount++;

					

				}
			}
			else
			{
				System.out.println("\tStatus: " +" Not  Clicked on Change password Button is  Successfully" );
				System.out.println("\tTest" +testnum  + "- FAILED");
				failcount++;

			}
		}
		catch(Exception e)
		{
			System.out.println("\tStatus: " +" Not  Clicked on Change password Button is  Successfully" );
			System.out.println("\tTest" +testnum  + "- FAILED");
			failcount++;
		}
	}
	
	// change password
	public void  changepwd2(WebDriver obj)
	{
		try
		{
			testnum++;
			System.out.println("\nTest" + testnum );
			System.out.println("\tTitle: Click on change password");
			if(obj.findElement(By.id("change_password")).isDisplayed())
			{
				obj.findElement(By.id("change_password")).click();
				System.out.println("\tStatus: " +" Clicked on Change password Button is  Successfully" );
				Thread.sleep(5000);
				WebElement e = obj.findElement(By.id("old_password"));
				if(e.isDisplayed())
				{
					e.sendKeys("swathi123");
					Thread.sleep(5000);
					Actions a = new Actions(obj);
					a.sendKeys(Keys.TAB);
					obj.findElement(By.name("password")).sendKeys("Vendus@123");
					a.sendKeys(Keys.TAB);
					obj.findElement(By.name("passconf")).sendKeys("Vendus@123");
					a.sendKeys(Keys.TAB);
					obj.findElement(By.xpath("html/body/div[3]/div/div[2]/div[3]/div/div/div/div[2]/form/center/input")).click();
					Thread.sleep(5000);

					String msg = obj.findElement(By.id("success_msg")).getText();
					System.out.println("\tStatus: " +msg );
					obj.findElement(By.linkText("OK")).click();
					Thread.sleep(5000);
					System.out.println("\tTest" +testnum  + "- PASSED ");
					passcount++;

					

				}
			}
			else
			{
				System.out.println("\tStatus: " +" Not  Clicked on Change password Button is  Successfully" );
				System.out.println("\tTest" +testnum  + "- FAILED");
				failcount++;

			}
		}
		catch(Exception e)
		{
			System.out.println("\tStatus: " +" Not  Clicked on Change password Button is  Successfully" );
			System.out.println("\tTest" +testnum  + "- FAILED");
			failcount++;
		}
	}
	// Test 8		
	public void  backtodashboard(WebDriver obj)
		{
			try
			{
			testnum++;
			System.out.println("\nTest" + testnum );
			System.out.println("\tTitle: Back to Dashboard");
			url_before_test= obj.getCurrentUrl();
			obj.findElement(By.linkText("Back to Dashboard")).click();
			url_after_test= obj.getCurrentUrl();
			if(url_before_test!=url_after_test )
			{
				System.out.println("\tStatus: Redirected to Back to Dashboard successfully");
				System.out.println("\tTest" + testnum + "- PASSED");
				passcount++;
			}
			else
			{
				System.out.println("\tStatus: Not Redirected to Back to Dashboard ");
				System.out.println("\tTest" + testnum + "- FAILED");
				failcount++;

			}
			//Thread.sleep(3000);
			 }
			 catch(Exception e)
			 {
			 	System.out.println("\tStatus: Not Redirected to Back to Dashboard ");
				System.out.println("\tTest" + testnum + "- FAILED");
				failcount++;
			 }
		}
	
	//View Bill Test 9
	public void  viewbill(WebDriver obj)
	{
		try{
			testnum++;
			System.out.println("\nTest" + testnum);
			System.out.println("\tTitle: Click Viewbill ");
			url_before_test= obj.getCurrentUrl();
			obj.findElement(By.linkText("View Bill")).click();
			url_after_test= obj.getCurrentUrl();
			if(url_before_test!=url_after_test )
			{
				System.out.println("\tStatus: Redirected to View bill page successfully");
				System.out.println("\tTest" + testnum + "- PASSED");
				passcount++;
			}
			else
			{
				System.out.println("\tStatus: Not Redirected to View bill page ");
				System.out.println("\tTest" + testnum + "- FAILED");
				failcount++;
			}
			Thread.sleep(10000);

			Robot r =new Robot();
			r.keyPress(KeyEvent.VK_PAGE_UP);
			r.keyRelease(KeyEvent.VK_PAGE_UP);
		} 
		catch (Exception e){
			System.out.println("\tStatus: Not Redirected to View bill page ");
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}
	}

	public void  paybill(WebDriver obj)
	{
		try
		{
			testnum++;
			System.out.println("\nTest" + testnum);
			System.out.println("\tTitle: Click Paybill ");
			if(obj.findElement(By.xpath("html/body/div[3]/div/div[2]/div[2]/div/div/div[2]/div[1]/div[1]/div/div[1]/div[2]/a")).isDisplayed())
			{
				obj.findElement(By.xpath("html/body/div[3]/div/div[2]/div[2]/div/div/div[2]/div[1]/div[1]/div/div[1]/div[2]/a")).click();
				System.out.println("\tStatus: Paybill button clicked successfully ");
				System.out.println("\tTest" + testnum + "- PASSED");
				passcount++;

			}
			else
			{
				System.out.println("\tStatus: Paybill button not clicked successfully ");
				System.out.println("\tTest" + testnum + "- FAILED");
				failcount++;
			}
		}
		catch(Exception e)
		{
			System.out.println("\tStatus: Paybill button not clicked successfully ");
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}
	}
	public void  paynow(WebDriver obj)
	{
		try
		{


			testnum++;
			System.out.println("\nTest" + testnum);
			System.out.println("\tTitle: Click Paynow ");
			if(obj.findElement(By.xpath("html/body/div[3]/div/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/form/div/div/div[5]/label")).isDisplayed())
			{
				obj.findElement(By.xpath("html/body/div[3]/div/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/form/div/div/div[5]/label")).click();
				obj.findElement(By.xpath("html/body/div[3]/div/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/form/div/div/div[7]/a")).click();
				obj.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				status = obj.findElement(By.xpath(".//*[@class='f18 f700 lh22 payment_status']")).getText();
				//status = obj.findElement(By.id("currentbill")).getText();

				System.out.println("\tStatus: "+status );
				System.out.println("\tTest" + testnum + "- PASSED");
				passcount++;
			}
			else
			{
				System.out.println("\tStatus: "+status );
				System.out.println("\tTest" + testnum + "- FAILED");
				failcount++;

			}
		}
		catch(Exception e)
		{
			System.out.println("\tStatus: "+status );
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}
	}
	//Click History Test 10
	public void  history(WebDriver obj)
	{ 
		try

		{

			testnum++;
			System.out.println("\nTest" + testnum);
			System.out.println("\tTitle: Click History ");
			if(obj.findElement(By.linkText("History")).isDisplayed())
			{
				WebDriverWait wt = new WebDriverWait(obj,10);
				wt.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("History"))).click();
				System.out.println("\tStatus: History button clicked successfully ");
				System.out.println("\tTest" + testnum + "- PASSED");
				passcount++;
			}
			else
			{
				System.out.println("\tStatus: Not Redirected to History page ");
				System.out.println("\tTest" + testnum + "- FAILED");
				failcount++;

			}
		}
		catch(Exception e)
		{
			System.out.println("\tStatus: Not Redirected to History page ");
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}
	}
	//Click on Payment Test 11
	public void  payment(WebDriver obj)
	{
		try
		{
			testnum++;
			System.out.println("\nTest" + testnum);
			System.out.println("\tTitle: Click Payment ");
			if(obj.findElement(By.linkText("Payment")).isDisplayed())
			{
				obj.findElement(By.linkText("Payment")).click();
				System.out.println("\tStatus: Payment link clicked successfully and payment page opened ");
				System.out.println("\tTest" + testnum + "- PASSED");
				passcount++;
			}
			else
			{
				System.out.println("\tStatus: Not Redirected to Payment page ");
				System.out.println("\tTest" + testnum + "- FAILED");
				failcount++;

			}
		}
		catch(Exception e)
		{
			System.out.println("\tStatus: Not Redirected to Payment page ");
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}
	}
	public void  add(WebDriver obj)
	{
		try
		{
			testnum++;
			System.out.println("\nTest" + testnum);
			System.out.println("\tTitle: Click on Add Button ");
			System.out.println("\tInput: N/A ");
			if(obj.findElement(By.linkText("Add")).isDisplayed())
			{
				obj.findElement(By.linkText("Add")).click();
				Thread.sleep(3000);
				System.out.println("\tStatus: Clicked on Add Button successfully ");
				System.out.println("\tTest" + testnum + "- PASSED");
				passcount++;
				if(obj.findElement(By.name("card_number")).isDisplayed())
				{				
					testnum++;
					System.out.println("\nTest" + testnum);
					System.out.println("\tTitle: Enter Card Number ");
					System.out.println("\tInput: 5105105105105100 " );

					obj.findElement(By.name("card_number")).sendKeys("5105105105105100");
					System.out.println("\tStatus: Card number entered successfully ");
					System.out.println("\tTest" + testnum + "- PASSED");
					passcount++;

					Actions a = new Actions(obj);
					a.sendKeys(Keys.TAB);
					testnum++;
					System.out.println("\nTest" + testnum);
					System.out.println("\tTitle: Enter Expiry Month ");
					System.out.println("\tInput: 11" );

					obj.findElement(By.name("expiry_month")).click();
					obj.findElement(By.name("expiry_month")).sendKeys("11");
					System.out.println("\tStatus: Expiry month entered successfully ");
					System.out.println("\tTest" + testnum + "- PASSED");

					passcount++;
					a.sendKeys(Keys.TAB);
					testnum++;
					System.out.println("\nTest" + testnum);
					System.out.println("\tTitle: Enter Expiry Year ");
					System.out.println("\tInput: 2018");
					obj.findElement(By.name("expiry_year")).click();
					obj.findElement(By.name("expiry_year")).sendKeys("2018");
					System.out.println("\tStatus: Expiry year entered successfully ");
					System.out.println("\tTest" + testnum + "- PASSED");

					passcount++;

					a.sendKeys(Keys.TAB);
					testnum++;
					System.out.println("\nTest" + testnum);
					System.out.println("\tTitle: Enter  CVV ");
					System.out.println("\tInput: 123");
					obj.findElement(By.name("security_code")).click();
					
					obj.findElement(By.name("security_code")).sendKeys("123");
					System.out.println("\tStatus: CVV entered successfully ");
					System.out.println("\tTest" + testnum + "- PASSED");

					passcount++;

					a.sendKeys(Keys.TAB);
					testnum++;
					System.out.println("\nTest" + testnum);
					System.out.println("\tTitle: Click on Add Paymeny Button ");
					System.out.println("\tInput: N/A");
					obj.findElement(By.id("update_payment_btn")).click();
					Thread.sleep(5000);
					System.out.println("\tStatus: Clicked Add Paymeny Button successfully ");
					System.out.println("\tTest" + testnum + "- PASSED");

					passcount++;


				}
				else
				{
					System.out.println("\tStatus: Card number not entered successfully ");
					System.out.println("\tTest" + testnum + "- FAILED");

					failcount++;

				}
			}
			else
			{
				System.out.println("\tTitle: Not Clicked on Add Button ");
				System.out.println("\tTest" + testnum + "- FAILED");

				failcount++;
			}
		}
		catch(Exception e)
		{
			System.out.println("\tTitle: Not Clicked on Add Button ");
			System.out.println("\tTest" + testnum + "- FAILED");

			failcount++;
		}
	}
	
	public void  cancel1(WebDriver obj)
	{
		try
		{
			testnum++;
			System.out.println("\nTest" + testnum);
			System.out.println("\tTitle: Click on Add Button ");
			if(obj.findElement(By.linkText("Add")).isDisplayed())
			{
				obj.findElement(By.id("Add")).click();
				Thread.sleep(3000);
				System.out.println("\tStatus: Clicked on Add Button successfully ");
				passcount++;
				if(obj.findElement(By.name("card_number")).isDisplayed())
				{				
					testnum++;
					System.out.println("\nTest" + testnum);
					System.out.println("\tTitle: Enter Card Number ");

					obj.findElement(By.name("card_number")).sendKeys("5105105105105100");
					System.out.println("\tStatus: Card number entered successfully ");
					passcount++;

					Actions a = new Actions(obj);
					a.sendKeys(Keys.TAB);
					testnum++;
					System.out.println("\nTest" + testnum);
					System.out.println("\tTitle: Enter Expiry Month ");
					obj.findElement(By.name("expiry_month")).click();
					obj.findElement(By.name("expiry_month")).sendKeys("11");
					System.out.println("\tStatus: Expiry month entered successfully ");
					passcount++;
					a.sendKeys(Keys.TAB);
					testnum++;
					System.out.println("\nTest" + testnum);
					System.out.println("\tTitle: Enter Expiry Year ");
					obj.findElement(By.name("expiry_year")).click();
					obj.findElement(By.name("expiry_year")).sendKeys("2018");
					System.out.println("\tStatus: Expiry year entered successfully ");
					passcount++;

					a.sendKeys(Keys.TAB);
					testnum++;
					System.out.println("\nTest" + testnum);
					System.out.println("\tTitle: Enter  CVV ");

					obj.findElement(By.name("security_code")).click();
					obj.findElement(By.name("security_code")).sendKeys("123");
					System.out.println("\tStatus: CVV entered successfully ");
					passcount++;

					a.sendKeys(Keys.TAB);
					testnum++;
					System.out.println("\nTest" + testnum);
					System.out.println("\tTitle: Click on Cancel Button ");
					obj.findElement(By.linkText("Cancel")).click();
					Thread.sleep(5000);
					System.out.println("\tStatus: Clicked Cancel button successfully ");
					passcount++;


				}
				else
				{
					System.out.println("\tStatus: Card number not entered successfully ");
					System.out.println("\tTest" + testnum + "- FAILED");

					failcount++;

				}
			}
			else
			{
				System.out.println("\tTitle: Not Clicked on Cancel Button ");
				System.out.println("\tTest" + testnum + "- FAILED");

				failcount++;
			}
		}
		catch(Exception e)
		{
			System.out.println("\tTitle: Not Clicked on Cancel Button ");
			System.out.println("\tTest" + testnum + "- FAILED");

			failcount++;
		}
	}


	// back to dash board Test 12
	public void  BacktoDashboard(WebDriver obj)
	{
		try{


			testnum++;
			System.out.println("\nTest" + testnum);
			System.out.println("\tTitle: Click on Back to dashboard ");
			System.out.println("\tInput: N/A");
			url_before_test = obj.getCurrentUrl();
			obj.findElement(By.linkText("Back to Dashboard")).click();
			url_after_test = obj.getCurrentUrl();
			if(url_before_test != url_after_test )
			{
				System.out.println("\tStatus: Redirected to Dashboard page successfully");
				System.out.println("\tTest" + testnum + "- PASSED");
				passcount++;
			}
			else
			{
				System.out.println("\tStatus: Not Redirected to History page ");
				System.out.println("\tTest" + testnum + "- FAILED");
				failcount++;
			}
		}
		catch(Exception e)
		{
			System.out.println("\tStatus: Not Redirected to History page ");
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}
	}
	//my savings
	//r.keyPress(KeyEvent.VK_PAGE_DOWN);
	//r.keyRelease(KeyEvent.VK_PAGE_DOWN);
	//click on 6-month Test 13
	public void  MONTH(WebDriver obj)
	{
		try
		{
			testnum++;
			System.out.println("\nTest" + testnum);
			System.out.println("\tTitle: Click 6 Months ");
			if(obj.findElement(By.linkText("6 MONTH")).isDisplayed())
			{
				obj.findElement(By.linkText("6 MONTH")).click();
				Thread.sleep(3000);
				System.out.println("\tStatus: 6 MONTH link clicked successfully ");
				System.out.println("\tTest" + testnum + "- PASSED");
				passcount++;
			}
			else
			{
				System.out.println("\tStatus: 6 MONTH link not clicked ");
				System.out.println("\tTest" + testnum + "- FAILED");
				failcount++;

			}
		}
		catch(Exception e)
		{
			System.out.println("\tStatus: 6 MONTH link not clicked ");
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}

	}
	//click on 1-year Test 14
	public void  YEAR(WebDriver obj)
	{
		try{
			testnum++;
			System.out.println("\nTest" + testnum);
			System.out.println("\tTitle: Click 1 Year ");
			if(obj.findElement(By.linkText("1 YEAR")).isDisplayed())
			{
				obj.findElement(By.linkText("1 YEAR")).click();
				Thread.sleep(3000);
				System.out.println("\tStatus: 1 YEAR link clicked successfully ");
				System.out.println("\tTest" + testnum + "- PASSED");
				passcount++;
			}
			else
			{
				System.out.println("\tStatus: 1 YEAR link not clicked ");
				System.out.println("\tTest" + testnum + "- FAILED");
				failcount++;

			}
		}
		catch(Exception e)
		{
			System.out.println("\tStatus: 1 YEAR link not clicked ");
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}
	}
	//Life time Test 15
	public void  LIFETIME(WebDriver obj)
	{
		try
		{
			testnum++;
			System.out.println("\nTest" + testnum);
			System.out.println("\tTitle: Click on Discount ");
			if(obj.findElement(By.linkText("DISCOUNTS")).isDisplayed())
			{
				obj.findElement(By.linkText("DISCOUNTS")).click();
				Thread.sleep(5000);
				System.out.println("\tStatus: Discount link clicked successfully ");
				System.out.println("\tTest" + testnum + "- PASSED");
				passcount++;
			}
			else
			{
				System.out.println("\tStatus: LIFE TIME link not clicked ");
				System.out.println("\tTest" + testnum + "- FAILED");
				failcount++;

			}
		}
		catch(Exception e)
		{
			System.out.println("\tStatus: LIFE TIME link not clicked ");
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}
		/*			obj.findElement(By.linkText("LIFE TIME")).click();
			Thread.sleep(3000);
		 */		}
	//Steps back
	public void  stepsback( WebDriver obj) 
	{
		try
		{
			testnum++;
			System.out.println("\nTest " + testnum);
			System.out.println("\tTitle: Savings Previous Months  ");

			Thread.sleep(5000);
			//Actions a = new Actions(obj);
			//WebElement e = obj.findElement(By.xpath("//img[@id='left_arrow']"));

			WebElement e = obj.findElement(By.id("left_arrow"));
			if(e.isDisplayed())
			{
				JavascriptExecutor jse = (JavascriptExecutor)obj;
				jse.executeScript("arguments[0].scrollIntoView();", e); 
				Thread.sleep(5000);
				//jse.executeScript("arguments[0].click();",e);
				for(int i = 1; i < 4; i++ )
				{
					jse.executeScript("arguments[0].click();",e);

				}
				System.out.println("\tStatus: Clicked on Previous months successfully  ");
				System.out.println("\tTest" + testnum + "- PASSED");
				passcount++;

			}
			else
			{
				System.out.println("\tStatus: Not Clicked on Previous months ");
				System.out.println("\tTest" + testnum + "- FAILED");
				failcount++;

			}
		}
		catch(Exception e)
		{
			System.out.println("\tStatus: Not Clicked on Previous months ");
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}

	}
	//Steps back
	public void  stepsfar( WebDriver obj) 
	{
		try
		{
			testnum++;
			System.out.println("\nTest " + testnum);
			System.out.println("\tTitle: Saving upcomming months ");

			Thread.sleep(5000);
			//Actions a = new Actions(obj);
			//WebElement e = obj.findElement(By.xpath("//img[@id='left_arrow']"));

			WebElement e = obj.findElement(By.id("right_arrow"));
			if(e.isDisplayed())
			{
				JavascriptExecutor jse = (JavascriptExecutor)obj;
				jse.executeScript("arguments[0].scrollIntoView();", e); 
				Thread.sleep(5000);
				//jse.executeScript("arguments[0].click();",e);
				for(int i = 1; i < 8; i++ )
				{
					jse.executeScript("arguments[0].click();",e);
				}
				System.out.println("\tStatus: Clicked on Upcomming months successfully  ");
				System.out.println("\tTest" + testnum + "- PASSED");
				passcount++;


			}
			else
			{
				System.out.println("\tStatus: Not Clicked on Previous months ");
				System.out.println("\tTest" + testnum + "- FAILED");
				failcount++;

			}
		}
		catch(Exception e)
		{
			System.out.println("\tStatus: Not Clicked on Previous months ");
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}
	}
	// Weight Activity
	public void  weightsback( WebDriver obj) 
	{
		try
		{
			testnum++;
			System.out.println("\nTest " + testnum);
			System.out.println("\tTitle: Weights Previous Months  ");

			Thread.sleep(5000);
			//Actions a = new Actions(obj);
			//WebElement e = obj.findElement(By.xpath("//img[@id='left_arrow']"));

			WebElement e = obj.findElement(By.id("weight_left_arrow"));
			if(e.isDisplayed())
			{
				JavascriptExecutor jse = (JavascriptExecutor)obj;
				jse.executeScript("arguments[0].scrollIntoView();", e); 
				Thread.sleep(5000);
				//jse.executeScript("arguments[0].click();",e);
				for(int i = 1; i < 4; i++ )
				{
					jse.executeScript("arguments[0].click();",e);

				}
				System.out.println("\tStatus: Clicked on Weights upcomming months successfully  ");
				System.out.println("\tTest" + testnum + "- PASSED");
				passcount++;

			}
			else
			{
				System.out.println("\tStatus: Not Clicked on Weights Previous months ");
				System.out.println("\tTest" + testnum + "- FAILED");
				failcount++;

			}
		}
		catch(Exception e)
		{
			System.out.println("\tStatus: Not Clicked on Weights Previous months ");
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}
	}
	//Weight far
	public void  weightsfar( WebDriver obj) 
	{
		try{


			testnum++;
			System.out.println("\nTest " + testnum);
			System.out.println("\tTitle: Weights upcomming months ");

			Thread.sleep(5000);
			//Actions a = new Actions(obj);
			//WebElement e = obj.findElement(By.xpath("//img[@id='left_arrow']"));

			WebElement e = obj.findElement(By.id("weight_right_arrow"));
			if(e.isDisplayed())
			{
				JavascriptExecutor jse = (JavascriptExecutor)obj;
				jse.executeScript("arguments[0].scrollIntoView();", e); 
				Thread.sleep(5000);
				//jse.executeScript("arguments[0].click();",e);
				for(int i = 1; i < 8; i++ )
				{
					jse.executeScript("arguments[0].click();",e);
				}
				System.out.println("\tStatus: Clicked on Weights Upcomming months successfully  ");
				System.out.println("\tTest" + testnum + "- PASSED");
				passcount++;


			}
			else
			{
				System.out.println("\tStatus: Not Clicked on Previous months ");
				System.out.println("\tTest" + testnum + "- FAILED");
				failcount++;

			}
		}
		catch(Exception e)
		{
			System.out.println("\tStatus: Not Clicked on Previous months ");
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;

		}
	}

	// My Challenges Show All
	//	My Challenges back

	public void  activityback( WebDriver obj) 
	{
		testnum++;
		System.out.println("\nTest " + testnum);
		System.out.println("\tTitle: My Challenges Previous Months  ");
		try {
			Thread.sleep(5000);
			//Actions a = new Actions(obj);
			//WebElement e = obj.findElement(By.xpath("//img[@id='left_arrow']"));

			WebElement e = obj.findElement(By.id("challenges_left_arrow"));
			if(e.isDisplayed())
			{
				JavascriptExecutor jse = (JavascriptExecutor)obj;
				jse.executeScript("arguments[0].scrollIntoView();", e); 
				Thread.sleep(5000);
				//jse.executeScript("arguments[0].click();",e);
				for(int i = 1; i < 4; i++ )
				{
					jse.executeScript("arguments[0].click();",e);

				}
				System.out.println("\tStatus: Clicked on My Challenges Previous months successfully  ");
				System.out.println("\tTest" + testnum + "- PASSED");
				passcount++;

			}
			else
			{
				System.out.println("\tStatus: Not Clicked on My Challenges Previous months ");
				System.out.println("\tTest" + testnum + "- FAILED");
				failcount++;

			} 
		}catch(Exception e){
			System.out.println("\tStatus: Not Clicked on My Challenges Previous months ");
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}

	}
	//My Challenges far
	public void  activityfar( WebDriver obj) 
	{
		try
		{
			testnum++;
			System.out.println("\nTest " + testnum);
			System.out.println("\tTitle: My Challenges upcomming months ");

			Thread.sleep(5000);
			//Actions a = new Actions(obj);
			//WebElement e = obj.findElement(By.xpath("//img[@id='left_arrow']"));

			WebElement e = obj.findElement(By.id("challenges_right_arrow"));
			if(e.isDisplayed())
			{
				JavascriptExecutor jse = (JavascriptExecutor)obj;
				jse.executeScript("arguments[0].scrollIntoView();", e); 
				Thread.sleep(5000);
				//jse.executeScript("arguments[0].click();",e);
				for(int i = 1; i < 8; i++ )
				{
					jse.executeScript("arguments[0].click();",e);
				}
				System.out.println("\tStatus: Clicked My Challenges on Upcomming months successfully  ");
				System.out.println("\tTest" + testnum + "- PASSED");
				passcount++;


			}
			else
			{
				System.out.println("\tStatus: Not Clicked My Challenges on upcomming months ");
				System.out.println("\tTest" + testnum + "- FAILED");
				failcount++;

			}
		}
		catch(Exception e)
		{
			System.out.println("\tStatus: Not Clicked My Challenges on upcomming months ");
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}
	}

	public void  activity_showall( WebDriver obj) 
	{
		try
		{
			testnum++;
			System.out.println("\nTest " + testnum);
			System.out.println("\tTitle: Click on Challenges Show All button  ");
			WebElement e = obj.findElement(By.linkText("Show All"));
			if(e.isDisplayed())
			{
				JavascriptExecutor jse = (JavascriptExecutor)obj;
				jse.executeScript("arguments[0].scrollIntoView();", e); 
				jse.executeScript("arguments[0].click();",e);

				Thread.sleep(5000);
				System.out.println("\tStatus: Clicked on Show all successfully  ");
				System.out.println("\tTest" + testnum + "- PASSED");
				passcount++;

			}
			else
			{
				System.out.println("\tStatus: Not Clicked on Show all successfully  ");
				System.out.println("\tTest" + testnum + "- FAILED");
				failcount++;

			}
		}
		catch(Exception e)
		{
			System.out.println("\tStatus: Not Clicked on Show all successfully  ");
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}
	}
	//Accept Challange
	public void  Acceptnchallange( WebDriver obj) 
	{
		try
		{
			testnum++;
			System.out.println("\nTest " + testnum);
			System.out.println("\tTitle: Click Accept button for new challange  ");
			WebElement e = obj.findElement(By.id("accept_challenge5"));
			if(e.isDisplayed())
			{
				JavascriptExecutor jse = (JavascriptExecutor)obj;
				jse.executeScript("arguments[0].scrollIntoView();", e); 
				jse.executeScript("arguments[0].click();",e);
				Thread.sleep(5000);
				System.out.println("\tStatus: Clicked Accept Button and raised a popup should appear as * Are you sure you want to Accept Challenge?*  ");
				/*WebElement e1 = obj.findElement(By.id("ok_button")).isDisplayed());
				if(e1.isDisplayed())
				{
					JavascriptExecutor jse = (JavascriptExecutor)obj;
					jse.executeScript("arguments[0].scrollIntoView();", e1); 
					jse.executeScript("arguments[0].click();",e1);
					Thread.sleep(5000);
					*/
				if(obj.findElement(By.id("ok_button")).isDisplayed())
				{
				obj.findElement(By.id("ok_button")).click();
				Thread.sleep(3000);
				System.out.println("\tStatus: Clicked Yes, Accept it Button successfully  ");
				System.out.println("\tTest" + testnum + "- PASSED");
				passcount++;
				}							
				if(obj.findElement(By.id("ok_button")).isDisplayed())
				{
				obj.findElement(By.id("ok_button")).click();
				Thread.sleep(20000);
				System.out.println("\tStatus: Clicked OK button  ");
				System.out.println("\tTest" + testnum + "- PASSED");
				//passcount++;
				}
				else
				{
					System.out.println("\tStatus: Not Clicked OK button  ");
					System.out.println("\tTest" + testnum + "- FAILED");
					failcount++;
				}
			}
			else
			{
				System.out.println("\tStatus: Not Clicked on Yes, Accept it Button  ");
				System.out.println("\tTest" + testnum + "- FAILED");
				failcount++;

			}
		}
		catch(Exception e)
		{
			System.out.println("\tStatus: Not Clicked on Yes, Accept it Button  ");
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}
	}
//Accecpt already accepted challange
	public void  Activity( WebDriver obj) 
	{
		try
		{
			testnum++;
			System.out.println("\nTest " + testnum);
			System.out.println("\tTitle: Click Accept button for already accepted challange  ");
			//Thread.sleep(5000);
			WebElement e = obj.findElement(By.id("accept_challenge5"));
			if(e.isDisplayed())
			{
				JavascriptExecutor jse = (JavascriptExecutor)obj;
				jse.executeScript("arguments[0].scrollIntoView();", e); 
				jse.executeScript("arguments[0].click();",e);
				Thread.sleep(5000);
				System.out.println("\tStatus: Clicked Accept Button and raised a popup like you already accepted this challange  ");
				if(obj.findElement(By.id("ok_button")).isDisplayed())
				{
				obj.findElement(By.id("ok_button")).click();
				Thread.sleep(5000);
				System.out.println("\tStatus: Clicked on OK Button successfully  ");
				System.out.println("\tTest" + testnum + "- PASSED");
				passcount++;
				}
				else{
					System.out.println("\tStatus: Not Clicked on OK Button   ");
					System.out.println("\tTest" + testnum + "- FAILED");
					failcount++;
				}

			}
			else
			{
				System.out.println("\tStatus: Not Clicked on Accept Button  ");
				System.out.println("\tTest" + testnum + "- FAILED");
				failcount++;

			}
		}
		catch(Exception e)
		{
			System.out.println("\tStatus: Not Clicked on Accept Button  ");
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}
	}
//quit Challanges 
	public void quitchallange(WebDriver obj)
	{
		try{
			testnum++;
			System.out.println("\nTest" + testnum);
			System.out.println("\tTitle: Click on quit button for Accepted Challange ");
			if(obj.findElement(By.xpath("html/body/div[3]/div/div[2]/div[4]/div/div/div")).isDisplayed())
			{
				obj.findElement(By.xpath("html/body/div[3]/div/div[2]/div[4]/div/div/div")).click();
				Thread.sleep(5000);
				System.out.println("\tStatus: Accepted Challenge clicked successfully ");
				System.out.println("\tTest" + testnum + "- PASSED");
				passcount++;
			}
			else
			{
				System.out.println("\tStatus: Accepted Challenge not clicked ");
				System.out.println("\tTest" + testnum + "- FAILED");
				failcount++;
			}
		}
		catch(Exception e)
		{
			System.out.println("\tStatus: Accepted Challenge not clicked ");
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}
	}

	//Sync Fit bit		
	public void  SyncFitbit(WebDriver obj)
	{
		try{
			testnum++;
			System.out.println("\nTest" + testnum);
			System.out.println("\tTitle: Click Sync fitbit ");
			if(obj.findElement(By.linkText("Synch")).isDisplayed())
			{
				obj.findElement(By.linkText("Synch")).click();
				Thread.sleep(5000);
				System.out.println("\tStatus: Sync Fitbit button clicked successfully ");
				System.out.println("\tTest" + testnum + "- PASSED");
				passcount++;
			}
			else
			{
				System.out.println("\tStatus: Sync Fitbit button not clicked ");
				System.out.println("\tTest" + testnum + "- FAILED");
				failcount++;
			}
		}
		catch(Exception e)
		{
			System.out.println("\tStatus: Sync Fitbit button not clicked ");
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}
	}
	//Logout Test 17
	public void  Logout(WebDriver obj)
	{
		try
		{
			testnum++;
			System.out.println("\nTest" + testnum);
			System.out.println("\tTitle: Click Log out ");
			if(obj.findElement(By.xpath(".//*[@id='wrapper']/div[1]/div[3]/div/div[2]/a")).isDisplayed())
			{
				obj.findElement(By.xpath(".//*[@id='wrapper']/div[1]/div[3]/div/div[2]/a")).click();
				Thread.sleep(5000);
				System.out.println("\tStatus: Sign Out button clicked successfully ");
				System.out.println("\tTest" + testnum + "- PASSED");
				passcount++;
			}
			else
			{
				System.out.println("\tStatus: Sign Out button not clicked ");
				System.out.println("\tTest" + testnum + "- FAILED");
				failcount++;
			}
		}
		catch(Exception e)
		{
			System.out.println("\tStatus: Sign Out button not clicked ");
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}
	}
	// Forgot Password Test 18 
	public void  ForgotPassword (WebDriver obj)
	{
		try{
			testnum++;
			System.out.println("\nTest" + testnum);
			System.out.println("\tTitle: Click on Forgot password? link ");
			if(obj.findElement(By.linkText("Forgot password?")).isDisplayed())
			{
				obj.findElement(By.linkText("Forgot password?")).click();
				Thread.sleep(5000);
				System.out.println("\tStatus: Clicked on Forgot password? link successfully ");
				System.out.println("\tTest" + testnum + "- PASSED");
				passcount++;
			}
			else
			{
				System.out.println("\tStatus: Not Clicked on Forgot password? link ");
				System.out.println("\tTest" + testnum + "- FAILED");
				failcount++;
			}
		}

		catch(Exception e)
		{
			System.out.println("\tStatus: Forgot password? link ");
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}

	}
	// Enter Email in Forgot Password Test 19 
	public void  login_textbox (WebDriver obj)
	{
		try{
			testnum++;
			System.out.println("\nTest" + testnum);
			System.out.println("\tTitle:  Entering Email ");
			if(obj.findElement(By.id("email")).isDisplayed())
			{
				obj.findElement(By.id("email")).sendKeys("siddhii@gmail.com");
				Thread.sleep(5000);
				System.out.println("\tStatus: Email entered successfully ");
				System.out.println("\tTest" + testnum + "- PASSED");
				passcount++;
			}
			else
			{
				System.out.println("\tStatus: Email not entered ");
				System.out.println("\tTest" + testnum + "- FAILED");
				failcount++;
			}
		}
		catch(Exception e)
		{
			System.out.println("\tStatus: Email not entered ");
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}
	}
	// Click on Cancel  Test 20
	public void  Cancel (WebDriver obj)
	{
		testnum++;
		try
		{
			System.out.println("\nTest" + testnum);
			System.out.println("\tTitle: Click on Reset button ");
			if(obj.findElement(By.id("login_btn")).isDisplayed())
			{
				obj.findElement(By.id("login_btn")).click();
				System.out.println("\tStatus: Cancel button clicked successfully ");
				System.out.println("\tTest" + testnum + "- PASSED");
				passcount++;
			}
			else
			{
				System.out.println("\tStatus: Cancel button not clicked ");
				System.out.println("\tTest" + testnum + "- FAILED");
				failcount++;
			}
		}
		catch(Exception e)
		{
			System.out.println("\tStatus: Cancel button not clicked ");
			System.out.println("\tTest" + testnum + "- FAILED");
			failcount++;
		}
		//WebDriver obj1=new FirefoxDriver();

		Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("MMM-dd-yyyy h:mm:ss a");
			String formattedDate = sdf.format(date);
			System.out.println("***********************************************************");
			System.out.println("*\tTest Summary");
			System.out.println("*\tTest Completion Time: " +formattedDate);
			System.out.println("*\tNum of Tests:"+ testnum);
			System.out.println("*\tNum of PASSED Tests:"+ passcount);
			System.out.println("*\tNum of FAILED Tests:"+ failcount);
			System.out.println("***********************************************************");

			//obj.close(); 

	}
	
	public int[] callAllMethodsDemo(WebDriver obj)
	{
		ChkEmail(obj);
		ChkPwd(obj);
		Chklogin(obj);
		loginEmpty(obj); 

		loginEmailEmpty( obj);
		loginPWDEmpty(obj);
		loginInvalid(obj);
		loginValid(obj);
		
		connect(obj);
		connectfitbit(obj);
		email(obj);
		password1(obj);
		login(obj);
		allow(obj);
		sync(obj);
		settings(obj);
		disconnect(obj);
		editProfile(obj);
		uploadPic(obj);
		uploadPic1(obj);
		changepwd(obj);
		changepwd1(obj);
		changepwd2(obj);
		backtodashboard(obj);
		viewbill(obj);
		paybill(obj);
		paynow(obj);
		history(obj);
		payment(obj);
		add(obj);
		//cancel1(obj);
		BacktoDashboard(obj);
		MONTH(obj);
		YEAR(obj);
		LIFETIME(obj);
		stepsback(obj);
		stepsfar(obj);
		weightsback(obj);
		weightsfar(obj);
		activityback(obj);
		activityfar(obj);
		activity_showall(obj);
		Acceptnchallange(obj);
		Activity(obj);
		
		// quitchallange(obj);
		//SyncFitbit(obj);
		Logout(obj);
		ForgotPassword(obj);
		login_textbox(obj);
		Cancel(obj);

	int countarray[] = new int[3];
		countarray[0]= this.testnum;
		countarray[1]= this.passcount;
		countarray[2]= this.failcount;
		
		System.out.println("Total Tests : "+testnum);
		System.out.println("Pass Tests : "+passcount);
		System.out.println("Fail Tests : "+failcount);
		return countarray;
		
	}

}





