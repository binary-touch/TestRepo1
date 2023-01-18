package com.dupr.pages.events;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class AddParticipantsInBracketsPage extends DUPRBaseAutomationPage{
	private static final Logger log = LogManager.getLogger(AddParticipantsInBracketsPage.class);

	@B2BFindBy(xpath = "//button[contains(text(),'Add Event')]")
	private WebElement btnAddEvent;

	@B2BFindBy(xpath = "//h1[contains(text(),'Event Information')]")
	private WebElement lblEventInformation;

	@B2BFindBy(xpath = "//h5[text()='Event Name']")
	private WebElement lblEventName;
	
	public AddParticipantsInBracketsPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

}
