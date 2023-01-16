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
import com.dupr.pages.events.EditBracketsPage;
import com.dupr.pages.events.EditEventsPage;
import com.dupr.test.DUPRBaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class EditBracketsTest extends DUPRBaseAutomationTest {
	private static final Logger logger = Logger.getLogger(EditBracketsTest.class.getName());
	private ClubLogoPage clubLogoPage = null;
	private EditEventsPage editEventsPage = null;
	private BrowseEventsPage browseEventsPage = null;
	private EditBracketsPage editBracketsPage = null;
	private static String playGroup = null;
	private static String EventType = null;
	private static String TimeZone = null;
	private static String playGroupReset = null;
	private static String EventTypeReset = null;
	private static String TimeZoneReset = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String email, String password) throws Exception {
		logger.info("Starting of initMethod in ClubLogoTest");

		this.driver = super.getWebDriver(WebDriversEnum.EDIT_BRACKETS_DRIVER);
		this.siteLogin(siteURL, email, password, this.driver);

		this.clubLogoPage = new ClubLogoPage(this.driver);
		this.editEventsPage = new EditEventsPage(this.driver);
		this.browseEventsPage = new BrowseEventsPage(this.driver);
		this.editBracketsPage = new EditBracketsPage(this.driver);

		logger.info("Ending of initMethod in ClubLogoTest");
	}

	@Test(priority = 1, description = "Verify edit Bracket functionality", groups = "sanity")
	@Description("Test case #1, Verify edit Bracket functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify edit Bracket functionality")
	public void verifyEditBracketFunctionality() {
		logger.info("Starting of verifyAddLogoFunctionality method");
		browseEventsPage.clickOnMyEventButton();
		clubLogoPage.hardWait(3);
		editEventsPage.clickOnEventLabel();
		editEventsPage.hardWait(2);
		editBracketsPage.clickOnBracketLabel();
		editEventsPage.hardWait(2);
		editBracketsPage.clickOnEditBracketButton();
		logger.info("Ending of verifyAddLogoFunctionality method");
	}

	@Test(priority = 2, description = "Verify edit Bracket Page", groups = "sanity")
	@Description("Test case #1, Verify edit Bracket Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify edit Bracket Page")
	public void verifyEditBracketPage() {
		logger.info("Starting of verifyAddLogoPage method");

		Assert.assertTrue(editBracketsPage.isEditBracketsPageContains());
		Assert.assertEquals(editBracketsPage.getEditBrackettxt(), expectedAssertionsProp.getProperty("edit.bracket"));

		logger.info("Ending of verifyAddLogoPage method");
	}

	@Test(priority = 2, description = "Verify Cancel button functionality", groups = "sanity")
	@Description("Test case #2, Verify Cancel button functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify Cancel button functionality")
	public void verifyCancelFunctionality() {
		logger.info("Starting of verifyCancelFunctionality method");

		editBracketsPage.clickOnCancelButton();
		editBracketsPage.hardWait(2);
		editBracketsPage.clickOnEditBracketButton();
		playGroup = editBracketsPage.getPlayerGroupFieldTxt();
		EventType = editBracketsPage.getEventTypeFieldTxt();
		TimeZone = editBracketsPage.getTimeZoneFieldTxt();

		logger.info("Ending of verifyCancelFunctionality method");
	}

	@Test(priority = 3, description = "Verify Reset button functionality", groups = "sanity")
	@Description("Test case #3, Verify Reset button functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify Reset button functionality")
	public void verifyResetFunctionality() {
		logger.info("Starting of verifyResetFunctionality method");

		editBracketsPage.clickOnPlayerGroupField();
		editBracketsPage.selectMen();
		editBracketsPage.hardWait(1);
		editBracketsPage.clickOnEventTypeField();
		editBracketsPage.selectWaterfall();
		editBracketsPage.hardWait(1);
		editBracketsPage.clickOnTimeZoneField();
		editBracketsPage.selectAlaskan();
		editBracketsPage.hardWait(1);
		editBracketsPage.clickOnResetButton();
		playGroupReset = editBracketsPage.getPlayerGroupFieldTxt();
		EventTypeReset = editBracketsPage.getEventTypeFieldTxt();
		TimeZoneReset = editBracketsPage.getTimeZoneFieldTxt();

		logger.info("Ending of verifyResetFunctionality method");
	}

	@Test(priority = 4, description = "Verify Save changes button functionality", groups = "sanity")
	@Description("Test case #4, Verify save changes button functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify save changes button functionality")
	public void verifySaveChangesFunctionality() {
		logger.info("Starting of verifySaveChangesFunctionality method");

		System.out.println(!(playGroup.equals(playGroupReset)));
		System.out.println(!(EventType.equals(EventTypeReset)));
		System.out.println(!(TimeZone.equals(TimeZoneReset)));

		try {
			if (!(playGroup.equals(playGroupReset) && EventType.equals(EventTypeReset)
					&& TimeZone.equals(TimeZoneReset))) {
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		editBracketsPage.clickOnSaveChangesButton();

		logger.info("Ending of verifySaveChangesFunctionality method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.EDIT_BRACKETS_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}
}
