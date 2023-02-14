package com.dupr.test.events;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.events.AcceptOrDeclinePartnershipPage;
import com.dupr.pages.events.EditOrRemovePartnerPage;
import com.dupr.pages.events.EventRegistrationPage;
import com.dupr.pages.home.AntiScrappingCaptchaPage;
import com.dupr.pages.home.UserDashboardPage;
import com.dupr.test.CommonBaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic(value = "Brackets")
@Feature(value = "Accept or Decline Partner")
public class AcceptOrDeclinePartnerTest extends CommonBaseTest {

	private static final Logger logger = Logger.getLogger(AcceptOrDeclinePartnerTest.class.getName());

	private EventRegistrationPage directorEventRegistrationPage = null;
	private EditOrRemovePartnerPage editOrRemovePartnerPage = null;
	private AcceptOrDeclinePartnershipPage acceptOrDeclinePartnershipPage = null;
	private AntiScrappingCaptchaPage antiScrappingCaptchaPage = null;
	private UserDashboardPage userDashboardPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String directorEmail, String directorPassword)
			throws Exception {
		logger.info("Starting of initMethod in AcceptOrDeclinePartnerTest");

		this.driver = super.getWebDriver(WebDriversEnum.ACCEPT_OR_DECLINE_PARTNER_DRIVER);
		super.initCommonBaseTest(siteURL, directorEmail, directorPassword);
		this.antiScrappingCaptchaPage = new AntiScrappingCaptchaPage(this.driver);

		this.directorEventRegistrationPage = new EventRegistrationPage(this.driver);
		this.editOrRemovePartnerPage = new EditOrRemovePartnerPage(this.driver);
		this.acceptOrDeclinePartnershipPage = new AcceptOrDeclinePartnershipPage(this.driver);
		this.userDashboardPage = new UserDashboardPage(this.driver);

		logger.info("Ending of initMethod in AcceptOrDeclinePartnerTest");
	}

	@Test(priority = 1, description = "Verify Add Partner Functionality", groups = "sanity")
	@Description("Test case #1, Verify Add Partner Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Add Partner Functionality")
	public void verifyAddPartnerFunctionalityInBracketsPage() {
		logger.info("Starting of verifyAddPartnerFunctionalityInBracketsPage method");

		editOrRemovePartnerPage.clickOnMyBracketsLabel();
		editOrRemovePartnerPage.clickOnBracketKebabMenu();

		try {
			if (antiScrappingCaptchaPage.isAddPartnerDisplayedInBracketsPage()) {
				antiScrappingCaptchaPage.clickOnAddPartnerFromKebabMenu();

				Assert.assertEquals(editOrRemovePartnerPage.getAddAPartnerLabel(),
						expectedAssertionsProp.getProperty("add.a.partner.text"));

				editOrRemovePartnerPage.searchPartner(testDataProp.getProperty("partner.name"));
				editOrRemovePartnerPage.hardWait(3);

				Assert.assertTrue(
						editOrRemovePartnerPage.isValidPartnerDisplayed(testDataProp.getProperty("partner.name")));

				editOrRemovePartnerPage.clickOnAddPartnerRadioButton();
				editOrRemovePartnerPage.clickOnAddPartnerEnabledButton();
			}
		} catch (Exception e) {
			logger.info("****Add Partner Button not displayed****");

			antiScrappingCaptchaPage.clickOnRemovePartnerButton();
			antiScrappingCaptchaPage.hardWait(3);
			antiScrappingCaptchaPage.clickOnBracketKebabButton();
			antiScrappingCaptchaPage.clickOnAddPartnerFromKebabMenu();

			Assert.assertEquals(editOrRemovePartnerPage.getAddAPartnerLabel(),
					expectedAssertionsProp.getProperty("add.a.partner.text"));

			editOrRemovePartnerPage.searchPartner(testDataProp.getProperty("partner.name"));
			editOrRemovePartnerPage.hardWait(3);
			Assert.assertTrue(
					editOrRemovePartnerPage.isValidPartnerDisplayed(testDataProp.getProperty("partner.name")));

			editOrRemovePartnerPage.clickOnAddPartnerRadioButton();
			editOrRemovePartnerPage.clickOnAddPartnerEnabledButton();
		}

		acceptOrDeclinePartnershipPage.clickOnOpenSettingsMenu();
		acceptOrDeclinePartnershipPage.clickOnLogoutButton();

		logger.info("Ending of verifyAddPartnerFunctionalityInBracketsPage method");
	}

	@Parameters({ "siteURL", "validEmail", "validPassword" })
	@Test(priority = 2, description = "Verify MyBrackets Page In Player Account", groups = "sanity")
	@Description("Test case #2, Verify MyBrackets Page In Player Account")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify MyBrackets Page In Player Account")
	public void verifyMyBracketsPageInPlayerAccount(String siteURL, String validEmail, String validPassword)
			throws Exception {
		logger.info("Starting of verifyMyBracketsPageInPlayerAccount method");

		editOrRemovePartnerPage.hardWait(3);

		this.siteLogin(siteURL, validEmail, validPassword, this.driver);
		editOrRemovePartnerPage.hardWait(3);

		editOrRemovePartnerPage.clickOnMyBracketsLabel();

		Assert.assertEquals(editOrRemovePartnerPage.getBracketsLabel(),
				expectedAssertionsProp.getProperty("brackets.text"));
		Assert.assertEquals(editOrRemovePartnerPage.getBrowseBracketsLabel(),
				expectedAssertionsProp.getProperty("browse.brackets.text"));

		Assert.assertTrue(userDashboardPage.isDashboardPageContains());

		logger.info("Ending of verifyMyBracketsPageInPlayerAccount method");
	}

	@Test(priority = 3, description = "Verify Decline Partner Functionality in Brackets Page", groups = "sanity")
	@Description("Test case #3, Verify Decline Partner Functionality in Brackets Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify Decline Partner Functionality in Brackets Page")
	public void verifyDeclinePartnerFunctionalityInBracketsPage() {
		logger.info("Starting of verifyDeclinePartnerFunctionalityInBracketsPage method");

		acceptOrDeclinePartnershipPage.hardWait(3);

		Assert.assertTrue(acceptOrDeclinePartnershipPage.isDeclineButtonDisplayed());

		acceptOrDeclinePartnershipPage.clickOnDeclinePartnerButton();

		acceptOrDeclinePartnershipPage.hardWait(4);
		Assert.assertFalse(acceptOrDeclinePartnershipPage.isDeclineButtonDisplayed());

		acceptOrDeclinePartnershipPage.clickOnOpenSettingsMenu();
		acceptOrDeclinePartnershipPage.hardWait(2);
		acceptOrDeclinePartnershipPage.clickOnLogoutButton();

		logger.info("Ending of verifyDeclinePartnerFunctionalityInBracketsPage method");
	}

	@Parameters({ "siteURL", "directorEmail", "directorPassword", "validEmail", "validPassword" })
	@Test(priority = 4, description = "Verify Accept Button Functionality on Bracket Card", groups = "sanity")
	@Description("Test case #4, Verify Accept Button Functionality on Bracket Card")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify Accept Button Functionality on Bracket Card")
	public void verifyAcceptButtonFunctionalityOnBracketCard(String siteURL, String directorEmail,
			String directorPassword, String validEmail, String validPassword) throws Exception {
		logger.info("Starting of verifyAcceptButtonFunctionalityOnBracketCard method");

		this.siteLogin(siteURL, directorEmail, directorPassword, this.driver);

		this.verifyAddPartnerFunctionalityInBracketsPage();
		acceptOrDeclinePartnershipPage.hardWait(4);
		this.verifyMyBracketsPageInPlayerAccount(siteURL, validEmail, validPassword);

		acceptOrDeclinePartnershipPage.hardWait(4);

		acceptOrDeclinePartnershipPage.clickOnAcceptButton();

		Assert.assertTrue(acceptOrDeclinePartnershipPage.isAcceptPartnerPopupContains());

		logger.info("Ending of verifyAcceptButtonFunctionalityOnBracketCard method");
	}

	@Test(priority = 5, description = "Verify No Radio Button Functionality in Accept Partner popup", groups = "sanity")
	@Description("Test case #5, Verify No Radio Button Functionality in Accept Partner popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify No Radio Button Functionality in Accept Partner popup")
	public void verifyNoRadioButtonFunctionalityInAcceptPartnerPopup() {
		logger.info("Starting of verifyNoRadioButtonFunctionalityInAcceptPartnerPopup method");

		acceptOrDeclinePartnershipPage.clickOnNoRadioButton();

		Assert.assertTrue(acceptOrDeclinePartnershipPage.isNoRadioButtonSelected());
		Assert.assertTrue(acceptOrDeclinePartnershipPage.isRegisterButtonEnabled());

		logger.info("Ending of verifyNoRadioButtonFunctionalityInAcceptPartnerPopup method");
	}

	@Test(priority = 6, description = "Verify Yes Radio Button Functionality in Accept Partner popup", groups = "sanity")
	@Description("Test case #6, Verify Yes Radio Button Functionality in Accept Partner popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify Yes Radio Button Functionality in Accept Partner popup")
	public void verifyYesRadioButtonFunctionalityInAcceptPartnerPopup() {
		logger.info("Starting of verifyYesRadioButtonFunctionalityInAcceptPartnerPopup method");

		acceptOrDeclinePartnershipPage.clickOnYesRadioButton();

		Assert.assertTrue(acceptOrDeclinePartnershipPage.isYesRadioButtonSelected());
		Assert.assertTrue(acceptOrDeclinePartnershipPage.isRegisterButtonEnabled());

		logger.info("Ending of verifyYesRadioButtonFunctionalityInAcceptPartnerPopup method");
	}

	@Test(priority = 7, description = "Verify Register Button Functionality in Accept Partner popup", groups = "sanity")
	@Description("Test case #7, Verify Register Button Functionality in Accept Partner popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Verify Register Button Functionality in Accept Partner popup")
	public void verifyRegisterButtonFunctionalityInAcceptPartnerPopup() {
		logger.info("Starting of verifyRegisterButtonFunctionalityInAcceptPartnerPopup method");

		acceptOrDeclinePartnershipPage.clickOnRegisterButton();

		Assert.assertEquals(directorEventRegistrationPage.getSuccessLabel(),
				expectedAssertionsProp.getProperty("success.text"));
		Assert.assertEquals(directorEventRegistrationPage.getRegistrationCompletedLabel(),
				expectedAssertionsProp.getProperty("registration.completed"));
		Assert.assertEquals(directorEventRegistrationPage.getOkLabel(), expectedAssertionsProp.getProperty("ok.text"));

		logger.info("Ending of verifyRegisterButtonFunctionalityInAcceptPartnerPopup method");
	}

	@Test(priority = 8, description = "Verify Ok Button Functionality in Accept Partner Success popup", groups = "sanity")
	@Description("Test case #8, Verify Ok Button Functionality in Accept Partner Success popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Verify Ok Button Functionality in Accept Partner Success popup")
	public void verifyOkButtonFunctionalityInAcceptPartnerSuccessPopup() {
		logger.info("Starting of verifyOkButtonFunctionalityInAcceptPartnerSuccessPopup method");

		directorEventRegistrationPage.clickOnOkButton();

		Assert.assertEquals(editOrRemovePartnerPage.getBracketsLabel(),
				expectedAssertionsProp.getProperty("brackets.text"));
		Assert.assertEquals(editOrRemovePartnerPage.getBrowseBracketsLabel(),
				expectedAssertionsProp.getProperty("browse.brackets.text"));

		logger.info("Ending of verifyOkButtonFunctionalityInAcceptPartnerSuccessPopup method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.ACCEPT_OR_DECLINE_PARTNER_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
