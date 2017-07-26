package com.sureifylife;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PackageDelivery {

	private int testNum = 0;
	private int passCount = 0;
	private int failCount = 0;

	JavascriptExecutor executor;
	
	public PackageDelivery(){

	}

	public PackageDelivery(int testNum, int passCount, int failCount){
		this.testNum = testNum;
		this.passCount = passCount;
		this.failCount = failCount;
	}
	
	public void checkPrimaryAddress(WebDriver obj){
		
		try {
			obj.findElement(By.id("confirmAddressLine1")).clear();
			obj.findElement(By.id("confirmAddressLine2")).clear();
			obj.findElement(By.id("confirmCity")).clear();
			obj.findElement(By.id("confirmZip")).clear();
			testNum++;
			System.out.println("\nTest " + testNum);
			System.out.println("\tTitle: Check Primary Address : ");
			System.out.println("\tInput: N/A");
			//obj.findElement(By.id("sameAsPrimaryAddress")).click();
			executor.executeScript("arguments[0].click()", obj.findElement(By.id("sameAsPrimaryAddress")));
			System.out.println("\tStatus: Checked Primary Address");
			System.out.println("\tTest" + testNum + "- PASSED");
			passCount++;
		} catch(Exception e) {
			System.out.println("\tStatus: Caught Exception. Could not check Primary Address");
			
			System.out.println("\tTest" + testNum + "- FAILED");
			failCount++;
			//e.printStackTrace();
		}
	}
		
	public void addAddress(WebDriver obj){
		try {
			testNum++;
			System.out.println("\nTest " + testNum);
			System.out.println("\tTitle: Add Address");
			String addr1 = "Address Line 1";
			String addr2 = "Address Line 2";
			String city = "City";
			String zip = "1234";
			
			System.out.println("\tInput: Address Line 1 : "+ addr1 + " Address Line 2 : "+addr2+" City : "+city + " Zip Code : "+zip);
			obj.findElement(By.id("confirmAddressLine1")).sendKeys(addr1);
			obj.findElement(By.id("confirmAddressLine2")).sendKeys(addr2);
			obj.findElement(By.id("confirmCity")).sendKeys(city);
			obj.findElement(By.id("confirmZip")).sendKeys(zip);
			Select state = new Select(obj.findElement(By.id("confirmState")));
			state.selectByIndex(3);
			try {
				Thread.sleep(3000);
			} catch(Exception e){
				
			}
			//obj.findElement(By.id("send_button")).click();
			JavascriptExecutor jse = (JavascriptExecutor) obj;
			jse.executeScript("arguments[0].click()", obj.findElement(By.id("send_button")));
			
			System.out.println("\tStatus: Clicked on Send Button");
			System.out.println("\tTest" + testNum + "- PASSED");
			passCount++;
		} catch(Exception e) {
			System.out.println("\tStatus: Could not click on Send Button");
			System.out.println("\tTest" + testNum + "- FAILED");
			failCount++;
			//e.printStackTrace();
		}
	}
	
	public void zipCodeValidator(WebDriver obj){
		try {
			testNum++;
			System.out.println("\nTest " + testNum);
			System.out.println("\tTitle: Add Address");
			String addr1 = "Address Line 1";
			String addr2 = "Address Line 2";
			String city = "City";
			String zip = "0000";
			
			System.out.println("\tInput: Address Line 1 : "+ addr1 + " Address Line 2 : "+addr2+" City : "+city + " Zip Code : "+zip);
			obj.findElement(By.id("confirmAddressLine1")).sendKeys(addr1);
			obj.findElement(By.id("confirmAddressLine2")).sendKeys(addr2);
			obj.findElement(By.id("confirmCity")).sendKeys(city);
			obj.findElement(By.id("confirmZip")).sendKeys(zip);
			Select state = new Select(obj.findElement(By.id("confirmState")));
			state.selectByIndex(3);
			try {
				Thread.sleep(3000);
			} catch(Exception e){
				
			}
			//obj.findElement(By.id("send_button")).click();
			JavascriptExecutor jse = (JavascriptExecutor) obj;
			jse.executeScript("arguments[0].click()", obj.findElement(By.id("send_button")));
			
			if(obj.findElement(By.id("confirmZip")).isDisplayed()) {
			System.out.println("\tStatus: Zip Code : 0000 not accepted");
			System.out.println("\tTest" + testNum + "- PASSED");
			passCount++;
			} else {
				System.out.println("\tStatus: Zip Code : 0000 accepted");
				System.out.println("\tTest" + testNum + "- FAILED");
				failCount++;
			}
		} catch(Exception e) {
			System.out.println("\tStatus: Caught Exception. Zip Code : 0000 accepted");
			System.out.println("\tTest" + testNum + "- FAILED");
			failCount++;
			//e.printStackTrace();
		}
	}
		public void clickSend(WebDriver obj){
			
			try {
				testNum++;
				System.out.println("\nTest " + testNum);
				System.out.println("\tTitle: Click Send : ");
				System.out.println("\tInput: N/A");
				try {
					Thread.sleep(3000);
				} catch(Exception e){
					
				}
				//obj.findElement(By.id("send_button")).click();
				JavascriptExecutor jse = (JavascriptExecutor) obj;
				jse.executeScript("arguments[0].click()", obj.findElement(By.id("send_button")));
				
				System.out.println("\tStatus: Clicked on Send Button");
				
				System.out.println("\tTest" + testNum + "- PASSED");
				passCount++;
			} catch(Exception e) {
				System.out.println("\tStatus: Caught Exception. Could not click on Send Button");
				System.out.println("\tTest" + testNum + "- FAILED");
				failCount++;
				//e.printStackTrace();
			}
	}
	
		public void isModalAppeared(WebDriver obj){
			//*[@id="loginPopup"]/div/div
			try {
				testNum++;
				System.out.println("\nTest " + testNum);
				System.out.println("\tTitle: Modal to Login : ");
				System.out.println("\tInput: N/A");
				if(obj.findElement(By.xpath("html/body/div[4]/div/div/div")).isDisplayed()){
					System.out.println("\tStatus: Modal is Appeared");
					System.out.println("\tTest" + testNum + "- PASSED");
					passCount++;
				} else {
					System.out.println("\tStatus: Modal did not Appear");
					System.out.println("\tTest" + testNum + "- FAILED");
					failCount++;
				}
			} catch(Exception e) {
				System.out.println("\tStatus: Caught Exception. Modal did not Appear");
				System.out.println("\tTest" + testNum + "- FAILED");
				failCount++;
				//e.printStackTrace();
			}
		}
		
		public void login(WebDriver obj){
			String stremail = "swati8591@gmail.com";
			String strpassword = "swathi123";
			String strsend_button = "send_button";
			try {
				testNum++;
				System.out.println("\nTest " + testNum);
				System.out.println("\tTitle: Login to Dashboard ");
				System.out.println("\tInput: Email : "+stremail + " Password : "+strpassword);
				
				obj.findElement(By.id("email")).clear();
				obj.findElement(By.id("email")).sendKeys(stremail);
				
				obj.findElement(By.id("password")).clear();
				obj.findElement(By.id("password")).sendKeys(strpassword);
				
				String url_before_login = obj.getCurrentUrl();
				//obj.findElement(By.xpath("//*[@id=\"send_button\"]")).click();
				Thread.sleep(3000);
				executor.executeScript("arguments[0].click()", obj.findElement(By.id("send_button")));
				
				try{
					Thread.sleep(60000);
				} catch (Exception e) {
					
				}
				String url_after_login = obj.getCurrentUrl();
				try{
					Thread.sleep(3000);
				} catch (Exception e) {
					
				}
				if(!url_before_login.equals(url_after_login)) {
					System.out.println("\tStatus: Successfully Logged Into Dashboard.");
					System.out.println("\tTest" + testNum + "- PASSED");
					passCount++;
					//obj.findElement(By.id("logout")).click();
					JavascriptExecutor jse = (JavascriptExecutor) obj;
					jse.executeScript("arguments[0].click()", obj.findElement(By.id("logout")));
					
				} else {
					System.out.println("\tStatus: Failed Logging Into Dashboard.");
					System.out.println("\tTest" + testNum + "- FAILED");
					failCount++;
					obj.get("http://stg.sureify.com/login");
					//executor.executeScript("arguments[0].click()", obj.findElement(By.xpath("//*[@id=\"send_button\"]")));
					
				}
			} catch(Exception e) {
				System.out.println("\tStatus: Caught Exception. Failed Logging Into Dashboard.");
				System.out.println("\tTest" + testNum + "- FAILED");
				failCount++;
				obj.get("http://stg.sureify.com/login");
				//e.printStackTrace();
			}
		}
	public int[] callAllMethodsPD(WebDriver obj){
		int countArray[] = new int[3];
		executor = (JavascriptExecutor) obj;
		
		checkPrimaryAddress(obj);
		clickSend(obj);
		isModalAppeared(obj);
		try {
			Thread.sleep(4000);
		} catch(Exception e) {
			
		}
		login(obj);
		
		countArray[0] = testNum;
		countArray[1] = passCount;
		countArray[2] = failCount;
		
		System.out.println("Total Tests : "+testNum);
		System.out.println("Pass Tests : "+passCount);
		System.out.println("Fail Tests : "+failCount);
		return countArray;
	}
}
