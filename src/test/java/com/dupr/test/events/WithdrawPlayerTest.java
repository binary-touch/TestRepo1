package com.dupr.test.events;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.clubs.EditClubInfoPage;
import com.dupr.pages.events.AddBracketPage;
import com.dupr.pages.events.AddEventPage;
import com.dupr.pages.events.EditBracketsPage;
import com.dupr.pages.events.EndEventPage;
import com.dupr.pages.events.SeedMatchesPage;
import com.dupr.pages.events.TimeZonePage;
import com.dupr.pages.events.WithdrawPlayerPage;
import com.dupr.test.CommonBaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic(value = "Players")
@Feature(value = "Withdraw player")
public class WithdrawPlayerTest extends CommonBaseTest {
	private static final Logger logger = Logger.getLogger(WithdrawPlayerTest.class.getName());

	private EndEventPage endEventpage = null;
	private EditBracketsPage editBracketsPage = null;
	private WithdrawPlayerPage withdrawPlayerPage = null;
	private SeedMatchesPage seedMatchesPage = null;

	private String PlayerName = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String directorEmail, String directorPassword)
			throws Exception {
		logger.info("Starting of initMethod in WithdrawPlayerTest");

		this.driver = super.getWebDriver(WebDriversEnum.WITHDRAW_PLAYER_DRIVER);
		super.initCommonBaseTest(siteURL, directorEmail, directorPassword);
		
		this.addBracketPage = new AddBracketPage(this.driver);
		this.editClubInfoPage = new EditClubInfoPage(this.driver);
		this.addEventPage = new AddEventPage(this.driver);
		this.timeZonePage = new TimeZonePage(this.driver);

		this.editBracketsPage = new EditBracketsPage(this.driver);
		this.endEventpage = new EndEventPage(this.driver);
		this.withdrawPlayerPage = new WithdrawPlayerPage(this.driver);
		this.seedMatchesPage = new SeedMatchesPage(this.driver);

		logger.info("Ending of initMethod in WithdrawPlayerTest");
	}

	@Test(priority = 1, description = "Verify creating WaterFall Event As Doubles", groups = "sanity")
	@Description("Test case #1, Verify creating WaterFall Event As Doubles")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify creating WaterFall Event As Doubles")
	public void verifyCreatingWaterFallEventAsDoubles() {
		logger.info("Starting of verifyCreatingWaterFallEventAsDoubles method");

		seedMatchesPage.hardWait(3);

		super.verifyAddEventFunctionality();
		super.verifyEventInformationPageWithValidDetails();
		super.verifyEventPoliciesPageByEnteringValidDetails();

		addBracketPage.hardWait(3);
		addBracketPage.clickOnMatchTypeDropdown();
		addBracketPage.hardWait(3);
		addBracketPage.selectDoublesMatchType();

		addBracketPage.hardWait(3);
		addBracketPage.clickOnPlayGroupDropdown();
		addBracketPage.hardWait(3);
		addBracketPage.selectOpenPlayerGroup();

		addBracketPage.setMinimumAgeRange(testDataProp.getProperty("min.age.range"));
		Assert.assertTrue(addBracketPage.isEnteredMinimumAgeDisplayed(testDataProp.getProperty("min.age.range")));

		addBracketPage.setMaximumAgeRange(testDataProp.getProperty("max.age.range"));
		Assert.assertTrue(addBracketPage.isEnteredMaximumAgeDisplayed(testDataProp.getProperty("max.age.range")));

		addBracketPage.setMinimumRatingRange(testDataProp.getProperty("min.rating.range"));
		Assert.assertTrue(
				addBracketPage.isEnteredMinimumRatingRangeDisplayed(testDataProp.getProperty("min.rating.range")));

		addBracketPage.setMaximumRatingRange(testDataProp.getProperty("max.rating.range"));
		Assert.assertTrue(
				addBracketPage.isEnteredMaximumRatingRangeDisplayed(testDataProp.getProperty("max.rating.range")));

		Assert.assertTrue(addBracketPage.isAutoGenerateButtonEnabled());
		addBracketPage.clickOnAutoGenerateButton();

		addBracketPage.hardWait(3);
		addBracketPage.clickOnEventTypeDropdown();
		Assert.assertTrue(addBracketPage.isEventTypeListContains());
		addBracketPage.hardWait(3);
		addBracketPage.selectWaterfallEventType();
		Assert.assertTrue(addBracketPage.isSelectedEventTypeDisplayed());

		addBracketPage.hardWait(2);
		addBracketPage.setRegistrationStartDate();

		addBracketPage.hardWait(2);
		seedMatchesPage.setSampleRegistrationEndDate();

		addBracketPage.hardWait(2);
		seedMatchesPage.setSampleCompitionStartDate();

		addBracketPage.hardWait(2);
		addBracketPage.setCompetitionEndDate();
		addBracketPage.hardWait(2);
		addBracketPage.clickOnTimeZoneDropdown();
		addBracketPage.hardWait(2);
		addBracketPage.clickOnNewDelhiTimeZone();

		addBracketPage.hardWait(2);
		addBracketPage.setNumberOfCourts(testDataProp.getProperty("number.of.courts"));
		addBracketPage.setBracketClubMemberPrice(testDataProp.getProperty("zero.value"));
		addBracketPage.setBracketNonClubMemberPrice(testDataProp.getProperty("zero.value"));
		addBracketPage.setWaitlist(testDataProp.getProperty("zero.value"));

		addEventPage.clickOnNextStepButton();

		this.verifyNoContinueToSummaryButtonInAddAnotherBracketpopup();
		this.verifyPublishEventButton();

		addEventPage.clickOnEventsTab();
		seedMatchesPage.hardWait(5);
		addEventPage.clickOnRecentlyAddedEvent(eventName);
		addEventPage.hardWait(5);
		seedMatchesPage.clickOnBracketCard();
		seedMatchesPage.hardWait(5);

		logger.info("Ending of verifyCreatingWaterFallEventAsDoubles method");
	}

	@Test(priority = 2, description = "Verify the results on click of UnMatched players Tab", groups = "sanity")
	@Description("Test case #2, Verify the results on click of UnMatched players Tab")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify the results on click of UnMatched players Tab")
	public void verifyUnMatchedPlayersTab() {
		logger.info("Starting of verifyUnMatchedPlayersTab method");
		try {

			editBracketsPage.hardWait(3);
			addparticipantsPage.addParticipantsForWithdrawPlayer();
			editBracketsPage.hardWait(3);
			withdrawPlayerPage.clickOnUnmatchedTab();

		} catch (Exception e) {
			clubLogoPage.hardWait(3);
			withdrawPlayerPage.clickOnHomeMenu();
			clubLogoPage.hardWait(3);
			addparticipantsPage.clickOnMyBracketsDropdown();
			clubLogoPage.hardWait(3);
			withdrawPlayerPage.clickOnBracketLabel();
			endEventpage.hardWait(2);
		}

		Assert.assertTrue(withdrawPlayerPage.isUnMatchedPlayersTabContains());

		logger.info("Ending of verifyUnMatchedPlayersTab method");
	}

	@Test(priority = 3, description = "Verify the results on click of Withdraw/Refund Button", groups = "sanity")
	@Description("Test case #3, Verify the results on click of Withdraw/Refund Button")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify the results on click of Withdraw/Refund Button")
	public void verifyWithdrawRefundButtonFunctionality() {
		logger.info("Starting of verifyWithdrawRefundButtonFunctionality method");

		PlayerName = withdrawPlayerPage.getPlayerNameTxt();
		withdrawPlayerPage.hardWait(2);
		withdrawPlayerPage.clickOnWithdrawButton();
		withdrawPlayerPage.hardWait(2);
		Assert.assertTrue(withdrawPlayerPage.isWithdrawRefundPopUpContains());

		logger.info("Ending of verifyWithdrawRefundButtonFunctionality method");
	}

	@Test(priority = 4, description = "Verify the results on click of Close Icon", groups = "sanity")
	@Description("Test case #4, Verify the results on click of Close Icon")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify the results on click of Close Icon")
	public void verifyCloseIconFunctionalityOnWithdrawl() {
		logger.info("Starting of verifyCloseIconFunctionalityOnWithdrawl method");

		withdrawPlayerPage.clickOnCloseIconOnWIthdrawRefund();
		Assert.assertFalse(withdrawPlayerPage.isWithdrawRefundPopUpContains());

		logger.info("Ending of verifyCloseIconFunctionalityOnWithdrawl method");
	}

	@Test(priority = 5, description = "Verify the results on click on Next Button without selecting any radio buttons", groups = "sanity")
	@Description("Test case #5, Verify the results on click of Close Icon")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify the results on click of Close Icon")
	public void verifyValidationMsgWithoutSelectingAnyOption() {
		logger.info("Starting of verifyValidationMsgWithoutSelectingAnyOption method");
		
		withdrawPlayerPage.hardWait(4);
		withdrawPlayerPage.clickOnWithdrawButton();
		withdrawPlayerPage.hardWait(4);
		withdrawPlayerPage.clickOnNextButton();
		withdrawPlayerPage.hardWait(4);
		Assert.assertEquals(withdrawPlayerPage.getOptionValidationTxt(),
				expectedAssertionsProp.getProperty("Option.validation.txt"));

		logger.info("Ending of verifyValidationMsgWithoutSelectingAnyOption method");
	}

	@Test(priority = 6, description = "Verify the results on click on Next Button by selecting withdraw Option", groups = "sanity")
	@Description("Test case #6, Verify the results on click on Next Button by selecting withdraw Option")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify the results on click on Next Button by selecting withdraw Option")
	public void verifyNextButtonFunctionalityOnWIthdrawRefund() {
		logger.info("Starting of verifyNextButtonFunctionalityOnWIthdrawRefund method");

		withdrawPlayerPage.clickOnRadioWithdraw();
		withdrawPlayerPage.clickOnNextButton();
		Assert.assertTrue(withdrawPlayerPage.isWithdrawPopUpContains());

		logger.info("Ending of verifyNextButtonFunctionalityOnWIthdrawRefund method");
	}

	@Test(priority = 7, description = "Verify the results on click of Back Button", groups = "sanity")
	@Description("Test case #,7 Verify the results on click of Back Button")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Verify the results on click of Back Button")
	public void verifyBackButtonFunctionalityOnWIthdrawl() {
		logger.info("Starting of verifyBackButtonFunctionalityOnWIthdrawl method");

		withdrawPlayerPage.clickOnBackButton();
		Assert.assertTrue(withdrawPlayerPage.isWithdrawRefundPopUpContains());

		logger.info("Ending of verifyBackButtonFunctionalityOnWIthdrawl method");
	}

	@Test(priority = 8, description = "Verify the results on click on Next Button by selecting withdraw Option", groups = "sanity")
	@Description("Test case #8, Verify the results on click on Next Button by selecting withdraw Option")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Verify the results on click on Next Button by selecting withdraw Option")
	public void verifyNextFunctionalityBySelectingWithdraw() {
		logger.info("Starting of verifyNextFunctionalityBySelectingWithdraw method");

		withdrawPlayerPage.clickOnNextButton();
		withdrawPlayerPage.clickOnNextButton();
		Assert.assertEquals(withdrawPlayerPage.getSelectValidationTxt(),
				expectedAssertionsProp.getProperty("checkBox.validation.txt"));

		logger.info("Ending of verifyNextFunctionalityBySelectingWithdraw method");
	}

	@Test(priority = 9, description = "Verify the results on click on Next Button by selecting checkbox of bracket", groups = "sanity")
	@Description("Test case #9, Verify the results on click on Next Button by selecting checkbox of bracket")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9, Verify the results on click on Next Button by selecting withdraw Option")
	public void verifyNextBySelectingBracket() {
		logger.info("Starting of verifyNextBySelectingBracket method");

		withdrawPlayerPage.clickOnBracketCheckBox();
		withdrawPlayerPage.clickOnNextButton();
		Assert.assertTrue(withdrawPlayerPage.isConfirmationPopUpContains());
		Assert.assertEquals(withdrawPlayerPage.getConfirmTitleText(),
				expectedAssertionsProp.getProperty("confirmation.txt"));

		logger.info("Ending of verifyNextBySelectingBracket method");
	}

	@Test(priority = 10, description = "Verify the results on click of Back Button On Confirmation PopUp", groups = "sanity")
	@Description("Test case #10, Verify the results on click of Back Button on confirmation popUp")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #10, Verify the results on click of Back ButtonOn confirmation poopUp")
	public void verifyBackButtonFunctionalityOnConfirmation() {
		logger.info("Starting of verifyBackButtonFunctionalityOnConfirmation method");

		withdrawPlayerPage.clickOnBackButton();
		Assert.assertTrue(withdrawPlayerPage.isWithdrawPopUpContains());

		logger.info("Ending of verifyBackButtonFunctionalityOnConfirmation method");
	}

	@Test(priority = 11, description = "Verify the results on click of confirm Button", groups = "sanity")
	@Description("Test case #11, Verify the results on click of confirm Button")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #11, Verify the results on click of confirm Button")
	public void verifyConfirmButtonFunctionality() {
		logger.info("Starting of verifyConfirmButtonFunctionality method");

		withdrawPlayerPage.clickOnNextButton();
		withdrawPlayerPage.hardWait(3);
		withdrawPlayerPage.clickOnConfirmButton();
		Assert.assertTrue(withdrawPlayerPage.isSucessPopUpContains());
		Assert.assertEquals(withdrawPlayerPage.getSuccessTitleText(), expectedAssertionsProp.getProperty("sucess.txt"));

		logger.info("Ending of verifyConfirmButtonFunctionality method");
	}

	@Test(priority = 12, description = "Verify the results on click of close icon on Sucess PopUp", groups = "sanity")
	@Description("Test case #12, Verify the results on click of close icon on Sucess PopUp")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #12, Verify the results on click of close icon on Sucess PopUp")
	public void verifyCloseIconFunctionalityOnSucessPopup() {
		logger.info("Starting of verifyCloseIconFunctionalityOnSucessPopup method");

		withdrawPlayerPage.clickOnCloseIcon();
		withdrawPlayerPage.clickOnPlayersTab();
		withdrawPlayerPage.hardWait(3);
		withdrawPlayerPage.clickOnSearchFeild(PlayerName);
		withdrawPlayerPage.hardWait(3);
		Assert.assertTrue(withdrawPlayerPage.isPlayerRemoved());

		logger.info("Ending of verifyCloseIconFunctionalityOnSucessPopup method");
	}

	@Test(priority = 13, description = "Verify the results on click on Next Button by selecting Withdraw and Refund Option", groups = "sanity")
	@Description("Test case #13, Verify the results on click on Next Button by selecting Withdraw and Refund Option")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #13, Verify the results on click on Next Button by selecting Withdraw and Refund Option")
	public void verifyNextFunctionalityByselectingWithdrawRefund() {
		logger.info("Starting of verifyNextFunctionalityByselectingWithdrawRefund method");

		withdrawPlayerPage.clickOnUnMatchedPlayersTab();
		withdrawPlayerPage.clickOnWithdrawButton();
		withdrawPlayerPage.hardWait(2);
		withdrawPlayerPage.clickOnWithdrawRefund();
		withdrawPlayerPage.clickOnNextButton();

		Assert.assertTrue(withdrawPlayerPage.isWithdrawAndRefundPopUpContains());

		logger.info("Ending of verifyNextFunctionalityByselectingWithdrawRefund method");
	}

	@Test(priority = 14, description = "Verify the results on click on Next Button by selecting Withdraw and Refund Option", groups = "sanity")
	@Description("Test case #14, Verify the results on click on Next Button by selecting Withdraw and Refund Option")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #14, Verify the results on click on Next Button by selecting Withdraw and Refund Option")
	public void verifyNextButtonFunctionalityBySelectingBracket() {
		logger.info("Starting of verifyNextButtonFunctionalityBySelectingBracket method");
		try {
			withdrawPlayerPage.clickOnFreeBracket();
			withdrawPlayerPage.clickOnNextButton();
			Assert.assertTrue(withdrawPlayerPage.isConfirmationPopUpContains());
			Assert.assertEquals(withdrawPlayerPage.getConfirmTitleText(),
					expectedAssertionsProp.getProperty("confirmation.txt"));
			withdrawPlayerPage.clickOnCloseIconOnConfirm();
		} catch (Exception e) {
			withdrawPlayerPage.clickOnCloseWithdraw();
		}

		logger.info("Ending of verifyNextButtonFunctionalityBySelectingBracket method");
	}

	@Test(priority = 15, description = "Verify the results on click of Next Button by selecting Refund Only Option", groups = "sanity")
	@Description("Test case #15, Verify the results on click on Next Button by selecting Withdraw and Refund Option")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #15, Verify the results on click on Next Button by selecting Withdraw and Refund Option")
	public void verifyNextFunctionalityBySelectingRefund() {
		logger.info("Starting of verifyNextFunctionalityBySelectingRefund method");

		withdrawPlayerPage.clickOnWithdrawButton();
		withdrawPlayerPage.hardWait(2);
		withdrawPlayerPage.clickOnRefundButton();
		withdrawPlayerPage.clickOnNextButton();
		Assert.assertTrue(withdrawPlayerPage.isRefundPopUpContains());

		logger.info("Ending of verifyNextFunctionalityByRefund method");
	}

	@Test(priority = 16, description = "Verify the results on click of close icon", groups = "sanity")
	@Description("Test case #16, Verify the results on click oof close Icon")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #16, Verify the results on click on close icon")
	public void verifyCloseIconFunctionalityOnRefund() {
		logger.info("Starting of verifyCloseIconFunctionalityOnRefund method");

		withdrawPlayerPage.clickOnCloseOnRefund();
		Assert.assertFalse(withdrawPlayerPage.isRefundPopUpContains());

		logger.info("Ending of verifyCloseIconFunctionalityOnRefund method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.WITHDRAW_PLAYER_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}
}
