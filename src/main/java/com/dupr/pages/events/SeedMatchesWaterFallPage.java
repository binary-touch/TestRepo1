package com.dupr.pages.events;

import java.time.Duration;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BFindBys;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class SeedMatchesWaterFallPage extends DUPRBaseAutomationPage {
	private static final Logger log = LogManager.getLogger(SeedMatchesWaterFallPage.class);

	@B2BFindBy(xpath = "//button[contains(text(),'View the Queue')]")
	private WebElement btnViewTheQueue;

	@B2BFindBy(xpath = "//h4[contains(@class,'MuiTypography-root MuiTypography-h4')]/parent::div//h3")
	private WebElement txtNameOfBracket;

	@B2BFindBy(xpath = "//h4[contains(@class,'MuiTypography-root MuiTypography-h4')]")
	private WebElement txtNameOfClub;

	@B2BFindBy(xpath = "//span[contains(@class,'MuiChip-label MuiChip-labelSmall')]")
	private WebElement txtStatusOfBracket;

	@B2BFindBy(xpath = "//h4[contains(@class,'MuiTypography-root MuiTypography-h4')]/parent::div//h6")
	private WebElement txtStartAndEndDates;

	@B2BFindBy(xpath = "//p[contains(text(),'$')]")
	private WebElement txtBracketPrize;

	@B2BFindBy(xpath = "//button[text()='Seed Matches' and @disabled]")
	private WebElement btnSeedMatchesDisabled;

	@B2BFindBy(xpath = "//button[contains(text(),'Edit Bracket')]")
	private WebElement btnEditBracket;

	@B2BFindBy(xpath = "//button[contains(text(),'End Bracket')]")
	private WebElement btnEndBracket;

	@B2BFindBy(xpath = "//button[contains(text(),'Share')]")
	private WebElement btnShare;

	@B2BFindBy(xpath = "//button[contains(text(),'Show Details')]")
	private WebElement btnShowDetails;

	@B2BFindBy(xpath = "//button[contains(text(),'Players')]")
	private WebElement tabPlayers;

	@B2BFindBy(xpath = "//button[contains(text(),'Teams')]")
	private WebElement tabTeams;

	@B2BFindBy(xpath = "//button[contains(text(),'Unmatched Players')]")
	private WebElement tabUnMatchedPlayers;

	@B2BFindBy(xpath = "//button[text()='Matches']")
	private WebElement tabMatches;

	@B2BFindBy(xpath = "//button[contains(text(),'Information')]")
	private WebElement tabInformation;

	@B2BFindBy(xpath = "//input[@id='Search']")
	private WebElement txtBoxSearch;
	
	@B2BFindBy(xpath = "//h6[contains(text(),'Home')]")
	private WebElement mnuHome;

	@B2BFindBy(xpath = "//*[contains(text(),'Export CSV')]")
	private WebElement btnExportCSV;

	@B2BFindBy(xpath = "//button[contains(text(),'Sort')]")
	private WebElement btnSort;

	@B2BFindBy(xpath = "//span[contains(text(),'Registered')]")
	private WebElement btnRegistered;

	@B2BFindBy(xpath = "//span[contains(text(),'Waitlisted')]")
	private WebElement btnWaitlisted;

	@B2BFindBy(xpath = "//button[contains(text(),'Clear Filters')]")
	private WebElement btnClearFilters;

	@B2BFindBy(xpath = "//button[contains(text(),'Add Participants')]")
	private WebElement btnAddParticipants;

	@B2BFindBy(xpath = "//div[contains(@class,'infinite-scroll-component')]//h4/ancestor::div[contains(@class,'MuiGrid-root MuiGrid-container')]")
	private WebElement txtPlayerDetails;

	@B2BFindBy(xpath = "//h2[contains(text(),'BYE')]")
	private WebElement lblBye;

	@B2BFindBy(xpath = "//button[contains(text(),'Queue')]")
	private WebElement tabQueue;

	@B2BFindBy(xpath = "//span[contains(text(),'East')]")
	private WebElement btnEast;

	@B2BFindBy(xpath = "//span[contains(text(),'West')]")
	private WebElement btnWest;

	@B2BFindBy(xpath = "//span[contains(text(),'South')]")
	private WebElement btnSouth;

	@B2BFindBy(xpath = "//span[contains(text(),'North East')]")
	private WebElement btnNorthEast;

	@B2BFindBy(xpath = "//span[contains(text(),'South West')]")
	private WebElement btnSouthWest;

	@B2BFindBy(xpath = "//span[contains(text(),'North West')]")
	private WebElement btnNorthWest;

	@B2BFindBy(xpath = "//span[contains(text(),'South East')]")
	private WebElement btnSouthEast;

	@B2BFindBy(xpath = "//button[contains(text(),'Exit the queue')]")
	private WebElement btnExitTheQueue;

	@B2BFindBy(xpath = "//button[contains(text(),'View Draws')]")
	private WebElement btnViewDraws;

	@B2BFindBy(xpath = "//button[text()='Having Trouble?']")
	private WebElement btnHavingTrouble;

	@B2BFindBy(xpath = "//h4[text()='Having Wi-Fi problems or the app not running the way you want?']")
	private WebElement lblWiFiProblem;

	@B2BFindBy(xpath = "//a[text()='click here']")
	private WebElement lnkClickHere;

	@B2BFindBy(xpath = "//button[text()='Download Diagram']")
	private WebElement btnDownloadDiagram;

	@B2BFindBy(xpath = "//button[text()='OK']")
	private WebElement btnOk;

	@B2BFindBy(xpath = "//button[contains(@class,'MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium')]")
	private WebElement iconCloseOnSupport;

	@B2BFindBy(xpath = "//button[text()='Seed Matches'")
	private WebElement btnSeedMatches;

	@B2BFindBy(xpath = "//*[contains(@class,'MuiSvgIcon-root MuiSvgIcon-colorFirstWinner MuiSvgIcon-fontSizeMedium')]")
	private WebElement lblGoldMedal;

	@B2BFindBy(xpath = "//*[contains(@class,'MuiSvgIcon-root MuiSvgIcon-colorSecondWinner MuiSvgIcon-fontSizeMedium')]")
	private WebElement lblSilverMedal;

	@B2BFindBy(xpath = "//*[contains(@class,'MuiSvgIcon-root MuiSvgIcon-colorThirdWinner MuiSvgIcon-fontSizeMedium')]")
	private WebElement lblBronzeMedal;

	@B2BFindBy(xpath = "//b[contains(text(),'No more matches')]")
	private WebElement txtNoMoreMatches;

	@B2BFindBy(xpath = "//button[contains(text(),'Standings')]")
	private WebElement tabStanding;

	@B2BFindBys(@B2BFindBy(xpath = "//button[contains(text(),'Add Scores')]"))
	private List<WebElement> btnAddScores;

	@B2BFindBys(@B2BFindBy(xpath = "//button[contains(text(),'Validate')]"))
	private List<WebElement> btnValidate;
	
	@B2BFindBy(xpath = "//p[contains(text(),'The matches of this event were edited by event director after the completion of the event.')]")
	private WebElement lblMatchesAreEdited;
	
	//---------------
	
	@B2BFindBy(xpath = "(//p[contains(text(), 'Game 3')]//parent::div//child::div//descendant::input)[1]")
	private WebElement lblFirstGameScore;

	@B2BFindBy(xpath = "(//p[contains(text(), 'Game 3')]//parent::div//child::div//descendant::input)[2]")
	private WebElement lblSecondGameScore;

	@B2BFindBy(xpath = "//button[contains(text(),'Edit Scores')]")
	private WebElement btnEditScores;

	@B2BFindBy(xpath = "//h4[contains(text(),'Edit Scores')]")
	private WebElement lblEditScore;

	@B2BFindBy(xpath = "//h5[contains(text(),'Match Date')]")
	private WebElement lblMatchDate;

	@B2BFindBy(xpath = "//button[contains(text(),'Submit')]")
	private WebElement btnSubmit;

	@B2BFindBy(xpath = "//h4[contains(text(),'Edit Scores')]//button/*/*")
	private WebElement iconCross;

	@B2BFindBy(xpath = "(//span[contains(text(),'Game 3')]//parent::div//following::div//descendant::input)[1]")
	private WebElement lblFirstGameScoreEdit;

	@B2BFindBy(xpath = "(//span[contains(text(),'Game 3')]//parent::div//following::div//descendant::input)[2]")
	private WebElement lblSecondGameScoreEdit;

	@B2BFindBy(xpath = "//h4[contains(text(),'Submitting these new scores will affect scheduled matches')]")
	private WebElement lblSubmittingNewScores;

	@B2BFindBy(xpath = "//button[contains(text(),'Submit Scores')]")
	private WebElement btnSubmitScore;

	@B2BFindBy(xpath = "//button[contains(text(),'Go Back')]")
	private WebElement btnGoBack;

	@B2BFindBy(xpath = "//h4[contains(text(),'Submitting these new scores will affect scheduled matches')]//button/*/*")
	private WebElement iconClose;

	@B2BFindBy(xpath = "//button[contains(text(),'Forfeit')]")
	private WebElement btnForfeit;

	public SeedMatchesWaterFallPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public boolean isSeedMatchesButtonDisabled() {
		log.info("Starting of isSeedMatchesButtonDisabled method");
		boolean isSeedMatchesDisabled = false;
		hardWait(4);
		try {
			if (btnSeedMatchesDisabled.isDisplayed() == true) {

				isSeedMatchesDisabled = true;
			}
		} catch (Exception e) {
			isSeedMatchesDisabled = false;
		}
		log.info("Ending of isSeedMatchesButtonDisabled method");

		return isSeedMatchesDisabled;
	}

	public boolean isBracketHomePageContains() {
		log.info("Starting of isBracketHomePageContains method");

		boolean isBracketHomePageContains = false;
		try {
			if (isDisplayed(txtNameOfBracket) 
					&& isDisplayed(txtNameOfClub) 
					&& isDisplayed(txtStatusOfBracket)
					&& isDisplayed(txtStartAndEndDates)
					&& isDisplayed(txtBracketPrize)
					&& isDisplayed(btnEditBracket) 
					&& isDisplayed(btnEndBracket) 
					&& isDisplayed(btnShare)
					&& isDisplayed(btnShowDetails) 
					&& isDisplayed(tabPlayers) && 
					isDisplayed(tabTeams)
					&& isDisplayed(tabUnMatchedPlayers) 
					&& isDisplayed(tabMatches)
					&& isDisplayed(tabInformation)) {
				try {
					clickUsingActionsClass(tabPlayers);
				} catch (Exception e) {
					clickOnWebElement(tabPlayers);
				}
               hardWait(4);
				if (isDisplayed(txtBoxSearch)
						&& isDisplayed(btnExportCSV)
						&& isDisplayed(btnSort)
						&& isDisplayed(btnRegistered)
						&& isDisplayed(btnWaitlisted) && 
						isDisplayed(btnClearFilters)
						&& isDisplayed(btnAddParticipants)
						&& isDisplayed(txtPlayerDetails)) {
					isBracketHomePageContains = true;
				}

			}
		} catch (Exception e) {
			isBracketHomePageContains = false;
		}

		log.info("Ending of isBracketHomePageContains method");

		return isBracketHomePageContains;
	}

	public boolean isByeLabelDisplayed() {
		log.info("Starting of isByeLabelDisplayed method");

		boolean isByeLabelDisplayed = false;

		try {
			if (isDisplayed(lblBye)) {
				isByeLabelDisplayed = true;
			}
		} catch (Exception e) {
			for (int i = 0; i < 3; i++) {
				scrollDown(300);
				if (isDisplayed(lblBye)) {
					isByeLabelDisplayed = true;
					break;
				}
				isByeLabelDisplayed = false;
			}
		}

		log.info("Ending of isByeLabelDisplayed method");

		return isByeLabelDisplayed;
	}

	public boolean isQueueTabDisplayed() {
		log.info("Starting of isQueueTabDisplayed method");

		boolean isQueueTabDisplayed = false;
		try {
			if (isDisplayed(tabQueue)) {
				isQueueTabDisplayed = true;
			}
		} catch (Exception e) {

			isQueueTabDisplayed = false;
		}

		log.info("Ending of isQueueTabDisplayed method");

		return isQueueTabDisplayed;
	}

	public boolean isMatchesTabContains() {
		log.info("Starting of isMatchesTabContains method");

		boolean isMatchesTabContains = false;

		try {
			if (isDisplayed(btnEast) && isDisplayed(btnWest) && isDisplayed(btnSouth) && isDisplayed(btnNorthEast)
					&& isDisplayed(btnSouthWest) && isDisplayed(btnNorthWest) && isDisplayed(btnSouthEast)) {
				isMatchesTabContains = true;
			}
		} catch (Exception e) {
			isMatchesTabContains = false;

		}
		log.info("Ending of isMatchesTabContains method");

		return isMatchesTabContains;
	}

	public boolean isSeedMatchesDisabled() {
		log.info("Starting of isSeedMatchesDisabled method");

		boolean isSeedMatchesDisabled = false;

		try {
			if (btnSeedMatchesDisabled.isDisplayed() == true) {

				isSeedMatchesDisabled = true;
			}
		} catch (Exception e) {
			isSeedMatchesDisabled = false;
		}
		log.info("Ending of isSeedMatchesDisabled method");
		return isSeedMatchesDisabled;
	}

	public void clickOnMyMatchesButton(String eventName) {
		log.info("Starting of clickOnMyMatchesButton method");

		try {
			clickOnWebElement(driver.findElement(By.xpath(
					"//h6[contains(text(),'" + eventName + "')]/parent::div//button[contains(text(),'My Matches')]")));
		} catch (Exception e) {
			driver.findElement(By.xpath(
					"//h6[contains(text(),'" + eventName + "')]/parent::div//button[contains(text(),'My Matches')]"))
					.click();
		}

		this.hardWait(2);

		log.info("Ending of clickOnMyMatchesButton method");
	}

	public void clickOnViewQueueButton(String eventName) {
		log.info("Starting of clickOnViewQueueButton method");

		try {
			clickOnWebElement(driver.findElement(By.xpath("//h6[contains(text(),'" + eventName
					+ "')]/parent::div//button[contains(text(),'View the Queue')]")));
		} catch (Exception e) {
			driver.findElement(By.xpath("//h6[contains(text(),'" + eventName
					+ "')]/parent::div//button[contains(text(),'View the Queue')]")).click();
		}

		this.hardWait(2);

		log.info("Ending of clickOnViewQueueButton method");
	}

	public boolean isViewTheQueuebuttonDisplayed() {
		log.info("Starting of isViewTheQueuebuttonDisplayed method");

		boolean isViewTheQueuebuttonDisplayed = false;

		try {
			if (btnViewTheQueue.isDisplayed() == true) {

				isViewTheQueuebuttonDisplayed = true;
			}
		} catch (Exception e) {
			isViewTheQueuebuttonDisplayed = false;
		}
		log.info("Ending of isViewTheQueuebuttonDisplayed method");

		return isViewTheQueuebuttonDisplayed;
	}

	public boolean isExitTheQueuebuttonDisplayed() {
		log.info("Starting of isExitTheQueuebuttonDisplayed method");

		boolean isExitTheQueuebuttonDisplayed = false;

		clickOnElementUsingActionClass(tabQueue);
		this.hardWait(2);
		try {
			if (btnExitTheQueue.isDisplayed() == true) {

				isExitTheQueuebuttonDisplayed = true;
			}
		} catch (Exception e) {
			isExitTheQueuebuttonDisplayed = false;
		}
		log.info("Ending of isExitTheQueuebuttonDisplayed method");

		return isExitTheQueuebuttonDisplayed;
	}

	public boolean isViewDrawButtonDisplayed() {
		log.info("Starting of isViewDrawButtonDisplayed method");

		boolean isViewDrawButtonDisplayed = false;

		try {
			if (btnViewDraws.isDisplayed() == true) {

				isViewDrawButtonDisplayed = true;
			}
		} catch (Exception e) {
			isViewDrawButtonDisplayed = false;
		}
		log.info("Ending of isViewDrawButtonDisplayed method");

		return isViewDrawButtonDisplayed;
	}

	public void clickOnViewDrawsButton() {
		log.info("Starting of clickOnViewDrawsButton method");

		this.clickOnWebElement(btnViewDraws);

		log.info("Ending of clickOnViewDrawsButton method");
	}
	public void clickOnHomeMenu() {
		log.info("Starting of clickOnHomeMenu method");
       
		this.clickOnWebElement(mnuHome);

		log.info("Ending of clickOnHomeMenu method");
	}

	public void clickOnHavingTroubleButton() {
		log.info("Starting of clickOnHavingTroubleButton method");

		this.clickOnWebElement(btnHavingTrouble);

		log.info("Ending of clickOnHavingTroubleButton method");
	}

	public boolean isHavingTroubleButtonDisplayed() {
		log.info("Starting of isHavingTroubleButtonDisplayed method");

		boolean HavingTrouble = false;

		try {
			if (btnHavingTrouble.isDisplayed()) {
				HavingTrouble = true;
			}
		} catch (Exception e) {
			HavingTrouble = false;
		}

		log.info("Ending of isHavingTroubleButtonDisplayed method");

		return HavingTrouble;
	}

	public String getHavingTroubleText() {
		log.info("Starting of getHavingTroubleText method");
		log.info("Ending of getHavingTroubleText method");

		return getText(btnHavingTrouble);
	}

	public String getHavingWiFiProblemText() {
		log.info("Starting of getHavingWiFiProblemText method");
		log.info("Ending of getHavingWiFiProblemText method");

		return getText(lblWiFiProblem);
	}

	public boolean isHavingWiFiProblemLabelDisplayed() {
		log.info("Starting of isHavingWiFiProblemLabelDisplayed method");

		boolean lblState = false;

		try {
			if (lblWiFiProblem.isDisplayed()) {
				lblState = true;
			}
		} catch (Exception e) {
			lblState = false;
		}
		log.info("Ending of isHavingWiFiProblemLabelDisplayed method");

		return lblState;
	}

	public String getClickHereText() {
		log.info("Starting of getClickHereText method");
		log.info("Ending of getClickHereText method");

		return getText(lnkClickHere);
	}

	public void clickOnClickHereLink() {
		log.info("Starting of clickOnClickHereLink method");

		this.clickOnWebElement(lnkClickHere);

		log.info("Ending of clickOnClickHereLink method");
	}

	public String getDownloadDiagramText() {
		log.info("Starting of getDownloadDiagramText method");
		log.info("Ending of getDownloadDiagramText method");

		return getText(btnDownloadDiagram);
	}

	public void clickOnDownloadDiagramButton() {
		log.info("Starting of clickOnDownloadDiagramButton method");

		this.clickOnWebElement(btnDownloadDiagram);

		log.info("Ending of clickOnDownloadDiagramButton method");
	}

	public String getOkText() {
		log.info("Starting of getOkText method");
		log.info("Ending of getOkText method");

		return getText(btnOk);
	}

	public void clickOnOkButton() {
		log.info("Starting of clickOnOkButton method");

		this.clickOnWebElement(btnOk);

		log.info("Ending of clickOnOkButton method");
	}

	public boolean isCloseIconDisplayedOnHavingWiFiProblemPopUp() {
		log.info("Starting of isCloseIconDisplayedOnHavingWiFiProblemPopUp method");
		log.info("Ending of isCloseIconDisplayedOnHavingWiFiProblemPopUp method");

		return iconClose.isDisplayed();
	}

	public void clickOnCloseIcon() {
		log.info("Starting of clickOnCloseIcon method");

		this.clickOnWebElement(iconClose);

		log.info("Ending of clickOnCloseIcon method");
	}

	public void clickOnHavingTroubleForMultipleTimes() {
		log.info("Starting of clickOnHavingTroubleForMultipleTimes method");

		for (int i = 0; i < 8; i++) {
			this.clickOnWebElement(btnHavingTrouble);
		}

		log.info("Ending of clickOnHavingTroubleForMultipleTimes method");
	}

	public boolean isHavingTroubleButtonIsClickable() {
		log.info("Starting of isHavingTroubleButtonIsClickable method");
		log.info("Ending of isHavingTroubleButtonIsClickable method");

		return this.isClickable(btnHavingTrouble);
	}

	public void clickOnDownloadDiagramForMultipleTimes() {
		log.info("Starting of clickOnDownloadDiagramForMultipleTimes method");

		for (int i = 0; i < 8; i++) {
			this.clickOnWebElement(btnDownloadDiagram);
		}

		log.info("Ending of clickOnDownloadDiagramForMultipleTimes method");
	}

	public boolean isDownloadDiagramButtonIsClickable() {
		log.info("Starting of isDownloadDiagramButtonIsClickable method");
		log.info("Ending of isDownloadDiagramButtonIsClickable method");

		return this.isClickable(btnDownloadDiagram);
	}

	public boolean isClickable(WebElement webElement) {
		log.info("Starting of isClickable method");

		try {

			WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
			webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
			log.info("Ending of isClickable method");

			return true;
		} catch (Exception e) {
			log.info("Ending of isClickable method");
			return false;
		}
	}

	public void navigateBack() {
		log.info("Starting of navigateBack method");

		driver.navigate().back();
		hardWait(4);

		log.info("Ending of navigateBack method");
	}

	public int addScore() {
		log.info("Starting of addScore method");

		hardWait(4);
		int addScore = btnAddScores.size();
		if (addScore == 0) {
			for (int i = 1; i < 6; i++) {
				int scroll = i * 1000;
				scrollDown(scroll);
				hardWait(5);
				addScore = btnAddScores.size();
				if (addScore > 0) {
					break;
				}
				try {
					if (txtNoMoreMatches.isDisplayed() == true) {
						break;
					}
				} catch (Exception e) {
					scrollDown(500);
				}
			}
		}
		log.info("Ending of addScore method");
		return addScore;
	}

	public int validateScore() {
		log.info("Starting of validateScore method");
		hardWait(4);
		int validateScore = btnValidate.size();
		if (validateScore == 0) {
			for (int i = 1; i < 6; i++) {
				int scroll = i * 1000;
				scrollDown(scroll);
				hardWait(5);
				validateScore = btnValidate.size();
				if (validateScore > 0) {
					break;
				}
				try {
					if (txtNoMoreMatches.isDisplayed() == true) {
						break;
					}
				} catch (Exception e) {
					scrollDown(500);
				}
			}
		}
		log.info("Ending of validateScore method");
		return validateScore;
	}

	public void clickOnStandingTab() {
		log.info("Starting of clickOnStandingTab method");
		
		driver.navigate().refresh();
		
		
		try {
			clickUsingActionsClass(tabStanding);
		} catch (Exception e) {
			this.clickOnWebElement(tabStanding);
		}

		log.info("Ending of clickOnStandingTab method");
	}

	public boolean isAllThreeMedalsDisplayed() {
		log.info("Starting of isAllThreeMedalsDisplayed method");

		boolean isAllThreeMedalsDisplayed = false;

		try {
			if (isDisplayed(lblGoldMedal) && isDisplayed(lblSilverMedal) && isDisplayed(lblBronzeMedal)) {
				isAllThreeMedalsDisplayed = true;
			}
		} catch (Exception e) {
			isAllThreeMedalsDisplayed = false;

		}
		log.info("Ending of isAllThreeMedalsDisplayed method");

		return isAllThreeMedalsDisplayed;
	}
	
//----------------------------------
	
	public String getFirstGameScoreText() {
		log.info("Starting of getFirstGameScoreText method");

		String FirstGameScore = lblFirstGameScore.getAttribute("value");

		log.info("Ending of getFirstGameScoreText method");

		return FirstGameScore;
	}

	public String getSecondGameScoreText() {
		log.info("Starting of getSecondGameScoreText method");

		String SecondGameScore = lblSecondGameScore.getAttribute("value");

		log.info("Ending of getSecondGameScoreText method");

		return SecondGameScore;
	}

	public void clickOnEditScore() {
		log.info("Starting of clickOnEditScore method");

		clickOnWebElement(btnEditScores);

		log.info("Ending of clickOnEditScore method");
	}

	public boolean isEditScoreDisplayed() {
		log.info("Starting of isEditScoreDisplayed method");

		boolean lblState = false;

		try {

			if (lblEditScore.isDisplayed()) {

				lblState = true;
			}

		} catch (Exception e) {
			lblState = false;
		}
		log.info("Ending of isEditScoreDisplayed method");

		return lblState;
	}

	public String getEditScoreText() {
		log.info("Starting of getEditScoreText method");
		log.info("Ending of getEditScoreText method");

		return lblEditScore.getText();
	}

	public String getMatchDateText() {
		log.info("Starting of getMatchDateText method");
		log.info("Ending of getMatchDateText method");

		return lblMatchDate.getText();
	}

	public String getSubmitButtonText() {
		log.info("Starting of getSubmitButtonText method");
		log.info("Ending of getSubmitButtonText method");

		return btnSubmit.getText();
	}

	public boolean isCrossIconDisplayed() {
		log.info("Starting of isCloseIconDisplayed method");
		log.info("Ending of isCloseIconDisplayed method");

		return iconCross.isDisplayed();
	}

	public void setFirstGameScoreEdit(String editFirstGameScore) {
		log.info("Starting of setFirstGameScoreEdit method");

		lblFirstGameScoreEdit.sendKeys(Keys.CONTROL + "A");
		lblFirstGameScoreEdit.sendKeys(Keys.DELETE);
		lblFirstGameScoreEdit.sendKeys(editFirstGameScore);

		log.info("Ending of setFirstGameScoreEdit method");
	}

	public void setSecondGameScoreEdit(String editSecondGameScore) {

		log.info("Starting of setSecondGameScoreEdit method");
		lblSecondGameScoreEdit.sendKeys(Keys.CONTROL + "A");
		lblSecondGameScoreEdit.sendKeys(Keys.DELETE);
		lblSecondGameScoreEdit.sendKeys(editSecondGameScore);

		log.info("Ending of setSecondGameScoreEdit method");
	}

	public void clickOnSubmitButton() {
		log.info("Starting of clickOnSubmitButton method");

		clickOnWebElement(btnSubmit);

		log.info("Ending of clickOnSubmitButton method");
	}

	public String getSubmitScoresButtonText() {
		log.info("Starting of getSubmitScoresButtonText method");
		log.info("Ending of getSubmitScoresButtonText method");

		return btnSubmitScore.getText();
	}

	public String getSubmittingNewScoresText() {
		log.info("Starting of getSubmittingNewScoresText method");
		log.info("Ending of getSubmittingNewScoresText method");

		return lblSubmittingNewScores.getText();
	}

	public boolean isSubmittingNewScoresLabelDisplayed() {
		log.info("Starting of isSubmittingNewScoresLabelDisplayed method");

		boolean lblState = false;

		try {

			if (lblSubmittingNewScores.isDisplayed()) {
				lblState = true;
			}
		} catch (Exception e) {
			lblState = false;
		}
		log.info("Ending of isSubmittingNewScoresLabelDisplayed method");

		return lblState;

	}

	public String getGoBackText() {
		log.info("Starting of getGoBackText method");
		log.info("Ending of getGoBackText method");

		return btnGoBack.getText();
	}

	public boolean isCloseIconDisplayed() {
		log.info("Starting of uploadProfilePicture method");
		log.info("Ending of uploadProfilePicture method");

		return iconClose.isDisplayed();
	}

	public void clickOnGoBack() {
		log.info("Starting of clickOnGoBack method");

		clickOnWebElement(btnGoBack);

		log.info("Ending of clickOnGoBack method");
	}

	public void clickOnSubmitScoreButton() {
		log.info("Starting of clickOnSubmitScoreButton method");

		clickOnWebElement(btnSubmitScore);

		log.info("Ending of clickOnSubmitScoreButton method");
	}

	public boolean isEditButtonDisplayed() {
		log.info("Starting of isEditButtonDisplayed method");
		log.info("Ending of isEditButtonDisplayed method");

		return btnEditScores.isDisplayed();
	}

	public boolean isForfeitButtonDisplayed() {
		log.info("Starting of isForfeitButtonDisplayed method");
		log.info("Ending of isForfeitButtonDisplayed method");

		return btnForfeit.isDisplayed();
	}

	
	public boolean isTheMatchesLabelDisplayed() {
		log.info("Starting of isTheMatchesLabelDisplayed method");

		boolean isQueueTabDisplayed = false;
		try {
			if (isDisplayed(lblMatchesAreEdited)) {
				isQueueTabDisplayed = true;
			}
		} catch (Exception e) {

			isQueueTabDisplayed = false;
		}

		log.info("Ending of isTheMatchesLabelDisplayed method");

		return isQueueTabDisplayed;
	}
	
	
}
