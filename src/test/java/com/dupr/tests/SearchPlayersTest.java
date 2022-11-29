package com.dupr.tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.SearchPlayersPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("DUPR App")
@Feature("Search Players")
public class SearchPlayersTest extends DUPRBaseAutomationTest {
	private WebDriver driver = null;
	private SearchPlayersPage searchPlayersPage = null;

	private static final Logger logger = LogManager.getLogger(SearchPlayersTest.class.getName());

	@BeforeClass
	@Parameters({ "browser", "siteURL", "language", "headless" })
	public void initMethod(String browser, String siteURL, String language, String headless) throws Exception {
		logger.info("Starting of initMethod in SearchPlayerTest");

		this.driver = super.getWebDriver(WebDriversEnum.SEARCH_PLAYER_DRIVER);
		goToSite(driver);
		this.searchPlayersPage = new SearchPlayersPage(this.driver);

		logger.info("Ending of initMethod in SearchPlayerTest");
	}

	@Test(priority = 1, description = "Verify Click on Search players  functionality", groups = "sanity")
	@Description("Test case #1, Verify Click on Search players  functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Click on Search players")
	public void verifyClickOnSearchPlayers() {
		logger.info("Starting of verifyClickOnSearchPlayers method");

		searchPlayersPage.clickOnSearchLink();

		String SearchPlayerText = searchPlayersPage.getSearchPlayerText();
		Assert.assertEquals(SearchPlayerText, expectedAssertionsProp.getProperty("search.players.text"));

		Assert.assertTrue(searchPlayersPage.isSearchPlayersPageContains());

		logger.info("Ending of verifyClickOnSearchPlayers method");
	}

	@Test(priority = 2, description = "Verify Search players By Name functionality", groups = "sanity")
	@Description("Test case #2, Verify Search players By Name functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Search players By Name")
	public void verifySearchPlayersByName() {
		logger.info("Starting of verifySearchPlayersByName method");

		searchPlayersPage.searchWithPlayerName(testDataProp.getProperty("player.name"));
		searchPlayersPage.hardWait(5);

		String PlayerName = searchPlayersPage.getPlayerName();
		
		Assert.assertEquals(PlayerName, expectedAssertionsProp.getProperty("player.name"));

		logger.info("Ending of verifySearchPlayersByName method");
	}

	@Test(priority = 3, description = "Verify Search players By Location functionality", groups = "sanity")
	@Description("Test case #3,Verify Search players By Location functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Search players By Location")
	public void verifySearchPlayersByLocation() {

		logger.info("Starting of verifySearchPlayersByLocation method");

		driver.navigate().refresh();
		searchPlayersPage.searchWithPlayerLocation(testDataProp.getProperty("player.location"));
		searchPlayersPage.clickOnLocationDropDown();
		searchPlayersPage.hardWait(1);

		Assert.assertTrue(searchPlayersPage.getPlayerLocation());

		logger.info("Ending of verifySearchPlayersByLocation method");

	}

	@Test(priority = 4, description = "Verify Search players By Rating functionality", groups = "sanity")
	@Description("Test case #4, Verify Search playersBy Rating functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Search players By Rating")
	public void verifySearchPlayersByRating() {
		logger.info("Starting of verifySearchPlayersByRating method");

		driver.navigate().refresh();
		searchPlayersPage.clickOnRatingDropDown();
		searchPlayersPage.clickAndDragSliderNode();
		searchPlayersPage.clickOnRadioButton();
		searchPlayersPage.clickOnApplyButton();
		searchPlayersPage.hardWait(1);

		Assert.assertTrue(searchPlayersPage.getPlayerRating());

		logger.info("Ending of verifySearchPlayersByRating method");
	}

	@Test(priority = 5, description = "Verify Search players By Gender functionality", groups = "sanity")
	@Description("Test case #5, Verify Search players By Gender functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Search players By Gender")
	public void verifySearchPlayersByGender() {
		logger.info("Starting of verifySearchPlayersByGender method");
		driver.navigate().refresh();
		searchPlayersPage.clickOnGenderDropDown();

		logger.info("Ending of verifySearchPlayersByGender method");
	}

	@Test(priority = 6, description = "Verify Search players By Age functionality", groups = "sanity")
	@Description("Test case #6,Verify Search players By Age functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify Search players by Age")
	public void verifySearchPlayersByAge() {

		logger.info("Starting of verifySearchPlayersByAge method");

		driver.navigate().refresh();
		searchPlayersPage.clickOnAgeDropDown();
		searchPlayersPage.hardWait(1);

		Assert.assertTrue(searchPlayersPage.getPlayerAge());

		logger.info("Ending of verifySearchPlayersByAge method");
	}

	@Test(priority = 7, description = "Verify Search players By Age functionality", groups = "sanity")
	@Description("Test case #7, Verify Search players By Age functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Search players by Invalid Name")
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
