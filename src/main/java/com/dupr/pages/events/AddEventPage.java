package com.dupr.pages.events;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class AddEventPage extends DUPRBaseAutomationPage {
	private static final Logger log = LogManager.getLogger(AddEventPage.class);

	@B2BFindBy(xpath = "//button[contains(text(),'Add Event')]")
	private WebElement btnAddEvent;

	@B2BFindBy(xpath = "//h1[contains(text(),'Event Information')]")
	private WebElement lblEventInformation;

	@B2BFindBy(xpath = "//h5[text()='Event Name']")
	private WebElement lblEventName;

	@B2BFindBy(xpath = "//input[@type='text']")
	private WebElement txtEventName;

	@B2BFindBy(xpath = "//h4[contains(text(),'Event Logo')]")
	private WebElement lblEventLogo;

	@B2BFindBy(xpath = "//h4[contains(text(),'Drag and Drop Image')]")
	private WebElement btnDragandDropImage;

	@B2BFindBy(xpath = "//input[@accept='image/jpeg, image/png' and @type='file']")
	private WebElement inpUploadImage;

	@B2BFindBy(xpath = "//button[contains(text(),'Browse Files')]")
	private WebElement btnBrowswrFiles;

	@B2BFindBy(xpath = "//h5[contains(text(),'Entry fee')]")
	private WebElement lblEntryFee;

	@B2BFindBy(xpath = "//h5[text()='Member Price']")
	private WebElement lblboxMemberPrice;

	@B2BFindBy(xpath = "//h5[text()='Nonmember Price']")
	private WebElement lblboxNonMemberPrice;

	@B2BFindBy(xpath = "//h5[text()='Member Price']/parent::div/following-sibling::div/div/div/div/following-sibling::input")
	private WebElement txtMemberPrice;

	@B2BFindBy(xpath = "//h5[text()='Nonmember Price']/parent::div/following-sibling::div/div/div/div/following-sibling::input")
	private WebElement txtNonMemberPrice;

	@B2BFindBy(xpath = "//h5[contains(text(),'About the Event')]")
	private WebElement lblAbouttheEvents;

	@B2BFindBy(xpath = "//button[contains(text(),'Next Step')]")
	private WebElement btnNext;

	@B2BFindBy(xpath = "//button[contains(text(),'Exit')]")
	private WebElement btnExit;

	@B2BFindBy(xpath = "//div[@class='text-editor rdw-editor-main']")
	private WebElement txtAboutTheEvent;

	@B2BFindBy(xpath = "//div[@class='text-editor rdw-editor-main']/div/div/div/div/div/div/span")
	private WebElement txtAboutTheEventEdit;

	@B2BFindBy(xpath = "//div[@title='Bold']")
	private WebElement btnBold;

	@B2BFindBy(xpath = "//div[@title='Italic']")
	private WebElement btnItalic;

	@B2BFindBy(xpath = "//div[@title='Underline']")
	private WebElement btnUnderline;

	@B2BFindBy(xpath = "//button[text()='Next Step']")
	private WebElement btnNextStep;

	@B2BFindBy(xpath = "//h1[text()='Event Policies']")
	private WebElement lblEventPolicies;

	@B2BFindBy(xpath = "//h5[text()='Liability Waiver']")
	private WebElement lblLiabilityWaiver;

	@B2BFindBy(xpath = "//h5[text()='Refund Policy']")
	private WebElement lblRefundPolicy;

	@B2BFindBy(xpath = "(//div[@class=\"text-editor rdw-editor-main\"])[1]")
	private WebElement txtRefundEditor;

	@B2BFindBy(xpath = "//h5[text()='Health and Safety Policy']")
	private WebElement lblHealthandSafetyPolicy;

	@B2BFindBy(xpath = "(//div[@class=\"text-editor rdw-editor-main\"])[2]")
	private WebElement txtHealthandSafetyPolicyEditor;

	@B2BFindBy(xpath = "//button[text()='Go Back']")
	private WebElement btnGoBack;

	@B2BFindBy(xpath = "//button[text()='Next Step']")
	private WebElement btnEventPolicieNextStep;

	@B2BFindBy(xpath = "//h4[contains(text(),'Exit Event Creation?')]")
	private WebElement lblExitEventCreation;

	@B2BFindBy(xpath = "//button[contains(text(),'Discard')]")
	private WebElement btnExitEventCreationDiscard;

	@B2BFindBy(xpath = "//button[@aria-label='close']")
	private WebElement icnExitEventCreationClose;

	@B2BFindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-m8qqmy']")
	private WebElement lblIfyouliketoexiteventcreationprocessyoumaysaveyoureventasadraft;

	@B2BFindBy(xpath = "//h3[text()='Club']")
	private WebElement lblClub;

	@B2BFindBy(xpath = "//button[text()='Members']")
	private WebElement btnMembers;

	@B2BFindBy(xpath = "//button[text()='Matches']")
	private WebElement btnMatchess;

	@B2BFindBy(xpath = "//button[text()='Events']")
	private WebElement tabEvents;

	@B2BFindBy(xpath = "//button[text()='Save as Draft']")
	private WebElement btnSaveAsDraft;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation3')]//following-sibling::div//h4")
	private List<WebElement> lstEvents;

	@B2BFindBy(xpath = "//div[contains(@class, 'MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation3')]//span[text()='Draft']")
	private List<WebElement> lstDrafts;

	@B2BFindBy(xpath = "//div[contains(@class, 'MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation3')]//button[text()='Delete Event']")
	private List<WebElement> lstDeleteEvent;

	@B2BFindBy(xpath = "//h4[@class='MuiTypography-root MuiTypography-h4 css-12grqhn']")
	private List<WebElement> btnEventNames;

	@B2BFindBy(xpath = "//button[contains(text(),'Upload a Liability Waiver')]")
	private WebElement btnUploadaLiabilityWaiver;

	@B2BFindBy(xpath = "//input[@type='file']")
	private WebElement inpUploadaLiabilityWaiver;

	@B2BFindBy(xpath = "//button[@aria-label='remove player']")
	private WebElement btnLiabilityWaiverRemove;
	
	@B2BFindBy(xpath = "//button[text()='Upload a Liability Waiver'])")
	private WebElement btnLiabilityWaiver;

	@B2BFindBy(xpath = "//button[contains(text(),'Replace')]")
	private WebElement btnReplace;

	@B2BFindBy(xpath = "//h5[text()='Refund Policy']/parent::div/following-sibling::div/div/div/following-sibling::div")
	private WebElement txtRefundPolicy;

	@B2BFindBy(xpath = "//h5[text()='Refund Policy']/parent::div/following-sibling::div/div/div/following-sibling::div/div/div/div/div/div/div/span")
	private WebElement txtRefundPolicyEdit;

	@B2BFindBy(xpath = "//h5[text()='Health and Safety Policy']/parent::div/following-sibling::div/div/div/following-sibling::div")
	private WebElement txtHealthAndSaftyPolicy;

	@B2BFindBy(xpath = "//h5[text()='Health and Safety Policy']/parent::div/following-sibling::div/div/div/following-sibling::div/div/div/div/div/div/div/span")
	private WebElement txtHealthAndSaftyPolicyEdit;

	public AddEventPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public boolean isLiabilityWaiverFileUploaded() {
		log.info("Starting of isLiabilityWaiverFileUploaded method");

		boolean isLiabilityWaiverFileUploaded = false;

		if (isDisplayed(btnLiabilityWaiverRemove) && isDisplayed(btnReplace)) {

			isLiabilityWaiverFileUploaded = true;
		}

		log.info("Ending of isLiabilityWaiverFileUploaded method");

		return isLiabilityWaiverFileUploaded;
	}

	public boolean isClubPageContains() {
		log.info("Starting of isClubPageContains method");

		boolean isClubPageContains = false;

		if (isDisplayed(lblClub) && isDisplayed(btnMembers) && isDisplayed(btnMatchess) && isDisplayed(tabEvents)) {

			isClubPageContains = true;
		}

		log.info("Ending of isClubPageContains method");

		return isClubPageContains;
	}

	public void clickonAddEventButton() {
		log.info("Starting of clickonAddEventButton method");

		elementClick(btnAddEvent);

		log.info("Ending of clickonAddEventButton�method");
	}

	public void clickonExitEventCreationCloseIcon() {
		log.info("Starting of clickonAddEventButton method");

		elementClick(icnExitEventCreationClose);

		log.info("Ending of clickonAddEventButton�method");
	}

	public void clickonSaveAsDraftButton() {
		log.info("Starting of clickonSaveAsDraftButton method");

		elementClick(btnSaveAsDraft);

		log.info("Ending of clickonSaveAsDraftButton�method");
	}

	public void clickonEventTab() {
		log.info("Starting of clickonEventTab method");

		elementClick(tabEvents);

		log.info("Ending of clickonEventTab method");
	}

	public void setUploadImageButton(String uploadimage) {
		String osPath = System.getProperty("os.name");
		if (osPath.contains("Linux")) {
			inpUploadImage.sendKeys(TEST_FILE_PATH + "/" + uploadimage);
		} else {
			hardWait(5);
			inpUploadImage.sendKeys(TEST_FILE_PATH + "/" + uploadimage);
		}
	}

	public boolean isEventInformationPageContains() {
		log.info("Starting of isEventInformationPageContains method");

		boolean isEventInformationPageContains = false;

		if (isDisplayed(lblEventInformation) && isDisplayed(lblEventName) && isDisplayed(lblEventLogo)
				&& isDisplayed(lblEntryFee) && isDisplayed(lblboxMemberPrice) && isDisplayed(lblboxNonMemberPrice)
				&& isDisplayed(lblAbouttheEvents) && isDisplayed(btnNext) && isDisplayed(btnExit)) {

			isEventInformationPageContains = true;
		}

		log.info("Ending of isEventInformationPageContains method");

		return isEventInformationPageContains;
	}

	public String getEventInformation() {
		log.info("Starting of getEventInformation method");

		lblEventInformation.click();

		log.info("Ending of getEventInformation�method");

		return lblEventInformation.getText();
	}

	public String getEventNameTitle() {
		log.info("Starting of getEventNameTitle method");

		this.lblEventName.click();

		log.info("Ending of getEventNameTitle�method");
		return lblEventName.getText();
	}

	public String setEventName(String eventname) {
		log.info("Starting of setEventName method");
		hardWait(2);
		txtEventName.click();
		txtEventName.sendKeys(Keys.CONTROL+"a", Keys.DELETE);
		 txtEventName.sendKeys(eventname+"_"+randomNumber(2));
		 String eventName = txtEventName.getAttribute("value");
		log.info("Ending of setEventName�method");
		
		return eventName;
	}

	public void setEditEventName(String editeventname) {
		log.info("Starting of setEditEventName method");
		hardWait(2);
		txtEventName.click();
		this.txtEventName.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		// txtEventName.clear();
		txtEventName.sendKeys(editeventname);

		log.info("Ending of setEditEventName��method");

	}

	public String getEventName() {
		log.info("Starting of getEventName method");
		System.out.println(txtEventName.getText());
		log.info("Ending of getEventName�method");
		return txtEventName.getText();
	}

	public void selectEventsFromEventsList() {
		hardWait(3);
		String s = txtEventName.getText();
		for (WebElement events : lstEvents) {
			if (events.getText().equals(s)) {

				elementClick(events);
				break;
			}
		}

	}

	public boolean isDraftEventDisplayed(String eventName) {
		
		hardWait(3);
		boolean isDraftEventDisplayed = false;
		
		WebElement draft = driver.findElement(By.xpath("//h4[text()='"+eventName+"']/ancestor::div[contains(@class, 'MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation3')]//span[text()='Draft']"));
		System.out.println(draft);
		System.out.println(draft.getText());
		try {
			if (draft.isDisplayed() == true) {
				isDraftEventDisplayed = true;
			}
		} catch (Exception e) {
			isDraftEventDisplayed = false;
		}

		/*
		 * for (int i = 0; i <= lstEvents.size(); i++) {
		 * System.out.println(lstEvents.get(i).getText()); if
		 * (lstEvents.get(i).getText().equals(eventName)) {
		 * System.out.println(lstDrafts.get(i).getText()); if
		 * (lstDrafts.get(i).getText().contains("Draft")) { isDraftEventDisplayed =
		 * true; } } }
		 */
		return isDraftEventDisplayed;
	}

	public boolean selectRecentlyAddedEvent(String eventName) {
		log.info("Starting of selectRecentlyAddedEvent method");
		
		hardWait(3);
boolean eventStatus = false;
		
		for (int i = 0; i <= lstEvents.size(); i++) {
			System.out.println(lstEvents.get(i).getText());
			if (lstEvents.get(i).getText().equals(eventName)) {
				if (lstDrafts.get(i).getText().contains("Upcoming")) {
					eventStatus =  true;
				}
				break;
			}
		}
		log.info("Starting of selectRecentlyAddedEvent method");
		return eventStatus;
	}

	public boolean isDeleteEventDisplayedForDraftEvent(String eventName) {
		log.info("Starting of isDeleteEventDisplayedForDraftEvent method");
		
		hardWait(3);
		boolean deleteButtonState = false;
		
		WebElement btnDelete = driver.findElement(By.xpath("//h4[text()='"+eventName+"']/ancestor::div[contains(@class, 'MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation3')]//button[text()='Delete Event']"));
		System.out.println(btnDelete);
		System.out.println(btnDelete.getText());
		try {
			if (btnDelete.isDisplayed() == true) {
				deleteButtonState = true;
			}
		} catch (Exception e) {
			deleteButtonState = false;
		}
		
		/*
		 * for (int i = 0; i <= lstEvents.size(); i++) { if
		 * (lstEvents.get(i).getText().equals(eventName)) { if
		 * (lstDeleteEvent.get(i).getText().contains("Delete Event")) { eventStatus =
		 * true; } } }
		 */
		log.info("Starting of isDeleteEventDisplayedForDraftEvent method");
		return deleteButtonState;
	}

	public String getEventLogoTitle() {
		log.info("Starting of getEventLogoTitle method");

		lblEventLogo.click();

		log.info("Ending of getEventLogoTitle method");
		
		return lblEventLogo.getText();
	}

	public void clickonDragandDropImageButton() {
		log.info("Starting of clickonDragandDropImageButton method");

		btnDragandDropImage.click();

		log.info("Ending of clickonDragandDropImageButton�method");
	}

	public void clickonBrowswrFilesButton() {
		log.info("Starting of clickonBrowswrFilesButton method");

		btnBrowswrFiles.click();
		log.info("Ending of clickonBrowswrFilesButton�method");
	}

	public String getEntryFeeTitle() {
		log.info("Starting of getEntryFeeTitle method");

		lblEntryFee.click();

		log.info("Ending of getEntryFeeTitle�method");
		return lblEntryFee.getText();
	}

	public void setMemberPrice(String memberPrice) {
		log.info("Starting of setMemberPrice method");

		txtMemberPrice.click();
		// txtMemberPrice.clear();
		txtMemberPrice.sendKeys(memberPrice);

		log.info("Ending of setMemberPrice�method");

	}

	public void setNonMemberPrice(String nonMemberPrice) {
		log.info("Starting of setNonMemberPrice method");

		txtNonMemberPrice.click();
		// txtNonMemberPrice.clear();
		txtNonMemberPrice.sendKeys(nonMemberPrice);

		log.info("Ending of setNonMemberPrice�method");
	}

	public String getAboutTheEvents() {
		log.info("Starting of getAboutTheEvents method");

		lblAbouttheEvents.click();

		log.info("Ending of getAboutTheEvents�method");

		return lblAbouttheEvents.getText();
	}

	public void setAboutTheEvent(String aboutTheEvent) {
		log.info("Starting of setAboutTheEvent method");

		txtAboutTheEvent.click();
		// txtAboutTheEventEdit.clear();
		txtAboutTheEventEdit.sendKeys(aboutTheEvent);
		this.txtAboutTheEventEdit.sendKeys(Keys.CONTROL + "a");

		log.info("Ending of setAboutTheEvent�method");
	}

	public void clickonTextFormattingButtons() {
		log.info("Starting of clickonTextFormattingButtons method");
		hardWait(2);
		elementClick(btnBold);
		elementClick(btnItalic);
		elementClick(btnUnderline);
		hardWait(2);
		txtAboutTheEvent.click();
		log.info("Ending of clickonTextFormattingButtons�method");
	}

	public boolean isEventPoliciesPageContains() {
		log.info("Starting of isEventPoliciesPageContains method");

		boolean isEventPoliciesPageContains = false;

		if (isDisplayed(btnExit) && isDisplayed(btnGoBack) && isDisplayed(lblEventPolicies)
				&& isDisplayed(lblLiabilityWaiver) && isDisplayed(lblRefundPolicy)
				&& isDisplayed(lblHealthandSafetyPolicy) && isDisplayed(btnEventPolicieNextStep)) {

			isEventPoliciesPageContains = true;
		}

		log.info("Ending of isEventPoliciesPageContains method");

		return isEventPoliciesPageContains;
	}

	public void clickonNextButton() {
		log.info("Starting of clickonNextButton method");

		this.btnNextStep.click();

		log.info("Ending of clickonNextButton method");
	}

	public String getEventPoliciesTitle() {
		log.info("Starting of getEventPoliciesTitle method");

		lblEventPolicies.click();
		log.info("Ending of getEventPoliciesTitle method");

		return lblEventPolicies.getText();

	}

	public String getLiabilityWaiver() {
		log.info("Starting of getLiabilityWaiver method");

		lblLiabilityWaiver.click();

		log.info("Ending of getLiabilityWaiver method");
		return lblLiabilityWaiver.getText();

	}

	public String getRefundPolicyTitle() {
		log.info("Starting of getRefundPolicyTitle method");

		lblRefundPolicy.click();

		log.info("Ending of getRefundPolicyTitle method");
		return lblRefundPolicy.getText();

	}

	public String setRefundEditor(String event) {
		log.info("Starting of getRefundPolicyTitle method");

		txtRefundEditor.click();
		txtRefundEditor.clear();
		txtRefundEditor.sendKeys(event);

		log.info("Ending of getRefundPolicyTitle method");

		return txtRefundEditor.getText();

	}

	public String getHealthandSafetyPolicyTitle() {
		log.info("Starting of getHealthandSafetyPolicyTitle method");
		lblHealthandSafetyPolicy.click();
		log.info("Ending of getHealthandSafetyPolicyTitle method");

		return lblHealthandSafetyPolicy.getText();

	}

	public String setHealthandSafetyPolicyEditor(String event) {
		log.info("Starting of setHealthandSafetyPolicyEditor method");

		txtHealthandSafetyPolicyEditor.click();
		txtHealthandSafetyPolicyEditor.clear();
		txtHealthandSafetyPolicyEditor.sendKeys(event);

		log.info("Ending of setHealthandSafetyPolicyEditor method");

		return txtHealthandSafetyPolicyEditor.getText();
	}

	public void clickonGoBackButton() {
		log.info("Starting of clickonGoBackButton method");

		elementClick(btnGoBack);

		log.info("Ending of clickonGoBackButton method");
	}

	public void clickonExitButton() {
		log.info("Starting of clickonExitButton method");
		hardWait(3);
		elementClick(btnExit);

		log.info("Ending of clickonExitButton method");
	}

	public void clickonExitEventCreationDiscardButton() {
		log.info("Starting of clickonExitEventCreationDiscardButton method");

		elementClick(btnEventPolicieNextStep);

		log.info("Ending of clickonExitEventCreationDiscardButton�method");
	}

	public boolean isExitEventCreationPopupContains() {
		log.info("Starting of isExitEventCreationPopupContains method");

		boolean isExitEventCreationPopupContains = false;

		if (isDisplayed(btnEventPolicieNextStep) && isDisplayed(lblExitEventCreation)
				&& isDisplayed(btnExitEventCreationDiscard) && isDisplayed(icnExitEventCreationClose)
				&& isDisplayed(lblIfyouliketoexiteventcreationprocessyoumaysaveyoureventasadraft)) {

			isExitEventCreationPopupContains = true;
		}

		log.info("Ending of isExitEventCreationPopupContains method");

		return isExitEventCreationPopupContains;
	}

	public void clickonEventPolicieDiscardButton() {
		log.info("Starting of clickonEventPolicieDiscardButton method");

		elementClick(btnExitEventCreationDiscard);

		log.info("Ending of clickonEventPolicieDiscardButton�method");
	}

	public void clickonLiabilityWaiverRemoveButton() {
		log.info("Starting of clickonLiabilityWaiverRemoveButton method");

		elementClick(btnLiabilityWaiverRemove);

		log.info("Ending of clickonLiabilityWaiverRemoveButton�method");
	}
	
	public boolean isLiabilityWaiverButtonDisplayed() {
		log.info("Starting of isLiabilityWaiverButtonDisplayed method");
		log.info("Ending of isLiabilityWaiverButtonDisplayed method");
		
		return btnLiabilityWaiver.isDisplayed();
	}
	
	public void clickonReplaceButton() {
		log.info("Starting of clickonReplaceButton method");

		elementClick(btnReplace);

		log.info("Ending of clickonReplaceButton�method");
	}

	public void setHealthandSafetyPolicyEdit(String event) {
		log.info("Starting of setHealthandSafetyPolicyEdit method");

		txtHealthAndSaftyPolicy.click();
		// txtHealthAndSaftyPolicyEdit.clear();
		txtHealthAndSaftyPolicyEdit.sendKeys(event);
		txtHealthAndSaftyPolicy.click();

		log.info("Ending of setHealthandSafetyPolicyEdit�method");
	}

	public void setRefundPolicyEdit(String event) {
		log.info("Starting of setRefundPolicyEdit method");

		txtRefundPolicy.click();
		// txtRefundPolicyEdit.clear();
		txtRefundPolicyEdit.sendKeys(event);
		txtRefundPolicy.click();
		log.info("Ending of setRefundPolicyEdit�method");
	}

	public void uploadEventLogo(String filepath) {
		log.info("Starting of uploadEventLogo method");

		this.inpUploadImage.sendKeys(filepath);

		log.info("Ending of uploadEventLogo method");
	}

	public void setUploadaLiabilityWaiverButton(String filepath) {
		log.info("Starting of setUploadaLiabilityWaiverButton method");

		this.inpUploadaLiabilityWaiver.sendKeys(filepath);

		log.info("Ending of setUploadaLiabilityWaiverButton method");
	}

}
