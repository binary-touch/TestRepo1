package com.dupr.pages.events;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class AddEventNegativePage extends DUPRBaseAutomationPage {
	private static final Logger log = LogManager.getLogger(AddEventNegativePage.class);

	@B2BFindBy(xpath = "//p[contains(text(),'Event name is required.')]")
	private WebElement msgEventNameisRequired;

	@B2BFindBy(xpath = "//h5[contains(text(),'Member Price')]/parent::div/following-sibling::div/div/p[contains(text(),'Club member price is required.')]")
	private WebElement msgMemberPriceOnlyNumbersAreAllowed;

	@B2BFindBy(xpath = "//h5[contains(text(),'Member Price')]/parent::div/following-sibling::div//p[text()='price field must have 2 digits after decimal or less']")
	private WebElement msgMemberPriceFieldDigitsAfterDecimal;

	@B2BFindBy(xpath = "//h5[contains(text(),'Nonmember Price')]/parent::div/following-sibling::div//p[text()='price field must have 2 digits after decimal or less']")
	private WebElement msgNonmemberPriceFieldDigitsAfterDecimal;

	@B2BFindBy(xpath = "//h5[contains(text(),'Nonmember Price')]/parent::div/following-sibling::div/div/p[contains(text(),'Club non-member price is required.')]")
	private WebElement msgNonMemberPriceOnlyNumbersAreAllowed;

	@B2BFindBy(xpath = "//p[contains(text(),'Event description is required.')]")
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
	private WebElement msgLiabilityWaiverinvalidLogo;

	public AddEventNegativePage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public boolean isEventWithEmptyFieldsContainsDisplayed() {
		log.info("Starting of isEventWithEmptyFieldsContainsDisplayed method");

		boolean isEventWithEmptyFieldsContainsDisplayed = false;

		/*
		 * System.out.println(msgEventNameisRequired.isDisplayed());
		 * System.out.println(msgMemberPriceOnlyNumbersAreAllowed.isDisplayed());
		 * System.out.println(msgNonMemberPriceOnlyNumbersAreAllowed.isDisplayed());
		 * System.out.println(msgEventDescriptionisRequired.isDisplayed());
		 */
		if (msgEventNameisRequired.isDisplayed() && msgMemberPriceOnlyNumbersAreAllowed.isDisplayed()
				&& msgNonMemberPriceOnlyNumbersAreAllowed.isDisplayed()
				&& msgEventDescriptionisRequired.isDisplayed()) {

			isEventWithEmptyFieldsContainsDisplayed = true;
		}

		log.info("Ending of isEventWithEmptyFieldsContainsDisplayed method");

		return isEventWithEmptyFieldsContainsDisplayed;
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

	public boolean isLiabilityWaiverinvalidLogoDisplayed() {
		log.info("Starting of isMaximumCharsValidationDisplayed method");

		log.info("Ending of isMaximumCharsValidationDisplayed method");
		return msgLiabilityWaiverinvalidLogo.isDisplayed();

	}

	public void clickonRemovelogoIcon() {
		log.info("Starting of clickonDragandDropImageButton method");

		this.waitForElementToBeVisible(iconRemovelogo);
		elementClick(iconRemovelogo);

		log.info("Ending of clickonDragandDropImageButton method");
	}
}
