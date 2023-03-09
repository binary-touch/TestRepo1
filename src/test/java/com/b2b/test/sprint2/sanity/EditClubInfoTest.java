package com.b2b.test.sprint2.sanity;

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
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Epic("DUPR App")
@Feature("Edit Club Info Sanity")
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

	@Test(priority = 1, description = "Verify My Clubs functionality in Home page", groups = "sanity")
	@Description("Test case #1, Verify My Clubs functionality in Home page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify My Clubs functionality in Home page")
	public void verifyMyClubsFunctionalityInHomePage() {
		logger.info("Starting of verifyMyClubsFunctionalityInHomePage method");

		clubLogoPage.clickOnMyClubsTab();
		clubLogoPage.clickOnClub();

		clubLogoPage.hardWait(2);
		Assert.assertTrue(editClubInfoPage.isClubPageContains());

		logger.info("Ending of verifyMyClubsFunctionalityInHomePage method");
	}

	//@Test(priority = 2, description = "Verify See club details functionality in Club page", groups = "sanity")
	@Description("Test case #2, Verify results on click of click on see club details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify results on click of click on see club details")
	public void verifySeeClubDetailsFunctionalityInClubPage() {
		logger.info("Starting of verifySeeClubDetailsFunctionalityInClubPage method");

		editClubInfoPage.clickOnSeeClubDetailsDropdown();

		Assert.assertTrue(editClubInfoPage.isClubAddressDisplayed());

		Assert.assertTrue(editClubInfoPage.isShowLessOptionDisplayed());

		String contactText = editClubInfoPage.getContactLabelText();
		Assert.assertEquals(contactText, expectedAssertionsProp.getProperty("contact.label"));

		String AboutText = editClubInfoPage.getAboutLabelText();
		Assert.assertEquals(AboutText, expectedAssertionsProp.getProperty("about.label"));

		String clubOrganizersText = editClubInfoPage.getClubOrganizersText();
		Assert.assertEquals(clubOrganizersText, expectedAssertionsProp.getProperty("club.organizers.label"));

		logger.info("Ending of verifySeeClubDetailsFunctionalityInClubPage method");
	}

	//@Test(priority = 3, description = "Verify Show Less details option functionality in club page", groups = "sanity")
	@Description("Test case #3, Verify Show Less details option functionality in club page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify Show Less details option functionality in club page")
	public void verifyShowLessOptionFunctionalityInClubPage() {
		logger.info("Starting of verifyShowLessOptionFunctionalityInClubPage method");

		editClubInfoPage.clickOnShowLessOption();

		Assert.assertTrue(editClubInfoPage.isSeeClubDetailsDisplayed());
		Assert.assertFalse(editClubInfoPage.isContactLabelDisplayed());
		Assert.assertFalse(editClubInfoPage.isAboutLabelDisplayed());
		Assert.assertFalse(editClubInfoPage.isClubOrganizersLabelDisplayed());

		logger.info("Ending of verifyShowLessOptionFunctionalityInClubPage method");
	}

	@Test(priority = 4, description = "Verify whether director/Organizer is able to Edit club name", groups = "sanity")
	@Description("Test case #4, Verify whether director/Organizer is able to Edit club name")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify whether director/Organizer is able to Edit club name")
	public void verifyWhetherADirectorOrOrganizerCanEditClubInfo() {
		logger.info("Starting of verifyWhetherADirectorOrOrganizerCanEditClubInfo method");

		editClubInfoPage.hardWait(3);
		Assert.assertTrue(editClubInfoPage.isEditIconDisplayed());

		editClubInfoPage.clickOnEditIcon();

		Assert.assertTrue(editClubInfoPage.isChangeClubNamePopUpContains());

		logger.info("Ending of verifyWhetherADirectorOrOrganizerCanEditClubInfo method");
	}

	@Test(priority = 5, description = "Verify Edit Club Name Functionality for Director/Organizer", groups = "sanity")
	@Description("Test case #5, Verify Edit Club Name Functionality for Director/Organizer")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify Edit Club Name Functionality for Director/Organizer")
	public void verifyEditClubNameFunctionalityForDirectorOrOrganizer() {
		logger.info("Starting of verifyEditClubNameFunctionalityForDirectorOrOrganizer method");

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

		logger.info("Ending of verifyEditClubNameFunctionalityForDirectorOrOrganizer method");
	}

	@Test(priority = 6, description = "Verify Contact Edit Functionality", groups = "sanity")
	@Description("Test case #6, Verify Contact Edit Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify Contact Edit Functionality")
	public void verifyContactEditFunctionality() {
		logger.info("Starting of verifyContactEditFunctionality method");

		editClubInfoPage.clickOnSeeClubDetailsDropdown();
		editClubInfoPage.clickOnEditContactIcon();

		Assert.assertTrue(editClubInfoPage.isEditClubContactInformationPopupContains());

		String editClubContactInformationText = editClubInfoPage.getEditClubContactInformationText();
		Assert.assertEquals(editClubContactInformationText,
				expectedAssertionsProp.getProperty("edit.club.contact.information.label"));

		logger.info("Ending of verifyContactEditFunctionality method");
	}

	@Test(priority = 7, description = "Verify the validation displayed for Empty Address field in Edit Contact Information popup", groups = "sanity")
	@Description("Test case #7, Verify the validation displayed for Empty Address field in Edit Contact Information popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Verify the validation displayed for Empty Address field in Edit Contact Information popup")
	public void verifyTheValidationDisplayedForEmptyAddressFieldInEditContactInformationPopup() {
		logger.info("Starting of verifyTheValidationDisplayedForEmptyAddressFieldInEditContactInformationPopup method");

		editClubInfoPage.clearAddressField();
		editClubInfoPage.clickOnSaveChangesButton();

		editClubInfoPage.hardWait(2);

		String locationRequiredValidationText = editClubInfoPage.getLocationRequiredValidationText();
		Assert.assertEquals(locationRequiredValidationText,
				expectedAssertionsProp.getProperty("location.reuired.validation"));

		logger.info("Ending of verifyTheValidationDisplayedForEmptyAddressFieldInEditContactInformationPopup method");
	}

	@Test(priority = 8, description = "Verify the validation displayed for Invalid Email in Edit Contact Information popup", groups = "sanity")
	@Description("Test case #8, Verify the validation displayed for Invalid Email in Edit Contact Information popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Verify the validation displayed for Invalid Email in Edit Contact Information popup")
	public void verifyTheValidationDisplayedForInvalidEmailInEditContactInformationPopup() {
		logger.info("Starting of verifyTheValidationDisplayedForInvalidEmailInEditContactInformationPopup method");

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

		logger.info("Ending of verifyTheValidationDisplayedForInvalidEmailInEditContactInformationPopup method");
	}

	@Test(priority = 9, description = "Verify Edit Phone number field in Edit contact information popup", groups = "sanity")
	@Description("Test case #9, Verify Edit Phone number field in Edit contact information popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9, Verify Edit Phone number field in Edit contact information popup")
	public void verifyEditPhoneNumberFieldInEditContactInformationPopup() {
		logger.info("Starting of verifyEditPhoneNumberFieldInEditContactInformationPopup method");

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

		logger.info("Ending of verifyEditPhoneNumberFieldInEditContactInformationPopup method");
	}

	@Test(priority = 10, description = "Verify Edit About Club Description Functionality", groups = "sanity")
	@Description("Test case #10, Verify Edit About Club Description Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #10, Verify Edit About Club Description Functionality")
	public void VerifyEditIconForAboutSectionClubDescriptionFunctionality() {
		logger.info("Starting of VerifyEditClubDescriptionFunctionality method");

		editClubInfoPage.clickOnSeeClubDetailsDropdown();
		editClubInfoPage.clickOnEditAboutIcon();

		Assert.assertTrue(editClubInfoPage.isEditClubDescriptionPopUpContains());

		logger.info("Ending of VerifyEditClubDescriptionFunctionality method");
	}

	@Test(priority = 11, description = "Verify validation displayed for Edit Club field without Minimum Characters", groups = "sanity")
	@Description("Test case #11, Verify validation displayed for Edit Club field without Minimum Characters")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #11, Verify validation displayed for Edit Club field without Minimum Characters")
	public void verifyValidationDisplayedForEditClubFieldWithoutMinChars() {
		logger.info("Starting of verifyValidationDisplayedForEditClubFieldWithoutMinChars method");

		editClubInfoPage.clickAndClearClubInfoField();
		editClubInfoPage.hardWait(1);

		Assert.assertTrue(this.editClubInfoPage.isMinimumTenCharactersLabelDisplayed());

		logger.info("Ending of verifyValidationDisplayedForEditClubFieldWithoutMinChars method");
	}

	@Test(priority = 12, description = "Verify Add Club Description Functionality in Edit contact information popup", groups = "sanity")
	@Description("Test case #12, Verify Add Club Description Functionality in Edit contact information popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #12, Verify Add Club Description Functionality in Edit contact information popup")
	public void verifyAddClubDescriptionFunctionality() {
		logger.info("Starting of verifyEditClubDescriptionFunctionality method");

		editClubInfoPage.clickOnEditCloseIcon();
		editClubInfoPage.hardWait(2);
		editClubInfoPage.clickOnBackButtonInDirectorsPage();
		editClubInfoPage.clickOnAddDescriptionButton();

		editClubInfoPage.setEditInfoDescription(testDataProp.getProperty("club.descrption"));

		editClubInfoPage.clickOnBoldImageButton();
		editClubInfoPage.clickOnItalicImageButton();
		editClubInfoPage.clickOnUnderlineImageButton();

		editClubInfoPage.clickOnBoldImageButton();
		editClubInfoPage.clickOnItalicImageButton();
		editClubInfoPage.clickOnUnderlineImageButton();

		editClubInfoPage.clickOnSaveChangesButton();editClubInfoPage.hardWait(3);
		Assert.assertTrue(editClubInfoPage.isSuccessPopUpContains());

		editClubInfoPage.clickOnOkButton();

		logger.info("Ending of verifyEditClubDescriptionFunctionality method");
	}

	@Test(priority = 13, description = "Verify Edit Club Description Functionality in Edit contact information popup", groups = "sanity")
	@Description("Test case #13, Verify Edit Club Description Functionality in Edit contact information popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #13, Verify Edit Club Description Functionality in Edit contact information popup")
	public void verifyEditClubDescriptionFunctionality() {
		logger.info("Starting of verifyEditClubDescriptionFunctionality method");

		editClubInfoPage.clickOnSeeClubDetailsDropdown();
		editClubInfoPage.clickOnEditAboutIcon();
		editClubInfoPage.setEditInfoDescription(testDataProp.getProperty("club.descrption"));
		editClubInfoPage.clickOnSaveChangesButton();
		Assert.assertTrue(editClubInfoPage.isSuccessPopUpContains());

		editClubInfoPage.clickOnOkButton();

		logger.info("Ending of verifyEditClubDescriptionFunctionality method");
	}

	@Test(priority = 14, description = "Verify Download Or Export club members Functionality", groups = "sanity")
	@Description("Test case #14, Verify Download Or Export club members Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #14, Verify Download Or Export club members Functionality")
	public void verifyDownloadORExportClubMembersFunctionality() {
		logger.info("Starting of verifyDownloadORExportClubMembersFunctionality method");

		Assert.assertTrue(editClubInfoPage.isExportCSVButtonDisplayed());
		editClubInfoPage.clickOnExportCSVButton();

		logger.info("Ending of verifyDownloadORExportClubMembersFunctionality method");
	}

	@Test(priority = 15, description = "Verify Whether a Member can Edit Club Info", groups = "sanity")
	@Description("Test case #15, Verify Whether a Member can Edit Club Info")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #15, Verify Whether a Member can Edit Club Info")
	public void verifyWhetherAMemberCanEditClubInfo() {
		logger.info("Starting of verifyWhetherAMemberCanEditClubInfo method And Member");

		editClubInfoPage.clickOnBackButtonInDirectorsPage();
		editClubInfoPage.clickOnBrowseClubsButton();

		Assert.assertTrue(editClubInfoPage.isBrowserClubsLabelDisplayed());

		editClubInfoPage.clickOnClubNameButton();

		Assert.assertFalse(editClubInfoPage.isEditIconDisplayed());

		logger.info("Ending of verifyWhetherAMemberCanEditClubInfo method");
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
