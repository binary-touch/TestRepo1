package com.dupr.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.AddAMatchPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("DUPR App")
@Feature("Add a Match")
public class AddAMatchTest extends DUPRBaseAutomationTest {
	private static final Logger logger = Logger.getLogger(AddAMatchTest.class.getName());

	private AddAMatchPage addamatchpage = null;
	private WebDriver driver = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "validEmail", "validPassword" })
	public void initMethod(String browser, String siteURL, String email, String password) throws Exception {
		logger.info("Starting of initMethod in AddAMatchTest");

		this.driver = super.getWebDriver(WebDriversEnum.ADDAMATCH_DRIVER_TEST);
		siteLogin(driver, email, password);
		this.addamatchpage = new AddAMatchPage(this.driver);

		logger.info("Ending of initMethod in AddAMatchTest");
	}

	@Test(priority = 1, description = "Verify click on Add a Match", groups = "sanity")

	@Description("Test case #1,Verify click on Add a Match")

	@Severity(SeverityLevel.NORMAL)

	@Story("Test case #1, Click on Add a Match")
	public void verifyClickOnAddAMatch() {
		logger.info("Starting of verifyClickOnAddAMatch method");

		addamatchpage.clickOnAddAMatchTab();

		Assert.assertTrue(addamatchpage.isAddAMatchPageContains());

		logger.info("Ending of verifyClickOnAddAMatch method");
	}

	@Test(priority = 2, description = "Verify match details in doubles Rally match option  selected as No", groups = "sanity")

	@Description("Test case #2,Verify match details in doubles Rally match option  selected as No ")

	@Severity(SeverityLevel.NORMAL)

	@Story("Test case #2, Verify match details in doubles Rally match option  selected as No ")
	public void verifyClickOnAddPartner() {
		logger.info("Starting of verifyClickOnAddPartner method");

		addamatchpage.setMatchDate(testDataProp.getProperty("match.date"));
		addamatchpage.setLocation(testDataProp.getProperty("location"));
		addamatchpage.setEventName(testDataProp.getProperty("event.name.in.doubles"));
		addamatchpage.clickOnAddPartnerbutton();

		Assert.assertTrue(addamatchpage.isAddPlayerPageContains());

		logger.info("Ending of verifyClickOnAddPartner method");
	}

	@Test(priority = 3, description = "Verify Add partner functionality", groups = "sanity")

	@Description("Test case #3,Verify Add partner functionality ")

	@Severity(SeverityLevel.NORMAL)

	@Story("Test case #3, Verify Add partner functionality ")
	public void verifyAddPartner() {
		logger.info("Starting of verifyAddPartner method");

		addamatchpage.searchWithPlayerName();
		Assert.assertTrue(addamatchpage.isAddPlayerButtonDisabled());
		addamatchpage.clickOnPlayerRadioButton();
		Assert.assertTrue(addamatchpage.isAddPlayerButtonEnabled());
		addamatchpage.clickOnAddPlayerButton();

		Assert.assertTrue(addamatchpage.isAddPartnerDisplayed());

		logger.info("Ending of verifyAddPartner method");
	}

	@Test(priority = 4, description = "Verify Add opponent functionality", groups = "sanity")

	@Description("Test case #4,Verify Add opponent functionality ")

	@Severity(SeverityLevel.NORMAL)

	@Story("Test case #4, Verify Add opponent functionality ")
	public void verifyClickOnAddOpponent() {
		logger.info("Starting of verifyClickOnAddOpponent method");

		addamatchpage.clickOnFirstOpponent();

		Assert.assertTrue(addamatchpage.isAddPlayerPageContains());

		Assert.assertTrue(addamatchpage.isAddPlayerButtonDisabled());

		logger.info("Ending of verifyClickOnAddOpponent method");

	}

	@Test(priority = 5, description = "Verify Add first opponent Player", groups = "sanity")

	@Description("Test case #5,Verify Add first opponent player")

	@Severity(SeverityLevel.NORMAL)

	@Story("Test case #5, Verify Add first opponent player ")
	public void verifyAddFirstOpponentplayer() {
		logger.info("Starting of verifyAddFirstOpponentplayer method");

		addamatchpage.clickOnInviteButton();

		Assert.assertTrue(addamatchpage.isInvitePlayerPageContains());
		addamatchpage.setFullName(testDataProp.getProperty("full.name"));
		addamatchpage.setEmail(testDataProp.getProperty("not.registered.email"));
		addamatchpage.clickOnSendInviteButton();
		addamatchpage.hardWait(2);
		Assert.assertEquals(addamatchpage.getInviteSentText(), expectedAssertionsProp.getProperty("invite.sent.label"));

		addamatchpage.clickOnOKButton();
		Assert.assertTrue(addamatchpage.isFirstOPPonentDisplayed());

		logger.info("Ending of verifyAddFirstOpponentplayer method");
	}

	@Test(priority = 6, description = "Verify Add second opponent Player", groups = "sanity")

	@Description("Test case #6,Verify Add second opponent player")

	@Severity(SeverityLevel.NORMAL)

	@Story("Test case #6, Verify Add second opponent player ")
	public void verifyClickOnAddSecondOpponent() {

		logger.info("Starting of verifyClickOnAddSecondOpponent method");

		addamatchpage.clickOnSecondOpponent();

		Assert.assertTrue(addamatchpage.isAddPlayerPageContains());

		Assert.assertTrue(addamatchpage.isAddPlayerButtonDisabled());

		logger.info("Ending of verifyClickOnAddSecondOpponent method");
	}

	@Test(priority = 7, description = "Verify Add second opponent Player", groups = "sanity")

	@Description("Test case #4,Verify Add second opponent player")

	@Severity(SeverityLevel.NORMAL)

	@Story("Test case #4, Verify Add second opponent player ")
	public void verifyAddSecondOpponent() {
		logger.info("Starting of verifyAddSecondOpponent method");

		addamatchpage.searchWithPlayerName();
		Assert.assertTrue(addamatchpage.isAddPlayerButtonDisabled());
		addamatchpage.clickOnPlayerRadioButton();
		Assert.assertTrue(addamatchpage.isAddPlayerButtonEnabled());
		addamatchpage.clickOnAddPlayerButton();

		logger.info("Ending of verifyAddSecondOpponent method");
	}

	@Test(priority = 8, description = "Verify adding game one scores functionality", groups = "sanity")

	@Description("Test case #8,Verify adding game one scores functionality  selected as No ")

	@Severity(SeverityLevel.NORMAL)

	@Story("Test case #8, Verify adding game one scores functionality ")
	public void verifyAddingGameOneScores() {
		logger.info("Starting of verifyAddingGameOneScores method");

		addamatchpage.setGameOneScores(testDataProp.getProperty("teamone.gameone.Score"),
				testDataProp.getProperty("teamtwo.gameone.Score"));

		logger.info("Ending of verifyAddingGameOneScores method");
	}

	@Test(priority = 9, description = "Verif Plus icon functionality for adding game 2 and game 3 scores", groups = "sanity")

	@Description("Test case #9,Verif Plus icon functionality for adding game 2 and game 3 scores")

	@Severity(SeverityLevel.NORMAL)

	@Story("Test case 9 #, Verif Plus icon functionality for adding game 2 and game 3 scores ")
	public void verifyPlusicon() {
		logger.info("Starting of verifyPlusicon method");

		addamatchpage.clickOnPlusIcon();

		addamatchpage.setGameTwoScores(testDataProp.getProperty("teamone.gametwo.Score"),
				testDataProp.getProperty("teamtwo.gametwo.Score"));

		logger.info("Ending of verifyPlusicon method");
	}

	@Test(priority = 10, description = "Verify Submit button functionality", groups = "sanity")

	@Description("Test case #10,Verify Submit button functionality")

	@Severity(SeverityLevel.NORMAL)

	@Story("Test case 10 #, Verify Submit button functionality")
	public void verifySubmitButton() {
		logger.info("Starting of verifyPlusicon method");
		addamatchpage.clickOnSubmitButton();
		Assert.assertEquals(addamatchpage.getSuccessText(), expectedAssertionsProp.getProperty("success.label"));
		Assert.assertTrue(addamatchpage.isOKButtonDisplayed());
		addamatchpage.clickOnOKButton();
		logger.info("Ending of verifyPlusicon method");
	}

	@Test(priority = 11, description = "Verify match details in singles Rally match option selected as Yes ", groups = "sanity")
	@Description("Test case #11,Verify match details in singles Rally match option  selected as Yes ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case 11 #, Verify match details in singles Rally match option  selected as Yes ")
	public void verifyAddAMatchWithSingles() {
		logger.info("Starting of verifyAddAMatchWithSingles method");

		addamatchpage.clickOnAddAMatchTab();
		addamatchpage.clickOnRallyMatchToggle();

		addamatchpage.setLocation(testDataProp.getProperty("location"));
		addamatchpage.setEventName(testDataProp.getProperty("event.name"));

		Assert.assertTrue(addamatchpage.isAddYourPartnerButtonEnabled());

		addamatchpage.clickOnSinglesButton();

		Assert.assertTrue(addamatchpage.isAddYourPartnerButtonDisplayed());

		logger.info("Ending of verifyAddAMatchWithSingles method");
	}

	@Test(priority = 12, description = "Verify Add your opponent in singles match", groups = "sanity")
	@Description("Test case #12,Verify Add your opponent in singles match ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case 12 #, Verify Add your opponent in singles match")
	public void verifyAddYourOpponentButton() {
		logger.info("Starting of verifyAddYourOpponentButton method");

		addamatchpage.clickOnAddYourOpponent();

		Assert.assertTrue(addamatchpage.isAddPlayerPageContains());

		logger.info("Ending of verifyAddYourOpponentButton method");
	}

	@Test(priority = 13, description = "Verify Add your opponent in singles match", groups = "sanity")
	@Description("Test case #12,Verify Add your opponent in singles match ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #13, Verify Add your opponent in singles match")
	public void verifyAddYourOpponent() {
		logger.info("Starting of verifyAddYourOpponent method");

		addamatchpage.searchWithPlayerName();
		addamatchpage.clickOnPlayerRadioButton();
		addamatchpage.clickOnAddPlayerButton();

		Assert.assertTrue(addamatchpage.isFirstOPPonentDisplayed());

		logger.info("Ending of verifyAddYourOpponent method");
	}

	@Test(priority = 14, description = "Verify Adding game one scores in singles", groups = "sanity")
	@Description("Test case #14,Verify Adding game one scores in singles ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case 14 #, Verify Adding game one scores in singles")
	public void verifyAddGameOneScoresInSingles() {
		logger.info("Starting of verifyAddGameOneScoresInSingles method");

		addamatchpage.setGameOneScores(testDataProp.getProperty("teamone.gameone.Score"),
				testDataProp.getProperty("teamtwo.gameone.Score"));

		logger.info("Ending of verifyAddGameOneScoresInSingles method");
	}

	@Test(priority = 15, description = "Verify Plus icon functionality and adding game two scores", groups = "sanity")
	@Description("Test case #15,Verify Plus icon functionality and adding game two scores ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case 15 #, Verify Plus icon functionality and adding game two scores")
	public void verifyAddingGameTwoScores() {
		logger.info("Starting of verifyAddingGameTwoScores method");

		addamatchpage.clickOnPlusIcon();

		addamatchpage.setGameTwoScores(testDataProp.getProperty("teamone.gametwo.Score"),
				testDataProp.getProperty("teamtwo.gametwo.Score"));

		addamatchpage.clickOnPlusIcon();

		addamatchpage.setGameThreeScores(testDataProp.getProperty("teamone.gamethree.Score"),
				testDataProp.getProperty("teamtwo.gamethree.Score"));

		logger.info("Ending of verifyAddingGameTwoScores method");
	}

	@Test(priority = 16, description = "Verify  Submit button functionality", groups = "sanity")
	@Description("Test case #16,Verify Submit button functionality ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case 16 #, Verify Submit button functionality")
	public void verifySubmit() {
		logger.info("Starting of verifySubmit method");

		addamatchpage.clickOnSubmitButton();

		Assert.assertEquals(addamatchpage.getSuccessText(), expectedAssertionsProp.getProperty("success.label"));

		Assert.assertTrue(addamatchpage.isOKButtonDisplayed());

		addamatchpage.clickOnOKButton();

		logger.info("Ending of verifySubmit method");
	}

	/*
	 * @AfterClass public void quitDriver() {
	 * 
	 * try {
	 * 
	 * if (this.driver != null) { Thread.sleep(5000); this.quitDriver(this.driver,
	 * WebDriversEnum.FORGOT_PASSWORD_DRIVER);
	 * 
	 * logger.info("Driver quit successfully"); } } catch (Exception ex) {
	 * logger.error(ex.getMessage()); } }
	 */
}
