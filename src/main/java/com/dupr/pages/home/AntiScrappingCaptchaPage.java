package com.dupr.pages.home;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BFindBys;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class AntiScrappingCaptchaPage extends DUPRBaseAutomationPage {

	private static final Logger log = LogManager.getLogger(AntiScrappingCaptchaPage.class);

	@B2BFindBy(xpath = "//div[@id='recaptcha-accessible-status']/parent::div[contains(@class, 'rc-anchor rc-anchor-invisible rc-anchor-light')]")
	private WebElement logoCaptcha;

	@B2BFindBy(xpath = "//iframe[@title='reCAPTCHA']")
	private WebElement iframe;

	@B2BFindBy(xpath = "//h6[text()='Clubs']/parent::div")
	private WebElement mnuClubs;

	@B2BFindBy(xpath = "//h6[text()='Players']/parent::div")
	private WebElement mnuPlayers;

	@B2BFindBy(xpath = "(//h4[contains(@class,'MuiTypography-root MuiTypography-h4 MuiTypography-noWrap')])")
	private List<WebElement> lblBrackets;

	@B2BFindBy(xpath = "//*[contains(@class,'MuiSvgIcon-root MuiSvgIcon-colorPrimary MuiSvgIcon-fontSizeMedium')]")
	private WebElement btnBack;

	@B2BFindBy(xpath = "//button[@id='composition-button']")
	private WebElement btnkebabBracket;

	@B2BFindBy(xpath = "//span[text()='Edit Partner']")
	private WebElement lstEditPartner;

	@B2BFindBy(xpath = "//button[text()='Add Partner']")
	private WebElement btnAddPartner;

	@B2BFindBy(xpath = "//span[text()='Add Partner']")
	private WebElement btnAddPartnerInKebabMenu;

	@B2BFindBy(xpath = "//div[text()='Add a Partner']/parent::div//following-sibling::div//div[contains(@class,'MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0')]//div[contains(@class,'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-6')]//h4[contains(@class,'MuiTypography-root MuiTypography-h4')]")
	private WebElement rdoPartner;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiToolbar-gutters MuiToolbar-regular')]//button[text()='Add Partner']")
	private WebElement btnAddAPartner;

	@B2BFindBy(xpath = "//h4[text()='My Brackets']")
	private WebElement btnMyBrackets;

	@B2BFindBy(xpath = "//span[text()='Remove Partner']")
	private WebElement btnRemovePartner;

	@B2BFindBy(xpath = "//span[text()='Edit Partner']")
	private WebElement btnEditPartner;

	@B2BFindBys(@B2BFindBy(xpath = "//h4[contains(@class,'MuiTypography-root MuiTypography-h4 MuiTypography-noWrap')]"))
	private List<WebElement> lnkBracketNames;

	@B2BFindBy(xpath = "//button[text()='Cancel']")
	private WebElement btnBracketcancel;

	@B2BFindBy(xpath = "//h6[text()='Home']")
	private WebElement mnuHome;

	@B2BFindBy(xpath = "//button[text()='Add Participants']")
	private WebElement btnAddParticipants;

	@B2BFindBy(xpath = "//button[text()='Go Back']")
	private WebElement btnGoBack;

	@B2BFindBy(xpath = "//h6[text()='Add a Match']")
	private WebElement mnuAddAMatch;

	@B2BFindBy(xpath = "//button[text()='Add Your Partner']")
	private WebElement btnAddYourPartner;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiToolbar-gutters MuiToolbar-regular')]//button[text()='Cancel']")
	private WebElement btnCancel;

	@B2BFindBy(xpath = "//button[text()='Add Your Opponent']")
	private WebElement btnAddYourOpponent;

	@B2BFindBy(xpath = "//button[contains(text(),'Add Players')]")
	private WebElement drpAddPlayers;

	@B2BFindBy(xpath = "//li[text()='Add a single DUPR user']")
	private WebElement btnAddSingleDURPUser;

	@B2BFindBy(xpath = "//button[text()='Cancel']")
	private WebElement btnCancelInClubMemberPage;

	@B2BFindBy(xpath = "//button[contains(text(),'Add a Match')]")
	private WebElement btnAddAMatch;

	@B2BFindBy(xpath = "//button[text()='Browse Clubs']")
	private WebElement btnBrowseClubs;

	@B2BFindBy(xpath = "//button[text()='Add First Player']")
	private WebElement btnAddFirstPlayer;

	@B2BFindBy(xpath = "//button[text()='Cancel']")
	private WebElement btnPlayersCancel;

	@B2BFindBy(xpath = "//button[@aria-label='Open settings']")
	private WebElement mnuOpenSettings;

	@B2BFindBy(xpath = "//div[text()='Logout']")
	private WebElement btnLogOut;

	@B2BFindBy(xpath = "//p[text()='Sign up']")
	private WebElement btnSignUP;

	@B2BFindBy(xpath = " //button[text()='Teams']")
	private WebElement tabTeams;

	@B2BFindBys({ @B2BFindBy(xpath = " //button[text()='Edit Team']") })
	private List<WebElement> lstEditTeam;

	@B2BFindBy(xpath = "(//button[@aria-label='remove player'])[1]")
	private WebElement iconRemovePlayer;

	@B2BFindBy(xpath = "//button[contains(text(),'Add a Player')]")
	private WebElement btnAddPlayer;

	@B2BFindBys({ @B2BFindBy(xpath = "//div[contains(@class,'infinite-scroll-component__outerdiv')]//h4") })
	private List<WebElement> txtPlayerName;

	public AntiScrappingCaptchaPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public boolean isAntiScrappingCaptchaDisplayed() {
		log.info("Starting of isAntiScrappingCaptchaDisplayed method");
		boolean isAntiScrappingCaptchaDisplayed = false;

		driver.switchTo().frame(iframe);
		if (isDisplayed(logoCaptcha) == true) {
			isAntiScrappingCaptchaDisplayed = true;
		}
		log.info("Ending of isAntiScrappingCaptchaDisplayed method");

		return isAntiScrappingCaptchaDisplayed;
	}

	public void goTodefaultContent() {
		log.info("Starting of goTodefaultContent method");

		driver.switchTo().defaultContent();

		log.info("Ending of goTodefaultContent method");

	}

	public void clickOnClubsMenu() {
		log.info("Starting of clickOnClubsMenu Method");

		elementClick(mnuClubs);

		log.info("Ending of clickOnClubsMenu Method");
	}

	public void clickOnPlayersMenu() {
		log.info("Starting of clickOnPlayersMenu Method");

		elementClick(mnuPlayers);

		log.info("Ending of clickOnPlayersMenu Method");
	}

	public void clickOnBracketLabel() {
		log.info("Starting of clickOnBracketLabel method");

		for (int i = 1; i < lblBrackets.size(); i++) {
			this.hardWait(2);
			driver.findElement(
					By.xpath((("(//h4[contains(@class,'MuiTypography-root MuiTypography-h4 MuiTypography-noWrap')])["
							+ i + "]"))))
					.click();

			this.hardWait(3);
			try {
				if ((isDisplayed(btnAddPartner) == true)) {
					clickOnWebElement(btnAddPartner);
					break;
				}

			} catch (Exception e) {

				try {
					if ((isDisplayed(btnRemovePartner) == true)) {
						clickOnWebElement(btnRemovePartner);
						this.hardWait(4);
						clickOnWebElement(btnAddPartner);
						break;

					}

				} catch (Exception e1) {
					clickOnElement(btnBack);
				}

			}

		}

		log.info("Ending of clickOnBracketLabel method");
	}

	public void clickOnAddPartnerFromKebabMenu() {
		log.info("Starting of clickOnAddPartnerFromKebabMenu method");

		clickOnWebElement(btnAddPartnerInKebabMenu);

		log.info("Ending of clickOnAddPartnerFromKebabMenu method");
	}

	public boolean isAddPartnerDisplayedInBracketsPage() {
		log.info("Starting of isAddPartnerDisplayedInBracketsPage method");
		log.info("Ending of isAddPartnerDisplayedInBracketsPage method");

		return btnAddPartnerInKebabMenu.isDisplayed();
	}

	public boolean isEditPartnerDisplayedInBracketsPage() {
		log.info("Starting of isEditPartnerDisplayedInBracketsPage method");
		log.info("Ending of isEditPartnerDisplayedInBracketsPage method");

		return btnEditPartner.isDisplayed();
	}

	public void clickOnBracketKebabButton() {
		log.info("Starting of clickOnBracketKebabButton method");

		clickOnWebElement(btnkebabBracket);

		log.info("Ending of clickOnBracketKebabButton method");
	}

	public void clickOnEditPartner() {
		log.info("Starting of clickOnEditPartner method");
		try {
			clickOnWebElement(btnEditPartner);
		} catch (Exception e) {
			btnEditPartner.click();
		}
		log.info("Ending of clickOnEditPartner method");

	}

	public void clickOnAddPartnerRadioButton() {
		log.info("Starting of clickOnAddPartnerRadioButton method");

		hardWait(5);
		try {
			Actions act = new Actions(driver);

			for (int i = 0; i < 7; i++) {
				hardWait(2);
				act.sendKeys(Keys.TAB).build().perform();
			}

			act.sendKeys(Keys.SPACE).build().perform();

		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("Ending of clickOnAddPartnerRadioButton method");

	}

	public void clickOnBracketNameLink() {
		log.info("Starting of clickOnBracketNameLink method");

		for (int i = 1; i < lnkBracketNames.size(); i++) {
			this.hardWait(2);
			driver.findElement(
					By.xpath((("(//h4[contains(@class,'MuiTypography-root MuiTypography-h4 MuiTypography-noWrap')])["
							+ i + "]"))))
					.click();

			this.hardWait(5);
			try {
				if ((isDisplayed(btnAddParticipants) == true)) {
					clickOnElement(btnAddParticipants);
					break;
				}
			} catch (Exception e) {
				clickOnElement(btnBack);
			}
		}

		log.info("Ending of clickOnBracketNameLink method");
	}

	public void clickOnMyBrackets() {
		log.info("Starting of clickOnMyBrackets method");
		try {
			clickOnWebElement(btnMyBrackets);
		} catch (Exception e) {
			btnMyBrackets.click();
		}

		log.info("Ending of clickOnMyBrackets method");
	}

	public void clickOnAddAPartnerButton() {
		log.info("Starting of clickOnAddAPartnerButton method");

		try {

			Actions act = new Actions(driver);

			for (int i = 0; i < 2; i++) {
				hardWait(2);
				act.sendKeys(Keys.TAB).build().perform();
			}

			act.sendKeys(Keys.SPACE).build().perform();

		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("Ending of clickOnAddAPartnerButton method");
	}

	public void clickOnEditPartnerButton() {
		log.info("Starting of clickOnEditPartnerButton method");

		clickOnWebElement(btnEditPartner);

		log.info("Ending of clickOnEditPartnerButton method");
	}

	public void clickOnBracketCancelButon() {
		log.info("Starting Of clickOnBracketCancelButon method");

		clickOnWebElement(btnBracketcancel);

		log.info("Ending Of clickOnBracketCancelButon method");
	}

	public void clickOnHomeMenu() {
		log.info("Starting of clickOnHomeMenu method");

		clickOnWebElement(mnuHome);

		log.info("Ending of clickOnHomeMenu method");
	}

	public void clickOnAddParticipantsButton() {
		log.info("Starting of clickOnAddParticipantsButton method");

		clickOnWebElement(btnAddParticipants);

		log.info("Ending of clickOnAddParticipantsButton method");
	}

	public void clickOnGoBackButton() {
		log.info("Starting Of clickOnGoBackButton method");

		clickOnWebElement(btnGoBack);

		log.info("Ending Of clickOnGoBackButton method");
	}

	public void clickOnAddAMatchMenu() {
		log.info("Starting of clickOnAddAMatchMenu method");

		clickOnWebElement(mnuAddAMatch);

		log.info("Ending of clickOnAddAMatchMenu method");
	}

	public void clickOnAddYourPartnerButton() {
		log.info("Starting of clickOnAddYourPartnerButton method");

		clickOnWebElement(btnAddYourPartner);

		log.info("Ending of clickOnAddYourPartnerButton method");
	}

	public void clickOnCancelButton() throws InterruptedException {
		log.info("Starting of clickOnCancelButton method");

		this.hardWait(2);
		/*
		 * try { elementClick(btnCancel);
		 * 
		 * 
		 * } catch (Exception e) { clickOnWebElement(btnCancel); }
		 */
		driver.navigate().back();

		log.info("Ending of clickOnCancelButton method");
	}

	public void clickOnAddYourOpponentButton() {
		log.info("Starting of clickOnAddYourOpponentButton method");

		clickOnWebElement(btnAddYourOpponent);

		log.info("Ending of clickOnAddYourOpponentButton method");
	}

	public void clickOnRemovePartnerButton() {
		log.info("Starting of clickOnRemovePartnerButton method");

		clickOnWebElement(btnRemovePartner);

		log.info("Ending of clickOnRemovePartnerButton method");
	}

	public void clickOnAddPlayersDropdown() {
		log.info("Starting of clickOnAddPlayersDropdown method");

		hardWait(3);
		try {
			clickUsingActionsClass(drpAddPlayers);
		} catch (Exception e) {
			clickOnWebElement(drpAddPlayers);
		}
		
		log.info("Ending of clickOnAddPlayersDropdown method");
	}

	public void clickOnAddSingleDURPUserButton() {
		log.info("Starting of clickOnAddSingleDURPUserButton method");

		clickOnWebElement(btnAddSingleDURPUser);

		log.info("Ending of clickOnAddSingleDURPUserButton method");
	}

	public void clickOnCancelButtonInClubMemberPage() {
		log.info("Starting of clickOnCancelButtonInClubMemberPage method");

		clickOnWebElement(btnCancelInClubMemberPage);

		log.info("Ending of clickOnCancelButtonInClubMemberPage method");
	}

	public void clickOnAddAMatchButton() {
		log.info("Starting of clickOnAddAMatchButton method");

		clickOnWebElement(btnAddAMatch);

		log.info("Ending of clickOnAddAMatchButton method");
	}

	public void clickOnBrowseClubsButton() {
		log.info("Starting of clickOnBrowseClubsButton method");

		clickOnWebElement(btnBrowseClubs);

		log.info("Ending of clickOnBrowseClubsButton method");
	}

	public void clickOnAddFirstPlayerButton() {
		log.info("Starting of clickOnAddFirstPlayerButton method");

		clickOnWebElement(btnAddFirstPlayer);

		log.info("Ending of clickOnAddFirstPlayerButton method");
	}

	public void clickOnPlayerCancelButton() {
		log.info("Starting of clickOnPlayerCancelButton method");

		clickOnWebElement(btnPlayersCancel);

		log.info("Ending of clickOnPlayerCancelButton method");
	}

	public void clickOnOpenSettingsMenu() {
		log.info("Starting of clickOnOpenSettingsMenu method");

		clickOnWebElement(mnuOpenSettings);

		log.info("Ending of clickOnOpenSettingsMenu method");
	}

	public void clickOnLogOutButton() {
		log.info("Starting of clickOnLogOutButton method");

		clickOnWebElement(btnLogOut);

		log.info("Ending of clickOnLogOutButton method");
	}

	public void clickOnSignUpButton() {
		log.info("Starting of clickOnSignUpButton method");

		clickOnWebElement(btnSignUP);

		log.info("Ending of clickOnSignUpButton method");
	}

	public void clickOnTeamsTab() {
		log.info("Starting of clickOnTeamsTab method");

		try {
			try {
				clickUsingActionsClass(tabTeams);
			} catch (Exception e) {
				clickOnWebElement(tabTeams);
			}

		} catch (Exception e) {
			clickOnElement(btnBack);
			hardWait(3);

			for (int i = 1; i < lnkBracketNames.size(); i++) {
				this.hardWait(2);
				driver.findElement(By
						.xpath((("(//h4[contains(@class,'MuiTypography-root MuiTypography-h4 MuiTypography-noWrap')])["
								+ i + "]"))))
						.click();

				this.hardWait(5);
				try {
					if ((isDisplayed(tabTeams) == true)) {
						clickOnElement(tabTeams);
						break;
					}
				} catch (Exception e1) {
					clickOnElement(btnBack);
				}
			}
		}

		log.info("Ending of clickOnTeamsTab method");
	}

	public void clickOnEditTeamButton() {
		log.info("Starting of clickOnEditTeamButton method");

		for (WebElement element : lstEditTeam) {
			element.click();
			break;
		}
		log.info("Ending of clickOnEditTeamButton method");
	}

	public void clickOnRemovePlayerIcon() {
		//log.info("Starting of clickOnRemovePlayerIcon method");

		hardWait(3);
		try {
			hardWait(3);
			clickUsingActionsClass(iconRemovePlayer);
			hardWait(3);
		} catch (Exception e) {
			clickOnWebElement(iconRemovePlayer);
		}

		for (int i = 0; i < 5; i++) {
			try {
				if (driver.findElement(By.xpath("//button[contains(text(),'Add a Player')]")).isDisplayed()) {
					System.out.println("***Player Removed***");
					break;
				}
			} catch (Exception e) {
				driver.findElement(By.xpath("(//button[@aria-label='remove player'])[1]")).click();
				break;
			}
		}

		log.info("Ending of clickOnRemovePlayerIcon method");
	}

	public void clickOnAddPlayerButton() {
		log.info("Starting of clickOnAddPlayerButton method");

		clickOnElement(btnAddPlayer);

		log.info("Ending of clickOnAddPlayerButton method");
	}

	public int getPlayerList() {
		log.info("Starting of getPlayerList Method");

		int getPlayerList = txtPlayerName.size();
		System.out.println(txtPlayerName.size());

		log.info("Ending of getPlayerList Method");
		return getPlayerList;
	}
}
