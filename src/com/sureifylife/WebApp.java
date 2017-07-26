package com.sureifylife;

import java.awt.AWTException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import services.Browser;
import services.RiseException;
import services.URLClass;
/**
 * 
 * @author Suresh
 * 
 */
public class WebApp {
  WebDriver driver = null;	
  JavascriptExecutor js = null;
  WebDriverWait wait = null;
  
  LaunchApp lanchapp =  null; 
  BasicInfo basicinfo = null;
  Mailverification mail = null;
  
  AppProcessCreateAcount ca = null;
  AppProcessPersonalInfo pi = null;
  AppProcessBeneficiaryInfo bi = null;
  AppProcessOwnershipInfo oi = null;
  AppProcessOtherInsurances ori = null;
  AppProcessReplacement rp = null;
  AppProcessMedicalInfo mi = null;
  AppProcessConsent cons = null;
  AppProcessPaymentInfo ptm = null;
  ConfirmationPage cp  = null;
  ConditionalReceipt crp = null;
  ConfirmAddress cadd = null;
  
  
  boolean skiptest = false;
  
  @Parameters({"browsername","environment"})
  @Test(groups = {"smoketest" , "regressiontest"},priority = 0)
  public void setUp(@Optional ("firefox") String browsername,@Optional ("staging") String environment) {
	 driver = Browser.getBrowser(browsername);
	 wait = new WebDriverWait(driver, 20);
	 try{
	     driver.get(URLClass.getUrl(environment));                      
	     driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);		
         Reporter.log("Status: " + URLClass.getUrl(environment) + " Launched",true);
	 }catch(NullPointerException ne){
		 Reporter.log("Environment is Incorrect",true ); 
	 }catch (Exception e) {
		 Reporter.log("Environment is Incorrect",true ); 
	 }   
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"setUp"},priority = 0)
  public void lanchApp() throws InterruptedException{
     lanchapp = new LaunchApp(driver);
     Thread.sleep(3000);
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"lanchApp"},priority = 1)
  public void lifeInsurance() throws InterruptedException{
	  Reporter.log("TEST NO : 1",true); 
	  lanchapp.lifeinsurance();   
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"lanchApp"}, priority = 2)
  public void learnMore() throws InterruptedException{
	  Reporter.log("TEST NO : 2",true); 
	  lanchapp.learnmore();   
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"lanchApp"}, priority = 3)
  public void trySureify() throws InterruptedException{
	  Reporter.log("TEST NO : 3",true);
	  lanchapp.trysureify();   
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"lanchApp"}, priority = 4)
  public void startSaving() throws InterruptedException{
	  Reporter.log("TEST NO : 4",true);
	  lanchapp.startsaving();   
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"lanchApp"}, priority = 5)
  public void getRate() throws InterruptedException{
	  Reporter.log("TEST NO : 5",true);
	  lanchapp.getrate();   
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"lanchApp"}, priority = 6)
  public void getStarted() throws InterruptedException{
	  Reporter.log("TEST NO : 6",true);
	  lanchapp.getstarted();   
  }
  

  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"lanchApp"}, priority = 7)
  public void getaQuote() throws InterruptedException{
	  Reporter.log("TEST NO : 7",true);
	  lanchapp.getaquote();   
  }

  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"lanchApp"}, priority = 8)
  public void savings() throws InterruptedException{
	  Reporter.log("TEST NO : 8",true);
	  lanchapp.savings();   
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"lanchApp"}, priority = 9)
  public void learnMore_Savings() throws InterruptedException{
	  Reporter.log("TEST NO : 9",true);
	  lanchapp.learnmore_savings();   
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"lanchApp"}, priority = 10)
  public void getAquote_Savings() throws InterruptedException{
	  Reporter.log("TEST NO : 10",true);
	  lanchapp.getaquote_savings();   
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"lanchApp"}, priority = 11)
  public void pro_Savings() throws InterruptedException{
	  Reporter.log("TEST NO : 11",true);
	  lanchapp.pro_savings();   
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"lanchApp"}, priority = 12)
  public void planComparision_Savings() throws InterruptedException{
	  Reporter.log("TEST NO : 12",true);
	  lanchapp.plancomparision_savings();   
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"lanchApp"}, priority = 13)
  public void clogo() throws InterruptedException{
	  Reporter.log("TEST NO : 13",true);
	  lanchapp.clogo();   
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"lanchApp"}, priority = 14)
  public void devices() throws InterruptedException{
	  Reporter.log("TEST NO : 14",true);
	  lanchapp.devices();   
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"lanchApp"}, priority = 15)
  public void learnMore_Devices() throws InterruptedException{
	  Reporter.log("TEST NO : 15",true);
	  lanchapp.learnmore_devices();   
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"lanchApp"}, priority = 16)
  public void getAquote_Devices() throws InterruptedException{
	  Reporter.log("TEST NO : 16",true);
	  lanchapp.getaquote_devices();   
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"lanchApp"}, priority = 17)
  public void pro_devices() throws InterruptedException{
	  Reporter.log("TEST NO : 17",true);
	  lanchapp.pro_devices();   
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"lanchApp"}, priority = 18)
  public void dlogo() throws InterruptedException{
	  Reporter.log("TEST NO : 18",true);
	  lanchapp.dlogo();   
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"lanchApp"}, priority = 19)
  public void blog() throws InterruptedException{
	  Reporter.log("TEST NO : 19",true);
	  lanchapp.blog();   
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"lanchApp"}, priority = 20)
  public void blogo() throws InterruptedException{
	  Reporter.log("TEST NO : 20",true);
	  lanchapp.blogo();   
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"lanchApp"}, priority = 21)
  public void getQuotebutton2() throws InterruptedException{
	  Reporter.log("TEST NO : 21",true);
	  lanchapp.getQuotebutton2();   
  }
  
  /*
   * Basic info page 
   */
     
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"lanchApp","getQuotebutton2"},priority = 22)
  public void BasicInfo(){
	  Reporter.log("TEST NO : 22",true);
	  Reporter.log("\tTITLE : Entering Into Basicinfo Quote Page",true);
	  driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.SECONDS);
	  basicinfo = new BasicInfo(driver);
	  String expt = driver.getCurrentUrl();
	  if(expt.contains("getQuotev4")){
		  Reporter.log("\tSTATUS : Enterend into Basicinfo Quote Page",true);
		  Reporter.log("\tTEST : Passed",true);
	  }else{
		  Reporter.log("\tSTATUS : Not Enterend into Basicinfo Quote Page",true);
		  Reporter.log("\tTEST : Failed",true);
	  }
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = "BasicInfo", priority = 23)
  public void zipcodeInfo() throws InterruptedException{
	  Reporter.log("TEST NO : 23",true);
	  basicinfo.zipcodeInfo();
  }

  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = "BasicInfo", priority = 24)
  public void invalidzipcode() throws InterruptedException{
	  Reporter.log("TEST NO : 24",true);
	  basicinfo.invalidzipcode();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = "BasicInfo", priority = 25)
  public void validzipcode() throws InterruptedException{
	  Reporter.log("TEST NO : 25",true);
	  basicinfo.validzipcode();  
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = "BasicInfo", priority = 26)
  public void faceAmountInfo() throws InterruptedException{
	Reporter.log("TEST NO : 26",true);
	basicinfo.faceamountInfo();  
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = "BasicInfo", priority = 27)
  public void chooseFaceAmount() throws InterruptedException{
	Reporter.log("TEST NO : 27",true);  
	basicinfo.choosefaceamount();  
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = "BasicInfo", priority = 28)
  public void durationInfo() throws InterruptedException{
	 Reporter.log("TEST NO : 28",true);
	 basicinfo.durationInfo();  
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = "BasicInfo", priority = 29)
  public void chooseDuration() throws InterruptedException{
	Reporter.log("TEST NO : 29",true);  
	basicinfo.chooseDuration();  
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = "BasicInfo", priority = 30)
  public void genderInfo() throws InterruptedException{
	Reporter.log("TEST NO : 30",true);  
	basicinfo.genderInfo();  
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = "BasicInfo", priority = 31)
  public void chooseGender() throws InterruptedException{
	Reporter.log("TEST NO : 31",true);  
	basicinfo.chooseGender();  
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = "BasicInfo", priority = 32)
  public void ageInfo() throws InterruptedException{
	Reporter.log("TEST NO : 32",true);
	basicinfo.ageInfo();  
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = "BasicInfo", priority = 33)
  public void chooseAge() throws InterruptedException{
	Reporter.log("TEST NO : 33",true);  
	basicinfo.chooseAge();  
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = "BasicInfo", priority = 34)
  public void smokeInfo() throws InterruptedException{
	Reporter.log("TEST NO : 34",true);
	basicinfo.smokeInfo();  
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = "BasicInfo", priority = 35)
  public void chooseSmoke() throws InterruptedException{
	Reporter.log("TEST NO : 35",true);  
	basicinfo.chooseSmoke();  
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = "BasicInfo", priority = 36)
  public void healthInfo() throws InterruptedException{
	Reporter.log("TEST NO : 36",true);  
	basicinfo.healthInfo();  
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = "BasicInfo", priority = 37)
  public void chooseHealth() throws InterruptedException{
	Reporter.log("TEST NO : 37",true);  
	basicinfo.chooseHealth();  
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = "BasicInfo", priority = 38)
  public void invalidName() throws InterruptedException{
	Reporter.log("TEST NO : 38",true);  
	basicinfo.invalidName();  
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = "BasicInfo", priority = 39)
  public void validName() throws InterruptedException{
	Reporter.log("TEST NO : 39",true);  
	basicinfo.validName();  
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = "BasicInfo", priority = 40)
  public void invalidEmail() throws InterruptedException{
	Reporter.log("TEST NO : 40",true);  
	basicinfo.invalidEmail();  
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = "BasicInfo", priority = 41)
  public void validEmail() throws InterruptedException{
	Reporter.log("TEST NO : 41",true);
	basicinfo.validEmail();  
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = "BasicInfo", priority = 42)
  public void getCaptcha() throws InterruptedException{
	Reporter.log("TEST NO : 42",true);
	basicinfo.getCapcha();  
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = "BasicInfo", priority = 43)
  public void getquoteButton() throws InterruptedException{
	Reporter.log("TEST NO : 43",true);
	basicinfo.getquoteButton();  
  }
  
  //
  // Quote Page
  //
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"BasicInfo","getquoteButton"}, priority = 44)
  public void verifyAmountAndDuration() throws InterruptedException{
	Reporter.log("TEST NO : 44",true);
	basicinfo.verifyAmountAndDuration();  
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"BasicInfo","getquoteButton"}, priority = 45)
  public void checkFitBitDevices() throws InterruptedException{
	Reporter.log("TEST NO : 45",true);
	basicinfo.checkFitBitDevices();  
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"BasicInfo","getquoteButton"}, priority = 46)
  public void clickCvrgAmountQst() throws InterruptedException{
	Reporter.log("TEST NO : 46",true);
	basicinfo.clickCvrgAmountQst();  
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"BasicInfo","getquoteButton"}, priority = 47)
  public void clickCvrgDurationQst() throws InterruptedException{
	Reporter.log("TEST NO : 47",true);
	basicinfo.clickCvrgDurationQst();  
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"BasicInfo","getquoteButton"}, priority = 48)
  public void clickPriceQst() throws InterruptedException{
	Reporter.log("TEST NO : 48",true);
	basicinfo.clickPriceQst();  
  }
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"BasicInfo","getquoteButton"}, priority = 49)
  public void selectQuote() throws InterruptedException{
	Reporter.log("TEST NO : 49",true);
	basicinfo.selectQuote();  
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"BasicInfo","getquoteButton"}, priority = 50)
  public void confirmApply() throws InterruptedException, RiseException{
	Reporter.log("TEST NO : 50",true);
	basicinfo.confirmApply();  
  }
 
  //
  // Confirm And Apply
  //
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"confirmApply"}, priority = 51)
  public void checkNewMonthlyPremium() throws InterruptedException{
	Reporter.log("TEST NO : 51",true);
	basicinfo.checkNewMonthlyPremium();  
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"confirmApply"}, priority = 52)
  public void checkNewYearlyPremium() throws InterruptedException{
	Reporter.log("TEST NO : 52",true);
	basicinfo.checkNewYearlyPremium();  
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"confirmApply"}, priority = 53)
  public void checkNewCoverageAmount() throws InterruptedException{
	Reporter.log("TEST NO : 53",true);
	basicinfo.checkNewCoverageAmount();  
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"confirmApply"}, priority = 54)
  public void checkNewDuration() throws InterruptedException{
	Reporter.log("TEST NO : 54",true);
	basicinfo.checkNewDuration();  
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"confirmApply"}, priority = 55)
  public void CBasicinfo() throws InterruptedException{
	Reporter.log("TEST NO : 55",true);
	basicinfo.CBasicinfo(); 
	basicinfo.getquotebutton1();
	basicinfo.confirmApply1();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"confirmApply"}, priority = 56)
  public void getQuoteInfo() throws InterruptedException{
	Reporter.log("TEST NO : 56",true);
	basicinfo.getQuoteInfo();
	Thread.sleep(3000);
	basicinfo.confirmapply2(); 
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"confirmApply"}, priority = 57)
  public void checkFitbitDeviceVisible() throws InterruptedException{
	Reporter.log("TEST NO : 57",true);
	basicinfo.checkFitbitDeviceVisible();
	 
  }
  
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"confirmApply"}, priority = 58)
  public void buyNow() throws InterruptedException{
	Reporter.log("TEST NO : 58",true);
	basicinfo.buyNow(); 
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"confirmApply"}, priority = 59)
  public void bannerText() throws InterruptedException{
	Reporter.log("TEST NO : 59",true);
	basicinfo.bannerText(); 
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"confirmApply"}, priority = 60)
  public void checkResend_link_btn() throws InterruptedException{
	Reporter.log("TEST NO : 60",true);
	basicinfo.checkResend_link_btn(); 
  }
  
  //
  // mail link click
  //
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"buyNow"},priority = 61)
  public void lanchGmail() throws InterruptedException{
	  Reporter.log("TEST NO : 61",true);
	  Reporter.log("\tTitle Lanch Gamil",true);
	  Thread.sleep(5000);
	  mail = new Mailverification(driver);
  }
  
  @Parameters({"uname","pwd"})
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"lanchGmail"},priority = 62)
  public void mailLogin(@Optional ("suresh@sureify.com") String uname,@Optional ("suresh@sureify") String pwd) throws InterruptedException{
	  Reporter.log("TEST NO : 62",true);
	  mail.login(uname, pwd);
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"mailLogin"},priority = 63)
  public void clickLink() throws InterruptedException{
	  
	  Reporter.log("TEST NO : 63",true);
	  Reporter.log("\tTitle Click link redirect to AppProcessCreateAcount Page",true);
	  mail.filterUnreadMails();
	  mail.clickLink();
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  
	  String currentwindow = driver.getWindowHandle();
	  //System.out.println("current window :"+currentwindow);
	  Set<String> handle = driver.getWindowHandles();
	  // System.out.println("No of handles :"+handle.size());
	  handle.remove(currentwindow);
	  Iterator<String> it = handle.iterator();
	  while(it.hasNext()){
		  String child = it.next();
		  //System.out.println(child);
		  if(!child.equals(currentwindow)){
			  
			 driver.switchTo().window(child);
			 driver.manage().window().maximize();
			 String url = driver.getCurrentUrl();
			 if(url.contains("home/appprocess")){
				 Reporter.log("\tStatus::Passed Controller redirect to Appprocess",true);
			 }else{
				 Reporter.log("\tStatus::Failed Controller not redirect to Appprocess",true);

			 }
		  }
	  }
	  
  }
  
  //
  // App process Create Account
  //
  //
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"clickLink"},priority = 64)
  public void createAccountInstance(){
	Reporter.log("TEST NO : 64",true);  
	ca = new AppProcessCreateAcount(driver); 
	Reporter.log("\tCreate instance for Create Account",true);
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"createAccountInstance"},priority = 65)
  public void verifyUserName(){
	  Reporter.log("TEST NO : 65",true);
	  ca.verifyUserName();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"createAccountInstance"},priority = 66)
  public void verifyEmailAddress(){
	  Reporter.log("TEST NO : 66",true);
	  ca.verifyEmailAddress();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"createAccountInstance"},priority = 67)
  public void invalidPasswordData() throws InterruptedException{
	  Reporter.log("TEST NO : 67",true);
	  ca.invalidPasswordData();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"createAccountInstance"},priority = 68)
  public void validPassword() throws InterruptedException{
	  Reporter.log("TEST NO : 68",true);
	  ca.validPassword();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"createAccountInstance"},priority = 69)
  public void invalidConfirmPasswordData() throws InterruptedException{
	  Reporter.log("TEST NO : 69",true);
	  ca.invalidConfirmPasswordData();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"createAccountInstance"},priority = 70)
  public void validConfirmPassword() throws InterruptedException{
	  Reporter.log("TEST NO : 70",true);
	  ca.validConfirmPassword();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"createAccountInstance"},priority = 71)
  public void verifyShowAndHidePassword() throws InterruptedException{
	  Reporter.log("TEST NO : 71",true);
	  ca.verifyShowAndHidePassword();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"createAccountInstance"},priority = 72)
  public void captcha() throws InterruptedException{
	  Reporter.log("TEST NO : 72",true);
	  ca.captcha();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"createAccountInstance"},priority = 73)
  public void clickCreat() throws InterruptedException{
	  Reporter.log("TEST NO : 73",true);
	  ca.clickCreat();
  }
  
  //
  //
  // Personal Info
  //
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"clickCreat"},priority = 74)
  public void personalInfo() throws InterruptedException{
	  Reporter.log("TEST NO : 74",true);
	  Reporter.log("\tCreate instance for personalinfo ",true);
	  pi = new AppProcessPersonalInfo(driver);
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"personalInfo"},priority = 75)
  public void invalidFirstName() throws InterruptedException{
	  Reporter.log("TEST NO : 75",true);
	  pi.invalidFirstName();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"personalInfo"},priority = 76)
  public void validFirstName() throws InterruptedException{
	  Reporter.log("TEST NO : 76",true);
	  pi.validFirstName();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"personalInfo"},priority = 77)
  public void invalidMiddleName() throws InterruptedException{
	  Reporter.log("TEST NO : 77",true);
	  pi.invalidMiddleName();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"personalInfo"},priority = 78)
  public void validMiddleName() throws InterruptedException{
	  Reporter.log("TEST NO : 78",true);
	  pi.validMiddleName();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"personalInfo"},priority = 79)
  public void invalidLastName() throws InterruptedException{
	  Reporter.log("TEST NO : 79",true);
	  pi.invalidLastName();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"personalInfo"},priority = 80)
  public void validLastName() throws InterruptedException{
	  Reporter.log("TEST NO : 80",true);
	  pi.validLastName();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"personalInfo"},priority = 81)
  public void chooseBirth() throws InterruptedException{
	  Reporter.log("TEST NO : 81",true);
	  pi.chooseBirth();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"personalInfo"},priority = 82)
  public void choosGender() throws InterruptedException{
	  Reporter.log("TEST NO : 82",true);
	  pi.chooseGender();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"personalInfo"},priority = 83)
  public void selectHeight() throws InterruptedException{
	  Reporter.log("TEST NO : 83",true);
	  pi.selectHeight();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"personalInfo"},priority = 84)
  public void InvalidWeight() throws InterruptedException{
	  Reporter.log("TEST NO : 84",true);
	  pi.InvalidWeight();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"personalInfo"},priority = 85)
  public void validWeight() throws InterruptedException{
	  Reporter.log("TEST NO : 85",true);
	  pi.validWeight();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"personalInfo"},priority = 86)
  public void invalidSSN() throws InterruptedException{
	  Reporter.log("TEST NO : 86",true);
	  pi.invalidSSN();
  }
  
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"personalInfo"},priority = 87)
  public void validSSN() throws InterruptedException{
	  Reporter.log("TEST NO : 87",true);
	  pi.validSSN();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"personalInfo"},priority = 88)
  public void notInUs() throws InterruptedException{
	  Reporter.log("TEST NO : 88",true);
	  pi.notInUs();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"personalInfo"},priority = 89)
  public void selectState() throws InterruptedException{
	  Reporter.log("TEST NO : 89",true);
	  pi.selectState();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"personalInfo"},priority = 90)
  public void inavalidAddress1() throws InterruptedException{
	  Reporter.log("TEST NO : 90",true);
	  pi.inavalidAddress1();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"personalInfo"},priority = 91)
  public void validAddress1() throws InterruptedException{
	  Reporter.log("TEST NO : 91",true);
	  pi.validAddress1();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"personalInfo"},priority = 92)
  public void enterAddress2() throws InterruptedException{
	  Reporter.log("TEST NO : 92",true);
	  pi.enterAddress2();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"personalInfo"},priority = 93)
  public void inValidCity() throws InterruptedException{
	  Reporter.log("TEST NO : 93",true);
	  pi.inavalidCity();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"personalInfo"},priority = 94)
  public void validCity() throws InterruptedException{
	  Reporter.log("TEST NO : 94",true);
	  pi.validCity();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"personalInfo"},priority = 95)
  public void selectUserState() throws InterruptedException{
	  Reporter.log("TEST NO : 95",true);
	  pi.selectUserState();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"personalInfo"},priority = 96)
  public void invalidZipCode() throws InterruptedException{
	  Reporter.log("TEST NO : 96",true);
	  pi.invalidZipCode();
  }  
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"personalInfo"},priority = 97)
  public void validZipCode() throws InterruptedException{
	  Reporter.log("TEST NO : 97",true);
	  pi.validZipCode();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"personalInfo"},priority = 98)
  public void invalidCellNumber() throws InterruptedException{
	  Reporter.log("TEST NO : 98",true);
	  pi.invalidCellNumber();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"personalInfo"},priority = 99)
  public void validCellNumber() throws InterruptedException{
	  Reporter.log("TEST NO : 98",true);
	  pi.validCellNumber();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"personalInfo"},priority = 100)
  public void invalidWorkNumber() throws InterruptedException{
	  Reporter.log("TEST NO : 100",true);
	  pi.invalidWorkNumber();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"personalInfo"},priority = 101)
  public void validWorkNumber() throws InterruptedException{
	  Reporter.log("TEST NO : 101",true);
	  pi.validWorkNumber();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"personalInfo"},priority = 102)
  public void invalidHomeNumber() throws InterruptedException{
	  Reporter.log("TEST NO : 102",true);
	  pi.invalidHomeNumber();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"personalInfo"},priority = 103)
  public void validHomeNumber() throws InterruptedException{
	  Reporter.log("TEST NO : 103",true);
	  pi.validHomeNumber();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"personalInfo"},priority = 104)
  public void invalidLicenseNumber() throws InterruptedException{
	  Reporter.log("TEST NO : 104",true);
	  pi.invalidLicenseNumber();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"personalInfo"},priority = 105)
  public void validLicenseNumber() throws InterruptedException{
	  Reporter.log("TEST NO : 105",true);
	  pi.validLicenseNumber();
  }
  
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"personalInfo"},priority = 106)
  public void driverState() throws InterruptedException{
	  Reporter.log("TEST NO : 106",true);
	  pi.driverState();
  }
  

  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"personalInfo"},priority = 107)
  public void invalidOccupation() throws InterruptedException{
	  Reporter.log("TEST NO : 107",true);
	  pi.invalidOccupation();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"personalInfo"},priority = 108)
  public void validOccupation() throws InterruptedException{
	  Reporter.log("TEST NO : 108",true);
	  pi.validOccupation();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"personalInfo"},priority = 109)
  public void invalidWorkZip() throws InterruptedException{
	  Reporter.log("TEST NO : 109",true);
	  pi.invalidWorkZip();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"personalInfo"},priority = 110)
  public void validWorkZip() throws InterruptedException{
	  Reporter.log("TEST NO : 110",true);
	  pi.validWorkZip();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"personalInfo"},priority = 111)
  public void clickNextInPersonalINfo()throws InterruptedException{
	  Reporter.log("TEST NO : 111",true);
	  pi.click_Next_InPersonalInfo();
  }
  
  //
  // Benificiary Info
  //
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"clickNextInPersonalINfo"},priority = 112)
  public void BeneficiaryInfo()throws InterruptedException{
	  Reporter.log("TEST NO : 112",true);
	  Reporter.log("\tCreate Instance for Benificiary Info ",true);
	  bi = new AppProcessBeneficiaryInfo(driver);
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"BeneficiaryInfo"},priority = 113)
  public void invalidPrimaryBenName()throws InterruptedException{
	  Reporter.log("TEST NO : 113",true);
	  bi.invalidPrimaryBenName();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"BeneficiaryInfo"},priority = 114)
  public void validPrimaryBenName()throws InterruptedException{
	  Reporter.log("TEST NO : 114",true);
	  bi.validPrimaryBenName();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"BeneficiaryInfo"},priority = 115)
  public void InvalidPrimaryRelationName()throws InterruptedException{
	  Reporter.log("TEST NO : 115",true);
	  bi.InvalidPrimaryRelationName();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"BeneficiaryInfo"},priority = 116)
  public void validPrimaryRelationName()throws InterruptedException{
	  Reporter.log("TEST NO : 116",true);
	  bi.validPrimaryRelationName();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"BeneficiaryInfo"},priority = 117)
  public void addPrimaryBenficiary()throws InterruptedException{
	  Reporter.log("TEST NO : 117",true);
	  bi.addPrimaryBenficiary();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"BeneficiaryInfo"},priority = 118)
  public void addPercentagePrimaryBenf()throws InterruptedException{
	  Reporter.log("TEST NO : 118",true);
	  bi.addPercentagePrimaryBenf();
  } 
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"BeneficiaryInfo"},priority = 119)
  public void removePrimaryBenficiary()throws InterruptedException{
	  Reporter.log("TEST NO : 119",true);
	  bi.removePrimaryBenficiary();
  } 
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"BeneficiaryInfo"},priority = 120)
  public void InvalidPrimaryBenfPer()throws InterruptedException{
	  Reporter.log("TEST NO : 120",true);
	  bi.InvalidPrimaryBenfPer();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"BeneficiaryInfo"},priority = 121)
  public void validPrimaryBenfPer()throws InterruptedException{
	  Reporter.log("TEST NO : 121",true);
	  bi.validPrimaryBenfPer();
  }
  
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"BeneficiaryInfo"},priority = 122)
  public void invalidContingentBenfName()throws InterruptedException{
	  Reporter.log("TEST NO : 122",true);
	  bi.invalidContingentBenfName();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"BeneficiaryInfo"},priority = 123)
  public void validContingentBenfName()throws InterruptedException{
	  Reporter.log("TEST NO : 123",true);
	  bi.validContingentBenfName();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"BeneficiaryInfo"},priority = 124)
  public void invalidContingentRelationName()throws InterruptedException{
	  Reporter.log("TEST NO : 124",true);
	  bi.invalidContingentRelationName();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"BeneficiaryInfo"},priority = 125)
  public void validContingentRelationName()throws InterruptedException{
	  Reporter.log("TEST NO : 125",true);
	  bi.validContingentRelationName();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"BeneficiaryInfo"},priority = 126)
  public void addContingentBenficiary()throws InterruptedException{
	  Reporter.log("TEST NO : 126",true);
	  bi.addContingentBenficiary();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"BeneficiaryInfo"},priority = 127)
  public void addPercentageContingentBenf()throws InterruptedException{
	  Reporter.log("TEST NO : 127",true);
	  bi.addPercentageContingentBenf();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"BeneficiaryInfo"},priority = 128)
  public void removeContingentBenficiary()throws InterruptedException{
	  Reporter.log("TEST NO : 128",true);
	  bi.removeContingentBenficiary();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"BeneficiaryInfo"},priority = 129)
  public void invalidContingentBenfPer()throws InterruptedException{
	  Reporter.log("TEST NO : 129",true);
	  bi.invalidContingentBenfPer();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"BeneficiaryInfo"},priority = 130)
  public void validContingentBenfPer()throws InterruptedException{
	  Reporter.log("TEST NO : 130",true);
	  bi.validContingentBenfPer();
  }

  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"BeneficiaryInfo"},
		/*dependsOnMethods = {"invalidPrimaryBenName",
				             "validPrimaryRelationName",
				             "validPrimaryBenfPer",
				             "validContingentBenfName",
				             "validContingentRelationName",
				             "validContingentBenfPer"
				             },*/
		priority = 131)
  public void next()throws InterruptedException{
	  Reporter.log("TEST NO : 131",true);
	  bi.next();
  }  
  
  //
  //  Ownership Info
  // 
  //
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"next"} , priority = 132)
  public void  ownershipInfo()throws InterruptedException{
	  Reporter.log("TEST NO : 132",true);
	  oi = new AppProcessOwnershipInfo(driver);
	  Reporter.log("\tStatus :: Create Ownership info Instace",true);
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"ownershipInfo"} , priority = 133)
  public void  testFiledsWithInvalidData()throws InterruptedException{
	  Reporter.log("TEST NO : 133",true);
	  oi.testFiledsWithInvalidData();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"ownershipInfo"} , priority = 134)
  public void  select_Person_Me_Yes()throws InterruptedException{
	  Reporter.log("TEST NO : 134",true);
	  oi.select_Person_Me_Yes();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"ownershipInfo"} , priority = 135)
  public void  select_Person_somoneElse()throws InterruptedException{
	  Reporter.log("TEST NO : 135",true);
	  oi.select_Person_somoneElse();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"ownershipInfo"} , priority = 136)
  public void  trust()throws InterruptedException{
	  Reporter.log("TEST NO : 136",true);
	  oi.trust();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"ownershipInfo"} , priority = 137)
  public void  select_Person_Me_No()throws InterruptedException{
	  Reporter.log("TEST NO : 137",true);
	  oi.select_Person_Me_No();
  }
  
  //
  // Other Insurance Info
  //
  //
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"select_Person_Me_No"} , priority = 138)
  public void  otherInsurances()throws InterruptedException{
	  Reporter.log("TEST NO : 138",true);
	  Reporter.log("\tStatus :: Creating Other insurance instance",true);
	  ori = new AppProcessOtherInsurances(driver);
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"otherInsurances"} , priority = 139)
  public void  otherInsurance_Yes_Yes()throws InterruptedException{
	  Reporter.log("TEST NO : 139",true);
	  ori.otherInsurance_Yes_Yes();
  }
  
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"otherInsurances"} , priority = 140)
  public void  otherInsurance_Yes_No()throws InterruptedException{
	  Reporter.log("TEST NO : 140",true);
	  ori.otherInsurance_Yes_No();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"otherInsurances"} , priority = 141)
  public void  otherInsurance_Yes_Unsure()throws InterruptedException{
	  Reporter.log("TEST NO : 141",true);
	  ori.otherInsurance_Yes_Unsure();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"otherInsurances"} , priority = 142)
  public void  addAnotherPolicy()throws InterruptedException{
	  Reporter.log("TEST NO : 142",true);
	  ori.addAnotherPolicy();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"otherInsurances"} , priority = 143)
  public void removePolicy()throws InterruptedException{
	  Reporter.log("TEST NO : 143",true);
	  ori.removePolicy();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"otherInsurances"} , priority = 144)
  public void otherInsurance_No()throws InterruptedException{
	  Reporter.log("TEST NO : 144",true);
	  ori.otherInsurance_No();
  }
  
  //
  // Replacement Info
  // 
  //
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"otherInsurance_No"} , priority = 145)
  public void replacement()throws InterruptedException{
	  Reporter.log("TEST NO : 145",true);
	  Reporter.log("\tTitle : Create Replacement Instance",true);
	  rp = new AppProcessReplacement(driver);
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"replacement"} , priority = 146)
  public void select_Yes_Yes()throws InterruptedException{
	  Reporter.log("TEST NO : 146",true);
	  rp.select_Yes_Yes();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"replacement"} , priority = 147)
  public void addAnotherReplacement()throws InterruptedException{
	  Reporter.log("TEST NO : 147",true);
	  rp.addAnotherReplacement();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"replacement"} , priority = 148)
  public void removePolicy_Replacement()throws InterruptedException{
	  Reporter.log("TEST NO : 148",true);
	  rp.removePolicy();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"replacement"} , priority = 149)
  public void select_No_No()throws InterruptedException{
	  Reporter.log("TEST NO : 149",true);
	  rp.select_No_No();
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"select_No_No"} , priority = 150)
  public void next_replacement()throws InterruptedException{
	  Reporter.log("TEST NO : 150",true);
	  rp.clickNext();
  }
  
  //
  // Medical Info
  //
  //
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"next_replacement"} , priority = 151)
  public void medicalInfo()throws InterruptedException{
	  
	  Reporter.log("TEST NO : 151",true);
	  Reporter.log("\tTitle : Create medical info instance",true);
	  mi = new AppProcessMedicalInfo(driver);
	  
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"medicalInfo"} , priority = 152)
  public void select_Yes_Diagnosed()throws InterruptedException{

	  Reporter.log("TEST NO : 152",true);
	  mi.select_Yes_Diagnosed();

  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"select_Yes_Diagnosed"} , priority = 153)
  public void invalidDiagnosis()throws InterruptedException{

	  Reporter.log("TEST NO : 153",true);
	  mi.invalidDiagnosis();

  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"select_Yes_Diagnosed"} , priority = 154)
  public void validDiagnosis()throws InterruptedException{

	  Reporter.log("TEST NO : 154",true);
	  mi.validDiagnosis();

  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"select_Yes_Diagnosed"} , priority = 155)
  public void invalidDateofDiagnosis()throws InterruptedException{

	  Reporter.log("TEST NO : 155",true);
	  mi.invalidDateofDiagnosis();

  } 
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"select_Yes_Diagnosed"} , priority = 156)
  public void validDateofDiagnosis()throws InterruptedException{

	  Reporter.log("TEST NO : 156",true);
	  mi.validDateofDiagnosis();

  } 
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"select_Yes_Diagnosed"} , priority = 157)
  public void invalidHealthcareProvider()throws InterruptedException{

	  Reporter.log("TEST NO : 157",true);
	  mi.invalidHealthcareProvider();

  } 
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"select_Yes_Diagnosed"} , priority = 158)
  public void validHealthcareProvider()throws InterruptedException{

	  Reporter.log("TEST NO : 158",true);
	  mi.validHealthcareProvider();

  } 
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"select_Yes_Diagnosed"} , priority = 159)
  public void medicalinfoInvalidAddress1()throws InterruptedException{

	  Reporter.log("TEST NO : 159",true);
	  mi.invalidAddress1();

  } 
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"select_Yes_Diagnosed"} , priority = 160)
  public void medicalinfoValidAddress1()throws InterruptedException{

	  Reporter.log("TEST NO : 160",true);
	  mi.validAddress1();;

  } 
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"select_Yes_Diagnosed"} , priority = 161)
  public void medicalinfoValidAddress2()throws InterruptedException{

	  Reporter.log("TEST NO : 161",true);
	  mi.validAddress2();;

  } 
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"select_Yes_Diagnosed"} , priority = 162)
  public void medicalinfoInvalidCity()throws InterruptedException{

	  Reporter.log("TEST NO : 162",true);
	  mi.invalidCity();

  } 
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"select_Yes_Diagnosed"} , priority = 163)
  public void medicalinfovalidCity()throws InterruptedException{

	  Reporter.log("TEST NO : 163",true);
	  mi.validCity();

  } 
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"select_Yes_Diagnosed"} , priority = 164)
  public void medicalinfoState()throws InterruptedException{

	  Reporter.log("TEST NO : 164",true);
	  mi.state();

  } 
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"select_Yes_Diagnosed"} , priority = 165)
  public void medicalinfoInvalidZip()throws InterruptedException{

	  Reporter.log("TEST NO : 165",true);
	  mi.invalidZip();

  } 
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"select_Yes_Diagnosed"} , priority = 166)
  public void medicalinfoValidZip()throws InterruptedException{

	  Reporter.log("TEST NO : 166",true);
	  mi.validZip();;

  } 
  
  @Test(groups = {"smoketest" , "regressiontest"} ,dependsOnMethods = {"select_Yes_Diagnosed"} , priority = 167)
  public void addAnotherDiagnosis()throws InterruptedException{

	  Reporter.log("TEST NO : 167",true);
	  mi.addAnotherDiagnosis();

  } 
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"addAnotherDiagnosis"} , priority = 168)
  public void removeDiagnosis()throws InterruptedException{

	  Reporter.log("TEST NO : 168",true);
	  mi.removeDiagnosis();

  } 
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"removeDiagnosis"} , priority = 169 )
  public void select_No_Diagnosed()throws InterruptedException{

	  Reporter.log("TEST NO : 169",true);
	  mi.select_No_Diagnosed();

  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"select_No_Diagnosed"} , priority = 170 )
  public void clickNext()throws InterruptedException{

	  Reporter.log("TEST NO : 170",true);
	  mi.clickNext();

  }
  
  //
  //
  // Consent page
  //
  //
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"clickNext"} , priority = 171 )
  public void consent()throws InterruptedException{

	  Reporter.log("TEST NO : 171",true);
	  Reporter.log("\tCreate instance for consent page",true);
	  cons = new AppProcessConsent(driver);

  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"consent"} , priority = 172 )
  public void clickToEsign()throws InterruptedException, RiseException{

	  Reporter.log("TEST NO : 172",true);
	  boolean res = cons.clickToEsign();
	  if(res){
		skiptest = true;  
	  }

  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"clickToEsign"} , priority = 173 )
  public void clickOk()throws InterruptedException, RiseException{

	  Reporter.log("TEST NO : 173",true);
	  if(!skiptest){
	   cons.clickOk();
	  }else{
		  Reporter.log("Skipping the clickOk()",true);
	  }
  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"clickOk"} , priority = 174 )
  public void clickGetStarted()throws InterruptedException, RiseException{

	  Reporter.log("TEST NO : 174",true);
	  if(!skiptest){
		  cons.clickGetStarted();
	  }else{
		  Reporter.log("Skipping the clickGetStarted()",true);
	  }

  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"clickGetStarted"} , priority = 175 )
  public void checkFieldReq()throws InterruptedException, RiseException{

	  Reporter.log("TEST NO : 175",true);
	  if(!skiptest){
		  cons.checkFieldReq();
	  }else{
		  Reporter.log("Skipping the checkFieldReq()",true);

	  }

  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"clickGetStarted"} , priority = 176 )
  public void clickToSign()throws InterruptedException, RiseException, AWTException{

	  Reporter.log("TEST NO : 176",true);
	  if(!skiptest){
		  cons.clickToSign();
		  Thread.sleep(5000);

		  cons.signatureDraw();
		  //cons.signatureType();
		  //cons.signatureUploadImage();
	  }else{
		  Reporter.log("Skipping the clickToSign()",true);
	  }

  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"clickToSign"} , priority = 177 )
  public void clickContinue()throws InterruptedException, RiseException{

	  Reporter.log("TEST NO : 177",true);
	  if(!skiptest){
		  cons.clickContinue();
	  }else{
		  Reporter.log("Skipping the clickContinue()",true);  
	  }

  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"clickContinue"} , priority = 178 )
  public void iAgree()throws InterruptedException, RiseException{

	  Reporter.log("TEST NO : 178",true);
	  if(!skiptest){
		  cons.iAgree();
	  }else{
		  Reporter.log("Skipping the iAgree()",true);   
	  }

  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"iAgree"} , priority = 179 )
  public void clickClose()throws InterruptedException, RiseException{

	  Reporter.log("TEST NO : 179",true);
	  if(!skiptest){
		  cons.clickClose();
	  }else{
		  Reporter.log("Skipping the clickClose()",true);   
	  }

  }
  
  //
  // payment
  //
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"clickClose"} ,priority = 180)
  public void payment(){
	  Reporter.log("TEST NO : 180",true);
	  Reporter.log("\tCreate Payment page instance ",true);
	  AppProcessPaymentInfo ptm = new AppProcessPaymentInfo(driver);
	  ptm.clickNext();
  }
  
  //
  // Confirmation page
  //
  //
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"payment"} , priority = 181 )
  public void confirmation()throws InterruptedException, RiseException{

	  Reporter.log("TEST NO : 181",true);
	  Reporter.log("Create Confirmation page instance",true);
	  cp = new ConfirmationPage(driver);

  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"confirmation"} , priority = 182 )
  public void checkGreyLayout()throws InterruptedException, RiseException{

	  Reporter.log("TEST NO : 182",true);
	  cp.checkGreyLayout();

  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"confirmation"} , priority = 183 )
  public void selectOtherTab()throws InterruptedException, RiseException{

	  Reporter.log("TEST NO : 183",true);
	  cp.selectOtherTab();

  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"selectOtherTab"} , priority = 184 )
  public void clickEdit()throws InterruptedException, RiseException{

	  Reporter.log("TEST NO : 184",true);
	  cp.clickEdit();

  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"clickEdit"} , priority = 185 )
  public void clickUpdate()throws InterruptedException, RiseException{

	  Reporter.log("TEST NO : 185",true);
	  cp.clickUpdate();

  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"clickUpdate"} , priority = 186 )
  public void clickConfirm()throws InterruptedException, RiseException{

	  Reporter.log("TEST NO : 186",true);
	  cp.clickConfirm();

  }

  //
  // ConditionalReceipt
  //
  //
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"clickConfirm"} , priority = 187 )
  public void conditionalReceipt()throws InterruptedException, RiseException{

	  Reporter.log("TEST NO : 187",true);
	  Reporter.log("\tCreate instance for Conditional receipt",true);
	  crp = new ConditionalReceipt(driver);

  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"conditionalReceipt"} , priority = 188 )
  public void clickConditionalNext()throws InterruptedException, RiseException{

	  Reporter.log("TEST NO : 188",true);
	  crp.clickConditionalNext();

  }
  
  //
  // Confirm Address
  //
  //
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"clickConditionalNext"} , priority = 189 )
  public void confirmAddress()throws InterruptedException, RiseException{

	  Reporter.log("TEST NO : 189",true);
	  Reporter.log("Create instance for Confirm Address",true);
	  cadd = new ConfirmAddress(driver);

  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"confirmAddress"} , priority = 190 )
  public void clickSameAdd()throws InterruptedException, RiseException{

	  Reporter.log("TEST NO : 190",true);
	  cadd.clickSameAdd();

  }
  
 //@Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"clickSameAdd"} , priority = 191 )
  public void addFiledsWithInvalidData()throws InterruptedException, RiseException{

	  Reporter.log("TEST NO : 191",true);
	  cadd.addFiledsWithInvalidData();

  }
  
 //@Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"clickSameAdd"} , priority = 192 )
  public void addFiledsWithValidData()throws InterruptedException, RiseException{

	  Reporter.log("TEST NO : 192",true);
	  cadd.addFiledsWithValidData();

  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"clickSameAdd"} , priority = 193 )
  public void clickSend()throws InterruptedException, RiseException{

	  Reporter.log("TEST NO : 193",true);
	  cadd.clickSendButton();

  }
  
  @Test(groups = {"smoketest" , "regressiontest"},dependsOnMethods = {"clickSend"} , priority = 194 )
  public void userLogin()throws InterruptedException, RiseException{

	  Reporter.log("TEST NO : 194",true);
	  cadd.userLogin();

  }
  
  
  
  @AfterTest
  public void tearDown() {
  }

}
