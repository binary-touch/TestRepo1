package com.dupr.test.events;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.clubs.EditClubInfoPage;
import com.dupr.pages.events.AcceptOrDeclinePartnershipPage;
import com.dupr.pages.events.AddBracketPage;
import com.dupr.pages.events.AddEventPage;
import com.dupr.pages.events.EditBracketsPage;
import com.dupr.pages.events.EditOrRemovePartnerPage;
import com.dupr.pages.events.EventRegistrationPage;
import com.dupr.pages.events.TimeZonePage;
import com.dupr.pages.home.UserDashboardPage;
import com.dupr.test.CommonBaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic(value = "Brackets")
@Feature(value = "Accept or Decline Partner")
public class AcceptOrDeclinePartnerTest extends CommonBaseTest {

	private static final Logger logger = Logger.getLogger(AcceptOrDeclinePartnerTest.class.getName());

	private EditOrRemovePartnerPage editOrRemovePartnerPage = null;
	private AcceptOrDeclinePartnershipPage acceptOrDeclinePartnershipPage = null;
	private UserDashboardPage userDashboardPage = null;
	private EditBracketsPage editBracketsPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String directorEmail, String directorPassword)
			throws Exception {
		logger.info("Starting of initMethod in AcceptOrDeclinePartnerTest");

		this.driver = super.getWebDriver(WebDriversEnum.ACCEPT_OR_DECLINE_PARTNER_DRIVER);
		super.initCommonBaseTest(siteURL, directorEmail, directorPassword);
		this.directorEventRegistrationPage = new EventRegistrationPage(this.driver);
		this.editOrRemovePartnerPage = new EditOrRemovePartnerPage(this.driver);
		this.acceptOrDeclinePartnershipPage = new AcceptOrDeclinePartnershipPage(this.driver);
		this.userDashboardPage = new UserDashboardPage(this.driver);
		this.editBracketsPage = new EditBracketsPage(this.driver);
		this.addBracketPage = new AddBracketPage(this.driver);
        this.addEventPage = new AddEventPage(this.driver);
		this.timeZonePage = new TimeZonePage(this.driver);
		this.editClubInfoPage = new EditClubInfoPage(this.driver);
        
		logger.info("Ending of initMethod in AcceptOrDeclinePartnerTest");
	}

	@Test(priority = 1, description = "Verify Add Partner Functionality In Bracket Page ", groups = "sanity")
	@Description("Test case #1, Verify Add Partner Functionality In Bracket Page ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Add Partner Functionality In Bracket Page")
	public void verifyAddPartnerFunctionalityInBracketPage() {
		logger.info("Starting of verifyAddPartnerFunctionalityInBracketPage method");

		super.verifyAddEventFunctionality();
		super.verifyEventInformationPageWithValidDetails();
		super.verifyEventPoliciesPageByEnteringValidDetails();
		super.verifyAddBracketsForRegisterFunctionalityWithValidDetails();
		super.verifyNoContinueToSummaryButtonInAddAnotherBracketpopup();
		super.verifyPublishEventButton();
		super.verifyRecentlyAddedEventUnderEventsTab();
		super.verifyRegisterFunctionality();

		clubLogoPage.clickOnMyClubsTab();
		editClubInfoPage.clickOnSimbaOrganizerButton();

		addEventPage.clickOnEventsTab();
		addEventPage.clickOnRecentlyAddedEvent(eventName);

		editBracketsPage.clickOnBracketLabel();

		editOrRemovePartnerPage.clickOnAddPartnerInBracketPageButton();

		Assert.assertEquals(editOrRemovePartnerPage.getAddAPartnerLabel(),
				expectedAssertionsProp.getProperty("add.a.partner.text"));

		Assert.assertTrue(editOrRemovePartnerPage.isAddAPartnerPageContains());

		logger.info("Ending of verifyAddPartnerFunctionalityInBracketPage method");
	}

	@Test(priority = 2, description = "Verify Add Partner Functionality In AddPartner Page ", groups = "sanity")
	@Description("Test case #2, Verify Add Partner Functionality In AddPartner Page ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify Add Partner Functionality In AddPartner Page ")
	public void verifyAddPartnerFunctionalityInAddPartnerPage() {
		logger.info("Starting of verifyAddPartnerFunctionalityInAddPartnerPage method");

		editOrRemovePartnerPage.searchPartner(testDataProp.getProperty("partner.name"));
		
		editOrRemovePartnerPage.hardWait(3);

		eventRegistrationPage.clickOnAddYourPartnerRadioButton();

		eventRegistrationPage.clickOnAddPartnerButton();

		logger.info("Ending of verifyAddPartnerFunctionalityInAddPartnerPage method");
	}

	@Test(priority = 3, description = "Verify EditPartner Functionality In BracketPage ", groups = "sanity")
	@Description("Test case #1, Verify EditPartner Functionality In BracketPage  ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify EditPartner Functionality In BracketPage  ")
	public void verifyEditPartnerFunctionalityInBracketPage() {
		logger.info("Starting of verifyEditPartnerFunctionalityInBracketPage method");

		editOrRemovePartnerPage.clickOnEditPartnerButton();

		Assert.assertTrue(editOrRemovePartnerPage.isAddAPartnerPageContains());

		logger.info("Ending of verifyAddPartnerFunctionalityInAddPartnerPage method");
	}

	@Test(priority = 4, description = "Verify Cancel Button Functionality in AddPartner Page", groups = "sanity")
	@Description("Test case #4, Verify Cancel Button Functionality in AddPartner Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify Cancel Button Functionality in AddPartner Page")
	public void verifyCancelButtonFunctionalityInAddPartnerPage() {
		logger.info("Starting of verifyCancelButtonFunctionalityInAddPartnerPage method");

		editOrRemovePartnerPage.clickOnCancelButton();

		Assert.assertEquals(editOrRemovePartnerPage.getBracketLabel(),
				expectedAssertionsProp.getProperty("bracket.text"));

		Assert.assertTrue(editOrRemovePartnerPage.isBracketPageContains());

		logger.info("Ending of verifyCancelButtonFunctionalityInAddPartnerPage method");
	}

	@Test(priority = 5, description = "Verify Search Partner functionality with valid partnername", groups = "sanity")
	@Description("Test case #5, Verify Search Partner functionality with valid partnername")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify Search Partner functionality with valid partnername")
	public void verifySearchPartnerFunctionalityWithValidPartnerName() {
		logger.info("Starting of verifySearchPartnerFunctionalityWithValidPartnerName method");

		this.verifyEditPartnerFunctionalityInBracketPage();

		editOrRemovePartnerPage.searchPartner(testDataProp.getProperty("partner2.name"));

		logger.info("Ending of verifySearchPartnerFunctionalityWithValidPartnerName method");
	}

	@Test(priority = 6, description = "Verify Search Partner functionality with Invalid partnername", groups = "sanity")
	@Description("Test case #6, Verify Search Partner functionality with Invalid partnername")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify Search Partner functionality with Invalid partnername")
	public void verifySearchPartnerFunctionalityWithInvalidPartnerName() {
		logger.info("Starting of verifySearchPartnerFunctionalityWithInvalidPartnerName method");

		editOrRemovePartnerPage.searchPartner(testDataProp.getProperty("in.valid.partner.name"));

		Assert.assertFalse(editOrRemovePartnerPage.isPartnerRadioButtonDisplayed());
		Assert.assertEquals(editOrRemovePartnerPage.getNoMoreResultsLabel(),
				expectedAssertionsProp.getProperty("no.more.results"));

		logger.info("Ending of verifySearchPartnerFunctionalityWithInvalidPartnerName method");
	}

	@Test(priority = 7, description = "Verify AddPartner Button State Before Adding Partner", groups = "sanity")
	@Description("Test case #7, Verify AddPartner Button State Before Adding Partner")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Verify AddPartner Button State Before Adding Partner")
	public void verifyAddPartnerButtonStateBeforeAddingPartner() {
		logger.info("Starting of verifyAddPartnerButtonStateBeforeAddingPartner method");

		editOrRemovePartnerPage.searchPartner(testDataProp.getProperty("player.name.txt"));

		Assert.assertTrue(editOrRemovePartnerPage.isAddPartnerButtonDisabled());

		logger.info("Ending of verifyAddPartnerButtonStateBeforeAddingPartner method");
	}

	@Test(priority = 8, description = "Verify Edit Partner functionality by selecting a participant from the list", groups = "sanity")
	@Description("Test case #8, Verify Edit Partner functionality by selecting a participant from the list")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Verify Edit Partner functionality by selecting a participant from the list")
	public void verifyEditPartnerFunctionality() {
		logger.info("Starting of verifyEditPartnerFunctionality method");

		editOrRemovePartnerPage.searchPartner(testDataProp.getProperty("player.name.txt"));

		editOrRemovePartnerPage.hardWait(3);
		editOrRemovePartnerPage.clickOnAddPartnerRadioButton();
		editOrRemovePartnerPage.hardWait(2);
		editOrRemovePartnerPage.clickOnAddPartnerEnabledButton();

		Assert.assertTrue(editOrRemovePartnerPage.isBracketPageContainsAfterAddingPartner());

		logger.info("Ending of verifyEditPartnerFunctionality method");
	}

	@Test(priority = 9, description = "Verify Remove Partner button on the Bracket Card", groups = "sanity")
	@Description("Test case #9, Verify Remove Partner button on the Bracket Card")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9, Verify Remove Partner button on the Bracket Card")
	public void verifyRemovePartnerFunctionality() {
		logger.info("Starting of verifyRemovePartnerFunctionality method");

		editOrRemovePartnerPage.clickOnRemovePartnerButton();
		editOrRemovePartnerPage.hardWait(3);
		Assert.assertTrue(editOrRemovePartnerPage.isBracketPageContainsAfterRemovingPartner());

		logger.info("Ending of verifyRemovePartnerFunctionality method");
	}

	@Test(priority = 10, description = "Verify Add Partner Functionality For Accept Or Decline Partner ", groups = "sanity")
	@Description("Test case #10, Verify Add Partner Functionality For Accept Or Decline Partner ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #10, Verify Add Partner Functionality For Accept Or Decline Partner ")
	public void verifyEditPartnerFunctionalityForAcceptOrDeclinePartnerInBracketPage() {
		logger.info("Starting of verifyEditPartnerFunctionalityForAcceptOrDeclinePartnerInBracketPage method");

		editOrRemovePartnerPage.clickOnAddPartnerInBracketPageButton();

		editOrRemovePartnerPage.searchPartner(testDataProp.getProperty("partner.name"));
		editOrRemovePartnerPage.hardWait(3);

		eventRegistrationPage.clickOnAddYourPartnerRadioButton();
		eventRegistrationPage.clickOnAddPartnerButton();

		logger.info("Ending of verifyEditPartnerFunctionalityForAcceptOrDeclinePartnerInBracketPage method");
	}

	@Parameters({ "siteURL", "validEmail", "validPassword" })
	@Test(priority = 11, description = "Verify Accept Functionality MyBrackets Page In Player Account", groups = "sanity")
	@Description("Test case #11, Verify Accept Functionality MyBrackets Page In Player Account")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #11, Verify Accept Functionality MyBrackets Page In Player Account")
	public void verifyAcceptFunctionalityInPlayerAccount(String siteURL, String validEmail, String validPassword)
			throws Exception {
		logger.info("Starting of verifyAcceptFunctionalityInPlayerAccount method");

		editOrRemovePartnerPage.hardWait(3);
		userDashboardPage.clickOnOpenSettingsMenu();

		acceptOrDeclinePartnershipPage.clickOnLogoutButton();

		paidEventPage.hardWait(3);
		this.devSiteLogin(siteURL, validEmail, validPassword, driver);
		paidEventPage.hardWait(3);

		clubLogoPage.clickOnMyClubsTab();
		clubLogoPage.clickOnBrowseClubs();
		paidEventPage.hardWait(3);
		paidEventPage.clickOnSimbaClubName();
		paidEventPage.hardWait(3);
		addEventPage.clickOnEventsTab();
		addEventPage.clickOnRecentlyAddedEvent(eventName);

		editBracketsPage.clickOnBracketLabel();
		paidEventPage.hardWait(3);

		Assert.assertTrue(acceptOrDeclinePartnershipPage.isAcceptButtonDisplayed());
		Assert.assertTrue(acceptOrDeclinePartnershipPage.isDeclineButtonDisplayed());

		logger.info("Ending of verifyAcceptFunctionalityInPlayerAccount method");
	}

	@Parameters({ "siteURL", "validEmail", "validPassword" })
	@Test(priority = 12, description = "Verify Yes Radio Button in Accept Partner PopUp", groups = "sanity")
	@Description("Test case #12, Verify No Radio Button in Accept Partner PopUp")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #12, Verify No Radio Button in Accept Partner PopUp")
	public void verifyYesButtonFunctionalityInAcceptPartnerPopUp(String siteURL, String validEmail,
			String validPassword) throws Exception {
		logger.info("Starting of verifyYesButtonFunctionalityInAcceptPartnerPopUp method");

		acceptOrDeclinePartnershipPage.clickOnAcceptButton();
		acceptOrDeclinePartnershipPage.isAcceptPartnerPopupContains();

		acceptOrDeclinePartnershipPage.clickOnYesRadioButton();

		Assert.assertTrue(acceptOrDeclinePartnershipPage.isRegisterButtonEnabled());

		logger.info("Ending of verifyYesButtonFunctionalityInAcceptPartnerPopUp method");
	}

	@Test(priority = 13, description = "Verify No Radio Button in Accept Partner PopUp", groups = "sanity")
	@Description("Test case #13, Verify No Radio Button in Accept Partner PopUp")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #13, Verify No Radio Button in Accept Partner PopUp")
	public void verifyNoRadioButtonFunctionalityInAcceptPartnerPopUp() {
		logger.info("Starting of verifyNoRadioButtonFunctionalityInAcceptPartnerPopUp method");

		acceptOrDeclinePartnershipPage.clickOnNoRadioButton();
		Assert.assertTrue(acceptOrDeclinePartnershipPage.isNoRadioButtonSelected());
		Assert.assertTrue(acceptOrDeclinePartnershipPage.isRegisterButtonEnabled());

		logger.info("Ending of verifyNoRadioButtonFunctionalityInAcceptPartnerPopUp method");
	}

	@Test(priority = 14, description = "Verify MyBrackets Page In Player Account", groups = "sanity")
	@Description("Test case #14, Verify MyBrackets Page In Player Account")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #14, Verify MyBrackets Page In Player Account")
	public void verifyRegisterFunctionalityInAcceptPartnerPopUp() {
		logger.info("Starting of verifyRegisterFunctionalityInAcceptPartnerPopUp method");

		acceptOrDeclinePartnershipPage.clickOnRegisterButton();

		Assert.assertEquals(eventRegistrationPage.getSuccessLabel(),
				expectedAssertionsProp.getProperty("success.text"));

		Assert.assertEquals(eventRegistrationPage.getRegistrationCompletedLabel(),
				expectedAssertionsProp.getProperty("registration.completed"));

		Assert.assertEquals(eventRegistrationPage.getOkLabel(), expectedAssertionsProp.getProperty("ok.text"));

		logger.info("Ending of verifyRegisterFunctionalityInAcceptPartnerPopUp method");
	}

	@Test(priority = 15, description = "Verify Ok finctionality In Accept Partner PopUp", groups = "sanity")
	@Description("Test case #15, Verify Ok finctionality In Accept Partner PopUp")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #15, Verify Ok finctionality In Accept Partner PopUp")
	public void verifyOkFunctionalityInAcceptPartnerPopUp() {
		logger.info("Starting of verifyOkFunctionalityInAcceptPartnerPopUp method");

		eventRegistrationPage.clickOnOkButton();

		logger.info("Ending of verifyOkFunctionalityInAcceptPartnerPopUp method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.ACCEPT_OR_DECLINE_PARTNER_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
