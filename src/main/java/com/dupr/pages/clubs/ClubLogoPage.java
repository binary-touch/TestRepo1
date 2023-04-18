package com.dupr.pages.clubs;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BFindBys;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class ClubLogoPage extends DUPRBaseAutomationPage {
	private static final Logger log = LogManager.getLogger(ClubLogoPage.class);

	@B2BFindBy(xpath = "//h3[text()='Club']")
	private WebElement lblClub;

	// @B2BFindBy(xpath = "//div[@class='MuiBox-root
	// css-1srz93r']/input[@type='file']")
	// @B2BFindBy(xpath = "//label[text()='Choose file']")
	@B2BFindBy(xpath = "//input[@type='file' and @accept]")
	private WebElement chooseFile;

	@B2BFindBy(xpath = "//div[contains(@class, 'MuiBox-root css-')]/label[text()='Choose file']")
	private WebElement btnChooseFile;

	@B2BFindBy(xpath = "//label/span[contains(@class,'MuiIconButton-colorPrimary MuiIconButton-sizeMedium')]")
	private WebElement iconCamera;

	@B2BFindBy(xpath = "//button[contains(@class,'MuiButton-contained') and text()='Save']")
	private WebElement btnSave;

	@B2BFindBy(xpath = "//button[contains(@class,'MuiButton-contained') and text()='Save' and @disabled]")
	private WebElement btnSaveInDisabled;

	@B2BFindBy(xpath = "//h2[@id='customized-dialog-title']/h4[text()='Club Logo']")
	private WebElement lblClubLogo;

	@B2BFindBy(xpath = "//button[@aria-label='close']")
	private WebElement iconClose;

	@B2BFindBy(xpath = "//div/button[contains(@class,'MuiButton-contained')]/preceding-sibling::button[text()='Cancel']")
	private WebElement btnCancel;

	// @B2BFindBy(xpath
	// ="//ul[@id='composition-menu']/li/following-sibling::li[text()='Remove
	// Logo']")
	@B2BFindBy(xpath = "//li[text()='Remove Logo']")
	private WebElement btnRemoveLogo;

	// @B2BFindBy(xpath
	// ="//ul[@id='composition-menu']/li/following-sibling::li/preceding-sibling::li")
	@B2BFindBy(xpath = "//li[contains(text(),'Change Logo')]")
	private WebElement btnChangeLogo;

	@B2BFindBy(xpath = "//h4[contains(text(),'Remove Logo')]")
	private WebElement txtRemoveLogo;

	@B2BFindBy(xpath = "//ul[@id='composition-menu']/li/following-sibling::li[text()='Remove Logo']")
	private WebElement lblRemoveLogo;

	@B2BFindBy(xpath = "//div/button[contains(@class,'MuiButton-contained') and text()='Yes']")
	private WebElement btnYes;

	@B2BFindBy(xpath = "//div/button[contains(@class,'MuiButton-contained')]/preceding-sibling::button[text()='No']")
	private WebElement btnNo;

	@B2BFindBy(xpath = "//h3/div[contains(@class,'MuiBox-root')]")
	private WebElement lblClubName;

	@B2BFindBy(xpath = "//h3//button[contains(@class,'MuiIconButton-root MuiIconButton-sizeSmall')]")
	private WebElement iconEditClub;

	@B2BFindBy(xpath = "//button[contains(text(),'Add Players')]/span")
	private WebElement btnAddPlayers;

	@B2BFindBy(xpath = "//button[contains(text(),'Add a Match')]")
	private WebElement btnAddAMatch;

	@B2BFindBy(xpath = "//div/button[text()='Add Event']")
	private WebElement btnAddEvent;

	@B2BFindBy(xpath = "//div/following-sibling::button[text()='Share']")
	private WebElement btnShare;

	@B2BFindBy(xpath = "//div/h4[text()='My Clubs']")
	private WebElement tabMyClubs;

	@B2BFindBys(@B2BFindBy(xpath = "//h5[text()='As a Director']/..//div[contains(@class,'MuiGrid-item MuiGrid-grid-xs-12')]/div//h4"))
	private List<WebElement> lstClubs;

	@B2BFindBy(xpath = "//h3[text()='Browse Clubs']")
	private WebElement lblBrowseClubs;

	@B2BFindBys(@B2BFindBy(xpath = "//div/div[contains(@class,'MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation3')]//h4"))
	private List<WebElement> lstClubsInBrowseClubsPage;

	@B2BFindBy(xpath = "(//button[contains(@class,'MuiIconButton-root MuiIconButton-sizeMedium') and @type='button'])[2]")
	private WebElement btnBack;

	@B2BFindBy(xpath = "//input[@id='Search']")
	private WebElement txtBoxSearch;

	@B2BFindBy(xpath = "//h4[text()='Simba']")
	private WebElement lblSimbaClubName;

	@B2BFindBy(xpath = "//span[contains(@class,'MuiBadge-root MuiBadge-root')]/div[contains(@class,'MuiAvatar-root MuiAvatar-circular')]/img")
	private WebElement imgClubLogo;

	@B2BFindBy(xpath = "//*[name()='path' and contains(@data-name,'Path 1260')]")
	private WebElement imgEmptyClubLogo;

	@B2BFindBy(xpath = "//p[text()='Select an image to upload']")
	private WebElement lblSelectAnImageToUpload;

	@B2BFindBy(xpath = "//button[text()='Browse Clubs']")
	private WebElement btnBrowseClubs;

	public ClubLogoPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public void uploadProfilePicture(String filepath) {
		log.info("Starting of uploadProfilePicture method");

		this.chooseFile.sendKeys(filepath);

		log.info("Ending of uploadProfilePicture method");
	}

	public String getClubLogoText() {
		log.info("Starting of getClubLogoText method");
		System.out.println(getText(lblClubLogo));
		log.info("Ending of getClubLogoText method");

		return getText(lblClubLogo);
	}

	public void clickOnRemoveLogoOption() {
		log.info("Starting of clickOnRemoveLogoOption method");
		try {
			clickUsingActionsClass(btnRemoveLogo);
		} catch (Exception e) {
			clickOnWebElement(btnRemoveLogo);
		}
		log.info("Ending of clickOnRemoveLogoOption method");
	}

	public void clickOnChangeLogoOption() {
		log.info("Starting of clickOnChangeLogoOption method");
		
		try {
			clickUsingActionsClass(btnChangeLogo);
		} catch (Exception e) {
			clickOnWebElement(btnChangeLogo);
		}

		log.info("Ending of clickOnChangeLogoOption method");
	}

	public void clickOnBrowseClubs() {
		log.info("Starting of clickOnBrowseClubs method");
         hardWait(5);
		elementClick(btnBrowseClubs);

		log.info("Ending of clickOnBrowseClubs method");
	}

	public void clickOnBackButton() {
		log.info("Starting of clickOnBackButton method");

		elementClick(btnBack);

		log.info("Ending of clickOnBackButton method");
	}

	public boolean isClubPageContains() {
		log.info("Starting of isClubPageContains method");

		boolean isClubPageContains = false;

		if (isDisplayed(lblClubName) && isDisplayed(iconEditClub) && isDisplayed(btnAddPlayers)
				&& isDisplayed(btnAddAMatch) && isDisplayed(btnAddEvent) && isDisplayed(btnShare)) {
			isClubPageContains = true;
		}

		log.info("Ending of isClubPageContains method");

		return isClubPageContains;
	}

	public boolean isRemoveLogoPopupContains() {
		log.info("Starting of isRemoveLogoPopupContains method");

		boolean isRemoveLogoPopupContains = false;

		try {
			if (isDisplayed(lblRemoveLogo) && isDisplayed(btnYes) && isDisplayed(btnNo) && isDisplayed(iconClose)) {
				isRemoveLogoPopupContains = true;
			}
		} catch (Exception e) {
			isRemoveLogoPopupContains = false;
		}

		log.info("Ending of isRemoveLogoPopupContains method");

		return isRemoveLogoPopupContains;
	}

	public boolean isClubLogoPopupContains() {
		log.info("Starting of isClubLogoPopupContains method");

		boolean isClubLogoPopupContains = false;

		if (isDisplayed(iconClose) && isDisplayed(btnCancel) && isDisplayed(btnChooseFile)) {
			isClubLogoPopupContains = true;
		}

		log.info("Ending of isClubLogoPopupContains method");

		return isClubLogoPopupContains;
	}

	public boolean isRemoveLogoDisplayed() {
		log.info("Starting of isRemoveLogoDisplayed method");
		log.info("Ending of isRemoveLogoDisplayed method");

		return isDisplayed(btnRemoveLogo);
	}

	public boolean isEmptyLogoDisplayed() {
		log.info("Starting of isEmptyLogoDisplayed method");
		log.info("Ending of isEmptyLogoDisplayed method");

		return isDisplayed(imgEmptyClubLogo);
	}

	public String getSelectImageToUploadText() {
		log.info("Starting of getSelectImageToUploadText method");
		System.out.println(getText(lblSelectAnImageToUpload));
		log.info("Ending of getSelectImageToUploadText method");

		return getText(lblSelectAnImageToUpload);
	}

	public boolean isChangeLogoDisplayed() {
		log.info("Starting of isChangeLogoDisplayed method");
		log.info("Ending of isChangeLogoDisplayed method");

		return isDisplayed(btnChangeLogo);
	}

	public void clickOnMyClubsTab() {
		log.info("Starting of clickOnMyClubsTab method");

		try {
			hardWait(5);
			clickUsingActionsClass(tabMyClubs);
		} catch (Exception e) {
			hardWait(5);
			clickOnWebElement(tabMyClubs);
		}

		log.info("Ending of clickOnMyClubsTab method");
	}

	public void clickOnClub() {
		log.info("Starting of clickOnClub method");

		for (WebElement club : lstClubs) {
			hardWait(5);
			try {
				clickOnElementUsingActionClass(club);
			} catch (Exception e) {
				for (int i = 0; i <= 3;) {
					this.lstClubs.get(i).click();
					break;
				}
			}

			break;
		}
		log.info("Ending of clickOnClub method");
	}

	public void searchClubWithClubName() {
		log.info("Starting of searchClubWithClubName method");

		this.txtBoxSearch.click();
		this.txtBoxSearch.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
		try {
			sendKeys(txtBoxSearch, "jvdvdn");
			this.txtBoxSearch.sendKeys(Keys.ENTER);
			try {
				hardWait(3);
				clickOnElementUsingActionClass(lstClubsInBrowseClubsPage.get(0));
			} catch (Exception e) {
				hardWait(3);
				this.lstClubsInBrowseClubsPage.get(0).click();
			}

		} catch (Exception e) {
			sendKeys(txtBoxSearch, "gegegerge");
			this.txtBoxSearch.sendKeys(Keys.ENTER);
			try {
				clickOnElementUsingActionClass(lstClubsInBrowseClubsPage.get(0));
			} catch (Exception e1) {
				this.lstClubsInBrowseClubsPage.get(0).click();
			}
		}

		log.info("Ending of searchClubWithClubName method");
	}

	public void clickOnClubInBrowsePlayersPage() {
		log.info("Starting of clickOnClubInBrowsePlayersPage method");

		for (WebElement club : lstClubsInBrowseClubsPage) {
			hardWait(5);
			try {
				clickOnElementUsingActionClass(club);
			} catch (Exception e) {
				for (int i = 0; i <= 3;) {
					this.lstClubsInBrowseClubsPage.get(i).click();
					break;
				}
			}

			break;
		}
		log.info("Ending of clickOnClubInBrowsePlayersPage method");
	}

	public boolean isClubsDisplayedInMyClubs() {
		log.info("Starting of isClubsDisplayedInMyClubs method");

		boolean clubState = false;
		for (WebElement club : lstClubs) {
			hardWait(5);
			if (club.isDisplayed() == true) {
				clubState = true;
				break;
			}
		}
		log.info("Ending of isClubsDisplayedInMyClubs method");

		return clubState;
	}

	public void clickOnSimbaClubName() {
		log.info("Starting of clickOnSimbaClubName method");

		try {
			if (lblBrowseClubs.isDisplayed() == true) {
				this.txtBoxSearch.click();
				this.txtBoxSearch.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);

				sendKeys(txtBoxSearch, "Simba");
				//this.txtBoxSearch.sendKeys(Keys.ENTER);
				
				this.txtBoxSearch.sendKeys(Keys.BACK_SPACE);
				sendKeys(txtBoxSearch, "a");
				this.waitForElementToBeVisible(lblSimbaClubName);
				elementClick(lblSimbaClubName);
			}
		} catch (Exception e) {
			elementClick(lblSimbaClubName);
		}

		log.info("Ending of clickOnSimbaClubName method");
	}

	public boolean isProfilePictureDisplayed() {
		log.info("Starting of isProfilePictureDisplayed method");

		boolean profilePictureStatus = false;

		try {
			if (isDisplayed(imgClubLogo) == true) {
				profilePictureStatus = true;
			}
		} catch (NoSuchElementException e) {
			log.info("Profile picture was removed");
			profilePictureStatus = false;
		}

		log.info("Ending of isProfilePictureDisplayed method");

		return profilePictureStatus;
	}
}
