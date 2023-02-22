package com.dupr.test.events;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.events.CombinationOfMatchTypeAndPlayerGroupPage;
import com.dupr.test.CommonBaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class CombinationOfMatchTypeAndPlayerGroupTest extends CommonBaseTest {

	private static final Logger logger = Logger.getLogger(CombinationOfMatchTypeAndPlayerGroupTest.class.getName());
	private CombinationOfMatchTypeAndPlayerGroupPage combinationOfMatchTypeAndPlayerGroupPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String directorEmail, String directorPassword)
			throws Exception {
		logger.info("Starting of initMethod in CombinationOfMatchTypeAndPlayerGroupTest");

		this.driver = super.getWebDriver(WebDriversEnum.COMBINATION_OF_MATCHTYPE_AND_PLAYERGROUP_DRIVER);
		super.initCommonBaseTest(siteURL, directorEmail, directorPassword);

		this.combinationOfMatchTypeAndPlayerGroupPage = new CombinationOfMatchTypeAndPlayerGroupPage(this.driver);

		logger.info("Ending of initMethod in CombinationOfMatchTypeAndPlayerGroupTest");
	}

	@Test(priority = 1, description = "verifyBracketWithMatchTypeSingleAndMixedPlayerGroup", groups = "sanity")
	@Description("Test case #1, verify RegistVerifyBracketWithMatchTypeSingleAndMixedPlayerGroup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, verifyBracketWithMatchTypeSingleAndMixedPlayerGroup")
	public void verifyBracketWithMatchTypeSingleAndMixedPlayerGroup() {
		logger.info("Starting of verifyBracketWithMatchTypeSingleAndMixedPlayerGroup method");

		super.verifyAddEventFunctionality();
		super.verifyEventInformationPageWithValidDetails();
		super.verifyEventPoliciesPageByEnteringValidDetails();

		addBracketPage.clickOnMatchTypeDropdown();
		Assert.assertTrue(addBracketPage.isMatchTypeListContains());
		addBracketPage.selectSinglesMatchType();
		Assert.assertTrue(addBracketPage.isSelectedMatchTypeDisplayed());

		addBracketPage.clickOnPlayGroupDropdown();
		Assert.assertTrue(addBracketPage.isPlayerGroupListDisplayed());
		addBracketPage.selectMixedPlayerGroup();
		Assert.assertTrue(addBracketPage.isSelectedPlayerGroupTypeDisplayed());

		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(combinationOfMatchTypeAndPlayerGroupPage.isPlayerGroupWithSingleAndMixedDisplayed());

		logger.info("Ending of verifyBracketWithMatchTypeSingleAndMixedPlayerGroup method");
	}

	@Test(priority = 2, description = "verifyBracketWithMatchTypeSingleAndOpenPlayerGroup", groups = "sanity")
	@Description("Test case #2, verifyBracketWithMatchTypeSingleAndOpenPlayerGroup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, verifyBracketWithMatchTypeSingleAndOpenPlayerGroup")
	public void verifyBracketWithMatchTypeSingleAndOpenPlayerGroup() {
		logger.info("Starting of verifyBracketWithMatchTypeSingleAndOpenPlayerGroup method");

		addBracketPage.clickOnMatchTypeDropdown();
		Assert.assertTrue(addBracketPage.isMatchTypeListContains());
		addBracketPage.selectSinglesMatchType();
		Assert.assertTrue(addBracketPage.isSelectedMatchTypeDisplayed());

		addBracketPage.clickOnPlayGroupDropdown();
		Assert.assertTrue(addBracketPage.isPlayerGroupListDisplayed());
		addBracketPage.selectOpenPlayerGroup();
		Assert.assertTrue(addBracketPage.isSelectedPlayerGroupTypeDisplayed());

		super.verifyBracketWithoutEnteringDetailsIntoMatchTypeAndPlayerGroup();
		super.VerifyRecentlyAddedEventUnderEventsTab();

		Assert.assertTrue(combinationOfMatchTypeAndPlayerGroupPage.isOpenSinglesCardDisplayed());

		logger.info("Ending of verifyBracketWithMatchTypeSingleAndOpenPlayerGroup method");
	}

	@Test(priority = 3, description = "verifyBracketWithMatchTypeSingleAndOpenPlayerGroup", groups = "sanity")
	@Description("Test case #3, verifyBracketWithMatchTypeSingleAndOpenPlayerGroup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, verifyBracketWithMatchTypeSingleAndOpenPlayerGroup")
	public void verifyBracketWithMatchTypeSingleAndMenPlayerGroup() {
		logger.info("Starting of verifyBracketWithMatchTypeSingleAndOpenPlayerGroup method");

		driver.navigate().back();
		addEventPage.clickOnAddEventButton();
		super.verifyEventInformationPageWithValidDetails();
		super.verifyEventPoliciesPageByEnteringValidDetails();

		addBracketPage.clickOnMatchTypeDropdown();
		Assert.assertTrue(addBracketPage.isMatchTypeListContains());
		addBracketPage.selectSinglesMatchType();
		Assert.assertTrue(addBracketPage.isSelectedMatchTypeDisplayed());

		addBracketPage.clickOnPlayGroupDropdown();
		Assert.assertTrue(addBracketPage.isPlayerGroupListDisplayed());
		addBracketPage.selectMenPlayerGroup();
		Assert.assertTrue(addBracketPage.isSelectedPlayerGroupTypeDisplayed());

		super.verifyBracketWithoutEnteringDetailsIntoMatchTypeAndPlayerGroup();
		super.VerifyRecentlyAddedEventUnderEventsTab();

		Assert.assertTrue(combinationOfMatchTypeAndPlayerGroupPage.isMenSinglesCardDisplayed());

		logger.info("Ending of verifyBracketWithMatchTypeSingleAndOpenPlayerGroup method");
	}

	@Test(priority = 4, description = "verifyBracketWithMatchTypeSingleAndWomenPlayerGroup", groups = "sanity")
	@Description("Test case #4, verifyBracketWithMatchTypeSingleAndWomenPlayerGroup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, verifyBracketWithMatchTypeSingleAndWomenPlayerGroup")
	public void verifyBracketWithMatchTypeSingleAndWomenPlayerGroup() {
		logger.info("Starting of verifyBracketWithMatchTypeSingleAndWomenPlayerGroup method");

		driver.navigate().back();
		addEventPage.clickOnAddEventButton();
		super.verifyEventInformationPageWithValidDetails();
		super.verifyEventPoliciesPageByEnteringValidDetails();

		addBracketPage.clickOnMatchTypeDropdown();
		Assert.assertTrue(addBracketPage.isMatchTypeListContains());
		addBracketPage.selectSinglesMatchType();
		Assert.assertTrue(addBracketPage.isSelectedMatchTypeDisplayed());

		addBracketPage.clickOnPlayGroupDropdown();
		Assert.assertTrue(addBracketPage.isPlayerGroupListDisplayed());
		addBracketPage.selectWomenPlayerGroup();
		Assert.assertTrue(addBracketPage.isSelectedPlayerGroupTypeDisplayed());

		super.verifyBracketWithoutEnteringDetailsIntoMatchTypeAndPlayerGroup();
		super.VerifyRecentlyAddedEventUnderEventsTab();

		Assert.assertTrue(combinationOfMatchTypeAndPlayerGroupPage.isWomenSinglesCardDisplayed());

		logger.info("Ending of verifyBracketWithMatchTypeSingleAndWomenPlayerGroup method");
	}

	@Test(priority = 5, description = "verifyBracketWithMatchTypeDoublesAndMixedPlayerGroup", groups = "sanity")
	@Description("Test case #5, verifyBracketWithMatchTypeDoublesAndMixedPlayerGroup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, verifyBracketWithMatchTypeDoublesAndMixedPlayerGroup")
	public void verifyBracketWithMatchTypeDoublesAndMixedPlayerGroup() {
		logger.info("Starting of verifyBracketWithMatchTypeDoublesAndMixedPlayerGroup method");

		driver.navigate().back();
		addEventPage.clickOnAddEventButton();
		super.verifyEventInformationPageWithValidDetails();
		super.verifyEventPoliciesPageByEnteringValidDetails();

		addBracketPage.clickOnMatchTypeDropdown();
		Assert.assertTrue(addBracketPage.isMatchTypeListContains());
		addBracketPage.selectDoublesMatchType();
		Assert.assertTrue(addBracketPage.isSelectedMatchTypeDisplayed());

		addBracketPage.clickOnPlayGroupDropdown();
		Assert.assertTrue(addBracketPage.isPlayerGroupListDisplayed());
		addBracketPage.selectMixedPlayerGroup();
		Assert.assertTrue(addBracketPage.isSelectedPlayerGroupTypeDisplayed());

		super.verifyBracketWithoutEnteringDetailsIntoMatchTypeAndPlayerGroup();
		super.VerifyRecentlyAddedEventUnderEventsTab();

		Assert.assertTrue(combinationOfMatchTypeAndPlayerGroupPage.isDoublesMixedCardDisplayed());

		logger.info("Ending of verifyBracketWithMatchTypeDoublesAndMixedPlayerGroup method");
	}

	@Test(priority = 6, description = "verifyBracketWithMatchTypedoublesAndOpenPlayerGroup", groups = "sanity")
	@Description("Test case #6, verifyBracketWithMatchTypedoublesAndOpenPlayerGroup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, verifyBracketWithMatchTypedoublesAndOpenPlayerGroup")
	public void verifyBracketWithMatchTypedoublesAndOpenPlayerGroup() {
		logger.info("Starting of verifyBracketWithMatchTypedoublesAndOpenPlayerGroup method");

		driver.navigate().back();
		addEventPage.clickOnAddEventButton();
		super.verifyEventInformationPageWithValidDetails();
		super.verifyEventPoliciesPageByEnteringValidDetails();

		addBracketPage.clickOnMatchTypeDropdown();
		Assert.assertTrue(addBracketPage.isMatchTypeListContains());
		addBracketPage.selectDoublesMatchType();
		Assert.assertTrue(addBracketPage.isSelectedMatchTypeDisplayed());

		addBracketPage.clickOnPlayGroupDropdown();
		Assert.assertTrue(addBracketPage.isPlayerGroupListDisplayed());
		addBracketPage.selectOpenPlayerGroup();
		Assert.assertTrue(addBracketPage.isSelectedPlayerGroupTypeDisplayed());

		super.verifyBracketWithoutEnteringDetailsIntoMatchTypeAndPlayerGroup();
		super.VerifyRecentlyAddedEventUnderEventsTab();

		Assert.assertTrue(combinationOfMatchTypeAndPlayerGroupPage.isDoublesOpenCardDisplayed());

		logger.info("Ending of verifyBracketWithMatchTypedoublesAndOpenPlayerGroup method");
	}

	@Test(priority = 7, description = "verifyBracketWithMatchTypeDoublesMenPlayerGroup", groups = "sanity")
	@Description("Test case #7, verifyBracketWithMatchTypeDoublesMenPlayerGroup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, verifyBracketWithMatchTypeDoublesMenPlayerGroup")
	public void verifyBracketWithMatchTypeDoublesMenPlayerGroup() {
		logger.info("Starting of verifyBracketWithMatchTypeDoublesMenPlayerGroup method");

		driver.navigate().back();
		addEventPage.clickOnAddEventButton();
		super.verifyEventInformationPageWithValidDetails();
		super.verifyEventPoliciesPageByEnteringValidDetails();

		addBracketPage.clickOnMatchTypeDropdown();
		Assert.assertTrue(addBracketPage.isMatchTypeListContains());
		addBracketPage.selectDoublesMatchType();
		Assert.assertTrue(addBracketPage.isSelectedMatchTypeDisplayed());

		addBracketPage.clickOnPlayGroupDropdown();
		Assert.assertTrue(addBracketPage.isPlayerGroupListDisplayed());
		addBracketPage.selectMenPlayerGroup();
		Assert.assertTrue(addBracketPage.isSelectedPlayerGroupTypeDisplayed());

		super.verifyBracketWithoutEnteringDetailsIntoMatchTypeAndPlayerGroup();

		super.VerifyRecentlyAddedEventUnderEventsTab();

		Assert.assertTrue(combinationOfMatchTypeAndPlayerGroupPage.isDoublesMenCardDisplayed());

		logger.info("Ending of verifyBracketWithMatchTypeDoublesMenPlayerGroup method");
	}

	@Test(priority = 8, description = "verifyBracketWithMatchTypeDoublesWomenPlayerGroup", groups = "sanity")
	@Description("Test case #8, verifyBracketWithMatchTypeDoublesWomenPlayerGroup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, verifyBracketWithMatchTypeDoublesWomenPlayerGroup")
	public void verifyBracketWithMatchTypeDoublesWomenPlayerGroup() {
		logger.info("Starting of verifyBracketWithMatchTypeDoublesWomenPlayerGroup method");

		driver.navigate().back();
		addEventPage.clickOnAddEventButton();
		super.verifyEventInformationPageWithValidDetails();
		super.verifyEventPoliciesPageByEnteringValidDetails();

		addBracketPage.clickOnMatchTypeDropdown();
		Assert.assertTrue(addBracketPage.isMatchTypeListContains());
		addBracketPage.selectDoublesMatchType();
		Assert.assertTrue(addBracketPage.isSelectedMatchTypeDisplayed());

		addBracketPage.clickOnPlayGroupDropdown();
		Assert.assertTrue(addBracketPage.isPlayerGroupListDisplayed());
		addBracketPage.selectWomenPlayerGroup();
		Assert.assertTrue(addBracketPage.isSelectedPlayerGroupTypeDisplayed());

		super.verifyBracketWithoutEnteringDetailsIntoMatchTypeAndPlayerGroup();

		super.VerifyRecentlyAddedEventUnderEventsTab();

		Assert.assertTrue(combinationOfMatchTypeAndPlayerGroupPage.isDoublesWomenCardDisplayed());

		logger.info("Ending of verifyBracketWithMatchTypeDoublesWomenPlayerGroup method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.COMBINATION_OF_MATCHTYPE_AND_PLAYERGROUP_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
