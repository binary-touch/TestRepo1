package com.dupr.pages.addamatch;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BFindBys;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class AddAMatchPage extends DUPRBaseAutomationPage {
	private static final Logger log = LogManager.getLogger(AddAMatchPage.class);

	@B2BFindBy(xpath = "//h6[text()='Add a Match']")
	private WebElement tabAddAMatch;

	@B2BFindBy(xpath = "//h5[text()='Location']/parent::div//following-sibling::div//input")
	private WebElement txtBoxLocation;

	@B2BFindBy(xpath = "//h5[text()='Event Name']/parent::div/following-sibling::div[1]/*/*/input")
	private WebElement txtBoxEventName;

	@B2BFindBy(xpath = "//h5[text()='Match Date']/parent::div/following-sibling::div/*/div/input")
	private WebElement txtBoxMatchDate;

	@B2BFindBy(xpath = "//button[text()='Add Your Partner']")
	private WebElement btnAddPartner;

	@B2BFindBy(xpath = "//ul[contains(@class,'MuiList-root MuiList-padding')]/li[contains(@class, 'MuiListItem-gutters MuiListItem-divider')]")
	private List<WebElement> lstLocations;

	@B2BFindBy(xpath = "//p[text()='Location is required. ']")
	private WebElement txtLocationRequired;

	@B2BFindBy(xpath = "//span[contains(@class, 'MuiRadio-colorPrimary')]/input[contains(@class,'PrivateSwitchBase-input')]")
	private WebElement rdoPlayer;

	@B2BFindBy(xpath = "//button[text()='Add Player']")
	private WebElement btnAddPlayer;

	@B2BFindBy(xpath = "//input[contains(@class, 'MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd')]")
	private WebElement txtBoxMatchdate;

	@B2BFindBy(xpath = "//h3[text()='Add a Score']")
	private WebElement lblAddScore;

	@B2BFindBy(xpath = "//h2[text()='Match Details']")
	private WebElement lblMatchDetails;

	@B2BFindBy(xpath = "//div[contains(@class, 'MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation3')]/div")
	private WebElement addPartnerPlayer;

	// @B2BFindBy(xpath = "//button[contains(@class,'MuiButton-containedPrimary')]")
	@B2BFindBy(xpath = "//button[@type='submit' and text()='Submit']")
	private WebElement btnSubmit;

	@B2BFindBy(xpath = "//div[contains(@class, 'MuiDialogActions-root')]/button[text()='Submit']")
	private WebElement btnSubmitInFinalScoresPopup;

	@B2BFindBy(xpath = "//button[contains(@class, 'MuiIconButton-colorPrimary MuiIconButton-sizeLarge')]")
	private WebElement iconPlus;

	@B2BFindBy(xpath = "//button[text()='Add Player' and @disabled]")
	private WebElement btnAddPlayerDisabled;

	@B2BFindBy(xpath = "//button[@value='SINGLES']")
	private WebElement btnSingles;

	@B2BFindBy(xpath = "//button[@value='DOUBLES']")
	private WebElement btnDoubles;

	@B2BFindBy(xpath = "//input[@class='PrivateSwitchBase-input MuiSwitch-input css-1m9pwf3']/following-sibling::span/following-sibling::span")
	private WebElement tglRallyMatch;

	@B2BFindBy(xpath = "//button[ text()='Cancel']")
	private WebElement btnCancel;

	@B2BFindBy(xpath = "//input[@id='Search']")
	private WebElement txtBoxSearch;

	@B2BFindBy(xpath = "//button[text()='Invite']")
	private WebElement btnInvite;

	@B2BFindBys(@B2BFindBy(xpath = "//span[contains(@class, 'MuiFormControlLabel-label')]/div"))
	private List<WebElement> lstPlayersNames;

	@B2BFindBys(@B2BFindBy(xpath = "//button[contains(@class,'MuiButton-containedPrimary')]/ancestor::div/preceding-sibling::div[contains(@class, 'MuiGrid-grid-md-6')]/button[contains(@class,'MuiButton-outlinedSizeMedium')]"))
	private List<WebElement> lstOfAddYourPartnersButtons;

	@B2BFindBy(xpath = "(//button[text()='Add Your Opponent'])[1]")
	private WebElement btnAddOpponent;

	@B2BFindBy(xpath = "//h4[@id='customized-dialog-title']")
	private WebElement lblInviteAPlayer;

	@B2BFindBy(xpath = "//h5[text()='Full Name']/parent::div/following-sibling::div//input")
	private WebElement txtBoxFullName;

	@B2BFindBy(xpath = "//h5[text()='Email']/parent::div/following-sibling::div//input")
	private WebElement txtBoxEmailAddress;

	@B2BFindBy(xpath = "//h5[text()='Phone Number']/parent::div/following-sibling::div//input")
	private WebElement txtBoxPhoneNumber;

	@B2BFindBy(xpath = "//button[text()='Back']")
	private WebElement btnBack;

	@B2BFindBy(xpath = "//button[text()='Send Invite']")
	private WebElement btnSendInvite;

	@B2BFindBy(xpath = "//h4[@id='customized-dialog-title']")
	private WebElement lblInviteSent;

	@B2BFindBy(xpath = "//button[text()='OK']")
	private WebElement btnOK;

	@B2BFindBy(xpath = "//button[text()='Ok']")
	private WebElement btnOk;

	@B2BFindBy(xpath = "//h4[text()='Team 2']/parent::div/following-sibling::div/div[contains(@class,'MuiBox-root')]")
	private WebElement firstOpponent;

	@B2BFindBy(xpath = "(//span[text()='Game 1']/parent::div/following-sibling::div/child::div/following-sibling::div[contains(@class, 'MuiFormControl-root')])[1]//input")
	private WebElement txtBoxGameOneScoreTeamOne;

	@B2BFindBy(xpath = "//span[contains(@class, 'MuiChip-label MuiChip-labelSmall')]/parent::div/following-sibling::div/following-sibling::div//input")
	private WebElement txtBoxGameOneScoreTeamTwo;

	@B2BFindBy(xpath = "(//span[text()='Game 2']/parent::div/following-sibling::div/child::div//input)[1]")
	private WebElement txtBoxGameTwoScoreTeamOne;

	@B2BFindBy(xpath = "(//span[text()='Game 2']/parent::div/following-sibling::div/child::div//input)[2]")
	private WebElement txtBoxGameTwoScoreTeamTwo;

	@B2BFindBy(xpath = "(//span[text()='Game 3']/parent::div/following-sibling::div/child::div//input)[1]")
	private WebElement txtBoxGameThreeScoreTeamone;

	@B2BFindBy(xpath = "(//span[text()='Game 3']/parent::div/following-sibling::div/child::div//input)[2]")
	private WebElement txtBoxGameThreeScoreTeamTwo;

	@B2BFindBy(xpath = "//h4[@id='customized-dialog-title' and text()='Success']")
	private WebElement lblSuccess;

	@B2BFindBy(xpath = "//h4[text()='Submit Scores for All Games']")
	private WebElement lblSubmitScores;

	@B2BFindBy(xpath = "//div[@class='MuiDialogActions-root MuiDialogActions-spacing css-v0512d']//button[text()='OK']")
	private WebElement btnOkInSuccessPopup;

	@B2BFindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium MuiPhoneNumber-flagButton css-1yxmbwk']//*[local-name()='svg']")
	private WebElement iconFlog;

	@B2BFindBy(xpath = "//p[text()='The winner of the first game must score a minimum of 6 points. ']")
	private WebElement txtValidationScoreLessThanSixInFirstGame;

	@B2BFindBy(xpath = "//p[text()='Score is required.']")
	private WebElement txtValidationScoreRequired;

	@B2BFindBy(xpath = "//p[text()='Either team must be a winner']")
	private WebElement txtValidationEitherTeamMustWinner;

	@B2BFindBy(xpath = "//h6[text()='Players']")
	private WebElement tabPlayers;

	@B2BFindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-148fdm8']")
	private WebElement mnuOpenSettings;

	@B2BFindBy(xpath = "//div[@class='text-dark_blue' and text()='Logout']")
	private WebElement btnLogOut;

	@B2BFindBy(xpath = "//div[@class='MuiBox-root css-19midj6']/img")
	private WebElement imgDUPR;

	@B2BFindBys(@B2BFindBy(xpath = "//button[contains(@class,'Mui-disabled')]"))
	private List<WebElement> lstButtonsAddYourOppentandPartnerDisableMode;

	@B2BFindBys(@B2BFindBy(xpath = "//div[@class='MuiBox-root css-p7q4ra']/h4"))
	private List<WebElement> lstPlayersNamesInBrowsePlayers;

	public AddAMatchPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public void clickOnRallyMatchToggleButton() {
		log.info("Starting of clickOnRallyMatchToggleButton method");

		elementClick(tglRallyMatch);

		log.info("Ending of clickOnRallyMatchToggleButton method");
	}

	public void clickOnSubmitButton() {
		log.info("Starting of clickOnSubmitButton method");

		btnSubmit.submit();

		log.info("Ending of clickOnSubmitButton method");
	}

	public void clickOnSubmitButtonInFinalScoresPopup() {
		log.info("Starting of clickOnSubmitButtonInFinalScoresPopup method");

		clickOnWebElement(btnSubmitInFinalScoresPopup);

		log.info("Ending of clickOnSubmitButtonInFinalScoresPopup method");
	}

	public void clickOnAddAMatchTab() {
		log.info("Starting of clickOnAddAMatchTab method");

		elementClick(tabAddAMatch);

		log.info("Ending of clickOnAddAMatchTab method");
	}

	public boolean isAddAMatchPageContains() {
		log.info("Starting of isAddAMatchPageContains method");

		boolean isAddAMatchPageContains = false;

		if (btnSubmit.isDisplayed() && lblAddScore.isDisplayed() && lblMatchDetails.isDisplayed()
				&& txtBoxMatchdate.isDisplayed() && iconPlus.isDisplayed() && txtBoxLocation.isDisplayed()
				&& txtBoxEventName.isDisplayed() && btnAddPartner.isDisplayed() && btnSingles.isDisplayed()
				&& btnDoubles.isDisplayed() && txtBoxGameOneScoreTeamOne.isDisplayed()
				&& txtBoxGameOneScoreTeamTwo.isDisplayed() && btnDoubles.isDisplayed()) {
			isAddAMatchPageContains = true;
		}

		log.info("Ending of isAddAMatchPageContains method");

		return isAddAMatchPageContains;
	}

	public boolean isInvitePlayerPageContains() {
		log.info("Starting of isInvitePlayerPageContains method");

		boolean isInvitePlayerPageContains = false;

		if (isDisplayed(txtBoxFullName) && isDisplayed(txtBoxEmailAddress) && isDisplayed(txtBoxPhoneNumber)
				&& isDisplayed(btnBack) && isDisplayed(btnSendInvite) && isDisplayed(iconFlog)) {
			isInvitePlayerPageContains = true;
		}

		log.info("Ending of isInvitePlayerPageContains method");

		return isInvitePlayerPageContains;
	}

	public boolean isAddPlayerPageContains() {
		log.info("Starting of isAddPlayerPageContains method");

		boolean isAddPlayerPageContains = false;

		if (isDisplayed(btnCancel) && isDisplayed(btnInvite) && isDisplayed(txtBoxSearch)) {
			isAddPlayerPageContains = true;
		}

		log.info("Ending of isAddPlayerPageContains method");

		return isAddPlayerPageContains;
	}

	public void setLocationInDoubles(String location) {
		log.info("Starting of setLocationInDoubles method");

		explicitWait(txtBoxLocation);
		this.clickOnWebElement(txtBoxLocation);
		txtBoxLocation.sendKeys(location);
		hardWait(3);

		try {
			for (WebElement citylocation : lstLocations) {
				this.implicitWait();
				if (citylocation.getText().equalsIgnoreCase("Hyderabad, Telangana, India")) {
					hardWait(2);
					citylocation.click();
					break;
				}
			}
		} catch (Exception e) {
			if (txtLocationRequired.isDisplayed() == true) {
				for (WebElement citylocation : lstLocations) {
					this.implicitWait();
					hardWait(2);
					clickOnWebElement(citylocation);
				}
			}
		}

		log.info("Ending of setLocationInDoubles method");
	}

	public void setLocationInSingles(String location) {
		log.info("Starting of setLocationInSingles method");

		this.implicitWait();
		this.clickOnWebElement(txtBoxLocation);
		txtBoxLocation.sendKeys(location);

		this.clickOnWebElement(txtBoxLocation);

		for (WebElement citylocation : lstLocations) {
			if (citylocation.getText().equalsIgnoreCase("Hyderabad, Telangana, India")) {
				citylocation.click();
				break;
			}
		}

		log.info("Ending of setLocationInSingles method");
	}

	public void searchWithPlayerName(String name) {
		log.info("Starting of searchWithPlayerName method");

		this.txtBoxSearch.sendKeys(name);

		log.info("Ending of searchWithPlayerName method");
	}

	public String setEventName(String eventName) {
		log.info("Starting of setEventName method");

		this.implicitWait();
		this.clickOnWebElement(txtBoxEventName);

		String newEventName = eventName + randomNumber(5);
		txtBoxEventName.sendKeys(newEventName);

		log.info("Ending of setEventName method");
		return newEventName;
	}

	public void setMatchDate() {
		log.info("Starting of setMatchDate method");

		this.implicitWait();
		this.clickOnWebElement(txtBoxMatchDate);
		// txtBoxMatchDate.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		// txtBoxMatchDate.sendKeys(matchDate);

		log.info("Ending of setMatchDate method");
	}

	public boolean isAddPartnerDisplayed() {
		log.info("Starting of isAddPartnerDisplayed method");
		log.info("Ending of isAddPartnerDisplayed method");

		return isDisplayed(addPartnerPlayer);
	}

	public boolean isGameTwoScoreBoxesDisplayed() {
		log.info("Starting of isGameTwoScoreBoxesDisplayed method");

		boolean isGameTwoScoreBoxesDisplayed = false;

		if (isDisplayed(txtBoxGameTwoScoreTeamOne) && isDisplayed(txtBoxGameTwoScoreTeamTwo)) {
			isGameTwoScoreBoxesDisplayed = true;
		}

		log.info("Ending of isGameTwoScoreBoxesDisplayed method");

		return isGameTwoScoreBoxesDisplayed;
	}

	public boolean isGame3ScoreBoxesDisplayed() {
		log.info("Starting of isGame3ScoreBoxesDisplayed method");

		boolean isGame3ScoreBoxesDisplayed = false;
		if (isDisplayed(txtBoxGameThreeScoreTeamone) && isDisplayed(txtBoxGameThreeScoreTeamTwo)) {
			isGame3ScoreBoxesDisplayed = true;
		}

		log.info("Ending of isGame3ScoreBoxesDisplayed method");

		return isGame3ScoreBoxesDisplayed;
	}

	public void clickOnPlayerRadioButton() {
		log.info("Starting of clickOnPlayerRadioButton method");

		elementClick(rdoPlayer);

		log.info("Ending of clickOnPlayerRadioButton method");
	}

	public void clickOnAddPlayerButton() {
		log.info("Starting of clickOnAddPlayerButton method");

		elementClick(btnAddPlayer);

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

	public void clickOnAddPlayer() {
		log.info("Starting of clickOnAddPlayer method");

		scrollDown(700);
		WebElement Partner = null;

		for (int i = 0; i <= lstOfAddYourPartnersButtons.size() - 1;) {
			Partner = lstOfAddYourPartnersButtons.get(0);
			break;
		}
		clickOnWebElement(Partner);
		// elementClick(Partner);

		log.info("Ending of clickOnAddPlayer method");
	}

	public void clickOnInviteButton() {
		log.info("Starting of clickOnInviteButton method");

		this.clickOnWebElement(btnInvite);

		log.info("Ending of clickOnInviteButton method");
	}

	public void setFullName(String fullName) {
		log.info("Starting of setFullName method");

		this.txtBoxFullName.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		sendKeys(txtBoxFullName, fullName);

		log.info("Ending of setFullName method");
	}

	public void setEmail(String email) {
		log.info("Starting of setEmail method");

		this.txtBoxEmailAddress.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		sendKeys(txtBoxEmailAddress, email + randomNumber(3) + "@gmail.com");

		log.info("Ending of setEmail method");
	}

	public void setEmailForNegativeScenarios(String email) {
		log.info("Starting of setEmailForNegativeScenarios method");

		this.txtBoxEmailAddress.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		sendKeys(txtBoxEmailAddress, email);

		log.info("Ending of setEmailForNegativeScenarios method");
	}

	public void clickOnSendInviteButton() {
		log.info("Starting of clickOnSendInviteButton method");

		elementClick(btnSendInvite);

		log.info("Ending of clickOnSendInviteButton method");
	}

	public String getInviteSentText() {
		log.info("Starting of getInviteSentText method");
		log.info("Ending of getInviteSentText method");

		return getText(lblInviteSent);
	}

	public boolean isOkButtonDisplayed() {
		log.info("Starting of isOkButtonDisplayed method");
		log.info("Ending of isOkButtonDisplayed method");

		return isDisplayed(btnOK);
	}

	public boolean isFlogIconDisplayed() {
		log.info("Starting of isFlogIconDisplayed method");
		log.info("Ending of isFlogIconDisplayed method");

		return isDisplayed(iconFlog);
	}

	public void clickOnOkButtonInInviteSentPopup() {
		log.info("Starting of clickOnOkButtonInInviteSentPopup method");

		try {
			btnOk.click();
		} catch (ElementClickInterceptedException e) {
			clickOnWebElement(btnOk);
		}

		log.info("Ending of clickOnOkButtonInInviteSentPopup method");
	}

	public void clickOnOkButton() {
		log.info("Starting of clickOnOKButton method");

		try {
			btnOK.click();
		} catch (ElementClickInterceptedException e) {
			clickOnWebElement(btnOK);
		}

		log.info("Ending of clickOnOKButton method");
	}

	public boolean isFirstOpponentDisplayed() {
		log.info("Starting of isFirstOPPonentDisplayed method");
		this.scrollDown(500);
		log.info("Ending of isFirstOPPonentDisplayed method");

		return isDisplayed(firstOpponent);
	}

	public void setGameOneScores(String gameOneScoreTeamOne, String gameOneScoreTeamTwo) {
		log.info("Starting of setGameOneScores method");

		scrollDown(500);
		clickOnWebElement(txtBoxGameOneScoreTeamOne);
		sendKeys(txtBoxGameOneScoreTeamOne, gameOneScoreTeamOne);
		clickOnWebElement(txtBoxGameOneScoreTeamTwo);
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

		sendKeys(txtBoxGameTwoScoreTeamOne, gameTwoScoreTeamOne);
		sendKeys(txtBoxGameTwoScoreTeamTwo, gameTwoScoreTeamTwo);

		log.info("Ending of setGameTwoScores method");
	}

	public String getSuccessText() {
		log.info("Starting of getSuccessText method");
		log.info("Ending of getSuccessText method");

		return getText(lblSuccess);
	}

	public String getSubmitScoresText() {
		log.info("Starting of getSubmitScoresText method");
		log.info("Ending of getSubmitScoresText method");

		return getText(lblSubmitScores);
	}

	public void clickOnOKButtonInSuccessPopup() {
		log.info("Starting of clickOnOKButtonSuccessPopup method");

		clickOnElement(btnOkInSuccessPopup);

		log.info("Ending of clickOnOKButtonSuccessPopup method");
	}

	public void clickOnRallyMatchToggle() {
		log.info("Starting of clickOnRallyMatchToggle method");

		elementClick(tglRallyMatch);

		log.info("Ending of clickOnRallyMatchToggle method");
	}

	public void clickOnSinglesButton() {
		log.info("Starting of clickOnSinglesButton method");

		explicitWait(btnSingles);
		clickOnElement(btnSingles);

		log.info("Ending of clickOnSinglesButton method");
	}

	public void setGameThreeScores(String gameThreeScoreTeamOne, String gameThreeScoreTeamTwo) {
		log.info("Starting of setGameThreeScores method");

		sendKeys(txtBoxGameThreeScoreTeamone, gameThreeScoreTeamOne);
		sendKeys(txtBoxGameThreeScoreTeamTwo, gameThreeScoreTeamTwo);

		log.info("Ending of setGameThreeScores method");
	}

	public String getValidationScoreLessThanSix() {
		log.info("Starting of getValidationScoreLessThanSix method");
		log.info("Ending of getValidationScoreLessThanSix method");

		return getText(txtValidationScoreLessThanSixInFirstGame);
	}

	public String getValidationScoreIsRequired() {
		log.info("Starting of getValidationvalidationScorerequired method");
		log.info("Ending of getValidationvalidationScorerequired method");

		return getText(txtValidationScoreRequired);
	}

	public String getValidationEitherTeamMustWinner() {
		log.info("Starting of getValidationvalidationEitherTeamMustWinner method");
		log.info("Ending of getValidationvalidationEitherTeamMustWinner method");

		return getText(txtValidationEitherTeamMustWinner);
	}

	public void clickOnPlayersTab() {
		log.info("Starting of clickOnPlayersTab method");

		elementClick(tabPlayers);

		log.info("Ending of clickOnPlayersTab method");
	}

	public void clickOnProfileIcon() {
		log.info("Starting of clickOnProfileIcon method");

		elementClick(mnuOpenSettings);

		log.info("Ending of clickOnProfileIcon method");
	}

	public void clickOnLogOut() {
		log.info("Starting of clickOnLogOut method");

		elementClick(btnLogOut);

		log.info("Ending of clickOnLogOut method");
	}

	public void clickOnDUPRImage() {
		log.info("Starting of clickOnDUPRImage method");

		elementClick(imgDUPR);

		log.info("Ending of clickOnDUPRImage method");
	}

	public boolean isAddYourPartnerAndOpponentButtonsDisplayed() {
		log.info("Starting of isAddYourPartnerAndOpponentButtonsDisplayed method");

		scrollDown(500);
		boolean isAddYourPartnerAndopponentButtonsDisplayed = false;

		for (WebElement Player : lstButtonsAddYourOppentandPartnerDisableMode) {
			if (isDisplayed(Player)) {
				isAddYourPartnerAndopponentButtonsDisplayed = true;
			}
		}

		log.info("Ending of isAddYourPartnerAndOpponentButtonsDisplayed method");

		return isAddYourPartnerAndopponentButtonsDisplayed;
	}

	public String getPlayerName(String name) {
		log.info("Starting of getPlayerName method");

		this.implicitWait();
		String playerName = null;

		for (int i = 0; i <= lstPlayersNamesInBrowsePlayers.size() - 1; i++) {

			if (lstPlayersNamesInBrowsePlayers.get(i).getText().contains(name)) {
				playerName = lstPlayersNamesInBrowsePlayers.get(i).getText();
			}
		}

		log.info("Ending of getPlayerName method");

		return playerName;
	}

	public void clickOnCancelButton() {
		log.info("Starting of clickOnCancelButton method");

		elementClick(btnCancel);

		log.info("Ending of clickOnCancelButton method");
	}

	public void clickOnAddOpponentButton() {
		log.info("Starting of clickOnAddOpponentButton method");

		elementClick(btnAddOpponent);

		log.info("Ending of clickOnAddOpponentButton method");
	}
}
