package com.b2b.test.sprint1.sanity;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.DUPRLoginPage;
import com.dupr.test.DUPRBaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("DUPR App")
@Feature("Login-Sanity")
public class DUPRLoginTest extends DUPRBaseAutomationTest {

	private static final Logger logger = Logger.getLogger(DUPRLoginTest.class.getName());

	@BeforeClass
	@Parameters({ "browser", "siteURL" })
	public void initMethod(String browser, String siteURL) throws Exception {
		logger.info("Starting of initMethod in DUPRLoginTest");

		this.driver = super.getWebDriver(WebDriversEnum.LOGIN_DRIVER);
		goToSite(driver);
		this.loginPage = new DUPRLoginPage(this.driver);

		logger.info("Ending of initMethod in DUPRLoginTest");
	}

	@Parameters({ "validEmail", "validPassword" })
	@Test(priority = 1, description = "Verify Login to DUPR app with valid mail id and valid password")
	@Description("Test case #1, Verify Login to DUPR app with valid mail id and valid password")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test case #1, Verify Login to DUPR app with valid mail id and valid password")
	public void loginToDUPR(String validEmail, String validPassword) {
		logger.info("Starting of loginToDUPR method");

		String searchPlayersValidationText = this.loginPage.getSearchPlayersValidationText();
		Assert.assertEquals(searchPlayersValidationText, expectedAssertionsProp.getProperty("search.players.text"));

		loginPage.clickOnLogInLink();

		String welcomeBackValidationText = this.loginPage.getWelcomeBackValidationText();
		Assert.assertEquals(welcomeBackValidationText, expectedAssertionsProp.getProperty("welcome.back.label"));

		loginPage.loginToDUPRApplication(validEmail, validPassword);

		String addAMatchValidationText = this.loginPage.getAddAMatchValidationText();
		Assert.assertEquals(addAMatchValidationText, expectedAssertionsProp.getProperty("add.match.label"));

		logger.info("Ending of loginToDUPR method");
	}

	@Test(priority = 2, description = "Verify logout functionality of DUPR")
	@Description("Test case #2, Verify logout functionality of DUPR")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #2, Verify logout functionality of DUPR")
	public void verifyLogoutFunctionality() {
		logger.info("Starting of verifyLogoutFunctionality method");

		loginPage.hardWait(3);
		loginPage.clickOnOpenSettingsMenu();
		loginPage.clickOnLogoutButton();

		String welcomeBackValidationText = this.loginPage.getWelcomeBackValidationText();
		Assert.assertEquals(welcomeBackValidationText, expectedAssertionsProp.getProperty("welcome.back.label"));

		logger.info("Ending of verifyLogoutFunctionality method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.LOGIN_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}
}
