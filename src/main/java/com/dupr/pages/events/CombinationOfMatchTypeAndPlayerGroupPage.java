package com.dupr.pages.events;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class CombinationOfMatchTypeAndPlayerGroupPage extends DUPRBaseAutomationPage {
	private static final Logger log = LogManager.getLogger(CombinationOfMatchTypeAndPlayerGroupPage.class);

	@B2BFindBy(xpath = "//p[text()='Please select different match type']")
	private WebElement msgPlayerGroupWithSingleAndMixed;

	@B2BFindBy(xpath = "//h4[contains(text(),'OPEN SINGLES')]")
	private WebElement lblOPenSingles;

	@B2BFindBy(xpath = "//h4[contains(text(),'MEN SINGLES')]")
	private WebElement lblMenSingles;

	@B2BFindBy(xpath = "//h4[contains(text(),'WOMEN SINGLES')]")
	private WebElement lblWomenSingles;

	@B2BFindBy(xpath = "//h4[contains(text(),'MIXED DOUBLES')]")
	private WebElement lblDoublesMixed;

	@B2BFindBy(xpath = "//h4[contains(text(),'OPEN DOUBLES')]")
	private WebElement lblDoublesOpen;

	@B2BFindBy(xpath = "//h4[contains(text(),'MEN DOUBLES')]")
	private WebElement lblDoublesMen;

	@B2BFindBy(xpath = "//h4[contains(text(),'WOMEN DOUBLES')]")
	private WebElement lblDoublesWomen;

	public CombinationOfMatchTypeAndPlayerGroupPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public boolean isPlayerGroupWithSingleAndMixedDisplayed() {
		log.info("Starting of isClubMemberYesRadioButtonSelected method");
		log.info("Ending of isClubMemberYesRadioButtonSelected method");

		return msgPlayerGroupWithSingleAndMixed.isDisplayed();
	}

	public boolean isOpenSinglesCardDisplayed() {
		log.info("Starting of isOpenSinglesCardDisplayed method");
		log.info("Ending of isOpenSinglesCardDisplayed method");

		return lblOPenSingles.isDisplayed();
	}

	public boolean isMenSinglesCardDisplayed() {
		log.info("Starting of isMenSinglesCardDisplayed method");
		log.info("Ending of isMenSinglesCardDisplayed method");

		return lblMenSingles.isDisplayed();
	}

	public boolean isWomenSinglesCardDisplayed() {
		log.info("Starting of isWomenSinglesCardDisplayed method");
		log.info("Ending of isWomenSinglesCardDisplayed method");

		return lblWomenSingles.isDisplayed();
	}

	public boolean isDoublesMixedCardDisplayed() {
		log.info("Starting of isDoublesMixedCardDisplayed method");
		log.info("Ending of isDoublesMixedCardDisplayed method");

		return lblDoublesMixed.isDisplayed();
	}

	public boolean isDoublesOpenCardDisplayed() {
		log.info("Starting of isDoublesOpenCardDisplayed method");
		log.info("Ending of isDoublesOpenCardDisplayed method");

		return lblDoublesOpen.isDisplayed();
	}

	public boolean isDoublesMenCardDisplayed() {
		log.info("Starting of isOpenSinglesCardDisplayed method");
		log.info("Ending of isOpenSinglesCardDisplayed method");

		return lblDoublesMen.isDisplayed();
	}

	public boolean isDoublesWomenCardDisplayed() {
		log.info("Starting of isDoublesWomenCardDisplayed method");
		log.info("Ending of isDoublesWomenCardDisplayed method");

		return lblDoublesWomen.isDisplayed();
	}
}
