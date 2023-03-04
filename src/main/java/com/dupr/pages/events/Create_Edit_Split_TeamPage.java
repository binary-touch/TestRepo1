package com.dupr.pages.events;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BFindBys;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class Create_Edit_Split_TeamPage extends DUPRBaseAutomationPage {

	private static final Logger log = LogManager.getLogger(Create_Edit_Split_TeamPage.class);

	@B2BFindBy(xpath = "//button[text()='Unmatched Players']")
	private WebElement tabUnmatchedPlayes;

	@B2BFindBys({
			@B2BFindBy(xpath = "//h4[contains(@class,'MuiTypography-root MuiTypography-h4') and contains(text(), 'DOUBLES')]") })
	private List<WebElement> lblEvent;

	@B2BFindBy(xpath = "//*[contains(@class,'MuiSvgIcon-root MuiSvgIcon-colorPrimary MuiSvgIcon-fontSizeMedium')]")
	private WebElement btnBack;

	@B2BFindBy(id = "composition-button")
	private WebElement btnSort;

	@B2BFindBy(xpath = "//button[contains(text(),'Clear Filters')]")
	private WebElement btnClearFilter;

	@B2BFindBy(xpath = "//p[contains(text(),'Please select any two players from this list to create a team')]")
	private WebElement lblPlayerInformation;

	@B2BFindBys({ @B2BFindBy(xpath = "//input[@type='checkbox']") })
	private List<WebElement> chkFirstPlayers;

	@B2BFindBys(@B2BFindBy(xpath = "//input[@type='checkbox']"))
	private WebElement chkFirstPlayer;

	@B2BFindBy(xpath = "//input[@type='checkbox']/parent::span/parent::label/following-sibling::label//input[@type='checkbox']")
	private WebElement chkSecondPlayers;

	@B2BFindBy(xpath = "//button[contains(text(),'Create Team')]")
	private WebElement btnCreateTeam;

	@B2BFindBy(xpath = "//button[text()='Players']")
	private WebElement tabPlayers;

	@B2BFindBy(xpath = "//button[text()='Add Participants']")
	private WebElement btnAddParticipants;

	@B2BFindBy(xpath = "//h2[text()='Add a Bracket Participant']/parent::div/child::div//input[@id='Search']")
	private WebElement txtBoxSearchParticipant;

	@B2BFindBy(xpath = "//input[@type='radio']")
	private WebElement rdoSelectParticipant;

	@B2BFindBy(xpath = "//button[text()='Add Participant']")
	private WebElement btnAddParticipant;

	@B2BFindBy(xpath = "//h4[text()='Players must be different genders']")
	private WebElement txtPlayersWithSameGender;

	@B2BFindBy(xpath = "//span[contains(text(),'No results found!')]")
	private WebElement txtNoResultsFound;

	@B2BFindBys({ @B2BFindBy(xpath = "//div[@id='simple-tabpanel-2']//input[@type='checkbox']") })
	private List<WebElement> lstUnMatchedPlayersCheckbox;

	@B2BFindBys({
			@B2BFindBy(xpath = "//div[@id='simple-tabpanel-2']//div[contains(@class,'MuiPaper-elevation MuiPaper-rounded')]//h4") })
	private List<WebElement> lstUnMatchedPlayerNames;

	@B2BFindBys({
			@B2BFindBy(xpath = "//div[@id='simple-tabpanel-2']//div[contains(@class,'MuiPaper-elevation MuiPaper-rounded')]//p[1]") })
	private List<WebElement> lstUnMatchedPlayersEmail;

	@B2BFindBys({
			@B2BFindBy(xpath = "//div[@id='simple-tabpanel-2']//div[contains(@class,'MuiPaper-elevation MuiPaper-rounded')]//div/span") })
	private List<WebElement> lstUnMatchedPlayerPaymentStatus;

	@B2BFindBys({
			@B2BFindBy(xpath = "//div[@id='simple-tabpanel-2']//div[contains(@class,'MuiPaper-elevation MuiPaper-rounded')]//h6[text()='Doubles']/ancestor::div[contains(@class,'MuiGrid-item MuiGrid-grid-xs-5')]") })
	private List<WebElement> lstUnMatchedPlayerDoublesRatings;

	@B2BFindBys({
			@B2BFindBy(xpath = "//div[@id='simple-tabpanel-2']//div[contains(@class,'MuiPaper-elevation MuiPaper-rounded')]//h6[text()='Singles']/ancestor::div[contains(@class,'MuiGrid-item MuiGrid-grid-xs-5')]") })
	private List<WebElement> lstUnMatchedPlayerSinglesRatings;

	@B2BFindBy(xpath = "//div[@id='simple-tabpanel-1']//button[contains(@class,'MuiIconButton-root MuiIconButton-sizeMedium')]")
	private WebElement iconInfoInTeamsTab;

	@B2BFindBy(xpath = "//p[contains(., 'Team') and contains(., '1')]")
	private WebElement lblTeamOne;

	@B2BFindBy(xpath = "//button[text()='Edit Team']")
	private WebElement btnEditTeam;

	@B2BFindBy(xpath = "//button[text()='Split Team']")
	private WebElement btnSplitTeam;

	@B2BFindBy(xpath = "//button[text()='Save Changes' and @disabled]")
	private WebElement btnSaveChangesDisabled;

	@B2BFindBy(xpath = "//button[text()='Create Team' and @disabled]")
	private WebElement btnCreateTeamDisabled;

	@B2BFindBy(xpath = "//h4[contains(text(),'Create Team')]")
	private WebElement lblCreateTeam;

	@B2BFindBy(xpath = "//h4[contains(text(),'Create Team')]/following-sibling::div/div/h4")
	private WebElement lblCreateTeamQuestion;

	@B2BFindBy(xpath = "//h4[contains(text(),'Create Team')]/following-sibling::div/div/p[contains(text(),'After you confirm ')]")
	private WebElement lblCreateTeamConfirm;

	@B2BFindBy(xpath = "//button[@aria-label='close']")
	private WebElement iconCloseCreateTeamPopup;

	@B2BFindBy(xpath = "//button[contains(text(),'Cancel')]")
	private WebElement btnCancel;

	@B2BFindBy(xpath = "//button[text()='Create']")
	private WebElement btnCreate;

	@B2BFindBy(xpath = "//h4[contains(text(),'Create Team')]/child::button/*/*")
	private WebElement iconClose;

	@B2BFindBy(xpath = " //button[text()='Teams']")
	private WebElement tabTeams;

	@B2BFindBy(xpath = "//span[text()='Team Confirmed']")
	private WebElement lblTeamConfirmed;

	@B2BFindBys({ @B2BFindBy(xpath = " //button[text()='Edit Team']") })
	private List<WebElement> lstEditTeam;

	@B2BFindBy(xpath = "//button[@aria-label='remove player']")
	private WebElement iconRemovePlayer;

	@B2BFindBy(xpath = "//button[contains(text(),'Add a Player')]")
	private WebElement btnAddPlayer;

	@B2BFindBy(xpath = "//div[@role='dialog']//button[text()='Add Partner']")
	private WebElement btnAddPartnerInPartnerPage;

	@B2BFindBy(xpath = "//div[@role='dialog']//button[text()='Add Partner' and @disabled]")
	private WebElement btnAddPartnerDisabled;

	@B2BFindBy(xpath = "//div[contains(text(),'Add a Partner')]")
	private WebElement lblAddPartner;

	@B2BFindBy(xpath = "//div[contains(text(),'partner is already a DUPR user')]")
	private WebElement lblAddPartnerInfo;

	@B2BFindBy(xpath = "//div[@role='dialog']//button[contains(text(),'Cancel')]")
	private WebElement btnCancelAddPartner;

	@B2BFindBy(xpath = "//input[@placeholder='Search by Name...']")
	private WebElement txtBoxSearchName;

	@B2BFindBys({ @B2BFindBy(xpath = "//input[@type='radio']") })
	private List<WebElement> lstPartners;

	@B2BFindBy(xpath = "//h4[contains(text(),'Club Membership')]")
	private WebElement lblClubMembership;

	@B2BFindBy(xpath = "//p[contains(text(),'Is Player a member of the host club?')]")
	private WebElement lblClubMembershipQuestion;

	@B2BFindBy(xpath = "//span[contains(text(),'No')]")
	private WebElement rdoNo;

	@B2BFindBy(xpath = "//span[contains(text(),'Yes')]")
	private WebElement rdoYes;

	@B2BFindBy(xpath = "//button[text()='Add']")
	private WebElement btnAdd;

	@B2BFindBy(xpath = "//button[text()='Save Changes']")
	private WebElement btnSaveChanges;

	@B2BFindBy(xpath = "//h4[text()='Edit team']")
	private WebElement lblEditTeam;

	@B2BFindBy(xpath = "//h6[text()='Are you sure you want to remove']")
	private WebElement lblRemovePlayer;

	@B2BFindBy(xpath = "//p[contains(text(),'After withdrawing this player')]")
	private WebElement lblRemoveMessage;

	@B2BFindBy(xpath = "//button[text()='Go Back']")
	private WebElement btnGoBack;

	@B2BFindBy(xpath = "//h4[contains(text(),'Edit team')]/child::button/*/*")
	private WebElement iconClosePopup;

	@B2BFindBy(xpath = "//button[text()='Confirm']")
	private WebElement btnConfirm;

	@B2BFindBy(xpath = "//h6[text()='Success']")
	private WebElement lblEditSuccess;

	@B2BFindBy(xpath = "//p[text()='Team created successfully!']")
	private WebElement lblTeamCreatedSuccess;

	@B2BFindBys({ @B2BFindBy(xpath = "//button[text()='Split Team']") })
	private List<WebElement> lstSplitTeam;

	@B2BFindBy(xpath = "//p[text()='Team withdrawn Successfully!']")
	private WebElement lblTeamWithdrawnSuccess;

	@B2BFindBy(xpath = "//h6[text()='Are you sure you want to edit team?']")
	private WebElement lblAreYouSure;

	@B2BFindBy(xpath = "//input[@type='checkbox']/parent::span/following-sibling::span//h4")
	private WebElement txtName;
	
	@B2BFindBy(xpath = "//h4[text()='Players must be different genders']")
	private WebElement lblPlayersMustBeDifferentGenders;
	
	@B2BFindBy(xpath = "//button[text()='Cancel']")
	private WebElement btnCancelOnMixedPlayerPopUp;
	
	@B2BFindBy(xpath = "//h4[text()='Players must be different genders']/button")
	private WebElement iconClosePopUp;
	
	@B2BFindBy(xpath = "//button[text()='Edit Bracket']")
	private WebElement btnEditBracket;

	public Create_Edit_Split_TeamPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public void clickOnEventLabel() {
		log.info("Starting of clickOnEventLabel method");

		for (int i = 1; i < lblEvent.size(); i++) {
			this.hardWait(3);
			driver.findElement(By.xpath(
					(("(//h4[contains(@class,'MuiTypography-root MuiTypography-h4') and contains(text(), 'DOUBLES')])["
							+ i + "]"))))
					.click();

			this.hardWait(3);
			try {
				if ((isDisplayed(tabUnmatchedPlayes))) {
					clickOnElement(tabUnmatchedPlayes);
					break;
				}
			} catch (Exception e) {
				clickOnElement(btnBack);
			}
		}

		log.info("Ending of clickOnEventLabel method");
	}

	public boolean isUmMatchedPlayersTabContains() {
		log.info("Starting of isUmMatchedPlayersTabContains method");

		boolean isDashboardPageContains = false;

		System.out.println(isDisplayed(btnSort));
		System.out.println(isDisplayed(btnClearFilter));
		System.out.println(isDisplayed(btnCreateTeamDisabled));

		if (isDisplayed(btnSort) && isDisplayed(btnClearFilter) && isDisplayed(btnCreateTeamDisabled)) {

			isDashboardPageContains = true;
		}
		log.info("Ending of isUmMatchedPlayersTabContains method");

		return isDashboardPageContains;
	}

	public boolean isUnMatchedPlayersChkboxesDisplayed() {
		log.info("Starting of isUnMatchedPlayersChkboxesDisplayed method");

		boolean isUnMatchedPlayersChkboxesDisplayed = false;
		try {
			for (WebElement checkbox : lstUnMatchedPlayersCheckbox) {
				if (checkbox.isSelected() == false) {
					isUnMatchedPlayersChkboxesDisplayed = true;
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}

		log.info("Ending of isUnMatchedPlayersChkboxesDisplayed method");

		return isUnMatchedPlayersChkboxesDisplayed;
	}

	public boolean isUnMatchedPlayersPaymentStatusDisplayed() {
		log.info("Starting of isUnMatchedPlayersPaymentStatusDisplayed method");

		boolean isUnMatchedPlayersPaymentStatusDisplayed = false;

		for (WebElement paymentStatus : lstUnMatchedPlayerPaymentStatus) {
			if (paymentStatus.isDisplayed()) {
				isUnMatchedPlayersPaymentStatusDisplayed = true;
			}
		}

		log.info("Ending of isUnMatchedPlayersPaymentStatusDisplayed method");

		return isUnMatchedPlayersPaymentStatusDisplayed;
	}

	public boolean isUnMatchedPlayerNamesDisplayed() {
		log.info("Starting of isUnMatchedPlayerNamesDisplayed method");

		boolean isUnMatchedPlayerNamesDisplayed = false;

		for (WebElement playerName : lstUnMatchedPlayerNames) {
			if (playerName.isDisplayed()) {
				isUnMatchedPlayerNamesDisplayed = true;
			}
		}

		log.info("Ending of isUnMatchedPlayerNamesDisplayed method");

		return isUnMatchedPlayerNamesDisplayed;
	}

	public boolean isUnMatchedPlayersEmailsDisplayed() {
		log.info("Starting of isUnMatchedPlayersEmailsDisplayed method");

		boolean isUnMatchedPlayersEmailsDisplayed = false;

		for (WebElement playerEmail : lstUnMatchedPlayersEmail) {
			if (playerEmail.isDisplayed()) {
				isUnMatchedPlayersEmailsDisplayed = true;
			}
		}

		log.info("Ending of isCreateTeamEnabled method");

		return isUnMatchedPlayersEmailsDisplayed;
	}

	public boolean isMixedBracketDisplayed() {
		log.info("Starting of isMixedBracketDisplayed method");

		log.info("Ending of isMixedBracketDisplayed method");

		return lblPlayersMustBeDifferentGenders.isDisplayed();
	}
	public boolean isUnMatchedPlayerDoublesRatingsDisplayed() {
		log.info("Starting of isUnMatchedPlayerDoublesRatingsDisplayed method");

		boolean isDoublesRatingsDisplayed = false;

		for (WebElement doublesRating : lstUnMatchedPlayerDoublesRatings) {
			if (doublesRating.isDisplayed()) {
				isDoublesRatingsDisplayed = true;
			}
		}

		log.info("Ending of isUnMatchedPlayerDoublesRatingsDisplayed method");

		return isDoublesRatingsDisplayed;
	}

	public boolean isUnMatchedPlayersSinglesRatingsDisplayed() {
		log.info("Starting of isUnMatchedPlayersSinglesRatingsDisplayed method");

		boolean isSinglesRatingsDisplayed = false;

		for (WebElement singlesRating : lstUnMatchedPlayerSinglesRatings) {
			if (singlesRating.isDisplayed()) {
				isSinglesRatingsDisplayed = true;
			}
		}

		log.info("Ending of isUnMatchedPlayersSinglesRatingsDisplayed method");

		return isSinglesRatingsDisplayed;
	}

	public boolean isCreateTeamEnabled() {
		log.info("Starting of isCreateTeamEnabled method");
		log.info("Ending of isCreateTeamEnabled method");

		return btnCreateTeam.isEnabled();
	}

	public boolean isCreateTeamDisabled() {
		log.info("Starting of isCreateTeamDisabled method");
		log.info("Ending of isCreateTeamDisabled method");

		return btnCreateTeamDisabled.isDisplayed();
	}

	public void clickOnUnMatchedPlayersTab() {
		log.info("Starting of clickOnUnMatchedPlayersTab method");
		clickOnWebElement(tabUnmatchedPlayes);
		log.info("Ending of clickOnUnMatchedPlayersTab method");
	}

	public void clickOnValidPlayerCheckbox() {
		log.info("Starting of clickOnValidPlayerCheckbox method");
		System.out.println(lstUnMatchedPlayerNames.get(0).getText());
		System.out.println((lstUnMatchedPlayerNames).get(1).getText());
		try {
			if ((lstUnMatchedPlayerNames.get(0).getText()).equals((lstUnMatchedPlayerNames).get(1).getText()) == true) {
				clickOnWebElement(tabPlayers);
				clickOnElement(btnAddParticipants);
				clickOnWebElement(rdoSelectParticipant);
				clickOnWebElement(btnAddParticipant);
				clickOnWebElement(btnAdd);
				clickOnWebElement(tabUnmatchedPlayes);
				selectPlayerCheckbox();
			} else {
				selectPlayerCheckbox();
			}

		} catch (Exception e) {
			selectPlayerCheckbox();
		}

		log.info("Ending of clickOnValidPlayerCheckbox method");
	}

	public void selectPlayerCheckbox() {
		log.info("Starting of selectPlayerCheckbox method");

		for (int i = 1; i <= 2; i++) {
			try {
				clickUsingActionsClass(driver.findElement(By.xpath("(//input[@type='checkbox'])[" + i + "]")));
			} catch (Exception e) {
				clickOnWebElement(driver.findElement(By.xpath("(//input[@type='checkbox'])[" + i + "]")));
			}
		}

		log.info("Ending of selectPlayerCheckbox method");
	}

	public void selectPlayerCheckboxs() {
		log.info("Starting of selectPlayerCheckbox method");
		try {
			clickOnWebElement(chkFirstPlayer);
		} catch (Exception e) {
			chkFirstPlayer.click();
		}

		clickOnWebElement(chkSecondPlayers);

		log.info("Ending of selectPlayerCheckbox method");
	}

	public boolean isPlayersCheckboxSelected() {
		log.info("Starting of isPlayersCheckboxSelected method");
		System.out.println(chkFirstPlayers.get(0).isSelected());
		System.out.println(chkSecondPlayers.isSelected());
		log.info("Ending of isPlayersCheckboxSelected method");

		return chkFirstPlayers.get(0).isSelected() && chkSecondPlayers.isSelected();
	}

	public void clickOnSecondPlayerChechbox() {
		log.info("Starting of clickOnSecondPlayerChechbox method");

		clickOnElement(chkSecondPlayers);

		log.info("Ending of clickOnSecondPlayerChechbox method");
	}

	public void selectMultiplePlayers() {
		log.info("Starting of selectMultiplePlayers method");

		try {
			if (chkFirstPlayers.size() < 3) {
				clickOnWebElement(tabPlayers);

				this.implicitWait();
				clickOnElement(btnAddParticipants);
				this.txtBoxSearchParticipant.sendKeys(randomAlphabet(1));
				this.implicitWait();
				clickOnWebElement(rdoSelectParticipant);
				clickOnWebElement(btnAddParticipant);
				clickOnWebElement(btnAdd);

				hardWait(2);
				clickOnWebElement(tabUnmatchedPlayes);
			}
		} catch (Exception e) {
			System.out.println("Greater than 2 UnMatched players displayed");
		}

		for (int i = 1; i <= 3; i++) {
			try {
				clickUsingActionsClass(driver.findElement(By.xpath("(//input[@type='checkbox'])[" + i + "]")));
			} catch (Exception e) {
				clickOnWebElement(driver.findElement(By.xpath("(//input[@type='checkbox'])[" + i + "]")));
			}
		}

		log.info("Ending of selectMultiplePlayers method");
	}

	public void clickOnCreateTeamButton() {
		log.info("Starting of clickOnCreateTeamButton method");

		try {
			clickUsingActionsClass(btnCreateTeam);
		} catch (Exception e) {
			clickOnWebElement(btnCreateTeam);
		}

		log.info("Ending of clickOnCreateTeamButton method");
	}

	public boolean isSameGenderPopupDisplayed() {
		log.info("Starting of addAnotherPlayer method");
		log.info("Ending of addAnotherPlayer method");

		return txtPlayersWithSameGender.isDisplayed();
	}

	public void addMultiplePlayers() {
		log.info("Starting of addMultiplePlayers method");

		driver.navigate().refresh();
		hardWait(3);

		clickOnWebElement(tabPlayers);

		for (int i = 0; i < 3; i++) {

			this.implicitWait();
			clickOnElement(btnAddParticipants);
			this.txtBoxSearchParticipant.sendKeys(randomAlphabet(1));
			this.implicitWait();
			clickOnWebElement(rdoSelectParticipant);
			clickOnWebElement(btnAddParticipant);
			clickOnWebElement(btnAdd);

			hardWait(2);
		}
		clickOnWebElement(tabUnmatchedPlayes);

		log.info("Ending of addMultiplePlayers method");
	}

	public void addAnotherPlayer() {
		log.info("Starting of addAnotherPlayer method");

		driver.navigate().refresh();
		
	//	

		clickOnWebElement(tabPlayers);
		clickOnElement(btnAddParticipants);
		this.txtBoxSearchParticipant.sendKeys("Mohit");
		clickOnWebElement(rdoSelectParticipant);
	//-------
		clickOnWebElement(btnAdd);
		clickOnWebElement(tabUnmatchedPlayes);
		selectPlayerCheckbox();
		clickOnCreateTeamButton();

		log.info("Ending of addAnotherPlayer method");
	}

	public boolean isCreateTeamPopupContains() {
		log.info("Starting of isCreateTeamPopupContains method");

		boolean isCreateTeamPopupContains = false;

		if (isDisplayed(lblCreateTeam)
				&& isDisplayed(lblCreateTeamQuestion)
				&& isDisplayed(btnCreate)
				&& isDisplayed(iconCloseCreateTeamPopup)) {

			isCreateTeamPopupContains = true;
		}

		log.info("Ending of isCreateTeamPopupContains method");

		return isCreateTeamPopupContains;
	}

	public void clickOnCancelButton() {
		log.info("Starting of clickOnCancelButton method");
		try {
			clickUsingActionsClass(btnCancel);
		} catch (Exception e) {
			clickOnWebElement(btnCancel);
		}

		log.info("Ending of clickOnCancelButton method");
	}
	
	public void clickOnCancelButtonOnMixedBracketPopUp() {
		log.info("Starting of clickOnCancelButtonOnMixedBracketPopUp method");
		try {
			clickUsingActionsClass(btnCancelOnMixedPlayerPopUp);
		} catch (Exception e) {
			clickOnWebElement(btnCancelOnMixedPlayerPopUp);
		}

		log.info("Ending of clickOnCancelButtonOnMixedBracketPopUp method");
	}

	public void clickOnCreateButton() {
		log.info("Starting of clickOnCreateButton method");
		try {
			clickUsingActionsClass(btnCreate);
		} catch (Exception e) {
			clickOnWebElement(btnCreate);
		}

		log.info("Ending of clickOnCreateButton method");
	}

	public boolean isNoResultsFoundDisplayed() {
		log.info("Starting of isNoResultsFoundDisplayed method");
		log.info("Ending of isNoResultsFoundDisplayed method");

		return txtNoResultsFound.isDisplayed();
	}

	public void clickOnCloseIcon() {
		log.info("Starting of clickOnCloseIcon method");
		try {
			clickUsingActionsClass(iconClose);
		} catch (Exception e) {
			clickOnWebElement(iconClose);
		}

		log.info("Ending of clickOnCloseIcon method");
	}

	public void clickOnTeamsTab() {
		log.info("Starting of clickOnTeamsTab method");

		clickOnWebElement(tabTeams);

		log.info("Ending of clickOnTeamsTab method");
	}

	public boolean isTeamTabContains() {
		//log.info("Starting of isTeamTabContains method");

		boolean isTeamTabContains = false;
try {
	if (isDisplayed(lblTeamConfirmed) 
			&& isDisplayed(btnSort)
			&& isDisplayed(btnClearFilter)
			&& isDisplayed(iconInfoInTeamsTab)
			&& isDisplayed(lblTeamOne)
			&& isDisplayed(btnEditTeam)
			&& isDisplayed(btnSplitTeam)) {

		isTeamTabContains = true;
	}
} catch (Exception e) {
	isTeamTabContains = false;
}
		

		log.info("Ending of isTeamTabContains method");

		return isTeamTabContains;
	}

	public boolean getTeamConfirmedText() {
		log.info("Starting of getTeamConfirmedText method");
		log.info("Ending of getTeamConfirmedText method");

		return isDisplayed(lblTeamConfirmed);
	}

	public void clickOnEditTeamButton() {
		log.info("Starting of clickOnEditTeamButton method");

		for (WebElement element : lstEditTeam) {
			element.click();
			break;
		}
		log.info("Ending of clickOnEditTeamButton method");
	}

	public boolean isResultsOnClickOfEditTeamDisplayed() {
		log.info("Starting of isResultsOnClickOfEditTeamDisplayed method");

		System.out.println(isDisplayed(iconRemovePlayer));
		System.out.println(isDisplayed(btnSaveChanges));
		System.out.println(isDisplayed(btnCancel));
		boolean isResultsOnClickOfEditTeamDisplayed = false;

		if (isDisplayed(iconRemovePlayer) && isDisplayed(btnSaveChanges) && isDisplayed(btnCancel)) {
			isResultsOnClickOfEditTeamDisplayed = true;
		}
		log.info("Ending of isResultsOnClickOfEditTeamDisplayed method");
		return isResultsOnClickOfEditTeamDisplayed;
	}

	public boolean isPlayerRemovedFromTeam() {
		log.info("Starting of isPlayerRemovedFromTeam method");

		boolean isPlayerRemovedFromTeam = false;

		if (isDisplayed(btnAddPlayer) && isDisplayed(btnSaveChangesDisabled)) {

			isPlayerRemovedFromTeam = true;
		}

		log.info("Ending of isPlayerRemovedFromTeam method");

		return isPlayerRemovedFromTeam;
	}

	public void clickOnRemovePlayerIcon() {
		log.info("Starting of clickOnRemovePlayerIcon method");

		clickOnElement(iconRemovePlayer);

		log.info("Ending of clickOnRemovePlayerIcon method");
	}

	public void clickOnAddPlayerButton() {
		log.info("Starting of clickOnAddPlayerButton method");

		clickOnElement(btnAddPlayer);

		log.info("Ending of clickOnAddPlayerButton method");
	}

	public String getAddPartnerText() {
		log.info("Starting of getAddPartnerText method");
		log.info("Ending of getAddPartnerText method");

		return getText(lblAddPartner);
	}

	public boolean getAddPartnerInfoText() {
		log.info("Starting of getAddPartnerInfoText method");
		log.info("Ending of getAddPartnerInfoText method");

		return isDisplayed(lblAddPartnerInfo);
	}

	public void clickOnCancelAddPartnerButton() {
		log.info("Starting of clickOnCancelAddPartnerButton method");

		clickOnElement(btnCancelAddPartner);

		log.info("Ending of clickOnCancelAddPartnerButton method");
	}

	public boolean getSearchNameText() {
		log.info("Starting of getSearchNameText method");
		log.info("Ending of getSearchNameText method");

		return isDisplayed(txtBoxSearchName);
	}

	public void clickOnPartnersRadioButton() {
		log.info("Starting of clickOnPartnersRadioButton method");

		for (WebElement element : lstPartners) {
			element.click();
			break;
		}
		log.info("Ending of clickOnPartnersRadioButton method");
	}

	public void clickOnAddPartnerButton() {
		log.info("Starting of clickOnAddPartnerButton method");

		clickOnElement(btnAddPartnerInPartnerPage);

		log.info("Ending of clickOnAddPartnerButton method");
	}

	public boolean isClubMembershipPopupContains() {
		log.info("Starting of isClubMembershipPopupContains method");

		boolean isClubMembershipPopupContains = false;

		if (isDisplayed(lblClubMembership) && isDisplayed(lblClubMembershipQuestion) && isDisplayed(rdoNo)
				&& isDisplayed(rdoYes)) {

			isClubMembershipPopupContains = true;
		}
		log.info("Ending of isClubMembershipPopupContains method");

		return isClubMembershipPopupContains;
	}

	public void clickOnAddButton() {
		log.info("Starting of clickOnAddButton method");

		clickOnElement(btnAdd);

		log.info("Ending of clickOnAddButton method");
	}

	public void clickOnSaveChangesButton() {
		log.info("Starting of clickOnSaveChangesButton method");

		clickOnElement(btnSaveChanges);

		log.info("Ending of clickOnSaveChangesButton method");
	}
	public void clickOnEditBracketButton() {
		log.info("Starting of clickOnEditBracketButton method");

		clickOnElement(btnEditBracket);

		log.info("Ending of clickOnEditBracketButton method");
	}

	public boolean isEditTeamPopupDisplayed() {
		log.info("Starting of isEditTeamPopupDisplayed method");

		boolean isEditTeamPopupDisplayed = false;

		if (isDisplayed(lblEditTeam) && isDisplayed(lblRemovePlayer) && isDisplayed(lblRemoveMessage)
				&& isDisplayed(btnGoBack) && isDisplayed(btnConfirm) && isDisplayed(iconClosePopup)) {

			isEditTeamPopupDisplayed = true;
		}
		log.info("Ending of isEditTeamPopupDisplayed method");

		return isEditTeamPopupDisplayed;
	}

	public void clickOnGoBackButton() {
		log.info("Starting of clickOnGoBackButton method");

		clickOnElement(btnGoBack);

		log.info("Ending of clickOnGoBackButton method");
	}

	public void clickOnClosePopupIcon() {
		log.info("Starting of clickOnClosePopupIcon method");

		clickOnElement(iconClosePopup);

		log.info("Ending of clickOnClosePopupIcon method");
	}

	public void clickOnConfirmButton() {
		log.info("Starting of clickOnConfirmButton method");

		clickOnElement(btnConfirm);

		log.info("Ending of clickOnConfirmButton method");
	}

	public boolean getEditSuccessText() {
		log.info("Starting of getEditSuccessText method");
		log.info("Ending of getEditSuccessText method");

		return isDisplayed(lblEditSuccess);
	}

	public String getTeamCreatedSuccessText() {
		log.info("Starting of getTeamCreatedSuccessText method");
		log.info("Ending of getTeamCreatedSuccessText method");

		return getText(lblTeamCreatedSuccess);
	}

	public void clickOnSplitTeamButton() {
		log.info("Starting of clickOnSplitTeamButton method");

		for (WebElement element : lstSplitTeam) {
			clickOnWebElement(element);
			break;
		}
		log.info("Ending of clickOnSplitTeamButton method");
	}

	public String getTeamWithdrawnSuccessText() {
		log.info("Starting of getTeamWithdrawnSuccessText method");
		log.info("Ending of getTeamWithdrawnSuccessText method");

		return getText(lblTeamWithdrawnSuccess);
	}

	public boolean isAddPartnerPageContains() {
		log.info("Starting of isAddPartnerPageContains method");
		boolean isAddPartnerPageContains = false;

		if (isDisplayed(lblAddPartnerInfo) && isDisplayed(btnCancelAddPartner) && isDisplayed(txtBoxSearchName)
				&& isDisplayed(btnAddPartnerDisabled)) {

			isAddPartnerPageContains = true;
		}
		log.info("Ending of isAddPartnerPageContains method");
		return isAddPartnerPageContains;
	}

	public boolean isAddPartnerButtonEnabled() {
		log.info("Starting of isAddPartnerButtonEnabled method");
		log.info("Ending of isAddPartnerButtonEnabled method");

		return btnAddPartnerInPartnerPage.isEnabled();
	}

	public boolean isSaveChangesButtonEnabled() {
		log.info("Starting of isSaveChangesButtonEnabled method");
		log.info("Ending of isSaveChangesButtonEnabled method");

		return btnSaveChanges.isEnabled();
	}

	public boolean isGoBackButtonDisplayed() {
		log.info("Starting of isGoBackButtonDisplayed method");
		log.info("Ending of isGoBackButtonDisplayed method");

		return btnGoBack.isDisplayed();
	}

	public boolean isAreYouSurePopupContains() {
		log.info("Starting of isAreYouSurePopupContains method");
		boolean isAreYouSurePopupContains = false;

		if (isDisplayed(lblAreYouSure) && isDisplayed(btnGoBack) && isDisplayed(btnConfirm)
				&& isDisplayed(iconCloseCreateTeamPopup)) {

			isAreYouSurePopupContains = true;
		}
		log.info("Ending of isAreYouSurePopupContains method");
		return isAreYouSurePopupContains;
	}

	public void clickOnCloseIconInEditTeam() {
		log.info("Starting of clickOnCloseIconInEditTeam method");

		clickOnElement(iconCloseCreateTeamPopup);

		log.info("Ending of clickOnCloseIconInEditTeam method");
	}

	public void selectTeams() {
		log.info("Starting of selectTeams method");
		this.hardWait(5);
		try {
			clickOnWebElement(tabUnmatchedPlayes);
		} catch (Exception e) {
			clickOnElementUsingActionClass(tabUnmatchedPlayes);
		}

		for (int i = 0; i < 8; i++) {
			try {
				this.hardWait(3);
				this.scrollDown(300);
				selectPlayerCheckboxs();
				this.hardWait(2);
				clickOnWebElement(btnCreateTeam);
				this.hardWait(2);
				clickOnWebElement(btnCreate);
				this.hardWait(4);
			} catch (Exception e) {
				this.hardWait(3);
				this.scrollDown(300);
				selectPlayerCheckboxs();
				this.hardWait(2);
				clickOnWebElement(btnCreateTeam);
				this.hardWait(2);
				clickOnWebElement(btnCreate);
				this.hardWait(4);
			}

		}
		log.info("Ending of selectTeams method");

	}

	public void selectTeamsInWaterFall() {
		log.info("Starting of selectTeams method");
		this.hardWait(5);
		try {
			clickOnElementUsingActionClass(tabUnmatchedPlayes);
			this.hardWait(5);
		} catch (Exception e) {
			tabUnmatchedPlayes.click();
			this.hardWait(5);
		}
		for (int i = 0; i < 9; i++) {
			try {
				if (txtName.isDisplayed() == true) {
					this.hardWait(3);
					this.scrollDown(300);
					selectPlayerCheckboxs();
					this.hardWait(2);
					clickOnWebElement(btnCreateTeam);
					this.hardWait(2);
					clickOnWebElement(btnCreate);
					this.hardWait(4);
				}
			} catch (Exception e) {
				try {
					if (txtName.isDisplayed() == true) {
						this.hardWait(3);
						this.scrollDown(300);
						selectPlayerCheckboxs();
						this.hardWait(2);
						clickOnWebElement(btnCreateTeam);
						this.hardWait(2);
						clickOnWebElement(btnCreate);
						this.hardWait(4);
					}
				} catch (Exception e2) {
					System.out.println();
				}
			}
		}
		log.info("Ending of selectTeams method");
	}

}
