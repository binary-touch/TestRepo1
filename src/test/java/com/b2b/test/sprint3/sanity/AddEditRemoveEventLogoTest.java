package com.b2b.test.sprint3.sanity;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.clubs.ClubLogoPage;
import com.dupr.pages.events.AddEditRemoveEventLogoPage;
import com.dupr.pages.events.BrowseEventsPage;
import com.dupr.pages.events.EditEventsPage;
import com.dupr.pages.profile.ProfilePicturePage;
import com.dupr.test.DUPRBaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class AddEditRemoveEventLogoTest extends DUPRBaseAutomationTest {

	private static final Logger logger = Logger.getLogger(AddEditRemoveEventLogoTest.class.getName());
	private ClubLogoPage clubLogoPage = null;
	private ProfilePicturePage profilePicturePage = null;
	private AddEditRemoveEventLogoPage eventLogoPage = null;
	private BrowseEventsPage browseEventsPage = null;
	private EditEventsPage editEventsPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String email, String password) throws Exception {
		logger.info("Starting of initMethod in AddEditRemoveEventLogoTest");

		this.driver = super.getWebDriver(WebDriversEnum.ADD_EDIT_REMOVE_EVENT_LOGO_DRIVER);
		this.siteLogin(siteURL, email, password, this.driver);

		this.clubLogoPage = new ClubLogoPage(this.driver);
		this.profilePicturePage = new ProfilePicturePage(this.driver);
		this.eventLogoPage = new AddEditRemoveEventLogoPage(this.driver);
		this.browseEventsPage = new BrowseEventsPage(this.driver);
		this.editEventsPage = new EditEventsPage(this.driver);

		logger.info("Ending of initMethod in AddEditRemoveEventLogoTest");
	}

	@Test(priority = 1, description = "Verify Add Event  logo  functionality", groups = "sanity")
	@Description("Test case #1, Verify Add event  logo  functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Add event logo functionality")
	public void verifyAddEventLogoFunctionality() {
		logger.info("Starting of verifyAddLogoFunctionality method");

		browseEventsPage.clickOnMyEventButton();
		clubLogoPage.hardWait(3);
		eventLogoPage.clickOnEventLabel();
		editEventsPage.hardWait(2);

		logger.info("Ending of verifyAddLogoFunctionality method");
	}

	@Test(priority = 2, description = "Verify Choose logo functionality", groups = "sanity")
	@Description("Test case #2, Verify Choose logo functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify Choose logo functionality")
	public void verifyChooseEventLogoFunctionality() {
		logger.info("Starting of verifyChooseEventLogoFunctionality method");

		try {
			if (eventLogoPage.isEmptyLogoDisplayed() == true) {

				Assert.assertEquals(this.clubLogoPage.getSelectImageToUploadText(),
						expectedAssertionsProp.getProperty("select.image.to.upload"));

				Assert.assertTrue(clubLogoPage.isClubLogoPopupContains());

				String clubLogoText = eventLogoPage.getClubLogoText();
				Assert.assertEquals(clubLogoText, expectedAssertionsProp.getProperty("event.logo.label"));

				Assert.assertTrue(profilePicturePage.isSaveButtonDisabled());

				clubLogoPage
						.uploadProfilePicture(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("club.logo.path"));
			}
		} catch (Exception e) {
			clubLogoPage.hardWait(1);
			clubLogoPage.clickOnRemoveLogoOption();
			profilePicturePage.clickOnYesButton();
			clubLogoPage.hardWait(3);
			profilePicturePage.clickOnCameraIcon();
			clubLogoPage.uploadProfilePicture(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("club.logo.path"));
		}

		clubLogoPage.hardWait(3);
		profilePicturePage.clickOnSaveButton();

		profilePicturePage.hardWait(3);
		Assert.assertTrue(clubLogoPage.isProfilePictureDisplayed());

		logger.info("Ending of verifyChooseEventLogoFunctionality method");
	}

	@Test(priority = 3, description = "Verify Change  logo functionality", groups = "sanity")
	@Description("Test case #3, Verify Change  logo functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify Change  logo functionality")
	public void verifyEditEventLogoFunctionality() {
		logger.info("Starting of verifyEditEventLogoFunctionality method");

		profilePicturePage.clickOnCameraIcon();

		Assert.assertTrue(clubLogoPage.isChangeLogoDisplayed());
		Assert.assertTrue(clubLogoPage.isRemoveLogoDisplayed());

		logger.info("Ending of verifyEditEventLogoFunctionality method");
	}

	@Test(priority = 4, description = "Verify Change Logo button functionality", groups = "sanity")
	@Description("Test case #4, Verify Change Logo button functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify Change Logo button functionality")
	public void verifyResultsOnClickOfChangeLogo() {
		logger.info("Starting of verifyResultsOnClickOfChangeLogo method");

		clubLogoPage.hardWait(3);
		clubLogoPage.clickOnChangeLogoOption();

		Assert.assertTrue(clubLogoPage.isClubLogoPopupContains());
		Assert.assertTrue(profilePicturePage.isSaveButtonDisplayed());
		Assert.assertTrue(profilePicturePage.isPreviousUploadedImageDisplayed());
		profilePicturePage.hardWait(2);
		clubLogoPage.uploadProfilePicture(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("edit.club.logo.path"));
		profilePicturePage.hardWait(3);
		profilePicturePage.clickOnSaveButton();
		clubLogoPage.hardWait(3);
		Assert.assertTrue(clubLogoPage.isProfilePictureDisplayed());

		logger.info("Ending of verifyResultsOnClickOfChangeLogo method");
	}

	@Test(priority = 5, description = "Verify results on click of Cancel Button in Club  logo popup", groups = "sanity")
	@Description("Test case #5, Verify results on click of Cancel Button in Club  logo popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify results on click of Cancel Button in Club  logo popup")
	public void verifyCancelClubLogoPopupFunctionality() {
		logger.info("Starting of verifyCancelClubLogoPopupFunctionality method");

		profilePicturePage.hardWait(3);
		profilePicturePage.clickOnCameraIcon();
		clubLogoPage.clickOnChangeLogoOption();

		profilePicturePage.clickOnCancelButton();

		logger.info("Ending of verifyCancelClubLogoPopupFunctionality method");
	}

	@Test(priority = 6, description = "Verify results on click of Close Icon in event logo popup", groups = "sanity")
	@Description("Test case #6, Verify results on click of Close Icon in event logo popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify results on click of Close Icon in event  logo popup")
	public void verifyCloseIconInEventLogoPopUp() {
		logger.info("Starting of verifyCloseIconInEventLogoPopUp method");

		profilePicturePage.hardWait(3);
		profilePicturePage.clickOnCameraIcon();
		clubLogoPage.clickOnChangeLogoOption();

		profilePicturePage.clickOnCloseIconOnEventLogo();

		logger.info("Ending of verifyCloseIconInEventLogoPopUp method");
	}

	@Test(priority = 7, description = "Verify the state of save button", groups = "sanity")
	@Description("Test case #9, Verify the state of save button")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9, Verify the state of save button")
	public void verifySaveButtonState() {
		logger.info("Starting of verifySaveButtonState method");

		profilePicturePage.hardWait(3);
		profilePicturePage.clickOnCameraIcon();
		clubLogoPage.clickOnChangeLogoOption();
		clubLogoPage.hardWait(2);
		Assert.assertTrue(profilePicturePage.isSaveButtonDisplayed());
		clubLogoPage.hardWait(2);
		driver.navigate().refresh();
		clubLogoPage.implicitWait();

		logger.info("Ending of verifySaveButtonState method");
	}

	@Test(priority = 8, description = "Verify results on click of 'No' Button in Remove Logo popup", groups = "sanity")
	@Description("Test case #7, Verify results on click of 'No' Button in Remove Logo popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Verify results on click of 'No' Button in Remove Logo popup")
	public void verifyNoButtonFunctionality() {
		logger.info("Starting of verifyNoButtonFunctionality method");

		clubLogoPage.hardWait(4);
		profilePicturePage.clickOnCameraIcon();
		clubLogoPage.implicitWait();
		clubLogoPage.clickOnRemoveLogoOption();
		clubLogoPage.hardWait(2);
		profilePicturePage.clickOnNoButton();

		logger.info("Ending of verifyNoButtonFunctionality method");
	}

	@Test(priority = 9, description = "Verify Close Icon Button functionality in Remove logo popup", groups = "sanity")
	@Description("Test case #8, Verify Close Icon Button functionality in Remove logo popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Verify Close Icon Button functionality in Remove logo popup")
	public void verifyCloseIconButtonInRemoveLogoPopup() {
		logger.info("Starting of verifyCloseIconButtonInRemoveLogoPopup method");

		profilePicturePage.hardWait(3);
		profilePicturePage.clickOnCameraIcon();
		clubLogoPage.hardWait(2);
		clubLogoPage.clickOnRemoveLogoOption();
		clubLogoPage.hardWait(2);
		profilePicturePage.iconCloseOnRemoveLogo();

		logger.info("Ending of verifyCloseIconButtonInRemoveLogoPopup method");
	}

	@Test(priority = 10, description = "Verify remove logo functionality", groups = "sanity")
	@Description("Test case #9, Verify remove logo functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9, Verify remove logo functionality")
	public void verifyRemoveLogo() {
		logger.info("Starting of verifyRemoveLogo method");

		clubLogoPage.hardWait(3);
		profilePicturePage.clickOnCameraIcon();
		clubLogoPage.hardWait(3);
		clubLogoPage.clickOnRemoveLogoOption();

		Assert.assertTrue(clubLogoPage.isRemoveLogoPopupContains());

		profilePicturePage.clickOnYesButton();

		logger.info("Ending of verifyRemoveLogo method");
	}

	@AfterClass
	public void quitDriver() {
		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.ADD_EDIT_REMOVE_EVENT_LOGO_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
