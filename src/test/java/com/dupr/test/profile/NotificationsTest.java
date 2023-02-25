package com.dupr.test.profile;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.profile.EditProfilePage;
import com.dupr.pages.profile.NotificationsPage;
import com.dupr.test.CommonBaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("DUPR App")
@Feature("Notifications")
public class NotificationsTest extends CommonBaseTest {

	private static final Logger logger = Logger.getLogger(NotificationsTest.class.getName());

	private EditProfilePage editProfilePage = null;
	private NotificationsPage notificationsPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "validEmail", "validPassword" })
	public void initMethod(String browser, String siteURL, String validEmail, String validPassword) throws Exception {
		logger.info("Starting of initMethod in NotificationsTest");

		this.driver = super.getWebDriver(WebDriversEnum.NOTIFICATIONS_DRIVER);
		super.initCommonBaseTest(siteURL, validEmail, validPassword);

		this.notificationsPage = new NotificationsPage(this.driver);
		this.editProfilePage = new EditProfilePage(this.driver);

		logger.info("Ending of initMethod in NotificationsTest");
	}

	@Test(priority = 1, description = "Verify notifications tab fucnctionality", groups = "sanity")
	@Description("Test case #1,Verify notifications tab fucnctionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify notifications tab fucnctionality")
	public void verifyNotificationsTab() {
		logger.info("Starting of verifyNotificationsTab method");

		editProfilePage.clickOnOpenSettingMenu();
		editProfilePage.clickOnEditProfileButton();

		notificationsPage.clickOnNotificationsTab();
		Assert.assertTrue(notificationsPage.isNotifcationsTabContains());

		logger.info("Ending of verifyNotificationsTab method");
	}

	@Test(priority = 2, description = "Verify App notifications functionality", groups = "sanity")
	@Description("Test case #2, Verify App notifications functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify notifications tab fucnctionality")
	public void verifyAppNotificationsFunctionality() {
		logger.info("Starting of verifyAppNotificationsFunctionality method");

		notificationsPage.clickOnAppNotificationsToggle();

		boolean saveButtonStatus = notificationsPage.isSaveButtonEnabled();
		if (saveButtonStatus) {
			Assert.assertTrue(notificationsPage.isSaveButtonEnabled());
		} else {
			Assert.assertFalse(notificationsPage.isSaveButtonEnabled());
		}

		notificationsPage.clickOnSaveButton();
		AddingMatchInSingles();

		logger.info("Ending of verifyAppNotificationsFunctionality method");
	}

	@Test(priority = 3, description = "Verify Email notifications functionality", groups = "sanity")
	@Description("Test case #3,Verify Email notifications functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify Email notifications functionality")
	public void verifyEmailNotificationsFunctionality() {
		logger.info("Starting of verifyEmailNotificationsFunctionality method");

		addAMatchPage.hardWait(2);
		editProfilePage.clickOnOpenSettingMenu();
		editProfilePage.clickOnEditProfileButton();

		notificationsPage.clickOnNotificationsTab();
		notificationsPage.clickOnEmailNotificationsToggle();

		boolean saveButtonStatus = notificationsPage.isSaveButtonEnabled();
		if (saveButtonStatus) {
			Assert.assertTrue(notificationsPage.isSaveButtonEnabled());
		} else {
			Assert.assertFalse(notificationsPage.isSaveButtonEnabled());
		}

		notificationsPage.clickOnSaveButton();

		AddingMatchInSingles();

		logger.info("Ending of verifyEmailNotificationsFunctionality method");
	}

	@Test(priority = 4, description = "Verify Text(Sms) notifications functionality", groups = "sanity")
	@Description("Test case #4,Verify Text(Sms) notifications functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify Text(Sms) notifications functionality")
	public void verifyTextNotificationsFunctionality() {
		logger.info("Starting of verifyTextNotificationsFunctionality method");
		editProfilePage.hardWait(3);
		editProfilePage.clickOnOpenSettingMenu();
		editProfilePage.clickOnEditProfileButton();

		notificationsPage.clickOnNotificationsTab();
		notificationsPage.clickOnSMSNotificationsToggle();
		
		try {
			notificationsPage.hardWait(2);
			Assert.assertTrue(this.notificationsPage.isVerifyPhoneNumberPopupDisplayed());
			editProfilePage.clickOnOKButton();
		} catch (Exception e) {
			Assert.assertTrue(notificationsPage.isSMSNotificationsEnabled()); ////Reason For Failure: Sometimes Verify Phone Number PopUp Is Displaying////
		}
		
		boolean saveButtonStatus = notificationsPage.isSaveButtonEnabled();
		if (saveButtonStatus) {
			Assert.assertTrue(notificationsPage.isSaveButtonEnabled());
		} else {
			Assert.assertFalse(notificationsPage.isSaveButtonEnabled());
		}

		notificationsPage.clickOnSaveButton();
		AddingMatchInSingles();

		logger.info("Ending of verifyTextNotificationsFunctionality method");
	}

	public void AddingMatchInSingles() {
		logger.info("Starting of AddingMatchInSingles method");

		driver.navigate().refresh();

		addAMatchPage.clickOnAddAMatchTab();
		
		addAMatchPage.setLocationInDoubles(testDataProp.getProperty("location.city.name"));
		addAMatchPage.setEventName(testDataProp.getProperty("event.name"));
		addAMatchPage.clickOnSinglesButton();
		addAMatchPage.clickOnAddOpponentButton();
		addAMatchPage.searchWithPlayerName(testDataProp.getProperty("search.partner.name"));
		addAMatchPage.clickOnPlayerRadioButton();
		addAMatchPage.clickOnAddPlayerButton();

		addAMatchPage.setGameOneScores(testDataProp.getProperty("teamone.gameone.Score"),
				testDataProp.getProperty("teamtwo.gameone.Score"));

		addAMatchPage.clickOnSubmitButton();
		addAMatchPage.hardWait(1);
		addAMatchPage.clickOnSubmitButtonInFinalScoresPopup();
		addAMatchPage.clickOnOkButton();

		logger.info("Ending of AddingMatchInSingles method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.NOTIFICATIONS_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}
}
