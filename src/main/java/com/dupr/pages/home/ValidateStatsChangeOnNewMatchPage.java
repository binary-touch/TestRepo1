package com.dupr.pages.home;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class ValidateStatsChangeOnNewMatchPage extends DUPRBaseAutomationPage {

	private static final Logger log = LogManager.getLogger(ValidateStatsChangeOnNewMatchPage.class);

	@B2BFindBy(xpath = "//h3[text()='Result Overview']")
	private WebElement lblResultOverview;

	@B2BFindBy(xpath = "//div[contains(@class, 'MuiBox-root')]/button[text()='View Profile']")
	private WebElement btnViewProfile;

	@B2BFindBy(xpath = "(//div[contains(@class, 'MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0')]/div/div[contains(@class,'MuiBox-root')]/descendant::div[contains(@class, 'MuiBox-root')]/h5)[1]")
	private WebElement lblWinsCount;

	@B2BFindBy(xpath = "(//div[contains(@class, 'MuiBox-root')]/h5[contains(@class, 'MuiTypography-root MuiTypography-h5')])[3]")
	private WebElement lblPendingCount;

	@B2BFindBy(xpath = "(//div[contains(@class, 'MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0')]/div/div[contains(@class, 'MuiBox-root')]/div/div/following-sibling::div[contains(@class, 'MuiBox-root')]/h5)[1]")
	private WebElement lblLossesCount;

	@B2BFindBy(xpath = "//div[contains(@class, 'MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0')]/div/div/following-sibling::div/div/div/div/following-sibling::div/following-sibling::div/*/*/*[4]/*[1]")
	private WebElement lblTotalMatches;

	@B2BFindBy(xpath = "//p[contains(@id,'-legend-datagroup-0-title') and text()='Wins']/preceding-sibling::div")
	private WebElement chkWins;

	@B2BFindBy(xpath = "//p[contains(@id,'-legend-datagroup-1-title') and text()='Losses']")
	private WebElement chkLosses;

	@B2BFindBy(xpath = "//p[contains(@id,'-legend-datagroup-2-title') and text()='Pending']/preceding-sibling::div")
	private WebElement chkPending;

	@B2BFindBy(xpath = "//h3[contains(text(),'Result Overview')]/child::button")
	private WebElement iconInfo;

	@B2BFindBy(xpath = "//h4[@id='customized-dialog-title']")
	private WebElement lblResultOverViewOnInfoPopup;

	@B2BFindBy(xpath = "//h4[@id='customized-dialog-title']/following-sibling::div/button")
	private WebElement btnOK;

	@B2BFindBy(xpath = "//h4[@id='customized-dialog-title']/button")
	private WebElement iconClose;

	@B2BFindBy(xpath = "//h3[contains(@class, 'MuiTypography-root MuiTypography-h3') and text()='Result Overview']")
	private WebElement lblPlayerProfile;

	@B2BFindBy(xpath = "//div[contains(@class, 'MuiBox-root')]//descendant::h6[text()='Doubles']")
	private WebElement lblDoubles;

	@B2BFindBy(xpath = "//div[contains(@class, 'MuiBox-root')]/div/following-sibling::div/div/h6[text()='Singles']")
	private WebElement lblSingles;

	@B2BFindBy(xpath = "(//h3[text()='Performance Analysis'])[1]")
	private WebElement lblPerformanceAnalysis;

	@B2BFindBy(xpath = "//h4[contains(@class, 'MuiTypography-root MuiTypography-h4') and text()='Match History']")
	private WebElement tabMatchHistory;

	@B2BFindBy(xpath = "//input[@id='Search']")
	private WebElement txtBoxSearch;

	public ValidateStatsChangeOnNewMatchPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public boolean isResultOverViewSectionContains() {
		log.info("Starting of isResultOverViewSectionContains method");

		boolean isResultOverViewSectionContains = false;

		if (isDisplayed(lblResultOverview) && isDisplayed(btnViewProfile) && isDisplayed(lblWinsCount)
				&& isDisplayed(lblPendingCount) && isDisplayed(lblLossesCount) && isDisplayed(lblTotalMatches)
				&& isDisplayed(chkWins) && isDisplayed(chkLosses) && isDisplayed(chkPending) && isDisplayed(iconInfo)) {
			isResultOverViewSectionContains = true;
		}

		log.info("Ending of isResultOverViewSectionOptionsDisplayed method");

		return isResultOverViewSectionContains;
	}

	public String getPendingCountLabelText() {
		log.info("Starting of getPendingCountLabelText method");
		log.info("Ending of getPendingCountLabelText method");

		return getText(lblPendingCount);
	}

	public String getWinsCountLabelText() {
		log.info("Starting of getWinsCountLabelText method");
		log.info("Ending of getWinsCountLabelText method");

		return getText(lblWinsCount);
	}

	public String getLossesCountLabelText() {
		log.info("Starting of getLossesCountLabelText method");
		log.info("Ending of getLossesCountLabelText method");

		return getText(lblLossesCount);
	}

	public String getTotalMatchesText() {
		log.info("Starting of getTotalMatchesText method");
		log.info("Ending of getTotalMatchesText method");

		return getText(lblTotalMatches);
	}

	public void clickOnWinsCheckBox() {
		log.info("Starting of getTotalMatchesText method");

		clickOnElement(chkWins);

		log.info("Ending of getTotalMatchesText method");
	}

	public void clickOnLossesCheckBox() {
		log.info("Starting of clickOnLossesCheckBox method");

		clickOnElement(chkLosses);

		log.info("Ending of clickOnLossesCheckBox method");
	}

	public void clickOnPendingCheckBox() {
		log.info("Starting of clickOnPendingCheckBox method");

		if (chkWins.isSelected()) {
			clickOnWebElement(chkWins);
		}
		if (chkWins.isSelected()) {
			clickOnWebElement(chkLosses);
		}
		clickOnElement(chkPending);

		log.info("Ending of clickOnPendingCheckBox method");
	}

	public void clickOnInfoIcon() {
		log.info("Starting of clickOnInfoIcon method");

		clickOnElement(iconInfo);

		log.info("Ending of clickOnInfoIcon method");
	}

	public boolean isResultOverViewPopupContains() {
		log.info("Starting of clickOnInfoIcon method");

		boolean options = false;
		if (isDisplayed(lblResultOverViewOnInfoPopup) && isDisplayed(btnOK) && isDisplayed(iconClose))
			options = true;

		log.info("Ending of clickOnInfoIcon method");
		return options;
	}

	public void clickOnOKButton() {
		log.info("Starting of clickOnOKButton method");

		clickOnElement(btnOK);

		log.info("Ending of clickOnOKButton method");
	}

	public void clickOnViewProfileButton() {
		log.info("Starting of clickOnViewProfileButton method");

		clickOnElement(btnViewProfile);

		log.info("Ending of clickOnViewProfileButton method");
	}

	public boolean isPlayerProfilePageContains() throws InterruptedException {
		log.info("Starting of isPlayerProfilePageContains method");
		
		
		driver.navigate().refresh();
		Thread.sleep(2000);

		boolean isPlayerProfilePageContains = false;

		if (isDisplayed(lblPlayerProfile) && isDisplayed(lblDoubles) && isDisplayed(lblSingles)
				&& isDisplayed(lblPerformanceAnalysis) && isDisplayed(tabMatchHistory))
			isPlayerProfilePageContains = true;

		log.info("Ending of isPlayerProfilePageContains method");

		return isPlayerProfilePageContains;
	}

	public void searchPlayerName(String name) {
		log.info("Starting of searchPlayerName method");

		this.clickOnWebElement(txtBoxSearch);
		this.sendKeys(txtBoxSearch, name);

		log.info("Ending of searchPlayerName method");
	}

}