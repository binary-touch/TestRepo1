package com.dupr.pages.events;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class AcceptOrDeclinePartnershipPage extends DUPRBaseAutomationPage {
	private static final Logger log = LogManager.getLogger(AcceptOrDeclinePartnershipPage.class);

	@B2BFindBy(xpath = "//h4[contains(text(),'MIXED DOUBLES')]")
	private WebElement btnMixedDoubleBrackets;

	@B2BFindBy(xpath = "//p[text()='Partner Pending']")
	private WebElement lblPartnerPending;

	@B2BFindBy(xpath = "//p[text()='No partner Selected']")
	private WebElement lblNoPartnerSelected;

	@B2BFindBy(xpath = "//button[text()='Add Participants']")
	private WebElement btnAddParticipants;

	@B2BFindBy(xpath = "//button[text()='Add Participant' and @disabled]")
	private WebElement btnAddParticipantDisabled;

	@B2BFindBy(xpath = "//button[text()='Add Participant']")
	private WebElement btnAddParticipant;

	@B2BFindBy(xpath = "//button[text()='Go Back']")
	private WebElement btnGoBack;

	@B2BFindBy(xpath = "//h2[text()='Add a Bracket Participant']")
	private WebElement lblAddABracketParticipant;

	@B2BFindBy(xpath = "//h2[text()='Add a Bracket Participant']/parent::div//input[@id='Search']")
	private WebElement txtBoxSearchAddABracketParticipant;

	@B2BFindBy(xpath = "//input[@type='radio']")
	private WebElement rdoAddParticipants;

	@B2BFindBy(xpath = "//button[text()='Add Participant']")
	private WebElement btnAddParticipantEnabled;

	@B2BFindBy(xpath = "//button[text()='Edit Bracket']")
	private WebElement btnEditBracket;

	@B2BFindBy(xpath = "//button[text()='End Bracket']")
	private WebElement btnEndBracket;

	@B2BFindBy(xpath = "//button[text()='Share']")
	private WebElement btnShare;

	@B2BFindBy(xpath = "//button[text()='Show Details']")
	private WebElement btnShowDetails;

	@B2BFindBy(xpath = "//button[@aria-label='Open settings']")
	private WebElement btnOpenSettings;

	@B2BFindBy(xpath = "//div[contains(text(),'Logout')]")
	private WebElement btnLogout;

	@B2BFindBy(xpath = "//button[text()='Accept']")
	private WebElement btnAccept;
	
	@B2BFindBy(xpath = "//button[text()='Decline']")
	private WebElement btnDecline;

	@B2BFindBy(xpath = "//h4[text()='Accept Partner']")
	private WebElement lblAcceptPartner;

	@B2BFindBy(xpath = "//h5[text()='Are you a member of the host club?']")
	private WebElement lblHostClub;

	@B2BFindBy(xpath = "//span[text()='Yes']/parent::label//input")
	private WebElement rdoYes;

	@B2BFindBy(xpath = "//span[text()='No']/parent::label//input")
	private WebElement rdoNo;

	@B2BFindBy(xpath = "//button[text()='Register']")
	private WebElement btnRegister;

	@B2BFindBy(xpath = "//button[text()='Register' and @disabled]")
	private WebElement btnRegisterDisabled;

	public AcceptOrDeclinePartnershipPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public boolean isAddABracketParticipantsPageContains() {
		log.info("Starting of isAddABracketParticipantsPageContains method");

		boolean isAddABracketParticipantsPageContains = false;

		if (btnAddParticipantDisabled.isDisplayed() && btnGoBack.isDisplayed()
				&& lblAddABracketParticipant.isDisplayed() && txtBoxSearchAddABracketParticipant.isDisplayed()
				&& rdoAddParticipants.isDisplayed()) {

			isAddABracketParticipantsPageContains = true;
		}

		log.info("Ending of isAddABracketParticipantsPageContains method");

		return isAddABracketParticipantsPageContains;
	}

	public boolean isBracketPageContainsBeforeAddingPartner() {
		log.info("Starting of isBracketPageContainsBeforeAddingPartner method");

		boolean isBracketPageContainsBeforeAddingPartner = false;

		if (btnEditBracket.isDisplayed() && btnEndBracket.isDisplayed() && btnShare.isDisplayed()
				&& btnShowDetails.isDisplayed()) {

			isBracketPageContainsBeforeAddingPartner = true;
		}

		log.info("Ending of isBracketPageContainsBeforeAddingPartner method");

		return isBracketPageContainsBeforeAddingPartner;
	}

	public String getMixedDoubleBracketsLabel() {
		log.info("Starting of getMixedDoubleBracketsLabel method");
		log.info("Ending of getMixedDoubleBracketsLabel method");

		return btnMixedDoubleBrackets.getText();
	}

	public void clickOnMixedDoubleBracket() {
		log.info("Starting of clickOnMixedDoubleBracket method");

		try {
			if (btnMixedDoubleBrackets.isDisplayed() && lblPartnerPending.isDisplayed()) {
				this.clickOnWebElement(btnMixedDoubleBrackets);
			}
		} catch (Exception e) {
			btnMixedDoubleBrackets.click();
		}

		log.info("Ending of clickOnMixedDoubleBracket method");
	}

	public String getAddParticipantsLabel() {
		log.info("Starting of getAddParticipantsLabel method");
		hardWait(3);
		this.scrollDown(500);
		log.info("Ending of getAddParticipantsLabel method");

		return btnAddParticipants.getText();
	}

	public boolean isAddParticipantButtonDisabled() {
		log.info("Starting of isAddParticipantButtonDisabled method");
		log.info("Ending of isAddParticipantButtonDisabled method");

		return btnAddParticipantDisabled.isDisplayed();
	}

	public String getAddABracketParticipantLabel() {
		log.info("Starting of getAddABracketParticipantLabel method");
		log.info("Ending of getAddABracketParticipantLabel method");

		return lblAddABracketParticipant.getText();
	}

	public void clickOnAddParticipantsButton() {
		log.info("Starting of clickOnAddParticipantsButton method");

		try {
			this.waitForElementToBeVisible(btnAddParticipants);
			elementClick(btnAddParticipants);
		} catch (Exception e) {
			btnAddParticipants.click();
		}

		log.info("Ending of clickOnAddParticipantsButton method");
	}

	public void clickOnGoBackButton() {
		log.info("Starting of clickOnGoBackButton method");

		elementClick(btnGoBack);

		log.info("Ending of clickOnGoBackButton method");
	}

	public void searchParticipants(String participateName) {
		log.info("Starting of searchParticipants method");

		clickOnWebElement(txtBoxSearchAddABracketParticipant);
		this.txtBoxSearchAddABracketParticipant.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		txtBoxSearchAddABracketParticipant.sendKeys(participateName);

		log.info("Ending of searchParticipants method");
	}

	public void clickOnAddParticipantRadioButton() {
		log.info("Starting of clickOnAddParticipantRadioButton method");

		try {
			elementClick(rdoAddParticipants);
		} catch (Exception e) {
			rdoAddParticipants.click();
		}

		log.info("Ending of clickOnAddParticipantRadioButton method");
	}

	public void clickOnAddParticipantButton() {
		log.info("Starting of clickOnAddParticipantButton method");

		try {
			this.waitForElementToBeVisible(btnAddParticipant);
			elementClick(btnAddParticipant);
		} catch (Exception e) {
			btnAddParticipant.click();
		}

		log.info("Ending of clickOnAddParticipantButton method");
	}

	public void clickOnOpenSettingsMenu() {
		log.info("Starting of clickOnOpenSettingsMenu method");

		clickOnWebElement(btnOpenSettings);

		log.info("Ending of clickOnOpenSettingsMenu method");
	}

	public void clickOnLogoutButton() {
		log.info("Starting of clickOnLogoutButton method");

		try {

			btnLogout.click();
		} catch (Exception e) {
			clickOnWebElement(btnLogout);
		}
		log.info("Ending of clickOnLogoutButton method");
	}

	public void clickOnAcceptButton() {
		log.info("Starting of clickOnAcceptButton method");
		try {
			clickOnWebElement(btnAccept);
		} catch (Exception e) {
			clickOnElementUsingActionClass(btnAccept);
		}
		log.info("Ending of clickOnAcceptButton method");
	}
	
	public void clickOnDeclinePartnerButton() {
		log.info("Starting of clickOnDeclinePartnerButton method");

		clickOnWebElement(btnDecline);

		log.info("Ending of clickOnDeclinePartnerButton method");
	}

	public boolean isAcceptPartnerPopupContains() {
		log.info("Starting of isAcceptPartnerPopupContains method");

		boolean isAcceptPartnerPopupContains = false;

		if (lblAcceptPartner.isDisplayed() && lblHostClub.isDisplayed() && btnRegisterDisabled.isDisplayed()) {

			isAcceptPartnerPopupContains = true;
		}

		log.info("Ending of isAcceptPartnerPopupContains method");

		return isAcceptPartnerPopupContains;
	}

	public void clickOnNoRadioButton() {
		log.info("Starting of clickOnNoRadioButton method");
		
		try {
			clickOnWebElement(rdoNo);
		} catch (Exception e) {
			clickOnElementUsingActionClass(rdoNo);
		}
		log.info("Ending of clickOnNoRadioButton method");
	}

	public void clickOnYesRadioButton() {
		log.info("Starting of clickOnYesRadioButton method");

		clickOnWebElement(rdoYes);

		log.info("Ending of clickOnYesRadioButton method");
	}

	public void clickOnRegisterButton() {
		log.info("Starting of clickOnRegisterButton method");

		clickOnWebElement(btnRegister);

		log.info("Ending of clickOnRegisterButton method");
	}

	public boolean isYesRadioButtonSelected() {
		log.info("Starting of isYesRadioButtonSelected method");
		log.info("Ending of isYesRadioButtonSelected method");

		return rdoYes.isSelected();
	}

	public boolean isNoRadioButtonSelected() {
		log.info("Starting of isNoRadioButtonSelected method");
		log.info("Ending of isNoRadioButtonSelected method");

		return rdoNo.isSelected();
	}

	public boolean isRegisterButtonEnabled() {
		log.info("Starting of isRegisterButtonEnabled method");
		log.info("Ending of isRegisterButtonEnabled method");

		return btnRegister.isEnabled();
	}
	
	public boolean isAcceptButtonDisplayed() {
		log.info("Starting of isAcceptButtonDisplayed method");
		boolean buttonState = false;
		
		try {
			if(btnAccept.isDisplayed()==true) {
				buttonState = true;
			}
		} catch (Exception e) {
			buttonState = false;
		}
		log.info("Ending of isAcceptButtonDisplayed method");

		return buttonState;
	}


	public boolean isDeclineButtonDisplayed() {
		log.info("Starting of isDeclineButtonDisplayed method");
		boolean buttonState = false;
		
		try {
			if(btnDecline.isDisplayed()==true) {
				buttonState = true;
			}
		} catch (Exception e) {
			buttonState = false;
		}
		log.info("Ending of isDeclineButtonDisplayed method");

		return buttonState;
	}
}
