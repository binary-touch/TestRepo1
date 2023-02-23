package com.dupr.pages.events;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class FullRegistrationPage extends DUPRBaseAutomationPage {
	private static final Logger log = LogManager.getLogger(AddEventPage.class);

	@B2BFindBy(xpath = "//p[text()='Maximum 100 teams can join the bracket.']")
	private WebElement msgNumberOfTeamsFullValidation;

	@B2BFindBy(xpath = "//p[text()='Maximum 50 teams can join the waitlist']")
	private WebElement msgWaitlistFullValidation;

	@B2BFindBy(xpath = "//h4[contains(text(),'MIXED DOUBLES')]")
	private WebElement lblDoublesMixed;

	@B2BFindBy(xpath = "//button[text()='Unmatched Players']")
	private WebElement tabUnmatchedPlayers;

	@B2BFindBy(xpath = "//h4[contains(text(),'OPEN SINGLES')]")
	private WebElement lblOpenSingles;

	@B2BFindBy(xpath = "//button[text()='Register']")
	private WebElement btnRegister;

	@B2BFindBy(xpath = "//h3[contains(text(),'Event Registration')]")
	private WebElement lblEventRegistration;

	@B2BFindBy(xpath = "//span[@aria-disabled='true']")
	private WebElement chkSelectBracketDisabled;

	@B2BFindBy(xpath = "//h6[contains(text(),'*Registration Full')]")
	private WebElement msgRegistrationFull;

	@B2BFindBy(xpath = "//button[contains(text(),'Register') and @disabled]")
	private WebElement btnRegisterDisabled;

	@B2BFindBy(xpath = "//h3[text()='Competition Date']/following-sibling::div//h5[text()='Start Date & Time']/parent::div/following-sibling::div//input")
	private WebElement txtBoxCompetitionStartDate;

	@B2BFindBy(xpath = "//button[text()='OK']")
	private WebElement btnOK;

	@B2BFindBy(xpath = "//span[text()='55']")
	private WebElement btnTimeInMinutes;

	public FullRegistrationPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public boolean isFullRegistrationValidationsDisplayed() {
		log.info("Starting of isFullRegistrationValidationsDisplayed method");

		boolean isFullRegistrationValidationsDisplayed = false;

		if (isDisplayed(msgNumberOfTeamsFullValidation) && isDisplayed(msgWaitlistFullValidation)) {

			isFullRegistrationValidationsDisplayed = true;
		}

		log.info("Ending of isFullRegistrationValidationsDisplayed method");

		return isFullRegistrationValidationsDisplayed;
	}

	public boolean isDoublesMixedCardDisplayed() {
		log.info("Starting of isDoublesMixedCardDisplayed method");
		log.info("Ending of isDoublesMixedCardDisplayed method");

		return lblDoublesMixed.isDisplayed();
	}

	public void clickOnDoublesMixedCard() {
		log.info("Starting of clickOnDoublesMixedCard method");

		elementClick(lblDoublesMixed);

		log.info("Ending of clickOnDoublesMixedCard method");
	}

	public void clickOnOpenSinglesCard() {
		log.info("Starting of clickOnOpenSinglesCard method");

		elementClick(lblOpenSingles);

		log.info("Ending of clickOnOpenSinglesCard method");
	}

	public void clickOnUnmatchedPlayersTab() {
		log.info("Starting of clickOnUnmatchedPlayersTab method");

		elementClick(tabUnmatchedPlayers);

		log.info("Ending of clickOnUnmatchedPlayersTab method");
	}

	public boolean isOpenSinglesCardDisplayed() {
		log.info("Starting of isOpenSinglesCardDisplayed method");
		log.info("Ending of isOpenSinglesCardDisplayed method");

		return lblOpenSingles.isDisplayed();
	}

	public void clickOnRegisterButton() {
		log.info("Starting of clickOnRegisterButton method");

		try {
			elementClick(btnRegister);
		} catch (Exception e) {
			clickUsingActionsClass(btnRegister);
		}

		log.info("Ending of clickOnRegisterButton method");
	}

	public boolean isRegisterDisplayed() {
		log.info("Starting of isRegisterDisplayed method");
		log.info("Ending of isRegisterDisplayed method");

		return btnRegister.isDisplayed();
	}

	public String getEventRegistrationText() {
		log.info("Starting of getEventRegistrationText method");
		log.info("Ending of getEventRegistrationText method");

		return lblEventRegistration.getText();
	}

	public String getRegistrationFullText() {
		log.info("Starting of getRegistrationFullText method");
		log.info("Ending of getRegistrationFullText method");

		return msgRegistrationFull.getText();
	}

	public boolean isSelectBracketCheckBoxDisabledDisplayed() {
		log.info("Starting of isSelectBracketCheckBoxDisabledDisplayed method");
		log.info("Ending of isSelectBracketCheckBoxDisabledDisplayed method");

		return chkSelectBracketDisabled.isDisplayed();
	}

	public boolean isRegisterButtonDisableDisplayed() {
		log.info("Starting of isRegisterButtonDisableDisplayed method");
		log.info("Ending of isRegisterButtonDisableDisplayed method");

		return btnRegisterDisabled.isDisplayed();
	}

	public void setCompetitionStartDate() {
		log.info("Starting of setCompetitionStartDate method");

		try {
			clickOnWebElement(txtBoxCompetitionStartDate);
		} catch (Exception e) {
			clickOnElementUsingActionClass(txtBoxCompetitionStartDate);
		}

		int date = this.getFutureDate(2);
		String hours = this.getCurrentHour();
		String meridiem = this.getCurrentMeridiem();

		this.clickOnCurrentDate(date);
		this.clickOnCurrentTime(hours);
		clickOnElementUsingActionClass(btnTimeInMinutes);
		this.clickOnCurrentTime(meridiem);
		this.clickOnElementUsingActionClass(btnOK);

		log.info("Ending of setCompetitionStartDate method");
	}
}
