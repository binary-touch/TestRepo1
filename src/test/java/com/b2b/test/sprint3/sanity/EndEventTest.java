package com.b2b.test.sprint3.sanity;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.events.EndEventPage;
import com.dupr.test.CommonBaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic(value = "Events")
@Feature(value = "End Event Sanity")

public class EndEventTest extends CommonBaseTest {
	private static final Logger logger = Logger.getLogger(EndEventTest.class.getName());

	private EndEventPage endEventpage = null;
	private static String eventNameForEndEvent = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String directorEmail, String directorPassword)
			throws Exception {
		logger.info("Starting of initMethod in EndEventTest");

		this.driver = super.getWebDriver(WebDriversEnum.END_EVENT_DRIVER);
		super.initCommonBaseTest(siteURL, directorEmail, directorPassword);

		this.endEventpage = new EndEventPage(this.driver);

		logger.info("Ending of initMethod in EndEventTest");
	}

	public void verifyFreeEventFunctionality() {
		logger.info("Starting of verifyFreeEventFunctionality method");

		addEventPage.hardWait(3);

		super.verifyAddEventFunctionality();

		eventNameForEndEvent = addEventPage.setEventName(testDataProp.getProperty("event.name"));
		addEventPage.setLocation(testDataProp.getProperty("state.address"));

		addEventPage.uploadEventLogo(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("edit.club.logo.path"));
		addEventPage.setMemberPrice(testDataProp.getProperty("zero.value"));
		addEventPage.setNonMemberPrice(testDataProp.getProperty("zero.value"));
		addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.event"));
		addEventPage.clickonTextFormattingButtons();
		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addEventPage.isEventPoliciesPageContains());

		addBracketPage.hardWait(3);
		this.verifyEventPoliciesPageByEnteringValidDetails();

		addBracketPage.hardWait(3);
		super.verifyAddBracketsFunctionalityWithValidDetails();

		addBracketPage.hardWait(3);
		this.verifyNoContinueToSummaryButtonInAddAnotherBracketpopup();

		addBracketPage.hardWait(3);
		this.verifyPublishEventButton();

		logger.info("Ending of verifyFreeEventFunctionality method");
	}

	@Test(priority = 1, description = "Verify End event functionality in Event page", groups = "sanity")
	@Description("Test case #1, Verify End event functionality in Event page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify End event functionality in Event page")
	public void verifyEndEventFunctionality() {
		logger.info("Starting of verifyEndEventFunctionality method");

		clubLogoPage.hardWait(3);

		this.verifyFreeEventFunctionality();
		clubLogoPage.hardWait(3);

		addEventPage.clickOnEventsTab();
		addEventPage.hardWait(3);

		addEventPage.clickOnRecentlyAddedEvent(eventNameForEndEvent);
		addEventPage.hardWait(2);

		endEventpage.clickOnEndEventButton();
		endEventpage.hardWait(2);
		Assert.assertTrue(endEventpage.isEndEventPopupContains());
		Assert.assertEquals(endEventpage.getEndEventTxt(), expectedAssertionsProp.getProperty("end.event"));
		Assert.assertEquals(endEventpage.getWarningTxt(), expectedAssertionsProp.getProperty("warning.msg"));
		Assert.assertEquals(endEventpage.getAreYouSureToEndEvent(), expectedAssertionsProp.getProperty("are.you.sure"));

		logger.info("Ending of verifyEndEventFunctionality method");
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
