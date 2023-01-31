package com.dupr.pages.events;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class EditOrRemovePartnerPage extends DUPRBaseAutomationPage {
	private static final Logger log = LogManager.getLogger(EditOrRemovePartnerPage.class);

	@B2BFindBy(xpath = "//h4[text()='My Brackets']")
	private WebElement btnBrackets;

	@B2BFindBy(xpath = "//button[text()='Browse all Events']")
	private WebElement btnBrowseAllEvents;

	@B2BFindBy(xpath = "//h3[text()='Brackets']")
	private WebElement lblBrackets;

	@B2BFindBy(xpath = "//button[@id='composition-button']")
	private WebElement btnkebabBracket;

	@B2BFindBy(xpath = "//span[text()='Edit Partner']")
	private WebElement lstEditPartner;

	@B2BFindBy(xpath = "//span[text()='Remove Partner']")
	private WebElement lstRemovePartner;

	@B2BFindBy(xpath = "//span[contains(text(),'Add Partner')]")
	private WebElement btnAddPartner;

	@B2BFindBy(xpath = "//button[contains(text(),'Add Partner')]")
	private WebElement btnAddPartnerEnabled;

	@B2BFindBy(xpath = "//p[text()='Partner Pending']")
	private WebElement lblPartnerPending;

	@B2BFindBy(xpath = "//h3[text()='Bracket']")
	private WebElement lblBracket;

	@B2BFindBy(xpath = "//button[text()='Edit Bracket']")
	private WebElement btnEditBracket;

	@B2BFindBy(xpath = "//button[text()='End Bracket']")
	private WebElement btnEndBracket;

	@B2BFindBy(xpath = "//button[text()='withdraw']")
	private WebElement btnWithdraw;

	@B2BFindBy(xpath = "//button[text()='Edit Partner']")
	private WebElement btnEditPartner;

	@B2BFindBy(xpath = "//button[text()='Remove Partner']")
	private WebElement btnRemovePartner;

	@B2BFindBy(xpath = "//button[text()='Share']")
	private WebElement btnShare;

	@B2BFindBy(xpath = "//button[text()='Show Details']")
	private WebElement btnShowDetails;

	@B2BFindBy(xpath = "//input[@type='radio']")
	private WebElement rdoPartner;

	@B2BFindBy(xpath = "//div[text()='Add a Partner']")
	private WebElement lblAddAPartner;

	@B2BFindBy(xpath = "//button[text()='Add Partner' and @disabled]")
	private WebElement btnAddPartnerDisabled;

	@B2BFindBy(xpath = "//button[text()='Cancel']")
	private WebElement btnCancel;

	@B2BFindBy(xpath = "//button[text()='Invite']")
	private WebElement btnInvite;

	@B2BFindBy(xpath = "//div[text()='Add a Partner']/parent::div//input[@id='Search']")
	private WebElement txtSearch;

	@B2BFindBy(xpath = "//h4[contains(text(),'Spandana')]")
	private WebElement lblValidPartner;

	public EditOrRemovePartnerPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public boolean isDisplayedBracketPageContains() {
		log.info("Starting of isDisplayedBracketPageContains method");

		boolean isDisplayedBracketPageContains = false;

		if (btnEditBracket.isDisplayed() && btnEndBracket.isDisplayed() && lblBracket.isDisplayed()
				&& btnWithdraw.isDisplayed() && btnEditPartner.isDisplayed() && btnShare.isDisplayed()
				&& btnShowDetails.isDisplayed()) {

			isDisplayedBracketPageContains = true;
		}

		log.info("Ending of isDisplayedBracketPageContains method");

		return isDisplayedBracketPageContains;

	}

	public boolean isDisplayedBracketPageAfterAddingPartnerContains() {
		log.info("Starting of isDisplayedBracketPageContains method");

		boolean isDisplayedBracketPageContains = false;

		if (btnEditBracket.isDisplayed() && btnEndBracket.isDisplayed() && btnWithdraw.isDisplayed()
				&& btnEditPartner.isDisplayed() && btnRemovePartner.isDisplayed() && btnShare.isDisplayed()
				&& btnShowDetails.isDisplayed()) {

			isDisplayedBracketPageContains = true;
		}

		log.info("Ending of isDisplayedBracketPageContains method");

		return isDisplayedBracketPageContains;

	}

	/*
	 * public String getEventLabel() {
	 * 
	 * log.info("Starting of getEventLabel method");
	 * 
	 * log.info("Ending of getEventLabel method");
	 * 
	 * return lblEvent.getText(); }
	 */

	public String getBracketsLabel() {
		log.info("Starting of getBracketsLabel method");

		log.info("Ending of getBracketsLabel method");

		return lblBrackets.getText();
	}

	public String getBracketLabel() {
		log.info("Starting of getBracketLabel method");
		hardWait(3);
		log.info("Ending of getBracketLabel method");

		return lblBracket.getText();
	}

	public String getBrowseBracketsLabel() {
		log.info("Starting of getBrowseBracketsLabel method");

		log.info("Ending of getBrowseBracketsLabel method");

		return btnBrowseAllEvents.getText();
	}

	public String getEditPartnerLabel() {
		log.info("Starting of getEditPartnerLabel method");

		log.info("Ending of getEditPartnerLabel method");

		return lstEditPartner.getText();
	}

	public String getAddPartnerLabel() {
		log.info("Starting of getAddPartnerLabel method");

		log.info("Ending of getAddPartnerLabel method");

		return btnAddPartner.getText();
	}

	public void clickOnAddPartnerButton() {
		log.info("Starting of clickOnAddPartnerButton method");

		elementClick(btnAddPartner);

		log.info("Ending of clickOnAddPartnerButton method");

	}

	public void clickOnAddPartnerEnabledButton() {
		log.info("Starting of clickOnAddPartnerEnabledButton method");

		elementClick(btnAddPartnerEnabled);

		log.info("Ending of clickOnAddPartnerEnabledButton method");

	}

	public void clickOnPartnerPendingBracketCard() {
		log.info("Starting of clickOnPartnerPendingBracketCard method");

		elementClick(lblPartnerPending);

		log.info("Ending of clickOnPartnerPendingBracketCard method");

	}

	public void clickOnRemovePartnerButton() {
		log.info("Starting of clickOnRemovePartnerButton method");

		clickOnWebElement(btnRemovePartner);

		log.info("Ending of clickOnRemovePartnerButton method");

	}

	public void clickOnAddPartnerRadioButton() {
		log.info("Starting of clickOnAddPartnerRadioButton method");

		elementClick(rdoPartner);

		log.info("Ending of clickOnAddPartnerRadioButton method");

	}

	public String getRemovePartnerLabel() {
		log.info("Starting of getRemovePartnerLabel method");

		log.info("Ending of getRemovePartnerLabel method");

		return lstRemovePartner.getText();
	}

	public boolean isPartnerRadioButtonDisplayed() {
		log.info("Starting of isPartnerRadioButtonDisplayed method");

		boolean isPartnerRadioButtonDisplayed = false;
		try {
			if (rdoPartner.isDisplayed()) {
				isPartnerRadioButtonDisplayed = true;
			}
		} catch (Exception e) {
			isPartnerRadioButtonDisplayed = false;
		}
		log.info("Ending of isPartnerRadioButtonDisplayed method");

		return isPartnerRadioButtonDisplayed;

	}

	public boolean isAddPartnerDisabledButtonDisplayed() {
		log.info("Starting of isAddPartnerDisabledButtonDisplayed method");

		log.info("Ending of isAddPartnerDisabledButtonDisplayed method");

		return btnAddPartnerDisabled.isDisplayed();

	}

	public void clickOnMyBracketsLabel() {
		log.info("Starting of clickOnMyBracketsLabel method");

		elementClick(btnBrackets);

		log.info("Ending of clickOnMyBracketsLabel method");

	}

	public void clickOnBracketKebabButton() {
		log.info("Starting of clickOnBracketKebabButton method");

		elementClick(btnkebabBracket);

		log.info("Ending of clickOnBracketKebabButton method");

	}

	public void clickOnEditPartnerButton() {
		log.info("Starting of clickOnEditPartnerButton method");
		try {
			elementClick(btnEditPartner);
		} catch (Exception e) {
			btnEditPartner.click();
		}
		log.info("Ending of clickOnEditPartnerButton method");

	}

	public void clickOnCancelButton() {
		log.info("Starting of clickOnCancelButton method");

		elementClick(btnCancel);

		log.info("Ending of clickOnCancelButton method");

	}

	public boolean isDisplayedEditPartnerBracketPageContains() {
		log.info("Starting of isDisplayedEditPartnerBracketPageContains method");

		boolean isDisplayedEditPartnerBracketPageContains = false;

		if (btnAddPartnerDisabled.isDisplayed() && btnCancel.isDisplayed() && btnInvite.isDisplayed()
				&& txtSearch.isDisplayed()) {

			isDisplayedEditPartnerBracketPageContains = true;
		}

		log.info("Ending of isDisplayedEditPartnerBracketPageContains method");

		return isDisplayedEditPartnerBracketPageContains;

	}

	public String getAddAPartnerLabel() {
		log.info("Starting of getAddAPartnerLabel method");

		log.info("Ending of getAddAPartnerLabel method");

		return lblAddAPartner.getText();
	}

	public void setSearchPartner(String partnerName) {
		log.info("Starting of setSearchPartner method");

		clickOnWebElement(txtSearch);
		this.txtSearch.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		txtSearch.sendKeys(partnerName);

		log.info("Ending of setSearchPartner method");
	}

	public String getvalidPartnerLabel() {
		log.info("Starting of getvalidPartnerLabel method");
		hardWait(5);
		log.info("Ending of getvalidPartnerLabel method");

		return lblValidPartner.getText();
	}

}
