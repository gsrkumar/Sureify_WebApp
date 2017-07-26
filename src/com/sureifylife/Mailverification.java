package com.sureifylife;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;


public class Mailverification {
	WebDriver driver = null;
	WebDriverWait wait = null;
	
	public  Mailverification(WebDriver driver){
	   /* driver = new FirefoxDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);*/
		this.driver = driver;
		wait = new WebDriverWait(driver, 60);
		driver.navigate().to("https://accounts.google.com/ServiceLogin");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Reporter.log("\tStatus::Passed lanch Mail");
	}
	
	
	public void login(String uname,String pwd) throws InterruptedException{
		Reporter.log("\tTitle Login into Gmail",true);
		driver.findElement(By.xpath("//input[@id = 'Email']")).sendKeys(uname);;
		driver.findElement(By.xpath("//input[@id = 'next']")).click();
		Thread.sleep(3000);
		try{
		     if(driver.findElement(By.xpath("//input[@id = 'Passwd']")).isDisplayed()){
			    Reporter.log("\tStatus::Passed valid User Name :"+uname,true);
			    driver.findElement(By.xpath("//input[@id = 'Passwd']")).sendKeys(pwd);
			    driver.findElement(By.xpath("//input[@id = 'signIn']")).click();
			    Thread.sleep(5000);
			    if(driver.findElement(By.xpath(".//*[@id='gbwa']/div[1]/a")).isDisplayed()){
			    	Reporter.log("\tStatus::Passed valid Password :"+pwd,true);
			    	
			    	driver.findElement(By.xpath(".//*[@id='gbwa']/div[1]/a")).click();
			    	Thread.sleep(3000);
			    	driver.findElement(By.xpath(".//*[@id='gb23']/span[1]")).click();
			    	Thread.sleep(7000);
			    	
			    }else{
			    	Reporter.log("\tStatus::Failed Invalid Password :"+pwd,true);
			    }
		     }
			
		}catch (Exception e) {
			Reporter.log("\tStatus::Failed Invalid User Name :"+uname,true);
		}
	}
	
	
	public void filterUnreadMails() throws InterruptedException{
		WebElement sel = driver.findElement(By.xpath("//div[@class = 'aio UKr6le']"));
		(new Actions(driver)).moveToElement(sel).perform();
		WebElement unread = driver.findElement(By.xpath("//img[@class = 'afM']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", unread);
		Thread.sleep(2000);
		(new Actions(driver)).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER).perform();
	}
	
	
	public void clickLink() throws InterruptedException{
		
		WebElement table = driver.findElement(By.xpath("//table[@class = 'F cf zt']/tbody"));
		//wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div/div[4]/div[2]/div[2]/div/table/tbody"))));
		//WebElement table = driver.findElement(By.xpath("html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div/div[4]/div[2]/div[2]/div/table/tbody"));
		java.util.List<WebElement> rows = table.findElements(By.tagName("tr"));
    	//System.out.println("No of rows :"+rows.size());
    	int i=0;
    	while(i<rows.size()){
    		java.util.List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
    		String text = cols.get(5).getText();
    		if(text.contains("Verify your email address")){
    			System.out.println(text);
    			cols.get(5).click();
    			Thread.sleep(5000);   			
    			break;
    		}else{
    			i +=1;
    		}
    	}
    	
    	getAlllinks(); 
	}

    public void getAlllinks(){
        List<WebElement> maillinks = new  ArrayList<WebElement>();
    	List<WebElement> alllinks = driver.findElements(By.tagName("a"));
    	for(int i =0 ;i<alllinks.size();i++){
    		String linktext = alllinks.get(i).getText();
    		if(linktext.contains("https://sureifylife.com/quote/")){
    			maillinks.add(alllinks.get(i));
    		}else{
    			//System.out.println(linktext);
    		}
    	}
    	try{
    	   (new Actions(driver)).moveToElement(maillinks.get(maillinks.size()-1)).click().perform();
    	}catch(ArrayIndexOutOfBoundsException ai){
    		Reporter.log("\tStatus :: Failed Email not Found",true);
    	}catch (Exception e) {
		    e.printStackTrace();
		}
    }
}
