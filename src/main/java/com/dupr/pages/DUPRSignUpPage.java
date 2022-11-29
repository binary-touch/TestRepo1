package com.dupr.pages;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BFindBys;
import com.b2b.support.B2BPageFactory;

public class DUPRSignUpPage extends DUPRBaseAutomationPage {

	@B2BFindBy(xpath = "//a[contains(@class,'mt-4') and text()='Search Players']")
	private WebElement lblSearchPlayers;

	@B2BFindBy(xpath = "//a[contains(@class,'MuiButton-containedInherit') and text()='Sign Up']")
	private WebElement btnSignUP;

	@B2BFindBy(xpath = "//h1[@class='MuiTypography-root MuiTypography-h1 MuiTypography-gutterBottom css-1hlv3ti']")
	private WebElement lblClaimYourAccount;

	@B2BFindBy(xpath = "(//p[contains(@class,'css-af81j8')])[1]")
	private WebElement txtPlayerName;

	@B2BFindBy(xpath = "//h4[@class='MuiTypography-root MuiTypography-h4 css-12grqhn']")
	private WebElement txtSearchPlayerName;

	@B2BFindBy(xpath = "//input[@id='Search']")
	private WebElement txtSearchField;

	@B2BFindBy(xpath = "//button[text()='Claim Account']")
	private WebElement btnClaimAccount;

	@B2BFindBy(xpath = "//h1[@class='MuiTypography-root MuiTypography-h1 css-16r2ge5']")
	private WebElement lblPlayerDetails;

	@B2BFindBy(xpath = "//button[text()='Create an Account']")
	private WebElement btnCreateAnAccount;

	@B2BFindBy(xpath = "//h5[text()='Full Name']/parent::div/parent::Div //parent::div //input")
	private WebElement txtFullNameField;

	@B2BFindBy(xpath = "//h5[text()='Birth Date']/parent::div //parent::div[@class='MuiBox-root css-8atqhb']/descendant::input")
	private WebElement txtBirthDateField;

	@B2BFindBy(xpath = "//h5[text()='Email']/parent::div //parent::div[@class='MuiBox-root css-0']/descendant::input")
	private WebElement txtmailField;

	@B2BFindBy(xpath = "//h5[text()='Confirm Email']/parent::div //parent::div[@class='MuiBox-root css-0']/descendant::input")
	private WebElement txtConfirmEmailField;

	@B2BFindBy(xpath = "//input[@value='MALE']")
	private WebElement rdoGender;

	@B2BFindBy(xpath = "//h5[text()='Location (City or Zip)']/parent::Div //parent::div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-lg-6 css-tletg0']/descendant::input")
	private WebElement txtLocationField;

	@B2BFindBy(xpath = "//span[text()='Hyderabad, Telangana, India']")
	private WebElement btnLocationAddress;

	@B2BFindBy(xpath = "//h5[text()='Password']/parent::div //parent::div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-lg-6 css-tletg0']/descendant::input")
	private WebElement txtBoxPassword;

	@B2BFindBy(xpath = "//h5[text()='Confirm Password']/parent::div //parent::div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-lg-6 css-tletg0']/descendant::input")
	private WebElement txtBoxConfirmPassword;

	@B2BFindBy(xpath = "//input[@class='PrivateSwitchBase-input css-1m9pwf3' and @type='checkbox']")
	private WebElement chkReviewDUPRPolicies;

	@B2BFindBys({ @B2BFindBy(xpath = "//li/div[@role='button']") })
	protected List<WebElement> options;

	@B2BFindBy(xpath = "//span[text()='India']")
	private WebElement lblCountry;

	@B2BFindBy(xpath = "//button[@type='submit']")
	private WebElement btnFinish;

	@B2BFindBy(xpath = "//button[text()='Go Back']")
	private WebElement btnGoBack;

	@B2BFindBy(xpath = "//h5[text()='Full Name']")
	private WebElement lblFullName;

	@B2BFindBy(xpath = "//h4[@class='MuiTypography-root MuiTypography-h4 css-22xj42']")
	private WebElement lblStreetAddress;

	@B2BFindBy(xpath = "//button[contains(@class,'css-1971f2t') and text()='OK']")
	private WebElement btnOK;

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

	@B2BFindBy(xpath = "//h5[text()='Birth Date']/parent::div/following-sibling::div//child::button")
	private WebElement iconCalenderBirthdate;

	@B2BFindBy(xpath = "//div[@class='MuiPickersCalendarHeader-label css-1v994a0']/parent::div/following-sibling::button")
	private WebElement DDMonthYear;

	@B2BFindBy(xpath = "//div[@class='MuiPickersCalendarHeader-label css-1v994a0']")
	private WebElement btnMonthYear;

	@B2BFindBys(@B2BFindBy(xpath = "//button[@class='PrivatePickersYear-yearButton css-1hu4nqc']"))
	private List<WebElement> btnYears;

	@B2BFindBy(xpath = "//button[contains(@class,'css-h1vjls') and @title='Previous month']")
	private WebElement iconPrevoiusMonth;

	@B2BFindBy(xpath = "//button[contains(@class,'MuiIconButton-edgeStart') and @title='Next month']")
	private WebElement iconNextMonth;

	@B2BFindBys(@B2BFindBy(xpath = "//button[@class='MuiButtonBase-root MuiPickersDay-root MuiPickersDay-dayWithMargin css-16hcnau']"))
	private List<WebElement> btnDates;

	private static final Logger logger = LogManager.getLogger(DUPRLoginPage.class);
	static String playerName = null;

	public DUPRSignUpPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public void clickOnSignUpButton() {
		logger.info("Starting of clickOnSignUpButton method");

		this.impicitWait();
		this.btnSignUP.click();

		logger.info("Ending of clickOnSignUpButton method");
	}

	public void clickOnCreateAccountButton() {
		logger.info("Starting of clickOnCreateAccountButton method");

		this.impicitWait();
		this.btnCreateAnAccount.click();

		logger.info("Ending of clickOnCreateAccountButton method");
	}

	public void setFullName(String fullName) {
		logger.info("Starting of setFullName method");

		this.impicitWait();
		txtFullNameField.click();
		txtFullNameField.sendKeys(fullName);

		logger.info("Ending of setFullName method");
	}

	public void selectBirthDateFromCalender(String birthyear, String birthMonth, String birthDate) {

		clickOnElement(iconCalenderBirthdate);
		clickOnElement(DDMonthYear);

		for (WebElement year : btnYears) {

			String yearText = getText(year);

			if (yearText.equals(birthyear)) {

				clickOnElement(year);

				break;
			}

		}
		while (true) {

			String monthYearText = getText(btnMonthYear);

			String arr[] = monthYearText.split(" ");

			String mon = arr[0];
			String yr = arr[1];

			if (mon.equalsIgnoreCase(birthMonth) && yr.equalsIgnoreCase(birthyear))

				break;
			else

				clickOnElement(iconPrevoiusMonth);
			// clickOnElement(iconNextMonth);

		}
		for (WebElement date : btnDates) {

			String dateText = getText(date);

			if (dateText.equals(birthDate)) {

				clickOnElement(date);

				break;
			}
		}

	}

	public void setBirthDate(String BirthDate) {
		logger.info("Starting of setBirthDate method");

		clickOnElement(txtBirthDateField);
		sendKeys(txtBirthDateField, BirthDate);

		logger.info("Starting od setBirthDate method");
	}

	public void searchPlayerName() {
		logger.info("Starting of setEmail method");
		this.impicitWait();
		String playerName = "";
		for (WebElement player : lstPlayersNames) {
			playerName = this.getText(player);
			break;
		}
		this.sendKeys(txtSearchField, playerName);
		// this.clickOnWebElement(btnClaimAccount);

		logger.info("Ending of setEmail method");

	}

	public void setEmail(String email) {
		logger.info("Starting of setEmail method");

		clickOnElement(txtmailField);
		txtmailField.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		txtmailField.sendKeys(email + randomNumber(2) + "@gmail.com");

		logger.info("Ending of setEmail method");
	}

	public void setConfirmEmail() {
		logger.info("Starting of setConfirmEmail method");

		String email = txtmailField.getAttribute("value");
		logger.debug(email);
		this.impicitWait();
		clickOnElement(txtConfirmEmailField);
		txtConfirmEmailField.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		txtConfirmEmailField.sendKeys(email);

		logger.info("Ending of setConfirmEmail method");
	}

	public void clickOnGenderRadioButton() {
		logger.info("Starting od clickOnGenderRadioButton method");

		this.impicitWait();
		this.rdoGender.click();

		logger.info("Ending of clickOnGenderRadioButton method");
	}

	public void setInvalidLocation(String location) {
		logger.info("Starting of setInvalidLocation method");

		this.impicitWait();
		clickOnElement(txtLocationField);
		txtLocationField.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		txtLocationField.sendKeys(location);
		hardWait(3);
		try {
			for (WebElement option : options) {
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

		this.impicitWait();
		clickOnElement(txtLocationField);
		txtLocationField.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		txtLocationField.sendKeys(location);
		hardWait(3);
		try {
			for (WebElement option : options) {
				option.click();
				break;
			}

		} catch (Exception e) {
			clickOnElement(lblCountry);
		}

		logger.info("Ending of setLocation method");
	}

	public void setPassword(String password) {
		logger.info("Starting of setPassword method");

		this.impicitWait();
		txtBoxPassword.click();
		txtBoxPassword.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		txtBoxPassword.sendKeys(password);

		logger.info("Ending of setPassword method");
	}

	public void setConfirmPassword() {
		logger.info("Starting of setConfirmPassword method");

		String password = txtBoxPassword.getAttribute("value");
		logger.debug(password);

		this.impicitWait();
		scrollDown(200);
		txtBoxConfirmPassword.click();
		txtBoxConfirmPassword.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		txtBoxConfirmPassword.sendKeys(password);

		logger.info("Ending of setConfirmPassword method");
	}

	public void clickOnReviewDUPRPoliciesCheckBox() {
		logger.info("Starting od clickOnReviewDUPRPoliciesCheckBox method");

		this.impicitWait();
		scrollIntoView(chkReviewDUPRPolicies);
		this.chkReviewDUPRPolicies.click();

		logger.info("Ending of clickOnReviewDUPRPoliciesCheckBox method");
	}

	public boolean isCreateAccountButtonDisplayed() {
		logger.info("Starting of isCreateAccountButtonDisplayed method");

		this.impicitWait();

		logger.info("Ending of isCreateAccountButtonDisplayed method");

		return isDisplayed(btnCreateAnAccount);
	}

	public boolean isGoBackButtonDisplayed() {
		logger.info("Starting of isGoBackButtonDisplayed method");

		this.impicitWait();

		logger.info("Ending of isGoBackButtonDisplayed method");

		return isDisplayed(btnGoBack);
	}

	public String getPlayerDetailsText() {
		logger.info("Starting of getPlayerDetailsText method");

		this.impicitWait();

		logger.info("Ending of getPlayerDetailsText method");

		return getText(lblPlayerDetails);
	}

	public boolean isFullNameAutoPopulated() {
		logger.info("Starting of isFullNameDisplayed method");

		this.impicitWait();

		logger.info("Ending of isFullNameAutoPopulated method");

		return getText(txtFullNameField).equals(playerName);
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

		this.impicitWait();
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
		this.impicitWait();
		txtSearchField.click();
		this.impicitWait();
		sendKeys(txtSearchField, strFullName);

		logger.info("Ending of setFullNameInSearchTextField method ");
	}

	public String getSearchPlayerNameText() {
		logger.info("Starting of getSearchPlayerNameText method ");
		logger.info("Ending of getSearchPlayerNameText method ");

		return getText(txtSearchPlayerName);
	}

	public void clickOnClaimAccountButton() {
		logger.info("Starting od clickOnClaimAccountButton method");

		this.impicitWait();
		this.btnClaimAccount.click();

		logger.info("Ending of clickOnClaimAccountButton method");
	}

	public void clickOnLocationAddressButton() {
		logger.info("Starting of clickOnLocationAddressButton method");

		this.impicitWait();
		this.clickOnElement(btnLocationAddress);

		logger.info("Ending of clickOnLocationAddressButton method");
	}

	public void setConfirmPassword(String strConfirmPassword) {
		logger.info("Starting of setConfirmPassword method");

		this.impicitWait();
		txtBoxConfirmPassword.click();
		txtBoxConfirmPassword.sendKeys(strConfirmPassword);

		logger.info("Ending of setConfirmPassword method");
	}

	public void selelctReviewDUPRPoliciesCheckBox() {
		logger.info("Starting of selelctReviewDUPRPoliciesCheckBox method");

		this.impicitWait();
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

	public boolean isDisplayedAlreadyVerifiedButton() {
		logger.info("Starting of isDisplayedAlreadyVerifiedButton method");
		logger.info("Ending of isDisplayedAlreadyVerifiedButton method");

		return isDisplayed(btnAlreadyVerified);
	}

	public boolean isDisplayedResendLinkButton() {
		logger.info("Starting of isDisplayedResendLink method");
		logger.info("Ending of isDisplayedResendLink method");

		return isDisplayed(btnResendLink);
	}

}
