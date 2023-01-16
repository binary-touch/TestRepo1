package com.dupr.pages.addamatch;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class AddClubMatchPage extends DUPRBaseAutomationPage {
	private static final Logger log = LogManager.getLogger(AddAMatchPage.class);

	@B2BFindBy(xpath = "//button[contains(text(),'Add a Match')]")
	private WebElement btnAddAMatch;

	@B2BFindBy(xpath = "//input[@data-indeterminate='false']")
	private WebElement chkAddYourselfAsPlayerInThisMatch;

	@B2BFindBy(xpath = "//h4[@class='MuiTypography-root MuiTypography-h4 css-12grqhn']")
	private WebElement btnDirectorAddedItSelf;

	@B2BFindBy(xpath = "//button[text()='Add First Opponent']")
	private WebElement btnAddFirstOpponent;

	@B2BFindBy(xpath = "//button[text()='Add Second Opponent']")
	private WebElement btnSecondOpponent;

	@B2BFindBy(xpath = "//button[text()='Doubles']")
	private WebElement btnAddDoubles;

	@B2BFindBy(xpath = "//button[text()='Add First Player']")
	private WebElement btnAddFirstPlayer;

	@B2BFindBy(xpath = "//button[text()='Add Second Player']")
	private WebElement btnAddSecondPlayer;

	@B2BFindBy(xpath = "//button[text()='Add Second Opponent']")
	private WebElement btnAddSecondOpponent;

	@B2BFindBy(xpath = "//button[text()='Cancel']")
	private WebElement btnCancel;

	@B2BFindBy(xpath = "//input[@type='radio']")
	private WebElement rdoPlayer;

	@B2BFindBy(xpath = "//button[text()='Matches']")
	private WebElement btnMatches;

	@B2BFindBy(xpath = "//button[text()='Sort']")
	private WebElement btnSort;

	@B2BFindBy(xpath = "//span[text()='Oldest to Newest']")
	private WebElement btnOldestToNewest;

	@B2BFindBy(xpath = "//span[text()='Newest to Oldest']")
	private WebElement btnNewestToOldest;

	@B2BFindBy(xpath = "//span[text()='Singles']")
	private WebElement btnSingles;

	@B2BFindBy(xpath = "//span[text()='Doubles']")
	private WebElement btnDoubles;

	@B2BFindBy(xpath = "//button[text()='Clear Filters']")
	private WebElement btnClearFilters;

	@B2BFindBy(xpath = "//span[text()='Singles']/parent::div//*[local-name()='svg']")
	private WebElement iconRightmarkSingles;

	@B2BFindBy(xpath = "//span[text()='Doubles']/parent::div//*[local-name()='svg']")
	private WebElement iconRightmarkDouble;

	public AddClubMatchPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public void clickOnAddAMatchButton() {
		log.info("Starting of clickOnAddAMatchButton method");

		elementClick(btnAddAMatch);

		log.info("Ending of clickOnAddAMatchButton method");
	}

	public void clickOnAddYourselfAsPlayerCheckbox() {
		log.info("Starting of clickOnAddYourselfAsPlayerCheckbox method");

		elementClick(chkAddYourselfAsPlayerInThisMatch);

		log.info("Ending of clickOnAddYourselfAsPlayerCheckbox method");
	}

	public boolean isDirectorNameDisplayedItSelf() {
		log.info("Starting of isDirectorNameDisplayedItSelf method");
		log.info("Ending of isDirectorNameDisplayedItSelf method");

		return isDisplayed(btnDirectorAddedItSelf);
	}

	public boolean isDisplayedSinglesDoublesInMatchesTab() {
		log.info("Starting of isDisplayedSinglesDoublesInMatchesTab method");

		boolean isDisplayedSinglesDoublesInMatchesTab = false;
		if (isDisplayed(btnSort) && isDisplayed(btnSingles) && isDisplayed(btnDoubles)
				&& isDisplayed(btnClearFilters)) {
			isDisplayedSinglesDoublesInMatchesTab = true;
		}

		log.info("Ending of isDisplayedSinglesDoublesInMatchesTab method");

		return isDisplayedSinglesDoublesInMatchesTab;
	}

	public void clickOnAddFirstOpponentButton() {
		log.info("Starting of clickOnAddFirstOpponentButton method");
		
		this.scrollDown(500);
		this.waitForElementToBeVisible(btnAddFirstOpponent);
		elementClick(btnAddFirstOpponent);

		log.info("Ending of clickOnAddFirstOpponentButton method");
	}

	public void clickOnAddFirstPlayerButton() {
		log.info("Starting of clickOnAddFirstPlayerButton method");

		elementClick(btnAddFirstPlayer);

		log.info("Ending of clickOnAddFirstPlayerButton method");
	}

	public void clickOnAddDoublesButton() {
		log.info("Starting of clickOnAddDoublesButton method");

		elementClick(btnAddDoubles);

		log.info("Ending of clickOnAddDoublesButton method");
	}

	public void clickOnAddSecondPlayerButton() {
		log.info("Starting of clickOnAddSecondPlayerButton method");

		elementClick(btnAddSecondPlayer);

		log.info("Ending of clickOnAddSecondPlayerButton method");
	}

	public void clickOnMatchesButton() {
		log.info("Starting of clickOnMatchesButton method");

		elementClick(btnMatches);

		log.info("Ending of clickOnMatchesButton method");
	}

	public void clickOnSortButton() {
		log.info("Starting of clickOnSortButton method");

		elementClick(btnSort);

		log.info("Ending of clickOnSortButton method");
	}

	public void clickOnOldestToNewestButton() {
		log.info("Starting of clickOnOldestToNewestButton method");

		elementClick(btnOldestToNewest);

		log.info("Ending of clickOnOldestToNewestButton method");
	}

	public void clickOnNewestToOldestButton() {
		log.info("Starting of clickOnNewestToOldestButton method");

		elementClick(btnNewestToOldest);

		log.info("Ending of clickOnNewestToOldestButton method");
	}

	public boolean isSortFilterContains() {
		log.info("Starting of isSortFilterContains method");

		boolean isSortFilterContains = false;
		if (isDisplayed(btnOldestToNewest) && isDisplayed(btnNewestToOldest)) {
			isSortFilterContains = true;
		}

		log.info("Ending of isSortFilterContains method");

		return isSortFilterContains;
	}

	public void clickOnSinglesButton() {
		log.info("Starting of clickOnSinglesButton method");

		elementClick(btnSingles);

		log.info("Ending of clickOnSinglesButton method");
	}

	public void clickOnDoublesButton() {
		log.info("Starting of clickOnDoublesButton method");

		elementClick(btnDoubles);

		log.info("Ending of clickOnDoublesButton method");
	}

	public void clickOnClearFiltersButton() {
		log.info("Starting of clickOnClearFiltersButton method");

		elementClick(btnClearFilters);

		log.info("Ending of clickOnClearFiltersButton method");
	}

	public void clickOnAddSecondOpponentButton() {
		log.info("Starting of clickOnAddSecondOpponentButton method");
		this.scrollDown(500);
		this.waitForElementToBeVisible(btnAddSecondOpponent);

		elementClick(btnAddSecondOpponent);

		log.info("Ending of clickOnAddSecondOpponentButton method");
	}

	public void clickOnPlayerRadioButton() {
		log.info("Starting of clickOnPlayerRadioButton method");
		hardWait(3);
		elementClick(rdoPlayer);

		log.info("Ending of clickOnPlayerRadioButton method");
	}

	public boolean isRightMarkSinglesDisplayed() {
		log.info("Starting of isRightMarkSinglesDisplayed method");
		log.info("Ending of isRightMarkSinglesDisplayed method");

		return iconRightmarkSingles.isDisplayed();
	}

	public boolean isRightMarkDoublesDisplayed() {
		log.info("Starting of isRightMarkDoublesDisplayed method");
		log.info("Ending of isRightMarkDoublesDisplayed method");

		return iconRightmarkDouble.isDisplayed();
	}

	public boolean isSingleAndDoubleRightMarkDisplayed() {
		log.info("Starting of isSingleAndDoubleRightMarkDisplayed method");

		boolean isSingleAndDoubleRightMarkDisplayed = false;
		try {
			if (isDisplayed(iconRightmarkSingles) && isDisplayed(iconRightmarkDouble)) {

				isSingleAndDoubleRightMarkDisplayed = true;
			}
		} catch (Exception e) {
			isSingleAndDoubleRightMarkDisplayed = false;
		}
		log.info("Ending of isSingleAndDoubleRightMarkDisplayed method");

		return isSingleAndDoubleRightMarkDisplayed;
	}
}
