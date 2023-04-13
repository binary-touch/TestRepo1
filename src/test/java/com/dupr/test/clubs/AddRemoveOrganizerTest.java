package com.dupr.test.clubs;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.clubs.AddORRemoveOrganizerPage;
import com.dupr.pages.clubs.ClubLogoPage;
import com.dupr.test.DUPRBaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Epic("DUPR App")
@Feature("Add Remove Organizer")
public class AddRemoveOrganizerTest extends DUPRBaseAutomationTest {

	private static final Logger logger = Logger.getLogger(AddRemoveOrganizerTest.class.getName());
	private ClubLogoPage clubLogoPage = null;
	private AddORRemoveOrganizerPage addRemoveOrganizerPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String directorEmail, String directorPassword) throws Exception {
		logger.info("Starting of initMethod in AddRemoveOrganizerTest");

		this.driver = super.getWebDriver(WebDriversEnum.ADD_OR_REMOVE_ORGANIZER_DRIVER);
		this.siteLogin(siteURL, directorEmail, directorPassword, this.driver);

		this.clubLogoPage = new ClubLogoPage(this.driver);
		this.addRemoveOrganizerPage = new AddORRemoveOrganizerPage(this.driver);

		logger.info("Ending of initMethod in AddRemoveOrganizerTest");
	}

	@Test(priority = 1, description = "Verify Add organizer functionality", groups = "sanity")
	@Description("Test case #1, Verify Add organizer functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Add Club logo functionality")
	public void verifyAddOrganizerFunctionality() {
		logger.info("Starting of verifyAddOrganizerFunctionality method");

		clubLogoPage.clickOnMyClubsTab();
		addRemoveOrganizerPage.hardWait(3);
		clubLogoPage.clickOnClub();
		clubLogoPage.hardWait(3);

		addRemoveOrganizerPage.clickOnSeeClubDetailsDropdown();
		addRemoveOrganizerPage.AddingOrganizers();
		
		logger.info("Ending of verifyAddOrganizerFunctionality method");
	}

	@Test(priority = 2, description = "Verify Delete organizer functionality", groups = "sanity")
	@Description("Test case #2, Verify Delete organizer functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify Delete organizer functionality")
	public void verifyDeleteOrganizerFunctionality() {
		logger.info("Starting of verifyDeleteOrganizerFunctionality method");

		addRemoveOrganizerPage.clickOnRemoveOrgButton();

		clubLogoPage.hardWait(3);
		
		if(addRemoveOrganizerPage.isAddOrganizerButtonDisplayed()==true) {
			
			addRemoveOrganizerPage.clickOnAddOrganizerButton();
			Assert.assertTrue(addRemoveOrganizerPage.isAddOrgPageContains());
			addRemoveOrganizerPage.clickOnGoBackButton();
		}

		logger.info("Ending of verifyDeleteOrganizerFunctionality method");
	}

	@Test(priority = 3, description = "Verify Delete organizer content", groups = "sanity")
	@Description("Test case #3, Verify Delete organizer content")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify Delete organizer content")
	public void verifyDeleteOrganizerContent() {
		logger.info("Starting of verifyDeleteOrganizerContent method");

		addRemoveOrganizerPage.DeletingOrganizer();

		Assert.assertTrue(addRemoveOrganizerPage.isRemoveOrgPopupContains());

		String removeOrgText = addRemoveOrganizerPage.getRemoveOrganizerText();
		Assert.assertEquals(removeOrgText, expectedAssertionsProp.getProperty("remove.organizer.label"));

		logger.info("Ending of verifyDeleteOrganizerContent method");
	}

	@Test(priority = 4, description = "Verify Go Back Button Functionality", groups = "sanity")
	@Description("Test case #4, Verify Go Back Button Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify Go Back Button Functionality")
	public void verifyGoBackFunctionality() {
		logger.info("Starting of verifyGoBackFunctionality method");

		addRemoveOrganizerPage.hardWait(3);
		addRemoveOrganizerPage.clickOnGoBackButton();
		addRemoveOrganizerPage.hardWait(3);
		Assert.assertFalse(addRemoveOrganizerPage.isRemoveOrgPopupContains());

		logger.info("Ending of verifyGoBackFunctionality method");
	}

	@Test(priority = 5, description = "Verify cancel Button Functionality ", groups = "sanity")
	@Description("Test case #5, Verify cancel Button Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify cancel Button Functionality")
	public void verifyCancelFunctionality() {
		logger.info("Starting of verifyCancelFunctionality method");
		
		addRemoveOrganizerPage.hardWait(3);
		addRemoveOrganizerPage.DeletingOrganizer();
		addRemoveOrganizerPage.hardWait(3);
		addRemoveOrganizerPage.clickOnCancelButton();addRemoveOrganizerPage.hardWait(3);
		Assert.assertFalse(addRemoveOrganizerPage.isRemoveOrgPopupContains());

		logger.info("Ending of verifyCancelFunctionality method");
	}

	@Test(priority = 6, description = "Verify Edit Organizer Button Functionality", groups = "sanity")
	@Description("Test case #6, Verify Edit Organizer Button Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify Edit Organizer Button Functionality")
	public void verifyEditOrganizerFunctionality() {
		logger.info("Starting of verifyEditOrganizerFunctionality method");

		addRemoveOrganizerPage.clickOnEditIcon();
		clubLogoPage.hardWait(2);
		Assert.assertTrue(addRemoveOrganizerPage.isEditOrganizerPopupContains());

		logger.info("Ending of verifyEditOrganizerFunctionality method");
	}

	@Test(priority = 7, description = "Verify Save Button Functionality", groups = "sanity")
	@Description("Test case #7, Verify Save Button Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Verify Save Button Functionality")
	public void verifySaveFunctionality() {
		logger.info("Starting of verifySaveFunctionality method");

		addRemoveOrganizerPage.clearOrganizerNameEmail();

		Assert.assertEquals(addRemoveOrganizerPage.getNameText(),
				expectedAssertionsProp.getProperty("name.validation"));

		Assert.assertEquals(addRemoveOrganizerPage.getEmailText(),
				expectedAssertionsProp.getProperty("email.validation"));

		addRemoveOrganizerPage.setInvalidEmail(testDataProp.getProperty("organizer.invalid.email"));
		addRemoveOrganizerPage.hardWait(3);
		
		Assert.assertEquals(addRemoveOrganizerPage.getInvalidEmailText(),
				expectedAssertionsProp.getProperty("invalid.email"));

		logger.info("Ending of verifySaveFunctionality method");
	}

	@Test(priority = 8, description = "Verify Cancel Button Functionality", groups = "sanity")
	@Description("Test case #8, Verify Cancel Button Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Verify Save Cancel Functionality")
	public void verifyCancelEditFunctionality() {
		logger.info("Starting of verifyCancelEditFunctionality method");

		addRemoveOrganizerPage.clickOnEditCancelButton();
		clubLogoPage.hardWait(2);
		Assert.assertFalse(addRemoveOrganizerPage.isEditOrganizerPopupContains());

		logger.info("Ending of verifyCancelEditFunctionality method");
	}

	@Test(priority = 9, description = "Verify set Name & Email", groups = "sanity")
	@Description("Test case #9, Verify set Name & Email")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9, Verify set Name & Email")
	public void verifyNameAndEmail() {
		logger.info("Starting of verifyNameAndEmail method");
		
		addRemoveOrganizerPage.clickOnEditIcon();
		addRemoveOrganizerPage.setOrganizerName(testDataProp.getProperty("organizer.name"));
		addRemoveOrganizerPage.setOrganizerEmail(testDataProp.getProperty("organizer.email"));
		addRemoveOrganizerPage.setOrganizerNumber(testDataProp.getProperty("organizer.num"));

		addRemoveOrganizerPage.clickOnSaveChangesButton();
		
		String clubOrgText = addRemoveOrganizerPage.getClubOrganizerLabelText();
		Assert.assertEquals(clubOrgText, expectedAssertionsProp.getProperty("club.organizer.label"));		

		logger.info("Ending of verifyNameAndEmail method");
	}

	@Test(priority = 10, description = "Verify Remove Organizer Button Functionality", groups = "sanity")
	@Description("Test case #10, Verify Remove Organizer Button Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #10, Verify Remove Organizer Button Functionality")
	public void verifyRemoveOrganizerFunctionality() {
		logger.info("Starting of verifyRemoveOrganizerFunctionality method");
		
		addRemoveOrganizerPage.hardWait(3);
		addRemoveOrganizerPage.clickOnRemoveOrganizerButton();

		logger.info("Ending of verifyRemoveOrganizerFunctionality method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.ADD_OR_REMOVE_ORGANIZER_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
