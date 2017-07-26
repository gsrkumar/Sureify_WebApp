package com.sureifylife;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class AppProcessOtherInsurances {
   
   WebDriver driver = null;
   
   String[] invalid_name_data = {
		   "   ", " name", "_name", "name12", "name?;'", "12345", "@#$%&* " , "name_",
		   "qwertyuioplkjhgfdsazxcvbnmmnbvcxzlkjhgfdsapoiuytres"
   };
   
   String[] valid_name_data = {
			"a","Test data","Test'data","Test-data","Test.data","Testdata"
   };
   
   String[] invalid_cmpyname_data = {
		   "      " , "_MetLife" , " MetLife" , "123MetLife" , "@#$%^&",
			"qwertyuioplkjhgfdsazxcvbnmmnbvcxzlkjhgfdsapoiuytresqwertyuioplkjhgfdsazxcvbnmmnbvcxzlkjhgfdsapoiuytrs"

   };
   
   String[] valid_cmpyname_data = {
	        "Met-Life (MET)" , "MetLife (MET)" , "MetLife.CO (MET)" , "MetLife&Co (MET)" , "MetLife" ,"Met Life"
		   
   };
   
   String[] invalid_amount_data = {
		   "    ","ten10000" , "!@#@$#$%$#" , "0" , "49999"
   };
   
   String[] valid_amount_data = {
		    "50000" , "50001"
   };
   
   String[] invalid_number_data = {
		 "      " , "@##$@#$" , "Agh10@#$ " , " 10Ap189798" , "123456789012345678901" , "number" 
   };
   
   String[] valid_number_data = {
		   "10US1f00156" , "561245782"
   };
   
   String[] invalid_purpose_data = {
	       "   " , "@##$%" , "123345" , "Alpha1232" , 	
	       "qwertyuioplkjhgfdsazxcvbnmmnbvcxzlkjhgfdsapoiuytres"
   };
   
   String[] valid_purpose_data = {
	      "Retirement time" , "education"	   
   };
   
   String[] year = {
		   "2000"
   };
   
  
   public AppProcessOtherInsurances(WebDriver driver){
      this.driver = driver;
   }
   
   public void isVisible(WebElement ele ,String name){
	   
	   if(ele.isDisplayed()){
		   Reporter.log("\tStatus ::Passed "+name+" selected",true);
	   }else{

		   Reporter.log("\tStatus ::Failed "+name+" select",true);
	   }
   }

   public void  clickOption(String name,String id,WebElement check) throws InterruptedException{

	   Reporter.log("\tInput : Select "+name+"",true);
	   JavascriptExecutor js = (JavascriptExecutor)driver;
	   boolean visible = (Boolean)js.executeScript("return $('#"+id+"').is(':visible')");
	   if(visible){
		   js.executeScript("document.getElementById('"+id+"').scrollIntoView(false);");
		   js.executeScript("$('#"+id+"').click();");
		   Thread.sleep(5000);
		   isVisible(check, name);
	   }else{
		   Reporter.log("\tStatus ::Failed "+name+" button not displayed",true);
	   }	
   }
   
   public void  selectOption(String name,WebElement ele,WebElement check) throws InterruptedException{

	   Reporter.log("\tInput : Select "+name+"",true);
	   JavascriptExecutor js = (JavascriptExecutor)driver;
	  // WebElement ele = driver.findElement(By.xpath("//input[@id = 'policy_pending' AND  @value = '"+val+"']"));
	   boolean visible = ele.isDisplayed();
	   if(visible){
		   js.executeScript("arguments[0].scrollIntoView(false);",ele);
		   js.executeScript("arguments[0].click();",ele);
		   Thread.sleep(5000);
		   isVisible(check, name);
	   }else{
		   Reporter.log("\tStatus ::Failed "+name+" button not displayed",true);
	   }	
   }

   //
   //Do you have any other life insurance or annuities in force or pending? 
   // Yes
   //
   public void select_Yes_Annuities() throws InterruptedException{
	   Reporter.log("Test Step",true);
	   Reporter.log("\tTitle : Do you have any other life insurance or annuities in force or pending?  ",true);

	   WebElement check = driver.findElement(By.xpath("//label[contains(text() , 'name of the insured?')]"));
	   clickOption("Yes", "insurance_applied1", check);
   }
   
   //
   //Do you have any other life insurance or annuities in force or pending? 
   // No
   //
   public void select_No_Annuities() throws InterruptedException{
	   Reporter.log("Test Step",true);
	   Reporter.log("\tTitle : Do you have any other life insurance or annuities in force or pending?  ",true);

	   WebElement check = driver.findElement(By.id("next_button"));
	   clickOption("No", "insurance_applied2", check);
   }
   
   //
   // Is this policy still pending? 
   // Yes
   //
   public void select_Yes_PolicyPending() throws InterruptedException{
	   Reporter.log("Test Step",true);
	   Reporter.log("\tTitle : Is this policy still pending?   ",true);

	   WebElement check = driver.findElement(By.xpath("//label[contains(text() , 'primary purpose of the policy?')]"));
	   WebElement ele = driver.findElement(By.xpath("//label[text() = 'Is this policy still pending?']//following::label[1]"));
	   selectOption("Yes", ele, check);
   }
   
   //
   // Is this policy still pending? 
   // No
   //
   public void select_No_PolicyPending() throws InterruptedException{
	   Reporter.log("Test Step",true);
	   Reporter.log("\tTitle : Is this policy still pending?   ",true);

	   WebElement check = driver.findElement(By.xpath("//label[contains(text() , 'the policy number?')]"));
	   WebElement ele = driver.findElement(By.xpath("//label[text() = 'Is this policy still pending?']//following::label[2]"));
	   selectOption("No", ele, check);
   }
   
   //
   // Is this policy still pending? 
   // Unsure
   //
   public void select_Unsure_PolicyPending() throws InterruptedException{
	   Reporter.log("Test Step",true);
	   Reporter.log("\tTitle : Is this policy still pending?   ",true);

	   WebElement check = driver.findElement(By.xpath("//label[contains(text() , 'primary purpose of the policy?')]"));
	   WebElement ele = driver.findElement(By.xpath("//label[text() = 'Is this policy still pending?']//following::label[3]"));
	   selectOption("Unsure", ele, check);
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
   
   public void enterAmount(String webelement,String[] data,String criteria) throws InterruptedException{

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
   
   public void year(String id) throws InterruptedException{

	   WebElement st = driver.findElement(By.id(id));
	   for(int i=0;i<year.length;i++){
		   Reporter.log("\tInput :"+year[i],true);
		   Select c = new Select(st);
		   c.selectByVisibleText(year[i]);
		   Thread.sleep(3000);
		   String expt = c.getFirstSelectedOption().getText();
		   if(year[i].equals(expt)){
			   Reporter.log("\tStatus ::Passed",true); 
		   }else{
			   Reporter.log("\tStatus ::Failed Act :"+year[i]+" ,Expt :"+expt,true);
		   }
	   }  
   }
  
   public void invalid_insured_Name() throws InterruptedException{
       
	   Reporter.log("Test Step",true);
	   Reporter.log("\tTitle : Test name of the insured field with invalid data",true);
	   enterText("insured_name", invalid_name_data, "invalid");
	   
   }
   
   public void valid_insured_Name() throws InterruptedException{

	   Reporter.log("Test Step",true);
	   Reporter.log("\tTitle : Test name of the insured field with valid data",true);
	   enterText("insured_name", valid_name_data, "valid");
	   
   }
   
   public void invalid_insured_Company() throws InterruptedException{

	   Reporter.log("Test Step",true);
	   Reporter.log("\tTitle : Test name of the company field with invalid data",true);
	   enterText("insured_company", invalid_cmpyname_data, "invalid");

   }
   
   public void valid_insured_Company() throws InterruptedException{

	   Reporter.log("Test Step",true);
	   Reporter.log("\tTitle : Test name of the company field with valid data",true);
	   enterText("insured_company", valid_cmpyname_data, "valid");

   }
   
   public void invalid_Amount() throws InterruptedException{

	   Reporter.log("Test Step",true);
	   Reporter.log("\tTitle : Test Amount field with invalid data",true);
	   enterText("insured_amount", invalid_amount_data , "invalid");

   }
   
   public void valid_Amount() throws InterruptedException{

	   Reporter.log("Test Step",true);
	   Reporter.log("\tTitle : Test Amount field with valid data",true);
	   enterText("insured_amount", valid_amount_data , "valid");

   }
   
   public void invalid_PolicyNumber() throws InterruptedException{

	   Reporter.log("Test Step",true);
	   Reporter.log("\tTitle : Test PolicyNumber field with invalid data",true);
	   enterText("insured_policy_number", invalid_number_data , "invalid");

   }
   
   public void valid_PolicyNumber() throws InterruptedException{

	   Reporter.log("Test Step",true);
	   Reporter.log("\tTitle : Test PolicyNumber field with valid data",true);
	   enterText("insured_policy_number", valid_number_data , "valid");

   }
   
   public void selectYear() throws InterruptedException{
	   
	   Reporter.log("Test Step",true);
	   Reporter.log("\tTitle : select year ",true);
	   year("insured_year");
	   
   }
   
   public void invalid_Purpose() throws InterruptedException{

	   Reporter.log("Test Step",true);
	   Reporter.log("\tTitle : Test primary purpose of the policy field with invalid data",true);
	   enterText("retirement", invalid_purpose_data , "invalid");

   }
   
   public void valid_Purpose() throws InterruptedException{

	   Reporter.log("Test Step",true);
	   Reporter.log("\tTitle : Test primary purpose of the policy field with valid data",true);
	   enterText("retirement", valid_purpose_data , "valid");

   }
   
   //test
   public void addAnotherPolicy() throws InterruptedException{
	   
	   Reporter.log("\tTitle : Add another policy",true);
	   JavascriptExecutor js = (JavascriptExecutor)driver;
	   WebElement add = driver.findElement(By.id("add_another_policy"));
	   js.executeScript("arguments[0].scrollIntoView", add);
	   add.click();
	   Thread.sleep(5000);
	   if(driver.findElement(By.id("insured_name2")).isDisplayed()){
		   Reporter.log("\tStatus :: Passed",true);
	   }else{
		   Reporter.log("\tStatus :: Failed",true);
	   }
	   
   }
   
   //test
   public void removePolicy() throws InterruptedException{

	   Reporter.log("\tTitle : Remove policy",true);
	   WebElement ele = driver.findElement(By.xpath(".//*[@id='info_div5']/div/ol[2]/a/span"));
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
   public void otherInsurance_Yes_Yes() throws InterruptedException{
	   
	   select_Yes_Annuities();
	   
	  invalid_insured_Name();
	   valid_insured_Name();
	   
	   invalid_insured_Company();
	   valid_insured_Company();
	   
	   invalid_Amount();
	   valid_Amount();
	   
	   select_Yes_PolicyPending();
	   
	   invalid_Purpose();
	   valid_Purpose();
	   
   }
   
   //test
   public void otherInsurance_Yes_No() throws InterruptedException{

	   select_No_PolicyPending();

	   invalid_PolicyNumber();
	   valid_PolicyNumber();
	   
	   selectYear();
	  
	   invalid_Purpose();
	   valid_Purpose();

   }
   
   //test
   public void otherInsurance_Yes_Unsure() throws InterruptedException{

	   select_Unsure_PolicyPending();
	  
	   invalid_Purpose();
	   valid_Purpose();

   }
   
   //test
   public void otherInsurance_No() throws InterruptedException{
       
	   select_No_Annuities();
	   next();

   }
   
   
   public void next(){

	   Reporter.log("\tTitle : Click next button",true);
	   WebElement next = driver.findElement(By.id("next_button"));
	   ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false)", next);
	   next.click();
	   (new WebDriverWait(driver, 30)).until(ExpectedConditions.attributeToBe(By.xpath("//li[@id = '6']"), "class","active"));
	   Reporter.log("\tStatus ::Passed clicked Next button",true);   	   
   }

}
