package com.dupr.pages.events;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class BrowseEventsPage extends DUPRBaseAutomationPage {
	private static final Logger log = LogManager.getLogger(BrowseEventsPage.class);

	@B2BFindBy(xpath = "//h4[contains(text(),'My Events')]")
	private WebElement btnMyEvent;

	@B2BFindBy(xpath = "//h3[contains(text(),'Events')]")
	private WebElement txtEvents;

	@B2BFindBy(xpath = "//button[text()='Browse all Events']")
	private WebElement btnBrowseAllEvents;

	@B2BFindBy(xpath = "//span[contains(@class,'MuiSwitch-thumb')]")
	private WebElement txtFindEventsNearMe;

	@B2BFindBy(xpath = "//span[contains(@class, 'MuiSwitch-switchBase')]")
	private WebElement tglFindEventsNearMe;

	@B2BFindBy(xpath = "//span[text()='Completed']")
	private WebElement btnCompleted;

	@B2BFindBy(xpath = "//span[text()='Open']")
	private WebElement btnOpen;

	@B2BFindBy(xpath = "//button[text()='Filters']")
	private WebElement btnClearFilters;

	@B2BFindBy(xpath = "//h5[text()='My Events']")
	private WebElement txtMyEvents;

	@B2BFindBy(xpath = "//input[@id='Search']")
	private WebElement txtSearch;

	@B2BFindBy(xpath = "//b[text()='No events found!']")
	private WebElement txtNoEvents;

	@B2BFindBy(xpath = "//span[text()='Complete']")
	private List<WebElement> txtComplete;

	@B2BFindBy(xpath = "//span[text()='Open']")
	private List<WebElement> txtOpen;

	@B2BFindBy(xpath = "//span[contains(@class,'MuiChip-label MuiChip-labelSmall')]")
	private List<WebElement> lblEventStatus;

	@B2BFindBy(xpath = "//span[contains(@class,'Mui-checked ')]")
	private WebElement tglLocationIsOnState;

	public BrowseEventsPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public void clickOnMyEventButton() {
		log.info("Starting of clickOnMyEventButton method");

		elementClick(btnMyEvent);

		log.info("Ending of clickOnMyEventButton method");
	}

	public boolean isMyEventsPageContains() {
		log.info("Starting of isMyEventsPageContains method");

		boolean isMyEventsPageContains = false;

		if (isDisplayed(txtEvents) && isDisplayed(btnBrowseAllEvents) && isDisplayed(txtMyEvents)) {

			isMyEventsPageContains = true;
		}

		log.info("Ending of isMyEventsPageContains method");

		return isMyEventsPageContains;
	}

	public boolean isBrowseEventsPageContains() {
		log.info("Starting of isBrowseEventsPageContains method");

		boolean isBrowseEventsPageContains = false;

		if (isDisplayed(btnClearFilters) && isDisplayed(btnCompleted) && isDisplayed(btnOpen)) {

			isBrowseEventsPageContains = true;
		}

		log.info("Ending of isBrowseEventsPageContains method");

		return isBrowseEventsPageContains;
	}

	public String getEventsText() {
		log.info("Starting of gettxtEventsText method");
		log.info("Ending of gettxtEventsText method");

		return getText(txtEvents);
	}

	public boolean getToggleOnState() {
		log.info("Starting of gettxtEventsText method");
		log.info("Ending of gettxtEventsText method");

		return isDisplayed(tglLocationIsOnState);
	}

	public boolean getCompleteText() {
		log.info("Starting of getCompleteText method");

		boolean getCompleteText = true;

		int i = 1;
		for (WebElement element : txtComplete) {
			if (!(element.getText().contains("Complete"))) {
				getCompleteText = false;
				System.out.println("testcase failed" + i);
			}
		}
		log.info("Ending of getCompleteText method");

		return getCompleteText;
	}

	public boolean getCompleteOpenEventsText() {
		log.info("Starting of getCompleteOpenEventsText method");

		boolean getCompleteOpenText = true;
		int i = 1;
		for (WebElement element : lblEventStatus) {
			if (!(element.getText().contains("Open") || element.getText().contains("Complete")
					|| element.getText().contains("Ongoing") || element.getText().contains("Registration closed")
					|| element.getText().contains("Upcoming"))) {
				getCompleteOpenText = false;
				System.out.println("testcase failed" + i);
			}
		}

		log.info("Ending of getCompleteOpenEventsText method");
		return getCompleteOpenText;
	}

	public boolean getOpenEventsText() {
		log.info("Starting of getOpenEventsText method");

		boolean getOpenText = true;
		int i = 1;
		for (WebElement element : lblEventStatus) {
			if (!(element.getText().contains("Open") || element.getText().contains("Ongoing")
					|| element.getText().contains("Upcoming"))) {
				getOpenText = false;
				System.out.println("testcase failed" + i);
			}
		}

		log.info("Ending of getOpenEventsText method");
		return getOpenText;
	}

	public void clickOnBrowseAllEventsButton() {
		log.info("Starting of clickOnBrowseAllEventsButton method");

		elementClick(btnBrowseAllEvents);

		log.info("Ending of clickOnBrowseAllEventsButton method");
	}

	public void clickOnOpen() {
		log.info("Starting of clickOnOpen method");

		clickOnElement(btnOpen);

		log.info("Ending of clickOnOpen method");
	}

	public String getFindEventsNearMeText() {
		log.info("Starting of getFindEventsNearMeText method");
		log.info("Ending of getFindEventsNearMeText method");

		return getText(txtFindEventsNearMe);
	}

	public void clickOnFindEventsNearMeToggleButton() {
		log.info("Starting of clickOnFindEventsNearMeToggleButton method");

		clickOnWebElement(tglFindEventsNearMe);

		log.info("Ending of clickOnFindEventsNearMeToggleButton method");
	}

	public void clickOnCompleted() {
		log.info("Starting of clickOnCompleted method");
		try {
			clickUsingActionsClass(btnCompleted);
		} catch (Exception e) {
			clickOnWebElement(btnCompleted);
		}

		log.info("Ending of clickOnCompleted method");
	}

	public void clickOnClearFiltersButton() {
		log.info("Starting of clickOnClearFiltersButton method");
		try {
			clickUsingActionsClass(btnClearFilters);
		} catch (Exception e) {
			elementClick(btnClearFilters);
		}

		log.info("Ending of clickOnClearFiltersButton method");
	}

	public void clickOnSearchFeild(String event) {
		log.info("Starting of clickOnSearchFeild method");

		clickOnElement(txtSearch);
		this.txtSearch.sendKeys(event);
		hardWait(2);
		this.txtSearch.sendKeys(event);

		log.info("Ending of clickOnSearchFeild method");
	}

	public String getNoResultsFountTxt() {
		log.info("Starting of getNoResultsFountTxt method");
		log.info("Ending of getNoResultsFountTxt method");

		return getText(txtNoEvents);
	}

	public void ClearSearchFeild() {
		log.info("Starting of ClearSearchFeild method");

		clickOnElement(txtSearch);
		this.txtSearch.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);

		log.info("Ending of ClearSearchFeild method");
	}
}
