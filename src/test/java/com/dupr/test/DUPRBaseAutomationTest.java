package com.dupr.test;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.b2b.common.WebDriversEnum;
import com.b2b.test.base.B2BBaseAutomationTest;
import com.b2b.utils.B2BBaseTestListener;
import com.dupr.pages.DUPRLoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(B2BBaseTestListener.class)

public abstract class DUPRBaseAutomationTest extends B2BBaseAutomationTest {

	protected WebDriver driver = null;
	protected DUPRLoginPage loginPage = null;
	
	protected static String eventName = null;
	private static final Logger log = Logger.getLogger(DUPRBaseAutomationTest.class);

	@BeforeSuite
	@Parameters({ "siteURL", "language", "browser", "headless" })
	public void initAutomation(String siteURL, String language, String browser, boolean headless) {
		this.loadProjectConfigFiles();
		this.initTestAutomation(siteURL, language, browser, headless, false);
		
		log.debug("Site URL :{} " + loginURL);
		 this.loginPage = new DUPRLoginPage(driver);
	}

protected void siteLogin(String siteURL, String email, String password, WebDriver webdriver) throws Exception {

		this.driver = webdriver;
		goToSite(webdriver);
		this.loginPage = new DUPRLoginPage(webdriver);

		loginPage.hardWait(4);
		loginPage.clickOnLogInLink();
		loginPage.loginToDUPRApplication(email, password);
		loginPage.hardWait(4);
		/*
		 * try { if(loginPage.isLoginFailedValidationText()) { loginPage.hardWait(5);
		 * loginPage.clickOnSignInButton(); } } catch (Exception e) {
		 * log.info("***Succesfully Logged In***"); }
		 */
	}
	
	protected void devSiteLogin(String devSiteURL, String email, String password, WebDriver webdriver) throws Exception {

		this.driver = webdriver;
		loginPage.hardWait(3);
		driver.get(devSiteURL);
		this.loginPage = new DUPRLoginPage(webdriver);

		loginPage.clickOnLogInLink();
		loginPage.loginToDUPRApplication(email, password);
	}

	protected synchronized WebDriver getDriver(String browser, WebDriversEnum webDriver) {
		log.info("Starting of method getDriver");
		WebDriver driver = null;
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		log.info("***************** Driver Successfully Created **************** " + driver.getTitle());
		log.info("End of method getDriver");
		return driver;

	}

}
