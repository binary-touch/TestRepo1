package com.dupr.pages.events;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BFindBys;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class EventRegistrationPage extends DUPRBaseAutomationPage {
	private static final Logger log = LogManager.getLogger(EventRegistrationPage.class);

	@B2BFindBy(xpath = "//h3[text()='Event']")
	private WebElement lblEvent;

	@B2BFindBy(xpath = "//h3[text()='Event']/parent::div//button")
	private WebElement btnEventBack;

	@B2BFindBy(xpath = "//button[text()='Register']")
	private WebElement btnRegister;

	@B2BFindBy(xpath = "//button[text()='Add a Bracket']")
	private WebElement btnAddABracket;

	@B2BFindBy(xpath = "//button[text()='Edit Event']")
	private WebElement btnEditEvent;

	@B2BFindBy(xpath = "//button[text()='End Event']")
	private WebElement btnEndEvent;

	@B2BFindBy(xpath = "//button[text()='Add An Announcement']")
	private WebElement btnAddAnnouncement;

	@B2BFindBy(xpath = "//button[text()='Share']")
	private WebElement btnShare;

	@B2BFindBy(xpath = "//button[text()='Show Details']")
	private WebElement btnShowDetails;

	@B2BFindBy(xpath = "//button[text()='Brackets']")
	private WebElement tabBrackets;

	@B2BFindBy(xpath = "//button[text()='Announcements']")
	private WebElement tabAnnouncements;

	@B2BFindBy(xpath = "//button[text()='Policies']")
	private WebElement tabPolicies;

	@B2BFindBy(xpath = "//h3[text()='Event Registration']")
	private WebElement lblEventRegistration;

	@B2BFindBy(xpath = "//h3[text()='Event Registration']/parent::div//button")
	private WebElement btnEventRegistrationBack;

	@B2BFindBy(xpath = "//button[text()='Refund Policy']")
	private WebElement btnRefundPolicy;

	@B2BFindBy(xpath = "//button[text()='Health and Safety Policy']")
	private WebElement btnHealthSafetyPolicy;

	@B2BFindBy(xpath = "//button[text()='Liability Policy']")
	private WebElement btnLiabilityPolicy;

	@B2BFindBys(@B2BFindBy(xpath = "//input[@type='checkbox']"))
	private List<WebElement> lstcheckboxes;

	@B2BFindBy(xpath = "//button[@type='button' and @disabled]")
	private WebElement btnRegisterDisable;

	@B2BFindBy(xpath = "//h5[text()='Select your Brackets']/parent::div/following-sibling::div//input")
	private WebElement chkSelectBracket;

	@B2BFindBy(xpath = "//button[text()='Refund Policy']/parent::div//input")
	private WebElement chkRefundPolicy;

	@B2BFindBy(xpath = "//button[text()='Health and Safety Policy']/parent::div//input")
	private WebElement chkHealthSafetyPolicy;

	@B2BFindBy(xpath = "//button[text()='Liability Policy']/parent::div//input")
	private WebElement chkLiabilityPolicy;

	@B2BFindBy(xpath = "//h4[text()='Success']")
	private WebElement lblSuccess;

	@B2BFindBy(xpath = "//h4[text()='Registration Complete']")
	private WebElement lblRegistrationCompleted;

	@B2BFindBy(xpath = "//button[text()='OK']")
	private WebElement btnOK;

	@B2BFindBy(xpath = "//span[text()='Open']/parent::div/parent::div/parent::div/following-sibling::div//h4")
	private WebElement lstOpenEvents;

	@B2BFindBy(xpath = "//span[text()='Ongoing']/parent::div/parent::div/parent::div/following-sibling::div//h4")
	private WebElement lstOngoingEvents;

	@B2BFindBy(xpath = "//span[text()='Complete']/parent::div/parent::div/parent::div/following-sibling::div//h4")
	private WebElement lstCompletedEvents;

	@B2BFindBy(xpath = "//span[text()='Registration closed']/parent::div/parent::div/parent::div/following-sibling::div//h4")
	private WebElement lstRegistrationCompleted;

	@B2BFindBy(xpath = "//span[text()='Upcoming']/parent::div/parent::div/parent::div/following-sibling::div//h4")
	private WebElement lstUpComingEvents;

	@B2BFindBy(xpath = "//h4[text()='Add your Partner']/parent::div/parent::button")
	private WebElement btnAddYourPartner;

	@B2BFindBy(xpath = "//h4[text()='View Qualifying Partners']")
	private WebElement lblViewQualifingPartners;

	@B2BFindBy(xpath = "//input[@name='Player Info']")
	private WebElement rdoAddYourPartner;

	@B2BFindBy(xpath = "//button[text()='Add Partner']")
	private WebElement btnAddPartner;

	@B2BFindBy(xpath = "//div[text()='Add a Partner']")
	private WebElement lblAddaPartner;

	@B2BFindBy(xpath = "//button[text()='Cancel']")
	private WebElement btnCancel;

	@B2BFindBy(xpath = "//button[text()='Change']")
	private WebElement btnChange;

	@B2BFindBy(xpath = "//button[@aria-label='Remove Partner']")
	private WebElement btnRemovePartner;

	@B2BFindBys(@B2BFindBy(xpath = "//div[contains(@class,'MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation3')]//h4"))
	private List<WebElement> lnkEventName;

	@B2BFindBys(@B2BFindBy(xpath = "//div[contains(@class,'MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation3')]//h5[1]"))
	private List<WebElement> lnkEventLocation;

	@B2BFindBys(@B2BFindBy(xpath = "//div[contains(@class,'MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation3')]//p"))
	private List<WebElement> lnkEventCompetitionDates;

	@B2BFindBys(@B2BFindBy(xpath = "//div[contains(@class,'MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation3')]//div[contains(@class,'MuiAvatar-root MuiAvatar-circular')]"))
	private List<WebElement> lnkEventLogo;

	@B2BFindBys(@B2BFindBy(xpath = "//div[contains(@class,'MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation3')]//div[contains(@class,'MuiChip-semifilled MuiChip-sizeSmall MuiChip-colorPrimary MuiChip-semifilledPrimary')]"))
	private List<WebElement> lnkEventStatus;

	@B2BFindBys(@B2BFindBy(xpath = "//div[contains(@class,'MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation3')]//button[text()='Delete Event']"))
	private List<WebElement> lnkDeleteEvent;

	public EventRegistrationPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public boolean isEventPageContains() {
		log.info("Starting of isEventPageContains method");

		boolean isEventPageContains = false;

		if (isDisplayed(lblEvent) && isDisplayed(btnEventBack) && isDisplayed(btnRegister)
				&& isDisplayed(btnAddABracket) && isDisplayed(btnEditEvent) && isDisplayed(btnEndEvent)
				&& isDisplayed(btnAddAnnouncement) && isDisplayed(btnShare) && isDisplayed(btnShowDetails)
				&& isDisplayed(tabBrackets) && isDisplayed(tabAnnouncements) && isDisplayed(tabPolicies)) {

			isEventPageContains = true;
		}

		log.info("Ending of isEventPageContains method");

		return isEventPageContains;
	}

	public boolean isEventLogosDisplayed() {
		log.info("Starting of isEventLogosDisplayed method");

		boolean isEventLogosDisplayed = false;
		try {
			for (WebElement logo : lnkEventLogo) {
				if (logo.isDisplayed() == true) {
					isEventLogosDisplayed = true;
				}
			}
		} catch (Exception e) {
			isEventLogosDisplayed = false;
		}

		log.info("Ending of isEventLogosDisplayed method");

		return isEventLogosDisplayed;
	}

	public boolean isEventNameDisplayed() {
		log.info("Starting of isEventNameDisplayed method");

		boolean isEventNameDisplayed = false;
		try {
			for (WebElement eventName : lnkEventName) {
				if (eventName.isDisplayed() == true) {
					isEventNameDisplayed = true;
				}
			}
		} catch (Exception e) {
			isEventNameDisplayed = false;
		}

		log.info("Ending of isEventNameDisplayed method");

		return isEventNameDisplayed;
	}

	public boolean isEventLocationDisplayed() {
		log.info("Starting of isEventLocationDisplayed method");

		boolean isEventLocationDisplayed = false;
		try {
			for (WebElement location : lnkEventLocation) {
				if (location.isDisplayed() == true) {
					isEventLocationDisplayed = true;
				}
			}
		} catch (Exception e) {
			isEventLocationDisplayed = false;
		}

		log.info("Ending of isEventLocationDisplayed method");

		return isEventLocationDisplayed;
	}

	public boolean isEventCompetitionDatesDisplayed() {
		log.info("Starting of isEventCompetitionDatesDisplayed method");

		boolean isEventCompetitionDatesDisplayed = false;
		try {
			for (WebElement competitionDates : lnkEventCompetitionDates) {
				if (competitionDates.isDisplayed() == true) {
					isEventCompetitionDatesDisplayed = true;
				}
			}
		} catch (Exception e) {
			isEventCompetitionDatesDisplayed = false;
		}

		log.info("Ending of isEventCompetitionDatesDisplayed method");

		return isEventCompetitionDatesDisplayed;
	}

	public boolean isEventStatusesDisplayed() {
		log.info("Starting of isEventStatusesDisplayed method");

		boolean isEventStatusesDisplayed = false;
		try {
			for (WebElement status : lnkEventStatus) {
				if (status.isDisplayed() == true) {
					isEventStatusesDisplayed = true;
				}
			}
		} catch (Exception e) {
			isEventStatusesDisplayed = false;
		}

		log.info("Ending of isEventStatusesDisplayed method");

		return isEventStatusesDisplayed;
	}

	public boolean isDeleteEventDisplayed() {
		log.info("Starting of isDeleteEventDisplayed method");

		boolean isDeleteEventDisplayed = false;
		try {
			for (WebElement deleteEvent : lnkDeleteEvent) {
				if (deleteEvent.isDisplayed() == true) {
					isDeleteEventDisplayed = true;
				}
			}
		} catch (Exception e) {
			isDeleteEventDisplayed = false;
		}

		log.info("Ending of isDeleteEventDisplayed method");

		return isDeleteEventDisplayed;
	}

	public String getEventLabel() {
		log.info("Starting of getEventLabel method");

		log.info("Ending of getEventLabel method");

		return lblEvent.getText();
	}

	public boolean isDisableRegisterButtonDisplayed() {
		log.info("Starting of isDisableRegisterButtonDisplayed method");

		log.info("Ending of isDisableRegisterButtonDisplayed method");

		return btnRegisterDisable.isDisplayed();
	}

	public void clickOnRegisterButton() {
		log.info("Starting of clickonRegisterButton method");

		elementClick(btnRegister);

		log.info("Ending of clickonRegisterButton method");
	}

	public boolean isRegisterButtonDisplayed() {
		log.info("Starting of isRegisterButtonDisplayed method");
		log.info("Ending of isRegisterButtonDisplayed method");

		return btnRegister.isDisplayed();
	}

	public String getEventRegistrationLabel() {
		log.info("Starting of getEventRegistrationLabel method");
		log.info("Ending of getEventRegistrationLabel method");

		return lblEventRegistration.getText();
	}

	public String getRefundPolicyLabel() {
		log.info("Starting of getRefundPolicyLabel method");
		log.info("Ending of getRefundPolicyLabel method");

		return btnRefundPolicy.getText();
	}

	public String getHealthAndSafetyLabel() {
		log.info("Starting of getHealthAndSafetyLabel method");
		log.info("Ending of getHealthAndSafetyLabel method");

		return btnHealthSafetyPolicy.getText();

	}

	public String getLiabiltyPolicyLabel() {
		log.info("Starting of getLiabiltyPolicyLabel method");
		log.info("Ending of getLiabiltyPolicyLabel method");

		return btnLiabilityPolicy.getText();
	}

	public boolean isBracketsCheckBoxesDisplayed() {
		log.info("Starting of isBracketsCheckBoxesDisplayed method");

		boolean isCheckBoxDisplayed = false;

		for (WebElement eventsChkbox : lstcheckboxes) {

			if (!(eventsChkbox.isDisplayed())) {
				isCheckBoxDisplayed = false;
			}
			return isCheckBoxDisplayed = true;
		}

		log.info("Ending of isBracketsCheckBoxesDisplayed method");

		return isCheckBoxDisplayed;
	}

	public void clickOnEventRegistrationBackButton() {
		log.info("Starting of clickonEventRegistrationBackButton method");

		elementClick(btnEventRegistrationBack);

		log.info("Ending of clickonEventRegistrationBackButton method");
	}

	public void clickOnSelectYourBracketCheckbox() {
		log.info("Starting of clickonSelectYourBracketCheckbox method");

		elementClick(chkSelectBracket);

		log.info("Ending of clickonSelectYourBracketCheckbox method");
	}

	public void clickOnRefundPolicyCheckbox() {
		log.info("Starting of clickOnRefundPolicyCheckbox method");

		elementClick(chkRefundPolicy);

		log.info("Ending of clickOnRefundPolicyCheckbox method");
	}

	public void clickOnHealthSafetyPolicyCheckbox() {
		log.info("Starting of clickOnHealthSafetyPolicyCheckbox method");

		elementClick(chkHealthSafetyPolicy);

		log.info("Ending of clickOnHealthSafetyPolicyCheckbox method");
	}

	public void clickOnLiabilityCheckbox() {
		log.info("Starting of clickOnLiabilityCheckbox method");

		elementClick(chkLiabilityPolicy);

		log.info("Ending of clickOnLiabilityCheckbox method");
	}

	public boolean isBracketCheckboxSelected() {
		log.info("Starting of isBracketCheckboxSelected method");
		log.info("Ending of isBracketCheckboxSelected method");

		return chkSelectBracket.isSelected();
	}

	public boolean isRefundPolicyCheckboxSelected() {
		log.info("Starting of isRefundPolicyCheckboxSelected method");
		log.info("Ending of isRefundPolicyCheckboxSelected method");

		return chkRefundPolicy.isSelected();
	}

	public boolean isHealthSafetyPolicyCheckboxSelected() {
		log.info("Starting of isHealthSafetyPolicyCheckboxSelected method");
		log.info("Ending of isHealthSafetyPolicyCheckboxSelected method");

		return chkHealthSafetyPolicy.isSelected();
	}

	public boolean isLiabilityPolicyCheckboxSelected() {
		log.info("Starting of isLiabilityPolicyCheckboxSelected method");
		log.info("Ending of isLiabilityPolicyCheckboxSelected method");

		return chkLiabilityPolicy.isSelected();
	}

	public String getSuccessLabel() {
		log.info("Starting of getSuccessLabel method");
		log.info("Ending of getSuccessLabel method");

		return lblSuccess.getText();
	}

	public String getRegistrationCompletedLabel() {
		log.info("Starting of getRegistrationCompletedLabel method");
		log.info("Ending of getRegistrationCompletedLabel method");

		return lblRegistrationCompleted.getText();
	}

	public String getOkLabel() {
		log.info("Starting of getOkLabel method");
		log.info("Ending of getOkLabel method");

		return btnOK.getText();
	}

	public void clickOnOkButton() {
		log.info("Starting of clickOnOkButton method");

		elementClick(btnOK);

		log.info("Ending of clickOnOkButton method");
	}

	public boolean isRegisterButtonDisplayedForOnGoingEventCard() {
		log.info("Starting of isRegisterButtonDisplayedForOnGoingEventCard method");

		boolean isRegisterButtonDisplayedForOnGoingEventCard = true;
		for (int i = 0; i < 4; i++) {
			try {
				if (isDisplayed(lstOngoingEvents)) {
					clickOnElement(lstOngoingEvents);
					this.hardWait(3);
					try {
						if (btnRegister.isDisplayed()) {
							isRegisterButtonDisplayedForOnGoingEventCard = true;
						}

					} catch (Exception e) {
						isRegisterButtonDisplayedForOnGoingEventCard = false;
						break;
					}
				}

			} catch (Exception e) {
				this.scrollDown(1000);
			}

		}

		log.info("Ending of isRegisterButtonDisplayedForOnGoingEventCard method");

		return isRegisterButtonDisplayedForOnGoingEventCard;
	}

	public boolean isRegisterButtonDisplayedForCompleteEventCard() {
		log.info("Starting of isRegisterButtonDisplayedForCompleteEventCard method");

		boolean isRegisterButtonDisplayedForCompleteEventCard = true;
		for (int i = 0; i < 4; i++) {
			try {
				if (isDisplayed(lstCompletedEvents)) {
					clickOnElement(lstCompletedEvents);
					this.hardWait(3);
					try {
						if (btnRegister.isDisplayed()) {
							isRegisterButtonDisplayedForCompleteEventCard = true;
						}
					} catch (Exception e) {
						isRegisterButtonDisplayedForCompleteEventCard = false;
						break;
					}
				}
			} catch (Exception e) {
				this.scrollDown(1000);
			}
		}

		log.info("Ending of isRegisterButtonDisplayedForCompleteEventCard method");

		return isRegisterButtonDisplayedForCompleteEventCard;
	}

	public boolean isRegisterButtonDisplayedForRegistrationClosedEventCard() {
		log.info("Starting of isRegisterButtonDisplayedForRegistrationClosedEventCard method");

		boolean isRegisterButtonDisplayedForRegistrationClosedEventCard = true;
		for (int i = 0; i < 4; i++) {
			try {
				if (isDisplayed(lstRegistrationCompleted)) {
					clickOnElement(lstRegistrationCompleted);
					this.hardWait(3);
					try {
						if (btnRegister.isDisplayed()) {
							isRegisterButtonDisplayedForRegistrationClosedEventCard = true;
						}
					} catch (Exception e) {
						isRegisterButtonDisplayedForRegistrationClosedEventCard = false;
						break;
					}
				}
			} catch (Exception e) {
				this.scrollDown(1000);
			}
		}

		log.info("Ending of isRegisterButtonDisplayedForRegistrationClosedEventCard method");

		return isRegisterButtonDisplayedForRegistrationClosedEventCard;
	}

	public boolean isRegisterButtonDisplayedForUpcomingEventCard() {
		log.info("Starting of isRegisterButtonDisplayedForUpcomingEventCard method");

		boolean isRegisterButtonDisplayedForUpcomingEventCard = true;
		for (int i = 0; i < 4; i++) {
			try {
				if (isDisplayed(lstUpComingEvents)) {
					clickOnElement(lstUpComingEvents);
					this.hardWait(3);
					try {
						if (btnRegister.isDisplayed()) {
							isRegisterButtonDisplayedForUpcomingEventCard = true;
						}
					} catch (Exception e) {
						break;
					}
				}
			} catch (Exception e) {
				isRegisterButtonDisplayedForUpcomingEventCard = false;
				this.scrollDown(1000);
			}
		}

		log.info("Ending of isRegisterButtonDisplayedForUpcomingEventCard method");

		return isRegisterButtonDisplayedForUpcomingEventCard;
	}

	public boolean isRegisterButtonDisplayedForOpenEventCard() {
		log.info("Starting of isRegisterButtonDisplayedForOpenEventCard method");

		boolean isRegisterButtonDisplayedForOpenEventCard = true;
		for (int i = 0; i < 4; i++) {
			try {
				if (isDisplayed(lstOpenEvents)) {
					clickOnElement(lstOpenEvents);
					this.hardWait(3);
					try {
						if (btnRegister.isDisplayed()) {
							isRegisterButtonDisplayedForOpenEventCard = true;
						}
					} catch (Exception e) {
						break;
					}
				}
			} catch (Exception e) {
				this.scrollDown(1000);
			}
		}

		log.info("Ending of isRegisterButtonDisplayedForOpenEventCard method");

		return isRegisterButtonDisplayedForOpenEventCard;
	}

	public String getAddYourPartnerLabel() {
		log.info("Starting of getAddYourPartnerLabel method");
		log.info("Ending of getAddYourPartnerLabel method");

		return btnAddYourPartner.getText();
	}

	public void clickOnAddYourPartnerButton() {
		log.info("Starting of clickOnAddYourPartnerButton method");

		elementClick(btnAddYourPartner);

		log.info("Ending of clickOnAddYourPartnerButton method");
	}

	public String getViewQualifingPartnersLabel() {
		log.info("Starting of getViewQualifingPartnersLabel method");
		log.info("Ending of getViewQualifingPartnersLabel method");

		return lblViewQualifingPartners.getText();
	}

	public void clickOnAddYourPartnerRadioButton() {
		log.info("Starting of clickOnAddYourPartnerRadioButton method");

		elementClick(rdoAddYourPartner);

		log.info("Ending of clickOnAddYourPartnerRadioButton method");
	}

	public void clickOnAddPartnerButton() {
		log.info("Starting of clickOnAddPartnerButton method");

		elementClick(btnAddPartner);

		log.info("Ending of clickOnAddPartnerButton method");
	}

	public String getAddAPartnerLabel() {
		log.info("Starting of getAddAPartnerLabel method");
		log.info("Ending of getAddAPartnerLabel method");

		return lblAddaPartner.getText();
	}

	public String getCancelLabel() {
		log.info("Starting of getCancelLabel method");
		log.info("Ending of getCancelLabel method");

		return btnCancel.getText();
	}
}
