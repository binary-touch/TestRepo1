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

public class WaterfallRoundOneSeedingLogicPage extends DUPRBaseAutomationPage {

	private static final Logger log = LogManager.getLogger(SeedMatchesWaterFallPage.class);

	@B2BFindBy(xpath = "//button[text()='Add Participants']")
	private WebElement btnAddParticipants;
	
	@B2BFindBy(xpath = "//button[text()='Add Participant']")
	private WebElement btnAddParticipant;
	
	@B2BFindBy(xpath = "//span[text()='No']")
	private WebElement rdoNo;
	
	@B2BFindBy(xpath = "//button[text()='Add']")
	private WebElement btnAdd;
	
	@B2BFindBy(xpath = "//h2[contains(text(),'Add a Bracket Participant')]/parent::div//h6[contains(text(),'Singles')]/parent::div//h2")
	private WebElement txtSinglesRating;
	
	public WaterfallRoundOneSeedingLogicPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public void getSinglesRating() {
		log.info("Starting of isQueueTabDisplayed method");
		 int j=0;
		 int k=0;
		 for (int i = 0; i < 9; i++) {
			this.hardWait(3);
			  clickOnWebElement(btnAddParticipants);
				this.hardWait(4);	
				
				 if(j<5) {
			  if (txtSinglesRating.getText().equals("NR")) {
				 
				  txtSinglesRating.click();
				  j++; 
				  }
				 
			  else {			 
				  if(k<4) {
					  txtSinglesRating.click();
					  k++;
				  }	
			  }}
		this.hardWait(3);
		clickOnElement(btnAddParticipant);
		this.hardWait(4);
		clickOnWebElement(rdoNo);
		this.hardWait(3);
		clickOnWebElement(btnAdd);
		this.hardWait(5);
		 }
		log.info("Ending of isQueueTabDisplayed method");
	}
}
