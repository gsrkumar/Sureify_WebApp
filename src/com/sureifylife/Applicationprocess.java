package com.sureifylife;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Applicationprocess 
{
	public static int Totaltests = 1;
	public static int Passcount = 0;
	public static int Failcount = 0;
	
	public static void main(String[] args) throws InterruptedException 
		{
			WebDriver obj = new FirefoxDriver();
			obj.get("https://stg.sureify.com/home/appprocess");
			
			obj.manage().window().maximize();
			pwd(obj);
		}
	
	public static void  pwd( WebDriver obj) throws InterruptedException
	{
		Totaltests++;
		System.out.println("\nTest " + Totaltests);
		System.out.println("\tTitle: Input data to create password field ");
		System.out.println("\tInput: swathi@145" );
		if(obj.findElement(By.id("user_pwd")).isDisplayed())
			
		{
			obj.findElement(By.id("user_pwd")).sendKeys("swathi@145");
			System.out.println("\tStatus: Data entered in create password field" );
			
		}
	}
}
