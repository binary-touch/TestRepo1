package com.dupr.pages.events;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BFindBys;
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
	private WebElement btnKebabMenu;

	@B2BFindBy(xpath = "//span[text()='Edit Partner']")
	private WebElement lstEditPartner;

	@B2BFindBy(xpath = "//span[text()='Remove Partner']")
	private WebElement lstRemovePartner;

	@B2BFindBy(xpath = "//span[contains(text(),'Add Partner')]")
	private WebElement btnAddPartner;

	@B2BFindBy(xpath = "//button[contains(text(),'Add Partner')]")
	private WebElement btnAddPartnerInBracketPage;

	@B2BFindBy(xpath = "//button[contains(text(),'Add Partner')]")
	private WebElement btnAddPartnerEnabled;

	@B2BFindBy(xpath = "//p[text()='Partner Pending']")
	private WebElement lblPartnerPending;

	@B2BFindBy(xpath = "//p[text()='Partner Pending']/ancestor::div[contains(@class,'MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation3')]//h4")
	private WebElement lnkBracketCard;

	@B2BFindBy(xpath = "//h3[text()='Bracket']")
	private WebElement lblBracket;

	@B2BFindBy(xpath = "//button[text()='Edit Bracket']")
	private WebElement btnEditBracket;

	@B2BFindBy(xpath = "(//div[@format=\"DOUBLES\"]//h3[contains(@class,'MuiTypography-root MuiTypography-h3')])[1]")
	private WebElement lblBracketName;

	@B2BFindBy(xpath = "//div[@format=\"DOUBLES\"]//h4")
	private WebElement lblClubNameInBracketPage;

	@B2BFindBys({ @B2BFindBy(xpath = "//div[@format=\"DOUBLES\"]//p") })
	private List<WebElement> lblBracketDetails;

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

	@B2BFindBy(id = "composition-button")
	private WebElement btnSort;

	@B2BFindBy(xpath = "//button[contains(text(),'Clear Filters')]")
	private WebElement btnClearFilter;

	@B2BFindBy(xpath = "//button[text()='Unmatched Players']")
	private WebElement tabUnmatchedPlayes;

	@B2BFindBy(xpath = "//button[text()='Teams']")
	private WebElement tabTeams;

	@B2BFindBy(xpath = "//button[text()='Players']")
	private WebElement tabPlayers;

	@B2BFindBy(xpath = "//button[text()='Matches']")
	private WebElement tabMatches;

	@B2BFindBy(xpath = "//button[text()='Information']")
	private WebElement tabInformation;

	@B2BFindBy(xpath = "//input[@type='radio']")
	private WebElement rdoPartner;

	@B2BFindBy(xpath = "//div[text()='Add a Partner']//parent::div//following-sibling::div[2]//b[text()='No more results.']")
	private WebElement lblNoMoreResults;

	@B2BFindBy(xpath = "//div[text()='Add a Partner']")
	private WebElement lblAddAPartner;

	@B2BFindBy(xpath = "//button[text()='Add Partner' and @disabled]")
	private WebElement btnAddPartnerDisabled;

	@B2BFindBy(xpath = "//button[text()='Cancel']")
	private WebElement btnCancel;

	@B2BFindBy(xpath = "//button[text()='Invite']")
	private WebElement btnInvite;

	@B2BFindBy(xpath = "//div[text()='Add a Partner']/parent::div//input[@id='Search']")
	private WebElement txtBoxSearch;

	@B2BFindBy(xpath = "//div[@role='radiogroup']//div[contains(@class, 'MuiGrid-grid-xs-12 MuiGrid-grid-md-6')]//h4")
	private WebElement lblValidPartner;

	@B2BFindBy(xpath = "//p[text()='No partner Selected']")
	private WebElement lblNoPartnerSelected;

	public EditOrRemovePartnerPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public boolean isBracketPageContains() {
		log.info("Starting of isBracketPageContains method");

		boolean isBracketPageContains = false;

		if (lblBracketName.isDisplayed() && lblClubNameInBracketPage.isDisplayed()
				&& lblBracketDetails.get(0).isDisplayed() && lblBracketDetails.get(1).isDisplayed()
				&& lblBracketDetails.get(2).isDisplayed() && btnEditBracket.isDisplayed() && btnEndBracket.isDisplayed()
				&& btnWithdraw.isDisplayed() && btnEditPartner.isDisplayed() && btnRemovePartner.isDisplayed()
				&& tabUnmatchedPlayes.isDisplayed() && btnShare.isDisplayed() && btnShowDetails.isDisplayed()
				&& isDisplayed(btnSort) && isDisplayed(btnClearFilter) && tabTeams.isDisplayed()
				&& tabPlayers.isDisplayed() && tabMatches.isDisplayed() && tabInformation.isDisplayed()) {

			isBracketPageContains = true;
		}

		log.info("Ending of isBracketPageContains method");

		return isBracketPageContains;
	}

	public boolean isBracketPageContainsAfterAddingPartner() {
		log.info("Starting of isBracketPageContainsAfterAddingPartner method");

		boolean isBracketPageContainsAfterAddingPartner = false;

		if (btnEditBracket.isDisplayed() && btnEndBracket.isDisplayed() && btnWithdraw.isDisplayed()
				&& btnEditPartner.isDisplayed() && btnRemovePartner.isDisplayed() && btnShare.isDisplayed()
				&& btnShowDetails.isDisplayed()) {

			isBracketPageContainsAfterAddingPartner = true;
		}

		log.info("Ending of isBracketPageContainsAfterAddingPartner method");

		return isBracketPageContainsAfterAddingPartner;
	}

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

	public String getNoMoreResultsLabel() {
		log.info("Starting of getNoMoreResultsLabel method");
		log.info("Ending of getNoMoreResultsLabel method");

		return lblNoMoreResults.getText();
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

		scrollIntoView(lblPartnerPending);
		hardWait(3);
		clickOnElementUsingActionClass(lnkBracketCard);

		log.info("Ending of clickOnPartnerPendingBracketCard method");
	}

	public boolean isPartnerPendingLabelDisplayed() {
		log.info("Starting of isPartnerPendingLabelDisplayed method");
		log.info("Ending of isPartnerPendingLabelDisplayed method");

		return lblPartnerPending.isDisplayed();
	}

	public void clickOnRemovePartnerButton() {
		log.info("Starting of clickOnRemovePartnerButton method");

		hardWait(3);
		clickOnWebElement(btnRemovePartner);

		log.info("Ending of clickOnRemovePartnerButton method");
	}

	public void clickOnAddPartnerRadioButton() {
		log.info("Starting of clickOnAddPartnerRadioButton method");

		elementClick(rdoPartner);

		log.info("Ending of clickOnAddPartnerRadioButton method");
	}

	public void clickOnAddPartnerInBracketPageButton() {
		log.info("Starting of clickOnAddPartnerInBracketPageButton method");

		elementClick(btnAddPartnerInBracketPage);

		log.info("Ending of clickOnAddPartnerInBracketPageButton method");
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

	public boolean isAddPartnerButtonDisabled() {
		log.info("Starting of isAddPartnerButtonDisabled method");
		log.info("Ending of isAddPartnerButtonDisabled method");

		return btnAddPartnerDisabled.isDisplayed();
	}

	public void clickOnMyBracketsLabel() {
		log.info("Starting of clickOnMyBracketsLabel method");

		elementClick(btnBrackets);

		log.info("Ending of clickOnMyBracketsLabel method");
	}

	public void clickOnBracketKebabMenu() {
		log.info("Starting of clickOnBracketKebabButton method");

		elementClick(btnKebabMenu);

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

	public boolean isAddAPartnerPageContains() {
		log.info("Starting of isAddAPartnerPageContains method");

		boolean isAddAPartnerPageContains = false;

		if (btnCancel.isDisplayed() && btnInvite.isDisplayed()
				&& txtBoxSearch.isDisplayed()) {

			isAddAPartnerPageContains = true;
		}

		log.info("Ending of isAddAPartnerPageContains method");

		return isAddAPartnerPageContains;
	}

	public String getAddAPartnerLabel() {
		log.info("Starting of getAddAPartnerLabel method");
		log.info("Ending of getAddAPartnerLabel method");

		return lblAddAPartner.getText();
	}

	public void searchPartner(String partnerName) {
		log.info("Starting of searchPartner method");

		clickOnWebElement(txtBoxSearch);
		this.txtBoxSearch.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		txtBoxSearch.sendKeys(partnerName);

		log.info("Ending of searchPartner method");
	}

	public boolean isValidPartnerDisplayed(String partnerName) {
		log.info("Starting of isValidPartnerDisplayed method");
		hardWait(5);
		System.out.println(lblValidPartner.getText());
		System.out.println(partnerName);
		System.out.println(lblValidPartner.getText().contains(partnerName));
		log.info("Ending of isValidPartnerDisplayed method");

		return lblValidPartner.getText().contains(partnerName);
	}

	public boolean isBracketPageContainsAfterRemovingPartner() {
		log.info("Starting of isBracketPageContainsAfterRemovingPartner method");

		boolean isBracketPageContainsAfterRemovingPartner = false;

		if (lblBracketName.isDisplayed() && lblClubNameInBracketPage.isDisplayed()
				&& lblBracketDetails.get(0).isDisplayed() && lblBracketDetails.get(1).isDisplayed()
				&& lblBracketDetails.get(2).isDisplayed() && btnEditBracket.isDisplayed() && btnEndBracket.isDisplayed()
				&& btnWithdraw.isDisplayed() && btnAddPartnerEnabled.isDisplayed() && lblNoPartnerSelected.isDisplayed()
				&& tabUnmatchedPlayes.isDisplayed() && btnShare.isDisplayed() && btnShowDetails.isDisplayed()
				&& isDisplayed(btnSort) && isDisplayed(btnClearFilter) && tabTeams.isDisplayed()
				&& tabPlayers.isDisplayed() && tabMatches.isDisplayed() && tabInformation.isDisplayed()) {

			isBracketPageContainsAfterRemovingPartner = true;
		}

		log.info("Ending of isBracketPageContainsAfterRemovingPartner method");

		return isBracketPageContainsAfterRemovingPartner;
	}
}
