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

public class AppProcessOwnershipInfo {

	WebDriver driver = null;
	WebDriverWait wait = null;

	String[] inavalid_name_data = {
			"   ", " testdata", "_testdata", "testdata12", "testdata?;'", "12345", "';';,[] " , "testdata_"
	};

	String[] valid_name_data = {
			"a","Test data","Test'data","Test-data","Test.data","Testdata"
	};

	String[] validrelname = {
			"testdata" , "test data"
	};
	
	String[] month = {

			"November",
	};

	String[] days = {
			"25"	
	};

	String[] year = {
			"1962"
	};

	String[] invalidssndata = {
			"    " , "ad" , "';." , "523  " , "52412  "
	};

	String[] validssndata = {
			"541236987"
	};

	String[] invalid_add_data = {
			"    "
	};

	String[] valid_add_data1 = {
			"Michel(mick) ,foresh hills Lane 1 , FalteNo #101 , Massachusetts, USA"
	};

	String valid_add_data2 = 
			"Michel(mick) ,green valley ,Massachusetts , USA";

	String[] inavalidcitydata = {
			"     " , "12345" , ";'..][]" , "1234*&^" , "weed123" , "weed<>;" 
	};

	String[] validcitydata = {
			"weed city" , "weed"	
	};

	String[] state = {
			"California"
	};

	String[] invalidzipcode = {
			"123","    ","1234567890"
	};

	String[] validzipcode = {
			"12345-6789" , "96094"	
	};

	public AppProcessOwnershipInfo(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
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

	public void chooseBirth() throws InterruptedException{

		Reporter.log("\tTitle: Select Month,Day and Year of Birth ",true);
		WebElement mon = driver.findElement(By.id("person_birthmonth"));
		//(new Actions(driver)).moveToElement(mon).perform();
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false)", mon);
		for(int i=0;i<month.length;i++){

			Reporter.log("\tInput : "+month[i]+"/"+days[i]+"/"+year[i],true);
			Select m = new Select(mon);
			m.selectByVisibleText(month[i]);
			Thread.sleep(3000);
			String exptmon = m.getFirstSelectedOption().getText();
			if(month[i].equals(exptmon)){

				Reporter.log("\tStatus ::Passed to select month",true);
				WebElement day = driver.findElement(By.id("person_birthday"));
				Select d = new Select(day);
				d.selectByVisibleText(days[i]);
				Thread.sleep(3000);
				String exptday = d.getFirstSelectedOption().getText();
				if(days[i].equals(exptday)){

					Reporter.log("\tStatus ::Passed to select day",true);
					WebElement yer = driver.findElement(By.id("person_birthyear"));
					Select y = new  Select(yer);
					y.selectByVisibleText(year[i]);
					Thread.sleep(3000);
					String exptyear = y.getFirstSelectedOption().getText();
					if(year[i].equals(exptyear)){

						Reporter.log("\tStatus ::Passed to select year",true);

					}else{

						Reporter.log("\tStaus ::Failed to select year Act :"+year[i]+", Expt :"+exptyear,true);
					}

				}else{
					Reporter.log("\tStatus ::Failed to select day Act :"+days[i]+" ,Expt :"+exptday,true);
				}

			}else{

				Reporter.log("\tStatus ::Failed to select month Act :"+month[i]+", Expt :"+exptmon,true);

			}

		}

	}

	//
	//  Who will own and manage this policy?
	//  Person 
	//
	public void selectPerson() throws InterruptedException{
		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Who will own and manage this policy? ",true);

		WebElement check = driver.findElement(By.xpath("//label[text() = 'Is that person you or someone else?']"));
		clickOption("Person", "policy_person", check);
	}

	//
	//  Who will own and manage this policy?
	//  trust
	//
	public void selectTrust() throws InterruptedException{
		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Who will own and manage this policy? ",true);

		WebElement check = driver.findElement(By.xpath("//label[contains(text() ,'name of this trust?')]"));
		clickOption("Trust", "policy_trust", check);
	}

	//
	//  Is that person you or someone else?
	//  Me 
	//
	public void selectMe() throws InterruptedException{
		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Is that person you or someone else?",true);

		WebElement check = driver.findElement(By.xpath("//label[text() = 'Is there a joint-owner?']"));
		clickOption("Me", "policy_trust_1", check);
	}

	//
	// Is that person you or someone else?
	// Someone else
	//
	public void selectSomeoneElse() throws InterruptedException{
		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Is that person you or someone else?",true);

		WebElement check = driver.findElement(By.xpath("//label[contains(text() , 'their full name?')]"));
		clickOption("Someone else", "policy_trust_2", check);
	}

	//
	// Is there a joint-owner?
	//  Yes 
	//
	public void selectYes() throws InterruptedException{
		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Is there a joint-owner?",true);

		WebElement check = driver.findElement(By.xpath("//label[contains(text() ,'their full name?')]"));
		clickOption("Yes", "joint_owner_1", check);
	}

	//
	// Is there a joint-owner?
	//  No
	//
	public void selectNo() throws InterruptedException{
		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Is there a joint-owner?",true);

		WebElement check = driver.findElement(By.id("next_button"));
		clickOption("No", "joint_owner_2", check);
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

	public void enterSSNNumber(String webelement,String[] data,String criteria) throws InterruptedException{

		(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.id(webelement)));
		WebElement name = driver.findElement(By.id(webelement));
		WebElement req = driver.findElement(By.xpath("//input[@id = '"+webelement+"']/following::small[1]"));
		WebElement notvalid = driver.findElement(By.xpath("//input[@id = '"+webelement+"']/following::small[2]"));;
		//(new Actions(driver)).moveToElement(name).perform();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false)",name);
		
		for(int i=0;i<data.length;i++){

			Reporter.log("\tInput :: "+data[i],true);
			name.clear();
			name.sendKeys(data[i]);
			Thread.sleep(5000);
			if(criteria.equalsIgnoreCase("invalid")){

				if( req.isDisplayed() || notvalid.isDisplayed() ){
					Reporter.log("\tStatus ::Passed ",true);
				}else{
					Reporter.log("\tStatus ::Failed ",true);
				}
			}else if(criteria.equalsIgnoreCase("valid")){
				if( !req.isDisplayed() && !notvalid.isDisplayed() ){
					Reporter.log("\tStatus ::Passed ",true);
				}else{
					Reporter.log("\tStatus ::Failed ",true);
				}
			}else{
				Reporter.log("\tStatus :: Invalid criteria : "+criteria,true);
			}
		}
	}

	public void enterAdd(String webelement,String[] data,String criteria) throws InterruptedException{

		(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.id(webelement)));
		WebElement name = driver.findElement(By.id(webelement));
		WebElement req = driver.findElement(By.xpath("//input[@id = '"+webelement+"']/following::small[1]"));
		//(new Actions(driver)).moveToElement(name).perform();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false)", name);
		
		for(int i=0;i<data.length;i++){

			Reporter.log("\tInput :: "+data[i],true);
			name.clear();
			name.sendKeys(data[i]);
			Thread.sleep(5000);
			if(criteria.equalsIgnoreCase("invalid")){

				if( req.isDisplayed() ){
					Reporter.log("\tStatus ::Passed ",true);
				}else{
					Reporter.log("\tStatus ::Failed ",true);
				}
			}else if(criteria.equalsIgnoreCase("valid")){
				if( req.isDisplayed() == false){
					Reporter.log("\tStatus ::Passed ",true);
				}else{
					Reporter.log("\tStatus ::Failed ",true);
				}
			}else{
				Reporter.log("\tStatus :: Invalid criteria : "+criteria,true);
			}

		}
	}

	public void enterZip(String webelement,String[] data,String criteria) throws InterruptedException{

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
		js.executeScript("document.getElementById('pending_radio1').scrollIntoView(false);");
    	js.executeScript("$('#pending_radio1').click();");
	}
	
	//test
    public void clickAddressCheckBox() throws InterruptedException{
    	Reporter.log("Test Step",true);
    	Reporter.log("\tTitle : Click Address check box ",true);
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("document.getElementById('pending_radio1').scrollIntoView(false);");
    	js.executeScript("$('#pending_radio1').click();");
    	Thread.sleep(3000);
    	boolean check = (Boolean)js.executeScript("return $('#pending_radio1').is(\":checked\");");
    	if(check){
    		String res = null;
    		Reporter.log("\tStatus ::Passed to click check box",true);
    		
    		Reporter.log("Test Step",true);
    		Reporter.log("\tTitle : Check Address1 field",true);
    		checkField("person_address_line1");
    	
    		Reporter.log("Test Step",true);
    		Reporter.log("\tTitle : Check Address2 field",true);
    	    checkField("person_address_line2");
    		
    	    Reporter.log("Test Step",true);
    	    Reporter.log("\tTitle : Check City filed",true);
    		checkField("person_city");
    	   
    		Reporter.log("Test Step",true);
    		Reporter.log("\tTitle : Check State ",true);
    		res = (String)js.executeScript("return $('#person_state option:selected').text();");
    		if(res != null){
				Reporter.log("\tStatus ::Passed : "+res,true);
			}else{
				Reporter.log("\tStatus ::Failed, Field was empty"+res,true);
			}
    		
    		Reporter.log("Test Step",true);
    		Reporter.log("\tCheck ZipCode field",true);
    		checkField("person_zipcode");
    		
    	}else{
    		Reporter.log("\tStatus ::Failed to click check box",true);
    	}
    }
	public void invalidName() throws InterruptedException{
		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Test Full Name field with inavalid data",true);
		enterText("person_name", inavalid_name_data, "invalid");
	}

	public void invalidRelName() throws InterruptedException{
		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Test Relation Name field with inavalid data",true);
		enterText("person_relationship", inavalid_name_data, "invalid");
	}

	public void invalidSSN() throws InterruptedException{
		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Test SSN Number field with inavalid data",true);
		enterSSNNumber("person_taxid", invalidssndata, "invalid");
	}

	public void invalidAdd1() throws InterruptedException{
		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Test Address1 field with invalid data ",true);
		enterAdd("person_address_line1", invalid_add_data, "invalid");
	}

	public void invalidCity() throws InterruptedException{
		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Test City field with invalid data ",true);
		enterText("person_city", inavalidcitydata, "invalid");
	}

	public void invalidZip() throws InterruptedException{
		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Test ZipCode field with invalid data ",true);
		enterZip("person_zipcode", invalidzipcode, "invalid");
	}



	public void validName() throws InterruptedException{
		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Test Name field with valid data",true);
		enterText("person_name", valid_name_data, "valid");
	}

	public void validRelName() throws InterruptedException{
		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Test Relation Name field with Valid data",true);
		enterText("person_relationship", validrelname, "valid");
	}

	public void selectDOB() throws InterruptedException{
		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Select DOB",true);
		chooseBirth();
	}

	public void validSSN() throws InterruptedException{
		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Test SSN Number field with Valid data",true);
		enterSSNNumber("person_taxid", validssndata, "valid");
	}

	public void validAdd1() throws InterruptedException{
		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Test Address1 field with valid data ",true);
		enterAdd("person_address_line1", valid_add_data1, "valid");
	}

	public void validAdd2() throws InterruptedException{
		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Test Address2 field with valid data ",true);
		WebElement name = driver.findElement(By.id("person_address_line2"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false)", name);
		name.sendKeys(valid_add_data2);
		Thread.sleep(3000);
		String res = (String)((JavascriptExecutor)driver).executeScript("return $('#person_address_line2').val();");
		if(valid_add_data2.equals(res)){
			Reporter.log("\tStatus ::Passed",true);
		}else{
			Reporter.log("\tStatus ::Failed",true);
		}
			
	}

	public void validCity() throws InterruptedException{
		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Test City field with Valid data ",true);
		enterText("person_city", validcitydata, "valid");
	}

	public void selectState() throws InterruptedException{
		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Select State ",true);
		state("person_state");
	}
	
	public void validZip() throws InterruptedException{
		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Test Zipcode field with valid data ",true);
		enterZip("person_zipcode", validzipcode, "valid");
	}
	
	public void trustName() throws InterruptedException{
		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Enter name of the trust",true);
		enterText("trust_name", valid_name_data, "valid");
	}
	
	public void trustAdd1() throws InterruptedException{
		Reporter.log("Test step",true);
		Reporter.log("\tTitle : Enter Trust Address1",true);
		enterAdd("trust_address_line1", valid_add_data1,"valid");
	}
	
	public void trustAdd2() throws InterruptedException{
		Reporter.log("Test step",true);
		Reporter.log("\tTitle : Enter Trust Address2",true);
		enterAdd("trust_address_line2", new String[] {valid_add_data2},"valid");
	}
	
	public void trustCity() throws InterruptedException{
		Reporter.log("Test Step",true);
		Reporter.log("\tTitle : Enter Trust City ",true);
		enterText("trust_city", validcitydata, "valid");
	}
    
	public void trustState() throws InterruptedException{
		Reporter.log("Test Step",true);;
		Reporter.log("\tTitle : Enter Trust State",true);
		state("trust_state");
	}
	public void trustZip() throws InterruptedException{
		Reporter.log("Test Step",true);;
		Reporter.log("\tTitle : Enter Trust Zipcode",true);
		enterZip("trust_zipcode", validzipcode, "valid");
	}
	
	public void clickNext() throws InterruptedException{
		
		Reporter.log("\tTitle click Next button",true);
		try{
			WebElement next = driver.findElement(By.id("next_button"));
			(new Actions(driver)).moveToElement(next).perform();
			if(next.isDisplayed()){
				next.click();
				(new WebDriverWait(driver, 30)).until(ExpectedConditions.attributeToBe(By.xpath("//li[@id = '5']"), "class","active"));
				Reporter.log("\tStatus ::Passed clicked Next button",true);   	   
			}else{
				Reporter.log("\tStatus ::Failed to Displayed Next button",true);
			}
		}catch (Exception e){
			Reporter.log("\tStatus ::Excception raised",true);
			e.printStackTrace();
		}

	}
		
		
		
	//test
	public void testFiledsWithInvalidData() throws InterruptedException{

		selectPerson();
		selectMe();
		selectYes();

		invalidName();
		invalidRelName();
		invalidSSN();
		invalidAdd1();
		invalidCity();
		invalidZip();
	}
	
	//test
	public void select_Person_Me_Yes() throws InterruptedException{

		selectPerson();
		selectMe();
		selectYes();

		validName();
		validRelName();
		selectDOB();
		validSSN();
		
		Thread.sleep(5000);
		clickAddressCheckBox();
		Thread.sleep(5000);
		uncheckCheckBox();
		Thread.sleep(5000);
		
		validAdd1();
		validAdd2();
		validCity();
		selectState();
		validZip();

	}

	//test
	public void select_Person_somoneElse() throws InterruptedException{

		selectPerson();
		selectSomeoneElse();

		validName();
		validRelName();
		selectDOB();
		validSSN();
        
		Thread.sleep(5000);
		clickAddressCheckBox();
		Thread.sleep(5000);
		uncheckCheckBox();
		Thread.sleep(5000);
		
		validAdd1();
		validAdd2();
		validCity();
		selectState();
		validZip();

	}
     
	//test
	public void  trust() throws InterruptedException{
		
		selectTrust();
		
		trustName();
		trustAdd1();
		trustAdd2();
		trustCity();
		trustState();
		trustZip();
		
	}

    //test
	public void select_Person_Me_No() throws InterruptedException{
		
		selectPerson();
		selectMe();
		selectNo();
		clickNext();
		
	}

}
