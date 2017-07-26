package com.sureifylife;

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

import com.sun.org.apache.bcel.internal.generic.VariableLengthInstruction;
import com.sun.org.apache.regexp.internal.RE;

import sun.security.util.PropertyExpander.ExpandException;

public class ConfirmAddress {

	WebDriver driver = null;
	WebDriverWait wait = null;
    JavascriptExecutor js = null;

	String[] invalid_add_data = {
			"    "
	};

	String[] valid_add_data1 = {
			"Michel(mick) ,foresh hills Lane 1 , FalteNo #101 , Massachusetts, USA"
	};

	String valid_add_data2 = 
			"Michel(mick) ,green valley ,Massachusetts , USA";

	String[] inavalidcitydata = {
			"     " , "12345" , ";'..][]" , "1234*&^" , "weed123" , "weed<>;" ,
			"qwertyuioplkjhgfdsazxcvbnmmnbvcxzlkjhgfdsapoiuytresqwertyuioplkjhgfdsazxcvbnmmnbvcxzlkjhgfdsapoiuytrs"
	};

	String[] validcitydata = {
			"weed city" , "weed"	
	};

	String[] state = {
			"California"
	};

	String[] invalidzipcode = {
			"    ","123","1234567890"
	};

	String[] validzipcode = {
			"12345-6789" , "96094"	
	};

	public ConfirmAddress(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
		js = (JavascriptExecutor)driver;
	}
	
	public void enterText(String webelement,String[] data,String criteria) throws InterruptedException{

		(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.id(webelement)));
		WebElement name = driver.findElement(By.id(webelement));
		WebElement send = driver.findElement(By.id("send_button"));
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false)", name);
		for(int i=0;i<data.length;i++){

			Reporter.log("\tInput :: "+data[i],true);
			name.clear();
			name.sendKeys(data[i]);
			send.click();
			Thread.sleep(5000);
			if(criteria.equalsIgnoreCase("invalid")){

				if( driver.findElement(By.xpath("//div[@for = '"+webelement+"']")).isDisplayed()){
					Reporter.log("\tStatus ::Passed ",true);
				}else{
					Reporter.log("\tStatus ::Failed ",true);
				}
			}else if(criteria.equalsIgnoreCase("valid")){
				
				try{
					if(driver.findElement(By.xpath("//div[@for = '"+webelement+"']")).isDisplayed() ){
						Reporter.log("\tStatus ::Failed ",true);
					}
				}catch(Exception e){
					Reporter.log("\tStatus :: Passed",true);
				}
				
			}else{
				Reporter.log("\tStatus :: Invalid criteria : "+criteria,true);
			}
            
		}
	}

	

	public void enterAdd(String webelement,String[] data,String criteria) throws InterruptedException{

		(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.id(webelement)));
		WebElement name = driver.findElement(By.id(webelement));
		
		WebElement send = driver.findElement(By.id("send_button"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false)", name);
		
		for(int i=0;i<data.length;i++){

			Reporter.log("\tInput :: "+data[i],true);
			name.clear();
			name.sendKeys(data[i]);
			send.click();
			Thread.sleep(5000);
			if(criteria.equalsIgnoreCase("invalid")){

				if(driver.findElement(By.xpath("//div[@for = '"+webelement+"']")).isDisplayed() ){
					Reporter.log("\tStatus ::Passed ",true);
				}else{
					Reporter.log("\tStatus ::Failed ",true);
				}
			}else if(criteria.equalsIgnoreCase("valid")){
				try{
					if( driver.findElement(By.xpath("//div[@for = '"+webelement+"']")).isDisplayed()){
						Reporter.log("\tStatus ::Failed ",true);
					}
				}catch(Exception e){
					Reporter.log("\tStatus ::Passed ",true);
				}
				
			}else{
				Reporter.log("\tStatus :: Invalid criteria : "+criteria,true);
			}

		}
	}

	public void enterZip(String webelement,String[] data,String criteria) throws InterruptedException{

		(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.id(webelement)));
		WebElement name = driver.findElement(By.id(webelement));
		
		WebElement send = driver.findElement(By.id("send_button"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false)", name);
		
		for(int i=0;i<data.length;i++){

			Reporter.log("\tInput :: "+data[i],true);
			name.clear();
			name.sendKeys(data[i]);
			send.click();
			Thread.sleep(5000);
			if(criteria.equalsIgnoreCase("invalid")){

				if( driver.findElement(By.xpath("//div[@for = '"+webelement+"']")).isDisplayed()){
					Reporter.log("\tStatus ::Passed ",true);
				}else{
					Reporter.log("\tStatus ::Failed ",true);
				}
			}else if(criteria.equalsIgnoreCase("valid")){
				try{
					if( driver.findElement(By.xpath("//div[@for = '"+webelement+"']")).isDisplayed() ){
						Reporter.log("\tStatus ::Failed ",true);
					}
				}catch(Exception e){
					Reporter.log("\tStatus ::Passed ",true);
				}

			}else{
				Reporter.log("\tStatus :: Invalid criteria : "+criteria,true);
			}

		}
	}

	public void state(String id) throws InterruptedException{

		WebElement st = driver.findElement(By.id(id));
		for(int i=0;i<state.length;i++){
			Reporter.log("\tInput :"+state[i],true);
			Select c = new Select(st);
			c.selectByVisibleText(state[i]);
			Thread.sleep(3000);
			String expt = c.getFirstSelectedOption().getText();
			if(state[i].equals(expt)){
				Reporter.log("\tStatus ::Passed",true); 
			}else{
				Reporter.log("\tStatus ::Failed Act :"+state[i]+" ,Expt :"+expt,true);
			}
		}  
	}

	public void checkField(String id){
		String res = null;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try{
			res = (String)js.executeScript("return $('#"+id+"').val();");	
			if(res != null){
				Reporter.log("\tStatus ::Passed : "+res,true);
			}else{
				Reporter.log("\tStatus ::Failed, Field was empty"+res,true);
			}
		}catch(Exception e){
			Reporter.log("\tStatus ::Exception raised",true);
			e.getMessage();
		}
	}

	public void uncheckCheckBox(){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('sameAsPrimaryAddress').scrollIntoView(false);");
    	js.executeScript("$('#sameAsPrimaryAddress').click();");
	}
	
	//test
    public void clickAddressCheckBox() throws InterruptedException{
    	Reporter.log("Test Step",true);
    	Reporter.log("\tTitle : Click Address check box ",true);
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("document.getElementById('sameAsPrimaryAddress').scrollIntoView(false);");
    	js.executeScript("$('#sameAsPrimaryAddress').click();");
    	Thread.sleep(3000);
    	boolean check = (Boolean)js.executeScript("return $('#sameAsPrimaryAddress').is(\":checked\");");
    	if(check){
    		String res = null;
    		Reporter.log("\tStatus ::Passed to click check box",true);
    		
    		Reporter.log("Test Step",true);
    		Reporter.log("\tTitle : Check Address1 field",true);
    		checkField("confirmAddressLine1");
    	
    		Reporter.log("Test Step",true);
    		Reporter.log("\tTitle : Check Address2 field",true);
    	    checkField("confirmAddressLine2");
    		
    	    Reporter.log("Test Step",true);
    	    Reporter.log("\tTitle : Check City filed",true);
    		checkField("confirmCity");
    	   
    		Reporter.log("Test Step",true);
    		Reporter.log("\tTitle : Check State ",true);
    		res = (String)js.executeScript("return $('#confirmState option:selected').text();");
    		if(res != null){
				Reporter.log("\tStatus ::Passed : "+res,true);
			}else{
				Reporter.log("\tStatus ::Failed, Field was empty"+res,true);
			}
    		
    		Reporter.log("Test Step",true);
    		Reporter.log("\tCheck ZipCode field",true);
    		checkField("confirmZip");
    		
    	}else{
    		Reporter.log("\tStatus ::Failed to click check box",true);
    	}
    }
	

	public void invalidAdd1() throws InterruptedException{
		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Test Address1 field with inavalid data ",true);
		enterAdd("confirmAddressLine1", invalid_add_data, "invalid");
	}

	public void invalidCity() throws InterruptedException{
		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Test City field with inavalid data ",true);
		enterText("confirmCity", inavalidcitydata, "invalid");
	}

	public void invalidZip() throws InterruptedException{
		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Test ZipCode field with inavalid data ",true);
		enterZip("confirmZip", invalidzipcode, "invalid");
	}


	public void validAdd1() throws InterruptedException{
		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Test Address1 field with valid data ",true);
		enterAdd("confirmAddressLine1", valid_add_data1, "valid");
	}

	public void validAdd2() throws InterruptedException{
		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Test Address2 field with valid data ",true);
		WebElement name = driver.findElement(By.id("confirmAddressLine2"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false)", name);
		name.sendKeys(valid_add_data2);
		Thread.sleep(3000);
		String res = (String)((JavascriptExecutor)driver).executeScript("return $('#confirmAddressLine2').val();");
		if(valid_add_data2.equals(res)){
			Reporter.log("\tStatus ::Passed",true);
		}else{
			Reporter.log("\tStatus ::Failed",true);
		}
			
	}

	public void validCity() throws InterruptedException{
		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Test City field with Valid data ",true);
		enterText("confirmCity", validcitydata, "valid");
	}

	public void selectState() throws InterruptedException{
		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Select State ",true);
		state("confirmState");
	}
	
	public void validZip() throws InterruptedException{
		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Test Zipcode field with valid data ",true);
		enterZip("confirmZip", validzipcode, "valid");
	}

	
	//test
	public void userLogin() throws InterruptedException{
		
		Reporter.log("\tTitle : User login ",true);
		WebElement mail = driver.findElement(By.id("email"));
		WebElement pwd = driver.findElement(By.id("password"));
		WebElement login = driver.findElement(By.id("send_button"));
		
		Reporter.log("\tUsername : suresh@sureify.com",true);
		mail.sendKeys("suresh@sureify.com");
		Reporter.log("\tPassword : Vendus@123",true);
		pwd.sendKeys("Vendus@123");
		Thread.sleep(5000);
		((JavascriptExecutor)driver).executeScript("$('#send_button').click();");
		Thread.sleep(3000);
		
		try{
			if((Boolean)js.executeScript("return $('#ok_button').is(\":visible\");")){
				js.executeScript("$('#ok_button').click();");
				Thread.sleep(3000);
				((JavascriptExecutor)driver).executeScript("$('#send_button').click();");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		wait.until(ExpectedConditions.urlContains("users/dashboard"));
		Reporter.log("\tStatus : Passed to login",true);
		Thread.sleep(5000);
		WebElement logout = driver.findElement(By.id("logout"));
		Reporter.log("\tTitle : User logout",true);
		if(logout.isDisplayed()){
			logout.click();
			wait.until(ExpectedConditions.urlContains("login"));
			Reporter.log("\tStatus :Passed to logout",true);
		}else{
			Reporter.log("\tStatus : Failed to display logout button",true);
		}
		
	}
	
	//test
	public void clickSendButton() throws InterruptedException{
		
		Reporter.log("\tTitle click to send button",true);
		try{
			WebElement next = driver.findElement(By.id("send_button"));
			(new Actions(driver)).moveToElement(next).perform();
			if(next.isDisplayed()){
				next.click();
				WebElement mail = driver.findElement(By.id("email"));
				(new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOf(mail));
				Reporter.log("\tStatus ::Passed clicked Send button",true);   	   
			}else{
				Reporter.log("\tStatus ::Failed to Displayed Send button",true);
			}
		}catch (Exception e){
			Reporter.log("\tStatus ::Excception raised",true);
			e.printStackTrace();
		}

	}
		
	//test
	public void clickSameAdd() throws InterruptedException{
		
		Thread.sleep(5000);
		clickAddressCheckBox();
		Thread.sleep(5000);
		//uncheckCheckBox();
		//Thread.sleep(5000);
		
	}

	
	//test
	public void addFiledsWithInvalidData() throws InterruptedException{

		invalidAdd1();
		invalidCity();
		invalidZip();
	}
	
	//test
	public void addFiledsWithValidData() throws InterruptedException{

		validAdd1();
		validAdd2();
		validCity();
		selectState();
		validZip();

	}
}
