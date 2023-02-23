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

public class SearchPlayersPage extends DUPRBaseAutomationPage {

	private static final Logger logger = LogManager.getLogger(SearchPlayersPage.class);

	@B2BFindBy(xpath = "(//a[text()='Search Players'])[1]")
	private WebElement lnkSearch;

	@B2BFindBy(xpath = "//p[text()='Search Players']")
	private WebElement lblSearch;

	@B2BFindBy(xpath = "//input[@id='Search']")
	private WebElement txtBoxSearch;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiInputBase-fullWidth')]/input")
	private WebElement txtBoxLocation;

	@B2BFindBy(xpath = "//button[@id='rangeslidermenubutton']")
	private WebElement ddRating;

	@B2BFindBy(xpath = "//div[@id='select-Gender']")
	private WebElement ddGender;

	@B2BFindBy(xpath = "//div[@id='select-Age']")
	private WebElement ddAge;

	@B2BFindBy(xpath = "//input[@value='SINGLES']")
	private WebElement rdoSingles;

	@B2BFindBy(xpath = "//input[@value='DOUBLES']")
	private WebElement rdoDoubles;

	@B2BFindBy(xpath = "//button[text()='Apply']")
	private WebElement btnApply;

	@B2BFindBy(xpath = "//button[text()='Reset']")
	private WebElement btnReset;

	@B2BFindBys(@B2BFindBy(xpath = "//ul[@class='MuiList-root MuiList-padding css-1xifowx']/li //span[@class='MuiTypography-root MuiTypography-body1 MuiListItemText-primary css-jygkuw']"))
	private List<WebElement> lstLocationOptions;

	@B2BFindBy(xpath = "//input[@data-index='1']")
	private WebElement silderNode;

	@B2BFindBy(tagName = "b")
	private WebElement msgResult;

	@B2BFindBys(@B2BFindBy(xpath = "//div[contains(@class, 'MuiPaper-rounded MuiPaper-elevation3')]/div[2]/div/div/p[contains(@class,'font-medium font-robo')]"))
	private List<WebElement> lstPlayersNames;

	@B2BFindBys(@B2BFindBy(xpath = "//h6[contains(text(),'Doubles')]/ancestor::li/descendant::p[contains(text(),' VA, US')]"))
	private List<WebElement> lstPlayersLocation;

	@B2BFindBys(@B2BFindBy(xpath = "//div[contains(@class, 'MuiPaper-rounded MuiPaper-elevation3')]/div[2]/div/div[1]/div"))
	private List<WebElement> lstPlayersAge;

	@B2BFindBys(@B2BFindBy(xpath = "//h6[contains(text(),'Singles')]/parent::div/descendant::h2"))
	private List<WebElement> lstPlayersRatingsInSingles;

	@B2BFindBys(@B2BFindBy(xpath = "//h6[contains(text(),'Doubles')]/parent::div/descendant::h2"))
	private List<WebElement> lstPlayersRatingsInDoubles;

	@B2BFindBys(@B2BFindBy(xpath = "//ul[contains(@class, 'MuiList-padding MuiMenu-list')]/li"))
	private List<WebElement> lstGenderAndAge;

	public SearchPlayersPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public void clickOnSearchLink() {
		logger.info("Starting of clickOnSearchLink method");

		elementClick(lnkSearch);

		logger.info("Ending of clickOnSearchLink method");
	}

	public void clickAndDragSliderNode() {
		logger.info("Starting of clickAndDragSliderNode method");

		this.implicitWait();
		Actions action = new Actions(driver);
		action.clickAndHold(silderNode);
		action.moveByOffset(100, 0).build().perform();

		logger.info("Ending of clickAndDragSliderNode method");
	}

	public String getSearchPlayerText() {
		logger.info("Starting of getSearchPlayerText method");
		logger.info("Ending of getSearchPlayerText method");

		return getText(lblSearch);
	}

	public void searchWithPlayerName(String playername) {
		logger.info("Starting of searchWithPlayerName method");

		this.clickOnWebElement(txtBoxSearch);
		txtBoxSearch.sendKeys(playername);

		logger.info("Ending of searchWithPlayerName method");
	}

	public void searchWithPlayerLocation(String location) {
		logger.info("Starting of searchWithPlayerLocation method");

		this.implicitWait();
		txtBoxLocation.click();
		txtBoxLocation.sendKeys(location);

		logger.info("Ending of searchWithPlayerLocation method");
	}

	public void clickOnLocationDropDown() {
		logger.info("starting of clickOnLocationDropDown method");

		for (int i = 0; i < lstLocationOptions.size() - 1; i++) {
			String gender = lstLocationOptions.get(i).getText();

			if (gender.contains("Chantilly")) {
				lstLocationOptions.get(i).click();
				break;
			}
		}

		logger.info("Ending of clickOnLocationDropDown method");
	}

	public void clickOnRatingDropDown() {
		logger.info("Starting of clickOnRatingDropDown method");

		this.implicitWait();
		ddRating.click();

		logger.info("Ending of clickOnRatingDropDown method");
	}

	public void clickOnGenderDropDown() {
		logger.info("Starting of clickOnGenderDropDown method");

		this.implicitWait();
		// elementClick(ddGender);
		ddGender.click();

		logger.info("Ending of clickOnGenderDropDown method");
	}

	public void clickOnMenInGenderDropDown() {
		logger.info("Staring of clickOnMenInGenderDropDown method");

		for (int i = 0; i < lstGenderAndAge.size() - 1; i++) {
			String gender = lstGenderAndAge.get(i).getText();

			if (gender.contains("Men")) {

				lstGenderAndAge.get(i).click();
				break;
			}
		}

		logger.info("Ending of clickOnMenInGenderDropDown method");
	}

	public void clickOnViewAllOption() {
		logger.info("Ending of clickOnViewAllOption method");

		for (int i = 0; i < lstGenderAndAge.size() - 1; i++) {
			String gender = lstGenderAndAge.get(i).getText();

			if (gender.contains("View All")) {
				lstGenderAndAge.get(i).click();
				break;
			}
		}

		logger.info("Ending of clickOnViewAllOption method");
	}

	public void clickOnAgeDropDown() {
		logger.info("Starting of clickOnAgeDropDown method");

		this.implicitWait();
		// elementClick(ddAge);
		ddAge.click();

		logger.info("Ending of clickOnAgeDropDown method");
	}

	public void clickOnOptionAgeRangeInAgeDropDown() {
		logger.info("Ending of clickOnOptionAgeRangeInDropDown method");

		for (int i = 0; i < lstGenderAndAge.size() - 1; i++) {
			String gender = lstGenderAndAge.get(i).getText();

			if (gender.contains("35 - 49")) {
				lstGenderAndAge.get(i).click();
				break;
			}
		}

		logger.info("Ending of clickOnOptionAgeRangeInDropDown method");
	}

	public void clickOnSinglesRadioButton() {
		logger.info("Starting of clickOnSinglesRadioButton method");

		this.implicitWait();
		rdoSingles.click();

		logger.info("Ending of clickOnSinglesRadioButton method");
	}

	public void clickOnDoublesRadioButton() {
		logger.info("Starting of clickOnDoublesRadioButton method");

		this.implicitWait();
		rdoDoubles.click();

		logger.info("Ending of clickOnDoublesRadioButton method");
	}

	public void clickOnApplyButton() {
		logger.info("starting of clickOnApplyButton method");

		this.implicitWait();
		btnApply.click();

		logger.info("Ending of clickOnApplyButton method");
	}

	public void clickOnResetButton() {
		logger.info("starting of clickOnResetButton method");

		elementClick(btnReset);

		logger.info("Ending of clickOnResetButton method");
	}

	public boolean isSearchPlayersPageContains() {
		logger.info("Starting of isSearchPlayersPageContains method");

		boolean isSearchPlayersPageContains = false;

		if (isDisplayed(txtBoxSearch) && isDisplayed(ddAge) && isDisplayed(ddGender) && isDisplayed(ddRating)
				&& isDisplayed(txtBoxLocation)) {
			isSearchPlayersPageContains = true;
		}

		logger.info("Ending of isSearchPlayersPageContains method");

		return isSearchPlayersPageContains;
	}

	public String getPlayerName(String playerName) {
		logger.info("Starting of getPlayerName method");

		this.implicitWait();
		//String playerName = null;

		for (int i = 0; i <= lstPlayersNames.size() - 1; i++) {

			if (lstPlayersNames.get(i).getText().equalsIgnoreCase(playerName)) {
				playerName = lstPlayersNames.get(i).getText();
			}
		}

		logger.info("Ending of getPlayerName method");

		return playerName;
	}

	public boolean getPlayerLocation() {
		logger.info("Starting of getPlayerLocation method");

		boolean flag = false;
		try {
			for (int i = 0; i < lstPlayersLocation.size() - 1; i++) {
				String locations = lstPlayersLocation.get(i).getText();
				if (locations.contains("VA, US")) {
					flag = true;
				}
			}
		} catch (Exception e) {
			flag = false;
		}

		logger.info("Ending of getPlayerLocation method");

		return flag;
	}

	public boolean getPlayerAge() {
		logger.info("Starting of getPlayerAge method");

		boolean flag = false;
		this.implicitWait();
		try {
			for (int i = 0; i <= lstPlayersAge.size() - 1; i++) {
				String Age = lstPlayersAge.get(i).getText();
				int age = Integer.parseInt(Age);
				if (age >= 35 && age < 50) {
					flag = true;
				}
			}
		} catch (Exception e) {
			flag = false;
		}
		logger.info("Ending of getPlayerAge method");

		return flag;
	}

	public boolean getPlayerSinglesRating() {
		logger.info("Starting of getPlayerSinglesRating method");

		boolean flag = false;
		this.implicitWait();
		try {

			for (int i = 0; i < lstPlayersRatingsInSingles.size() - 1; i++) {
				String Rating = lstPlayersRatingsInSingles.get(i).getText();
				float rating = Float.parseFloat(Rating);
				logger.debug("Singles Rating: " + Rating);

				if (rating >= 3.0 && rating <= 4.0) {
					flag = true;
					// break;
					
				}
			}
		} catch (Exception e) {
			flag = false;
		}

		logger.info("Ending of getPlayerSinglesRating method");

		return flag;
	}

	public boolean getPlayerDoublesRating() {
		logger.info("Starting of getPlayerDoublesRating method");

		boolean flag = false;
		this.implicitWait();
		try {
			System.out.println(lstPlayersRatingsInDoubles.size() - 1);
			for (int i = 0; i < lstPlayersRatingsInDoubles.size() - 1; i++) {
				String Rating = lstPlayersRatingsInDoubles.get(i).getText();
				float rating = Float.parseFloat(Rating);
				logger.debug("Doubles Rating: " + Rating);
				if (rating >= 3.0 && rating <= 4.0) {
					flag = true;
				}
			}
		} catch (Exception e) {
			flag = false;
		}

		logger.info("Ending of getPlayerDoublesRating method");

		return flag;
	}

	public String getNoResultFoundMessage() {
		logger.info("Starting of getNoResultFoundMessage method");
		this.implicitWait();
		logger.info("Ending of getNoResultFoundMessage method");

		return getText(msgResult);
	}
}
