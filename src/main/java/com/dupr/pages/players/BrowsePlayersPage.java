package com.dupr.pages.players;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BFindBys;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class BrowsePlayersPage extends DUPRBaseAutomationPage {

	private static final Logger logger = Logger.getLogger(BrowsePlayersPage.class);

	@B2BFindBy(xpath = "//button[contains(@class,'MuiButton-sizeMedium') and text()='Filters']")
	private WebElement btnFilters;

	@B2BFindBy(xpath = "//button[text()='Invite a Player to DUPR']")
	private WebElement tabInvitePlayerToDUPR;

	@B2BFindBy(xpath = "//input[contains(@class, 'PrivateSwitchBase-input MuiSwitch-input') and @type='checkbox']")
	private WebElement tglFindNearMePlayer;

	@B2BFindBys(@B2BFindBy(xpath = "//div[contains(@class, 'MuiPaper-rounded MuiPaper-elevation3')]/div/following-sibling::div[1]//following-sibling::div[1]//h4"))
	private List<WebElement> lstPlayerNames;

	@B2BFindBys(@B2BFindBy(xpath = "//p[contains(text(),'Age')]/parent::div/preceding-sibling::div/descendant::p"))
	private List<WebElement> lstPlayersLocations;

	@B2BFindBys(@B2BFindBy(xpath = "//p[contains(text(),'Age')]"))
	private List<WebElement> lstPlayersAge;

	@B2BFindBys(@B2BFindBy(xpath = "//h6[text()='Singles']/preceding-sibling::div/child::h2"))
	private List<WebElement> lstPlayersSingleMatchRatings;

	@B2BFindBys(@B2BFindBy(xpath = "//h6[text()='Doubles']/preceding-sibling::div/child::h2"))
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

	@B2BFindBy(xpath = "//h4[@id='customized-diaLog-title']")
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

	@B2BFindBy(xpath = "//h3[text()='Browse Players']/preceding-sibling::div/child::button")
	private WebElement btnBackArrow;

	public BrowsePlayersPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public void clickOnFilterButton() {
		logger.info("Starting of clickOnFilterButton method");

		elementClick(btnFilters);

		logger.info("Ending of clickOnFilterButton method");
	}

	public String getPlayerName() {
		logger.info("Starting of getPlayerName method");

		String playerName = null;

		WebElement element = driver.findElement(By.xpath("//input[@id='Search']"));
		String name = element.getAttribute("value");

		List<WebElement> element2 = driver.findElements(By.xpath("//h4[contains(text(),'" + name + "')]"));

		List<WebElement> lstPlayerNames = element2;
		System.out.println("No Of Records:" + lstPlayerNames.size());

		for (int i = 0; i < lstPlayerNames.size(); i++) {
			if (lstPlayerNames.get(i).getText().equalsIgnoreCase(name) == true) {
				playerName = lstPlayerNames.get(i).getText();
				System.out.println(playerName);

			}
		}

		logger.info("Ending of getPlayerName method");

		return playerName;
	}

	public boolean isBrowsePlayersPageContains() {
		logger.info("Starting of isBrowsePlayersPageContains method");

		boolean isBrowsePlayersPageContains = false;

		if (isDisplayed(lblBrowsePlayers) && isDisplayed(txtBoxSearchInBrowsePlayers)
				&& isDisplayed(tabInvitePlayerToDUPR) && isDisplayed(btnFilters)) {
			isBrowsePlayersPageContains = true;
		}

		logger.info("Ending of isBrowsePlayersPageContains method");

		return isBrowsePlayersPageContains;
	}

	public boolean isInvitePlayerPageContains() {
		logger.info("Starting of isInvitePlayerPageContains method");

		boolean isInvitePlayerPageContains = false;

		if (isDisplayed(txtBoxFullName) && isDisplayed(txtBoxEmail) && isDisplayed(lblFullName)
				&& isDisplayed(lblEmailAddress) && isDisplayed(lblInvitePlayer) && isDisplayed(btnBack)
				&& isDisplayed(btnSendInvite)) {
			isInvitePlayerPageContains = true;
		}

		logger.info("Ending of isInvitePlayerPageContains method");

		return isInvitePlayerPageContains;
	}

	public void clickOnInvitePlayerToDUPRTab() {
		logger.info("Starting of clickOnInvitePlayerToDUPRTab method");

		elementClick(tabInvitePlayerToDUPR);

		logger.info("Ending of clickOnInvitePlayerToDUPRTab method");
	}

	public void clickOnFindNearMeToggleButton() {
		logger.info("Starting of clickOnFindNearMeToggleButton method");

		elementClick(tglFindNearMePlayer);

		logger.info("Ending of clickOnFindNearMeToggleButton method");
	}

	public boolean isFiltersPageContains() {
		logger.info("Starting of isFiltersPageContains method");

		boolean isFiltersPageContains = false;

		if (isDisplayed(btnClearAll) && isDisplayed(btnApply) && isDisplayed(txtBoxLocationInFilters)
				&& isDisplayed(lblFilters) && isDisplayed(lblLocation) && isDisplayed(lblDistance)
				&& isDisplayed(lblSkillLevelRatings) && isDisplayed(lblType) && isDisplayed(lblGender)
				&& isDisplayed(lblAgeRange)) {
			isFiltersPageContains = true;
		}

		logger.info("Ending of isFiltersPageContains method");

		return isFiltersPageContains;
	}

	public void setLocationInFilters(String location) throws InterruptedException {
		logger.info("Starting of setLocationInFilters method");

		clickOnWebElement(txtBoxLocationInFilters);
		txtBoxLocationInFilters.sendKeys(location);
		Thread.sleep(2000);

		logger.info("Ending of setLocationInFilters method");
	}

	public void clickOnlocationOption() {
		logger.info("Starting of clickOnlocationOption method");

		for (int i = 0; i < lstLocationOptions.size() - 1; i++) {
			String location = lstLocationOptions.get(i).getText();

			if (location.equalsIgnoreCase("Pune, Maharashtra, India")) {

				lstLocationOptions.get(i).click();
				break;
			}
		}

		logger.info("Ending of clickOnlocationOption method");
	}

	public void clickOnApplyButton() {
		logger.info("Starting of clickOnApplyButton method");

		elementClick(btnApply);

		logger.info("Ending of clickOnApplyButton method");
	}

	public boolean getPlayerLocation() throws InterruptedException {
		logger.info("Starting of getPlayerLocation method");
		Thread.sleep(2000);
		elementClick(btnApply);

		boolean flag = false;

		try {
			
			System.out.println(lstPlayersLocations.size());
			for (int i = 0; i < lstPlayersLocations.size() - 1; i++) {
				String locations = lstPlayersLocations.get(i).getText();
				
				if (locations.contains("Pune")) {
					flag = true;
				}
			}
		} catch (Exception e) {
			flag = false;
		}
		logger.info("Ending of getPlayerLocation method");

		return flag;
	}


	public void clickOnClearAllButton() {
		logger.info("Starting of clickOnClearAllButton method");

		elementClick(btnClearAll);

		logger.info("Ending of clickOnClearAllButton method");
	}

	public void moveDistanceSlider() {
		logger.info("Starting of moveDistanceSlider method");

		Actions act = new Actions(driver);
		act.moveToElement(distanceSliderNode).perform();
		act.dragAndDropBy(distanceSliderNode, 100, 0).perform();

		logger.info("Ending of moveDistanceSlider method");
	}

	public boolean getPlayersDistance() {
		logger.info("Starting of getPlayersDistance method");

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

		logger.info("Ending of getPlayersDistance method");

		return flag;
	}

	public void moveRatingSecondSlider() {
		logger.info("Starting of moveRatingSecondSlider method");

		Actions act = new Actions(driver);
		act.moveToElement(ratingSecondNode).perform();
		act.dragAndDropBy(ratingSecondNode, -100, 0).perform();

		logger.info("Ending of moveRatingSecondSlider method");
	}

	public boolean getPlayersRatings() {
		logger.info("Starting of getPlayersRatings method");

		boolean flag = false;
		try {
			for (int i = 0; i < lstPlayerRatings.size() - 1; i++) {
				String rating = lstPlayerRatings.get(i).getText();
				Thread.sleep(2000);
				float num = Float.parseFloat(rating);

				if (num >= 2.00 && num <= 5.00) {
					flag = true;
				}
			}
		} catch (Exception e) {
			flag = false;
		}

		logger.info("Ending of getPlayersRatings method");

		return flag;
	}

	public void clickOnDoublesCheckBox() {
		logger.info("Starting of clickOnDoublesCheckBox method");

		elementClick(chkBoxDoubles);

		logger.info("Ending of clickOnDoublesCheckBox method");
	}

	public void clickOnSinglesCheckBox() {
		logger.info("Starting of clickOnSinglesCheckBox method");

		elementClick(chkBoxSingles);

		logger.info("Ending of clickOnSinglesCheckBox method");
	}

	public boolean getPlayersSinglesRating() {
		logger.info("Starting of getPlayersSinglesRating method");

		boolean flag = false;
		
		
		System.out.println("No Of Singles No Rating List Is: "+lstPlayersSingleMatchRatings.size());

		try {
			for (int i = 0; i < lstPlayersSingleMatchRatings.size() - 1; i++) {
				String Rating = lstPlayersSingleMatchRatings.get(i).getText();
				Thread.sleep(2000);
				if (Rating.equals("NR")) {
					flag = true;
					System.out.println(flag);
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

		logger.info("Ending of getPlayersSinglesRating method");

		return flag;
	}

	public boolean getPlayersDoublesRating() {
		logger.info("Starting of getPlayersDoublesRating method");

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

		logger.info("Ending of getPlayersDoublesRating method");

		return flag;
	}

	public void selectGender() {
		logger.info("Starting of selectGender method");

		elementClick(btnMale);

		logger.info("Ending of selectGender method");
	}

	public void clickOnAgeOptionRadioButton() {
		logger.info("Starting of clickOnAgeOptionRadioButton method");

		elementClick(rdoUnder19);

		logger.info("Ending of clickOnAgeOptionRadioButton method");
	}

	public boolean getPlayersAge() {
		logger.info("Starting of getPlayersAge method");

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

		logger.info("Ending of getPlayersAge method");

		return flag;
	}

	public boolean getPlayersDistances() {
		logger.info("Starting of getPlayersDistances method");

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

		logger.info("Ending of getPlayersDistances method");

		return flag;
	}

	public boolean isUnder19RadioButtonSeleceted() {
		logger.info("Starting of isUnder19RadioButtonSeleceted method");
		logger.info("Ending of isUnder19RadioButtonSeleceted method");

		return rdoUnder19.isSelected();
	}

	public boolean isViewAllRadioButtonSeleceted() {
		logger.info("Starting of isViewAllRadioButtonSeleceted method");
		logger.info("Ending of isViewAllRadioButtonSeleceted method");

		return rdoViewAll.isSelected();
	}

	public String getFullNameIsRequiredText() {
		logger.info("Starting of getFullNameIsRequiredText method");
		logger.info("Ending of getFullNameIsRequiredText method");

		return getText(txtValidationFullNameRequired);
	}

	public String getEmailIsRequiredText() {
		logger.info("Starting of getEmailIsRequiredText method");
		logger.info("Ending of getEmailIsRequiredText method");

		return getText(txtValidationEmailIsRequired);
	}

	public String getNoNumbersOrSpecialCharatersAreAllowedRequiredText() {
		logger.info("Starting of getNoNumbersOrSpecialCharatersAreAllowedRequiredText method");
		logger.info("Ending of getNoNumbersOrSpecialCharatersAreAllowedRequiredText method");

		return getText(txtValidationNoNumbersOrSpecialCharactersAllowed);
	}

	public String getInvalidEmailText() {
		logger.info("Starting of getInvalidEmailText method");
		logger.info("Ending of getInvalidEmailText method");

		return getText(txtValidationEmailIsInvalid);
	}

	public void clickOnBackArrowButton() {
		logger.info("Starting of clickOnBackArrowButton method");

		elementClick(btnBackArrow);

		logger.info("Ending of clickOnBackArrowButton method");
	}
}
