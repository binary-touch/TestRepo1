package com.dupr.test.events;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.clubs.ClubLogoPage;
import com.dupr.pages.clubs.EditClubInfoPage;
import com.dupr.pages.events.AddBracketPage;
import com.dupr.pages.events.AddEventPage;
import com.dupr.pages.events.EditOrRemovePartnerPage;
import com.dupr.pages.events.DirectorEventRegistrationPage;
import com.dupr.test.CommonBaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class EditOrRemovePartnerTest extends CommonBaseTest {

	private static final Logger logger = Logger.getLogger(EditOrRemovePartnerTest.class.getName());
	DirectorEventRegistrationPage directorEventRegistrationPage = null;
	EditOrRemovePartnerPage bracketAcceptOrDeclinePage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String email, String password) throws Exception {
		logger.info("Starting of initMethod in EditClubInfoTest");

		this.driver = super.getWebDriver(WebDriversEnum.EDIT_OR_REMOVE_PARTNER_DRIVER);
		this.siteLogin(siteURL, email, password, this.driver);

		this.editClubInfoPage = new EditClubInfoPage(this.driver);
		this.clubLogoPage = new ClubLogoPage(this.driver);
		this.addEventPage = new AddEventPage(this.driver);
		this.addBracketPage = new AddBracketPage(this.driver);
		this.directorEventRegistrationPage = new DirectorEventRegistrationPage(this.driver);
		this.bracketAcceptOrDeclinePage = new EditOrRemovePartnerPage(this.driver);

		logger.info("Ending of initMethod in EditClubInfoTest");
	}

	@Test(priority = 1, description = "Verify Kebab Menu Functinality In Brackets", groups = "sanity")
	@Description("Test case #1, Verify Kebab Menu Functinality In Brackets")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Kebab Menu Functinality In Brackets")
	public void VerifyKebabMenuFunctinalityInBrackets() {
		logger.info("Starting of VerifyKebabMenuFunctinalityInBrackets method");

		bracketAcceptOrDeclinePage.clickOnMyBracketsLabel();
		Assert.assertEquals(bracketAcceptOrDeclinePage.getBracketsLabel(),
				expectedAssertionsProp.getProperty("brackets.text"));
		Assert.assertEquals(bracketAcceptOrDeclinePage.getBrowseBracketsLabel(),
				expectedAssertionsProp.getProperty("browse.brackets.text"));

		bracketAcceptOrDeclinePage.clickOnBracketKebabButton();
		try {
			// Assert.assertEquals(bracketAcceptOrDeclinePage.getAddPartnerLabel(),expectedAssertionsProp.getProperty("add.partner.text"));

			bracketAcceptOrDeclinePage.clickOnAddPartnerButton();

			bracketAcceptOrDeclinePage.clickOnAddPartnerRadioButton();

			bracketAcceptOrDeclinePage.clickOnAddPartnerButton();

			bracketAcceptOrDeclinePage.clickOnBracketKebabButton();
		} catch (Exception e) {
			Assert.assertEquals(bracketAcceptOrDeclinePage.getEditPartnerLabel(),
					expectedAssertionsProp.getProperty("edit.partner.text"));
			Assert.assertEquals(bracketAcceptOrDeclinePage.getRemovePartnerLabel(),
					expectedAssertionsProp.getProperty("remove.partner.text"));
		}
		logger.info("Ending of VerifyKebabMenuFunctinalityInBrackets method");
	}

	@Test(priority = 2, description = "Verify Bracket Functinality With Partner Pending Status", groups = "sanity")
	@Description("Test case #2, Verify Bracket Functinality With Partner Pending Status")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify Bracket Functinality With Partner Pending Status")
	public void VerifyBracketFunctinalityWithPartnerPendingStatus() {
		logger.info("Starting of VerifyBracketFunctinalityWithPartnerPendingStatus method");

		bracketAcceptOrDeclinePage.clickOnPartnerPendingBracketCard();
		// Assert.assertEquals(bracketAcceptOrDeclinePage.getBracketLabel(),expectedAssertionsProp.getProperty("bracket.text"));

		Assert.assertTrue(bracketAcceptOrDeclinePage.isDisplayedBracketPageContains());

		logger.info("Ending of VerifyBracketFunctinalityWithPartnerPendingStatus method");
	}

	@Test(priority = 3, description = "VerifyEditPartnerFunctinalityInBRacketPage", groups = "sanity")
	@Description("Test case #3, VerifyEditPartnerFunctinalityInBRacketPage")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, VerifyEditPartnerFunctinalityInBRacketPage")
	public void VerifyEditPartnerFunctinalityInBRacketPage() {
		logger.info("Starting of VerifyEditPartnerFunctinalityInBRacketPage method");

		bracketAcceptOrDeclinePage.clickOnEditPartnerButton();
		Assert.assertEquals(bracketAcceptOrDeclinePage.getAddAPartnerLabel(),
				expectedAssertionsProp.getProperty("add.a.partner.text"));

		Assert.assertTrue(bracketAcceptOrDeclinePage.isDisplayedEditPartnerBracketPageContains());

		logger.info("Ending of VerifyEditPartnerFunctinalityInBRacketPage method");
	}

	@Test(priority = 4, description = "VerifyCancelButtonFunctinalityInAddPartnerPage", groups = "sanity")
	@Description("Test case #4, VerifyCancelButtonFunctinalityInAddPartnerPage")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, VerifyCancelButtonFunctinalityInAddPartnerPage")
	public void VerifyCancelButtonFunctinalityInAddPartnerPage() {
		logger.info("Starting of VerifyCancelButtonFunctinalityInAddPartnerPage method");

		bracketAcceptOrDeclinePage.clickOnCancelButton();
		Assert.assertEquals(bracketAcceptOrDeclinePage.getBracketLabel(),
				expectedAssertionsProp.getProperty("bracket.text"));

		Assert.assertTrue(bracketAcceptOrDeclinePage.isDisplayedBracketPageContains());

		logger.info("Ending of VerifyCancelButtonFunctinalityInAddPartnerPage method");
	}

	@Test(priority = 5, description = "VerifySearchPartnerFunctinalityWithAValidPartner", groups = "sanity")
	@Description("Test case #5, VerifySearchPartnerFunctinalityWithAValidPartner")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, VerifySearchPartnerFunctinalityWithAValidPartner")
	public void VerifySearchPartnerFunctinalityWithAValidPartner() {
		logger.info("Starting of VerifySearchPartnerFunctinalityWithAValidPartner method");

		this.VerifyEditPartnerFunctinalityInBRacketPage();

		bracketAcceptOrDeclinePage.setSearchPartner(testDataProp.getProperty("valid.partner.name"));
		Assert.assertEquals(bracketAcceptOrDeclinePage.getvalidPartnerLabel(),
				expectedAssertionsProp.getProperty("valid.partner.text"));

		// Assert.assertTrue(bracketAcceptOrDeclinePage.isDisplayedBracketPageContains());

		logger.info("Ending of VerifySearchPartnerFunctinalityWithAValidPartner method");
	}

	@Test(priority = 6, description = "VerifySearchPartnerFunctinalityWithAInValidPartner", groups = "sanity")
	@Description("Test case #6, VerifySearchPartnerFunctinalityWithAInValidPartner")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, VerifySearchPartnerFunctinalityWithAInValidPartner")
	public void VerifySearchPartnerFunctinalityWithAInValidPartner() {
		logger.info("Starting of VerifySearchPartnerFunctinalityWithAInValidPartner method");

		// this.VerifyEditPartnerFunctinalityInBRacketPage();
		bracketAcceptOrDeclinePage.setSearchPartner(testDataProp.getProperty("in.valid.partner.name"));
		// Assert.assertEquals(bracketAcceptOrDeclinePage.getvalidPartnerLabel(),expectedAssertionsProp.getProperty("valid.partner.text"));

		Assert.assertFalse(bracketAcceptOrDeclinePage.isPartnerRadioButtonDisplayed());

		logger.info("Ending of VerifySearchPartnerFunctinalityWithAInValidPartner method");
	}

	@Test(priority = 7, description = "VerifyDisableAddPartnerButtonFunctinality", groups = "sanity")
	@Description("Test case #7, VerifyDisableAddPartnerButtonFunctinality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, VerifyDisableAddPartnerButtonFunctinality")
	public void VerifyDisableAddPartnerButtonFunctinality() {
		logger.info("Starting of VerifyDisableAddPartnerButtonFunctinality method");

		// this.VerifyEditPartnerFunctinalityInBRacketPage();
		bracketAcceptOrDeclinePage.setSearchPartner(testDataProp.getProperty("valid.partner.name"));
		// Assert.assertEquals(bracketAcceptOrDeclinePage.getvalidPartnerLabel(),expectedAssertionsProp.getProperty("valid.partner.text"));

		Assert.assertTrue(bracketAcceptOrDeclinePage.isAddPartnerDisabledButtonDisplayed());

		logger.info("Ending of VerifyDisableAddPartnerButtonFunctinality method");
	}

	@Test(priority = 8, description = "VerifyDisableAddPartnerButtonFunctinality", groups = "sanity")
	@Description("Test case #8, VerifyDisableAddPartnerButtonFunctinality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, VerifyDisableAddPartnerButtonFunctinality")
	public void VerifyAddParticipantsFunctinality() {
		logger.info("Starting of VerifyDisableAddPartnerButtonFunctinality method");

		// this.VerifyEditPartnerFunctinalityInBRacketPage();
		bracketAcceptOrDeclinePage.setSearchPartner(testDataProp.getProperty("valid.partner.name"));
		// Assert.assertEquals(bracketAcceptOrDeclinePage.getvalidPartnerLabel(),expectedAssertionsProp.getProperty("valid.partner.text"));
		bracketAcceptOrDeclinePage.clickOnAddPartnerRadioButton();
		bracketAcceptOrDeclinePage.clickOnAddPartnerEnabledButton();
		Assert.assertTrue(bracketAcceptOrDeclinePage.isDisplayedBracketPageAfterAddingPartnerContains());

		logger.info("Ending of VerifyDisableAddPartnerButtonFunctinality method");
	}

	@Test(priority = 9, description = "VerifyRemovePartnerFunctinality", groups = "sanity")
	@Description("Test case #9, VerifyRemovePartnerFunctinality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9, VerifyRemovePartnerFunctinality")
	public void VerifyRemovePartnerFunctinality() {
		logger.info("Starting of VerifyRemovePartnerFunctinality method");

		// this.VerifyEditPartnerFunctinalityInBRacketPage();
		// bracketAcceptOrDeclinePage.setSearchPartner(testDataProp.getProperty("valid.partner.name"));
		// Assert.assertEquals(bracketAcceptOrDeclinePage.getvalidPartnerLabel(),expectedAssertionsProp.getProperty("valid.partner.text"));

		bracketAcceptOrDeclinePage.clickOnRemovePartnerButton();
		Assert.assertTrue(bracketAcceptOrDeclinePage.isDisplayedBracketPageContains());

		logger.info("Ending of VerifyRemovePartnerFunctinality method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.EDIT_OR_REMOVE_PARTNER_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}
}
