package com.dupr.pages.profile;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import com.dupr.pages.DUPRLoginPage;

public class EditProfilePage extends DUPRBaseAutomationPage {

	private static final Logger log = LogManager.getLogger(DUPRLoginPage.class);

	@B2BFindBy(xpath = "//button[@aria-label='Open settings']")
	private WebElement mnuOpenSettings;

	@B2BFindBys(@B2BFindBy(xpath = "//div[@class='text-dark_blue']"))
	private List<WebElement> lstProfileOptions;

	@B2BFindBy(xpath = "//div[text()='Edit Profile']")
	private WebElement btnEditProfile;

	@B2BFindBy(xpath = "//h3[text()='Edit Profile']")
	private WebElement lblEditProfile;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiGrid-root MuiGrid-container')]/descendant::h2")
	private WebElement lblPlayerName;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiBox-root')]//span[contains(@class,'MuiButtonBase-root MuiIconButton-root MuiIconButton-colorPrimary MuiIconButton-sizeMedium')]/span")
	private WebElement iconCamera;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiBox-root')]/button[text()='View Public Profile']")
	private WebElement btnViewPublicProfile;

	@B2BFindBy(xpath = "//button[text()='Profile']")
	private WebElement tabProfile;

	@B2BFindBy(xpath = "//h5[text()='First Name']/../following-sibling::div//input")
	private WebElement txtBoxFirstName;

	@B2BFindBy(xpath = "//h5[text()='First Name']/../following-sibling::div//p")
	private WebElement txtValidationFullName;

	@B2BFindBy(xpath = "//h5[text()='Address']/../following-sibling::div//input")
	private WebElement txtBoxAddress;

	@B2BFindBys(@B2BFindBy(xpath = "//li[contains(@class,'MuiListItem-gutters MuiListItem-divider')]/*/*/span"))
	private List<WebElement> lstAddress;

	@B2BFindBy(xpath = "//button[text()='Save']")
	private WebElement btnSave;

	@B2BFindBy(xpath = "//h4[@id='customized-dialog-title']")
	private WebElement lblUpdateProfile;

	// @B2BFindBy(xpath = "//h6[text()='Please enter your street address or city
	// name']")
	@B2BFindBy(xpath = "//h6[text()='Invalid parameters']")
	private WebElement lblInvalidAddressValidation;

	@B2BFindBy(xpath = "//button[text()='ok']")
	private WebElement btnOk;

	@B2BFindBy(xpath = "//button[text()='OK']")
	private WebElement btnOK;

	@B2BFindBy(xpath = "//h4[@id='customized-dialog-title']/button")
	private WebElement iconClose;

	@B2BFindBy(xpath = "//div[@class='MuiBox-root css-0']/p")
	private WebElement txtValidationStreetAddress;

	@B2BFindBy(xpath = "//h2[text()='Congratulations!']")
	private WebElement txtValidationCongratulations;

	@B2BFindBy(xpath = "//h5[text()='Birth Date']/../following-sibling::div//input")
	private WebElement txtBoxBirthDate;

	@B2BFindBy(xpath = "//button[@aria-label='calendar view is open, switch to year view']")
	private WebElement ddYear;
	
	@B2BFindBy(xpath = "//button[@title='Next month']")
	private WebElement iconNextMonth;

	@B2BFindBy(xpath = "//h5[text()='Birth Date']/../following-sibling::div//p")
	private WebElement txtValidationBirthDate;

	@B2BFindBy(xpath = "//h4[@id='customized-dialog-title']")
	private WebElement lblReviewPolicies;

	@B2BFindBy(xpath = "//h4[@id='customized-dialog-title']/following-sibling::div/label/span/input[@type='checkbox']")
	private WebElement chkReviewPolicies;

	@B2BFindBy(xpath = "//h5[text()='DUPR ID']/../following-sibling::div//input")
	private WebElement txtBoxDuprId;

	@B2BFindBy(xpath = "//h5[text()='Gender']/../following-sibling::div/div/div")
	private WebElement ddGender;

	@B2BFindBys(@B2BFindBy(xpath = "(//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')])[2]/li"))
	private List<WebElement> lstGender;

	@B2BFindBy(xpath = "//h5[text()='Default Rating']/../following-sibling::div//label//input[@value='DOUBLES']")
	private WebElement rdoDoublesStatus;

	@B2BFindBy(xpath = "//h5[text()='Default Rating']/../following-sibling::div//label//input/..")
	private WebElement rdoDoubles;

	@B2BFindBy(xpath = "//h5[text()='Default Rating']/../following-sibling::div//label/following-sibling::label//input/..")
	private WebElement rdoSingles;

	@B2BFindBy(xpath = "//h5[contains(text(),'Phone')]/../following-sibling::div//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedStart')]")
	private WebElement txtBoxPhoneNumber;

	@B2BFindBy(xpath = "//h5[contains(text(),'Phone')]/../following-sibling::div//div[contains(@class,'MuiInputAdornment-positionStart')]//div[@class='MuiBox-root css-0']")
	private WebElement btnCountryCode;

	@B2BFindBys(@B2BFindBy(xpath = "//div[contains(@class,'MuiPopover-root  MuiModal-root')]//ul/li/div/following-sibling::span[@class='country-name']"))
	private List<WebElement> lstCountryNames;

	@B2BFindBy(xpath = "//h4[@id='customized-dialog-title']")
	private WebElement lblVerifyYourMobileNumber;

	@B2BFindBy(xpath = "//h4[text()='Enter your OTP']")
	private WebElement lblEnterYourOTP;

	@B2BFindBy(xpath = "//input[@aria-label='Please enter verification code. Character 1']")
	private WebElement txtBoxOTPFirst;

	@B2BFindBy(xpath = "//button[text()='Resend Code']")
	private WebElement btnResendCode;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiBox-root')]//p[text()='An OTP was sent to your new number!']")
	private WebElement txtValidationOTPResend;

	@B2BFindBy(xpath = "//div[contains(@class, 'MuiDialogActions-root MuiDialogActions-spacing')]/button[text()='Verify Now']")
	private WebElement btnVerifyNow;

	@B2BFindBy(xpath = "//p[text()='Mobile Successfully Verified.']")
	private WebElement txtPhoneNumberVerified;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiBox-root')]/div/following-sibling::div/following-sibling::div/*[local-name()='svg']")
	private WebElement iconPhoneNumberVerified;

	@B2BFindBy(xpath = "//div[@class='MuiBox-root css-t91h8u']/p")
	private WebElement txtValidationIncorrectOTP;

	@B2BFindBy(xpath = "//h5[text()='Dominant Hand']/../following-sibling::div/div/div")
	private WebElement ddDominantHand;

	@B2BFindBys(@B2BFindBy(xpath = "(//div[contains(@class,'MuiPaper-rounded MuiPaper-elevation8 MuiPopover-paper')])[2]//ul[contains(@class,'MuiList-padding MuiMenu-list')]/li"))
	private List<WebElement> lstDominantHandOptions;

	@B2BFindBy(xpath = "//h5[text()='Paddle Brand']/../following-sibling::div//input")
	private WebElement txtBoxPaddleBrand;

	@B2BFindBy(xpath = "//h5[text()='Shoe Brand']/../following-sibling::div//input")
	private WebElement txtBoxShoeBrand;

	@B2BFindBy(xpath = "//h5[text()='Apparel Brand']/../following-sibling::div//input")
	private WebElement txtBoxApparelBrand;

	@B2BFindBy(xpath = "//h5[text()='Preferred Ball']/../following-sibling::div//input")
	private WebElement txtBoxPrefferedBall;

	@B2BFindBy(xpath = "//h5[text()='Preferred Side']/../following-sibling::div/div/div")
	private WebElement ddPreferredSide;

	@B2BFindBys(@B2BFindBy(xpath = "(//div[contains(@class,'MuiMenu-root MuiModal-root')])[2]//ul/li"))
	private List<WebElement> lstPreferredSideOptions;

	public EditProfilePage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public void clickOnOpenSettingMenu() {
		log.info("Starting of clickOnOpenSettingMenu method");

		clickOnElement(mnuOpenSettings);

		log.info("Ending of clickOnOpenSettingMenu method");
	}

	public boolean isProfileDropDownContains() {
		log.info("Starting of isProfileDropDownContains method");

		boolean isProfileDropDownContains = false;

		for (WebElement profileOption : lstProfileOptions) {

			if (isDisplayed(profileOption)) {
				isProfileDropDownContains = true;
			}
		}

		log.info("Ending of isProfileDropDownContains method");

		return isProfileDropDownContains;
	}

	public void clickOnEditProfileButton() {
		log.info("Starting of clickOnEditProfileButton method");

		clickOnElement(btnEditProfile);

		log.info("Ending of clickOnEditProfileButton method");
	}

	public boolean isEditProfilePageContains() {
		log.info("Starting of isEditProfilePageContaiins method");

		boolean isEditProfilePageContains = false;

		if (isDisplayed(lblEditProfile) && isDisplayed(lblPlayerName) && isDisplayed(iconCamera)
				&& isDisplayed(btnViewPublicProfile) && tabProfile.isEnabled() && isDisplayed(txtBoxFirstName)
				&& isDisplayed(txtBoxAddress) && isDisplayed(txtBoxBirthDate)) {
			isEditProfilePageContains = true;
		}

		log.info("Ending of isEditProfilePageContaiins method");

		return isEditProfilePageContains;
	}

	public boolean isProfileTabContains() {
		log.info("Starting of isProfileTabContains method");

		boolean isProfileTabContains = false;

		System.out.println(isDisplayed(txtBoxFirstName));
		System.out.println(isDisplayed(txtBoxAddress));
		System.out.println(isDisplayed(txtBoxBirthDate));
		System.out.println(isDisplayed(txtBoxPhoneNumber));
		System.out.println(isDisplayed(btnCountryCode));
		System.out.println(isDisplayed(rdoDoubles));
		System.out.println(isDisplayed(txtBoxDuprId));
		System.out.println(isDisplayed(ddDominantHand));
		System.out.println(isDisplayed(txtBoxPaddleBrand));
		System.out.println(isDisplayed(txtBoxShoeBrand));
		System.out.println(isDisplayed(txtBoxApparelBrand));
		System.out.println(isDisplayed(txtBoxPrefferedBall));
		System.out.println(isDisplayed(ddPreferredSide));

		if (isDisplayed(txtBoxFirstName) && isDisplayed(txtBoxAddress) && isDisplayed(txtBoxBirthDate)
				&& isDisplayed(txtBoxPhoneNumber) && isDisplayed(btnCountryCode) && isDisplayed(rdoDoubles)
				&& isDisplayed(txtBoxDuprId) && isDisplayed(ddDominantHand) && isDisplayed(txtBoxPaddleBrand)
				&& isDisplayed(txtBoxShoeBrand) && isDisplayed(txtBoxApparelBrand) && isDisplayed(txtBoxPrefferedBall)
				&& isDisplayed(ddPreferredSide)) {
			isProfileTabContains = true;
		}

		log.info("Ending of isProfileTabContains method");

		return isProfileTabContains;
	}

	public void setFullName(String fullName) {
		log.info("Starting of setFullName method");

		clickOnWebElement(txtBoxFirstName);
		this.txtBoxFirstName.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		sendKeys(txtBoxFirstName, fullName);

		log.info("Ending of setFullName method");
	}

	public String getFullNameValidationText() {
		log.info("Starting of getFullNameValidationText method");
		log.info("Ending of getFullNameValidationText method");

		return getText(txtValidationFullName);
	}

	public void setAddress(String stateOrCountryName, String Address) {
		log.info("Starting of setAddress method");

		clickOnWebElement(txtBoxAddress);
		this.txtBoxAddress.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		sendKeys(txtBoxAddress, stateOrCountryName);

		hardWait(3);
		for (WebElement country : lstAddress) {

			if (getText(country).equals(Address)) {
				log.debug("Country: " + getText(country));
				log.debug("Address: " + Address);

				elementClick(country);
				break;
			}
		}
		log.info("Ending of setAddress method");
	}

	public boolean isSaveEnabled() {
		log.info("Starting of isSaveEnabled method");

		boolean buttonStatus = false;
		try {
			hardWait(1);
			if (btnSave.isEnabled()) {
				buttonStatus = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("Ending of isSaveEnabled method");

		return buttonStatus;
	}

	public void clickOnSaveButton() {
		log.info("Starting of clickOnSaveButton method");

		scrollIntoView(btnSave);
		clickOnWebElement(btnSave);

		log.info("Ending of clickOnSaveButton method");
	}

	public boolean isUpdateProfilePopupContains() {
		log.info("Starting of isUpdateProfilePopupContains method");

		boolean isUpdateProfilePopupContains = false;

		if (isDisplayed(lblUpdateProfile) && isDisplayed(lblInvalidAddressValidation) && isDisplayed(btnOk)
				&& isDisplayed(iconClose)) {
			isUpdateProfilePopupContains = true;
		}

		log.info("Ending of isUpdateProfilePopupContains method");

		return isUpdateProfilePopupContains;
	}

	public void clickOnOkButton() {
		log.info("Starting of clickOnOkButton method");

		waitForElementVisibilty(btnOk, 3);
		if (btnOk.isEnabled()) {
			clickOnElement(btnOk);
		}

		log.info("Ending of clickOnOkButton method");
	}

	public void clickOnOKButton() {
		log.info("Starting of clickOnOKButton method");

		if (btnOK.isEnabled()) {
			clickOnElement(btnOK);
		}

		log.info("Ending of clickOnOKButton method");
	}

	public String getStreetAddresValidationText() {
		log.info("Starting of getStreetAddresValidationText method");
		log.info("Ending of getStreetAddresValidationText method");

		return getText(txtValidationStreetAddress);
	}

	public String getCongratulationsLabel() {
		log.info("Starting of getCongratulationsLabel method");
		log.info("Ending of getCongratulationsLabel method");

		return getText(txtValidationCongratulations);
	}

	public void setBirthDate() {
		log.info("Starting of setBirthDate method");

		clickOnWebElement(txtBoxBirthDate);
		hardWait(2);
		clickUsingActionsClass(ddYear);
		hardWait(2);
		clickOnSelectedYear(22);
		
		hardWait(2);
		clickUsingActionsClass(iconNextMonth);
		clickUsingActionsClass(iconNextMonth);
		
		hardWait(2);
		driver.findElement(By.xpath("//button[text()='3']"));

		log.info("Ending of setBirthDate method");
	}

	public String getBirthDateValidationText() {
		log.info("Starting of getBirthDateValidationText method");
		log.info("Ending of getBirthDateValidationText method");

		return getText(txtValidationBirthDate);
	}

	public void clickOnCurrentYear() {

		int currentYearValue = this.getCurrentYear();
		System.out.println(currentYearValue);

		try {
			clickOnElementUsingActionClass(driver.findElement(By.xpath("//button[text()='" + currentYearValue + "']")));
		} catch (Exception e) {
			driver.findElement(By.xpath("//button[text()='" + currentYearValue + "']")).click();
		}
	}

	public void setCurrentDateAsBirthDate() {
		log.info("Starting of setCurrentDateAsBirthDate method");

		clickOnWebElement(txtBoxBirthDate);
		int date = this.getCurrentDate();
		this.hardWait(3);
		clickUsingActionsClass(ddYear);
		this.hardWait(3);
		clickOnCurrentYear();
		this.clickOnCurrentDate(date);

		log.info("Ending of setCurrentDateAsBirthDate method");
	}

	public void setBirthDateWithLessthanMinimumAge() {
		log.info("Starting of setBirthDateWithLessthanMinimumAge method");

		clickOnWebElement(txtBoxBirthDate);
		int date = this.getCurrentDate();

		try {
			hardWait(2);
			clickUsingActionsClass(ddYear);
		} catch (Exception e) {
			hardWait(2);
			clickOnWebElement(ddYear);
		}
		hardWait(2);
		clickOnSelectedYear(1);
		hardWait(2);
		this.clickOnCurrentDate(date);

		log.info("Ending of setBirthDateWithLessthanMinimumAge method");
	}

	public void setBirthDateMinimumAge() {
		log.info("Starting of setBirthDateMinimumAge method");

		clickOnWebElement(txtBoxBirthDate);
		int date = this.getCurrentDate();

		try {
			hardWait(2);
			clickUsingActionsClass(ddYear);
		} catch (Exception e) {
			hardWait(2);
			clickOnWebElement(ddYear);
		}
		hardWait(2);
		clickOnSelectedYear(2);
		hardWait(2);
		this.clickOnCurrentDate(date);

		log.info("Ending of setBirthDateMinimumAge method");
	}

	public boolean isReviewDUPRPoliciesPopupContains() {
		log.info("Starting of isReviewDUPRPoliciesPopupContains method");

		boolean isReviewDUPRPoliciesPopupContains = false;

		if (isDisplayed(lblReviewPolicies) && isDisplayed(btnOK)) {
			isReviewDUPRPoliciesPopupContains = true;
		}

		log.info("Ending of isReviewDUPRPoliciesPopupContains method");

		return isReviewDUPRPoliciesPopupContains;
	}

	public void clickOnReviewPoliciesCheckBox() {
		log.info("Starting of clickOnReviewPoliciesCheckBox method");

		elementClick(chkReviewPolicies);

		log.info("Ending of clickOnReviewPoliciesCheckBox method");
	}

	public boolean isOkButtonEnabled() {
		log.info("Starting of isOkButtonEnabled method");

		boolean status = false;
		if (btnOK.isEnabled()) {
			status = true;
		}

		log.info("Ending of isOkButtonEnabled method");

		return status;
	}

	public boolean isDUPRIDAutoPopulated() {
		log.info("Starting of isOkButtonEnabled method");
		log.info("Ending of isOkButtonEnabled method");

		return txtBoxDuprId.getAttribute("value").isEmpty();
	}

	public void clickOnGenderDropDown() {
		log.info("Starting of clickOnGenderDropDown method");

		clickOnElementUsingActionClass(ddGender);

		log.info("Ending of clickOnGenderDropDown method");
	}

	public void clickOnGenderDropDownListOption() {
		log.info("Starting of clickOnGenderDropDownListOption method");

		String ddText = ddGender.getText();
		log.debug("Gender: " + ddText);

		for (WebElement gender : lstGender) {

			try {

				if (!(gender.getText().equals(ddText))) {
					clickOnWebElement(gender);
					break;
				}
			} catch (Exception e) {
			}
		}

		log.info("Ending of clickOnGenderDropDownListOption method");
	}

	public void clickOnDefaultRatingRadioButtons() {
		log.info("Starting of clickOnDefaultRatingRadioButtons method");

		try {

			if (rdoDoublesStatus.isSelected()) {
				clickOnElement(rdoSingles);
			} else {
				clickOnElement(rdoDoubles);
			}
		} catch (Exception e) {
		}

		log.info("Ending of clickOnDefaultRatingRadioButtons method");
	}

	public void clickOnCountryCodePhoneNumber(String code) {
		log.info("Starting of clickOnCountryCodePhoneNumber method");

		clickOnWebElement(btnCountryCode);

		for (WebElement countryName : lstCountryNames) {

			try {

				if (countryName.getText().equalsIgnoreCase(code)) {
					clickOnWebElement(countryName);
					break;
				}
			} catch (Exception e) {
				clickOnElement(countryName);
				break;
			}
		}

		log.info("Ending of clickOnCountryCodePhoneNumber method");
	}

	public void clearPhoneNumber() {
		log.info("Starting of clearPhoneNumber method");

		clickOnWebElement(txtBoxPhoneNumber);

		int numberLength = txtBoxPhoneNumber.getAttribute("value").length();

		log.debug("Phone number length: " + numberLength);

		try {
			for (int i = 0; i <= numberLength - 1; i++) {
				hardWait(5);
				this.txtBoxPhoneNumber.sendKeys(Keys.BACK_SPACE);
			}
		} catch (Exception e) {
			for (int i = numberLength; i > 0;) {
				hardWait(5);
				this.txtBoxPhoneNumber.sendKeys(Keys.BACK_SPACE);
			}
		}
		log.info("Ending of clearPhoneNumber method");
	}

	public void setValidPhoneNumber(String phoneNumber) {
		log.info("Starting of setValidPhoneNumber method");

		clickOnWebElement(txtBoxPhoneNumber);
		hardWait(2);
		this.txtBoxPhoneNumber.sendKeys(phoneNumber + randomNumber(8));

		log.info("Ending of setValidPhoneNumber method");
	}

	public boolean isVeriyYourMobileNumberPopupContains() {
		log.info("Starting of isVeriyYourMobileNumberPopupContains method");

		boolean isVeriyYourMobileNumberPopupContains = false;
		hardWait(3);

		if (isDisplayed(lblVerifyYourMobileNumber) && isDisplayed(lblEnterYourOTP) && isDisplayed(txtBoxOTPFirst)
				&& isDisplayed(btnResendCode) && !this.btnVerifyNow.isEnabled()) {
			isVeriyYourMobileNumberPopupContains = true;
		}

		log.info("Ending of isVeriyYourMobileNumberPopupContains method");

		return isVeriyYourMobileNumberPopupContains;
	}

	public void setOTP(String otp) {
		log.info("Starting of setOTP method");

		sendKeys(txtBoxOTPFirst, otp);

		log.info("Ending of setOTP method");
	}

	public void clickOnVerifyNowButton() {
		log.info("Starting of clickOnVerifyNowButton method");

		if (this.btnVerifyNow.isEnabled()) {
			clickOnElement(btnVerifyNow);
		}

		log.info("Ending of clickOnVerifyNowButton method");
	}

	public String getMobileVerifiedText() {
		log.info("Starting of getMobileVerifiedText method");
		log.info("Ending of getMobileVerifiedText method");

		return getText(txtPhoneNumberVerified);
	}

	public boolean isVerifiedRightMarkIconDisplayed() {
		log.info("Starting of isVerifiedRightMarkIconDisplayed method");

		boolean iconStatus = false;
		if (isDisplayed(iconPhoneNumberVerified)) {

			iconStatus = true;

		}

		log.info("Ending of isVerifiedRightMarkIconDisplayed method");

		return iconStatus;
	}

	public String getOTPValidationText() {
		log.info("Starting of getOTPValidationText method");
		log.info("Ending of getOTPValidationText method");

		return getText(txtValidationIncorrectOTP);
	}

	public void clickOnCloseIcon() {
		log.info("Starting of clickOnCloseIcon method");

		clickOnElement(iconClose);

		log.info("Ending of clickOnCloseIcon method");
	}

	public void clickOnResendCodeButton() {
		log.info("Starting of clickOnResendCode method");

		clickOnElement(btnResendCode);

		log.info("Ending of clickOnResendCode method");
	}

	public String getOTPResendValidationText() {
		log.info("Starting of getOTPResendValidationText method");
		log.info("Ending of getOTPResendValidationText method");

		return getText(txtValidationOTPResend);
	}

	public void clickOnDominantHandDropDownListOption() {
		log.info("Starting of clickOnDominantHandDropDownListOption method");

		String ddText = ddDominantHand.getText();
		log.debug(ddText);
		hardWait(3);
		clickOnElementUsingActionClass(ddDominantHand);
		for (WebElement dominantHand : lstDominantHandOptions) {
			try {
				if (!(dominantHand.getText().equals(ddText))) {
					clickOnWebElement(dominantHand);
					break;
				}
			} catch (Exception e) {
				clickOnElement(dominantHand);
				break;
			}
		}

		log.info("Ending of clickOnDominantHandDropDownListOption method");
	}

	public void setPaddleBrand(String paddleBrand) {
		log.info("Starting of setPaddleBrand method");

		clickOnElement(txtBoxPaddleBrand);
		this.txtBoxPaddleBrand.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		sendKeys(txtBoxPaddleBrand, paddleBrand + randomNumber(2));

		log.info("Ending of setPaddleBrand method");
	}

	public void setShoeBrand(String shoeBrand) {
		log.info("Starting of setShoeBrand method");

		clickOnElement(txtBoxShoeBrand);
		this.txtBoxShoeBrand.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		sendKeys(txtBoxShoeBrand, shoeBrand + randomNumber(2));

		log.info("Ending of setShoeBrand method");
	}

	public void setApparelBrand(String apparelBrand) {
		log.info("Starting of setApparelBrand method");

		this.txtBoxApparelBrand.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		sendKeys(txtBoxApparelBrand, apparelBrand + randomNumber(2));

		log.info("Ending of setApparelBrand method");
	}

	public void setPreferredBall(String preferredBall) {
		log.info("Starting of setPreferredBall method");

		this.txtBoxPrefferedBall.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		this.hardWait(3);
		sendKeys(txtBoxPrefferedBall, preferredBall + randomNumber(2));

		log.info("Ending of setPreferredBall method");
	}

	public void clickOnPreferredSideDropDownListOption() {
		log.info("Starting of clickOnPreferredSideDropDownListOption method");

		hardWait(3);
		String ddText = ddPreferredSide.getText();
		Actions ac = new Actions(driver);
		hardWait(3);
		ac.moveToElement(ddPreferredSide).click(ddPreferredSide).build().perform();
		hardWait(2);
		for (WebElement preferredSide : lstPreferredSideOptions) {

			try {

				if (!(preferredSide.getText().equals(ddText))) {

					clickOnWebElement(preferredSide);
					break;
				}
			} catch (Exception e) {
				clickOnElement(preferredSide);
				break;
			}
		}
		log.info("Ending of clickOnPreferredSideDropDownListOption method");
	}
}
