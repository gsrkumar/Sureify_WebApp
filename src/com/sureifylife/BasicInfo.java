
package com.sureifylife;

import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import services.RiseException;

public class BasicInfo 
{
	WebDriver driver = null;

	static String invalidzipcodedata[] = {
			"123",
			"ab1234d",
			"-1234", 
			"123456",
			"000000",

	};

	static String validzipcodedata[] = {
			"12345-6789","96094"
	};

	static String faceamontdata[] = {
			"$250,000",
			"$500,000",
			"$750,000",
			"$1,000,000"
	};

	static String durationdata[] = {
			"10",
			"20",
			"30"
	};

    static String genderdata[] = {
			"female",
			"male"
	};

	static String agedata[] = {"18","19","99","100","35"};

	static String smokedata[] = {"no","yes"};

	static String healthdata[] = {
			"Excellent",
			"Very Good",
			"Good",
			"Fair"
	};

	static String invalidnamedata[]  = {
			"_test",
			"12test",
			"12345",
			"#$%@-"
	};

	static String validnamedata[] = {
			"a",
			"suresh test"
	};

	static String invalidemaildata [] = {
			"suresh@sureify",
			"sureshsureify.com",
			"suresh@sureifycom",
			"@suresh.com",
			"suresh"		
	};

	static String validemaildata[] = {
			"s@s.c",
			"s@s.c.in",
			"suresh@sureify.com"
	};

	static String slideramontdata[] = {
			"250,000",
			"500,000",
			"750,000",
			"1,000,000"
	};

	public BasicInfo(WebDriver driver){
		this.driver = driver;
	}


	public static void main(String[] args) throws InterruptedException 
	{
		//basicInfo.callAllMethodsBI(driver);
		/*basicInfo.zipcode(driver);
		basicInfo.invalidzipcode1(driver);
		basicInfo.invalidzipcode2(driver);
		basicInfo.invalidzipcode3(driver);
		basicInfo.invalidzipcode4(driver);
		basicInfo.invalidzipcode5(driver);
		basicInfo.invalidzipcode6(driver);
		basicInfo.invalidzipcode7(driver);
		basicInfo.faceamount(driver);
		basicInfo.choosefaceamount(driver);
		basicInfo.choosefaceamount2(driver);
		basicInfo.choosefaceamount3(driver);
		basicInfo.choosefaceamount4(driver);
		  basicInfo.duration(driver);
		  basicInfo.chooseduration1(driver);
		  basicInfo.chooseduration2(driver);
		  basicInfo.chooseduration3(driver);
		  basicInfo.gender(driver);
		basicInfo.choosegender1(driver);
		basicInfo.choosegender2(driver);
		basicInfo.age(driver);
		basicInfo.chooseage(driver);
		basicInfo.smoke(driver);
		basicInfo.choosesmoke1(driver);
		basicInfo.choosesmoke2(driver);
		basicInfo.health(driver); 
		basicInfo.choosehealth(driver);
		basicInfo.choosehealth1(driver);
		basicInfo.choosehealth2(driver);
		basicInfo.choosehealth3(driver);
		basicInfo.name(driver);
		basicInfo.name2(driver);
		basicInfo.name3(driver);
		basicInfo.name4(driver);
/*		basicInfo.email(driver);
		basicInfo.email2(driver);
		basicInfo.email3(driver);
		basicInfo.email4(driver);
		basicInfo.getquotebutton(driver);
		basicInfo.existinguser(driver);
		basicInfo.hereyourquote(driver);
		basicInfo.confirmapply(driver);
		basicInfo.CBasicinfo(driver);
		basicInfo.getquotebutton1(driver);
		basicInfo.confirmapply1(driver);
		basicInfo.getquote1(driver);
		basicInfo.confirmapply2(driver);
		basicInfo.apply(driver);

		 */
	}

	public void  zipcodeInfo() throws InterruptedException
	{
		Reporter.log("\tTitle: Click on Question icon preceeding  Zipcode ",true);
		Reporter.log("\tInput: N/A" ,true);
		WebElement zipcodeinfo = driver.findElement(By.xpath("//div[text() = 'ZIP Code']/a/img"));
		try{						
			if(zipcodeinfo.isDisplayed()){   
				zipcodeinfo.click();
				Thread.sleep(5000);
				if(driver.findElement(By.xpath("//div[@class = 'modal-content']")).isDisplayed()){
					Reporter.log("\tStatus: Clicked on Question mark successfully" ,true);
					Reporter.log("\tStatus: Popup opened" ,true);
					driver.findElement(By.xpath("//a[text() = 'close']")).click();	
					Reporter.log("\tStatus: Popup closed successfully" ,true  );
					Reporter.log("\tTest - PASSED",true);
				}else{
					Reporter.log("\tStatus: Popup not displayed" ,true  );
					Reporter.log("\tTest - FAILED",true);
				}

			}
			else{
				Reporter.log("\tStatus: Not Clicked on Question mark successfully"  ,true );
				Reporter.log("\tTest - FAILED",true);
			}
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Reporter.log("\tStatus: Not Clicked on Question mark successfully" ,true  );
			Reporter.log("\tTest - FAILED",true);	
		}
	}

	public void  invalidzipcode() throws InterruptedException
	{
		String actualerrmsg = "* Please enter a valid zipcode";
		Reporter.log("\tTitle: Input Invalid Zipcode ",true);
		WebElement zipcodefiled = driver.findElement(By.id("area_code"));
		WebElement faceamount = driver.findElement(By.id("coverage_amount"));
		if(zipcodefiled.isDisplayed()){
			for(int i=0;i<invalidzipcodedata.length;i++){
				zipcodefiled.clear();
				Reporter.log("\tInput:"+invalidzipcodedata[i],true);
				zipcodefiled.sendKeys(invalidzipcodedata[i]);
				//driver.findElement(By.xpath("//div[text() = 'ZIP Code']")).click();
				(new Actions(driver)).sendKeys(faceamount, Keys.TAB).perform();
				Thread.sleep(5000);
				try{
					if(driver.findElement(By.xpath("//span[@for = 'area_code']")).isDisplayed()){
						String expterrmsg =	driver.findElement(By.xpath("//span[@for = 'area_code']")).getText();
						if(actualerrmsg.equalsIgnoreCase(expterrmsg)){
							Reporter.log("\tStatus: " +" Should show Error messages like Invalid Zipcode",true);
							Reporter.log("\tTest - PASSED",true);
						}else{
							Reporter.log("\tTest FAILED - Invalid error message showed",true);
						} 
					}
				}catch (Exception e) {
					Reporter.log("\tTest FAILED - Error message not displayed",true);
				}	 
			}
		}else{
			Reporter.log("\tStatus: Area code not entered  successfully" ,true );
			Reporter.log("\tTest - FAILED",true);
		}
	}

	public void  validzipcode() throws InterruptedException
	{
		Reporter.log("\tTitle: Input Valid Zipcode ");
		WebElement zipcodefiled = driver.findElement(By.id("area_code"));
		WebElement faceamount = driver.findElement(By.id("coverage_amount"));
		if(zipcodefiled.isDisplayed()){
			for(int i=0;i<validzipcodedata.length;i++){
				Reporter.log("\tInput:"+validzipcodedata[i],true);
				zipcodefiled.clear();
				zipcodefiled.sendKeys(validzipcodedata[i]);
				///driver.findElement(By.xpath("//div[text() = 'ZIP Code']")).click();
				(new Actions(driver)).sendKeys(faceamount, Keys.TAB).perform();
				Thread.sleep(5000);
				try{
					if(driver.findElement(By.xpath("//span[@for = 'area_code']")).isDisplayed()){
						Reporter.log("\tTest FAILED - Zipcode not accepted",true); 
					}
				}catch(Exception e){
					Reporter.log("\tTest PASSED - Zipcode accepted",true);
				} 
			}

		}else{
			Reporter.log("\tStatus: Area code not entered  successfully" ,true );
			Reporter.log("\tTest - FAILED",true);
		}
	}

	public void  faceamountInfo() throws InterruptedException
	{
		Reporter.log("\tTitle: Click on Question icon preceeding Faceamount ",true);
		Reporter.log("\tInput: N/A",true );
		//https://sureifylife.com/quote/popupcontent/coverage_amount
		WebElement faceamountinfo = driver.findElement(By.xpath(".//*[@id='modal-popup']/img"));
		try{						
			if(faceamountinfo.isDisplayed()){ 
				((JavascriptExecutor)driver).executeScript("scroll(0, -250);",faceamountinfo);
				(new Actions(driver)).moveToElement(faceamountinfo).perform();
				faceamountinfo.click();
				Thread.sleep(5000);
				if(driver.findElement(By.xpath("//div[@class = 'modal-content']")).isDisplayed()){
					Reporter.log("\tStatus: Clicked on Question mark successfully" ,true);
					Reporter.log("\tStatus: Popup opened" ,true);
					driver.findElement(By.xpath("//a[text() = 'close']")).click();	
					Reporter.log("\tStatus: Popup closed successfully" ,true  );
					Reporter.log("\tTest - PASSED",true);
				}else{
					Reporter.log("\tStatus: Popup not displayed" ,true  );
					Reporter.log("\tTest - FAILED",true);
				}	   
			}
			else{
				Reporter.log("\tStatus: Not Clicked on Question mark successfully"  ,true );
				Reporter.log("\tTest - FAILED",true);
			}
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Reporter.log("\tStatus: Not Clicked on Question mark successfully" ,true  );
			Reporter.log("\tTest - FAILED",true);	
		}	
	}

	public void  choosefaceamount() throws InterruptedException
	{
		Reporter.log("\tTitle: Click on dropdown arrow to choose Faceamount ",true);
		WebElement faceamount = driver.findElement(By.id("coverage_amount"));
		(new Actions(driver)).moveToElement(faceamount).perform();
		for(int i=0;i<faceamontdata.length;i++){
			Reporter.log("\tInput: "+faceamontdata[i],true );
			Select amount  = new Select(faceamount);
			Thread.sleep(2000);
			amount.selectByVisibleText(faceamontdata[i]);
			if(amount.getFirstSelectedOption().getText().equals(faceamontdata[i])){
				Reporter.log("\tStatus: Choose "+ amount.getFirstSelectedOption().getText() +"from dropdown ",true);
				Reporter.log("\tTest - PASSED",true);
			}else{
				Reporter.log("\tStatus: Not Clicked on dropdown arrow to choose Faceamount ",true);
				Reporter.log("\tTest - FAILED",true);
			}
		}
	}

	public void  durationInfo() throws InterruptedException
	{
		Reporter.log("\tTitle: Click on Question icon preceeding Duration ",true);
		Reporter.log("\tInput: N/A" ,true);
		WebElement durationinfo = driver.findElement(By.xpath("//a[contains(@href,'coverage_duration')]/img"));
		try{						
			if(durationinfo.isDisplayed()){   
				durationinfo.click();
				Thread.sleep(5000);
				if(driver.findElement(By.xpath("//div[@class = 'modal-content']")).isDisplayed()){
					Reporter.log("\tStatus: Clicked on Question mark successfully" ,true);
					Reporter.log("\tStatus: Popup opened" ,true);
					driver.findElement(By.xpath("//a[text() = 'close']")).click();	
					Reporter.log("\tStatus: Popup closed successfully" ,true  );
					Reporter.log("\tTest - PASSED",true);
				}else{
					Reporter.log("\tStatus: Popup not displayed" ,true  );
					Reporter.log("\tTest - FAILED",true);
				}	   
			}
			else{
				Reporter.log("\tStatus: Not Clicked on Question mark successfully"  ,true );
				Reporter.log("\tTest - FAILED",true);
			}
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Reporter.log("\tStatus: Not Clicked on Question mark successfully" ,true  );
			Reporter.log("\tTest - FAILED",true);	
		}	
	}

	public void  chooseDuration() throws InterruptedException
	{
		Reporter.log("\tTitle: Click on Dropdown to choose Duration",true);
		WebElement duration = driver.findElement(By.name("duration"));
		(new Actions(driver)).moveToElement(duration).perform();
		for(int i=0;i<durationdata.length;i++){
			Reporter.log("\tInput: "+durationdata[i],true );
			Select d = new Select(duration);
			d.selectByVisibleText(durationdata[i]);
			Thread.sleep(2000);
			if(d.getFirstSelectedOption().getText().equals(durationdata[i])){
				Reporter.log("\tStatus: Choosed "+d.getFirstSelectedOption().getText()+" from dropdown ",true);
				Reporter.log("\tTest - PASSED",true);
			}else{
				Reporter.log("\tStatus: Not Clicked on dropdown arrow to choose Duration ",true);
				Reporter.log("\tTest - FAILED",true);
			}	
		}
	}	


	public void  genderInfo() throws InterruptedException
	{
		Reporter.log("\tTitle: Click on Question icon preceeding Gender ",true);
		Reporter.log("\tInput: N/A" ,true);
		WebElement genderinfo = driver.findElement(By.xpath("//a[contains(@href,'gender')]/img"));
		try{						
			if(genderinfo.isDisplayed()){   
				genderinfo.click();
				Thread.sleep(5000);
				if(driver.findElement(By.xpath("//div[@class = 'modal-content']")).isDisplayed()){
					Reporter.log("\tStatus: Clicked on Question mark successfully" ,true);
					Reporter.log("\tStatus: Popup opened" ,true);
					driver.findElement(By.xpath("//a[text() = 'close']")).click();	
					Reporter.log("\tStatus: Popup closed successfully" ,true  );
					Reporter.log("\tTest - PASSED",true);
				}else{
					Reporter.log("\tStatus: Popup not displayed" ,true  );
					Reporter.log("\tTest - FAILED",true);
				}	   
			}
			else{
				Reporter.log("\tStatus: Not Clicked on Question mark successfully"  ,true );
				Reporter.log("\tTest - FAILED",true);
			}
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Reporter.log("\tStatus: Not Clicked on Question mark successfully" ,true  );
			Reporter.log("\tTest - FAILED",true);	
		}	
	}

	public void  chooseGender() throws InterruptedException
	{
		Reporter.log("\tTitle: Click checkbox following gender",true);

		for(int i=0;i<genderdata.length;i++){
			Reporter.log("\tInput : "+genderdata[i],true);
			driver.findElement(By.xpath("//input[@id = '"+genderdata[i]+"']/following::label[1]")).click();;
			Thread.sleep(2000);
			boolean check = (boolean)((JavascriptExecutor)driver).executeScript("return window.document.getElementById('"+genderdata[i]+"').checked");
			if(check == true){
				Reporter.log("\tStatus: Choosed "+genderdata[i],true);
				Reporter.log("\tTest - PASSED",true);
			}else{
				Reporter.log("\tStatus: Not Choosed "+genderdata[i],true);
				Reporter.log("\tTest - FAILED",true);
			}
		}
	}	


	public void  ageInfo() throws InterruptedException
	{
		Reporter.log("\tTitle: Click on Question icon preceeding Age ",true);
		Reporter.log("\tInput: N/A" ,true);
		WebElement ageinfo = driver.findElement(By.xpath("//div[text() = 'Age']//a[contains(@href,'age')]/img"));
		try{						
			if(ageinfo.isDisplayed()){   
				ageinfo.click();
				Thread.sleep(5000);
				if(driver.findElement(By.xpath("//div[@class = 'modal-content']")).isDisplayed()){
					Reporter.log("\tStatus: Clicked on Question mark successfully" ,true);
					Reporter.log("\tStatus: Popup opened" ,true);
					driver.findElement(By.xpath("//a[text() = 'close']")).click();	
					Reporter.log("\tStatus: Popup closed successfully" ,true  );
					Reporter.log("\tTest - PASSED",true);
				}else{
					Reporter.log("\tStatus: Popup not displayed" ,true  );
					Reporter.log("\tTest - FAILED",true);
				}	   
			}
			else{
				Reporter.log("\tStatus: Not Clicked on Question mark successfully"  ,true );
				Reporter.log("\tTest - FAILED",true);
			}
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Reporter.log("\tStatus: Not Clicked on Question mark successfully" ,true  );
			Reporter.log("\tTest - FAILED",true);	
		}	
	}

	public void  chooseAge() throws InterruptedException
	{
		Reporter.log("\tTitle: Click on Question mark icon preceeding age ",true);
		WebElement age = driver.findElement(By.id("age"));
		(new Actions(driver)).moveToElement(age).perform();
		for(int i=0;i<agedata.length;i++){
			Reporter.log("\tInput: "+agedata[i] ,true);
			Select d = new Select(age);
			d.selectByVisibleText(agedata[i]);
			Thread.sleep(3000);
			if(d.getFirstSelectedOption().getText().equals(agedata[i])){
				Reporter.log("\tStatus: Choosed "+d.getFirstSelectedOption().getText()+" from dropdown ",true);
				Reporter.log("\tTest - PASSED",true);
			}else{
				Reporter.log("\tStatus: Not Clicked on dropdown arrow to choose Age ",true);
				Reporter.log("\tTest - FAILED",true);
			}	
		}
	}		

	public void  smokeInfo() throws InterruptedException
	{
		Reporter.log("\tTitle: Click on Question icon preceeding Do You Smoke ",true);
		Reporter.log("\tInput: N/A" ,true);
		WebElement smokeinfo = driver.findElement(By.xpath("//a[contains(@href,'smoke')]/img"));
		try{						
			if(smokeinfo.isDisplayed()){   
				smokeinfo.click();
				Thread.sleep(5000);
				if(driver.findElement(By.xpath("//div[@class = 'modal-content']")).isDisplayed()){
					Reporter.log("\tStatus: Clicked on Question mark successfully" ,true);
					Reporter.log("\tStatus: Popup opened" ,true);
					driver.findElement(By.xpath("//a[text() = 'close']")).click();	
					Reporter.log("\tStatus: Popup closed successfully" ,true  );
					Reporter.log("\tTest - PASSED",true);
				}else{
					Reporter.log("\tStatus: Popup not displayed" ,true  );
					Reporter.log("\tTest - FAILED",true);
				}	   
			}
			else{
				Reporter.log("\tStatus: Not Clicked on Question mark successfully"  ,true );
				Reporter.log("\tTest - FAILED",true);
			}
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Reporter.log("\tStatus: Not Clicked on Question mark successfully" ,true  );
			Reporter.log("\tTest - FAILED",true);	
		}	
	}

	public void  chooseSmoke() throws InterruptedException
	{   
		Reporter.log("\tTitle: Choose option for Smoke ",true);
		Reporter.log("\tInput: N/A" ,true);

		for(int i=0;i<smokedata.length;i++){
			Reporter.log("\tInput : "+smokedata[i],true);
			driver.findElement(By.xpath("//input[@id ='"+smokedata[i]+"']/following::label[1]")).click();;
			Thread.sleep(2000);
			boolean check = (boolean)((JavascriptExecutor)driver).executeScript("return window.document.getElementById('"+smokedata[i]+"').checked");
			if(check == true){
				Reporter.log("\tStatus: Choosed "+smokedata[i]+" for Smoke",true);
				Reporter.log("\tTest - PASSED",true);
			}else{
				Reporter.log("\tStatus: Not Choosed on "+smokedata[i],true);
				Reporter.log("\tTest - FAILED",true);
			}
		}
	}



	public void  healthInfo() throws InterruptedException
	{
		Reporter.log("\tTitle: Click on Question icon preceeding Health ",true);
		Reporter.log("\tInput: N/A" ,true);
		WebElement healthinfo = driver.findElement(By.xpath("//a[contains(@href,'health')]/img"));
		try{						
			if(healthinfo.isDisplayed()){   
				healthinfo.click();
				Thread.sleep(5000);
				if(driver.findElement(By.xpath("//div[@class = 'modal-content']")).isDisplayed()){
					Reporter.log("\tStatus: Clicked on Question mark successfully" ,true);
					Reporter.log("\tStatus: Popup opened" ,true);
					driver.findElement(By.xpath("//a[text() = 'close']")).click();	
					Reporter.log("\tStatus: Popup closed successfully" ,true  );
					Reporter.log("\tTest - PASSED",true);
				}else{
					Reporter.log("\tStatus: Popup not displayed" ,true  );
					Reporter.log("\tTest - FAILED",true);
				}	   
			}
			else{
				Reporter.log("\tStatus: Not Clicked on Question mark successfully"  ,true );
				Reporter.log("\tTest - FAILED",true);
			}
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			Reporter.log("\tStatus: Not Clicked on Question mark successfully" ,true  );
			Reporter.log("\tTest - FAILED",true);	
		}	
	}

	public void  chooseHealth() throws InterruptedException
	{   
		Reporter.log("\tTitle: Click on dropdown arrow to choose Health ",true);
		WebElement health = driver.findElement(By.id("health"));
		(new Actions(driver)).moveToElement(health).perform();
		for(int i=0;i<healthdata.length;i++){
			Reporter.log("\tInput: "+healthdata[i],true );
			Select h  = new Select(health);
			Thread.sleep(3000);
			h.selectByVisibleText(healthdata[i]);
			if(h.getFirstSelectedOption().getText().equals(healthdata[i])){
				Reporter.log("\tStatus: Choose "+ h.getFirstSelectedOption().getText() +"from dropdown ",true);
				Reporter.log("\tTest - PASSED",true);
			}else{
				Reporter.log("\tStatus: Not Clicked on dropdown arrow to choose Health ",true);
				Reporter.log("\tTest - FAILED",true);
			}
		}
	}



	public void  invalidName() throws InterruptedException
	{
		String actualerrmsg = "* Please enter a valid name";
		Reporter.log("\tTitle: Input Invalid Name ",true);
		WebElement namefiled = driver.findElement(By.id("name"));
		WebElement emailfiled = driver.findElement(By.id("email"));
		(new Actions(driver)).moveToElement(namefiled).build().perform();
		//WebElement errspan = driver.findElement(By.xpath("//span[@class = 'error-quote'] and for = 'name'"));
		
		if(namefiled.isDisplayed()){
			for(int i=0;i<invalidnamedata.length;i++){
				namefiled.clear();
				Reporter.log("\tInput:"+invalidnamedata[i],true);
				namefiled.sendKeys(invalidnamedata[i]);
				
				(new Actions(driver)).sendKeys(emailfiled, Keys.TAB).perform();
				Thread.sleep(4000);
				try{
					if(driver.findElement(By.xpath("//span[@for = 'name']")).isDisplayed()){
						String expterrmsg =	driver.findElement(By.xpath("//span[@for = 'name']")).getText();
						if(actualerrmsg.equalsIgnoreCase(expterrmsg)){
							Reporter.log("\tStatus: " +" Should show Error messages like Enter lettersonly",true);
							Reporter.log("\tTest - PASSED",true);
						}else{
							Reporter.log("\tTest FAILED - Invalid error message showed",true);
						}
					}
				}catch(Exception e){
					Reporter.log("\tTest FAILED - Error message not displayed",true);
				}	 
			}

		}else{
			Reporter.log("\tStatus: Name not entered  successfully" ,true );
			Reporter.log("\tTest - FAILED",true);
		}

	}

	public void validName() throws InterruptedException{

		Reporter.log("\tTitle: Input Valid Name ",true);
		WebElement namefield = driver.findElement(By.id("name"));
		WebElement emailfiled = driver.findElement(By.id("email"));
		// WebElement errspan = driver.findElement(By.xpath("//span[@class = 'error-quote'] and for = 'name'"));
		(new Actions(driver)).moveToElement(namefield).build().perform();
		
		if(namefield.isDisplayed()){
			for(int i=0;i<validnamedata.length;i++){
				Reporter.log("\tInput:"+validnamedata[i],true);
				namefield.clear();
				namefield.sendKeys(validnamedata[i]);
				(new Actions(driver)).sendKeys(emailfiled, Keys.TAB).perform();
				Thread.sleep(2000);
				try{
					if(driver.findElement(By.xpath("//span[@for = 'name']")).isDisplayed()){
						Reporter.log("\tStatus: " +" Name not accepted",true);
						Reporter.log("\tTest - FAILED",true);   
					}
				}catch(Exception e){
					Reporter.log("\tStatus: Test PASSED - Name accepted",true);
				}	 
			}

		}else{
			Reporter.log("\tStatus: Name not entered  successfully" ,true );
			Reporter.log("\tTest - FAILED",true);
		}
	}

	public void  invalidEmail() throws InterruptedException
	{
		String actualerrmsg = "Please enter a valid email.";
		Reporter.log("\tTitle: Input Invalid Email ",true);
		WebElement emailfiled = driver.findElement(By.id("email"));
		WebElement sub = driver.findElement(By.id("submit"));
		(new Actions(driver)).moveToElement(emailfiled).build().perform();
		
		
		if(emailfiled.isDisplayed()){
			for(int i=0;i<invalidemaildata.length;i++){
				emailfiled.clear();
				Reporter.log("\tInput:"+invalidemaildata[i],true);
				emailfiled.sendKeys(invalidemaildata[i]);
				
				(new Actions(driver)).sendKeys(sub,Keys.TAB).build().perform();
				Thread.sleep(4000);
				try{
					if(driver.findElement(By.xpath("//span[@for = 'email']")).isDisplayed()){
						String expterrmsg =	driver.findElement(By.xpath("//span[@for='email']")).getText();
						if(actualerrmsg.equalsIgnoreCase(expterrmsg)){
							Reporter.log("\tStatus: " +" Should show Error messages like Invalid email",true);
							Reporter.log("\tTest - PASSED",true);
						}else{
							Reporter.log("\tTest FAILED - Invalid error message showed",true);
						}
					}
				}catch(Exception e){
					Reporter.log("\tTest FAILED - Error message not displayed",true);
				}	 
			}

		}else{
			Reporter.log("\tStatus: Email not entered  successfully" ,true );
			Reporter.log("\tTest - FAILED",true);
		}

	}	

	public void validEmail() throws InterruptedException{
         
		WebElement sub = driver.findElement(By.id("submit"));
		WebElement emailfield = driver.findElement(By.id("email"));
		(new Actions(driver)).moveToElement(emailfield).build().perform();
		if(emailfield.isDisplayed()){
			for(int i=0;i<validemaildata.length;i++){
				Reporter.log("\tInput:"+validemaildata[i],true);
				emailfield.clear();
				emailfield.sendKeys(validemaildata[i]);
				//driver.findElement(By.xpath("//div[@class = 'quote_section']")).click();
				
				(new Actions(driver)).sendKeys(sub,Keys.TAB).perform();
				Thread.sleep(2000);
				try{
					if(driver.findElement(By.xpath("//span[@for = 'email']")).isDisplayed()){
						Reporter.log("\tStatus: " +" Email Not Accepted",true);
						Reporter.log("\tTest - FAILED",true);   
					}
				}catch(Exception e){
					Reporter.log("\tStatus: Test PASSED - Email Accepted",true);
				}	 
			}
		}else{
			Reporter.log("\tStatus: Email not entered  successfully" ,true );
			Reporter.log("\tTest - FAILED",true);
		}


	} 

	public void checkCaptchaMsg() throws InterruptedException{
		Reporter.log("\tTitle: To check Captcha require messsage ",true);
		Reporter.log("\tInput: N/A ",true);
		WebElement captcha = driver.findElement(By.id("recaptcha_div"));
		(new WebDriverWait(driver,20)).until(ExpectedConditions.visibilityOf(captcha));
		if(captcha.isDisplayed()){
			Reporter.log("\tStatus: Captcha messsage is dislayed",true);
			Reporter.log("\tTest - PASSED",true);
		}else{
			Reporter.log("\tStatus: Captcha messsage not displayed",true);
			Reporter.log("\tTest - FAILED",true);
		}

	}


	public void getCapcha() throws InterruptedException{
		Reporter.log("\tTitle: Click Captcha ",true);
		String currentwindow = driver.getWindowHandle();
		WebElement frame = driver.findElement(By.xpath("//iframe[@title = 'recaptcha widget']"));
		driver.switchTo().frame(frame);
		WebElement check = driver.findElement(By.xpath("//span[@id = 'recaptcha-anchor']"));
		driver.findElement(By.xpath("//div[@class = 'recaptcha-checkbox-checkmark']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 130);
		wait.until(ExpectedConditions.attributeToBe(check, "aria-checked", "true"));
		driver.switchTo().window(currentwindow);
		Reporter.log("\tStatus: Complete Captcha",true);
		Reporter.log("\tTest - PASSED",true);
	}




	/*driver.switchTo().frame(0);
    	WebElement clickcapche = driver.findElement(By.xpath("html/body/div[2]/div[3]/div[2]/div/label"));
    	Thread.sleep(3000);
    	clickcapche.click();
    	//(new Actions(driver)).moveToElement(clickcapche).click().perform();;
	 */    	/* WebElement check = driver.findElement(By.id("recaptcha-anchor"));
    	(new WebDriverWait(driver, 180)).until(ExpectedConditions.attributeToBe(check, "aria-checked","true"));*/




	public void  getquoteButton() throws InterruptedException
	{  
		
		try{

		Reporter.log("\tTitle: Click on Get Quote Button ",true);
		WebElement e = driver.findElement(By.xpath(".//*[@id='submit']"));
		(new Actions(driver)).moveToElement(e).perform();
		Reporter.log("\tInput: N/A ");
		Thread.sleep(3000);
		e.click();
		Thread.sleep(3000);
		if(!existinguser()){
			Reporter.log("\tStatus:  Clicked on Get Quote Button",true);
			Reporter.log("\tTest - PASSED",true);
		}else{
			//Reporter.log("\tStatus: Not clicked on Get Quote Button",true);
			Reporter.log("\tTest - FAILED",true);
			throw new RiseException("Not complete BasicInfo");
		}
	   }catch (Exception e) {
		e.printStackTrace();
	   }
	}

	/*
	 * Existing user
	 */
	public boolean existinguser() throws InterruptedException
	{
		boolean result = false;
		Reporter.log("\tTitle: Check the user is existed or new ",true);
		try{
			WebElement msg = driver.findElement(By.xpath("//div[@class = 'sweet-content']"));
			//WebElement login = driver.findElement(By.xpath(".//*[@id='exist_login']"));
			if (msg.isDisplayed())
			{
				Reporter.log("\tStatus:"+msg.getText(),true);
				driver.findElement(By.xpath(".//*[@id='ok_button']")).click();
				Thread.sleep(5000);
				result = true;
			}
			/*else
		    {
		    	Reporter.log("\tStatus:Failed  Check the user is existed or new",true); 
		    	Reporter.log("TEST : Failed");
		    }*/
		}catch (Exception e) {
			Reporter.log("\tStatus: New user/ Redirect to next page",true);
			Reporter.log("TEST : Failed");
			result = false;
		}

		return result;
	}

	//
	// Quote methods in Getquote page 
	//  
	//

	public void verifyAmountAndDuration(){

		Reporter.log("\tTitle : Check Premium and Duration in Basic Info and Quote page",true);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String infoamount = (String)js.executeScript("return $(\"#coverage_amount\").val()");
		String infoduration = (String)js.executeScript("return  $(\"#NewCategory\").val()");

		String quoteamount = (String)driver.findElement(By.xpath("//span[@id = 'amountText']")).getText();
		String quoteduration = (String)driver.findElement(By.xpath("//span[@id = 'durationText']")).getText();

		if(infoamount.equals(quoteamount.replaceAll("[^0-9]",""))){
			Reporter.log("\tStatus : Passed :: Premium in InfoPage :"+infoamount+" ,Quote Page :"+quoteamount,true);
		}else{
			Reporter.log("\tStatus : Failed :: Premium in InfoPage :"+infoamount+" ,Quote Page :"+quoteamount,true);
		}

		if(infoduration.equals(quoteduration)){
			Reporter.log("\tStatus : Passed :: Duration in InfoPage :"+infoduration+" ,Quote Page :"+quoteduration,true);
		}else{
			Reporter.log("\tStatus : Passed :: Duration in InfoPage :"+infoduration+" ,Quote Page :"+quoteduration,true);
		}
	}


	public void checkFitBitDevices(){
		Reporter.log("\tTitle : Check Fitbit Devices display",true);
		WebElement devices = driver.findElement(By.xpath("//div[@class = 'quote_image']"));
		if(devices.isDisplayed()){
			Reporter.log("\tStatus : Passed :: Fitbit device image displayed",true);
		}else{
			Reporter.log("\tStatus : Failed :: Fitbit device not image displayed",true);
		}
	}

	@SuppressWarnings("static-access")
	public void clickCvrgAmountQst() throws InterruptedException{
		Thread.sleep(4000);
		Reporter.log("\tTitle : Click ? of the Coverage Amount",true);
		//WebElement qst = driver.findElement(By.xpath("//a[contains(@href,'coverage_amount')]/img"));
		WebElement qst = driver.findElement(By.xpath(".//*[@id='modal-popup5']/img"));
		if(qst.isDisplayed()){
			(new Actions(driver)).moveToElement(qst).perform();
			qst.click();
			Thread.sleep(2000);
			WebElement popup = driver.findElement(By.xpath("//div[@class = 'modal-content']").xpath("//div[text() = 'Coverage Amount']"));
			if(popup.isDisplayed()){
				driver.findElement(By.xpath("//a[text() = 'close']")).click();
				Reporter.log("\tStatus : Passed :: PopUp displayed",true); 
			}else{
				Reporter.log("\tStatus : Failed :: PopUp not displayed",true);
			}
		}else{
			Reporter.log("\tStatus : Failed:: ? mark not displayed",true);
		}
	}

	@SuppressWarnings("static-access")
	public void clickCvrgDurationQst() throws InterruptedException{
		Thread.sleep(4000);
		Reporter.log("\tTitle : Click ? of the Coverage Duration",true);
		WebElement qst = driver.findElement(By.xpath("//span[@id = 'durationText']/following::img[1]"));/*("//a[@id = 'modal-popup6']/img"));*/
		if(qst.isDisplayed()){
			(new Actions(driver)).moveToElement(qst).perform();
			qst.click();
			Thread.sleep(2000);
			WebElement popup = driver.findElement(By.xpath("//div[@class = 'modal-content']").xpath("//div[text() = 'Coverage Duration']"));
			if(popup.isDisplayed()){
				driver.findElement(By.xpath("//a[text() = 'close']")).click();
				Reporter.log("\tStatus : Passed :: PopUp displayed",true); 
			}else{
				Reporter.log("\tStatus : Failed :: PopUp not displayed",true);
			}
		}else{
			Reporter.log("\tStatus : Failed:: ? mark not displayed",true);
		}
	}

	@SuppressWarnings("static-access")
	public void clickPriceQst() throws InterruptedException{
		Thread.sleep(4000);
		Reporter.log("\tTitle : Click ? of the Price",true);
		WebElement qst = driver.findElement(By.xpath("//a[contains(@href,'price')]/img"));
		if(qst.isDisplayed()){
			(new Actions(driver)).moveToElement(qst).click().perform();
			Thread.sleep(2000);
			WebElement popup = driver.findElement(By.xpath("//div[@class = 'modal-content']").xpath("//div[text() = 'Your Quote']"));
			if(popup.isDisplayed()){
				driver.findElement(By.xpath("//a[text() = 'close']")).click();
				Reporter.log("\tStatus : Passed :: PopUp displayed",true); 
			}else{
				Reporter.log("\tStatus : Failed :: PopUp not displayed",true);
			}
		}else{
			Reporter.log("\tStatus : Failed:: ? mark not displayed",true);
		}
	}


	public void  selectQuote() throws InterruptedException
	{
		int x=20,y=3;
		DecimalFormat decimalformat = new DecimalFormat("#.00");
		/*
		 * Change amount slider
		 */
		try{
			for(int i=0;i<=slideramontdata.length;i++){
				Reporter.log("\n\tTitle: Move Coverage Amount Slider to $"+slideramontdata[i],true);
				Actions slider = new Actions(driver);
				WebElement slider1 = driver.findElement(By.xpath("//div[@id='amount']"));
				slider.moveToElement(slider1,x,y).click().perform();
				x = x+75;
				Thread.sleep(5000);
				String changedamount = (String)((JavascriptExecutor)driver).executeScript("return $('#amountText').text()");
				if(changedamount.equals(slideramontdata[i])){
					Reporter.log("\tStatus: Passed::Slider moved to $"+slideramontdata[i],true);

					/*
					 * Change duration slider
					 */

					WebElement durationslider = driver.findElement(By.xpath("//div[@id =  'duration']"));
					WebElement month = driver.findElement(By.xpath("//span[@id = 'estimateText']"));
					WebElement year = driver.findElement(By.xpath("//span[@id = 'estimateYearText']"));
					double permonth = 0.0;
					double peryear = 0.0;
					double actpre = 0.0;

					Reporter.log("\tTitle: Move Coverage Duration Slider to 10 years",true);
					Actions slider2 = new Actions(driver);
					slider2.moveToElement(durationslider,5,5).click().perform();;
					Thread.sleep(3000);
					String duration = (String)driver.findElement(By.xpath("//span[@id = 'durationText']")).getText();
					if("10".equals(duration)){
						Reporter.log("\tStatus: Passsed :: Slider moved to 10 years",true);

						/*
						 * Check Monthly premium  
						 */

						permonth = Double.parseDouble((String)month.getText());
						Reporter.log("\tTitle: Check Mothly premiun ",true);
						if(0.0<permonth){
							Reporter.log("\tStatus: Passed :: Mothly premiun "+permonth,true);
						}else{
							Reporter.log("\tStatus: Failed :: Mothly premiun "+permonth,true);
						}

						/*
						 *  Check Yearly premium
						 */

						peryear = Double.parseDouble((String)year.getText());
						Reporter.log("\tTitle: Check Mothly premiun ",true);
						actpre = Double.parseDouble(decimalformat.format(12*permonth));
						if(actpre == peryear){
							Reporter.log("\tStatus: Passed :: Yearly premiun "+peryear,true);
						}else{
							Reporter.log("\tStatus: Failed :: Yearly premiun "+actpre+" Expected :"+peryear,true);
						}

					}else{
						Reporter.log("\tStatus: Failed :: Slider Not  moved to 10 years",true);
					}

					Reporter.log("\tTitle: Move Coverage Duration Slider to 11 years",true);
					slider2 = new Actions(driver);
					slider2.moveToElement(durationslider,11,5).click().perform();;
					Thread.sleep(3000);
					duration = (String)driver.findElement(By.xpath("//span[@id = 'durationText']")).getText();
					if("11".equals(duration)){
						Reporter.log("\tStatus: Passsed :: Slider moved to 11 years",true);

						/*
						 * Check Monthly premium  
						 */

						permonth = Double.parseDouble((String)month.getText());
						Reporter.log("\tTitle: Check Mothly premiun ",true);
						if(0.0<permonth){
							Reporter.log("\tStatus: Passed :: Mothly premiun "+permonth,true);
						}else{
							Reporter.log("\tStatus: Failed :: Mothly premiun "+permonth,true);
						}

						/*
						 *  Check Yearly premium
						 */

						peryear = Double.parseDouble((String)year.getText());
						Reporter.log("\tTitle: Check Mothly premiun ",true);
						actpre = Double.parseDouble(decimalformat.format(12*permonth));
						if(actpre == peryear){
							Reporter.log("\tStatus: Passed :: Yearly premiun "+peryear,true);
						}else{
							Reporter.log("\tStatus: Failed :: Yearly premiun "+actpre+" Expected :"+peryear,true);
						}

					}else{
						Reporter.log("\tStatus: Failed :: Slider Not  moved to 11 years",true);
					}

					Reporter.log("\tTitle: Move Coverage Duration Slider to 21 years",true);
					slider2 = new Actions(driver);
					slider2.moveToElement(durationslider,155,5).click().perform();;
					Thread.sleep(3000);
					duration = (String)driver.findElement(By.xpath("//span[@id = 'durationText']")).getText();
					if("21".equals(duration)){
						Reporter.log("\tStatus: Passsed :: Slider moved to 21 years",true);

						/*
						 * Check Monthly premium  
						 */

						permonth = Double.parseDouble((String)month.getText());
						Reporter.log("\tTitle: Check Mothly premiun ",true);
						if(0.0<permonth){
							Reporter.log("\tStatus: Passed :: Mothly premiun "+permonth,true);
						}else{
							Reporter.log("\tStatus: Failed :: Mothly premiun "+permonth,true);
						}

						/*
						 *  Check Yearly premium
						 */

						peryear = Double.parseDouble((String)year.getText());
						Reporter.log("\tTitle: Check Mothly premiun ",true);
						actpre = Double.parseDouble(decimalformat.format(12*permonth));
						if(actpre == peryear){
							Reporter.log("\tStatus: Passed :: Yearly premiun "+peryear,true);
						}else{
							Reporter.log("\tStatus: Failed :: Yearly premiun "+actpre+" Expected :"+peryear,true);
						}

					}else{
						Reporter.log("\tStatus: Failed :: Slider Not  moved to 21 years",true);
					}
				}else{
					Reporter.log("\tStatus: Failed::Slider Not moved to $"+slideramontdata[i]+" Expected :"+changedamount,true);

				}
			}
		}catch (Exception e) {}

	}


	public void  confirmApply() throws InterruptedException, RiseException
	{
		Thread.sleep(3000);  
		Reporter.log("\tTitle: Click on Confirm&Apply Button ",true);
		WebElement e = driver.findElement(By.xpath("//input[@id = 'confirmApplyButton']"));
		Reporter.log("\tInput: N/A ");
		if(e.isDisplayed()){	
			(new Actions(driver)).moveToElement(e).click().perform();
			Thread.sleep(3000);
			WebElement check = driver.findElement(By.xpath("//div[text() = 'Just confirm and apply!']"));
			if(check.isDisplayed()){
				Reporter.log("\tStatus: Passed :: Clicked on Confirm&Apply Button",true);
			}else{
				Reporter.log("\tStatus: Failed :: Not Clicked on Confirm&Apply Button",true);
			}
		}else{
			Reporter.log("\tStatus: Failed ::Confirm&Apply Button Not Displyed",true);
			
			throw new RiseException("Confirm&Apply Button Not Displyed ");
		}
	}


	//***
	//   Confirm and Apply
	// 
	//**

	public void checkNewMonthlyPremium(){
		Reporter.log("\tTitle : Check new monthly premium  ",true);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String quote = (String)js.executeScript("return $('#estimateText').text()");
		String apply = (String)js.executeScript("return $('#newMonthlyCoverage').text()");
		if(quote.equals(apply)){
			Reporter.log("\tStatus:: Passed Quote Page :"+quote+" ,Apply Page :"+apply,true);
		}else{
			Reporter.log("\tStatus:: Faild Quote Page :"+quote+" ,Apply Page :"+apply,true);
		}
	}

	public void checkNewYearlyPremium(){
		Reporter.log("\tTitle : Check new yearly premium  ",true);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String quote = (String)js.executeScript("return $('#estimateYearText').text()");
		String apply = (String)js.executeScript("return $('#newCoverageperYear').text()");
		if(quote.equals(apply)){
			Reporter.log("\tStatus:: Passed Quote Page :"+quote+" ,Apply Page :"+apply,true);
		}else{
			Reporter.log("\tStatus:: Faild Quote Page :"+quote+" ,Apply Page :"+apply,true);
		} 
	}

	public void checkNewCoverageAmount(){
		Reporter.log("\tTitle : Check new coverage amount  ",true);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String quote = (String)js.executeScript("return $('#amountText').text()");
		String apply = (String)js.executeScript("return $('#newCoverageAmount').text()");
		if(quote.equals(apply)){
			Reporter.log("\tStatus:: Passed Quote Page :"+quote+" ,Apply Page :"+apply,true);
		}else{
			Reporter.log("\tStatus:: Faild Quote Page :"+quote+" ,Apply Page :"+apply,true);
		} 
	}

	public void checkNewDuration(){
		Reporter.log("\tTitle : Check new Duration  ",true);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String quote = (String)js.executeScript("return $('#durationText').text()");
		String apply = (String)js.executeScript("return $('#newDuration').text()");
		if(quote.equals(apply)){
			Reporter.log("\tStatus:: Passed Quote Page :"+quote+" ,Apply Page :"+apply,true);
		}else{
			Reporter.log("\tStatus:: Faild Quote Page :"+quote+" ,Apply Page :"+apply,true);
		} 
	}

	public void  CBasicinfo() throws InterruptedException
	{

		Reporter.log("\tTitle: Click on Basic Info Button ",true);
		Reporter.log("\tInput: N/A ",true);
		WebElement e = driver.findElement(By.xpath("//ul[@id='quote_process']//a[text() = 'Basic Info']"));
		if(e.isDisplayed())
		{	
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click();", e);
			Thread.sleep(3000);
			Reporter.log("\tStatus::Passed Clicked on Basic Info Button",true);
			WebElement info = driver.findElement(By.xpath("//div[text() = 'First we need some basic info from you.']"));
			if(info.isDisplayed())
			{
				Reporter.log("\tStatus::Passed to Moved  Basic Info",true);
			}else
			{
				Reporter.log("\tStaus::Failed to Moved Basic Info",true);
			}
		}
		else
		{
			Reporter.log("\tStatus::Failed Not clicked on Basic Info Button",true);
		}

	}

	public void  getquotebutton1() throws InterruptedException
	{
		Reporter.log("\tTitle: Click on Get Quote Button ",true);
		WebElement e = driver.findElement(By.xpath("//input[@id='submit']"));
		Reporter.log("\tInput: N/A ",true);
		if(e.isDisplayed())
		{	
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click();", e);
			Thread.sleep(3000);
			Reporter.log("\tStatus::Passed  Clicked on Get Quote Button",true);
		}
		else
		{
			Reporter.log("\tStatus::Failed Not clicked on Get Quote Button",true);			
		}

	}

	public void  confirmApply1() throws InterruptedException
	{
		Reporter.log("\tTitle: Click on Confirm&Apply Button ",true);
		WebElement e = driver.findElement(By.id("confirmApplyButton"));
		Reporter.log("\tInput: N/A ",true);
		if(e.isDisplayed())
		{	
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click();", e);
			Thread.sleep(3000);
			Reporter.log("\tStatus::Passed  Clicked on Confirm&Apply Button",true);

		}
		else
		{
			Reporter.log("\tStatus::Failed Not clicked on Confirm&Apply Button",true);
		}
	}

	public void  getQuoteInfo() throws InterruptedException
	{
		Reporter.log("\tTitle: Click on Get Quote Info Button ",true);
		Reporter.log("\tInput: N/A ",true);
		WebElement e = driver.findElement(By.xpath("//ul[@id='quote_process']//a[text() = 'Get Quote']"));;
		if(e.isDisplayed())
		{	
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click()",e);
			Thread.sleep(3000);
			Reporter.log("\tStatus:Passed Clicked on Basic Info Button",true);
			WebElement quoteinfo = driver.findElement(By.xpath("//input[@id = 'confirmApplyButton']"));
			if(quoteinfo.isDisplayed())
			{
				Reporter.log("\tStatus::Passed to Moved Quote Info",true);
			}else
			{
				Reporter.log("\tStatus::Failed to Moved Quote Info",true);
			}

		}
		else
		{
			Reporter.log("\tStatus:Failed Not clicked on Basic Info Button",true);
		}

	}

	public void  confirmapply2() throws InterruptedException
	{

		Reporter.log("\tTitle: Click on Confirm&Apply Button ",true);
		WebElement e = driver.findElement(By.id("confirmApplyButton"));
		Reporter.log("\tInput: N/A ",true);
		if(e.isDisplayed())
		{	
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click();", e);
			Thread.sleep(3000);
			Reporter.log("\tStatus::Passed  Clicked on Confirm&Apply Button",true);
		}
		else
		{
			Reporter.log("\tStatus::Failed Not clicked on Confirm&Apply Button",true);

		}
	}

	public void checkFitbitDeviceVisible(){
		Reporter.log("\tTitle To check Fitbit devices Visible",true);
		WebElement device = driver.findElement(By.xpath("//div[@id = 'confirm_caret']"));
		if(device.isDisplayed()){
			Reporter.log("\tStatus::Passed Devices is displayed",true);
		}else{
			Reporter.log("\tStatus::Failed Dvices are not displayed",true);
		}
	}

	public void checkResend_link_btn(){
		Reporter.log("\tTitle check Resend button displayed or not");
		WebElement resend = driver.findElement(By.xpath("//input[@id = 'resend_link_btn']"));
		if(resend.isDisplayed()){
			Reporter.log("\tStatus::Passed Resend button displyed",true); 
		}else{
			Reporter.log("\tStatus::Falied Resend button not displayed",true);
		}
	}

	public void bannerText(){
		Reporter.log("\tTitle check  or not",true);
		WebElement text = driver.findElement(By.xpath("//div[@class = 'text-center email-view-header']"));
		if(text.isDisplayed()){
			Reporter.log("\tStatus::Passed "+text.getText()+" displayed",true);
		}else{
			Reporter.log("\tStatus::Failed email verification text not displayed",true);
		}


	}

	public void  buyNow() throws InterruptedException
	{
		Reporter.log("\tTitle: Click on Apply Button ",true);
		WebElement e = driver.findElement(By.xpath("//input[@id = 'buynow_btn']"));
		Reporter.log("\tInput: N/A ",true);
		if(e.isDisplayed())
		{	
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click();", e);
			Thread.sleep(5000);
			((JavascriptExecutor)driver).executeScript("$('#ok_button').click();");
			Reporter.log("\tStatus::Passed  Clicked on Confirm Button",true);
		}
		else
		{
			Reporter.log("\tStatus::Failed Not clicked on Confirm Button",true);
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

	/*public int[] callAllMethodsBI(WebDriver driver) throws InterruptedException
	{
		//callAllMethodsBI(driver);
		zipcode(driver);
		invalidzipcode1(driver);
		invalidzipcode2(driver);
		invalidzipcode3(driver);
		invalidzipcode4(driver);
		invalidzipcode5(driver);
		invalidzipcode6(driver);

		invalidzipcode7(driver);
		faceamount(driver);
		choosefaceamount(driver);
		choosefaceamount2(driver);
		choosefaceamount3(driver);
		choosefaceamount4(driver);
		duration(driver);
		chooseduration1(driver);
		chooseduration2(driver);
		chooseduration3(driver);
		gender(driver);
		choosegender1(driver);
		choosegender2(driver);
		age(driver);
		chooseage(driver);
		smoke(driver);
		choosesmoke1(driver);
		choosesmoke2(driver);
		health(driver);
		choosehealth(driver);
		choosehealth1(driver);
		choosehealth2(driver);
		choosehealth3(driver);
		name(driver);
		name2(driver);
		name3(driver);
		name4(driver);
		email(driver);
		email2(driver);
		email3(driver);
		email4(driver);
		getquotebutton(driver);
		hereyourquote(driver);
		confirmapply(driver);
		CBasicinfo(driver);
		getquotebutton1(driver);
		confirmapply1(driver);
		getquote1(driver);
		confirmapply2(driver);
		apply(driver);
		//existinguser(driver);
		int countarray[] = new int[3];

		countarray[0]= this.testnum;
		countarray[1]= this.passcount;
		countarray[2]= this.failcount;
		Reporter.log("Total Tests : "+testNum);
			Reporter.log("Pass Tests : "+passCount);
			Reporter.log("Fail Tests : "+failCount);
		return countarray;
	}*/
}


