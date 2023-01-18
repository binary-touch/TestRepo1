package com.dupr.pages.events;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.b2b.support.B2BFindBy;
import com.dupr.pages.DUPRBaseAutomationPage;

public class EditEventsPage extends DUPRBaseAutomationPage {

	private static final Logger log = LogManager.getLogger(EditEventsPage.class);

	@B2BFindBy(xpath = "//span[contains(text(),'Ongoing')]/ancestor::div/following-sibling::div/descendant::h4")
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

	@B2BFindBy(xpath = "//div[contains(@class,'text-editor rdw-editor-main')]")
	// h5[text()='About the
	// Event']/parent::div/following-sibling::div//div[contains(@class,'DraftEditor-root')]
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
	private WebElement btnLiability;

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

	@B2BFindBy(xpath = "//div[@class='text-editor rdw-editor-main']/div/div/div/div/div/div/span")
	private WebElement editAboutEvent;

	@B2BFindBy(xpath = "//h5[text()='Refund Policy']/parent::div/following-sibling::div/div/div/following-sibling::div/div/div/div/div/div/div/span/span")
	private WebElement editRefundPolicy;

	@B2BFindBy(xpath = "//h5[text()='Health and Safety Policy']/parent::div/following-sibling::div/div/div/following-sibling::div/div/div/div/div/div/div/span")
	private WebElement editHealthPolicy;

	@B2BFindBy(xpath = "//button[@aria-label='remove player']")
	private WebElement btnRemove;

	public EditEventsPage(WebDriver driver) {
		super(driver);

	}

	public void editRefundPolicy(String refundpolicy) {
		log.info("Starting of clickOnbtnMyEvent method");

		try {
			this.txtRefundField.click();
		//	this.editRefundPolicy.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
			this.hardWait(2);
			this.txtRefundField.click();
		//	this.editRefundPolicy.sendKeys(refundpolicy);

		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("Ending of clickOnbtnMyEvent method");
	}

	public void clickOnEventLabel() {
		log.info("Starting of clickOnEventLabel method");

		elementClick(lblEvent);

		log.info("Ending of clickOnEventLabel method");
	}

	public void clickOnEditEvent() {
		log.info("Starting of clickOnbtnMyEvent method");

		elementClick(btnEditEvent);

		log.info("Ending of clickOnbtnMyEvent method");
	}

	public void clickOnCancel() {
		log.info("Starting of clickOnCancel method");

		elementClick(btnCancel);

		log.info("Ending of clickOnCancel method");
	}

	public void clickOnSaveChanges() {
		log.info("Starting of clickOnSaveChanges method");

		elementClick(btnSaveChanges);

		log.info("Ending of clickOnSaveChanges method");
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

	public void ClickOnRemoveButton() {
		log.info("Starting of ClickOnReplace method");

		clickOnElement(btnRemove);

		log.info("Ending of ClickOnReplace method");

	}

	public Boolean btnReplace() {
		boolean replacebtn = false;

		if (isDisplayed(btnReplace) == true) {
			replacebtn = true;
		}
		return replacebtn;
	}

	public void ClickOnUpload() {
		log.info("Starting of ClickOnUpload method");

		clickOnElement(btnLiability);

		log.info("Ending of ClickOnUpload method");

	}

	public Boolean btnupload() {
		boolean uploadBtn = false;

		if (isDisplayed(btnLiability) == true) {
			uploadBtn = true;
		}
		return uploadBtn;
	}

	public String getLiabilityWaiverText() {
		log.info("Starting of getLiabilityWaiverText method");
		log.info("Ending of getLiabilityWaiverText method");

		return getText(txtLiability);
	}

	public boolean isEditEventsPageContains() {
		log.info("Starting of isMyEventsPageContains method");

		boolean isEditEventPageContains = false;

		if (isDisplayed(btnCancel) && isDisplayed(btnSaveChanges) && isDisplayed(txtEditEvent)) {

			isEditEventPageContains = true;
		}

		log.info("Ending of isMyEventsPageContains method");

		return isEditEventPageContains;
	}

	public String getEventNameText() {
		log.info("Starting of getEventNameText method");
		log.info("Ending of getEventNameText method");

		return getText(txtEventName);
	}

	public void clickOnEventName(String name) {
		log.info("Starting of clickOnbtnMyEvent method");

		clickOnElement(txtEventNameField);
		this.txtEventNameField.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		this.hardWait(2);
		clickOnElement(txtEventNameField);
		this.txtEventNameField.sendKeys(name);

		log.info("Ending of clickOnbtnMyEvent method");
	}

	public String getAboutEventText() {
		log.info("Starting of getAboutEventText method");
		log.info("Ending of getAboutEventText method");

		return getText(txtAboutEvent);
	}

	public void clickOnAboutEvent(String aboutEvent) {
		log.info("Starting of clickOnAboutEvent method");

		clickOnElement(txtAboutEventField);
		//this.editAboutEvent.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		this.hardWait(2);
		clickOnElement(txtAboutEventField);
		//this.txtAboutEventField.sendKeys(aboutEvent);

		log.info("Ending of clickOnAboutEvent method");
	}

	public String getEntryFeeText() {
		log.info("Starting of entryFeeText method");
		log.info("Ending of entryFeeText method");

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

	public String getHealthSafetyText() {
		log.info("Starting of getHealthSafetyText method");
		log.info("Ending of getHealthSafetyText method");

		return getText(txtHealth);
	}

	public void clickOnHealthSafety(String healthPolicy) {
		log.info("Starting of clickOnHealthSafety method");

		clickOnElement(txtHealthField);

		//this.editHealthPolicy.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);

		// this.txtHealthField.sendKeys(healthPolicy);

		log.info("Ending of clickOnHealthSafety method");
	}

}
