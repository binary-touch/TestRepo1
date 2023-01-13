package com.dupr.pages.profile;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.dupr.pages.DUPRBaseAutomationPage;

public class ChangePasswordPage extends DUPRBaseAutomationPage {
	private static final Logger log = LogManager.getLogger(ChangePasswordPage.class);

	@B2BFindBy(xpath = "//button[text()='Security']")
	private WebElement tabSecurity;

	@B2BFindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-15j76c0']/h3[@class='MuiTypography-root MuiTypography-h3 css-1nvrxol']")
	private WebElement lblChangePassword;

	@B2BFindBy(xpath = "//*[text()='Old Password']/../following-sibling::div//input")
	private WebElement txtBoxOldPassword;

	@B2BFindBy(xpath = "//*[text()='New Password']/../following-sibling::div//input")
	private WebElement txtBoxNewPassword;

	@B2BFindBy(xpath = "//*[text()='Confirm Password']/../following-sibling::div//input")
	private WebElement txtBoxConfirmPassword;

	@B2BFindBy(xpath = "//div[@class='MuiBox-root css-sjnho']/button[@disabled]")
	private WebElement btnSaveInDisabled;

	@B2BFindBy(xpath = "//div[@class='MuiBox-root css-sjnho']/button")
	private WebElement btnSaveInEnabled;

	@B2BFindBy(xpath = "//h4[@id='customized-dialog-title']")
	private WebElement lblUpdateProfile;

	@B2BFindBy(xpath = "//h2[@class='MuiTypography-root MuiTypography-h2 css-ir0jjf']")
	private WebElement txtCongratulations;

	@B2BFindBy(xpath = "//h6[@class='MuiTypography-root MuiTypography-subtitle2 css-1aon3dv']")
	private WebElement txtValidationInUpateProfile;

	@B2BFindBy(xpath = "//div[@class='MuiDialogActions-root MuiDialogActions-spacing css-v0512d']/button")
	private WebElement btnOk;

	@B2BFindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1d07y9m']")
	private WebElement iconClose;

	@B2BFindBy(xpath = "//h5[text()='Old Password']/../following-sibling::div //p")
	private WebElement txtOldPasswordValidation;

	@B2BFindBy(xpath = "//h5[text()='New Password']/../following-sibling::div //p")
	private WebElement txtNewPasswordValidation;

	@B2BFindBy(xpath = "//h5[text()='Confirm Password']/../following-sibling::div //p")
	private WebElement txtConfirmPasswordValidation;

	@B2BFindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 MuiTypography-alignLeft css-1cmwbh0']")
	private WebElement txtValidationInValidPassword;

	@B2BFindBy(xpath = "//h5[text()='Old Password']/../following-sibling::div //button")
	private WebElement iconEye;

	@B2BFindBy(xpath = "//input[@type='text']")
	private WebElement iconEyeUnHiddenMode;

	public ChangePasswordPage(WebDriver driver) {
		super(driver);
	}

	public void clickOnSecurityTab() {
		log.info("Starting of clickOnSecurityTab method");

		try {
			this.clickOnWebElement(tabSecurity);
		} catch (Exception e) {
			this.clickOnElement(tabSecurity);
		}

		log.info("Ending of clickOnSecurityTab method");
	}

	public void setOldPassword(String password) {
		log.info("Starting of setOldPassword method");

		txtBoxOldPassword.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		txtBoxOldPassword.sendKeys(password);

		log.info("Ending of setOldPassword method");
	}

	public void setNewPassword(String password) {
		log.info("Starting of setNewPassword method");

		txtBoxNewPassword.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		txtBoxNewPassword.sendKeys(password);

		log.info("Ending of setNewPassword method");
	}

	public void setConfirmPassword(String password) {
		log.info("Starting of setConfirmPassword method");

		txtBoxConfirmPassword.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		txtBoxConfirmPassword.sendKeys(password);

		log.info("Ending of setConfirmPassword method");
	}

	public boolean isSaveButtonInDisabledDisplayed() {
		log.info("Starting of isSaveButtonInDisabledDisplayed method");
		log.info("Ending of isSaveButtonInDisabledDisplayed method");

		return isDisplayed(btnSaveInDisabled);
	}

	public boolean isSaveButtonInEnabledDisplayed() {
		log.info("Starting of isSaveButtonInEnabledDisplayed method");
		log.info("Ending of isSaveButtonInEnabledDisplayed method");

		return isDisplayed(btnSaveInEnabled);
	}

	public boolean isChangePasswordPageContains() {
		log.info("Starting of isChangePasswordPageContains method");

		boolean isChangePasswordPageContains = false;

		if (isDisplayed(lblChangePassword) && isDisplayed(txtBoxOldPassword) && isDisplayed(txtBoxNewPassword)
				&& isDisplayed(txtBoxConfirmPassword)) {
			isChangePasswordPageContains = true;
		}

		log.info("Ending of isChangePasswordPageContains method");

		return isChangePasswordPageContains;
	}

	public void clickOnSaveButton() {
		log.info("Starting of clickOnSaveButton method");

		try {
			this.clickOnWebElement(btnSaveInEnabled);
		} catch (Exception e) {
			this.clickOnElement(btnSaveInEnabled);
		}

		log.info("Ending of clickOnSaveButton method");
	}

	public boolean isUpdateProfilePopupForSuccessContains() {
		log.info("Starting of isUpdateProfilePopupForSuccessContains method");

		boolean isUpdateProfilePopupForSuccessContains = false;

		if (isDisplayed(lblUpdateProfile) && isDisplayed(txtCongratulations) && isDisplayed(txtValidationInUpateProfile)
				&& isDisplayed(btnOk) && isDisplayed(iconClose)) {
			isUpdateProfilePopupForSuccessContains = true;
		}
		log.info("Ending of isUpdateProfilePopupForSuccessContains method");

		return isUpdateProfilePopupForSuccessContains;
	}

	public void clickOnOkButton() {
		log.info("Starting of clickOnOkButton method");

		try {
			this.clickOnWebElement(btnOk);
		} catch (Exception e) {
			this.clickOnElement(btnOk);
		}

		log.info("Ending of clickOnOkButton method");
	}

	public String getOldPasswordValidationText() {
		log.info("Starting of getOldPasswordValidationText method");
		log.info("Ending of getOldPasswordValidationText method");

		return getText(txtOldPasswordValidation);
	}

	public String getNewPasswordValidationText() {
		log.info("Starting of getNewPasswordValidationText method");
		log.info("Ending of getNewPasswordValidationText method");

		return getText(txtNewPasswordValidation);
	}

	public String getConfirmPasswordValidationText() {
		log.info("Starting of getConfirmPasswordValidationText method");
		scrollDown(500);
		log.info("Ending of getConfirmPasswordValidationText method");

		return getText(txtConfirmPasswordValidation);
	}

	public boolean isUpdateProfilePopupForFailureContains() {
		log.info("Starting of isUpdateProfilePopupForFailureContains method");

		boolean isUpdateProfilePopupForFailureContains = false;

		if (isDisplayed(lblUpdateProfile) && isDisplayed(txtValidationInUpateProfile) && isDisplayed(btnOk)
				&& isDisplayed(iconClose)) {
			isUpdateProfilePopupForFailureContains = true;
		}

		log.info("Ending of isUpdateProfilePopupForFailureContains method");

		return isUpdateProfilePopupForFailureContains;
	}

	public String getInvalidPasswordValidationText() {
		log.info("Starting of getInvalidPasswordValidationText method");

		this.scrollDown(-500);

		log.info("Ending of getInvalidPasswordValidationText method");

		return getText(txtValidationInValidPassword);
	}

	public void setOldPassWordWithWhiteSpaces(String value) {
		log.info("Starting of setOldPassWordWithWhiteSpaces method");

		this.implicitWait();
		this.txtBoxOldPassword.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		int i = Integer.parseInt(value);
		if (i >= 6) {
			for (int j = 1; j <= i; j++) {
				txtBoxOldPassword.sendKeys(Keys.SPACE);
			}

		}

		log.info("Ending of setOldPassWordWithWhiteSpaces method");
	}

	public void setNewPasswordWithWhiteSpaces(String value) {
		log.info("Starting of setNewPasswordWithWhiteSpaces method");

		this.implicitWait();
		this.txtBoxNewPassword.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		int i = Integer.parseInt(value);
		if (i >= 6) {
			for (int j = 1; j <= i; j++) {
				txtBoxNewPassword.sendKeys(Keys.SPACE);
			}
		}

		log.info("Ending of setNewPasswordWithWhiteSpaces method");
	}

	public void clickOnEyeIcon() {
		log.info("Starting of clickOnEyeIcon method");

		try {
			this.clickOnWebElement(iconEye);
		} catch (Exception e) {
			this.clickOnElement(iconEye);
		}

		log.info("Ending of clickOnEyeIcon method");
	}

	public String getOldPasswordText() {
		log.info("Starting of getOldPasswordText method");

		this.txtBoxOldPassword.click();

		log.info("Ending of getOldPasswordText method");

		return getText(txtBoxOldPassword);
	}

	public boolean isEyeIconInHiddenMode() {
		log.info("Starting of isEyeIconInHiddenMode method");
		log.info("Ending of isEyeIconInHiddenMode method");

		return isDisplayed(iconEyeUnHiddenMode);
	}

}
