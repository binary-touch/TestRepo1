package com.b2b.test.sprint3.sanity;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.home.AdditionOfChartAndShopTabPage;
import com.dupr.test.DUPRBaseAutomationTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic(value = "Home")
@Feature(value = "Chart_Shop Sanity")
public class AdditionOfChartAndShopTabTest extends DUPRBaseAutomationTest {
	private static final Logger logger = Logger.getLogger(AdditionOfChartAndShopTabTest.class.getName());
	private AdditionOfChartAndShopTabPage chart_ShopPage = null;

	@BeforeClass
	@Parameters({ "siteURL" })
	public void initMethod(String siteURL) throws Exception {
		logger.info("Starting of initMethod in AdditionOfChartAndShopTabTest");

		this.driver = super.getWebDriver(WebDriversEnum.HOMEPAGE_EDITS_DRIVER);
		driver.get(siteURL);
		this.chart_ShopPage = new AdditionOfChartAndShopTabPage(this.driver);

		logger.info("Ending of initMethod in AdditionOfChartAndShopTabTest");
	}

	//@Test(priority = 1, description = "Verify the results on click of Chart Menu", groups = "sanity")
	@Description("Test case #1, Verify the results on click of Chart Menu")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify the results on click of Chart Menu")
	public void verifyChartMenuFunctionality() {
		logger.info("Starting of verifyChartMenuFunctionality method");

		chart_ShopPage.clickOnChartMenu();
		chart_ShopPage.hardWait(3);
		Assert.assertTrue(chart_ShopPage.isChartTitleDisplayed());
		
		Assert.assertTrue(driver.getCurrentUrl().equals(testDataProp.getProperty("chart.menu.url")));

		logger.info("Ending of verifyChartMenuFunctionality method");
	}

	//@Test(priority = 2, description = "Verify the results on click of browser back button on DUPR Performance Chart page", groups = "sanity")
	@Description("Test case #2, Verify the results on click of browser back button on DUPR Performance Chart page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify the results on click of browser back button on DUPR Performance Chart page")
	public void verifyBrowserBackFunctionalityOnChart() {
		logger.info("Starting of verifyBrowserBackFunctionalityOnChart method");

		chart_ShopPage.clickOnBrowserBackButton();
		chart_ShopPage.hardWait(3);
		Assert.assertEquals(chart_ShopPage.getHomeTitleDisplayed(), expectedAssertionsProp.getProperty("home.page.title"));

		logger.info("Ending of verifyBrowserBackFunctionalityOnChart method");
	}

	@Test(priority = 3, description = "Verify the results on click of Shop Menu", groups = "sanity")
	@Description("Test case #3, Verify the results on click of Shop Menu")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify the results on click of Shop Menu")
	public void verifyShopMenuFunctionality() {
		logger.info("Starting of verifyShopMenuFunctionality method");

		chart_ShopPage.clickOnShopMenu();
		chart_ShopPage.hardWait(3);
		Assert.assertTrue(chart_ShopPage.isShopTitleDisplayed());
	
		Assert.assertTrue(driver.getCurrentUrl().equals(testDataProp.getProperty("shop.menu.url")));

		logger.info("Ending of verifyShopMenuFunctionality method");
	}

	@Test(priority = 4, description = "Verify the results on click of browser back button on DUPR Shop page", groups = "sanity")
	@Description("Test case #4, Verify the results on click of browser back button on DUPR Sop page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify the results on click of browser back button on DUPR Shop page")
	public void verifyBrowserBackFunctionalityOnShop() {
		logger.info("Starting of verifyBrowserBackFunctionalityOnShop method");

		chart_ShopPage.clickOnBrowserBackButton();
		chart_ShopPage.hardWait(3);
		Assert.assertEquals(chart_ShopPage.getHomeTitleDisplayed(), expectedAssertionsProp.getProperty("home.page.title"));

		logger.info("Ending of verifyBrowserBackFunctionalityOnShop method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.HOMEPAGE_EDITS_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}
}
