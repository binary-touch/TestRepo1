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
	private WebElement icnRegistrationUnsuccessfulClose;

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
	private WebElement txtBoxCardCvc;

	@B2BFindBy(xpath = "//input[@name='billingName']")
	private WebElement txtBoxNameOnCardCard;

	@B2BFindBy(xpath = "//input[@id='enableStripePass']")
	private WebElement chkSecurlySaveInf;

	@B2BFindBy(xpath = "//button[@type='submit']")
	private WebElement btnPay;

	
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

	public void clickOnBackTodkarsButton() {
		log.info("Starting of clickOnBackTodkarsButton method");

		elementClick(btnBackTodkars);

		log.info("Ending of clickOnBackTodkarsButton method");

	}

	public boolean isRegistrationUnSuccessFulPageContains() {

		log.info("Starting of isRegistrationUnSuccessFulPageContains method");

		boolean isRegistrationUnSuccessFulPageContains = false;

		if (lblRegistrationUnsuccessful.isDisplayed() && btnRegistrationUnsuccessfulOk.isDisplayed()
				&& icnRegistrationUnsuccessfulClose.isDisplayed()) {
			isRegistrationUnSuccessFulPageContains = true;
		}

		log.info("Ending of isRegistrationUnSuccessFulPageContains method");

		return isRegistrationUnSuccessFulPageContains;
	}

	public void clickOnRegistrationUnsuccessfulOkButton() {
		log.info("Starting of clickOnRegistrationUnsuccessfulOkButton method");

		elementClick(btnRegistrationUnsuccessfulOk);

		log.info("Ending of clickOnRegistrationUnsuccessfulOkButton method");

	}

	public void clickOnRegistrationUnsuccessfulCloseButton() {
		log.info("Starting of clickOnRegistrationUnsuccessfulCloseButton method");

		elementClick(icnRegistrationUnsuccessfulClose);

		log.info("Ending of clickOnRegistrationUnsuccessfulCloseButton method");

	}

	public float getEvenClubMemberPriceValue() {
		log.info("Starting of getEvenClubMemberPriceValue method");

		System.out.println(lblNonClubMembershipEventPrice.getText());

		String EventPrice = lblNonClubMembershipEventPrice.getText().substring(1);
		
		float EventPrice1=Float.parseFloat(EventPrice);
		System.out.println(EventPrice1);

		log.info("Ending of getEvenClubMemberPriceValue method");

		return EventPrice1;
	}

	public float getBracketClubMemberPriceValue() {
		log.info("Starting of getBracketClubMemberPriceValue method");

		String BracketPrice = lblNonClubMembershipBracketPrice.getText().substring(1);
		
		float BracketPrice1=Float.parseFloat(BracketPrice);
		System.out.println(BracketPrice1);

		log.info("Ending of getBracketClubMemberPriceValue method");

		return BracketPrice1;
	}

	public float getToatalMemberPriceValue() {
		log.info("Starting of getToatalMemberPriceValue method");

		//System.out.println(lblNonClubMembershipEventPrice.getText());

		String EventPrice = lblNonClubMembershipEventPrice.getText().substring(1);
		float EventPrice1 = Float.parseFloat(EventPrice);
		System.out.println(EventPrice1);

		String BracketPrice = lblNonClubMembershipBracketPrice.getText().substring(1);

		float BracketPrice1 = Float.parseFloat(BracketPrice);
		System.out.println(BracketPrice1);
		
		float TotalPrice1 = EventPrice1 + BracketPrice1;
		//float TotalPrice1 = Float.parseFloat(EventPrice);
		System.out.println(TotalPrice1);

		log.info("Ending of getToatalMemberPriceValue method");

		return TotalPrice1;
	}
	

	public float getEventNonClubMemberPriceValue() {
		log.info("Starting of getEventNonClubMemberPriceValue method");

		System.out.println(lblNonClubMembershipEventPrice.getText());

		String EventPrice = lblNonClubMembershipEventPrice.getText().substring(1);
		
		float EventPrice1=Float.parseFloat(EventPrice);
		System.out.println(EventPrice1);

		log.info("Ending of getEventNonClubMemberPriceValue method");

		return EventPrice1;
	}

	public float getBracketNonClubMemberPriceValue() {
		log.info("Starting of getBracketNonClubMemberPriceValue method");

		String BracketPrice = lblNonClubMembershipBracketPrice.getText().substring(1);
		
		float BracketPrice1=Float.parseFloat(BracketPrice);
		System.out.println(BracketPrice1);

		log.info("Ending of getBracketNonClubMemberPriceValue method");

		return BracketPrice1;
	}

	public float getToatalNonMemberPriceValue() {
		log.info("Starting of getToatalNonMemberPriceValue method");

		//System.out.println(lblNonClubMembershipEventPrice.getText());

		String EventPrice = lblNonClubMembershipEventPrice.getText().substring(1);
		float EventPrice1 = Float.parseFloat(EventPrice);
		System.out.println(EventPrice1);

		String BracketPrice = lblNonClubMembershipBracketPrice.getText().substring(1);

		float BracketPrice1 = Float.parseFloat(BracketPrice);
		System.out.println(BracketPrice1);
		
		float TotalPrice1 = EventPrice1 + BracketPrice1;
		//float TotalPrice1 = Float.parseFloat(EventPrice);
		System.out.println(TotalPrice1);

		log.info("Ending of getToatalNonMemberPriceValue method");

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

    public void setBoxCardCvc(String boxCardCvc) {
		
		log.info("Starting of setBoxCardCvc method");
		
		txtBoxCardCvc.sendKeys(boxCardCvc);
		
		log.info("Ending of setBoxCardCvc method");

	}

    public void setBoxNameOnCard(String boxNameOnCard) {
		
		log.info("Starting of setBoxNameOnCard method");
		
		txtBoxNameOnCardCard.sendKeys(boxNameOnCard);
		
		log.info("Ending of setBoxNameOnCard method");

	}

    public void clickOnSecurlySaveInfButton() {
		log.info("Starting of clickOnSecurlySaveInfButton method");

		elementClick(chkSecurlySaveInf);

		log.info("Ending of clickOnSecurlySaveInfButton method");

	}
    
    public void clickOnPayButton() {
		log.info("Starting of clickOnPayButton method");

		elementClick(btnPay);

		log.info("Ending of clickOnPayButton method");

	}
    
}
