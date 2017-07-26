/**
 * 
 */
package com.sureifylife;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author Swathi
 *
 */
public class Main 
{
	public static int testnum=0;
	public static int passcount = 0;
	public static int failcount = 0;
	
	public static void main(String[] args) throws InterruptedException 
	{
		//Firefox
		WebDriver obj = new FirefoxDriver();
		
		//Chrome
		
		/*System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
		WebDriver obj = new ChromeDriver();*/
		
		//IE
		
		/*System.setProperty("webdriver.ie.driver", "E:\\IEDriverServer_Win32_2.53.0\\IEDriverServer.exe");
		WebDriver obj = new InternetExplorerDriver();*/
				
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMM-dd-yyyy h:mm:ss a");
		String formattedDate = sdf.format(date);
	  
		System.out.println("***********************************************************");
		System.out.println("*\tSelenium Automation Testing Log");
		System.out.println("*\tApplication : Sureify stg");
		System.out.println("*\tExecution Start Time: " +formattedDate);
		System.out.println("*\tBuild Number: Not Available");
		System.out.println("***********************************************************");
		
		int[] countarray = new int[3];
		//LaunchApp launchapp = new LaunchApp(testnum,passcount,failcount);
		//countarray = launchapp.callAllMethodsLA(obj);
		
		/*QuotePage quotepage = new QuotePage(countarray[0],countarray[1],countarray[2]);
		countarray = quotepage.callAllMethodsQP(obj);
		*/
		/*BasicInfo basicInfo = new BasicInfo(countarray[0],countarray[1],countarray[2]);
		countarray = basicInfo.callAllMethodsBI(obj);*/
		
		/*AppProcessCreateAcount appProcessCreateAcount = new AppProcessCreateAcount(countarray[0],countarray[1],countarray[2]);
		countarray = appProcessCreateAcount.callAllMethodsAP(obj);*/
		
		/*AppProcessPersonalInfo appProcessPersonalInfo = new AppProcessPersonalInfo(countarray[0],countarray[1],countarray[2]);
		countarray = appProcessPersonalInfo.callAllMethodsAPPI(obj);*/
		
		/*AppProcessBeneficiaryInfo appProcessBeneficiaryInfo = new AppProcessBeneficiaryInfo(countarray[0],countarray[1],countarray[2]);
		countarray = appProcessBeneficiaryInfo.callAllMethodsAPBI(obj);
		try{
			Thread.sleep(3000);
		} catch(Exception e){
			
		}*/
		/*AppProcessOwnershipInfo appProcessOwnershipInfo = new AppProcessOwnershipInfo(countarray[0],countarray[1],countarray[2]);
		countarray = appProcessOwnershipInfo.callAllMethodsAPOI(obj);*/
		
		try{
			Thread.sleep(3000);
		} catch(Exception e){
			
		}
		/*AppProcessOtherInsurances appProcessOtherInsurances = new AppProcessOtherInsurances(countarray[0],countarray[1],countarray[2]);
		countarray = appProcessOtherInsurances.callAllMethodsAPOIn(obj);
		try{
			Thread.sleep(3000);
		} catch(Exception e){
			
		}*/
		/*AppProcessReplacement appProcessReplacement = new AppProcessReplacement(countarray[0],countarray[1],countarray[2]);
		countarray = appProcessReplacement.callAllMethodsAPR(obj);
		try{
			Thread.sleep(3000);
		} catch(Exception e){
			
		}*/
		/*AppProcessMedicalInfo appProcessMedicalInfo = new AppProcessMedicalInfo(countarray[0],countarray[1],countarray[2]);
		countarray = appProcessMedicalInfo.callAllMethodsAPMI(obj);
		try{
			Thread.sleep(3000);
		} catch(Exception e){
			
		}*/
		/*AppProcessConsent appProcessConsent = new AppProcessConsent(countarray[0],countarray[1],countarray[2]);
		countarray = appProcessConsent.callAllMethodsAPC(obj);
		try{
			Thread.sleep(3000);
		} catch(Exception e){
			
		}
		AppProcessPaymentInfo appProcessPaymentInfo = new AppProcessPaymentInfo(countarray[0],countarray[1],countarray[2]);
		countarray = appProcessPaymentInfo.callAllMethodsAPPAYI(obj);
		try{
			Thread.sleep(3000);
		} catch(Exception e){
			
		}
		
		ConfirmationPage confirmationPage 
		= new ConfirmationPage(countarray[0],countarray[1],countarray[2]);
		countarray = confirmationPage.callAllMethodsCP(obj);
		try{
			Thread.sleep(3000);
		} catch(Exception e){
			
		}*/
		
		
		/*ConditionalReceipt conditionalReceipt = new ConditionalReceipt(countarray[0],countarray[1],countarray[2]);
		countarray = conditionalReceipt.callAllMethodsCR(obj);
		*/
		try{
			Thread.sleep(3000);
		} catch(Exception e){
			
		}
		PackageDelivery packageDelivery = new PackageDelivery(countarray[0],countarray[1],countarray[2]);
		countarray = packageDelivery.callAllMethodsPD(obj);
		try{
			Thread.sleep(3000);
		} catch(Exception e){
			
		}
		
		Demo demo = new Demo(countarray[0],countarray[1],countarray[2]);
		countarray = demo.callAllMethodsDemo(obj);
		
		try
		{
			Thread.sleep(3000);
		} catch(Exception e)
		{
			
		}
		
		date = new Date();
		 sdf = new SimpleDateFormat("MMM-dd-yyyy h:mm:ss a");
		 formattedDate = sdf.format(date);
		System.out.println("***********************************************************");
		System.out.println("*\tTest Summary");
		System.out.println("*\tTest Completion Time: " +formattedDate);
		System.out.println("*\tNum of Tests:"+ countarray[0]);
		System.out.println("*\tNum of PASSED Tests:"+ countarray[1]);
		System.out.println("*\tNum of FAILED Tests:"+ countarray[2]);
		System.out.println("***********************************************************");
	}

}
