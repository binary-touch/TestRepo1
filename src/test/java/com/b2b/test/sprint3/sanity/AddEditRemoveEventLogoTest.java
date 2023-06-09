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
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic(value = "Events")
@Feature(value = "Add Edit Remove Event Logo Sanity")
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

	@Test(priority = 1, description = "Verify Add Event logo functionality", groups = "sanity")
	@Description("Test case #1, Verify Add event logo functionality")
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
			clubLogoPage.hardWait(3);
			clubLogoPage.clickOnRemoveLogoOption();
			profilePicturePage.clickOnYesButton();
			clubLogoPage.hardWait(3);
			profilePicturePage.clickOnCameraIcon();clubLogoPage.hardWait(3);
			clubLogoPage.uploadProfilePicture(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("club.logo.path"));
		}

		clubLogoPage.hardWait(3);
		profilePicturePage.clickOnSaveButton();

		profilePicturePage.hardWait(3);
		Assert.assertTrue(clubLogoPage.isProfilePictureDisplayed());

		logger.info("Ending of verifyChooseEventLogoFunctionality method");
	}

	@Test(priority = 3, description = "Verify Change logo functionality", groups = "sanity")
	@Description("Test case #3, Verify Change logo functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify Change logo functionality")
	public void verifyEditEventLogoFunctionality() {
		logger.info("Starting of verifyEditEventLogoFunctionality method");

		profilePicturePage.hardWait(3);
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

	@Test(priority = 5, description = "Verify the state of save button", groups = "sanity")
	@Description("Test case #5, Verify the state of save button")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify the state of save button")
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

	@Test(priority = 6, description = "Verify remove logo functionality", groups = "sanity")
	@Description("Test case #6, Verify remove logo functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify remove logo functionality")
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
