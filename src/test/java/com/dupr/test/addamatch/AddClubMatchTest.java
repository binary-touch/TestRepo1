package com.dupr.test.addamatch;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.addamatch.AddClubMatchPage;
import com.dupr.pages.clubs.BrowseClubsPage;
import com.dupr.pages.clubs.MyClubsPage;
import com.dupr.pages.players.SearchPlayersPage;
import com.dupr.test.CommonBaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class AddClubMatchTest extends CommonBaseTest {

	private static final Logger logger = Logger.getLogger(AddClubMatchTest.class.getName());

	protected SearchPlayersPage searchPlayersPage = null;
	private AddClubMatchPage addClubMatchPage = null;
	private MyClubsPage myClubsPage = null;
	private BrowseClubsPage browseClubsPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String directorEmail, String directorPassword)
			throws Exception {
		logger.info("Starting of initMethod in AddClubMatchTest");

		this.driver = super.getWebDriver(WebDriversEnum.ADD_CLUB_MATCH_TEST);
		super.initCommonBaseTest(siteURL, directorEmail, directorPassword);

		this.searchPlayersPage = new SearchPlayersPage(this.driver);
		this.myClubsPage = new MyClubsPage(this.driver);
		this.browseClubsPage = new BrowseClubsPage(this.driver);
		this.addClubMatchPage = new AddClubMatchPage(this.driver);

		logger.info("Ending of initMethod in AddClubMatchTest");
	}

	@Test(priority = 1, description = "Verify Add a Match Tab functionality", groups = "sanity")
	@Description("Test case #1, Verify Add a Match Tab functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Add a Match Tab functionality")
	public void verifyAddAMatchTabFunctionality() {
		logger.info("Starting of verifyAddAMatchTabFunctionality method");

		addAMatchPage.clickOnAddAMatchTab();
		Assert.assertTrue(addAMatchPage.isAddAMatchPageContains());

		logger.info("Ending of verifyAddAMatchTabFunctionality method");
	}

	@Test(priority = 2, description = "Verify Add club Match functionality From A Specific Club", groups = "sanity")
	@Description("Test case #2, Verify Add club Match functionality From A Specific Club")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify Add club Match functionality From A Specific Club")
	public void verifyAddClubMatchFunctionalityFromASpecificClub() {
		logger.info("Starting of verifyAddClubMatchFunctionalityFromASpecificClub method");

		driver.navigate().back();
		clubLogoPage.clickOnMyClubsTab();
		clubLogoPage.hardWait(3);
		try {
			if (clubLogoPage.isClubsDisplayedInMyClubs()) {
				clubLogoPage.clickOnSimbaClubName();
			} else {
				myClubsPage.clickOnBrowseClubsButton();
				Assert.assertTrue(browseClubsPage.isBrowseClubsPageContains());
				clubLogoPage.clickOnSimbaClubName();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		addClubMatchPage.clickOnAddAMatchButton();
		addAMatchPage.setLocationInDoubles(testDataProp.getProperty("location.city.name"));
		addAMatchPage.setEventName(testDataProp.getProperty("event.name.in.doubles"));

		logger.info("Ending of verifyAddClubMatchFunctionalityFromASpecificClub method");
	}

	@Test(priority = 3, description = "verify Add A Match Functionality For Singles By Selecting Add Your self Checkbox", groups = "sanity")
	@Description("Test case #3,verify Add A Match Functionality For Singles By Selecting Add Your self Checkbox ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, verify Add A Match Functionality For Singles By Selecting Add Your self Checkbox")
	public void verifyAddClubMatchFunctionalityForSinglesBySelectingAddYourselfCheckbox() {
		logger.info("Starting of verifyAddClubMatchFunctionalityForSinglesBySelectingAddYourselfCheckbox method");

		addClubMatchPage.clickOnAddYourselfAsPlayerCheckbox();
		Assert.assertTrue(addClubMatchPage.isDirectorNameDisplayedItSelf());

		addAMatchPage.clickOnSinglesButton();
		addClubMatchPage.clickOnAddFirstOpponentButton();
		Assert.assertTrue(addAMatchPage.isAddPlayerButtonDisabled());

		addAMatchPage.clickOnPlayerRadioButton();
		Assert.assertTrue(addAMatchPage.isAddPlayerButtonEnabled());
		addAMatchPage.clickOnAddPlayerButton();

		addAMatchPage.setGameOneScores(testDataProp.getProperty("teamone.gameone.Score"),
				testDataProp.getProperty("teamone.gameone.Score"));
		addAMatchPage.setGameOneScores(testDataProp.getProperty("teamone.gameone.Score"),
				testDataProp.getProperty("teamtwo.gameone.Score"));

		addAMatchPage.clickOnSubmitButton();

		addAMatchPage.clickOnSubmitButtonInFinalScoresPopup();

		Assert.assertEquals(addAMatchPage.getSuccessText(), expectedAssertionsProp.getProperty("success.label"));
		Assert.assertTrue(addAMatchPage.isOkButtonDisplayed());

		addAMatchPage.clickOnOKButtonInSuccessPopup();

		logger.info("Ending of verifyAddClubMatchFunctionalityForSinglesBySelectingAddYourselfCheckbox method");
	}

	@Test(priority = 4, description = "verify Add A Match Functionality For Doubles By Selecting Add Your self Checkbox", groups = "sanity")
	@Description("Test case #4,verify Add A Match Functionality For Doubles By Selecting Add Your self Checkbox ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, verify Add A Match Functionality For Doubles By Selecting Add Your self Checkbox")
	public void verifyAddClubMatchFunctionalityForDoublesBySelectingAddYourselfCheckbox() {
		logger.info("Starting of verifyAddClubMatchFunctionalityForDoublesBySelectingAddYourselfCheckbox method");

		addClubMatchPage.clickOnAddAMatchButton();
		addAMatchPage.setLocationInDoubles(testDataProp.getProperty("location.city.name"));
		addAMatchPage.setEventName(testDataProp.getProperty("event.name.in.doubles"));

		addClubMatchPage.clickOnAddYourselfAsPlayerCheckbox();
		Assert.assertTrue(addClubMatchPage.isDirectorNameDisplayedItSelf());

		addClubMatchPage.clickOnAddDoublesButton();

		addClubMatchPage.clickOnAddFirstOpponentButton();
		addClubMatchPage.clickOnPlayerRadioButton();
		Assert.assertTrue(addAMatchPage.isAddPlayerButtonEnabled());
		addAMatchPage.clickOnAddPlayerButton();

		addClubMatchPage.clickOnAddSecondPlayerButton();
		addClubMatchPage.clickOnPlayerRadioButton();
		Assert.assertTrue(addAMatchPage.isAddPlayerButtonEnabled());
		addAMatchPage.clickOnAddPlayerButton();

		addClubMatchPage.clickOnAddSecondOpponentButton();
		addClubMatchPage.clickOnPlayerRadioButton();
		Assert.assertTrue(addAMatchPage.isAddPlayerButtonEnabled());
		addAMatchPage.clickOnAddPlayerButton();

		addAMatchPage.setGameOneScores(testDataProp.getProperty("teamone.gameone.Score"),
				testDataProp.getProperty("teamone.gameone.Score"));
		addAMatchPage.setGameOneScores(testDataProp.getProperty("teamone.gameone.Score"),
				testDataProp.getProperty("teamtwo.gameone.Score"));

		addAMatchPage.clickOnSubmitButton();

		addAMatchPage.clickOnSubmitButtonInFinalScoresPopup();

		Assert.assertEquals(addAMatchPage.getSuccessText(), expectedAssertionsProp.getProperty("success.label"));
		Assert.assertTrue(addAMatchPage.isOkButtonDisplayed());

		addAMatchPage.clickOnOKButtonInSuccessPopup();

		logger.info("Ending of verifyAddClubMatchFunctionalityForDoublesBySelectingAddYourselfCheckbox method");
	}

	@Test(priority = 5, description = "verify Add A Match Functionality For Singles By WithOut Selecting Add Your self Checkbox", groups = "sanity")
	@Description("Test case #5,verify Add A Match Functionality For Singles By WithOut Selecting Add Your self Checkbox ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, verify Add A Match Functionality For Singles By WithOut Selecting Add Your self Checkbox")
	public void verifyAddClubMatchFunctionalityForSinglesByWithOutSelectingAddYourselfCheckbox() {
		logger.info(
				"Starting of verifyAddClubMatchFunctionalityForSinglesByWithOutSelectingAddYourselfCheckbox method");

		addClubMatchPage.clickOnAddAMatchButton();
		addAMatchPage.setLocationInDoubles(testDataProp.getProperty("location.city.name"));
		addAMatchPage.setEventName(testDataProp.getProperty("event.name.in.doubles"));

		addAMatchPage.clickOnSinglesButton();

		addClubMatchPage.clickOnAddFirstPlayerButton();
		addClubMatchPage.clickOnPlayerRadioButton();
		Assert.assertTrue(addAMatchPage.isAddPlayerButtonEnabled());
		addAMatchPage.clickOnAddPlayerButton();

		addClubMatchPage.clickOnAddFirstOpponentButton();
		addClubMatchPage.clickOnPlayerRadioButton();
		Assert.assertTrue(addAMatchPage.isAddPlayerButtonEnabled());
		addAMatchPage.clickOnAddPlayerButton();

		addAMatchPage.setGameOneScores(testDataProp.getProperty("teamone.gameone.Score"),
				testDataProp.getProperty("teamone.gameone.Score"));
		addAMatchPage.setGameOneScores(testDataProp.getProperty("teamone.gameone.Score"),
				testDataProp.getProperty("teamtwo.gameone.Score"));

		addAMatchPage.clickOnSubmitButton();

		addAMatchPage.clickOnSubmitButtonInFinalScoresPopup();

		Assert.assertEquals(addAMatchPage.getSuccessText(), expectedAssertionsProp.getProperty("success.label"));
		Assert.assertTrue(addAMatchPage.isOkButtonDisplayed());

		addAMatchPage.clickOnOKButtonInSuccessPopup();

		logger.info("Ending of verifyAddClubMatchFunctionalityForSinglesByWithOutSelectingAddYourselfCheckbox method");
	}

	@Test(priority = 6, description = "verify Add A Match Functionality For Doubles By WithOut Selecting Add Your self Checkbox", groups = "sanity")
	@Description("Test case #6,verify Add A Match Functionality For Doubles By WithOut Selecting Add Your self Checkbox ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, verify Add A Match Functionality For Doubles By WithOut Selecting Add Your self Checkbox")
	public void verifyAddClubMatchFunctionalityForDoublesByWithOutSelectingAddYourselfCheckbox() {
		logger.info(
				"Starting of verifyAddClubMatchFunctionalityForDoublesByWithOutSelectingAddYourselfCheckbox method");

		addClubMatchPage.clickOnAddAMatchButton();
		addAMatchPage.setLocationInDoubles(testDataProp.getProperty("location.city.name"));
		addAMatchPage.setEventName(testDataProp.getProperty("event.name.in.doubles"));

		addClubMatchPage.clickOnAddDoublesButton();

		addClubMatchPage.clickOnAddFirstPlayerButton();
		addClubMatchPage.clickOnPlayerRadioButton();
		Assert.assertTrue(addAMatchPage.isAddPlayerButtonEnabled());
		addAMatchPage.clickOnAddPlayerButton();

		addClubMatchPage.clickOnAddFirstOpponentButton();
		addClubMatchPage.clickOnPlayerRadioButton();
		Assert.assertTrue(addAMatchPage.isAddPlayerButtonEnabled());
		addAMatchPage.clickOnAddPlayerButton();

		addClubMatchPage.clickOnAddSecondPlayerButton();
		addClubMatchPage.clickOnPlayerRadioButton();
		Assert.assertTrue(addAMatchPage.isAddPlayerButtonEnabled());
		addAMatchPage.clickOnAddPlayerButton();

		addClubMatchPage.clickOnAddSecondOpponentButton();
		addClubMatchPage.clickOnPlayerRadioButton();
		Assert.assertTrue(addAMatchPage.isAddPlayerButtonEnabled());
		addAMatchPage.clickOnAddPlayerButton();

		addAMatchPage.setGameOneScores(testDataProp.getProperty("teamone.gameone.Score"),
				testDataProp.getProperty("teamone.gameone.Score"));
		addAMatchPage.setGameOneScores(testDataProp.getProperty("teamone.gameone.Score"),
				testDataProp.getProperty("teamtwo.gameone.Score"));

		addAMatchPage.clickOnSubmitButton();

		addAMatchPage.clickOnSubmitButtonInFinalScoresPopup();

		Assert.assertEquals(addAMatchPage.getSuccessText(), expectedAssertionsProp.getProperty("success.label"));
		Assert.assertTrue(addAMatchPage.isOkButtonDisplayed());

		addAMatchPage.clickOnOKButtonInSuccessPopup();

		logger.info("Ending of verifyAddClubMatchFunctionalityForDoublesByWithOutSelectingAddYourselfCheckbox method");
	}

	@Test(priority = 7, description = "Validate club match functionality in matches Tab ", groups = "sanity")
	@Description("Test case #7,Validate club match functionality in matches Tab  ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Validate club match functionality in matches Tab ")
	public void validateClubMatchFunctionalityInMatchesTab() {
		logger.info("Starting of validateClubMatchFunctionalityInMatchesTab method");

		addClubMatchPage.clickOnMatchesButton();
		// addClubMatchDirectorOnlyPage.isMatchesTabContains();

		logger.info("Ending of validateClubMatchFunctionalityInMatchesTab method");
	}

	@Test(priority = 8, description = "Validate club match Sort functionality in matches Tab ", groups = "sanity")
	@Description("Test case #8,Validate club match Sort functionality in matches Tab  ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Validate club match Sort functionality in matches Tab ")
	public void validateClubMatchSortFunctionalityInMatchesTab() {
		logger.info("Starting of validateClubMatchSortFunctionalityInMatchesTab method");

		addClubMatchPage.clickOnMatchesButton();
		addClubMatchPage.clickOnSortButton();
		Assert.assertTrue(addClubMatchPage.isSortFilterContains());
		addClubMatchPage.clickOnOldestToNewestButton();
		addClubMatchPage.clickOnSortButton();
		addClubMatchPage.clickOnNewestToOldestButton();

		logger.info("Ending of validateClubMatchSortFunctionalityInMatchesTab method");
	}

	@Test(priority = 9, description = "Validate club match Single functionality in matches Tab ", groups = "sanity")
	@Description("Test case #9,Validate club match Single functionality in matches Tab  ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9, Validate club match Single functionality in matches Tab ")
	public void validateClubMatchSinglesFunctionalityInMatchesTab() {
		logger.info("Starting of validateClubMatchSinglesFunctionalityInMatchesTab method");

		addClubMatchPage.clickOnSinglesButton();
		Assert.assertTrue(addClubMatchPage.isRightMarkSinglesDisplayed());

		logger.info("Ending of validateClubMatchSinglesFunctionalityInMatchesTab method");
	}

	@Test(priority = 10, description = "Validate club match Doubles functionality in matches Tab ", groups = "sanity")
	@Description("Test case #10,Validate club match Doubles functionality in matches Tab  ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #10, Validate club match Doubles functionality in matches Tab ")
	public void validateClubMatchDoublesFunctionalityInMatchesTab() {
		logger.info("Starting of validateClubMatchDoublesFunctionalityInMatchesTab method");

		addClubMatchPage.clickOnSinglesButton();
		addClubMatchPage.clickOnDoublesButton();

		Assert.assertTrue(addClubMatchPage.isRightMarkDoublesDisplayed());

		logger.info("Ending of validateClubMatchDoublesFunctionalityInMatchesTab method");
	}

	@Test(priority = 11, description = "Validate club match Clear Filters functionality in matches Tab ", groups = "sanity")
	@Description("Test case #11,Validate club match Clear Filters functionality in matches Tab  ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #11, Validate club match Clear Filters functionality in matches Tab ")
	public void validateClubMatchClearFiltersFunctionalityInMatchesTab() {
		logger.info("Starting of validateClubMatchClearFiltersFunctionalityInMatchesTab method");

		addClubMatchPage.clickOnSinglesButton();
		Assert.assertTrue(addClubMatchPage.isRightMarkSinglesDisplayed());
		Assert.assertTrue(addClubMatchPage.isRightMarkDoublesDisplayed());
		addClubMatchPage.clickOnClearFiltersButton();

		Assert.assertFalse(addClubMatchPage.isSingleAndDoubleRightMarkDisplayed());

		logger.info("Ending of validateClubMatchClearFiltersFunctionalityInMatchesTab method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.ADD_CLUB_MATCH_TEST);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
