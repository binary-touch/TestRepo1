package com.b2b.test.sprint2.sanity;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.events.EditBracketsPage;
import com.dupr.pages.events.EditEventsPage;
import com.dupr.test.CommonBaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("DUPR App")
@Feature("Edit Bracket Sanity")
public class EditBracketsTest extends CommonBaseTest {
	private static final Logger logger = Logger.getLogger(EditBracketsTest.class.getName());

	private EditEventsPage editEventsPage = null;
	private EditBracketsPage editBracketsPage = null;
	private static String eventNameForEditBrackets = null;

	private static String playGroup = null;
	private static String EventType = null;
	private static String TimeZone = null;
	private static String playGroupReset = null;
	private static String EventTypeReset = null;
	private static String TimeZoneReset = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String directorEmail, String directorPassword)
			throws Exception {
		logger.info("Starting of initMethod in EditBracketsTest");

		this.driver = super.getWebDriver(WebDriversEnum.EDIT_BRACKETS_DRIVER);
		super.initCommonBaseTest(siteURL, directorEmail, directorPassword);

		this.editEventsPage = new EditEventsPage(this.driver);
		this.editBracketsPage = new EditBracketsPage(this.driver);

		logger.info("Ending of initMethod in EditBracketsTest");
	}

	public void verifyFreeEventFunctionality() {
		logger.info("Starting of verifyFreeEventFunctionality method");

		addEventPage.hardWait(3);

		super.verifyAddEventFunctionality();

		eventNameForEditBrackets = addEventPage.setEventName(testDataProp.getProperty("event.name"));
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

	@Test(priority = 1, description = "Verify Edit Brackets Button functionality in Bracket page", groups = "sanity")
	@Description("Test case #1, Verify Edit Brackets Button functionality in Bracket page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Edit Brackets Button functionality in Bracket page")
	public void verifyEditBracketFunctionalityInBracketPage() {
		logger.info("Starting of verifyEditBracketFunctionalityInBracketPage method");

		clubLogoPage.hardWait(3);
		this.verifyFreeEventFunctionality();
		clubLogoPage.hardWait(3);
		addEventPage.clickOnEventsTab();
		clubLogoPage.hardWait(3);
		addEventPage.clickOnRecentlyAddedEvent(eventNameForEditBrackets);
		editEventsPage.hardWait(2);
		editBracketsPage.clickOnBracketLabel();
		editEventsPage.hardWait(2);
		editBracketsPage.clickOnEditBracketButton();

		logger.info("Ending of verifyEditBracketFunctionalityInBracketPage method");
	}

	@Test(priority = 2, description = "Verify the Details displayed in Edit Bracket Page", groups = "sanity")
	@Description("Test case #2, Verify the Details displayed in Edit Bracket Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify the Details displayed in Edit Bracket Page")
	public void verifyTheDetailsDisplayedInEditBracketPage() {
		logger.info("Starting of verifyTheDetailsDisplayedInEditBracketPage method");

		clubLogoPage.hardWait(3);
		Assert.assertTrue(editBracketsPage.isEditBracketsPageContains());
		Assert.assertEquals(editBracketsPage.getEditBrackettxt(), expectedAssertionsProp.getProperty("edit.bracket"));

		logger.info("Ending of verifyTheDetailsDisplayedInEditBracketPage method");
	}

	@Test(priority = 3, description = "Verify Cancel button functionality in Edit Bracket Page", groups = "sanity")
	@Description("Test case #3, Verify Cancel button functionality in Edit Bracket Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify Cancel button functionality in Edit Bracket Page")
	public void verifyCancelFunctionalityInEditBracketPage() {
		logger.info("Starting of verifyCancelFunctionalityInEditBracketPage method");

		clubLogoPage.hardWait(3);
		editBracketsPage.clickOnCancelButton();
		editBracketsPage.hardWait(2);
		editBracketsPage.clickOnEditBracketButton();
		playGroup = editBracketsPage.getPlayerGroupFieldTxt();
		EventType = editBracketsPage.getEventTypeFieldTxt();
		TimeZone = editBracketsPage.getTimeZoneFieldTxt();

		logger.info("Ending of verifyCancelFunctionalityInEditBracketPage method");
	}

	@Test(priority = 4, description = "Verify Reset button functionality in Edit Bracket Page", groups = "sanity")
	@Description("Test case #4, Verify Reset button functionality in Edit Bracket Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify Reset button functionality in Edit Bracket Page")
	public void verifyResetFunctionalityInEditBracketPage() {
		logger.info("Starting of verifyResetFunctionalityInEditBracketPage method");

		clubLogoPage.hardWait(3);
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

		logger.info("Ending of verifyResetFunctionalityInEditBracketPage method");
	}

	@Test(priority = 5, description = "Verify Save changes button functionality in Edit Bracket Page", groups = "sanity")
	@Description("Test case #5, Verify save changes button functionality in Edit Bracket Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify save changes button functionality in Edit Bracket Page")
	public void verifySaveChangesFunctionalityInEditBracketPage() {
		logger.info("Starting of verifySaveChangesFunctionalityInEditBracketPage method");

		clubLogoPage.hardWait(3);
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

		logger.info("Ending of verifySaveChangesFunctionalityInEditBracketPage method");
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
