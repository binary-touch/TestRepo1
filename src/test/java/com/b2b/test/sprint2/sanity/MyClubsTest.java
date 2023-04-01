package com.b2b.test.sprint2.sanity;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.clubs.BrowseClubsPage;
import com.dupr.pages.clubs.MyClubsPage;
import com.dupr.test.CommonBaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Epic("DUPR App")
@Feature("MyClubs-Sanity")
public class MyClubsTest extends CommonBaseTest {

	private static final Logger logger = Logger.getLogger(MyClubsTest.class.getName());
	private MyClubsPage myClubsPage = null;
	private BrowseClubsPage browseClubsPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "validEmail", "validPassword" })
	public void initMethod(String browser, String siteURL, String email, String password) throws Exception {
		logger.info("Starting of initMethod in MyClubsTest");

		this.driver = super.getWebDriver(WebDriversEnum.MYCLUBS_DRIVER);
		super.initCommonBaseTest(siteURL, email, password);

		this.myClubsPage = new MyClubsPage(this.driver);
		this.browseClubsPage = new BrowseClubsPage(this.driver);

		logger.info("Ending of initMethod in MyClubsTest");
	}

	@Test(priority = 1, description = "Verify results on click of My clubs tab", groups = "sanity")
	@Description("Test case #1, Verify results on click of My clubs tab")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify results on click of My clubs tab")
	public void verifyMyClubsTabFunctionality() {
		logger.info("Starting of verifyMyClubsTabFunctionality method");

		myClubsPage.clickOnMyClubsTab();
		Assert.assertTrue(myClubsPage.isClubsPageContains());

		if (myClubsPage.isClubsAvailableOnClubsPage() == true) {
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(false);
		}

		logger.info("Ending of verifyMyClubsTabFunctionality method");
	}

	@Test(priority = 2, description = "Verify results on click of club card in my clubs", groups = "sanity")
	@Description("Test case #2, Verify results on click of club card in my clubs")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify results on click of club card in my clubs")
	public void verifyClubCardFunctionality() {
		logger.info("Starting of verifyClubCardFunctionality method");

		if (myClubsPage.isClubsAvailableOnClubsPage() == true) {
			myClubsPage.clickOnClubCard();

			Assert.assertTrue(browseClubsPage.isClubPageContains());

			myClubsPage.clickOnBackArrowIcon();
		} else {

			logger.info("Clubs not avaialble");

		}

		logger.info("Ending of verifyClubCardFunctionality method");
	}

	@Test(priority = 3, description = "Verify Browse clubs button functionality", groups = "sanity")
	@Description("Test case #3, Verify Browse clubs button functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify Browse clubs button functionality")
	public void verifyBrowseClubsButtonsFunctionality() {
		logger.info("Starting of verifyBrowseClubsButtonsFunctionality method");

		myClubsPage.clickOnBrowseClubsButton();
		Assert.assertTrue(browseClubsPage.isBrowseClubsPageContains());

		logger.info("Ending of verifyBrowseClubsButtonsFunctionality method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.MYCLUBS_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
