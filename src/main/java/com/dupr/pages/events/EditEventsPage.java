package com.dupr.pages.events;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.dupr.pages.DUPRBaseAutomationPage;

public class EditEventsPage extends DUPRBaseAutomationPage {

	private static final Logger log = LogManager.getLogger(EditEventsPage.class);

	@B2BFindBy(xpath = "//span[contains(text(),'Open')]/ancestor::div/following-sibling::div/descendant::h4")
	private WebElement lblEvent;
	
	@B2BFindBy(xpath = "//h6[contains(text(),'Home')]")
	private WebElement mnuHome;
	
	@B2BFindBy(xpath = "//h3[text()='Event']")
	private WebElement lblEventInEventPage;

	@B2BFindBy(xpath = "//button[text()='Edit Event']")
	private WebElement btnEditEvent;

	@B2BFindBy(xpath = "//h1[text()='Edit Event']")
	private WebElement txtEditEvent;

	@B2BFindBy(xpath = "//h5[text()='Event Name']")
	private WebElement txtEventName;

	@B2BFindBy(xpath = "//button[text()='Cancel']")
	private WebElement btnCancel;

	@B2BFindBy(xpath = "//h5[text()='About the Event']")
	private WebElement txtAboutEvent;

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

	@B2BFindBy(xpath = "//h5[text()='Health and Safety Policy']")
	private WebElement txtHealth;

	@B2BFindBy(xpath = "//button[text()='Save Changes']")
	private WebElement btnSaveChanges;

	@B2BFindBy(xpath = "//button[@aria-label='remove player']")
	private WebElement btnRemove;

	public EditEventsPage(WebDriver driver) {
		super(driver);
	}

	public void clickOnEventLabel(String eventName) {
		log.info("Starting of clickOnEventLabel method");
		
		WebElement element = driver.findElement(By.xpath("//h4[text()='" + eventName + "']"));
		try {
			clickUsingActionsClass(element);
		} catch (Exception e) {
			elementClick(element);
		}
		log.info("Ending of clickOnEventLabel method");
	}

	public void clickOnEditEventButton() {
		log.info("Starting of clickOnEditEventButton method");

		elementClick(btnEditEvent);

		log.info("Ending of clickOnEditEventButton method");
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

	public void clickOnReplaceButton() {
		log.info("Starting of clickOnReplaceButton method");

		clickOnElement(btnReplace);

		log.info("Ending of clickOnReplaceButton method");
	}

	public void clickOnRemoveButton() {
		log.info("Starting of clickOnRemoveButton method");

		clickOnElement(btnRemove);

		log.info("Ending of clickOnRemoveButton method");
	}

	public boolean isReplaceButtonDisplayed() {
		log.info("Starting of isReplaceButtonDisplayed method");

		boolean replacebtn = false;

		try {
			if (isDisplayed(btnReplace) == true) {
				replacebtn = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("Ending of isReplaceButtonDisplayed method");
		return replacebtn;
	}

	public String getLiabilityWaiverText() {
		log.info("Starting of getLiabilityWaiverText method");
		log.info("Ending of getLiabilityWaiverText method");

		return getText(txtLiability);
	}

	public boolean isEditEventsPageContains() {
		log.info("Starting of isMyEventsPageContains method");

		boolean isEditEventPageContains = false;

		try {
			if (isDisplayed(btnCancel) && isDisplayed(btnSaveChanges) && isDisplayed(txtEditEvent)) {

				isEditEventPageContains = true;
			}
		} catch (Exception e) {
			isEditEventPageContains = false;
		}

		log.info("Ending of isMyEventsPageContains method");

		return isEditEventPageContains;
	}

	public String getEventNameText() {
		log.info("Starting of getEventNameText method");
		log.info("Ending of getEventNameText method");

		return getText(txtEventName);
	}

	public String getAboutEventText() {
		log.info("Starting of getAboutEventText method");
		log.info("Ending of getAboutEventText method");

		return getText(txtAboutEvent);
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

	public String getEventNameLabel() {
		log.info("Starting of getEventNameLabel method");
		log.info("Ending of getEventNameLabel method");

		return getText(lblEventInEventPage);
	}

	public void clickOnHomeMenu() {
		log.info("Starting of clickOnHomeMenu method");
		
		clickUsingActionsClass(mnuHome);
		
		log.info("Ending of clickOnHomeMenu method");
	}
}
