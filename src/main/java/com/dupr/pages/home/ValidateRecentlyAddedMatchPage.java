package com.dupr.pages.home;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BFindBys;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class ValidateRecentlyAddedMatchPage extends DUPRBaseAutomationPage {

	private static final Logger log = LogManager.getLogger(ValidateRecentlyAddedMatchPage.class);

	@B2BFindBy(xpath = "//h4[@class='MuiTypography-root MuiTypography-h4 css-12grqhn' and text()='Match History']")
	private WebElement tabMatchHistory;

	@B2BFindBy(xpath = "//h3[@class='MuiTypography-root MuiTypography-h3 css-hyqj8z' and text()='Match History']")
	private WebElement lblMatchHistory;

	@B2BFindBy(xpath = "//span[text()='Completed']")
	private WebElement btnCompleted;

	@B2BFindBy(xpath = "//span[text()='Singles']")
	private WebElement btnSingles;

	@B2BFindBy(xpath = "//span[text()='Doubles']")
	private WebElement btnDoubles;

	@B2BFindBy(xpath = "//span[text()='Pending']")
	private WebElement btnPending;

	@B2BFindBy(xpath = "//button[@id='composition-button']")
	private WebElement btnSort;

	@B2BFindBy(xpath = "//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0 css-1efqb7s']/descendant::div[@class='MuiBox-root css-yd8sa2']/child::div/following-sibling::div/p")
	private WebElement lblMatchId;

	@B2BFindBy(xpath = "//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0 css-1efqb7s']/descendant::div[@class='MuiBox-root css-0']/p[@class='MuiTypography-root MuiTypography-body2 css-1kuc6t0']")
	private WebElement txtEventNames;

	@B2BFindBy(xpath = "//div[@class='MuiBox-root css-d4yq24']/button[text()='Clear Filters']")
	private WebElement btnClearFilters;

	@B2BFindBys(@B2BFindBy(xpath = "//h6[@class='MuiTypography-root MuiTypography-subtitle2 css-1aon3dv']"))
	private List<WebElement> lstMatchDates;

	@B2BFindBy(xpath = "(//button[text()='Validate'])[1]")
	private WebElement btnValidate;

	@B2BFindBys(@B2BFindBy(xpath = "//button[text()='Validate']"))
	private List<WebElement> lstValidate;

	@B2BFindBy(xpath = "(//button[text()='Delete'])[1]")
	private WebElement btnDelete;

	@B2BFindBys(@B2BFindBy(xpath = "//button[text()='Delete']"))
	private List<WebElement> lstDelete;

	@B2BFindBy(xpath = "//h4[@id='customized-dialog-title']")
	private WebElement lblValidateMatch;

	@B2BFindBy(xpath = "//h4[@id='customized-dialog-title']/following-sibling::div/following::div//button")
	private WebElement btnValidateOnValidateMatchPopup;

	@B2BFindBy(xpath = "//h4[@id='customized-dialog-title']/button")
	private WebElement iconClose;

	@B2BFindBy(xpath = "//h4[@class='MuiTypography-root MuiTypography-h4 MuiDialogTitle-root css-1jdllhz']")
	private WebElement lblValidateMatchInValidateMatchPopup;

	@B2BFindBy(xpath = "//button[contains(@class,'MuiButton-whitecontained') and text()='Cancel']")
	private WebElement btnCancel;

	@B2BFindBy(xpath = "//button[contains(@class,'MuiButton-containedSizeMedium') and text()='Validate']")
	private WebElement btnValidateInConfirmValidatePopup;

	@B2BFindBy(xpath = "//h4[@id='customized-dialog-title']")
	private WebElement lblSuccess;

	@B2BFindBys(@B2BFindBy(xpath = "//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0 css-1efqb7s'] //div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-12 css-15j76c0']/following-sibling::div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-12 css-15j76c0']"))
	private List<WebElement> lstPlayerNames;

	@B2BFindBys(@B2BFindBy(xpath = "//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0 css-1efqb7s'] //div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-12 css-15j76c0']/following-sibling::div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-12 css-15j76c0']/preceding-sibling::div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-12 css-15j76c0']"))
	private List<WebElement> lstOpponentPlayerNames;

	@B2BFindBys(@B2BFindBy(xpath = "//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0 css-1efqb7s']/descendant::div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-6 css-zbuby5']/div/div/following-sibling::div/following-sibling::div/following-sibling::div/following-sibling::div/preceding-sibling::div/preceding-sibling::div/preceding-sibling::div/preceding-sibling::div"))
	private List<WebElement> lstDoublesPlayerNames;

	@B2BFindBys(@B2BFindBy(xpath = "//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0 css-1efqb7s'] //div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-6 css-rpybyc'][2]"))
	private List<WebElement> lstDoublesPartner;

	@B2BFindBys(@B2BFindBy(xpath = "//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0 css-1efqb7s'] //div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-6 css-rpybyc'][3]"))
	private List<WebElement> lstDoublesOpponent;

	@B2BFindBys(@B2BFindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-container css-1qx1d3r']/child::div/following-sibling::div/following-sibling::div/following-sibling::div/following-sibling::div"))
	private List<WebElement> lstDoublesOpponentPartner;

	@B2BFindBys(@B2BFindBy(xpath = "//div[contains(@class,'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-15j76c0')]/div/div[@class='MuiBox-root css-1oykulc']/div//*[local-name()='svg']"))
	private List<WebElement> lstIconGreenTickMark;

	@B2BFindBy(xpath = "//input[@class='PrivateSwitchBase-input css-1m9pwf3' and @value='ASC']")
	private WebElement rdoOldestToNewest;

	@B2BFindBy(xpath = "//input[@class='PrivateSwitchBase-input css-1m9pwf3' and @value='DESC']")
	private WebElement rdoNewestToOldest;

	@B2BFindBy(xpath = "//h3[@class='MuiTypography-root MuiTypography-h3 css-hyqj8z']//parent::div/following-sibling::div/descendant::div//*[@class='MuiSvgIcon-root MuiSvgIcon-fontSizeSmall MuiChip-icon MuiChip-iconMedium MuiChip-iconColorPrimary css-nitmjn']")
	private WebElement iconRightMarkCompleted;

	@B2BFindBy(xpath = "(//h3[@class='MuiTypography-root MuiTypography-h3 css-hyqj8z']//parent::div/following-sibling::div/descendant::div//*[@class='MuiSvgIcon-root MuiSvgIcon-fontSizeSmall MuiChip-icon MuiChip-iconMedium MuiChip-iconColorPrimary css-nitmjn'])[2]")
	private WebElement iconRightMarkPending;

	@B2BFindBy(xpath = "(//h3[@class='MuiTypography-root MuiTypography-h3 css-hyqj8z']//parent::div/following-sibling::div/descendant::div//*[@class='MuiSvgIcon-root MuiSvgIcon-fontSizeSmall MuiChip-icon MuiChip-iconMedium MuiChip-iconColorPrimary css-nitmjn'])[3]")
	private WebElement iconRightMarkSingles;

	@B2BFindBy(xpath = "//h3[@class='MuiTypography-root MuiTypography-h3 css-hyqj8z']//parent::div/following-sibling::div[@class='MuiBox-root css-d4yq24']/child::div/following-sibling::div/following-sibling::div/following-sibling::div/*[local-name()='svg']")
	private WebElement iconRightMarkDoubles;

	@B2BFindBys(@B2BFindBy(xpath = "//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0 css-1efqb7s']"))
	private List<WebElement> lstMatchDetailsBoxes;

	public ValidateRecentlyAddedMatchPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public void clickOnMatchHistoryTab() {
		log.info("Starting of clickMatchHistoryTab method");

		scrollDown(1500);
		elementClick(tabMatchHistory);

		log.info("Ending of clickMatchHistoryTab method");
	}

	public void clickOnDeleteButton(String eventName) {
		log.info("Ending of clickOnDeleteButton method");

		WebElement btnDeleteDisplayed = driver.findElement(By.xpath("//p[contains(text(),' " + eventName
				+ " ')]/ancestor::div[contains(@class, 'MuiGrid-grid-xs-8')]/following-sibling::div//button"));

		elementClick(btnDeleteDisplayed);

		log.info("Ending of clickOnDeleteButton method");
	}

	public boolean isMatchHistoryOptionsPageContains() {
		log.info("Starting of isMatchHistoryOptionsPageContains method");

		explicitWait(lstMatchDetailsBoxes);
		boolean isMatchHistoryOptionsPageContains = false;

		if (isDisplayed(lblMatchHistory) && isDisplayed(btnPending) && isDisplayed(btnCompleted)
				&& isDisplayed(btnSingles) && isDisplayed(btnDoubles) && isDisplayed(lblMatchId))
			isMatchHistoryOptionsPageContains = true;

		log.info("Ending of isMatchHistoryOptionsPageContains method");

		return isMatchHistoryOptionsPageContains;
	}

	public void clickOnPendingButton() {
		log.info("Starting of clickOnPendingButton method");

		clickOnWebElement(btnPending);

		log.info("Ending of clickOnPendingButton method");
	}

	public boolean isDeleteButtonsDisplayed() {
		log.info("Starting of clickOnPendingButton method");

		explicitWait(lstMatchDetailsBoxes);
		boolean isDeleteButtonsDisplayed = false;

		try {
			for (WebElement delete : lstDelete) {

				if (isDisplayed(delete) == true) {
					isDeleteButtonsDisplayed = true;
				}
			}

		} catch (Exception e) {
			isDeleteButtonsDisplayed = false;
		}

		log.info("Ending of clickOnPendingButton method");

		return isDeleteButtonsDisplayed;
	}

	public boolean isDeleteORValidateButtonsDisplayed() {
		log.info("Starting of isDeleteORValidateButtonsDisplayed method");

		explicitWait(lstMatchDetailsBoxes);
		boolean isDeleteORValidateButtonsDisplayed = false;

		if (isDeleteButtonsDisplayed() || isValidateButtonsDisplayedInPending()) {
			isDeleteORValidateButtonsDisplayed = true;
		}

		log.info("Ending of isDeleteORValidateButtonsDisplayed method");

		return isDeleteORValidateButtonsDisplayed;
	}

	public boolean isValidateButtonsDisplayedInPending() {
		log.info("Starting of isValidateButtonsDisplayed method");

		explicitWait(lstMatchDetailsBoxes);
		boolean isValidateButtonsDisplayedInPending = false;
		try {
			for (WebElement validate : lstValidate) {

				if (isDisplayed(validate) == true) {
					isValidateButtonsDisplayedInPending = true;
				}
			}
		} catch (Exception e) {
			isValidateButtonsDisplayedInPending = false;
		}

		log.info("Ending of isValidateButtonsDisplayed method");

		return isValidateButtonsDisplayedInPending;
	}

	public boolean isMatchDateButtonDisplayed() {
		log.info("Starting of isMatchDateButtonDisplayed method");

		explicitWait(lstMatchDetailsBoxes);
		boolean isMatchDateButtonDisplayed = false;

		for (WebElement matchDate : lstMatchDates) {

			if (isDisplayed(matchDate))
				isMatchDateButtonDisplayed = true;

		}

		log.info("Ending of isMatchDateButtonDisplayed method");

		return isMatchDateButtonDisplayed;
	}

	public boolean isValidateButtonDisplayed(String eventName) {
		log.info("Starting of isValidateButtonDisplayed method");

		explicitWait(lstMatchDetailsBoxes);
		boolean validateButtonState = false;

		WebElement btnDeleteDisplayed = driver.findElement(By.xpath("//p[contains(text(),'" + eventName
				+ "')]/ancestor::div[contains(@class, 'MuiGrid-grid-xs-8')]/following-sibling::div//button"));

		try {
			if (isDisplayed(btnDeleteDisplayed) == true) {
				validateButtonState = true;
			}
		} catch (Exception e) {
			validateButtonState = false;
		}

		log.info("Ending of isValidateButtonDisplayed method");

		return validateButtonState;
	}

	public void clickOnValidateButton(String eventName) {
		log.info("Starting of clickOnValidateButton method");

		WebElement btnValidateDisplayed = driver.findElement(By.xpath("//p[contains(text(),'" + eventName
				+ "')]/ancestor::div[contains(@class, 'MuiGrid-grid-xs-8')]/following-sibling::div//button"));

		elementClick(btnValidateDisplayed);

		log.info("Ending of clickOnValidateButton method");
	}

	public boolean isValidateMatchPopupContains() {
		log.info("Starting of isValidateMatchPopupContains method");

		boolean isValidateMatchPopupContains = false;

		if (isDisplayed(lblValidateMatch) && isDisplayed(btnValidateOnValidateMatchPopup) && isDisplayed(iconClose))

			isValidateMatchPopupContains = true;

		log.info("Ending of isValidateMatchPopupContains method");

		return isValidateMatchPopupContains;
	}

	public void clickOnValidateButtonOnValidateMatchPopup() {
		log.info("Starting of clickOnValidateButtonOnValidateMatchPopup method");

		clickOnElement(btnValidateOnValidateMatchPopup);

		log.info("Ending of clickOnValidateButtonOnValidateMatchPopup method");
	}

	public boolean isConfirmValidateMatchPopupContains() {
		log.info("Starting of isConfirmValidateMatchPopupOptionsDisplayed method");

		boolean isConfirmValidateMatchPopupContains = false;

		if (isDisplayed(lblValidateMatchInValidateMatchPopup) && isDisplayed(btnCancel)
				&& isDisplayed(btnValidateInConfirmValidatePopup))

			isConfirmValidateMatchPopupContains = true;

		log.info("Ending of isConfirmValidateMatchPopupOptionsDisplayed method");

		return isConfirmValidateMatchPopupContains;
	}

	public void clickOnValidateButtonOnConfirmValidatePopup() {
		log.info("Starting of clickOnValidateButtonOnConfirmValidatePopup method");

		clickOnElement(btnValidateInConfirmValidatePopup);

		log.info("Ending of clickOnValidateButtonOnConfirmValidatePopup method");
	}

	public String getSuccessText() {
		log.info("Starting of getSuccessText method");
		log.info("Ending of getSuccessText method");

		return getText(lblSuccess);
	}

	public void clickOnCloseIcon() {
		log.info("Starting of clickOnCloseIcon method");

		elementClick(iconClose);

		log.info("Ending of clickOnCloseIcon method");
	}

	public void clickOnCompletedButton() {
		log.info("Starting of clickOnCompletedButton method");

		clickOnElement(btnCompleted);

		log.info("Ending of clickOnCompletedButton method");
	}

	public boolean isTickIconDisplayed() {
		log.info("Starting of isTickIconDisplayed method");

		explicitWait(lstMatchDetailsBoxes);
		boolean icon = true;

		for (WebElement tickIcon : lstIconGreenTickMark) {
			try {
				if (isDisplayed(tickIcon)) {
					icon = true;
				}
			} catch (Exception e) {
				icon = false;
			}
		}

		log.info("Ending of isTickIconDisplayed method");

		return icon;
	}

	public boolean isValidateButtonsDisplayed() {
		log.info("Starting of isValidateButtonsDisplayed method");

		explicitWait(lstMatchDetailsBoxes);
		boolean validateButtonState = false;

		try {
			for (WebElement validate : lstValidate) {
				if (isDisplayed(validate) == true) {
					validateButtonState = true;
				}
			}
		} catch (Exception e) {
			validateButtonState = false;
		}
		log.info("Ending of isValidateButtonsDisplayed method");

		return validateButtonState;
	}

	public boolean isDeleteButtonDisplayed(String eventName) {
		log.info("Starting of isDeleteButtonsDisplayed method");

		explicitWait(lstMatchDetailsBoxes);
		boolean deleteButtonState = false;

		WebElement btnDeleteDisplayed = driver.findElement(By.xpath("//p[contains(text(),' " + eventName
				+ " ')]/ancestor::div[contains(@class, 'MuiGrid-grid-xs-8')]/following-sibling::div//button"));

		try {
			if (isDisplayed(btnDeleteDisplayed) == true) {
				deleteButtonState = true;
			}
		} catch (Exception e) {
			deleteButtonState = false;
		}
		log.info("Ending of isValidateButtonsDisplayed method");

		return deleteButtonState;
	}

	public void clickOnSinglesButton() {
		log.info("Starting of clickOnSinglesButton method");

		clickOnElement(btnSingles);

		log.info("Ending of clickOnSinglesButton method");
	}

	public boolean isPlayerNamesButtonsDisplayed() {
		log.info("Starting of isPlayerNamesButtonsDisplayed method");

		boolean teamOneButton = true;
		for (WebElement playerName : lstPlayerNames) {

			if (isDisplayed(playerName)) {
				teamOneButton = true;
			} else {
				teamOneButton = false;
			}
		}

		log.info("Ending of isPlayerNamesButtonsDisplayed method");

		return teamOneButton;
	}

	public boolean isOpponentPlayerNamesButtonsDisplayed() {
		log.info("Starting of isOpponentPlayerNamesButtonsDisplayed method");

		boolean teamOneButton = true;
		for (WebElement playerName : lstOpponentPlayerNames) {

			if (isDisplayed(playerName)) {
				teamOneButton = true;
			} else {
				teamOneButton = false;
			}

		}

		log.info("Ending of isOpponentPlayerNamesButtonsDisplayed method");

		return teamOneButton;
	}

	public void clickOnDoublesButton() {
		log.info("Starting of clickOnDoublesButton method");

		clickOnElement(btnDoubles);

		log.info("Ending of clickOnDoublesButton method");
	}

	public boolean isRightMarkIconsDisplayed() {
		log.info("Starting of isRightMarkIconsDisplayed method");

		boolean rightMarkState = false;

		try {
			if (isDisplayed(iconRightMarkCompleted) && isDisplayed(iconRightMarkPending)
					&& isDisplayed(iconRightMarkSingles) && isDisplayed(iconRightMarkDoubles)) {

				rightMarkState = true;
			}
		} catch (Exception e) {

			rightMarkState = false;
		}

		log.info("Ending of isRightMarkIconsDisplayed method");

		return rightMarkState;
	}

	public boolean isPlayerButtonsDisplayed() {
		log.info("Starting of isPlayerButtonsDisplayed method");

		boolean teamOneButton = true;
		for (WebElement playerName : lstDoublesPlayerNames) {

			if (isDisplayed(playerName)) {
				teamOneButton = true;
			} else {
				teamOneButton = false;
			}
		}

		log.info("Ending of isPlayerButtonsDisplayed method");

		return teamOneButton;
	}

	public boolean isPlayerPartnerButtonsDisplayed() {
		log.info("Starting of isPlayerPartnerButtonsDisplayed method");

		boolean teamOneButton = true;

		for (WebElement playerName : lstDoublesPartner) {

			if (isDisplayed(playerName)) {
				teamOneButton = true;
			} else {
				teamOneButton = false;
			}

		}

		log.info("Ending of isPlayerPartnerButtonsDisplayed method");

		return teamOneButton;
	}

	public boolean isOpponentButtonsDisplayed() {
		log.info("Starting of isOpponentButtonsDisplayed method");

		boolean teamOneButton = true;
		for (WebElement playerName : lstDoublesOpponent) {

			if (isDisplayed(playerName)) {
				teamOneButton = true;
			} else {
				teamOneButton = false;
			}

		}

		log.info("Ending of isOpponentButtonsDisplayed method");

		return teamOneButton;
	}

	public boolean isOpponentPartnerButtonsDisplayed() {
		log.info("Starting of isOpponentPartnerButtonsDisplayed method");

		boolean teamOneButton = true;
		for (WebElement playerName : lstDoublesOpponentPartner) {

			if (isDisplayed(playerName)) {
				teamOneButton = true;
			} else {
				teamOneButton = false;
			}

		}

		log.info("Ending of isOpponentPartnerButtonsDisplayed method");

		return teamOneButton;
	}

	public void clickOnSortButton() {
		log.info("Ending of clickOnSortButton method");

		clickOnElement(btnSort);

		log.info("Ending of clickOnSortButton method");
	}

	public boolean isNewestToOldestRadioButtonSelected() {
		log.info("Ending of isNewestToOldestButtonSelected method");
		log.info("Ending of isNewestToOldestButtonSelected method");

		return this.rdoNewestToOldest.isSelected();
	}

	public void clickOnOldestToNewestButton() {
		log.info("Ending of clickOnOldestToNewestButton method");

		elementClick(rdoOldestToNewest);

		log.info("Ending of clickOnOldestToNewestButton method");
	}

	public boolean isOldMatchDatesDisplayedTop() throws ParseException {
		log.info("Starting of isOldMatchDatesDisplayedTop method");

		explicitWait(lstMatchDetailsBoxes);
		String firstDate = lstMatchDates.get(0).getText();

		SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd,yyyy");

		Date oldDate = sdf.parse(firstDate);

		boolean oldToNewDates = false;

		for (WebElement matchDate : lstMatchDates) {

			String strDate = matchDate.getText();
			Date date = sdf.parse(strDate);

			if (date.compareTo(oldDate) >= 0) {
				oldToNewDates = true;
			} else {
				oldToNewDates = false;
			}
		}

		log.info("Ending of isOldMatchDatesDisplayedTop method");

		return oldToNewDates;
	}

	public void clickOnClearFiltersButton() {
		log.info("Starting of clickOnClearFiltersButton method");

		clickOnElement(btnClearFilters);

		log.info("Ending of clickOnClearFiltersButton method");
	}
}
