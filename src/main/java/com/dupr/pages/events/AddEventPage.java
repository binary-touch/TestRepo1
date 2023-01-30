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

public class AddEventPage extends DUPRBaseAutomationPage {
	private static final Logger log = LogManager.getLogger(AddEventPage.class);

	@B2BFindBy(xpath = "//button[contains(text(),'Add Event')]")
	private WebElement btnAddEvent;

	@B2BFindBy(xpath = "//h1[contains(text(),'Event Information')]")
	private WebElement lblEventInformation;

	@B2BFindBy(xpath = "//h5[text()='Event Name']")
	private WebElement lblEventName;

	@B2BFindBy(xpath = "//input[@id='Search']")
	private WebElement txtBoxSearch;

	@B2BFindBy(xpath = "//h4[text()='Simba']")
	private WebElement lblSimbaClubName;

	@B2BFindBy(xpath = "//span[text()='Hyderabad, Telangana, India']")
	private WebElement lblEventLocation;

	@B2BFindBy(xpath = "//h5[text()='Location']/parent::div/following-sibling::div/div/following-sibling::ul")
	private List<WebElement> lstEventLocations;

	@B2BFindBy(xpath = "//input[@type='text']")
	private WebElement txtEventName;

	@B2BFindBy(xpath = "//h5[text()='Location']/parent::div/following-sibling::div//input")
	private WebElement txtLocation;

	@B2BFindBy(xpath = "//h4[contains(text(),'Event Logo')]")
	private WebElement lblEventLogo;

	@B2BFindBy(xpath = "//h4[contains(text(),'Drag and Drop Image')]")
	private WebElement btnDragandDropImage;

	@B2BFindBy(xpath = "//input[@accept='image/jpeg, image/png' and @type='file']")
	private WebElement txtBoxUploadImage;

	/*
	 * @B2BFindBy(xpath = "//button[contains(text(),'Browse Files')]") private
	 * WebElement btnBrowswrFiles;
	 */

	@B2BFindBy(xpath = "//h5[contains(text(),'Entry fee')]")
	private WebElement lblEntryFee;

	@B2BFindBy(xpath = "//h5[text()='Member Price']")
	private WebElement lblMemberPrice;

	@B2BFindBy(xpath = "//h5[text()='Nonmember Price']")
	private WebElement lblNonMemberPrice;

	@B2BFindBy(xpath = "//h5[text()='Member Price']/parent::div/following-sibling::div/div/div/div/following-sibling::input")
	private WebElement txtBoxMemberPrice;

	@B2BFindBy(xpath = "//h5[text()='Nonmember Price']/parent::div/following-sibling::div/div/div/div/following-sibling::input")
	private WebElement txtBoxNonMemberPrice;

	@B2BFindBy(xpath = "//h5[contains(text(),'About the Event')]")
	private WebElement lblAboutTheEvents;

	@B2BFindBy(xpath = "//button[contains(text(),'Exit')]")
	private WebElement btnExit;

	@B2BFindBy(xpath = "//div[@class='text-editor rdw-editor-main']")
	private WebElement txtAboutTheEvent;

	@B2BFindBy(xpath = "//div[@class='text-editor rdw-editor-main']/div/div/div/div/div/div/span")
	private WebElement txtAboutTheEventEdit;

	@B2BFindBy(xpath = "//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']/span")
	private WebElement txtFontStyle;

	@B2BFindBy(xpath = "//div[@title='Bold']")
	private WebElement btnBold;

	@B2BFindBy(xpath = "//div[@title='Italic']")
	private WebElement btnItalic;

	@B2BFindBy(xpath = "//div[@title='Underline']")
	private WebElement btnUnderline;

	@B2BFindBy(xpath = "//button[text()='Next Step']")
	private WebElement btnNextStep;

	@B2BFindBy(xpath = "//h4[text()='Delete Event']")
	private WebElement lblDeleteEvent;

	@B2BFindBy(xpath = "//button[@aria-label='close']")
	private WebElement btnDeleteBracketClose;

	@B2BFindBy(xpath = "//button[text()='Cancel']")
	private WebElement btnDeleteBracketCancel;

	@B2BFindBy(xpath = "//button[text()='Confirm']")
	private WebElement btnDeleteBracketConfirm;

	@B2BFindBy(xpath = "//p[text()='Deleting this event will also delete the bracket(s) associated with it. Confirm to delete this event.']")
	private WebElement btnDeleteBracketDescription;

	@B2BFindBy(xpath = "//h4[text()='Success']")
	private WebElement lblDeleteBracketSuccess;

	@B2BFindBy(xpath = "//h4[text()='You have successfully deleted this event']/parent::div/parent::div/following-sibling::div/button")
	private WebElement btnDeleteBracketSuccessOK;

	@B2BFindBy(xpath = "//h4[text()='You have successfully deleted this event']")
	private WebElement lblDeleteBracketSuccessDescription;

	@B2BFindBy(xpath = "//h1[text()='Event Policies']")
	private WebElement lblEventPolicies;

	@B2BFindBy(xpath = "//h5[text()='Liability Waiver']")
	private WebElement lblLiabilityWaiver;

	@B2BFindBy(xpath = "//h5[text()='Refund Policy']")
	private WebElement lblRefundPolicy;

	@B2BFindBy(xpath = "(//div[@class=\"text-editor rdw-editor-main\"])[1]")
	private WebElement txtBoxRefund;

	@B2BFindBy(xpath = "//h5[text()='Health and Safety Policy']")
	private WebElement lblHealthAndSafetyPolicy;

	@B2BFindBy(xpath = "(//div[@class=\"text-editor rdw-editor-main\"])[2]")
	private WebElement txtBoxEditHealthAndSafetyPolicy;

	@B2BFindBy(xpath = "//button[text()='Go Back']")
	private WebElement btnGoBack;

	@B2BFindBy(xpath = "//h4[contains(text(),'Exit Event Creation?')]")
	private WebElement lblExitEventCreation;

	@B2BFindBy(xpath = "//button[contains(text(),'Discard')]")
	private WebElement btnExitEventCreationDiscard;

	@B2BFindBy(xpath = "//button[@aria-label='close']")
	private WebElement iconExitEventCreationClose;

	@B2BFindBy(xpath = "//p[contains(text(), 'like to exit event creation process you may save your event as a draft.')]")
	private WebElement lblExitEventCreationProcess;

	@B2BFindBy(xpath = "//h3[text()='Club']")
	private WebElement lblClub;

	@B2BFindBy(xpath = "//button[text()='Members']")
	private WebElement btnMembers;

	@B2BFindBy(xpath = "//button[text()='Matches']")
	private WebElement btnMatchess;

	@B2BFindBy(xpath = "//button[text()='Events']")
	private WebElement btnEvents;

	@B2BFindBy(xpath = "//button[text()='Save as Draft']")
	private WebElement btnSaveAsDraft;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-17d30pw')]/following-sibling::div//h4")
	private List<WebElement> lstEvents;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-17d30pw')]/following-sibling::div//h4")
	private WebElement btnEvent;

	@B2BFindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-17d30pw']//span[text()='Draft']")
	private List<WebElement> lstDrafts;

	@B2BFindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-17d30pw']//span[text()='Open']")
	private List<WebElement> lstOpen;

	@B2BFindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-17d30pw']//button[text()='Delete Event'] ")
	private List<WebElement> lstDeleteEvent;

	@B2BFindBy(xpath = "//h4[@class='MuiTypography-root MuiTypography-h4 css-12grqhn']")
	private List<WebElement> btnEventNames;

	@B2BFindBy(xpath = "//button[contains(text(),'Upload a Liability Waiver')]")
	private WebElement btnUploadaLiabilityWaiver;

	@B2BFindBy(xpath = "//input[@type='file']")
	private WebElement inpUploadaLiabilityWaiver;

	@B2BFindBy(xpath = "//button[@aria-label='remove player']")
	private WebElement btnLiabilityWaiverRemove;

	@B2BFindBy(xpath = "//button[text()='Replace']")
	private WebElement btnReplace;

	@B2BFindBy(xpath = "//h5[text()='Refund Policy']/parent::div/following-sibling::div/div/div/following-sibling::div")
	private WebElement txtRefundPolicy;

	@B2BFindBy(xpath = "//h5[text()='Refund Policy']/parent::div/following-sibling::div/div/div/following-sibling::div/div/div/div/div/div/div/span")
	private WebElement txtRefundPolicyEdit;

	@B2BFindBy(xpath = "//h5[text()='Health and Safety Policy']/parent::div/following-sibling::div/div/div/following-sibling::div")
	private WebElement txtHealthAndSaftyPolicy;

	@B2BFindBy(xpath = "//h5[text()='Health and Safety Policy']/parent::div/following-sibling::div/div/div/following-sibling::div/div/div/div/div/div/div/span")
	private WebElement txtHealthAndSaftyPolicyEdit;

	@B2BFindBy(xpath = "//span[@aria-label='upload picture']")
	private WebElement btnUploadlogo;

	@B2BFindBy(xpath = "//li[text()='Remove Logo']")
	private WebElement btnRemovelogo;

	@B2BFindBy(xpath = "//button[text()='Yes']")
	private WebElement btnRemoveLogoYes;

	@B2BFindBy(xpath = "//input[@type='file' and @accept]")
	private WebElement txtEventLogoUpload;

	@B2BFindBy(xpath = "//button[text()='Save']")
	private WebElement btnSave;

	@B2BFindBy(xpath = "//p[text()='Event refund policy is required.']")
	private WebElement msgisEventRefundPolicyRequired;

	@B2BFindBy(xpath = "//p[text()='File type must be image/jpeg, image/png']")
	private WebElement lblInvalidUploadLogo;

	public AddEventPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public boolean isDisplayedRemoveAndReplaceContains() {
		log.info("Starting of isDisplayedRemoveAndReplaceContains method");

		boolean isDisplayedRemoveAndReplaceContains = false;

		if (isDisplayed(btnLiabilityWaiverRemove) && isDisplayed(btnReplace)) {

			isDisplayedRemoveAndReplaceContains = true;
		}

		log.info("Ending of isDisplayedRemoveAndReplaceContains method");

		return isDisplayedRemoveAndReplaceContains;
	}

	public boolean isDisplayedClubContains() {
		log.info("Starting of isDisplayedClubContains method");

		boolean isDisplayedClubContains = false;

		if (isDisplayed(lblClub) && isDisplayed(btnMembers) && isDisplayed(btnMatchess) && isDisplayed(btnEvents)) {

			isDisplayedClubContains = true;
		}

		log.info("Ending of isDisplayedClubContains method");

		return isDisplayedClubContains;
	}

	public void clickonAddEventButton() {
		log.info("Starting of clickonAddEventButton method");
		this.waitForElementToBeVisible(btnAddEvent);
		elementClick(btnAddEvent);

		log.info("Ending of clickonAddEventButton method");
	}

	public void clickonSimbaClubNameButton() {
		log.info("Starting of clickonSimbaClubNameButton method");

		elementClick(lblSimbaClubName);

		log.info("Ending of clickonSimbaClubNameButton method");
	}

	public void clickonEventcard() {
		log.info("Starting of clickonAddEventButton method");

		elementClick(btnEvent);

		log.info("Ending of clickonAddEventButton method");
	}

	public void clickonUploadlogoButton() {
		log.info("Starting of clickonUploadlogoButton method");
		hardWait(2);
		elementClick(btnUploadlogo);

		log.info("Ending of clickonUploadlogoButton method");
	}

	public boolean isDragandDropImageTextDispalyed() {
		log.info("Starting of isDragandDropImageTextDispalyed method");
		log.info("Ending of isDragandDropImageTextDispalyed method");

		return this.btnDragandDropImage.isDisplayed();
	}

	public void clickonRemovelogoButton() {
		log.info("Starting of clickonRemovelogoButton method");

		elementClick(btnRemovelogo);

		log.info("Ending of clickonRemovelogoButton method");
	}

	public void clickonRemoveLogoYesButton() {
		log.info("Starting of clickonRemoveLogoYesButton method");

		elementClick(btnRemoveLogoYes);

		log.info("Ending of clickonRemoveLogoYesButton method");
	}

	public void clickonExitEventCreationCloseIcon() {
		log.info("Starting of clickonAddEventButton method");

		elementClick(iconExitEventCreationClose);

		log.info("Ending of clickonAddEventButton method");
	}

	public void clickonSaveButton() {
		log.info("Starting of clickonSaveButton method");
		hardWait(2);
		elementClick(btnSave);

		log.info("Ending of clickonSaveButton method");
	}

	public void clickonSaveAsDraftButton() {
		log.info("Starting of clickonSaveAsDraftButton method");

		elementClick(btnSaveAsDraft);

		log.info("Ending of clickonSaveAsDraftButton method");
	}

	public void clickonEventButton() {
		log.info("Starting of clickonEventButton method");

		elementClick(btnEvents);

		log.info("Ending of clickonEventButton method");
	}

	public void setUploadImageButton(String uploadimage) {
		String osPath = System.getProperty("os.name");
		if (osPath.contains("Linux")) {
			txtBoxUploadImage.sendKeys(TEST_FILE_PATH + "/" + uploadimage);
		} else {
			hardWait(5);
			txtBoxUploadImage.sendKeys(TEST_FILE_PATH + "/" + uploadimage);
		}
	}

	public boolean isDisplayedEventInformationPageContains() {
		log.info("Starting of isDisplayedEventInformationPageContains method");

		boolean isDisplayedEventInformationPageContains = false;

		if (isDisplayed(lblEventInformation) && isDisplayed(lblEventName) && isDisplayed(lblEventLogo)
				&& isDisplayed(lblEntryFee) && isDisplayed(lblMemberPrice) && isDisplayed(lblNonMemberPrice)
				&& isDisplayed(lblAboutTheEvents) && isDisplayed(btnNextStep) && isDisplayed(btnExit)) {

			isDisplayedEventInformationPageContains = true;
		}

		log.info("Ending of isDisplayedEventInformationPageContains method");

		return isDisplayedEventInformationPageContains;
	}

	public boolean isDisplayedEventDeletePopUpContains() {
		log.info("Starting of isDisplayedEventDeletePopUpContains method");

		boolean isDisplayedEventDeletePopUpContains = false;

		if (isDisplayed(lblDeleteEvent) && isDisplayed(btnDeleteBracketClose)
				&& isDisplayed(btnDeleteBracketDescription) && isDisplayed(btnDeleteBracketCancel)
				&& isDisplayed(btnDeleteBracketConfirm)) {

			isDisplayedEventDeletePopUpContains = true;
		}

		log.info("Ending of isDisplayedEventDeletePopUpContains method");

		return isDisplayedEventDeletePopUpContains;
	}

	public void clickOnDeleteEventCancelButton() {
		log.info("Starting of clickOnDeleteEventCancelButton method");

		btnDeleteBracketCancel.click();

		log.info("Ending of clickOnDeleteEventCancelButto method");
	}

	public void clickOnDeleteEventCloseButton() {
		log.info("Starting of clickOnDeleteEventCloseButton method");

		btnDeleteBracketClose.click();

		log.info("Ending of clickOnDeleteEventCloseButton method");
	}

	public void clickOnDeleteEventConfirmButton() {
		log.info("Starting of clickOnDeleteEventConfirmButton method");

		btnDeleteBracketConfirm.click();

		log.info("Ending of clickOnDeleteEventConfirmButton method");
	}

	public void clickOnDeleteEventOKButton() {
		log.info("Starting of clickOnDeleteEventOKButton method");

		btnDeleteBracketSuccessOK.click();

		log.info("Ending of clickOnDeleteEventOKButton method");
	}

	public boolean isDisplayedEventDeleteSuccessPopUpContains() {
		log.info("Starting of isDisplayedEventDeleteSuccessPopUpContains method");

		boolean isDisplayedEventDeleteSuccessPopUpContains = false;
		hardWait(2);
		if (isDisplayed(lblDeleteBracketSuccess) && isDisplayed(btnDeleteBracketClose)
				&& isDisplayed(lblDeleteBracketSuccessDescription) && isDisplayed(btnDeleteBracketSuccessOK)) {

			isDisplayedEventDeleteSuccessPopUpContains = true;
		}

		log.info("Ending of isDisplayedEventDeletePopUpContains method");

		return isDisplayedEventDeleteSuccessPopUpContains;
	}

	public String getEventInformation() {
		log.info("Starting of getEventInformation method");

		lblEventInformation.click();

		log.info("Ending of getEventInformation method");

		return lblEventInformation.getText();
	}

	public String getEventNameTitle() {
		log.info("Starting of getEventNameTitle method");

		this.lblEventName.click();

		log.info("Ending of getEventNameTitle method");
		return lblEventName.getText();
	}

	public String setEventName(String eventname) {
		log.info("Starting of setEventName method");
		hardWait(2);
		this.txtEventName.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		txtEventName.click();
		this.txtEventName.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		// textboxEventName.clear();
		txtEventName.sendKeys(eventname + "_" + randomNumber(3));

		log.info("Ending of setEventName method");

		return txtEventName.getAttribute("value");

	}

	public void setLocation(String location) {
		log.info("Starting of setLocation method");
		hardWait(2);
		this.txtLocation.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		txtLocation.click();
		this.txtLocation.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		// textboxEventName.clear();
		txtLocation.sendKeys(location);
		// for(WebElement loc : lstEventLocations)
		// if(loc.equals(lblEventLocation.getText()))
		hardWait(2);
		lstEventLocations.get(0).click();
		log.info("Ending of setLocation method");
	}

	public String getEventNameValue() {
		log.info("Starting of getEventNameValue method");
		log.info("Ending of getEventNameValue method");

		return this.txtEventName.getAttribute("value");
	}

	public void setEditEventName(String editeventname) {
		log.info("Starting of setEditEventName method");
		hardWait(2);
		txtEventName.click();
		this.txtEventName.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		// txtEventName.clear();
		txtEventName.sendKeys(editeventname);

		log.info("Ending of setEditEventName method");
	}

	public String getEventName() {
		log.info("Starting of getEventName method");
		System.out.println(txtEventName.getText());
		log.info("Ending of getEventName method");
		return txtEventName.getText();
	}

	public void selectEventsFromEventsList() {
		log.info("Starting of selectEventsFromEventsList method");
		hardWait(3);
		// String s = txtEventName.getText();
		for (int i = 0; i <= lstEvents.size(); i++) {
			for (WebElement events : lstEvents) {
				if (events.getText().equals("pickleball_40")) {
					elementClick(events);
					break;
				}
				break;
			}
		}

		log.info("Ending of selectEventsFromEventsList method");
	}

	public void clickOnEventName(String eventname) {
		log.info("Starting of clickOnEventName method");
		hardWait(2);

		driver.findElement(By.xpath("//h4[text()='" + eventname + "']")).click();

		log.info("Ending of clickOnEventName method");
	}

	public boolean selectDraftFromDraftsList(String eventName) {
		hardWait(3);
		log.info("Starting of selectDraftFromDraftsList method");

		// String s1=btnEventNames.getText();
		for (int i = 0; i <= lstEvents.size(); i++) {
			System.out.println(lstEvents.get(i).getText());
			if (lstEvents.get(i).getText().equals(eventName)) {
				if (lstDrafts.get(i).getText().contains("Draft")) {
					return true;
				}
				break;
			}
			break;
		}
		log.info("Ending of selectDraftFromDraftsList method");
		return false;

	}

	public boolean selectRecentlyAddedEvent(String eventName) {
		hardWait(3);
		log.info("Starting of selectRecentlyAddedEvent method");
		for (int i = 0; i <= lstEvents.size(); i++) {
			System.out.println(lstEvents.get(i).getText());
			if (lstEvents.get(i).getText().equals(eventName)) {
				if (lstOpen.get(i).getText().contains("Open")) {
					return true;
				}
				break;
			}
			break;
		}
		log.info("Ending of selectRecentlyAddedEvent method");
		return false;
	}

	public void clickonRecentlyAddedEvent(String eventName) {
		hardWait(3);
		log.info("Starting of clickonRecentlyAddedEvent method");
		for (int i = 0; i <= lstEvents.size(); i++) {
			System.out.println(lstEvents.get(i).getText());
			if (lstEvents.get(i).getText().equals(eventName)) {
				if (lstOpen.get(i).getText().contains("Open")) {
					lstOpen.get(0).click();
				}
				break;
			}
			break;
		}
		log.info("Ending of clickonRecentlyAddedEvent method");

	}

	public boolean selectDeleteEventFromList(String eventName) {
		log.info("Starting of selectDeleteEventFromList method");

		for (int i = 0; i <= lstEvents.size(); i++) {
			if (lstEvents.get(i).getText().equals(eventName)) {
				if (lstDeleteEvent.get(i).getText().contains("Delete Event")) {
					return true;
				}
				break;
			}
			break;
		}
		log.info("Ending of selectDeleteEventFromList method");
		return false;
	}

	public void ClickOnDeleteEventFromList(String eventName) {
		hardWait(3);
		log.info("Starting of ClickOnDeleteEventFromList method");
		for (int i = 0; i <= lstEvents.size(); i++) {
			if (lstEvents.get(i).getText().equals(eventName)) {
				if (lstDeleteEvent.get(i).getText().contains("Delete Event")) {
					lstDeleteEvent.get(i).click();
				}
				break;
			}
			// break;
		}
		log.info("Ending of ClickOnDeleteEventFromList method");
	}

	public String getEveltLogoTitle() {
		log.info("Starting of getEveltLogoTitle method");

		lblEventLogo.click();

		log.info("Ending of getEveltLogoTitle�method");
		return lblEventLogo.getText();
	}

	public void clickonDragandDropImageButton() {
		log.info("Starting of clickonDragandDropImageButton method");

		btnDragandDropImage.click();

		log.info("Ending of clickonDragandDropImageButton method");
	}

	/*
	 * public void clickonBrowswrFilesButton() {
	 * log.info("Starting of clickonBrowswrFilesButton method");
	 * 
	 * btnBrowswrFiles.click();
	 * log.info("Ending of clickonBrowswrFilesButton method"); }
	 */

	public String getEntryFeeTitle() {
		log.info("Starting of getEntryFeeTitle method");

		lblEntryFee.click();

		log.info("Ending of getEntryFeeTitle�method");
		return lblEntryFee.getText();
	}

	public void setMemberPrice(String memberPrice) {
		log.info("Starting of setMemberPrice method");

		this.txtBoxMemberPrice.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		txtBoxMemberPrice.click();

		this.txtBoxMemberPrice.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		txtBoxMemberPrice.sendKeys(memberPrice);

		log.info("Ending of setMemberPrice method");

	}

	public void setSearchClubName(String clubName) {
		log.info("Starting of setSearchClubName method");

		this.txtBoxSearch.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		txtBoxSearch.click();

		this.txtBoxSearch.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		txtBoxSearch.sendKeys(clubName);

		log.info("Ending of setSearchClubName method");
	}

	public void setNonMemberPrice(String nonMemberPrice) {
		log.info("Starting of setNonMemberPrice method");

		this.txtBoxNonMemberPrice.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		txtBoxNonMemberPrice.click();

		this.txtBoxNonMemberPrice.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		txtBoxNonMemberPrice.sendKeys(nonMemberPrice);

		log.info("Ending of setNonMemberPrice method");
	}

	public String getAboutTheEvents() {
		log.info("Starting of getAboutTheEvents method");

		lblAboutTheEvents.click();

		log.info("Ending of getAboutTheEvents method");

		return lblAboutTheEvents.getText();
	}

	public void setAboutTheEvent(String aboutTheEvent) {
		log.info("Starting of setAboutTheEvent method");

		txtAboutTheEvent.click();
		this.txtAboutTheEventEdit.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		txtAboutTheEventEdit.sendKeys(aboutTheEvent);

		log.info("Ending of setAboutTheEvent method");
	}

	public void clickonTextFormattingButtons() {
		log.info("Starting of clickonTextFormattingButtons method");

		hardWait(2);
		this.txtAboutTheEventEdit.sendKeys(Keys.CONTROL + "a");

		elementClick(btnBold);
		elementClick(btnItalic);
		elementClick(btnUnderline);
		hardWait(2);
		// txtAboutTheEvent.click();
		log.info("Ending of clickonTextFormattingButtons method");
	}

	public void clickonBoldTextFormattingButton() {
		log.info("Starting of clickonBoldTextFormattingButton method");

		hardWait(2);
		this.txtAboutTheEventEdit.sendKeys(Keys.CONTROL + "a");

		elementClick(btnBold);

		// txtAboutTheEvent.click();

		log.info("Ending of clickonBoldTextFormattingButton method");
	}

	public boolean isBoldFontStyleDisplayed() {
		log.info("Starting of isBoldFontStyleDisplayed method");

		boolean fontStyle = false;
		try {
			if (txtFontStyle.getAttribute("style").equals("font-weight: bold;")) {
				System.out.println(txtFontStyle.getAttribute("style").equals("font-weight: bold;"));
				fontStyle = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("Ending of isBoldFontStyleDisplayed method");

		return fontStyle;
	}

	public void clickonItalicTextFormattingButton() {
		log.info("Starting of clickonItalicTextFormattingButton method");

		hardWait(2);
		elementClick(btnItalic);

		// txtAboutTheEvent.click();
		log.info("Ending of clickonItalicTextFormattingButton method");
	}

	public boolean isItalicFontStyleDisplayed() {
		log.info("Starting of isItalicFontStyleDisplayed method");

		boolean fontStyle = false;
		try {
			if (txtFontStyle.getAttribute("style").equals("font-style: italic;")) {
				System.out.println(txtFontStyle.getAttribute("style").equals("font-style: italic;"));
				fontStyle = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("Ending of isItalicFontStyleDisplayed method");

		return fontStyle;
	}

	public void clickonUnderLineTextFormattingButton() {
		log.info("Starting of clickonUnderLineTextFormattingButton method");

		hardWait(2);
		elementClick(btnUnderline);

		// txtAboutTheEvent.click();
		log.info("Ending of clickonUnderLineTextFormattingButton method");
	}

	public boolean isUnderlineFontStyleDisplayed() {
		log.info("Starting of isUnderlineFontStyleDisplayed method");

		boolean fontStyle = false;
		try {
			if (txtFontStyle.getAttribute("style").equals("text-decoration: underline;")) {
				System.out.println(txtFontStyle.getAttribute("style").equals("text-decoration: underline;"));
				fontStyle = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("Ending of isUnderlineFontStyleDisplayed method");

		return fontStyle;
	}

	public boolean isBoldUnderlineFontStylesDisplayed() {
		log.info("Starting of isBoldUnderlineFontStylesDisplayed method");

		boolean fontStyle = false;
		try {
			if (txtFontStyle.getAttribute("style").equals("font-weight: bold; text-decoration: underline;")) {
				System.out.println(
						txtFontStyle.getAttribute("style").equals("font-weight: bold; text-decoration: underline;"));
				fontStyle = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("Ending of isBoldUnderlineFontStylesDisplayed method");

		return fontStyle;
	}

	public boolean isItalicUnderlineFontStylesDisplayed() {
		log.info("Starting of isItalicUnderlineFontStylesDisplayed method");

		boolean fontStyle = false;
		try {
			if (txtFontStyle.getAttribute("style").equals("font-style: italic; text-decoration: underline;")) {
				System.out.println(
						txtFontStyle.getAttribute("style").equals("font-style: italic; text-decoration: underline;"));
				fontStyle = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("Ending of isItalicUnderlineFontStylesDisplayed method");

		return fontStyle;
	}

	public boolean isBoldItalicFontStylesDisplayed() {
		log.info("Starting of isBoldItalicFontStylesDisplayed method");

		boolean fontStyle = false;
		try {
			if (txtFontStyle.getAttribute("style").equals("font-weight: bold; font-style: italic;")) {
				System.out.println(txtFontStyle.getAttribute("style").equals("font-weight: bold; font-style: italic;"));
				fontStyle = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("Ending of isBoldItalicFontStylesDisplayed method");

		return fontStyle;
	}

	public boolean isBoldItalicUnderlineFontStylesDisplayed() {
		log.info("Starting of isBoldItalicUnderlineFontStylesDisplayed method");

		boolean fontStyle = false;
		try {
			if (txtFontStyle.getAttribute("style")
					.equals("font-weight: bold; font-style: italic; text-decoration: underline;")) {
				System.out.println(txtFontStyle.getAttribute("style")
						.equals("font-weight: bold; font-style: italic; text-decoration: underline;"));
				fontStyle = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("Ending of isBoldItalicUnderlineFontStylesDisplayed method");

		return fontStyle;
	}

	public void clickonBoldAndUnderLineTextFormattingButton() {
		log.info("Starting of clickonUnderLineTextFormattingButton method");

		hardWait(2);
		this.txtAboutTheEventEdit.sendKeys(Keys.CONTROL + "a");

		elementClick(btnBold);
		elementClick(btnUnderline);

		log.info("Ending of clickonUnderLineTextFormattingButton��method");
	}

	public void clickonItalicAndUnderLineTextFormattingButton() {
		log.info("Starting of clickonUnderLineTextFormattingButton method");

		hardWait(2);
		this.txtAboutTheEventEdit.sendKeys(Keys.CONTROL + "a");

		elementClick(btnItalic);
		elementClick(btnUnderline);
		hardWait(2);

		log.info("Ending of clickonUnderLineTextFormattingButton��method");
	}

	public void clickonBoldAndItalicTextFormattingButton() {
		log.info("Starting of clickonBoldAndItalicTextFormattingButton method");

		hardWait(2);
		this.txtAboutTheEventEdit.sendKeys(Keys.CONTROL + "a");

		elementClick(btnBold);
		elementClick(btnItalic);

		log.info("Ending of clickonBoldAndItalicTextFormattingButton��method");
	}

	public boolean isDisplayedEventPoliciesPageContains() {
		log.info("Starting of isDisplayedEventPoliciesPageContains method");

		boolean isDisplayedEventPoliciesPageContains = false;

		System.out.println(isDisplayed(btnExit));
		System.out.println(isDisplayed(btnGoBack));
		System.out.println(isDisplayed(lblEventPolicies));
		System.out.println(isDisplayed(lblLiabilityWaiver));
		System.out.println(isDisplayed(lblRefundPolicy));
		System.out.println(isDisplayed(lblHealthAndSafetyPolicy));

		if (isDisplayed(btnExit) && isDisplayed(btnGoBack) && isDisplayed(lblEventPolicies)
				&& isDisplayed(lblLiabilityWaiver) && isDisplayed(lblRefundPolicy)
				&& isDisplayed(lblHealthAndSafetyPolicy) && isDisplayed(btnNextStep)) {

			isDisplayedEventPoliciesPageContains = true;
		}

		log.info("Ending of isDisplayedEventPoliciesPageContains method");

		return isDisplayedEventPoliciesPageContains;
	}

	public void clickonNextButton() {
		log.info("Starting of clickonNextButton method");

		try {
			elementClick(btnNextStep);
		} catch (Exception e) {
			btnNextStep.click();
		}

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

		txtBoxRefund.click();
		txtBoxRefund.clear();
		txtBoxRefund.sendKeys(event);

		log.info("Ending of getRefundPolicyTitle method");

		return txtBoxRefund.getText();

	}

	public String getHealthandSafetyPolicyTitle() {
		log.info("Starting of getHealthandSafetyPolicyTitle method");
		lblHealthAndSafetyPolicy.click();
		log.info("Ending of getHealthandSafetyPolicyTitle method");

		return lblHealthAndSafetyPolicy.getText();

	}

	public String setHealthandSafetyPolicyEditor(String event) {
		log.info("Starting of setHealthandSafetyPolicyEditor method");

		txtBoxEditHealthAndSafetyPolicy.click();
		txtBoxEditHealthAndSafetyPolicy.clear();
		txtBoxEditHealthAndSafetyPolicy.sendKeys(event);

		log.info("Ending of setHealthandSafetyPolicyEditor method");

		return txtBoxEditHealthAndSafetyPolicy.getText();
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

	public boolean isDisplayedExitEventCreationPopupContains() {
		log.info("Starting of isDisplayedExitEventCreationPopupContains method");

		boolean isDisplayedExitEventCreationPopupContains = false;

		if (isDisplayed(lblExitEventCreation) && isDisplayed(btnSaveAsDraft) && isDisplayed(btnExitEventCreationDiscard)
				&& isDisplayed(iconExitEventCreationClose) && isDisplayed(lblExitEventCreationProcess)) {

			isDisplayedExitEventCreationPopupContains = true;
		}

		log.info("Ending of isDisplayedExitEventCreationPopupContains method");

		return isDisplayedExitEventCreationPopupContains;
	}

	public void clickonEventPolicieDiscardButton() {
		log.info("Starting of clickonEventPolicieDiscardButton method");

		elementClick(btnExitEventCreationDiscard);

		log.info("Ending of clickonEventPolicieDiscardButton method");
	}

	public void clickonLiabilityWaiverRemoveButton() {
		log.info("Starting of clickonLiabilityWaiverRemoveButton method");

		elementClick(btnLiabilityWaiverRemove);

		log.info("Ending of clickonLiabilityWaiverRemoveButton method");
	}

	public void setReplaceButton(String filepath) {
		log.info("Starting of setReplaceButton method");

		btnReplace.sendKeys(filepath);

		log.info("Ending of setReplaceButton method");
	}

	public void setHealthandSafetyPolicyEdit(String event) {
		log.info("Starting of setHealthandSafetyPolicyEdit method");

		txtHealthAndSaftyPolicy.click();
		// txtHealthAndSaftyPolicyEdit.clear();
		this.txtHealthAndSaftyPolicyEdit.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		txtHealthAndSaftyPolicyEdit.sendKeys(event);
		txtHealthAndSaftyPolicy.click();

		log.info("Ending of setHealthandSafetyPolicyEdit method");
	}

	public void setRefundPolicyEdit(String event) {
		log.info("Starting of setRefundPolicyEdit method");

		txtRefundPolicy.click();
		// txtRefundPolicyEdit.clear();
		this.txtRefundPolicyEdit.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		txtRefundPolicyEdit.sendKeys(event);
		txtRefundPolicy.click();
		log.info("Ending of setRefundPolicyEdit method");
	}

	public void uploadEventLogo(String filepath) {
		log.info("Starting of uploadEventLogo method");
		hardWait(2);
		this.txtBoxUploadImage.sendKeys(filepath);

		log.info("Ending of uploadEventLogo method");
	}

	public void EventLogoUpload(String filepath) {
		log.info("Starting of EventLogoUpload method");

		this.txtEventLogoUpload.sendKeys(filepath);

		log.info("Ending of EventLogoUpload method");
	}

	public void clickOnLiabilityWaiverButton() {
		log.info("Starting of clickOnLiabilityWaiverButton method");

		clickOnWebElement(btnUploadaLiabilityWaiver);

		log.info("Ending of clickOnLiabilityWaiverButton�method");
	}

	public void setUploadaLiabilityWaiverButton(String filepath) {
		log.info("Starting of setUploadaLiabilityWaiverButton method");

		this.inpUploadaLiabilityWaiver.sendKeys(filepath);

		log.info("Ending of setUploadaLiabilityWaiverButton�method");
	}

	public boolean isFileExplorerContains() {
		log.info("Starting of isFileExplorerContains method");
		log.info("Ending of isFileExplorerContains method");

		return txtBoxUploadImage.isDisplayed();
	}

	public void setUploadaLiabilityWaiverReplaceButton(String filepath) {
		log.info("Starting of setUploadaLiabilityWaiverButton method");
		btnReplace.click();
		hardWait(3);
		this.inpUploadaLiabilityWaiver.sendKeys(filepath);

		log.info("Ending of setUploadaLiabilityWaiverButton�method");
	}

	public boolean isEventRefundPolicyRequiredDisplayed() {
		log.info("Starting of isEventRefundPolicyRequiredDisplayed method");

		log.info("Ending of isEventRefundPolicyRequiredDisplayed method");

		return msgisEventRefundPolicyRequired.isDisplayed();
	}

	public boolean isInvalidUploadLogoDisplayed() {
		log.info("Starting of isInvalidUploadLogoDisplayed method");

		log.info("Ending of isInvalidUploadLogoDisplayed method");
		return lblInvalidUploadLogo.isDisplayed();

	}
}
