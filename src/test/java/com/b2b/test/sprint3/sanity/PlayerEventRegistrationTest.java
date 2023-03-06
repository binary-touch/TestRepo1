package com.b2b.test.sprint3.sanity;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.events.BrowseEventsPage;
import com.dupr.pages.events.EventRegistrationPage;
import com.dupr.pages.events.PlayerEventRegistrationPage;
import com.dupr.test.CommonBaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class PlayerEventRegistrationTest extends CommonBaseTest {

	private static final Logger logger = Logger.getLogger(PlayerEventRegistrationTest.class.getName());
	private EventRegistrationPage directorEventRegistrationPage = null;
	private PlayerEventRegistrationPage playerEventRegistrationPage = null;
	private BrowseEventsPage browseEventsPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "validEmail", "validPassword" })
	public void initMethod(String browser, String siteURL, String validEmail, String validPassword) throws Exception {
		logger.info("Starting of initMethod in PlayerEventRegistrationTest");

		this.driver = super.getWebDriver(WebDriversEnum.EVENT_REGISTRATION_DRIVER);
		super.initCommonBaseTest(siteURL, validEmail, validPassword);

		this.directorEventRegistrationPage = new EventRegistrationPage(this.driver);
		this.playerEventRegistrationPage = new PlayerEventRegistrationPage(this.driver);
		this.browseEventsPage = new BrowseEventsPage(this.driver);

		logger.info("Ending of initMethod in PlayerEventRegistrationTest");
	}

	@Test(priority = 1, description = "Verify Events Menu Functionality in Player Account", groups = "sanity")
	@Description("Test case #1, Verify Events Menu Functionality in Player Account")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Events Menu Functionality in Player Account")
	public void verifyEventsMenuFunctionalityInPlayerAccount() {
		logger.info("Starting of verifyEventsMenuFunctionalityInPlayerAccount method");

		playerEventRegistrationPage.clickOnEventsMenu();
		playerEventRegistrationPage.hardWait(3);
		Assert.assertTrue(browseEventsPage.isBrowseEventsPageContains());

		logger.info("Ending of verifyEventsMenuFunctionalityInPlayerAccount method");
	}
	
	@Test(priority = 2, description = "Verify details displayed on Event Card in Player Account", groups = "sanity")
	@Description("Test case #2, Verify details displayed on Event Card in Player Account")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify details displayed on Event Card in Player Account")
	public void verifyDetailsDisplayedOnEventCardInPlayerAccount() {
		logger.info("Starting of verifyDetailsDisplayedOnEventCardInPlayerAccount method");

		playerEventRegistrationPage.clickOnEventCard();

		Assert.assertEquals(playerEventRegistrationPage.getEventHeadingLabel(),
				expectedAssertionsProp.getProperty("event.text"));
		
		Assert.assertTrue(directorEventRegistrationPage.isEventPageContains());

		logger.info("Ending of verifyDetailsDisplayedOnEventCardInPlayerAccount method");
	}

	@Test(priority = 3, description = "Verify Register Functionality in Player Account", groups = "sanity")
	@Description("Test case #3, Verify Register Functionality in Player Account")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify Register Functionality in Player Account")
	public void verifyRegisterFunctionalityInPlayerAccount() {
		logger.info("Starting of verifyRegisterFunctionalityInPlayerAccount method");

		playerEventRegistrationPage.clickOnRegisterButtonInEventPage();
		
		Assert.assertEquals(directorEventRegistrationPage.getEventRegistrationLabel(),
				expectedAssertionsProp.getProperty("Event.registration"));

		Assert.assertEquals(playerEventRegistrationPage.getClubMembershipLabel(),
				expectedAssertionsProp.getProperty("club.membership"));
		Assert.assertEquals(directorEventRegistrationPage.getHealthAndSafetyLabel(),
				expectedAssertionsProp.getProperty("health.and.safety"));
		Assert.assertEquals(directorEventRegistrationPage.getLiabiltyPolicyLabel(),
				expectedAssertionsProp.getProperty("liabilty.policies"));

		logger.info("Ending of verifyRegisterFunctionalityInPlayerAccount method");
	}

	@Test(priority = 4, description = "Verify Back Button Functionality in Player Account Event Registration page", groups = "sanity")
	@Description("Test case #4, Verify Back Button Functionality in Player Account Event Registration page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify Back Button Functionality in Player Account Event Registration page")
	public void verifyBackButtonFunctionalityInPlayerAccountEventRegistrationPage() {
		logger.info("Starting of verifyBackButtonFunctionalityInPlayerAccountEventRegistrationPage method");

		directorEventRegistrationPage.clickOnEventRegistrationBackButton();

		Assert.assertEquals(directorEventRegistrationPage.getEventLabel(),
				expectedAssertionsProp.getProperty("event.text"));

		logger.info("Ending of verifyBackButtonFunctionalityInPlayerAccountEventRegistrationPage method");
	}

	@Test(priority = 5, description = "Verify register Functionality in Player Account Event Registration Page", groups = "sanity")
	@Description("Test case #5, Verify register Functionality in Player Account Event Registration Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify register Functionality in Player Account Event Registration Page")
	public void verifyRegisterFunctionalityInPlayerAccountEventRegistrationPage() {
		logger.info("Starting of verifyRegisterFunctionalityInPlayerAccountEventRegistrationPage method");
		
		this.verifyRegisterFunctionalityInPlayerAccount();
		playerEventRegistrationPage.hardWait(3);

		playerEventRegistrationPage.clickOnClubMemberYesButton();
		Assert.assertTrue(playerEventRegistrationPage.isClubMemberYesRadioButtonSelected());

		directorEventRegistrationPage.clickOnSelectYourBracketCheckbox();
		Assert.assertTrue(directorEventRegistrationPage.isBracketCheckboxSelected());

		directorEventRegistrationPage.clickOnRefundPolicyCheckbox();
		Assert.assertTrue(directorEventRegistrationPage.isRefundPolicyCheckboxSelected());

		directorEventRegistrationPage.clickOnHealthSafetyPolicyCheckbox();
		Assert.assertTrue(directorEventRegistrationPage.isHealthSafetyPolicyCheckboxSelected());

		directorEventRegistrationPage.clickOnLiabilityCheckbox();

		Assert.assertTrue(directorEventRegistrationPage.isLiabilityPolicyCheckboxSelected());
		playerEventRegistrationPage.clickOnRegisterButtonInEventRegPage();

		logger.info("Ending of verifyRegisterFunctionalityInPlayerAccountEventRegistrationPage method");
	}

	@Test(priority = 6, description = "Verify Ok button Functionality in Success PopUp", groups = "sanity")
	@Description("Test case #6, Verify Ok button Functionality in Success PopUp")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify Ok button Functionality in Success PopUp")
	public void verifyOKButtonFunctionalityInSuccessPopUp() {
		logger.info("Starting of verifyOKButtonFunctionalityInSuccessPopUp method");

		Assert.assertEquals(directorEventRegistrationPage.getSuccessLabel(),
				expectedAssertionsProp.getProperty("success.text"));
		Assert.assertEquals(directorEventRegistrationPage.getRegistrationCompletedLabel(),
				expectedAssertionsProp.getProperty("registration.completed"));
		Assert.assertEquals(directorEventRegistrationPage.getOkLabel(), expectedAssertionsProp.getProperty("ok.text"));

		directorEventRegistrationPage.clickOnOkButton();

		logger.info("Ending of verifyOKButtonFunctionalityInSuccessPopUp method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.EVENT_REGISTRATION_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
