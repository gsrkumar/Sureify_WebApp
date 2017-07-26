package com.sureifylife;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import services.RiseException;




public class AppProcessConsent {
	
	WebDriver driver = null;
	WebDriverWait wait = null;
	JavascriptExecutor js = null;
	
	
	public AppProcessConsent(WebDriver driver){
         
		this.driver = driver;
		wait = new WebDriverWait(driver, 130);
		js = (JavascriptExecutor)driver;
	}
	
	public boolean clickToEsign() throws RiseException, InterruptedException
	{
	        boolean res;
			Reporter.log("\tTitle: Click Esign Button ",true);
			Reporter.log("\tInput: N/A");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("next_button")));
			js.executeScript("document.getElementById('next_button').scrollIntoView(false);");
			js.executeScript("$('#next_button').click();");
			Thread.sleep(3000);
			Reporter.log("\tStatus : Passed to click to Esign ",true);
			WebElement exist = driver.findElement(By.id("ok_button"));
			if(exist.isDisplayed()){
                exist.click();
                res = true;
                Reporter.log("\tStatus : You have already signed the document.",true);
			}else{
				res = false;
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hsEmbeddedWrapper")));
				WebElement consent = driver.findElement(By.id("hsEmbeddedWrapper"));
				if(!consent.isDisplayed()){
					throw new RiseException("Cosent page not displayed");
				}
			}
			
			return res;
	}
	
	public void switchToFrame() {
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("hsEmbeddedFrame"));
			//driver.switchTo().frame("hsEmbeddedFrame");
			System.out.println("Navigated to Consent page");
		} catch (NoSuchFrameException e) {
			System.out.println("Unable to locate frame "
					+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to navigate to frame"
					+ e.getStackTrace());
		}
	}
	
	
	//test
	public void clickOk() throws RiseException{
		
		Reporter.log("\tTitle : This is not legally binding, Click Ok ",true);
		
		switchToFrame();
		try{
			WebElement ok = driver.findElement(By.xpath(".//*[@id='signer-mobile-application']/div/div/div/div[3]/div[2]/button"));
			wait.until(ExpectedConditions.visibilityOf(ok));
			ok.click();
			Reporter.log("\tStatus :: Pssed to click Ok",true);
		}catch(NoSuchElementException ne){
              Reporter.log("\tStatus :: Failed to locate OK ",true);
              throw new RiseException("Failed to locate OK");
		}catch (Exception e) {
			Reporter.log("\tStatus ::Failed Exception rised ",true);
			throw new RiseException(e.getMessage());
		}

	}
	
	//test
    public void clickGetStarted() throws RiseException{
    	
    	Reporter.log("\tTitle : Get Statrted",true);
    	
    	//switchToFrame();
		try{
			WebElement getstarted = driver.findElement(By.xpath("//span[text() = 'Get Started']"));
			wait.until(ExpectedConditions.visibilityOf(getstarted));
			getstarted.click();
			Reporter.log("\tStatus :: Pssed to click GetStarted",true);
		}catch(NoSuchElementException ne){
              Reporter.log("\tStatus :: Failed to locate GetStarted ",true);
              throw new RiseException("Failed to locate GetStarted");
		}catch (Exception e) {
			Reporter.log("\tStatus ::Failed Exception rised ",true);
			throw new RiseException(e.getMessage());
		}
    	
    }
	
	//test
    public void clickNextReq() throws RiseException{
    	
    	Reporter.log("\tTitle : Click NextRequest",true);
    	
    	//switchToFrame();
    	try{
    		
			WebElement next = driver.findElement(By.xpath("//span[text() = 'Next Req*']"));
			wait.until(ExpectedConditions.visibilityOf(next));
			next.click();
			Reporter.log("\tStatus :: Passed to click NextReq",true);
			
		}catch(NoSuchElementException ne){
              Reporter.log("\tStatus :: Failed to locate NextReq ",true);
              throw new RiseException("Failed to locate NextReq");
		}catch (Exception e) {
			Reporter.log("\tStatus ::Failed Exception rised ",true);
			throw new RiseException(e.getMessage());
		}	
    	
    }
	
    //test
    public void checkFieldReq() throws RiseException{
    	
    	Reporter.log("\tTitle : Check 'This field is required' message",true);
    	
    	clickNextReq();
    	try{
    		
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'm-signer-mobile-header-alert-message']")));
			Reporter.log("\tStatus ::Passed",true);
  
    	}catch(Exception e){
    		Reporter.log("\tStatus ::Failed check error message",true);
    	}
    }
	
	//test
    public void clickToSign() throws RiseException{
    	
    	Reporter.log("\tTitle :Click to Sign",true);
    	
    	//switchToFrame();
        WebElement sign = driver.findElement(By.xpath("//span[text() = 'Click to sign']"));
        if(sign.isDisplayed()){
        	sign.click();
        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'CREATE SIGNATURE']")));
        	Reporter.log("\tStatus ::Passed",true);
        	driver.findElement(By.id("insertButton")).click();;
        }else{
        	Reporter.log("\tStatus ::Failed to display sign button",true);;
        	throw new RiseException("Failed to display sign button");
        }
     		
    }
	
    //test
    public void signatureDraw() throws InterruptedException{
    	
    	Reporter.log("\tTitle :Draw signature",true);
    	
    	WebElement draw = driver.findElement(By.xpath("//span[text() = 'Draw it in']"));
    	WebElement canvas = driver.findElement(By.id("drawSignatureCanvas"));
    	draw.click();
 
    	Actions bulder = new Actions(driver);
    	bulder.moveToElement(canvas, 300, 120).clickAndHold()    	
    	      .moveToElement(canvas,260, 120)
              .moveToElement(canvas,260, 150)
              .moveToElement(canvas,300,150)
              .moveToElement(canvas,300, 180)
              .moveToElement(canvas,260,180);
        bulder.release().build().perform();
        Thread.sleep(5000);
        driver.findElement(By.id("insertButton")).click();;
    
    }
    
    //test
    public void signatureType() throws InterruptedException{
    	
    	Reporter.log("\tTitle : Type signatuer",true);
    	
    	driver.findElement(By.xpath(".//*[@id='component_1147831397_1']/div[2]/div/div/div/div[2]/img")).click();
    	Thread.sleep(3000);
    	
    	driver.findElement(By.linkText("Edit")).click();
    	Thread.sleep(3000);;
    	
    	WebElement type = driver.findElement(By.xpath("//span[text() = 'Type it in']"));
    	type.click();
    	WebElement layer = driver.findElement(By.id("typedSignatureInput"));
    	layer.clear();
    	layer.sendKeys("kumar");
    	Thread.sleep(5000);
    	String expt = layer.getAttribute("value");
    	if(expt.equals("kumar")){
    		Reporter.log("\tStatus : Passed",true);
    		driver.findElement(By.id("insertButton")).click();;
    		Thread.sleep(3000);
    	}
    }
    
    //test
    public void signatureUploadImage() throws InterruptedException, AWTException, RiseException{
    	
    	Reporter.log("\tTitle :Upload image",true);
    	
    	driver.findElement(By.xpath(".//*[@id='component_1147831397_1']/div[2]/div/div/div/div[2]/img")).click();
    	Thread.sleep(3000);
    	
    	driver.findElement(By.linkText("Edit")).click();
    	Thread.sleep(3000);;
    	
    	WebElement up = driver.findElement(By.xpath("//span[text() = 'Upload image']"));
    	up.click();
    	
    	WebElement upload = driver.findElement(By.xpath("//span[text() = 'UPLOAD']"));
        upload.click();
        Thread.sleep(3000);
        
        Robot robot = new Robot();  // Robot class throws AWT Exception	
        Thread.sleep(2000); // Thread.sleep throws InterruptedException	
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
        
        WebElement insert =  driver.findElement(By.id("insertButton"));
        if(insert.isEnabled()){
        	Reporter.log("\tStatus ::Passed ",true);
        	insert.click();
        }else{
        	Reporter.log("\tStatus ::Failed to upload image",true);
        	throw new RiseException("upload image failed");
        }
    
    }
	
    //test
    public void clickContinue() throws InterruptedException{
    	
    	Reporter.log("\tTitle : Click to continue",true);
    	WebElement cnt = driver.findElement(By.xpath("//span[text() = 'Continue']"));
    	if(cnt.isDisplayed()){
    		cnt.click();
    		Thread.sleep(5000);
    		Reporter.log("\tStatus :: Passed",true);
    	}else{
    		Reporter.log("\tStatus :: Failed",true);
    	}
    }
    
    public void iAgree() throws InterruptedException{
    	
    	Reporter.log("\tTitle :Click to I agree",true);
    	WebElement agree = driver.findElement(By.xpath("//span[text() = 'I agree']"));
    	if(agree.isDisplayed()){
    		agree.click();
    		Thread.sleep(7000);
    		if(driver.findElement(By.xpath("//span[text() = 'Close']")).isDisplayed());{
    		   Reporter.log("\tStatus ::Passed",true);
    		}
    	}else{
    		Reporter.log("\tStatus ::Faile",true);
    	}
    }
    
    public void clickClose() throws InterruptedException{
    
    	Reporter.log("\tTitle :Click to close",true);
    	WebElement close = driver.findElement(By.xpath("//span[text() = 'Close']"));
    	if(close.isDisplayed()){
    		close.click();
    		Thread.sleep(7000);
    		driver.switchTo().defaultContent();
    		(new WebDriverWait(driver, 30)).until(ExpectedConditions.attributeToBe(By.xpath("//li[@id = '9']"), "class","active"));
    		Reporter.log("\tStatus ::Passed",true);
    	}else{
    		Reporter.log("\tStatus ::Failed",true);
    	}
    }
    
    
}
