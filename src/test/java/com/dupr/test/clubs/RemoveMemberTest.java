package com.dupr.test.clubs;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.clubs.ClubLogoPage;
import com.dupr.pages.clubs.RemoveMemberPage;
import com.dupr.test.DUPRBaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class RemoveMemberTest extends DUPRBaseAutomationTest {
	private static final Logger logger = Logger.getLogger(RemoveMemberTest.class.getName());
	private ClubLogoPage clubLogoPage = null;
	private RemoveMemberPage removeMemberPage = null;
	private static String clubMemberName = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String email, String password) throws Exception {
		logger.info("Starting of initMethod in RemoveMemberTest");

		this.driver = super.getWebDriver(WebDriversEnum.REMOVE_CLUB_MEMBER_DRIVER);
		this.siteLogin(siteURL, email, password, this.driver);
		this.clubLogoPage = new ClubLogoPage(this.driver);
		this.removeMemberPage = new RemoveMemberPage(this.driver);

		logger.info("Ending of initMethod in RemoveMemberTest");
	}

	@Test(priority = 1, description = "Verify members tab", groups = "sanity")
	@Description("Test case #1, Verify members tab")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify members tab")
	public void verifyMembersTab() {
		logger.info("Starting of verifyMembersTab method");

		clubLogoPage.clickOnMyClubsTab();
		clubLogoPage.clickOnClub();
		clubLogoPage.hardWait(3);
		removeMemberPage.clickOnMembersTab();

		logger.info("Ending of verifyMembersTab method");
	}

	@Test(priority = 2, description = "Verify club member details", groups = "sanity")
	@Description("Test case #2, Verify club member details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify club member details")
	public void verifyClubMember() {
		logger.info("Starting of verifyClubMember method");

		if (removeMemberPage.getDoubles() == false) {
			Assert.assertTrue(removeMemberPage.isClubMemberContains());
			Assert.assertEquals(removeMemberPage.getDoublesTxt(), expectedAssertionsProp.getProperty("member.doubles"));
			Assert.assertEquals(removeMemberPage.getSinglesTxt(), expectedAssertionsProp.getProperty("member.singles"));
		}

		logger.info("Ending of verifyClubMember method");
	}

	@Test(priority = 3, description = "Verify kebab menu functionality", groups = "sanity")
	@Description("Test case #3, Verify kebab menu functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify kebab menu functionality")
	public void verifyKebabMenu() {
		logger.info("Starting of verifyKebabMenu method");

		if (removeMemberPage.getDoubles() == false) {
			clubMemberName = removeMemberPage.getMemberNameTxt();

			clubLogoPage.hardWait(2);
			removeMemberPage.clickOnKebabMenu();
			clubLogoPage.hardWait(1);
			removeMemberPage.clickOnRemoveButton();
		}

		logger.info("Ending of verifyKebabMenu method");
	}

	@Test(priority = 4, description = "Verify removed club member", groups = "sanity")
	@Description("Test case #4, Verify kebab removed club member")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify removed club member")
	public void verifyRemovedMember() {
		logger.info("Starting of verifyKebabMenu method");

		if (removeMemberPage.getDoubles() == false) {
			removeMemberPage.clickOnSearch(clubMemberName);
			clubLogoPage.hardWait(2);
			Assert.assertEquals(removeMemberPage.getNoResultsTxt(),
					expectedAssertionsProp.getProperty("member.removed"));
		}

		logger.info("Ending of verifyKebabMenu method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.REMOVE_CLUB_MEMBER_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
