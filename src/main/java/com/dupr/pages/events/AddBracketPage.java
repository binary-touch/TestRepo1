package com.dupr.pages.events;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class AddBracketPage extends DUPRBaseAutomationPage {
	private static final Logger log = LogManager.getLogger(AddEventPage.class);

	@B2BFindBy(xpath="//h2[text()='Bracket #1']/parent::div/parent::div/parent::div/following-sibling::div")
	private WebElement drpBracket1;
	
	@B2BFindBy(xpath="//h3[text()='Type']/parent::div/div/div/div/div")
	private WebElement drpType;
	
	@B2BFindBy(xpath="//h3[text()='Player Group']/parent::div/div/div/div/div")
	private WebElement drpPlayerGroup;
	
	@B2BFindBy(xpath="//li[text()='Doubles']")
	private WebElement btnTypeDoubles;

	@B2BFindBy(xpath="//li[text()='Singles']")
	private WebElement btnTypeSingles;

	@B2BFindBy(xpath="//h3[text()='Type']/parent::div/div/div/following-sibling::div/div/div")
	private List<WebElement> lstType;

	@B2BFindBy(xpath="//h3[text()='Player Group']/parent::div/div/div/following-sibling::div/div/div")
	private List<WebElement> lstPlayGroup;

	@B2BFindBy(xpath="//li[text()='Open']")
	private WebElement btnPlayGroundOpen;

	@B2BFindBy(xpath="//li[text()='Mixed']")
	private WebElement btnPlayGroupMixed;

	@B2BFindBy(xpath="//h3[text()='Age Range']/parent::div/div/div/div/div/h5[text()='Minimum']/parent::div/following-sibling::div/div/div/input")
	private WebElement txtAgeRangeMinimum;

	@B2BFindBy(xpath="//h3[text()='Age Range']/parent::div/div/div/div/div/h5[text()='Maximum']/parent::div/following-sibling::div/div/div/input")
	private WebElement txtAgeRangeMaximum;

	@B2BFindBy(xpath="//h3[text()='Rating Range']/parent::div/div/div/div/div/h5[text()='Minimum']/parent::div/following-sibling::div/div/div/input")
	private WebElement txtRatingRangeMinimum;

	@B2BFindBy(xpath="//h3[text()='Rating Range']/parent::div/div/div/div/div/h5[text()='Maximum']/parent::div/following-sibling::div/div/div/input")
	private WebElement txtRatingRangeMaximum;

	@B2BFindBy(xpath="//button[text()='Auto Generate']")
	private WebElement btnAutoGenerate;
	
	@B2BFindBy(xpath="//h3[text()='Event Type']/parent::div/div/div/div/input")
	private WebElement drpEventType;
	
	@B2BFindBy(xpath="//li[text()='Round Robin']")
	private WebElement btnRoundRobin;

	@B2BFindBy(xpath="//li[text()='Waterfall']")
	private WebElement btnWaterfall;

	@B2BFindBy(xpath="//h3[text()='Registration Date']/parent::div/div/div/div/div/h5[text()='Start Date']/parent::div/following-sibling::div/div/div/div/button/span")
	private WebElement btnRegistrationStartDate;
	
	@B2BFindBy(xpath="//h3[text()='Registration Date']/parent::div/div/div/div/div/h5[text()='End Date']/parent::div/following-sibling::div/div/div/div/button/span")
	private WebElement btnRegistrationEndDate;
	
	@B2BFindBy(xpath="//h3[text()='Competition Date']/parent::div/div/div/div/div/h5[text()='Start Date']/parent::div/following-sibling::div/div/div/div/button/span")
	private WebElement btnRegistrationCompetitionStartDate;
	
	@B2BFindBy(xpath="//h3[text()='Competition Date']/parent::div/div/div/div/div/h5[text()='End Date']/parent::div/following-sibling::div/div/div/div/button/span")
	private WebElement btnRegistrationCompetitionEndDate;
	
	@B2BFindBy(xpath="//button[contains(@class, 'MuiButtonBase-root MuiPickersDay-root MuiPickersDay-dayWithMargin MuiPickersDay-today')]")
	private WebElement btnRegistrationDateToday;
	
	@B2BFindBy(xpath="//span[@role='option' and @aria-label='3 hours']")
	private WebElement btnRegistrationDateTodayhours;
	
	@B2BFindBy(xpath="//span[@role='option' and @aria-label='20 minutes']")
	private WebElement btnRegistrationDateTodayMinutes;
	
	@B2BFindBy(xpath="//button[@aria-label='calendar view is open, switch to year view']")
	private WebElement drpRegistrationEndDate;
	
	@B2BFindBy(xpath="//button[text()='2024']")
	private WebElement btnRegistrationEndDateNextYear;
	
	@B2BFindBy(xpath="//button[text()='2025']")
	private WebElement btnRegistrationCompetitionStartDateNextYear;
	
	@B2BFindBy(xpath="//button[text()='2026']")
	private WebElement btnRegistrationCompetitionEndDateNextYear;
	
	@B2BFindBy(xpath="//button[text()='9']")
	private WebElement btnRegistrationEndDateNextYearSelectDate;

	@B2BFindBy(xpath="//button[text()='18']")
	private WebElement btnRegistrationCompetitionStartDateNextYearSelectDate;
	
	@B2BFindBy(xpath="//span[text()='9']")
	private WebElement btnRegistrationEndDateNextYearSelectDateTime;
	
	@B2BFindBy(xpath="//span[text()='55']")
	private WebElement btnRegistrationEndDateNextYearSelectDateTimeMinutes;
	
	@B2BFindBy(xpath="//h3[text()='Time Zone']/parent::div/div/div/div")
	private WebElement drpTimeZone;
	
	@B2BFindBy(xpath="//li[contains(@class,'MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-xo32vf')]")
	private List <WebElement> lstTimeZone;
	
	@B2BFindBy(xpath="//li[text()='(GMT-06:00) Central America']")
	private WebElement btnCentalAmericaTimeZone;
	
	@B2BFindBy(xpath="//h3[text()='Bracket Price']/parent::div/div/div/div/div/h5[text()='Club Member Price']/parent::div/following-sibling::div/div/div/div/following-sibling::input")
	private WebElement txtBracketPriceClubMemberPrice;
	
	@B2BFindBy(xpath="//h3[text()='Bracket Price']/parent::div/div/div/div/div/h5[text()='Club nonmember Price']/parent::div/following-sibling::div/div/div/div/following-sibling::input")
	private WebElement txtBracketPriceNonClubMemberPrice;
	
	@B2BFindBy(xpath="//h3[text()='Number of Teams']/parent::div/div/div/div/div/div/input")
	private WebElement txtNumberOfTerms;
	
	@B2BFindBy(xpath="//h3[text()='Waitlist']/parent::div/div/div/div/div/div/input")
	private WebElement txtWaitlist;
	
	@B2BFindBy(xpath="//button[text()='No, Continue to Summary']")
	private WebElement btnNoContinueToSummary;
	
	@B2BFindBy(xpath="//h4[text()='Add Another Bracket?']")
	private WebElement lblAddAnotherBracket;
	
	@B2BFindBy(xpath="//h2[text()='Event Details']/parent::div/button")
	private WebElement btnEditEventDetails;
	
	@B2BFindBy(xpath="//button[text()='Publish Event']")
	private WebElement btnPublishEvent;
	
	@B2BFindBy(xpath="//h4[text()='Success']")
	private WebElement lblEventSuccess;
	
	@B2BFindBy(xpath="//h4[text()='Your event is now published.']")
	private WebElement lblYourEventIsNowPublished;
	
	@B2BFindBy(xpath="//h4[text()='Success']/button")
	private WebElement lblEventSuccessClosePopup;
	
	@B2BFindBy(xpath="//button[text()='Add Another Bracket']")
	private WebElement btnAddAnotherBracket;
	
	@B2BFindBy(xpath="//button[text()='Delete Bracket']")
	private WebElement btnDeleteBracket;
	
	
	public AddBracketPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}
	
	public void clickonBracket1Button() {
		  log.info("Starting of clickonBracket1Button method");
		 hardWait(2);
		  clickOnElementUsingActionClass(drpBracket1);
		  
		  log.info("Ending of clickonBracket1Button method"); }
		 
	public void clickonTypeDropdown() {
		log.info("Starting of clickonTypeDropdown method");

		clickOnElementUsingActionClass(drpType);
		
	    elementClick(btnTypeDoubles);
    
		log.info("Ending of clickonTypeDropdown method");
	}
	
	public void clickonPlayGroundDropdown() {
		log.info("Starting of clickonPlayGroundDropdown method");
		
		clickOnElementUsingActionClass(drpPlayerGroup);
		
		elementClick(btnPlayGroupMixed);
   
		log.info("Ending of clickonPlayGroundDropdown method");
	}
	public void setAgeRangeMinimum(String ageRangeMinimum) {
		log.info("Starting of setAgeRangeMinimum method");
       
        txtAgeRangeMinimum.click();
		
        txtAgeRangeMinimum.sendKeys(ageRangeMinimum);
		
		log.info("Ending of setAgeRangeMinimum method");

	}

	public void setAgeRangeMaximum(String ageRangeMaximum) {
		log.info("Starting of setAgeRangeMaximum method");
       
        txtAgeRangeMaximum.click();
		
        txtAgeRangeMaximum.sendKeys(ageRangeMaximum);
		
		log.info("Ending of setAgeRangeMaximum method");

	}

	public void setRatingRangeMinimum(String ageRatingRangeMinimum) {
		log.info("Starting of setRangeRangeMinimum method");
      
        txtRatingRangeMinimum.click();
	
        txtRatingRangeMinimum.sendKeys(ageRatingRangeMinimum);
		
		log.info("Ending of setRangeRangeMinimum method");

	}

	public void setRatingRangeMaximum(String ageRatingRangeMaximum) {
		log.info("Starting of setRangeRangeMaximum method");
     
        txtRatingRangeMaximum.click();
		
        txtRatingRangeMaximum.sendKeys(ageRatingRangeMaximum);
		
		log.info("Ending of setRangeRangeMaximum method");

	}

	public void clickOnAutoGenerate() {
		log.info("Starting of clickOnAutoGenerate method");
     
		elementClick(btnAutoGenerate);

		log.info("Ending of clickOnAutoGenerate method");
	}
	
	public void clickOnEventTypeDropdown() {
		log.info("Starting of clickOnEventTypeDropdown method");
		
		
		clickOnElementUsingActionClass(drpEventType);
		
	    elementClick(btnRoundRobin);
    
		log.info("Ending of clickOnEventTypeDropdown method");
	}
	
	public void clickOnRegistrationStartDate() {
		log.info("Starting of clickOnRegistrationStartDate method");
        
		hardWait(2);
		
		clickOnElementUsingActionClass(btnRegistrationStartDate);
		
		elementClick(btnRegistrationCompetitionStartDateNextYearSelectDate);
		
		clickOnElementUsingActionClass(btnRegistrationEndDateNextYearSelectDateTime);
		
		clickOnElementUsingActionClass(btnRegistrationEndDateNextYearSelectDateTimeMinutes);

		log.info("Ending of clickOnRegistrationStartDate method");
	}
	
	public void clickOnRegistrationEndDate() {
		log.info("Starting of clickOnRegistrationEndDate method");
		
		clickOnElementUsingActionClass(btnRegistrationEndDate);
		
		elementClick(drpRegistrationEndDate);
		
		hardWait(2);
		
		clickOnElementUsingActionClass(btnRegistrationEndDateNextYear);
		
		elementClick(btnRegistrationCompetitionStartDateNextYearSelectDate);
		
		clickOnElementUsingActionClass(btnRegistrationEndDateNextYearSelectDateTime);
		
		clickOnElementUsingActionClass(btnRegistrationEndDateNextYearSelectDateTimeMinutes);
		
		log.info("Ending of clickOnRegistrationEndDate method");
	}
	

	public void clickOnCompetitionStartDate() {
		log.info("Starting of clickOnCompetitionStartDate method");
		
		clickOnElementUsingActionClass(btnRegistrationCompetitionStartDate);
		
		elementClick(drpRegistrationEndDate);
		
		hardWait(2);
		
		elementClick(btnRegistrationCompetitionStartDateNextYear);
		
		elementClick(btnRegistrationCompetitionStartDateNextYearSelectDate);
		
		clickOnElementUsingActionClass(btnRegistrationEndDateNextYearSelectDateTime);
		
		clickOnElementUsingActionClass(btnRegistrationEndDateNextYearSelectDateTimeMinutes);
		
		log.info("Ending of clickOnCompetitionStartDate method");
	}
	
	public void clickOnCompetitionEndDate() {
		log.info("Starting of clickOnCompetitionEndDate method");
		
		clickOnElementUsingActionClass(btnRegistrationCompetitionEndDate);
		
		elementClick(drpRegistrationEndDate);
		
		hardWait(2);
		
		elementClick(btnRegistrationCompetitionEndDateNextYear);
		
		clickOnElementUsingActionClass(btnRegistrationCompetitionStartDateNextYearSelectDate);
		
		clickOnElementUsingActionClass(btnRegistrationEndDateNextYearSelectDateTime);
		
		clickOnElementUsingActionClass(btnRegistrationEndDateNextYearSelectDateTimeMinutes);
		
		log.info("Ending of clickOnCompetitionEndDate method");
	}
	
	
	public void clickOnTimeZoneDropdown() {
		log.info("Starting of clickOnTimeZoneDropdown method");
        hardWait(2);
		clickOnElementUsingActionClass(drpTimeZone);
		
		elementClick(btnCentalAmericaTimeZone);
		
		log.info("Ending of clickOnTimeZoneDropdown method");
	
	}	
		public void setBracketPriceClubMemberPrice(String clubMemberPrice) {
			log.info("Starting of setBracketPriceClubMemberPrice method");
	       
	        txtBracketPriceClubMemberPrice.click();
			
	        txtBracketPriceClubMemberPrice.sendKeys(clubMemberPrice);
			
			log.info("Ending of setBracketPriceClubMemberPrice method");

		}	
		
		public void setBracketPriceNonClubMemberPrice(String nonclubMemberPrice) {
			log.info("Starting of setBracketPriceNonClubMemberPrice method");
	      
	        txtBracketPriceNonClubMemberPrice.click();
		
	        txtBracketPriceNonClubMemberPrice.sendKeys(nonclubMemberPrice);
			
			log.info("Ending of setBracketPriceNonClubMemberPrice method");

		}	
		
		public void setNumberOfTerms(String numberOfTerms) {
			log.info("Starting of setNumberOfTerms method");
	       
	        txtNumberOfTerms.click();
			
	        txtNumberOfTerms.sendKeys(numberOfTerms);
			
			log.info("Ending of setNumberOfTerms method");

		}	

		public void setWaitlist(String waitlist) {
			log.info("Starting of setWaitlist method");
	       
	        txtWaitlist.click();
			
	        txtWaitlist.sendKeys(waitlist);
			
			log.info("Ending of setWaitlist method");

		}	

		public void clickOnNoContinueToSummary() {
			log.info("Starting of clickOnNoContinueToSummary method");

			elementClick(btnNoContinueToSummary);

			log.info("Ending of clickOnNoContinueToSummary method");
		}
		
		public void clickOnPublishEventButton() {
			log.info("Starting of clickOnPublishEventButton method");

			elementClick(btnPublishEvent);

			log.info("Ending of clickOnPublishEventButton method");
		}
		
		public void clickOnEventSuccessClosePopupButton() {
			log.info("Starting of clickOnEventSuccessClosePopupButton method");

			elementClick(lblEventSuccessClosePopup);

			log.info("Ending of clickOnEventSuccessClosePopupButton method");
		}
		
		public void clickOnAddAnotherBracketButton() {
			log.info("Starting of clickOnAddAnotherBracketButton method");

			elementClick(btnAddAnotherBracket);

			log.info("Ending of clickOnAddAnotherBracketButton method");
		}
		public void clickOnDeleteBracketButton() {
			log.info("Starting of clickOnDeleteBracketButton method");

			elementClick(btnDeleteBracket);

			log.info("Ending of clickOnDeleteBracketButton method");
		}
		
 }
