package com.dupr.pages.events;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class AddParticipantsInBracketsPage extends DUPRBaseAutomationPage {

	private static final Logger log = LogManager.getLogger(AddParticipantsInBracketsPage.class);

	@B2BFindBy(xpath = "//h4[text()='My Brackets']")
	private WebElement ddMyBrackets;

	@B2BFindBy(xpath = "//h3[text()='Brackets']")
	private WebElement lblBrackets;

	@B2BFindBy(xpath = "//h4[contains(@class,'MuiTypography-root MuiTypography-h4 MuiTypography-noWrap')]")
	private List<WebElement> lnkBracketNames;

	@B2BFindBy(xpath = "(//div[contains(@class, 'MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0')])[1]//h3[contains(@class, 'MuiTypography-h3')]")
	private List<WebElement> lstBracketNameInBracketPage;

	@B2BFindBy(xpath = "(//div[contains(@class, 'MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0')])[1]//h4[contains(@class, 'MuiTypography-h4')]")
	private WebElement lblClubNameInBracketPage;

	@B2BFindBy(xpath = "(//div[contains(@class, 'MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0')])[1]//p[contains(@class, 'MuiTypography-body2')]")
	private List<WebElement> lstBracketDetailsInBracketPage;

	@B2BFindBy(xpath = "(//div[contains(@class, 'MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0')])[1]//span[contains(@class, 'MuiChip-label MuiChip-labelSmall')]")
	private WebElement eventStatusinBracketPage;

	@B2BFindBy(xpath = "//button[text()='Add Participants']")
	private WebElement btnAddParticipants;

	@B2BFindBy(xpath = "//*[contains(@class,'MuiSvgIcon-root MuiSvgIcon-colorPrimary MuiSvgIcon-fontSizeMedium')]")
	private WebElement btnBack;

	@B2BFindBy(xpath = "//button[text()='Go Back']")
	private WebElement btnGoBack;

	@B2BFindBy(xpath = "//h2[text()='Add a Bracket Participant']")
	private WebElement lblAddBracket;

	@B2BFindBy(xpath = "//h2[text()='Add a Bracket Participant']/parent::div/child::div//input[@id='Search']")
	private WebElement txtBoxSearchParticipant;

	@B2BFindBy(xpath = "//button[text()='Add Participant']")
	private WebElement btnAddParticipant;

	@B2BFindBy(xpath = "//button[text()='Add Participant' and @disabled]")
	private WebElement btnAddParticipantDisabled;

	@B2BFindBy(xpath = "//input[@type='radio']")
	private WebElement rdoSelectParticipant;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12')]//b[text()='No more results.']")
	private WebElement lblNoResults;

	@B2BFindBy(xpath = "//h4[text()='Club Membership']")
	private WebElement lblClubMember;

	@B2BFindBy(xpath = "//h4[text()='Club Membership']/button[@aria-label='close']")
	private WebElement iconClose;

	@B2BFindBy(xpath = "//span[text()='Yes']")
	private WebElement rdoYes;

	@B2BFindBy(xpath = "//span[text()='No']")
	private WebElement rdoNo;

	@B2BFindBy(xpath = "//button[text()='Cancel']")
	private WebElement btnCancel;

	@B2BFindBy(xpath = "//button[text()='Add']")
	private WebElement btnAdd;

	@B2BFindBy(xpath = "//h2[text()='Add a Bracket Participant']/parent::div//following-sibling::div//div[contains(@class,'MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0')]//div[contains(@class,'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-6')]//h4[contains(@class,'MuiTypography-root MuiTypography-h4')]")
	private WebElement txtParticipantName;

	@B2BFindBy(xpath = "//input[@id='Search']")
	private WebElement txtBoxSearchByName;

	@B2BFindBy(xpath = "//h3[text()='Brackets']")
	private WebElement txtBrackets;

	@B2BFindBy(xpath = "//h5[text()='My Brackets']")
	private WebElement txtMyBrackets;

	@B2BFindBy(xpath = "//button[text()='Browse all Events']")
	private WebElement btnBrowseEvents;

	@B2BFindBy(xpath = "//h3[text()='Brackets']/parent::div//button")
	private WebElement btnBackBrackets;

	@B2BFindBy(xpath = "//span[text()='Export CSV']")
	private WebElement btnExportCSV;

	public AddParticipantsInBracketsPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public void clickOnExportCSVButton() {
		log.info("Starting of clickOnExportCSVButton method");

		this.hardWait(4);
		clickOnWebElement(btnExportCSV);

		log.info("Ending of clickOnExportCSVButton method");
	}

	public void clickOnMyBracketsDropdown() {
		log.info("Starting of clickOnMyBracketsDropdown method");
		this.hardWait(4);
		clickOnWebElement(ddMyBrackets);

		log.info("Ending of clickOnMyBracketsDropdown method");
	}

	public String getBracketsLabel() {
		log.info("Starting of getBracketsLabel method");
		log.info("Ending of getBracketsLabel method");

		return getText(lblBrackets);
	}

	public boolean isAddParticipantButtonDisabled() {
		log.info("Starting of isAddParticipantButtonDisabled method");
		log.info("Ending of isAddParticipantButtonDisabled method");

		return isDisplayed(btnAddParticipantDisabled);
	}

	public void clickOnBracketNameLink() {
		log.info("Starting of clickOnBracketNameLink method");

		for (int i = 1; i < lnkBracketNames.size(); i++) {
			this.hardWait(2);
			driver.findElement(
					By.xpath((("(//h4[contains(@class,'MuiTypography-root MuiTypography-h4 MuiTypography-noWrap')])["
							+ i + "]"))))
					.click();

			this.hardWait(5);
			try {
				if ((isDisplayed(btnAddParticipants) == true)) {
					clickOnElement(btnAddParticipants);
					break;
				}
			} catch (Exception e) {
				clickOnElement(btnBack);
			}
		}

		log.info("Ending of clickOnBracketNameLink method");
	}

	public void clickOnGoBackButton() {
		log.info("Starting of clickOnGoBackButton method");

		clickOnWebElement(btnGoBack);

		log.info("Ending of clickOnGoBackButton method");
	}

	public void searchParticipantByName(String name) {
		log.info("Starting of searchParticipantByName method");

		clickOnWebElement(txtBoxSearchParticipant);

		try {
			this.txtBoxSearchParticipant.sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);

		} catch (Exception e) {
			this.txtBoxSearchParticipant.clear();
		}

		this.txtBoxSearchParticipant.sendKeys(name);
		this.hardWait(2);

		log.info("Ending of searchByName method");
	}

	public String getSearchParticipantResult(String participantName) {
		log.info("Starting of getSearchParticipantResult method");

		String searchPlayerName = driver.findElement(By.xpath(
				"//div[@role='radiogroup']//div[contains(@class, 'MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0')]//h4[text()='"
						+ participantName + "']"))
				.getText();

		log.info("Ending of getSearchParticipantResult method");

		return searchPlayerName;
	}

	public String getParticipantNameFromSearchField() {
		log.info("Starting of getParticipantNameFromSearchField method");
		log.info("Ending of getParticipantNameFromSearchField method");

		return txtBoxSearchParticipant.getAttribute("value");
	}

	public String getNoResultsText() {
		log.info("Starting of getNoResultsText method");
		log.info("Ending of getNoResultsText method");

		return getText(lblNoResults);
	}

	public String getParticipantNameText() {
		log.info("Starting of getParticipantNameText method");
		log.info("Ending of getParticipantNameText method");

		return getText(txtParticipantName);
	}

	public void clickOnSelectParticipantRadioButton() {
		log.info("Starting of clickOnSelectParticipantRadioButton method");

		//this.waitForElementToBeVisible(rdoSelectParticipant);
		clickOnWebElement(rdoSelectParticipant);

		log.info("Ending of clickOnSelectParticipantRadioButton method");
	}

	public boolean isParticipantSelected() {
		log.info("Starting of isParticipantSelected method");
		log.info("Ending of isParticipantSelected method");

		return rdoSelectParticipant.isSelected();
	}

	public boolean isAddParticipantButtonState() {
		log.info("Starting of isAddParticipantButtonState method");
		log.info("Ending of isAddParticipantButtonState method");

		return btnAddParticipant.isEnabled();
	}

	public void clickOnAddParticipantButton() {
		log.info("Starting of clickOnAddParticipantButton method");

		this.waitForElementToBeVisible(btnAddParticipant);
		clickOnWebElement(btnAddParticipant);

		log.info("Ending of clickOnAddParticipantButton method");
	}

	public void clickOnCloseIconInClubMembershipPopup() {
		log.info("Starting of clickOnCloseIconInClubMembershipPopup method");

		clickOnWebElement(iconClose);

		log.info("Ending of clickOnCloseIconInClubMembershipPopup method");
	}

	public String getAddBracketParticipantLabel() {
		log.info("Starting of getAddBracketParticipantLabel method");
		log.info("Ending of getAddBracketParticipantLabel method");

		return getText(lblAddBracket);
	}

	public String getCLubMembershipLabel() {
		log.info("Starting of getCLubMembershipLabel method");
		log.info("Ending of getCLubMembershipLabel method");

		return getText(lblClubMember);
	}

	public void clickOnCancelButtonInClubMembershipPopup() {
		log.info("Starting of clickOnCancelButtonInClubMembershipPopup method");

		clickOnWebElement(btnCancel);

		log.info("Ending of clickOnCancelButtonInClubMembershipPopup method");
	}

	public void clickOnYesRadioButton() {
		log.info("Starting of clickOnYesRadioButton method");

		clickOnWebElement(rdoYes);

		log.info("Ending of clickOnYesRadioButton method");
	}

	public boolean isYesRadioButtonSelected() {
		log.info("Starting of isYesRadioButtonSelected method");
		log.info("Ending of isYesRadioButtonSelected method");

		return rdoYes.getAttribute("value").equals("true");
	}

	public void clickOnNoRadioButton() {
		log.info("Starting of clickOnNoRadioButton method");

		clickOnWebElement(rdoNo);

		log.info("Ending of clickOnNoRadioButton method");
	}

	public boolean isNoRadioButtonSelected() {
		log.info("Starting of isNoRadioButtonSelected method");
		log.info("Ending of isNoRadioButtonSelected method");

		return rdoNo.isSelected();
	}

	public void clickOnAddButtonInClubMembershipPopup() {
		log.info("Starting of InClubMembershipPopup method");

		clickOnWebElement(btnAdd);

		log.info("Ending of InClubMembershipPopup method");
	}

	public boolean isAddBracketParticipantPageContains() {
		log.info("Starting of isAddBracketParticipantPageContains method");

		boolean isAddBracketParticipantPageContains = false;
		try {
			log.debug(isDisplayed(btnGoBack));
			log.debug(isDisplayed(txtBoxSearchParticipant));
			log.debug(isDisplayed(lblAddBracket));
			log.debug(isDisplayed(btnAddParticipant));
		} catch (Exception e) {
			log.error("Reason for failure: ", e);
		}

		if (isDisplayed(btnGoBack) && isDisplayed(txtBoxSearchParticipant) && isDisplayed(lblAddBracket)
				&& isDisplayed(btnAddParticipant)) {
			isAddBracketParticipantPageContains = true;
		}

		log.info("Ending of isAddBracketParticipantPageContains method");

		return isAddBracketParticipantPageContains;
	}

	public boolean isClubMemberPopupContains() {
		log.info("Starting of isClubMemberPopupContains method");

		boolean isClubMemberPopupContains = false;

		if (btnAdd.isDisplayed() && btnCancel.isDisplayed() && iconClose.isDisplayed() && rdoYes.isDisplayed()
				&& rdoNo.isDisplayed() && lblClubMember.isDisplayed()) {
			isClubMemberPopupContains = true;
		}

		log.info("Ending of isClubMemberPopupContains method");

		return isClubMemberPopupContains;
	}

	public void clickOnAddParticipantsButton() {
		log.info("Starting of clickOnAddParticipantsButton method");

		this.waitForElementToBeVisible(btnAddParticipants);
		clickOnWebElement(btnAddParticipants);

		log.info("Ending of clickOnAddParticipantsButton method");
	}
	
	public boolean isAddParticiPantsButtonDisplayed() {
		log.info("Starting of isAddParticiPantsButtonDisplayed method");
		
		boolean isAddParticiPantsButtonDisplayed = false;

		try {
			if(btnAddParticipants.isDisplayed()==true) {
				isAddParticiPantsButtonDisplayed = true;
			}
		} catch (Exception e) {
			isAddParticiPantsButtonDisplayed = false;
		}

		log.info("Ending of isAddParticiPantsButtonDisplayed method");

		return isAddParticiPantsButtonDisplayed;
	}

	public void searchByNameInPlayersTab(String Name) {
		log.info("Starting of searchByNameInPlayersTab method");
		this.scrollDown(150);
		clickOnWebElement(txtBoxSearchByName);

		try {
			this.txtBoxSearchByName.sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);

		} catch (Exception e) {
			this.txtBoxSearchByName.clear();
		}

		this.txtBoxSearchByName.sendKeys(Name);

		log.info("Ending of searchByNameInPlayersTab method");
	}

	public String getBracketsTitle() {
		log.info("Starting of getBracketsTitle method");
		log.info("Ending of getBracketsTitle method");

		return getText(txtBrackets);
	}

	public boolean isMyBracketsPageContains() {
		log.info("Starting of isMyBracketsPageContains method");

		boolean isMyBracketsPageContains = false;

		if (isDisplayed(txtBrackets) && isDisplayed(btnBackBrackets) && isDisplayed(txtMyBrackets)

				&& isDisplayed(btnBrowseEvents)) {

			isMyBracketsPageContains = true;
		}

		log.info("Ending of isDashboardPageContains method");

		return isMyBracketsPageContains;
	}

	public void addParticipants() {
		log.info("Starting of addParticipants method");

		for (int i = 0; i < 16; i++) {
			try {
				this.hardWait(3);
				clickOnWebElement(btnAddParticipants);
				this.hardWait(4);
				clickOnWebElement(rdoSelectParticipant);
				this.hardWait(3);
				clickOnElement(btnAddParticipant);
				this.hardWait(4);
				clickOnWebElement(rdoNo);
				this.hardWait(3);
				clickOnWebElement(btnAdd);
				this.hardWait(5);
			} catch (Exception e) {
				this.hardWait(3);
				clickOnWebElement(btnAddParticipants);
				this.hardWait(4);
				clickOnWebElement(rdoSelectParticipant);
				this.hardWait(3);
				clickOnElement(btnAddParticipant);
				this.hardWait(4);
				clickOnWebElement(rdoNo);
				this.hardWait(3);
				clickOnWebElement(btnAdd);
				this.hardWait(5);
			}
			
		}

		log.info("Ending of addParticipants method");
	}
}
