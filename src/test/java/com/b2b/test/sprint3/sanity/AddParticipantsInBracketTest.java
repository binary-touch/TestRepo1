package com.b2b.test.sprint3.sanity;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.events.AddParticipantsInBracketsPage;
import com.dupr.test.DUPRBaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class AddParticipantsInBracketTest extends DUPRBaseAutomationTest {
	
	private static final Logger logger = Logger.getLogger(AddParticipantsInBracketTest.class.getName());
	private AddParticipantsInBracketsPage addparticipantsPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String directorEmail, String directorPassword)
			throws Exception {
		logger.info("Starting of initMethod in AddParticipantsInBracketTest");

		this.driver = super.getWebDriver(WebDriversEnum.ADD_PARTICIPANTS_DRIVER);
		this.siteLogin(siteURL, directorEmail, directorPassword, this.driver);
		this.addparticipantsPage = new AddParticipantsInBracketsPage(this.driver);

		logger.info("Ending of initMethod in AddParticipantsInBracketTest");
	}

	@Test(priority = 1, description = "Verify Add Participants functionality", groups = "sanity")
	@Description("Test case #1, Verify Add Participants functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Add Participants functionality")
	public void verifyAddParticipantsFunctionality() {
		logger.info("Starting of verifyAddParticipantsFunctionality method");

		addparticipantsPage.clickOnMyBracketsDropdown();
		
		Assert.assertEquals(addparticipantsPage.getBracketsTitle(), expectedAssertionsProp.getProperty("brackets.text"));

		Assert.assertTrue(addparticipantsPage.isMyBracketsPageContains());

		addparticipantsPage.clickOnBracketNameLink();

		Assert.assertTrue(addparticipantsPage.isAddBracketParticipantPageContains());
		Assert.assertTrue(addparticipantsPage.isAddParticipantButtonDisabled());
		Assert.assertEquals(addparticipantsPage.getAddBracketParticipantLabel(),
				expectedAssertionsProp.getProperty("add.bracket.label"));

		logger.info("Ending of verifyAddParticipantsFunctionality method");
	}

	@Test(priority = 2, description = "Verify Go Back functionality in Add a Bracket Participant page", groups = "sanity")
	@Description("Test case #2, Verify Go Back functionality in Add a Bracket Participant page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify Go Back functionality")
	public void verifyGoBackFunctionality() {
		logger.info("Starting of verifyGoBackFunctionality method");

		addparticipantsPage.clickOnGoBackButton();
		addparticipantsPage.hardWait(2);
		
		logger.info("Ending of verifyGoBackFunctionality method");
	}
	
	@Test(priority = 3, description = "Verify Search Participant Functionality With valid Participant Name", groups = "sanity")
	@Description("Test case #3, Verify Search Participant Functionality With valid Participant Name")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify Search By Name Functionality with valid Participant Name")
	public void verifySearchParticipantFunctionalityWithValidName() {
		logger.info("Starting of verifySearchParticipantFunctionalityWithValidName method");

		addparticipantsPage.clickOnAddParticipantsButton();
		addparticipantsPage.hardWait(2);

		String participantName = addparticipantsPage.getParticipantNameText();
		addparticipantsPage.searchParticipantByName(participantName);		
		
		String searchData = addparticipantsPage.getParticipantNameFromSearchField();
		Assert.assertEquals(searchData, addparticipantsPage.getSearchParticipantResult(participantName));

		logger.info("Ending of verifySearchParticipantFunctionalityWithValidName method");
	}

	@Test(priority = 4, description = "Verify Search Participant Functionality With Invalid Participant Name", groups = "sanity")
	@Description("Test case #4, Verify Search Participant Functionality With Invalid Paticipant Name")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify Search By Name Functionality with Invalid Participant Name")
	public void verifySearchParticipantFunctionalityWithInvalidName() {
		logger.info("Starting of verifySearchParticipantFunctionalityWithInvalidName method");
		
		addparticipantsPage.searchParticipantByName(testDataProp.getProperty("name.txt"));
		Assert.assertEquals(addparticipantsPage.getNoResultsText(), expectedAssertionsProp.getProperty("no.results"));

		logger.info("Ending of verifySearchParticipantFunctionalityWithInvalidName method");
	}

	@Test(priority = 5, description = "Verify the State of Add Participant Button before adding Participant", groups = "sanity")
	@Description("Test case #5, Verify the State of Add Participant Button before adding Participant")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify the State of Add Participant Button before adding Participant")
	public void verifyStateOfAddParticipantButton() {
		logger.info("Starting of verifyStateOfAddParticipantButton method");

		driver.navigate().refresh();
		addparticipantsPage.hardWait(2);
		addparticipantsPage.clickOnAddParticipantsButton();
		
		Assert.assertTrue(addparticipantsPage.isAddParticipantButtonDisabled());
		
		logger.info("Ending of verifyStateOfAddParticipantButton method");
	}
	
	@Test(priority = 6, description = "Verify Add Participant functionality", groups = "sanity")
	@Description("Test case #6, Verify Add Participant functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify Add Participant functionality")
	public void verifySelectAddParticipantFunctionality() {
		logger.info("Starting of verifySelectAddParticipantFunctionality method");

		addparticipantsPage.clickOnSelectParticipantRadioButton();
		
		Assert.assertTrue(addparticipantsPage.isParticipantSelected());
		
		addparticipantsPage.clickOnAddParticipantButton();
		addparticipantsPage.hardWait(4);
		Assert.assertTrue(addparticipantsPage.isClubMemberPopupContains());
		Assert.assertEquals(addparticipantsPage.getCLubMembershipLabel(),
				expectedAssertionsProp.getProperty("add.participate.popup.title"));

		logger.info("Ending of verifySelectAddParticipantFunctionality method");
	}

	@Test(priority = 7, description = "Verify close icon functionality in Club Membership popup", groups = "sanity")
	@Description("Test case #7, Verify close icon functionality in Club Membership popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Verify close icon functionality in Club Membership popup")
	public void verifyCloseIconFunctionality() {
		logger.info("Starting of verifyCloseIconFunctionality method");

		addparticipantsPage.clickOnCloseIconInClubMembershipPopup();
		addparticipantsPage.hardWait(2);
	
		Assert.assertTrue(addparticipantsPage.isAddBracketParticipantPageContains());
		
		logger.info("Ending of verifyCloseIconFunctionality method");
	}

	@Test(priority = 8, description = "Verify Cancel button functionality in Club Membership popup", groups = "sanity")
	@Description("Test case #8, Verify cancel button functionality in Club Membership popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Verify cancel button functionality in Club Membership popup")
	public void verifyCancelClubMembershipPopupFunctionality() {
		logger.info("Starting of verifyCancelClubMembershipPopupFunctionality method");

		addparticipantsPage.clickOnAddParticipantButton();
		addparticipantsPage.clickOnCancelButtonInClubMembershipPopup();
		
		addparticipantsPage.hardWait(2);
		Assert.assertTrue(addparticipantsPage.isAddBracketParticipantPageContains());

		logger.info("Ending of verifyCancelClubMembershipPopupFunctionality method");
	}

	@Test(priority = 9, description = "Verify by selecting Yes Radio button & adding participant in Club Membership popup", groups = "sanity")
	@Description("Test case #9, Verify by selecting Yes Radio button & adding participant in Club Membership popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9, Verify by selecting Yes Radio button & adding participant in Club Membership popup")
	public void verifyAddingHostClubMember() {
		logger.info("Starting of verifyAddingHostClubMember method");
		
		addparticipantsPage.clickOnAddParticipantButton();
		addparticipantsPage.clickOnYesRadioButton();
		
		addparticipantsPage.hardWait(3);
		
		//Assert.assertTrue(this.addparticipantsPage.isYesRadioButtonSelected());
		
		addparticipantsPage.clickOnAddButtonInClubMembershipPopup();
		
		logger.info("Ending of verifyAddingHostClubMember method");
	}

	@Test(priority = 10, description = "Verify by selecting No Radio button in Club Membership popup & adding participant", groups = "sanity")
	@Description("Test case #10, Verify by selecting No Radio button in Club Membership popup & adding participant")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #10, Verify by selecting No Radio button in Club Membership popup & adding participant")
	public void verifyAddingNonHostClubMember() {
		logger.info("Starting of verifyAddingNonHostClubMember method");

		addparticipantsPage.clickOnAddParticipantsButton();
		this.verifySelectAddParticipantFunctionality();
		
		addparticipantsPage.clickOnNoRadioButton();
		
		addparticipantsPage.clickOnAddButtonInClubMembershipPopup();
		
		logger.info("Ending of verifyAddingNonHostClubMember method");
	}
	
	@Test(priority = 11, description = "Verify the results on click of Export CSV", groups = "sanity")
	@Description("Test case #11, Verify the results on click of Export CSV")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #11 Verify the results on click of Export CSV")
	public void verifyExportCsvFunctionality() throws IOException {
		logger.info("Starting of verifyExportCsvFunctionality method");
		
		addparticipantsPage.clickOnExportCSVButton();
		
		driver.get("chrome://downloads/");

		logger.info("Ending of verifyExportCsvFunctionality method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.ADD_PARTICIPANTS_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}
}
