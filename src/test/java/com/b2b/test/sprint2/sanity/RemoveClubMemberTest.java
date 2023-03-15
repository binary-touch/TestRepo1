package com.b2b.test.sprint2.sanity;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.clubs.ClubLogoPage;
import com.dupr.pages.clubs.RemoveClubMemberPage;
import com.dupr.test.DUPRBaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("DUPR App")
@Feature("Remove ClubMember Sanity")
public class RemoveClubMemberTest extends DUPRBaseAutomationTest {
	private static final Logger logger = Logger.getLogger(RemoveClubMemberTest.class.getName());
	private ClubLogoPage clubLogoPage = null;
	private RemoveClubMemberPage removeMemberPage = null;
	private static String clubMemberName = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String directorEmail, String directorPassword)
			throws Exception {
		logger.info("Starting of initMethod in RemoveClubMemberTest");

		this.driver = super.getWebDriver(WebDriversEnum.REMOVE_CLUB_MEMBER_DRIVER);
		this.siteLogin(siteURL, directorEmail, directorPassword, this.driver);
		this.clubLogoPage = new ClubLogoPage(this.driver);
		this.removeMemberPage = new RemoveClubMemberPage(this.driver);

		logger.info("Ending of initMethod in RemoveClubMemberTest");
	}

	@Test(priority = 1, description = "Verify the details displayed in club page-Members Tab", groups = "sanity")
	@Description("Test case #1, Verify the details displayed in club page-Members Tab")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify the details displayed in club page-Members Tab")
	public void verifyDetailsDisplayedInClubPageMembersTab() {
		logger.info("Starting of verifyDetailsDisplayedInClubPageMembersTab method");

		clubLogoPage.clickOnMyClubsTab();
		removeMemberPage.clickOnClubNameLink();
		clubLogoPage.hardWait(3);
		removeMemberPage.clickOnMembersTab();

		Assert.assertTrue(removeMemberPage.isClubMemberContains());
		Assert.assertEquals(removeMemberPage.getDoublesTxt(), expectedAssertionsProp.getProperty("member.doubles"));
		Assert.assertEquals(removeMemberPage.getSinglesTxt(), expectedAssertionsProp.getProperty("member.singles"));

		logger.info("Ending of verifyDetailsDisplayedInClubPageMembersTab method");
	}

	@Test(priority = 2, description = "Verify Kebab menu functionality under Memebers Tab in Club Page", groups = "sanity")
	@Description("Test case #2, Verify Kebab menu functionality under Memebers Tab in Club Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify Kebab menu functionality under Memebers Tab in Club Page")
	public void verifyKebabMenuFunctionalityUnderMemebersTab() {
		logger.info("Starting of verifyKebabMenuFunctionalityUnderMemebersTab method");

		clubMemberName = removeMemberPage.getMemberNameTxt();

		clubLogoPage.hardWait(2);
		removeMemberPage.clickOnKebabMenu();
		clubLogoPage.hardWait(2);

		Assert.assertTrue(this.removeMemberPage.isRemoveFromClubButtonDisplayed());

		logger.info("Ending of verifyKebabMenuFunctionalityUnderMemebersTab method");
	}

	@Test(priority = 3, description = "Verify Remove From Club Functionality", groups = "sanity")
	@Description("Test case #3, Verify Remove From Club Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify Remove From Club Functionality")
	public void verifyRemoveFromClubFunctionality() {
		logger.info("Starting of verifyRemoveFromClubFunctionality method");

		removeMemberPage.clickOnRemoveButton();
		removeMemberPage.hardWait(2);
		Assert.assertFalse(this.removeMemberPage.isRemoveFromClubButtonDisplayed());

		logger.info("Ending of verifyRemoveFromClubFunctionality method");
	}

	@Test(priority = 4, description = "Verify Member Search field with Removed Club Member Name", groups = "sanity")
	@Description("Test case #4, Verify Member Search field with Removed Club Member Name")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify Member Search field with Removed Club Member Name")
	public void verifyMemberSearchFieldWithRemovedClubMemberName() {
		logger.info("Starting of verifyMemberSearchFieldWithRemovedClubMemberName method");

		removeMemberPage.clickOnSearch(clubMemberName);

		Assert.assertEquals(removeMemberPage.getNoResultsTxt(), expectedAssertionsProp.getProperty("member.removed"));

		logger.info("Ending of verifyMemberSearchFieldWithRemovedClubMemberName method");
	}

	@AfterClass
	public void quitDriver() {
		try {
			if (this.driver != null)

			{
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.REMOVE_CLUB_MEMBER_DRIVER);
				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
