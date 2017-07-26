package com.sureifylife;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class AppProcessBeneficiaryInfo {

	WebDriver driver ;
	
	String[] invalid_name_data = {
			 "   ", " name", "_name", "name12", "name?;'", "12345", "@#$%&* " , "name_",
             
	};
	
	String[] invalidperc = {
			"0" , "1" , "2" ,"99" ,"101"
	};
	
	String[] validperc = {
			"100"
	};
	
	String[] pb_name = {
		    "qwertyuioplkjhgfdsazxcvbnmmnbvcxzlkjhgfdsapoiuytre" , "manu sri" , "srinivas"	
	};
	
	String[] prel_name = {
		    "father"	
	};
	
	String[] cb_name = {
		  "qwertyuioplkjhgfdsazxcvbnmmnbvcxzlkjhgfdsapoiuytre","charan","varun raj"
	};
	
	String[] crel_name = {
			"elder brother","friend"
	};
	
	String[] percdata = {
		"0" , "1" , "48" , "49"	
	};
	
	String perc = "50"; 
			
	public AppProcessBeneficiaryInfo(WebDriver driver){
		
		this.driver = driver;
	}
	
	public void enterName(String webelement,String criteria,String[] data) throws InterruptedException{
		
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.id(webelement)));
		WebElement name = driver.findElement(By.id(webelement));
		WebElement req = driver.findElement(By.xpath("//input[@id = '"+webelement+"']/following::small[1]"));
		WebElement alpha = driver.findElement(By.xpath("//input[@id = '"+webelement+"']/following::small[2]"));
		WebElement len = driver.findElement(By.xpath("//input[@id = '"+webelement+"']/following::small[3]"));
		(new Actions(driver)).moveToElement(name).perform();
		
		for(int i=0;i<data.length;i++){
			
			Reporter.log("\tInput :: "+data[i],true);
			name.clear();
			name.sendKeys(data[i]);
			Thread.sleep(3000);
			if(criteria.equalsIgnoreCase("invalid")){
				
			    if( req.isDisplayed() || alpha.isDisplayed() || len.isDisplayed()){
				  Reporter.log("\tStatus ::Passed ",true);
			    }else{
				  Reporter.log("\tStatus ::Failed ",true);
			    }
			}else if(criteria.equalsIgnoreCase("valid")){
				if( !req.isDisplayed() && !alpha.isDisplayed() && !len.isDisplayed()){
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
	public void invalidPrimaryBenName() throws InterruptedException{
		
		Reporter.log("\tTitle : Check Primary Benificiary Name with Invalid data",true);
		enterName("ben_name", "invalid", invalid_name_data);
		
	}
	
	//test
	public void validPrimaryBenName() throws InterruptedException{
	
		Reporter.log("\tTitle : Check Primary Benificiary Name with Valid data",true);
		enterName("ben_name", "valid", pb_name);	
	}
	
	//test
	public void InvalidPrimaryRelationName() throws InterruptedException{
		
		Reporter.log("\tTitle : Check Primary Benificiary Relation Name with Invalid data",true);
		enterName("rel_name", "invalid", invalid_name_data);	
	}
	
	//test
	public void validPrimaryRelationName() throws InterruptedException{

		Reporter.log("\tTitle : Check Primary Benificiary Relation Name with Valid data",true);
		enterName("rel_name", "valid", prel_name);	
	}
	
	//test
	public void InvalidPrimaryBenfPer() throws InterruptedException{

		Reporter.log("\tTitle : Check Primary Benificiary Percentage with Invalid data",true);
		enterName("rel_ins_percentage", "invalid", invalidperc);	
	}
	
	//test
	public void validPrimaryBenfPer() throws InterruptedException{

		Reporter.log("\tTitle : Check Primary Benificiary Percentage with Valid data",true);
		enterName("rel_ins_percentage", "valid", validperc);	
	}
	
	
	//test
	public void invalidContingentBenfName() throws InterruptedException{

		Reporter.log("\tTitle : Check Contingent Benificiary Name with Invalid data",true);
		enterName("con_ben_name", "invalid", invalid_name_data);

	}

	//test
	public void validContingentBenfName() throws InterruptedException{

		Reporter.log("\tTitle : Check Contingent Benificiary Name with Valid data",true);
		enterName("con_ben_name", "valid", cb_name);	
	}

	//test
	public void invalidContingentRelationName() throws InterruptedException{

		Reporter.log("\tTitle : Check Contingent  Benificiary Relation Name with Invalid data",true);
		enterName("con_rel_name", "invalid", invalid_name_data);	
	}

	//test
	public void validContingentRelationName() throws InterruptedException{

		Reporter.log("\tTitle : Check Contingent Benificiary Relation Name with Valid data",true);
		enterName("con_rel_name", "valid", crel_name);	
	}

	//test
	public void invalidContingentBenfPer() throws InterruptedException{

		Reporter.log("\tTitle : Check Contingent Benificiary Percentage with Invalid data",true);
		enterName("con_ins_percentage", "invalid", invalidperc);	
	}

	//test
	public void validContingentBenfPer() throws InterruptedException{

		Reporter.log("\tTitle : Check Contingent Benificiary Percentage with Valid data",true);
		enterName("con_ins_percentage", "valid", validperc);	
	}
	
	public void checkBenificiary(String locater,String operation){
		
		try{
			boolean check = (Boolean)((JavascriptExecutor)driver).executeScript("return $('#"+locater+"').is(':visible')");
			if(operation.equals("add")){
				if(check){
					Reporter.log("\tStatus ::Passed",true);
				}else{
					Reporter.log("\tStatus ::Failed",true);
				}
			}else if(operation.equals("remove")){
				if(!check){
					Reporter.log("\tStatus ::Passed",true);
				}else{
					Reporter.log("\tStatus ::Failed",true);
				}
			}else{
				Reporter.log("\tStatus :: Invalid operation :",true);
			}
		}catch(Exception e){
               Reporter.log("\tStatus :: Failed ,Exception Rised"+operation,true);
		}
	
	}
	
	//test
	public void addPrimaryBenficiary() throws InterruptedException{
		
		Reporter.log("\tTitle : Add PrimaryBenficiary ",true);
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.id("ben-btn")));
		WebElement add = driver.findElement(By.id("ben-btn"));
		(new Actions(driver)).moveToElement(add).perform();
		add.click();
		Thread.sleep(5000);
		
		Reporter.log("\tTitle : Check Benficiary Name field visible",true);
		checkBenificiary("ben_name2","add");
		
		Reporter.log("\tTitle : Check Relation Name field visible",true);
		checkBenificiary("rel_name2","add");
		
		Reporter.log("\tTitle : Check % field visible",true);
		checkBenificiary("rel_ins_percentage2","add");
		
	}
	
	//test
	public void addContingentBenficiary() throws InterruptedException{

		Reporter.log("\tTitle : Add ContingentBenficiary ",true);
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.id("con-beneficiary")));
		WebElement add = driver.findElement(By.id("con-beneficiary"));
		(new Actions(driver)).moveToElement(add).perform();
		add.click();
		Thread.sleep(5000);

		Reporter.log("\tTitle : Check Benficiary Name field visible",true);
		checkBenificiary("con_ben_name2","add");

		Reporter.log("\tTitle : Check Relation Name field visible",true);
		checkBenificiary("con_rel_name2","add");

		Reporter.log("\tTitle : Check % field visible",true);
		checkBenificiary("con_ins_percentage2","add");

	}

	//test
	public void removePrimaryBenficiary() throws InterruptedException{

		Reporter.log("\tTitle : Remove PrimaryBenficiary ",true);
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id = 'rel_ins_percentage2']/following::a[1]")));
		WebElement remove = driver.findElement(By.xpath("//input[@id = 'rel_ins_percentage2']/following::a[1]/span"));
		(new Actions(driver)).moveToElement(remove).perform();
		remove.click();
		Thread.sleep(5000);

		Reporter.log("\tTitle : Check Benficiary Name field Remove",true);
		checkBenificiary("ben_name2","remove");

		Reporter.log("\tTitle : Check Relation Name field Remove",true);
		checkBenificiary("rel_name2","remove");

		Reporter.log("\tTitle : Check % field Remove",true);
		checkBenificiary("rel_ins_percentage2","remove");

	}
    
	//test
	public void removeContingentBenficiary() throws InterruptedException{

		Reporter.log("\tTitle : Remove ContingentBenficiary ",true);
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id = 'con_ins_percentage2']/following::a[1]")));
		WebElement remove = driver.findElement(By.xpath("//input[@id = 'con_ins_percentage2']/following::a[1]"));
		(new Actions(driver)).moveToElement(remove).perform();
		remove.click();
		Thread.sleep(5000);

		Reporter.log("\tTitle : Check Benficiary Name field Remove",true);
		checkBenificiary("con_ben_name2","remove");

		Reporter.log("\tTitle : Check Relation Name field Remove",true);
		checkBenificiary("con_rel_name2","remove");

		Reporter.log("\tTitle : Check % field Remove",true);
		checkBenificiary("con_ins_percentage2","remove");

	}
	
	public void checkPercentageEquality(String b1,String[] b2,String b1locater,String b2locater) throws InterruptedException{
		Actions a = new Actions(driver);
	    WebElement b1p = driver.findElement(By.id(b1locater));
	    WebElement b2p = driver.findElement(By.id(b2locater));
		WebElement type = driver.findElement(By.xpath("//input[@id = '"+b2locater+"']/following::small[3]"));
		
		Reporter.log("\tInput : Benificiary One :"+b1+ " %",true);
		
		a.moveToElement(b1p).perform();
	    b1p.clear();
	    b1p.sendKeys(b1);
	    Thread.sleep(3000);
	    
	    a.moveToElement(b2p).perform();
	    b2p.clear();
	    b2p.sendKeys(b2);
	    Thread.sleep(3000);
	    
	    Reporter.log("\tBeneficiary Two % ",true);
	    for(int i=0;i<b2.length;i++){
	    	Reporter.log("\tInput : "+b2[i],true);
	    	b2p.clear();
	    	b2p.sendKeys(b2[i]);
	    	Thread.sleep(3000);
	    	if( type.isDisplayed()){
	    	   Reporter.log("\tStatus ::Passed ,Error message displayed",true);
	    	}else{
	    		Reporter.log("\tStatus ::Failed ,Error message not displayed",true);
	    	}
	    	
	    }
		
	}
	
	//test
	public void addPercentagePrimaryBenf() throws InterruptedException{
		
		Reporter.log("\tTite : Check Primary Benificiaries % ",true);
		checkPercentageEquality("50", percdata, "rel_ins_percentage", "rel_ins_percentage2");
	    
	}
	
	//test
	public void addPercentageContingentBenf() throws InterruptedException{

		Reporter.log("\tTite : Check Contingent Benificiaries % ",true);
		checkPercentageEquality("50", percdata, "con_ins_percentage", "con_ins_percentage2");
		

	}
	
	
	//test
	public void next(){
		
		Reporter.log("\tTitle : click Next button in Beneficiary Info",true);
		try{
			WebElement next = driver.findElement(By.id("next_button"));
			(new Actions(driver)).moveToElement(next).perform();
			if(next.isDisplayed()){
				next.click();
				(new WebDriverWait(driver, 30)).until(ExpectedConditions.attributeToBe(By.xpath("//li[@id = '4']"), "class","active"));
				Reporter.log("\tStatus ::Passed clicked Next button",true);   	   
			}else{
				Reporter.log("\tStatus ::Failed to Displayed Next button",true);
			}
		}catch (Exception e){
			Reporter.log("\tStatus ::Failed To move Ownership Info page");
			e.printStackTrace();
		}

	}
 }		
	
	/*public void invalidPriBenfName(){
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private int testNum = 0;
	private int passCount = 0;
	private int failCount = 0;
	private int addBenCount = 1;
	private int addConBenCount = 1;

	public AppProcessBeneficiaryInfo(){

	}

	public AppProcessBeneficiaryInfo(int testNum, int passCount, int failCount){
		this.testNum = testNum;
		this.passCount = passCount;
		this.failCount = failCount;
	}

	public void clearallfields(WebDriver obj)
	{
		String benId = "ben_name";
		String relName = "rel_name";
		String relInsPercent = "rel_ins_percentage";

		WebElement benData = obj.findElement(By.id(benId));
		benData.clear();
		WebElement benRel = obj.findElement(By.id(relName));
		benRel.clear();
		WebElement benRelPercent = obj.findElement(By.id(relInsPercent));
		benRelPercent.clear();

		benId = "con_ben_name";
		relName = "con_rel_name";
		relInsPercent = "con_ins_percentage";

		benData = obj.findElement(By.xpath("html/body/div[3]/div/div/div[1]/div[2]/div[2]/div/form/div[2]/ol/div[3]/div/div[1]/div/input"));
		benData.clear();

		benRel = obj.findElement(By.id(relName));
		benRel.clear();

		benRelPercent = obj.findElement(By.id(relInsPercent));
		benRelPercent.clear();

	}
	public void setBenData(WebDriver obj, String strBenName, String strBenRel, String strBenPercent, boolean type){
		testNum++;
		System.out.println("\nTest " + testNum);
		System.out.println("\tTitle: Set Beneficiary Name, Relation and Percentage : ");
		System.out.println("\tInput: "+ strBenName +", " + strBenRel +", " + strBenPercent);

		try {
			String benId = "ben_name";
			String relName = "rel_name";
			String relInsPercent = "rel_ins_percentage";
			if(addBenCount > 1){
				String num = Integer.toString(addBenCount);
				benId = benId+num;
				relName = relName + num; 
				relInsPercent = relInsPercent + num;
			}
			WebElement benData = obj.findElement(By.id(benId));
			benData.clear();

			WebElement benRel = obj.findElement(By.id(relName));
			benRel.clear();

			WebElement benRelPercent = obj.findElement(By.id(relInsPercent));
			benRelPercent.clear();
			if(type) {
				benData.sendKeys(strBenName);
				benRel.sendKeys(strBenRel);
				benRelPercent.sendKeys(strBenPercent);

				System.out.println("\tStatus: Added Beneficiary Details");
				System.out.println("\tTest" + testNum + "- PASSED");
				passCount++;
			}
			if(!type){
				WebElement next = obj.findElement(By.id("next_button"));
				//next.click();
				JavascriptExecutor jse = (JavascriptExecutor) obj;
				jse.executeScript("arguments[0].click()", next);

				try{
					if(benRelPercent.isDisplayed()){
						System.out.println("\tStatus: Passed Did not add Invalid Beneficiary Details");
						System.out.println("\tTest" + testNum + "- PASSED");
						passCount++;
					}
				} catch(Exception e){
					System.out.println("\tStatus: Added Invalid Beneficiary Details");
					System.out.println("\tTest" + testNum + "- FAILED");
					failCount++;
				}
			}
		} catch(Exception e){
			System.out.println("\tStatus: Caught Exception. Failed to add Beneficiary Details");
			System.out.println("\tTest" + testNum + "- FAILED");
			failCount++;
			e.printStackTrace();
		}
	}

	public void addBeneficiary(WebDriver obj){
		WebElement add = obj.findElement(By.id("ben-btn"));
		//add.click();
		JavascriptExecutor jse = (JavascriptExecutor) obj;
		jse.executeScript("arguments[0].click()", add);

		addBenCount++;
	}

	public void setConBenData(WebDriver obj, String strConBenName, String strConBenRel, String strConBenPercent, boolean type){
		testNum++;
		System.out.println("\nTest " + testNum);
		System.out.println("\tTitle: Set Contingent Beneficiary Name : ");
		System.out.println("\tInput: "+ strConBenName +", " + strConBenRel +", " + strConBenPercent);

		try {
			String benId = "con_ben_name";
			String relName = "con_rel_name";
			String relInsPercent = "con_ins_percentage";
			if(addBenCount > 1){
				String num = Integer.toString(addBenCount);
				benId = benId+num;
				relName = relName + num; 
				relInsPercent = relInsPercent + num;
			}
			//WebElement benData = obj.findElement(By.id(benId));
			WebElement benData = obj.findElement(By.xpath("html/body/div[3]/div/div/div[1]/div[2]/div[2]/div/form/div[2]/ol/div[3]/div/div[1]/div/input"));
			benData.clear();
			//benData.sendKeys(strConBenName);

			//WebElement benRel = obj.findElement(By.id(relName));
			WebElement benRel = obj.findElement(By.xpath("html/body/div[3]/div/div/div[1]/div[2]/div[2]/div/form/div[2]/ol/div[3]/div/div[2]/div[1]/input"));
			benRel.clear();
//			benRel.sendKeys(strConBenRel);

			WebElement benRelPercent = obj.findElement(By.xpath("html/body/div[3]/div/div/div[1]/div[2]/div[2]/div/form/div[2]/ol/div[3]/div/div[2]/div[2]/input"));
			benRelPercent.clear();
//			benRelPercent.sendKeys(strConBenPercent);

			
			System.out.println("\tStatus: Added Contingent Beneficiary Details");

			System.out.println("\tTest" + testNum + "- PASSED");
			passCount++;
			 		
			if(type) {
				benData.sendKeys(strConBenName);
				benRel.sendKeys(strConBenRel);
				benRelPercent.sendKeys(strConBenPercent);

				System.out.println("\tStatus: Added Beneficiary Details");
				System.out.println("\tTest" + testNum + "- PASSED");
				passCount++;
			}
			if(!type){
				 WebElement next = obj.findElement(By.id("next_button"));
				 //next.click();
				 JavascriptExecutor jse = (JavascriptExecutor) obj;
				 jse.executeScript("arguments[0].click()", next);

				 try{
					 if(benRelPercent.isDisplayed()){
						 System.out.println("\tStatus: Did not add Invalid Contingent Beneficiary Details");

						 System.out.println("\tTest" + testNum + "- PASSED");
						 passCount++;
					 }
				 } catch(Exception e){
					 System.out.println("\tStatus: Caught Exception. Added Invalid Contingent Beneficiary Details");

					 System.out.println("\tTest" + testNum + "- FAILED");
					 failCount++;
					 e.printStackTrace();
				 }
			 }
		} catch(Exception e){
			System.out.println("\tStatus: Caught Exception. Failed to add Contingent Beneficiary Details");

			System.out.println("\tTest" + testNum + "- FAILED");
			failCount++;
			e.printStackTrace();
		}
	}

	public void addConBeneficiary(WebDriver obj){
		WebElement add = obj.findElement(By.id("con-beneficiary"));
		//add.click();
		JavascriptExecutor jse = (JavascriptExecutor) obj;
		jse.executeScript("arguments[0].click()", add);

		addConBenCount++;
	}

	public void clickNext(WebDriver obj){
		WebElement next = obj.findElement(By.id("next_button"));
		//next.click();
		JavascriptExecutor jse = (JavascriptExecutor) obj;
		jse.executeScript("arguments[0].click()", next);

	}
	public int[] callAllMethodsAPBI(WebDriver obj){
		int countArray[] = new int[3];
		clearallfields(obj);
		setBenData(obj, "!@#123", "E!@", "qwe", false);
		setBenData(obj, "Jacob", "Father", "100", true);
		//addBeneficiary(obj);

		try {
			Thread.sleep(3000);
		} catch(Exception e){

		}
		setConBenData(obj, "!@#123", "E!@", "qwe", false);
		setConBenData(obj, "Lusi", "Mother", "100", true);
		//addConBeneficiary(obj);
		clickNext(obj);

		countArray[0] = testNum;
		countArray[1] = passCount;
		countArray[2] = failCount;

		System.out.println("Total Tests : "+testNum);
		System.out.println("Pass Tests : "+passCount);
		System.out.println("Fail Tests : "+failCount);
		return countArray;
	}*/
