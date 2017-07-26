package com.sureifylife;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class ConditionalReceipt {

	WebDriver driver = null;
	JavascriptExecutor executor = null;;
	WebDriverWait wait = null;

	public ConditionalReceipt(WebDriver driver){

		this.driver = driver;
		executor = ((JavascriptExecutor)  driver);
		wait = new WebDriverWait(driver, 30);
	}


	public void clickConditionalNext(){


		try {

			Reporter.log("\tTitle: Click on Confirm : ",true);
			Reporter.log("\tInput: N/A",true);
			//obj.findElement(By.id("coditionalnext")).click();
			WebElement e = driver.findElement(By.id("coditionalnext"));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click()", e);

			Thread.sleep(5000);
			Reporter.log("\tStatus: Clicked on Confirm",true);
			Reporter.log("\tTest - PASSED",true);
		} catch(Exception e) {
			Reporter.log("\tStatus: Caught Exception. Could not Click on Confirm",true);
			Reporter.log("\tTest - FAILED",true);
			//e.printStackTrace();
		}
	}


}
