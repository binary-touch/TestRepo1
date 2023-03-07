package com.dupr.pages.home;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class DeleteRecentlyAddedMatchPage extends DUPRBaseAutomationPage {
	private static final Logger log = LogManager.getLogger(DeleteRecentlyAddedMatchPage.class);

	@B2BFindBy(xpath = "//span[@class='MuiChip-label MuiChip-labelSmall css-tavflp'][1]")
	private WebElement lblPending;

	@B2BFindBy(xpath = "//h4[@id='customized-dialog-title']")
	private WebElement lblDeleteMatch;

	@B2BFindBy(xpath = "//button[@aria-label='close']")
	private WebElement iconClose;

	@B2BFindBy(xpath = "//button[contains(@class,'MuiButton-whitecontained') and text()='Delete']")
	private WebElement btnDelete;

	@B2BFindBy(xpath = "//button[contains(@class,'MuiButton-contained') and text()='Go Back']")
	private WebElement btnGoBack;
	
	@B2BFindBy(xpath = "//h4[@id='customized-dialog-title']//following-sibling::div//button[text()='Delete']")
	private WebElement btnDeleteInDeleteMatchPopup;
	
	@B2BFindBy(xpath = "//h4[@id='customized-dialog-title']")
	private WebElement lblSuccess;

	@B2BFindBy(xpath = "//h4[text()='Match Deleted Successfully']")
	private WebElement txtValidationMessageInSuccessPopup;

	@B2BFindBy(xpath = "//h6[text()='Home']")
	private WebElement tabHome;

	public DeleteRecentlyAddedMatchPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public boolean isPendingLabelDisplayed(String matchEvent) {
		log.info("Starting of isPendingLabelDisplayed method");

		boolean isPendingLabelDisplayed = false;
		WebElement lblPendingDisplayed = driver.findElement(By.xpath("//p[contains(text(),'"+matchEvent+"')]/ancestor::div[contains(@class, 'MuiGrid-grid-xs-8')]/following-sibling::div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-4 MuiGrid-grid-md-2 css-lv0834']//span"));
		try {
			if (isDisplayed(lblPendingDisplayed) == true) {
				isPendingLabelDisplayed = true;
			}
		} catch (Exception e) {
			isPendingLabelDisplayed = false;
		}

		log.info("Ending of isPendingLabelDisplayed method");

		return isPendingLabelDisplayed;
	}

	public boolean isDeleteMatchPopupContains() {
		log.info("Starting of isDeleteMatchPopupContains method");

		boolean isDeleteMatchPopupContains = false;

		if (isDisplayed(iconClose) && isDisplayed(btnDelete) && isDisplayed(btnGoBack))
			isDeleteMatchPopupContains = true;

		log.info("Ending of isDeleteMatchPopupContains method");

		return isDeleteMatchPopupContains;
	}

	public boolean isSuccessPopupContains() {
		log.info("Starting of isSuccessPopupContains method");

		boolean isSuccessPopupContains = false;

		if (isDisplayed(txtValidationMessageInSuccessPopup) && isDisplayed(iconClose))
			isSuccessPopupContains = true;

		log.info("Ending of isSuccessPopupContains method");

		return isSuccessPopupContains;
	}

	public String getSuccessText() {
		log.info("Starting of getSuccessText method");
		log.info("Ending of getSuccessText method");

		return getText(lblSuccess);
	}

	public String getDeleteMatchText() {
		log.info("Starting of getDeleteMatchText method");
		log.info("Ending of getDeleteMatchText method");

		return getText(lblDeleteMatch);
	}

	public void clickOnCloseIcon() {
		log.info("Starting of clickOnCloseIcon method");

		elementClick(iconClose);

		log.info("Ending of clickOnCloseIcon method");
	}

	public void clickOnDeleteButtonInDeleteMatchPopup() {
		log.info("Starting of clickOnDeleteButtonInDeleteMatchPopup method");

		try {
			clickUsingActionsClass(btnDeleteInDeleteMatchPopup);
		} catch (Exception e) {
			clickOnWebElement(btnDeleteInDeleteMatchPopup);
		}

		log.info("Ending of clickOnDeleteButtonInDeleteMatchPopup method");
	}

	public void clickOnHomeTab() {
		log.info("Starting of clickOnHomeTab method");

		elementClick(tabHome);

		log.info("Ending of clickOnHomeTab method");
	}

}
