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
import com.dupr.pages.events.PaidEventPage;
import com.dupr.pages.events.PlayerEventRegistrationPage;
import com.dupr.pages.events.TimeZonePage;
import com.dupr.test.CommonBaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class PlayerEventRegistrationTest extends CommonBaseTest {

	private static final Logger logger = Logger.getLogger(PlayerEventRegistrationTest.class.getName());
	private EventRegistrationPage directorEventRegistrationPage = null;
	private PlayerEventRegistrationPage playerEventRegistrationPage = null;
	private EditOrRemovePartnerPage editOrRemovePartnerPage = null;
	private AcceptOrDeclinePartnershipPage acceptOrDeclinePartnershipPage = null;
	private EditBracketsPage editBracketsPage = null;
	
	
	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String validEmail, String validPassword) throws Exception {
		logger.info("Starting of initMethod in PlayerEventRegistrationTest");

		this.driver = super.getWebDriver(WebDriversEnum.EVENT_REGISTRATION_DRIVER);
		super.initCommonBaseTest(siteURL, validEmail, validPassword);

		this.directorEventRegistrationPage = new EventRegistrationPage(this.driver);
		this.playerEventRegistrationPage = new PlayerEventRegistrationPage(this.driver);
		this.paidEventPage = new PaidEventPage(driver);
        this.editOrRemovePartnerPage = new EditOrRemovePartnerPage(this.driver);
        this.acceptOrDeclinePartnershipPage = new AcceptOrDeclinePartnershipPage(this.driver);
        this.editBracketsPage = new EditBracketsPage(this.driver);
        this.addBracketPage = new AddBracketPage(this.driver);
        this.addEventPage = new AddEventPage(this.driver);
		this.timeZonePage = new TimeZonePage(this.driver);
		this.editClubInfoPage = new EditClubInfoPage(this.driver);
        
		logger.info("Ending of initMethod in PlayerEventRegistrationTest");
	}

	@Test(priority = 1, description = "Verify Register Functionality in Director Account", groups = "sanity")
	@Description("Test case #1, Verify Register Functionality in Director Account")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Register Functionality in Director Account")
	public void verifyRegisterFunctionalityInDirectorAccount() {
		logger.info("Starting of verifyRegisterFunctionalityInDirectorAccount method");

		super.verifyAddEventFunctionality();
		super.verifyFreeBracketWithRoundRobinEventType();
		playerEventRegistrationPage.hardWait(3);
		super.verifyRecentlyAddedEventUnderEventsTab();
		playerEventRegistrationPage.hardWait(3);
		eventRegistrationPage.clickOnRegisterButton();
		eventRegistrationPage.clickOnSelectYourBracketCheckbox();
		playerEventRegistrationPage.clickOnAddYourPartnerButton();
		directorEventRegistrationPage.clickOnOkButton();
		editOrRemovePartnerPage.searchPartner(testDataProp.getProperty("partner.name"));
		editOrRemovePartnerPage.hardWait(5);
		eventRegistrationPage.clickOnAddYourPartnerRadioButton();

		eventRegistrationPage.clickOnAddPartnerButton();
		eventRegistrationPage.clickOnRefundPolicyCheckbox();
		eventRegistrationPage.clickOnLiabilityCheckbox();
		eventRegistrationPage.clickOnHealthSafetyPolicyCheckbox();
		
		eventRegistrationPage.clickOnRegisterButton();
		directorEventRegistrationPage.clickOnOkButton();
		
		logger.info("Ending of verifyRegisterFunctionalityInDirectorAccount method");
	}
	
	@Parameters({ "siteURL", "validEmail", "validPassword" })
	@Test(priority = 2, description = "Verify details displayed in Player Account", groups = "sanity")
	@Description("Test case #2, Verify details displayed in Player Account")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify details displayed in Player Account")
	public void verifyDetailsDisplayedInPlayerAccount(String siteURL, String validEmail, String validPassword) throws Exception {
		logger.info("Starting of verifyDetailsDisplayedInPlayerAccount method");

		userDashboardPage.clickOnOpenSettingsMenu();

		acceptOrDeclinePartnershipPage.clickOnLogoutButton();

		paidEventPage.hardWait(6);
		this.devSiteLogin(siteURL, validEmail, validPassword, driver);
		paidEventPage.hardWait(3);

		clubLogoPage.clickOnMyClubsTab();
		clubLogoPage.clickOnBrowseClubs();
		paidEventPage.hardWait(3);
		paidEventPage.clickOnSimbaClubName();
		paidEventPage.hardWait(3);
		
		logger.info("Ending of verifyDetailsDisplayedInPlayerAccount method");
	}

	@Test(priority = 3, description = "Verify Register Functionality in Player Account", groups = "sanity")
	@Description("Test case #3, Verify Register Functionality in Player Account")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify Register Functionality in Player Account")
	public void verifyRegisterFunctionalityInPlayerAccount() {
		logger.info("Starting of verifyRegisterFunctionalityInPlayerAccount method");

		paidEventPage.hardWait(3);
		addEventPage.clickOnEventsTab();
		addEventPage.clickOnRecentlyAddedEvent(eventName);

		Assert.assertTrue(acceptOrDeclinePartnershipPage.isRegisterButtonDisplayed());

		logger.info("Ending of verifyRegisterFunctionalityInPlayerAccount method");
	}

	@Test(priority = 4, description = "Verify Bracket Card Functionality in Player Account Event Registration page", groups = "sanity")
	@Description("Test case #4, Verify Bracket Card Functionality in Player Account Event Registration page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify Bracket Card Functionality in Player Account Event Registration page")
	public void verifyBracketCardFunctionalityInPlayerAccountEventRegistrationPage() {
		logger.info("Starting of verifyBracketCardFunctionalityInPlayerAccountEventRegistrationPage method");

		editBracketsPage.clickOnBracketLabel();
		paidEventPage.hardWait(3);

		Assert.assertTrue(acceptOrDeclinePartnershipPage.isAcceptButtonDisplayed());
		Assert.assertTrue(acceptOrDeclinePartnershipPage.isDeclineButtonDisplayed());

		logger.info("Ending of verifyBracketCardFunctionalityInPlayerAccountEventRegistrationPage method");
	}

	@Test(priority = 5, description = "Verify register Functionality in Player Account Event Registration Page", groups = "sanity")
	@Description("Test case #5, Verify register Functionality in Player Account Event Registration Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify register Functionality in Player Account Event Registration Page")
	public void verifyRegisterFunctionalityInPlayerAccountEventRegistrationPage() {
		logger.info("Starting of verifyRegisterFunctionalityInPlayerAccountEventRegistrationPage method");
		
		acceptOrDeclinePartnershipPage.clickOnAcceptButton();
		acceptOrDeclinePartnershipPage.isAcceptPartnerPopupContains();

		acceptOrDeclinePartnershipPage.clickOnYesRadioButton();

		Assert.assertTrue(acceptOrDeclinePartnershipPage.isRegisterButtonEnabled());

		logger.info("Ending of verifyRegisterFunctionalityInPlayerAccountEventRegistrationPage method");
	}

	@Test(priority = 6, description = "Verify Ok button Functionality in Success PopUp", groups = "sanity")
	@Description("Test case #6, Verify Ok button Functionality in Success PopUp")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify Ok button Functionality in Success PopUp")
	public void verifyOKButtonFunctionalityInSuccessPopUp() {
		logger.info("Starting of verifyOKButtonFunctionalityInSuccessPopUp method");

		acceptOrDeclinePartnershipPage.clickOnRegisterButton();
		
		paidEventPage.setCardInformation(testDataProp.getProperty("card.information"));
		paidEventPage.setBoxCardExpiry(testDataProp.getProperty("card.expiry"));
		paidEventPage.setBoxCardCVC(testDataProp.getProperty("card.cvc"));
		paidEventPage.setBoxNameOnCard(testDataProp.getProperty("name.on.card"));
		paidEventPage.clickOnPayButton();
		
		logger.info("Ending of verifyOKButtonFunctionalityInSuccessPopUp method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.EVENT_REGISTRATION_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
