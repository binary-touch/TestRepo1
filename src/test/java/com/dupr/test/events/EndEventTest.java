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
import com.dupr.pages.events.EndEventPage;
import com.dupr.test.DUPRBaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic(value = "Events")
@Feature(value = "End Event")

public class EndEventTest extends DUPRBaseAutomationTest {
	private static final Logger logger = Logger.getLogger(EndEventTest.class.getName());
	private ClubLogoPage clubLogoPage = null;
	private BrowseEventsPage browseEventsPage = null;
	private EndEventPage endEventpage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String directorEmail, String directorPassword)
			throws Exception {
		logger.info("Starting of initMethod in EndEventTest");

		this.driver = super.getWebDriver(WebDriversEnum.END_EVENT_DRIVER);
		this.siteLogin(siteURL, directorEmail, directorPassword, this.driver);

		this.clubLogoPage = new ClubLogoPage(this.driver);
		this.browseEventsPage = new BrowseEventsPage(this.driver);
		this.endEventpage = new EndEventPage(this.driver);

		logger.info("Ending of initMethod in EndEventTest");
	}

	@Test(priority = 1, description = "Verify End event functionality", groups = "sanity")
	@Description("Test case #1, Verify Add End event functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Add End event functionality")
	public void verifyEndEventFunctionality() {
		logger.info("Starting of verifyEndEventFunctionality method");

		clubLogoPage.hardWait(3);
		browseEventsPage.clickOnMyEventButton();
		clubLogoPage.hardWait(3);
		endEventpage.clickOnEventLabel();
		endEventpage.hardWait(2);
		Assert.assertTrue(endEventpage.isEndEventPopupContains());
		Assert.assertEquals(endEventpage.getEndEventTxt(), expectedAssertionsProp.getProperty("end.event"));
		Assert.assertEquals(endEventpage.getWarningTxt(), expectedAssertionsProp.getProperty("warning.msg"));
		Assert.assertEquals(endEventpage.getAreYouSureToEndEvent(), expectedAssertionsProp.getProperty("are.you.sure"));

		logger.info("Ending of verifyEndEventFunctionality method");
	}

	@Test(priority = 2, description = "Verify cancel button functionality in end event popup", groups = "sanity")
	@Description("Test case #2, Verify cancel button functionality in end event popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify Cancel button functionality")
	public void verifyCancelButtonFunctionality() {
		logger.info("Starting of verifyCancelButtonFunctionality method");

		endEventpage.clickOnCancelButton();
		endEventpage.hardWait(2);

		Assert.assertFalse(endEventpage.isEndEventPopupContains());
		Assert.assertEquals(endEventpage.getEventTxt(), expectedAssertionsProp.getProperty("event.txt"));

		logger.info("Ending of verifyCancelButtonFunctionality method");
	}

	@Test(priority = 3, description = "Verify close icon functionality in end event popup", groups = "sanity")
	@Description("Test case #3, Verify close icon functionality in end event popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify close icon functionality")
	public void verifyCloseIconFunctionality() {
		logger.info("Starting of verifyCloseIconFunctionality method");

		endEventpage.clickOnEndEventButton();
		endEventpage.hardWait(2);
		endEventpage.clickOnCloseIcon();

		Assert.assertFalse(endEventpage.isEndEventPopupContains());
		Assert.assertEquals(endEventpage.getEventTxt(), expectedAssertionsProp.getProperty("event.txt"));

		logger.info("Ending of verifyCloseIconFunctionality method");
	}

	@Test(priority = 4, description = "Verify End EVent button functionality in end event popup", groups = "sanity")
	@Description("Test case #4, Verify End Event button functionality in end event popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify End Event button functionality")
	public void verifyEndEventButtonFunctionality() {
		logger.info("Starting of verifyEndEventButtonFunctionality method");

		endEventpage.clickOnEndEventButton();
		endEventpage.hardWait(2);
		endEventpage.clickOnConfirmEndEventButton();
		endEventpage.hardWait(3);
		Assert.assertEquals(endEventpage.getEventTxt(), expectedAssertionsProp.getProperty("event.txt"));
		Assert.assertTrue(endEventpage.isEndEventPageContains());
		Assert.assertTrue(endEventpage.getBracketsStatusText());

		logger.info("Ending of verifyEndEventButtonFunctionality method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.END_EVENT_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}
}
