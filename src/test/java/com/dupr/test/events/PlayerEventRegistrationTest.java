package com.dupr.test.events;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.clubs.ClubLogoPage;
import com.dupr.pages.clubs.EditClubInfoPage;
import com.dupr.pages.events.AddBracketPage;
import com.dupr.pages.events.AddEventPage;
import com.dupr.pages.events.DirectorEventRegistrationPage;
import com.dupr.pages.events.PlayerEventRegistrationPage;
import com.dupr.test.CommonBaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class PlayerEventRegistrationTest extends CommonBaseTest {

	private static final Logger logger = Logger.getLogger(PlayerEventRegistrationTest.class.getName());
	DirectorEventRegistrationPage directorEventRegistrationPage = null;
	PlayerEventRegistrationPage playerEventRegistrationPage=null;
	@BeforeClass
	@Parameters({ "browser", "siteURL", "validEmail", "validPassword" })
	public void initMethod(String browser, String siteURL, String email, String password) throws Exception {
		logger.info("Starting of initMethod in PlayerEventRegistrationTest");

		this.driver = super.getWebDriver(WebDriversEnum.EVENT_REGISTRATION_DRIVER);
		this.siteLogin(siteURL, email, password, this.driver);
		
		this.editClubInfoPage = new EditClubInfoPage(this.driver);
		this.clubLogoPage = new ClubLogoPage(this.driver);
		this.addEventPage = new AddEventPage(this.driver);
		this.addBracketPage = new AddBracketPage(this.driver);
		this.directorEventRegistrationPage= new DirectorEventRegistrationPage(this.driver);
		this.playerEventRegistrationPage= new PlayerEventRegistrationPage(this.driver);
		
		logger.info("Ending of initMethod in PlayerEventRegistrationTest");
	}

	@Test(priority = 1, description = "Verify Register Functionality With FreeEvent And Bracket", groups = "sanity")
	@Description("Test case #1, Verify Register Functionality With FreeEvent And Bracket")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Register Functionality With FreeEvent And Bracket")
	public void VerifyRegisterFunctionalityWithFreeEventAndBracket() {
		logger.info("Starting of VerifyRegisterFunctionalityWithFreeEventAndBracket method");
		
		playerEventRegistrationPage.clickonEventsTab();		
		
		playerEventRegistrationPage.clickonEventCard();
		
		Assert.assertEquals(playerEventRegistrationPage.getEventHeadingLabel(),expectedAssertionsProp.getProperty("event.text"));
		
		logger.info("Ending of VerifyRegisterFunctionalityWithFreeEventAndBracket method");
	}

	@Test(priority = 2, description = "Verify register Functionality", groups = "sanity")
	@Description("Test case #2, Verify register Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify register Functionality")
	public void VerifyRegisterFunctionality() {
		logger.info("Starting of VerifyRegisterFunctionality method");
		
	 
		playerEventRegistrationPage.clickonRegisterButton();		
		Assert.assertEquals(directorEventRegistrationPage.getEventRegistrationLabel(),expectedAssertionsProp.getProperty("Event.registration"));

		Assert.assertEquals(playerEventRegistrationPage.getClubMembershipLabel(),expectedAssertionsProp.getProperty("club.membership"));
		Assert.assertEquals(directorEventRegistrationPage.getHealthAndSafetyLabel(),expectedAssertionsProp.getProperty("health.and.safety"));
		Assert.assertEquals(directorEventRegistrationPage.getLiabiltyPolicyLabel(),expectedAssertionsProp.getProperty("liabilty.policies"));
		
		
		logger.info("Ending of VerifyRegisterFunctionality method");
	}

	
	
	@Test(priority = 4, description = "Verify Event Registration Back Button Functionality", groups = "sanity")
	@Description("Test case #4, Verify Event Registration Back Button Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify Event Registration Back Button Functionality")
	public void VerifyEventRegistrationBackButtonFunctionality() {
		logger.info("Starting of VerifyEventRegistrationBackButtonFunctionality method");
		
		directorEventRegistrationPage.clickonEventRegistrationBackButton();
		
		Assert.assertEquals(directorEventRegistrationPage.getEventLabel(),expectedAssertionsProp.getProperty("event.text"));

		playerEventRegistrationPage.clickonRegisterButton();
		
		logger.info("Ending of VerifyEventRegistrationBackButtonFunctionality method");
	}
	
	@Test(priority = 5, description = "Verify register Functionality In Event Registration Page", groups = "sanity")
	@Description("Test case #2, Verify register Functionality  In Event Registration Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify register Functionality  In Event Registration Page")
	public void VerifyRegisterFunctionalityInEventRegistrationPage() {
		logger.info("Starting of VerifyRegisterFunctionalityInEventRegistrationPage method");
		
	 
		playerEventRegistrationPage.clickonClubMemberYesButton();		
		Assert.assertTrue(playerEventRegistrationPage.isClubMemberYesRadioButtonSelected());
		
		directorEventRegistrationPage.clickonSelectYourBracketCheckbox();

        Assert.assertTrue(directorEventRegistrationPage.isBracketCheckboxSelected());		

		directorEventRegistrationPage.clickonRefundPolicyCheckbox();
		
        Assert.assertTrue(directorEventRegistrationPage.isRefundPolicyCheckboxSelected());		
        
		directorEventRegistrationPage.clickonHealthSafetyPolicyCheckbox();

        Assert.assertTrue(directorEventRegistrationPage.isHealthSafetyPolicyCheckboxSelected());		

		directorEventRegistrationPage.clickonLaibilityCheckbox();

        Assert.assertTrue(directorEventRegistrationPage.isLiabilityPolicyCheckboxSelected());		

        playerEventRegistrationPage.clickonRegisterButton();
		
		logger.info("Ending of VerifyRegisterFunctionalityInEventRegistrationPage method");
	}


	@Test(priority = 6, description = "Verify Register Functionality Success PopUp", groups = "sanity")
	@Description("Test case #6, Verify Register Functionality In Registration Closed Event")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify Register Functionality In Registration Closed Event")
	public void VerifyRegisterFunctionalitySuccessPopUp() {
		logger.info("Starting of VerifyRegisterFunctionalitySuccessPopUp method");
		
		Assert.assertEquals(directorEventRegistrationPage.getSuccessLabel(),expectedAssertionsProp.getProperty("success.text"));
		Assert.assertEquals(directorEventRegistrationPage.getRegistrationCompletedLabel(),expectedAssertionsProp.getProperty("registration.completed"));
		Assert.assertEquals(directorEventRegistrationPage.getOkLabel(),expectedAssertionsProp.getProperty("ok.text"));
	
		directorEventRegistrationPage.clickOnOkButton();
    
		logger.info("Ending of VerifyRegisterFunctionalityInEventRegistrationPage method");
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
