package com.dupr.pages.clubs;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class ImportPlayerViaCSVPage extends DUPRBaseAutomationPage {
	private static final Logger log = LogManager.getLogger(ImportPlayerViaCSVPage.class);

	@B2BFindBy(xpath = "//h5[contains(text(),'As a Director')]")
	private WebElement lblAsADirector;

	@B2BFindBy(xpath = "//h4[contains(@class,'MuiTypography-root MuiTypography-h4')]")
	private List<WebElement> lstDirectors;

	@B2BFindBy(xpath = "//h4[text()='demo']")
	private WebElement btnDemoDirector;

	@B2BFindBy(xpath = "//button[contains(text(),'Add Players')]/span")
	private WebElement ddAddPlayers;

	@B2BFindBy(xpath = "//li[contains(text(),'Import Players via CSV')]")
	private WebElement btnImportPlayersViaCSV;

	@B2BFindBy(xpath = "//li[contains(text(),'Add a single DUPR user')]")
	private WebElement btnAddASingleDUPRUser;

	@B2BFindBy(xpath = "//h4[contains(text(),'Invite Members by CSV')]")
	private WebElement lblInviteMembersByCSV;

	@B2BFindBy(xpath = "//button[contains(text(),'Download Template')]")
	private WebElement btnDownloadTemplate;

	@B2BFindBy(xpath = "//span[contains(text(),'browse files')]")
	private WebElement btnBrowseFiles;

	@B2BFindBy(xpath = "//div[contains(@class,'dropzone MuiBox-root')]/input[@type='file']")
	private WebElement inpBrowseFile;

	@B2BFindBy(xpath = "//button[contains(text(),'Remove File')]")
	private WebElement btnRemoveFile;

	@B2BFindBy(xpath = "//button[contains(text(),'Cancel')]")
	private WebElement btnCancel;

	@B2BFindBy(xpath = "//button[contains(text(),'Send Invites')]")
	private WebElement btnSendInvites;

	@B2BFindBy(xpath = "//button[@aria-label='close']")
	private WebElement btnClose;

	@B2BFindBy(xpath = "//h4[contains(text(),'Players Added Successfully')]")
	private WebElement lblPlayersAddedSuccessfully;

	@B2BFindBy(xpath = "//h4[contains(text(),'player added,')]")
	private WebElement lblPlayersAdded;

	@B2BFindBy(xpath = "//h4[contains(text(),'players invited,')]")
	private WebElement lblPlayersInvited;

	@B2BFindBy(xpath = "//h4[contains(text(),'invite failures')]")
	private WebElement lblInviteFailures;

	@B2BFindBy(xpath = "//button[contains(text(),'Click here')]")
	private WebElement btnClickHere;

	@B2BFindBy(xpath = "//button[contains(text(),'Ok')]")
	private WebElement btnOk;

	public ImportPlayerViaCSVPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public boolean isAsADirectorTextDisplayed() {
		log.info("Starting of isAsADirectorTextDisplayed method");
		log.info("Ending of isAsADirectorTextDisplayed method");

		return lblAsADirector.isDisplayed();
	}

	public void selectDirectorFromDirectorsList() {
		log.info("Starting of selectDirectorFromDirectorsList method");

		for (WebElement e : lstDirectors) {
			this.hardWait(3);
			if (e.getText().equals(btnDemoDirector.getText())) {
				this.hardWait(2);
				e.click();
			}
		}
		log.info("Ending of selectDirectorFromDirectorsList method");
	}

	public void clickOnDemoClubButton() {
		log.info("Starting of clickOnDemoClubButton method");

		this.waitForElementToBeVisible(btnDemoDirector);
		elementClick(btnDemoDirector);

		log.info("Ending of clickOnDemoClubButton method");
	}

	public void clickOnAddPlayersButton() {
		log.info("Starting of clickOnAddPlayersButton method");

		this.waitForElementToBeVisible(ddAddPlayers);
		elementClick(ddAddPlayers);

		log.info("Ending of clickOnAddPlayersButton method");
	}

	public boolean isAddPlayersDropdownListContains() {
		log.info("Starting of isAddPlayersDropdownListContains method");

		boolean isAddPlayersDropdownListContains = false;

		if (isDisplayed(btnAddASingleDUPRUser) && isDisplayed(btnImportPlayersViaCSV)) {
			isAddPlayersDropdownListContains = true;
		}
		log.info("Ending of isDisplayedAddPlayersDropdown method");

		return isAddPlayersDropdownListContains;
	}

	public void clickOnImportPlayersViaCSVButton() {
		log.info("Starting of clickOnImportPlayersViaCSVButton method");
		hardWait(2);
		this.waitForElementToBeVisible(btnImportPlayersViaCSV);
		elementClick(btnImportPlayersViaCSV);

		log.info("Ending of clickOnImportPlayersViaCSVButton method");
	}

	public boolean isImportCSVPopUpContains() {
		log.info("Starting of isImportCSVPopUpContains method");

		boolean isImportCSVPopUpContains = false;
		hardWait(3);
		if (isDisplayed(lblInviteMembersByCSV) && isDisplayed(btnImportPlayersViaCSV) && isDisplayed(btnBrowseFiles)
				&& isDisplayed(btnCancel) && isDisplayed(btnSendInvites) && isDisplayed(btnClose)) {
			isImportCSVPopUpContains = true;
		}

		log.info("Ending of isImportCSVPopUpContains method");

		return isImportCSVPopUpContains;
	}

	public void clickOnDownloadTemplateButton() {
		log.info("Starting of clickOnDownloadTemplateButton method");

		this.waitForElementToBeVisible(btnDownloadTemplate);
		elementClick(btnDownloadTemplate);

		log.info("Ending of clickOnDownloadTemplateButton method");
	}

	public void clickOnBrowseFiles() {
		log.info("Starting of clickOnBrowseFiles method");

		this.waitForElementToBeVisible(btnBrowseFiles);
		elementClick(btnBrowseFiles);

		log.info("Ending of clickOnBrowseFiles method");
	}

	public void uploadPlayerCSVFile(String filepath) {
		log.info("Starting of setBrowseFilesButton method");

		this.inpBrowseFile.sendKeys(filepath);

		log.info("Ending of setBrowseFilesButton method");
	}

	public void clickOnRemoveFileButton() {
		log.info("Starting of clickOnRemoveFileButton method");

		this.waitForElementToBeVisible(btnRemoveFile);
		elementClick(btnRemoveFile);

		log.info("Ending of clickOnRemoveFileButton method");
	}

	public void clickOnCancelButton() {
		log.info("Starting of clickOnCancelButton method");

		this.waitForElementToBeVisible(btnCancel);
		elementClick(btnCancel);

		log.info("Ending of clickOnCancelButton method");
	}

	public void clickOnSendInvitesButton() {
		log.info("Starting of clickOnSendInvitesButton method");

		this.waitForElementToBeVisible(btnSendInvites);
		elementClick(btnSendInvites);

		log.info("Ending of clickOnSendInvitesButton method");
	}

	public void clickOnCloseButton() {
		log.info("Starting of clickOnCloseButton method");

		this.waitForElementToBeVisible(btnClose);
		elementClick(btnClose);

		log.info("Ending of clickOnCloseButton method");
	}

	public boolean isPlayersAddedSuccessfullyPopUpContains() {
		log.info("Starting of isPlayersAddedSuccessfullyPopUpContains method");

		boolean isPlayersAddedSuccessfullyPopUpContains = false;

		hardWait(3);
		if (isDisplayed(lblPlayersAddedSuccessfully) && isDisplayed(btnClickHere) && isDisplayed(btnOk)) {

			isPlayersAddedSuccessfullyPopUpContains = true;
		}

		log.info("Ending of isPlayersAddedSuccessfullyPopUpContains method");

		return isPlayersAddedSuccessfullyPopUpContains;
	}

	public void clickOnOkButton() {
		log.info("Starting of clickOnOkButton method");

		this.waitForElementToBeVisible(btnOk);
		elementClick(btnOk);

		log.info("Ending of clickOnOkButton method");
	}
}
