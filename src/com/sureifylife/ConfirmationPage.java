package com.sureifylife;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import junit.framework.Assert;

public class ConfirmationPage { 
	
	WebDriver driver = null;
	JavascriptExecutor executor = null;
	WebDriverWait wait = null;
	
	public ConfirmationPage(WebDriver driver){
		
		this.driver = driver;
        executor = (JavascriptExecutor)driver;
        wait = new WebDriverWait(driver, 30);
	}

	

	public void checkGreyLayout(){
		try {
			Thread.sleep(2000);
			Reporter.log("\tTitle: Check whether Gray Window is Present : ",true);
			if(driver.findElement(By.id("a")).isDisplayed()){
				Reporter.log("\tStatus: Passed");
			} else {
				Reporter.log("\tStatus:: Failed , Gray Layout is not visible",true);
			}
		} catch(Exception e) {
			Reporter.log("\tStatus: Caught Exception. Gray Layout is not visible",true);
		}
	}

	public void selectOtherTab(){
		try {
			
			Reporter.log("\tTitle: Click on Other Tab : ",true);
			WebElement tab = driver.findElement(By.xpath("//a[@id = 'otherinsurance_tab']"));
			executor.executeScript("arguments[0].scrollIntoView(false)",tab);
			executor.executeScript("arguments[0].click();",tab);
			Thread.sleep(3000);
			Reporter.log("\tStatus: Selected Other Tab",true);
			Reporter.log("\tTest - PASSED",true);
		} catch(Exception e) {
			Reporter.log("\tStatus: Caught Exception. Could not Select another Tab",true);
			Reporter.log("\tTest - FAILED",true);
			
		}

	}

	public void clickEdit(){
		try {
			
			Reporter.log("\tTitle: Click on Edit : ",true);
			Reporter.log("\tInput: N/A",true);
			//obj.findElement(By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/div[3]/a")).click();
			//executor.executeScript("arguments[0].click",obj.findElement(By.xpath("/html/body/div[3]/div[3]/div[2]/div[2]/div[3]/a")));
			driver.findElement(By.id("edit_button")).click();
		    wait.until(ExpectedConditions.urlContains("edit"));
			Reporter.log("\tStatus: Clicked on Edit",true);
			Reporter.log("\tTest - PASSED",true);
		} catch(Exception e) {
			Reporter.log("\tStatus: Exception Caught. Could not click on Edit",true);
			
			Reporter.log("\tTest - FAILED",true);
			//e.printStackTrace();
		}
	}

	public void clickUpdate(){
		try {
			
			Reporter.log("\tTitle: Click on Update : ",true);
			Reporter.log("\tInput: N/A",true);
			//obj.findElement(By.id("next_button")).click();

			executor.executeScript("arguments[0].click();",driver.findElement(By.id("next_button")));
			Reporter.log("\tStatus: Clicked on Update",true);
			wait.until(ExpectedConditions.urlContains("confirminformation"));
			Reporter.log("\tTest- PASSED",true); 
		
		} catch(Exception e) {
			Reporter.log("\tStatus: Exception Caught. Could not click on Update",true);
			
			Reporter.log("\tTest - FAILED",true);
			//e.printStackTrace();
		}
	}

	public void clickConfirm(){

		try {
			Reporter.log("\tTitle: Click on Confirm : ",true);
			Reporter.log("\tInput: N/A",true);

			//obj.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[4]/a")).click();
			WebElement element = driver.findElement(By.linkText("CONFIRM"));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click()", element);
			Thread.sleep(5000);
			String res = driver.getCurrentUrl();
			if(res.contains("conditionalReceipt")){

				Reporter.log("\tTest - PASSED",true);
			}else{
				Reporter.log("\tTest - FAILED",true);
			}

		} catch(Exception e) {
			Reporter.log("\tTest - FAILED",true);
		}
	}
	
}
