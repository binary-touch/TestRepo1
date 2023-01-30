package com.dupr.pages.profile;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class ProfilePicturePage extends DUPRBaseAutomationPage {
	private static final Logger log = LogManager.getLogger(ProfilePicturePage.class);

	@B2BFindBy(xpath = "//button[@aria-label='Open settings']")
	private WebElement mnuOpenSettings;

	@B2BFindBy(xpath = "//div[text()='Edit Profile']")
	private WebElement btnEditProfile;

	@B2BFindBy(xpath = "//input[@type='file']")
	private WebElement fileChoose;
	
	@B2BFindBy(xpath = "//div[contains(@class, 'MuiBox-root css-')]/label[text()='Choose file']")
	private WebElement btnChooseFile;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiBox-root')]//span[contains(@class,'MuiButtonBase-root MuiIconButton-root MuiIconButton-colorPrimary MuiIconButton-sizeMedium')]/span")
	private WebElement iconCamera;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiDialogActions-root MuiDialogActions-spacing')]/button[text()='Save']")
	private WebElement btnSave;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiDialogActions-root MuiDialogActions-spacing')]/button[text()='Save' and @disabled]")
	private WebElement btnSaveInDisabled;

	@B2BFindBy(xpath = "//h4[text()='Profile Picture']")
	private WebElement lblProfilePicture;

	@B2BFindBy(xpath = "//button[@aria-label=\"close\"]")
	private WebElement iconClose;

	//@B2BFindBy(xpath = "//div[@class='MuiDialogActions-root MuiDialogActions-spacing css-v0512d']/button[contains(@class,'MuiButton-contained')]/preceding-sibling::button")
	@B2BFindBy(xpath = "//button[text()='Cancel']")
	private WebElement btnCancel;

	@B2BFindBy(xpath = "//ul[@id='composition-menu']/li/following-sibling::li")
	private WebElement btnRemoveProfilePicture;

	@B2BFindBy(xpath = "//ul[@id='composition-menu']/li/following-sibling::li/preceding-sibling::li")
	private WebElement btnChangeProfilePicture;

	@B2BFindBy(xpath = "//h4[@id='customized-dialog-title']")
	private WebElement lblRemoveProfilePicture;

	@B2BFindBy(xpath = "//div[@class='MuiDialogActions-root MuiDialogActions-spacing css-v0512d']/button[contains(@class,'MuiButton-contained')]")
	private WebElement btnYes;

	@B2BFindBy(xpath = "//button[text()='No']")
	private WebElement btnNo;

	@B2BFindBy(xpath = "//span[contains(@class, 'MuiBadge-root MuiBadge-root')]/div[contains(@class,'MuiAvatar-root MuiAvatar-circular')]/img")
	private WebElement imgProfilePicture;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiDialogContent-root MuiDialogContent-dividers')]//div[@class='cropper-container'] //div[@class='cropper-canvas']/img")
	private WebElement imgPreviouslyUploaded;

	@B2BFindBy(xpath = "//h3[text()='Edit Profile']")
	private WebElement lblEditProfile;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiGrid-root MuiGrid-container')]/descendant::h2")
	private WebElement lblPlayerName;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiBox-root')]//span[contains(@class,'MuiButtonBase-root MuiIconButton-root MuiIconButton-colorPrimary MuiIconButton-sizeMedium')]/span")
	private WebElement iconEditProfileImage;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiBox-root')]/button[text()='View Public Profile']")
	private WebElement btnViewPublicProfile;

	@B2BFindBy(xpath = "//img[@class='MuiAvatar-img css-1hy9t21']")
	private WebElement iconSettings;

	public ProfilePicturePage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public void clickOnOpenSettingsMenu() {
		log.info("Starting of clickOnOpenSettingsMenu method");

		elementClick(mnuOpenSettings);

		log.info("Ending of clickOnOpenSettingsMenu method");
	}

	public void clickOnEditProfileButton() {
		log.info("Starting of clickOnEditProfileButton method");

		elementClick(btnEditProfile);

		log.info("Ending of clickOnEditProfileButton method");
	}

	public void clickOnCameraIcon() {
		log.info("Starting of clickOnCameraIcon method");

		elementClick(iconCamera);

		log.info("Ending of clickOnCameraIcon method");
	}

	public boolean isProfilePicturePopupContains() {
		log.info("Starting of isProfilePicturePopupContains method");

		System.out.println(isDisplayed(iconClose));
		System.out.println(isDisplayed(btnCancel));
		System.out.println(isDisplayed(btnChooseFile));
		
		boolean isProfilePicturePopupContains = false;

		if (isDisplayed(iconClose) && isDisplayed(btnCancel) && isDisplayed(btnChooseFile)) {
			isProfilePicturePopupContains = true;
		}

		log.info("Ending of isProfilePicturePopupContains method");

		return isProfilePicturePopupContains;
	}

	public String getProfilePictureText() {
		log.info("Starting of getProfilePictureText method");
		log.info("Ending of getProfilePictureText method");

		return getText(lblProfilePicture);
	}

	public void uploadProfilePicture(String filepath) {
		log.info("Starting of uploadProfilePicture method");

		this.fileChoose.sendKeys(filepath);

		log.info("Ending of uploadProfilePicture method");
	}

	public void clickOnSaveButton() {
		log.info("Starting of clickOnSaveButton method");

		elementClick(btnSave);

		log.info("Ending of clickOnSaveButton method");
	}

	public void clickOnCloseIcon() {
		log.info("Starting of clickOnCloseIcon method");

		elementClick(iconClose);

		log.info("Ending of clickOnCloseIcon method");
	}

	public void clickOnCancelButton() {
		log.info("Starting of clickOnCancelButton method");

		elementClick(btnCancel);

		log.info("Ending of clickOnCancelButton method");
	}

	public void clickOnRemoveProfilePicture() {
		log.info("Starting of clickOnRemoveProfilePicture method");

		elementClick(btnRemoveProfilePicture);

		log.info("Ending of clickOnRemoveProfilePicture method");
	}

	public void clickOnChangeProfilePictureButton() {
		log.info("Starting of clickOnChangeProfilePictureButton method");

		clickOnWebElement(btnChangeProfilePicture);

		log.info("Ending of clickOnChangeProfilePictureButton method");
	}

	public void clickOnYesButton() {
		log.info("Starting of clickOnYesButton method");

		elementClick(btnYes);

		log.info("Ending of clickOnYesButton method");
	}

	public void clickOnNoButton() {
		log.info("Starting of clickOnNoButton method");

		elementClick(btnNo);

		log.info("Ending of clickOnNoButton method");
	}

	public boolean isRemoveProfilePictureButtonDisplayed() {
		log.info("Starting of isRemoveProfilePictureButtonDisplayed method");
		log.info("Ending of isRemoveProfilePictureButtonDisplayed method");

		return isDisplayed(btnRemoveProfilePicture);
	}

	public boolean isChangeProfilePictureButtonDisplayed() {
		log.info("Starting of isChangeProfilePictureButtonDisplayed method");
		log.info("Ending of isChangeProfilePictureButtonDisplayed method");

		return isDisplayed(btnChangeProfilePicture);
	}

	public boolean isProfilePictureDisplayed() {
		log.info("Starting of isProfilePictureDisplayed method");

		boolean profilePictureStatus = false;

		try {
			if (isDisplayed(imgProfilePicture) == true) {
				profilePictureStatus = true;
			}
		} catch (Exception e) {
			log.info("Profile picture was removed");
		}

		log.info("Ending of isProfilePictureDisplayed method");

		return profilePictureStatus;
	}

	public boolean ispreviousUploadedImageDisplayed() {
		log.info("Starting of ispreviousUploadedImageDisplayed method");
		log.info("Ending of ispreviousUploadedImageDisplayed method");

		return isDisplayed(imgPreviouslyUploaded);
	}

	public boolean isSaveButtonDisabled() {
		log.info("Starting of isSaveButtonDisabled method");
		log.info("Ending of isSaveButtonDisabled method");

		return isDisplayed(btnSaveInDisabled);
	}

	public boolean isSaveButtonDisplayed() {
		log.info("Starting of isSaveButtonDisplayed method");
		log.info("Ending of isSaveButtonDisplayed method");

		return isDisplayed(btnSave);
	}

	public boolean isEditProfilePageContains() {
		log.info("Starting of isEditProfilePageContains method");

		boolean isEditProfilePageContains = false;

		if (isDisplayed(lblEditProfile) && isDisplayed(lblPlayerName) && isDisplayed(iconEditProfileImage)
				&& isDisplayed(btnViewPublicProfile)) {
			isEditProfilePageContains = true;
		}

		log.info("Ending of isEditProfilePageContains method");

		return isEditProfilePageContains;
	}

	public boolean isRemoveProfilePicturePopupContains() {
		log.info("Starting of isRemoveProfilePicturePopupContains method");

		boolean isRemoveProfilePicturePopupContains = false;

		if (isDisplayed(lblRemoveProfilePicture) && isDisplayed(btnYes) && isDisplayed(btnNo)
				&& isDisplayed(iconClose)) {
			isRemoveProfilePicturePopupContains = true;
		}

		log.info("Ending of isRemoveProfilePicturePopupContains method");

		return isRemoveProfilePicturePopupContains;
	}

	public void clickOnSettingsIcon() {
		log.info("Starting of clickOnSettingsIcon method");

		elementClick(iconSettings);

		log.info("Ending of clickOnSettingsIcon method");
	}
}
