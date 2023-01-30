package com.dupr.test.events;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.clubs.ClubLogoPage;
import com.dupr.pages.events.AddParticipantsInBracketsPage;
import com.dupr.pages.events.Create_Edit_Split_TeamPage;
import com.dupr.pages.events.EndEventPage;
import com.dupr.pages.home.UserDashboardPage;
import com.dupr.test.DUPRBaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Brackets")
@Feature("Create_Edit_Split_Teams")
public class Create_Edit_Split_TeamTest extends DUPRBaseAutomationTest {
	private static final Logger log = LogManager.getLogger(Create_Edit_Split_TeamTest.class);

	private ClubLogoPage clubLogoPage = null;
	private EndEventPage endEventpage = null;
	private UserDashboardPage userDashboardPage = null;

	private Create_Edit_Split_TeamPage teamsPage = null;
	private AddParticipantsInBracketsPage addParticipantsPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String directorEmail, String directorPassword)
			throws Exception {
		log.info("Starting of initMethod in Create_Edit_Split_TeamTest");

		this.driver = super.getWebDriver(WebDriversEnum.TEAMS_DRIVER);
		this.siteLogin(siteURL, directorEmail, directorPassword, this.driver);

		this.clubLogoPage = new ClubLogoPage(this.driver);
		this.endEventpage = new EndEventPage(this.driver);

		this.teamsPage = new Create_Edit_Split_TeamPage(this.driver);
		this.addParticipantsPage = new AddParticipantsInBracketsPage(driver);
		this.userDashboardPage = new UserDashboardPage(this.driver);

		log.info("Ending of initMethod in Create_Edit_Split_TeamTest");
	}

	@Test(priority = 1, description = "Verify Details Displayed On UnMatchedPlayers Tab", groups = "sanity")
	@Description("Test case #1, Verify Details Displayed On UnMatchedPlayers Tab")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #1, Verify Details Displayed On UnMatchedPlayers Tab")
	public void verifyDetailsDisplayedOnUnMatchedPlayersTab() {
		log.info("Starting of verifyDetailsDisplayedOnUnMatchedPlayersTab method");

		clubLogoPage.hardWait(3);
		addParticipantsPage.clickOnMyBracketsDropdown();
		clubLogoPage.hardWait(3);

		Assert.assertEquals(userDashboardPage.getBracketsTitle(), expectedAssertionsProp.getProperty("brackets.text"));
		Assert.assertTrue(userDashboardPage.isMyBracketsPageContains());

		teamsPage.clickOnEventLabel();
		endEventpage.hardWait(5);
		
		try {
			if(teamsPage.isNoResultsFoundDisplayed()==true) {
				teamsPage.addMultiplePlayers();
			}
		} catch (Exception e) {
		log.info("****UnMatched Players Displayed****");
		}

		Assert.assertTrue(this.teamsPage.isUmMatchedPlayersTabContains());

		Assert.assertTrue(this.teamsPage.isUnMatchedPlayersChkboxesDisplayed());
		Assert.assertTrue(this.teamsPage.isUnMatchedPlayerNamesDisplayed());
		Assert.assertTrue(this.teamsPage.isUnMatchedPlayersEmailsDisplayed());
		Assert.assertTrue(this.teamsPage.isUnMatchedPlayersPaymentStatusDisplayed());
		Assert.assertTrue(this.teamsPage.isUnMatchedPlayerDoublesRatingsDisplayed());
		Assert.assertTrue(this.teamsPage.isUnMatchedPlayersSinglesRatingsDisplayed());

		log.info("Ending of verifyDetailsDisplayedOnUnMatchedPlayersTab method");
	}
	
	@Test(priority = 2, description = "Verify the state of Create Team button before Selecting Players", groups = "sanity")
	@Description("Test case #2, Verify the state of Create Team button before Selecting Players")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify the state of Create Team button before Selecting Players")
	public void verifyStateOfCreateTeamBeforeSelectingPlayers() {
		log.info("Starting of verifyStateOfCreateTeamBeforeSelectingPlayers method");

		Assert.assertTrue(this.teamsPage.isCreateTeamDisabled());

		log.info("Ending of verifyStateOfCreateTeamBeforeSelectingPlayers method");
	}

	@Test(priority = 3, description = "Verify the state of Create Team button If User Selects Only Player/More than 2 Players", groups = "sanity")
	@Description("Test case #3, Verify the state of Create Team button If User Selects Only Player/More than 2 Players")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify the state of Create Team button If User Selects Only Player/More than 2 Players")
	public void verifyCreateTeamStateIfOneOrThreePlayersSelected() {
		log.info("Starting of verifyCreateTeamStateIfOneOrThreePlayersSelected method");

		teamsPage.selectMultiplePlayers();
		clubLogoPage.hardWait(3);

		Assert.assertTrue(this.teamsPage.isCreateTeamDisabled());
		driver.navigate().refresh();
		log.info("Ending of verifyCreateTeamStateIfOneOrThreePlayersSelected method");
	}

	@Test(priority = 4, description = "Verify Players Selection From List in UnMatched Players tab", groups = "sanity")
	@Description("Test case #4, Verify Players Selection From List in UnMatched Players tab")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #4, Verify Players Selection From List in UnMatched Players tab")
	public void verifyPlayersSelectionFromList() {
		log.info("Starting of verifyPlayersSelectionFromList method");

		clubLogoPage.hardWait(3);
		teamsPage.clickOnUnMatchedPlayersTab();
		teamsPage.clickOnValidPlayerCheckbox();
		clubLogoPage.hardWait(3);

		Assert.assertTrue(this.teamsPage.isPlayersCheckboxSelected());
		boolean createTeam = teamsPage.isCreateTeamEnabled();
		assertTrue(createTeam);

		log.info("Ending of verifyPlayersSelectionFromList method");
	}

	@Test(priority = 5, description = "Verify the results on click of Create Team button", groups = "sanity")
	@Description("Test case #5, Verify the results on click of Create Team button")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #5, Verify the results on click of Create Team button")
	public void verifyResultsOnClickOfCreateTeam() {
		log.info("Starting of verifyResultsOnClickOfCreateTeam method");

		teamsPage.clickOnCreateTeamButton();
		try {
			if(teamsPage.isSameGenderPopupDisplayed()==true) {
				teamsPage.addAnotherPlayer();
			}
		} catch (Exception e) {
		log.info("****Create Team Popup displayed****");
		}
		
		clubLogoPage.hardWait(3);
		boolean createTeam = teamsPage.isCreateTeamPopupContains();
		assertTrue(createTeam);

		log.info("Ending of verifyResultsOnClickOfCreateTeam method");
	}

	@Test(priority = 6, description = "Verify the results on click of Close Icon in Create Team Popup", groups = "sanity")
	@Description("Test case #6,Verify the results on click of Close Icon in Create Team Popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6,Verify the results on click of Close Icon in Create Team Popup")
	public void verifyResultsOnClickOfCloseCreateTeamPopup() {
		log.info("Starting of verifyResultsOnClickOfCloseCreateTeamPopup method");

		teamsPage.clickOnCloseIcon();
		clubLogoPage.hardWait(3);
			
		Assert.assertTrue(this.teamsPage.isPlayersCheckboxSelected());
		boolean createTeam = teamsPage.isCreateTeamEnabled();
		assertTrue(createTeam);
		
		log.info("Ending of verifyResultsOnClickOfCloseCreateTeamPopup method");
	}

	@Test(priority = 7, description = "Verify the results on click of Cancel button in Create Team Popup", groups = "sanity")
	@Description("Test case #7, Verify the results on click of Cancel button in Create Team Popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case # 7, Verify the results on click of Cancel button in Create Team Popup")
	public void verifyResultsOnClickOfCancelPopup() {
		log.info("Starting of verifyResultsOnClickOfCancelPopup method");

		teamsPage.clickOnCreateTeamButton();
		clubLogoPage.hardWait(3);
		Assert.assertTrue(this.teamsPage.isCreateTeamPopupContains());
		
		teamsPage.clickOnCancelButton();
		clubLogoPage.hardWait(3);
		
		Assert.assertTrue(this.teamsPage.isPlayersCheckboxSelected());
		boolean createTeam = teamsPage.isCreateTeamEnabled();
		assertTrue(createTeam);
		
		log.info("Ending of verifyResultsOnClickOfCancelPopup method");
	}

	@Test(priority = 8, description = "Verify Create Team Functionality", groups = "sanity")
	@Description("Test case #8, Verify Create Team Functionality")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #8, Verify Create Team Functionality")
	public void verifyCreateTeamFunctionality() {
		log.info("Starting of verifyCreateTeamFunctionality method");

		teamsPage.clickOnCreateTeamButton();
		clubLogoPage.hardWait(3);

		teamsPage.clickOnCreateButton();
		clubLogoPage.hardWait(3);
		
		try {
			Assert.assertTrue(this.teamsPage.isUmMatchedPlayersTabContains());

			Assert.assertTrue(this.teamsPage.isUnMatchedPlayersChkboxesDisplayed());
			Assert.assertTrue(this.teamsPage.isUnMatchedPlayerNamesDisplayed());
			Assert.assertTrue(this.teamsPage.isUnMatchedPlayersEmailsDisplayed());
			Assert.assertTrue(this.teamsPage.isUnMatchedPlayersPaymentStatusDisplayed());
			Assert.assertTrue(this.teamsPage.isUnMatchedPlayerDoublesRatingsDisplayed());
			Assert.assertTrue(this.teamsPage.isUnMatchedPlayersSinglesRatingsDisplayed());

		} catch (Exception e) {
			Assert.assertTrue(this.teamsPage.isNoResultsFoundDisplayed());
		}
		
		log.info("Ending of verifyCreateTeamFunctionality method");
	}

	@Test(priority = 9, description = "Verify the recently created team in Teams tab", groups = "sanity")
	@Description("Test case #9, Verify the recently created team in Teams tab")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #9, Verify the recently created team in Teams tab")
	public void verifyRecentlyCreatedTeam() {
		log.info("Starting of verifyRecentlyCreatedTeam method");

		teamsPage.clickOnTeamsTab();

		clubLogoPage.hardWait(3);
		
		Assert.assertTrue(this.teamsPage.isTeamTabContains());

		log.info("Ending of verifyRecentlyCreatedTeam method");
	}

	@Test(priority = 10, description = "Verify Results On Click Of Edit Team Option", groups = "sanity")
	@Description("Test case #10, Verify Results On Click Of Edit Team Option")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #10, Verify Results On Click Of Edit Team Option")
	public void verifyResultsOnClickOfEditTeamOption() {
		log.info("Starting of verifyResultsOnClickOfEditTeamOption method");

		teamsPage.clickOnEditTeamButton();

		clubLogoPage.hardWait(3);
		boolean buttons = teamsPage.isResultsOnClickOfEditTeamDisplayed();
		assertTrue(buttons);

		log.info("Ending of verifyResultsOnClickOfEditTeamOption method");
	}
	
	@Test(priority = 11, description = "Verify Cancel Option In Edit Team Popup", groups = "sanity")
	@Description("Test case #11, Verify Cancel Option In Edit Team Popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #11, Verify Cancel Option In Edit Team Popup")
	public void verifyCancelOptionInEditTeamPopup() {
		log.info("Starting of verifyEditTeamFunctionality method");

		teamsPage.clickOnCancelButton();

		clubLogoPage.hardWait(3);
		Assert.assertTrue(this.teamsPage.isTeamTabContains());

		log.info("Ending of verifyEditTeamFunctionality method");
	}
	
	@Test(priority = 12, description = "Verify Edit Team Functionality", groups = "sanity")
	@Description("Test case #12, Verify Edit Team Functionality")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #12, Verify Edit Team Functionality")
	public void verifyEditTeamFunctionality() {
		log.info("Starting of verifyRemovePlayerFunctionality method");

		teamsPage.clickOnEditTeamButton();
		teamsPage.clickOnRemovePlayerIcon();

		clubLogoPage.hardWait(3);
		boolean buttons = teamsPage.isPlayerRemovedFromTeam();
		assertTrue(buttons);
		
		teamsPage.clickOnAddPlayerButton();
		String addPartnerTitle = this.teamsPage.getAddPartnerText();
		Assert.assertEquals(addPartnerTitle, expectedAssertionsProp.getProperty("add.partner.title"));

		Assert.assertTrue(this.teamsPage.isAddPartnerPageContains());
		
		teamsPage.clickOnPartnersRadioButton();
		Assert.assertTrue(this.teamsPage.isAddPartnerButtonEnabled());
		
		teamsPage.clickOnAddPartnerButton();
		Assert.assertTrue(this.teamsPage.isClubMembershipPopupContains());
		
		teamsPage.clickOnAddButton();
		Assert.assertTrue(this.teamsPage.isResultsOnClickOfEditTeamDisplayed());
		Assert.assertTrue(this.teamsPage.isSaveChangesButtonEnabled());
		
		teamsPage.clickOnSaveChangesButton();
		Assert.assertTrue(this.teamsPage.isEditTeamPopupDisplayed());
		
		teamsPage.clickOnConfirmButton();
		
		String teamCreatedSuccesfullyText = this.teamsPage.getTeamCreatedSuccessText();
		Assert.assertEquals(teamCreatedSuccesfullyText, expectedAssertionsProp.getProperty("team.created.success.message"));
		
		Assert.assertTrue(this.teamsPage.isGoBackButtonDisplayed());
		
		teamsPage.clickOnGoBackButton();
		Assert.assertTrue(this.teamsPage.isTeamTabContains());
		
		log.info("Ending of verifyRemovePlayerFunctionality method");
	}
	
	@Test(priority = 13, description = "Verify GoBack Functionality in Are you sure popup", groups = "sanity")
	@Description("Test case #13, Verify GoBack Functionality in Are you sure popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #13, Verify GoBack Functionality in Are you sure popup")
	public void verifyGoBackFunctionality() {
		log.info("Starting of verifyGoBackFunctionality method");

		teamsPage.clickOnEditTeamButton();

		clubLogoPage.hardWait(3);
		boolean buttons = teamsPage.isResultsOnClickOfEditTeamDisplayed();
		assertTrue(buttons);
		
		teamsPage.clickOnSaveChangesButton();
		
		Assert.assertTrue(this.teamsPage.isAreYouSurePopupContains());
		
		teamsPage.clickOnGoBackButton();
		Assert.assertTrue(this.teamsPage.isResultsOnClickOfEditTeamDisplayed());
		
		log.info("Ending of verifyGoBackFunctionality method");
	}
	
	@Test(priority = 14, description = "Verify Close Icon In Edit Team Popup", groups = "sanity")
	@Description("Test case #14, Verify Close Icon In Edit Team Popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #14, Verify Close Icon In Edit Team Popup")
	public void verifyCloseIconInEditTeamPopup() {
		log.info("Starting of verifyCloseIconInEditTeamPopup method");

		teamsPage.clickOnSaveChangesButton();
		clubLogoPage.hardWait(3);
		
		teamsPage.clickOnCloseIconInEditTeam();
		Assert.assertTrue(this.teamsPage.isResultsOnClickOfEditTeamDisplayed());

		log.info("Ending of verifyCloseIconInEditTeamPopup method");
	}
	
	@Test(priority = 15, description = "Verify Split Team Functionality", groups = "sanity")
	@Description("Test case #15, Verify Split Team Functionality")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #15, Verify Split Team Functionality")
	public void verifySplitTeamFunctionality() {
		log.info("Starting of verifySplitTeamFunctionality method");

		teamsPage.clickOnSaveChangesButton();
		teamsPage.clickOnConfirmButton();
		teamsPage.clickOnGoBackButton();

		clubLogoPage.hardWait(3);
		teamsPage.clickOnSplitTeamButton();
		
		String teamWithdrawnSuccesfullyText = this.teamsPage.getTeamWithdrawnSuccessText();
		Assert.assertEquals(teamWithdrawnSuccesfullyText, expectedAssertionsProp.getProperty("team.withdrawn.success.message"));
		
		Assert.assertTrue(this.teamsPage.isGoBackButtonDisplayed());
		
		teamsPage.clickOnGoBackButton();

		log.info("Ending of verifySplitTeamFunctionality method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.TEAMS_DRIVER);

				log.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			log.error(ex.getMessage());
		}
	}
}
