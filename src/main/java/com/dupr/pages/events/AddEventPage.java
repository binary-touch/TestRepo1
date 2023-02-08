package com.dupr.pages.events;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class AddEventPage extends DUPRBaseAutomationPage {
	private static final Logger log = LogManager.getLogger(AddEventPage.class);

	@B2BFindBy(xpath = "//div[contains(@class,'MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0')]//h6")
	private List<WebElement> lstClubDetails;

	@B2BFindBy(xpath = "//h3[text()='Browse Clubs']")
	private WebElement lblBrowseClubs;

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

	@B2BFindBy(xpath = "//input[contains(@accept,'image/jpeg, image/png, application/pdf') and @type='file']")
	private WebElement txtBoxUploadImage;

	@B2BFindBy(xpath = "//input[@type='file']")
	private WebElement eventLogoUpload;

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

	@B2BFindBy(xpath = "//h3//button[contains(@class,'MuiIconButton-root MuiIconButton-sizeSmall')]")
	private WebElement iconEdit;

	@B2BFindBy(xpath = "//button[text()='See Club Details']")
	private WebElement btnSeeClubDetails;

	@B2BFindBy(xpath = "//button[contains(text(),'Add Players')]/span")
	private WebElement btnAddPlayers;

	@B2BFindBy(xpath = "//button[contains(text(),'Add a Match')]")
	private WebElement btnAddAMatch;

	@B2BFindBy(xpath = "//div/button[text()='Add Event']")
	private WebElement btnAddEvent;

	@B2BFindBy(xpath = "//div/following-sibling::button[text()='Share']")
	private WebElement btnShare;

	@B2BFindBy(xpath = "//span[text()='Export CSV']")
	private WebElement btnExportCSV;

	@B2BFindBy(xpath = "(//div[contains(@class,'MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0')]//h3)[1]")
	private WebElement lblClubName;

	@B2BFindBy(xpath = "//button[text()='Members']")
	private WebElement tabMembers;

	@B2BFindBy(xpath = "//button[text()='Matches']")
	private WebElement tabMatches;

	@B2BFindBy(xpath = "//button[text()='Events']")
	private WebElement tabEvents;

	@B2BFindBy(xpath = "//button[text()='Save as Draft']")
	private WebElement btnSaveAsDraft;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation3')]//following-sibling::div//h4")
	private List<WebElement> lstEvents;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-17d30pw')]/following-sibling::div//h4")
	private WebElement btnEvent;

	@B2BFindBy(xpath = "//div[contains(@class, 'MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation3')]//span[text()='Draft']")
	private List<WebElement> lstDrafts;

	@B2BFindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-17d30pw']//span[text()='Open']")
	private List<WebElement> lstOpen;

	@B2BFindBy(xpath = "//div[contains(@class, 'MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation3')]//button[text()='Delete Event']")
	private List<WebElement> lstDeleteEvent;

	@B2BFindBy(xpath = "//h4[@class='MuiTypography-root MuiTypography-h4 css-12grqhn']")
	private List<WebElement> btnEventNames;

	@B2BFindBy(xpath = "//button[contains(text(),'Upload a Liability Waiver')]")
	private WebElement btnUploadLiabilityWaiver;

	@B2BFindBy(xpath = "//input[@type='file']")
	private WebElement inpUploadLiabilityWaiver;

	@B2BFindBy(xpath = "//button[@aria-label='remove player']")
	private WebElement btnLiabilityWaiverRemove;

	@B2BFindBy(xpath = "//button[text()='Replace']")
	private WebElement btnReplace;

	@B2BFindBy(xpath = "//h5[text()='Refund Policy']/parent::div/following-sibling::div/div/div/following-sibling::div")
	private WebElement txtBoxRefundPolicy;

	@B2BFindBy(xpath = "//h5[text()='Refund Policy']/parent::div/following-sibling::div/div/div/following-sibling::div/div/div/div/div/div/div/span")
	private WebElement txtBoxRefundPolicyEdit;

	@B2BFindBy(xpath = "//h5[text()='Health and Safety Policy']/parent::div/following-sibling::div/div/div/following-sibling::div")
	private WebElement txtBoxHealthAndSafetyPolicy;

	@B2BFindBy(xpath = "//h5[text()='Health and Safety Policy']/parent::div/following-sibling::div/div/div/following-sibling::div/div/div/div/div/div/div/span")
	private WebElement txtBoxHealthAndSafetyPolicyEdit;

	@B2BFindBy(xpath = "//span[@aria-label='upload picture']")
	private WebElement btnUploadLogo;

	@B2BFindBy(xpath = "//li[text()='Remove Logo']")
	private WebElement btnRemoveLogo;

	@B2BFindBy(xpath = "//button[text()='Yes']")
	private WebElement btnRemoveLogoYes;

	@B2BFindBy(xpath = "//input[@type='file' and @accept]")
	private WebElement txtEventLogoUpload;

	@B2BFindBy(xpath = "//button[text()='Save']")
	private WebElement btnSave;

	@B2BFindBy(xpath = "//p[text()='Event refund policy is required.']")
	private WebElement msgEventRefundPolicyRequired;

	@B2BFindBy(xpath = "//p[text()='File type must be image/jpeg, image/png']")
	private WebElement lblInvalidUploadLogo;

	// Add Event Negative Scenario XPATHS

	@B2BFindBy(xpath = "//p[contains(text(),'Event name is required.')]")
	private WebElement msgEventNameisRequired;
	
	@B2BFindBy(xpath = "//p[text()='Location is required. ']")
	private WebElement msgLocationisRequired;
	
	@B2BFindBy(xpath = "//h5[contains(text(),'Member Price')]/parent::div/following-sibling::div/div/p[contains(text(),'Club member price is required.')]")
	private WebElement msgMemberPriceOnlyNumbersAreAllowed;

	@B2BFindBy(xpath = "//h5[contains(text(),'Member Price')]/parent::div/following-sibling::div//p[text()='price field must have 2 digits after decimal or less']")
	private WebElement msgMemberPriceFieldDigitsAfterDecimal;

	@B2BFindBy(xpath = "//h5[contains(text(),'Nonmember Price')]/parent::div/following-sibling::div//p[text()='price field must have 2 digits after decimal or less']")
	private WebElement msgNonmemberPriceFieldDigitsAfterDecimal;

	@B2BFindBy(xpath = "//h5[contains(text(),'Nonmember Price')]/parent::div/following-sibling::div/div/p[contains(text(),'Club non-member price is required.')]")
	private WebElement msgNonMemberPriceOnlyNumbersAreAllowed;

	@B2BFindBy(xpath = "//p[text()='Event description is required.']")
	private WebElement msgEventDescriptionisRequired;

	@B2BFindBy(xpath = "//p[text()='Club member price is required.']")
	private WebElement msgClubMemberPriceisRequired;

	@B2BFindBy(xpath = "//p[text()='Club non-member price is required.']")
	private WebElement msgNonClubMemberPriceisRequired;

	@B2BFindBy(xpath = "//h5[contains(text(),'Member Price')]/parent::div/following-sibling::div/div/p[contains(text(),'Price should be either 0 or greater than 1.00.')]")
	private WebElement msgMemberPriceGreaterThantwo;

	@B2BFindBy(xpath = "//h5[contains(text(),'Nonmember Price')]/parent::div/following-sibling::div/div/p[contains(text(),'Price should be either 0 or greater than 1.00.')]")
	private WebElement msgNonMemberPriceGreaterThantwo;

	@B2BFindBy(xpath = "//p[contains(text(),'Minimum 10 characters.')]")
	private WebElement msgMinimumTenCharsValidation;

	@B2BFindBy(xpath = "//p[contains(text(),'Maximum 4500 characters')]")
	private WebElement msgMaximumCharsValidation;

	@B2BFindBy(xpath = "//button[@aria-label='remove picture']")
	private WebElement iconRemovelogo;

	@B2BFindBy(xpath = "//p[contains(text(),'Only PDF or WORD files and JPG or PNG images are allowed.')]")
	private WebElement msgLiabilityWaiverInvalidLogo;

	public AddEventPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public boolean isRemoveAndReplaceOptionsDisplayed() {
		log.info("Starting of isRemoveAndReplaceOptionsDisplayed method");

		scrollDown(-500);
		boolean isRemoveAndReplaceOptionsDisplayed = false;

		if (isDisplayed(btnLiabilityWaiverRemove) && isDisplayed(btnReplace)) {

			isRemoveAndReplaceOptionsDisplayed = true;
		}

		log.info("Ending of isRemoveAndReplaceOptionsDisplayed method");

		return isRemoveAndReplaceOptionsDisplayed;
	}

	public boolean isClubDetailsDisplayed() {
		log.info("Starting of isClubDetailsDisplayed method");

		boolean isClubDetailsDisplayed = false;

		for (WebElement club : lstClubDetails) {
			if (club.isDisplayed()) {
				isClubDetailsDisplayed = true;
			}
		}

		log.info("Ending of isClubDetailsDisplayed method");

		return isClubDetailsDisplayed;
	}

	public boolean isClubPageContains() {
		log.info("Starting of isClubPageContains method");

		boolean isClubPageContains = false;
		this.waitForElementToBeVisible(lblClub);

		if (isDisplayed(lblClub) && isDisplayed(iconEdit) && isDisplayed(btnAddEvent) && isDisplayed(btnShare)
				&& isDisplayed(btnAddPlayers) && isDisplayed(btnAddAMatch) && isDisplayed(btnExportCSV)
				&& isDisplayed(tabMembers) && isDisplayed(tabEvents) && isDisplayed(tabMatches)
				&& isDisplayed(btnSeeClubDetails)) {

			isClubPageContains = true;
		}

		log.info("Ending of isClubPageContains method");

		return isClubPageContains;
	}

	public void clickOnReplaceButton() {
		log.info("Starting of clickOnReplaceButton method");

		try {
			clickOnElementUsingActionClass(btnReplace);
		} catch (Exception e) {
			elementClick(btnReplace);
		}

		log.info("Ending of clickOnReplaceButton method");
	}

	public void clickOnAddEventButton() {
		log.info("Starting of clickOnAddEventButton method");

		this.waitForElementToBeVisible(btnAddEvent);
		elementClick(btnAddEvent);

		log.info("Ending of clickOnAddEventButton method");
	}

	public void clickOnSimbaClubName() {
		log.info("Starting of clickOnSimbaClubName method");

		try {
			if (lblBrowseClubs.isDisplayed() == true) {
				this.txtBoxSearch.click();
				this.txtBoxSearch.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);

				sendKeys(txtBoxSearch, "Simba");
				this.txtBoxSearch.sendKeys(Keys.ENTER);
				elementClick(lblSimbaClubName);
			}
		} catch (Exception e) {
			elementClick(lblSimbaClubName);
		}

		log.info("Ending of clickOnSimbaClubName method");
	}

	public void clickOnEventCard() {
		log.info("Starting of clickOnEventCard method");

		elementClick(btnEvent);

		log.info("Ending of clickOnEventCard method");
	}

	public void clickOnUploadLogoButton() {
		log.info("Starting of clickOnUploadLogoButton method");

		hardWait(2);
		elementClick(btnUploadLogo);

		log.info("Ending of clickOnUploadLogoButton method");
	}

	public boolean isDragandDropImageTextDispalyed() {
		log.info("Starting of isDragandDropImageTextDispalyed method");
		log.info("Ending of isDragandDropImageTextDispalyed method");

		return this.btnDragandDropImage.isDisplayed();
	}

	public void clickOnRemoveLogoButton() {
		log.info("Starting of clickOnRemoveLogoButton method");

		elementClick(btnRemoveLogo);

		log.info("Ending of clickOnRemoveLogoButton method");
	}

	public void clickOnRemoveLogoYesButton() {
		log.info("Starting of clickOnRemoveLogoYesButton method");

		elementClick(btnRemoveLogoYes);

		log.info("Ending of clickOnRemoveLogoYesButton method");
	}

	public void clickOnExitEventCreationCloseIcon() {
		log.info("Starting of clickOnExitEventCreationCloseIcon method");

		elementClick(iconExitEventCreationClose);

		log.info("Ending of clickOnExitEventCreationCloseIcon method");
	}

	public void clickOnSaveButton() {
		log.info("Starting of clickOnSaveButton method");

		hardWait(2);
		elementClick(btnSave);

		log.info("Ending of clickOnSaveButton method");
	}

	public void clickOnSaveAsDraftButton() {
		log.info("Starting of clickOnSaveAsDraftButton method");

		elementClick(btnSaveAsDraft);

		log.info("Ending of clickOnSaveAsDraftButton method");
	}

	public void clickOnEventsTab() {
		log.info("Starting of clickOnEventsTab method");

		elementClick(tabEvents);

		log.info("Ending of clickOnEventsTab method");
	}

	public boolean isEventInformationPageContains() {
		log.info("Starting of isEventInformationPageContains method");

		boolean isEventInformationPageContains = false;

		if (isDisplayed(lblEventInformation) && isDisplayed(lblEventName) && isDisplayed(lblEventLogo)
				&& isDisplayed(lblEntryFee) && isDisplayed(lblMemberPrice) && isDisplayed(lblNonMemberPrice)
				&& isDisplayed(lblAboutTheEvents) && isDisplayed(btnNextStep) && isDisplayed(btnExit)) {

			isEventInformationPageContains = true;
		}

		log.info("Ending of isEventInformationPageContains method");

		return isEventInformationPageContains;
	}

	public boolean isDeleteEventPopUpContains() {
		log.info("Starting of isDeleteEventPopUpContains method");

		boolean isDeleteEventPopUpContains = false;

		if (isDisplayed(lblDeleteEvent) && isDisplayed(btnDeleteBracketClose)
				&& isDisplayed(btnDeleteBracketDescription) && isDisplayed(btnDeleteBracketCancel)
				&& isDisplayed(btnDeleteBracketConfirm)) {

			isDeleteEventPopUpContains = true;
		}

		log.info("Ending of isDeleteEventPopUpContains method");

		return isDeleteEventPopUpContains;
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

	public boolean isEventDeletedSuccessPopUpContains() {
		log.info("Starting of isEventDeletedSuccessPopUpContains method");

		boolean isEventDeletedSuccessPopUpContains = false;

		hardWait(2);
		if (isDisplayed(lblDeleteBracketSuccess) && isDisplayed(btnDeleteBracketClose)
				&& isDisplayed(lblDeleteBracketSuccessDescription) && isDisplayed(btnDeleteBracketSuccessOK)) {

			isEventDeletedSuccessPopUpContains = true;
		}

		log.info("Ending of isEventDeletedSuccessPopUpContains method");

		return isEventDeletedSuccessPopUpContains;
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

	public boolean isDraftEventDisplayed(String draftEventName) {
		log.info("Starting of isDraftEventDisplayed method");

		boolean isDraftEventDisplayed = false;

		hardWait(3);

		for (int i = 0; i <= lstEvents.size(); i++) {
			System.out.println(lstEvents.get(i).getText());
			if (lstEvents.get(i).getText().equals(draftEventName)) {
				if (lstDrafts.get(i).getText().contains("Draft")) {
					isDraftEventDisplayed = true;
					break;
				}
			}
		}

		log.info("Ending of isDraftEventDisplayed method");
		return isDraftEventDisplayed;
	}

	public boolean isRecentlyAddedEventDisplayed(String eventName) {
		log.info("Starting of isRecentlyAddedEventDisplayed method");
		
		boolean eventStatus = false;
		hardWait(3);
		
		for (int i = 0; i <= lstEvents.size();) {
			System.out.println(lstEvents.get(i).getText());
			if (lstEvents.get(i).getText().equals(eventName)) {
				if (lstOpen.get(i).getText().contains("Open")) {
					eventStatus =  true;
				}
				break;
			}
			break;
		}
		log.info("Ending of isRecentlyAddedEventDisplayed method");
		return eventStatus;
	}

	public void clickOnRecentlyAddedEvent(String eventName) {
		log.info("Starting of clickOnRecentlyAddedEvent method");
		
		hardWait(3);
		for (int i = 0; i <= lstEvents.size();) {
			System.out.println(lstEvents.get(i).getText());
			if (lstEvents.get(i).getText().equals(eventName)) {
				try {
					clickOnWebElement(lstEvents.get(i));
				} catch (Exception e) {
					lstEvents.get(i).click();
				}
				
			}
			break;
		}
		log.info("Ending of clickOnRecentlyAddedEvent method");
	}

	public boolean isDeleteEventButtonDisplayedForDraftEvent(String eventName) {
		log.info("Starting of isDeleteEventButtonDisplayedForDraftEvent method");

		hardWait(3);

		for (int i = 0; i <= lstEvents.size();) {
			if (lstEvents.get(i).getText().equals(eventName)) {
				if (lstDeleteEvent.get(i).getText().contains("Delete Event")) {
					return true;
				}
			}
		}
		log.info("Ending of isDeleteEventButtonDisplayedForDraftEvent method");
		return false;
	}

	public void clickOnDeleteEventFromList(String eventName) {
		log.info("Starting of clickOnDeleteEventFromList method");

		hardWait(3);
		for (int i = 0; i <= lstEvents.size(); i++) {
			if (lstEvents.get(i).getText().equals(eventName)) {
				if (lstDeleteEvent.get(i).getText().contains("Delete Event")) {
					lstDeleteEvent.get(i).click();
				}
				break;
			}
		}
		log.info("Ending of clickOnDeleteEventFromList method");
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

		scrollIntoView(txtBoxMemberPrice);
		this.txtBoxMemberPrice.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		clickOnWebElement(txtBoxMemberPrice);

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
		clickOnWebElement(txtBoxNonMemberPrice);

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

	public boolean isEventPoliciesPageContains() {
		log.info("Starting of isEventPoliciesPageContains method");

		boolean isEventPoliciesPageContains = false;

		System.out.println(isDisplayed(btnExit));
		System.out.println(isDisplayed(btnGoBack));
		System.out.println(isDisplayed(lblEventPolicies));
		System.out.println(isDisplayed(lblLiabilityWaiver));
		System.out.println(isDisplayed(lblRefundPolicy));
		System.out.println(isDisplayed(lblHealthAndSafetyPolicy));

		if (isDisplayed(btnExit) && isDisplayed(btnGoBack) && isDisplayed(lblEventPolicies)
				&& isDisplayed(lblLiabilityWaiver) && isDisplayed(lblRefundPolicy)
				&& isDisplayed(lblHealthAndSafetyPolicy) && isDisplayed(btnNextStep)) {

			isEventPoliciesPageContains = true;
		}

		log.info("Ending of isEventPoliciesPageContains method");

		return isEventPoliciesPageContains;
	}

	public void clickOnNextStepButton() {
		log.info("Starting of clickOnNextStepButton method");

		try {
			elementClick(btnNextStep);
		} catch (Exception e) {
			btnNextStep.click();
		}

		log.info("Ending of clickOnNextStepButton method");
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

	public boolean isExitEventCreationPopupContains() {
		log.info("Starting of isExitEventCreationPopupContains method");

		boolean isExitEventCreationPopupContains = false;

		if (isDisplayed(lblExitEventCreation) && isDisplayed(btnSaveAsDraft) && isDisplayed(btnExitEventCreationDiscard)
				&& isDisplayed(iconExitEventCreationClose) && isDisplayed(lblExitEventCreationProcess)) {

			isExitEventCreationPopupContains = true;
		}

		log.info("Ending of isExitEventCreationPopupContains method");

		return isExitEventCreationPopupContains;
	}

	public void clickOnEventPoliciesDiscardButton() {
		log.info("Starting of clickonEventPolicieDiscardButton method");

		elementClick(btnExitEventCreationDiscard);

		log.info("Ending of clickonEventPolicieDiscardButton method");
	}

	public void clickOnLiabilityWaiverRemoveButton() {
		log.info("Starting of clickOnLiabilityWaiverRemoveButton method");

		elementClick(btnLiabilityWaiverRemove);

		log.info("Ending of clickOnLiabilityWaiverRemoveButton method");
	}

	public void setHealthAndSafetyPolicy(String policy) {
		log.info("Starting of setHealthAndSafetyPolicy method");

		txtBoxHealthAndSafetyPolicy.click();

		this.txtBoxHealthAndSafetyPolicyEdit.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		txtBoxHealthAndSafetyPolicyEdit.sendKeys(policy);
		txtBoxHealthAndSafetyPolicy.click();

		log.info("Ending of setHealthAndSafetyPolicy method");
	}

	public void setRefundPolicy(String policy) {
		log.info("Starting of setRefundPolicy method");

		txtBoxRefundPolicy.click();

		this.txtBoxRefundPolicyEdit.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		txtBoxRefundPolicyEdit.sendKeys(policy);
		txtBoxRefundPolicy.click();

		log.info("Ending of setRefundPolicy method");
	}

	public void uploadEventLogo(String filepath) {
		log.info("Starting of uploadEventLogo method");

		hardWait(2);
		this.eventLogoUpload.sendKeys(filepath);

		log.info("Ending of uploadEventLogo method");
	}

	public void EventLogoUpload(String filepath) {
		log.info("Starting of EventLogoUpload method");

		this.txtEventLogoUpload.sendKeys(filepath);

		log.info("Ending of EventLogoUpload method");
	}

	public void clickOnLiabilityWaiverButton() {
		log.info("Starting of clickOnLiabilityWaiverButton method");

		try {
			clickOnElementUsingActionClass(btnUploadLiabilityWaiver);
		} catch (Exception e) {
			elementClick(btnUploadLiabilityWaiver);
		}

		log.info("Ending of clickOnLiabilityWaiverButton�method");
	}

	public void uploadLiabilityWaiverFile(String filepath) {
		log.info("Starting of uploadLiabilityWaiverFile method");

		this.inpUploadLiabilityWaiver.sendKeys(filepath);

		log.info("Ending of uploadLiabilityWaiverFile method");
	}

	public boolean isFileExplorerContains() {
		log.info("Starting of isFileExplorerContains method");
		log.info("Ending of isFileExplorerContains method");

		return txtBoxUploadImage.isDisplayed();
	}

	public void pressEscapeKey() throws AWTException {
		log.info("Starting of pressEscapeKey method");

		try {
			Robot robot = new Robot();
			// press key Alt+F4
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.delay(100);
			robot.keyPress(KeyEvent.VK_ESCAPE);
			// relase key Alt+F4
			robot.delay(100);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			robot.delay(100);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
		} catch (Exception e) {
			// TODO: handle exception
		}
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_ESCAPE);

		log.info("Ending of pressEscapeKey method");
	}

	public boolean isEventRefundPolicyRequiredDisplayed() {
		log.info("Starting of isEventRefundPolicyRequiredDisplayed method");

		log.info("Ending of isEventRefundPolicyRequiredDisplayed method");

		return msgEventRefundPolicyRequired.isDisplayed();
	}

	public boolean isInvalidUploadLogoDisplayed() {
		log.info("Starting of isInvalidUploadLogoDisplayed method");
		log.info("Ending of isInvalidUploadLogoDisplayed method");

		return lblInvalidUploadLogo.isDisplayed();
	}

	// Add Events Negative Scenario Methods

	public boolean isEventInfoPageValidationsDisplayed() {
		log.info("Starting of isEventInfoPageValidationsDisplayed method");

		boolean isEventInfoPageValidationsDisplayed = false;
		
		hardWait(5);
		System.out.println(msgEventNameisRequired.isDisplayed());
		System.out.println(msgLocationisRequired.isDisplayed());
		System.out.println(msgMemberPriceOnlyNumbersAreAllowed.isDisplayed());
		System.out.println(msgNonMemberPriceOnlyNumbersAreAllowed.isDisplayed());
		System.out.println(msgEventDescriptionisRequired.isDisplayed());

		if (msgEventNameisRequired.isDisplayed() && msgLocationisRequired.isDisplayed() && msgMemberPriceOnlyNumbersAreAllowed.isDisplayed()
				&& msgNonMemberPriceOnlyNumbersAreAllowed.isDisplayed()
				&& msgEventDescriptionisRequired.isDisplayed()) {

			isEventInfoPageValidationsDisplayed = true;
		}

		log.info("Ending of isEventInfoPageValidationsDisplayed method");

		return isEventInfoPageValidationsDisplayed;
	}

	public boolean isMemberAndNonMemberPriceFieldsWithInvalidDetailsDisplayed() {
		log.info("Starting of isMemberAndNonMemberPriceFieldsWithInvalidDetailsDisplayed method");

		boolean isMemberAndNonMemberPriceFieldsWithInvalidDetailsDisplayed = false;

		if (msgClubMemberPriceisRequired.isDisplayed() && msgNonClubMemberPriceisRequired.isDisplayed()) {

			isMemberAndNonMemberPriceFieldsWithInvalidDetailsDisplayed = true;
		}

		log.info("Ending of isMemberAndNonMemberPriceFieldsWithInvalidDetailsDisplayed method");

		return isMemberAndNonMemberPriceFieldsWithInvalidDetailsDisplayed;
	}

	public boolean isMemberAndNonMemberPriceFieldsWithNegativeDetailsDisplayed() {
		log.info("Starting of isMemberAndNonMemberPriceFieldsWithNegativeDetailsDisplayed method");

		boolean isMemberAndNonMemberPriceFieldsWithNegativeDetailsDisplayed = false;

		System.out.println(msgMemberPriceGreaterThantwo.isDisplayed());
		System.out.println(msgNonMemberPriceGreaterThantwo.isDisplayed());

		if (msgMemberPriceGreaterThantwo.isDisplayed() && msgNonMemberPriceGreaterThantwo.isDisplayed()) {

			isMemberAndNonMemberPriceFieldsWithNegativeDetailsDisplayed = true;
		}

		log.info("Ending of isMemberAndNonMemberPriceFieldsWithNegativeDetailsDisplayed method");

		return isMemberAndNonMemberPriceFieldsWithNegativeDetailsDisplayed;
	}

	public boolean isMemberAndNonMemberPriceFieldsWithMaxDetailsDisplayed() {
		log.info("Starting of isMemberAndNonMemberPriceFieldsWithMaxDetailsDisplayed method");

		boolean isMemberAndNonMemberPriceFieldsWithMaxDetailsDisplayed = false;

		if (msgMemberPriceFieldDigitsAfterDecimal.isDisplayed()
				&& msgNonmemberPriceFieldDigitsAfterDecimal.isDisplayed()) {

			isMemberAndNonMemberPriceFieldsWithMaxDetailsDisplayed = true;
		}

		log.info("Ending of isMemberAndNonMemberPriceFieldsWithMaxDetailsDisplayed method");

		return isMemberAndNonMemberPriceFieldsWithMaxDetailsDisplayed;
	}

	public boolean isMinimumTenCharsValidationDisplayed() {
		log.info("Starting of isMinimumTenCharsValidationDisplayed method");

		log.info("Ending of isMinimumTenCharsValidationDisplayed method");
		return msgMinimumTenCharsValidation.isDisplayed();

	}

	public boolean isMaximumCharsValidationDisplayed() {
		log.info("Starting of isMaximumCharsValidationDisplayed method");
		log.info("Ending of isMaximumCharsValidationDisplayed method");

		return msgMaximumCharsValidation.isDisplayed();
	}

	public boolean isLiabilityWaiverInvalidValidationDisplayed() {
		log.info("Starting of isLiabilityWaiverInvalidValidationDisplayed method");
		log.info("Ending of isLiabilityWaiverInvalidValidationDisplayed method");

		return msgLiabilityWaiverInvalidLogo.isDisplayed();
	}

	public void clickonRemovelogoIcon() {
		log.info("Starting of clickonDragandDropImageButton method");

		this.waitForElementToBeVisible(iconRemovelogo);
		elementClick(iconRemovelogo);

		log.info("Ending of clickonDragandDropImageButton method");
	}
}
