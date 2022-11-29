package com.dupr.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.b2b.test.base.B2BBaseAutomationTest;
import com.b2b.utils.B2BBaseTestListener;
import com.dupr.pages.DUPRLoginPage;

@Listeners(B2BBaseTestListener.class)
public abstract class DUPRBaseAutomationTest extends B2BBaseAutomationTest {
	private static final Logger log = Logger.getLogger(DUPRBaseAutomationTest.class);
private DUPRLoginPage loginPage=null;
	@BeforeSuite
	@Parameters({ "siteURL", "language", "browser", "headless" })
	public void initAutomation(String siteURL, String language, String browser, String headless) {
		this.loadProjectConfigFiles();
		this.initTestAutomation(siteURL, language, browser, false, false);

		log.debug("Site URL :{} " + loginURL);
	}
	
	protected void siteLogin(WebDriver driver, String email, String password) throws Exception {
		goToSite(driver);
		this.loginPage = new DUPRLoginPage(driver);
		loginPage.clickOnLogInLink();
		loginPage.loginToDUPRApplication(email, password);
	}

}
