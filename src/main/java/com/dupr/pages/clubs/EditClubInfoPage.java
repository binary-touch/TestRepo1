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

public class EditClubInfoPage extends DUPRBaseAutomationPage {
	private static final Logger log = LogManager.getLogger(EditClubInfoPage.class);

	@B2BFindBy(xpath = "//button[text()='See Club Details']")
	private WebElement btnSeeClubDetails;

	@B2BFindBy(xpath = "//h3[text()='Contact']/following-sibling::button")
	private WebElement iconEditContact;

	@B2BFindBy(xpath = "//h3[text()='About']/../button")
	private WebElement iconEditAbout;

	@B2BFindBy(xpath = "(//div[contains(@class,'MuiGrid-item MuiGrid-grid-xs-12')]/div[1]/p[contains(@class,'MuiTypography-root MuiTypography-body1')])[1]")
	private WebElement lblAddressInContact;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiGrid-grid-md-5')]//p")
	private WebElement lblEmailInContact;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiGrid-grid-md-5')]//following-sibling::div//p")
	private WebElement lblphoneNumberInContact;

	@B2BFindBy(xpath = "//h4[@id='customized-dialog-title']")
	private WebElement lblEditClubContactInformation;

	@B2BFindBy(xpath = "//button[@aria-label='close']")
	private WebElement iconClose;

	@B2BFindBy(xpath = "//button[text()='Save Changes']")
	private WebElement btnSaveChanges;

	@B2BFindBy(xpath = "//h5[text()='Address']/../following-sibling::div//input[contains(@class,'MuiOutlinedInput-input MuiInputBase-inputAdornedStart') and @name='clubLocationName']")
	private WebElement txtBoxAddress;

	@B2BFindBy(xpath = "//h5[text()='Email']/../following-sibling::div//input[contains(@class,'MuiOutlinedInput-input')]")
	private WebElement txtBoxEmail;

	@B2BFindBy(xpath = "//h5[text()='Phone']/../following-sibling::div//input[contains(@class,'MuiOutlinedInput-input') and@name='clubPhoneNumber']")
	private WebElement txtBoxPhoneNumber;

	@B2BFindBy(xpath = "//h3[text()='Club Organizers']")
	private WebElement lblClubOrganizers;

	@B2BFindBy(xpath = "//h3[text()='About']")
	private WebElement lblAbout;

	@B2BFindBy(xpath = "//button[text()='Show Less']")
	private WebElement btnShowLess;

	@B2BFindBy(xpath = "//p[contains(@class,'Mui-error')]")
	private WebElement txtLocationRequiredValidation;

	@B2BFindBy(xpath = "//h4[@id='customized-dialog-title']")
	private WebElement lblChangeClubName;

	@B2BFindBy(xpath = "//h5[contains(text(),'Club:')]/../following-sibling::div//div/input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')]")
	private WebElement txtBoxClubName;

	@B2BFindBy(xpath = "//button[text()='Cancel']")
	private WebElement btnCancel;

	@B2BFindBy(xpath = "(//div[contains(@class,'MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0')]//h3[contains(@class,'MuiTypography-root MuiTypography-h3')])[1]")
	private WebElement lblClubName;

	@B2BFindBy(xpath = "//h3[contains(text(),'Club')]")
	private WebElement lblClub;

	@B2BFindBy(xpath = "//h3//button[contains(@class,'MuiIconButton-root MuiIconButton-sizeSmall')]")
	private WebElement iconEdit;

	@B2BFindBy(xpath = "//label/span[contains(@class,'MuiIconButton-colorPrimary MuiIconButton-sizeMedium')]")
	private WebElement iconCamera;

	@B2BFindBy(xpath = "//button[contains(text(),'Add Players')]/span")
	private WebElement btnAddPlayers;

	@B2BFindBy(xpath = "//button[contains(text(),'Add a Match')]")
	private WebElement btnAddAMatch;

	@B2BFindBy(xpath = "//div/button[text()='Add Event']")
	private WebElement btnAddEvent;

	@B2BFindBy(xpath = "//div/following-sibling::button[text()='Share']")
	private WebElement btnShare;

	@B2BFindBy(xpath = "//span[text()='Export CSV']")
	private WebElement btnExportCSV;

	@B2BFindBy(xpath = "//input[@id='Search']")
	private WebElement txtBoxSearchField;

	@B2BFindBy(xpath = "//div/button[text()='Members']")
	private WebElement tabMembers;

	@B2BFindBy(xpath = "//div/button[text()='Events']")
	private WebElement tabEvents;

	@B2BFindBy(xpath = "//div/button[text()='Matches']")
	private WebElement tabMatches;

	@B2BFindBy(xpath = "//h3[text()='Contact']")
	private WebElement lblContact;

	@B2BFindBy(xpath = "//button[contains(text(),'OK')]")
	private WebElement btnOk;

	@B2BFindBy(xpath = "//h4[contains(text(),'Success')]")
	private WebElement lblSuccess;

	@B2BFindBys(@B2BFindBy(xpath = "//ul[contains(@class,'MuiList-root MuiList-padding')]/li[contains(@class,'MuiListItem-gutters MuiListItem-divider')]"))
	private List<WebElement> lstAddressOptions;

	@B2BFindBy(xpath = "//h4[@id='customized-dialog-title']")
	private WebElement lblError;

	@B2BFindBy(xpath = "//h4[text()='Invalid email address']")
	private WebElement txtInvalidEmailValidation;

	@B2BFindBy(xpath = "//h3[contains(text(),'About')]/parent::div/button")
	private WebElement IconAbout;

	@B2BFindBy(xpath = "//button[text()='Add Club Description']")
	private WebElement btnAddDescription;

	@B2BFindBy(xpath = "//h4[contains(text(),'Edit Club Description')]")
	private WebElement lblEditClubDescription;

	@B2BFindBy(xpath = "//h5[contains(text(),'Edit your club description in the box below.')]")
	private WebElement lblEditYourClubDescriptionInTheBoxBelow;

	@B2BFindBy(xpath = "//p[contains(text(),'Minimum 10 characters.')]")
	private WebElement lblMinimumTenCharacters;

	@B2BFindBy(xpath = "//div[@class=\"text-editor rdw-editor-main\"]")
	private WebElement txtDescription;

	@B2BFindBy(xpath = "//div[@class='text-editor rdw-editor-main']/div/div/div/div/div/div/span")
	private WebElement txtEditDescription;

	@B2BFindBy(xpath = "//div[@title='Bold']")
	private WebElement ImgBoldText;

	@B2BFindBy(xpath = "//div[@title='Italic']")
	private WebElement ImgItalicText;

	@B2BFindBy(xpath = "//div[@title='Underline']")
	private WebElement ImgUnderlineText;

	@B2BFindBy(xpath = "//h4[contains(@class,'MuiTypography-root MuiTypography-h4')]")
	private List<WebElement> lstDirectors;

	@B2BFindBy(xpath = "//h4[text()='yemeni rial']")
	private WebElement btnYemenirialDirector;

	@B2BFindBy(xpath = "//div[contains(text(),'demo')]/button")
	private WebElement iconEditDirector;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation3')]//h4[contains(@class,'MuiTypography-root MuiTypography-h4')]")
	private List<WebElement> lstDirectorNames;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiBox-root')]/button[contains(@class,'MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium')]/*[contains(@class,'MuiSvgIcon-root MuiSvgIcon-colorPrimary')]")
	private WebElement btnBackInDirectorsPage;

	@B2BFindBy(xpath = "//h4[contains(text(),'Simba')]")
	private WebElement btnSimbaOrganizer;

	@B2BFindBy(xpath = "//div[contains(text(),'Simba')]/button")
	private WebElement iconEditOrganizer;

	@B2BFindBy(xpath = "//button[contains(text(),'Browse Clubs')]")
	private WebElement btnBrowseClubs;

	@B2BFindBy(xpath = "//h3[contains(text(),'Browse Clubs')]")
	private WebElement lblBrowseClubs;

	@B2BFindBy(xpath = "//input[@id='Search']")
	private WebElement txtSearchBar;

	@B2BFindBy(xpath = "//h4[contains(text(),'Jalsa')]")
	private WebElement btnJalsa;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiPaper-rounded MuiPaper-elevation3')]//following-sibling::div//div[contains(@class,'MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2')]//h4")
	private WebElement btnClubName;

	public EditClubInfoPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public boolean isClubPageContains() {
		log.info("Starting of isClubPageContains method");

		boolean isClubPageContains = false;
		this.waitForElementToBeVisible(lblClub);

		if (isDisplayed(lblClub) && isDisplayed(iconEdit) && isDisplayed(iconCamera) && isDisplayed(btnAddEvent)
				&& isDisplayed(btnShare) && isDisplayed(btnAddPlayers) && isDisplayed(btnAddAMatch)
				&& isDisplayed(btnExportCSV) && isDisplayed(tabMembers) && isDisplayed(tabEvents)
				&& isDisplayed(tabMatches) && isDisplayed(btnSeeClubDetails)) {

			isClubPageContains = true;
		}

		log.info("Ending of isClubPageContains method");

		return isClubPageContains;
	}

	public String getContactLabelText() {
		log.info("Starting of getContactLabelText method");
		log.info("Ending of getContactLabelText method");

		return getText(lblContact);
	}

	public String getAboutLabelText() {
		log.info("Starting of getAboutLabelText method");
		log.info("Ending of getAboutLabelText method");

		return getText(lblAbout);
	}

	public String getClubOrganizersText() {
		log.info("Starting of getClubOrganizersText method");
		log.info("Ending of getClubOrganizersText method");

		return getText(lblClubOrganizers);
	}

	public void clickSeeClubDetailsDropdown() {
		log.info("Starting of clickSeeClubDetailsDropdown method");

		this.waitForElementToBeVisible(btnSeeClubDetails);
		elementClick(btnSeeClubDetails);

		log.info("Ending of clickSeeClubDetailsDropdown method");
	}

	public boolean isClubAddressDisplayed() {
		log.info("Starting of isClubAddressDisplayed method");
		log.info("Ending of isClubAddressDisplayed method");

		return lblAddressInContact.isDisplayed();
	}

	public boolean isShowLessOptionDisplayed() {
		log.info("Starting of isShowLessOptionDisplayed method");
		log.info("Ending of isShowLessOptionDisplayed method");

		return btnShowLess.isDisplayed();
	}

	/*
	 * public void clickOnDirectorButton() {
	 * log.info("Starting of clickOnDirectorButton method");
	 * 
	 * elementClick(btnDirector);
	 * 
	 * log.info("Ending of clickOnDirectorButton method"); }
	 */

	public void clickOnEditContactIcon() {
		log.info("Starting of clickOnEditContactIcon method");

		elementClick(iconEditContact);

		log.info("Ending of clickOnEditContactIcon method");
	}

	public boolean isEditClubContactInformationPopupContains() {
		log.info("Starting of isEditClubContactInformationPopupContains method");

		boolean isEditClubContactInformationPopupContains = false;

		if (isDisplayed(txtBoxAddress) && isDisplayed(txtBoxEmail) && isDisplayed(txtBoxPhoneNumber)
				&& isDisplayed(btnSaveChanges)) {

			isEditClubContactInformationPopupContains = true;
		}

		log.info("Ending of isEditClubContactInformationPopupContains method");

		return isEditClubContactInformationPopupContains;
	}

	public String getEditClubContactInformationText() {
		log.info("Starting of getEditClubContactInformationText method");
		log.info("Ending of getEditClubContactInformationText method");

		return getText(lblEditClubContactInformation);
	}

	public void clickOnEditIcon() {
		log.info("Starting of clickOnEditIcon method");

		elementClick(iconEdit);

		log.info("Ending of clickOnEditIcon method");
	}

	public void clickOnShowLessOption() {
		log.info("Starting of clickOnShowLessOption method");

		elementClick(btnShowLess);

		log.info("Ending of clickOnShowLessOption method");
	}

	public boolean isContactLabelDisplayed() {
		log.info("Starting of isContactLabelDisplayed method");

		boolean isContactLabelDisplayed = false;

		try {
			if (isDisplayed(lblContact) == true) {
				isContactLabelDisplayed = true;
			}
		} catch (Exception e) {
			isContactLabelDisplayed = false;
		}

		log.info("Ending of isContactLabelDisplayed method");

		return isContactLabelDisplayed;
	}

	public boolean isAboutLabelDisplayed() {
		log.info("Starting of isAboutLabelDisplayed method");

		boolean isAboutLabelDisplayed = false;

		try {
			if (lblAbout.isDisplayed() == true) {
				isAboutLabelDisplayed = true;
			}
		} catch (Exception e) {
			isAboutLabelDisplayed = false;
		}

		log.info("Ending of isAboutLabelDisplayed method");

		return isAboutLabelDisplayed;
	}

	public boolean isClubOrganizersLabelDisplayed() {
		log.info("Starting of isClubOrganizersLabelDisplayed method");

		boolean isClubOrganizersLabelDisplayed = false;

		try {
			if (lblClubOrganizers.isDisplayed() == true) {
				isClubOrganizersLabelDisplayed = true;
			}
		} catch (Exception e) {
			isClubOrganizersLabelDisplayed = false;
		}

		log.info("Ending of isClubOrganizersLabelDisplayed method");

		return isClubOrganizersLabelDisplayed;
	}

	public boolean isSeeClubDetailsDisplayed() {
		log.info("Starting of isSeeClubDetailsDisplayed method");

		boolean isSeeClubDetailsDisplayed = false;

		try {
			if (btnSeeClubDetails.isDisplayed() == true) {
				isSeeClubDetailsDisplayed = true;
			}
		} catch (Exception e) {
			isSeeClubDetailsDisplayed = false;
		}

		log.info("Ending of isSeeClubDetailsDisplayed method");

		return isSeeClubDetailsDisplayed;
	}

	public boolean isChangeClubNamePopUpContains() {
		log.info("Starting of isChangeClubNamePopUpContains method");

		boolean isClubPageContains = false;

		if (isDisplayed(btnCancel) && isDisplayed(btnSaveChanges) && isDisplayed(txtBoxClubName)
				&& isDisplayed(iconClose)) {

			isClubPageContains = true;
		}

		log.info("Ending of isChangeClubNamePopUpContains method");

		return isClubPageContains;
	}

	public String getChangeClubNameText() {
		log.info("Starting of getChangeClubNameText method");
		log.info("Ending of getChangeClubNameText method");

		return getText(lblChangeClubName);
	}

	public void setClubName(String name) {
		log.info("Starting of setClubName method");

		// this.txtBoxClubName.clear();
		this.txtBoxClubName.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		this.txtBoxClubName.sendKeys(name+"_"+randomNumber(2));

		log.info("Ending of setClubName method");
	}

	public void clickOnSaveChangesButton() {
		log.info("Starting of clickOnSaveChangesButton method");

		elementClick(btnSaveChanges);

		log.info("Ending of clickOnSaveChangesButton method");
	}

	public boolean isSuccessPopUpContains() {
		log.info("Starting of isSuccessPopUpContains method");

		boolean isSuccessPopUpContains = false;

		if (isDisplayed(btnOk) && isDisplayed(iconClose)) {

			isSuccessPopUpContains = true;
		}

		log.info("Ending of isSuccessPopUpContains method");

		return isSuccessPopUpContains;
	}

	public boolean isErrorPopUpContains() {
		log.info("Starting of isSuccessPopUpContains method");

		boolean isSuccessPopUpContains = false;

		if (isDisplayed(btnOk) && isDisplayed(iconClose)) {

			isSuccessPopUpContains = true;
		}

		log.info("Ending of isSuccessPopUpContains method");

		return isSuccessPopUpContains;
	}

	public void clickOnOkButton() {
		log.info("Starting of clickOnOkButton method");

		elementClick(btnOk);

		log.info("Ending of clickOnOkButton method");
	}

	public void clearAddressField() {
		log.info("Starting of clearAddressField method");

		this.txtBoxAddress.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);

		log.info("Ending of clearAddressField method");
	}

	public void clickOnSelectedAddressOption() {
		log.info("Starting of clickOnSelectedAddressOption method");

		for (WebElement address : lstAddressOptions) {
			clickOnWebElement(address);
			break;
		}

		log.info("Ending of clickOnSelectedAddressOption method");
	}

	public void setAddress(String address) {
		log.info("Starting of setAddress method");

		this.txtBoxAddress.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		this.txtBoxAddress.sendKeys(address);
		
		hardWait(2);
		this.clickOnSelectedAddressOption();

		log.info("Ending of setAddress method");
	}

	public String getLocationRequiredValidationText() {
		log.info("Starting of getLocationRequiredValidationText method");
		log.info("Ending of getLocationRequiredValidationText method");

		return getText(txtLocationRequiredValidation);
	}

	public void setEmail(String email) {
		log.info("Starting of setEmail method");

		// this.txtBoxEmail.clear();
		this.txtBoxEmail.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		this.txtBoxEmail.sendKeys(email);

		log.info("Ending of setEmail method");
	}

	public void clearPhoneNumber() {
		log.info("Starting of clearPhoneNumber method");

		clickOnElement(txtBoxPhoneNumber);
		String s = txtBoxPhoneNumber.getAttribute("value");

		int numberLenght = s.length();
		for (int i = 0; i <= numberLenght - 1; i++) {
			hardWait(1);
			this.txtBoxPhoneNumber.sendKeys(Keys.BACK_SPACE);
		}

		log.info("Ending of clearPhoneNumber method");
	}

	public void setPhoneNumber(String number) {
		log.info("Starting of setPhoneNumber method");

		this.txtBoxPhoneNumber.sendKeys(number);

		log.info("Ending of setPhoneNumber method");
	}

	public String getInvalidEmailValidationText() {
		log.info("Starting of getInvalidEmailValidationText method");
		log.info("Ending of getInvalidEmailValidationText method");

		return getText(txtInvalidEmailValidation);
	}

	public String getSuccessLabel() {
		log.info("Starting of getSuccessLabel method");
		log.info("Ending of getSuccessLabel method");

		return getText(lblSuccess);
	}

	public String getErrorLabel() {
		log.info("Starting of getErrorLabel method");
		log.info("Ending of getErrorLabel method");

		return getText(lblError);
	}

	public void clickOnEditAboutUcon() {
		log.info("Starting of clickOnEditAboutUcon method");

		this.scrollDown(8);
		elementClick(IconAbout);

		log.info("Ending of clickOnEditAboutUcon method");
	}

	public boolean isExportCSVButtonDisplayed() {
		log.info("Starting of isExportCSVButtonDisplayed method");
		this.scrollDown(10);
		log.info("Ending of isExportCSVButtonDisplayed method");

		return btnExportCSV.isDisplayed();
	}

	public void clickOnExportCSVButton() {
		log.info("Starting of clickOnExportCSVButton method");

		this.scrollDown(5);
		elementClick(btnExportCSV);
		hardWait(5);

		log.info("Ending of clickOnExportCSVButton method");
	}

	public String getEditClubDescriptionLabel() {
		log.info("Starting of getEditClubDescriptionLabel method");
		log.info("Ending of getEditClubDescriptionLabel method");

		return getText(lblEditClubDescription);
	}

	public String getEditYourClubDescriptionInTheBoxBelowLabel() {
		log.info("Starting of getEditYourClubDescriptionInTheBoxBelowLabel method");
		log.info("Ending of getEditYourClubDescriptionInTheBoxBelowLabel method");

		return getText(lblEditYourClubDescriptionInTheBoxBelow);
	}

	public String getMinimumTenCharactersLabel() {
		log.info("Starting of getMinimumTenCharactersLabel method");
		log.info("Ending of getMinimumTenCharactersLabel method");

		return getText(lblMinimumTenCharacters);
	}

	public void clickOnAddDescriptionButton() {
		log.info("Starting of clickOnAddDescriptionButton method");

		elementClick(btnAddDescription);

		log.info("Ending of clickOnAddDescriptionButton method");
	}

	public boolean isEditClubDescriptionPopUpContains() {
		log.info("Starting of isEditClubDescriptionPopUpContains method");

		boolean isEditClubDescriptionPopUpContains = false;

		if (isDisplayed(lblEditClubDescription) && isDisplayed(lblEditYourClubDescriptionInTheBoxBelow)) {

			isEditClubDescriptionPopUpContains = true;
		}

		log.info("Ending of isEditClubDescriptionPopUpContains method");

		return isEditClubDescriptionPopUpContains;
	}

	public void setEditInfoDescription(String description) {
		log.info("Starting of setEditInfoDescription method");

		this.txtDescription.click();
		this.txtEditDescription.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		this.txtEditDescription.sendKeys(description);

		log.info("Ending of setEditInfoDescription method");
	}

	public void clickOnBoldImageButton() {
		log.info("Starting of clickOnBoldImageButton method");

		this.txtEditDescription.sendKeys(Keys.CONTROL + "a");
		elementClick(ImgBoldText);

		log.info("Ending of clickOnBoldImageButton method");
	}

	public void clickOnItalicImageButton() {
		log.info("Starting of clickOnItalicImageButton method");

		this.txtEditDescription.sendKeys(Keys.CONTROL + "a");
		elementClick(ImgItalicText);

		log.info("Ending of clickOnItalicImageButton method");
	}

	public void clickOnUnderlineImageButton() {
		log.info("Starting of clickOnUnderlineImageButton method");

		this.txtEditDescription.sendKeys(Keys.CONTROL + "a");
		elementClick(ImgUnderlineText);
		hardWait(2);

		this.txtDescription.click();
		hardWait(2);

		log.info("Ending of clickOnUnderlineImageButton method");
	}

	public void selectDirectorFromDirectorsList() {
		log.info("Starting of selectDirectorFromDirectorsList method");

		hardWait(3);
		String s = btnYemenirialDirector.getText();

		for (WebElement director : lstDirectors) {
			if (director.getText().equals(s)) {
				elementClick(director);
				break;
			}
		}
		log.info("Ending of selectDirectorFromDirectorsList method");
	}

	public boolean isDirectorsEditIconDisplayed() {
		log.info("Starting of isDirectorsEditIconDisplayed method");
		log.info("Ending of isDirectorsEditIconDisplayed method");

		return iconEditDirector.isDisplayed();
	}

	public void clickOnBackButtonInDirectorsPage() {
		log.info("Starting of clickOnBackButtonInDirectorsPage method");

		this.waitForElementToBeVisible(btnBackInDirectorsPage);
		elementClick(btnBackInDirectorsPage);

		log.info("Ending of clickOnBackButtonInDirectorsPage method");
	}

	public void clickOnSimbaOrganizerButton() {
		log.info("Starting of clickOnSimbaOrganizerButton method");

		this.waitForElementToBeVisible(btnSimbaOrganizer);
		elementClick(btnSimbaOrganizer);

		log.info("Ending of clickOnItalicImageButton method");
	}

	public void clickOnClubNameButton() {
		log.info("Starting of clickOnClubNameButton method");

		this.waitForElementToBeVisible(btnClubName);
		elementClick(btnClubName);

		log.info("Ending of clickOnClubNameButton method");
	}

	public boolean isOrganizersEditIconDisplayed() {
		log.info("Starting of isOrganizersEditIconDisplayed method");
		log.info("Ending of isOrganizersEditIconDisplayed method");

		return iconEditOrganizer.isDisplayed();
	}

	public void clickOnBrowseClubsButton() {
		log.info("Starting of clickOnBrowseClubsButton method");

		this.waitForElementToBeVisible(btnBrowseClubs);
		elementClick(btnBrowseClubs);

		log.info("Ending of clickOnBrowseClubsButton method");
	}

	public boolean isBrowserClubsLabelDisplayed() {
		log.info("Starting of isBrowserClubsLabelDisplayed method");
		log.info("Ending of isBrowserClubsLabelDisplayed method");

		return lblBrowseClubs.isDisplayed();
	}

	public boolean isSearchBarDisplayed() {
		log.info("Starting of isSearchBarDisplayed method");
		log.info("Ending of isSearchBarDisplayed method");

		return txtSearchBar.isDisplayed();
	}

	public void setClubSearch(String clubName) {
		log.info("Starting of setClubSearch method");

		this.txtSearchBar.click();
		this.txtSearchBar.sendKeys(clubName);
		this.waitForElementToBeVisible(btnJalsa);
		this.btnJalsa.click();

		log.info("Ending of setClubSearch method");
	}

	public boolean isEditClubIsNotDisplayed() {
		log.info("Starting of isEditClubIsNotDisplayed method");
		log.info("Ending of isEditClubIsNotDisplayed method");

		boolean isEditClubDescriptionPopUpContains = false;
		try {
			if (isDisplayed(iconEdit)) {

				System.out.println(isEditClubDescriptionPopUpContains = true);
			}
		} catch (Exception e) {
			System.out.println(isEditClubDescriptionPopUpContains = false);
		}
		return isEditClubDescriptionPopUpContains;

	}

}
