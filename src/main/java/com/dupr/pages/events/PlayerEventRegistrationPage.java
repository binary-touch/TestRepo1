package com.dupr.pages.events;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class PlayerEventRegistrationPage extends DUPRBaseAutomationPage {
	private static final Logger log = LogManager.getLogger(DirectorEventRegistrationPage.class);

	@B2BFindBy(xpath = "//h6[text()='Events']")
	private WebElement tabEvents;
	
	@B2BFindBy(xpath = "//span[text()='Yes']/parent::label//input")
	private WebElement rdoYes;

	@B2BFindBy(xpath = "//h5[text()='Club Membership']")
	private WebElement lblClubMembership;

	@B2BFindBy(xpath = "//h4[contains(text(),'Ad')]")
	private WebElement lblPlayerClubName;

	@B2BFindBy(xpath = "//h3[text()='Event']")
	private WebElement lblEventHeading;

	@B2BFindBy(xpath = "//span[text()='Open']/parent::div/parent::div/parent::div/following-sibling::div//h4")
	private WebElement lblEventCard;

	@B2BFindBy(xpath = "//button[text()='Register']")
	private WebElement btnRegister;
	
	public PlayerEventRegistrationPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}
	
	/*
	 * public boolean isDisplayedEventPageContains() {
	 * log.info("Starting of isDisplayedEventPageContains method");
	 * 
	 * boolean isDisplayedRemoveAndReplaceContains = false;
	 * 
	 * if (isDisplayed(lblEvent) && isDisplayed(btnEventBack) &&
	 * isDisplayed(btnRegister) && isDisplayed(btnAddABracket) &&
	 * isDisplayed(btnEditEvent) && isDisplayed(btnEndEvent) &&
	 * isDisplayed(btnAddAnnouncement) && isDisplayed(btnShare) &&
	 * isDisplayed(btnShowDetails) && isDisplayed(tabBrackets) &&
	 * isDisplayed(tabAnnouncements) && isDisplayed(tabPolicies)) {
	 * 
	 * isDisplayedRemoveAndReplaceContains = true; }
	 * 
	 * log.info("Ending of isDisplayedEventPageContains method");
	 * 
	 * return isDisplayedRemoveAndReplaceContains; }
	 */
	public String getClubMembershipLabel() {
		log.info("Starting of getClubMembershipLabel method");
		
		log.info("Ending of getClubMembershipLabel method");

		return lblClubMembership.getText();
	}
	
	public String getPlayerClubNameLabel() {
		log.info("Starting of getPlayerClubNameLabel method");
		
		log.info("Ending of getPlayerClubNameLabel method");

		return lblPlayerClubName.getText();
	}

	
	public String getEventHeadingLabel() {
		log.info("Starting of getEventHeadingLabel method");
		
		log.info("Ending of getEventHeadingLabel method");

		return lblEventHeading.getText();
	}


	public void clickonClubMemberYesButton() {
		log.info("Starting of clickonClubMemberYesButton method");

		elementClick(rdoYes);

		log.info("Ending of clickonClubMemberYesButton method");
	}
	
	public boolean isClubMemberYesRadioButtonSelected() {
		log.info("Starting of isClubMemberYesRadioButtonSelected method");
		
		log.info("Ending of isClubMemberYesRadioButtonSelected method");

		return rdoYes.isSelected();
	}

	public void clickonEventCard() {
		log.info("Starting of clickonEventCard method");

		try {
			if (isDisplayed(lblEventCard)==true) {
				hardWait(2);
				clickOnElement(lblEventCard);
			}
				} catch (Exception e) {
					lblEventCard.click();
					e.printStackTrace();
				
				}
		log.info("Ending of clickonEventCard method");
	}

	public void clickonEventsTab() {
		log.info("Starting of clickonEventsTab method");

		elementClick(tabEvents);

		log.info("Ending of clickonEventsTab method");
	}
	
	public void clickonRegisterButton() {
		log.info("Starting of clickonRegisterButton method");

		elementClick(btnRegister);

		log.info("Ending of clickonRegisterButton method");
	}

	

}
