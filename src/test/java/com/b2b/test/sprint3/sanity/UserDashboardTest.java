package com.b2b.test.sprint3.sanity;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.addamatch.AddAMatchPage;
import com.dupr.pages.clubs.BrowseClubsPage;
import com.dupr.pages.clubs.MyClubsPage;
import com.dupr.pages.events.BrowseEventsPage;
import com.dupr.pages.home.UserDashboardPage;
import com.dupr.pages.home.ValidateRecentlyAddedMatchPage;
import com.dupr.pages.players.BrowsePlayersPage;
import com.dupr.test.DUPRBaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic(value = "DUPR App")
@Feature(value = "UserDashboard Sanity")
public class UserDashboardTest extends DUPRBaseAutomationTest {

	private static final Logger logger = Logger.getLogger(UserDashboardTest.class.getName());
	private UserDashboardPage userDashboardPage = null;
	private AddAMatchPage addAMatchPage = null;
	private BrowsePlayersPage browsePlayersPage = null;
	private BrowseEventsPage browseEventsPage = null;
	private ValidateRecentlyAddedMatchPage validateRecentlyAddedMatchPage = null;
	private MyClubsPage myClubsPage = null;
	private BrowseClubsPage browseClubsPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String email, String password) throws Exception {
		logger.info("Starting of initMethod in UserDashboardTest");

		this.driver = super.getWebDriver(WebDriversEnum.USER_DASHBOARD_DRIVER);
		this.siteLogin(siteURL, email, password, this.driver);
		this.userDashboardPage = new UserDashboardPage(this.driver);
		this.browsePlayersPage = new BrowsePlayersPage(this.driver);
		this.addAMatchPage = new AddAMatchPage(this.driver);
		this.browseEventsPage = new BrowseEventsPage(this.driver);
		this.myClubsPage = new MyClubsPage(this.driver);
		this.browseClubsPage = new BrowseClubsPage(this.driver);

		this.validateRecentlyAddedMatchPage = new ValidateRecentlyAddedMatchPage(this.driver);

		logger.info("Ending of initMethod in UserDashboardTest");
	}

	@Test(priority = 1, description = "Verify the details displayed on UserDashboard page", groups = "sanity")
	@Description("Test case #1, Verify the details displayed on User Dashboard page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify the details displayed on User Dashboard page")
	public void verifyDetailsOnDashboard() {
		logger.info("Starting of verifyDetailsOnDashboard method");

		Assert.assertTrue(userDashboardPage.isDashboardPageContains());
		Assert.assertTrue(userDashboardPage.isDashboardUserNameSecContains());
		Assert.assertTrue(userDashboardPage.isDashboardDoublesSinglesSecContains());
		Assert.assertTrue(userDashboardPage.isDashboardResultSecContains());
		userDashboardPage.hardWait(3);
		Assert.assertTrue(userDashboardPage.isDashboardPerformanceSecContains());
		Assert.assertTrue(userDashboardPage.isDashboardMatchesSecContains());
		Assert.assertTrue(userDashboardPage.isDashboardClubsSecContains());
		Assert.assertTrue(userDashboardPage.isDashboardEventsSecContains());
		Assert.assertTrue(userDashboardPage.isDashboardBracketsSecContains());
		logger.info("Ending of verifyDetailsOnDashboard method");
	}

	@Test(priority = 2, description = "Verify the details displayed on Homepage", groups = "sanity")
	@Description("Test case #2, Verify the details displayed on Home page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify the details displayed on Home page")
	public void verifyDetailsOnHomePage() {
		logger.info("Starting of verifyDetailsOnHomePage method");

		userDashboardPage.clickOnDUPRLogoLink();
		Assert.assertTrue(userDashboardPage.isHomePageMenuSecContains());
		Assert.assertTrue(userDashboardPage.isHomePageTextContains());
		Assert.assertTrue(userDashboardPage.isHomePagesponsorlogosContains());
		Assert.assertTrue(userDashboardPage.isHomePageFooterSecContains());

		logger.info("Ending of verifyDetailsOnHomePage method");
	}

	@Test(priority = 3, description = "Verify the results on click of Dashboard Menu", groups = "sanity")
	@Description("Test case #3, Verify the results on click of Dashboard Menue")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify the results on click of Dashboard Menu")
	public void verifyDashboardMenuFunctionality() {
		logger.info("Starting of verifyDashboardMenuFunctionality method");

		userDashboardPage.clickOnDashboardMenu();
		Assert.assertTrue(userDashboardPage.isDashboardPageContains());

		logger.info("Ending of verifyDashboardMenuFunctionality method");
	}

	@Test(priority = 4, description = "Verify the results on click of User Instruction icon", groups = "sanity")
	@Description("Test case #4, Verify the results on click of User instruction icon")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify the results on click of User instruction icon")
	public void verifyUserInstructionFunctionality() {
		logger.info("Starting of verifyUserInstructionFunctionality method");

		userDashboardPage.clickOnUserInstructionIcon();
		userDashboardPage.hardWait(3);
		Assert.assertTrue(userDashboardPage.isUserInstructionPopUpContains());
		Assert.assertEquals(userDashboardPage.getInstructionPopUpTitle(),
				expectedAssertionsProp.getProperty("user.instruction.title"));
		Assert.assertEquals(userDashboardPage.getUserInstructionDecription(),
				expectedAssertionsProp.getProperty("user.instruction.description"));

		logger.info("Ending of verifyUserInstructionFunctionality method");
	}

	@Test(priority = 5, description = "Verify the results on click on close icon on Provisional Rating popup", groups = "sanity")
	@Description("Test case #5, Verify the results on click on close icon on Provisional Rating popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify the results on click on close icon on Provisional Rating popup")
	public void verifyCloseIconFunctionalityOnProvisionalPopUp() {
		logger.info("Starting of verifyCloseIconFunctionalityOnProvisionalPopUp method");

		userDashboardPage.clickOnCloseIcon();
		userDashboardPage.hardWait(3);
		Assert.assertFalse(userDashboardPage.isUserInstructionPopUpContains());

		logger.info("Ending of verifyCloseIconFunctionalityOnProvisionalPopUp method");
	}

	@Test(priority = 6, description = "Verify the results on click on Ok buttonon Provisional Rating popup", groups = "sanity")
	@Description("Test case #6, Verify the results on click on Ok button on Provisional Rating popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify the results on click on Ok button on Provisional Rating popup")
	public void verifyOkFunctionalityOnProvisionalPopUp() {
		logger.info("Starting of verifyOkFunctionalityOnProvisionalPopUp method");

		userDashboardPage.clickOnUserInstructionIcon();
		userDashboardPage.hardWait(2);
		userDashboardPage.clickOnOkButton();

		userDashboardPage.hardWait(3);
		Assert.assertFalse(userDashboardPage.isUserInstructionPopUpContains());

		logger.info("Ending of verifyOkFunctionalityOnProvisionalPopUp method");
	}

	@Test(priority = 7, description = "Verify the results on click of info icon In Results Overview section", groups = "sanity")
	@Description("Test case #7, Verify the results on click of info icon In Results Overview section")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Verify the results on click of info icon In Results Overview section")
	public void verifyResultsInstructionFunctionality() {
		logger.info("Starting of verifyResultsInstructionFunctionality method");

		userDashboardPage.clickOnResultsInstructionIcon();

		Assert.assertTrue(userDashboardPage.isResultsInstructionPopUpContains());
		Assert.assertEquals(userDashboardPage.getInstructionPopUpTitle(),
				expectedAssertionsProp.getProperty("results.instruction.title"));
		Assert.assertEquals(userDashboardPage.getResultsInstructionDecription(),
				expectedAssertionsProp.getProperty("results.instruction.description"));

		logger.info("Ending of verifyResultsInstructionFunctionality method");
	}

	@Test(priority = 8, description = "Verify the results on click on close icon on results overview popup", groups = "sanity")
	@Description("Test case #8, Verify the results on click on close icon on results overview popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Verify the results on click on close icon on results overview popup")
	public void verifyCloseFunctionalityOnResultsPopUp() {
		logger.info("Starting of verifyCloseFunctionalityOnResultsPopUp method");

		userDashboardPage.clickOnCloseIcon();
		userDashboardPage.hardWait(3);
		Assert.assertFalse(userDashboardPage.isResultsInstructionPopUpContains());

		logger.info("Ending of verifyCloseFunctionalityOnResultsPopUp method");
	}

	@Test(priority = 9, description = "Verify the results on click on Ok buttonon results overview popup", groups = "sanity")
	@Description("Test case #9, Verify the results on click on Ok button on results overview popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9, Verify the results on click on Ok button on results overview  popup")
	public void verifyOkFunctionalityOnResultsPopUp() {
		logger.info("Starting of verifyOkFunctionalityOnResultsPopUp method");

		userDashboardPage.clickOnResultsInstructionIcon();
		userDashboardPage.hardWait(2);
		userDashboardPage.clickOnOkButton();

		userDashboardPage.hardWait(3);
		Assert.assertFalse(userDashboardPage.isResultsInstructionPopUpContains());

		logger.info("Ending of verifyOkFunctionalityOnResultsPopUp method");
	}

	@Test(priority = 10, description = "Verify the results on click of Performance instruction icon", groups = "sanity")
	@Description("Test case #10, Verify the results on click of Performance instruction icon")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #10, Verify the results on click of Performance instruction icon")
	public void verifyPerformanceInstructionFunctionality() {
		logger.info("Starting of verifyPerformanceInstructionFunctionality method");

		userDashboardPage.clickOnPerformanceInstructionIcon();

		Assert.assertTrue(userDashboardPage.isPerformanceInstructionPopUpContains());
		Assert.assertEquals(userDashboardPage.getInstructionPopUpTitle(),
				expectedAssertionsProp.getProperty("performance.instruction.title"));

		Assert.assertEquals(userDashboardPage.getPerformanceInstructionDecription(),
				expectedAssertionsProp.getProperty("performance.instruction.text"));

		logger.info("Ending of verifyPerformanceInstructionFunctionality method");
	}

	@Test(priority = 11, description = "Verify the results on click on close iconon Provisional Rating popup", groups = "sanity")
	@Description("Test case #11, Verify the results on click on close icon on Provisional Rating popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #11, Verify the results on click on close icon on Provisional Rating popup")
	public void verifyCloseFunctionalityOnperformancePopUp() {
		logger.info("Starting of verifyCloseFunctionalityOnperformancePopUp method");

		userDashboardPage.clickOnCloseIcon();
		userDashboardPage.hardWait(3);
		Assert.assertFalse(userDashboardPage.isPerformanceInstructionPopUpContains());

		logger.info("Ending of verifyCloseFunctionalityOnperformancePopUp method");
	}

	@Test(priority = 12, description = "Verify the results on click on Ok buttonon Performance Analysis popup", groups = "sanity")
	@Description("Test case #12, Verify the results on click on Ok button on Performance Analysis popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #12, Verify the results on click on Ok button on Performance Analysis popup")
	public void verifyOkFunctionalityOnPerformancePopUp() {
		logger.info("Starting of verifyOkFunctionalityOnPerformancePopUp method");

		userDashboardPage.clickOnPerformanceInstructionIcon();
		userDashboardPage.hardWait(2);
		userDashboardPage.clickOnOkButton();
		Assert.assertFalse(userDashboardPage.isPerformanceInstructionPopUpContains());

		logger.info("Ending of verifyOkFunctionalityOnPerformancePopUp method");
	}

	@Test(priority = 13, description = "Verify results after clicking on Match History tab", groups = "sanity")
	@Description("Test case #13, Verify results after clicking on Match History tab")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #13, Verify results after clicking on Match History tab")
	public void verifyMatchHistory() {
		logger.info("Starting of verifyMatchHistory method");

		validateRecentlyAddedMatchPage.hardWait(5);
		validateRecentlyAddedMatchPage.clickOnMatchHistoryTab();
		validateRecentlyAddedMatchPage.hardWait(5);

		Assert.assertTrue(validateRecentlyAddedMatchPage.isMatchHistoryOptionsPageContains());

		logger.info("Ending of verifyMatchHistory method");
	}

	@Test(priority = 14, description = "Verify results on click of Back Button in Match History Page", groups = "sanity")
	@Description("Test case #14, Verify results on click of Back Button in Match History Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #14, Verify results on click of Back Button in Match History Page")
	public void verifyBackButtonFunctionality() {
		logger.info("Starting of verifyBackButtonFunctionality method");

		userDashboardPage.clickOnBackButtonOnMatch();
		Assert.assertTrue(userDashboardPage.isDashboardPageContains());

		logger.info("Ending of verifyBackButtonFunctionality method");
	}

	@Test(priority = 15, description = "Verify results on click of My clubs tab", groups = "sanity")
	@Description("Test case #15, Verify results on click of My clubs tab")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #15, Verify results on click of My clubs tab")
	public void verifyMyClubsTabFunctionality() {
		logger.info("Starting of verifyMyClubsTabFunctionality method");

		myClubsPage.clickOnMyClubsTab();
		Assert.assertTrue(myClubsPage.isClubsPageContains());
		userDashboardPage.clickOnBackButtonOnClubs();
		userDashboardPage.hardWait(3);
		Assert.assertTrue(userDashboardPage.isDashboardPageContains());

		logger.info("Ending of verifyMyClubsTabFunctionality method");
	}

	@Test(priority = 16, description = "Verify my events functionality", groups = "sanity")
	@Description("Test case #16, Verify my events functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #16, Verify my events functionality")

	public void verifyMyEventsFunctionality() {
		logger.info("Starting of verifyMyEventsFunctionality method");

		browseEventsPage.clickOnMyEventButton();
		browseEventsPage.hardWait(3);
		Assert.assertEquals(browseEventsPage.getEventsText(), expectedAssertionsProp.getProperty("txt.event"));

		Assert.assertTrue(browseEventsPage.isMyEventsPageContains());
		userDashboardPage.clickOnBackButtonOnEvents();
		Assert.assertTrue(userDashboardPage.isDashboardPageContains());

		logger.info("Ending of verifyMyEventsFunctionality method");
	}

	@Test(priority = 17, description = "Verify my Brackets functionality", groups = "sanity")
	@Description("Test case #17, Verify my Brackets functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #17, Verify my Brackets functionality")

	public void verifyMyBracketsFunctionality() {
		logger.info("Starting of verifyMyEventsFunctionality method");

		userDashboardPage.clickOnMyBracketsButton();
		browseEventsPage.hardWait(3);
		Assert.assertEquals(userDashboardPage.getBracketsTitle(), expectedAssertionsProp.getProperty("brackets.text"));

		Assert.assertTrue(userDashboardPage.isMyBracketsPageContains());
		userDashboardPage.clickOnBackButtonOnBrackets();
		userDashboardPage.hardWait(3);
		Assert.assertTrue(userDashboardPage.isDashboardPageContains());

		logger.info("Ending of verifyMyEventsFunctionality method");
	}

	@Test(priority = 18, description = "Verify Add a Match functionality", groups = "sanity")
	@Description("Test case #18,Verify Add a Match functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #18,Verify Add a Match functionality")
	public void verifyAddAMatchFuntionality() {
		logger.info("Starting of verifyAddAMatchFuntionality method");

		addAMatchPage.clickOnAddAMatchTab();
		Assert.assertTrue(addAMatchPage.isAddAMatchPageContains());

		logger.info("Ending of verifyAddAMatchFuntionality method");
	}

	@Test(priority = 19, description = "Verify Browse player functionaity", groups = "sanity")
	@Description("Test case #19,Verify Browse player functionaity")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #19, Verify Browse player functionaity")
	public void verifyClickOnPlayersTab() {
		logger.info("Starting of verifyClickOnPlayersTab method");

		addAMatchPage.clickOnPlayersTab();
		browseEventsPage.hardWait(3);
		Assert.assertTrue(browsePlayersPage.isBrowsePlayersPageContains());

		logger.info("Ending of verifyClickOnPlayersTab method");
	}

	@Test(priority = 20, description = "Verify results on click of Browse clubs tab", groups = "sanity")
	@Description("Test case #20, Verify results on click of Browse clubs tab")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #20, Verify results on click of Browse clubs tab")
	public void verifyBrowseClubs() {
		logger.info("Starting of verifyBrowseClubs method");
		browseClubsPage.clickOnBrowseClubsTab();
		Assert.assertTrue(browseClubsPage.isBrowseClubsPageContains());
		logger.info("Ending of verifyBrowseClubs method");
	}

	@Test(priority = 21, description = "Verify events menu functionality", groups = "sanity")
	@Description("Test case #21, Verify events menu functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #21, Verify events menu functionality")

	public void verifyEventsMenuFunctionality() {
		logger.info("Starting of verifyEventsMenuFunctionality method");

		userDashboardPage.clickOnEventsMenu();
		browseEventsPage.hardWait(3);
		logger.info("Ending of verifyEventsMenuFunctionality method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.USER_DASHBOARD_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}
}
