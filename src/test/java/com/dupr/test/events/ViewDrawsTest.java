package com.dupr.test.events;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.events.ViewDrawsPage;
import com.dupr.test.DUPRBaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class ViewDrawsTest extends DUPRBaseAutomationTest {

	private static final Logger logger = Logger.getLogger(ViewDrawsTest.class.getName());

	private ViewDrawsPage viewdrawsPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String directorEmail, String directorPassword) throws Exception {
		logger.info("Starting of initMethod method in ViewDrawsTest");

		this.driver = super.getWebDriver(WebDriversEnum.VIEW_DRAWS_DRIVER);
		this.siteLogin(siteURL, directorEmail, directorPassword, this.driver);
		this.viewdrawsPage = new ViewDrawsPage(this.driver);

		logger.info("Ending of initMethod method in ViewDrawsTest");
	}

	@Test(priority = 1, description = "Verify View Draws Button Functionality", groups = "sanity")
	@Description("Test case #1, Verify View Draws Button Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify View Draws Button Functionality")
	public void verifyViewDrawsButtonFunctionality() {
		logger.info("Starting of verifyViewDrawsButtonFunctionality method");

		viewdrawsPage.clickOnViewDrawsButton();
		Assert.assertEquals(viewdrawsPage.getHavingTroubleText(),
				expectedAssertionsProp.getProperty("having.trouble.text"));

		logger.info("Ending of verifyViewDrawsButtonFunctionality method");
	}

	@Test(priority = 2, description = "Verify the results on click of Having trouble button", groups = "sanity")
	@Description("Test case #2, Verify the results on click of Having trouble button")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify the results on click of Having trouble button")
	public void verifyHavingTroubleOptionFunctionality() {
		logger.info("Starting of verifyHavingTroubleOptionFunctionality method");

		viewdrawsPage.clickOnHavingTroubleButton();

		Assert.assertEquals(viewdrawsPage.getHavingWiFiProblemText(), expectedAssertionsProp.get("wifi.problem.text"));

		logger.info("Ending of verifyHavingTroubleOptionFunctionality method");
	}

	@Test(priority = 3, description = "Verify the details displayed in Having WiFi problems Popup", groups = "sanity")
	@Description("Test case #3, Verify the details displayed in Having WiFi problems Popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify the details displayed in Having WiFi problems Popup")
	public void verifyTheDetailsDisplayedInHavingWiFiProblemPopUp() {
		logger.info("Starting of verifyTheDetailsDisplayedInHavingWiFiProblemPopUp method");

		Assert.assertEquals(viewdrawsPage.getClickHereText(), expectedAssertionsProp.getProperty("click.here.text"));
		Assert.assertEquals(viewdrawsPage.getDownloadDiagramText(),
				expectedAssertionsProp.getProperty("download.diagram.text"));
		Assert.assertEquals(viewdrawsPage.getOkText(), expectedAssertionsProp.getProperty("ok.text"));
		Assert.assertTrue(viewdrawsPage.isCloseIconDisplayed());

		logger.info("Ending of verifyTheDetailsDisplayedInHavingWiFiProblemPopUp method");
	}

	@Test(priority = 4, description = "Verify Click Here Link Functionality in Having WiFi Problems Popup", groups = "sanity")
	@Description("Test case #4, Verify Click Here Link Functionality in Having WiFi Problems Popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify Click Here Link Functionality in Having WiFi Problems Popup")
	public void verifyClickHereLinkFunctionalityInHavingWiFiProblemsPopup() {
		logger.info("Starting of verifyClickHereLinkFunctionalityInHavingWiFiProblemsPopup method");

		viewdrawsPage.clickOnClickHereLink();
		viewdrawsPage.switchToNewWindow();

		Assert.assertTrue(driver.getCurrentUrl().contains("Waterfall+Diagram.pdf"));
		viewdrawsPage.closeWindow();

		logger.info("Ending of verifyClickHereLinkFunctionalityInHavingWiFiProblemsPopup method");
	}

	@Test(priority = 5, description = "Verify Close Icon Functionality in Having WiFi Problems Popup", groups = "sanity")
	@Description("Test case #5, Verify Close Icon Functionality in Having WiFi Problems Popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify Close Icon Functionality in Having WiFi Problems Popup")
	public void verifyCloseIconFunctionalityInHavingWiFiProblemsPopup() {
		logger.info("Starting of verifyCloseIconFunctionalityInHavingWiFiProblemsPopup method");

		viewdrawsPage.clickOnCloseIcon();
		viewdrawsPage.hardWait(3);
		Assert.assertFalse(viewdrawsPage.isHavingWiFiProblemLabelDisplayed());

		logger.info("Ending of verifyCloseIconFunctionalityInHavingWiFiProblemsPopup method");
	}

	@Test(priority = 6, description = "Verify Ok Button Functionality in Having WiFi Problems Popup", groups = "sanity")
	@Description("Test case #6, Verify Ok Button Functionality in Having WiFi Problems Popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify Ok Button Functionality in Having WiFi Problems Popup")
	public void verifOkButtonFunctionalityInHavingWiFiProblemsPopup() {
		logger.info("Starting of verifOkButtonFunctionalityInHavingWiFiProblemsPopup method");

		viewdrawsPage.clickOnHavingTroubleButton();
		viewdrawsPage.clickOnOkButton();
		viewdrawsPage.hardWait(2);
		Assert.assertFalse(viewdrawsPage.isHavingWiFiProblemLabelDisplayed());
		Assert.assertTrue(viewdrawsPage.isHavingTroubleButtonDisplayed());

		logger.info("Ending of verifOkButtonFunctionalityInHavingWiFiProblemsPopup method");
	}

	@Test(priority = 7, description = "Verify Download Diagram Functionality in Having WiFi Problems Popup", groups = "sanity")
	@Description("Test case #7, Verify Download Diagram Functionality in Having WiFi Problems Popup")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Verify Download Diagram Functionality in Having WiFi Problems Popup")
	public void verifyDownloadDiagramFunctionalityInHavingWiFiProblemsPopup() {
		logger.info("Starting of verifyDownloadDiagramFunctionalityInHavingWiFiProblemsPopup method");

		viewdrawsPage.clickOnHavingTroubleButton();
		viewdrawsPage.clickOnDownloadDiagramButton();
		viewdrawsPage.switchToNewWindow();
		Assert.assertTrue(driver.getCurrentUrl().contains("Waterfall+Diagram.pdf"));

		logger.info("Ending of verifyDownloadDiagramFunctionalityInHavingWiFiProblemsPopup method");

	}

	@Test(priority = 8, description = "Verify Having Trouble button Is Displayed On VB Diagram", groups = "sanity")
	@Description("Test case #8, Verify Having Trouble button Is Displayed On VB Diagram")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Verify Having Trouble button Is Displayed On VB Diagram")
	public void verifyHavingTroubleButtonIsDisplayedOnVBDiagram() {
		logger.info("Starting of verifyHavingTroubleButtonIsDisplayedOnVBDiagram method");

		viewdrawsPage.hardWait(2);
		Assert.assertFalse(viewdrawsPage.isHavingTroubleButtonDisplayed());
		viewdrawsPage.closeWindow();

		logger.info("Ending of verifyHavingTroubleButtonIsDisplayedOnVBDiagram method");
	}

	@Test(priority = 9, description = "Verify Whether Having Trouble Button Is Clickable", groups = "sanity")
	@Description("Test case #9, Verify Whether Having Trouble Button Is Clickable")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9,Verify Whether Having Trouble Button Is Clickable")
	public void verifyWhetherHavingTroubleButtonIsClickable() {
		logger.info("Starting of verifyWhetherHavingTroubleButtonIsClickable method");

		viewdrawsPage.hardWait(2);
		viewdrawsPage.clickOnHavingTroubleForMultipleTimes();
		Assert.assertTrue(viewdrawsPage.isHavingTroubleButtonIsClickable());

		logger.info("Ending of verifyWhetherHavingTroubleButtonIsClickable method");
	}

	@Test(priority = 10, description = "Verify Whether Download Diagram Button Is Clickable", groups = "sanity")
	@Description("Test case #10, Verify Whether Download Diagram Button Is Clickable")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #10, Verify Whether Download Diagram Button Is Clickable")
	public void verifyWhetherDownloadDiagramButtonIsClickable() {
		logger.info("Starting of verifyWhetherDownloadDiagramButtonIsClickable method");

		viewdrawsPage.hardWait(2);
		viewdrawsPage.clickOnHavingTroubleButton();
		viewdrawsPage.clickOnDownloadDiagramButton();
		Assert.assertTrue(viewdrawsPage.isDownloadDiagramButtonIsClickable());

		logger.info("Ending of verifyWhetherDownloadDiagramButtonIsClickable method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.VIEW_DRAWS_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
