package com.dupr.test.clubs;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.clubs.BrowseClubsPage;
import com.dupr.test.CommonBaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("DUPR App")
@Feature("Browse clubs")
public class BrowseClubsTest extends CommonBaseTest {

	private static final Logger logger = Logger.getLogger(BrowseClubsTest.class.getName());
	private BrowseClubsPage browseClubsPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "validEmail", "validPassword" })
	public void initMethod(String browser, String siteURL, String email, String password) throws Exception {
		logger.info("Starting of initMethod in BrowseClubsTest");

		this.driver = super.getWebDriver(WebDriversEnum.BROWSE_CLUBS_DRIVER);
		super.initCommonBaseTest(siteURL, email, password);

		this.browseClubsPage = new BrowseClubsPage(this.driver);

		logger.info("Ending of initMethod in BrowseClubsTest");
	}

	@Test(priority = 1, description = "Verify results on click of Browse clubs tab", groups = "sanity")
	@Description("Test case #1, Verify results on click of Browse clubs tab")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify results on click of Browse clubs tab")
	public void verifyBrowseClubs() {
		logger.info("Starting of verifyBrowseClubs method");

		browseClubsPage.clickOnBrowseClubsTab();
		Assert.assertTrue(browseClubsPage.isBrowseClubsPageContains());

		logger.info("Ending of verifyBrowseClubs method");
	}

	@Test(priority = 2, description = "Verify Search by club name field functionality with club name which club is not available", groups = "sanity")
	@Description("Test case #2, Verify Search by club name field functionality with club name which club is not available")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify Search by club name field functionality with club name which club is not available")
	public void verifySearchByClubNameFilterWithNotAvailaleClub() {
		logger.info("Starting of verifySearchByClubNameFilterWithNotAvailaleClub method");

		browseClubsPage.setSearchByClubNameWithClubName(testDataProp.getProperty("player.invalid.name"));
        browseClubsPage.hardWait(3);
		String noMoreResults = browseClubsPage.getNoMoreResultsText();
		browseClubsPage.hardWait(3);
		Assert.assertEquals(noMoreResults, expectedAssertionsProp.getProperty("no.more.results"));

		logger.info("Ending of verifySearchByClubNameFilterWithNotAvailaleClub method");
	}

	@Test(priority = 3, description = "Verify Search by club name field functionality with club name", groups = "sanity")
	@Description("Test case #3, Verify Search by club name field functionality with club name")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify Search by club name field functionality with club name")
	public void verifySearchByClubNameFilter() {
		logger.info("Starting of verifySearchByClubNameFilter method");

		browseClubsPage.setSearchByClubName();
		browseClubsPage.hardWait(5);
		Assert.assertEquals(browseClubsPage.isClubNameDisplayed(), BrowseClubsPage.name);

		logger.info("Ending of verifySearchByClubNameFilter method");
	}

	@Test(priority = 4, description = "Verify results on click of one perticular club", groups = "sanity")
	@Description("Test case #4, Verify results on click of one perticular club")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify results on click of one perticular club")
	public void verifyClubTabFunctionality() {
		logger.info("Starting of verifyClubTabFunctionality method");

		browseClubsPage.clickOnClubTab();

		Assert.assertTrue(browseClubsPage.isClubPageContains());

		logger.info("Ending of verifyClubTabFunctionality method");
	}

	@Test(priority = 5, description = "Verify searched club name and results of clubs on click of back arrow icon on club page", groups = "sanity")
	@Description("Test case #5, Verify searched club name and results of clubs on click of back arrow icon on club page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify results on click of one perticular club")
	public void verifySearchedClubResultsFunctionality() {
		logger.info("Starting of verifySearchedClubResultsFunctionality method");

		browseClubsPage.clickOnBackArrowIcon();
		Assert.assertEquals(browseClubsPage.getSearchedClubName(), BrowseClubsPage.name);
		browseClubsPage.hardWait(3);
		Assert.assertEquals(browseClubsPage.getClubCountAfterClickOnBackArrowIconOnClubPage(),
				BrowseClubsPage.countAfterSearchingClub);

		logger.info("Ending of verifySearchedClubResultsFunctionality method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.BROWSE_CLUBS_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
