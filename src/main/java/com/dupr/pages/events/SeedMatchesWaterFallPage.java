package com.dupr.pages.events;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class SeedMatchesWaterFallPage extends DUPRBaseAutomationPage {
	private static final Logger log = LogManager.getLogger(SeedMatchesWaterFallPage.class);

	@B2BFindBy(xpath = "//button[text()='Seed Matches' and @disabled]")
	private WebElement btnSeedMatchesDisabled;

	@B2BFindBy(xpath = "//button[contains(text(),'View the Queue')]")
	private WebElement btnViewTheQueue;

	@B2BFindBy(xpath = "(//input[@type='number'])[3]")
	private WebElement txt2ndpointOfPlayerOne;

	@B2BFindBy(xpath = "(//input[@type='number'])[4]")
	private WebElement txt2ndpointOfPlayerTwo;

	@B2BFindBy(xpath = "(//input[@type='number'])[5]")
	private WebElement txt3rdpointOfPlayerOne;

	@B2BFindBy(xpath = "(//input[@type='number'])[6]")
	private WebElement txt3rdpointOfPlayerTwo;

	public SeedMatchesWaterFallPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public boolean isSeedMatchesButtonDisabled() {

		boolean isSeedMatchesDisabled = false;

		try {
			if (btnSeedMatchesDisabled.isDisplayed() == true) {

				isSeedMatchesDisabled = true;
			}
		} catch (Exception e) {
			isSeedMatchesDisabled = false;
		}

		return isSeedMatchesDisabled;

	}
}
