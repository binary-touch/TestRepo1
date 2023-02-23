package com.dupr.pages.events;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class PaidEventPage extends DUPRBaseAutomationPage {

	protected static float BracketPrice1;
	protected static float EventPrice1;
	protected static float TotalPrice1;
	private static final Logger log = LogManager.getLogger(PaidEventPage.class);

	@B2BFindBy(xpath = "//button[text()='Continue to Payment' and @disabled]")
	private WebElement btnContinuePaymentDisabled;

	@B2BFindBy(xpath = "//button[text()='Continue to Payment']")
	private WebElement btnContinuePayment;

	@B2BFindBy(xpath = "//a[@aria-label='Back to Todkars']")
	private WebElement btnBackTodkars;

	@B2BFindBy(xpath = "//h4[@id='customized-dialog-title']")
	private WebElement lblRegistrationUnsuccessful;

	@B2BFindBy(xpath = "//button[text()='OK']")
	private WebElement btnRegistrationUnsuccessfulOk;

	@B2BFindBy(xpath = "//h4[@id='customized-dialog-title']/button")
	private WebElement iconRegistrationUnsuccessfullClose;

	@B2BFindBy(xpath = "//span[text()='Event Base Price']/parent::div//following-sibling::div//following-sibling::div//following-sibling::div//following-sibling::div/span")
	private WebElement lblNonClubMembershipEventPrice;

	@B2BFindBy(xpath = "//span[text()='Event Base Price']/parent::div/parent::div/parent::div/parent::li/following-sibling::li/div/div/div/following-sibling::div/following-sibling::div/following-sibling::div/following-sibling::div/following-sibling::div/following-sibling::div/span")
	private WebElement lblNonClubMembershipBracketPrice;

	@B2BFindBy(xpath = "//div[text()='Pay with card']")
	private WebElement lblPayWithCard;

	@B2BFindBy(xpath = "//div[text()='meet@yopmail.com']")
	private WebElement lblMeetMail;

	@B2BFindBy(xpath = "//input[@name='cardNumber']")
	private WebElement txtBoxCardInformation;

	@B2BFindBy(xpath = "//input[@id='cardExpiry']")
	private WebElement txtBoxCardExpiry;

	@B2BFindBy(xpath = "//input[@id='cardCvc']")
	private WebElement txtBoxCardCVC;

	@B2BFindBy(xpath = "//input[@name='billingName']")
	private WebElement txtBoxNameOnCard;

	@B2BFindBy(xpath = "//button[@type='submit']")
	private WebElement btnPay;

	public PaidEventPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public boolean isContinuePaymentButtonDisabled() {
		log.info("Starting of isContinuePaymentButtonDisabled method");
		log.info("Ending of isContinuePaymentButtonDisabled method");

		return btnContinuePaymentDisabled.isDisplayed();
	}

	public void clickOnContinuePaymentButton() {
		log.info("Starting of clickOnContinuePaymentButton method");

		elementClick(btnContinuePayment);

		log.info("Ending of clickOnContinuePaymentButton method");
	}

	public void clickOnBackTodkarsButton() {
		log.info("Starting of clickOnBackTodkarsButton method");

		elementClick(btnBackTodkars);

		log.info("Ending of clickOnBackTodkarsButton method");
	}

	public boolean isRegistrationUnSuccessFullPageContains() {
		log.info("Starting of isRegistrationUnSuccessFulPageContains method");

		boolean isRegistrationUnSuccessFullPageContains = false;

		if (lblRegistrationUnsuccessful.isDisplayed() && btnRegistrationUnsuccessfulOk.isDisplayed()
				&& iconRegistrationUnsuccessfullClose.isDisplayed()) {
			isRegistrationUnSuccessFullPageContains = true;
		}

		log.info("Ending of isRegistrationUnSuccessFulPageContains method");

		return isRegistrationUnSuccessFullPageContains;
	}

	public void clickOnRegistrationUnsuccessfulOkButton() {
		log.info("Starting of clickOnRegistrationUnsuccessfulOkButton method");

		elementClick(btnRegistrationUnsuccessfulOk);

		log.info("Ending of clickOnRegistrationUnsuccessfulOkButton method");
	}

	public void clickOnRegistrationUnsuccessfullCloseButton() {
		log.info("Starting of clickOnRegistrationUnsuccessfullCloseButton method");

		elementClick(iconRegistrationUnsuccessfullClose);

		log.info("Ending of clickOnRegistrationUnsuccessfullCloseButton method");
	}

	public float getEventClubMemberPriceValue() {
		log.info("Starting of getEventClubMemberPriceValue method");

		System.out.println(lblNonClubMembershipEventPrice.getText());

		String EventPrice = lblNonClubMembershipEventPrice.getText().substring(1);

		float EventPrice1 = Float.parseFloat(EventPrice);
		System.out.println(EventPrice1);

		log.info("Ending of getEventClubMemberPriceValue method");

		return EventPrice1;
	}

	public float getBracketClubMemberPriceValue() {
		log.info("Starting of getBracketClubMemberPriceValue method");

		String BracketPrice = lblNonClubMembershipBracketPrice.getText().substring(1);

		float BracketPrice1 = Float.parseFloat(BracketPrice);
		System.out.println(BracketPrice1);

		log.info("Ending of getBracketClubMemberPriceValue method");

		return BracketPrice1;
	}

	public float getTotalMemberPriceValue() {
		log.info("Starting of getTotalMemberPriceValue method");

		String EventPrice = lblNonClubMembershipEventPrice.getText().substring(1);
		float EventPrice1 = Float.parseFloat(EventPrice);
		System.out.println(EventPrice1);

		String BracketPrice = lblNonClubMembershipBracketPrice.getText().substring(1);

		float BracketPrice1 = Float.parseFloat(BracketPrice);
		System.out.println(BracketPrice1);

		float TotalPrice1 = EventPrice1 + BracketPrice1;
		System.out.println(TotalPrice1);

		log.info("Ending of getTotalMemberPriceValue method");

		return TotalPrice1;
	}

	public float getEventNonClubMemberPriceValue() {
		log.info("Starting of getEventNonClubMemberPriceValue method");

		System.out.println(lblNonClubMembershipEventPrice.getText());
		String EventPrice = lblNonClubMembershipEventPrice.getText().substring(1);

		float EventPrice1 = Float.parseFloat(EventPrice);
		System.out.println(EventPrice1);

		log.info("Ending of getEventNonClubMemberPriceValue method");

		return EventPrice1;
	}

	public float getBracketNonClubMemberPriceValue() {
		log.info("Starting of getBracketNonClubMemberPriceValue method");

		String BracketPrice = lblNonClubMembershipBracketPrice.getText().substring(1);

		float BracketPrice1 = Float.parseFloat(BracketPrice);
		System.out.println(BracketPrice1);

		log.info("Ending of getBracketNonClubMemberPriceValue method");

		return BracketPrice1;
	}

	public float getTotalNonMemberPriceValue() {
		log.info("Starting of getTotalNonMemberPriceValue method");

		String EventPrice = lblNonClubMembershipEventPrice.getText().substring(1);
		float EventPrice1 = Float.parseFloat(EventPrice);
		System.out.println(EventPrice1);

		String BracketPrice = lblNonClubMembershipBracketPrice.getText().substring(1);

		float BracketPrice1 = Float.parseFloat(BracketPrice);
		System.out.println(BracketPrice1);

		float TotalPrice1 = EventPrice1 + BracketPrice1;
		System.out.println(TotalPrice1);

		log.info("Ending of getTotalNonMemberPriceValue method");

		return TotalPrice1;
	}

	public String getPayWithCardLabel() {
		log.info("Starting of getPayWithCardLabel method");
		log.info("Ending of getPayWithCardLabel method");

		return lblPayWithCard.getText();
	}

	public String getMeetMailLabel() {
		log.info("Starting of getMeetMailLabel method");
		log.info("Ending of getMeetMailLabel method");

		return lblMeetMail.getText();
	}

	public void setCardInformation(String cardInformation) {
		log.info("Starting of setCardInformation method");

		txtBoxCardInformation.sendKeys(cardInformation);

		log.info("Ending of setCardInformation method");
	}

	public void setBoxCardExpiry(String boxCardExpiry) {
		log.info("Starting of setBoxCardExpiry method");

		txtBoxCardExpiry.sendKeys(boxCardExpiry);

		log.info("Ending of setBoxCardExpiry method");
	}

	public void setBoxCardCVC(String boxCardCvc) {
		log.info("Starting of setBoxCardCVC method");

		txtBoxCardCVC.sendKeys(boxCardCvc);

		log.info("Ending of setBoxCardCVC method");
	}

	public void setBoxNameOnCard(String boxNameOnCard) {
		log.info("Starting of setBoxNameOnCard method");

		txtBoxNameOnCard.sendKeys(boxNameOnCard);

		log.info("Ending of setBoxNameOnCard method");
	}

	public void clickOnPayButton() {
		log.info("Starting of clickOnPayButton method");

		elementClick(btnPay);

		log.info("Ending of clickOnPayButton method");
	}
	
	
}
