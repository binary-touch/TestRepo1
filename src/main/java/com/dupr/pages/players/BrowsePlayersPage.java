package com.dupr.pages.players;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BFindBys;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class BrowsePlayersPage extends DUPRBaseAutomationPage {

	private static final Logger log = LogManager.getLogger(BrowsePlayersPage.class);

	@B2BFindBy(xpath = "//button[contains(@class,'MuiButton-sizeMedium') and text()='Filters']")
	private WebElement btnFilters;

	@B2BFindBy(xpath = "//button[contains(@class,'MuiButton-sizeLarge') and text()='Invite a Player to DUPR']")
	private WebElement tabInvitePlayerToDUPR;

	@B2BFindBy(xpath = "//input[contains(@class, 'PrivateSwitchBase-input MuiSwitch-input') and @type='checkbox']")
	private WebElement tglFindNearMePlayer;

	@B2BFindBys(@B2BFindBy(xpath = "//div[contains(@class, 'MuiPaper-rounded MuiPaper-elevation3')]/div/following-sibling::div[1]//following-sibling::div[1]//h4"))
	private List<WebElement> lstPlayerNames;

	@B2BFindBys(@B2BFindBy(xpath = "//div[@class='MuiBox-root css-hp68mp'] //div/preceding-sibling::p"))
	private List<WebElement> lstPlayersLocations;

	@B2BFindBys(@B2BFindBy(xpath = "//div[contains(@class,'MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation3')]/div/following-sibling::div[1]/div/following-sibling::div/*/*/div/div/p"))
	private List<WebElement> lstPlayersAge;

	@B2BFindBys(@B2BFindBy(xpath = "//div[contains(@class, 'MuiPaper-rounded MuiPaper-elevation3')]/div/following-sibling::div[1]/*/following-sibling::div/*/*/following-sibling::div/div/h6[text()='Singles']/parent::div/div"))
	private List<WebElement> lstPlayersSingleMatchRatings;

	@B2BFindBys(@B2BFindBy(xpath = "//div[contains(@class, 'MuiPaper-rounded MuiPaper-elevation3')]/div/following-sibling::div[1]/*/following-sibling::div/*/*/following-sibling::div/div/h6[text()='Doubles']/parent::div/div"))
	private List<WebElement> lstPlayersDoublesMatchRatings;

	@B2BFindBys(@B2BFindBy(xpath = "//div[contains(@class,'MuiBox-root')]//div/following-sibling::p"))
	private List<WebElement> lstPlayersDistance;

	@B2BFindBy(xpath = "//h3[text()='Browse Players']")
	private WebElement lblBrowsePlayers;

	@B2BFindBy(xpath = "//input[@id='Search']")
	private WebElement txtBoxSearchInBrowsePlayers;

	@B2BFindBy(xpath = "//h5[text()='Location']/../following-sibling::div/div//fieldset/preceding-sibling::input")
	private WebElement txtBoxLocationInFilters;

	@B2BFindBy(xpath = "//h3[text()='Filters']")
	private WebElement lblFilters;

	@B2BFindBy(xpath = "//button[text()='Clear All']")
	private WebElement btnClearAll;

	@B2BFindBy(xpath = "//button[text()='Apply']")
	private WebElement btnApply;

	@B2BFindBy(xpath = "//h5[text()='Full Name']/../.. //input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')]")
	private WebElement txtBoxFullName;

	@B2BFindBy(xpath = "//h5[text()='Email Address']/../.. //input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')]")
	private WebElement txtBoxEmail;

	@B2BFindBy(xpath = "//h5[text()='Full Name']")
	private WebElement lblFullName;

	@B2BFindBy(xpath = "//h5[text()='Email Address']")
	private WebElement lblEmailAddress;

	@B2BFindBy(xpath = "//h4[@id='customized-dialog-title']")
	private WebElement lblInvitePlayer;

	@B2BFindBy(xpath = "//div/button[contains(@class,'MuiButton-whitecontained') and text()='Back']")
	private WebElement btnBack;

	@B2BFindBy(xpath = "//div/button[contains(@class,'MuiButton-whitecontained')]/following-sibling::button[text()='Send Invite']")
	private WebElement btnSendInvite;

	@B2BFindBy(xpath = "//h4[@id='customized-dialog-title']")
	private WebElement lblInviteSent;

	@B2BFindBy(css = ".MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary.MuiButton-sizeMedium.MuiButton-containedSizeMedium.MuiButton-root.MuiButton-contained.MuiButton-containedPrimary.MuiButton-sizeMedium.MuiButton-containedSizeMedium.css-1971f2t")
	private WebElement btnOk;

	@B2BFindBy(xpath = "//h5[text()='Location']")
	private WebElement lblLocation;

	@B2BFindBy(xpath = "//h5[text()='Distance']")
	private WebElement lblDistance;

	@B2BFindBy(xpath = "//h5[text()='Skill Level Ratings']")
	private WebElement lblSkillLevelRatings;

	@B2BFindBy(xpath = "//h5[text()='Type']")
	private WebElement lblType;

	@B2BFindBy(xpath = "//h5[text()='Gender']")
	private WebElement lblGender;

	@B2BFindBy(xpath = "//h5[text()='Age Range']")
	private WebElement lblAgeRange;

	@B2BFindBys(@B2BFindBy(xpath = "//ul[contains(@class,'MuiList-root MuiList-padding')]/li[contains(@class,'MuiListItem-gutters MuiListItem-divider')]/div"))
	private List<WebElement> lstLocationOptions;

	@B2BFindBy(xpath = "//input[@type='range' and @aria-label='Distance']")
	private WebElement distanceSliderNode;

	@B2BFindBy(xpath = "//input[@name='doubles']")
	private WebElement chkBoxDoubles;

	@B2BFindBy(xpath = "//input[@value='ALL']")
	private WebElement rdoViewAll;

	@B2BFindBy(xpath = "//input[@name='singles']")
	private WebElement chkBoxSingles;

	@B2BFindBy(xpath = "//input[@data-index='1']/following-sibling::span")
	private WebElement ratingSecondNode;

	@B2BFindBys(@B2BFindBy(xpath = "//h2[contains(@class,'MuiTypography-root MuiTypography-h2')]"))
	private List<WebElement> lstPlayerRatings;

	@B2BFindBy(xpath = "//button[@value='MALE']")
	private WebElement btnMale;

	@B2BFindBy(xpath = "//input[@name='controlled-radio-buttons-group' and @value='0, 19']")
	private WebElement rdoUnder19;

	@B2BFindBy(xpath = "//p[text()='Full name is required.']")
	private WebElement txtValidationFullNameRequired;

	@B2BFindBy(xpath = "//p[text()='Email is required.']")
	private WebElement txtValidationEmailIsRequired;

	@B2BFindBy(xpath = "//p[text()='No numbers or special characters are allowed.']")
	private WebElement txtValidationNoNumbersOrSpecialCharactersAllowed;

	@B2BFindBy(xpath = "//p[text()='Email is invalid.']")
	private WebElement txtValidationEmailIsInvalid;

	@B2BFindBy(xpath = "(//button[@type='button' and contains(@class, 'MuiIconButton-root MuiIconButton-sizeMedium')]/span[contains(@class, 'MuiTouchRipple-root')])[2]")
	private WebElement btnBackArrow;

	public BrowsePlayersPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public void clickOnFilterButton() {
		log.info("Starting of clickOnFilterButton method");

		elementClick(btnFilters);

		log.info("Ending of clickOnFilterButton method");
	}

	public String getPlayerName(String name) {
		log.info("Starting of getPlayerName method");

		String playerName = null;
		for (int i = 0; i <= lstPlayerNames.size() - 1; i++) {

			if (lstPlayerNames.get(i).getText().equalsIgnoreCase(name)) {
				playerName = lstPlayerNames.get(i).getText();
				break;
			}
		}

		log.info("Ending of getPlayerName method");

		return playerName;
	}

	public boolean isBrowsePlayersPageContains() {
		log.info("Starting of isBrowsePlayersPageContains method");

		boolean isBrowsePlayersPageContains = false;

		if (isDisplayed(lblBrowsePlayers) && isDisplayed(txtBoxSearchInBrowsePlayers)
				&& isDisplayed(tabInvitePlayerToDUPR) && isDisplayed(btnFilters)) {
			isBrowsePlayersPageContains = true;
		}

		log.info("Ending of isBrowsePlayersPageContains method");

		return isBrowsePlayersPageContains;
	}

	public boolean isInvitePlayerPageContains() {
		log.info("Starting of isInvitePlayerPageContains method");

		boolean isInvitePlayerPageContains = false;

		if (isDisplayed(txtBoxFullName) && isDisplayed(txtBoxEmail) && isDisplayed(lblFullName)
				&& isDisplayed(lblEmailAddress) && isDisplayed(lblInvitePlayer) && isDisplayed(btnBack)
				&& isDisplayed(btnSendInvite)) {
			isInvitePlayerPageContains = true;
		}

		log.info("Ending of isInvitePlayerPageContains method");

		return isInvitePlayerPageContains;
	}

	public void clickOnInvitePlayerToDUPRTab() {
		log.info("Starting of clickOnInvitePlayerToDUPRTab method");

		elementClick(tabInvitePlayerToDUPR);

		log.info("Ending of clickOnInvitePlayerToDUPRTab method");
	}

	public void clickOnFindNearMeToggleButton() {
		log.info("Starting of clickOnFindNearMeToggleButton method");

		elementClick(tglFindNearMePlayer);

		log.info("Ending of clickOnFindNearMeToggleButton method");
	}

	public boolean isFiltersPageContains() {
		log.info("Starting of isFiltersPageContains method");

		boolean isFiltersPageContains = false;

		if (isDisplayed(btnClearAll) && isDisplayed(btnApply) && isDisplayed(txtBoxLocationInFilters)
				&& isDisplayed(lblFilters) && isDisplayed(lblLocation) && isDisplayed(lblDistance)
				&& isDisplayed(lblSkillLevelRatings) && isDisplayed(lblType) && isDisplayed(lblGender)
				&& isDisplayed(lblAgeRange)) {
			isFiltersPageContains = true;
		}

		log.info("Ending of isFiltersPageContains method");

		return isFiltersPageContains;
	}

	public void setLocationInFilters(String location) {
		log.info("Starting of setLocationInFilters method");

		clickOnWebElement(txtBoxLocationInFilters);
		txtBoxLocationInFilters.sendKeys(location);

		log.info("Ending of setLocationInFilters method");
	}

	public void clickOnlocationOption() {
		log.info("Starting of clickOnlocationOption method");

		for (int i = 0; i < lstLocationOptions.size() - 1; i++) {
			String location = lstLocationOptions.get(i).getText();

			if (location.equalsIgnoreCase("Pune, Maharashtra, India")) {

				lstLocationOptions.get(i).click();
				break;
			}
		}

		log.info("Ending of clickOnlocationOption method");
	}

	public void clickOnApplyButton() {
		log.info("Starting of clickOnApplyButton method");

		elementClick(btnApply);

		log.info("Ending of clickOnApplyButton method");
	}

	public boolean getPlayerLocation() {
		log.info("Starting of getPlayerLocation method");

		boolean flag = false;

		try {
			for (int i = 0; i < lstPlayersLocations.size() - 1; i++) {
				String locations = lstPlayersLocations.get(i).getText();
				if (locations.contains("Pune")) {
					flag = true;
				}
			}
		} catch (Exception e) {
			flag = false;
		}
		log.info("Ending of getPlayerLocation method");

		return flag;
	}

	public void clickOnClearAllButton() {
		log.info("Starting of clickOnClearAllButton method");

		elementClick(btnClearAll);

		log.info("Ending of clickOnClearAllButton method");
	}

	public void moveDistanceSlider() {
		log.info("Starting of moveDistanceSlider method");

		Actions act = new Actions(driver);
		act.moveToElement(distanceSliderNode).perform();
		act.dragAndDropBy(distanceSliderNode, 100, 0).perform();

		log.info("Ending of moveDistanceSlider method");
	}

	public boolean getPlayersDistance() {
		log.info("Starting of getPlayersDistance method");

		boolean flag = false;

		try {
			for (int i = 0; i < lstPlayersDistance.size() - 1; i++) {
				String distance = lstPlayersDistance.get(i).getText();
				if (distance.equalsIgnoreCase("Nearby")) {
					flag = true;
				}
			}
		} catch (Exception e) {
			flag = false;
		}

		log.info("Ending of getPlayersDistance method");

		return flag;
	}

	public void moveRatingSecondSlider() {
		log.info("Starting of moveRatingSecondSlider method");

		Actions act = new Actions(driver);
		act.moveToElement(ratingSecondNode).perform();
		act.dragAndDropBy(ratingSecondNode, -100, 0).perform();

		log.info("Ending of moveRatingSecondSlider method");
	}

	public boolean getPlayersRatings() {
		log.info("Starting of getPlayersRatings method");

		boolean flag = false;
		try {
			for (int i = 0; i < lstPlayerRatings.size() - 1; i++) {
				String rating = lstPlayerRatings.get(i).getText();
				float num = Float.parseFloat(rating);

				if (num >= 2.00 && num <= 5.00) {
					flag = true;
				}
			}
		} catch (Exception e) {
			flag = false;
		}

		log.info("Ending of getPlayersRatings method");

		return flag;
	}

	public void clickOnDoublesCheckBox() {
		log.info("Starting of clickOnDoublesCheckBox method");

		elementClick(chkBoxDoubles);

		log.info("Ending of clickOnDoublesCheckBox method");
	}

	public void clickOnSinglesCheckBox() {
		log.info("Starting of clickOnSinglesCheckBox method");

		elementClick(chkBoxSingles);

		log.info("Ending of clickOnSinglesCheckBox method");
	}

	public boolean getPlayersSinglesRating() {
		log.info("Starting of getPlayersSinglesRating method");

		boolean flag = false;

		try {
			for (int i = 0; i < lstPlayersSingleMatchRatings.size() - 1; i++) {
				String Rating = lstPlayersSingleMatchRatings.get(i).getText();
				if (Rating.equals("NR")) {
					flag = true;
				} else {
					float rating = Float.parseFloat(Rating);

					if ((rating >= 2.00 && rating <= 8.00)) {
						flag = true;

					}
				}
			}
		} catch (Exception e) {
			flag = false;
		}

		log.info("Ending of getPlayersSinglesRating method");

		return flag;
	}

	public boolean getPlayersDoublesRating() {
		log.info("Starting of getPlayersDoublesRating method");

		boolean flag = false;

		try {
			for (int i = 0; i < lstPlayersDoublesMatchRatings.size() - 1; i++) {
				String Rating = lstPlayersDoublesMatchRatings.get(i).getText();
				if (Rating.equals("NR")) {
					flag = true;
				} else {
					float rating = Float.parseFloat(Rating);

					if ((rating >= 2.00 && rating <= 8.00)) {
						flag = true;
					}
				}
			}
		} catch (Exception e) {
			flag = false;
		}

		log.info("Ending of getPlayersDoublesRating method");

		return flag;
	}

	public void selectGender() {
		log.info("Starting of selectGender method");

		elementClick(btnMale);

		log.info("Ending of selectGender method");
	}

	public void clickOnAgeOptionRadioButton() {
		log.info("Starting of clickOnAgeOptionRadioButton method");

		elementClick(rdoUnder19);

		log.info("Ending of clickOnAgeOptionRadioButton method");
	}

	public boolean getPlayersAge() {
		log.info("Starting of getPlayersAge method");

		boolean flag = false;
		try {
			for (int i = 0; i < lstPlayersAge.size() - 1; i++) {
				String rating = lstPlayersAge.get(i).getText().split(" ")[1].trim();

				int num = Integer.parseInt(rating);

				if (num >= 2 && num < 19) {
					flag = true;
				}
			}
		} catch (Exception e) {
			flag = false;
		}

		log.info("Ending of getPlayersAge method");

		return flag;
	}

	public boolean getPlayersDistances() {
		log.info("Starting of getPlayersDistances method");

		boolean flag = false;

		try {
			for (int i = 0; i < lstPlayersDistance.size() - 1; i++) {
				String Rating = lstPlayersDistance.get(i).getText();
				if (Rating.equals("Nearby")) {
					flag = true;
				} else {
					String rate = Rating.split(" ")[0].trim();
					float rating = Float.parseFloat(rate);

					if ((rating >= 1 && rating <= 10)) {
						flag = true;
					}
				}
			}
		} catch (Exception e) {
			flag = false;
		}

		log.info("Ending of getPlayersDistances method");

		return flag;
	}

	public boolean isUnder19RadioButtonSeleceted() {
		log.info("Starting of isUnder19RadioButtonSeleceted method");
		log.info("Ending of isUnder19RadioButtonSeleceted method");

		return rdoUnder19.isSelected();
	}

	public boolean isViewAllRadioButtonSeleceted() {
		log.info("Starting of isViewAllRadioButtonSeleceted method");
		log.info("Ending of isViewAllRadioButtonSeleceted method");

		return rdoViewAll.isSelected();
	}

	public String getFullNameIsRequiredText() {
		log.info("Starting of getFullNameIsRequiredText method");
		log.info("Ending of getFullNameIsRequiredText method");

		return getText(txtValidationFullNameRequired);
	}

	public String getEmailIsRequiredText() {
		log.info("Starting of getEmailIsRequiredText method");
		log.info("Ending of getEmailIsRequiredText method");

		return getText(txtValidationEmailIsRequired);
	}

	public String getNoNumbersOrSpecialCharatersAreAllowedRequiredText() {
		log.info("Starting of getNoNumbersOrSpecialCharatersAreAllowedRequiredText method");
		log.info("Ending of getNoNumbersOrSpecialCharatersAreAllowedRequiredText method");

		return getText(txtValidationNoNumbersOrSpecialCharactersAllowed);
	}

	public String getInvalidEmailText() {
		log.info("Starting of getInvalidEmailText method");
		log.info("Ending of getInvalidEmailText method");

		return getText(txtValidationEmailIsInvalid);
	}

	public void clickOnBackArrowButton() {
		log.info("Starting of clickOnBackArrowButton method");

		elementClick(btnBackArrow);

		log.info("Ending of clickOnBackArrowButton method");
	}
}
