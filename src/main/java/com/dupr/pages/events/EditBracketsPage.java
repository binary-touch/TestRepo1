package com.dupr.pages.events;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class EditBracketsPage extends DUPRBaseAutomationPage {

	private static final Logger log = LogManager.getLogger(EditBracketsPage.class);

	// @B2BFindBy(xpath = "//div[contains(@class,'MuiPaper-root MuiPaper-elevation
	// MuiPaper-rounded MuiPaper-elevation3')]")
	@B2BFindBy(xpath = "//div[contains(@class,'MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation3')]//h4")
	private WebElement lblBracket;

	@B2BFindBy(xpath = "//button[text()='Edit Bracket']")
	private WebElement btnEditBracket;

	@B2BFindBy(xpath = "//button[text()='Cancel']")
	private WebElement btnCancel;

	@B2BFindBy(xpath = "//h1[text()='Edit Bracket']")
	private WebElement txtEditBracket;

	@B2BFindBy(xpath = "//button[text()='Reset']")
	private WebElement btnReset;

	@B2BFindBy(xpath = "//button[text()='Save Changes']")
	private WebElement btnSaveChanges;

	@B2BFindBy(xpath = "//h3[text()='Player Group']/parent::div//div[contains(@class,'MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl')]")
	private WebElement btnPlayerGroup;

	@B2BFindBy(xpath = "//li[text()='Men']")
	private WebElement listMen;

	@B2BFindBy(xpath = "//h3[text()='Event Type']/parent::div//div[contains(@class,'MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input')]")
	// @B2BFindBy(xpath = "//h3[text()='Event
	// Type']/parent::div//div[contains(@class,'MuiInputBase-root
	// MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl')]")
	private WebElement btnEventType;

	@B2BFindBy(xpath = "//li[text()='Waterfall']")
	private WebElement listWaterfall;

	@B2BFindBy(xpath = "//h3[text()='Time Zone']/parent::div//div[contains(@class,'MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input')]")
	// @B2BFindBy(xpath = "//h3[text()='Time
	// Zone']/parent::div//div[contains(@class,'MuiInputBase-root
	// MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl')]")
	private WebElement btnTimeZone;

	@B2BFindBy(xpath = "//li[contains(text(),'Alaskan Standard Time')]")
	private WebElement listAlaskan;

	@B2BFindBy(xpath = "//h3[text()='Player Group']")
	private WebElement txtPlayerGroup;

	@B2BFindBy(xpath = "//h3[text()='Event Type']")
	private WebElement txtEventType;

	@B2BFindBy(xpath = "//h3[text()='Time Zone']")
	private WebElement txtTimeZone;

	public EditBracketsPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public void clickOnBracketLabel() {
		log.info("Starting of clickOnLabelBracket method");
		try {
			clickUsingActionsClass(lblBracket);
		} catch (Exception e) {
			clickOnWebElement(lblBracket);
		}

		log.info("Ending of clickOnLabelBracket method");
	}

	public void clickOnEditBracketButton() {
		log.info("Starting of clickOnEditBracket method");

		try {
			clickUsingActionsClass(btnEditBracket);
		} catch (Exception e) {
			clickOnWebElement(btnEditBracket);
		}

		log.info("Ending of clickOnEditBracket method");
	}

	public void clickOnCancelButton() {
		log.info("Starting of clickOnCancel method");

		elementClick(btnCancel);

		log.info("Ending of clickOnCancel method");
	}

	public String getEditBrackettxt() {
		log.info("Starting of getEditBrackettxt method");
		log.info("Ending of getEditBrackettxt method");

		return getText(txtEditBracket);
	}

	public boolean isEditBracketsPageContains() {
		log.info("Starting of isMyEventsPageContains method");

		boolean isEditBracketPageContains = false;

		if (isDisplayed(btnCancel) && isDisplayed(btnSaveChanges) && isDisplayed(btnReset)
				&& isDisplayed(txtEditBracket)) {

			isEditBracketPageContains = true;
		}

		log.info("Ending of isMyEventsPageContains method");

		return isEditBracketPageContains;
	}

	public void clickOnPlayerGroupField() {
		log.info("Starting of clickOnPlayerGroup method");

		clickOnElement(btnPlayerGroup);

		log.info("Ending of clickOnPlayerGroup method");
	}

	public void selectMen() {
		log.info("Starting of clickOnMen method");

		clickOnElement(listMen);

		log.info("Ending of clickOnMen method");
	}

	public void clickOnEventTypeField() {
		log.info("Starting of clickOnEventType method");

		clickOnElement(btnEventType);

		log.info("Ending of clickOnEventType method");
	}

	public void selectWaterfall() {
		log.info("Starting of clickOnWaterfall method");

		clickOnElement(listWaterfall);

		log.info("Ending of clickOnWaterfall method");
	}

	public void clickOnTimeZoneField() {
		log.info("Starting of clickOnTimeZone method");

		clickOnElement(btnTimeZone);

		log.info("Ending of clickOnTimeZone method");
	}

	public void selectAlaskan() {
		log.info("Starting of clickOnAlaskan method");

		clickOnWebElement(listAlaskan);

		log.info("Ending of clickOnAlaskan method");
	}

	public void clickOnResetButton() {
		log.info("Starting of clickOnReset method");

		clickOnElement(btnReset);

		log.info("Ending of clickOnReset method");
	}

	public void clickOnSaveChangesButton() {
		log.info("Starting of clickOnSaveChanges method");

		clickOnElement(btnSaveChanges);

		log.info("Ending of clickOnSaveChanges method");
	}

	public String getPlayerGroupFieldTxt() {
		log.info("Starting of getPlayerGroup method");
		log.info("Ending of getPlayerGroup method");

		return getText(btnPlayerGroup);

	}

	public String getEventTypeFieldTxt() {
		log.info("Starting of getEventType method");
		log.info("Ending of getEventType method");

		return getText(btnEventType);

	}

	public String getTimeZoneFieldTxt() {
		log.info("Starting of getTimeZOne method");
		log.info("Ending of getTimeZOne method");

		return getText(btnTimeZone);

	}

}
