package com.dupr.pages.home;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class ChatPage extends DUPRBaseAutomationPage {
	private static final Logger log = LogManager.getLogger(ChatPage.class);

	@B2BFindBy(xpath = "//div[contains(@class,'MuiGrid-item MuiGrid-grid-xs-2 MuiGrid-grid-md-1.5')]/div")
	private WebElement iconMessage;

	@B2BFindBy(xpath = "//button[contains(text(),'Message')]")
	private WebElement btnMessage;

	@B2BFindBy(xpath = "//p[contains(@class,'str-chat__header-livestream-left--title str-chat__channel-header-title')]")
	private WebElement txtName;

	@B2BFindBy(xpath = "//textarea[@data-testid='message-input']")
	private WebElement txtMessage;

	@B2BFindBy(xpath = "//div[contains(@class,'rfu-file-upload-button')]")
	private WebElement btnAttachFiles;

	@B2BFindBy(xpath = "//div[@class='str-chat messaging light str-chat-channel str-chat__channel']/parent::div/following-sibling::div//button")
	private WebElement iconClose;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiGrid-item MuiGrid-grid-xs-2 MuiGrid-grid-md-1.5')]/div/ancestor::div[contains(@class,'MuiGrid-root MuiGrid-container')]/div[contains(@class,'MuiGrid-grid-xs-12 MuiGrid-grid-md-6')]//h4 ")
	private WebElement lblVerifiedPlayerCard;

	@B2BFindBy(xpath = "//input[@id='Search']")
	private WebElement txtBoxSearch;

	@B2BFindBy(xpath = "//h4[contains(@class,'MuiTypography-root MuiTypography-h4')]")
	private WebElement txtClubCard;

	@B2BFindBy(xpath = "//button[contains(text(),'Add Players')]")
	private WebElement btnAddPlayer;

	@B2BFindBy(xpath = "//li[contains(text(),'Add a single DUPR user')]")
	private WebElement btnAddSinglePlayers;

	@B2BFindBy(xpath = "//input[@type='radio']")
	private WebElement rdoPlayer;

	@B2BFindBy(xpath = "//button/following-sibling::button[contains(text(),'Add Player')]")
	private WebElement btnAddClubPlayer;

	@B2BFindBy(xpath = "//h3[contains(text(),'Inbox Empty')]")
	private WebElement txtInboxEmpty;

	@B2BFindBy(xpath = "//span[contains(@class,'MuiBadge-root MuiBadge-root')]")
	private WebElement btnMessageDashboard;

	@B2BFindBy(xpath = "//h4[contains(text(),'Verify your Email')]//button[contains(@class,'MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium')]")
	private WebElement iconCloseOnVerifyEmail;

	@B2BFindBy(xpath = "//input[@id='Search']")
	private WebElement txtSearch;
	
	public ChatPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public void clickOnMessageIcon(String meet) {
		log.info("Starting of clickOnMessageIcon method");

		try {
			clickUsingActionsClass(txtSearch);
			txtSearch.sendKeys(meet);
			if (isDisplayed(iconMessage) == true) {
				try {

					elementClick(iconMessage);
				} catch (Exception e) {
					clickUsingActionsClass(txtSearch);
					txtSearch.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
				}

				// iconMessage.click();
				// clickOnWebElement(iconMessage);
			}
		} catch (Exception e) {
			for (int i = 0; i < 4; i++) {
				try {
					this.scrollDown(1000);
					this.hardWait(5);
					if (isDisplayed(iconMessage) == true) {
						clickOnWebElement(iconMessage);
					}

				} catch (Exception e2) {
					driver.navigate().refresh();
				}
			}
		}
		log.info("Ending of clickOnMessageIcon method");
	}

	public void clickOnMessageButton() {
		log.info("Starting of clickOnMessageButton method");
		
		try {
			clickOnWebElement(btnMessage);
			this.hardWait(3);
		} catch (Exception e) {
			elementClick(btnMessage);
			this.hardWait(3);
		}

		log.info("Ending of clickOnMessageButton method");
	}

	public boolean isMessagePopUpContains() {
		log.info("Starting of isMessagePopUpContains method");

		boolean isMessagePopUpContains = false;

		try {
			this.hardWait(3);

			if (isDisplayed(txtName) && isDisplayed(txtMessage) && isDisplayed(btnAttachFiles)
					&& isDisplayed(iconClose)) {

				isMessagePopUpContains = true;
			}
		} catch (Exception e) {
			isMessagePopUpContains = false;
		}

		log.info("Ending of isMessagePopUpContains method");

		return isMessagePopUpContains;
	}

	public void clickOnCloseIcon() {
		log.info("Starting of clickOnCloseIcon method");

		clickOnWebElement(iconClose);

		log.info("Ending of clickOnCloseIcon method");
	}

	public void clickOnPlayersCard() {
		log.info("Starting of clickOnPlayersCard method");
		
		this.hardWait(3);
		clickOnWebElement(lblVerifiedPlayerCard);
		this.hardWait(3);

		log.info("Ending of clickOnPlayersCard method");
	}

	public void clickOnMessageIconClub() {
		log.info("Starting of clickOnMessageIconClub method");

		try {
			if (isDisplayed(iconMessage) == true) {
				clickOnWebElement(iconMessage);
			}
		} catch (Exception e) {
			for (int i = 0; i < 3; i++) {
				try {
					this.scrollDown(1000);
					this.hardWait(5);
					if (isDisplayed(iconMessage) == true) {
						clickOnWebElement(iconMessage);
					}

				} catch (Exception e2) {
					e.printStackTrace();
				}
			}
		}
		log.info("Ending of clickOnMessageIconClub method");
	}

	public void searchForClub(String ClubName) {
		log.info("Starting of searchForClub method");

		clickOnWebElement(txtBoxSearch);
		this.txtBoxSearch.sendKeys(ClubName);
		this.hardWait(3);

		log.info("Ending of searchForClub method");
	}

	public void clickOnClubCard() {
		log.info("Starting of clickOnClubCard method");

		clickOnWebElement(txtClubCard);

		log.info("Ending of clickOnClubCard method");
	}

	public void clickOnTextMessage(String Msg) {
		log.info("Starting of clickOnTextMessage method");
		try {
			clickOnWebElement(txtMessage);
			this.txtMessage.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
			this.txtMessage.sendKeys(Msg);
			this.txtMessage.sendKeys(Keys.ENTER);
			this.hardWait(3);
		} catch (Exception e) {
			System.out.println("  ");
		}

		log.info("Ending of clickOnTextMessage method");
	}

	public boolean isInboxEmptyDisplayed() {
		log.info("Starting of isInboxEmptyDisplayed method");

		boolean isInboxEmptyDisplayed = false;
		try {
			if (isDisplayed(txtInboxEmpty)) {

				isInboxEmptyDisplayed = true;
			}
		} catch (Exception e) {
			isInboxEmptyDisplayed = false;
		}

		log.info("Ending of isInboxEmptyDisplayed method");

		return isInboxEmptyDisplayed;
	}

	public boolean isMessageIconDisplayed() {
		log.info("Starting of isMessageIconDisplayed method");

		boolean isMessageIconDisplayed = false;
		try {
			if (isDisplayed(btnMessageDashboard)) {

				isMessageIconDisplayed = true;
			}
		} catch (Exception e) {
			isMessageIconDisplayed = false;
		}

		log.info("Ending of isMessageIconDisplayed method");

		return isMessageIconDisplayed;
	}

	public void clickOnCloseOnVerifyEmail() {
		log.info("Starting of clickOnCloseOnVerifyEmail method");

		clickOnWebElement(iconCloseOnVerifyEmail);

		log.info("Ending of clickOnCloseOnVerifyEmail method");
	}
}
