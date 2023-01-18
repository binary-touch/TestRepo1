package com.dupr.test.clubs;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.clubs.ClubLogoPage;
import com.dupr.pages.clubs.EditClubInfoPage;
import com.dupr.test.DUPRBaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class EditClubInfoTest extends DUPRBaseAutomationTest {

	private static final Logger logger = Logger.getLogger(EditClubInfoTest.class.getName());
	private ClubLogoPage clubLogoPage = null;
	private EditClubInfoPage editClubInfoPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "validPassword" })
	public void initMethod(String browser, String siteURL, String email, String password) throws Exception {
		logger.info("Starting of initMethod in EditClubInfoTest");

		this.driver = super.getWebDriver(WebDriversEnum.EDIT_CLUB_INFO_DRIVER);
		this.siteLogin(siteURL, email, password, this.driver);
		this.editClubInfoPage = new EditClubInfoPage(this.driver);
		this.clubLogoPage = new ClubLogoPage(this.driver);

		logger.info("Ending of initMethod in EditClubInfoTest");
	}

	@Test(priority = 1, description = "Verify results on click of the club functionality", groups = "sanity")
	@Description("Test case #1, Verify results on click of the club functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify results on click of the club functionality")
	public void verifyClickOnClubFunctionality() {
		logger.info("Starting of verifyClickOnClubFunctionality method");

		clubLogoPage.clickOnMyClubsTab();
		clubLogoPage.clickOnClub();

		Assert.assertTrue(editClubInfoPage.isClubPageContains());

		logger.info("Ending of verifyClickOnClubFunctionality method");
	}

	@Test(priority = 2, description = "Verify results on click of click on see club details", groups = "sanity")
	@Description("Test case #2, Verify results on click of click on see club details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify results on click of click on see club details")
	public void verifyClickOnSeeClubDetailsFunctionality() {
		logger.info("Starting of verifyClickOnSeeClubDetailsFunctionality method");

		editClubInfoPage.clickSeeClubDetailsDropdown();

		Assert.assertTrue(editClubInfoPage.isClubAddressDisplayed());

		Assert.assertTrue(editClubInfoPage.isShowLessOptionDisplayed());

		String contactText = editClubInfoPage.getContactLabelText();
		Assert.assertEquals(contactText, expectedAssertionsProp.getProperty("contact.label"));

		String AboutText = editClubInfoPage.getAboutLabelText();
		Assert.assertEquals(AboutText, expectedAssertionsProp.getProperty("about.label"));

		String clubOrganizersText = editClubInfoPage.getClubOrganizersText();
		Assert.assertEquals(clubOrganizersText, expectedAssertionsProp.getProperty("club.organizers.label"));

		logger.info("Ending of verifyClickOnSeeClubDetailsFunctionality method");
	}

	@Test(priority = 3, description = "Verify results on click of click on Show  Less details", groups = "sanity")
	@Description("Test case #3, Verify results on click of click on Show  Less details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify results on click of click on Show  Less details")
	public void verifyClickOnShowLessFunctionality() {
		logger.info("Starting of verifyClickOnSeeClubFunctionality method");

		editClubInfoPage.clickOnShowLessOption();

		Assert.assertTrue(editClubInfoPage.isSeeClubDetailsDisplayed());
		Assert.assertFalse(editClubInfoPage.isContactLabelDisplayed());
		Assert.assertFalse(editClubInfoPage.isAboutLabelDisplayed());
		Assert.assertFalse(editClubInfoPage.isClubOrganizersLabelDisplayed());

		logger.info("Ending of verifyClickOnSeeClubFunctionality method");
	}

	@Test(priority = 4, description = "Verify Edit club name functionality", groups = "sanity")
	@Description("Test case #4, Verify Edit club name functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify Edit club name functionality")
	public void verifyEditClubNameFunctionality() {
		logger.info("Starting of verifyEditClubNameFunctionality method");

		editClubInfoPage.clickOnEditIcon();

		Assert.assertTrue(editClubInfoPage.isChangeClubNamePopUpContains());

		String ChangeClubNameText = editClubInfoPage.getChangeClubNameText();
		Assert.assertEquals(ChangeClubNameText, expectedAssertionsProp.getProperty("change.club.name.label"));

		editClubInfoPage.setClubName(testDataProp.getProperty("club.name"));
		editClubInfoPage.clickOnSaveChangesButton();

		editClubInfoPage.hardWait(5);
		String successLabel = editClubInfoPage.getSuccessLabel();
		Assert.assertEquals(successLabel, expectedAssertionsProp.getProperty("success.label"));

		Assert.assertTrue(editClubInfoPage.isSuccessPopUpContains());

		editClubInfoPage.clickOnOkButton();

		Assert.assertTrue(editClubInfoPage.isClubPageContains());

		logger.info("Ending of verifyEditClubNameFunctionality method");
	}

	@Test(priority = 5, description = "Verify results on click of click on the pen icon of the Contact", groups = "sanity")
	@Description("Test case #5, Verify results on click of click on the pen icon of the Contact")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify results on click of click on the pen icon of the Contact")
	public void verifyClickOnEditIconInContactFunctionality() {
		logger.info("Starting of verifyClickOnEditIconInContactFunctionality method");
		
		editClubInfoPage.clickSeeClubDetailsDropdown();
		editClubInfoPage.clickOnEditContactIcon();

		Assert.assertTrue(editClubInfoPage.isEditClubContactInformationPopupContains());

		String editClubContactInformationText = editClubInfoPage.getEditClubContactInformationText();
		Assert.assertEquals(editClubContactInformationText,
				expectedAssertionsProp.getProperty("edit.club.contact.information.label"));

		logger.info("Ending of verifyClickOnEditIconInContactFunctionality method");
	}

	@Test(priority = 6, description = "Verify the address field as empty in the edit contact information popup", groups = "sanity")
	@Description("Test case #6, Verify the address field as empty in the edit contact information popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify the address field as empty in the edit contact information popup")
	public void verifyAddressFieldAsEmptyInEditContactInformationPopup() {
		logger.info("Starting of verifyAddressFieldAsEmptyInEditContactInformationPopup method");

		editClubInfoPage.clearAddressField();
		editClubInfoPage.clickOnSaveChangesButton();

		editClubInfoPage.hardWait(2);
		String locationRequiredValidationText = editClubInfoPage.getLocationRequiredValidationText();
		Assert.assertEquals(locationRequiredValidationText,
				expectedAssertionsProp.getProperty("location.reuired.validation"));

		logger.info("Ending of verifyAddressFieldAsEmptyInEditContactInformationPopup method");
	}

	@Test(priority = 7, description = "Verify email with invalid email in the edit contact information popup ", groups = "sanity")
	@Description("Test case #7, Verify email with invalid email in the edit contact information popup ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Verify email with invalid email in the edit contact information popup ")
	public void verifyEmailFieldWithInvalidEmailInEditContactInformationPopup() {
		logger.info("Starting of verifyEmailFieldWithInvalidEmailInEditContactInformationPopup method");

		editClubInfoPage.setAddress(testDataProp.getProperty("address"));
		editClubInfoPage.setEmail(testDataProp.getProperty("invalid.email.in.signup"));
		editClubInfoPage.clickOnSaveChangesButton();

		editClubInfoPage.hardWait(3);
		String InvalidEmailValidationText = editClubInfoPage.getInvalidEmailValidationText();
		Assert.assertEquals(InvalidEmailValidationText, expectedAssertionsProp.getProperty("invalid.email.address"));

		String Error = editClubInfoPage.getErrorLabel();
		Assert.assertEquals(Error, expectedAssertionsProp.getProperty("error.label"));
		Assert.assertTrue(editClubInfoPage.isErrorPopUpContains());
		editClubInfoPage.clickOnOkButton();

		logger.info("Ending of verifyEmailFieldWithInvalidEmailInEditContactInformationPopup method");
	}

	@Test(priority = 8, description = "Verify Edit club contact information functionality", groups = "sanity")
	@Description("Test case #8, Verify Edit club contact information functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Verify Edit club contact information functionality")
	public void verifyEditClubContactInformationFunctionality() {
		logger.info("Starting of verifyEditClubContactInformationFunctionality method");

		editClubInfoPage.setAddress(testDataProp.getProperty("address"));
		editClubInfoPage.setEmail(testDataProp.getProperty("invalid.email.in.negative.login"));
		editClubInfoPage.clearPhoneNumber();
		editClubInfoPage.setPhoneNumber(testDataProp.getProperty("mobile.number"));
		editClubInfoPage.clickOnSaveChangesButton();

		editClubInfoPage.hardWait(3);
		String successLabel = editClubInfoPage.getSuccessLabel();
		Assert.assertEquals(successLabel, expectedAssertionsProp.getProperty("success.label"));

		Assert.assertTrue(editClubInfoPage.isSuccessPopUpContains());
		editClubInfoPage.clickOnOkButton();

		Assert.assertTrue(editClubInfoPage.isClubPageContains());

		logger.info("Ending of verifyEditClubContactInformationFunctionality method");
	}

	@Test(priority = 9, description = "Verify Download Or Export club members Functionali", groups = "sanity")
	@Description("Test case #9, Verify Download Or Export club members Functionali")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9, Verify Download Or Export club members Functionali")
	public void verifyDownloadORExportClubMembersFunctionality() {
		logger.info("Starting of verifyDownloadORExportClubMembersFunctionality method");
	
		Assert.assertTrue(editClubInfoPage.isExportCSVButtonDisplayed());
		editClubInfoPage.clickOnExportCSVButton();
		
		logger.info("Ending of verifyDownloadORExportClubMembersFunctionality method");
	}

	@Test(priority = 10, description = "Verify Edit Club Description Functionality", groups = "sanity")
	@Description("Test case #10, Verify Edit Club Description Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #10, Verify Verify Edit Club Description Functionality")
	public void VerifyEditClubDescriptionFunctionality() {
		logger.info("Starting of VerifyEditClubDescriptionFunctionality method");
		
		editClubInfoPage.clickSeeClubDetailsDropdown();
		editClubInfoPage.clickOnAddDescriptionButton();
		
		//editClubInfoPage.clickOnEditIconInAbout();
		Assert.assertTrue(editClubInfoPage.isEditClubDescriptionPopUpContains());
		
		editClubInfoPage.setEditInfoDescription(testDataProp.getProperty("club.descrption"));
		
		editClubInfoPage.clickOnBoldImageButton();
		editClubInfoPage.clickOnItalicImageButton();
		editClubInfoPage.clickOnUnderlineImageButton();
       
		editClubInfoPage.clickOnBoldImageButton();
		editClubInfoPage.clickOnItalicImageButton();
		editClubInfoPage.clickOnUnderlineImageButton();
		
		logger.info("Ending of VerifyEditClubDescriptionFunctionality method");
	}
	
	@Test(priority = 11, description = "Verify Edit Club Info Feature Is Applicable To Organizer And DIrector", groups = "sanity")
	@Description("Test case #11, Verify Edit Club Info Feature Is Applicable To Organizer And DIrector")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #11, Verify Edit Club Info Feature Is Applicable To Organizer And DIrector")
	public void VerifyEditClubInfoFeatureIsApplicableToOrganizerAndDIrector() {
		logger.info("Starting of VerifyEditClubInfoFeatureIsApplicableToOrganizerAndDIrector method");
		
		editClubInfoPage.clickOnDirectorButton();
		
		Assert.assertTrue(editClubInfoPage.isDirectorsEditIconDisplayed());
		
		editClubInfoPage.clickOnBackButtonInDirectorsPage();
		
		editClubInfoPage.clickOnSimbaOrganizerButton();
		
		Assert.assertTrue(editClubInfoPage.isOrganizersEditIconDisplayed());
		
		editClubInfoPage.clickOnBackButtonInDirectorsPage();
		
		
		logger.info("Ending of VerifyEditClubInfoFeatureIsApplicableToOrganizerAndDIrector method");
	}
	
	@Test(priority = 12, description = "Verify Edit Club Info Feature Is Not Applicable To Organizer And DIrector And Member", groups = "sanity")
	@Description("Test case #12, Verify Edit Club Info Feature Is Not Applicable To Organizer And DIrector")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #12, Verify Edit Club Info Feature Is Not Applicable To Organizer And DIrector And Member")
	public void VerifyEditClubInfoFeatureIsNotApplicableToOrganizerAndDIrectorAndMember() {
		logger.info("Starting of VerifyEditClubInfoFeatureIsNotApplicableToOrganizerAndDIrector method And Member");
		
        editClubInfoPage.clickOnBrowseClubsButton();
		
		Assert.assertTrue(editClubInfoPage.isBrowserClubsLabelDisplayed());
		
		editClubInfoPage.clickOnClubNameButton();
		
		Assert.assertFalse(editClubInfoPage.isEditClubIsNotDisplayed());

		
		logger.info("Ending of VerifyEditClubInfoFeatureIsNotApplicableToOrganizerAndDIrector method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.EDIT_CLUB_INFO_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
