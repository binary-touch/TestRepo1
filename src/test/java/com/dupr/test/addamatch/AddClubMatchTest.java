package com.dupr.test.addamatch;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.addamatch.AddAMatchPage;
import com.dupr.pages.addamatch.AddClubMatchPage;
import com.dupr.pages.clubs.ClubLogoPage;
import com.dupr.pages.clubs.EditClubInfoPage;
import com.dupr.pages.players.SearchPlayersPage;
import com.dupr.test.CommonBaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class AddClubMatchTest extends CommonBaseTest {

	private static final Logger logger = Logger.getLogger(AddClubMatchTest.class.getName());
	private AddAMatchPage addAMatchPage = null;
	private ClubLogoPage clubLogoPage = null;
	private EditClubInfoPage editClubInfoPage = null;
	protected SearchPlayersPage searchPlayersPage = null;
	private AddClubMatchPage addClubMatchDirectorOnlyPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String email, String password) throws Exception {
		logger.info("Starting of initMethod in AddAMatchTest");

		this.driver = super.getWebDriver(WebDriversEnum.ADD_CLUB_MATCH_TEST);
		this.siteLogin(siteURL, email, password, this.driver);
		this.addAMatchPage = new AddAMatchPage(this.driver);
		this.clubLogoPage = new ClubLogoPage(this.driver);
		this.editClubInfoPage = new EditClubInfoPage(this.driver);
		this.searchPlayersPage = new SearchPlayersPage(this.driver);

		this.addClubMatchDirectorOnlyPage = new AddClubMatchPage(this.driver);

		logger.info("Ending of initMethod in AddAMatchTest");
	}

	@Test(priority = 1, description = "Verify Add a Match Tab functionality", groups = "sanity")
	@Description("Test case #1,Verify Add a Match Tab functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1,Verify Add a Match Tab functionality")
	public void verifyAddAMatchTabFuntionality() {
		logger.info("Starting of verifyAddAMatchFuntionality method");

		addAMatchPage.clickOnAddAMatchTab();
		Assert.assertTrue(addAMatchPage.isAddAMatchPageContains());

		logger.info("Ending of verifyAddAMatchFuntionality method");
	}

	@Test(priority = 2, description = "Verify Add a Match functionality ", groups = "sanity")
	@Description("Test case #2,Verify Add a Match functionality From A Specific Club")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2,Verify Add a Match functionality From A Specific Club")
	public void verifyAddAMatchFuntionalityFromASpecificClub() {
		logger.info("Starting of verifyAddAMatchFuntionalityFromASpecificClub method");

		driver.navigate().back();
		clubLogoPage.clickOnMyClubsTab();

		clubLogoPage.clickOnClub();
		Assert.assertTrue(editClubInfoPage.isClubPageContains());

		addClubMatchDirectorOnlyPage.clickOnAddAMatchButton();
		addAMatchPage.setLocationInDoubles(testDataProp.getProperty("location.city.name"));
		addAMatchPage.setEventName(testDataProp.getProperty("event.name.in.doubles"));

		logger.info("Ending of verifyAddAMatchFuntionalityFromASpecificClub method");
	}

	@Test(priority = 3, description = "verify Add A Match Funtionality For Singles By Selecting Add Your self Checkbox", groups = "sanity")
	@Description("Test case #3,verify Add A Match Funtionality For Singles By Selecting Add Your self Checkbox ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, verify Add A Match Funtionality For Singles By Selecting Add Your self Checkbox")
	public void verifyAddAMatchFuntionalityForSinglesBySelectingAddYourselfCheckbox() {
		logger.info("Starting of verifyAddAMatchFuntionalityForSinglesBySelectingAddYourselfCheckbox method");

		addClubMatchDirectorOnlyPage.clickOnAddYourselfAsPlayerCheckbox();
		Assert.assertTrue(addClubMatchDirectorOnlyPage.isDirectorNameDisplayedItSelf());
		
		addAMatchPage.clickOnSinglesButton();
		addClubMatchDirectorOnlyPage.clickOnAddFirstOpponentButton();
		// Assert.assertTrue(addAMatchPage.isAddPlayerPageContains());

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

		logger.info("Ending of verifyAddAMatchFuntionalityForSinglesBySelectingAddYourselfCheckbox method");
	}

	@Test(priority = 4, description = "verify Add A Match Funtionality For Doubles By Selecting Add Your self Checkbox", groups = "sanity")
	@Description("Test case #4,verify Add A Match Funtionality For Doubles By Selecting Add Your self Checkbox ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, verify Add A Match Funtionality For Doubles By Selecting Add Your self Checkbox")
	public void verifyAddAMatchFuntionalityForDoublesBySelectingAddYourselfCheckbox() {
		logger.info("Starting of verifyAddAMatchFuntionalityForDoublesBySelectingAddYourselfCheckbox method");

		addClubMatchDirectorOnlyPage.clickOnAddAMatchButton();
		addAMatchPage.setLocationInDoubles(testDataProp.getProperty("location.city.name"));
		addAMatchPage.setEventName(testDataProp.getProperty("event.name.in.doubles"));

		addClubMatchDirectorOnlyPage.clickOnAddYourselfAsPlayerCheckbox();
		Assert.assertTrue(addClubMatchDirectorOnlyPage.isDirectorNameDisplayedItSelf());

		addClubMatchDirectorOnlyPage.clickOnAddDoublesButton();

		addClubMatchDirectorOnlyPage.clickOnAddFirstOpponentButton();
		addClubMatchDirectorOnlyPage.clickOnPlayerRadioButton();
		Assert.assertTrue(addAMatchPage.isAddPlayerButtonEnabled());
		addAMatchPage.clickOnAddPlayerButton();

		addClubMatchDirectorOnlyPage.clickOnAddSecondPlayerButton();
		addClubMatchDirectorOnlyPage.clickOnPlayerRadioButton();
		Assert.assertTrue(addAMatchPage.isAddPlayerButtonEnabled());
		addAMatchPage.clickOnAddPlayerButton();

		addClubMatchDirectorOnlyPage.clickOnAddSecondOpponentButton();
		addClubMatchDirectorOnlyPage.clickOnPlayerRadioButton();
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

		logger.info("Ending of verifyAddAMatchFuntionalityForDoublesBySelectingAddYourselfCheckbox method");
	}

	@Test(priority = 5, description = "verify Add A Match Funtionality For Singles By WithOut Selecting Add Your self Checkbox", groups = "sanity")
	@Description("Test case #5,verify Add A Match Funtionality For Singles By WithOut Selecting Add Your self Checkbox ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, verify Add A Match Funtionality For Singles By WithOut Selecting Add Your self Checkbox")
	public void verifyAddAMatchFuntionalityForSinglesByWithOutSelectingAddYourselfCheckbox() {
		logger.info("Starting of verifyAddAMatchFuntionalityForSinglesByWithOutSelectingAddYourselfCheckbox method");

		addClubMatchDirectorOnlyPage.clickOnAddAMatchButton();
		addAMatchPage.setLocationInDoubles(testDataProp.getProperty("location.city.name"));
		addAMatchPage.setEventName(testDataProp.getProperty("event.name.in.doubles"));

		addAMatchPage.clickOnSinglesButton();

		addClubMatchDirectorOnlyPage.clickOnAddFirstPlayerButton();
		addClubMatchDirectorOnlyPage.clickOnPlayerRadioButton();
		Assert.assertTrue(addAMatchPage.isAddPlayerButtonEnabled());
		addAMatchPage.clickOnAddPlayerButton();

		addClubMatchDirectorOnlyPage.clickOnAddFirstOpponentButton();
		addClubMatchDirectorOnlyPage.clickOnPlayerRadioButton();
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

		logger.info("Ending of verifyAddAMatchFuntionalityForSinglesByWithOutSelectingAddYourselfCheckbox method");
	}

	@Test(priority = 6, description = "verify Add A Match Funtionality For Doubles By WithOut Selecting Add Your self Checkbox", groups = "sanity")
	@Description("Test case #6,verify Add A Match Funtionality For Doubles By WithOut Selecting Add Your self Checkbox ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, verify Add A Match Funtionality For Doubles By WithOut Selecting Add Your self Checkbox")
	public void verifyAddAMatchFuntionalityForDoublesByWithOutSelectingAddYourselfCheckbox() {
		logger.info("Starting of verifyAddAMatchFuntionalityForDoublesByWithOutSelectingAddYourselfCheckbox method");

		addClubMatchDirectorOnlyPage.clickOnAddAMatchButton();
		addAMatchPage.setLocationInDoubles(testDataProp.getProperty("location.city.name"));
		addAMatchPage.setEventName(testDataProp.getProperty("event.name.in.doubles"));

		addClubMatchDirectorOnlyPage.clickOnAddDoublesButton();

		addClubMatchDirectorOnlyPage.clickOnAddFirstPlayerButton();
		addClubMatchDirectorOnlyPage.clickOnPlayerRadioButton();
		Assert.assertTrue(addAMatchPage.isAddPlayerButtonEnabled());
		addAMatchPage.clickOnAddPlayerButton();

		addClubMatchDirectorOnlyPage.clickOnAddFirstOpponentButton();
		addClubMatchDirectorOnlyPage.clickOnPlayerRadioButton();
		Assert.assertTrue(addAMatchPage.isAddPlayerButtonEnabled());
		addAMatchPage.clickOnAddPlayerButton();

		addClubMatchDirectorOnlyPage.clickOnAddSecondPlayerButton();
		addClubMatchDirectorOnlyPage.clickOnPlayerRadioButton();
		Assert.assertTrue(addAMatchPage.isAddPlayerButtonEnabled());
		addAMatchPage.clickOnAddPlayerButton();

		addClubMatchDirectorOnlyPage.clickOnAddSecondOpponentButton();
		addClubMatchDirectorOnlyPage.clickOnPlayerRadioButton();
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

		logger.info("Ending of verifyAddAMatchFuntionalityForDoublesByWithOutSelectingAddYourselfCheckbox method");
	}

	@Test(priority = 7, description = "Validate club match functionality in matches Tab ", groups = "sanity")
	@Description("Test case #7,Validate club match functionality in matches Tab  ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Validate club match functionality in matches Tab ")
	public void ValidatClubMatchFunctionalityInMatchesTab() {
		logger.info("Starting of ValidatClubMatchFunctionalityInMatchesTab method");

		addClubMatchDirectorOnlyPage.clickOnMatchesButton();
		//addClubMatchDirectorOnlyPage.isMatchesTabContains();

		logger.info("Ending of ValidatClubMatchFunctionalityInMatchesTab method");
	}

	@Test(priority = 8, description = "Validate club match Sort functionality in matches Tab ", groups = "sanity")
	@Description("Test case #8,Validate club match Sort functionality in matches Tab  ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Validate club match Sort functionality in matches Tab ")
	public void ValidatClubMatchSortFunctionalityInMatchesTab() {
		logger.info("Starting of ValidatClubMatchSortFunctionalityInMatchesTab method");

		addClubMatchDirectorOnlyPage.clickOnMatchesButton();
		addClubMatchDirectorOnlyPage.clickOnSortButton();
		Assert.assertTrue(addClubMatchDirectorOnlyPage.isSortFilterContains());
		addClubMatchDirectorOnlyPage.clickOnOldestToNewestButton();
		addClubMatchDirectorOnlyPage.clickOnSortButton();
		addClubMatchDirectorOnlyPage.clickOnNewestToOldestButton();

		logger.info("Ending of ValidatClubMatchSortFunctionalityInMatchesTab method");
	}

	@Test(priority = 9, description = "Validate club match Single functionality in matches Tab ", groups = "sanity")
	@Description("Test case #9,Validate club match Single functionality in matches Tab  ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9, Validate club match Single functionality in matches Tab ")
	public void ValidatClubMatchSingleFunctionalityInMatchesTab() {
		logger.info("Starting of ValidatClubMatchSingleFunctionalityInMatchesTab method");

		addClubMatchDirectorOnlyPage.clickOnSinglesButton();
		Assert.assertTrue(addClubMatchDirectorOnlyPage.isRightMarkSinglesDisplayed());

		logger.info("Ending of ValidatClubMatchSingleFunctionalityInMatchesTab method");
	}

	@Test(priority = 10, description = "Validate club match Doubles functionality in matches Tab ", groups = "sanity")
	@Description("Test case #10,Validate club match Doubles functionality in matches Tab  ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #10, Validate club match Doubles functionality in matches Tab ")
	public void ValidatClubMatchDoublesFunctionalityInMatchesTab() {
		logger.info("Starting of ValidatClubMatchDoublesFunctionalityInMatchesTab method");

		addClubMatchDirectorOnlyPage.clickOnSinglesButton();
		addClubMatchDirectorOnlyPage.clickOnDoublesButton();

		Assert.assertTrue(addClubMatchDirectorOnlyPage.isRightMarkDoublesDisplayed());

		logger.info("Ending of ValidatClubMatchDoublesFunctionalityInMatchesTab method");
	}

	@Test(priority = 11, description = "Validate club match Clear Filters functionality in matches Tab ", groups = "sanity")
	@Description("Test case #11,Validate club match Clear Filters functionality in matches Tab  ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #11, Validate club match Clear Filters functionality in matches Tab ")
	public void ValidatClubMatchClearFiltersFunctionalityInMatchesTab() {
		logger.info("Starting of ValidatClubMatchClearFiltersFunctionalityInMatchesTab method");

		addClubMatchDirectorOnlyPage.clickOnSinglesButton();
		Assert.assertTrue(addClubMatchDirectorOnlyPage.isRightMarkSinglesDisplayed());
		Assert.assertTrue(addClubMatchDirectorOnlyPage.isRightMarkDoublesDisplayed());
		addClubMatchDirectorOnlyPage.clickOnClearFiltersButton();

		Assert.assertFalse(addClubMatchDirectorOnlyPage.isSingleAndDoubleRightMarkDisplayed());

		logger.info("Ending of ValidatClubMatchClearFiltersFunctionalityInMatchesTab method");
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
