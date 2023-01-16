package com.dupr.pages.events;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class EditEventsPage extends DUPRBaseAutomationPage {

	private static final Logger log = LogManager.getLogger(EditEventsPage.class);

	@B2BFindBy(xpath = "//h4[contains(@class,'MuiTypography-root MuiTypography-h4')]")
	private WebElement lblEvent;

	@B2BFindBy(xpath = "//button[text()='Edit Event']")
	private WebElement btnEditEvent;

	@B2BFindBy(xpath = "//h1[text()='Edit Event']")
	private WebElement txtEditEvent;

	@B2BFindBy(xpath = "//h5[text()='Event Name']")
	private WebElement txtEventName;

	@B2BFindBy(xpath = "//input[@type='text']")
	private WebElement txtEventNameField;

	@B2BFindBy(xpath = "//button[text()='Cancel']")
	private WebElement btnCancel;

	@B2BFindBy(xpath = "//h5[text()='About the Event']")
	private WebElement txtAboutEvent;

	@B2BFindBy(xpath = "//h5[text()='About the Event']/parent::div/following-sibling::div//div[contains(@class,'DraftEditor-root')]")
	private WebElement txtAboutEventField;

	@B2BFindBy(xpath = "//h5[text()='Entry fee']")
	private WebElement txtEntryFee;

	@B2BFindBy(xpath = "//h5[text()='Member Price']")
	private WebElement txtMember;

	@B2BFindBy(xpath = "//h5[text()='Member Price']/parent::div/following-sibling::div//input")
	private WebElement txtMemberField;

	@B2BFindBy(xpath = "//h5[text()='Nonmember Price']")
	private WebElement txtNonMember;

	@B2BFindBy(xpath = "//h5[text()='Nonmember Price']/parent::div/following-sibling::div//input")
	private WebElement txtNonMemberField;

	@B2BFindBy(xpath = "//h5[text()='Liability Waiver']")
	private WebElement txtLiability;

	@B2BFindBy(xpath = "//button[text()='Upload a Liability Waiver']")
	private WebElement btnLiabilityUpload;

	@B2BFindBy(xpath = "//button[text()='Replace']")
	private WebElement btnReplace;

	@B2BFindBy(xpath = "//h5[text()='Refund Policy']")
	private WebElement txtRefundPolicy;

	@B2BFindBy(xpath = "//h5[text()='Refund Policy']/parent::div/following-sibling::div//div[contains(@class,'DraftEditor-root')]")
	private WebElement txtRefundField;

	@B2BFindBy(xpath = "//h5[text()='Health and Safety Policy']")
	private WebElement txtHealth;

	@B2BFindBy(xpath = "//h5[text()='Health and Safety Policy']/parent::div/following-sibling::div//div[contains(@class,'DraftEditor-root')]")
	private WebElement txtHealthField;

	@B2BFindBy(xpath = "//button[text()='Save Changes']")
	private WebElement btnSaveChanges;

	public EditEventsPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public void clickOnEventLabel() {
		log.info("Starting of clickOnEventLabel method");

		elementClick(lblEvent);

		log.info("Ending of clickOnEventLabel method");
	}

	public void clickOnEditEvent() {
		log.info("Starting of clickOnEditEvent method");

		elementClick(btnEditEvent);

		log.info("Ending of clickOnEditEvent method");
	}

	public void clickOnCancelButton() {
		log.info("Starting of clickOnCancelButton method");

		elementClick(btnCancel);

		log.info("Ending of clickOnCancelButton method");
	}

	public void clickOnSaveChangesButton() {
		log.info("Starting of clickOnSaveChangesButton method");

		elementClick(btnSaveChanges);

		log.info("Ending of clickOnSaveChangesButton method");
	}

	public String getEditEventsText() {
		log.info("Starting of gettxtEventsText method");
		log.info("Ending of gettxtEventsText method");

		return getText(txtEditEvent);
	}

	public void ClickOnReplace() {
		log.info("Starting of ClickOnReplace method");

		clickOnElement(btnReplace);

		log.info("Ending of ClickOnReplace method");

	}

	public boolean isReplaceButtonDisplayed() {
		log.info("Starting of isReplaceButtonDisplayed method");
		boolean replacebtn = false;

		if (isDisplayed(btnReplace) == true) {
			replacebtn = true;
		}
		log.info("Ending of isReplaceButtonDisplayed method");

		return replacebtn;
	}

	public void clickOnUploadLiabilityFile() {
		log.info("Starting of clickOnUploadLiabilityFile method");

		clickOnElement(btnLiabilityUpload);

		log.info("Ending of clickOnUploadLiabilityFile method");

	}

	public boolean isUploadButtonDisplayed() {
		log.info("Starting of isUploadButtonDisplayed method");

		boolean uploadBtn = false;

		if (isDisplayed(btnLiabilityUpload) == true) {
			uploadBtn = true;
		}
		log.info("Ending of isUploadButtonDisplayed method");

		return uploadBtn;
	}

	public String getLiabilityWaiverText() {
		log.info("Starting of getLiabilityWaiverText method");
		log.info("Ending of getLiabilityWaiverText method");

		return getText(txtLiability);
	}

	public boolean isEditEventsPageContains() {
		log.info("Starting of isEditEventsPageContains method");

		boolean isEditEventsPageContains = false;

		if (isDisplayed(btnCancel) && isDisplayed(btnSaveChanges) && isDisplayed(txtEditEvent)) {

			isEditEventsPageContains = true;
		}

		log.info("Ending of isEditEventsPageContains method");

		return isEditEventsPageContains;
	}

	public String getEventNameText() {
		log.info("Starting of getEventNameText method");
		log.info("Ending of getEventNameText method");

		return getText(txtEventName);
	}

	public void clickOnEventName(String name) {
		log.info("Starting of clickOnEventName method");

		clickOnElement(txtEventNameField);
		this.txtEventNameField.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		this.hardWait(2);
		this.txtEventNameField.sendKeys(name);

		log.info("Ending of clickOnEventName method");
	}

	public String getAboutEventText() {
		log.info("Starting of getAboutEventText method");
		log.info("Ending of getAboutEventText method");

		return getText(txtAboutEvent);
	}

	public void clickOnAboutEvent(String aboutEvent) {
		log.info("Starting of clickOnAboutEvent method");

		clickOnElement(txtAboutEventField);
		this.txtAboutEventField.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		this.hardWait(2);
		this.txtAboutEventField.sendKeys(aboutEvent);

		log.info("Ending of clickOnAboutEvent method");
	}

	public String getEntryFeeText() {
		log.info("Starting of getEntryFeeText method");
		log.info("Ending of getEntryFeeText method");

		return getText(txtEntryFee);
	}

	public String getMembersText() {
		log.info("Starting of getMembersText method");
		log.info("Ending of getMembersText method");

		return getText(txtMember);
	}

	public String getNonMemberText() {
		log.info("Starting of getNonMemberText method");
		log.info("Ending of getNonMemberText method");

		return getText(txtNonMember);
	}

	public String getRefundPolicyText() {
		log.info("Starting of getRefundPolicyText method");
		log.info("Ending of getRefundPolicyText method");

		return getText(txtRefundPolicy);
	}

	public void clickOnRefundPolicy(String refundpolicy) {
		log.info("Starting of clickOnRefundPolicy method");

		clickOnElement(txtRefundField);
		this.txtRefundField.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		this.hardWait(2);
		this.txtRefundField.sendKeys(refundpolicy);

		log.info("Ending of clickOnRefundPolicy method");
	}

	public String getHealthSafetyText() {
		log.info("Starting of getHealthSafetyText method");
		log.info("Ending of getHealthSafetyText method");

		return getText(txtHealth);
	}

	public void clickOnHealthSafety(String healthPolicy) {
		log.info("Starting of clickOnHealthSafety method");

		clickOnElement(txtHealthField);
		this.txtHealthField.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		this.hardWait(2);
		this.txtHealthField.sendKeys(healthPolicy);

		log.info("Ending of clickOnHealthSafety method");
	}
}
