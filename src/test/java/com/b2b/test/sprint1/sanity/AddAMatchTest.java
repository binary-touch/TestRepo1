package com.b2b.test.sprint1.sanity;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.test.CommonBaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("DUPR App")
@Feature("Add a Match-Sanity")
public class AddAMatchTest extends CommonBaseTest {

	private static final Logger logger = Logger.getLogger(AddAMatchTest.class.getName());

	@BeforeClass
	@Parameters({ "browser", "siteURL", "validEmail", "validPassword" })
	public void initMethod(String browser, String siteURL, String email, String password) throws Exception {
		logger.info("Starting of initMethod in AddAMatchTest");

		this.driver = super.getWebDriver(WebDriversEnum.ADDAMATCH_DRIVER);
		super.initCommonBaseTest(siteURL, email, password);

		logger.info("Ending of initMethod in AddAMatchTest");
	}

	@Test(priority = 1, description = "Verify Add a Match functionality", groups = "sanity")
	@Description("Test case #1,Verify Add a Match functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1,Verify Add a Match functionality")
	public void verifyAddAMatchFuntionality() {
		logger.info("Starting of verifyAddAMatchFuntionality method");

		addAMatchPage.clickOnAddAMatchTab();
		Assert.assertTrue(addAMatchPage.isAddAMatchPageContains());

		logger.info("Ending of verifyAddAMatchFuntionality method");
	}

	@Test(priority = 2, description = "Verify Add a Match functionality with Doubles & Rally match option  selected as No", groups = "sanity")
	@Description("Test case #2,Add a Match functionality with Doubles & Rally match option  selected as No")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Add a Match functionality with Doubles & Rally match as No")
	public void verifySetMatchDetails() {
		logger.info("Starting of verifySetMatchDetails method");

		addAMatchPage.setLocationInDoubles(testDataProp.getProperty("location.city.name"));
		addAMatchPage.setEventName(testDataProp.getProperty("event.name.in.doubles"));

		logger.info("Ending of verifySetMatchDetails method");
	}

	@Test(priority = 3, description = "Verify add your partner functionality", groups = "sanity")
	@Description("Test case #3,Verify add your partner functionality ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify add your partner button functionality ")
	public void verifyAddYourPartnerFunctonality() {
		logger.info("Starting of verifyAddYourPartnerFunctonality method");

		addAMatchPage.clickOnAddPlayer();
		Assert.assertTrue(addAMatchPage.isAddPlayerPageContains());

		addAMatchPage.searchWithPlayerName(testDataProp.getProperty("search.partner.name"));
		this.verifyAddPlayer();

		logger.info("Ending of verifyAddYourPartnerFunctonality method");
	}

	@Test(priority = 4, description = "Verify Add Your Opponent Functionality In Team 2 by Invite a Player", groups = "sanity")
	@Description("Test case #4,Verify Add Your Opponent Functionality In Team 2 by Invite a Player through invite feature ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify Add Your Opponent Functionality In Team 2 by Invite a Player")
	public void verifyAddYourOpponentByInvite() {
		logger.info("Starting of verifyAddYourOpponentByInvite method");
		
		addAMatchPage.hardWait(3);
		addAMatchPage.clickOnAddPlayer();

		Assert.assertTrue(addAMatchPage.isAddPlayerPageContains());
		Assert.assertTrue(addAMatchPage.isAddPlayerButtonDisabled());

		addAMatchPage.clickOnInviteButton();
		addAMatchPage.setFullName(testDataProp.getProperty("player.name.in.browse.players"));
		addAMatchPage.setEmail(testDataProp.getProperty("invite.email"));
		addAMatchPage.clickOnSendInviteButton();
		addAMatchPage.hardWait(6);

		Assert.assertEquals(addAMatchPage.getInviteSentText(), expectedAssertionsProp.getProperty("invite.sent.label"));

		addAMatchPage.clickOnOkButtonInInviteSentPopup();

		Assert.assertTrue(addAMatchPage.isFirstOpponentDisplayed());

		logger.info("Ending of verifyAddYourOpponentByInvite method");
	}

	@Test(priority = 5, description = "Verify Add Your Opponent functionality by selecting the Existing player from the Players List", groups = "sanity")
	@Description("Test case #5, Verify Add Your Opponent functionality by search and select a player from the Players List")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify Add Your Opponent functionality by by search and select a player from the Players List")
	public void verifyAddOpponentPlayerWithSearchByName() {
		logger.info("Starting of verifyAddOpponentPlayerWithSearchByName method");

		addAMatchPage.clickOnAddPlayer();
		Assert.assertTrue(addAMatchPage.isAddPlayerPageContains());
		addAMatchPage.searchWithPlayerName(testDataProp.getProperty("search.first.opponent.name"));
		this.verifyAddPlayer();

		logger.info("Ending of verifyAddOpponentPlayerWithSearchByName method");
	}

	@Test(priority = 6, description = "Verify add a game score and submitting added match details", groups = "sanity")
	@Description("Test case #6,Verify add a game score and submitting added match details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify add a game score and submitting added match details")
	public void verifyAddScoreFunctionality() {
		logger.info("Starting of verifyAddScoreFunctionality method");

		addAMatchPage.setGameOneScores(testDataProp.getProperty("teamone.gameone.Score"),
				testDataProp.getProperty("teamtwo.gameone.Score"));
		addAMatchPage.clickOnSubmitButton();

		addAMatchPage.hardWait(2);
		Assert.assertEquals(addAMatchPage.getSubmitScoresText(),
				expectedAssertionsProp.getProperty("submit.final.score.label"));
		addAMatchPage.clickOnSubmitButtonInFinalScoresPopup();

		Assert.assertEquals(addAMatchPage.getSuccessText(), expectedAssertionsProp.getProperty("success.label"));
		Assert.assertTrue(addAMatchPage.isOkButtonDisplayed());

		addAMatchPage.clickOnOKButtonInSuccessPopup();

		logger.info("Ending of verifyAddScoreFunctionality method");
	}

	@Test(priority = 7, description = "Verify Add a Match functionality Verify add a game score and submitting added match details ", groups = "sanity")
	@Description("Test case #7, Verify Add a Match functionality with Singles & Rally matchas Yes ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Verify Add a Match functionality with Singles & Rally matchas Yes ")
	public void verifyAddAMatchInSingles() {
		logger.info("Starting of verifyAddAMatchInSingles method");

		driver.navigate().refresh();
		addAMatchPage.hardWait(1);
		addAMatchPage.clickOnAddAMatchTab();

		this.verifySetMatchDetails();
		addAMatchPage.clickOnSinglesButton();
		addAMatchPage.clickOnAddOpponentButton();

		Assert.assertTrue(addAMatchPage.isAddPlayerPageContains());

		addAMatchPage.searchWithPlayerName(testDataProp.getProperty("search.first.opponent.name"));
		this.verifyAddPlayer();

		logger.info("Ending of verifyAddAMatchInSingles method");
	}

	@Test(priority = 8, description = "Verify Plus icon functionality for displaying game scrore fields at Add a score page", groups = "sanity")
	@Description("Test case #8,Verify Plus icon functionality for displaying game scrore fields at Add a score page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Verify Plus icon functionality for displaying game scrore fields at Add a score page")
	public void verifyPlusIcon() {
		logger.info("Starting of verifyPlusIcon method");

		addAMatchPage.clickOnPlusIcon();
		Assert.assertTrue(addAMatchPage.isGameTwoScoreBoxesDisplayed());

		logger.info("Ending of verifyPlusIcon method");
	}

	@Test(priority = 9, description = "Verify Add score functionality by adding score less than 6 in game 1", groups = "sanity")
	@Description("Test case #9,Verify Add score functionality by adding score less than 6 in game 1")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9,Verify Add score functionality by adding score less than 6 in game 1")
	public void verifyAddFirstGameScoreLessThanSix() {
		logger.info("Starting of verifyAddFirstGameScoreLessThanSix method");

		driver.navigate().refresh();
		addAMatchPage.setGameOneScores(testDataProp.getProperty("teamone.gameone.Score"),
				testDataProp.getProperty("teamone.gameone.Score"));
		addAMatchPage.clickOnSubmitButton();

		String scoreValidationMessage = addAMatchPage.getValidationScoreLessThanSix();
		Assert.assertEquals(scoreValidationMessage,
				expectedAssertionsProp.getProperty("validation.message.score.less.than.six"));

		logger.info("Ending of verifyAddFirstGameScoreLessThanSix method");
	}

	@Test(priority = 10, description = "Verify add score functionality by adding game results as both teams won each one game and second game is tie", groups = "sanity")
	@Description("Test case #10,Verify add score functionality by adding game results as both teams won each one game and second game is tie")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #10,Verify add score functionality by adding game results as both teams won each one game and second game is tie")
	public void verifyAddScoreFunctionalityByTieingSecondGame() {
		logger.info("Starting of verifyAddScoreFunctionalityByTieingSecondGame method");

		driver.navigate().refresh();
		addAMatchPage.setGameOneScores(testDataProp.getProperty("teamone.gameone.Score"),
				testDataProp.getProperty("teamtwo.gameone.Score"));
		addAMatchPage.clickOnPlusIcon();
		addAMatchPage.setGameTwoScores(testDataProp.getProperty("teamtwo.gamethree.Score"),
				testDataProp.getProperty("teamtwo.gamethree.Score"));
		addAMatchPage.clickOnPlusIcon();
		addAMatchPage.setGameThreeScores(testDataProp.getProperty("teamone.gamethree.Score"),
				testDataProp.getProperty("teamtwo.gamethree.Score"));
		addAMatchPage.clickOnSubmitButton();

		String scoreValidationMessage = addAMatchPage.getValidationEitherTeamMustWinner();
		Assert.assertEquals(scoreValidationMessage,
				expectedAssertionsProp.getProperty("validation.message.Either.Team.Must.Winner"));

		logger.info("Ending of verifyAddScoreFunctionalityByTieingSecondGame method");
	}

	@Test(priority = 11, description = "Verify add score functionality by adding game results as both teams won each one game and First game is tie", groups = "sanity")
	@Description("Test case #11,Verify add score functionality by adding game results as both teams won each one game and First game is tie")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #11,Verify add score functionality by adding game results as both teams won each one game and First game is tie")
	public void verifyAddScoreFunctionalityByTieingFirstGame() {
		logger.info("Starting of verifyAddScoreFunctionalityByTieingFirstGame method");

		driver.navigate().refresh();
		addAMatchPage.setGameOneScores(testDataProp.getProperty("teamone.gameone.Score"),
				testDataProp.getProperty("teamtwo.gameone.Score"));

		addAMatchPage.clickOnPlusIcon();
		addAMatchPage.setGameTwoScores(testDataProp.getProperty("teamone.gamethree.Score"),
				testDataProp.getProperty("teamtwo.gamethree.Score"));

		addAMatchPage.clickOnPlusIcon();
		addAMatchPage.setGameThreeScores(testDataProp.getProperty("teamtwo.gamethree.Score"),
				testDataProp.getProperty("teamtwo.gamethree.Score"));

		addAMatchPage.clickOnSubmitButton();

		String scoreValidationMessage = addAMatchPage.getValidationEitherTeamMustWinner();
		Assert.assertEquals(scoreValidationMessage,
				expectedAssertionsProp.getProperty("validation.message.Either.Team.Must.Winner"));

		logger.info("Ending of verifyAddScoreFunctionalityByTieingFirstGame method");
	}

	@Test(priority = 12, description = "Verify add score functionality with only adding one game scores and leaving other two game score empty", groups = "sanity")
	@Description("Test case #12Verify add score functionality with only adding one game scores and leaving other two game score empty")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #12, Verify add score functionality with only adding one game scores and leaving other two game score empty")
	public void verifyAddScoreFunctionalityWithOnlyAddingOneGame() {
		logger.info("Starting of verifyAddScoreFunctionalityWithOnlyAddingOneGame method");

		driver.navigate().refresh();
		addAMatchPage.setGameOneScores(testDataProp.getProperty("teamone.gameone.Score"),
				testDataProp.getProperty("teamtwo.gameone.Score"));

		addAMatchPage.clickOnPlusIcon();
		addAMatchPage.clickOnPlusIcon();

		addAMatchPage.clickOnSubmitButton();
		addAMatchPage.hardWait(3);
		String scoreValidationMessage = addAMatchPage.getValidationScoreIsRequired();
		Assert.assertEquals(scoreValidationMessage,
				expectedAssertionsProp.getProperty("validation.message.score.required"));

		logger.info("Ending of verifyAddScoreFunctionalityWithOnlyAddingOneGame method");
	}

	@Test(priority = 13, description = "Verify add score functionality with making Tie between Team 1 & Team 2 in all three games", groups = "sanity")
	@Description("Test case #13,Verify add score functionality with making Tie between Team 1 & Team 2 in all three games")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #13, Verify add score functionality with making Tie between Team 1 & Team 2 in all three games")
	public void verifyAddScoreFunctionalityByTieingAllTheGames() {
		logger.info("Starting of verifyAddScoreFunctionalityByTieingAllTheGames method");

		driver.navigate().refresh();
		addAMatchPage.setGameOneScores(testDataProp.getProperty("teamtwo.gametwo.Score"),
				testDataProp.getProperty("teamtwo.gametwo.Score"));

		addAMatchPage.clickOnPlusIcon();
		addAMatchPage.setGameTwoScores(testDataProp.getProperty("teamtwo.gametwo.Score"),
				testDataProp.getProperty("teamtwo.gametwo.Score"));

		addAMatchPage.clickOnPlusIcon();
		addAMatchPage.setGameThreeScores(testDataProp.getProperty("teamtwo.gametwo.Score"),
				testDataProp.getProperty("teamtwo.gametwo.Score"));

		addAMatchPage.clickOnSubmitButton();

		String scoreValidationMessage = addAMatchPage.getValidationEitherTeamMustWinner();
		Assert.assertEquals(scoreValidationMessage,
				expectedAssertionsProp.getProperty("validation.message.Either.Team.Must.Winner"));

		logger.info("Ending of verifyAddScoreFunctionalityByTieingAllTheGames method");
	}

	@Test(priority = 14, description = "Verify player is visible in browse player list After sending invite to palyer ", groups = "sanity")
	@Description("Test case #14,After sending invite, verify player is visible in browse player list")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #14, After sending invite, verify player is visible in browse player list")
	public void verifyInvitePlayerIsInBrowserPlayersList() {
		logger.info("Starting of verifyInvitePlayerIsInBrowserPlayersList method");

		driver.navigate().refresh();

		addAMatchPage.clickOnSinglesButton();

		addAMatchPage.clickOnAddOpponentButton();

		addAMatchPage.clickOnInviteButton();
		addAMatchPage.setFullName(testDataProp.getProperty("full.name"));
		addAMatchPage.setEmail(testDataProp.getProperty("invite.email"));
		addAMatchPage.clickOnSendInviteButton();

		addAMatchPage.hardWait(2);
		addAMatchPage.clickOnOkButtonInInviteSentPopup();

		addAMatchPage.clickOnPlayersTab();
		browsePlayersPage.hardWait(4);

		searchPlayersPage.searchWithPlayerName(testDataProp.getProperty("player.name.in.browse.players"));
		browsePlayersPage.hardWait(2);

		String PlayerName = browsePlayersPage.getPlayerName();
		Assert.assertEquals(PlayerName, expectedAssertionsProp.getProperty("search.player.name.in.browse.players"));

		logger.info("Ending of verifyInvitePlayerIsInBrowserPlayersList method");
	}

	@Test(priority = 15, description = "Verify player is visible in search player list After sending invite to palyer", groups = "sanity")
	@Description("Test case #15,After sending invite, verify player is visible in search player list")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #15 After sending invite, verify player is visible in search player list")
	public void verifyInvitePlayerIsInSearchPlayersList() {
		logger.info("Starting of verifyInvitePlayerIsInSearchPlayersList method");

		driver.get("https://stage.gamestoppedout.com/");
		searchPlayersPage.clickOnSearchLink();
		searchPlayersPage.hardWait(3);

		searchPlayersPage.searchWithPlayerName(testDataProp.getProperty("player.name.in.search.players"));
		browsePlayersPage.hardWait(5);

		String playerName = searchPlayersPage.getPlayerName(testDataProp.getProperty("player.name.in.search.players"));
		Assert.assertEquals(playerName, expectedAssertionsProp.getProperty("search.player.name"));

		logger.info("Ending of verifyInvitePlayerIsInSearchPlayersList method");
	}

	public void verifyAddPlayer() {
		logger.info("Starting of verifyAddPlayer method");

		Assert.assertTrue(addAMatchPage.isAddPlayerButtonDisabled());

		addAMatchPage.clickOnPlayerRadioButton();
		Assert.assertTrue(addAMatchPage.isAddPlayerButtonEnabled());

		addAMatchPage.clickOnAddPlayerButton();
		Assert.assertTrue(addAMatchPage.isAddPartnerDisplayed());

		logger.info("Ending of verifyAddPlayer method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.ADDAMATCH_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
