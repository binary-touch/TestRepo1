package com.dupr.test.events;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.events.EditOrRemovePartnerPage;
import com.dupr.pages.home.AntiScrappingCaptchaPage;
import com.dupr.test.CommonBaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic(value = "Brackets")
@Feature(value = "Edit or Remove Partner")
public class EditOrRemovePartnerTest extends CommonBaseTest {

	private static final Logger logger = Logger.getLogger(EditOrRemovePartnerTest.class.getName());
	private EditOrRemovePartnerPage editOrRemovePartnerPage = null;
	private AntiScrappingCaptchaPage antiScrappingCaptchaPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String directorEmail, String directorPassword)
			throws Exception {
		logger.info("Starting of initMethod in EditOrRemovePartnerTest");

		this.driver = super.getWebDriver(WebDriversEnum.EDIT_OR_REMOVE_PARTNER_DRIVER);
		super.initCommonBaseTest(siteURL, directorEmail, directorPassword);

		this.editOrRemovePartnerPage = new EditOrRemovePartnerPage(this.driver);
		this.antiScrappingCaptchaPage = new AntiScrappingCaptchaPage(this.driver);

		logger.info("Ending of initMethod in EditOrRemovePartnerTest");
	}

	@Test(priority = 1, description = "Verify Kebab Menu Functionality In Brackets page", groups = "sanity")
	@Description("Test case #1, Verify Kebab Menu Functionality In Brackets page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Kebab Menu Functionality In Brackets page")
	public void verifyKebabMenuFunctionalityInBracketsPage() {
		logger.info("Starting of verifyKebabMenuFunctionalityInBracketsPage method");

		editOrRemovePartnerPage.clickOnMyBracketsLabel();
		Assert.assertEquals(editOrRemovePartnerPage.getBracketsLabel(),
				expectedAssertionsProp.getProperty("brackets.text"));
		Assert.assertEquals(editOrRemovePartnerPage.getBrowseBracketsLabel(),
				expectedAssertionsProp.getProperty("browse.brackets.text"));

		editOrRemovePartnerPage.clickOnBracketKebabMenu();
		try {
			editOrRemovePartnerPage.hardWait(3);
			Assert.assertEquals(editOrRemovePartnerPage.getAddPartnerLabel(),
					expectedAssertionsProp.getProperty("add.partner.text"));
		} catch (Exception e) {
			Assert.assertEquals(editOrRemovePartnerPage.getEditPartnerLabel(),
					expectedAssertionsProp.getProperty("edit.partner.text"));
			Assert.assertEquals(editOrRemovePartnerPage.getRemovePartnerLabel(),
					expectedAssertionsProp.getProperty("remove.partner.text"));
		}
		logger.info("Ending of verifyKebabMenuFunctionalityInBracketsPage method");
	}

	@Test(priority = 2, description = "Verify details displayed in Bracket Page with Partner Pending Status", groups = "sanity")
	@Description("Test case #2, Verify details displayed in Bracket Page with Partner Pending Status")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify details displayed in Bracket Page with Partner Pending Status")
	public void verifyDetailsDisplayedInBracketPageWithPartnerPendingStatus() {
		logger.info("Starting of verifyDetailsDisplayedInBracketPageWithPartnerPendingStatus method");

		try {
			if (editOrRemovePartnerPage.isPartnerPendingLabelDisplayed()) {
				editOrRemovePartnerPage.clickOnPartnerPendingBracketCard();
			}
		} catch (Exception e) {
			editOrRemovePartnerPage.clickOnBracketKebabMenu();

			if (antiScrappingCaptchaPage.isAddPartnerDisplayedInBracketsPage()) {
				antiScrappingCaptchaPage.clickOnAddPartnerFromKebabMenu();

				Assert.assertTrue(antiScrappingCaptchaPage.isAntiScrappingCaptchaDisplayed());

				antiScrappingCaptchaPage.clickOnAddPartnerRadioButton();
				antiScrappingCaptchaPage.clickOnAddAPartnerButton();
				antiScrappingCaptchaPage.hardWait(3);
				editOrRemovePartnerPage.clickOnPartnerPendingBracketCard();
			}
		}
		Assert.assertEquals(editOrRemovePartnerPage.getBracketLabel(),
				expectedAssertionsProp.getProperty("bracket.text"));

		Assert.assertTrue(editOrRemovePartnerPage.isBracketPageContains());

		logger.info("Ending of verifyDetailsDisplayedInBracketPageWithPartnerPendingStatus method");
	}

	@Test(priority = 3, description = "Verify Edit Partner functionality in Bracket Page", groups = "sanity")
	@Description("Test case #3, Verify Edit Partner functionality in Bracket Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify Edit Partner functionality in Bracket Page")
	public void verifyEditPartnerFunctionalityInBracketPage() {
		logger.info("Starting of verifyEditPartnerFunctionalityInBracketPage method");

		editOrRemovePartnerPage.clickOnEditPartnerButton();

		Assert.assertEquals(editOrRemovePartnerPage.getAddAPartnerLabel(),
				expectedAssertionsProp.getProperty("add.a.partner.text"));

		Assert.assertTrue(editOrRemovePartnerPage.isAddAPartnerPageContains());

		logger.info("Ending of verifyEditPartnerFunctionalityInBracketPage method");
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
		editOrRemovePartnerPage.implicitWait();
		editOrRemovePartnerPage.searchPartner(testDataProp.getProperty("player.name.txt"));

		Assert.assertTrue(editOrRemovePartnerPage.isValidPartnerDisplayed(testDataProp.getProperty("player.name.txt")));

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

	@Test(priority = 9, description = "Verify the results on click of Remove Partner button on the Bracket Card", groups = "sanity")
	@Description("Test case #9, Verify the results on click of Remove Partner button on the Bracket Card")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9, Verify the results on click of Remove Partner button on the Bracket Card")
	public void verifyRemovePartnerFunctionality() {
		logger.info("Starting of verifyRemovePartnerFunctionality method");

		editOrRemovePartnerPage.clickOnRemovePartnerButton();
		editOrRemovePartnerPage.hardWait(3);
		Assert.assertTrue(editOrRemovePartnerPage.isBracketPageContainsAfterRemovingPartner());

		logger.info("Ending of verifyRemovePartnerFunctionality method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.EDIT_OR_REMOVE_PARTNER_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}
}
