package com.dupr.test.events;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.clubs.ClubLogoPage;
import com.dupr.pages.events.BrowseEventsPage;
import com.dupr.pages.events.EditEventsPage;
import com.dupr.test.DUPRBaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class EditEventsTest extends DUPRBaseAutomationTest {
	private static final Logger logger = Logger.getLogger(EditEventsTest.class.getName());
	private ClubLogoPage clubLogoPage = null;
	private EditEventsPage editEventsPage = null;
	private BrowseEventsPage browseEventsPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String directorEmail, String directorPassword) throws Exception {
		logger.info("Starting of initMethod in ClubLogoTest");

		this.driver = super.getWebDriver(WebDriversEnum.EDIT_EVENTS_DRIVER);
		this.siteLogin(siteURL, directorEmail, directorPassword, this.driver);
		this.clubLogoPage = new ClubLogoPage(this.driver);
		this.editEventsPage = new EditEventsPage(this.driver);
		this.browseEventsPage = new BrowseEventsPage(this.driver);

		logger.info("Ending of initMethod in ClubLogoTest");
	}

	@Test(priority = 1, description = "Verify Edit event functionality", groups = "sanity")
	@Description("Test case #1, Verify Edit events functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Edit events functionality")

	public void verifyEditEventsFunctionality() {
		logger.info("Starting of verifyEditEventsFunctionality method");

		browseEventsPage.clickOnMyEventButton();
		clubLogoPage.hardWait(3);
		editEventsPage.clickOnEventLabel();
		editEventsPage.hardWait(2);
		editEventsPage.clickOnEditEvent();
		editEventsPage.hardWait(2);
		editEventsPage.clickOnCancel();
		editEventsPage.hardWait(2);
		editEventsPage.clickOnEditEvent();
		editEventsPage.hardWait(2);
		Assert.assertEquals(editEventsPage.getEditEventsText(), expectedAssertionsProp.getProperty("edit.event.txt"));
		Assert.assertTrue(editEventsPage.isEditEventsPageContains());

		logger.info("Ending of verifyEditEventsFunctionality method");
	}

	@Test(priority = 2, description = "Verify Event Name Field", groups = "sanity")
	@Description("Test case #2, Verify event name field")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify event name field")

	public void verifyEditName() {
		logger.info("Starting of verifyEditName method");

		Assert.assertEquals(editEventsPage.getEventNameText(), expectedAssertionsProp.getProperty("event.name.txt"));
		editEventsPage.clickOnEventName(testDataProp.getProperty("event.name"));

		logger.info("Ending of verifyEditName method");
	}

	@Test(priority = 3, description = "Verify about the event Field", groups = "sanity")
	@Description("Test case #3, Verify about the event field")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify about the event field")

	public void verifyAboutTheEvent() {
		logger.info("Starting of verifyAboutTheEvent method");

		Assert.assertEquals(editEventsPage.getAboutEventText(), expectedAssertionsProp.getProperty("about.event.txt"));

		editEventsPage.clickOnAboutEvent(testDataProp.getProperty("about.the.event"));

		logger.info("Ending of verifyAboutTheEvent method");
	}

	@Test(priority = 4, description = "Verify Edit Event page", groups = "sanity")
	@Description("Test case #4, Verify Edit Event page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify Edit Event page")

	public void verifyEditEvent() {
		logger.info("Starting of verifyEditEvent method");

		Assert.assertEquals(editEventsPage.getEntryFeeText(), expectedAssertionsProp.getProperty("entry.fee"));
		Assert.assertEquals(editEventsPage.getMembersText(), expectedAssertionsProp.getProperty("member.price"));
		Assert.assertEquals(editEventsPage.getNonMemberText(), expectedAssertionsProp.getProperty("nonmember.price"));
		Assert.assertEquals(editEventsPage.getLiabilityWaiverText(),
				expectedAssertionsProp.getProperty("liability.waiver"));

		logger.info("Ending of verifyEditEvent method");
	}

	@Test(priority = 5, description = "Verify Liability Waiver Field", groups = "sanity")
	@Description("Test case #5, Verify Liability Waiver field")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify Liability Waiver field")

	public void verifyLiabilityWaiver() {
		logger.info("Starting of verifyLiabilityWaiver method");

		try {
			if (editEventsPage.btnReplace() == true) {

				editEventsPage.ClickOnRemoveButton();
				clubLogoPage
						.uploadProfilePicture(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("club.logo.path"));
			}

		} catch (Exception e) {
			clubLogoPage.uploadProfilePicture(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("club.logo.path"));

		}

		logger.info("Ending of verifyLiabilityWaiver method");
	}

	@Test(priority = 6, description = "Verify Refund Policy Field", groups = "sanity")
	@Description("Test case #6, Verify Refund Policy field")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify Refund Policy field")

	public void verifyRefundPolicy() {
		logger.info("Starting of verifyRefundPolicy method");
		Assert.assertEquals(editEventsPage.getRefundPolicyText(),
				expectedAssertionsProp.getProperty("refund.policy"));

		editEventsPage.editRefundPolicy(testDataProp.getProperty("refund.policy"));

		logger.info("Ending of verifyRefundPolicy method");
	}

	@Test(priority = 7, description = "Verify Health and Safety Policy Field", groups = "sanity")
	@Description("Test case #7, Verify Health and Safety Policy field")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Verify Health and Safety Policy field")

	public void verifyHealthAndSafetyPolicy() {
		logger.info("Starting of verifyHealthAndSafetyPolicy method");
		Assert.assertEquals(editEventsPage.getHealthSafetyText(),
				expectedAssertionsProp.getProperty("health.and.safety"));

		editEventsPage.clickOnHealthSafety(testDataProp.getProperty("health.policy"));

		logger.info("Ending of verifyHealthAndSafetyPolicy method");
	}

	@Test(priority = 8, description = "Verify save changes button", groups = "sanity")
	@Description("Test case #8, Verify save changes button")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Verify save changes button")

	public void verifySaveChanges() {
		logger.info("Starting of verifySaveChanges method");

		editEventsPage.clickOnSaveChanges();

		logger.info("Ending of verifySaveChanges method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.EDIT_EVENTS_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}
}
