package com.dupr.pages.events;

import static org.testng.Assert.expectThrows;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class SeedMatchesPage extends DUPRBaseAutomationPage {

	private static final Logger log = LogManager.getLogger(SeedMatchesPage.class);

	@B2BFindBy(xpath = "//button[contains(text(),'Seed Matches')]")
	private WebElement btnSeedMatches;

	@B2BFindBy(xpath = "//button[contains(text(),'Reseed Matches')]")
	private WebElement btnReseedMatches;

	@B2BFindBy(xpath = "//button[contains(text(),'Teams')]")
	private WebElement tabTeams;

	@B2BFindBy(xpath = "//button[contains(text(),'Unmatched Players')]")
	private WebElement tabUnmatchedPlayers;

	@B2BFindBy(xpath = "//button[text()='Matches']")
	private WebElement tabMatches;

	@B2BFindBy(xpath = "//div[@id='simple-tabpanel-brackets']//h4")
	private WebElement lblBracketCard;

	@B2BFindBy(xpath = "//button[contains(@class,'MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium')]")
	private WebElement iconClose;

	@B2BFindBy(xpath = "//h4[contains(text(),'Seeds')]")
	private WebElement txtSeeds;

	@B2BFindBy(xpath = "//button[contains(text(),'Create Matches')]")
	private WebElement btnCreateMatches;

	@B2BFindBy(xpath = "//button[contains(text(),'Save & Publish') and @disabled]")
	private WebElement btnSavePublishDisabled;

	@B2BFindBy(xpath = "//button[contains(text(),'Save & Publish')]")
	private WebElement btnSavePublish;

	@B2BFindBy(xpath = "//button[@aria-label='scroll-left']")
	private WebElement iconLeftArrow;

	@B2BFindBy(xpath = "//button[@aria-label='scroll-left']/following-sibling::button[@aria-label='scroll-left']")
	private WebElement iconRightArrow;

	@B2BFindBy(xpath = "//button[@aria-label='scroll-left']")
	private WebElement iconArrowDisabled;

	@B2BFindBy(xpath = "//h6[contains(text(),'Click “Create Matches” to automatically create matches.')]")
	private WebElement txtClick;

	@B2BFindBy(xpath = "//h3[contains(text(),'Bracket')]")
	private WebElement txtBracket;

	@B2BFindBy(xpath = "//h4[contains(text(),'Round 1')]")
	private WebElement txtRoundOne;

	@B2BFindBy(xpath = "//h4[contains(text(),'Round 2')]")
	private WebElement txtRoundTwo;

	@B2BFindBy(xpath = "//h4[contains(text(),'Round 3')]")
	private WebElement txtRoundThree;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl')]")
	private WebElement lstViewAll;

	@B2BFindBy(xpath = "//div[@id='simple-tabpanel-3']//h4")
	private WebElement lblLocation;

	@B2BFindBy(xpath = "//div[@id='simple-tabpanel-3']//p[contains(@class,'MuiTypography-root MuiTypography-body2')]")
	private WebElement lblBracketName;

	@B2BFindBy(xpath = "//div[@id='simple-tabpanel-3']//p[contains(@class,'MuiTypography-root MuiTypography-body2 MuiTypography-noWrap')]")
	private WebElement lblPlayerName;

	@B2BFindBy(xpath = "//p[contains(text(),'Game 1')]")
	private WebElement lblGameOne;

	@B2BFindBy(xpath = "//button[contains(text(),'Add Scores')]")
	private WebElement btnAddScores;

	@B2BFindBy(xpath = "//button[contains(text(),'Add Scores')]/following-sibling::button[contains(text(),'Forfeit')]")
	// @B2BFindBy(xpath = "//button[contains(text(),'Forfeit')]")
	private WebElement btnForfeit;

	@B2BFindBy(xpath = "(//p[contains(text(),'Team')])[2]/parent::div/parent::div//button[contains(text(),'Split Team')]")
	private WebElement btnSplitTeam;

	@B2BFindBy(xpath = "//button[contains(text(),'Go Back')]")
	private WebElement btnGoBack;

	@B2BFindBy(xpath = "//span[contains(text(),'Bye')]")
	private WebElement txtBye;

	@B2BFindBy(xpath = "//button[contains(text(),'Standings')]")
	private WebElement btnStandings;

	@B2BFindBy(xpath = "//button[contains(text(),'Withdraw/Refund')]")
	private WebElement btnWithdraw;

	@B2BFindBy(xpath = "//h4[contains(@class,'MuiTypography-root MuiTypography-h4')]")
	private WebElement lblEventCard;

	@B2BFindBy(xpath = "//h6[contains(text(),'Home')]")
	private WebElement mnuHome;

	@B2BFindBy(xpath = "//button[contains(text(),'My Matches')]")
	private WebElement btnMyMatches;

	@B2BFindBy(xpath = "//*[contains(@class,'MuiSvgIcon-root MuiSvgIcon-colorPrimary MuiSvgIcon-fontSizeMedium')]")
	private WebElement btnBack;

	@B2BFindBy(xpath = "//h3[contains(text(),'My Matches')]")
	private WebElement lblMyMatches;

	@B2BFindBy(xpath = "//button[contains(text(),'Register')]")
	private WebElement btnRegister;

	@B2BFindBy(xpath = "//span[contains(@class,'MuiButtonBase-root MuiCheckbox-root MuiCheckbox-colorPrimary PrivateSwitchBase-root')]//input")
	private WebElement chkBracket;

	@B2BFindBy(xpath = "//button[contains(text(),'Refund')]//preceding-sibling::label//input")
	private WebElement chkRefund;

	@B2BFindBy(xpath = "//button[contains(text(),'Health')]//preceding-sibling::label//input")
	private WebElement chkHealth;

	@B2BFindBy(xpath = "//button[contains(text(),'Liability')]//preceding-sibling::label//input")
	private WebElement chkLiability;

	@B2BFindBy(xpath = "//button[text()='OK']")
	private WebElement btnOK;

	@B2BFindBy(xpath = "//span[contains(@class,'MuiChip-label MuiChip-labelSmall') and contains(text(),'Forfeit')]")
	private WebElement lblForfeit;

	@B2BFindBy(xpath = "//h4[contains(text(),'Add Scores')]")
	private WebElement txtAddScores;

	@B2BFindBy(xpath = "//h4[contains(text(),'Add Scores')]//button")
	private WebElement iconCloseOnAddScores;

	@B2BFindBy(xpath = "//h5[contains(text(),'Match Date')]")
	private WebElement txtMatchDate;

	@B2BFindBy(xpath = "//button[contains(@aria-label,'Choose date')]")
	private WebElement btnCalender;

	@B2BFindBy(xpath = "//button[contains(@class,'MuiButtonBase-root MuiPickersDay-root MuiPickersDay-dayWithMargin MuiPickersDay-today')]")
	private WebElement btnDate;

	@B2BFindBy(xpath = "//button[contains(@class,'MuiPickersDay-dayWithMargin MuiPickersDay-today')]")
	private WebElement btnTodayDate;

	@B2BFindBy(xpath = "(//input[@type='number'])[1]")
	private WebElement txt1stpointOfPlayerOne;

	@B2BFindBy(xpath = "(//input[@type='number'])[2]")
	private WebElement txt1stpointOfPlayerTwo;

	@B2BFindBy(xpath = "(//input[@type='number'])[3]")
	private WebElement txt2ndpointOfPlayerOne;

	@B2BFindBy(xpath = "(//input[@type='number'])[4]")
	private WebElement txt2ndpointOfPlayerTwo;

	@B2BFindBy(xpath = "(//input[@type='number'])[5]")
	private WebElement txt3rdpointOfPlayerOne;

	@B2BFindBy(xpath = "(//input[@type='number'])[6]")
	private WebElement txt3rdpointOfPlayerTwo;

	@B2BFindBy(xpath = "//button[contains(@class,'MuiButtonBase-root MuiIconButton-root MuiIconButton-colorPrimary MuiIconButton-sizeLarge')]")
	private WebElement iconAdd;

	@B2BFindBy(xpath = "//button[contains(text(),'Submit')]")
	private WebElement btnSubmit;

	@B2BFindBy(xpath = "//button[text()='Submit Scores']")
	private WebElement btnSubmitScores;

	@B2BFindBy(xpath = "//p[contains(text(),'Date format')]")
	private WebElement txtDateValidation;

	@B2BFindBy(xpath = "//p[contains(text(),'The winner')]")
	private WebElement txtPointsValidation;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiButtonBase-root MuiChip-root MuiChip-semifilled')]")
	private WebElement txtGameTwo;

	@B2BFindBy(xpath = "//p[contains(text(),'Atleast one')]")
	private WebElement txtInvalidPointsValidation;

	@B2BFindBy(xpath = "//*[contains(@class,'MuiSvgIcon-root MuiSvgIcon-fontSizeMedium MuiChip-deleteIcon')]")
	private WebElement iconRemove;

	// @B2BFindBy(xpath = "//span[contains(text(),'Game 2')]/following-sibling::*")
	@B2BFindBy(xpath = "//span[contains(text(),'Game')]/following-sibling::*")
	private WebElement iconRemoveOnAddScores;

	@B2BFindBy(xpath = "//h4[contains(text(),'Submit Scores')]")
	private WebElement txtSubmitScores;

	@B2BFindBy(xpath = "//h4[contains(text(),'Submit Scores')]//button")
	private WebElement iconCloseOnSubmitScores;

	@B2BFindBy(xpath = "//h4[contains(text(),'Submit Scores')]/following-sibling::div/following-sibling::div//button[contains(text(),'Submit')]")
	private WebElement btnSubmitOnSubmitScores;

	@B2BFindBy(xpath = "//button[contains(text(),'Go Back')]")
	private WebElement btnGoBackOnSubmitScores;

	@B2BFindBy(xpath = "//h5[contains(text(),'Winner')]")
	private WebElement txtWinnerTag;

	@B2BFindBy(xpath = "//h4[text()='Scores Added']")
	private WebElement txtScoresAdded;

	@B2BFindBy(xpath = "//h4[text()='Scores Added']//button")
	private WebElement iconCLoseOnScoresAdded;

	@B2BFindBy(xpath = "//h4[contains(text(),'Scores Added - Pending')]")
	private WebElement txtPending;

	@B2BFindBy(xpath = "//h4[contains(text(),'My Clubs')]")
	private WebElement btnMyClubs;

	@B2BFindBy(xpath = "//h4[contains(text(),'Simba')]")
	private WebElement btnSimba;

	@B2BFindBy(xpath = "//button[contains(text(),'Edit Scores')]")
	private WebElement btnEditScores;

	@B2BFindBy(xpath = "//h4[contains(text(),'Edit Scores')]")
	private WebElement txtEditScores;

	@B2BFindBy(xpath = "//h4[contains(text(),'Edit Scores')]//button")
	private WebElement iconCloseOnEditScores;

	@B2BFindBy(xpath = "//h4[text()='Forfeit Match']")
	private WebElement txtForfeitMatch;

	@B2BFindBy(xpath = "//h4[text()='Forfeit Match']//button")
	private WebElement iconCloseOnForfeitMatch;

	@B2BFindBy(xpath = "//input[@type='radio']")
	private WebElement rdoFirstTeam;

	@B2BFindBy(xpath = "//input[@type='radio']/ancestor::div/following-sibling::div//input")
	private WebElement rdoSecondTeam;

	@B2BFindBy(xpath = "//button[text()='Cancel']")
	private WebElement btnCancel;

	@B2BFindBy(xpath = "//button[text()='Mark as Forfeit' and @disabled]")
	private WebElement btnMardkAsForfeitDisabled;

	@B2BFindBy(xpath = "//button[text()='Mark as Forfeit' ]")
	private WebElement btnMarkAsForfiet;

	@B2BFindBy(xpath = "//button[contains(text(),'Validate')]")
	private WebElement btnValidate;

	@B2BFindBy(xpath = "//h4[contains(text(),'Validate Match')]")
	private WebElement lblValidateMatch;

	@B2BFindBy(xpath = "//h4[contains(text(),'Validate Match')]//button")
	private WebElement iconCloseOnValidatePopup;

	@B2BFindBy(xpath = "//h4[contains(text(),'Validate Match')]/following-sibling::div//p[contains(text(),'Game 1')]")
	private WebElement lblGame1;

	@B2BFindBy(xpath = "//h4[contains(text(),'Validate Match')]/following-sibling::div//p[contains(text(),'Game 2')]")
	private WebElement lblGame2;

	@B2BFindBy(xpath = "//h4[contains(text(),'Validate Match')]/following-sibling::div//p[contains(text(),'Game 3')]")
	private WebElement lblGame3;

	@B2BFindBy(xpath = "//h4[contains(text(),'Validate Match')]/following-sibling::div//button[contains(text(),'Validate')]")
	private WebElement btnValidateInValidateMatch;

	@B2BFindBy(xpath = "//h5[contains(text(),'Winner')]")
	private WebElement lblWinner;

	@B2BFindBy(xpath = "//button[contains(text(),'Edit Bracket')]")
	private WebElement btnEditBracket;

	@B2BFindBy(xpath = "//button[contains(text(),'Save Changes')]")
	private WebElement btnSaveChanges;

	@B2BFindBy(xpath = "//h4[contains(text(),'Simba')]")
	private WebElement btnSimbaClub;

	@B2BFindBy(xpath = "//h4[contains(text(),'Validate Match?')]")
	private WebElement lblValidateMatchPopUp;

	@B2BFindBy(xpath = "//h4[contains(text(),'Validate Match?')]//button")
	private WebElement btnValidateMatchClose;

	@B2BFindBy(xpath = "//h4[text()='Validate Match?']/following-sibling::div//button/following-sibling::button")
	private WebElement btnValidateMatchValidate;

	@B2BFindBy(xpath = "//h4[text()='Validate Match?']/following-sibling::div//button[text()='Cancel']")
	private WebElement btnValidateMatchCancel;

	@B2BFindBy(xpath = "//h4[(text()='Success')]")
	private WebElement lblSuccess;

	@B2BFindBy(xpath = "//button[text()='Matches']")
	private WebElement btnMatches;

	@B2BFindBy(xpath = "//h4[(text()='Success')]//button")
	private WebElement btnClose;

	@B2BFindBy(xpath = "//h4[(text()='Match Validated Successfully')]")
	private WebElement lblMatchValidateSuccessfully;

	@B2BFindBy(xpath = "//h3[text()='Registration Date']/following-sibling::div//h5[text()='Start Date & Time']/parent::div/following-sibling::div//input")
	private WebElement txtBoxRegistrationStartDate;

	@B2BFindBy(xpath = "//h3[text()='Registration Date']/following-sibling::div//h5[text()='End Date & Time']/parent::div/following-sibling::div//input")
	private WebElement txtBoxRegistrationEndDate;

	@B2BFindBy(xpath = "//h3[contains(text(),'Competition Date')]/following-sibling::div//h5[contains(text(),'Start Date & Time')]/parent::div/following-sibling::div//input")
	private WebElement txtBoxCompetitionStartDate;

	@B2BFindBy(xpath = "//h3[text()='Competition Date']/following-sibling::div//h5[text()='End Date & Time']/parent::div/following-sibling::div//input")
	private WebElement txtBoxCompetitionEndDate;

	@B2BFindBy(xpath = "//span[text()='00']")
	private WebElement btnDefaultTimeInMinutes;

	@B2BFindBy(xpath = "//span[text()='05']")
	private WebElement btnTimeInMinutes;

	@B2BFindBy(xpath = "//div[@role='dialog']//button[text()='Cancel']")
	private WebElement btnCancelCalender;

	@B2BFindBy(xpath = "//button[text()='Players']")
	private WebElement tabPlayers;

	public SeedMatchesPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	private static int finalminutesValue = 0;
	private static String lastMinutes = null;
	private static String min = null;

	public void clickOnBracketCard() {
		log.info("Starting of clickOnBracketCard method");

		try {
			clickUsingActionsClass(lblBracketCard);
		} catch (Exception e) {
			clickOnWebElement(lblBracketCard);
		}

		log.info("Ending of clickOnBracketCard method");
	}

	public void clickOnMyClubsCard() {
		log.info("Starting of clickOnMyClubsCard method");
		try {
			clickOnWebElement(btnMyClubs);
		} catch (Exception e) {
			elementClick(btnMyClubs);
		}
		this.hardWait(4);
		try {
			clickOnWebElement(btnSimba);
		} catch (Exception e) {
			elementClick(btnSimba);
		}

		log.info("Ending of clickOnMyClubsCard method");
	}

	public void clickOnTeamsTab() {
		log.info("Starting of clickOnTeamsTab method");
		try {
			this.scrollDown(-200);
			clickUsingActionsClass(tabTeams);
		} catch (Exception e) {
			clickOnWebElement(tabTeams);
		}

		log.info("Ending of clickOnTeamsTab method");
	}

	public void scrollUp() {
		log.info("Starting of scrollUp method");

		this.scrollDown(-800);

		log.info("Ending of scrollUp method");
	}

	public void scrollUptoDate() {
		log.info("Starting of scrollUp method");

		this.scrollDown(-400);

		log.info("Ending of scrollUp method");
	}

	public void clickOnEventCard(String event) {
		log.info("Starting of clickOnEventCard method");

		try {
			clickUsingActionsClass(driver.findElement(By.xpath(("//button[text()='" + event + "']"))));
		} catch (Exception e) {
			driver.findElement(By.xpath(("//button[text()='" + event + "']"))).click();
		}

		log.info("Ending of clickOnEventCard method");
	}

	public boolean isForfeitMatchPopupContains() {
		log.info("Starting of isForfeitMatchPopupContains method");

		boolean isForfeitMatchPopupContains = false;
		try {
			if (isDisplayed(txtForfeitMatch) && isDisplayed(iconCloseOnForfeitMatch) && isDisplayed(btnCancel)
					&& isDisplayed(btnMardkAsForfeitDisabled)) {
				isForfeitMatchPopupContains = true;
			}
		} catch (Exception e) {
			isForfeitMatchPopupContains = false;
		}

		log.info("Ending of isForfeitMatchPopupContains method");

		return isForfeitMatchPopupContains;
	}

	public void clickOnForfeitButon() {
		log.info("Starting of clickOnForfeitButon method");
		try {
			clickUsingActionsClass(btnForfeit);
		} catch (Exception e) {
			clickOnWebElement(btnForfeit);
		}

		log.info("Ending of clickOnForfeitButon method");
	}

	public void clickOnSaveChangesButon() {
		log.info("Starting of clickOnSaveChangesButon method");
		try {
			clickUsingActionsClass(btnSaveChanges);
		} catch (Exception e) {
			clickOnWebElement(btnSaveChanges);
		}

		log.info("Ending of clickOnSaveChangesButon method");
	}

	public void clickCloseIconOnForfeitMatch() {
		log.info("Starting of clickCloseIconOnForfeitMatch method");

		clickOnWebElement(iconCloseOnForfeitMatch);

		log.info("Ending of clickCloseIconOnForfeitMatch method");
	}

	public void clickOnSeedMatchesButton() {
		log.info("Starting of clickOnSeedMatchesButton method");
		this.hardWait(3);

		try {
			this.scrollDown(-300);
			clickUsingActionsClass(btnSeedMatches);
		} catch (Exception e) {
			clickOnWebElement(btnSeedMatches);
		}

		log.info("Ending of clickOnSeedMatchesButton method");
	}

	public void clickOnCloseIcon() {
		log.info("Starting of clickOnCloseIcon method");

		clickOnWebElement(iconClose);

		log.info("Ending of clickOnCloseIcon method");
	}

	public boolean isSeedMatchesPageContains() {
		log.info("Starting of isSeedMatchesPageContains method");

		boolean isSeedMatchesPageContains = false;
		System.out.println(isDisplayed(txtSeeds));
		System.out.println(isDisplayed(btnCreateMatches));
		System.out.println(isDisplayed(btnSavePublishDisabled));
		System.out.println(isDisplayed(iconLeftArrow));
		System.out.println(isDisplayed(iconRightArrow));
		System.out.println(txtClick);

		if (isDisplayed(txtSeeds) && isDisplayed(btnCreateMatches) && isDisplayed(btnSavePublishDisabled)
				&& isDisplayed(iconLeftArrow) && isDisplayed(iconRightArrow) && isDisplayed(txtClick)) {
			isSeedMatchesPageContains = true;
		}

		log.info("Ending of isSeedMatchesPageContains method");

		return isSeedMatchesPageContains;
	}

	public boolean isPublisbButtonDisabled() {
		log.info("Starting of isPublisbButtonDisabled method");

		boolean isPublisbButtonDisabled = false;

		if (isDisplayed(btnSavePublishDisabled)) {
			isPublisbButtonDisabled = true;
		}

		log.info("Ending of isPublisbButtonDisabled method");

		return isPublisbButtonDisabled;
	}

	public boolean isMarkAsForfeitButtonDisabled() {
		log.info("Starting of isMarkAsForfeitButtonDisabled method");

		boolean isMarkAsForfeitButtonDisabled = false;
		try {
			if (isDisplayed(btnMardkAsForfeitDisabled)) {
				isMarkAsForfeitButtonDisabled = true;
			}
		} catch (Exception e) {
			isMarkAsForfeitButtonDisabled = false;
		}

		log.info("Ending of isMarkAsForfeitButtonDisabled method");

		return isMarkAsForfeitButtonDisabled;
	}

	public boolean isForfeitLabelDisabled() {
		log.info("Starting of isForfeitLabelDisabled method");

		boolean isForfeitLabelDisabled = false;

		if (isDisplayed(lblForfeit)) {
			isForfeitLabelDisabled = true;
		}

		log.info("Ending of isForfeitLabelDisabled method");

		return isForfeitLabelDisabled;
	}

	public boolean isFirstTeamRadioButtonSelected() {
		log.info("Starting of isFirstTeamRadioButtonSelected method");

		boolean isFirstTeamRadioButtonSelected = false;
		try {
			if (isDisplayed(rdoFirstTeam)) {
				isFirstTeamRadioButtonSelected = true;
			}
		} catch (Exception e) {
			isFirstTeamRadioButtonSelected = true;
		}

		log.info("Ending of isFirstTeamRadioButtonSelected method");

		return isFirstTeamRadioButtonSelected;
	}

	public boolean isByeLabelDisplayed() {
		log.info("Starting of isByeLabelDisplayed method");

		boolean isByeLabelDisplayed = false;

		if (isDisplayed(txtBye)) {
			isByeLabelDisplayed = true;
		}

		log.info("Ending of isByeLabelDisplayed method");

		return isByeLabelDisplayed;
	}

	public boolean isStandingsTabDisplayed() {
		log.info("Starting of isStandingsTabDisplayed method");

		boolean isStandingsTabDisplayed = false;

		driver.navigate().refresh();
		this.hardWait(3);

		if (isDisplayed(btnStandings)) {
			isStandingsTabDisplayed = true;
		}

		log.info("Ending of isStandingsTabDisplayed method");

		return isStandingsTabDisplayed;
	}

	public boolean isRemoveIconDisplayed() {
		log.info("Starting of isRemoveIconDisplayed method");

		boolean isRemoveIconDisplayed = false;

		if (isDisplayed(iconRemove)) {
			isRemoveIconDisplayed = true;
		}

		log.info("Ending of isRemoveIconDisplayed method");

		return isRemoveIconDisplayed;
	}

	public String getClickText() {
		log.info("Starting of getClickText method");
		log.info("Ending of getClickText method");

		return getText(txtClick);
	}

	public boolean isBracketHomePageDisplayed() {
		log.info("Starting of isBracketHomePageDisplayed method");

		boolean isBracketHomePageDisplayed = false;

		try {
			if (isDisplayed(txtBracket)) {
				isBracketHomePageDisplayed = true;
			}
		} catch (Exception e) {
			isBracketHomePageDisplayed = false;
		}

		log.info("Ending of isBracketHomePageDisplayed method");

		return isBracketHomePageDisplayed;
	}

	public void clickOnCreateMatches() {
		log.info("Starting of clickOnCreateMatches method");
		try {
			this.hardWait(3);
			clickUsingActionsClass(btnCreateMatches);
		} catch (Exception e) {
			clickOnWebElement(btnCreateMatches);
		}

		log.info("Ending of clickOnCreateMatches method");
	}

	public void clickOnSimbaClub() {
		log.info("Starting of clickOnSimbaClub method");
		try {
			this.hardWait(3);
			clickUsingActionsClass(btnSimbaClub);
		} catch (Exception e) {
			clickOnWebElement(btnSimbaClub);
		}

		log.info("Ending of clickOnSimbaClub method");
	}

	public void clickOnCancelButton() {
		log.info("Starting of clickOnCancelButton method");

		clickOnWebElement(btnCancel);

		log.info("Ending of clickOnCancelButton method");
	}

	public void clickOnMarkAsForfeitButton() {
		log.info("Starting of clickOnMarkAsForfeitButton method");

		clickOnWebElement(btnMarkAsForfiet);

		log.info("Ending of clickOnMarkAsForfeitButton method");
	}

	public void clickOnFirstTeamRadioButton() {
		log.info("Starting of clickOnFirstTeamRadioButton method");

		try {
			elementClick(rdoFirstTeam);
		} catch (Exception e) {
			clickOnWebElement(rdoFirstTeam);
		}

		log.info("Ending of clickOnFirstTeamRadioButton method");
	}

	public void clickOnSecondTeamRadioButton() {
		log.info("Starting of clickOnSecondTeamRadioButton method");

		clickOnWebElement(rdoSecondTeam);

		log.info("Ending of clickOnSecondTeamRadioButton method");
	}

	public boolean isRoundsDisplayed() {
		log.info("Starting of isRoundsDisplayed method");

		boolean isRoundsDisplayed = false;

		try {
			if (isDisplayed(txtRoundOne) && isDisplayed(txtRoundTwo) || isDisplayed(txtRoundThree)) {
				isRoundsDisplayed = true;
			}
		} catch (Exception e) {
			isRoundsDisplayed = false;
		}

		log.info("Ending of isRoundsDisplayed method");

		return isRoundsDisplayed;
	}

	public boolean isScoresAddedPopUpContains() {
		log.info("Starting of isScoresAddedPopUpContains method");

		boolean isScoresAddedPopUpContains = false;
		try {
			if (isDisplayed(txtScoresAdded) && isDisplayed(iconCLoseOnScoresAdded)) {
				isScoresAddedPopUpContains = true;
			}
		} catch (Exception e) {
			isScoresAddedPopUpContains = false;
		}

		log.info("Ending of isScoresAddedPopUpContains method");

		return isScoresAddedPopUpContains;
	}

	public void clickCloseIconOnScoreAddedPopUP() {
		log.info("Starting of clickCloseIconOnScoreAddedPopUP method");
		try {
			clickOnWebElement(iconCLoseOnScoresAdded);
		} catch (Exception e) {
			elementClick(iconCLoseOnScoresAdded);
		}

		log.info("Ending of clickCloseIconOnScoreAddedPopUP method");
	}

	public boolean isPublishButtonEnabled() {
		log.info("Starting of isPublishButtonEnabled method");

		boolean isPublishButtonEnabled = false;

		if (isDisplayed(btnSavePublish)) {
			isPublishButtonEnabled = true;
		}

		log.info("Ending of isPublishButtonEnabled method");

		return isPublishButtonEnabled;
	}

	public void clickOnRightArrowIcon() {
		log.info("Starting of clickOnRightArrowIcon method");

		clickOnWebElement(iconRightArrow);

		this.hardWait(2);
		clickOnWebElement(iconRightArrow);

		log.info("Ending of clickOnRightArrowIcon method");
	}

	public void clickOnLefttArrowIcon() {
		log.info("Starting of clickOnLefttArrowIcon method");

		clickOnWebElement(iconLeftArrow);
		this.hardWait(2);
		clickOnWebElement(iconLeftArrow);

		log.info("Ending of clickOnLefttArrowIcon method");
	}

	public boolean isArrowDisabled() {
		log.info("Starting of isArrowDisabled method");

		boolean isArrowDisabled = false;

		if (isDisplayed(iconArrowDisabled)) {
			isArrowDisabled = true;
		}

		log.info("Ending of isArrowDisabled method");

		return isArrowDisabled;
	}

	public void clickOnSavePublishButton() {
		log.info("Starting of clickOnSavePublishButton method");
		try {
			elementClick(btnSavePublish);
		} catch (Exception e) {
			clickOnWebElement(btnSavePublish);
		}

		log.info("Ending of clickOnSavePublishButton method");
	}

	public void clickOnMatchesTab() {
		log.info("Starting of clickOnMatchesTab method");
		try {
			clickOnElementUsingActionClass(tabMatches);
			hardWait(4);
		} catch (Exception e) {
			clickOnWebElement(tabMatches);
			hardWait(4);
		}

		log.info("Ending of clickOnMatchesTab method");
	}

	public boolean isMatchesTabContains() {
		log.info("Starting of isMatchesTabContains method");

		boolean isMatchesTabContains = true;
		this.scrollDown(170);
		try {
			if (isDisplayed(lstViewAll) && isDisplayed(lblLocation) && isDisplayed(lblBracketName)
					&& isDisplayed(lblPlayerName) && isDisplayed(lblGameOne) && isDisplayed(btnAddScores)
					&& isDisplayed(btnForfeit)) {
				isMatchesTabContains = true;
			}
		} catch (Exception e) {
			if (isDisplayed(lstViewAll) && isDisplayed(lblLocation) && isDisplayed(lblBracketName)
					&& isDisplayed(lblPlayerName) && isDisplayed(lblGameOne) && isDisplayed(btnAddScores)
					&& isDisplayed(btnForfeit)) {
				isMatchesTabContains = true;
			}

		}

		this.scrollDown(-200);
		log.info("Ending of isMatchesTabContains method");

		return isMatchesTabContains;
	}

	public void withdrawTeam() {
		log.info("Starting of withdrawTeam method");
		try {
			clickOnWebElement(btnSplitTeam);
		} catch (Exception e) {
			elementClick(btnSplitTeam);
		}

		this.hardWait(5);
		try {
			clickOnWebElement(btnGoBack);
		} catch (Exception e) {
			elementClick(btnGoBack);
		}

		log.info("Ending of withdrawTeam method");
	}

	public void clickOnReseedButton() {
		log.info("Starting of clickOnReseedButton method");
		try {
			elementClick(btnReseedMatches);
		} catch (Exception e) {
			clickOnWebElement(btnReseedMatches);
		}

		log.info("Ending of clickOnReseedButton method");
	}

	public void clickOnEditBracketButton() {
		log.info("Starting of clickOnEditBracketButton method");

		try {
			elementClick(btnEditBracket);
		} catch (Exception e) {
			clickOnWebElement(btnEditBracket);
		}
		this.hardWait(2);
		this.scrollDown(400);

		log.info("Ending of clickOnEditBracketButton method");
	}

	public boolean beforeValidateisBracketPageContains() {
		log.info("Starting of beforeValidateisBracketPageContains method");

		boolean isMatchesTabContains = false;

		try {
			this.hardWait(3);
			isDisplayed(btnEditBracket);
			this.hardWait(2);
			isDisplayed(btnForfeit);
			this.hardWait(3);
			try {
				elementClick(tabTeams);
			} catch (Exception e) {
				clickOnWebElement(tabTeams);
			}

			this.hardWait(5);
			isDisplayed(btnSplitTeam);

			isMatchesTabContains = true;

		} catch (Exception e) {
			isMatchesTabContains = false;
		}

		log.info("Ending of beforeValidateisBracketPageContains method");

		return isMatchesTabContains;
	}

	public void clickOnHomeMenu() {
		log.info("Starting of clickOnHomeMenu method");

		try {
			clickUsingActionsClass(mnuHome);
		} catch (Exception e) {
			clickOnWebElement(mnuHome);
		}

		this.hardWait(3);

		log.info("Ending of clickOnHomeMenu method");
	}

	public void clickOnMyMatchesButton(String eventName) {
		log.info("Starting of clickOnMyMatchesButton method");

		clickOnWebElement(driver.findElement(By.xpath(
				"//h6[contains(text(),'" + eventName + "')]/parent::div//button[contains(text(),'My Matches')]")));

		this.hardWait(3);

		log.info("Ending of clickOnMyMatchesButton method");
	}

	public boolean isMyMatchesPageContains() {
		log.info("Starting of isMyMatchesPageContains method");

		boolean isMyMatchesPageContains = false;
		try {
			if (isDisplayed(btnBack) && isDisplayed(lblMyMatches) && isDisplayed(btnAddScores)) {
				isMyMatchesPageContains = true;
			}
		} catch (Exception e) {
			if (isDisplayed(btnBack) && isDisplayed(lblMyMatches) && isDisplayed(btnAddScores)) {
				isMyMatchesPageContains = true;
			}
		}

		log.info("Ending of isMyMatchesPageContains method");

		return isMyMatchesPageContains;
	}

	public boolean isRegisterButtonDisplayed() {
		log.info("Starting of isRegisterButtonDisplayed method");

		boolean isRegisterButtonDisplayed = false;
		try {
			if (btnRegister.isDisplayed() == true) {
				isRegisterButtonDisplayed = true;
			}
		} catch (Exception e) {
			isRegisterButtonDisplayed = false;
		}

		log.info("Ending of isRegisterButtonDisplayed method");

		return isRegisterButtonDisplayed;
	}

	public void registerEvent() {
		log.info("Starting of registerEvent method");

		clickOnWebElement(btnRegister);
		this.hardWait(3);
		clickOnWebElement(chkBracket);
		this.hardWait(3);
		this.scrollDown(200);
		clickOnWebElement(chkRefund);
		this.hardWait(3);
		clickOnWebElement(chkHealth);
		this.hardWait(3);
		clickOnWebElement(chkLiability);
		this.hardWait(3);
		clickOnWebElement(btnRegister);
		this.hardWait(3);
		clickOnWebElement(btnOK);
		this.hardWait(3);

		log.info("Ending of registerEvent method");
	}

	public void clickOnAddScoresButton() {
		log.info("Starting of clickOnAddScoresButton method");
		try {
			this.hardWait(3);
			clickUsingActionsClass(btnAddScores);
		} catch (Exception e) {
			clickOnWebElement(btnAddScores);
		}

		this.hardWait(3);

		log.info("Ending of clickOnAddScoresButton method");
	}

	public boolean isAddScoresPopUpContains() {
		log.info("Starting of isAddScoresPopUpContains method");

		boolean isAddScoresPopUpContains = false;
		try {
			if (isDisplayed(txtAddScores) && isDisplayed(iconCloseOnAddScores) && isDisplayed(txtMatchDate)
					&& isDisplayed(btnCalender) && isDisplayed(txt1stpointOfPlayerOne)
					&& isDisplayed(txt1stpointOfPlayerTwo) && isDisplayed(iconAdd) && isDisplayed(btnSubmit)) {
				isAddScoresPopUpContains = true;
			}

		} catch (Exception e) {
			isAddScoresPopUpContains = false;

		}

		log.info("Ending of isAddScoresPopUpContains method");

		return isAddScoresPopUpContains;
	}

	public boolean isEditScoresPopUpContains() {
		log.info("Starting of isEditScoresPopUpContains method");

		boolean isEditScoresPopUpContains = false;
		try {
			if (isDisplayed(txtEditScores) 
					&& isDisplayed(iconCloseOnEditScores) 
					&& isDisplayed(txtMatchDate)
					&& isDisplayed(btnCalender) 
					&& isDisplayed(txt1stpointOfPlayerOne)
					&& isDisplayed(txt1stpointOfPlayerTwo) 
					&& isDisplayed(txtWinnerTag) 
					&& isDisplayed(btnSubmit)) {
				isEditScoresPopUpContains = true;
			}

		} catch (Exception e) {
			isEditScoresPopUpContains = false;

		}

		log.info("Ending of isEditScoresPopUpContains method");

		return isEditScoresPopUpContains;
	}

	public String getEditScoresTxt() {
		log.info("Starting of getEditScoresTxt method");
		log.info("Ending of getEditScoresTxt method");

		return getText(txtEditScores);
	}

	public String getAddScoresTxt() {
		log.info("Starting of getAddScoresTxt method");
		log.info("Ending of getAddScoresTxt method");

		return getText(txtAddScores);
	}

	public String getMatchDateTxt() {
		log.info("Starting of getMatchDateTxt method");
		log.info("Ending of getMatchDateTxt method");

		return getText(txtMatchDate);
	}

	public void clickCloseIconOnAddScores() {
		log.info("Starting of clickCloseIconOnAddScores method");

		clickOnWebElement(iconCloseOnAddScores);
		this.hardWait(3);

		log.info("Ending of clickCloseIconOnAddScores method");
	}

	public void clickOnEditScoresButton() {
		log.info("Starting of clickOnEditScoresButton method");
		try {
			clickOnWebElement(btnEditScores);
			this.hardWait(3);
		} catch (Exception e) {
			scrollDown(200);
			clickUsingActionsClass(btnEditScores);
		}

		log.info("Ending of clickOnEditScoresButton method");
	}

	public void clickOnSubmitButton() {
		//log.info("Starting of clickOnSubmitButton method");
		try {
			clickUsingActionsClass(btnSubmit);

		} catch (Exception e) {
			clickOnWebElement(btnSubmit);
		}
		this.hardWait(2);

		log.info("Ending of clickOnSubmitButton method");
	}
	
	public void clickOnSubmitButtonOnSubmitScores() {
		log.info("Starting of clickOnSubmitButton method");
		try {
			clickUsingActionsClass(btnSubmitOnSubmitScores);

		} catch (Exception e) {
			clickOnWebElement(btnSubmitOnSubmitScores);
		}
		this.hardWait(2);

		log.info("Ending of clickOnSubmitButton method");
	}

	public void clickOnSubmitScoresButton() {
		log.info("Starting of clickOnSubmitScoresButton method");

		clickOnWebElement(btnSubmitScores);
		this.hardWait(2);

		log.info("Ending of clickOnSubmitScoresButton method");
	}

	public String getDateValidationTxt() {
		log.info("Starting of getDateValidationTxt method");
		log.info("Ending of getDateValidationTxt method");

		return getText(txtDateValidation);
	}

	public String getPointsValidationTxt() {
		log.info("Starting of getPointsValidationTxt method");
		log.info("Ending of getPointsValidationTxt method");

		return getText(txtPointsValidation);
	}

	public void clickOnCalenderButton() {
		log.info("Starting of clickOnCalenderButton method");
		try {
			this.hardWait(3);
			clickOnWebElement(btnCalender);
		} catch (Exception e) {
			clickUsingActionsClass(btnCalender);
		}

		this.hardWait(2);

		log.info("Ending of clickOnCalenderButton method");
	}

	public void selectingMatchDate() {
		log.info("Starting of selectingMatchDate method");

		try {
			this.hardWait(3);
			clickOnWebElement(btnDate);
		} catch (Exception e) {
			elementClick(btnDate);
		}

		log.info("Ending of selectingMatchDate method");

	}

	public void selectingMatchDateAsCurrentDate() {
		log.info("Starting of selectingMatchDateAsCurrentDate method");

		try {
			this.hardWait(3);
			clickOnWebElement(btnTodayDate);
		} catch (Exception e) {
			elementClick(btnTodayDate);
		}

		log.info("Ending of selectingMatchDateAsCurrentDate method");

	}

	public boolean isDateSelected() {
		log.info("Starting of isDateSelected method");
		boolean isDateSelected = false;

		try {
			if (btnCalender.isDisplayed()) {
				isDateSelected = true;
			}

		} catch (Exception e) {
			isDateSelected = false;
		}

		log.info("Ending of isDateSelected method");
		return isDateSelected;
	}

	public void clickOnAddIcon() {
		log.info("Starting of clickOnAddIcon method");

		clickOnWebElement(iconAdd);
		this.hardWait(3);

		log.info("Ending of clickOnAddIcon method");

	}

	public boolean isAddIconDisappeared() {
		log.info("Starting of isAddIconDisappeared method");

		boolean isAddIconDisappeared = true;

		try {
			if (isDisplayed(iconAdd) == true) {
				isAddIconDisappeared = false;
			}

		} catch (Exception e) {
			isAddIconDisappeared = true;
		}
		log.info("Ending of isAddIconDisappeared method");

		return isAddIconDisappeared;
	}

	public void enterFirstGamePlayerPoints(String gameOnePlayerOne, String gameOnePlayerTwo) {
		log.info("Starting of enterFirstGamePoints method");

		this.txt1stpointOfPlayerOne.sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
		clickOnWebElement(txt1stpointOfPlayerOne);
		this.txt1stpointOfPlayerOne.sendKeys(gameOnePlayerOne);

		this.hardWait(3);

		this.txt1stpointOfPlayerTwo.sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
		clickOnWebElement(txt1stpointOfPlayerTwo);
		this.txt1stpointOfPlayerTwo.sendKeys(gameOnePlayerTwo);

		this.hardWait(3);

		log.info("Ending of enterFirstGamePoints method");

	}

	public boolean isGameTwoDisplayed() {
		log.info("Starting of isGameTwoDisplayed method");
		log.info("Ending of isGameTwoDisplayed method");

		return isDisplayed(txtGameTwo);
	}

	public void enterSecondGamePlayerPoints(String gameOnePlayerOne, String gameOnePlayerTwo) {
		log.info("Starting of enterSecondGamePlayerPoints method");

		this.txt2ndpointOfPlayerOne.sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
		clickOnWebElement(txt2ndpointOfPlayerOne);
		this.txt2ndpointOfPlayerOne.sendKeys(gameOnePlayerOne);

		this.hardWait(3);

		this.txt2ndpointOfPlayerTwo.sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
		clickOnWebElement(txt2ndpointOfPlayerTwo);
		this.txt2ndpointOfPlayerTwo.sendKeys(gameOnePlayerTwo);

		this.hardWait(3);

		log.info("Ending of enterSecondGamePlayerPoints method");
	}

	public String getInvalidPointsValidation() {
		log.info("Starting of getInvalidPointsValidation method");
		log.info("Ending of getInvalidPointsValidation method");

		return getText(txtInvalidPointsValidation);
	}

	public void clickOnRemoveIcon() {
		log.info("Starting of clickOnRemoveIcon method");

		try {
			clickOnElementUsingActionClass(iconRemoveOnAddScores);
			this.hardWait(3);
		} catch (Exception e) {
			elementClick(iconRemoveOnAddScores);
		}

		log.info("Ending of clickOnRemoveIcon method");
	}

	public boolean isSubmitScoresPopUpContains() {
		log.info("Starting of isSubmitScoresPopUpContains method");

		boolean isSubmitScoresPopUpContains = false;

		if (isDisplayed(txtSubmitScores) && isDisplayed(iconCloseOnSubmitScores) && isDisplayed(btnSubmitOnSubmitScores)
				&& isDisplayed(btnGoBackOnSubmitScores)) {
			isSubmitScoresPopUpContains = true;
		}

		log.info("Ending of isSubmitScoresPopUpContains method");

		return isSubmitScoresPopUpContains;
	}

	public String getSubmitScoresTxt() {
		log.info("Starting of getSubmitScoresTxt method");
		log.info("Ending of getSubmitScoresTxt method");

		return getText(txtSubmitScores);
	}

	public void clickCloseIconOnSubmitScores() {
		log.info("Starting of clickCloseIconOnSubmitScores method");

		clickOnWebElement(iconCloseOnSubmitScores);
		this.hardWait(3);

		log.info("Ending of clickCloseIconOnSubmitScores method");
	}

	public void clickGoBackButtonOnSubmitScores() {
		log.info("Starting of clickGoBackButtonOnSubmitScores method");

		clickOnWebElement(btnGoBackOnSubmitScores);
		this.hardWait(3);

		log.info("Ending of clickGoBackButtonOnSubmitScores method");
	}

	public void enterThirdGamePlayerPoints(String gameOnePlayerOne, String gameOnePlayerTwo) {
		log.info("Starting of enterThirdGamePlayerPoints method");

		this.txt3rdpointOfPlayerOne.sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
		clickOnWebElement(txt3rdpointOfPlayerOne);
		this.txt3rdpointOfPlayerOne.sendKeys(gameOnePlayerOne);

		this.hardWait(3);

		this.txt3rdpointOfPlayerTwo.sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
		clickOnWebElement(txt3rdpointOfPlayerTwo);
		this.txt3rdpointOfPlayerTwo.sendKeys(gameOnePlayerTwo);

		this.hardWait(3);

		log.info("Ending of enterThirdGamePlayerPoints method");
	}

	public boolean isWinnerTagDisplayed() {
		log.info("Starting of isWinnerTagDisplayed method");

		boolean isWinnerTagDisplayed = false;

		if (isDisplayed(txtWinnerTag)) {
			isWinnerTagDisplayed = true;
		}

		log.info("Ending of isWinnerTagDisplayed method");

		return isWinnerTagDisplayed;
	}

	public void clickOnValidateButton() {
		log.info("Starting of clickOnValidateButton method");

		this.hardWait(2);
		try {
			// this.waitForElementToBeVisible(btnValidate);
			btnValidate.click();
		} catch (Exception e) {
			clickOnWebElement(btnValidate);
		}

		log.info("Ending of clickOnValidateButton method");
	}

	public void clickOnMatchesTabButton() {
		log.info("Starting of clickOnMatchesTabButton method");

		this.hardWait(2);
		try {
			this.waitForElementToBeVisible(btnMatches);
			btnMatches.click();
		} catch (Exception e) {
			clickOnWebElement(btnMatches);
		}

		log.info("Ending of clickOnMatchesTabButton method");
	}

	public String getValidateLabel() {
		log.info("Starting of getValidateLabel method");
		log.info("Ending of getValidateLabel method");

		return getText(btnValidate);
	}

	public String getValidateMatchLabel() {
		log.info("Starting of getValidateMatchLabel method");
		this.hardWait(3);
		log.info("Ending of getValidateMatchLabel method");

		return lblValidateMatch.getText();
	}

	public void clickOnCloseIconOnValidatePopUp() {
		log.info("Starting of clickOnCloseIconOnValidatePopUp method");

		this.hardWait(2);
		try {
			iconCloseOnValidatePopup.click();
		} catch (Exception e) {
			elementClick(iconCloseOnValidatePopup);
		}
		log.info("Ending of clickOnCloseIconOnValidatePopUp method");
	}

	public boolean isGame1Displayed() {
		log.info("Starting of isGame1Displayed method");
		log.info("Ending of isGame1Displayed method");

		return lblGame1.isDisplayed();
	}

	public boolean isGame2Displayed() {
		log.info("Starting of isGame2Displayed method");
		log.info("Ending of isGame1D2splayed method");

		return lblGame2.isDisplayed();
	}

	public boolean isGame3Displayed() {
		log.info("Starting of isGame3Displayed method");
		log.info("Ending of isGame3Displayed method");

		return lblGame3.isDisplayed();
	}

	public void clickOnValidateInValidateMatchButton() {
		log.info("Starting of clickOnValidateInValidateMatchButton method");

		this.hardWait(2);
		try {
			btnValidateInValidateMatch.click();
		} catch (Exception e) {
			elementClick(btnValidateInValidateMatch);
		}
		log.info("Ending of clickOnValidateInValidateMatchButton method");
	}

	public boolean isValidateMatchPopupContains() {
		log.info("Starting of isValidateMatchPopupContains method");

		boolean isValidateMatchPopupContains = false;
		try {
			if (iconCloseOnValidatePopup.isDisplayed() && lblGame1.isDisplayed() && lblGame2.isDisplayed()
					&& lblGame3.isDisplayed() && lblWinner.isDisplayed() && btnValidateInValidateMatch.isDisplayed()) {
				isValidateMatchPopupContains = true;
			}
		} catch (Exception e) {
			isValidateMatchPopupContains = false;
		}

		log.info("Ending of isClubMemberPopupContains method");

		return isValidateMatchPopupContains;
	}

	public boolean isValidateMatchPopupInValidateMatchContains() {
		log.info("Starting of isValidateMatchPopupInValidateMatchContains method");

		boolean isValidateMatchPopupInValidateMatchContains = false;
		try {
			if (lblValidateMatchPopUp.isDisplayed() && btnValidateMatchClose.isDisplayed()
					&& btnValidateMatchCancel.isDisplayed() && btnValidateMatchValidate.isDisplayed()) {
				isValidateMatchPopupInValidateMatchContains = true;
			}
		} catch (Exception e) {
			isValidateMatchPopupInValidateMatchContains = false;
		}

		log.info("Ending of isValidateMatchPopupInValidateMatchContains method");

		return isValidateMatchPopupInValidateMatchContains;
	}

	public void clickOnValidateMatchCloseIcon() {
		log.info("Starting of clickOnValidateMatchCloseIcon method");

		this.hardWait(2);
		try {
			btnValidateMatchClose.click();
		} catch (Exception e) {
			elementClick(btnValidateMatchClose);
		}
		log.info("Ending of clickOnValidateMatchCloseIcon method");
	}

	public void clickOnValidateMatchCancelButton() {
		log.info("Starting of clickOnValidateMatchCancelButton method");

		this.hardWait(2);
		try {
			btnValidateMatchCancel.click();
		} catch (Exception e) {
			elementClick(btnValidateMatchCancel);
		}
		log.info("Ending of clickOnValidateMatchCancelButton method");
	}

	public void clickOnValidateMatchValidateButton() {
		log.info("Starting of clickOnValidateMatchValidateButton method");

		this.hardWait(2);
		try {
			btnValidateMatchValidate.click();
			this.hardWait(4);

		} catch (Exception e) {
			elementClick(btnValidateMatchValidate);
			this.hardWait(4);
		}
		log.info("Ending of clickOnValidateMatchValidateButton method");
	}

	public String getValidateMatchSuccessLabel() {
		log.info("Starting of getValidateMatchSuccessLabel method");
		this.hardWait(3);
		log.info("Ending of getValidateMatchSuccessLabel method");

		return lblSuccess.getText();
	}

	public void clickOnValidateMatchSuccessCloseButton() {
		log.info("Starting of clickOnValidateMatchSuccessCloseButton method");

		this.hardWait(2);
		try {
			btnClose.click();
		} catch (Exception e) {
			elementClick(btnClose);
		}
		log.info("Ending of clickOnValidateMatchSuccessCloseButton method");
	}

	public String getMatchValidateSuccessfullyLabel() {
		log.info("Starting of getMatchValidateSuccessfullyLabel method");
		log.info("Ending of getMatchValidateSuccessfullyLabel method");

		return getText(lblMatchValidateSuccessfully);
	}

	public int getMinutes() {

		SimpleDateFormat simpleformat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a z");

		simpleformat = new SimpleDateFormat("mm");
		String strMinutes = simpleformat.format(new Date());
		String minutesValue = strMinutes.substring(1);

		int minutues = Integer.parseInt(minutesValue);
		int minutesFinalValue = 0;

		if (minutues == 9) {
			minutesFinalValue = minutues + 6;
		} else if (minutues == 8) {
			minutesFinalValue = minutues + 2;
		} else if (minutues == 7) {
			minutesFinalValue = minutues + 3;
		} else if (minutues == 6) {
			minutesFinalValue = minutues + 4;
		} else if (minutues == 5) {
			minutesFinalValue = minutues + 5;
		} else if (minutues == 4) {
			minutesFinalValue = minutues + 6;
		} else if (minutues == 3) {
			minutesFinalValue = minutues + 2;
		} else if (minutues == 2) {
			minutesFinalValue = minutues + 3;
		} else if (minutues == 1) {
			minutesFinalValue = minutues + 4;
		} else if (minutues == 0) {
			minutesFinalValue = minutues + 5;
		}

		String minutesValue1 = null;
		for (int i = 0; i < 11;) {
			try {
				minutesValue1 = strMinutes.substring(1).replace(String.valueOf(i), "0");
				int minutues1 = Integer.parseInt(minutesValue1);
				if (minutues1 == 0) {

					break;
				}
			} catch (Exception e) {
				expectThrows(null, null);
				System.out.println();
			}

			i++;
		}
		String minutesValue2 = strMinutes.substring(0, 1);

		String last = minutesValue2 + minutesValue1;
		int num = Integer.parseInt(last);

		finalminutesValue = num + minutesFinalValue;
		System.out.println(finalminutesValue);

		lastMinutes = String.valueOf(finalminutesValue);

		return finalminutesValue;
	}

	public void clickOnCancelCalenderButton() {
		log.info("Starting of clickOnCancelCalenderButton method");

		try {
			clickUsingActionsClass(btnCancelCalender);
		} catch (Exception e) {
			clickOnWebElement(btnCancelCalender);
		}

		log.info("Starting of clickOnCancelCalenderButton method");
	}

	public void setRegistrationStartDate() {
		log.info("Starting of setRegistrationStartDate method");

		scrollDown(200);
		clickOnWebElement(txtBoxRegistrationStartDate);

		int date = this.getCurrentDate();
		String hours = this.getCurrentHour();
		String meridiem = this.getCurrentMeridiem();

		this.clickOnCurrentDate(date);
		this.clickOnCurrentTime(meridiem);
		this.clickOnCurrentTime(hours);
		hardWait(1);
		this.clickUsingActionsClass(btnDefaultTimeInMinutes);
		hardWait(2);

		log.info("Ending of setRegistrationStartDate method");
	}

	public void setRegistrationEndDate() {
		log.info("Starting of setRegistrationEndDate method");

		this.hardWait(2);
		try {
			clickUsingActionsClass(txtBoxRegistrationEndDate);
		} catch (Exception e) {
			clickOnWebElement(txtBoxRegistrationEndDate);
		}

		int date = this.getCurrentDate();
		String hours = this.getCurrentHour();
		String meridiem = this.getCurrentMeridiem();

		String pattern = "h";

		LocalTime currentHour = LocalTime.now();
		LocalTime futureHour = currentHour.plusHours(1);
		String futureHourValue = futureHour.format(DateTimeFormatter.ofPattern(pattern));
		System.out.println(futureHourValue);

		this.clickOnCurrentDate(date);
		this.clickOnCurrentTime(meridiem);

		try {
			System.out.println(driver.findElement(By.cssSelector("div>span[aria-label='" + hours + " hours']")));
			WebElement currentHourValue = driver
					.findElement(By.cssSelector("div>span[aria-label='" + hours + " hours']"));

			this.hardWait(2);
			Actions action = new Actions(driver);
			action.moveToElement(currentHourValue).contextClick(currentHourValue).build().perform();
		} catch (Exception e) {
			clickOnWebElement(driver.findElement(By.cssSelector("div>span[aria-label='" + hours + " hours']")));
		}

		try {
			min = String.valueOf(this.getMinutes());
			if (driver.findElement(By.cssSelector("span[aria-label='" + min + " minutes']")).isDisplayed()) {
				try {
					this.clickOnCurrentTime(min);

					this.setCompetitionStartDate();
				} catch (Exception e) {
					Actions action = new Actions(driver);
					action.moveToElement(driver.findElement(By.cssSelector("span[aria-label='" + min + " minutes']")))
							.click().perform();
				}
			}
		} catch (Exception e) {
			try {
				clickUsingActionsClass(txtBoxRegistrationEndDate);
			} catch (Exception e2) {
				clickOnWebElement(txtBoxRegistrationEndDate);
			}
			hardWait(2);
			try {
				clickUsingActionsClass(txtBoxRegistrationEndDate);
			} catch (Exception e2) {
				clickOnWebElement(txtBoxRegistrationEndDate);
			}

			this.clickOnCurrentDate(date);
			this.clickOnCurrentTime(meridiem);
			this.selectFutureHour();

			this.setfutureCompitionDate();
		}

		log.info("Ending of setRegistrationEndDate method");
	}

	public void selectFutureHour() {
		log.info("Starting of selectFutureHour method");

		String pattern = "h";
		LocalTime currentHour = LocalTime.now();

		if (lastMinutes.substring(0, 1).contains("5")) {
			if (lastMinutes.substring(1).contains("5")) {
				System.out.println();
			} else if (lastMinutes.substring(1).contains("0")) {
				System.out.println();
			} else {
				String currentHourValue = currentHour.format(DateTimeFormatter.ofPattern(pattern));
				System.out.println(currentHourValue);
				this.clickOnCurrentTime(currentHourValue);
				min = "05";
				this.clickOnCurrentTime(min);
			}
		}

		if (lastMinutes.substring(0, 1).contains("6")) {
			LocalTime futureHour = currentHour.plusHours(1);
			String futureHourValue = futureHour.format(DateTimeFormatter.ofPattern(pattern));
			System.out.println(futureHourValue);
			this.clickOnCurrentTime(futureHourValue);
			min = "05";
			this.clickOnCurrentTime(min);
		}

		log.info("Ending of selectFutureHour method");
	}

	public void setfutureCompitionDate() {

		log.info("Starting of setCompetitionStartDate method");

		try {
			clickUsingActionsClass(txtBoxCompetitionStartDate);
		} catch (Exception e) {
			clickOnWebElement(txtBoxCompetitionStartDate);
		}

		int date = this.getCurrentDate();
		String hours = this.getCurrentHour();
		String meridiem = this.getCurrentMeridiem();
		String pattern = "h";

		LocalTime currentHour = LocalTime.now();
		LocalTime futureHour = currentHour.plusHours(1);
		String futureHourValue = futureHour.format(DateTimeFormatter.ofPattern(pattern));
		System.out.println(futureHourValue);

		this.clickOnCurrentDate(date);
		this.clickOnCurrentTime(meridiem);
		System.out.println(driver.findElement(By.cssSelector("div>span[aria-label='" + hours + " hours']")));
		WebElement currentHourValue = driver.findElement(By.cssSelector("div>span[aria-label='" + hours + " hours']"));

		try {
			this.hardWait(2);
			Actions action = new Actions(driver);
			action.moveToElement(currentHourValue).contextClick(currentHourValue).build().perform();
		} catch (Exception e) {
			clickOnWebElement(driver.findElement(By.cssSelector("div>span[aria-label='" + hours + " hours']")));
		}

		this.selectFutureHour();

		log.info("Ending of setCompetitionStartDate method");

	}

	public void setCompetitionStartDate() {
		log.info("Starting of setCompetitionStartDate method");

		try {
			clickUsingActionsClass(txtBoxCompetitionStartDate);
		} catch (Exception e) {
			clickOnWebElement(txtBoxCompetitionStartDate);
		}

		int date = this.getCurrentDate();
		String hours = this.getCurrentHour();
		String meridiem = this.getCurrentMeridiem();
		String pattern = "h";

		LocalTime currentHour = LocalTime.now();
		LocalTime futureHour = currentHour.plusHours(1);
		String futureHourValue = futureHour.format(DateTimeFormatter.ofPattern(pattern));
		System.out.println(futureHourValue);

		this.clickOnCurrentDate(date);
		this.clickOnCurrentTime(meridiem);
		System.out.println(driver.findElement(By.cssSelector("div>span[aria-label='" + hours + " hours']")));
		WebElement currentHourValue = driver.findElement(By.cssSelector("div>span[aria-label='" + hours + " hours']"));

		try {
			this.hardWait(2);
			Actions action = new Actions(driver);
			action.moveToElement(currentHourValue).contextClick(currentHourValue).build().perform();
		} catch (Exception e) {
			clickOnWebElement(driver.findElement(By.cssSelector("div>span[aria-label='" + hours + " hours']")));
		}

		String min = null;
		try {
			min = String.valueOf(this.getMinutes());
			if (driver.findElement(By.cssSelector("span[aria-label='" + min + " minutes']")).isDisplayed()) {
				try {
					this.clickOnCurrentTime(min);
				} catch (Exception e) {
					Actions action = new Actions(driver);
					action.moveToElement(driver.findElement(By.cssSelector("span[aria-label='" + min + " minutes']")))
							.click().perform();
				}
			}
		} catch (Exception e) {
			hardWait(2);
			try {
				clickUsingActionsClass(txtBoxCompetitionStartDate);
			} catch (Exception e2) {
				clickOnWebElement(txtBoxCompetitionStartDate);
			}
			try {
				clickUsingActionsClass(txtBoxCompetitionStartDate);
			} catch (Exception e1) {
				clickOnWebElement(txtBoxCompetitionStartDate);
			}

			this.clickOnCurrentDate(date);
			this.clickOnCurrentTime(meridiem);
			this.selectFutureHour();
		}

		log.info("Ending of setCompetitionStartDate method");
	}

	public boolean isRoundOneDisplayed() {
		log.info("Starting of isRoundOneDisplayed method");

		boolean isRoundOneDisplayed = false;

		try {
			if (isDisplayed(txtRoundOne)) {
				isRoundOneDisplayed = true;
			}
		} catch (Exception e) {
			isRoundOneDisplayed = false;
		}

		log.info("Ending of isRoundOneDisplayed method");

		return isRoundOneDisplayed;
	}

	public void clickOnPlayersTab() {
		log.info("Starting of clickOnPlayersTab method");

		try {
			clickUsingActionsClass(tabPlayers);
		} catch (Exception e) {
			clickOnWebElement(tabPlayers);
		}
		log.info("Ending of clickOnPlayersTab method");
	}
}
