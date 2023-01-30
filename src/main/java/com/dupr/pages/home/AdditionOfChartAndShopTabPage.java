package com.dupr.pages.home;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class AdditionOfChartAndShopTabPage extends DUPRBaseAutomationPage {

	private static final Logger log = LogManager.getLogger(AdditionOfChartAndShopTabPage.class);

	@B2BFindBy(xpath = "//a[text()='Chart']")
	private WebElement mnuChart;

	@B2BFindBy(xpath = "//a[text()='Shop']")
	private WebElement mnuShop;

	@B2BFindBy(xpath = "//h2[text()='DUPR Performance Chart']")
	private WebElement txtChartTitle;

	@B2BFindBy(xpath = "//h2[text()='DUPR Shop']")
	private WebElement txtShopTitle;

	@B2BFindBy(xpath = "//p[text()='Pickleball’s Most Accurate Global Rating System']")
	private WebElement txtHomeTitle;

	public AdditionOfChartAndShopTabPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public void clickOnChartMenu() {
		log.info("Starting of clickOnChartMenu method");

		clickOnElement(mnuChart);
		this.hardWait(5);

		log.info("Ending of clickOnChartMenu method");
	}

	public boolean isChartTitleDisplayed() {
		log.info("Starting of isChartTitleDisplayed method");
		log.info("Ending of isChartTitleDisplayed method");

		return isDisplayed(txtChartTitle);
	}

	public void clickOnBrowserBackButton() {
		log.info("Starting of clickOnBrowserBackButton method");

		this.driver.navigate().back();

		log.info("Ending of clickOnBrowserBackButton method");
	}

	public void clickOnShopMenu() {
		log.info("Starting of clickOnShopMenu method");

		clickOnElement(mnuShop);
		this.hardWait(5);

		log.info("Ending of clickOnShopMenu method");
	}

	public boolean isShopTitleDisplayed() {
		log.info("Starting of isShopTitleDisplayed method");
		log.info("Ending of isShopTitleDisplayed method");

		return isDisplayed(txtShopTitle);
	}

	public String getHomeTitleDisplayed() {
		log.info("Starting of getHomeTitleDisplayed method");
		log.info("Ending of getHomeTitleDisplayed method");

		return driver.getTitle();
	}
}
