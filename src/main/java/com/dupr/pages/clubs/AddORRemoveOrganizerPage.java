package com.dupr.pages.clubs;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class AddORRemoveOrganizerPage extends DUPRBaseAutomationPage {

	private static final Logger log = LogManager.getLogger(AddORRemoveOrganizerPage.class);

	@B2BFindBy(xpath = "//button[contains(text(),'See Club Details')]")
	private WebElement btnSeeClubDetails;

	@B2BFindBy(xpath = "//button[text()='Add Organizer' and contains(@class, 'MuiButton-whitecontained')]")
	private WebElement btnAddOrganizer;

	@B2BFindBy(xpath = "//input[@type='radio']")
	private WebElement rdoBtn;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiToolbar-root MuiToolbar-gutters MuiToolbar-regular')]/button[text()='Add Organizer']")
	private WebElement btnAddOrganizerInAddClubOrg;

	@B2BFindBy(xpath = "//div[@class='MuiBox-root css-0']/button[contains(@class, 'MuiIconButton-sizeSmall')]/*[@viewBox='0 0 10.55 12.004']")
	private List<WebElement> btnDelete;

	@B2BFindBy(xpath = "(//div[@class='MuiBox-root css-0']/button[contains(@class, 'MuiIconButton-sizeSmall')]/*[@viewBox='0 0 10.55 12.004'])[1]")
	private WebElement btnDeleteOrg;

	@B2BFindBy(xpath = "//h3[contains(text(),'Club Organizers')]")
	private WebElement txtClubOrganizer;

	@B2BFindBy(xpath = "//button[contains(text(),'Remove Organizer')]")
	private WebElement btnRemoveOrganizer;

	@B2BFindBy(xpath = "//button[text()='Go Back']")
	private WebElement btnGoBack;

	@B2BFindBy(xpath = "//h4[contains(text(),'Remove Organizer from club?')]/button")
	private WebElement btnCancel;

	@B2BFindBy(xpath = "//h4[contains(text(),'Remove Organizer from club?')]")
	private WebElement txtRemoveOrganizer;

	@B2BFindBy(xpath = "//h6[contains(text(),'Are you sure that you’d like to remove this member from your club Organizers? You may again add the user to the club later if necessary.')]")
	private WebElement txtAreYouSure;

	@B2BFindBy(xpath = "//h2[text()='Add a Club Organizer']")
	private WebElement txtAddClubOrg;

	@B2BFindBy(xpath = "//h2[contains(text(),'Add a Club Organizer')]/parent::div/descendant::input[@id='Search']")
	private WebElement txtSearchBar;

	@B2BFindBy(xpath = "//body/div[@id='root']/div/main/div/div/div[contains(@class, 'MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0')]/div/div[contains(@class,'MuiGrid-spacing-xs-4')]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]/*[1]")
	private WebElement iconEdit;

	@B2BFindBy(xpath = "//h4[text()='Edit Organiser Details']")
	private WebElement lblEditOrganizer;

	// @B2BFindBy(xpath = "//input[@id=':r1o:']")
	@B2BFindBy(xpath = "//h5[contains(text(),'Name')]/parent::div/following-sibling::div//input")
	private WebElement txtEditName;

	// @B2BFindBy(xpath = "//input[@id=':r1s:']")
	@B2BFindBy(xpath = "//h5[contains(text(),'Email')]/parent::div/following-sibling::div//input")
	private WebElement txtEditEmail;

	// @B2BFindBy(xpath = "//input[@id=':r1q:']")
	@B2BFindBy(xpath = "//input[@name='phoneNumber']")
	private WebElement txtEditNumber;

	@B2BFindBy(xpath = "//h4[text()='Edit Organiser Details']/button")
	private WebElement iconCancel;

	@B2BFindBy(xpath = "//button[text()='Save Changes']")
	private WebElement btnSaveChanges;

	@B2BFindBy(xpath = "//p[contains(text(),'Name is required.')]")
	private WebElement txtName;

	@B2BFindBy(xpath = "//p[contains(text(),'Email is required.')]")
	private WebElement txtEmail;

	@B2BFindBy(xpath = "//p[text()='Email is invalid.']")
	private WebElement txtInvalidEmail;

	public AddORRemoveOrganizerPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public void clickOnSeeClubDetailsDropdown() {
		log.info("Starting of clickOnSeeClubDetailsDropdown method");

		elementClick(btnSeeClubDetails);
		this.scrollIntoView(txtClubOrganizer);

		log.info("Ending of clickOnSeeClubDetailsDropdown method");
	}

	public boolean isDeleteOrganizerButtonDisplayed() {
		log.info("Starting of isDeleteOrganizerButtonDisplayed method");

		boolean deleteOrgButtonState = false;

		try {
			if (btnDeleteOrg.isDisplayed() == true) {
				deleteOrgButtonState = true;
			}
		} catch (Exception e) {
			log.debug("***Delete Organizer button is not displayed***");
		}

		log.info("Ending of verifyBtnAddOrganizer method");

		return deleteOrgButtonState;
	}

	public void clickOnAddOrganizerButton() {
		log.info("Starting of clickOnAddOrganizerButton method");

		this.scrollIntoView(txtClubOrganizer);
		this.hardWait(2);
		clickOnWebElement(btnAddOrganizer);

		log.info("Ending of clickOnAddOrganizerButton method");
	}
	
	public boolean isAddOrganizerButtonDisplayed() {
		log.info("Starting of isAddOrganizerButtonDisplayed method");
		log.info("Ending of isAddOrganizerButtonDisplayed method");
		
		return btnAddOrganizer.isDisplayed();
	}

	public boolean isAddOrgPageContains() {
		log.info("Starting of isAddOrgPageContains method");

		boolean isAddOrgPageContains = false;

		if (isDisplayed(txtAddClubOrg) && isDisplayed(btnGoBack) && isDisplayed(txtSearchBar)) {
			isAddOrgPageContains = true;
		}

		log.info("Ending of isAddOrgPageContains method");

		return isAddOrgPageContains;
	}

	public boolean verifyButtonDelete() {
		log.info("Starting of verifyButtonDelete method");

		boolean deleteOrgButtonState = false;

		if (isDisplayed(btnDeleteOrg) == true) {
			deleteOrgButtonState = true;
		}

		log.info("Ending of verifyButtonDelete method");

		return deleteOrgButtonState;
	}

	public void AddingOrganizers() {
		log.info("Starting of AddingOrganizers method");

		this.scrollIntoView(txtClubOrganizer);
		System.out.println(isDeleteOrganizerButtonDisplayed());
		System.out.println(btnDelete.size());
		if (isDeleteOrganizerButtonDisplayed() == false || btnDelete.size() <= 8) {
				
				try {
					if ((btnAddOrganizer.isDisplayed()) == false) {
						System.out.println("**add organizer button not displayed**");
					}

				} catch (Exception e) {
					/* for (int j = btnDelete.size(); j >= 0; j++) { */
						clickOnRemoveOrganizerButton();
				//	}
				}
				for (int i = btnDelete.size(); i < 8; i++) {
					this.hardWait(2);
				clickOnWebElement(btnAddOrganizer);
				elementClick(rdoBtn);
				elementClick(btnAddOrganizerInAddClubOrg);
			}
		}

		log.info("Ending of AddingOrganizers method");
	}

	public void DeletingOrganizers() {
		log.info("Starting of DeletingOrganizers method");

		this.hardWait(2);
		try {
			clickOnWebElement(btnDeleteOrg);
		} catch (Exception e) {
			clickOnElement(btnDeleteOrg);
		}

		log.info("Ending of DeletingOrganizers method");
	}

	public boolean isRemoveOrgPopupContains() {
		log.info("Starting of isRemoveOrgPopupContains method");

		boolean isRemoveOrgPopupContains = false;

		if (isDisplayed(txtRemoveOrganizer) && isDisplayed(txtAreYouSure) && isDisplayed(btnCancel)
				&& isDisplayed(btnGoBack) && isDisplayed(btnRemoveOrganizer)) {

			isRemoveOrgPopupContains = true;
		}

		log.info("Ending of isRemoveOrgPopupContains method");

		return isRemoveOrgPopupContains;
	}

	public String getRemoveOrganizerText() {
		log.info("Starting of getRemoveOrganizerText method");
		log.info("Ending of getRemoveOrganizerText method");

		return getText(txtRemoveOrganizer);
	}

	public String getInvalidEmailText() {
		log.info("Starting of getInvalidEmailText method");
		log.info("Ending of getInvalidEmailText method");

		return getText(txtInvalidEmail);
	}

	public String getAreYouSureText() {
		log.info("Starting of getAreYouSureText method");
		log.info("Ending of getAreYouSureText method");

		return getText(txtAreYouSure);
	}

	public void clickOnGoBackButton() {
		log.info("Starting of clickOnGoBackButton method");

		clickOnElement(btnGoBack);

		log.info("Ending of clickOnGoBackButton method");
	}

	public void clickOnCancelButton() {
		log.info("Starting of clickOnCancelButton method");

		clickOnElement(btnDeleteOrg);
		this.hardWait(1);
		clickOnElement(btnCancel);

		log.info("Ending of clickOnCancelButton method");
	}

	public void clickOnRemoveOrganizerButton() {
		log.info("Starting of clickOnRemoveOrganizerButton method");

		for (int i = 1; i < btnDelete.size() - 1;) {

			this.hardWait(2);
			clickOnElement(btnDeleteOrg);
			this.hardWait(1);
			clickOnElement(btnRemoveOrganizer);
		}
		log.info("Ending of clickOnRemoveOrganizerButton method");
	}

	public void clickOnEditIcon() {
		log.info("Starting of clickOnEditIcon method");

		clickOnElement(iconEdit);

		log.info("Ending of clickOnEditIcon method");
	}

	public boolean isEditOrganizerPopupContains() {
		log.info("Starting of isEditOrganizerPopupContains method");

		boolean isEditOrganizerPopupContains = false;

		if (isDisplayed(btnSaveChanges) && isDisplayed(iconCancel) && isDisplayed(txtEditEmail)
				&& isDisplayed(txtEditName) && isDisplayed(lblEditOrganizer) && (isDisplayed(txtEditNumber))) {
			isEditOrganizerPopupContains = true;
		}
		log.info("Ending of isEditOrganizerPopupContains method");

		return isEditOrganizerPopupContains;
	}

	public String getEditOrganizerText() {
		log.info("Starting of getEditOrganizerText method");
		log.info("Ending of getEditOrganizerText method");

		return getText(lblEditOrganizer);
	}

	public void setOrganizerName() {
		log.info("Starting of setOrganizerName method");

		clickOnElement(txtEditName);
		this.txtEditName.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		this.hardWait(2);
		clickOnElement(txtEditEmail);
		this.txtEditName.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		clickOnElement(btnSaveChanges);

		log.info("Ending of setOrganizerName method");
	}

	public void setInvalidEmail(String orgInvalidEmail) {
		log.info("Starting of setInvalidEmail method");

		clickOnElement(txtEditEmail);
		this.txtEditEmail.sendKeys(orgInvalidEmail);
		clickOnElement(btnSaveChanges);

		log.info("Ending of setInvalidEmail method");
	}

	public String getNameText() {
		log.info("Starting of getNameText method");
		log.info("Ending of getNameText method");

		return getText(txtName);
	}

	public String getEmailText() {
		log.info("Starting of getEmailText method");
		log.info("Ending of getEmailText method");

		return getText(txtEmail);
	}

	public void clickOnEditCancelButton() {
		log.info("Starting of clickOnEditCancelButton method");

		clickOnElement(iconCancel);

		log.info("Ending of clickOnEditCancelButton method");
	}

	public void setOrganizerName(String orgName) {
		log.info("Starting of setOrganizerName method");

		clickOnElement(txtEditName);
		this.txtEditName.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		this.txtEditName.sendKeys(orgName);

		log.info("Ending of setOrganizerName method");
	}

	public void setOrganizerEmail(String orgEmail) {
		log.info("Starting of setOrganizerEmail method");

		clickOnElement(txtEditEmail);
		this.txtEditName.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		this.txtEditEmail.sendKeys(orgEmail);

		log.info("Ending of setOrganizerEmail method");
	}

	public void setOrganizerNumber(String orgNum) {
		log.info("Starting of setOrganizerNumber method");

		clickOnElement(txtEditNumber);
		this.txtEditName.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		this.txtEditNumber.sendKeys(orgNum);

		log.info("Ending of setOrganizerNumber method");
	}

	public void clickOnSaveChangesButton() {
		log.info("Starting of clickOnSaveChangesButton method");

		clickOnElement(btnSaveChanges);

		log.info("Ending of clickOnSaveChangesButton method");
	}
}
