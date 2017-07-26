package com.sureifylife;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;


public class AppProcessMedicalInfo {
    
	WebDriver driver = null;
	JavascriptExecutor js = null;
	
	String[] inavalid_name_data = {
			"   ", "';';,[] " ," testdata", "_testdata", "testdata12", "testdata?;'", "12345",  "testdata_"
	};

	String[] valid_name_data = {
			"qwertyuioplkjhgfdsazxcvbnmqwertyuioplkjhgfdsazxcvb",
		    	"a","Test data","Test'data","Test-data","Test.data","Testdata"
	};
	
	String[] invalid_date = {
			"      " ,"abcdefg","@#$%&*?","  /2008","01/    ","10/abcd","ab/2008",
			 "00/0000" ,"102008" , "00/2005" , "13/2017"
	};
	
	String[] valid_date = {
		    "01/2016" , "12/2006" , "02/2015" , "11/2007"	
	};
	
	String[] valid_healthcaredata = {
			"a","Test data","Testdata"
	};
	
	String[] invalid_add_data = {
		"    "
	};

	String[] valid_add_data1 = {
			 "testdata-testdata-testdata-testdata-testdata-testdata-testdata-testdata-testdata-testdata-testdata-t",
			"Michel(mick) ,foresh hills Lane 1 , FalteNo #101 , Massachusetts, USA"
	};

	String[] valid_add_data2 = {
			"testdata-testdata-testdata-testdata-testdata-testdata-testdata-testdata-testdata-testdata-testdata-t",
			"Michel(mick) ,green valley ,Massachusetts , USA"
	};
	
	String[] inavalidcitydata = {
			"     " , "12345" , ";'..][]" , "1234*&^" , "weed123" , "weed<>;" ,
			"qwertyuioplkjhgfdsazxcvbnmqwertyuioplkjhgfdsazxcvb"
	};

	String[] validcitydata = {
			"weed city" , "weed"	
	};
	
	String[] state = {
			"California"
	};
	
	String[] invalidzipcode = {
			"    ","123","1234567890" ,"1234-56789"
	};

	String[] validzipcode = {
			"96094"	, "12345-6789"
	};


	public AppProcessMedicalInfo(WebDriver driver){

		this.driver = driver;
		
		js = (JavascriptExecutor)driver;
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
	
	//
	// Within the last 10 years, has the Proposed Insured been treated for,
	// diagnosed as having a heart condition, chest pain, stroke, cancer, diabetes,
	// alcohol abuse or drug dependency?
	//
	//  Yes
	
	public void select_Yes_Diagnosed() throws InterruptedException{
		
		//Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Select Diagnosed Yes ",true);

		WebElement check = driver.findElement(By.xpath("//label[text() = 'Please include details regarding each diagnosis.']"));
		clickOption("Yes", "your_drug_1", check);
		Thread.sleep(5000);
	}
	
	//
	// Within the last 10 years, has the Proposed Insured been treated for,
	// diagnosed as having a heart condition, chest pain, stroke, cancer, diabetes,
	// alcohol abuse or drug dependency?
	//
	//  No
	
	public void select_No_Diagnosed() throws InterruptedException{
		
		//Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Select Diagnosed No",true);

		WebElement check = driver.findElement(By.id("next_button"));
		clickOption("No", "your_drug_2", check);
		Thread.sleep(5000);
	}
	
	public void enterText(String webelement,String[] data,String criteria) throws InterruptedException{
		
		WebElement name = driver.findElement(By.id(webelement));
		WebElement req = driver.findElement(By.xpath("//input[@id = '"+webelement+"']/following::small[1]"));
		WebElement notvalid = driver.findElement(By.xpath("//input[@id = '"+webelement+"']/following::small[2]"));;
		WebElement len = driver.findElement(By.xpath("//input[@id = '"+webelement+"']/following::small[3]"));;
		//(new Actions(driver)).moveToElement(name).perform();
       // ((JavascriptExecutor)driver).executeScript("document.getElementById('"+webelement+"').scrollIntoView(false);");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false)", name);
		for(int i=0;i<data.length;i++){

			Reporter.log("\tInput :: "+data[i],true);
			(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.id(webelement)));
			String check = (String)js.executeScript("return $('#"+webelement+"').val()");
			if(!check.equals("")){
				name.clear();
			}
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

	//test
	public void state() throws InterruptedException{
        
		Reporter.log("\tTitle :: Select Diagnosis state",true);
		((JavascriptExecutor)driver).executeScript("document.getElementById('medical_state').scrollIntoView(false);");
		WebElement st = driver.findElement(By.id("medical_state"));
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

	//test
	public void addAnotherDiagnosis() throws InterruptedException{

		Reporter.log("\tTitle : Add another Diagnosis",true);
		select_Yes_Diagnosed();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//WebElement add = driver.findElement(By.id("addpolicy3"));
		js.executeScript("document.getElementById('addpolicy3').scrollIntoView(false);");
		js.executeScript("$('#addpolicy3').click();");
		Thread.sleep(5000);
		if(driver.findElement(By.id("diagnosis_name2")).isDisplayed()){
			Reporter.log("\tStatus :: Passed Add another Diagnosis ",true);
		}else{
			Reporter.log("\tStatus :: Failed Add another Diagnosis",true);
		}

	}
	
	//test
	public void removeDiagnosis() throws InterruptedException{

		Reporter.log("\tTitle : Remove policy",true);
		WebElement ele = driver.findElement(By.xpath(".//*[@id='info_div7']/ol/div[2]/div[3]/a/span"));
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
	public void invalidDiagnosis() throws InterruptedException{
		
		//Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Test Diagnosis name field with invalid data",true);
		enterText("diagnosis_name", inavalid_name_data, "invalid");
	}	
	
	//test
	public void invalidDateofDiagnosis() throws InterruptedException{

		//Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Test Date of diagnosis field with invalid data",true);
		enterText("diagnosis_date", invalid_date, "invalid");
	}	
	
	//test
	public void invalidHealthcareProvider() throws InterruptedException{

		//Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Test Healthcare Provider field with invalid data",true);
		enterText("provider", inavalid_name_data, "invalid");
	}	
	
	//test
	public void invalidAddress1() throws InterruptedException{

		//Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Test Diagnosis Address1 field with invalid data",true);
		enterText("diagnosis_address_line1", valid_healthcaredata, "invalid");
	}	
	
	//test
	public void invalidCity() throws InterruptedException{

		//Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Test Diagnosis City field with invalid data",true);
		enterText("diagnosis_city", inavalidcitydata, "invalid");
	}	
	
	//test
	public void invalidZip() throws InterruptedException{

		//Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Test Diagnosis zipcode field with invalid data",true);
		enterText("diagnosis_zip", invalidzipcode, "invalid");
	}	
	
	
	//test	
	public void validZip() throws InterruptedException{

		//Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Test Diagnosis zipcode field with valid data",true);
		enterText("diagnosis_zip", validzipcode, "valid");
	}	

	//test
	public void validCity() throws InterruptedException{

		//Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Test Diagnosis City field with valid data",true);
		enterText("diagnosis_city", validcitydata, "valid");
	}

	//test
	public void validAddress2() throws InterruptedException{

		//Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Test Diagnosis Address2 field with valid data",true);
		enterText("diagnosis_address_line2", valid_add_data2, "valid");
	}	
	
	//test
	public void validAddress1() throws InterruptedException{

		//Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Test Diagnosis Address1 field with valid data",true);
		enterText("diagnosis_address_line1", valid_add_data1, "valid");
	}	
	
	//test
	public void validHealthcareProvider() throws InterruptedException{

		//Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Test Healthcare Provider field with valid data",true);
		enterText("provider", valid_name_data, "valid");
	}	
	
	//test
	public void validDateofDiagnosis() throws InterruptedException{

		//Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Test Date of diagnosis field with valid data",true);
		enterText("diagnosis_date", valid_date, "valid");
	}	
	
	//test
	public void validDiagnosis() throws InterruptedException{

		//Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Test Diagnosis Name field with valid data",true);
		enterText("diagnosis_name", valid_name_data, "valid");
	}
	
	public void clickNext() throws InterruptedException{

		Reporter.log("\tTitle click Next button",true);
		try{
			WebElement next = driver.findElement(By.id("next_button"));
			(new Actions(driver)).moveToElement(next).perform();
			if(next.isDisplayed()){
				next.click();
				(new WebDriverWait(driver, 30)).until(ExpectedConditions.attributeToBe(By.xpath("//li[@id = '8']"), "class","active"));
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
