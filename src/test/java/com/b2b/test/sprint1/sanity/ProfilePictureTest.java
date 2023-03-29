package com.b2b.test.sprint1.sanity;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.profile.ProfilePicturePage;
import com.dupr.test.CommonBaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("DUPR App")
@Feature("Profie Picture-Sanity")
public class ProfilePictureTest extends CommonBaseTest {

	private static final Logger logger = Logger.getLogger(ProfilePictureTest.class.getName());
	private ProfilePicturePage profilePicturePage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "validEmail", "validPassword" })
	public void initMethod(String browser, String siteURL, String email, String password) throws Exception {
		logger.info("Starting of initMethod in ProfilePictureTest");

		this.driver = super.getWebDriver(WebDriversEnum.PROFILE_PICTURE_DRIVER);
		super.initCommonBaseTest(siteURL, email, password);

		this.profilePicturePage = new ProfilePicturePage(this.driver);

		logger.info("Ending of initMethod in ProfilePictureTest");
	}

	@Test(priority = 1, description = "Verify Add profile picture functionality", groups = "sanity")
	@Description("Test case #1, Verify Add profile picture functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Add profile picture  functionality")
	public void verifyAddProfilePicture() {
		logger.info("Starting of verifyAddProfilePicture method");

		profilePicturePage.clickOnOpenSettingsMenu();
		profilePicturePage.clickOnEditProfileButton();
		
		profilePicturePage.hardWait(4);
		profilePicturePage.clickOnCameraIcon();
		
		try {
			if (profilePicturePage.isRemoveProfilePictureButtonDisplayed() == true) {

				profilePicturePage.clickOnRemoveProfilePicture();
				profilePicturePage.hardWait(2);
				profilePicturePage.clickOnYesButton();
				profilePicturePage.hardWait(3);

				profilePicturePage.refresh();
				profilePicturePage.hardWait(3);
				profilePicturePage.clickOnCameraIcon();
			}

		} catch (Exception e) {
			System.out.println("*****Profile picture not displayed*****");
		}
		
		try {
			if (profilePicturePage.isSaveButtonDisabled()==false) {
				driver.navigate().refresh();

				profilePicturePage.hardWait(4);
				profilePicturePage.clickOnCameraIcon();
				profilePicturePage.clickOnChangeProfilePictureButton();
			}
		} catch (Exception e) {
			System.out.println("*****Profile picture popup displayed*****");
		}

		Assert.assertTrue(profilePicturePage.isProfilePicturePopupContains());

		String profilePictureText = profilePicturePage.getProfilePictureText();
		Assert.assertEquals(profilePictureText, expectedAssertionsProp.getProperty("profile.picture.label"));
		
		profilePicturePage.hardWait(3);
		
		Assert.assertTrue(profilePicturePage.isSaveButtonDisabled());

		logger.info("Ending of verifyAddProfilePicture method");
	}

	@Test(priority = 2, description = "Verify Choose profile picture functionality", groups = "sanity")
	@Description("Test case #2, Verify Choose profile picture functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify Choose profile picture functionality")
	public void verifyChooseProfilePictureFunctionality() {
		logger.info("Starting of verifyChooseProfilePictureFunctionality method");

		profilePicturePage
				.uploadProfilePicture(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("profile.picture.path"));
		profilePicturePage.hardWait(3);
		profilePicturePage.clickOnSaveButton();

		profilePicturePage.hardWait(3);
		Assert.assertTrue(profilePicturePage.isProfilePictureDisplayed());

		logger.info("Ending of verifyChooseProfilePictureFunctionality method");
	}

	@Test(priority = 3, description = "Verify Edit Profile picture functionality", groups = "sanity")
	@Description("Test case #3, Verify Edit Profile picture functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify Edit Profile picture functionality")
	public void verifyEditProfilePicture() {
		logger.info("Starting of verifyEditProfilePicture method");

		profilePicturePage.clickOnCameraIcon();

		Assert.assertTrue(profilePicturePage.isChangeProfilePictureButtonDisplayed());
		Assert.assertTrue(profilePicturePage.isRemoveProfilePictureButtonDisplayed());

		logger.info("Ending of verifyEditProfilePicture method");
	}

	@Test(priority = 4, description = "Verify Change Profile picture button functionality", groups = "sanity")
	@Description("Test case #4, Verify Change Profile picture button functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify Change Profile picture button functionality")
	public void verifyClickOnChangeProfilePicture() {
		logger.info("Starting of verifyClickOnChangeProfilePicture method");

		profilePicturePage.clickOnChangeProfilePictureButton();

		Assert.assertTrue(profilePicturePage.isProfilePicturePopupContains());
		Assert.assertTrue(profilePicturePage.isSaveButtonDisplayed());
		Assert.assertTrue(profilePicturePage.isPreviousUploadedImageDisplayed());
		profilePicturePage.hardWait(2);
		profilePicturePage.uploadProfilePicture(
				BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("edit.profile.picture.path"));
		profilePicturePage.hardWait(3);
		profilePicturePage.clickOnSaveButton();

		profilePicturePage.hardWait(3);
		Assert.assertTrue(profilePicturePage.isProfilePictureDisplayed());
		
		try {
			if(profilePicturePage.isSaveButtonDisplayed()) {
				driver.navigate().refresh();
				profilePicturePage.hardWait(3);
			}
		} catch (Exception e) {
			logger.info("*** Profile Picture popup haven't displayed ***");
		}	

		logger.info("Ending of verifyClickOnChangeProfilePicture method");
	}

	@Test(priority = 5, description = "Verify remove profile picture functionality", groups = "sanity")
	@Description("Test case #5, Verify remove profile picture functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify remove profile picture functionality")
	public void verifyRemoveProfilePicture() {
		logger.info("Starting of verifyRemoveProfilePicture method");

		profilePicturePage.clickOnCameraIcon();
		profilePicturePage.hardWait(3);
		profilePicturePage.clickOnRemoveProfilePicture();

		Assert.assertTrue(profilePicturePage.isRemoveProfilePicturePopupContains());

		profilePicturePage.clickOnYesButton();
		profilePicturePage.hardWait(2);

		Assert.assertFalse(profilePicturePage.isProfilePictureDisplayed());

		logger.info("Ending of verifyRemoveProfilePicture method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.PROFILE_PICTURE_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
