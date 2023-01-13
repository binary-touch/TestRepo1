package com.dupr.test;

import org.apache.log4j.Logger;

import com.dupr.pages.addamatch.AddAMatchPage;
import com.dupr.pages.players.BrowsePlayersPage;
import com.dupr.pages.players.SearchPlayersPage;

public class CommonBaseTest extends DUPRBaseAutomationTest {

	private static final Logger logger = Logger.getLogger(CommonBaseTest.class.getName());

	protected AddAMatchPage addAMatchPage = null;
	protected SearchPlayersPage searchPlayersPage = null;
	protected BrowsePlayersPage browsePlayersPage = null;
	protected static String eventName = null;

	public void initCommonBaseTest(String siteURL, String email, String password) throws Exception {
		logger.info("Starting of initTest in CommonBaseTest");

		this.siteLogin(siteURL, email, password, this.driver);

		this.addAMatchPage = new AddAMatchPage(this.driver);
		this.browsePlayersPage = new BrowsePlayersPage(this.driver);
		this.searchPlayersPage = new SearchPlayersPage(this.driver);

		logger.info("Ending of initTest in CommonBaseTest");
	}

	public void verifySetMatchDetails() {
		logger.info("Starting of verifySetMatchDetails method");

		//addAMatchPage.setMatchDate(testDataProp.getProperty("match.date"));
		addAMatchPage.setLocationInDoubles(testDataProp.getProperty("location.city.name"));

		eventName = addAMatchPage.setEventName(testDataProp.getProperty("event.name.in.doubles"));

		logger.info("Ending of verifySetMatchDetails method");
	}

	public void verifyAddAMatchInDoubles() {
		logger.info("Starting of verifyAddAMatchInDoubles method");

		addAMatchPage.clickOnAddPlayer();
		addAMatchPage.searchWithPlayerName(testDataProp.getProperty("search.partner.name"));
		addAMatchPage.clickOnPlayerRadioButton();
		addAMatchPage.clickOnAddPlayerButton();
		
		addAMatchPage.clickOnAddPlayer();
		addAMatchPage.searchWithPlayerName(testDataProp.getProperty("search.first.opponent.name"));
		addAMatchPage.clickOnPlayerRadioButton();
		addAMatchPage.clickOnAddPlayerButton();
		
		addAMatchPage.clickOnAddPlayer();
		addAMatchPage.searchWithPlayerName(testDataProp.getProperty("search.second.opponent.name"));
		addAMatchPage.clickOnPlayerRadioButton();
		addAMatchPage.clickOnAddPlayerButton();
		addAMatchPage.setGameOneScores(testDataProp.getProperty("teamone.gameone.Score"),
				testDataProp.getProperty("teamtwo.gameone.Score"));

		addAMatchPage.clickOnSubmitButton();
		
		addAMatchPage.hardWait(2);
		addAMatchPage.clickOnSubmitButtonInFinalScoresPopup();
		
		addAMatchPage.clickOnOKButtonInSuccessPopup();

		logger.info("Starting of verifyAddAMatchInDoubles method");
	}

	public void verifyAddAMatchInSinglesWonGame() {
		logger.info("Starting of verifyAddAMatchInSinglesWonGame method");

		addAMatchPage.clickOnSinglesButton();

		addAMatchPage.clickOnAddOpponentButton();
		addAMatchPage.searchWithPlayerName(testDataProp.getProperty("search.first.opponent.name"));
		addAMatchPage.clickOnPlayerRadioButton();
		addAMatchPage.clickOnAddPlayerButton();

		addAMatchPage.setGameOneScores(testDataProp.getProperty("teamtwo.gameone.Score"),
				testDataProp.getProperty("teamone.gameone.Score"));

		addAMatchPage.clickOnSubmitButton();
		
		addAMatchPage.hardWait(2);
		
		addAMatchPage.clickOnSubmitButtonInFinalScoresPopup();

		logger.info("Starting of verifyAddAMatchInDoubles method");
	}

	public void verifyAddAMatchInSinglesLossGame() {
		logger.info("Starting of verifyAddAMatchInSinglesLossGame method");

		addAMatchPage.clickOnSinglesButton();

		addAMatchPage.clickOnAddOpponentButton();
		addAMatchPage.searchWithPlayerName(testDataProp.getProperty("search.first.opponent.name"));
		addAMatchPage.clickOnPlayerRadioButton();
		addAMatchPage.clickOnAddPlayerButton();

		addAMatchPage.setGameOneScores(testDataProp.getProperty("teamone.gameone.Score"),
				testDataProp.getProperty("teamtwo.gameone.Score"));

		addAMatchPage.clickOnSubmitButton();
		
		addAMatchPage.hardWait(2);
		addAMatchPage.clickOnSubmitButtonInFinalScoresPopup();

		logger.info("Starting of verifyAddAMatchInSinglesLossGame method");
	}
}
