package com.dupr.pages.events;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BFindBys;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class PlayerEventRegistrationPage extends DUPRBaseAutomationPage {
	private static final Logger log = LogManager.getLogger(EventRegistrationPage.class);

	@B2BFindBy(xpath = "//h6[text()='Events']")
	private WebElement tabEvents;

	@B2BFindBy(xpath = "//span[text()='Yes']/parent::label//input")
	private WebElement rdoYes;

	@B2BFindBy(xpath = "//span[text()='No']/parent::label//input")
	private WebElement rdoNo;

	@B2BFindBy(xpath = "//h5[text()='Club Membership']")
	private WebElement lblClubMembership;

	@B2BFindBy(xpath = "//h4[contains(text(),'Ad')]")
	private WebElement lblPlayerClubName;

	@B2BFindBy(xpath = "//h3[text()='Event']")
	private WebElement lblEventHeading;

	@B2BFindBys(@B2BFindBy(xpath = "//span[text()='Open']/parent::div/parent::div/parent::div/following-sibling::div//h4"))
	private List<WebElement> lstEventNameLink;
	
	@B2BFindBy(xpath = "//button[@aria-label='close']")
	private WebElement iconClose;
	
	@B2BFindBy(xpath = "//h3[text()='Event']/parent::div//button")
	private WebElement btnBack;

	@B2BFindBy(xpath = "//button[text()='Register']")
	private WebElement btnRegister;

	@B2BFindBy(xpath = "//h4[text()='No Qualifying Brackets']")
	private WebElement lblNoQualifyingBrackets;

	@B2BFindBy(xpath = "//h6[text()='Events']")
	private WebElement mnuEvents;
	
	@B2BFindBy(xpath = "//button[text()='Register']")
	private WebElement btnRegisterInEventRegistrationPage;

	public PlayerEventRegistrationPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

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

	public void clickOnClubMemberYesButton() {
		log.info("Starting of clickOnClubMemberYesButton method");

		elementClick(rdoYes);

		log.info("Ending of clickOnClubMemberYesButton method");
	}

	public void clickOnClubMemberNoButton() {
		log.info("Starting of clickOnClubMemberNoButton method");

		elementClick(rdoNo);

		log.info("Ending of clickOnClubMemberNoButton method");
	}

	public boolean isClubMemberYesRadioButtonSelected() {
		log.info("Starting of isClubMemberYesRadioButtonSelected method");
		log.info("Ending of isClubMemberYesRadioButtonSelected method");

		return rdoYes.isSelected();
	}

	public void clickOnEventCard() {
		log.info("Starting of clickOnEventCard method");

		for (WebElement eventName : lstEventNameLink) {
			try {
				clickOnElementUsingActionClass(eventName);
			} catch (Exception e) {
				clickOnWebElement(eventName);
			}
		}

		log.info("Ending of clickOnEventCard method");
	}

	public void clickOnRegisterButton() {
		log.info("Starting of clickOnRegisterButton method");

		for (int i = 1; i < lstEventNameLink.size(); i++) {
			this.hardWait(2);
			driver.findElement(
					By.xpath((("(//span[text()='Open']/parent::div/parent::div/parent::div/following-sibling::div//h4)["
							+ i + "]"))))
					.click();

			this.hardWait(5);
			clickOnElementUsingActionClass(btnRegister);
			try {
				if ((isDisplayed(lblNoQualifyingBrackets) == true)) {
					clickOnElementUsingActionClass(iconClose);
					clickOnElementUsingActionClass(btnBack);
				}
			} catch (Exception e) {
				log.info("Register Event Page displayed");
				break;
			}
		}

		log.info("Ending of clickOnRegisterButton method");
	}

	public void clickOnRegisterButtonInEventPage() {
		log.info("Starting of clickOnRegisterButton method");
		this.hardWait(5);
		clickOnElementUsingActionClass(btnRegister);

		log.info("Ending of clickOnRegisterButton method");
	}
	
	public void clickOnEventsMenu() {
		log.info("Starting of clickOnEventsMenu method");
        hardWait(4);
        try{
		clickOnWebElement(mnuEvents);
        }catch(Exception e) {
        	mnuEvents.click();
        }
        
		log.info("Ending of clickOnEventsMenu method");
	}
	
	public void clickOnRegisterButtonInEventRegPage() {
		log.info("Starting of clickOnRegisterButtonInEventRegPage method");

		clickOnWebElement(btnRegisterInEventRegistrationPage);

		log.info("Ending of clickOnRegisterButtonInEventRegPage method");
	}
}
