package com.dupr.test.home;

import java.text.ParseException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.home.ValidateRecentlyAddedMatchPage;
import com.dupr.test.CommonBaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("DUPR App")
@Feature("Validate Recently Added Match")
public class ValidateRecentlyAddedMatchTest extends CommonBaseTest {

	private static final Logger logger = Logger.getLogger(ValidateRecentlyAddedMatchTest.class.getName());
	private ValidateRecentlyAddedMatchPage validateRecentlyAddedMatchPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "validEmail", "validPassword" })
	public void initMethod(String browser, String siteURL, String email, String password) throws Exception {
		logger.info("Starting of initMethod in ValidateRecentlyAddedMatchTest");

		this.driver = super.getWebDriver(WebDriversEnum.VALIDATE_RECENTLY_ADDED_MATCH_DRIVER);
		super.initCommonBaseTest(siteURL, email, password);

		this.validateRecentlyAddedMatchPage = new ValidateRecentlyAddedMatchPage(this.driver);

		logger.info("Ending of initMethod in ValidateRecentlyAddedMatchTest");
	}

	@Test(priority = 1, description = "Verify results after clicking on Match History tab", groups = "sanity")
	@Description("Test case #1, Verify results after clicking on Match History tab")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify results after clicking on Match History tab")
	public void verifyMatchHistory() {
		logger.info("Starting of verifyMatchHistory method");

		validateRecentlyAddedMatchPage.hardWait(5);
		validateRecentlyAddedMatchPage.clickOnMatchHistoryTab();
		validateRecentlyAddedMatchPage.hardWait(5);

		Assert.assertTrue(validateRecentlyAddedMatchPage.isMatchHistoryOptionsPageContains());

		logger.info("Ending of verifyMatchHistory method");
	}

	@Test(priority = 2, description = "Verify matches with completed filter", groups = "sanity")
	@Description("Test case #2, Verify matches with completed filter")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify matches with completed filter")
	public void verifyCompletedFilterFunctionality() {
		logger.info("Starting of verifyCompletedFilterFunctionality method");

		validateRecentlyAddedMatchPage.clickOnCompletedButton();
		validateRecentlyAddedMatchPage.hardWait(2);

		Assert.assertTrue(validateRecentlyAddedMatchPage.isTickIconDisplayed());
		Assert.assertFalse(validateRecentlyAddedMatchPage.isValidateButtonsDisplayed());
		Assert.assertFalse(validateRecentlyAddedMatchPage.isDeleteButtonsDisplayed());

		logger.info("Ending of verifyCompletedFilterFunctionality method");
	}

	@Test(priority = 3, description = "Verify matches with filter Singles", groups = "sanity")
	@Description("Test case #3,Verify matches with filter Singles")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify matches with filter Singles")
	public void verifySinglesFilterFunctionality() {
		logger.info("Starting of verifySinglesFilterFunctionality method");

		validateRecentlyAddedMatchPage.clickOnClearFiltersButton();
		validateRecentlyAddedMatchPage.clickOnSinglesButton();

		Assert.assertTrue(validateRecentlyAddedMatchPage.isOpponentPlayerNamesButtonsDisplayed());

		logger.info("Ending of verifySinglesFilterFunctionality method");
	}

	@Test(priority = 4, description = "Verify matches with doubles filter", groups = "sanity")
	@Description("Test case #4, Verify matches with doubles filter")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify matches with doubles filter")
	public void verifyDoublesFilterFunctionality() {
		logger.info("Starting of verifyDoublesFilterFunctionality method");

		validateRecentlyAddedMatchPage.clickOnClearFiltersButton();
		validateRecentlyAddedMatchPage.clickOnDoublesButton();
		validateRecentlyAddedMatchPage.hardWait(3);

		Assert.assertTrue(validateRecentlyAddedMatchPage.isPlayerButtonsDisplayed());
		Assert.assertTrue(validateRecentlyAddedMatchPage.isPlayerPartnerButtonsDisplayed());
		Assert.assertTrue(validateRecentlyAddedMatchPage.isOpponentButtonsDisplayed());
		Assert.assertTrue(validateRecentlyAddedMatchPage.isOpponentPartnerButtonsDisplayed());

		logger.info("Ending of verifyDoublesFilterFunctionality method");
	}

	@Test(priority = 5, description = "Verify sort functionality with oldest to new dates filter", groups = "sanity")
	@Description("Test case #5, Verify sort functionality with oldest to new dates filter")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify sort functionality with oldest to new dates filter")
	public void verifySortFunctionalityWithOlddates() throws ParseException {
		logger.info("Starting of verifySortFunctionalityWithOlddates method");

		validateRecentlyAddedMatchPage.clickOnClearFiltersButton();
		validateRecentlyAddedMatchPage.clickOnSortButton();

		Assert.assertTrue(validateRecentlyAddedMatchPage.isNewestToOldestRadioButtonSelected());

		validateRecentlyAddedMatchPage.hardWait(2);
		validateRecentlyAddedMatchPage.clickOnOldestToNewestButton();
		validateRecentlyAddedMatchPage.hardWait(5);

		Assert.assertTrue(validateRecentlyAddedMatchPage.isOldMatchDatesDisplayedTop());

		logger.info("Ending of verifySortFunctionalityWithOlddates method");
	}

	@Test(priority = 6, description = "Verify clear filters functionality", groups = "sanity")
	@Description("Test case #6, Verify clear filters functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify clear filters functionality")
	public void verifyClearFiltersFunctionality() {
		logger.info("Starting of verifyClearFiltersFunctionality method");

		validateRecentlyAddedMatchPage.clickOnClearFiltersButton();

		validateRecentlyAddedMatchPage.clickOnCompletedButton();

		validateRecentlyAddedMatchPage.clickOnPendingButton();
		validateRecentlyAddedMatchPage.clickOnSinglesButton();
		validateRecentlyAddedMatchPage.clickOnDoublesButton();

		Assert.assertTrue(validateRecentlyAddedMatchPage.isRightMarkIconsDisplayed());

		validateRecentlyAddedMatchPage.clickOnClearFiltersButton();

		Assert.assertFalse(validateRecentlyAddedMatchPage.isRightMarkIconsDisplayed());

		logger.info("Ending of verifyClearFiltersFunctionality method");
	}

	@Test(priority = 7, description = "Verify results by selecting completed and singles filters combination", groups = "sanity")
	@Description("Test case #7, Verify results by selecting completed and singles filters combination")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Verify results by selecting completed and singles filters combination")
	public void verifyCompletedAndSinglesFiltersFunctionality() {
		logger.info("Starting of verifyCompletedAndSinglesFiltersFunctionality method");

		validateRecentlyAddedMatchPage.clickOnCompletedButton();
		validateRecentlyAddedMatchPage.hardWait(3);

		validateRecentlyAddedMatchPage.clickOnSinglesButton();
		validateRecentlyAddedMatchPage.hardWait(3);

		Assert.assertTrue(validateRecentlyAddedMatchPage.isTickIconDisplayed());

		validateRecentlyAddedMatchPage.hardWait(3);

		Assert.assertFalse(validateRecentlyAddedMatchPage.isValidateButtonsDisplayed());

		Assert.assertFalse(validateRecentlyAddedMatchPage.isDeleteButtonsDisplayed());

		Assert.assertTrue(validateRecentlyAddedMatchPage.isPlayerNamesButtonsDisplayed());

		Assert.assertTrue(validateRecentlyAddedMatchPage.isOpponentPlayerNamesButtonsDisplayed());

		logger.info("Ending of verifyCompletedAndSinglesFiltersFunctionality method");
	}

	@Test(priority = 8, description = "Verify results by selecting completed and doubles filters combination", groups = "sanity")
	@Description("Test case #8, Verify results by selecting completed and doubles filters combination")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Verify results by selecting completed and doubles filters combination")
	public void verifyResultsByCompletedAndDoublesFilters() {
		logger.info("Starting of verifyResultsByCompletedAndDoublesFilters method");

		validateRecentlyAddedMatchPage.clickOnClearFiltersButton();

		validateRecentlyAddedMatchPage.clickOnCompletedButton();
		validateRecentlyAddedMatchPage.hardWait(3);

		validateRecentlyAddedMatchPage.clickOnDoublesButton();
		validateRecentlyAddedMatchPage.hardWait(5);

		Assert.assertTrue(validateRecentlyAddedMatchPage.isTickIconDisplayed());
		Assert.assertFalse(validateRecentlyAddedMatchPage.isValidateButtonsDisplayed());
		Assert.assertFalse(validateRecentlyAddedMatchPage.isDeleteButtonsDisplayed());

		validateRecentlyAddedMatchPage.hardWait(3);

		Assert.assertTrue(validateRecentlyAddedMatchPage.isPlayerButtonsDisplayed());
		Assert.assertTrue(validateRecentlyAddedMatchPage.isPlayerPartnerButtonsDisplayed());
		Assert.assertTrue(validateRecentlyAddedMatchPage.isOpponentButtonsDisplayed());
		Assert.assertTrue(validateRecentlyAddedMatchPage.isOpponentPartnerButtonsDisplayed());

		logger.info("Ending of verifyResultsByCompletedAndDoublesFilters method");
	}

	@Test(priority = 9, description = "Verify results by selecting pending and singles filters combination", groups = "sanity") //
	@Description("Test case #9, Verify results by selecting pending and singles filters combination")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9, Verify results by selecting pending and singles filters combination")
	public void verifyResultsWithPendingAndSinglesFilters() {
		logger.info("Starting of verifyResultsWithPendingAndSinglesFilters method");

		validateRecentlyAddedMatchPage.hardWait(2);
		validateRecentlyAddedMatchPage.clickOnClearFiltersButton();

		validateRecentlyAddedMatchPage.clickOnPendingButton();
		validateRecentlyAddedMatchPage.clickOnSinglesButton();

		validateRecentlyAddedMatchPage.hardWait(5);

		Assert.assertTrue(validateRecentlyAddedMatchPage.isDeleteORValidateButtonsDisplayed());
		Assert.assertTrue(validateRecentlyAddedMatchPage.isPlayerNamesButtonsDisplayed());
		Assert.assertTrue(validateRecentlyAddedMatchPage.isOpponentPlayerNamesButtonsDisplayed());

		logger.info("Ending of verifyResultsWithPendingAndSinglesFilters method");
	}

	@Test(priority = 10, description = "Verify results by selecting pending and doubles filters combination", groups = "sanity")
	@Description("Test case #10, Verify results by selecting pending and doubles filters combination")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #10, Verify results by selecting pending and doubles filters combination")
	public void verifyResultsWithPendingAndDoublesFilters() {
		logger.info("Starting of verifyResultsWithPendingAndDoublesFilters method");

		validateRecentlyAddedMatchPage.hardWait(2);
		validateRecentlyAddedMatchPage.clickOnClearFiltersButton();

		validateRecentlyAddedMatchPage.clickOnPendingButton();

		validateRecentlyAddedMatchPage.clickOnDoublesButton();

		validateRecentlyAddedMatchPage.hardWait(5);

		Assert.assertTrue(validateRecentlyAddedMatchPage.isDeleteORValidateButtonsDisplayed());

		validateRecentlyAddedMatchPage.hardWait(3);

		Assert.assertTrue(validateRecentlyAddedMatchPage.isPlayerButtonsDisplayed());
		Assert.assertTrue(validateRecentlyAddedMatchPage.isPlayerPartnerButtonsDisplayed());
		Assert.assertTrue(validateRecentlyAddedMatchPage.isOpponentButtonsDisplayed());
		Assert.assertTrue(validateRecentlyAddedMatchPage.isOpponentPartnerButtonsDisplayed());

		logger.info("Ending of verifyResultsWithPendingAndDoublesFilters method");
	}

	@Test(priority = 11, description = "Verify Match History details with filter Pending", groups = "sanity")
	@Description("Test case #11,Verify Match History details with filter Pending")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #11, Verify Match History details with filter Pending")
	public void verifyPendingMatchHistory() {
		logger.info("Starting of verifyPendingMatchHistory method");

		validateRecentlyAddedMatchPage.clickOnClearFiltersButton();
		validateRecentlyAddedMatchPage.clickOnPendingButton();
		validateRecentlyAddedMatchPage.hardWait(5);

		Assert.assertTrue(validateRecentlyAddedMatchPage.isMatchDateButtonDisplayed());

		driver.navigate().refresh();

		validateRecentlyAddedMatchPage.hardWait(6);

		Assert.assertTrue(validateRecentlyAddedMatchPage.isDeleteORValidateButtonsDisplayed());

		logger.info("Ending of verifyPendingMatchHistory method");
	}

	@Parameters({ "opponent1Email", "partnerPassword" })
	@Test(priority = 12, description = "Verify validate match functionality", groups = "sanity")
	@Description("Test case #12, Verify validate match functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #12, Verify validate match functionality")
	public void verifyValidateFunctionality(String opponentEmail, String partnerPassword) {
		logger.info("Starting of verifyValidateFunctionality method");

		addAMatchPage.clickOnAddAMatchTab();

		super.verifySetMatchDetails();
		super.verifyAddAMatchInSinglesWonGame();
		addAMatchPage.clickOnOkButton();

		loginPage.clickOnOpenSettingsMenu();
		loginPage.clickOnLogoutButton();

		loginPage.loginToDUPRApplication(opponentEmail, partnerPassword);

		validateRecentlyAddedMatchPage.clickOnMatchHistoryTab();
		validateRecentlyAddedMatchPage.clickOnPendingButton();
		validateRecentlyAddedMatchPage.clickOnValidateButton(eventName);

		Assert.assertTrue(validateRecentlyAddedMatchPage.isValidateMatchPopupContains());

		validateRecentlyAddedMatchPage.clickOnValidateButtonOnValidateMatchPopup();
		validateRecentlyAddedMatchPage.hardWait(2);

		Assert.assertTrue(validateRecentlyAddedMatchPage.isConfirmValidateMatchPopupContains());

		validateRecentlyAddedMatchPage.clickOnValidateButtonOnConfirmValidatePopup();
		validateRecentlyAddedMatchPage.hardWait(3);

		String successText = validateRecentlyAddedMatchPage.getSuccessText();
		Assert.assertEquals(successText, expectedAssertionsProp.getProperty("success.label"));

		validateRecentlyAddedMatchPage.clickOnCloseIcon();

		logger.info("Ending of verifyValidateFunctionality method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.VALIDATE_RECENTLY_ADDED_MATCH_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
