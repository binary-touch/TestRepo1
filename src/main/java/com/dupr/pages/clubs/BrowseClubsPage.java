package com.dupr.pages.clubs;

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

public class BrowseClubsPage extends DUPRBaseAutomationPage {

	private static final Logger log = LogManager.getLogger(BrowseClubsPage.class);
	public static String name = null;
	
	public static int countAfterSearchingClub;
	
	@B2BFindBy(xpath = "//h6[text()='Clubs']")
	private WebElement tabClubs;

	@B2BFindBy(xpath = "//h3[text()='Browse Clubs']")
	private WebElement lblBrowseClubs;

	@B2BFindBy(xpath = "//input[@id='Search']")
	private WebElement txtBoxSearch;

	@B2BFindBys(@B2BFindBy(xpath = "//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation3 css-zvos3g']"))
	private List<WebElement> lstClubs;

	@B2BFindBys(@B2BFindBy(xpath = "//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation3 css-zvos3g']//h4"))
	private List<WebElement> lstClubNames;

	@B2BFindBy(xpath = "//b[text()='No more results.']")
	private WebElement txtNoMoreResults;

	@B2BFindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-u7hjsa']")
	private WebElement iconBackArrow;

	@B2BFindBy(xpath = "//h3[text()='Club']")
	private WebElement lblClub;

	@B2BFindBy(xpath = "//div[@class='MuiBox-root css-1821gv5']/h3/div")
	private WebElement txtClubName;

	@B2BFindBy(xpath = "//div[@class='MuiBox-root css-1821gv5']/h6/following-sibling::h6/preceding-sibling::h6")
	private WebElement txtClubAddress;

	@B2BFindBy(xpath = "//div[@class='MuiBox-root css-1821gv5']/h6/following-sibling::h6")
	private WebElement txtNumberOfClubMembers;

	@B2BFindBy(xpath = "//button[text()='Join Club']")
	private WebElement btnJoinClub;

	@B2BFindBy(xpath = "//button[text()='Share']")
	private WebElement btnShare;

	@B2BFindBy(xpath = "//button[text()='See Club Details']")
	private WebElement btnSeeClubDetails;

	@B2BFindBy(xpath = "//button[text()='Members']")
	private WebElement tabMembers;

	@B2BFindBy(xpath = "//button[text()='Matches']")
	private WebElement tabMatches;

	@B2BFindBy(xpath = "//button[text()='Events']")
	private WebElement tabEvents;

	@B2BFindBy(xpath = "//h3[text()='Contact']")
	private WebElement lblContact;

	@B2BFindBy(xpath = "//h3[text()='Club Organizers']")
	private WebElement lblCluborganizers;

	@B2BFindBy(xpath = "//button[text()='Show Less']")
	private WebElement btnShowLess;

	public BrowseClubsPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public void clickOnBrowseClubsTab() {
		log.info("Starting of clickOnBrowseClubsTab method");

		tabClubs.click();

		log.info("Ending of clickOnBrowseClubsTab method");
	}

	public boolean isBrowseClubsPageContains() {
		log.info("Starting of isBrowseClubsPageContains method");

		boolean isBrowseClubsPageContains = false;
		if (isDisplayed(lblBrowseClubs) && isDisplayed(txtBoxSearch)) {

			isBrowseClubsPageContains = true;

		}

		log.info("Ending of isBrowseClubsPageContains method");

		return isBrowseClubsPageContains;
	}

	public boolean isClubsAvailable() {
		log.info("Starting of clickOnClub method");

		boolean isClubsAvailable = false;

		for (WebElement club : lstClubs) {

			if (club.isDisplayed()) {

				isClubsAvailable = true;
			}

		}
		log.info("Ending of clickOnClub method");

		return isClubsAvailable;
	}

	public void setSearchByClubName() {
		log.info("Starting of setSearchByClubName method");

		this.txtBoxSearch.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
		for (WebElement clubName : lstClubNames) {
			
			name = getText(clubName);

			sendKeys(txtBoxSearch, name);
			hardWait(3);
			countAfterSearchingClub=lstClubNames.size();
			break;

		}

		log.info("Ending of setSearchByClubName method");
	}

	public String isClubNameDisplayed() {
		log.info("Starting of isClubNameDisplayed method");

		String searchedClub = null;
		for (WebElement clubName : lstClubNames) {

			searchedClub = clubName.getText();
			break;

		}

		log.info("Ending of isClubNameDisplayed method");

		return searchedClub;
	}

	public void setSearchByClubNameWithClubName(String clubName) {
		log.info("Starting of setSearchByClubNameWithClubName method");

		// txtBoxSearch.clear();
		this.txtBoxSearch.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
		sendKeys(txtBoxSearch, clubName);

		log.info("Ending of setSearchByClubNameWithClubName method");
	}

	public String getNoMoreResultsText() {
		log.info("Starting of getNoMoreResultsText method");
		log.info("Ending of getNoMoreResultsText method");

		return getText(txtNoMoreResults);
	}

	public void clickOnClubTab() {
		log.info("Starting of clickOnClubTab method");

		for (WebElement clubName : lstClubNames) {

			/*
			 * name = getText(clubName); this.txtBoxSearch.sendKeys(Keys.CONTROL + "A",
			 * Keys.BACK_SPACE); sendKeys(txtBoxSearch, name);
			 */
			
			clickOnWebElement(clubName);
			break;

		}

		log.info("Ending of clickOnClubTab method");
	}

	public boolean isClubPageContains() {
		log.info("Starting of isClubPageContains method");

		boolean isClubPageContains = false;
		if (isDisplayed(iconBackArrow) && isDisplayed(lblClub) && isDisplayed(txtClubAddress)
				&& isDisplayed(txtNumberOfClubMembers) && isDisplayed(btnSeeClubDetails) && isDisplayed(tabMembers)
				&& isDisplayed(tabMatches) && isDisplayed(tabEvents)) {
			isClubPageContains = true;
		}

		log.info("Ending of isClubPageContains method");

		return isClubPageContains;
	}
	
	public void clickOnBackArrowicon() {
		log.info("Starting of clickOnBackArrowicon method");

		clickOnWebElement(iconBackArrow);

		log.info("Ending of clickOnBackArrowicon method");
	}
	
	public String getSearchedClubName() {
		log.info("Starting of getSearchedClubName method");
		log.info("Ending of getSearchedClubName method");
		
		return txtBoxSearch.getAttribute("value");
	}
	
	
	public int getClubCountAfterClickOnBackArrowiconOnClubPage() {
		log.info("Starting of getClubCountAfterClickOnBackArrowiconOnClubPage method");
		
		int clubCountOnBrowseClubsPage=lstClubNames.size();
		
		log.info("Ending of getClubCountAfterClickOnBackArrowiconOnClubPage method");
		
		return clubCountOnBrowseClubsPage;
	}
	
	
}
