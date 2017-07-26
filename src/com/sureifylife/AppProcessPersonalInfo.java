package com.sureifylife;

import java.util.ArrayList;
import java.util.List;

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

public class AppProcessPersonalInfo {

	WebDriver driver = null;
	List<String> validnamedata = new ArrayList<String>();
	
	String[] inavalinamedata = {
			 "   ", 
			 " name",             
             "_name",          
             "name12",
             "name?;'",
             "12345",
             "';';,[] ",
             "name_",
             
	};
	
	String[] month = {
			"January",
			"February",
			"November",
			"December",
			"July"
	};
	
	String[] days = {
		     "1","2","29","30","5"	
	};
	
	String[] year = {
			"1901","1902","2015","2016","1990"
	};
	
	String[] gender = {
			"female" , "male"
	};
	
	String[] heigtdata = {
			"4' 10\"" , "4' 11\"" , "6' 4\"" ,"6' 3\""
	};
	
	String[] invalidwightdata = {
			"wig" , "@#$" ,"wi1" , "wi@","   " , "0" , "00" ,"000" ,"59"
	};
	
	String[] validwightdata = {
			"60" , "61" , "998" , "999"
	};
	
	String[] invalidssndata = {
			"    " , "ads" , "';." , " 5234" , "524  " , "524 12  "
	};
	
	String[] validssndata = {
			"541236987"
	};
	
	String[] country = {
			"India"
	};
	
	String[] state = {
			"California"
	};
	
	String[] inavalidcitydata = {
			"     " , "12345" , ";'..][]" , "1234*&^" , "weed123" , "weed<>;" ,
			
	};
	
	String[] validcitydata = {
		  "qwertyuioplkjhgfdsazxcvbnmmnbvcxzlkjhgfdsapoiuytre" ,"weed city" , "weed"	
	};
	
	String[] invalidzipcode = {
			"    ","123","1234567890"
	};
	
	String[] validzipcode = {
		  "12345-6789" , "96094"	
	};
	
	String[] invalidMObileData = {
			"    " , "ads" , "';." , " 5234" , "524  " , "524 12  ","123456789"	
	};
	
	String[] validmobileData = {
			"9955123456"
	};
	
	String[] invalidlicensedata = {
			"     " , "&&&&@##" , "$$$14253" , "@@@Abfc"
	};
	
	String[]  validlicensedata = {
			"123456789" , "ABCFGK" , "1456ABFGH"
	};
	
	String[] inavalid_occuoation_data = {
			"     " , "12345" , ";'..][]" , "1234,." , "Qa123" , "QA<>';" ,
			"qwertyuioplkjhgfdsazx"
	};
	
	String[] valid_occuoation_data = {
			"QAEngineer" , "QA Engineer" 
	};
	
	String[]  inavalid_wzip_data = {
		"   " , "1234"	
	};
	
	String[] valid_wzip_data = {
		"96094"	
	};
	public AppProcessPersonalInfo(WebDriver driver){
		
		this.driver = driver;
		validnamedata.add("name-test");
		validnamedata.add("name'test");
		validnamedata.add("name.test");

	}
 
   public void ivName(String locater) throws InterruptedException{
	   
	   (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.id(locater)));
	    WebElement firstNameEle = driver.findElement(By.id(locater));
	   (new Actions(driver)).moveToElement(firstNameEle).perform();;
	   WebElement req = driver.findElement(By.xpath("//input[@id = '"+locater+"']/following::small[1]"));
	   WebElement alpha = driver.findElement(By.xpath("//input[@id = '"+locater+"']/following::small[2]"));
	   WebElement fifty = driver.findElement(By.xpath("//input[@id = '"+locater+"']/following::small[3]"));
	   for(int i=0;i<inavalinamedata.length;i++){
		   
		   Reporter.log("\tInput :"+inavalinamedata[i],true);
		   firstNameEle.clear();
		   firstNameEle.sendKeys(inavalinamedata[i]);
		   firstNameEle.sendKeys(Keys.ENTER);  
		   Thread.sleep(3000);
		   if(req.isDisplayed() == true || alpha.isDisplayed() == true || fifty.isDisplayed() == true){
			   
			   Reporter.log("\tStatus ::Passed",true);
		   }else{
			   
			   Reporter.log("\tStatus ::Failed",true);
		   }
		   
	   }
	   
   }
  
   public void vName(String locater) throws InterruptedException{
	   
	   (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.id(locater)));
	   WebElement firstNameEle = driver.findElement(By.id(locater));
	   (new Actions(driver)).moveToElement(firstNameEle).perform();
	   WebElement req = driver.findElement(By.xpath("//input[@id = '"+locater+"']/following::small[1]"));
	   WebElement alpha = driver.findElement(By.xpath("//input[@id = '"+locater+"']/following::small[2]"));
	   WebElement fifty = driver.findElement(By.xpath("//input[@id = '"+locater+"']/following::small[3]"));
	   for(int i=0;i<validnamedata.size();i++){
		   
		   Reporter.log("\tInput :"+validnamedata.get(i),true);
		   firstNameEle.clear();
		   firstNameEle.sendKeys(validnamedata.get(i));
		   (new Actions(driver)).sendKeys(Keys.TAB);  
		   Thread.sleep(3000);
		   boolean middle = false;
		   if(!locater.equals("user_middle_name")){
			   middle = fifty.isDisplayed();
		   }
		   if(req.isDisplayed() == false && alpha.isDisplayed() == false && middle == false){
			   
			   Reporter.log("\tStatus ::Passed",true);
		   }else{
			   
			   Reporter.log("\tStatus ::Failed",true);
		   }
		   
	   }
   }
   
   public void invalidFirstName() throws InterruptedException{
	   
	   Reporter.log("\tTitle : Test FirstName field with invalid data",true);
	   ivName("user_first_name");
	   
   }
   
   public void invalidMiddleName() throws InterruptedException{
	   
	   Reporter.log("\tTitle : Test MiddleName field with invalid data",true);
	   ivName("user_middle_name");
	   
   }
   
   public void invalidLastName() throws InterruptedException{
	   
	   Reporter.log("\tTitle : Test LastName field with invalid data",true);
	   ivName("user_last_name");
	   
   }
   
   public void validFirstName() throws InterruptedException{
	   
	   Reporter.log("\tTitle : Test FirstName field with valid data",true);
	   validnamedata.add("suresh");
	   vName("user_first_name");
	   validnamedata.remove("suresh");
   }
   
   public void validMiddleName() throws InterruptedException{
	   
	   Reporter.log("\tTitle : Test MiddleName field with valid data",true);
	   validnamedata.add("kumar");
	   vName("user_middle_name");
	   validnamedata.remove("kumar");
   }
   
   public void validLastName() throws InterruptedException{
	   
	   Reporter.log("\tTitle : Test LastName field with valid data",true);
	   validnamedata.add("gollapalli");
	   vName("user_last_name");
	   validnamedata.remove("gollapalli");
   }
   
   public void chooseBirth() throws InterruptedException{
	   
	   Reporter.log("\tTitle: Select Month,Day and Year of Birth ",true);
	   WebElement mon = driver.findElement(By.id("user_month"));
	   (new Actions(driver)).moveToElement(mon).perform();
	   for(int i=0;i<month.length;i++){
		   
		   Reporter.log("\tInput : "+month[i]+"/"+days[i]+"/"+year[i],true);
		   Select m = new Select(mon);
		   m.selectByVisibleText(month[i]);
		   Thread.sleep(3000);
		   String exptmon = m.getFirstSelectedOption().getText();
		   if(month[i].equals(exptmon)){
			   
			   Reporter.log("\tStatus ::Passed to select month",true);
			   WebElement day = driver.findElement(By.id("user_day"));
			   Select d = new Select(day);
			   d.selectByVisibleText(days[i]);
			   Thread.sleep(3000);
			   String exptday = d.getFirstSelectedOption().getText();
			   if(days[i].equals(exptday)){
				   
				   Reporter.log("\tStatus ::Passed to select day",true);
				   WebElement yer = driver.findElement(By.id("user_year"));
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
   
   public void chooseGender() throws InterruptedException{
	 
	   Reporter.log("\tTitle choose gender");
	   (new Actions(driver)).moveToElement(driver.findElement(By.xpath("//label[text() = 'Please tell us your sex.']"))).perform();
	   for(int i=0;i<gender.length;i++){
	
		   Reporter.log("\tInput : "+gender[i],true);
           try{
        	  ((JavascriptExecutor)driver).executeScript("$('#"+gender[i]+"').click();");
           }catch(Exception e){
		      driver.findElement(By.xpath("//input[@id = '"+gender[i]+"']")).click();
           }
		   Thread.sleep(5000);
		   if(driver.findElement(By.xpath("//label[@class = 'btn btn-radio active']/input")).getAttribute("id").equals(gender[i])){
			   
			   Reporter.log("\tStatus ::Passed",true);
		   }else{
			   
			   Reporter.log("\tStatus ::Failed",true);
		   }
	   }
   }
   
   public void selectHeight() throws InterruptedException{
	  
	   Reporter.log("\tTitle Select height",true);
	   WebElement height = driver.findElement(By.id("user_height"));
	   (new Actions(driver)).moveToElement(height).perform();
	   for(int i=0;i<heigtdata.length;i++){
		   
		   Reporter.log("\tInput : "+heigtdata[i],true);
		   Select h = new Select(height);
		   h.selectByVisibleText(heigtdata[i]);
		   Thread.sleep(3000);
		   String expt = h.getFirstSelectedOption().getText();
		   if(heigtdata[i].equals(expt)){
			   
			   Reporter.log("\tStatus ::Passed",true);
		   }else{
			   
			   Reporter.log("\tStatus ::Failed",true);
		   }
		   
	   }
	   
   }
   
   public void InvalidWeight() throws InterruptedException{
	
	   Reporter.log("\tTitle : Test weight field with Invalid data",true);
	   WebElement wight = driver.findElement(By.id("user_weight"));
	   WebElement req = driver.findElement(By.xpath("//input[@id = 'user_weight']/following::small[1]"));
	   WebElement type = driver.findElement(By.xpath("//input[@id = 'user_weight']/following::small[2]"));
	   WebElement len = driver.findElement(By.xpath("//input[@id = 'user_weight']/following::small[3]"));
	   (new Actions(driver)).moveToElement(wight).perform();
	   for(int i=0;i<invalidwightdata.length;i++){
		   
		   Reporter.log("\tInput : "+invalidwightdata[i],true);
		   (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.id("user_weight")));
		   wight.clear();
		   wight.sendKeys(invalidwightdata[i]);
		   Thread.sleep(3000);
		   if(req.isDisplayed() || type.isDisplayed() || len.isDisplayed()){
			   
			   Reporter.log("\tStatus :Passed",true);
		   }else{
			   
			   Reporter.log("\tStatus :Failed",true);
		   }
		   
	   }
   }
   
   public void validWeight() throws InterruptedException{
	 
	 Reporter.log("\tTitle : Test weight field with valid data",true);
	 WebElement wight = driver.findElement(By.id("user_weight"));
	 WebElement req = driver.findElement(By.xpath("//input[@id = 'user_weight']/following::small[1]"));
	 WebElement type = driver.findElement(By.xpath("//input[@id = 'user_weight']/following::small[2]"));
	 WebElement len = driver.findElement(By.xpath("//input[@id = 'user_weight']/following::small[3]"));
	 (new Actions(driver)).moveToElement(wight).perform();
	 for(int i=0;i<validwightdata.length;i++){
		   
		  Reporter.log("\tInput : "+validwightdata[i],true);
		  (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.id("user_weight")));
		  wight.clear();
		  wight.sendKeys(validwightdata[i]);
		  Thread.sleep(3000);
		  if(req.isDisplayed() == false && type.isDisplayed() == false && len.isDisplayed() == false){
			   
			  Reporter.log("\tStatus :Passed",true);
		  }else{
			   
			  Reporter.log("\tStatus :Failed",true);
		   }
		   
	   }
	   
   }
   
   public void invalidSSN() throws InterruptedException{
	   
	   Reporter.log("\tTitle :Test SSN field with invalid data",true);
	   WebElement title = driver.findElement(By.xpath("//label[contains(text(),'Social Security Number (SSN)?')]"));

	   WebElement ssn = driver.findElement(By.id("user_ssn"));
	   WebElement req = driver.findElement(By.xpath("//input[@id = 'user_ssn']/following::small[1]"));
	   WebElement notvalid = driver.findElement(By.xpath("//input[@id = 'user_ssn']/following::small[2]"));
	   (new Actions(driver)).moveToElement(title).perform();
	   for(int i=0;i<invalidssndata.length;i++){
		   
		   Reporter.log("\tInput : "+invalidssndata[i],true);
		   (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.id("user_ssn")));
		   ssn.clear();
		   ssn.sendKeys(invalidssndata[i]);
		   Thread.sleep(3000);
		   if(req.isDisplayed() || notvalid.isDisplayed()){
			   
			   Reporter.log("\tStatus ::Passed",true);
		   }else{
			   
			   Reporter.log("\tStatus ::Failed",true);
		   }
		   
	   }
	   
   }
   
  public void validSSN() throws InterruptedException{
	   
	   Reporter.log("\tTitle :Test SSN field with valid data",true);
	   WebElement title = driver.findElement(By.xpath("//label[contains(text(),'Social Security Number (SSN)?')]"));
	  
	   WebElement ssn = driver.findElement(By.id("user_ssn"));
	   WebElement req = driver.findElement(By.xpath("//input[@id = 'user_ssn']/following::small[1]"));
	   WebElement notvalid = driver.findElement(By.xpath("//input[@id = 'user_ssn']/following::small[2]"));
	   (new Actions(driver)).moveToElement(title).perform();
	   for(int i=0;i<validssndata.length;i++){
		   
		   Reporter.log("\tInput : "+validssndata[i],true);
		   (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.id("user_ssn")));
		   ssn.clear();
		   ssn.sendKeys(validssndata[i]);
		   Thread.sleep(3000);
		   if(req.isDisplayed() == false && notvalid.isDisplayed() == false){
			   
			   Reporter.log("\tStatus ::Passed",true);
		   }else{
			   
			   Reporter.log("\tStatus ::Failed",true);
		   }
		   
	   }
	   
   }
   
   public void selectCountry() throws InterruptedException{
	  
	  Reporter.log("\tTitle :: Select Country",true);
	  WebElement user_born_country = driver.findElement(By.id("user_born_country"));
	  
	  for(int i=0;i<country.length;i++){
		  Reporter.log("\tInput :"+country[i],true);
		  Select c = new Select(user_born_country);
		  c.selectByVisibleText(country[i]);
		  Thread.sleep(3000);
		  String expt = c.getFirstSelectedOption().getText();
		  if(country[i].equals(expt)){
			  Reporter.log("\tStatus ::Passed",true); 
		  }else{
			  Reporter.log("\tStatus ::Failed Act :"+country[i]+" ,Expt :"+expt,true);
		  }
	  }
	   
   }
   public void notInUs() throws InterruptedException{
	   
	 Reporter.log("\tTitle: Not in US Checkbox : Country list Should Display",true);
	 WebElement user_born_country  = driver.findElement(By.id("user_born_country"));
	 WebElement notin_us = driver.findElement(By.id("notin_us"));
	 (new Actions(driver)).moveToElement(notin_us).perform();
	 if(!notin_us.isSelected()){
		 JavascriptExecutor jse = (JavascriptExecutor) driver;
		 jse.executeScript("$('#notin_us').click();");
		 Thread.sleep(3000);
		 if(notin_us.isSelected()){
			 Reporter.log("\tStatus ::Passed Checked Not in US ",true);
			 if (user_born_country.isDisplayed()) {
				 Reporter.log("\tStatus ::Passed Enable Country ",true);
				 selectCountry();
			 }else{
				 Reporter.log("\tStatus ::Failed Enable Country",true);
			 }
		 }else{
			 Reporter.log("\tStatus ::Failed Checked Not in US ",true);
		 }
		 
	 }else{
		 
		 Reporter.log("\tStatus ::Passed Checked Not in US ",true);
		 if (user_born_country.isDisplayed()) {
			 Reporter.log("\tStatus ::Passed Enable Country ",true);
			 selectCountry();
		 }else{
			 Reporter.log("\tStatus ::Failed Enable Country",true);
		 }
	 }
	 
   }
   
   public void state() throws InterruptedException{
	   
	   WebElement st = driver.findElement(By.id("user_born_state"));
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
   
   public void selectState() throws InterruptedException{
	   
	   Reporter.log("\tTitle select state",true);
	   WebElement notin_us = driver.findElement(By.id("notin_us"));
	   (new Actions(driver)).moveToElement(notin_us).perform();
	   if(notin_us.isSelected()){
		  ((JavascriptExecutor)driver).executeScript("$('#notin_us').click();"); 
		  //notin_us.click();
		  Thread.sleep(5000);
		  state(); 
	   }else{
		  state(); 
	   }
	   
   }
   
   public boolean enterAdd(String data,String locater) throws InterruptedException{
	   
	   boolean res;
	   WebElement title = driver.findElement(By.xpath("//label[contains(text() , 'your primary address?')]"));
	   (new Actions(driver)).moveToElement(title).perform();;
	   
	   (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = '"+locater+"']")));
	   WebElement add = driver.findElement(By.xpath("//input[@id = '"+locater+"']"));
	   WebElement err = driver.findElement(By.xpath("//input[@id = '"+locater+"']/following::small[1]"));
	  // ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", add);
	   Reporter.log("\tInput : "+data,true);
	   add.clear();
	   add.sendKeys(data);
	   (new Actions(driver)).sendKeys(Keys.TAB); 
	   Thread.sleep(5000);
	   if(err.isDisplayed()){
		   res = true;
	   }else{
		   res = false;
	   }
	   
	   return res;
   }
   //test
   public void inavalidAddress1() throws InterruptedException{
	   
	   Reporter.log("\tTitle : Enter invalid data for Address1",true);
	   boolean res = enterAdd("    ","user_address_line1");
	   if(res == true){
		   Reporter.log("\tStatus ::Passed",true);
	   }else{
		   Reporter.log("\tStatus ::Failed",true);
	   }
	   
   }
   
   //test
   public void validAddress1() throws InterruptedException{
	   
	   Reporter.log("\tTitle : Enter valid data for Address1",true);
	   boolean res = enterAdd("forest hills","user_address_line1");
	   if(!res){
		   Reporter.log("\tStatus ::Passed",true);
	   }else{
		   Reporter.log("\tStatus ::Failed",true);
	   }
	   
   }
   
  //test
   public void enterAddress2(){
	  
	   Reporter.log("\tTitle : Enter Address2",true);
	   WebElement title = driver.findElement(By.xpath("//label[contains (text() , 'your primary address?')]"));
	   (new Actions(driver)).moveToElement(title).perform();;

	  (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'user_address_line2']")));
	   WebElement add = driver.findElement(By.xpath("//input[@id = 'user_address_line2']"));
	   //((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)",add);
	   Reporter.log("\tInput : 6th lane",true);
	   add.sendKeys("6th lane");
	   Reporter.log("\tStatus ::Passed",true);
	   
   }
   
   public void enterCity(String[] data,String criteria) throws InterruptedException{
	   
	  WebElement title = driver.findElement(By.xpath("//label[contains(text() , 'your primary address?')]"));
	  (new Actions(driver)).moveToElement(title).perform();;
	  
	  (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'user_city']")));
	  WebElement city = driver.findElement(By.xpath("//input[@id = 'user_city']"));
	  WebElement req = driver.findElement(By.xpath("//input[@id = 'user_city']/following::small[1]"));
	  WebElement alpha = driver.findElement(By.xpath("//input[@id = 'user_city']/following::small[2]"));
	  WebElement len = driver.findElement(By.xpath("//input[@id = 'user_city']/following::small[3]"));
	  (new Actions(driver)).moveToElement(city);
	  //((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", city);
	  for(int i=0;i<data.length;i++){
		  
		  Reporter.log("\tStatus : Input :"+data[i],true);
		  city.clear();
		  city.sendKeys(data[i]);
		  Thread.sleep(5000);
		  if(criteria.equals("invalid")){
			 if(req.isDisplayed() || alpha.isDisplayed() || len.isDisplayed()){
				 Reporter.log("\tStatus ::Passed",true);
			 }else{
				 Reporter.log("\tStatus ::Failed",true);
			 }
		  }else if(criteria.equalsIgnoreCase("valid")){
			  
			  if(!req.isDisplayed() && !alpha.isDisplayed() && !len.isDisplayed()){
				  Reporter.log("\tStatus ::Passed",true);
			  }else{
				  Reporter.log("\tStatus ::Failed",true);
			  }
		  }else{
			  
			  Reporter.log("\tStatus Info : criteria not matched",true);
		  }
		  
	  }
	  	  
   }
   
   // test
   public void inavalidCity() throws InterruptedException{
	   
	   Reporter.log("\tTitle : Invalied City",true);
	   enterCity(inavalidcitydata, "invalid");
   }
   
   // test
   public void validCity() throws InterruptedException{
	   
	   Reporter.log("\tTitle : Valid City",true);
	   enterCity(validcitydata, "valid");
   }
   
   //test
   public void selectUserState() throws InterruptedException{
	   
	  Reporter.log("\tTitle : Select user state",true);
	  WebElement title = driver.findElement(By.xpath("//label[contains(text() , 'your primary address?')]"));
	  (new Actions(driver)).moveToElement(title).perform();;
	  
	  (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id = 'user_state']")));
      WebElement state = driver.findElement(By.id("user_state"));
      //(new Actions(driver)).moveToElement(state);
      //((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", state);
      String act = "California";
      Select s = new Select(state);
      s.selectByVisibleText(act);
      Thread.sleep(5000);
      String expt = s.getFirstSelectedOption().getText();
      if(act.equals(expt)){
    	  Reporter.log("\tStatus ::Passed",true);
      }else{
    	  Reporter.log("\tStatus ::Failed , Act :"+act+" ,Expt :"+expt,true);
      }
     
   }
   
   public void enterZipCode(String[] data,String criteria) throws InterruptedException{
	 
	 WebElement title = driver.findElement(By.xpath("//label[contains(text() , 'your primary address?')]"));
	 (new Actions(driver)).moveToElement(title).perform();; 
	 
	 (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.id("user_zipcode")));
     WebElement zip = driver.findElement(By.id("user_zipcode"));
     WebElement req =driver.findElement(By.xpath("//input[@id = 'user_zipcode']/following::small[1]"));
     WebElement notvalid =driver.findElement(By.xpath("//input[@id = 'user_zipcode']/following::small[2]"));
     WebElement len =driver.findElement(By.xpath("//input[@id = 'user_zipcode']/following::small[3]"));
     //((JavascriptExecutor)driver).executeScript("argumets[0].scrollIntoView(true)", zip);
     for(int i=0;i<data.length;i++){
    	 Reporter.log("\tInput : "+data[i],true);
    	 zip.clear();
    	 zip.sendKeys(data[i]);
    	 (new Actions(driver)).sendKeys(Keys.TAB); 
    	 Thread.sleep(5000);
         if(criteria.equalsIgnoreCase("invalid")){
        	 if(zip.isDisplayed() || notvalid.isDisplayed() || len.isDisplayed()){
        		 Reporter.log("\tStatus ::Passed");
        	 }else{
        		 Reporter.log("\tStatus ::Failed");
        	 }
         }else if(criteria.equalsIgnoreCase("valid")){
        	 if(!zip.isDisplayed() && !notvalid.isDisplayed() && !len.isDisplayed()){
        		 Reporter.log("\tStatus ::Passed");
        	 }else{
        		 Reporter.log("\tStatus ::Failed");
        	 }
         }else{
        	 Reporter.log("\tStatus Info : Criteria not valid");
         }
     
     }
   
   }
   
   //test
   public void invalidZipCode() throws InterruptedException{

	   Reporter.log("\tTitle : Enter invalid Zipcode",true);
	   enterZipCode(invalidzipcode, "invalid");
   }
   
   //test
   public void validZipCode() throws InterruptedException{
	   
	   Reporter.log("\tTitle : Enter valid Zipcode",true);
	   enterZipCode(validzipcode, "valid");
   }
   

   public  void enterCellNumber(String[] data,String criteria) throws InterruptedException{
	   
	   WebElement title = driver.findElement(By.xpath("//label[text() =  'Please provide your phone number(s).']"));
	   (new Actions(driver)).moveToElement(title).perform();
	   
	   (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.id("user_cell_no")));
	   WebElement cell = driver.findElement(By.id("user_cell_no"));
	   WebElement req = driver.findElement(By.xpath("//input[@id = 'user_cell_no']/following::small[1]"));
	   WebElement notvalid = driver.findElement(By.xpath("//input[@id = 'user_cell_no']/following::small[2]"));
	   
	   for(int i=0;i<data.length;i++){
		   Reporter.log("\tInput :"+data[i],true);
		   cell.clear();
		   cell.sendKeys(data[i]);
		   (new Actions(driver)).sendKeys(Keys.TAB); 
		   Thread.sleep(5000);
		   if(criteria.equalsIgnoreCase("invalid")){
		      if(req.isDisplayed() || notvalid.isDisplayed()){
			     Reporter.log("\tStatus ::Passed",true); 
		      }else{
			     Reporter.log("\tStatus ::Failed",true);
		      }
		   }else if(criteria.equalsIgnoreCase("valid")){
			   if(!req.isDisplayed() && !notvalid.isDisplayed()){
				   Reporter.log("\tStatus ::Passed",true); 
			   }else{
				   Reporter.log("\tStatus ::Failed",true);
			   }
		   }
	   }
   }
   
   public void enterWorkAndHomeNumber(String[] data,String criteria,String locater) throws InterruptedException{
	   
	   WebElement title = driver.findElement(By.xpath("//label[text() = 'Please provide your phone number(s).']"));
	   ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView", title);
	   (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.id(locater)));
	   WebElement cell = driver.findElement(By.id(locater));
	   WebElement req = driver.findElement(By.xpath("//input[@id = '"+locater+"']/following::small[1]"));
	
	   for(int i=0;i<data.length;i++){
		   Reporter.log("\tInput :"+data[i],true);
		   cell.clear();
		   cell.sendKeys(data[i]);
		   (new Actions(driver)).sendKeys(Keys.TAB);  Thread.sleep(5000);
		   if(criteria.equalsIgnoreCase("invalid")){
			   if(req.isDisplayed()){
				   Reporter.log("\tStatus ::Passed",true); 
			   }else{
				   Reporter.log("\tStatus ::Failed",true);
			   }
		   }else if(criteria.equalsIgnoreCase("valid")){
			   if(!req.isDisplayed()){
				   Reporter.log("\tStatus ::Passed",true); 
			   }else{
				   Reporter.log("\tStatus ::Failed",true);
			   }
		   }
	   }   
   }
   
 //test
   public void invalidCellNumber() throws InterruptedException{
	   
	   Reporter.log("\tStatus : Enter invalid Cell Number",true);
	   enterCellNumber(invalidMObileData, "invalid");
   }
   
   //test
   public void validCellNumber() throws InterruptedException{
	   
	   Reporter.log("\tStatus : Enter invalid Cell Number",true);
	   enterCellNumber(validmobileData, "valid");
   }
   
   //test
   public void invalidWorkNumber() throws InterruptedException{
	   
	   Reporter.log("\tTitle : Enter invalid work number",true);
	   enterWorkAndHomeNumber(invalidMObileData, "invalid", "user_work_no");
   }
   
  //test
   public void validWorkNumber() throws InterruptedException{
	   
	   Reporter.log("\tTitle : Enter valid work number",true);
	   enterWorkAndHomeNumber(validmobileData, "valid", "user_work_no");
   }
   
   //test
   public void invalidHomeNumber() throws InterruptedException{
	   
	   Reporter.log("\tTitle : Enter invalid home number",true);
	   enterWorkAndHomeNumber(invalidMObileData, "invalid", "user_home_no");
   }
   
   //test
   public void validHomeNumber() throws InterruptedException{
	   
	   Reporter.log("\tTitle : Enter valid home number",true);
	   enterWorkAndHomeNumber(validmobileData, "valid", "user_home_no");
   }
   
   public void enterLicenseNumber(String[] data,String criteria) throws InterruptedException{
	   
	   WebElement title = driver.findElement(By.xpath("//label[contains(text() , 'your drivers license number?')]"));
	   (new Actions(driver)).moveToElement(title).perform();
	   
	   (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.id("user_dln")));
	   WebElement dln = driver.findElement(By.id("user_dln"));
	   WebElement err = driver.findElement(By.xpath("//input[@id = 'user_dln']/following::small[1]"));
	   for(int i=0;i<data.length;i++){
		   
		   Reporter.log("\tInput : "+data[i],true);
		   dln.clear();
		   dln.sendKeys(data[i]);
		   (new Actions(driver)).sendKeys(Keys.TAB); 
		   Thread.sleep(5000);
		   if(criteria.equalsIgnoreCase("invalid")){
			   if(err.isDisplayed()){
				   Reporter.log("\tStatus ::Passed",true);
			   }else{
				   Reporter.log("\tStatus ::Failed",true);
			   }
		   }else if(criteria.equalsIgnoreCase("valid")){
			   if(!err.isDisplayed()){
				   Reporter.log("\tStatus ::Passed",true); 
			   }else{
				   Reporter.log("\tStatus ::Failed",true);
			   }
		   }else{
			   Reporter.log("\tStatus Info : criteria not valid");
		   }
		   
	   }
   }
   
   //test
   public void invalidLicenseNumber() throws InterruptedException{
	   
	   Reporter.log("\tTitle Enter invalid License number",true);
	   enterLicenseNumber(invalidlicensedata, "invalid");
   }
   
   //test
   public void validLicenseNumber() throws InterruptedException{
	   
	   Reporter.log("\tTitle Enter valid License number",true);
	   enterLicenseNumber(validlicensedata, "valid");
   }
   
   //test
   public void driverState() throws InterruptedException{
	   
	  Reporter.log("\tTitle Select Driver State",true);
	  WebElement title = driver.findElement(By.xpath("//label[contains(text() , 'drivers license number?')]"));
	  (new Actions(driver)).moveToElement(title).perform();
	  
	  WebElement state = driver.findElement(By.id("state_issued"));
	  String act = "California";
	  Reporter.log("\tInput : "+act,true);
	  Select s = new Select(state);
	  s.selectByVisibleText(act);
	  Thread.sleep(5000);
	  String expt = s.getFirstSelectedOption().getText();
	  if(act.equals(expt)){
		  Reporter.log("\tStatus ::Passed",true);
	  }else{
		  Reporter.log("\tStatus ::Failed , Act :"+act+" , Expt :"+expt,true);
	  }
	   
   }
   
   public void enterOccupation(String[] data,String criteria) throws InterruptedException{
	   
	   WebElement title = driver.findElement(By.xpath("//label[text() = 'Occupation']"));
	   (new Actions(driver)).moveToElement(title).perform();
	   
	   (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.id("user_occupation")));
	   WebElement occ = driver.findElement(By.id("user_occupation"));
	   WebElement req = driver.findElement(By.xpath("//input[@id = 'user_occupation']/following::small[1]"));
	   WebElement notvalid = driver.findElement(By.xpath("//input[@id = 'user_occupation']/following::small[2]"));
	   WebElement len = driver.findElement(By.xpath("//input[@id = 'user_occupation']/following::small[3]"));

	   for(int i=0;i<data.length;i++){
		   
		   Reporter.log("\tInput :"+data[i],true);
		   occ.clear();
		   occ.sendKeys(data[i]);
		   (new Actions(driver)).sendKeys(Keys.TAB); 
		   Thread.sleep(5000);
		   if(criteria.equalsIgnoreCase("invalid")){
			   
			   if(req.isDisplayed() || notvalid.isDisplayed() || len.isDisplayed()){
				   
				   Reporter.log("\tStatus ::Passed",true);
			   }else{
				   
				   Reporter.log("\tStatus ::Failed",true);
			   }
			   
		   }else if(criteria.equalsIgnoreCase("valid")){
			   
			   if(!req.isDisplayed() && !notvalid.isDisplayed() && !len.isDisplayed()){

				   Reporter.log("\tStatus ::Passed",true);
			   }else{

				   Reporter.log("\tStatus ::Failed",true);
			   }
			   
		   }else{
			   Reporter.log("\tStatus Info : Criteria not valid",true);
		   }
		   
	   }
   }
   
   //test
   public void invalidOccupation() throws InterruptedException{
	   
	   Reporter.log("\tTitle : Enter invalid Occupation data",true);
	   enterOccupation(inavalid_occuoation_data,"invalid");
   }
   
 //test
   public void validOccupation() throws InterruptedException{
	   
	   Reporter.log("\tTitle : Enter valid Occupation data",true);
	   enterOccupation(valid_occuoation_data,"valid");
   }
   
  public void enterWorkZip(String[] data,String criteria) throws InterruptedException{
	   
	   WebElement title = driver.findElement(By.xpath("//label[text() = 'Occupation']"));
	   (new Actions(driver)).moveToElement(title).perform();
	   
	   (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.id("user_another_zipcode")));
	   WebElement occ = driver.findElement(By.id("user_another_zipcode"));
	   WebElement req = driver.findElement(By.xpath("//input[@id = 'user_another_zipcode']/following::small[1]"));
	   WebElement notvalid = driver.findElement(By.xpath("//input[@id = 'user_another_zipcode']/following::small[2]"));
	   WebElement len = driver.findElement(By.xpath("//input[@id = 'user_another_zipcode']/following::small[3]"));

	   for(int i=0;i<data.length;i++){
		   
		   Reporter.log("\tInput :"+data[i],true);
		   occ.clear();
		   occ.sendKeys(data[i]);
		   (new Actions(driver)).sendKeys(Keys.TAB); 
		   Thread.sleep(5000);
		   if(criteria.equalsIgnoreCase("invalid")){
			   
			   if(req.isDisplayed() || notvalid.isDisplayed() || len.isDisplayed()){
				   
				   Reporter.log("\tStatus ::Passed",true);
			   }else{
				   
				   Reporter.log("\tStatus ::Failed",true);
			   }
			   
		   }else if(criteria.equalsIgnoreCase("valid")){
			   
			   if(!req.isDisplayed() && !notvalid.isDisplayed() && !len.isDisplayed()){

				   Reporter.log("\tStatus ::Passed",true);
			   }else{

				   Reporter.log("\tStatus ::Failed",true);
			   }
			   
		   }else{
			   Reporter.log("\tStatus Info : Criteria not valid",true);
		   }
		   
	   }
   }

   //test
   public void invalidWorkZip() throws InterruptedException{

	  Reporter.log("\tTitle : Enter invalid Work Zipcode data",true);
	  enterWorkZip(inavalid_wzip_data, "invalid");
   }

   //test
   public void validWorkZip() throws InterruptedException{

	  Reporter.log("\tTitle : Enter valid Work Zipcode data",true);
	  enterWorkZip(valid_wzip_data,"valid");
   }
   
   //test
   public void click_Next_InPersonalInfo(){
	   
	   Reporter.log("\tTitle : Click Next Button In PersonalInfo page");
	   try{
	       WebElement next = driver.findElement(By.id("next_button"));
	       (new Actions(driver)).moveToElement(next).perform();
	       if(next.isDisplayed()){
	    	   ((JavascriptExecutor)driver).executeScript("$('#next_button').click();");
	    	   (new WebDriverWait(driver, 30)).until(ExpectedConditions.attributeToBe(By.xpath("//li[@id = '3']"), "class","active"));
	    		   Reporter.log("\tStatus ::Passed clicked Next button",true);   	   
	       }else{
	    	   Reporter.log("\tStatus ::Failed to Displayed Next button",true);
	       }
	   }catch (Exception e){
		   Reporter.log("\tStatus ::Failed To move Beneficiary Info page");
		   e.printStackTrace();
	   }
   }
}
   
	