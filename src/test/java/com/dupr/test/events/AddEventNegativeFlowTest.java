package com.dupr.test.events;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.clubs.ClubLogoPage;
import com.dupr.pages.clubs.EditClubInfoPage;
import com.dupr.pages.events.AddBracketPage;
import com.dupr.pages.events.AddEventNegativePage;
import com.dupr.pages.events.AddEventPage;
import com.dupr.test.DUPRBaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class AddEventNegativeFlowTest extends DUPRBaseAutomationTest {

	private static final Logger logger = Logger.getLogger(AddEventNegativeFlowTest.class.getName());
	private ClubLogoPage clubLogoPage = null;
	private EditClubInfoPage editClubInfoPage = null;

	private AddEventPage addEventPage = null;
	private AddBracketPage addBracketPage = null;
	private AddEventNegativePage addEventNegativeFlow = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String email, String password) throws Exception {
		logger.info("Starting of initMethod in EditClubInfoTest");

		this.driver = super.getWebDriver(WebDriversEnum.ADD_EVENT_DRIVER);
		this.siteLogin(siteURL, email, password, this.driver);
		this.editClubInfoPage = new EditClubInfoPage(this.driver);
		this.clubLogoPage = new ClubLogoPage(this.driver);

		this.addEventPage = new AddEventPage(this.driver);
		this.addBracketPage = new AddBracketPage(this.driver);
		this.addEventNegativeFlow = new AddEventNegativePage(this.driver);
		
		logger.info("Ending of initMethod in EditClubInfoTest");
	}

	@Test(priority = 1, description = "Verify Add Event functionality", groups = "sanity")
	@Description("Test case #1, Verify Add Event functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Add Event functionality")
	public void VerifyAddEventFunctionality() {
		logger.info("Starting of VerifyAddEventFunctionality method");

		clubLogoPage.clickOnMyClubsTab();

		editClubInfoPage.selectDirectorFromDirectorsList();

	    addEventPage.clickonAddEventButton();

	   Assert.assertTrue(addEventPage.isDisplayedEventInformationPageContains());

		logger.info("Ending of VerifyAddEventFunctionality method");
	}

	@Test(priority = 2, description = "Verify Event Info Page With EmptyFields", groups = "sanity")
	@Description("Test case #2, Verify Event Info Page With EmptyFields")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify Event Info Page With EmptyFields")
	public void VerifyEventInfoPageWithEmptyFields() {
		logger.info("Starting of VerifyEventInfoPageWithEmptyFields method");
	
		addEventPage.clickonNextButton();
		Assert.assertTrue(addEventNegativeFlow.isEventWithEmptyFieldsContainsDisplayed());
		
		logger.info("Ending of VerifyEventInfoPageWithEmptyFields method");
	}
	
	@Test(priority = 3, description = "Verify Member And NonMember Price Fields With Invalid Details", groups = "sanity")
	@Description("Test case #3, Verify Member And NonMember Price Fields With Invalid Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify Member And NonMember Price Fields With Invalid Details")
	public void VerifyMemberAndNonMemberPriceFieldsWithInvalidDetails() {
		logger.info("Starting of VerifyMemberAndNonMemberPriceFieldsWithInvalidDetails method");
	
		addEventPage.setMemberPrice(testDataProp.getProperty("memberPrice.invalid.value"));
		
		addEventPage.setNonMemberPrice(testDataProp.getProperty("nonMemberPrice.invalid.value"));
		
		Assert.assertTrue(addEventNegativeFlow.isMemberAndNonMemberPriceFieldsWithInvalidDetailsDisplayed());
		
		logger.info("Ending of VerifyMemberAndNonMemberPriceFieldsWithInvalidDetails method");
	}
	
	//@Test(priority = 4, description = "Verify Member And Nonmember Price Fields With Negative Values", groups = "sanity")
	@Description("Test case #4, Verify Member And Nonmember Price Fields With Negative Values")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify Member And Nonmember Price Fields With Negative Values")
	public void VerifyMemberAndNonmemberPriceFieldsWithNegativeValues() {
		logger.info("Starting of VerifyMemberAndNonmemberPriceFieldsWithNegativeValues method");
	
		addEventPage.setMemberPrice(testDataProp.getProperty("memberPrice.neg.value"));
		
		addEventPage.setNonMemberPrice(testDataProp.getProperty("nonMemberPrice.neg.value"));
		
		addEventPage.clickonNextButton();
		
		Assert.assertTrue(addEventNegativeFlow.isMemberAndNonMemberPriceFieldsWithNegativeDetailsDisplayed());
		
		logger.info("Ending of VerifyMemberAndNonmemberPriceFieldsWithNegativeValues method");
	}
	
	//@Test(priority = 5, description = "Verify Minimum Ten Chars Validation In AboutTheEvent", groups = "sanity")
	@Description("Test case #5, Verify Minimum Ten Chars Validation In AboutTheEvent")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify Minimum Ten Chars Validation In AboutTheEvent")
	public void VerifyMinimumTenCharsValidationInAboutTheEvent() {
		logger.info("Starting of VerifyMinimumTenCharsValidationInAboutTheEvent method");
	
		addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.Event.minimum.char"));
				
		addEventPage.clickonNextButton();
		
		Assert.assertTrue(addEventNegativeFlow.isMinimumTenCharsValidationDisplayed());
		
		logger.info("Ending of VerifyMinimumTenCharsValidationInAboutTheEvent method");
	}
	
	
	//@Test(priority = 6, description = "Verify Formating of Font styles for the About event field", groups = "sanity")
	@Description("Test case #6, Verify Formating of Font styles for the About event field")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify Formating of Font styles for the About event field")
	public void VerifyFormatingFontStylesAboutEventField() {
		logger.info("Starting of VerifyFormatingFontStylesAboutEventField method");
	
		addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.Event"));
				
		addEventPage.clickonTextFormattingButtons();
		Assert.assertTrue(this.addEventPage.isBoldItalicUnderlineFontStylesDisplayed());
		
		logger.info("Ending of VerifyFormatingFontStylesAboutEventField method");
	}
	
	//@Test(priority = 7, description = "Verify Font styles for the About event field", groups = "sanity")
	@Description("Test case #7, Verify Font styles for the About event field")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Verify Font styles for the About event field")
	public void VerifyFontStylesAboutEventField() {
		logger.info("Starting of VerifyFontStylesAboutEventField method");
	
		addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.Event"));
				
		addEventPage.clickonBoldTextFormattingButton();
		Assert.assertTrue(this.addEventPage.isBoldFontStyleDisplayed());
		
		addEventPage.clickonBoldTextFormattingButton();
		
		addEventPage.clickonItalicTextFormattingButton();
		Assert.assertTrue(this.addEventPage.isItalicFontStyleDisplayed());
		
		addEventPage.clickonItalicTextFormattingButton();
		
		addEventPage.clickonUnderLineTextFormattingButton();
		Assert.assertTrue(this.addEventPage.isUnderlineFontStyleDisplayed());
		
		addEventPage.clickonUnderLineTextFormattingButton();
		
		logger.info("Ending of VerifyFontStylesAboutEventField method");
	}
	
	//@Test(priority = 8, description = "Verify combination of Bold and Underline  Font styles for the About event field", groups = "sanity")
	@Description("Test case #8, Verify combination of Bold and Underline Font styles for the About event field")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Verify combination of Bold and Underline Font styles for the About event field")
	public void VerifyCombinationOFBoldAndUnderlineFontStylesAboutEventField() {
		logger.info("Starting of VerifyCombinationOFFontStylesAboutEventField method");
	
		addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.Event"));
				
		addEventPage.clickonBoldAndUnderLineTextFormattingButton();
		Assert.assertTrue(this.addEventPage.isBoldUnderlineFontStylesDisplayed());
		
		logger.info("Ending of VerifyCombinationOFBoldAndUnderlineFontStylesAboutEventField method");
	}

	
	//@Test(priority = 9, description = "Verify combination of Italic and Underline  Font styles for the About event field", groups = "sanity")
	@Description("Test case #9, Verify combination of Italic and Underline Font styles for the About event field")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9, Verify combination of Italic and Underline Font styles for the About event field")
	public void VerifyCombinationOFItalicAndUnderlineFontStylesAboutEventField() {
		logger.info("Starting of VerifyCombinationOFItalicAndUnderlineFontStylesAboutEventField method");
	
         addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.Event"));
		
		addEventPage.clickonItalicAndUnderLineTextFormattingButton();
		Assert.assertTrue(this.addEventPage.isItalicUnderlineFontStylesDisplayed());
		
		logger.info("Ending of VerifyCombinationOFItalicAndUnderlineFontStylesAboutEventField method");
	}
	

	//@Test(priority = 10, description = "Verify combination of Bold and Italic  Font styles for the About event field", groups = "sanity")
	@Description("Test case #10, Verify combination of Bold and Italic Font styles for the About event field")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #10, Verify combination of Bold and Italic Font styles for the About event field")
	public void VerifyCombinationOFBoldAndItalicFontStylesAboutEventField() {
		logger.info("Starting of VerifyCombinationOFBoldAndItalicFontStylesAboutEventField method"); 
		
        addEventPage.setAboutTheEvent(testDataProp.getProperty("about.the.Event"));
		
		addEventPage.clickonBoldAndItalicTextFormattingButton();
		Assert.assertTrue(this.addEventPage.isBoldItalicFontStylesDisplayed());
		
		logger.info("Ending of VerifyCombinationOFBoldAndItalicFontStylesAboutEventField method");
	}
	
	//@Test(priority = 11, description = "Verify Maximum Chars Validation In AboutTheEvent", groups = "sanity")
	@Description("Test case #11, Verify Maximum Chars Validation In AboutTheEvent")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #11, Verify Maximum Chars Validation In AboutTheEvent")
	public void VerifyMaximumCharsValidationInAboutTheEvent() {
		logger.info("Starting of VerifyMaximumCharsValidationInAboutTheEvent method"); 
		
		String aboutTheEventMaximumChars = RandomStringUtils.randomAlphabetic(4510);
		System.out.println("about max characters text: ***" + aboutTheEventMaximumChars);
		addEventPage.setAboutTheEvent(aboutTheEventMaximumChars);
			
		Assert.assertTrue(this.addEventNegativeFlow.isMaximumCharsValidationDisplayed());
		
		logger.info("Ending of VerifyMaximumCharsValidationInAboutTheEvent method");
	}
		
	   // @Test(priority = 12, description = "Verify Maximum Chars Validation In AboutTheEvent", groups = "sanity")
		@Description("Test case #12, Verify Maximum Chars Validation In AboutTheEvent")
		@Severity(SeverityLevel.NORMAL)
		@Story("Test case #12, Verify Maximum Chars Validation In AboutTheEvent")
		public void VerifyRemovelogoFunctionalityInEventInformationPage () {
			logger.info("Starting of VerifyRemovelogoFunctionalityInEventInformationPage method"); 
			
			addEventPage.uploadEventLogo(BASE_DIR + FILE_SEPARATOR + testDataProp.getProperty("edit.club.logo.path"));
			
			addEventNegativeFlow.clickonRemovelogoIcon();
			
			Assert.assertTrue(this.addEventPage.isDragandDropImageTextDispalyed());
			
			logger.info("Ending of VerifyRemovelogoFunctionalityInEventInformationPage method");
		}
		
	
	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.ADD_EVENT_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
