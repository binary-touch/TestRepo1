package com.dupr.pages;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BFindBys;

public class AddAMatchPage extends DUPRBaseAutomationPage {
	private static final Logger log = LogManager.getLogger(AddAMatchPage.class);

	@B2BFindBy(xpath = "//div[@class='MuiButtonBase-root MuiListItemButton-root MuiListItemButton-gutters MuiListItemButton-root MuiListItemButton-gutters css-o5pjoi'] //h6[text()='Add a Match']")
	private WebElement tabAddAMatch;

	@B2BFindBy(xpath = "//input[@name='location']")
	private WebElement txtBoxLocation;

	@B2BFindBy(xpath = "//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq' and @placeholder='Enter Event Name']")
	private WebElement txtBoxEventName;

	@B2BFindBy(xpath = "//input[@placeholder='mm/dd/yyyy']")
	private WebElement txtBoxMatchDate;

	@B2BFindBy(xpath = "//button[text()='Add Your Partner']")
	private WebElement btnAddPartner;

	@B2BFindBy(xpath = "//ul[@class='MuiList-root MuiList-padding css-1xifowx']/li")
	private List<WebElement> lstLocations;

	@B2BFindBy(xpath = "//h4[@class='MuiTypography-root MuiTypography-h4 css-131o6ft']")
	private List<WebElement> lstPlayers;

	@B2BFindBy(xpath = "//input[@class='PrivateSwitchBase-input css-1m9pwf3']")
	private WebElement rdoPlayer;

	@B2BFindBy(xpath = "//button[text()='Add Player']")
	private WebElement btnAddPlayer;

	@B2BFindBy(xpath = "//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd css-1uvydh2']")
	private WebElement txtBoxMatchdate;

	@B2BFindBy(xpath = "//h3[@class='MuiTypography-root MuiTypography-h3 css-hyqj8z']")
	private WebElement lblAddScore;

	@B2BFindBy(xpath = "//h2[@class='MuiTypography-root MuiTypography-h2 css-ir0jjf']")
	private WebElement lblMatchDetails;

	@B2BFindBy(xpath = "//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation3 css-m85v0k']/div")
	private WebElement addPartnerplayer;

	@B2BFindBy(xpath = "//button[contains(@class,'MuiButton-containedPrimary')]")
	private WebElement btnSubmit;

	@B2BFindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorSuccess MuiIconButton-sizeLarge css-11yeg47']")
	private WebElement iconPlus;

	@B2BFindBy(xpath = "//button[text()='Add Player' and @disabled]")
	private WebElement btnAddPlayerDisabled;

	@B2BFindBy(xpath = "//button[text()='Add Player']")
	private WebElement btnAddplayer;

	@B2BFindBy(xpath = "//button[@value='SINGLES']")
	private WebElement btnSingles;

	@B2BFindBy(xpath = "//button[@value='DOUBLES']")
	private WebElement btnDoubles;

	@B2BFindBy(xpath = "//input[@class='PrivateSwitchBase-input MuiSwitch-input css-1m9pwf3']/following-sibling::span/following-sibling::span")
	private WebElement btnToggle;

	@B2BFindBy(xpath = "//button[ text()='Cancel']")
	private WebElement btnCancle;

	@B2BFindBy(xpath = "//input[@id='Search']")
	private WebElement txtBoxSearch;

	@B2BFindBy(xpath = "//input[@id='Search']/ancestor::div[@class='MuiBox-root css-i9gxme']/following-sibling::button")
	private WebElement btnInvite;

	@B2BFindBys(@B2BFindBy(xpath = "//h4[@class='MuiTypography-root MuiTypography-h4 css-131o6ft']"))
	private List<WebElement> lstPlayersNames;

	@B2BFindBy(xpath = "//button[contains(@class,'MuiButton-containedPrimary')]/ancestor::div/preceding-sibling::Div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-6 css-iol86l']/button")
	private List<WebElement> lstOfAddYourPartnersButtons;

	@B2BFindBy(xpath = "//button[contains(@class,'MuiButton-containedPrimary')]/ancestor::div/preceding-sibling::Div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-6 css-iol86l']/button")
	private WebElement btnSecondOpponet;

	@B2BFindBy(xpath = "//h4[@id='customized-dialog-title']")
	private WebElement lblInviteAPlayer;

	@B2BFindBy(xpath = "//h5[text()='Full Name']/parent::div/following-sibling::div//input")
	private WebElement txtBoxFullName;

	@B2BFindBy(xpath = "//h5[text()='Email Address']/parent::div/following-sibling::div//input")
	private WebElement txtBoxEmailAddress;

	@B2BFindBy(xpath = "//h5[text()='Phone Number']/parent::div/following-sibling::div//input")
	private WebElement txtBoxPhoneNumber;

	@B2BFindBy(xpath = "//button[text()='Back']")
	private WebElement btnBack;

	@B2BFindBy(xpath = "//div[@class='MuiDialogActions-root MuiDialogActions-spacing css-v0512d']/button/following-sibling::button")
	private WebElement btnSendInvite;

	@B2BFindBy(xpath = "//h4[@id='customized-dialog-title']")
	private WebElement lblInviteSent;

	@B2BFindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium css-1971f2t']")
	private WebElement btnOk;

	@B2BFindBy(xpath = "//h4[text()='Team 2']/parent::div/following-sibling::div/div[@class='MuiBox-root css-79elbk']")
	private WebElement firstOpponent;

	@B2BFindBy(xpath = "//span[text()='Game 1']/parent::div/following-sibling::div/child::div/following-sibling::div[@class='MuiFormControl-root css-1tqbe2y']//input")
	private WebElement txtBoxGameOneScoreTeamOne;

	@B2BFindBy(xpath = "//span[@class='MuiChip-label MuiChip-labelSmall css-tavflp']/parent::div/following-sibling::div/following-sibling::div//input")
	private WebElement txtBoxGameOneScoreTeamTwo;

	@B2BFindBy(xpath = "//span[text()='Game 2']/parent::div/following-sibling::div/child::div[@class='MuiFormControl-root css-1tqbe2y']//input")
	private WebElement txtBoxGametwoScoreTeamOne;

	@B2BFindBy(xpath = "//span[text()='Game 2']/parent::div/following-sibling::div/following-sibling::div//input")
	private WebElement txtBoxGametwoScoreTeamTwo;

	@B2BFindBy(xpath = "//span[text()='Game 3']/parent::div/following-sibling::div/child::div/following-sibling::div[@class='MuiFormControl-root css-1tqbe2y']//input")
	private WebElement txtBoxGameThreeScoreTeamone;

	@B2BFindBy(xpath = "//span[text()='Game 3']/parent::div/following-sibling::div/following-sibling::div//input")
	private WebElement txtBoxGameThreeScoreTeamTwo;

	@B2BFindBy(xpath = "//h4[@id='customized-dialog-title']")
	private WebElement lblSuccess;

	@B2BFindBy(xpath = "//button[text()='Add Your Partner' and @disabled]")
	private WebElement btnAddYourPartnerDisabled;

	@B2BFindBy(xpath = "//button[text()='Add Your Opponent' and @disabled]/parent::div/preceding-sibling::div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-6 css-iol86l']/button[text()='Add Your Opponent']")
	private WebElement btnAddYourOpponentInSingles;

	public AddAMatchPage(WebDriver driver) {
		super(driver);
	}

	public void clickOnRollyMatchToggleButton() {
		log.info("Starting of clickOnRollyMatchToggleButton method");
		try {
			this.clickOnWebElement(btnToggle);
		} catch (Exception e) {
			this.clickOnElement(btnToggle);
		}
		log.info("Ending of clickOnRollyMatchToggleButton method");
	}

	public void clickOnSubmitButton() {
		log.info("Starting of clickOnSubmitButton method");
		try {
			this.clickOnWebElement(btnSubmit);
		} catch (Exception e) {
			this.clickOnElement(btnSubmit);
		}
		log.info("Ending of clickOnSubmitButton method");
	}

	public void clickOnAddAMatchTab() {
		log.info("Starting of clickOnAddAMatchTab method");
		try {
			this.clickOnWebElement(tabAddAMatch);
		} catch (Exception e) {
			this.clickOnElement(tabAddAMatch);
		}
		log.info("Ending of clickOnAddAMatchTab method");
	}

	public boolean isAddAMatchPageContains() {
		log.info("Starting of isSearchPlayersPageContains method");

		boolean isSearchPlayersPageContains = false;

		if (isDisplayed(btnSubmit) && isDisplayed(lblAddScore) && isDisplayed(lblMatchDetails)
				&& isDisplayed(txtBoxMatchdate) && isDisplayed(iconPlus)) {
			isSearchPlayersPageContains = true;
		}
		log.info("Ending of isSearchPlayersPageContains method");

		return isSearchPlayersPageContains;
	}

	public boolean isInvitePlayerPageContains() {
		log.info("Starting of isSearchPlayersPageContains method");

		boolean isSearchPlayersPageContains = false;

		if (isDisplayed(txtBoxFullName) && isDisplayed(txtBoxEmailAddress) && isDisplayed(txtBoxPhoneNumber)
				&& isDisplayed(btnBack) && isDisplayed(btnSendInvite)) {
			isSearchPlayersPageContains = true;
		}
		log.info("Ending of isSearchPlayersPageContains method");

		return isSearchPlayersPageContains;
	}

	public boolean isAddPlayerPageContains() {
		log.info("Starting of isAddPlayerPageContains method");

		boolean isSearchPlayersPageContains = false;

		if (isDisplayed(btnCancle) && isDisplayed(btnInvite) && isDisplayed(txtBoxSearch)) {
			isSearchPlayersPageContains = true;
		}
		log.info("Ending of isAddPlayerPageContains method");

		return isSearchPlayersPageContains;
	}

	public void setLocation(String location) {
		log.info("Starting of setLocation method");

		this.impicitWait();
		this.clickOnWebElement(txtBoxLocation);
		txtBoxLocation.sendKeys(location);
		for (WebElement citylocation : lstLocations) {
			if (citylocation.getText().equalsIgnoreCase("Hyderabad, Telangana, India")) {
				citylocation.click();
				break;
			}
		}
		log.info("Ending of setLocation method");
	}

	public void searchWithPlayerName() {
		log.info("Starting of searchWithPlayerName method");
		String name = "";
		for (WebElement playerName : lstPlayersNames) {
			name = playerName.getText();
		}
		this.clickOnWebElement(txtBoxSearch);
		this.sendKeys(txtBoxSearch, name);

		log.info("Ending of searchWithPlayerName method");
	}

	public void setEventName(String eventName) {
		log.info("Starting of setEventName method");

		this.impicitWait();
		this.clickOnWebElement(txtBoxEventName);
		txtBoxEventName.sendKeys(eventName);

		log.info("Ending of setEventName method");
	}
	public void setMatchDate(String matchDate) {
		log.info("Starting of setMatchDate method");

		this.impicitWait();
		this.clickOnWebElement(txtBoxMatchDate);
		txtBoxMatchDate.sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
		txtBoxMatchDate.sendKeys(matchDate);

		log.info("Ending of setMatchDate method");
	}

	public void clickOnAddPartnerbutton() {
		log.info("Starting of clickOnAddPartnerbutton method");

		try {
			this.clickOnWebElement(btnAddPartner);
		} catch (Exception e) {
			this.clickOnElement(btnAddPartner);
		}

		log.info("Ending of clickOnAddPartnerbutton method");
	}

	public boolean isAddPartnerDisplayed() {
		log.info("Starting of isAddPartnerDisplayed method");
		log.info("Ending of isAddPartnerDisplayed method");

		return isDisplayed(addPartnerplayer);
	}

	public void clickOnPlayerRadioButton() {
		log.info("Starting of clickOnPlayerRadioButton method");

		try {
			this.clickOnWebElement(rdoPlayer);
		} catch (Exception e) {
			this.clickOnElement(rdoPlayer);
		}

		log.info("Ending of clickOnPlayerRadioButton method");
	}

	public void clickOnAddPlayerButton() {
		log.info("Starting of clickOnAddPlayerButton method");

		try {
			this.clickOnWebElement(btnAddPlayer);
		} catch (Exception e) {
			this.clickOnElement(btnAddPlayer);
		}

		log.info("Ending of clickOnAddPlayerButton method");
	}

	public boolean isAddPlayerButtonDisabled() {
		log.info("Starting of isAddPlayerButtonDisabled method");
		log.info("Ending of isAddPlayerButtonDisabled method");

		return isDisplayed(btnAddPlayerDisabled);
	}

	public boolean isAddPlayerButtonEnabled() {
		log.info("Starting of isAddPlayerButtonEnabled method");
		log.info("Ending of isAddPlayerButtonEnabled method");

		return btnAddPlayer.isEnabled();
	}

	public void clickOnFirstOpponent() {
		log.info("Starting of clickOnFirstOpponent method");
		WebElement Partner = null;
		for (int i = 0; i < lstOfAddYourPartnersButtons.size() - 1; i++) {
			Partner = lstOfAddYourPartnersButtons.get(0);
		}
		try {
			this.clickOnWebElement(Partner);
		} catch (Exception e) {
			this.clickOnElement(Partner);
		}

		log.info("Ending of clickOnFirstOpponent method");
	}

	public void clickOnInviteButton() {
		log.info("Starting of clickOnInviteButton method");

		this.clickOnWebElement(btnInvite);

		log.info("Ending of clickOnInviteButton method");
	}

	public void setFullName(String fullName) {
		log.info("Starting of isAddPlayerButtonEnabled method");

		this.clickOnWebElement(txtBoxFullName);
		sendKeys(txtBoxFullName, fullName);

		log.info("Ending of isAddPlayerButtonEnabled method");
	}

	public void setEmail(String email) {
		log.info("Starting of isAddPlayerButtonEnabled method");

		this.clickOnWebElement(txtBoxEmailAddress);
		sendKeys(txtBoxEmailAddress, email);

		log.info("Ending of isAddPlayerButtonEnabled method");
	}

	public void clickOnSendInviteButton() {
		log.info("Starting of clickOnSendInviteButton method");
		try {
			this.clickOnWebElement(btnSendInvite);
		} catch (Exception e) {
			this.clickOnElement(btnSendInvite);
		}

		log.info("Ending of clickOnSendInviteButton method");
	}

	public String getInviteSentText() {
		log.info("Starting of clickOnSendInviteButton method");
		log.info("Ending of clickOnSendInviteButton method");

		return getText(lblInviteSent);
	}

	public boolean isOkButtonDisplayed() {
		log.info("Starting of isOkButtonDisplayed method");
		log.info("Starting of isOkButtonDisplayed method");

		return isDisplayed(btnOk);
	}

	public void clickOnOKButton() {
		log.info("Starting of clickOnOKButton method");
		try {
			this.clickOnWebElement(btnOk);
		} catch (Exception e) {
			clickOnElement(btnOk);
		}

		log.info("Ending of clickOnOKButton method");
	}

	public boolean isFirstOPPonentDisplayed() {
		log.info("Starting of isFirstOPPonentDisplayed method");
		log.info("Starting of isFirstOPPonentDisplayed method");

		return isDisplayed(firstOpponent);
	}

	public void clickOnSecondOpponent() {
		log.info("Starting of clickOnSecondOpponent method");

		try {
			this.clickOnWebElement(btnSecondOpponet);
		} catch (Exception e) {
			clickOnElement(btnSecondOpponet);
		}

		log.info("Starting of clickOnSecondOpponent method");
	}

	public void setGameOneScores(String gameOneScoreTeamOne, String gameOneScoreTeamTwo) {
		log.info("Starting of setGameOneScores method");

		sendKeys(txtBoxGameOneScoreTeamOne, gameOneScoreTeamOne);
		sendKeys(txtBoxGameOneScoreTeamTwo, gameOneScoreTeamTwo);

		log.info("Ending of setGameOneScores method");
	}

	public void clickOnPlusIcon() {
		log.info("Starting of clickOnPlusIcon method");

		clickOnElement(iconPlus);

		log.info("Ending of clickOnPlusIcon method");
	}

	public void setGameTwoScores(String gameTwoScoreTeamOne, String gameTwoScoreTeamTwo) {
		log.info("Starting of setGameTwoScores method");

		sendKeys(txtBoxGametwoScoreTeamOne, gameTwoScoreTeamOne);
		sendKeys(txtBoxGametwoScoreTeamTwo, gameTwoScoreTeamTwo);

		log.info("Ending of setGameTwoScores method");
	}

	public String getSuccessText() {
		log.info("Starting of getSuccessText method");
		log.info("Ending of getSuccessText method");
		return getText(lblSuccess);
	}

	public boolean isOKButtonDisplayed() {
		log.info("Starting of isOKButtonDisplayed method");
		log.info("Ending of isOKButtonDisplayed method");
		return isDisplayed(btnOk);
	}

	public void clickOnOKButtonScoreForSubmit() {
		log.info("Starting of clickOnOKButtonScoreForSubmit method");
		clickOnElement(btnOk);
		log.info("Ending of clickOnOKButtonScoreForSubmit method");
	}

	public void clickOnRallyMatchToggle() {
		log.info("Starting of clickOnRallyMatchToggle method");

		try {
			clickOnWebElement(btnToggle);
		} catch (Exception e) {
			clickOnElement(btnToggle);
		}

		log.info("Ending of clickOnRallyMatchToggle method");
	}

	/*
	 * public boolean isRallymatchToggleSelectedYes() {
	 * log.info("Starting of isToggleButtonSelectedYes method");
	 * log.info("Starting of isToggleButtonSelectedYes method"); return
	 * btnToggle.isSelected(); }
	 */

	public void clickOnSinglesButton() {
		log.info("Starting of clickOnSinglesButton method");
		clickOnElement(btnSingles);
		log.info("Ending of clickOnSinglesButton method");
	}

	public boolean isAddYourPartnerButtonEnabled() {
		log.info("Starting of isAddYourPartnerButtonEnabled method");
		boolean partnerButton = false;
		try {
			for (WebElement partner : lstOfAddYourPartnersButtons) {
				if (partner.isEnabled()) {
					partnerButton = true;
					break;
				}
			}
		} catch (Exception e) {
			partnerButton = false;
		}

		log.info("Starting of isAddYourPartnerButtonEnabled method");

		return partnerButton;
	}

	public boolean isAddYourPartnerButtonDisplayed() {
		log.info("Starting of isAddYourPartnerDisabledButtonDisplayed method");
		log.info("Ending of isAddYourPartnerDisabledButtonDisplayed method");
		return isDisplayed(btnAddYourPartnerDisabled);
	}

	public void clickOnAddYourOpponent() {
		log.info("Starting of clickOnAddYourOpponent method");
		
		try {
			this.clickOnWebElement(btnAddYourOpponentInSingles);
		} catch (Exception e) {
			this.clickOnElement(btnAddYourOpponentInSingles);
		}

		log.info("Ending of clickOnAddYourOpponent method");

	}
	public void setGameThreeScores(String gameThreeScoreTeamOne, String gameThreeScoreTeamTwo) {
		log.info("Starting of setGameOneScores method");

		sendKeys(txtBoxGameThreeScoreTeamone, gameThreeScoreTeamOne);
		sendKeys(txtBoxGameThreeScoreTeamTwo, gameThreeScoreTeamTwo);

		log.info("Ending of setGameOneScores method");
	}

}
