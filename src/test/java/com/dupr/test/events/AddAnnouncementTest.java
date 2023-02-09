package com.dupr.test.events;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.clubs.ClubLogoPage;
import com.dupr.pages.events.AddAnnouncementPage;
import com.dupr.pages.events.BrowseEventsPage;
import com.dupr.pages.events.EndEventPage;
import com.dupr.test.DUPRBaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic(value = "Events")
@Feature(value = "Add Announcement")
public class AddAnnouncementTest extends DUPRBaseAutomationTest {

	private static final Logger logger = Logger.getLogger(AddAnnouncementTest.class.getName());
	private ClubLogoPage clubLogoPage = null;
	private BrowseEventsPage browseEventsPage = null;
	private EndEventPage endEventpage = null;
	private AddAnnouncementPage addAnnouncementPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String directorEmail, String directorPassword)
			throws Exception {
		logger.info("Starting of initMethod in AddAnnouncementTest");

		this.driver = super.getWebDriver(WebDriversEnum.ADD_ANNOUNCEMENT_DRIVER);
		this.siteLogin(siteURL, directorEmail, directorPassword, this.driver);

		this.clubLogoPage = new ClubLogoPage(this.driver);
		this.browseEventsPage = new BrowseEventsPage(this.driver);
		this.endEventpage = new EndEventPage(this.driver);
		this.addAnnouncementPage = new AddAnnouncementPage(this.driver);

		logger.info("Ending of initMethod in AddAnnouncementTest");
	}

	@Test(priority = 1, description = "Verify Add Announcement functionality", groups = "sanity")
	@Description("Test case #1, Verify Add Announcement functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Add Announcement functionality")
	public void verifyAddAnnouncementFunctionality() {
		logger.info("Starting of verifyAddAnnouncementFunctionality method");

		clubLogoPage.hardWait(3);
		browseEventsPage.clickOnMyEventButton();
		clubLogoPage.hardWait(3);
		addAnnouncementPage.clickOnEventLabel();
		endEventpage.hardWait(2);

		Assert.assertTrue(addAnnouncementPage.isSendAnnouncementPageContains());
		Assert.assertEquals(addAnnouncementPage.getSubjectText(), expectedAssertionsProp.getProperty("subject.txt"));
		Assert.assertEquals(addAnnouncementPage.getSendAnnouncementText(),
				expectedAssertionsProp.getProperty("announcement.txt"));
		Assert.assertTrue(addAnnouncementPage.isTitleFieldEmpty());
		Assert.assertTrue(addAnnouncementPage.isDescriptionFieldEmpty());
		Assert.assertTrue(addAnnouncementPage.isSendButtonEnabled());

		logger.info("Ending of verifyAddAnnouncementFunctionality method");
	}

	@Test(priority = 2, description = "Verify Back button functionality in Send An Announcement page", groups = "sanity")
	@Description("Test case #2, Verify Back Button functionality in Send An Announcement")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify Back Button functionality")
	public void verifyBackButtonFunctionality() {
		logger.info("Starting of verifyBackButtonFunctionality method");

		addAnnouncementPage.clickOnBackButton();
		endEventpage.hardWait(2);
		Assert.assertEquals(endEventpage.getEventTxt(), expectedAssertionsProp.getProperty("event.txt"));

		logger.info("Ending of verifyBackButtonFunctionality method");
	}

	@Test(priority = 3, description = "Verify the results on click of browser back button ", groups = "sanity")
	@Description("Test case #3, Verify the results on click of browser back button ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify Browser Back button")
	public void verifyBrowserBackFunctionality() {
		logger.info("Starting of verifyBrowserBackFunctionality method");

		addAnnouncementPage.clickOnAddAnnouncementButton();
		endEventpage.hardWait(2);
		addAnnouncementPage.clickOnBrowserBackButton();
		Assert.assertEquals(endEventpage.getEventTxt(), expectedAssertionsProp.getProperty("event.txt"));

		logger.info("Ending of verifyBrowserBackFunctionality method");
	}

	@Test(priority = 4, description = "Verify the validation message of the description field with less than 10 characters ", groups = "sanity")
	@Description("Test case #4, Verify the validation message of the description field with less than 10 characters ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify Validation message of description")
	public void verifyMinimumCharsValidationOfDescriptionField() {
		logger.info("Starting of verifyMinimumCharsValidationOfDescriptionField method");

		addAnnouncementPage.clickOnAddAnnouncementButton();
		endEventpage.hardWait(2);
		addAnnouncementPage.setDescription(testDataProp.getProperty("primary.location"));
		addAnnouncementPage.clickOnSendButton();
		endEventpage.hardWait(2);

		Assert.assertEquals(addAnnouncementPage.getMinimumCharactersTxt(),
				expectedAssertionsProp.getProperty("description.validation.txt"));

		Assert.assertEquals(addAnnouncementPage.getSendAnnouncementText(),
				expectedAssertionsProp.getProperty("announcement.txt"));

		logger.info("Ending of verifyMinimumCharsValidationOfDescriptionField method");
	}

	@Test(priority = 5, description = "Verify the send button state, if the user enters more than 10 characters in the description field", groups = "sanity")
	@Description("Test case #5, Verify the send button state, if the user enters more than 10 characters in the description field ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify Save Button State")
	public void verifyTheStateOfSaveButtonAfterFillingMandatoryDetails() {
		logger.info("Starting of verifyTheStateOfSaveButtonAfterFillingMandatoryDetails method");

		addAnnouncementPage.setDescription(testDataProp.getProperty("announcement.txt"));

		endEventpage.hardWait(2);
		Assert.assertFalse(addAnnouncementPage.isMinimumCharactersText());
		endEventpage.hardWait(2);

		Assert.assertTrue(addAnnouncementPage.isSendButtonEnabled());

		Assert.assertEquals(addAnnouncementPage.getSendAnnouncementText(),
				expectedAssertionsProp.getProperty("announcement.txt"));

		logger.info("Ending of verifyTheStateOfSaveButtonAfterFillingMandatoryDetails method");
	}

	@Test(priority = 6, description = "Verify the validation message of the subject field with an empty field ", groups = "sanity")
	@Description("Test case #6, Verify the validation message of the subject field with an empty field ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, verify Validation Of Title")
	public void verifyValidationOfTitle() {
		logger.info("Starting of verifyValidationOfTitle method");

		addAnnouncementPage.setDescription(testDataProp.getProperty("announcement.txt"));
		addAnnouncementPage.clickOnSendButton();
		endEventpage.hardWait(2);

		Assert.assertEquals(addAnnouncementPage.getValidationOfTitleTxt(),
				expectedAssertionsProp.getProperty("title.validation.txt"));

		Assert.assertEquals(addAnnouncementPage.getSendAnnouncementText(),
				expectedAssertionsProp.getProperty("announcement.txt"));

		logger.info("Ending of verifyValidationOfTitle method");
	}

	@Test(priority = 7, description = "Verify Formating of Font styles for the Subject Description field", groups = "sanity")
	@Description("Test case #7, Verify Formating of Font styles for the Subject Description field")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Verify Formating of Font styles for the Subject Description field")
	public void verifySubjectDescriptionFieldWithBoldItalicUnderlineStyles() {
		logger.info("Starting of verifySubjectDescriptionFieldWithBoldItalicUnderlineStyles method");

		addAnnouncementPage.setDescription(testDataProp.getProperty("announcement.txt"));
		addAnnouncementPage.clickOnTextFormattingButtons();

		Assert.assertTrue(this.addAnnouncementPage.isBoldItalicUnderlineFontStylesDisplayed());

		logger.info("Ending of verifySubjectDescriptionFieldWithBoldItalicUnderlineStyles method");
	}

	@Test(priority = 8, description = "Verify Font styles for the SubjectDescription field", groups = "sanity")
	@Description("Test case #8, Verify Font styles for the Subject Description field")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Verify Font styles for the Subject Description field")
	public void verifySubjectDescriptionFieldWithAllFontStyles() {
		logger.info("Starting of verifySubjectDescriptionFieldWithAllFontStyles method");

		addAnnouncementPage.setDescription(testDataProp.getProperty("announcement.txt"));

		addAnnouncementPage.clickOnBoldTextFormattingButton();
		Assert.assertTrue(this.addAnnouncementPage.isBoldFontStyleDisplayed());

		addAnnouncementPage.clickOnBoldTextFormattingButton();

		addAnnouncementPage.clickOnItalicTextFormattingButton();
		Assert.assertTrue(this.addAnnouncementPage.isItalicFontStyleDisplayed());

		addAnnouncementPage.clickOnItalicTextFormattingButton();

		addAnnouncementPage.clickOnUnderLineTextFormattingButton();
		Assert.assertTrue(this.addAnnouncementPage.isUnderlineFontStyleDisplayed());

		addAnnouncementPage.clickOnUnderLineTextFormattingButton();

		logger.info("Ending of verifySubjectDescriptionFieldWithAllFontStyles method");
	}

	@Test(priority = 9, description = "Verify combination of Bold and Underline Font styles for the Subject Description field", groups = "sanity")
	@Description("Test case #9, Verify combination of Bold and Underline Font styles for the Subject Description field")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9, Verify combination of Bold and Underline Font styles for the Subject Description field")
	public void VerifySubjectDescFieldWithCombinationOfBoldAndUnderlineFontStyles() {
		logger.info("Starting of VerifySubjectDescFieldWithCombinationOfBoldAndUnderlineFontStyles method");

		addAnnouncementPage.setDescription(testDataProp.getProperty("announcement.txt"));
		addAnnouncementPage.clickOnBoldAndUnderLineTextFormattingButton();

		Assert.assertTrue(this.addAnnouncementPage.isBoldUnderlineFontStylesDisplayed());

		logger.info("Ending of VerifySubjectDescFieldWithCombinationOfBoldAndUnderlineFontStyles method");
	}

	@Test(priority = 10, description = "Verify combination of Italic and Underline  Font styles for the Subject Description field", groups = "sanity")
	@Description("Test case #10, Verify combination of Italic and Underline Font styles for the Subject Description field")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #10, Verify combination of Italic and Underline Font styles for the Subject Description field")
	public void VerifySubjectDescFieldWithCombinationOfItalicAndUnderlineFontStyles() {
		logger.info("Starting of VerifySubjectDescFieldWithCombinationOfItalicAndUnderlineFontStyles method");

		addAnnouncementPage.setDescription(testDataProp.getProperty("announcement.txt"));
		addAnnouncementPage.clickOnItalicAndUnderLineTextFormattingButton();

		Assert.assertTrue(this.addAnnouncementPage.isItalicUnderlineFontStylesDisplayed());

		logger.info("Ending of VerifySubjectDescFieldWithCombinationOfItalicAndUnderlineFontStyles method");
	}

	@Test(priority = 11, description = "Verify combination of Bold and Italic Font styles for the Subject Description field", groups = "sanity")
	@Description("Test case #11, Verify combination of Bold and Italic Font styles for the Subject Description field")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #11, Verify combination of Bold and Italic Font styles for the Subject Description field")
	public void VerifySubjectDescFieldWithCombinationOfBoldAndItalicFontStyles() {
		logger.info("Starting of VerifySubjectDescFieldWithCombinationOfBoldAndItalicFontStyles method");

		addAnnouncementPage.setDescription(testDataProp.getProperty("announcement.txt"));
		addAnnouncementPage.clickOnBoldAndItalicTextFormattingButton();

		Assert.assertTrue(this.addAnnouncementPage.isBoldItalicFontStylesDisplayed());

		logger.info("Ending of VerifySubjectDescFieldWithCombinationOfBoldAndItalicFontStyles method");
	}

	@Test(priority = 12, description = "Verify the results on click of send button", groups = "sanity")
	@Description("Test case #12, Verify the results on click of send button ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #12, Verify Save Button Functionality")
	public void verifySendButtonFunctionality() {
		logger.info("Starting of verifySaveButtonFunctionality method");

		addAnnouncementPage.setDescription(testDataProp.getProperty("announcement.txt"));
		addAnnouncementPage.setTitle(testDataProp.getProperty("title.txt"));
		addAnnouncementPage.clickOnSendButton();

		Assert.assertTrue(addAnnouncementPage.isEventAnnouncementPopUpContains());

		Assert.assertEquals(addAnnouncementPage.getEventAnnouncementText(),
				expectedAssertionsProp.getProperty("event.announcement.txt"));

		Assert.assertEquals(addAnnouncementPage.getCongratulationsText(),
				expectedAssertionsProp.getProperty("congratulations.txt"));

		Assert.assertEquals(addAnnouncementPage.getEventCreatedText(),
				expectedAssertionsProp.getProperty("event.created.txt"));

		logger.info("Ending of verifySaveButtonFunctionality method");
	}

	@Test(priority = 13, description = "Verify the results on click of close icon", groups = "sanity")
	@Description("Test case #13, Verify the results on click of close icon")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #13, Verify Close Icon Functionality")
	public void verifyCloseIconFunctionality() {
		logger.info("Starting of verifyCloseIconFunctionality method");

		addAnnouncementPage.clickOnCloseIcon();
		addAnnouncementPage.hardWait(3);

		Assert.assertEquals(endEventpage.getEventTxt(), expectedAssertionsProp.getProperty("event.txt"));

		logger.info("Ending of verifyCloseIconFunctionality method");
	}

	@Test(priority = 14, description = "Verify the edit Button is displayed for only the latest announcement", groups = "sanity")
	@Description("Test case #14, Verify the edit Button is displayed for only the latest announcement")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #14, Verify the edit Button")
	public void verifyEditButton() {
		logger.info("Starting of verifyEditButton method");

		addAnnouncementPage.clickOnAnnouncementsTab();

		Assert.assertTrue(addAnnouncementPage.isAnnouncementCardContains());
		Assert.assertTrue(addAnnouncementPage.isEditButtonListDisplayed());

		logger.info("Ending of verifyEditButton method");
	}

	@Test(priority = 15, description = "Verify the edit button Functionality", groups = "sanity")
	@Description("Test case #15, Verify the edit button Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #15, Verify the edit button Functionality")
	public void verifyEditButtonFunctionality() {
		logger.info("Starting of verifyCloseIconFunctionality method");

		addAnnouncementPage.clickOnEditBuuton();
		addAnnouncementPage.hardWait(3);

		Assert.assertTrue(addAnnouncementPage.isSendAnnouncementPageContains());
		Assert.assertTrue(addAnnouncementPage.isSendButtonEnabled());

		logger.info("Ending of verifyCloseIconFunctionality method");
	}

	@Test(priority = 16, description = "Verify the result of Subject title field by entering new data", groups = "sanity")
	@Description("Test case #16, Verify the result of Subject title field by entering new data")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #16, Verify the SUbject tittle Functionality")
	public void verifyTitleFieldFunctionality() {
		logger.info("Starting of verifyTitleFieldFunctionality method");

		addAnnouncementPage.setTitle(testDataProp.getProperty("title.txt"));
		Assert.assertTrue(addAnnouncementPage.isSendButtonEnabled());

		logger.info("Ending of verifyTitleFieldFunctionality method");
	}

	@Test(priority = 17, description = "Verify the result of Subject Description field by entering new data", groups = "sanity")
	@Description("Test case #17, Verify the result of Subject Description field by entering new data")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #17, Verify the SUbject Description Functionality")
	public void verifyDescriptionFieldFunctionality() {
		logger.info("Starting of verifyDescriptionFieldFunctionality method");

		addAnnouncementPage.setDescription(testDataProp.getProperty("edit.description.txt"));
		Assert.assertTrue(addAnnouncementPage.isSendButtonEnabled());

		logger.info("Ending of verifyDescriptionFieldFunctionality method");
	}

	@Test(priority = 18, description = "Verify Send Functionality", groups = "sanity")
	@Description("Test case #18, Verify Send Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #18, Verify Send Functionality")
	public void verifySendFunctionality() {
		logger.info("Starting of verifySendButtonFunctionality method");

		addAnnouncementPage.clickOnSendButton();
		Assert.assertTrue(addAnnouncementPage.isEventAnnouncementPopUpContains());

		Assert.assertEquals(addAnnouncementPage.getEventAnnouncementText(),
				expectedAssertionsProp.getProperty("event.announcement.txt"));

		Assert.assertEquals(addAnnouncementPage.getCongratulationsText(),
				expectedAssertionsProp.getProperty("congratulations.txt"));

		Assert.assertEquals(addAnnouncementPage.getEventCreatedText(),
				expectedAssertionsProp.getProperty("event.updated.txt"));

		logger.info("Ending of verifySendButtonFunctionality method");
	}

	@Test(priority = 19, description = "Verify the results on click of close icon", groups = "sanity")
	@Description("Test case #19, Verify the result of Subject Description field by entering new data")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #19, Verify the SUbject Description Functionality")
	public void verifyCloseButtonFunctionality() {
		logger.info("Starting of verifyCloseButtonFunctionality method");

		addAnnouncementPage.clickOnCloseIcon();
		addAnnouncementPage.hardWait(3);

		Assert.assertEquals(endEventpage.getEventTxt(), expectedAssertionsProp.getProperty("event.txt"));

		logger.info("Ending of verifyCloseButtonFunctionality method");
	}

	@AfterClass
	public void quitDriver() {
		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.ADD_ANNOUNCEMENT_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}
}
