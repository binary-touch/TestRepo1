package com.dupr.test.players;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.players.SearchPlayersPage;
import com.dupr.test.DUPRBaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("DUPR App")
@Feature("Search Players")
public class SearchPlayersTest extends DUPRBaseAutomationTest {

	private static final Logger logger = LogManager.getLogger(SearchPlayersTest.class.getName());

	private SearchPlayersPage searchPlayersPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "language", "headless" })
	public void initMethod(String browser, String siteURL, String language, String headless) throws Exception {
		logger.info("Starting of initMethod in SearchPlayerTest");

		this.driver = super.getWebDriver(WebDriversEnum.SEARCH_PLAYER_DRIVER);
		goToSite(driver);
		this.searchPlayersPage = new SearchPlayersPage(this.driver);

		logger.info("Ending of initMethod in SearchPlayerTest");
	}

	@Test(priority = 1, description = "Verify Search players  functionality", groups = "sanity")
	@Description("Test case #1, Verify Search players  functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Search players  functionality")
	public void verifySearchPlayers() {
		logger.info("Starting of verifySearchPlayers method");

		searchPlayersPage.clickOnSearchLink();

		searchPlayersPage.hardWait(2);
		String SearchPlayerText = searchPlayersPage.getSearchPlayerText();
		Assert.assertEquals(SearchPlayerText, expectedAssertionsProp.getProperty("search.players.text"));

		Assert.assertTrue(searchPlayersPage.isSearchPlayersPageContains());

		logger.info("Ending of verifySearchPlayers method");
	}

	@Test(priority = 2, description = "Verify Search players functionality By Name", groups = "sanity")
	@Description("Test case #2, Verify Search players functionality By Name")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify Search players functionality By Name")
	public void verifySearchPlayersByName() {
		logger.info("Starting of verifySearchPlayersByName method");

		searchPlayersPage.searchWithPlayerName(testDataProp.getProperty("player.name"));
		searchPlayersPage.hardWait(5);

		String PlayerName = searchPlayersPage.getPlayerName(testDataProp.getProperty("player.name"));
		Assert.assertEquals(PlayerName, expectedAssertionsProp.getProperty("player.name"));

		logger.info("Ending of verifySearchPlayersByName method");
	}

	@Test(priority = 3, description = "Verify Search players functionality By Location", groups = "sanity")
	@Description("Test case #3, Verify Search players functionality By Location")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify Search players functionality By Location")
	public void verifySearchPlayersByLocation() {
		logger.info("Starting of verifySearchPlayersByLocation method");

		driver.navigate().refresh();

		searchPlayersPage.searchWithPlayerLocation(testDataProp.getProperty("player.location"));
		searchPlayersPage.clickOnLocationDropDown();
		searchPlayersPage.hardWait(1);

		Assert.assertTrue(searchPlayersPage.getPlayerLocation());

		logger.info("Ending of verifySearchPlayersByLocation method");
	}

	@Test(priority = 4, description = "Verify Search players functionality By Singles Rating", groups = "sanity")
	@Description("Test case #4, Verify Search players functionality By Rating ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify Search players functionality By Rating")
	public void verifySearchPlayersBySinglesRating() {
		logger.info("Starting of verifySearchPlayersBySinglesRating method");

		driver.navigate().refresh();

		searchPlayersPage.clickOnRatingDropDown();
		searchPlayersPage.clickAndDragSliderNode();
		searchPlayersPage.clickOnSinglesRadioButton();
		searchPlayersPage.clickOnApplyButton();
		searchPlayersPage.hardWait(1);

		Assert.assertTrue(searchPlayersPage.getPlayerSinglesRating());

		logger.info("Ending of verifySearchPlayersBySinglesRating method");
	}

	@Test(priority = 5, description = "Verify Search players By Doubles Rating", groups = "sanity")
	@Description("Test case #5, Verify Search players By Doubles Rating")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify Search players By Doubles Rating")
	public void verifySearchPlayersByDoublesRating() {
		logger.info("Starting of verifySearchPlayersByDoublesRating method");

		driver.navigate().refresh();
		searchPlayersPage.clickOnRatingDropDown();
		searchPlayersPage.clickAndDragSliderNode();
		searchPlayersPage.clickOnDoublesRadioButton();
		searchPlayersPage.clickOnApplyButton();
		searchPlayersPage.hardWait(3);

		Assert.assertTrue(searchPlayersPage.getPlayerDoublesRating());

		logger.info("Ending of verifySearchPlayersByDoublesRating method");
	}

	@Test(priority = 6, description = "Verify Reset button functionality in rating range", groups = "sanity")
	@Description("Test case #6, Verify Reset button functionality in rating range")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify Reset button functionality in rating range")
	public void verifyResetButtonInRating() {
		logger.info("Starting of verifyResetButtonInRating method");

		searchPlayersPage.clickOnRatingDropDown();
		searchPlayersPage.clickOnResetButton();

		logger.info("Ending of verifyResetButtonInRating method");
	}

	@Test(priority = 7, description = "Verify Search players functionality By Gender", groups = "sanity")
	@Description("Test case #7, Verify Search players functionality By Gender")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Verify Search players functionality By Gender")
	public void verifySearchPlayersByGender() {
		logger.info("Starting of verifySearchPlayersByGender method");

		searchPlayersPage.clickOnGenderDropDown();
		searchPlayersPage.clickOnMenInGenderDropDown();

		logger.info("Ending of verifySearchPlayersByGender method");
	}

	@Test(priority = 8, description = "Verify View All option functionality in Gender dropdown", groups = "sanity")
	@Description("Test case #8, Verify View All option functionality in Gender dropdown")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Verify View All option functionality in Gender dropdown")
	public void verifyViewAllInGenderDropdown() {
		logger.info("Starting of verifyViewAllInGenderDropdown method");

		driver.navigate().refresh();

		searchPlayersPage.clickOnGenderDropDown();
		searchPlayersPage.clickOnViewAllOption();

		logger.info("Ending of verifyViewAllInGenderDropdown method");
	}

	@Test(priority = 9, description = "Verify Search players functionality By Age", groups = "sanity")
	@Description("Test case #9, Verify Search players functionality By Age")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9, Verify Search players functionality By Age")
	public void verifySearchPlayersByAge() {
		logger.info("Starting of verifySearchPlayersByAge method");

		driver.navigate().refresh();
		searchPlayersPage.clickOnAgeDropDown();
		searchPlayersPage.clickOnOptionAgeRangeInAgeDropDown();
		searchPlayersPage.hardWait(1);

	

		logger.info("Ending of verifySearchPlayersByAge method");
	}

	@Test(priority = 10, description = "Verify Search players functionality By inavlid name", groups = "sanity")
	@Description("Test case #10, Verify Search players functionality By inavlid name")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #10, Verify Search players functionality By inavlid name")
	public void verifySearchPlayersByInvalidName() {
		logger.info("Starting of verifySearchPlayersByInvalidName method");

		driver.navigate().refresh();

		searchPlayersPage.searchWithPlayerName(testDataProp.getProperty("player.invalid.name"));
		searchPlayersPage.hardWait(2);

		String NoResultFoundMessage = searchPlayersPage.getNoResultFoundMessage();
		Assert.assertEquals(NoResultFoundMessage, expectedAssertionsProp.getProperty("message"));

		logger.info("Ending of verifySearchPlayersByInvalidName method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.SEARCH_PLAYER_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
