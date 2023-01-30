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

public class EndEventPage extends DUPRBaseAutomationPage {
	private static final Logger log = LogManager.getLogger(EndEventPage.class);

	@B2BFindBy(xpath = "(//h4[contains(@class,'MuiTypography-root MuiTypography-h4')])")
	private List<WebElement> lblEvent;

	@B2BFindBy(xpath = "//button[text()='End Event']")
	private WebElement btnEndEvent;

	@B2BFindBy(xpath = "//*[contains(@class,'MuiSvgIcon-root MuiSvgIcon-colorPrimary MuiSvgIcon-fontSizeMedium')]")
	private WebElement btnBack;

	// @B2BFindBy(xpath = "//h4[@id='customized-dialog-title']")
	@B2BFindBy(xpath = "//h4[text()='End Event']")
	private WebElement lblEndEvent;

	@B2BFindBy(xpath = "//h4[@id='customized-dialog-title']//button/*")
	private WebElement iconClose;

	@B2BFindBy(xpath = "//p[text()='You will no longer be able to make changes to this event once you chose to mark it as completed. The event will be marked as inactive permanently.']")
	private WebElement txtWarningMsg;

	@B2BFindBy(xpath = "//button[text()='Cancel']")
	private WebElement btnCancel;

	@B2BFindBy(xpath = "//h4[@id='customized-dialog-title']/following-sibling::div//h5")
	private WebElement lblAreYouSure;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiDialogActions-root MuiDialogActions-spacing')]/button[text()='End Event']")
	private WebElement btnConfirmEndEvent;

	@B2BFindBy(xpath = "//h3[text()='Event']")
	private WebElement txtEvent;

	@B2BFindBy(xpath = "//*[contains(@class,'MuiSvgIcon-root MuiSvgIcon-fontSizeMedium')]")
	private WebElement imgEmptyLogo;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiBox-root ')]//h3[contains(@class,'MuiTypography-root MuiTypography-h3')]/following-sibling::h4/following-sibling::p")
	private WebElement lblRegisterDates;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiBox-root ')]//h3[contains(@class,'MuiTypography-root MuiTypography-h3')]/following-sibling::h4")
	private WebElement lblClubName;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiBox-root ')]//h3[contains(@class,'MuiTypography-root MuiTypography-h3')]/following-sibling::h4/preceding-sibling::h3")
	private WebElement lblBracketName;

	@B2BFindBy(xpath = "//span[text()='Complete']")
	private WebElement lblComplete;

	@B2BFindBy(xpath = "//button[text()='Share']")
	private WebElement btnShare;

	@B2BFindBy(xpath = "//span[contains(@class,'MuiChip-label MuiChip-labelSmall')]//font[text()='Complete']")
	private WebElement lblBracketComplete;

	// @B2BFindBy(xpath = "//div[contains(@class,'MuiAvatar-root
	// MuiAvatar-circular')]/parent::div")
	@B2BFindBy(xpath = "//div[contains(@class,'MuiBox-root ')]//h3[contains(@class,'MuiTypography-root MuiTypography-h3')]/following-sibling::h4/parent::div/preceding-sibling::div")
	private WebElement imgLogo;

	@B2BFindBy(xpath = "//span[contains(@class,'MuiChip-label MuiChip-labelSmall')]")
	private List<WebElement> lblEventStatus;

	public EndEventPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public void clickOnEventLabel() {
		log.info("Starting of clickOnEventLabel method");

		for (int i = 1; i < lblEvent.size(); i++) {
			this.hardWait(3);
			driver.findElement(
					By.xpath((("(//h4[contains(@class,'MuiTypography-root MuiTypography-h4')])[" + i + "]")))).click();

			this.hardWait(3);
			try {
				if ((isDisplayed(btnEndEvent) == true)) {
					clickOnElement(btnEndEvent);
					break;
				}
			} catch (Exception e) {
				clickOnElement(btnBack);
			}

		}

		log.info("Ending of clickOnEventLabel method");
	}

	public boolean isEndEventPopupContains() {
		log.info("Starting of isEndEventPopupContains method");

		boolean isEndEventPopupContains = false;

		try {
			log.debug(isDisplayed(btnConfirmEndEvent));
			log.debug(isDisplayed(btnCancel));
			log.debug(isDisplayed(lblAreYouSure));
			log.debug(isDisplayed(txtWarningMsg));
			log.debug(isDisplayed(iconClose));
			log.debug(isDisplayed(lblEndEvent));
		} catch (Exception e) {
			log.debug("Failed: " + e.getMessage());
		}

		try {
			if (isDisplayed(btnConfirmEndEvent) && isDisplayed(btnCancel) && isDisplayed(lblAreYouSure)
					&& isDisplayed(txtWarningMsg) && isDisplayed(iconClose) && isDisplayed(lblEndEvent)) {
				isEndEventPopupContains = true;
			}

		} catch (Exception e) {
			isEndEventPopupContains = false;
		}

		log.info("Ending of isEndEventPopupContains method");

		return isEndEventPopupContains;
	}

	public String getEndEventTxt() {
		log.info("Starting of getEndEventTxt method");
		log.info("Ending of getEndEventTxt method");

		return getText(lblEndEvent);
	}

	public String getAreYouSureToEndEvent() {
		log.info("Starting of getAreYouSureToEndEvent method");
		log.info("Ending of getAreYouSureToEndEvent method");

		return getText(lblAreYouSure);
	}

	public String getWarningTxt() {
		log.info("Starting of getWarningTxt method");
		log.info("Ending of getWarningTxt method");

		return getText(txtWarningMsg);
	}

	public void clickOnCancelButton() {
		log.info("Starting of clickOnCancelButton method");

		clickOnElement(btnCancel);

		log.info("Ending of clickOnCancelButton method");
	}

	public void clickOnCloseIcon() {
		log.info("Starting of clickOnCloseIcon method");

		clickOnElement(iconClose);

		log.info("Ending of clickOnCloseIcon method");
	}

	public void clickOnConfirmEndEventButton() {
		log.info("Starting of clickOnConfirmEndEventButton method");

		clickOnElement(btnConfirmEndEvent);

		log.info("Ending of clickOnConfirmEndEventButton method");
	}

	public void clickOnEndEventButton() {
		log.info("Starting of clickOnEndEventButton method");

		clickOnElement(btnEndEvent);

		log.info("Ending of clickOnEndEventButton method");
	}

	public String getEventTxt() {
		log.info("Starting of getEventTxt method");
		log.info("Ending of getEventTxt method");

		return getText(txtEvent);
	}

	public boolean isEndEventPageContains() {
		log.info("Starting of isEndEventPageContains method");

		boolean isEndEventPageContains = false;
		try {
			log.debug(isDisplayed(imgLogo));
			log.debug(isDisplayed(txtEvent));
			log.debug(isDisplayed(btnShare));
			log.debug(isDisplayed(lblComplete));
			log.debug(isDisplayed(btnBack));
			log.debug(isDisplayed(lblBracketName));
			log.debug(isDisplayed(lblClubName));
			log.debug(isDisplayed(lblRegisterDates));
		} catch (Exception e) {
			log.debug("Failed: " + e.getMessage());
		}

		if (isDisplayed(imgLogo) && isDisplayed(txtEvent) && isDisplayed(btnShare) && isDisplayed(lblComplete)
				&& isDisplayed(btnBack) && isDisplayed(lblBracketName) && isDisplayed(lblClubName)
				&& isDisplayed(lblRegisterDates)) {
			isEndEventPageContains = true;
		}

		log.info("Ending of isEndEventPopupContains method");

		return isEndEventPageContains;
	}

	public boolean getBracketsStatusText() {
		log.info("Starting of getBracketsStatusText method");

		boolean getBracketsStatusText = true;

		int i = 1;
		for (WebElement element : lblEventStatus) {
			if (!(element.getText().contains("Complete"))) {
				getBracketsStatusText = false;
				System.out.println("testcase failed" + i);
			}
		}

		log.info("Ending of getBracketsStatusText method");

		return getBracketsStatusText;
	}
}
