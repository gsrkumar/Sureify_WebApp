package com.sureifylife;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class AppProcessReplacement {

	WebDriver driver = null;
	
	String[] invalid_cmpyname_data = {
			"      " , "_MetLife" , " MetLife" , "123MetLife" , "@#$%^&",
			

	};

	String[] valid_cmpyname_data = {
			"Met-Life (MET)" , "MetLife (MET)" , "MetLife.CO (MET)" , "MetLife&Co (MET)" , 
			"qwertyuioplkjhgfdsazxcvbnmmnbvcxzlkjhgfdsapoiuytresqwertyuioplkjhgfdsazxcvbnmmnbvcxzlkjhgfdsapoiuytrs",
			"MetLife" ,"Met Life"

	};
	
	String[] invalid_number_data = {
			"      " , "@##$@#$" , "Agh10@#$ " , " 10Ap189798" , "123456789012345678901" , "number" 
	};

	String[] valid_number_data = {
			"10US1f00156" , "561245782"
	};
	
	public AppProcessReplacement(WebDriver driver){
		
		this.driver = driver;
	}
	
	public void  clickOption(String name,String id,WebElement check) throws InterruptedException{

		Reporter.log("\tInput : Select "+name+"",true);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		boolean visible = (Boolean)js.executeScript("return $('#"+id+"').is(':visible')");
		if(visible){
			js.executeScript("document.getElementById('"+id+"').scrollIntoView(false);");
			js.executeScript("$('#"+id+"').click();");
			Thread.sleep(5000);
			if(check.isEnabled()){
				Reporter.log("\tStatus ::Passed "+name+" selected",true);
			}else{
				Reporter.log("\tStatus ::Failed "+name+" select",true);
			}
		}else{
			Reporter.log("\tStatus ::Failed "+name+" button not displayed",true);
		}	
	}
	
	public void enterText(String webelement,String[] data,String criteria) throws InterruptedException{

		(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.id(webelement)));
		WebElement name = driver.findElement(By.id(webelement));
		WebElement req = driver.findElement(By.xpath("//input[@id = '"+webelement+"']/following::small[1]"));
		WebElement len = driver.findElement(By.xpath("//input[@id = '"+webelement+"']/following::small[2]"));;
		WebElement alpha = driver.findElement(By.xpath("//input[@id = '"+webelement+"']/following::small[3]"));;
		WebElement leter = driver.findElement(By.xpath("//input[@id = '"+webelement+"']/following::small[4]"));;
		//(new Actions(driver)).moveToElement(name).perform();
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false)", name);
		for(int i=0;i<data.length;i++){

			Reporter.log("\tInput :: "+data[i],true);
			name.clear();
			name.sendKeys(data[i]);
			Thread.sleep(5000);
			if(criteria.equalsIgnoreCase("invalid")){

				if( req.isDisplayed() || alpha.isDisplayed() || len.isDisplayed() || leter.isDisplayed()){
					Reporter.log("\tStatus ::Passed ",true);
				}else{
					Reporter.log("\tStatus ::Failed ",true);
				}
			}else if(criteria.equalsIgnoreCase("valid")){
				if( !req.isDisplayed() && !alpha.isDisplayed() && !len.isDisplayed() && !leter.isDisplayed()){
					Reporter.log("\tStatus ::Passed ",true);
				}else{
					Reporter.log("\tStatus ::Failed ",true);
				}
			}else{
				Reporter.log("\tStatus :: Invalid criteria : "+criteria,true);
			}

		}
	}
	
	public void enterPolicyNumber(String webelement,String[] data,String criteria) throws InterruptedException{

		(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.id(webelement)));
		WebElement name = driver.findElement(By.id(webelement));
		WebElement req = driver.findElement(By.xpath("//input[@id = '"+webelement+"']/following::small[1]"));
		WebElement notvalid = driver.findElement(By.xpath("//input[@id = '"+webelement+"']/following::small[2]"));;
		WebElement len = driver.findElement(By.xpath("//input[@id = '"+webelement+"']/following::small[3]"));;
		//(new Actions(driver)).moveToElement(name).perform();
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false)", name);

		for(int i=0;i<data.length;i++){

			Reporter.log("\tInput :: "+data[i],true);
			name.clear();
			name.sendKeys(data[i]);
			Thread.sleep(5000);
			if(criteria.equalsIgnoreCase("invalid")){

				if( req.isDisplayed() || notvalid.isDisplayed() || len.isDisplayed()){
					Reporter.log("\tStatus ::Passed ",true);
				}else{
					Reporter.log("\tStatus ::Failed ",true);
				}
			}else if(criteria.equalsIgnoreCase("valid")){
				if( !req.isDisplayed() && !notvalid.isDisplayed() && !len.isDisplayed()){
					Reporter.log("\tStatus ::Passed ",true);
				}else{
					Reporter.log("\tStatus ::Failed ",true);
				}
			}else{
				Reporter.log("\tStatus :: Invalid criteria : "+criteria,true);
			}

		}
	}
	
	//
	//Will the insurance applied for with this application replace or effect 
	//any of the owner's other life or annuity contracts 
	//(including pending coverage provided with a binding receipt)? 
	//
	// Yes
	//
	public void select_Yes_Replace() throws InterruptedException{
		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Will the insurance applied for with this application replace or effect any of the owner's other life or annuity contracts  ",true);

		WebElement check = driver.findElement(By.xpath("//label[contains(text() , 'policies below that will be replaced.')]"));
		clickOption("Yes", "replacement_yes", check);
	}
	
	//
	//Will the insurance applied for with this application replace or effect 
	//any of the owner's other life or annuity contracts 
	//(including pending coverage provided with a binding receipt)? 
	//
	// No
	//
	public void select_No_Replace() throws InterruptedException{
		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Will the insurance applied for with this application replace or effect any of the owner's other life or annuity contracts  ",true);

		WebElement check = driver.findElement(By.xpath("//label[contains(text() , 'Code section 1035 exchange?')]"));
		clickOption("No", "replacement_no", check);
	}
	
	//
	//Is this an Internal Revenue Code section 1035 exchange?
	//
	// Yes
	//
	public void select_Yes_Revenue() throws InterruptedException{
		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Is this an Internal Revenue Code section 1035 exchange?  ",true);

		WebElement check = driver.findElement(By.xpath("//label[contains(text() , 'Code section 1035 exchange?')]"));
		clickOption("Yes", "exchange_y", check);
	}
	
	//
	//Is this an Internal Revenue Code section 1035 exchange?
	//
	// No
	//
	public void select_No_Revenue() throws InterruptedException{
		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Is this an Internal Revenue Code section 1035 exchange?  ",true);

		WebElement check = driver.findElement(By.xpath("//label[contains(text() , 'Code section 1035 exchange?')]"));
		clickOption("No", "exchange_n", check);
	}
	
	public  boolean clickReplaceThis() throws InterruptedException{

		JavascriptExecutor js = (JavascriptExecutor)driver;
		boolean res = false;
		boolean check = (Boolean)js.executeScript("return $('#replace_policy').is(':checked')");
		if(!check){
			js.executeScript("$('#replace_policy').click();");
			Thread.sleep(3000);
			check = (Boolean)js.executeScript("return $('#replace_policy').is(':checked')");
			if(check){
				res = true;
			}
		}else{
			res = true;
		}

		return res;
	}
	
	public void invalid_Company() throws InterruptedException{

		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Test name of the company field with invalid data",true);
		if(clickReplaceThis()){
		   enterText("company_name", invalid_cmpyname_data, "invalid");
		}else{
			Reporter.log("\tStatus ::Faild , to click chech box",true);
		}

	}

	public void valid_Company() throws InterruptedException{

		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Test name of the company field with valid data",true);
		if(clickReplaceThis()){
			enterText("company_name", valid_cmpyname_data, "valid");
		}else{
			Reporter.log("\tStatus ::Faild , to click chech box",true);
		}

	}
	
	public void invalid_Policy() throws InterruptedException{

		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Test PolicyNumber field with invalid data",true);
		if(clickReplaceThis()){
			enterText("policy_name", invalid_number_data , "invalid");
		}else{
			Reporter.log("\tStatus ::Faild , to click chech box",true);
		}
	}

	public void valid_Policy() throws InterruptedException{

		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Test PolicyNumber field with valid data",true);
		if(clickReplaceThis()){
			enterText("policy_name", valid_number_data , "valid");
		}else{
			Reporter.log("\tStatus ::Faild , to click chech box",true);
		}
	}  

	//test
	public void addAnotherReplacement() throws InterruptedException{

		Reporter.log("\tTitle : Add another replacement",true);
		select_Yes_Replace();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement add = driver.findElement(By.id("add_another_replacement"));
		js.executeScript("arguments[0].scrollIntoView", add);
		add.click();
		Thread.sleep(5000);
		if(driver.findElement(By.id("company_name2")).isDisplayed()){
			Reporter.log("\tStatus :: Passed Add another replacement ",true);
		}else{
			Reporter.log("\tStatus :: Failed Add another replacement",true);
		}

	}
	
	//test
	public void removePolicy() throws InterruptedException{

		Reporter.log("\tTitle : Remove policy",true);
		WebElement ele = driver.findElement(By.xpath(".//*[@id='info_div6']/ol/div[2]/div[2]/a/span"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false)", ele);
		ele.click();
		Thread.sleep(3000);
		try{
			if(ele.isDisplayed()){
				Reporter.log("\tStatus ::Failed",true); 
			}
		}catch(Exception e){
			Reporter.log("\tStatus ::Passed",true);
		}
	}
	
	//test
	public void select_Yes_Yes() throws InterruptedException{
		
		select_Yes_Replace();
	
		if(clickReplaceThis()){
			Thread.sleep(5000);
			invalid_Company();
			valid_Company();
			invalid_Policy();
			valid_Policy();
			select_Yes_Revenue();
		}else{
            Reporter.log("\tStatus ::Failed to click replace this check box",true);
		}
	
	}
	
	//test
	public void select_No_No() throws InterruptedException{
		
		select_No_Replace();
	    Thread.sleep(5000);
	    select_No_Revenue();
	    
	}
	
	public void clickNext() throws InterruptedException{

		Reporter.log("\tTitle click Next button",true);
		try{
			WebElement next = driver.findElement(By.id("next_button"));
			(new Actions(driver)).moveToElement(next).perform();
			if(next.isDisplayed()){
				next.click();
				(new WebDriverWait(driver, 30)).until(ExpectedConditions.attributeToBe(By.xpath("//li[@id = '7']"), "class","active"));
				Reporter.log("\tStatus ::Passed clicked Next button",true);   	   
			}else{
				Reporter.log("\tStatus ::Failed to Displayed Next button",true);
			}
		}catch (Exception e){
			Reporter.log("\tStatus ::Excception raised",true);
			e.printStackTrace();
		}

	}
	
}
