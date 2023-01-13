package com.dupr.pages.signup;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import com.dupr.pages.DUPRLoginPage;

public class DUPRSignUpPage extends DUPRBaseAutomationPage {

	@B2BFindBy(xpath = "(//a[text()='Search Players'])[1]")
	private WebElement lblSearchPlayers;

	@B2BFindBy(xpath = "(//a[text()='Sign Up'])[2]")
	private WebElement btnSignUP;

	@B2BFindBy(xpath = "//h1[contains(@class, 'MuiTypography-gutterBottom') and text()='Claim Your Account']")
	private WebElement lblClaimYourAccount;

	@B2BFindBy(xpath = "(//p[contains(@class,'css-af81j8')])[1]")
	private WebElement txtPlayerName;

	@B2BFindBy(xpath = "//h4[contains(@class,'MuiTypography-h4')]")
	private WebElement txtSearchPlayerName;

	@B2BFindBy(xpath = "//input[@id='Search']")
	private WebElement txtBoxSearch;

	@B2BFindBy(xpath = "//button[text()='Claim Account']")
	private WebElement btnClaimAccount;

	@B2BFindBy(xpath = "//h1[contains(@class,'MuiTypography-h1') and text()='Player Details']")
	private WebElement lblPlayerDetails;

	@B2BFindBy(xpath = "//button[text()='Create an Account']")
	private WebElement btnCreateAnAccount;

	@B2BFindBys(@B2BFindBy(xpath = "//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation3 css-111nsqi'] //button"))
	private List<WebElement> lstClaimAccountButtons;

	@B2BFindBy(xpath = "//h5[text()='Full Name']/parent::div/parent::div//parent::div//input")
	private WebElement txtBoxFullName;

	@B2BFindBy(xpath = "//h5[text()='Birth Date']/parent::div//parent::div/descendant::input")
	private WebElement txtBoxBirthDate;

	@B2BFindBy(xpath = "//h5[text()='Email']/parent::div//parent::div/descendant::input")
	private WebElement txtBoxEmail;

	@B2BFindBy(xpath = "//h5[text()='Confirm Email']/parent::div//parent::div/descendant::input")
	private WebElement txtBoxConfirmEmail;

	@B2BFindBy(xpath = "//input[@value='MALE']")
	private WebElement rdoGender;

	@B2BFindBy(xpath = "//h5[text()='Location (City or Zip)']/parent::div//parent::div[contains(@class,'MuiGrid-grid-lg-6')]/descendant::input")
	private WebElement txtBoxLocation;

	@B2BFindBy(xpath = "//ul[contains(@class,'MuiList-root MuiList-padding')]/li[contains(@class, 'MuiListItem-gutters MuiListItem-divider')]")
	private List<WebElement> lstLocations;

	@B2BFindBy(xpath = "//span[text()='Hyderabad, Telangana, India']")
	private WebElement btnLocationAddress;

	@B2BFindBy(xpath = "//h5[text()='Password']/parent::div//parent::div/descendant::input")
	private WebElement txtBoxPassword;

	@B2BFindBy(xpath = "//h5[text()='Confirm Password']/parent::div//parent::div/descendant::input")
	private WebElement txtBoxConfirmPassword;

	@B2BFindBy(xpath = "//input[contains(@class,'PrivateSwitchBase') and @type='checkbox']")
	private WebElement chkReviewDUPRPolicies;

	@B2BFindBys({ @B2BFindBy(xpath = "//li/div[@role='button']") })
	protected List<WebElement> lstLocationOptions;

	@B2BFindBy(xpath = "//span[text()='Indianapolis, IN, USA']")
	private WebElement lblCountry;

	@B2BFindBy(xpath = "//button[@type='submit']")
	private WebElement btnFinish;

	@B2BFindBy(xpath = "//button[text()='Go Back']")
	private WebElement btnGoBack;

	@B2BFindBy(xpath = "//h5[text()='Full Name']")
	private WebElement lblFullName;

	@B2BFindBy(xpath = "//h4[text()='Please enter your street address or city name']")
	private WebElement lblStreetAddress;

	@B2BFindBy(xpath = "//button[text()='OK']")
	private WebElement btnOK;

	@B2BFindBy(xpath = "//h3[text()='Success']")
	private WebElement lblSuccess;

	@B2BFindBy(xpath = "//h4[text()='Your account has been created. Welcome to DUPR.']")
	private WebElement lblWelcomeToDUPR;

	@B2BFindBy(xpath = "//p[contains(@class,' MuiFormHelperText-filled')]")
	private WebElement txtBirthDateValidationMessage;

	@B2BFindBy(xpath = "//h4[@id='customized-dialog-title']")
	private WebElement lblVerifyYourEmailId;

	@B2BFindBy(xpath = "//button[contains(@class,'MuiButton-whitecontained') and text()='Already Verified']")
	private WebElement btnAlreadyVerified;

	@B2BFindBy(xpath = "//button[contains(@class,'MuiButton-contained') and text()='Resend Link']")
	private WebElement btnResendLink;

	@B2BFindBys(@B2BFindBy(xpath = "//h4[@class='MuiTypography-root MuiTypography-h4 css-12grqhn']"))
	private List<WebElement> lstPlayersNames;

	@B2BFindBy(xpath = "//input[@name='phoneNumber']")
	private WebElement txtBoxMobileNumber;

	@B2BFindBy(xpath = "//p[text()='No numbers or special characters are allowed.']")
	private WebElement txtValidationFullName;

	@B2BFindBy(xpath = "//p[contains(@class, 'css-vbgz6h') and contains(text(), 'players under age 13')]")
	private WebElement chkBoxDUPRReview;

	@B2BFindBy(xpath = "//p[text()='Minimum age is 2 years old.']")
	private WebElement txtDateOfBirthvalidatioon;

	@B2BFindBy(xpath = "//h6[ text()='Singles']/preceding-sibling::div/h2")
	private WebElement txtPlayerSinglesRatings;

	@B2BFindBy(xpath = "//h6[ text()='Doubles']/preceding-sibling::div/h2")
	private WebElement txtPlayerDoublesRatings;

	@B2BFindBy(xpath = "//h6[text()='Singles']/../../h1")
	private WebElement txtPlayerSinglesRating;

	@B2BFindBy(xpath = "//h6[text()='Doubles']/../../h1")
	private WebElement txtPlayerDoublesRating;

	@B2BFindBy(xpath = "//h6[text()='No results found.']")
	private WebElement lblNoResults;

	@B2BFindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1d07y9m']")
	private WebElement iconClose;

	@B2BFindBy(xpath = "(//button[text()='Claim Account'])[1]/ancestor::div[contains(@class, 'MuiGrid-container')]/div/div/h4")
	private WebElement txtPlayerNameInClaimAccountList;

	@B2BFindBys(@B2BFindBy(xpath = "//h6[ text()='Singles']/preceding-sibling::div/h2"))
	private List<WebElement> lstPlayersSinglesRatings;

	@B2BFindBys(@B2BFindBy(xpath = "//h6[ text()='Doubles']/preceding-sibling::div/h2"))
	private List<WebElement> lstPlayersDoublesRatings;

	@B2BFindBy(xpath = "//h6[@class='MuiTypography-root MuiTypography-subtitle1 css-ucitf4']")
	private WebElement lblNoResultsFound;

	/*
	 * @B2BFindBy(xpath = "//h4[@id='customized-dialog-title']") private WebElement
	 * lblVerifyYourEmailId;
	 */

	@B2BFindBy(xpath = "//div[@class='MuiBox-root css-t91h8u']/p[@class='MuiTypography-root MuiTypography-body1 css-1nkxyiu']")
	private WebElement lblEmailSentValidation;

	/*
	 * @B2BFindBy(xpath =
	 * "//div[@class='MuiDialogActions-root MuiDialogActions-spacing css-v0512d']/button[contains(@class,'MuiButton-whitecontained')]"
	 * ) private WebElement btnAlreadyVerified;
	 * 
	 * @B2BFindBy(xpath =
	 * "//div[@class='MuiDialogActions-root MuiDialogActions-spacing css-v0512d']/button[contains(@class,'MuiButton-contained')]"
	 * ) private WebElement btnResendLink;
	 */

	@B2BFindBy(xpath = "//button[text()='Edit']")
	private WebElement btnEdit;

	@B2BFindBy(xpath = "//div[@class='MuiBox-root css-uvat92']/h5")
	private WebElement txtEmail;

	@B2BFindBy(xpath = "//input[contains(@class, 'MuiInputBase-input MuiOutlinedInput-input')]")
	private WebElement txtBoxEmailEnabled;

	@B2BFindBy(xpath = "//p[text()='You must verify your email to access this feature.']")
	private WebElement txtValidationEmail;

	@B2BFindBy(xpath = "//p[text()='A link was sent to your new email!']")
	private WebElement txtLinkSentValidation;

	@B2BFindBy(xpath = "//p[text()='That DUPR account already exists']")
	private WebElement txtAlreadyExistAccountValidation;

	@B2BFindBy(xpath = "//p[text()='Invalid email address']")
	private WebElement txtInvalidEmailValidation;

	@B2BFindBy(xpath = "//h4[text()='Email changed successfully']")
	private WebElement lblEmailChangedSuccessFully;

	@B2BFindBy(xpath = "//button[text()='Logout']")
	private WebElement btnLogout;

	@B2BFindBy(xpath = "//button[text()='Verify']")
	private WebElement btnVerify;

	@B2BFindBy(xpath = "//button[@disabled]")
	private WebElement btnResendLinkInDisabled;

	/*
	 * @B2BFindBy(xpath =
	 * "//div[@class='MuiDialogActions-root MuiDialogActions-spacing css-v0512d']/button"
	 * ) private WebElement btnOK;
	 */

	private static final Logger logger = LogManager.getLogger(DUPRLoginPage.class);

	static String playerName = null;
	public static String singlesRatings;
	public static String doublesRatings;
	public static String searchPlayerName;

	public DUPRSignUpPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public boolean isClaimYourAccountPageContains() {
		logger.info("Starting of isClaimYourAccountPageContains method");

		boolean isClaimYourAccountPageContains = false;

		if (isDisplayed(txtBoxSearch) && isDisplayed(btnGoBack) && isDisplayed(btnCreateAnAccount))
			isClaimYourAccountPageContains = true;

		logger.info("Ending of isClaimYourAccountPageContains method");

		return isClaimYourAccountPageContains;
	}

	public boolean isSignUpPageContains() {
		logger.info("Starting of isSignUpPageContains method");

		boolean isSignUpPageContains = false;

		if (isDisplayed(btnGoBack) && isDisplayed(txtBoxBirthDate) && isDisplayed(txtBoxEmail)
				&& isDisplayed(txtBoxConfirmEmail) && isDisplayed(txtBoxLocation) && isDisplayed(txtBoxMobileNumber))
			isSignUpPageContains = true;

		logger.info("Ending of isSignUpPageContains method");

		return isSignUpPageContains;
	}

	public boolean isFullNameFieldDisplayed() {
		logger.info("Starting of isFullNameFieldDisplayed method");
		logger.info("Ending of isFullNameFieldDisplayed method");

		return txtBoxFullName.isDisplayed();
	}

	public void clickOnSignUpButton() {
		logger.info("Starting of clickOnSignUpButton method");

		this.implicitWait();
		this.btnSignUP.click();

		logger.info("Ending of clickOnSignUpButton method");
	}

	public void clickOnCreateAccountButton() {
		logger.info("Starting of clickOnCreateAccountButton method");

		this.implicitWait();
		this.btnCreateAnAccount.click();

		logger.info("Ending of clickOnCreateAccountButton method");
	}

	public void setMobileNumber(String mobileNumber) {
		logger.info("Starting of setFullName method");

		this.implicitWait();
		txtBoxMobileNumber.click();
		txtBoxMobileNumber.sendKeys(mobileNumber);

		logger.info("Ending of setFullName method");
	}

	public void setFullName(String fullName) {
		logger.info("Starting of setFullName method");

		this.implicitWait();
		clickOnWebElement(txtBoxFullName);
		txtBoxFullName.sendKeys(fullName);

		logger.info("Ending of setFullName method");
	}

	public void setBirthDate(String BirthDate) {
		logger.info("Starting of setBirthDate method");
		this.implicitWait();
		// clickOnElement(txtBirthDateField);
		sendKeys(txtBoxBirthDate, BirthDate);

		logger.info("Starting od setBirthDate method");
	}

	public void searchPlayerName(String name) {
		logger.info("Starting of searchPlayerName method");

		this.implicitWait();
		this.txtBoxSearch.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
		this.txtBoxSearch.sendKeys(name);
		/*
		 * this.impicitWait(); String playerName = ""; for (WebElement player :
		 * lstPlayersNames) { playerName = this.getText(player); break; }
		 * this.sendKeys(txtBoxSearch, playerName); //
		 * this.clickOnWebElement(btnClaimAccount);
		 */
		logger.info("Ending of searchPlayerName method");
	}

	public void setEmail(String email) {
		logger.info("Starting of setEmail method");

		clickOnElement(txtBoxEmail);
		txtBoxEmail.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		txtBoxEmail.sendKeys(email + randomNumber(5) + "@gmail.com");

		logger.info("Ending of setEmail method");
	}

	public void setInvalidEmail(String email) {
		logger.info("Starting of setFullName method");

		this.implicitWait();
		txtBoxEmail.click();
		txtBoxEmail.sendKeys(email);

		logger.info("Ending of setFullName method");
	}

	public void setConfirmEmail() {
		logger.info("Starting of setConfirmEmail method");

		String email = txtBoxEmail.getAttribute("value");
		logger.debug(email);
		this.implicitWait();
		clickOnElement(txtBoxConfirmEmail);
		txtBoxConfirmEmail.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		txtBoxConfirmEmail.sendKeys(email);

		logger.info("Ending of setConfirmEmail method");
	}

	public void clickOnGenderRadioButton() {
		logger.info("Starting od clickOnGenderRadioButton method");

		this.implicitWait();
		this.rdoGender.click();

		logger.info("Ending of clickOnGenderRadioButton method");
	}

	public void setInvalidLocation(String location) {
		logger.info("Starting of setInvalidLocation method");

		this.implicitWait();
		clickOnElement(txtBoxLocation);
		txtBoxLocation.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		txtBoxLocation.sendKeys(location);
		hardWait(3);
		try {
			for (WebElement option : lstLocationOptions) {
				if (option.getText().equalsIgnoreCase("India")) {
					option.click();
					break;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Ending of setInvalidLocation method");
	}

	public void setLocation(String location) {
		logger.info("Starting of setLocation method");

		this.implicitWait();
		clickOnElement(txtBoxLocation);
		txtBoxLocation.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		txtBoxLocation.sendKeys(location);
		hardWait(3);
		
		clickOnWebElement(lblCountry);

		logger.info("Ending of setLocation method");
	}

	public void setPassword(String password) {
		logger.info("Starting of setPassword method");

		this.implicitWait();
		txtBoxPassword.click();
		txtBoxPassword.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		txtBoxPassword.sendKeys(password);

		logger.info("Ending of setPassword method");
	}

	public void setConfirmPassword() {
		logger.info("Starting of setConfirmPassword method");

		String password = txtBoxPassword.getAttribute("value");
		logger.debug(password);

		this.implicitWait();
		scrollDown(200);
		txtBoxConfirmPassword.click();
		txtBoxConfirmPassword.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		txtBoxConfirmPassword.sendKeys(password);

		logger.info("Ending of setConfirmPassword method");
	}

	public void clickOnReviewDUPRPoliciesCheckBox() {
		logger.info("Starting od clickOnReviewDUPRPoliciesCheckBox method");

		this.implicitWait();
		scrollIntoView(chkReviewDUPRPolicies);
		this.chkReviewDUPRPolicies.click();

		logger.info("Ending of clickOnReviewDUPRPoliciesCheckBox method");
	}

	public boolean isCreateAccountButtonDisplayed() {
		logger.info("Starting of isCreateAccountButtonDisplayed method");
		this.implicitWait();
		logger.info("Ending of isCreateAccountButtonDisplayed method");

		return isDisplayed(btnCreateAnAccount);
	}

	public boolean isGoBackButtonDisplayed() {
		logger.info("Starting of isGoBackButtonDisplayed method");
		this.implicitWait();
		logger.info("Ending of isGoBackButtonDisplayed method");

		return isDisplayed(btnGoBack);
	}

	public String getPlayerDetailsText() {
		logger.info("Starting of getPlayerDetailsText method");
		this.implicitWait();
		logger.info("Ending of getPlayerDetailsText method");

		return lblPlayerDetails.getText();
	}

	public boolean isFullNameAutoPopulated() {
		logger.info("Starting of isFullNameDisplayed method");
		this.implicitWait();
		logger.info("Ending of isFullNameAutoPopulated method");

		return getText(txtBoxFullName).equals(playerName);
	}

	public boolean isFinishButtonEnabled() {
		logger.info("Starting of isFinishButtonEnabled method");

		boolean buttonState = false;
		try {
			if (btnFinish.isEnabled() == true) {
				buttonState = true;
			}
		} catch (Exception e) {
			buttonState = false;
		}

		logger.info("Ending of isFinishButtonEnabled method");

		return buttonState;
	}

	public void clickOnFinishButton() {
		logger.info("Starting of clickOnFinishButton method");

		this.implicitWait();
		this.btnFinish.click();

		logger.info("Ending of clickOnFinishButton method");
	}

	public String getSearchPlayersValidationText() {
		logger.info("Starting of getSearchPlayersValidationText method");
		logger.info("Ending of getSearchPlayersValidationText method");

		return getText(lblSearchPlayers);
	}

	public String getClaimYourAccountText() {
		logger.info("Starting of getClaimYourAccountText method");
		logger.info("Ending of getClaimYourAccountText method");

		return getText(lblClaimYourAccount);
	}

	public void searchWithPlayerName(String strFullName) {
		logger.info("Starting of setFullNameInSearchTextField method ");

		// playerName = getText(txtPlayerName);
		this.implicitWait();
		txtBoxSearch.click();
		this.implicitWait();
		sendKeys(txtBoxSearch, strFullName);

		logger.info("Ending of setFullNameInSearchTextField method ");
	}

	public String getSearchPlayerNameText() {
		logger.info("Starting of getSearchPlayerNameText method ");
		logger.info("Ending of getSearchPlayerNameText method ");

		return getText(txtSearchPlayerName);
	}

	public String clickOnClaimAccountButton() {
		logger.info("Starting of clickOnClaimAccountButton method");
		for (int i = 0; i <= 5; i++) {

			searchPlayerName(randomAlphabet(2));
			try {
				if (btnClaimAccount.isDisplayed() == true) {
					searchPlayerName = txtPlayerNameInClaimAccountList.getText();
					searchPlayerName(searchPlayerName);
					hardWait(2);
					singlesRatings = txtPlayerSinglesRatings.getText();
					doublesRatings = txtPlayerDoublesRatings.getText();
					explicitWait(btnClaimAccount);
					clickOnWebElement(btnClaimAccount);
					break;
				}
				if (lblNoResults.isDisplayed() == true) {
					searchPlayerName(randomAlphabet(2));
				} else if (lblNoResultsFound.isDisplayed() == true) {
					searchPlayerName(randomAlphabet(2));
				} else {
					logger.info("**** results found ****");
				}
			} catch (Exception e) {
				logger.info("****************Claim Account Button is not displayed*****************");
			}
		}
		logger.info("Ending of clickOnClaimAccountButton method");

		return searchPlayerName;

	}

	public void clickOnLocationAddressButton() {
		logger.info("Starting of clickOnLocationAddressButton method");

		this.implicitWait();
		this.clickOnElement(btnLocationAddress);

		logger.info("Ending of clickOnLocationAddressButton method");
	}

	public void setConfirmPassword(String strConfirmPassword) {
		logger.info("Starting of setConfirmPassword method");

		this.implicitWait();
		txtBoxConfirmPassword.click();
		txtBoxConfirmPassword.sendKeys(strConfirmPassword);

		logger.info("Ending of setConfirmPassword method");
	}

	public void selelctReviewDUPRPoliciesCheckBox() {
		logger.info("Starting of selelctReviewDUPRPoliciesCheckBox method");

		this.implicitWait();
		chkReviewDUPRPolicies.click();

		logger.info("Ending of selelctReviewDUPRPoliciesCheckBox method");
	}

	public String getStreetAddressText() {
		logger.info("Starting of selelctReviewDUPRPoliciesCheckBox method");
		logger.info("Ending of selelctReviewDUPRPoliciesCheckBox method");

		return getText(lblStreetAddress);
	}

	public void clickOnOKButton() {
		logger.info("Starting of clickOnOKButton method");

		clickOnElement(btnOK);

		logger.info("Ending of clickOnOKButton method");
	}

	public String getBirthDateValidationMessage() {
		logger.info("Starting of getBirthDateValidationMessage method");
		logger.info("Ending of getBirthDateValidationMessage method");

		return getText(txtBirthDateValidationMessage);
	}

	public String getVerifyYourEmailId() {
		logger.info("Starting of getVerifyYourEmailId method");
		logger.info("Ending of getVerifyYourEmailId method");

		return getText(lblVerifyYourEmailId);
	}

	public String getDateOfBirthValidationMessage() {
		logger.info("Starting of getDateOfBirthValidationMessage method");
		logger.info("Ending of getDateOfBirthValidationMessage method");

		return getText(txtDateOfBirthvalidatioon);
	}

	public boolean isDateOfBirthValidationMessageDisplayed() {

		logger.info("Starting of isDateOfBirthValidationMessageDisplayed method");
		boolean flog = false;
		try {
			if (isDisplayed(txtDateOfBirthvalidatioon)) {
				flog = true;
			}
		} catch (Exception e) {
			flog = false;
		}

		logger.info("Ending of isDateOfBirthValidationMessageDisplayed method");

		return flog;
	}

	public boolean isAlreadyVerifiedButtonDisplayed() {
		logger.info("Starting of isAlreadyVerifiedButtonDisplayed method");
		logger.info("Ending of isAlreadyVerifiedButtonDisplayed method");

		return isDisplayed(btnAlreadyVerified);
	}

	public boolean isResendLinkButtonDisplayed() {
		logger.info("Starting of isResendLinkButtonDisplayed method");
		logger.info("Ending of isResendLinkButtonDisplayed method");

		return isDisplayed(btnResendLink);
	}

	public String getFullNameValidationText() {
		logger.info("Starting of getFullNameValidationText method");

		try {
			System.out.println(txtValidationFullName.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Ending of getFullNameValidationText method");
		scrollDown(100);

		return txtValidationFullName.getText();
	}

	public boolean isDUPRReviewCheckBox() {
		logger.info("Starting of isDUPRReviewCheckBox method");
		this.implicitWait();
		this.scrollDown(700);
		logger.info("Ending of isDUPRReviewCheckBox method");

		return isDisplayed(chkBoxDUPRReview);
	}

	public void setDateOfBirthWithCurrentYear() {
		logger.info("Starting of setDateOfBirthWithCurrentYear method");

		LocalDate date = LocalDate.now();
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("MM/dd/YYYY");
		String text = date.format(formatters);

		logger.debug("Current Year Birthdate: " + text);
		this.txtBoxBirthDate.sendKeys(text);

		logger.info("Ending of setDateOfBirthWithCurrentYear method");
	}

	public void setDateOfBirthWithPreviousYear() {
		logger.info("Starting of setDateOfBirthWithPreviousYear method");

		LocalDate date = LocalDate.now();
		LocalDate previousYear = date.minusYears(1);
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("MM/dd/YYYY");

		String text = previousYear.format(formatters);
		logger.debug("Previous Year Birthdate: " + text);

		this.txtBoxBirthDate.sendKeys(text);

		logger.info("Ending of setDateOfBirthWithPreviousYear method");
	}

	public void setDateOfBirthWithBeforeTwoYear() {
		logger.info("Starting of setDateOfBirthWithBeforeTwoYear method");

		LocalDate date = LocalDate.now();
		LocalDate previousYear = date.minusYears(3);
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("MM/dd/YYYY");

		String text = previousYear.format(formatters);
		logger.debug("Before Two Years Birthdate: " + text);

		this.txtBoxBirthDate.sendKeys(text);

		logger.info("Ending of setDateOfBirthWithBeforeTwoYear method");
	}

	public String getPlayerSinglesRatingInPlayerDashBoard() {
		logger.info("Starting of getPlayerSinglesRatingInPlayerDashBoard method");
		logger.info("Starting of getPlayerSinglesRatingInPlayerDashBoard method");

		return getText(txtPlayerSinglesRating);
	}

	public String getPlayersDoublesRatingInPlayerDashBoard() {
		logger.info("Starting of getPlayersDoublesRatingInPlayerDashBoard method");
		logger.info("Starting of getPlayersDoublesRatingInPlayerDashBoard method");

		return getText(txtPlayerDoublesRating);
	}

	public boolean getPlayerSinglesRating() {
		logger.info("Starting of getPlayerSinglesRating method");

		boolean flag = false;
		this.implicitWait();

		try {
			for (int i = 0; i < lstPlayersSinglesRatings.size() - 1; i++) {
				String Rating = lstPlayersSinglesRatings.get(i).getText();
				if (Rating.equals("NA")) {
					flag = true;
				} else {
					float rating = Float.parseFloat(Rating);
					if (rating >= 0 && rating <= 8.0) {
						flag = true;
						// break;
					}
				}
			}
		} catch (Exception e) {
			flag = false;
		}

		logger.info("Ending of getPlayerSinglesRating method");

		return flag;
	}

	public void clickOnCloseIcon() {
		logger.info("Starting of clickOnCloseIcon method");

		elementClick(iconClose);

		logger.info("Ending of clickOnCloseIcon method");
	}

	public boolean getPlayerDoublesRating() {
		logger.info("Starting of getPlayerDoublesRating method");

		boolean flag = false;
		this.implicitWait();

		try {
			for (int i = 0; i < lstPlayersDoublesRatings.size() - 1; i++) {
				String Rating = lstPlayersDoublesRatings.get(i).getText();
				if (Rating.equals("NA")) {
					flag = true;
				} else {
					float rating = Float.parseFloat(Rating);
					if (rating >= 0 && rating <= 8.0) {
						flag = true;
						// break;
					}
				}
			}
		} catch (Exception e) {
			flag = false;
		}

		logger.info("Ending of getPlayerDoublesRating method");

		return flag;
	}

	public void clickOnAlreadyVerifiedButton() {
		logger.info("Starting of clickOnAlreadyVerifiedButton method");

		clickOnElement(btnAlreadyVerified);

		logger.info("Ending of clickOnAlreadyVerifiedButton method");
	}

	public String getVerifyYourEmailValidationText() {
		logger.info("Starting of getVerifyYourEmailValidationText method");
		logger.info("Ending of getVerifyYourEmailValidationText method");

		return getText(txtValidationEmail);
	}

	public void clickOnEditButton() {
		logger.info("Starting of clickOnEditButton method");

		clickOnElement(btnEdit);

		logger.info("Ending of clickOnEditButton method");
	}

	public void clickOnResendLinkButton() {
		logger.info("Starting of clickOnResendLinkButton method");

		clickOnElement(btnResendLink);

		logger.info("Ending of clickOnResendLinkButton method");
	}

	public String getLinkWasSentValidationText() {
		logger.info("Starting of getLinkWasSentValidationText method");
		logger.info("Ending of getLinkWasSentValidationText method");

		return getText(txtLinkSentValidation);
	}

	public String getAlreadyExistDuprAccountValidationText() {
		logger.info("Starting of getAlreadyExistDuprAccountValidationText method");
		logger.info("Ending of getAlreadyExistDuprAccountValidationText method");

		return getText(txtAlreadyExistAccountValidation);
	}

	public String getInvalidEmailValidationText() {
		logger.info("Starting of getInvalidEmailValidationText method");
		System.out.println(txtInvalidEmailValidation.getText());
		logger.info("Ending of getInvalidEmailValidationText method");

		return getText(txtInvalidEmailValidation);
	}

	public String getlinkSentEmailValidation() {
		logger.info("Starting of getlinkSentEmailValidation method");
		System.out.println("Link Sent Email: " + txtLinkSentValidation.getText());
		logger.info("Ending of getlinkSentEmailValidation method");

		return txtLinkSentValidation.getText();
	}

	public void clickOnEmailTextBox() {
		logger.info("Starting of clickOnEmailTextBox method");

		explicitWait(txtBoxEmailEnabled);
		clickOnElement(txtBoxEmailEnabled);
		this.txtBoxEmailEnabled.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);

		logger.info("Ending of clickOnEmailTextBox method");
	}

	public void setEmailTextBox(String email) {
		logger.info("Starting of setEmailTextBox method");

		clickOnElement(txtBoxEmailEnabled);
		this.txtBoxEmailEnabled.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		sendKeys(txtBoxEmailEnabled, email);

		logger.info("Ending of setEmailTextBox method");
	}

	public void clickOnLogoutButton() {
		logger.info("Starting of clickOnLogoutButton method");

		clickOnElement(btnLogout);

		logger.info("Ending of clickOnLogoutButton method");
	}

	public String getEmailText() {
		logger.info("Starting of getEmailText method");
		logger.info("Starting of getEmailText method");

		return getText(txtEmail);
	}

	public void clickOnVerifyButton() {
		logger.info("Starting of clickOnVerifyButton method");

		try {
			if (btnVerify.isDisplayed() == true) {
				clickOnElement(btnVerify);
			}
		} catch (Exception e) {
			logger.info("Account has been already verified");
		}

		logger.info("Ending of clickOnVerifyButton method");
	}

	public String getSuccessLabel() {
		logger.info("Starting of getSuccessLabel method");
		logger.info("Ending of getSuccessLabel method");

		return getText(lblSuccess);
	}

	public String getWelcomeToDuprText() {
		logger.info("Starting of getWelcomeToDuprText method");
		logger.info("Ending of getWelcomeToDuprText method");

		return getText(lblWelcomeToDUPR);
	}

	public void clickOnGoBackButton() {
		logger.info("Starting of clickOnGoBackButton method");

		clickOnElement(btnGoBack);

		logger.info("Ending of clickOnGoBackButton method");
	}

	public boolean isClaimAccountButtonDisplayed() {
		logger.info("Starting of isClaimAccountButtonDisplayed method");

		boolean isClaimAccountButtonDisplayed = false;

		try {
			if (btnClaimAccount.isDisplayed() == true) {
				isClaimAccountButtonDisplayed = true;
			}
		} catch (Exception e) {
			isClaimAccountButtonDisplayed = false;
		}

		logger.info("Ending of isClaimAccountButtonDisplayed method");

		return isClaimAccountButtonDisplayed;
	}

	public boolean isResendButtonDisplayed() {
		logger.info("Starting of isResendButtonDisplayed method");

		boolean isResendButtonDisplayed = false;

		try {
			if (btnResendLinkInDisabled.isDisplayed() == true) {
				isResendButtonDisplayed = true;
			}
		} catch (Exception e) {
			isResendButtonDisplayed = false;
		}

		logger.info("Ending of isResendButtonDisplayed method");

		return isResendButtonDisplayed;
	}
}
