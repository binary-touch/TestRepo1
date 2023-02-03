package com.dupr.pages.home;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class UserDashboardPage extends DUPRBaseAutomationPage {
	private static final Logger log = LogManager.getLogger(UserDashboardPage.class);

	@B2BFindBy(xpath = "//h6[contains(text(),'Home')]")
	private WebElement mnuHome;

	@B2BFindBy(xpath = "//h6[contains(text(),'Add a Match')]")
	private WebElement mnuAddMatch;

	@B2BFindBy(xpath = "//h6[contains(text(),'Players')]")
	private WebElement mnuPlayers;

	@B2BFindBy(xpath = "//h6[contains(text(),'Clubs')]")
	private WebElement mnuClubs;

	@B2BFindBy(xpath = "//h6[contains(text(),'Events')]")
	private WebElement mnuEvents;

	@B2BFindBy(xpath = "//h2[contains(@class,'MuiTypography-root MuiTypography-h2 MuiTypography-alignLeft')]")
	private WebElement txtUserName;

	@B2BFindBy(xpath = "//h6[contains(text(),'Doubles')]")
	private WebElement lblDoubles;

	@B2BFindBy(xpath = "//h6[contains(text(),'Doubles')]/parent::div/parent::div/h1")
	private WebElement lblDoublesValue;

	@B2BFindBy(xpath = "//h6[contains(text(),'Singles')]")
	private WebElement lblSingles;

	@B2BFindBy(xpath = "//h6[contains(text(),'Singles')]/parent::div/parent::div/h1")
	private WebElement lblSinglesValue;

	@B2BFindBy(xpath = "//button[contains(@class,'MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall')]")
	private WebElement iconShare;

	@B2BFindBy(xpath = "//button/following-sibling::button[contains(@class,'MuiIconButton-sizeMedium')]")
	private WebElement iconInstructions;

	@B2BFindBy(xpath = "//button[contains(text(),'Doubles')]")
	private WebElement tabDoubles;

	@B2BFindBy(xpath = "//button[contains(text(),'Singles')]")
	private WebElement tabSingles;

	@B2BFindBy(xpath = "//p[contains(text(),'Avg % Points Won')]")
	private WebElement lblAvgPoints;

	@B2BFindBy(xpath = "//p[contains(text(),'Avg % Points Won')]/preceding-sibling::h1")
	private WebElement lblAvgPointsValue;

	@B2BFindBy(xpath = "//p[contains(text(),'Half-Life')]")
	private WebElement lblHalfLife;

	@B2BFindBy(xpath = "//p[contains(text(),'Half-Life')]/preceding-sibling::h1")
	private WebElement lblHalfLifeValue;

	@B2BFindBy(xpath = "//p[contains(text(),'Avg Partner DUPR')]")
	private WebElement lblAvgPartner;

	@B2BFindBy(xpath = "//p[contains(text(),'Avg Partner DUPR')]/preceding-sibling::h1")
	private WebElement lblAvgPartnerValue;

	@B2BFindBy(xpath = "//p[contains(text(),'Avg Opponent DUPR')]")
	private WebElement lblAvgOpponent;

	@B2BFindBy(xpath = "//p[contains(text(),'Avg Opponent DUPR')]/preceding-sibling::h1")
	private WebElement lblAvgOpponentValue;

	@B2BFindBy(xpath = "//h3[contains(text(),'Result Overview')]")
	private WebElement lblResultOverview;

	@B2BFindBy(xpath = "//h3[contains(text(),'Result Overview')]//button")
	private WebElement iconResultsInstruction;

	@B2BFindBy(xpath = "//button[contains(text(),'View Profile')]")
	private WebElement btnViewProfile;

	@B2BFindBy(xpath = "//*[@class='slices']")
	private WebElement biChart;

	@B2BFindBy(xpath = "//*[contains(text(),'Total Matches')]")
	private WebElement lblTotalMatches;

	@B2BFindBy(xpath = "//*[contains(text(),'Total Matches')]/preceding-sibling::*")
	private WebElement lblTotalMatchesValue;

	@B2BFindBy(xpath = "//p[contains(text(),'Wins')]")
	private WebElement lblWins;

	@B2BFindBy(xpath = "//h5[contains(@class,'MuiTypography-root MuiTypography-h5')]")
	private WebElement lblWinsValue;

	@B2BFindBy(xpath = "//p[contains(text(),'Losses')]")
	private WebElement lblLosses;

	@B2BFindBy(xpath = "//h5[contains(@class,'MuiTypography-root MuiTypography-h5')]/parent::div/following-sibling::div")
	private WebElement lblLossesValue;

	@B2BFindBy(xpath = "//p[contains(text(),'Pending')]")
	private WebElement lblPending;

	@B2BFindBy(xpath = "//h5[contains(@class,'MuiTypography-root MuiTypography-h5')]/parent::div/following-sibling::div/following-sibling::div")
	private WebElement lblPendingValue;

	@B2BFindBy(xpath = "//h3[contains(text(),'Performance Analysis')]")
	private WebElement lblPerformance;

	@B2BFindBy(xpath = "(//h3[contains(text(),'Performance Analysis')]//button)[1]")
	private WebElement iconPerformanceInstruction;

	@B2BFindBy(xpath = "//div[@aria-label='Performance Analysis Type']/button")
	private WebElement tabPerformanceDoubles;

	@B2BFindBy(xpath = "//div[@aria-label='Performance Analysis Type']/button/following-sibling::button")
	private WebElement tabPerformanceSingles;

	@B2BFindBy(xpath = "//div[@aria-label=\"A chart.\"]")
	private WebElement chartPerformance;

	@B2BFindBy(xpath = "//*[text()='Favorite']")
	private WebElement lblFavorite;

	@B2BFindBy(xpath = "//*[text()='underdog']")
	private WebElement lblUnderdog;

	@B2BFindBy(xpath = "//h4[contains(text(),'Match History')]")
	private WebElement lblMatchHistory;

	@B2BFindBy(xpath = "//p[contains(text(),'View Recent Matches')]")
	private WebElement lblRecentMatches;

	@B2BFindBy(xpath = "//p[contains(text(),'View Recent Matches')]/parent::div/following-sibling::*")
	private WebElement iconForwardMatches;

	@B2BFindBy(xpath = "//p[contains(text(),'View Recent Matches')]/parent::div/preceding-sibling::*")
	private WebElement logoForwardMatches;

	@B2BFindBy(xpath = "//h4[contains(text(),'My Clubs')]")
	private WebElement lblMyClubs;

	@B2BFindBy(xpath = "//p[contains(text(),'Associated Clubs')]")
	private WebElement lblAssociatedClubs;

	@B2BFindBy(xpath = "//p[contains(text(),'Associated Clubs')]/parent::div/following-sibling::*")
	private WebElement iconForwardClubs;

	@B2BFindBy(xpath = "//p[contains(text(),'Associated Clubs')]/parent::div/preceding-sibling::*")
	private WebElement logoForwardClubs;

	@B2BFindBy(xpath = "//h4[contains(text(),'My Events')]")
	private WebElement lblMyEvents;

	@B2BFindBy(xpath = "//p[contains(text(),'Registered/ Invited Events')]")
	private WebElement lblRegisteredEvents;

	@B2BFindBy(xpath = "//p[contains(text(),'Registered/ Invited Events')]/parent::div/following-sibling::*")
	private WebElement iconForwardEvents;

	@B2BFindBy(xpath = "//p[contains(text(),'Registered/ Invited Events')]/parent::div/preceding-sibling::*")
	private WebElement logoForwardEvents;

	@B2BFindBy(xpath = "//h4[contains(text(),'My Brackets')]")
	private WebElement lblMyBrackets;

	@B2BFindBy(xpath = "//p[contains(text(),'Registered/ Invited Brackets')]")
	private WebElement lblRegisteredBrackets;

	@B2BFindBy(xpath = "//p[contains(text(),'Registered/ Invited Brackets')]/parent::div/following-sibling::*")
	private WebElement iconForwardBrackets;

	@B2BFindBy(xpath = "//p[contains(text(),'Registered/ Invited Brackets')]/parent::div/preceding-sibling::*")
	private WebElement logoForwardBrackets;

	@B2BFindBy(xpath = "//button[@aria-label='Open settings']")
	private WebElement btnSettings;

	@B2BFindBy(xpath = "//span[contains(@class,'MuiBadge-root MuiBadge-root')]/*")
	private WebElement btnMessage;
	// ------
	@B2BFindBy(xpath = "//img[contains(@class,'MuiBox-root')]")
	private WebElement btnDUPR;

	@B2BFindBy(xpath = "//a[contains(text(),'Search Players')]/preceding-sibling::a[contains(text(),'Dashboard')]")
	private WebElement mnuDashboard;

	@B2BFindBy(xpath = "//a[contains(text(),'Search Players')]")
	private WebElement mnuSearchPlayers;

	@B2BFindBy(xpath = "//*[contains(@class,'MuiSvgIcon-root MuiSvgIcon-colorPrimary MuiSvgIcon-fontSizeMedium')]")
	private WebElement btnBack;

	@B2BFindBy(xpath = "//h3[text()='Match History']/parent::div//button")
	private WebElement btnBackMatch;

	@B2BFindBy(xpath = "//h3[text()='Clubs']/parent::div//button")
	private WebElement btnBackclubs;

	@B2BFindBy(xpath = "//h3[text()='Events']/parent::div//button")
	private WebElement btnBackEvents;

	@B2BFindBy(xpath = "//h3[text()='Brackets']/parent::div//button")
	private WebElement btnBackBrackets;

	@B2BFindBy(xpath = "//a[text()='Rankings']")
	private WebElement mnuRanking;

	@B2BFindBy(xpath = "//a[text()='Chart']")
	private WebElement mnuChart;

	@B2BFindBy(xpath = "//a[text()='Shop']")
	private WebElement mnuShop;

	@B2BFindBy(xpath = "//a[text()='Shop']/following-sibling::a[text()='How it Works']")
	private WebElement mnuHowItWorks;

	@B2BFindBy(xpath = "//a[text()='Shop']/following-sibling::a[text()='Run Events']")
	private WebElement txtRunEvents;

	@B2BFindBy(xpath = "//a[text()='Shop']/following-sibling::a[text()='News']")
	private WebElement lblNews;

	@B2BFindBy(xpath = "//a[text()='Shop']/following-sibling::a[text()='News']/following-sibling::div//button")
	private WebElement btnSettingsHome;

	@B2BFindBy(xpath = "//p[text()='Pickleball’s Most Accurate Global Rating System']")
	private WebElement lblPickleBall;

	@B2BFindBy(xpath = "//p[text()='Free for all Players']")
	private WebElement lblFreePlayer;

	@B2BFindBy(xpath = "//p[text()='Trusted by the world’s premier Pickleball clubs, professional tours, and recreational players alike.']")
	private WebElement lblTrustedTxt;

	@B2BFindBy(xpath = "//img[@alt='search dupr players']")
	private WebElement btnSearch;

	@B2BFindBy(xpath = "//img[@alt='search dupr players']/parent::a/following-sibling::div//img[@alt='DUPR iOS App']")
	private WebElement btnAppStore;

	@B2BFindBy(xpath = "//img[@alt='search dupr players']/parent::a/following-sibling::div//img[@alt='DUPR Android App']")
	private WebElement btnGooglePlay;

	@B2BFindBy(xpath = "//img[@alt='Pro Pickleball Association']")
	private WebElement imgPickleball;

	@B2BFindBy(xpath = "//img[@alt='Oofos']")
	private WebElement imgOofos;

	@B2BFindBy(xpath = "//img[@alt='Pickles']")
	private WebElement imgPickles;

	@B2BFindBy(xpath = "//img[@alt='Legacy_Pickleball']")
	private WebElement imgLegacy;

	@B2BFindBy(xpath = "//img[@alt='Major League Pickleball']")
	private WebElement imgMajor;

	@B2BFindBy(xpath = "//img[@alt='NYC_Pickleball']")
	private WebElement imgNyc;

	@B2BFindBy(xpath = "//img[@alt='Cirkul']")
	private WebElement imgCirkul;

	@B2BFindBy(xpath = "//img[@alt='michelob ULTRA']")
	private WebElement imgMichelob;

	@B2BFindBy(xpath = "//img[@alt='The Picklr']")
	private WebElement imgPicklr;

	@B2BFindBy(xpath = "//img[@alt='Missouri Pickleball Club']")
	private WebElement imgMissouri;

	@B2BFindBy(xpath = "//img[@alt='Gamma Pickleball']")
	private WebElement imgGamma;

	@B2BFindBy(xpath = "//p[text()='Contact']/parent::div/descendant::img")
	private WebElement logoDUPR;

	@B2BFindBy(xpath = "//p[text()='Contact']")
	private WebElement btnContact;

	@B2BFindBy(xpath = "//a[text()='support@mydupr.com']")
	private WebElement btnSupport;

	@B2BFindBy(xpath = "//a[text()='TEXT:']")
	private WebElement lblText;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiBox-root css-nr6f5k')]//a[text()='Search Players']")
	private WebElement btnSearchPlayers;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiBox-root css-nr6f5k')]//a[text()='Run Events']")
	private WebElement btnRunEvents;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiBox-root css-nr6f5k')]//a[text()='How it Works']")
	private WebElement btnHowItWorks;

	@B2BFindBy(xpath = "//a[text()='Logo Kit']")
	private WebElement btnLogoKit;

	@B2BFindBy(xpath = "//a[text()='Terms & conditions']")
	private WebElement btnTerms;

	@B2BFindBy(xpath = "//a[text()='Privacy Policy']")
	private WebElement btnPrivacy;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-3')]//img[@alt='DUPR iOS App']")
	private WebElement btnAppStoreFooter;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-3')]//img[@alt='DUPR Android App']")
	private WebElement btnGooglePlayFooter;

	@B2BFindBy(xpath = "//img[@alt='DUPR Facebook Page']")
	private WebElement iconFacebook;

	@B2BFindBy(xpath = "//img[@alt='DUPR Instagram Page']")
	private WebElement iconInstagram;

	@B2BFindBy(xpath = "//img[@alt='DUPR LinkedIn Page']")
	private WebElement iconLinkedIn;

	@B2BFindBy(xpath = "//img[@alt='DUPR Twitter Page']")
	private WebElement iconTwitter;

	@B2BFindBy(xpath = "//img[@alt='DUPR YouTube Page']")
	private WebElement iconYouTube;
	// -----

	@B2BFindBy(xpath = "//button[text()='OK']")
	private WebElement btnOk;

	@B2BFindBy(xpath = "//h4[@id='customized-dialog-title']")
	private WebElement lblTitle;

	@B2BFindBy(xpath = "//button[@aria-label='close']")
	private WebElement iconClose;

	@B2BFindBy(xpath = "//p[contains(text(),'An asterisk(*) means that you have a provisional r')]")
	private WebElement txtUserDescription;

	@B2BFindBy(xpath = "//p[contains(text(),'This section displays metrics about your performan')]")
	private WebElement txtResultsDescription;

	@B2BFindBy(xpath = "//h4[@id='customized-dialog-title']/following-sibling::div//div//*")
	private WebElement logoInstruction;

	@B2BFindBy(xpath = "//h4[text()='Some matches may be excluded.']")
	private WebElement txtPerformance;

	@B2BFindBy(xpath = "//h4[text()='My Brackets']")
	private WebElement btnMyBrackets;

	@B2BFindBy(xpath = "//h3[text()='Brackets']")
	private WebElement txtBrackets;

	@B2BFindBy(xpath = "//h5[text()='My Brackets']")
	private WebElement txtMyBrackets;

	@B2BFindBy(xpath = "//button[text()='Browse all Events']")
	private WebElement btnBrowseEvents;

	public UserDashboardPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public boolean isSearchPlayersMenuDisplayed() {
		log.info("Starting of isSearchPlayersMenuDisplayed method");
		log.info("Ending of isSearchPlayersMenuDisplayed method");

		return isDisplayed(mnuSearchPlayers);
	}

	public String getBracketsTitle() {
		log.info("Starting of getBracketsTitle method");
		log.info("Ending of getBracketsTitle method");

		return getText(txtBrackets);
	}

	public boolean isMyBracketsPageContains() {
		log.info("Starting of isMyBracketsPageContains method");

		boolean isMyBracketsPageContains = false;

		if (isDisplayed(txtBrackets) && isDisplayed(btnBackBrackets) && isDisplayed(txtMyBrackets)

				&& isDisplayed(btnBrowseEvents)) {

			isMyBracketsPageContains = true;
		}

		log.info("Ending of isDashboardPageContains method");

		return isMyBracketsPageContains;
	}

	public boolean isDashboardPageContains() {
		log.info("Starting of isDashboardPageContains method");

		boolean isDashboardPageContains = false;

		if (isDisplayed(btnDUPR) && isDisplayed(mnuHome) && isDisplayed(mnuAddMatch)

				&& isDisplayed(mnuPlayers) && isDisplayed(mnuClubs) && isDisplayed(mnuEvents)) {

			isDashboardPageContains = true;
		}

		log.info("Ending of isDashboardPageContains method");

		return isDashboardPageContains;
	}

	public boolean isDashboardUserNameSecContains() {
		log.info("Starting of isDashboardUserNameSecContains method");

		boolean isDashboardUserNameSecContains = false;

		if (isDisplayed(txtUserName) && isDisplayed(lblDoubles) && isDisplayed(lblDoublesValue)
				&& isDisplayed(lblSingles) && isDisplayed(lblSinglesValue) && isDisplayed(iconShare)
				&& isDisplayed(iconInstructions) && isDisplayed(btnSettings)) {
			isDashboardUserNameSecContains = true;
		}

		log.info("Ending of isDashboardUserNameSecContains method");

		return isDashboardUserNameSecContains;
	}

	public boolean isDashboardDoublesSinglesSecContains() {
		log.info("Starting of isDashboardDoublesSinglesSecContains method");

		boolean isDashboardDoublesSinglesSecContains = false;

		if (isDisplayed(tabDoubles) && isDisplayed(tabSingles) && isDisplayed(lblAvgPoints)
				&& isDisplayed(lblAvgPointsValue) && isDisplayed(lblHalfLife) && isDisplayed(lblHalfLifeValue)
				&& isDisplayed(lblAvgPartner) && isDisplayed(lblAvgPartnerValue) && isDisplayed(lblAvgOpponent)
				&& isDisplayed(lblAvgOpponentValue)) {
			isDashboardDoublesSinglesSecContains = true;
		}
		log.info("Ending of isDashboardDoublesSinglesSecContains method");

		return isDashboardDoublesSinglesSecContains;
	}

	public boolean isDashboardResultSecContains() {
		log.info("Starting of isDashboardResultSecContains method");

		boolean isDashboardResultSecContains = false;

		if (isDisplayed(lblResultOverview) && isDisplayed(iconResultsInstruction) && isDisplayed(btnViewProfile)
				&& isDisplayed(biChart) && isDisplayed(lblTotalMatches) && isDisplayed(lblTotalMatchesValue)
				&& isDisplayed(lblWins) && isDisplayed(lblWinsValue)

				&& isDisplayed(lblLosses) && isDisplayed(lblLossesValue) && isDisplayed(lblPending)
				&& isDisplayed(lblPendingValue)) {
			isDashboardResultSecContains = true;
		}

		log.info("Ending of isDashboardResultSecContains method");

		return isDashboardResultSecContains;
	}

	public boolean isDashboardPerformanceSecContains() {
		log.info("Starting of isDashboardPerformanceSecContains method");

		boolean isDashboardPerformanceSecContains = false;

		if (isDisplayed(lblPerformance) && isDisplayed(iconPerformanceInstruction) && isDisplayed(tabPerformanceDoubles)
				&& isDisplayed(tabPerformanceSingles) && isDisplayed(chartPerformance) && isDisplayed(lblFavorite)
				&& isDisplayed(lblUnderdog)) {
			isDashboardPerformanceSecContains = true;
		}
		log.info("Ending of isDashboardPerformanceSecContains method");

		return isDashboardPerformanceSecContains;
	}

	public boolean isDashboardMatchesSecContains() {
		log.info("Starting of isDashboardMatchesSecContains method");

		boolean isDashboardMatchesSecContains = false;

		if (isDisplayed(lblMatchHistory) && isDisplayed(lblRecentMatches) && isDisplayed(iconForwardMatches)
				&& isDisplayed(logoForwardMatches)) {
			isDashboardMatchesSecContains = true;
		}

		log.info("Ending of isDashboardMatchesSecContains method");

		return isDashboardMatchesSecContains;
	}

	public boolean isDashboardClubsSecContains() {
		log.info("Starting of isDashboardClubsSecContains method");

		boolean isDashboardClubsSecContains = false;

		if (isDisplayed(lblMyClubs) && isDisplayed(lblAssociatedClubs) && isDisplayed(iconForwardClubs)
				&& isDisplayed(logoForwardClubs)) {
			isDashboardClubsSecContains = true;
		}

		log.info("Ending of isDashboardClubsSecContains method");

		return isDashboardClubsSecContains;
	}

	public boolean isDashboardEventsSecContains() {
		log.info("Starting of isDashboardEventsSecContains method");

		boolean isDashboardEventsSecContains = false;

		if (isDisplayed(lblMyEvents) && isDisplayed(lblRegisteredBrackets) && isDisplayed(iconForwardEvents)
				&& isDisplayed(logoForwardEvents)) {
			isDashboardEventsSecContains = true;
		}

		log.info("Ending of isDashboardEventsSecContains method");

		return isDashboardEventsSecContains;
	}

	public boolean isDashboardBracketsSecContains() {
		log.info("Starting of isDashboardBracketsSecContains method");

		boolean isDashboardBracketsSecContains = false;

		if (isDisplayed(lblMyBrackets) && isDisplayed(lblRegisteredBrackets) && isDisplayed(iconForwardBrackets)
				&& isDisplayed(logoForwardBrackets) && isDisplayed(btnMessage)) {
			isDashboardBracketsSecContains = true;
		}

		log.info("Ending of isDashboardBracketsSecContains method");

		return isDashboardBracketsSecContains;
	}

	public void clickOnDUPRLogoLink() {
		log.info("Starting of clickOnDUPRLogoLink method");

		clickOnWebElement(btnDUPR);
		this.hardWait(3);

		log.info("Ending of clickOnDUPRLogoLink method");
	}

	public void clickOnMyBracketsButton() {
		log.info("Starting of clickOnMyBracketsButton method");

		clickOnWebElement(btnMyBrackets);
		this.hardWait(3);

		log.info("Ending of clickOnMyBracketsButton method");
	}

	public boolean isHomePageMenuSecContains() {
		log.info("Starting of isHomePageMenuSecContains method");

		boolean isHomePageMenuSecContains = false;

		if (isDisplayed(mnuDashboard) && isDisplayed(mnuSearchPlayers) && isDisplayed(mnuRanking)
				&& isDisplayed(mnuChart) && isDisplayed(mnuShop) && isDisplayed(mnuHowItWorks)
				&& isDisplayed(txtRunEvents) && isDisplayed(lblNews) && isDisplayed(btnSettingsHome)) {

			isHomePageMenuSecContains = true;
		}

		log.info("Ending of isHomePageMenuSecContains method");

		return isHomePageMenuSecContains;
	}

	public boolean isHomePageTextContains() {
		log.info("Starting of isHomePageTextContains method");

		boolean isHomePageTextContains = false;

		if (isDisplayed(lblPickleBall) && isDisplayed(lblFreePlayer) && isDisplayed(lblTrustedTxt)
				&& isDisplayed(btnSearch) && isDisplayed(btnAppStore) && isDisplayed(btnGooglePlay)) {

			isHomePageTextContains = true;
		}

		log.info("Ending of isHomePageTextContains method");

		return isHomePageTextContains;
	}

	public boolean isHomePagesponsorlogosContains() {
		log.info("Starting of isHomePagesponsorlogosContains method");

		boolean isHomePagesponsorlogosContains = false;

		if (isDisplayed(imgPickleball) && isDisplayed(imgOofos) && isDisplayed(imgPickles) && isDisplayed(imgLegacy)
				&& isDisplayed(imgMajor) && isDisplayed(imgNyc) && isDisplayed(imgCirkul) && isDisplayed(imgMichelob)
				&& isDisplayed(imgPicklr) && isDisplayed(imgMissouri) && isDisplayed(imgGamma)) {

			isHomePagesponsorlogosContains = true;
		}

		log.info("Ending of isHomePagesponsorlogosContains method");

		return isHomePagesponsorlogosContains;
	}

	public boolean isHomePageFooterSecContains() {
		log.info("Starting of isHomePageFooterSecContains method");

		boolean isHomePageFooterSecContains = false;

		if (isDisplayed(logoDUPR) && isDisplayed(btnContact) && isDisplayed(btnSupport) && isDisplayed(lblText)
				&& isDisplayed(btnSearchPlayers) && isDisplayed(btnRunEvents) && isDisplayed(btnHowItWorks)
				&& isDisplayed(btnLogoKit) && isDisplayed(btnTerms) && isDisplayed(btnPrivacy)
				&& isDisplayed(btnAppStoreFooter) && isDisplayed(btnGooglePlayFooter) && isDisplayed(iconFacebook)
				&& isDisplayed(iconInstagram) && isDisplayed(iconLinkedIn) && isDisplayed(iconTwitter)
				&& isDisplayed(iconYouTube)) {

			isHomePageFooterSecContains = true;
		}

		log.info("Ending of isHomePageFooterSecContains method");

		return isHomePageFooterSecContains;
	}

	public void clickOnDashboardMenu() {
		log.info("Starting of clickOnDashboardMenu method");

		clickOnWebElement(mnuDashboard);
		this.hardWait(3);

		log.info("Ending of clickOnDashboardMenu method");
	}

	public void clickOnEventsMenu() {
		log.info("Starting of clickOnEventsMenu method");

		clickOnWebElement(mnuEvents);
		this.hardWait(3);

		log.info("Ending of clickOnEventsMenu method");
	}

	public void clickOnBackButton() {
		log.info("Starting of clickOnBackButton method");

		clickOnWebElement(btnBack);
		this.hardWait(3);

		log.info("Ending of clickOnBackButton method");
	}

	public void clickOnBackButtonOnMatch() {
		log.info("Starting of clickOnBackButtonOnMatch method");

		clickOnWebElement(btnBackMatch);
		this.hardWait(3);

		log.info("Ending of clickOnBackButtonOnMatch method");
	}

	public void clickOnBackButtonOnClubs() {
		log.info("Starting of clickOnBackButtonOnClubs method");

		clickOnWebElement(btnBackclubs);
		this.hardWait(3);

		log.info("Ending of clickOnBackButtonOnClubs method");
	}

	public void clickOnBackButtonOnEvents() {
		log.info("Starting of clickOnBackButtonOnEvents method");

		clickOnWebElement(btnBackEvents);
		this.hardWait(3);

		log.info("Ending of clickOnBackButtonOnEvents method");
	}

	public void clickOnBackButtonOnBrackets() {
		log.info("Starting of clickOnBackButtonOnBrackets method");

		clickOnWebElement(btnBackBrackets);
		this.hardWait(3);

		log.info("Ending of clickOnBackButtonOnBrackets method");
	}

	public boolean isUserInstructionPopUpContains() {
		log.info("Starting of isUserInstructionPopUpContains method");

		boolean isUserInstructionPopUpContains = false;
		try {
			if (isDisplayed(iconClose) && isDisplayed(lblTitle) && isDisplayed(btnOk)
					&& isDisplayed(txtUserDescription)) {

				isUserInstructionPopUpContains = true;
			}
		} catch (Exception e) {
			isUserInstructionPopUpContains = false;
		}

		log.info("Ending of isUserInstructionPopUpContains method");

		return isUserInstructionPopUpContains;
	}

	public boolean isResultsInstructionPopUpContains() {
		log.info("Starting of isResultsInstructionPopUpContains method");

		boolean isResultsInstructionPopUpContains = false;
		try {
			if (isDisplayed(iconClose) && isDisplayed(lblTitle) && isDisplayed(btnOk)
					&& isDisplayed(txtResultsDescription)) {

				isResultsInstructionPopUpContains = true;
			}
		} catch (Exception e) {
			isResultsInstructionPopUpContains = false;
		}

		log.info("Ending of isResultsInstructionPopUpContains method");

		return isResultsInstructionPopUpContains;
	}

	public boolean isPerformanceInstructionPopUpContains() {
		log.info("Starting of isPerformanceInstructionPopUpContains method");

		boolean isPerformanceInstructionPopUpContains = false;
		try {
			if (isDisplayed(iconClose) && isDisplayed(lblTitle) && isDisplayed(btnOk) && isDisplayed(logoInstruction)
					&& isDisplayed(txtPerformance)) {

				isPerformanceInstructionPopUpContains = true;
			}
		} catch (Exception e) {
			isPerformanceInstructionPopUpContains = false;
		}

		log.info("Ending of isPerformanceInstructionPopUpContains method");

		return isPerformanceInstructionPopUpContains;
	}

	public void clickOnCloseIcon() {
		log.info("Starting of clickOnCloseIcon method");

		clickOnWebElement(iconClose);

		log.info("Ending of clickOnCloseIcon method");
	}

	public void clickOnOkButton() {
		log.info("Starting of clickOnOkButton method");
		this.hardWait(2);
		clickOnWebElement(btnOk);

		log.info("Ending of clickOnOkButton method");
	}

	public String getInstructionPopUpTitle() {
		log.info("Starting of getInstructionPopUpTitle method");
		log.info("Ending of getInstructionPopUpTitle method");

		return getText(lblTitle);
	}

	public void clickOnUserInstructionIcon() {
		log.info("Starting of clickOnUserInstructionIcon method");

		try {
			clickOnWebElement(iconInstructions);
		} catch (Exception e) {
			Actions action = new Actions(driver);
			action.moveToElement(iconInstructions).click().build().perform();
		}

		log.info("Ending of clickOnUserInstructionIcon method");
	}

	public String getUserInstructionDecription() {
		log.info("Starting of getUserInstructionDecription method");
		log.info("Ending of getUserInstructionDecription method");

		return getText(txtUserDescription);
	}

	public void clickOnResultsInstructionIcon() {
		log.info("Starting of clickOnResultsInstructionIcon method");

		try {
			clickOnWebElement(iconResultsInstruction);
		} catch (Exception e) {
			Actions action = new Actions(driver);
			action.moveToElement(iconResultsInstruction).click().build().perform();
		}

		log.info("Ending of clickOnResultsInstructionIcon method");
	}
	
	public void clickOnSearchPlayers() {
		log.info("Starting of clickOnSearchPlayers method");

		clickOnWebElement(mnuSearchPlayers);
		this.hardWait(3);

		log.info("Ending of clickOnSearchPlayers method");
	}

	public String getResultsInstructionDecription() {
		log.info("Starting of getResultsInstructionDecription method");
		log.info("Ending of getResultsInstructionDecription method");

		return getText(txtResultsDescription);
	}

	public void clickOnPerformanceInstructionIcon() {
		log.info("Starting of clickOnPerformanceInstructionIcon method");
		this.scrollDown(150);

		try {
			clickOnWebElement(iconPerformanceInstruction);
		} catch (Exception e) {
			Actions action = new Actions(driver);
			action.moveToElement(iconPerformanceInstruction).click().build().perform();
		}

		log.info("Ending of clickOnPerformanceInstructionIcon method");
	}

	public String getPerformanceInstructionDecription() {
		log.info("Starting of getUserInstructionDecription method");
		log.info("Ending of getUserInstructionDecription method");

		return getText(txtPerformance);
	}
	
	public void clickOnShareButton() {
		log.info("Starting of clickOnSettings method");

		this.hardWait(3);
		clickOnWebElement(iconShare);
		this.hardWait(2);

		log.info("Ending of clickOnSettings method");
	}

	public void clickOnMessageIcon() {
		log.info("Starting of clickOnMessageIcon method");
		
		this.hardWait(3);

		try {
			btnMessage.click();
			this.hardWait(3);
			
		} catch (Exception e) {
			
			elementClick(btnMessage);
		}
		log.info("Ending of clickOnMessageIcon method");
	}
	
	public void clickOnSettings() {
		log.info("Starting of clickOnSettings method");

		clickOnWebElement(btnSettings);

		log.info("Ending of clickOnSettings method");
	}
}
