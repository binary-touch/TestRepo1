package com.dupr.pages.events;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class DirectorEventRegistrationPage extends DUPRBaseAutomationPage {
	private static final Logger log = LogManager.getLogger(DirectorEventRegistrationPage.class);

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
	
	@B2BFindBy(xpath = "//input[@type='checkbox']")
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
	
	@B2BFindBy(xpath = "//input[@type='radio']")
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
	
	
	public DirectorEventRegistrationPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}
	
	public boolean isDisplayedEventPageContains() {
		log.info("Starting of isDisplayedEventPageContains method");

		boolean isDisplayedRemoveAndReplaceContains = false;

		if (isDisplayed(lblEvent) && isDisplayed(btnEventBack) && isDisplayed(btnRegister)
				&& isDisplayed(btnAddABracket) && isDisplayed(btnEditEvent) && isDisplayed(btnEndEvent)
				&& isDisplayed(btnAddAnnouncement) && isDisplayed(btnShare) && isDisplayed(btnShowDetails)
				&& isDisplayed(tabBrackets) && isDisplayed(tabAnnouncements) && isDisplayed(tabPolicies)) {

			isDisplayedRemoveAndReplaceContains = true;
		}

		log.info("Ending of isDisplayedEventPageContains method");

		return isDisplayedRemoveAndReplaceContains;
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

	public void clickonRegisterButton() {
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
        return 	btnRefundPolicy.getText();
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
	
	public boolean isCheckBoxDisplayed() {
		log.info("Starting of getLiabiltyPolicyLabel method");
		boolean isCheckBoxDisplayed=false;
		for(WebElement eventsChkbox:lstcheckboxes) {
			if(!(eventsChkbox.isDisplayed())) {
				isCheckBoxDisplayed=false;
			}
			return isCheckBoxDisplayed=true;
		}
	
		log.info("Ending of getLiabiltyPolicyLabel method");
		
		return isCheckBoxDisplayed;

	}

	public void clickonEventRegistrationBackButton() {
		log.info("Starting of clickonEventRegistrationBackButton method");

		elementClick(btnEventRegistrationBack);

		log.info("Ending of clickonEventRegistrationBackButton method");
	}
	
	public void clickonSelectYourBracketCheckbox() {
		log.info("Starting of clickonSelectYourBracketCheckbox method");

		elementClick(chkSelectBracket);

		log.info("Ending of clickonSelectYourBracketCheckbox method");
	}
	 
	
	public void clickonRefundPolicyCheckbox() {
		log.info("Starting of clickonRefundPolicyCheckbox method");

		elementClick(chkRefundPolicy);

		log.info("Ending of clickonRefundPolicyCheckbox method");
	}
	
	public void clickonHealthSafetyPolicyCheckbox() {
		log.info("Starting of clickonHealthSafetyPolicyCheckbox method");

		elementClick(chkHealthSafetyPolicy);

		log.info("Ending of clickonHealthSafetyPolicyCheckbox method");
	}
	
	public void clickonLaibilityCheckbox() {
		log.info("Starting of clickonLaibilityCheckbox method");

		elementClick(chkLiabilityPolicy);

		log.info("Ending of clickonLaibilityCheckbox method");
	}
	
	public boolean isBracketCheckboxSelected() {
		log.info("Starting of getEventRegistrationLabel method");
		log.info("Ending of getEventRegistrationLabel method");
		return chkSelectBracket.isSelected();

	}
	
	public boolean isRefundPolicyCheckboxSelected() {
		log.info("Starting of getEventRegistrationLabel method");
		log.info("Ending of getEventRegistrationLabel method");
		return chkRefundPolicy.isSelected();

	}
	public boolean isHealthSafetyPolicyCheckboxSelected() {
		log.info("Starting of getEventRegistrationLabel method");
		log.info("Ending of getEventRegistrationLabel method");
		return chkHealthSafetyPolicy.isSelected();

	}
	public boolean isLiabilityPolicyCheckboxSelected() {
		log.info("Starting of getEventRegistrationLabel method");
		log.info("Ending of getEventRegistrationLabel method");
		return chkLiabilityPolicy.isSelected();

	}

	public String getSuccessLabel() {
		log.info("Starting of getSuccessLabel method");
		log.info("Ending of getSuccessLabel method");
        return 	lblSuccess.getText();
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

	public void clickOnAddPartnerRadioButton() {
		log.info("Starting of clickOnAddPartnerRadioButton method");

		elementClick(btnAddPartner);

		log.info("Ending of clickOnAddPartnerRadioButton method");
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
