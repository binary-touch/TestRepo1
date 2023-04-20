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

	@B2BFindBys(@B2BFindBy(xpath = "(//div[@class='MuiBox-root css-0']/button[contains(@class, 'MuiIconButton-sizeSmall')]/*[@viewBox='0 0 10.55 12.004'])[2]"))
	private List<WebElement> btnDeleteOrg;

	@B2BFindBy(xpath = "(//div[@class='MuiBox-root css-0']/button[contains(@class, 'MuiIconButton-sizeSmall')]/*[@viewBox='0 0 10.55 12.004'])[2]")
	private WebElement btnDeleteOrganizer;

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

	@B2BFindBy(xpath = "//h6[contains(text(),'Are you sure that you�d like to remove this member from your club Organizers? You may again add the user to the club later if necessary.')]")
	private WebElement txtAreYouSure;

	@B2BFindBy(xpath = "//h2[text()='Add a Club Organizer']")
	private WebElement txtAddClubOrg;

	@B2BFindBy(xpath = "//h2[contains(text(),'Add a Club Organizer')]/parent::div/descendant::input[@id='Search']")
	private WebElement txtSearchBar;

	@B2BFindBy(xpath = "//div[@class='MuiBox-root css-0']/button[contains(@class, 'MuiIconButton-sizeSmall')]/*[@viewBox='0 0 13 13.001']")
	private List<WebElement> iconEdit;

	@B2BFindBy(xpath = "(//div[@class='MuiBox-root css-0']/button[contains(@class, 'MuiIconButton-sizeSmall')]/*[@viewBox='0 0 13 13.001'])[2]")
	private WebElement iconEditOrg;

	@B2BFindBy(xpath = "//h4[text()='Edit Organiser Details']")
	private WebElement lblEditOrganizer;

	@B2BFindBy(xpath = "//h5[contains(text(),'Name')]/parent::div/following-sibling::div//input")
	private WebElement txtEditName;

	@B2BFindBy(xpath = "//h5[contains(text(),'Email')]/parent::div/following-sibling::div//input")
	private WebElement txtEditEmail;

	@B2BFindBy(xpath = "//input[@type='tel']")
	private WebElement txtEditNumber;

	@B2BFindBy(xpath = "//h4[contains(text(),'Edit Organiser Details')]//button")
	private WebElement iconCancel;

	@B2BFindBy(xpath = "//h4[contains(text(),'Edit Director Details')]//button")
	private WebElement iconCancelorg;

	@B2BFindBy(xpath = "//button[text()='Save Changes']")
	private WebElement btnSaveChanges;

	@B2BFindBy(xpath = "//p[contains(text(),'Name is required.')]")
	private WebElement txtName;

	@B2BFindBy(xpath = "//p[contains(text(),'Email is required.')]")
	private WebElement txtEmail;

	@B2BFindBy(xpath = "//p[text()='Invalid email address.']")
	private WebElement txtInvalidEmail;

	public AddORRemoveOrganizerPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public void clickOnSeeClubDetailsDropdown() {
		log.info("Starting of clickOnSeeClubDetailsDropdown method");

		elementClick(btnSeeClubDetails);
		this.scrollDown(300);

		log.info("Ending of clickOnSeeClubDetailsDropdown method");
	}

	public boolean isDeleteOrganizerButtonDisplayed() {
		log.info("Starting of isDeleteOrganizerButtonDisplayed method");

		boolean deleteOrgButtonState = false;

		try {
			for (WebElement btnDeleteOrganizer : btnDeleteOrg)
				if (btnDeleteOrganizer.isDisplayed() == true) {
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
		this.hardWait(3);
		try {
			if (isDisplayed(txtAddClubOrg) && isDisplayed(btnGoBack) && isDisplayed(txtSearchBar)) {
				isAddOrgPageContains = true;
			}
		} catch (Exception e) {
			isAddOrgPageContains = false;
		}

		log.info("Ending of isAddOrgPageContains method");

		return isAddOrgPageContains;
	}

	public void AddingOrganizers() {
		log.info("Starting of AddingOrganizers method");

		try {
			System.out.println(isDeleteOrganizerButtonDisplayed());
			System.out.println(btnDelete.size());
			if (isDeleteOrganizerButtonDisplayed() == false || btnDelete.size() <= 8) {

				try {
					if ((btnAddOrganizer.isDisplayed()) == false) {
						System.out.println("**add organizer button not displayed**");
					}

				} catch (Exception e) {
					clickOnRemoveOrganizerButton();
				}
				for (int i = btnDelete.size(); i < 8; i++) {
					this.hardWait(2);
					clickOnWebElement(btnAddOrganizer);
					this.hardWait(2);
					clickOnWebElement(rdoBtn);
					this.hardWait(2);
					clickOnWebElement(btnAddOrganizerInAddClubOrg);
				}
			}
		} catch (Exception e) {
			for (int i = btnDelete.size(); i < 8; i++) {
				this.hardWait(2);
				clickOnWebElement(btnAddOrganizer);
				clickOnWebElement(rdoBtn);
				clickOnWebElement(btnAddOrganizerInAddClubOrg);
			}

			log.info("Ending of AddingOrganizers method");
		}
	}

	public void DeletingOrganizers() {
		log.info("Starting of DeletingOrganizers method");

		this.hardWait(2);

		for (WebElement deleteButton : btnDeleteOrg) {
			try {
				clickUsingActionsClass(deleteButton);
				break;
			} catch (Exception e) {
				clickOnElement(deleteButton);
				break;
			}
		}

		log.info("Ending of DeletingOrganizers method");
	}

	public boolean isRemoveOrgPopupContains() {
		log.info("Starting of isRemoveOrgPopupContains method");

		boolean isRemoveOrgPopupContains = false;
		try {

			if (txtRemoveOrganizer.isDisplayed() && btnCancel.isDisplayed() && btnGoBack.isDisplayed()
					&& btnRemoveOrganizer.isDisplayed()) {

				isRemoveOrgPopupContains = true;
			}

		} catch (Exception e) {
			isRemoveOrgPopupContains = false;
		}

		log.info("Ending of isRemoveOrgPopupContains method");

		return isRemoveOrgPopupContains;
	}

	public String getClubOrganizerLabelText() {
		log.info("Starting of getClubOrganizerLabelText method");
		log.info("Ending of getClubOrganizerLabelText method");

		return getText(txtClubOrganizer);
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

	public void DeletingOrganizer() {
		log.info("Starting of DeletingOrganizers method");

		this.hardWait(2);

		for (WebElement deletOrgButton : btnDeleteOrg) {
			try {
				mouseHoverAndClick(deletOrgButton);
			} catch (Exception e) {
				clickOnElement(deletOrgButton);
				break;
			}
		}

		log.info("Ending of DeletingOrganizers method");
	}

	public String getAreYouSureText() {
		log.info("Starting of getAreYouSureText method");
		log.info("Ending of getAreYouSureText method");

		return getText(txtAreYouSure);
	}

	public void clickOnGoBackButton() {
		log.info("Starting of clickOnGoBackButton method");

		try {
			clickOnElementUsingActionClass(btnGoBack);
		} catch (Exception e) {
			clickOnWebElement(btnGoBack);

		}

		log.info("Ending of clickOnGoBackButton method");
	}

	public void clickOnCancelButton() {
		log.info("Starting of clickOnCancelButton method");

		this.hardWait(1);
		try {
			clickOnElementUsingActionClass(btnCancel);
		} catch (Exception e) {
			clickOnWebElement(btnCancel);

		}

		log.info("Ending of clickOnCancelButton method");
	}

	public void clickOnRemoveOrganizerButton() {
		log.info("Starting of clickOnRemoveOrganizerButton method");

		this.scrollDown(-150);
		for (int i = 1; i < btnDelete.size() - 1;) {

			try {
				this.hardWait(2);
				DeletingOrganizers();
				this.hardWait(1);
				clickOnElement(btnRemoveOrganizer);
			} catch (Exception e) {
				this.hardWait(2);
				DeletingOrganizers();
				this.hardWait(1);
				clickOnWebElement(btnRemoveOrganizer);
			}
		}

		log.info("Ending of clickOnRemoveOrganizerButton method");
	}

	public void clickOnRemoveOrgButton() {
		log.info("Starting of clickOnRemoveOrgButton method");

		this.scrollDown(-150);
		for (int i = 1; i < 2; i++) {

			try {
				this.hardWait(2);
				DeletingOrganizers();
				this.hardWait(1);
				clickOnElement(btnRemoveOrganizer);
			} catch (Exception e) {
				this.hardWait(2);
				DeletingOrganizers();
				this.hardWait(1);
				clickOnWebElement(btnRemoveOrganizer);
			}
		}

		log.info("Ending of clickOnRemoveOrgButton method");
	}

	public void clickOnRemoveorganizerButton() {
		log.info("Starting of clickOnRemoveorganizerButton method");

		clickOnWebElement(btnRemoveOrganizer);

		log.info("Ending of clickOnRemoveorganizerButton method");
	}

	public void clickOnEditIcon() {
		log.info("Starting of clickOnEditIcon method");

		for (WebElement editIcon : iconEdit) {
			try {
				this.hardWait(2);
				mouseHoverAndClick(iconEditOrg);
			} catch (Exception e) {
				mouseHoverAndClick(iconEditOrg);
			}
			break;
		}

		log.info("Ending of clickOnEditIcon method");
	}

	public boolean isEditOrganizerPopupContains() {
		log.info("Starting of isEditOrganizerPopupContains method");

		boolean isEditOrganizerPopupContains = false;
		try {
			if (isDisplayed(btnSaveChanges) && isDisplayed(txtEditEmail) && isDisplayed(txtEditName)) {
				isEditOrganizerPopupContains = true;
			}
		} catch (Exception e) {
			hardWait(2);
			isEditOrganizerPopupContains = false;
		}

		log.info("Ending of isEditOrganizerPopupContains method");

		return isEditOrganizerPopupContains;
	}

	public String getEditOrganizerText() {
		log.info("Starting of getEditOrganizerText method");
		log.info("Ending of getEditOrganizerText method");

		return getText(lblEditOrganizer);
	}

	public void clearOrganizerNameEmail() {
		log.info("Starting of clearOrganizerNameEmail method");

		clickOnWebElement(txtEditName);
		this.txtEditName.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		this.hardWait(2);
		clickOnElement(txtEditEmail);
		this.txtEditEmail.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		clickOnElement(btnSaveChanges);

		log.info("Ending of clearOrganizerNameEmail method");
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

		try {

			clickUsingActionsClass(iconCancel);
		} catch (Exception e) {
			clickOnElement(iconCancel);
		}

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
		this.txtEditEmail.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		this.txtEditEmail.sendKeys(orgEmail);

		log.info("Ending of setOrganizerEmail method");
	}

	public void setOrganizerNumber(String orgNum) {
		log.info("Starting of setOrganizerNumber method");

		try {
			clickOnElement(txtEditNumber);
			this.txtEditNumber.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
			this.txtEditNumber.sendKeys(orgNum);
		} catch (Exception e) {
		}

		log.info("Ending of setOrganizerNumber method");
	}

	public void clickOnSaveChangesButton() {
		log.info("Starting of clickOnSaveChangesButton method");

		clickOnElement(btnSaveChanges);

		log.info("Ending of clickOnSaveChangesButton method");
	}
}
