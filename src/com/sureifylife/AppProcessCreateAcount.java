package com.sureifylife;


import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

/**
 * @author Suresh
 */
public class AppProcessCreateAcount {

	private int testNum = 0;
	private int passCount = 0;
	private int failCount = 0;
	
	
	static String[] inavalidPwddata = {
			"Vendus@jk",
			"vendus@12",
			"Vendus123",
			"1234567@",
			"Vend@12",
			"      "
	};
	
	static String[] validPwddata = {
			"Vendus@123"
	};

	WebDriver driver = null;

	public AppProcessCreateAcount(WebDriver driver){
        this.driver = driver;
	}

	public AppProcessCreateAcount(int testNum, int passCount, int failCount){
		this.testNum = testNum;
		this.passCount = passCount;
		this.failCount = failCount;
	}

	public static int exists(String URLName){
		try 
		{
			HttpURLConnection.setFollowRedirects(false);
			HttpURLConnection con = (HttpURLConnection) new URL(URLName).openConnection();

			Thread.sleep(5000);
			return con.getResponseCode();
		}
		catch (Exception e) 
		{
			return 0;
		}

	}

	public void sitelaunch( WebDriver driver) throws InterruptedException
	{
		testNum++;
		Reporter.log("\nTest " + testNum);
		Reporter.log("\tTitle: Launch Sureify Beta ");
		String url = "https://stg.sureify.com/home/appprocess/"; 
		Reporter.log("\tInput:" + url);
		int status = exists(url);

		if( status == 200 )
		{
			driver.get(url);
			driver.manage().window().maximize();
			Reporter.log("\tStatus: " + url + " Launched" );
			Reporter.log("\tTest" + testNum + "- PASSED");
			passCount++;

		}
		else
		{
			Reporter.log("\tURL: " + url + " is Incorrect" );
			System.err.println("\tERROR: Cannot access '" + url );
			Reporter.log("\tTest" + testNum + "- FAILED");
			failCount++;
		}
	}
	
	public void verifyUserName(){
		
		Reporter.log("\tTitle Check Name field filled with Username given name or Not",true);
		String actname = BasicInfo.validnamedata[BasicInfo.validnamedata.length-1];
		
		WebElement name = driver.findElement(By.id("create_user_name"));
		String exptname = name.getAttribute("value");
		
		if(actname.equals(exptname)){
			Reporter.log("\tStatus ::Passed Name matched",true);
		}else{
			Reporter.log("\tStatus ::Failed Name not matched Actual :"+actname+", Expecte :"+exptname,true);
		}
	}
	
	public void verifyEmailAddress(){
		
	   Reporter.log("\tTitle Check Email Address field filled with Username given Email or Not ",true);	
	   String actmail = BasicInfo.validemaildata[BasicInfo.validemaildata.length-1];
	   
	   WebElement mail = driver.findElement(By.id("user_mail"));
	   String exptemail = mail.getAttribute("value");
	   
	   if(actmail.equals(exptemail)){
		   Reporter.log("\tStatus ::Passed Email matched",true);
	   }else{
		   Reporter.log("\tStatus ::Failed Email not matched Actual :"+actmail+" ,Expected :"+exptemail,true);
	   }
	}
	
	
	
	
	public void clickOnLogo() {
		//header_logo
		String url_before_click, url_after_click;

		try {
			testNum++;
			WebElement header_logo = driver.findElement(By.id("header_logo"));
			Reporter.log("\nTest " + testNum,true);
			Reporter.log("\tTitle: Click on Logo ",true);
			Reporter.log("\tInput: N/A",true);
			url_before_click = driver.getCurrentUrl();
			//header_logo.click();
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click()", header_logo);
			try {
				Thread.sleep(5000);
			} catch (Exception e){

			}
			url_after_click = driver.getCurrentUrl();

			if(!url_before_click.equals(url_after_click)){
				Reporter.log("\tStatus: Navigated to home page when clicked on Logo",true);
				Reporter.log("\tTest" + testNum + "- PASSED",true);
				passCount++;
				driver.navigate().back();
				Thread.sleep(5000);
			} else {
				Reporter.log("\tStatus: Did not navigate to home page when clicked on Logo",true);
				Reporter.log("\tTest" + testNum + "- FAILED",true);
				failCount++;
			}
		} catch ( Exception e ){
			Reporter.log("\tStatus: Caught Exception. Did not navigate to home page when clicked on Logo");
			Reporter.log("\tTest" + testNum + "- FAILED");
			failCount++;
		}

	}

	public void invalidPasswordData() throws InterruptedException{
		
		Reporter.log("\tTitle: Enter Invalid data for Password",true);
	    WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_pwd")));
		for ( int i = 0 ; i < inavalidPwddata.length ; i++){
		     Reporter.log("\tInput : "+inavalidPwddata[i],true);
		     WebElement password = driver.findElement(By.id("user_pwd"));
		     password.clear();
			 password.sendKeys(inavalidPwddata[i]);
			 password.sendKeys(Keys.ENTER);
			 Thread.sleep(3000);
			 
			 WebElement req = driver.findElement(By.xpath("//input[@id = 'user_pwd']/following::small[1]"));
			 WebElement notavalid = driver.findElement(By.xpath("//input[@id = 'user_pwd']/following::small[2]"));

			 if(req.isDisplayed() == true || notavalid.isDisplayed() == true){
				 Reporter.log("\tStatus ::Passed",true);
			 }else{
				 Reporter.log("\tStatus ::Failed",true);
			 }
			 
		}			
	}
  
	public void validPassword() throws InterruptedException{
		
		Reporter.log("\tTitle: Enter Valid data for Password",true);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_pwd")));
		for(int i=0;i<validPwddata.length;i++){
			Reporter.log("\tInput : "+validPwddata[i],true);
			WebElement password = driver.findElement(By.id("user_pwd"));
			password.clear();
		    password.sendKeys(validPwddata[i]);
		    Thread.sleep(3000);
		    
		    WebElement req = driver.findElement(By.xpath("//input[@id = 'user_pwd']/following::small[1]"));
			WebElement notavalid = driver.findElement(By.xpath("//input[@id = 'user_pwd']/following::small[2]"));
		    
		    if(req.isDisplayed() == false && notavalid.isDisplayed() == false){
			   Reporter.log("\tStatus ::Passed",true);
		    }else{
			   Reporter.log("\tStatus ::Failed",true);
		    }
		}
		
	}
	
	public void invalidConfirmPasswordData() throws InterruptedException{
		
		Reporter.log("\tTitle: Enter InValid data for Confirm Password",true);
		WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_confirm_pwd")));
		
		for ( int i = 0 ; i < inavalidPwddata.length ; i++){
		     Reporter.log("\tInput : "+inavalidPwddata[i],true);
		     WebElement cpassword = driver.findElement(By.id("user_confirm_pwd"));
		     cpassword.clear();
			 cpassword.sendKeys(inavalidPwddata[i]);
			 cpassword.sendKeys(Keys.ENTER);
			 Thread.sleep(3000);
			 
			 WebElement req = driver.findElement(By.xpath("//input[@id = 'user_confirm_pwd']/following::small[1]"));
			 WebElement notvalid = driver.findElement(By.xpath("//input[@id = 'user_confirm_pwd']/following::small[2]"));
			 WebElement notmatch = driver.findElement(By.xpath("//input[@id = 'user_confirm_pwd']/following::small[3]"));

			 if(req.isDisplayed()==true || notvalid.isDisplayed()==true || notmatch.isDisplayed()==true){
				 Reporter.log("\tStatus ::Passed",true);
			 }else{
				 Reporter.log("\tStatus ::Failed",true);
			 }
			 
			 cpassword.clear();
		}		
	}
	
	public void validConfirmPassword() throws InterruptedException{
		
		Reporter.log("\tTitle: Enter Valid data for Confirm Password",true);
		WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_confirm_pwd")));
		
		for(int i=0;i<validPwddata.length;i++){
			WebElement password = driver.findElement(By.id("user_confirm_pwd"));
			password.clear();
		   password.sendKeys(validPwddata[i]);
		   Thread.sleep(3000);
		   
		   WebElement req = driver.findElement(By.xpath("//input[@id = 'user_confirm_pwd']/following::small[1]"));
		   WebElement notvalid = driver.findElement(By.xpath("//input[@id = 'user_confirm_pwd']/following::small[2]"));
		   WebElement notmatch = driver.findElement(By.xpath("//input[@id = 'user_confirm_pwd']/following::small[3]"));

		   if(req.isDisplayed() == false && notvalid.isDisplayed() == false && notmatch.isDisplayed() == false){
			  Reporter.log("\tStatus ::Passed",true);
		   }else{
			  Reporter.log("\tStatus ::Failed",true);
		   }
		}
		
	}
	
	public void verifyShowAndHidePassword() throws InterruptedException{
	
		Reporter.log("\tTitle : Click Show and Hide Password link",true);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Reporter.log("\tInput : Click Show Password",true);
		try{
			boolean show = (Boolean)js.executeScript("return $('#show_password').is(':visible');");
			if(show == true){
				js.executeScript("$('#show_password').click();");
				Thread.sleep(5000);
				boolean res = (Boolean)js.executeScript("return $('#show_password').is(':visible');");
				if(res == false ){
					Reporter.log("\tStatus ::Passed show password",true);
				}else{
					Reporter.log("\tStatus ::Failed show password",true);
				}
			}else{
				Reporter.log("\tStatus ::Failed Show Password link not displayed",true);
			}
		}catch(Exception e){
			Reporter.log("\tStatus ::Failed Exception Reised",true);
		}

		Thread.sleep(3000);
		Reporter.log("\tInput : Click Hide Password ",true);
		try{
			boolean hide = (Boolean)js.executeScript("return $('#hide_password').is(':visible');");
			if(hide == true){
				js.executeScript("$('#hide_password').click();");
				Thread.sleep(5000);
				boolean res = (Boolean)js.executeScript("return $('#hide_password').is(':visible');");
				if(res == false){
					Reporter.log("\tStatus ::Passed hide password",true);	
				}else{
					Reporter.log("\tStatus ::Failed hide password",true);
				}

			}else{
				Reporter.log("\tStatus Hide link not displayed",true);
			}
		}catch (Exception e) {
			Reporter.log("\tStatus ::Failed ,Exception rised",true);
		}
	}

	public void captcha() throws InterruptedException{
		
		Reporter.log("\tTitle click capcha",true);
		String currentwindow = driver.getWindowHandle();
		WebElement frame = driver.findElement(By.xpath("//iframe[@title = 'recaptcha widget']"));
		driver.switchTo().frame(frame);
		WebElement check = driver.findElement(By.xpath("//span[@id = 'recaptcha-anchor']"));
		driver.findElement(By.xpath("//div[@class = 'recaptcha-checkbox-checkmark']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.attributeToBe(check, "aria-checked", "true"));
		driver.switchTo().window(currentwindow);
		Reporter.log("\tStatus :: Complete capcha",true);
		
	}
	
	public void clickCreat() throws InterruptedException{
		
		Reporter.log("\tTitle click to CREATE button",true);
		driver.findElement(By.id("create_button")).click();;
		Thread.sleep(4000);
		if(driver.findElement(By.id("user_first_name")).isDisplayed()){
			Reporter.log("\tStatus ::Passed clicked to create button",true);
		}else{
			Reporter.log("\tStatus ::Failed to click create button",true);
		}
	}
}
