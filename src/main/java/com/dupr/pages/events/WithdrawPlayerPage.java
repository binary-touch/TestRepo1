package com.dupr.pages.events;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class WithdrawPlayerPage extends DUPRBaseAutomationPage {

	private static final Logger log = LogManager.getLogger(WithdrawPlayerPage.class);

	@B2BFindBy(xpath = "//button[text()='Unmatched Players']")
	private WebElement tabUnmatchedPlayes;

	@B2BFindBy(xpath = "(//h4[contains(@class,'MuiTypography-root MuiTypography-h4')])")
	private List<WebElement> lblBracket;

	@B2BFindBy(xpath = "//*[contains(@class,'MuiSvgIcon-root MuiSvgIcon-colorPrimary MuiSvgIcon-fontSizeMedium')]")
	private WebElement btnBack;

	@B2BFindBy(xpath = "//button[text()='Withdraw/Refund']")
	private WebElement btnWithdraw;

	@B2BFindBy(xpath = "//button[text()='Withdraw/Refund']")
	private List<WebElement> btnWithdrawRefund;

	@B2BFindBy(xpath = "//button[text()='Players']")
	private WebElement tabPlayers;

	@B2BFindBy(xpath = "//button[text()='Add Participants']")
	private WebElement btnAddParticipants;

	@B2BFindBy(xpath = "//input[@type='radio']")
	private WebElement btnRadio;

	@B2BFindBy(xpath = "//button[text()='Add Participant']")
	private WebElement btnAddParticipant;

	@B2BFindBy(xpath = "//button[text()='Add']")
	private WebElement btnAdd;

	@B2BFindBy(xpath = "//span[text()='No']")
	private WebElement rdoNo;

	@B2BFindBy(xpath = "//p[contains(text(),'Please select any two')]")
	private WebElement txtinstruction;

	@B2BFindBy(xpath = "//button[text()='Create Team']")
	private WebElement btnCreateTeam;

	@B2BFindBy(xpath = "//input[@type='checkbox']")
	private WebElement chkPlayer;

	@B2BFindBy(xpath = "//input[@type='checkbox']/parent::span/following-sibling::span//h4")
	private WebElement txtName;

	@B2BFindBy(xpath = "//input[@type='checkbox']/parent::span/following-sibling::span//h4/following-sibling::p")
	private WebElement txtEmail;

	@B2BFindBy(xpath = "//input[@type='checkbox']/parent::span/following-sibling::span//h4/parent::div//div")
	private WebElement txtPaymentStatus;

	@B2BFindBy(xpath = "//h6[text()='Doubles']")
	private WebElement txtDoubles;

	@B2BFindBy(xpath = "//h6[text()='Singles']")
	private WebElement txtSingles;

	@B2BFindBy(xpath = "//h6[contains(text(),'Home')]")
	private WebElement mnuHome;

	@B2BFindBy(xpath = "//h4[text()='Withdraw/Refund']")
	private WebElement txtWithdrawRefund;

	@B2BFindBy(xpath = "//h4[text()='Withdraw/Refund']//button")
	private WebElement iconCloseOnWithdrawRefund;

	@B2BFindBy(xpath = "//h4[text()='Withdraw']")
	private WebElement txtWithdraw;

	@B2BFindBy(xpath = "//h4[text()='Withdraw']//button//*")
	private WebElement iconCloseOnWithdraw;

	@B2BFindBy(xpath = "//h4[text()='Withdraw and Refund']//button")
	private WebElement iconCloseWithdrawRefund;

	@B2BFindBy(xpath = "//h4[text()='Refund Only']//button")
	private WebElement iconCloseRefund;

	@B2BFindBy(xpath = "//h4[text()='Withdraw and Refund']")
	private WebElement txtWithdrawAndRefund;

	@B2BFindBy(xpath = "//h4[text()='Refund Only']")
	private WebElement txtRefundOnly;

	@B2BFindBy(xpath = "//h5[contains(text(),'Total:')]")
	private WebElement txtTotal;

	@B2BFindBy(xpath = "//h5[contains(text(),'Step 1: Please select')]")
	private WebElement txtStepOne;

	@B2BFindBy(xpath = "(//h6[contains(text(),'₹')])[2]")
	private WebElement txtRupees;

	@B2BFindBy(xpath = "//span[text()='Withdraw']")
	private WebElement rdoWithdraw;

	@B2BFindBy(xpath = "//span[text()='Withdraw and Refund']")
	private WebElement rdoWIthdrawRefund;

	@B2BFindBy(xpath = "//span[text()='Refund Only']")
	private WebElement rdoRefund;

	@B2BFindBy(xpath = "//button[text()='Back']")
	private WebElement btnBackWithdraw;

	@B2BFindBy(xpath = "//button[text()='Next']")
	private WebElement btnNext;

	@B2BFindBy(xpath = "//p[text()='options is a required field']")
	private WebElement txtOptionValidation;

	@B2BFindBy(xpath = "//h5[contains(text(),'Step 2: Registered')]")
	private WebElement txtStepTwo;

	@B2BFindBy(xpath = "//p[contains(text(),'Select atleast')]")
	private WebElement txtSelectValidation;

	@B2BFindBy(xpath = "//div[contains(@class, 'MuiDialog-paper MuiDialog-paperScrollPaper')]//label[2]//input[@type='checkbox']")
	private WebElement chkBracket;

	@B2BFindBy(xpath = "//h4[contains(text(),'Confirmation')]")
	private WebElement txtConfirmation;

	@B2BFindBy(xpath = "//span[contains(@class, 'MuiBox-root') and contains(.,'Free Bracket')]")
	private WebElement chkFreeBracket;

	@B2BFindBy(xpath = "//h4[contains(text(),'Confirmation')]//button")
	private WebElement iconCLoseConfirmation;

	@B2BFindBy(xpath = "//button[contains(text(),'Confirm')]")
	private WebElement btnConfirm;

	@B2BFindBy(xpath = "//h4[contains(text(),'SUCCESS')]")
	private WebElement txtSucess;

	@B2BFindBy(xpath = "//h4[contains(text(),'SUCCESS')]//button")
	private WebElement iconClosSucess;

	@B2BFindBy(xpath = "//h6[contains(text(),'You have successfully')]")
	private WebElement txtSucessConfirmation;

	@B2BFindBy(xpath = "//button[text()='Withdraw/Refund']/ancestor::span//h4")
	private WebElement txtPlayerName;

	@B2BFindBy(xpath = "//input[@id='Search']")
	private WebElement txtSearchBox;

	@B2BFindBy(xpath = "//span[text()='No results found!']")
	private WebElement txtNoResults;

	public WithdrawPlayerPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public void clickOnBracketLabel() {
		log.info("Starting of clickOnEventLabel method");

		for (int i = 1; i < lblBracket.size(); i++) {
			this.hardWait(3);
			driver.findElement(
					By.xpath((("(//h4[contains(@class,'MuiTypography-root MuiTypography-h4')])[" + i + "]")))).click();

			this.hardWait(3);
			try {
				if ((isDisplayed(tabUnmatchedPlayes) == true)) {
					clickOnElement(tabUnmatchedPlayes);

					try {

						if (isDisplayed(btnWithdraw) == true) {
							break;
						}

					} catch (Exception e) {
						try {
							if (isDisplayed(tabPlayers) == true) {
								clickOnElement(tabPlayers);
								try {

									if (isDisplayed(btnAddParticipants)) {
										clickOnElement(btnAddParticipants);
										this.hardWait(4);
										clickOnWebElement(btnRadio);
										clickOnWebElement(btnAddParticipant);
										this.hardWait(2);
										clickOnElement(rdoNo);
										clickOnWebElement(btnAdd);
										this.hardWait(3);

										try {
											clickOnElement(tabUnmatchedPlayes);
											if (isDisplayed(btnWithdraw) == true) {
												break;
											}
										} catch (Exception e2) {
											clickOnElement(btnBack);
										}
									}
								} catch (Exception e2) {
									clickOnElement(btnBack);
								}
							}
						} catch (Exception e2) {
							clickOnElement(btnBack);
						}
					}
				}
			} catch (Exception e) {
				clickOnElement(btnBack);
			}
		}
		log.info("Ending of clickOnEventLabel method");
	}

	public boolean isUnMatchedPlayersTabContains() {
		log.info("Starting of isUnMatchedPlayrsTabContains method");

		boolean isUnMatchedPlayrsTabContains = false;
		this.scrollDown(200);
		try {
			if (isDisplayed(btnCreateTeam) 
					&& isDisplayed(txtName)
					&& isDisplayed(txtEmail)
					&& isDisplayed(txtPaymentStatus)
					&& isDisplayed(txtDoubles)
					&& isDisplayed(txtSingles)
					&& isDisplayed(btnWithdraw)) {
				isUnMatchedPlayrsTabContains = true;
			}
		} catch (Exception e) {
			System.out.println(" ");
		}

		log.info("Ending of isUnMatchedPlayersTabContains method");

		return isUnMatchedPlayrsTabContains;
	}

	public void clickOnWithdrawButton() {
		log.info("Starting of clickOnWithdrawButton method");
		this.scrollDown(150);
		try {
			// clickOnElementUsingActionClass(btnWithdraw);
			btnWithdraw.click();
			this.hardWait(2);
		} catch (Exception e) {
			elementClick(btnWithdraw);
			this.hardWait(2);
		}

		log.info("Ending of clickOnWithdrawButton method");
	}

	public void clickOnFreeBracket() {
		log.info("Starting of clickOnFreeBracket method");

		clickOnElement(chkFreeBracket);
		this.hardWait(2);

		log.info("Ending of clickOnWithdrawButton method");
	}

	public boolean isWithdrawRefundPopUpContains() {
		log.info("Starting of isWithdrawRefundPopUpContains method");

		boolean isWithdrawRefundPopUpContains = false;

		try {
			if (isDisplayed(btnNext) 
					&& isDisplayed(btnBackWithdraw) 
					&& isDisplayed(rdoRefund)
					&& isDisplayed(rdoWIthdrawRefund)
					&& isDisplayed(rdoWithdraw)
					&& isDisplayed(txtStepOne)
					&& isDisplayed(iconCloseOnWithdrawRefund)
					&& isDisplayed(txtWithdrawRefund)) {
				isWithdrawRefundPopUpContains = true;
			}
		} catch (Exception e) {
			isWithdrawRefundPopUpContains = false;
		}

		log.info("Ending of isWithdrawRefundPopUpContains method");

		return isWithdrawRefundPopUpContains;
	}

	public void clickOnCloseIconOnWIthdrawRefund() {
		log.info("Starting of clickOnCloseIconOnWIthdrawRefund method");
		try {
			clickOnWebElement(iconCloseOnWithdrawRefund);
			this.hardWait(2);
		} catch (Exception e) {
			elementClick(iconCloseOnWithdrawRefund);
			this.hardWait(2);
		}

		log.info("Ending of clickOnCloseIconOnWIthdrawRefund method");
	}

	public void clickOnNextButton() {
		log.info("Starting of clickOnCloseIcon method");

		clickOnWebElement(btnNext);
		this.hardWait(2);

		log.info("Ending of clickOnCloseIcon method");
	}

	public String getOptionValidationTxt() {
		log.info("Starting of getOptionValidationTxt method");
		log.info("Ending of getOptionValidationTxt method");

		return getText(txtOptionValidation);
	}

	public void clickOnRadioWithdraw() {
		log.info("Starting of clickOnCloseIcon method");

		clickOnWebElement(rdoWithdraw);
		this.hardWait(2);

		log.info("Ending of clickOnCloseIcon method");
	}

	public boolean isWithdrawPopUpContains() {
		log.info("Starting of isWithdrawPopUpContains method");

		boolean isWithdrawPopUpContains = false;

		try {
			if (isDisplayed(btnNext)
					&& isDisplayed(btnBackWithdraw)
					&& isDisplayed(txtStepTwo)
					&& isDisplayed(iconCloseOnWithdraw)
					&& isDisplayed(txtWithdraw)) {
				isWithdrawPopUpContains = true;
			}
		} catch (Exception e) {
			isWithdrawPopUpContains = false;
		}

		log.info("Ending of isWithdrawPopUpContains method");

		return isWithdrawPopUpContains;
	}

	public void clickOnBackButton() {
		log.info("Starting of clickOnBackButton method");

		clickOnWebElement(btnBackWithdraw);
		this.hardWait(2);

		log.info("Ending of clickOnBackButton method");
	}

	public String getSelectValidationTxt() {
		log.info("Starting of getSelectValidationTxt method");
		log.info("Ending of getSelectValidationTxt method");

		return getText(txtSelectValidation);
	}

	public void clickOnBracketCheckBox() {
		log.info("Starting of clickOnBracketCheckBox method");

		clickOnWebElement(chkBracket);
		this.hardWait(2);

		log.info("Ending of clickOnBracketCheckBox method");
	}

	public boolean isConfirmationPopUpContains() {
		log.info("Starting of isConfirmationPopUpContains method");

		boolean isConfirmationPopUpContains = false;

		if (isDisplayed(iconCLoseConfirmation) 
				&& isDisplayed(txtConfirmation)
				&& isDisplayed(btnBackWithdraw)
				&& isDisplayed(btnConfirm)) {
			isConfirmationPopUpContains = true;
		}

		log.info("Ending of isConfirmationPopUpContains method");

		return isConfirmationPopUpContains;
	}

	public String getConfirmTittleTxt() {
		log.info("Starting of getConfirmTittleTxt method");
		log.info("Ending of getConfirmTittleTxt method");

		return getText(txtConfirmation);
	}

	public void clickOnConfirmButton() {
		log.info("Starting of clickOnConfirmButton method");

		clickOnWebElement(btnConfirm);
		this.hardWait(2);

		log.info("Ending of clickOnConfirmButton method");
	}

	public void clickOnCloseIconOnConfirm() {
		log.info("Starting of clickOnConfirmButton method");

		clickOnWebElement(iconCLoseConfirmation);
		this.hardWait(2);

		log.info("Ending of clickOnConfirmButton method");
	}

	public boolean isSucessPopUpContains() {
		log.info("Starting of isSucessPopUpContains method");

		boolean isSucessPopUpContains = false;
		try {
			System.out.println(isDisplayed(txtSucess));
			System.out.println(isDisplayed(iconClosSucess));
			System.out.println(isDisplayed(txtSucessConfirmation));

		} catch (Exception e) {
			System.out.println(isDisplayed(txtSucess));
			System.out.println(isDisplayed(iconClosSucess));
			System.out.println(isDisplayed(txtSucessConfirmation));
		}
		if (isDisplayed(txtSucess) 
				&& isDisplayed(iconClosSucess)
				&& isDisplayed(txtSucessConfirmation)) {
			isSucessPopUpContains = true;
		}

		log.info("Ending of isSucessPopUpContains method");

		return isSucessPopUpContains;
	}

	public String getSucessTittleTxt() {
		log.info("Starting of getSucessTittleTxt method");
		log.info("Ending of getSucessTittleTxt method");

		return getText(txtSucess);
	}

	public void clickOnCloseIcon() {
		log.info("Starting of clickOnCloseIcon method");

		clickOnWebElement(iconClosSucess);
		this.hardWait(2);

		log.info("Ending of clickOnCloseIcon method");
	}

	public String getPlayerNameTxt() {
		log.info("Starting of getOptionValidationTxt method");
		log.info("Ending of getOptionValidationTxt method");

		return getText(txtPlayerName);
	}

	public void clickOnPlayersTab() {
		log.info("Starting of clickOnCloseIcon method");

		clickOnWebElement(tabPlayers);
		this.hardWait(2);

		log.info("Ending of clickOnCloseIcon method");
	}

	public void clickOnSearchFeild(String Name) {
		log.info("Starting of clickOnCloseIcon method");

		clickOnWebElement(txtSearchBox);
		this.txtSearchBox.sendKeys(Name);
		this.scrollDown(100);

		log.info("Ending of clickOnCloseIcon method");
	}

	public boolean isPlayerRemoved() {
		log.info("Starting of isPlayerRemoved method");

		boolean isPlayerRemoved = false;
		try {

			if (isDisplayed(txtNoResults)) {
				isPlayerRemoved = true;
			}
		} catch (Exception e) {
			isPlayerRemoved = false;
		}

		log.info("Ending of isPlayerRemoved method");

		return isPlayerRemoved;
	}

	public void clickOnUnMatchedPlayersTab() {
		log.info("Starting of clickOnCloseIcon method");

		clickOnWebElement(tabUnmatchedPlayes);
		this.hardWait(3);

		log.info("Ending of clickOnCloseIcon method");
	}

	public void clickOnWithdrawRefund() {
		log.info("Starting of clickOnWithdrawRefund method");

		clickOnWebElement(rdoWIthdrawRefund);
		this.hardWait(2);

		log.info("Ending of clickOnWithdrawRefund method");
	}

	public void clickOnRefundButton() {
		log.info("Starting of clickOnRefundButton method");

		clickOnWebElement(rdoRefund);
		this.hardWait(2);

		log.info("Ending of clickOnRefundButton method");
	}

	public boolean isWithdrawAndRefundPopUpContains() {
		log.info("Starting of isWithdrawAndRefundPopUpContains method");

		boolean isWithdrawAndRefundPopUpContains = false;

		try {
			if (isDisplayed(btnNext)
					&& isDisplayed(btnBackWithdraw) 
					&& isDisplayed(txtStepTwo)
					&& isDisplayed(iconCloseWithdrawRefund) 
					&& isDisplayed(txtWithdrawAndRefund)
					&& isDisplayed(txtTotal)) {
				isWithdrawAndRefundPopUpContains = true;
			}
		} catch (Exception e) {
			isWithdrawAndRefundPopUpContains = false;
		}

		log.info("Ending of isWithdrawAndRefundPopUpContains method");

		return isWithdrawAndRefundPopUpContains;
	}

	public void clickOnHomeMenu() {
		log.info("Starting of clickOnHomeMenu method");

		clickOnWebElement(mnuHome);
		this.hardWait(2);

		log.info("Ending of clickOnHomeMenu method");
	}

	
	public void clickOnCloseWithdraw() {
		log.info("Starting of clickOnHomeMenu method");

		clickOnWebElement(iconCloseWithdrawRefund);
		this.hardWait(2);

		log.info("Ending of clickOnHomeMenu method");
	}

	public boolean isRefundPopUpContains() {
		log.info("Starting of isRefundPopUpContains method");

		boolean isRefundPopUpContains = false;

		try {
			if (isDisplayed(btnNext)
					&& isDisplayed(btnBackWithdraw)
					&& isDisplayed(txtStepTwo)
					&& isDisplayed(iconCloseRefund) && isDisplayed(txtRefundOnly) && isDisplayed(txtTotal)) {
				isRefundPopUpContains = true;
			}
		} catch (Exception e) {
			isRefundPopUpContains = false;
		}

		log.info("Ending of isRefundPopUpContains method");

		return isRefundPopUpContains;
	}

	public void clickOnCloseOnRefund() {
		log.info("Starting of clickOnHomeMenu method");

		clickOnWebElement(iconCloseRefund);
		this.hardWait(3);

		log.info("Ending of clickOnHomeMenu method");
	}
}
