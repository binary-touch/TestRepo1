package com.dupr.pages.events;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class PaidEventPage extends DUPRBaseAutomationPage {
	private static final Logger log = LogManager.getLogger(PaidEventPage.class);

	@B2BFindBy(xpath = "//button[text()='Continue to Payment' and @disabled]")
	private WebElement btnContinuePaymentDisabled;

	@B2BFindBy(xpath = "//button[text()='Continue to Payment']")
	private WebElement btnContinuePayment;

	@B2BFindBy(xpath = "//h4[@id='customized-dialog-title']")
	private WebElement lblRegistrationUnsuccessful;

	@B2BFindBy(xpath = "//button[text()='OK']")
	private WebElement btnOk;

	@B2BFindBy(xpath = "//h4[@id='customized-dialog-title']/button")
	private WebElement icnRegistrationUnsuccessfulClose;

	@B2BFindBy(xpath = "//span[text()='Event Base Price']/parent::div//following-sibling::div//following-sibling::div//following-sibling::div//following-sibling::div/span/span")
	private WebElement lblNonClubMembershipEventPrice;

	public PaidEventPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public boolean isContinuePaymentDisabledDisplayed() {
		log.info("Starting of isContinuePaymentDisabledDisplayed method");
		log.info("Ending of isContinuePaymentDisabledDisplayed method");

		return btnContinuePaymentDisabled.isDisplayed();
	}

	public void clickOnContinuePaymentButton() {
		log.info("Starting of clickOnContinuePaymentButton method");
		
		elementClick(btnContinuePayment);
		
		log.info("Ending of clickOnContinuePaymentButton method");

	}

	/*
	 * public String getRegistrationEndDateTimeValue() {
	 * log.info("Starting of getRegistrationEndDateTimeText method");
	 * 
	 * System.out.println(txtRegistrationEndDateTime.getAttribute("value"));
	 * 
	 * String date = txtRegistrationEndDateTime.getAttribute("value").substring(0,
	 * 6); System.out.println(date);
	 * log.info("Ending of clickOnContinuePaymentButton method");
	 * 
	 * }
	 */

}
