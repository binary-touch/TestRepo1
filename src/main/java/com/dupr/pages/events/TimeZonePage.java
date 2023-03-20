package com.dupr.pages.events;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class TimeZonePage extends DUPRBaseAutomationPage {
	private static final Logger log = LogManager.getLogger(AddEventPage.class);

	@B2BFindBy(xpath = "//h3[text()='Registration Date']")
	private WebElement lblRegistrationDate;

	@B2BFindBy(xpath = "//h3[text()='Registration Date']/parent::div/div/div/div/div/h5[text()='Start Date & Time']")
	private WebElement lblRegistrationStartDateTime;

	@B2BFindBy(xpath = "//h3[text()='Registration Date']/parent::div/div/div/div/div/h5[text()='End Date & Time']")
	private WebElement lblRegistrationEndDateTime;

	@B2BFindBy(xpath = "//h3[text()='Competition Date']")
	private WebElement lblCompetitionDate;

	@B2BFindBy(xpath = "//h3[text()='Competition Date']/parent::div/div/div/div/div/h5[text()='Start Date & Time']")
	private WebElement lblCompetitionStartDateTime;

	@B2BFindBy(xpath = "//h3[text()='Competition Date']/parent::div/div/div/div/div/h5[text()='End Date & Time']")
	private WebElement lblCompetitionEndDateTime;

	@B2BFindBy(xpath = "//h3[text()='Time Zone']/parent::div/div/div/div")
	private WebElement drpTimeZone;

	@B2BFindBy(xpath = "//h3[text()='Registration Date']/parent::div//h5[text()='Start Date & Time']/parent::div/following-sibling::div//input")
	private WebElement txtRegistrationStartDateTime;

	@B2BFindBy(xpath = "//h3[text()='Registration Date']/parent::div//h5[text()='End Date & Time']/parent::div/following-sibling::div//input")
	private WebElement txtRegistrationEndDateTime;

	@B2BFindBy(xpath = "//h3[text()='Competition Date']/parent::div//h5[text()='Start Date & Time']/parent::div/following-sibling::div//input")
	private WebElement txtCompetitionStartDateTime;

	@B2BFindBy(xpath = "//h3[text()='Competition Date']/parent::div//h5[text()='End Date & Time']/parent::div/following-sibling::div//input")
	private WebElement txtCompetitionEndDateTime;

	@B2BFindBy(xpath = "//h4[text()='Registration Start Date ']/following-sibling::p")
	private WebElement txtRegStartDateInEventDetails;

	@B2BFindBy(xpath = "//h4[text()='Registration End Date']/following-sibling::p")
	private WebElement txtRegEndDateInEventDetails;

	@B2BFindBy(xpath = "//h4[text()='Competition Start Date']/following-sibling::p")
	private WebElement txtComstartDateInEventDetails;

	@B2BFindBy(xpath = "//h4[text()='Competition End Date']/following-sibling::p")
	private WebElement txtCompEndDateInEventDetails;

	@B2BFindBy(xpath = "//div[contains(text(),'(GMT-06:00) Central America')]")
	private WebElement txtCentalAmericaTimeZone;

	@B2BFindBy(xpath = "//div[text()='(GMT+05:30) Chennai, Kolkata, Mumbai, New Delhi']")
	private WebElement txtIndianTimeZone;

	@B2BFindBy(xpath = "//h4[text()='Time Zone']/following-sibling::p[text()='(GMT-06:00) Central America']")
	private WebElement txtTimeZoneInEventDetails;

	@B2BFindBy(xpath = "//h4[text()='Time Zone']/following-sibling::p[text()='(GMT+05:30) Chennai, Kolkata, Mumbai, New Delhi']")
	private WebElement txtNewDelhiTimeZoneInEventDetails;

	@B2BFindBy(xpath = "//h4[text()='Time Zone']/following-sibling::p[text()='(GMT-07:00) Arizona']")
	private WebElement txtArizonaTimeZoneInEventDetails;

	@B2BFindBy(xpath = "//span[text()='Upcoming']")
	private WebElement lblUpcoming;

	@B2BFindBy(xpath = "//span[text()='Open']")
	private WebElement lblOpen;

	@B2BFindBy(xpath = "//span[text()='Ongoing']")
	private WebElement lblOnGoing;

	@B2BFindBy(xpath = "//span[text()='Complete']")
	private WebElement lblComplete;

	@B2BFindBy(xpath = "//span[text()='Registration Closed']")
	private WebElement lblRegistrationClosed;

	@B2BFindBy(xpath = "//h6[text()='Events']")
	private WebElement tabEvents;

	@B2BFindBy(xpath = "//*/h4")
	private List<WebElement> lstBrowseEvents;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation3')]//following-sibling::div//h4")
	private List<WebElement> lstEvents;

	@B2BFindBy(xpath = "//span[text()='Open']")
	private List<WebElement> lstOpenEvents;

	@B2BFindBy(xpath = "//button[contains(text(),'Add a Bracket')]")
	private WebElement btnAddABracket;

	@B2BFindBy(xpath = "//button[contains(text(),'Publish')]")
	private WebElement btnPublish;

	@B2BFindBy(xpath = "//h4[contains(text(),'Success')]")
	private WebElement lblSuccess;

	@B2BFindBy(xpath = "//h4[contains(text(),'Success')]/button")
	private WebElement btnSuccessPopUpClose;

	@B2BFindBy(xpath = "//h6[contains(text(),'Bracket Created.')]")
	private WebElement lblBracketCreated;

	@B2BFindBy(xpath = "//h4[contains(text(),'MIXED DOUBLES')]")
	private WebElement lblMixedDoubleBracketBracketCreated;

	@B2BFindBy(xpath = "//button[text()='Edit Bracket']	")
	private WebElement btnEditBracket;

	@B2BFindBy(xpath = "//button[text()='Save Changes']")
	private WebElement btnSaveChanges;

	@B2BFindBy(xpath = "//h4[contains(@class,'MuiTypography-root MuiTypography-h4')]/parent::div/div/following-sibling::div/p[contains(@class,'MuiTypography-root MuiTypography-body2')]")
	private WebElement lblcompetitionRange;

	@B2BFindBy(xpath = "//h4[contains(@class,'MuiTypography-root MuiTypography-h4')]/parent::div/div/following-sibling::div/p[contains(@class,'MuiTypography-root MuiTypography-body2')]/following-sibling::h6")
	private WebElement lblLessthenSevenRelativeDays;

	@B2BFindBy(xpath = "//h4[contains(@class,'MuiTypography-root MuiTypography-h4')]/parent::div/div/following-sibling::div/p[contains(@class,'MuiTypography-root MuiTypography-body2')]/following-sibling::h6/div/span")
	private WebElement lblhoursAndMins;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiChip-root MuiChip-semifilled MuiChip-sizeSmall MuiChip-colorS')]/span")
	private WebElement lblStatus;

	@B2BFindBy(xpath = "//button[text()='Information']")
	private WebElement btnInformation;

	@B2BFindBy(xpath = "//h5[contains(text(),'Time Zone:')]/parent::div")
	private WebElement lblTimeZoneInformation;

	@B2BFindBy(xpath = "//h5[contains(text(),'Registration Dates:')]/parent::div")
	private WebElement lblRegistrationInformation;

	@B2BFindBy(xpath = "//h5[contains(text(),'Competition Dates:')]/parent::div")
	private WebElement lblCompetitionInformation;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiBox-root')]/h5/following-sibling::h5/following-sibling::p")
	private WebElement lblCompRange;

	@B2BFindBy(xpath = "//h6[text()='Home']")
	private WebElement tabHome;

	@B2BFindBy(xpath = "//h4[text()='My Events']")
	private WebElement tabMyEvents;

	@B2BFindBy(xpath = "//button[text()='Register']")
	private WebElement btnRegister;

	@B2BFindBy(xpath = "//h3[text()='Registration Date']/following-sibling::div//h5[text()='Start Date & Time']/parent::div/following-sibling::div//input")
	private WebElement txtBoxRegistrationStartDate;

	@B2BFindBy(xpath = "//h3[text()='Registration Date']/following-sibling::div//h5[text()='End Date & Time']/parent::div/following-sibling::div//input")
	private WebElement txtBoxRegistrationEndDate;

	@B2BFindBy(xpath = "//h3[text()='Competition Date']/following-sibling::div//h5[text()='Start Date & Time']/parent::div/following-sibling::div//input")
	private WebElement txtBoxCompetitionStartDate;

	@B2BFindBy(xpath = "//h3[text()='Competition Date']/following-sibling::div//h5[text()='End Date & Time']/parent::div/following-sibling::div//input")
	private WebElement txtBoxCompetitionEndDate;

	@B2BFindBy(xpath = "//span[text()='55']")
	private WebElement btnTimeInMinutes;

	@B2BFindBy(xpath = "//button[text()='OK']")
	private WebElement btnOK;

	@B2BFindBy(xpath = "//h3[text()='Time Zone']/parent::div/div/div/div")
	private WebElement ddTimeZone;

	@B2BFindBy(xpath = "//button[@aria-label='calendar view is open, switch to year view']")
	private WebElement ddRegistrationEndDate;

	@B2BFindBy(xpath = "//li[text()='(GMT+05:30) Chennai, Kolkata, Mumbai, New Delhi']")
	private WebElement btnIndianTime;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiPickersFadeTransitionGroup-root')]//div[contains(@class,'MuiPickersCalendarHeader-label')]")
	private WebElement lblMonth;

	public TimeZonePage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public void clickOnCurrentYear() {

		int currentYearValue = this.getCurrentYear();
		System.out.println(currentYearValue);

		try {
			clickOnElementUsingActionClass(driver.findElement(By.xpath("//button[text()='" + currentYearValue + "']")));
		} catch (Exception e) {
			driver.findElement(By.xpath("//button[text()='" + currentYearValue + "']")).click();
		}
	}

	public boolean isDisplayedRegistrationandCompetitionFieldslContains() {
		log.info("Starting of isDisplayedRegistrationandCompetitionFieldslContains method");

		boolean isDisplayedRegistrationandCompetitionFieldslContains = false;

		if (isDisplayed(lblRegistrationDate) && isDisplayed(lblRegistrationStartDateTime)
				&& isDisplayed(lblRegistrationEndDateTime) && isDisplayed(lblCompetitionDate)
				&& isDisplayed(lblCompetitionStartDateTime) && isDisplayed(lblCompetitionEndDateTime)
				&& isDisplayed(drpTimeZone)) {

			isDisplayedRegistrationandCompetitionFieldslContains = true;
		}

		log.info("Ending of isDisplayedRegistrationandCompetitionFieldslContains method");

		return isDisplayedRegistrationandCompetitionFieldslContains;
	}

	public boolean isEnteredMinimumAgeDisplayed() {
		log.info("Starting of isEnteredMinimumAgeDisplayed method");

		boolean isEnteredMinimumAgeDisplayed = false;
		try {
			if (txtCentalAmericaTimeZone.getAttribute("value").equals("(GMT-06:00) Central America")) {
				System.out
						.println(txtCentalAmericaTimeZone.getAttribute("value").equals("(GMT-06:00) Central America"));
				isEnteredMinimumAgeDisplayed = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("Ending of isEnteredMinimumAgeDisplayed method");

		return isEnteredMinimumAgeDisplayed;
	}

	public String getRegistrationStartDateTimeText() {
		log.info("Starting of getRegistrationStartDateTimeText method");

		System.out.println(txtRegistrationStartDateTime.getAttribute("value"));

		String date = txtRegistrationStartDateTime.getAttribute("value").substring(0, 6);
		System.out.println(date);

		String time = txtRegistrationStartDateTime.getAttribute("value").substring(8);
		System.out.println(time);

		String dateAndTime = date + time;
		System.out.println(dateAndTime);

		log.info("Ending of getRegistrationStartDateTimeText method");
		return dateAndTime;
	}

	public String getRegistrationEndDateTimeValue() {
		log.info("Starting of getRegistrationEndDateTimeText method");

		System.out.println(txtRegistrationEndDateTime.getAttribute("value"));

		String date = txtRegistrationEndDateTime.getAttribute("value").substring(0, 6);
		System.out.println(date);

		String time = txtRegistrationEndDateTime.getAttribute("value").substring(8);
		System.out.println(time);

		String dateAndTime = date + time;
		System.out.println(dateAndTime);

		log.info("Ending of getRegistrationEndDateTimeText method");

		return dateAndTime;
	}

	public String getCompetitionStartDateTimeValue() {
		log.info("Starting of getCompetitionStartDateTimeText method");

		System.out.println(txtCompetitionStartDateTime.getAttribute("value"));

		String date = txtCompetitionStartDateTime.getAttribute("value").substring(0, 6);
		System.out.println(date);

		String time = txtCompetitionStartDateTime.getAttribute("value").substring(8);
		System.out.println(time);

		String dateAndTime = date + time;
		System.out.println(dateAndTime);

		log.info("Ending of getCompetitionStartDateTimeText method");

		return dateAndTime;
	}

	public String getCompetitionEndDateTimeValue() {
		log.info("Starting of getCompetitionEndDateTimeText method");

		System.out.println(txtCompetitionEndDateTime.getAttribute("value"));

		String date = txtCompetitionEndDateTime.getAttribute("value").substring(0, 6);
		System.out.println(date);

		String time = txtCompetitionEndDateTime.getAttribute("value").substring(8);
		System.out.println(time);

		String dateAndTime = date + time;
		System.out.println(dateAndTime);

		log.info("Ending of getCompetitionEndDateTimeText method");

		return dateAndTime;
	}

	public String getRegStartInEventDetails() {
		log.info("Starting of getRegStartInEventDetails method");
		System.out.println(getText(txtRegStartDateInEventDetails));
		log.info("Ending of getRegStartInEventDetails method");

		return txtRegStartDateInEventDetails.getText();
	}

	public String getCompetitionStartDateTimeText() {
		log.info("Starting of getCompetitionStartDateTimeText method");
		System.out.println(getText(txtCompetitionStartDateTime));
		log.info("Ending of getCompetitionStartDateTimeText method");

		return txtCompetitionStartDateTime.getText();
	}

	public String getCompetitionEndDateTimeText() {
		log.info("Starting of getCompetitionEndDateTimeText method");
		System.out.println(getText(txtRegistrationEndDateTime));
		log.info("Ending of getCompetitionEndDateTimeText method");

		return txtCompetitionEndDateTime.getText();
	}

	public String getRegistrationEndDateTimeText() {
		log.info("Starting of getRegistrationEndDateTimeText method");
		System.out.println(getText(txtRegistrationEndDateTime));
		log.info("Ending of getRegistrationEndDateTimeText method");

		return txtRegistrationEndDateTime.getText();
	}

	public String getRegEndDateInEventDetails() {
		log.info("Starting of getRegEndDateInEventDetails method");
		System.out.println(getText(txtRegEndDateInEventDetails));
		log.info("Ending of getRegEndDateInEventDetails method");

		return txtRegEndDateInEventDetails.getText();
	}

	public String getCompStartDaeInEventDetails() {
		log.info("Starting of getCompetitionStartDaeText method");
		// System.out.println(getText(txtCompetitionStartDateTime));
		log.info("Ending of getCompetitionStartDaeText method");

		return txtComstartDateInEventDetails.getText();
	}

	public String getCompEndDateInEventDetails() {
		log.info("Starting of getCompEndDateInEventDetails method");
		// System.out.println(getText(txtCompEndDateInEventDetails));
		log.info("Ending of getCompEndDateInEventDetails method");

		return txtCompEndDateInEventDetails.getText();
	}

	public String getRegistrationStartDateTimeValue() {
		log.info("Starting of getRegistrationStartDateTimeValue method");
		System.out.println(getText(txtRegistrationStartDateTime));
		log.info("Ending of getRegistrationStartDateTimeValue method");

		return txtRegistrationStartDateTime.getAttribute("value");
	}

	public String getTimeZoneText() {
		log.info("Starting of getTimeZoneText method");
		log.info("Ending of getTimeZoneText method");

		return txtCentalAmericaTimeZone.getText();
	}

	public String getIndianTimeZoneText() {
		log.info("Starting of getIndianTimeZoneText method");
		log.info("Ending of getIndianTimeZoneText method");

		return txtIndianTimeZone.getText();
	}

	public String getTimeZoneInEventDetails() {
		log.info("Starting of getTimeZoneInEventDetails method");
		// System.out.println(getText(txtTimeZoneInEventDetails));
		log.info("Ending of getTimeZoneInEventDetails method");

		return txtTimeZoneInEventDetails.getText();
	}

	public String getIndianTimeZoneInEventDetails() {
		log.info("Starting of getIndianTimeZoneInEventDetails method");

		this.hardWait(3);
		log.info("Ending of getIndianTimeZoneInEventDetails method");

		return txtNewDelhiTimeZoneInEventDetails.getText();
	}

	public String getArizonaTimeZoneInEventDetails() {
		log.info("Starting of getArizonaTimeZoneInEventDetails method");
		log.info("Ending of getArizonaTimeZoneInEventDetails method");

		return txtArizonaTimeZoneInEventDetails.getText();
	}

	public boolean isRecentlyAddedEventDisplayed(String eventName) {
		log.info("Starting of isRecentlyAddedEventDisplayed method");

		boolean eventStatus = false;
		hardWait(3);

		for (int i = 0; i < lstBrowseEvents.size(); i++) {
			System.out.println(lstBrowseEvents.size());
			System.out.println(lstBrowseEvents.get(i).getText());

			if (lstBrowseEvents.get(i).getText().equals(eventName)) {

				System.out.println(lstOpenEvents.get(i).getText());
				if (lstOpenEvents.get(i).getText().contains("Open")) {
					eventStatus = true;
					break;
				}
			}
		}

		log.info("Ending of isRecentlyAddedEventDisplayed method");
		return eventStatus;
	}

	public void clickOnRecentlyAddedEvent(String eventName) {
		log.info("Starting of clickOnRecentlyAddedEvent method");

		hardWait(4);
		for (int i = 0; i < lstEvents.size(); i++) {
			System.out.println(lstEvents.get(i).getText());

			this.hardWait(2);
			if (lstEvents.get(i).getText().equals(eventName)) {
				System.out.println(lstEvents.get(i).getText());
				try {
					clickOnWebElement(lstEvents.get(i));
					this.hardWait(2);
					break;
				} catch (Exception e) {
					lstEvents.get(i).click();
					break;
				}

			}
		}
		log.info("Ending of clickOnRecentlyAddedEvent method");
	}

	public void clickOnEventsTab() {
		log.info("Starting of clickOnEventsTab method");

		try {
			tabEvents.click();
		} catch (Exception e) {
			elementClick(tabEvents);
		}
		log.info("Ending of clickOnEventsTab method");

	}

	public void clickOnAddABracketButton() {
		log.info("Starting of clickOnAddABracketButton method");

		try {
			btnAddABracket.click();
		} catch (Exception e) {
			elementClick(btnAddABracket);
		}
		log.info("Ending of clickOnAddABracketButton method");

	}

	public void clickOnPublishButton() {
		log.info("Starting of clickOnPublishButton method");

		try {

			btnPublish.click();
		} catch (Exception e) {
			elementClick(btnPublish);
		}
		log.info("Ending of clickOnPublishButton method");

	}

	public boolean isDisplayedSuccessPopUpInAddABracketContains() {
		log.info("Starting of isDisplayedSuccessPopUpInAddABracketContains method");

		boolean isDisplayedSuccessPopUpInAddABracketContains = false;

		if (isDisplayed(lblSuccess) && isDisplayed(btnSuccessPopUpClose) && isDisplayed(lblBracketCreated)) {

			isDisplayedSuccessPopUpInAddABracketContains = true;
		}

		log.info("Ending of isDisplayedSuccessPopUpInAddABracketContains method");

		return isDisplayedSuccessPopUpInAddABracketContains;
	}

	public void clickOnSuccessPopUpCloseButton() {
		log.info("Starting of clickOnSuccessPopUpCloseButton method");

		try {
			btnSuccessPopUpClose.click();
		} catch (Exception e) {
			elementClick(btnSuccessPopUpClose);
		}
		log.info("Ending of clickOnSuccessPopUpCloseButton method");

	}

	public boolean isMixedDoubleBracketBracketDisplayed() {
		log.info("Starting of isMixedDoubleBracketBracketDisplayed method");
		// System.out.println(getText(txtTimeZoneInEventDetails));
		log.info("Ending of isMixedDoubleBracketBracketDisplayed method");

		return lblMixedDoubleBracketBracketCreated.isDisplayed();
	}

	public void clickOnMixedDoubleBracket() {
		log.info("Starting of clickOnMixedDoubleBracket method");

		try {
			lblMixedDoubleBracketBracketCreated.click();
		} catch (Exception e) {
			elementClick(lblMixedDoubleBracketBracketCreated);
		}
		log.info("Ending of clickOnMixedDoubleBracket method");

	}

	public void clickOnEditBracketButton() {
		log.info("Starting of clickOnEditBracketButton method");

		try {
			btnEditBracket.click();
		} catch (Exception e) {
			elementClick(btnEditBracket);
		}
		this.hardWait(3);
		log.info("Ending of clickOnEditBracketButton method");
	}

	public void clickOnSaveChangesButton() {
		log.info("Starting of clickOnSaveChangesButton method");

		try {
			btnSaveChanges.click();
		} catch (Exception e) {
			elementClick(btnSaveChanges);
		}
		log.info("Ending of clickOnSaveChangesButton method");
	}

	public int getCurrentHourIn24HourFormat() {

		LocalDateTime dateTime = LocalDateTime.now();
		// int date = dateTime.getDayOfMonth();
		int hour = dateTime.getHour();

		return hour;
	}

	public int getFutureDate(int days) {

		LocalDateTime dateTime = LocalDateTime.now();
		LocalDateTime futureDate = dateTime.plusDays(days);
		int futureDateValue = futureDate.getDayOfMonth();

		return futureDateValue;
	}

	public boolean isLocalRangeDisplayed() {
		log.info("Starting of isLocalRangeDisplayed method");
		this.hardWait(5);
		scrollDown(-800);
		boolean state = false;
		try {
			if (lblcompetitionRange.isDisplayed()) {
				state = true;
			}
		} catch (Exception e) {
			state = false;
		}
		log.info("Ending of isLocalRangeDisplayed method");

		return state;
	}

	public boolean isLessthenSevenRelativeDaysDisplayed() {
		log.info("Starting of isLessthenSevenRelativeDaysDisplayed method");
		this.hardWait(5);
		scrollDown(-800);
		boolean state = false;
		try {
			if (lblLessthenSevenRelativeDays.isDisplayed()) {
				state = true;
			}
		} catch (Exception e) {
			state = false;
		}
		log.info("Ending of isLessthenSevenRelativeDaysDisplayed method");

		return state;
	}

	public boolean ishoursAndMinsDisplayed() {
		log.info("Starting of ishoursAndMinsDisplayed method");
		hardWait(5);
		scrollDown(-800);
		boolean ishoursAndMinsDisplayed = false;

		try {
			if (lblhoursAndMins.isDisplayed() == true) {
				ishoursAndMinsDisplayed = true;
			}
		} catch (Exception e) {
			ishoursAndMinsDisplayed = false;
		}
		log.info("Ending of ishoursAndMinsDisplayed method");

		return ishoursAndMinsDisplayed;
	}

	public boolean isStatusDisplayed1() {
		log.info("Starting of isStatusDisplayed method");

		log.info("Ending of isStatusDisplayed method");

		return lblStatus.isDisplayed();
	}

	public boolean isOpenUpcommingRegistrationClosedStatusDisplayed() {
		log.info("Starting of isOpenUpcommingRegistrationClosedStatusDisplayed method");

		hardWait(2);
		boolean isOpenUpcommingRegistrationClosedStatusDisplayed = false;
		try {
			if (this.isDisplayedOpenLabel()) {

				System.out.println(isOpenUpcommingRegistrationClosedStatusDisplayed = true);
			} else if (this.isDisplayedUpcomingLabel()) {

				System.out.println(isOpenUpcommingRegistrationClosedStatusDisplayed = true);

			} else if (this.isDisplayedRegistrationClosedLabel()) {

				System.out.println(isOpenUpcommingRegistrationClosedStatusDisplayed = true);
			} else if (this.isDisplayedOnGoingLabel()) {

				System.out.println(isOpenUpcommingRegistrationClosedStatusDisplayed = true);
			} else if (this.isDisplayedCompleteLabel()) {

				System.out.println(isOpenUpcommingRegistrationClosedStatusDisplayed = true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("Ending of isOpenUpcommingRegistrationClosedStatusDisplayed method");

		return isOpenUpcommingRegistrationClosedStatusDisplayed;
	}

	public boolean isDisplayedOpenLabel() {
		log.info("Starting of isDisplayedOpenLabel method");
		log.info("Ending of isDisplayedOpenLabels method");

		try {
			return lblOpen.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isDisplayedUpcomingLabel() {
		log.info("Starting of isDisplayedUpcomingLabel method");
		log.info("Ending of isDisplayedUpcomingLabel method");

		try {
			System.out.println(lblUpcoming.isDisplayed());
			return lblUpcoming.isDisplayed();

		} catch (Exception e) {
			return false;
		}
	}

	public boolean isDisplayedRegistrationClosedLabel() {
		log.info("Starting of isDisplayedRegistrationClosedLabel method");
		log.info("Ending of isDisplayedRegistrationClosedLabel method");

		try {
			return lblRegistrationClosed.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isDisplayedOnGoingLabel() {
		log.info("Starting of isDisplayedOnGoingLabel method");
		log.info("Ending of isDisplayedOnGoingLabel method");

		try {
			return lblOnGoing.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isDisplayedCompleteLabel() {
		log.info("Starting of isDisplayedCompleteLabel method");
		log.info("Ending of isDisplayedCompleteLabel method");

		try {
			return lblComplete.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * public boolean isOnGoingRegistrationClosedCompletedStatusDisplayed() { log.
	 * info("Starting of isOnGoingRegistrationClosedCompletedStatusDisplayed method"
	 * ); hardWait(2); boolean PlayerGroupType = false; try { if
	 * (lblOpen.getText().equals("Open")) {
	 * System.out.println(lblOpen.getText().equals("Open")); PlayerGroupType = true;
	 * } else if (lblUpcoming.getText().equals("Upcoming")) {
	 * System.out.println(lblUpcoming.getText().equals("Upcoming")); PlayerGroupType
	 * = true; } else if
	 * (lblRegistrationClosed.getText().equals("Registration closed")) {
	 * System.out.println(lblRegistrationClosed.getText().
	 * equals("Registration closed")); PlayerGroupType = true; }else if
	 * (lblOnGoing.getText().equals("Ongoing")) {
	 * System.out.println(lblStatus.getText().equals("Ongoing")); PlayerGroupType =
	 * true; } else if (lblComplete.getText().equals("Complete")) {
	 * System.out.println(lblStatus.getText().equals("Complete")); PlayerGroupType =
	 * true; } } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * log.
	 * info("Ending of isOnGoingRegistrationClosedCompletedStatusDisplayed method");
	 * 
	 * return PlayerGroupType; }
	 * 
	 */
	public void clickOnInformationButton() {
		log.info("Starting of clickOnInformationButton method");

		try {
			btnInformation.click();
		} catch (Exception e) {
			elementClick(btnInformation);
		}
		log.info("Ending of clickOnInformationButton method");
	}

	public boolean isTimeZoneInformationDisplayed() {
		log.info("Starting of isTimeZoneInformationDisplayed method");

		log.info("Ending of isTimeZoneInformationDisplayed method");

		return lblTimeZoneInformation.isDisplayed();
	}

	public boolean isRegistrationInformationDisplayed() {
		log.info("Starting of isRegistrationInformationDisplayed method");

		log.info("Ending of isRegistrationInformationDisplayed method");

		return lblRegistrationInformation.isDisplayed();
	}

	public boolean isCompetitionInformationDisplayed() {
		log.info("Starting of isCompetitionInformationDisplayed method");

		log.info("Ending of isCompetitionInformationDisplayed method");

		return lblCompetitionInformation.isDisplayed();
	}

	public boolean isCompRangeDisplayed() {
		log.info("Starting of isCompRangeDisplayed method");

		log.info("Ending of isCompRangeDisplayed method");

		return lblCompRange.isDisplayed();
	}

	public void clickOnCompRangeEventCard() {
		log.info("Starting of clickOnCompRangeEventCard method");
		if (lblCompRange.isDisplayed()) {
			try {
				clickOnWebElement(lblCompRange);
			} catch (Exception e) {
				lblCompRange.click();
				// elementClick(lblCompRange);
			}
		} else {
			try {
				this.clickUsingActionsClass(lblCompRange);
			} catch (Exception e) {
				lblCompRange.click();
			}
		}
		log.info("Ending of clickOnCompRangeEventCard method");
	}

	public void clickOnHomeButton() {
		log.info("Starting of clickOnHomeButton method");

		try {
			tabHome.click();
		} catch (Exception e) {
			elementClick(tabHome);
		}
		log.info("Ending of clickOnHomeButton method");
	}

	public void clickOnMyEventsButton() {
		log.info("Starting of clickOnMyEventsButton method");

		try {
			tabMyEvents.click();
		} catch (Exception e) {
			elementClick(tabMyEvents);
		}
		log.info("Ending of clickOnMyEventsButton method");
	}

	public boolean isRegisterDisplayed() {
		log.info("Starting of isRegisterDisplayed method");
		log.info("Ending of isRegisterDisplayed method");

		return btnRegister.isDisplayed();
	}

	public int getPastDate(int days) {
		log.info("Starting of getPastDate method");

		LocalDateTime dateTime = LocalDateTime.now();
		LocalDateTime date = dateTime.minusDays(days);
		int dateValue = date.getDayOfMonth();
		System.out.println("Date Value = " + dateValue);

		log.info("Starting of getPastDate method");

		return dateValue;
	}

	public void setRegistrationEndDateMoreThenSevenDays() {
		log.info("Starting of setRegistrationEndDateMoreThenSevenDays method");

		clickOnWebElement(txtBoxRegistrationEndDate);
		hardWait(3);
		int date = this.getFutureDate(9);
		String hours = this.getCurrentHour();
		String meridiem = this.getCurrentMeridiem();
		hardWait(3);
		this.clickOnCurrentDate(date);
		this.clickOnCurrentTime(hours);
		clickOnElementUsingActionClass(btnTimeInMinutes);
		this.clickOnCurrentTime(meridiem);
		this.clickOnElementUsingActionClass(btnOK);

		log.info("Ending of setRegistrationEndDateMoreThenSevenDays�method");
	}

	public void setRegistrationEndDateBeforeThreeDays() {
		log.info("Starting of setRegistrationEndDateBeforeThreeDays method");

		clickOnWebElement(txtBoxRegistrationEndDate);
		hardWait(3);
		int date = this.getPastDate(3);
		String hours = this.getCurrentHour();
		String meridiem = this.getCurrentMeridiem();

		this.clickOnCurrentDate(date);
		this.clickOnCurrentTime(hours);
		clickOnElementUsingActionClass(btnTimeInMinutes);
		this.clickOnCurrentTime(meridiem);
		this.clickOnElementUsingActionClass(btnOK);

		log.info("Ending of setRegistrationEndDateBeforeThreeDays�method");
	}

	public void setCompetitionStartDateMoreThenSevenDays() {
		log.info("Starting of setCompetitionStartDateMoreThenSevenDays method");

		clickOnWebElement(txtBoxCompetitionStartDate);

		int date = this.getFutureDate(10);
		String hours = this.getCurrentHour();
		String meridiem = this.getCurrentMeridiem();
		hardWait(3);
		this.clickOnCurrentDate(date);
		this.clickOnCurrentTime(hours);
		clickOnElementUsingActionClass(btnTimeInMinutes);
		this.clickOnCurrentTime(meridiem);
		this.clickOnElementUsingActionClass(btnOK);

		log.info("Ending of setCompetitionStartDateMoreThenSevenDays�method");
	}

	public void setCompetitionStartDateBeforeTwoDays() {
		log.info("Starting of setCompetitionStartDateBeforeTwoDays method");

		clickOnWebElement(txtBoxCompetitionStartDate);
		hardWait(3);

		int date = this.getPastDate(2);
		String hours = this.getCurrentHour();
		String meridiem = this.getCurrentMeridiem();

		this.clickOnCurrentDate(date);
		System.out.println(date);
		this.clickOnCurrentTime(hours);
		clickOnElementUsingActionClass(btnTimeInMinutes);
		this.clickOnCurrentTime(meridiem);
		this.clickOnElementUsingActionClass(btnOK);

		log.info("Ending of setCompetitionStartDateBeforeTwoDays�method");
	}

	public void setCompetitionStartDateBeforeOneDay() {
		log.info("Starting of setCompetitionStartDateBeforeOneDay method");

		clickOnWebElement(txtBoxCompetitionStartDate);
		hardWait(3);

		int date = this.getPastDate(1);
		String hours = this.getCurrentHour();
		String meridiem = this.getCurrentMeridiem();
		hardWait(3);
		this.clickOnCurrentDate(date);
		System.out.println(date);
		this.clickOnCurrentTime(hours);
		clickOnElementUsingActionClass(btnTimeInMinutes);
		this.clickOnCurrentTime(meridiem);
		this.clickOnElementUsingActionClass(btnOK);

		log.info("Ending of setCompetitionStartDateBeforeOneDay�method");
	}

	public void setCompetitionEndDateMoreThenSevenDays() {
		log.info("Starting of setCompetitionEndDateMoreThenSevenDays method");

		clickOnWebElement(txtBoxCompetitionEndDate);
		hardWait(3);
		int date = this.getFutureDate(11);
		String hours = this.getCurrentHour();
		String meridiem = this.getCurrentMeridiem();
		hardWait(3);
		this.clickOnCurrentDate(date);
		this.clickOnCurrentTime(hours);
		clickOnElementUsingActionClass(btnTimeInMinutes);
		this.clickOnCurrentTime(meridiem);
		this.clickOnElementUsingActionClass(btnOK);

		log.info("Ending of setCompetitionEndDateMoreThenSevenDays�method");
	}

	public void setCompetitionEndDateBeforeOneDay() {
		log.info("Starting of setCompetitionEndDateBeforeOneDay method");

		clickOnWebElement(txtBoxCompetitionEndDate);
		hardWait(3);
		int date = this.getPastDate(1);
		String hours = this.getCurrentHour();
		String meridiem = this.getCurrentMeridiem();
		hardWait(3);
		this.clickOnCurrentDate(date);
		this.clickOnCurrentTime(hours);
		clickOnElementUsingActionClass(btnTimeInMinutes);
		this.clickOnCurrentTime(meridiem);
		this.clickOnElementUsingActionClass(btnOK);

		log.info("Ending of setCompetitionEndDateBeforeOneDay�method");
	}

	public void setNewDelhiTimeZone() {
		log.info("Starting of setNewDelhiTimeZone method");
		hardWait(4);

		try {
			clickOnElementUsingActionClass(ddTimeZone);
		} catch (Exception e) {
			ddTimeZone.click();
		}

		hardWait(5);
		try {
			btnIndianTime.click();
		} catch (Exception e) {
			clickOnElementUsingActionClass(btnIndianTime);
		}

		log.info("Ending of setNewDelhiTimeZone method");
	}

	public void setRegistrationEndDateWithPlusInHour() {
		log.info("Starting of setRegistrationEndDateInHour method");

		clickOnWebElement(txtBoxRegistrationEndDate);
		clickOnWebElement(ddRegistrationEndDate);
		hardWait(2);

		this.clickOnCurrentYear();
		int date = this.getCurrentDate();

		String pattern = "h";
		String pattern1 = "a";

		LocalTime currentHour = LocalTime.now();
		LocalTime futureHour = currentHour.minusHours(1);
		String futureHourValue = futureHour.format(DateTimeFormatter.ofPattern(pattern));
		System.out.println(futureHourValue);

		String meridiem = futureHour.format(DateTimeFormatter.ofPattern(pattern1));
		String meridiemValue = meridiem.toUpperCase();
		System.out.println(meridiemValue);
		hardWait(3);
		this.clickOnCurrentDate(date);
		this.clickOnCurrentTime(futureHourValue);
		clickOnElementUsingActionClass(btnTimeInMinutes);
		this.clickOnCurrentTime(meridiemValue);
		this.clickOnElementUsingActionClass(btnOK);

		log.info("Ending of setRegistrationEndDateInHour�method");
	}

	public void setRegistrationEndDateInHour() {
		log.info("Starting of setRegistrationEndDateInHour method");

		clickOnWebElement(txtBoxRegistrationEndDate);
		clickOnWebElement(ddRegistrationEndDate);
		hardWait(2);

		this.clickOnCurrentYear();
		int date = this.getCurrentDate();

		String pattern = "h";
		String pattern1 = "a";

		LocalTime currentHour = LocalTime.now();
		LocalTime futureHour = currentHour.plusHours(1);
		String futureHourValue = futureHour.format(DateTimeFormatter.ofPattern(pattern));
		System.out.println(futureHourValue);

		String meridiem = futureHour.format(DateTimeFormatter.ofPattern(pattern1));
		String meridiemValue = meridiem.toUpperCase();
		System.out.println(meridiemValue);
		hardWait(3);
		this.clickOnCurrentDate(date);
		this.clickOnCurrentTime(futureHourValue);
		clickOnElementUsingActionClass(btnTimeInMinutes);
		this.clickOnCurrentTime(meridiemValue);
		this.clickOnElementUsingActionClass(btnOK);

		log.info("Ending of setRegistrationEndDateInHour method");
	}

	public void setRegistrationEndDateInMinusHour() {
		log.info("Starting of setRegistrationEndDateInMinusHour method");

		clickOnWebElement(txtBoxRegistrationEndDate);
		clickOnWebElement(ddRegistrationEndDate);
		hardWait(2);

		this.clickOnCurrentYear();

		int date = this.getCurrentDate();

		String pattern = "h";
		String pattern1 = "a";

		LocalTime currentHour = LocalTime.now();
		LocalTime futureHour = currentHour.minusHours(1);
		String futureHourValue = futureHour.format(DateTimeFormatter.ofPattern(pattern));
		System.out.println(futureHourValue);

		String meridiem = futureHour.format(DateTimeFormatter.ofPattern(pattern1));
		String meridiemValue = meridiem.toUpperCase();
		System.out.println(meridiemValue);
		hardWait(3);
		this.clickOnCurrentDate(date);
		this.clickOnCurrentTime(futureHourValue);
		clickOnElementUsingActionClass(btnTimeInMinutes);
		this.clickOnCurrentTime(meridiemValue);
		this.clickOnElementUsingActionClass(btnOK);

		log.info("Ending of setRegistrationEndDateInMinusHour�method");
	}

	public void setCompetitionEndDateInHour() {
		log.info("Starting of setCompetitionEndDateInHour method");

		clickOnWebElement(txtBoxCompetitionEndDate);
		hardWait(2);
		clickOnWebElement(ddRegistrationEndDate);
		hardWait(2);

		this.clickOnCurrentYear();
		int date = this.getCurrentDate();

		String pattern = "h";
		String pattern1 = "a";

		LocalTime currentHour = LocalTime.now();
		LocalTime futureHour = currentHour.plusHours(4);
		String futureHourValue = futureHour.format(DateTimeFormatter.ofPattern(pattern));
		System.out.println(futureHourValue);

		String meridiem = futureHour.format(DateTimeFormatter.ofPattern(pattern1));
		String meridiemValue = meridiem.toUpperCase();
		System.out.println(meridiemValue);

		this.clickOnCurrentDate(date);
		this.clickOnCurrentTime(futureHourValue);
		try {
			clickOnElementUsingActionClass(btnTimeInMinutes);
		} catch (Exception e) {
			elementClick(btnTimeInMinutes);
		}
		this.clickOnCurrentTime(meridiemValue);
		this.clickOnElementUsingActionClass(btnOK);

		log.info("Ending of setCompetitionEndDateInHour method");
	}

	public void setCompetitionCurrentEndDate() {
		log.info("Starting of setCompetitionCurrentEndDate method");

		scrollDown(200);

		clickOnWebElement(txtBoxCompetitionEndDate);

		int date = this.getCurrentDate();
		System.out.println(date);
		Month monthValue = this.getCurrentMonth();
		String mValue = monthValue.toString();
		System.out.println(mValue);

		String lblmonth = lblMonth.getText();
		String pNewTabValue = String.valueOf(lblmonth.split(" ")[0]).toUpperCase().trim();
		log.debug("Text is " + pNewTabValue);

		try {
			if ((mValue).equals(pNewTabValue)) {
				this.clickOnCurrentDate(date);
			} else {
				clickUsingActionsClass(driver.findElement(By.xpath("//button[@aria-label='Previous month']")));
				this.clickOnCurrentDate(date);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String hours = this.getCurrentHour();
		String meridiem = this.getCurrentMeridiem();

		this.clickOnCurrentTime(hours);
		this.clickOnCurrentTime(meridiem);
		this.clickOnElementUsingActionClass(btnOK);

		log.info("Ending of setCompetitionCurrentEndDate�method");
	}

	public void setCompetitionCurrentDate() {
		log.info("Starting of setCompetitionCurrentDate method");

		clickOnWebElement(txtBoxCompetitionStartDate);

		int date = this.getCurrentDate();
		Month monthValue = this.getCurrentMonth();
		String mValue = monthValue.toString();
		System.out.println(mValue);

		String lblmonth = lblMonth.getText();
		String pNewTabValue = String.valueOf(lblmonth.split(" ")[0]).toUpperCase().trim();
		log.debug("Text is " + pNewTabValue);

		try {
			if ((mValue).equals(pNewTabValue)) {
				this.clickOnCurrentDate(date);
			} else {
				clickUsingActionsClass(driver.findElement(By.xpath("//button[@aria-label='Previous month']")));
				this.clickOnCurrentDate(date);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String hours = this.getCurrentHour();
		String meridiem = this.getCurrentMeridiem();
		this.clickOnCurrentTime(hours);
		this.clickOnCurrentTime(meridiem);
		this.clickOnElementUsingActionClass(btnOK);

		log.info("Ending of setCompetitionCurrentDate�method");
	}

	public void setCompetitionEndDateInPastHours() {
		log.info("Starting of setCompetitionEndDateInPastHours method");

		clickOnWebElement(txtBoxCompetitionEndDate);

		clickOnWebElement(ddRegistrationEndDate);
		hardWait(2);

		this.clickOnCurrentYear();

		int date = this.getCurrentDate();

		String pattern = "h";
		String pattern1 = "a";

		LocalTime currentHour = LocalTime.now();
		LocalTime futureHour = currentHour.minusHours(1);
		String futureHourValue = futureHour.format(DateTimeFormatter.ofPattern(pattern));
		System.out.println(futureHourValue);

		String meridiem = futureHour.format(DateTimeFormatter.ofPattern(pattern1));
		String meridiemValue = meridiem.toUpperCase();
		System.out.println(meridiemValue);

		this.clickOnCurrentDate(date);
		this.clickOnCurrentTime(futureHourValue);
		clickOnElementUsingActionClass(btnTimeInMinutes);
		this.clickOnCurrentTime(meridiemValue);
		this.clickOnElementUsingActionClass(btnOK);

		log.info("Ending of setCompetitionEndDateInPastHours�method");
	}

	public void setRegistrationStartDateBeforeOneDay() {
		log.info("Starting of setRegistrationStartDateBeforeOneDay method");

		try {
			clickOnWebElement(txtBoxRegistrationStartDate);

		} catch (Exception e) {
			clickOnElementUsingActionClass(txtBoxRegistrationStartDate);
		}
		hardWait(2);
		clickOnWebElement(ddRegistrationEndDate);
		hardWait(3);

		this.clickOnCurrentYear();

		try {
			int date = this.getPastDate(1);
			Month monthValue = this.getPreviousMonth(1);
			String month = String.valueOf(monthValue);
			System.out.println(monthValue);

			String lblmonth = lblMonth.getText();
			String pNewTabValue = String.valueOf(lblmonth.split(" ")[0]).toUpperCase().trim();
			log.debug("Text is " + pNewTabValue);
			System.out.println(month);
			System.out.println(pNewTabValue);

			try {
				if ((month).equals(pNewTabValue)) {
					this.clickOnCurrentDate(date);
				} else {
					clickUsingActionsClass(driver.findElement(By.xpath("//button[@title='Previous month']")));
					this.clickOnCurrentDate(date);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			String hours = this.getCurrentHour();
			String meridiem = this.getCurrentMeridiem();
			this.clickOnCurrentTime(hours);

			clickOnElementUsingActionClass(btnTimeInMinutes);
			this.clickOnCurrentTime(meridiem);
			this.clickOnWebElement(btnOK);
		} catch (Exception e2) {
			e2.printStackTrace();
		}

		log.info("Ending of setRegistrationStartDateBeforeOneDay�method");
	}

	public void setRegistrationEndDate() {
		log.info("Starting of setRegistrationEndDate method");

		hardWait(2);
		try {
			clickOnWebElement(txtBoxRegistrationEndDate);
		} catch (Exception e) {
			clickOnElementUsingActionClass(txtBoxRegistrationEndDate);
		}

		int date = this.getFutureDate(1);
		String hours = this.getCurrentHour();
		String meridiem = this.getCurrentMeridiem();
		Month monthValue = this.getFutureMonth(1);
		String mValue = monthValue.toString();

		String lblmonth = lblMonth.getText();
		String monthvalue = String.valueOf(lblmonth.split(" ")[0]).toUpperCase().trim();
		log.debug("Derived Month value: " + mValue);
		log.debug("Current Month Value: " + monthvalue);
		log.debug("Are Current Month & Derived Month values matched: " + (mValue).equals(monthvalue));

		try {
			if ((mValue).equals(monthvalue)) {
				this.clickOnCurrentDate(date);
			} else {
				log.debug("Are Current Month & Derived Month values matched: " + (mValue).equals(monthvalue));
				log.info("***Current Month & Derived Month values are not matched, Selecting next month***");
				clickUsingActionsClass(driver.findElement(By.xpath("//button[@title='Next month']")));
				this.clickOnCurrentDate(date);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.clickOnCurrentTime(hours);
		clickOnElementUsingActionClass(btnTimeInMinutes);
		this.clickOnCurrentTime(meridiem);
		this.clickOnElementUsingActionClass(btnOK);

		log.info("Ending of setRegistrationEndDate method");
	}

	public void setCompetitionStartDateHour() {
		log.info("Starting of setCompetitionStartDateHour method");

		clickOnWebElement(txtBoxCompetitionStartDate);

		clickOnElementUsingActionClass(ddRegistrationEndDate);
		hardWait(2);

		this.clickOnCurrentYear();

		int date = this.getFutureDate(1);
		String hours = this.getCurrentHour();
		String meridiem = this.getCurrentMeridiem();
		hardWait(3);
		this.clickOnCurrentDate(date);
		this.clickOnCurrentTime(hours);
		clickOnElementUsingActionClass(btnTimeInMinutes);
		this.clickOnCurrentTime(meridiem);
		this.clickOnElementUsingActionClass(btnOK);

		log.info("Ending of setCompetitionStartDateHour�method");
	}
}
