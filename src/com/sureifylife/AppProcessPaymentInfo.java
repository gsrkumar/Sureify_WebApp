package com.sureifylife;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

//import com.gargoylesoftware.htmlunit.javascript.configuration.JavaScriptConfiguration;

public class AppProcessPaymentInfo {
	
	WebDriver driver = null;
	JavascriptExecutor executer = null;
	/*private int testNum = 0;
	private int passCount = 0;
	private int failCount = 0;*/

	

	public AppProcessPaymentInfo(WebDriver driver){
		
		this.driver = driver;
		executer = (JavascriptExecutor) driver;

	}
	
	public void clickNext(){
		try{
			
			Reporter.log("\tTitle: Click Next Button ");

			System.out.println("\tInput: N/A");
			WebElement next = driver.findElement(By.id("next_button"));
			executer.executeScript("arguments[0].scrollIntoView(false)",next);
			executer.executeScript("arguments[0].click()", next);
			Thread.sleep(5000);
			Reporter.log("\tStatus ::Passed",true);
		} catch(Exception e){
			Reporter.log("\tStatus: Not Clicked on Next Button");
			
		}
	}

	/*public AppProcessPaymentInfo(int testNum, int passCount, int failCount){
		this.testNum = testNum;
		this.passCount = passCount;
		this.failCount = failCount;
	}
	public void clearallfields(WebDriver obj)
	{
		WebElement bank_name = obj.findElement(By.id("bank_name"));
		bank_name.clear();

		WebElement bank_acno = obj.findElement(By.id("bank_acno"));
		bank_acno.clear();

		WebElement bank_routingno = obj.findElement(By.id("bank_acno"));
		bank_routingno.clear();


		WebElement credit_card_no = obj.findElement(By.id("credit_card_no"));
	credit_card_no.clear();

	WebElement exp_date = obj.findElement(By.id("exp_date"));
	exp_date.clear();

	WebElement card_cvv = obj.findElement(By.id("card_cvv"));
	card_cvv.clear();

	}
    public void clickNext(WebDriver obj){
	//	try{
	//		testNum++;
	//			System.out.println("\nTest " + testNum);
	//			System.out.println("\tTitle: Click Next Button ");
	//
	//		System.out.println("\tInput: N/A");
	//			//obj.findElement(By.id("next_button")).click();
	//		JavascriptExecutor jse = (JavascriptExecutor) obj;
	//		jse.executeScript("arguments[0].click()", obj.findElement(By.name("next_button")));
	//			Thread.sleep(5000);
	//			System.out.println("");
	//			System.out.println("\tTest" + testNum + "- PASSED");
	//			passCount++;
	//		} catch(Exception e){
	//			System.out.println("\tTest" + testNum + "- FAILED");
	//			failCount++;
	//		}
	//	}*/
	/*public void  bankname(WebDriver obj, boolean type )
	{
		try{
			testNum++;
			//String cellNumber = type?"1234567890":"123";
			String bankname= type?"CITI":"123456";
			System.out.println("\nTest " + testNum);
			System.out.println("\tTitle: Enter Bank Name ");

			System.out.println("\tInput:"+bankname);

			WebElement bank_name = obj.findElement(By.id("bank_name"));
			bank_name.clear();
			Thread.sleep(5000);
			bank_name.sendKeys(bankname);
			Thread.sleep(5000);
			String status = type?"Accepted":"Invalid data showing error message  ";
			System.out.println("\tStatus: "+status);
			System.out.println("\tTest" + testNum + "- PASSED");
			passCount++;

		}
		catch(Exception e)
		{
			System.out.println("\tStatus:  Accepted the bank name");
			System.out.println("\tTest" + testNum + "- FAILED");
			failCount++;
		}
	}
	public void invalidACnumber(WebDriver obj)
	{
		try
		{
			testNum++;
			//String ACnumber= type?"123333333333":"123456";
			System.out.println("\nTest " + testNum);
			System.out.println("\tTitle: Enter Invalid Account Number  ");
			System.out.println("\tInput: 11111");
			if(obj.findElement(By.id("bank_acno")).isDisplayed())

			{
				obj.findElement(By.id("bank_acno")).clear();
				obj.findElement(By.id("bank_acno")).sendKeys("11111");
				Thread.sleep(3000);
				System.out.println("\tStatus:Should show error message like Ac number should be 16 digits");
				System.out.println("\tTest" + testNum + "- PASSED");
				passCount++;
			}

			else
			{
				System.out.println("\tStatus:Account number entered");
				System.out.println("\tTest" + testNum + "- FAILED");
				failCount++;
			}

		}
		catch(Exception e)
		{
			System.out.println("\tStatus:  Invalid Ac number");
			System.out.println("\tTest" + testNum + "- FAILED");
			failCount++;
		}
	}
	public void invalidACnumber1(WebDriver obj)
	{
		try
		{
			testNum++;
			//String ACnumber= type?"123333333333":"123456";
			System.out.println("\nTest " + testNum);
			System.out.println("\tTitle: Enter Bank Name ");
			System.out.println("\tInput:ghjgvkgiki#$%^&*");
			if(obj.findElement(By.id("bank_acno")).isDisplayed())

			{
				obj.findElement(By.id("bank_acno")).clear();
				obj.findElement(By.id("bank_acno")).sendKeys("ghjgvkgiki#$%^&*");
				Thread.sleep(3000);
				System.out.println("\tStatus:Should show error message like The bank name can only consist of alphabetical and space.");
				System.out.println("\tTest" + testNum + "- PASSED");
				passCount++;
			}

			else
			{
				System.out.println("\tStatus: Invalid Bank name Accepted");
				System.out.println("\tTest" + testNum + "- FAILED");
				failCount++;
			}

		}
		catch(Exception e)
		{
			System.out.println("\tStatus:  Invalid Bank name Accepted");
			System.out.println("\tTest" + testNum + "- FAILED");
			failCount++;
		}
	}
	public void validACnumber1(WebDriver obj)
	{
		try
		{
			testNum++;
			//String ACnumber= type?"123333333333":"123456";
			System.out.println("\nTest " + testNum);
			System.out.println("\tTitle: Enter Account Number ");
			System.out.println("\tInput:11111111111111111");
			if(obj.findElement(By.id("bank_acno")).isDisplayed())

			{
				obj.findElement(By.id("bank_acno")).clear();
				obj.findElement(By.id("bank_acno")).sendKeys("11111111111111111");
				Thread.sleep(3000);
				System.out.println("\tStatus:Ac number accepted ");
				System.out.println("\tTest" + testNum + "- PASSED");
				passCount++;
			}

			else
			{
				System.out.println("\tStatus:Invalid Account number ");
				System.out.println("\tTest" + testNum + "- FAILED");
				failCount++;
			}

		}
		catch(Exception e)
		{
			System.out.println("\tStatus:  Invalid Ac number");
			System.out.println("\tTest" + testNum + "- FAILED");
			failCount++;
		}
	}

	public void invalidroutingno(WebDriver obj)
	{
		try
		{
			testNum++;
			//String ACnumber= type?"123333333333":"123456";
			System.out.println("\nTest " + testNum);
			System.out.println("\tTitle: Enter routing number ");
			System.out.println("\tInput:1111");
			if(obj.findElement(By.id("bank_routingno")).isDisplayed())

			{
				obj.findElement(By.id("bank_routingno")).clear();
				obj.findElement(By.id("bank_routingno")).sendKeys("1111");
				Thread.sleep(3000);
				System.out.println("\tStatus:Invalid routing  number  ");
				System.out.println("\tTest" + testNum + "- Failed");
				failCount++;
			}

			else
			{
				System.out.println("\tStatus:Valid routing number");
				System.out.println("\tTest" + testNum + "- PASSED");
				passCount++;
			}

		}
		catch(Exception e)
		{
			System.out.println("\tStatus:  Invalid routing number");
			System.out.println("\tTest" + testNum + "- FAILED");
			failCount++;
		}
	}
	public void invalidroutingno1(WebDriver obj)
	{
		try
		{
			testNum++;
			//String ACnumber= type?"123333333333":"123456";
			System.out.println("\nTest " + testNum);
			System.out.println("\tTitle: Enter routing number ");
			System.out.println("\tInput:@!@!@!@!$$%%^^&");
			if(obj.findElement(By.id("bank_routingno")).isDisplayed())

			{
				obj.findElement(By.id("bank_routingno")).clear();
				obj.findElement(By.id("bank_routingno")).sendKeys("@!@!@!@!$$%%^^&");
				Thread.sleep(3000);
				System.out.println("\tStatus:Should show an error message like The bank routing number can only consist of only numbers.  ");
				System.out.println("\tTest" + testNum + "- PASSED");
				passCount++;
			}

			else
			{
				System.out.println("\tStatus:InValid routing number");
				System.out.println("\tTest" + testNum + "- FAILED");
				failCount++;
			}

		}
		catch(Exception e)
		{
			System.out.println("\tStatus:  Invalid routing number");
			System.out.println("\tTest" + testNum + "- FAILED");
			failCount++;
		}
	}
	public void validroutingno1(WebDriver obj)
	{
		try
		{
			testNum++;
			//String ACnumber= type?"123333333333":"123456";
			System.out.println("\nTest " + testNum);
			System.out.println("\tTitle: Enter routing number ");
			System.out.println("\tInput:123456789");
			if(obj.findElement(By.id("bank_routingno")).isDisplayed())

			{
				obj.findElement(By.id("bank_routingno")).clear();
				obj.findElement(By.id("bank_routingno")).sendKeys("123456789");
				Thread.sleep(3000);
				System.out.println("\tStatus:Valid routing  number  ");
				System.out.println("\tTest" + testNum + "- PASSED");
				passCount++;
			}

			else
			{
				System.out.println("\tStatus:InValid routing number");
				System.out.println("\tTest" + testNum + "- FAILED");
				failCount++;
			}

		}
		catch(Exception e)
		{
			System.out.println("\tStatus:InValid routing number");
			System.out.println("\tTest" + testNum + "- FAILED");
			failCount++;
		}
	}
	public void settlementyes(WebDriver obj)

	{
		try{
			testNum++;
			System.out.println("\nTest " + testNum);
			System.out.println("\tTitle: Click on YES Button ");
			WebElement settlement = obj.findElement(By.id("bank_settlement1"));

			if(settlement.isDisplayed())
			{
				JavascriptExecutor jse = (JavascriptExecutor)obj;
				jse.executeScript("arguments[0].click();",settlement ); 
				//obj.findElement(By.id("bank_settlement1")).click();
				Thread.sleep(3000);
				System.out.println("\tStatus: Clicked on Yes ");
				System.out.println("\tTest" + testNum + "- PASSED");
				passCount++;
			}
			else
			{
				System.out.println("\tStatus: Not Clicked on Yes ");
				System.out.println("\tTest" + testNum + "- FAILED");
				failCount++;
			}
		}
		catch(Exception e)
		{
			System.out.println("\tStatus: Not Clicked on Yes ");
			System.out.println("\tTest" + testNum + "- FAILED");
			failCount++;
		}
	}
	public void settlementno(WebDriver obj)
	{
		try{
			testNum++;
			System.out.println("\nTest " + testNum);
			System.out.println("\tTitle: Click on NO Button ");
			WebElement settlementno = obj.findElement(By.id("bank_settlement2"));

			if(settlementno.isDisplayed())
			{
				JavascriptExecutor jse = (JavascriptExecutor)obj;
				jse.executeScript("arguments[0].click();",settlementno ); 

				Thread.sleep(3000);
				System.out.println("\tStatus: Clicked on No ");
				System.out.println("\tTest" + testNum + "- PASSED");
				passCount++;
			}
			else
			{
				System.out.println("\tStatus: Not Clicked on No ");
				System.out.println("\tTest" + testNum + "- FAILED");
				failCount++;
			}
		}
		catch(Exception e)
		{
			System.out.println("\tStatus: Not Clicked on No ");
			System.out.println("\tTest" + testNum + "- FAILED");
			failCount++;
		}
	}
	public void shortageyes(WebDriver obj)
	{
		try{
			testNum++;
			System.out.println("\nTest " + testNum);
			System.out.println("\tTitle: Click on YES Button ");
			WebElement shortage = obj.findElement(By.id("bank_settlement1"));

			if(shortage.isDisplayed())
			{
				JavascriptExecutor jse = (JavascriptExecutor)obj;
				jse.executeScript("arguments[0].click();",shortage ); 

				Thread.sleep(4000);
				System.out.println("\tStatus: Clicked on Yes ");
				System.out.println("\tTest" + testNum + "- PASSED");
				passCount++;
			}
			else
			{
				System.out.println("\tStatus: Not Clicked on Yes ");
				System.out.println("\tTest" + testNum + "- FAILED");
				failCount++;
			}
		}
		catch(Exception e)
		{
			System.out.println("\tStatus: Not Clicked on Yes ");
			System.out.println("\tTest" + testNum + "- FAILED");
			failCount++;
		}
	}
	public void shortageno(WebDriver obj)
	{
		try{
			testNum++;
			System.out.println("\nTest " + testNum);
			System.out.println("\tTitle: Click on NO Button ");
			WebElement Shortage1 = obj.findElement(By.id("bank_shortage2"));
			if(Shortage1.isDisplayed())
			{
				JavascriptExecutor jse = (JavascriptExecutor)obj;
				jse.executeScript("arguments[0].click();",Shortage1 ); 
				Thread.sleep(4000);
				System.out.println("\tStatus: Clicked on No ");
				System.out.println("\tTest" + testNum + "- PASSED");
				passCount++;
			}
			else
			{
				System.out.println("\tStatus: Not Clicked on No ");
				System.out.println("\tTest" + testNum + "- FAILED");
				failCount++;
			}

		}
		catch(Exception e)
		{
			System.out.println("\tStatus: Not Clicked on No ");
			System.out.println("\tTest" + testNum + "- FAILED");
			failCount++;
		}
	}
	public void requirementyes(WebDriver obj)
	{
		try{
			testNum++;
			System.out.println("\nTest " + testNum);
			System.out.println("\tTitle: Click on YES Button ");
			WebElement requirement = obj.findElement(By.id("bank_requirement1"));
			if(requirement.isDisplayed())
			{
				JavascriptExecutor jse = (JavascriptExecutor)obj;
				jse.executeScript("arguments[0].click();",requirement );

				Thread.sleep(4000);
				System.out.println("\tStatus: Clicked on Yes ");
				System.out.println("\tTest" + testNum + "- PASSED");
				passCount++;
			}
			else
			{
				System.out.println("\tStatus: Not Clicked on Yes ");
				System.out.println("\tTest" + testNum + "- FAILED");
				failCount++;

			}
		}
		catch(Exception e)
		{
			System.out.println("\tStatus: Not Clicked on Yes ");
			System.out.println("\tTest" + testNum + "- FAILED");
			failCount++;
		}
	}
	public void requirementno(WebDriver obj)
	{
		try{
			testNum++;
			System.out.println("\nTest " + testNum);
			System.out.println("\tTitle: Click on No Button ");
			WebElement requirement1 = obj.findElement(By.id("bank_requirement2"));
			if(requirement1.isDisplayed())
			{
				JavascriptExecutor jse = (JavascriptExecutor)obj;
				jse.executeScript("arguments[0].click();",requirement1 );
				Thread.sleep(4000);
				System.out.println("\tStatus: Clicked on No ");
				System.out.println("\tTest" + testNum + "- PASSED");
				passCount++;
			}
			else
			{
				System.out.println("\tStatus: Not Clicked on No ");
				System.out.println("\tTest" + testNum + "- FAILED");
				failCount++;

			}
		}
		catch(Exception e)
		{
			System.out.println("\tStatus: Not Clicked on No ");
			System.out.println("\tTest" + testNum + "- FAILED");
			failCount++;
		}
	}

	public void selectCreditCardTab(WebDriver obj){
		try{
			testNum++;
			System.out.println("\nTest " + testNum);
			System.out.println("\tTitle: Click on Credit Card Tab ");
			System.out.println("\tInput: N/A");

			WebElement credit_card_tab = obj.findElement(By.xpath("html/body/div[3]/div/div/div[1]/div[2]/div[2]/div/form/div[7]/div/div/ul/li[2]/a"));
			//credit_card_tab.click();

			JavascriptExecutor jse = (JavascriptExecutor) obj;
			jse.executeScript("arguments[0].click()", credit_card_tab);
			Thread.sleep(5000);
			System.out.println("\tStatus: Clicked on Credit Card Tab ");

			//executor.executeScript("arguments[0].click()", save_card);
			System.out.println("\tTest" + testNum + "- PASSED");
			passCount++;
		} catch(Exception e){
			System.out.println("\tTest" + testNum + "- FAILED");
			failCount++;
		}
	}
	//public void clearallfields1(WebDriver obj)
		{
			WebElement credit_card_no = obj.findElement(By.id("credit_card_no"));
	credit_card_no.clear();

	WebElement exp_date = obj.findElement(By.id("exp_date"));
	exp_date.clear();

	WebElement card_cvv = obj.findElement(By.id("card_cvv"));
	card_cvv.clear();
		}
	public void enterCreditCardNo(WebDriver obj){
		try{
			testNum++;
			System.out.println("\nTest " + testNum);
			System.out.println("\tTitle: Enter Credit Card Number ");
			String num = "4242424242424242";
			System.out.println("\tInput: "+num);

			WebElement credit_card_no = obj.findElement(By.id("credit_card_no"));
			credit_card_no.clear();
			Thread.sleep(3000);
			credit_card_no.sendKeys(num);
			Thread.sleep(3000);
			System.out.println("\tStatus: Credit Card Number Entered Successfully ");

			System.out.println("\tTest" + testNum + "- PASSED");
			passCount++;
		} catch(Exception e){
			System.out.println("\tStatus: Caught Exception. Credit Card Number Entry Failed ");

			System.out.println("\tTest" + testNum + "- FAILED");
			failCount++;
			e.printStackTrace();
		}
	}

	public void enterExpDate(WebDriver obj){
		try{
			testNum++;
			System.out.println("\nTest " + testNum);
			System.out.println("\tTitle: Enter Expiry Date ");
			String date = "12/20";
			System.out.println("\tInput: "+date);

			WebElement exp_date = obj.findElement(By.id("exp_date"));
			exp_date.clear();
			Thread.sleep(3000);
			exp_date.sendKeys(date);
			Thread.sleep(3000);
			System.out.println("\tStatus: Date Entered Successfully ");

			System.out.println("\tTest" + testNum + "- PASSED");
			passCount++;
		} catch(Exception e){
			System.out.println("\tStatus: Caught Exception. Date Not Entered  ");

			System.out.println("\tTest" + testNum + "- FAILED");
			failCount++;
		}
	}


	public void enterCardCvv(WebDriver obj){
		try{
			testNum++;
			System.out.println("\nTest " + testNum);
			System.out.println("\tTitle: Card CVV ");
			String card_cvv_str = "111";
			System.out.println("\tInput: "+card_cvv_str);

			WebElement card_cvv = obj.findElement(By.id("card_cvv"));
			card_cvv.clear();
			Thread.sleep(3000);
			card_cvv.sendKeys(card_cvv_str);
			Thread.sleep(3000);
			System.out.println("\tStatus: CVV Entered Successfully ");

			System.out.println("\tTest" + testNum + "- PASSED");
			passCount++;
		} catch(Exception e){
			System.out.println("\tStatus: Caught Exception. CVV Not Entered ");
			System.out.println("\tTest" + testNum + "- FAILED");
			failCount++;
		}
	}

	public void checkSaveCard(WebDriver obj){
		try{
			testNum++;
			System.out.println("\nTest " + testNum);
			System.out.println("\tTitle: Check I agree ");
			System.out.println("\tInput: N/A");

			WebElement save_card = obj.findElement(By.id("save_card"));
			//save_card.click();
			JavascriptExecutor jse = (JavascriptExecutor) obj;
			jse.executeScript("arguments[0].click()", save_card);

			System.out.println("\tStatus: Checked I agree ");

			//executor.executeScript("arguments[0].click()", save_card);
			System.out.println("\tTest" + testNum + "- PASSED");
			passCount++;
		} catch(Exception e){
			System.out.println("\tTest" + testNum + "- FAILED");
			failCount++;
		}
	}

	public void clickNext(WebDriver obj){
		try{
			testNum++;
			System.out.println("\nTest " + testNum);
			System.out.println("\tTitle: Click Next Button ");

			System.out.println("\tInput: N/A");
			//obj.findElement(By.id("next_button")).click();
			JavascriptExecutor jse = (JavascriptExecutor) obj;
			jse.executeScript("arguments[0].click()", obj.findElement(By.id("next_button")));
			Thread.sleep(5000);
			System.out.println("\tStatus: Clicked on Next Button");
			System.out.println("\tTest" + testNum + "- PASSED");
			passCount++;
		} catch(Exception e){

			System.out.println("\tStatus: Not Clicked on Next Button");
			System.out.println("\tTest" + testNum + "- FAILED");
			failCount++;
		}
	}


	public int[] callAllMethodsAPPAYI(WebDriver obj){
		int countArray[] = new int[3];
		executor = (JavascriptExecutor) obj;
		//selectCreditCardTab(obj);
		try {
			Thread.sleep(3000);
		} catch ( Exception e ) {

		}
		clearallfields(obj);
		bankname(obj,false);
		bankname(obj,true);
		//invalidACnumber(obj);
		invalidACnumber1(obj);
		validACnumber1(obj);
		//invalidroutingno(obj);
		invalidroutingno1(obj);
		validroutingno1(obj);
		settlementyes(obj);
		settlementno(obj);
		shortageyes(obj);
		shortageno(obj);
		requirementyes(obj);
		requirementno(obj);
		selectCreditCardTab(obj);
		//clearallfields1(obj);
		enterCreditCardNo(obj);
		enterExpDate(obj);
		enterCardCvv(obj);
		checkSaveCard(obj);
		clickNext(obj);
		countArray[0] = testNum;
		countArray[1] = passCount;
		countArray[2] = failCount;

		System.out.println("Total Tests : "+testNum);
		System.out.println("Pass Tests : "+passCount);
		System.out.println("Fail Tests : "+failCount);
		return countArray;
	}*/
}
