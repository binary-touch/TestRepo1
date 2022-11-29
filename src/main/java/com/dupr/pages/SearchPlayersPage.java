package com.dupr.pages;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BFindBys;
import com.b2b.support.B2BPageFactory;

public class SearchPlayersPage extends DUPRBaseAutomationPage {

	private static final Logger logger = LogManager.getLogger(SearchPlayersPage.class);
	@B2BFindBy(xpath = "//div[@class='flex items-center justify-center']/a[text()='Search Players']")
	private WebElement lnkSearch;

	@B2BFindBy(xpath = "//div[@class='MuiBox-root css-1510wke']/preceding-sibling::div/p")
	private WebElement lblSearch;

	@B2BFindBy(xpath = "//input[@id='Search']")
	private WebElement txtBoxSearch;

	@B2BFindBy(xpath = "//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputTypeSearch css-1n7nl07']")
	private WebElement txtBoxLocation;

	@B2BFindBy(xpath = "//button[@id='rangeslidermenubutton']")
	private WebElement ddRating;

	@B2BFindBy(xpath = "//div[@id='select-Gender']")
	private WebElement ddGender;

	@B2BFindBy(xpath = "//div[@id='select-Age']")
	private WebElement ddAge;

	@B2BFindBy(xpath = "//input[@class='PrivateSwitchBase-input css-1m9pwf3' and @value='SINGLES']")
	private WebElement rdoSingles;

	@B2BFindBy(xpath = "//button[contains(@class,'MuiButton-contained')]")
	private WebElement btnApply;

	@B2BFindBy(xpath = "//span[text()='Chantilly VA, USA']")
	private WebElement lstLocation;

	@B2BFindBy(xpath = "//input[@data-index='1']")
	private WebElement silderNode;

	@B2BFindBy(tagName = "b")
	private WebElement msgResult;

	@B2BFindBys(@B2BFindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 MuiTypography-noWrap text-base max-w-full font-medium font-robo css-af81j8']"))
	private List<WebElement> lstPlayersNames;

	@B2BFindBys(@B2BFindBy(xpath = "//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation3 w-full flex gap-2 rounded-md p-2 items-center css-1b9p2lz'] //p[@class='MuiTypography-root MuiTypography-body1 MuiTypography-noWrap text-sm text-gray-600 font-robo css-z5o8kd']"))
	private List<WebElement> lstPlayersLocation;

	@B2BFindBys(@B2BFindBy(xpath = "//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation3 w-full flex gap-2 rounded-md p-2 items-center css-1b9p2lz'] //div[@class='MuiBox-root css-fhxiwe']/p/following-sibling::p"))
	private List<WebElement> lstPlayersAge;

	@B2BFindBys(@B2BFindBy(xpath = "//li //div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-2 css-o0rlmm']/following-sibling::div/descendant::p"))
	private List<WebElement> lstPlayerRange;

	@B2BFindBys(@B2BFindBy(xpath = "//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li"))
	private List<WebElement> lstGender;

	@B2BFindBys(@B2BFindBy(xpath = "//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li"))
	private List<WebElement> lstAge;

	public SearchPlayersPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public void clickOnSearchLink() {
		logger.info("Starting of clickOnSearchLink method");

		this.impicitWait();
		this.clickOnWebElement(lnkSearch);

		logger.info("Ending of clickOnSearchLink method");
	}

	public void clickAndDragSliderNode() {
		logger.info("Starting of clickAndDragSliderNode method");

		this.impicitWait();
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

		this.impicitWait();
		this.clickOnWebElement(txtBoxSearch);
		txtBoxSearch.sendKeys(playername);

		logger.info("Ending of searchWithPlayerName method");
	}

	public void searchWithPlayerLocation(String location) {
		logger.info("Starting of searchWithPlayerLocation method");

		this.impicitWait();
		txtBoxLocation.click();
		txtBoxLocation.sendKeys(location);

		logger.info("Ending of searchWithPlayerLocation method");
	}

	public void clickOnLocationDropDown() {
		logger.info("starting of clickOnLocationDropDown method");

		this.impicitWait();
		this.clickOnWebElement(lstLocation);

		logger.info("Ending of clickOnLocationDropDown method");
	}

	public void clickOnRatingDropDown() {
		logger.info("Starting of clickOnRatingDropDown method");

		this.impicitWait();
		ddRating.click();

		logger.info("Ending of clickOnRatingDropDown method");
	}

	public void clickOnGenderDropDown() {
		logger.info("Starting of clickOnGenderDropDown method");

		this.impicitWait();

		try {
			this.ddGender.click();
		} catch (Exception e) {
			this.clickOnWebElement(ddGender);
		}

		for (int i = 1; i < lstGender.size() - 1; i++) {
			String gender = lstGender.get(i).getText();
			if (gender.contains("Men")) {

				lstGender.get(i).click();
				break;
			}
		}

		logger.info("Ending of clickOnGenderDropDown method");
	}

	public void clickOnAgeDropDown() {
		logger.info("Starting of clickOnAgeDropDown method");

		this.impicitWait();
		try {
			this.ddAge.click();
		} catch (Exception e) {
			this.clickOnWebElement(ddAge);
		}
		for (int i = 1; i < lstAge.size() - 1; i++) {
			String gender = lstAge.get(i).getText();
			if (gender.contains("35 - 49")) {
				lstAge.get(i).click();
				break;
			}

		}

		logger.info("Ending of clickOnAgeDropDown method");
	}

	public void clickOnRadioButton() {
		logger.info("Starting of clickOnRadioButton method");

		this.impicitWait();
		rdoSingles.click();

		logger.info("Ending of clickOnRadioButton method");
	}

	public void clickOnApplyButton() {
		logger.info("starting of clickOnApplyButton method");

		this.impicitWait();
		btnApply.click();

		logger.info("Ending of clickOnApplyButton method");
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

	public String getPlayerName() {
		logger.info("Starting of getPlayerName method");

		this.impicitWait();
		String playerName = null;
		for (int i = 0; i <= lstPlayersNames.size() - 1; i++) {

			if (lstPlayersNames.get(i).getText().contains("Meet Patel")) {
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
		this.impicitWait();
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

	public boolean getPlayerRating() {
		logger.info("Starting of getPlayerRating method");

		boolean flag = false;
		this.impicitWait();
		try {
			for (int i = 0; i < lstPlayerRange.size() - 1; i++) {
				String Rating = lstPlayerRange.get(i).getText();
				float rating = Float.parseFloat(Rating);
				System.out.println(rating);
				if (rating >= 3.0 && rating < 4.0) {
					flag = true;
					break;
				}
			}
		} catch (Exception e) {
			flag = false;
		}

		logger.info("Ending of getPlayerRating method");
		return flag;

	}

	public String getNoResultFoundMessage() {
		logger.info("Starting of getNoResultFoundMessage method");
		this.impicitWait();
		logger.info("Ending of getNoResultFoundMessage method");

		return getText(msgResult);
	}

}
