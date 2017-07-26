
package com.sureifylife;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Confirmation 
{
	public int passcount = 0;
	public int failcount = 0; 
	public static String url = "https://stg.sureify.com/login/";
	public static String url_before_test;
	public static String url_after_test;
	
	public static void main(String[] args) 
		{
		//LaunchApp launchapp = new LaunchApp();
		//Confirmation confirmation = new confirmation();
		WebDriver obj = new FirefoxDriver();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMM-dd-yyyy h:mm:ss a");
		String formattedDate = sdf.format(date);
	  
		System.out.println("***********************************************************");
		System.out.println("*\tSelenium Automation Testing Log");
		System.out.println("*\tApplication : Sureify Beta");
		System.out.println("*\tExecution Start Time: " +formattedDate);
		System.out.println("*\tBuild Number: Not Available");
		System.out.println("***********************************************************");
		
		}

}
