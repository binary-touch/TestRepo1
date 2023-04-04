package com.b2b.test.sprint3.sanity;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.dupr.test.CommonBaseTest;
import com.b2b.common.WebDriversEnum;
import com.dupr.pages.clubs.ClubLogoPage;
import com.dupr.pages.events.AddBracketPage;
import com.dupr.pages.events.AddParticipantsInBracketsPage;
import com.dupr.pages.events.Create_Edit_Split_TeamPage;
import com.dupr.pages.events.EndEventPage;
import com.dupr.pages.events.SeedMatchesPage;
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
public class Create_Edit_Split_TeamTest extends CommonBaseTest {
	private static final Logger log = LogManager.getLogger(Create_Edit_Split_TeamTest.class);

	private ClubLogoPage clubLogoPage = null;
	private EndEventPage endEventpage = null;
	private UserDashboardPage userDashboardPage = null;

	private SeedMatchesPage seedMatchesPage = null;
	private AddBracketPage addBracketPage = null;
	private Create_Edit_Split_TeamPage teamsPage = null;
	private AddParticipantsInBracketsPage addParticipantsPage = null;
	private static String TeamEvents = null;
	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String directorEmail, String directorPassword)
			throws Exception {
		log.info("Starting of initMethod in SeedAndReseedTest");

		this.driver = super.getWebDriver(WebDriversEnum.SEED_MATCHES_DRIVER);
		super.initCommonBaseTest(siteURL, directorEmail, directorPassword);

		this.clubLogoPage = new ClubLogoPage(this.driver);
		this.endEventpage = new EndEventPage(this.driver);
		this.addBracketPage = new AddBracketPage(this.driver);
		this.teamsPage = new Create_Edit_Split_TeamPage(this.driver);
		this.addParticipantsPage = new AddParticipantsInBracketsPage(driver);
		this.userDashboardPage = new UserDashboardPage(this.driver);

		this.seedMatchesPage = new SeedMatchesPage(this.driver);
		

		log.info("Ending of initMethod in SeedAndReseedTest");
	}

	@Test(priority = 1, description = "Verify the results on Click of seed Matches", groups = "sanity")
	@Description("Test case #1, Verify the results on Click of seed Matches")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify the results on Click of seed Matches")
	public void verifyAddBracketWithRoundRobinEventType() {
		log.info("Starting of verifyAddBracketWithRoundRobinEventType method");

		clubLogoPage.hardWait(3);

		super.verifyAddEventFunctionality();
		this.verifyFreeBracketDoublesTypeWithRoundRobinEventType();

		clubLogoPage.hardWait(2);
		addEventPage.clickOnEventsTab();
		clubLogoPage.hardWait(2);
		addEventPage.clickOnRecentlyAddedEvent(TeamEvents);
		clubLogoPage.hardWait(3);
		
		seedMatchesPage.clickOnBracketCard();
		seedMatchesPage.hardWait(5);

		log.info("Ending of verifyAddBracketWithRoundRobinEventType method");
	}
	@Test(priority = 2, description = "Verify Details Displayed On UnMatchedPlayers Tab", groups = "sanity")
	@Description("Test case #2, Verify Details Displayed On UnMatchedPlayers Tab")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #2, Verify Details Displayed On UnMatchedPlayers Tab")
	public void verifyDetailsDisplayedOnUnMatchedPlayersTab() {
		log.info("Starting of verifyDetailsDisplayedOnUnMatchedPlayersTab method");     
	
		addparticipantsPage.addParticipantsIntoRoundRobinSinglesMatch();
		
		teamsPage.clickOnUnMatchedPlayersTab();
		
		Assert.assertTrue(this.teamsPage.isUmMatchedPlayersTabContains());

		Assert.assertTrue(this.teamsPage.isUnMatchedPlayersChkboxesDisplayed());
		Assert.assertTrue(this.teamsPage.isUnMatchedPlayerNamesDisplayed());
		Assert.assertTrue(this.teamsPage.isUnMatchedPlayersEmailsDisplayed());
		Assert.assertTrue(this.teamsPage.isUnMatchedPlayersPaymentStatusDisplayed());
		Assert.assertTrue(this.teamsPage.isUnMatchedPlayerDoublesRatingsDisplayed());
		Assert.assertTrue(this.teamsPage.isUnMatchedPlayersSinglesRatingsDisplayed());

		log.info("Ending of verifyDetailsDisplayedOnUnMatchedPlayersTab method");
	}

	@Test(priority = 3, description = "Verify the state of Create Team button before Selecting Players", groups = "sanity")
	@Description("Test case #3, Verify the state of Create Team button before Selecting Players")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify the state of Create Team button before Selecting Players")
	public void verifyStateOfCreateTeamBeforeSelectingPlayers() {
		log.info("Starting of verifyStateOfCreateTeamBeforeSelectingPlayers method");

		Assert.assertTrue(this.teamsPage.isCreateTeamDisabled());

		log.info("Ending of verifyStateOfCreateTeamBeforeSelectingPlayers method");
	}

	@Test(priority = 4, description = "Verify the state of Create Team button If User Selects Only Player/More than 2 Players", groups = "sanity")
	@Description("Test case #4, Verify the state of Create Team button If User Selects Only Player/More than 2 Players")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify the state of Create Team button If User Selects Only Player/More than 2 Players")
	public void verifyCreateTeamStateIfOneOrThreePlayersSelected() {
		log.info("Starting of verifyCreateTeamStateIfOneOrThreePlayersSelected method");

		teamsPage.selectMultiplePlayers();
		clubLogoPage.hardWait(3);

		Assert.assertTrue(this.teamsPage.isCreateTeamDisabled());
		driver.navigate().refresh();
		log.info("Ending of verifyCreateTeamStateIfOneOrThreePlayersSelected method");
	}

	@Test(priority = 5, description = "Verify Players Selection From List in UnMatched Players tab", groups = "sanity")
	@Description("Test case #5, Verify Players Selection From List in UnMatched Players tab")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #5, Verify Players Selection From List in UnMatched Players tab")
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

	@Test(priority = 6, description = "Verify the results on click of Create Team button", groups = "sanity")
	@Description("Test case #6, Verify the results on click of Create Team button")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #6, Verify the results on click of Create Team button")
	public void verifyResultsOnClickOfCreateTeam() {
		log.info("Starting of verifyResultsOnClickOfCreateTeam method");

		teamsPage.clickOnCreateTeamButton();
		try {
			if (teamsPage.isSameGenderPopupDisplayed() == true) {
				teamsPage.clickOnCancelButtonOnMixedBracketPopUp();
				teamsPage.hardWait(2);
				teamsPage.clickOnEditBracketButton();
				teamsPage.hardWait(2);
				addBracketPage.clickOnPlayGroupDropdown();
				addBracketPage.hardWait(3);
				addBracketPage.selectOpenPlayerGroup();
				teamsPage.hardWait(2);
				teamsPage.clickOnSaveChangesButton();
				// teamsPage.addAnotherPlayer();

				clubLogoPage.hardWait(3);
				teamsPage.clickOnUnMatchedPlayersTab();
				teamsPage.clickOnValidPlayerCheckbox();
				clubLogoPage.hardWait(3);
				teamsPage.clickOnCreateTeamButton();
			}
		} catch (Exception e) {
			log.info("****Create Team Popup displayed****");
		}

		clubLogoPage.hardWait(3);
		boolean createTeam = teamsPage.isCreateTeamPopupContains();
		assertTrue(createTeam);

		log.info("Ending of verifyResultsOnClickOfCreateTeam method");
	}

	@Test(priority = 7, description = "Verify Create Team Functionality", groups = "sanity")
	@Description("Test case #7, Verify Create Team Functionality")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #7, Verify Create Team Functionality")
	public void verifyCreateTeamFunctionality() {
		log.info("Starting of verifyCreateTeamFunctionality method");

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

	@Test(priority = 8, description = "Verify the recently created team in Teams tab", groups = "sanity")
	@Description("Test case #8, Verify the recently created team in Teams tab")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #8, Verify the recently created team in Teams tab")
	public void verifyRecentlyCreatedTeam() {
		log.info("Starting of verifyRecentlyCreatedTeam method");

		teamsPage.clickOnTeamsTab();

		clubLogoPage.hardWait(3);

		Assert.assertTrue(this.teamsPage.isTeamTabContains());

		log.info("Ending of verifyRecentlyCreatedTeam method");
	}

	@Test(priority = 9, description = "Verify Results On Click Of Edit Team Option", groups = "sanity")
	@Description("Test case #9, Verify Results On Click Of Edit Team Option")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #9, Verify Results On Click Of Edit Team Option")
	public void verifyResultsOnClickOfEditTeamOption() {
		log.info("Starting of verifyResultsOnClickOfEditTeamOption method");

		teamsPage.clickOnEditTeamButton();

		clubLogoPage.hardWait(3);
		boolean buttons = teamsPage.isResultsOnClickOfEditTeamDisplayed();
		assertTrue(buttons);

		log.info("Ending of verifyResultsOnClickOfEditTeamOption method");
	}

	
	@Test(priority = 10, description = "Verify Edit Team Functionality", groups = "sanity")
	@Description("Test case #10, Verify Edit Team Functionality")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #10, Verify Edit Team Functionality")
	public void verifyEditTeamFunctionality() {
		log.info("Starting of verifyRemovePlayerFunctionality method");

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
		Assert.assertEquals(teamCreatedSuccesfullyText,
				expectedAssertionsProp.getProperty("team.created.success.message"));

		Assert.assertTrue(this.teamsPage.isGoBackButtonDisplayed());

		teamsPage.clickOnGoBackButton();
		Assert.assertTrue(this.teamsPage.isTeamTabContains());

		log.info("Ending of verifyRemovePlayerFunctionality method");
	}


	public void verifyFreeBracketDoublesTypeWithRoundRobinEventType() {
		log.info("Starting of verifyFreeBracketDoublesTypeWithRoundRobinEventType method");

		TeamEvents = addEventPage.setEventName(testDataProp.getProperty("event.name"));
		addEventPage.setLocation(testDataProp.getProperty("state.address"));

		addEventPage.uploadEventLogo(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("edit.club.logo.path"));
		addEventPage.setMemberPrice(testDataProp.getProperty("zero.value"));
		addEventPage.setNonMemberPrice(testDataProp.getProperty("zero.value"));
		addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.event"));
		addEventPage.clickonTextFormattingButtons();
		addEventPage.clickOnNextStepButton();

		Assert.assertTrue(addEventPage.isEventPoliciesPageContains());

		this.verifyEventPoliciesPageByEnteringValidDetails();

		addBracketPage.hardWait(3);
		addBracketPage.clickOnMatchTypeDropdown();
		addBracketPage.hardWait(3);
		addBracketPage.selectDoublesMatchType();

		addBracketPage.hardWait(3);
		addBracketPage.clickOnPlayGroupDropdown();
		addBracketPage.hardWait(3);
		addBracketPage.selectOpenPlayerGroup();

		addBracketPage.setMinimumAgeRange(testDataProp.getProperty("min.age.range"));
		addBracketPage.setMaximumAgeRange(testDataProp.getProperty("max.age.range"));
		addBracketPage.setMinimumRatingRange(testDataProp.getProperty("min.rating.range"));
		addBracketPage.setMaximumRatingRange(testDataProp.getProperty("max.rating.range"));

		Assert.assertTrue(addBracketPage.isAutoGenerateButtonEnabled());
		addBracketPage.clickOnAutoGenerateButton();

		addBracketPage.hardWait(3);
		addBracketPage.clickOnEventTypeDropdown();
		Assert.assertTrue(addBracketPage.isEventTypeListContains());
		addBracketPage.hardWait(3);
		addBracketPage.selectRoundRobinEvent();
		Assert.assertTrue(addBracketPage.isSelectedEventTypeDisplayed());
		
		addBracketPage.setRegistrationStartDate();

		addBracketPage.hardWait(2);
		addBracketPage.setRegistrationEndDate();

		addBracketPage.hardWait(2);
		addBracketPage.setCompetitionStartDate();

		addBracketPage.hardWait(2);
		addBracketPage.setCompetitionEndDate();
		
		addBracketPage.hardWait(2);
		addBracketPage.clickOnTimeZoneDropdown();
		Assert.assertTrue(addBracketPage.isTimeZoneListContains());
		addBracketPage.clickOnNewDelhiTimeZone();

		addBracketPage.setBracketClubMemberPrice(testDataProp.getProperty("zero.value"));
		addBracketPage.setBracketNonClubMemberPrice(testDataProp.getProperty("zero.value"));

		addBracketPage.setNumberOfTeams(testDataProp.getProperty("team.value"));
		addBracketPage.setWaitlist(testDataProp.getProperty("min.rating.range"));
		addEventPage.clickOnNextStepButton();
		addBracketPage.hardWait(2);
		addBracketPage.clickOnNoContinueToSummary();
		addBracketPage.clickOnPublishEventButton();
		addBracketPage.hardWait(2);
		addBracketPage.clickOnEventSuccessClosePopupButton();
		addBracketPage.hardWait(2);

		log.info("Ending of verifyFreeBracketDoublesTypeWithRoundRobinEventType method");
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
