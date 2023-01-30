package com.dupr.pages.events;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class AddBracketNegativePage extends DUPRBaseAutomationPage {
	private static final Logger log = LogManager.getLogger(AddBracketPage.class);

	@B2BFindBy(xpath = "//span[@class='MuiTouchRipple-root css-w0pj6f']//parent::button[text()='Next Step']")
	private WebElement btnNextStep;

	@B2BFindBy(xpath = "//p[contains(text(),'*Contains Errors')]")
	private WebElement msgContainsErrors;

	@B2BFindBy(xpath = "//p[contains(text(),'Bracket Type is required')]")
	private WebElement msgBracketTypeRequired;

	@B2BFindBy(xpath = "//p[contains(text(),'Player group is required')]")
	private WebElement msgPlayerGroupRequired;
	
	@B2BFindBy(xpath = "//p[text()='Number of Court is required.']")
	private WebElement msgNoOfCourtsRequired;

	@B2BFindBy(xpath = "//p[text()='Minimum age is required.']")
	private WebElement msgMinAgeRequired;

	@B2BFindBy(xpath = "//p[text()='Maximum age is required.']")
	private WebElement msgMaxAgeRequired;

	@B2BFindBy(xpath = "//p[text()='Minimum rating is required.']")
	private WebElement msgMinRatingRequired;

	@B2BFindBy(xpath = "//p[text()='Maximum rating is required.']")
	private WebElement msgMaxRatingRequired;

	@B2BFindBy(xpath = "//p[contains( text(),'Bracket name is required')]")
	private WebElement msgBracketNameRequired;

	@B2BFindBy(xpath = "//p[contains( text(),'Event Type is required')]")
	private WebElement msgEventTypeRequired;

	@B2BFindBy(xpath = "//p[text()='Registration start date and time is required.']")
	private WebElement msgRegistrationStartDateRequired;

	@B2BFindBy(xpath = "//p[text()='Registration end date and time is required.']")
	private WebElement msgRegistrationEndDateRequired;

	@B2BFindBy(xpath = "//p[text()='Competition start date and time is required.']")
	private WebElement msgCompetitionStartDateRequired;

	@B2BFindBy(xpath = "//p[text()='Competition end date and time is required.']")
	private WebElement msgCompetitionEndRequired;

	@B2BFindBy(xpath = "//p[contains( text(),'Timezone is required.')]")
	private WebElement msgTimeZoneRequired;

	@B2BFindBy(xpath = "//p[contains(text(),'Club member price is required.')]")
	private WebElement msgClubMemberPriceRequired;

	@B2BFindBy(xpath = "//p[contains(text(),'Club non-member price is required.')]")
	private WebElement msgClubNonMemberPrice;

	@B2BFindBy(xpath = "//p[text()='Number of Teams is required.']")
	private WebElement msgNumberOfTeamsRequired;

	@B2BFindBy(xpath = "//p[text()='Waitlist is required.']")
	private WebElement msgWaitListRequired;

	@B2BFindBy(xpath="//h3[text()='Age Range']/parent::div//h5[text()='Minimum']/parent::div//following-sibling::div//input")
	private WebElement txtAgeRangeMinimum;
	
	@B2BFindBy(xpath="//span[@class='MuiTouchRipple-root css-w0pj6f']/parent::button[text()='Next Step']")
	private WebElement btnBracketNextStep;
	
	@B2BFindBy(xpath="//p[contains(text(),'Minimum age should be 2 years.')]")
	private WebElement msgMinAgeValidation;
	
	@B2BFindBy(xpath="//p[contains(text(),'Maximum age should be 105 years')]")
	private WebElement msgMaxAgeValidation;
	
	@B2BFindBy(xpath="//p[contains(text(),'Maximum age should be 105 years')]")
	private WebElement msgMinAgeInMaxValidation;
	
	@B2BFindBy(xpath="//p[contains(text(),'Maximum age should be higher than minimum age')]")
	private WebElement msgMaxAgeInMinrValidation;

	@B2BFindBy(xpath="//p[contains(text(),'Maximum rating should be 8.')]")
	private WebElement msgMinRatingRange;
	
	@B2BFindBy(xpath="//p[contains(text(),'Maximum rating should be higher than minimum rating.')]")
	private WebElement msgMaximumRatingRange;

	@B2BFindBy(xpath="//p[contains(text(),'Minimum rating should be 2')]")
	private WebElement msgMinRatingRangeValidation;

	@B2BFindBy(xpath="//button[text()='Auto Generate']")
	private WebElement btnAutoGenerate;
	
	@B2BFindBy(xpath="//h3[text()='Bracket Name']/following-sibling::div//input")
	private WebElement lblBracketNameAutoGenerate;

	@B2BFindBy(xpath="//h5[contains(text(),'Club nonmember Price')]/parent::div/following-sibling::div/div/p[contains(text(),'Price should be either 0 or greater than 1.00.')]")
	private WebElement msgBracketClubnonmemPrice;
	
	@B2BFindBy(xpath="//h5[contains(text(),'Club Member Price')]/parent::div/following-sibling::div/div/p[contains(text(),'Price should be either 0 or greater than 1.00.')]")
	private WebElement msgBracketClubMemPrice;
	
	@B2BFindBy(xpath="//p[text()='Minimum teams should be 2.']")
	private WebElement msgBracketNumberOfTeamsValidation;
	
	@B2BFindBy(xpath="//p[text()='Maximum 100 teams can join the bracket.']")
	private WebElement msgBracketNumberOfTeamsMaxValidation;

	@B2BFindBy(xpath="//p[text()='Minimum 0 teams can join the waitlist']")
	private WebElement msgBracketWaitlistNegativeValidation;
	
	@B2BFindBy(xpath="//p[text()='Maximum 50 teams can join the waitlist']")
	private WebElement msgBracketWaitlistMaxValidation;

	@B2BFindBy(xpath = "//p[contains(text(),'Please select different match type')]")
	private WebElement msgMixedGroupSinglesValidation;
	
	@B2BFindBy(xpath = "//h3[contains(text(),'Number of Courts')]//following-sibling::div//input[@disabled]")
	private WebElement lblRounRobinNumberOfCourts;
	
	@B2BFindBy(xpath = "//h3[contains(text(),'Number of Teams')]//following-sibling::div//input[@value='16' and @disabled]")
	private WebElement txtWaterFallNumberOfTeams;
	
	public AddBracketNegativePage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public void clickOnNextStepButton() {
		log.info("Starting of clickOnNextStepButton method");

		elementClick(btnNextStep);

		log.info("Ending of clickOnNextStepButton method");
	}

	public boolean isAddBracketFieldsWithEmptyDetailsDisplayed() {
		log.info("Starting of isAddBracketFieldsWithEmptyDetailsDisplayed method");

		boolean isAddBracketFieldsWithEmptyDetailsDisplayed = false;

		if (msgContainsErrors.isDisplayed() && msgBracketTypeRequired.isDisplayed()
				&& msgPlayerGroupRequired.isDisplayed() && msgMinAgeRequired.isDisplayed()
				&& msgMaxAgeRequired.isDisplayed() && msgMinRatingRequired.isDisplayed()
				&& msgMaxRatingRequired.isDisplayed() && msgBracketNameRequired.isDisplayed()
				&& msgEventTypeRequired.isDisplayed() && msgRegistrationStartDateRequired.isDisplayed()
				&& msgRegistrationEndDateRequired.isDisplayed() && msgCompetitionStartDateRequired.isDisplayed()
				&& msgCompetitionEndRequired.isDisplayed() && msgTimeZoneRequired.isDisplayed()
				&& msgClubMemberPriceRequired.isDisplayed() && msgClubNonMemberPrice.isDisplayed()
				&& msgNumberOfTeamsRequired.isDisplayed() && msgWaitListRequired.isDisplayed()) {

			isAddBracketFieldsWithEmptyDetailsDisplayed = true;
		}

		log.info("Ending of isAddBracketFieldsWithEmptyDetailsDisplayed method");

		return isAddBracketFieldsWithEmptyDetailsDisplayed;
	}
	
	public void setAgeRangeMinimum(String ageRangeMinimum) {
		log.info("Starting of setAgeRangeMinimum method");
		
			elementClick(txtAgeRangeMinimum);
	
		txtAgeRangeMinimum.sendKeys(ageRangeMinimum);

		log.info("Ending of setAgeRangeMinimum�method");
	}

	
	public void clickOnBracketNextStepButton() {
		log.info("Starting of clickOnBracketNextStepButton Method");
		
		elementClick(btnBracketNextStep);
		
		log.info("Ending of clickOnBracketNextStepButton Method");
	}
	
	public boolean isMinimumAgeValidationDisplayed() {
		log.info("Starting of isMinimumAgeValidationDisplayed method");
		log.info("Ending of isMinimumAgeValidationDisplayed method");

		return msgMinAgeValidation.isDisplayed();
	}    

	public boolean isMaximumAgeValidationDisplayed() {
		log.info("Starting of isMaximumAgeValidationDisplayed method");
		log.info("Ending of isMaximumAgeValidationDisplayed method");

		return msgMaxAgeValidation.isDisplayed();
	}
	
	public boolean isMaxAgeHigheThenMinrValidationDisplayed() {
		log.info("Starting of isMaxAgeHigheThenMinrValidationDisplayed method");
		log.info("Ending of isMaxAgeHigheThenMinrValidationDisplayed method");

		return msgMaxAgeInMinrValidation.isDisplayed();
	}
	
	public boolean isMinimumRatingRangeMessageDisplayed() {
		log.info("Starting of isMinimumRatingRangeMessageDisplayed method");
	    log.info("Ending of isMinimumRatingRangeMessageDisplayed method");

		return  msgMinRatingRange.isDisplayed();
	}
	
	public boolean isMinRatingRangeValidationMessageDisplayed() {
		log.info("Starting of isMinRatingRangeValidationMessageDisplayed method");
	    log.info("Ending of isMinRatingRangeValidationMessageDisplayed method");

		return  msgMinRatingRangeValidation.isDisplayed();
	}
	
	public boolean isAutoGenerateButtonEnabled() {
		log.info("Starting of isAutoGenerateButtonEnabled method");
	    hardWait(2);
	    scrollDown(200);
	    log.info("Ending of isAutoGenerateButtonEnabled method");

		return  btnAutoGenerate.isEnabled();
}
	
	public boolean isBracketNameAutoGenerated() {
		log.info("Starting of isBracketNameAutoGenerated method");
	    log.info("Ending of isBracketNameAutoGenerated method");

		return lblBracketNameAutoGenerate.getAttribute("value").isEmpty();
}

	public boolean isBracketClubMemNonMemValidationMsgDisplayed() {
		log.info("Starting of isBracketClubMemNonMemValidationMsgDisplayed method");

		boolean isBracketClubMemNonMemValidationMsgDisplayed = false;

		if (msgBracketClubnonmemPrice.isDisplayed() && msgBracketClubMemPrice.isDisplayed()) {
				
			isBracketClubMemNonMemValidationMsgDisplayed = true;
		}

		log.info("Ending of isBracketClubMemNonMemValidationMsgDisplayed method");

		return isBracketClubMemNonMemValidationMsgDisplayed;
	}

	public boolean isBracketNumberOfTeamsValidationMsgDisplayed() {
		log.info("Starting of isBracketNumberOfTeamsValidationMsgDisplayed method");
	    log.info("Ending of isBracketNumberOfTeamsValidationMsgDisplayed method");

		return  msgBracketNumberOfTeamsValidation.isDisplayed();
	}
	
	public boolean isBracketNumberOfTeamsMaxValidationMsgDisplayed() {
		log.info("Starting of isBracketNumberOfTeamsMaxValidationMsgDisplayed method");
	    log.info("Ending of isBracketNumberOfTeamsMaxValidationMsgDisplayed method");

		return  msgBracketNumberOfTeamsMaxValidation.isDisplayed();
	}
	
	public boolean isBracketWaitlistNegativeValidationMsgDisplayed() {
		log.info("Starting of isBracketWaitlistNegativeValidationMsgDisplayed method");
	    log.info("Ending of isBracketWaitlistNegativeValidationMsgDisplayed method");

		return  msgBracketWaitlistNegativeValidation.isDisplayed();
	}
	
	public boolean isBracketWaitListMaxValidationMsgDisplayed() {
		log.info("Starting of isBracketWaitListMaxValidationMsgDisplayed method");
	    log.info("Ending of isBracketWaitListMaxValidationMsgDisplayed method");

		return  msgBracketWaitlistMaxValidation.isDisplayed();
	}
	
	public boolean isMixedGroupSinglesValidationDisplayed() {
		log.info("Starting of isMixedGroupSinglesValidationDisplayed method");
	
		log.info("Ending of isMixedGroupSinglesValidationDisplayed method");
		return msgMixedGroupSinglesValidation.isDisplayed();
		
	}
	
	public boolean isRounRobinNumberOfCourtsDisplayed() {
		log.info("Starting of isMixedGroupSinglesValidationDisplayed method");
	
		log.info("Ending of isMixedGroupSinglesValidationDisplayed method");
		return lblRounRobinNumberOfCourts.isDisplayed();
		
	}
	
	public boolean isWaterFallNumberOfTeamsDisplayed() {
		log.info("Starting of isWaterFallNumberOfTeamsDisplayed method");
	
		log.info("Ending of isWaterFallNumberOfTeamsDisplayed method");
		return txtWaterFallNumberOfTeams.isDisplayed();
		
	}
	
	
}
