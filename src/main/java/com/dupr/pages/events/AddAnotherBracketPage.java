package com.dupr.pages.events;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class AddAnotherBracketPage extends DUPRBaseAutomationPage {
	private static final Logger log = LogManager.getLogger(AddBracketPage.class);

	@B2BFindBy(xpath = "//h1[text()='Add Brackets']")
	private WebElement lblAddBrackets;

	@B2BFindBy(xpath = "//li[text()='Men']")
	private WebElement btnPlayGroupMen;

	@B2BFindBy(xpath = "//li[text()='Women']")
	private WebElement btnPlayGroupWomen;

	@B2BFindBy(xpath = "//li[text()='(GMT-11:00) Coordinated Universal Time-11']")
	private WebElement btnCoordinatedUniversalTime;

	@B2BFindBy(xpath = "//li[text()='(GMT-10:00) Hawaii']")
	private WebElement btnHawaiiTime;

	@B2BFindBy(xpath = "//li[text()='(GMT-09:00) Alaskan Standard Time']")
	private WebElement btnAlaskanStandardTime;

	@B2BFindBy(xpath = "//li[text()='(GMT-08:00) Pacific Standard Time (US & Canada)']")
	private WebElement btnPacificStandardTime;

	@B2BFindBy(xpath = "//li[text()='(GMT-07:00) Arizona']")
	private WebElement btnArizona;

	@B2BFindBy(xpath = "//input[@value='America/Belize']")
	private WebElement btnCentralAmericaTimeTime;

	@B2BFindBy(xpath = "//li[text()='(GMT-06:00) Saskatchewan']")
	private WebElement btnSaskatchewanTime;

	@B2BFindBy(xpath = "//li[text()='(GMT-05:00) Eastern Time (US & Canada)']")
	private WebElement btnEasternTime;

	@B2BFindBy(xpath = "//h3[text()='Type']")
	private WebElement lblType;

	@B2BFindBy(xpath = "//h3[text()='Player Group']")
	private WebElement lblPlayerGroup;

	@B2BFindBy(xpath = "//h3[text()='Rating Range']")
	private WebElement lblRatingRange;

	@B2BFindBy(xpath = "//h3[text()='Bracket Name']")
	private WebElement lblBracketName;

	@B2BFindBy(xpath = "//h3[text()='Event Type']")
	private WebElement lblEventType;

	@B2BFindBy(xpath = "//h3[text()='Registration Date']")
	private WebElement lblRegistrationDate;

	@B2BFindBy(xpath = "//h3[text()='Competition Date']")
	private WebElement lblCompetitionDate;

	@B2BFindBy(xpath = "//h3[text()='Time Zone']")
	private WebElement lblTimeZone;

	@B2BFindBy(xpath = "//h3[text()='Bracket Price']")
	private WebElement lblBracketPrice;

	@B2BFindBy(xpath = "//h3[text()='Number of Teams']")
	private WebElement lblNumberOfTeams;

	@B2BFindBy(xpath = "//h3[text()='Waitlist']")
	private WebElement lblWaitlist;

	@B2BFindBy(xpath = "//button[text()='Go Back']")
	private WebElement btnGoBack;

	@B2BFindBy(xpath = "//h2[text()='Bracket #1']/parent::div/parent::div/parent::div")
	private WebElement drpBracket1;

	@B2BFindBy(xpath = "//button[contains(text(),'Next Step')]")
	private WebElement btnNext;

	@B2BFindBy(xpath = "//h3[text()='Type']/parent::div/div/div/div/div//following-sibling::input")
	private WebElement txtBoxType;

	@B2BFindBy(xpath = "//h3[text()='Player Group']/parent::div/div/div/div/div//following-sibling::input")
	private WebElement txtBoxPlayerGroup;

	@B2BFindBy(xpath = "//button[contains(text(),'Exit')]")
	private WebElement btnExit;

	@B2BFindBy(xpath = "//h2[text()='Bracket #2']//ancestor::div[@id='panel1a-header']/following-sibling::div//h3[text()='Type']/parent::div/div/div/div/div")
	private WebElement drpType;

	@B2BFindBy(xpath = "//h2[text()='Bracket #2']//ancestor::div[@id='panel1a-header']/following-sibling::div//h3[text()='Player Group']/parent::div/div/div/div/div")
	private WebElement drpPlayerGroup;

	@B2BFindBy(xpath = "//li[text()='Doubles']")
	private WebElement btnTypeDoubles;

	@B2BFindBy(xpath = "//li[text()='Singles']")
	private WebElement btnTypeSingles;

	@B2BFindBy(xpath = "//h3[text()='Type']/parent::div/div/div/following-sibling::div/div/div")
	private List<WebElement> lstType;

	@B2BFindBy(xpath = "//h3[text()='Player Group']/parent::div/div/div/following-sibling::div/div/div")
	private List<WebElement> lstPlayGroup;

	@B2BFindBy(xpath = "//li[text()='Open']")
	private WebElement btnPlayGroupOpen;

	@B2BFindBy(xpath = "//li[text()='Mixed']")
	private WebElement btnPlayGroupMixed;

	@B2BFindBy(xpath = "//h2[text()='Bracket #2']//ancestor::div[@id='panel1a-header']/following-sibling::div//h3[text()='Age Range']/parent::div/div/div/div/div/h5[text()='Minimum']/parent::div/following-sibling::div/div/div/input")
	private WebElement txtAgeRangeMinimum;

	@B2BFindBy(xpath = "//h2[text()='Bracket #2']//ancestor::div[@id='panel1a-header']/following-sibling::div//h3[text()='Age Range']/parent::div/div/div/div/div/h5[text()='Maximum']/parent::div/following-sibling::div/div/div/input")
	private WebElement txtAgeRangeMaximum;

	@B2BFindBy(xpath = "//h2[text()='Bracket #2']//ancestor::div[@id='panel1a-header']/following-sibling::div//h3[text()='Rating Range']/parent::div/div/div/div/div/h5[text()='Minimum']/parent::div/following-sibling::div/div/div/input")
	private WebElement txtRatingRangeMinimum;

	@B2BFindBy(xpath = "//h2[text()='Bracket #2']//ancestor::div[@id='panel1a-header']/following-sibling::div//h3[text()='Rating Range']/parent::div/div/div/div/div/h5[text()='Maximum']/parent::div/following-sibling::div/div/div/input")
	private WebElement txtRatingRangeMaximum;

	@B2BFindBy(xpath = "//h2[text()='Bracket #2']//ancestor::div[@id='panel1a-header']/following-sibling::div//button[text()='Auto Generate']/parent::div")
	private WebElement btnAutoGenerate;

	@B2BFindBy(xpath = "//button[text()='Auto Generate' and @disabled]")
	private WebElement btnAutoGenerateDisabled;

	@B2BFindBy(xpath = "//h2[text()='Bracket #2']//ancestor::div[@id='panel1a-header']/following-sibling::div//h3[text()='Event Type']/parent::div/div/div/div/input")
	private WebElement drpEventType;

	@B2BFindBy(xpath = "//li[text()='Round Robin']")
	private WebElement btnRoundRobin;

	@B2BFindBy(xpath = "//input[@value='ROUND_ROBIN']")
	private WebElement txtRoundRobin;

	@B2BFindBy(xpath = "//li[text()='Waterfall']")
	private WebElement btnWaterfall;

	@B2BFindBy(xpath = "//h2[text()='Bracket #2']//ancestor::div[@id='panel1a-header']/following-sibling::div//h3[text()='Registration Date']/parent::div/div/div/div/div/h5[text()='Start Date & Time']/parent::div/following-sibling::div/div/div")
	private WebElement btnRegistrationStartDate;

	@B2BFindBy(xpath = "//h2[text()='Bracket #2']//ancestor::div[@id='panel1a-header']/following-sibling::div//h3[text()='Registration Date']/parent::div/div/div/div/div/h5[text()='End Date & Time']/parent::div/following-sibling::div/div/div/input")
	private WebElement btnRegistrationEndDate;

	@B2BFindBy(xpath = "//h2[text()='Bracket #2']//ancestor::div[@id='panel1a-header']/following-sibling::div//h3[text()='Competition Date']/parent::div/div/div/div/div/h5[text()='Start Date & Time']/parent::div/following-sibling::div/div/div")
	private WebElement btnRegistrationCompetitionStartDate;

	@B2BFindBy(xpath = "//h2[text()='Bracket #2']//ancestor::div[@id='panel1a-header']/following-sibling::div//h3[text()='Competition Date']/parent::div/div/div/div/div/h5[text()='End Date & Time']/parent::div/following-sibling::div/div/div")
	private WebElement btnRegistrationCompetitionEndDate;

	@B2BFindBy(xpath = "//button[contains(@class, 'MuiButtonBase-root MuiPickersDay-root MuiPickersDay-dayWithMargin MuiPickersDay-today')]")
	private WebElement btnRegistrationDateToday;

	@B2BFindBy(xpath = "//span[@role='option' and @aria-label='3 hours']")
	private WebElement btnRegistrationDateTodayhours;

	@B2BFindBy(xpath = "//span[@role='option' and @aria-label='20 minutes']")
	private WebElement btnRegistrationDateTodayMinutes;

	@B2BFindBy(xpath = "//button[@aria-label='calendar view is open, switch to year view']")
	private WebElement drpRegistrationEndDate;

	@B2BFindBy(xpath = "//h2[text()='Bracket #2']//ancestor::div[@id='panel1a-header']/following-sibling::div//h3[contains(text(),'Number of Courts')]//following-sibling::div//input")
	private WebElement txtNumberOfCourts;

	@B2BFindBy(xpath = "//p[text()='Registration start date is required.']")
	private WebElement msgRegStartDateRequired;

	@B2BFindBy(xpath = "//p[text()='Registration end date is required.']")
	private WebElement msgRegEndDateRequired;

	@B2BFindBy(xpath = "//p[text()='Registration end date must be after registration start date.']")
	private WebElement msgRegEndDateofPrevStartDate;

	@B2BFindBy(xpath = "//p[text()='Competition end date should be higher than competition start date.']")
	private WebElement msgCompEndDateofPrevStartDate;

	@B2BFindBy(xpath = "//p[text()='Competition start date is required.']")
	private WebElement msgCompStartDateRequired;

	@B2BFindBy(xpath = "//p[text()='Competition start date is required.']")
	private WebElement msgCompEndDateRequired;

	@B2BFindBy(xpath = "//p[text()='Competition start date should be higher than Registration end date.']")
	private WebElement msgCompStartDateHighRegEndDate;

	@B2BFindBy(xpath = "//p[contains(text(),'Number of court should be between 1 & 8.')]")
	private WebElement lblNumberOfCourtsValidation;

	@B2BFindBy(xpath = "//h4[text()='Time Zone']/following-sibling::p[text()='(GMT-07:00) Arizona']")
	private WebElement txtTimeZoneInEventDetails;

	@B2BFindBy(xpath = "//h2[text()='Bracket #2']//ancestor::div[@id='panel1a-header']/following-sibling::div//h3[text()='Registration Date']/following-sibling::div//h5[text()='Start Date & Time']/parent::div/following-sibling::div//input")
	private WebElement txtRegistrationStartDate;

	@B2BFindBy(xpath = "//h2[text()='Bracket #2']//ancestor::div[@id='panel1a-header']/following-sibling::div//h3[text()='Registration Date']/following-sibling::div//h5[text()='End Date & Time']/parent::div/following-sibling::div//input")
	private WebElement txtRegistrationEndDate;

	@B2BFindBy(xpath = "//h2[text()='Bracket #2']//ancestor::div[@id='panel1a-header']/following-sibling::div//h3[text()='Competition Date']/following-sibling::div//h5[text()='Start Date & Time']/parent::div/following-sibling::div//input")
	private WebElement txtCompetitionStartDate;

	@B2BFindBy(xpath = "//h2[text()='Bracket #2']//ancestor::div[@id='panel1a-header']/following-sibling::div//h3[text()='Competition Date']/following-sibling::div//h5[text()='End Date & Time']/parent::div/following-sibling::div//input")
	private WebElement txtCompetitionEndDate;

	@B2BFindBy(xpath = "//button[text()='2024']")
	private WebElement btnRegistrationEndDateNextYear;

	@B2BFindBy(xpath = "//button[text()='2025']")
	private WebElement btnRegistrationCompetitionStartDateNextYear;

	@B2BFindBy(xpath = "//button[text()='2026']")
	private WebElement btnRegistrationCompetitionEndDateNextYear;

	@B2BFindBy(xpath = "//button[text()='9']")
	private WebElement btnRegistrationEndDateNextYearSelectDate;

	@B2BFindBy(xpath = "//button[text()='18']")
	private WebElement btnRegistrationCompetitionStartDateNextYearSelectDate;

	@B2BFindBy(xpath = "//span[text()='9']")
	private WebElement btnRegistrationEndDateNextYearSelectDateTime;

	@B2BFindBy(xpath = "//span[text()='55']")
	private WebElement btnRegistrationEndDateNextYearSelectDateTimeMinutes;
	
	@B2BFindBy(xpath = "//button[text()='OK']")
	private WebElement btnOk;
	
	@B2BFindBy(xpath = "//h2[text()='Bracket #2']//ancestor::div[@id='panel1a-header']/following-sibling::div//h3[text()='Time Zone']/parent::div/div/div/div")
	private WebElement drpTimeZone;

	@B2BFindBy(xpath = "//div[contains(text(),'(GMT-07:00) Arizona')]")
	private WebElement txtArizonaTimeZone;
	
	@B2BFindBy(xpath = "//li[contains(@class,'MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-xo32vf')]")
	private List<WebElement> lstTimeZone;

	@B2BFindBy(xpath = "//li[contains(text(),'(GMT-06:00) Central America')]")
	private WebElement btnCentalAmericaTimeZone;

	@B2BFindBy(xpath = "//h2[text()='Bracket #2']//ancestor::div[@id='panel1a-header']/following-sibling::div//h3[text()='Bracket Price']/parent::div/div/div/div/div/h5[text()='Club Member Price']/parent::div/following-sibling::div/div/div/div/following-sibling::input")
	private WebElement txtBracketPriceClubMemberPrice;

	@B2BFindBy(xpath = "//h2[text()='Bracket #2']//ancestor::div[@id='panel1a-header']/following-sibling::div//h3[text()='Bracket Price']/parent::div/div/div/div/div/h5[text()='Club nonmember Price']/parent::div/following-sibling::div/div/div/div/following-sibling::input")
	private WebElement txtBracketPriceNonClubMemberPrice;

	@B2BFindBy(xpath = "//h2[text()='Bracket #2']//ancestor::div[@id='panel1a-header']/following-sibling::div//h3[text()='Number of Teams']/parent::div/div/div/div/div/div/input")
	private WebElement txtNumberOfTerms;

	@B2BFindBy(xpath = "//h2[text()='Bracket #2']//ancestor::div[@id='panel1a-header']/following-sibling::div//h3[text()='Waitlist']/parent::div/div/div/div/div/div/input")
	private WebElement txtWaitlist;

	@B2BFindBy(xpath = "//button[text()='Delete Bracket']")
	private WebElement btnDelteBracket;
	
	@B2BFindBy(xpath = "//h2[text()='Bracket #2']")
	private WebElement lblBracket2;

	public AddAnotherBracketPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public boolean isAddBracketPageContainsDisplayed() {
		log.info("Starting of isAddBracketPageContainsDisplayed method");

		boolean isAddBracketPageContainsDisplayed = false;

		if (btnNext.isDisplayed() && btnDelteBracket.isDisplayed() && btnExit.isDisplayed() && btnGoBack.isDisplayed()
				&& lblAddBrackets.isDisplayed()) {

			isAddBracketPageContainsDisplayed = true;
		}

		log.info("Ending of isAddBracketPageContainsDisplayed method");

		return isAddBracketPageContainsDisplayed;
	}

	
	public boolean isAddNewBracketPageContainsDisplayed() {
		log.info("Starting of isAddNewBracketPageContainsDisplayed method");

		boolean isAddNewBracketPageContainsDisplayed = false;

		// System.out.println(btnNext.isDisplayed());
		// System.out.println(btnDeleteBracket.isDisplayed());
		// System.out.println(btnExit.isDisplayed());
		// System.out.println(btnGoBack.isDisplayed());

		if (lblBracket2.isDisplayed() && lblAddBrackets.isDisplayed()) {

			isAddNewBracketPageContainsDisplayed = true;
		}

		log.info("Ending of isAddNewBracketPageContainsDisplayed method");

		return isAddNewBracketPageContainsDisplayed;
	}

	public boolean isBracketListDisplayed() {
		log.info("Starting of isBracketListDisplayed method");
		hardWait(2);
		boolean isBracketListDisplayed = false;
		hardWait(2);
		this.waitForElementToBeVisible(btnTypeDoubles);
		this.waitForElementToBeVisible(btnTypeSingles);
		if (btnTypeDoubles.isDisplayed() && btnTypeSingles.isDisplayed()) {

			isBracketListDisplayed = true;
		}

		log.info("Ending of isPlayerGroupListDisplayed method");

		return isBracketListDisplayed;
	}

	public void clickOnSinglesBracketTypeButton() {
		log.info("Starting of clickOnSinglesBracketTypeButton method");

		elementClick(btnTypeSingles);

		log.info("Ending of clickOnSinglesBracketTypeButton method");
	}

	public void clickOnDoublesBracketTypeButton() {
		log.info("Starting of clickOnDoublesBracketTypeButton method");
		try {
			btnTypeDoubles.click();
		} catch (Exception e) {
			elementClick(btnTypeDoubles);
		}
		log.info("Ending of clickOnDoublesBracketTypeButton method");
	}

	public boolean isSelectedBracketTypeDisplayed() {
		log.info("Starting of isSelectedBracketTypeDisplayed method");
		hardWait(2);
		boolean BracketType = false;
		try {
			if (txtBoxType.getAttribute("value").equals("DOUBLES")) {
				System.out.println(txtBoxType.getAttribute("value").equals("DOUBLES"));
				BracketType = true;
			} else if (txtBoxType.getAttribute("value").equals("SINGLES")) {
				System.out.println(txtBoxType.getAttribute("value").equals("SINGLES"));
				BracketType = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("Ending of isSelectedBracketTypeDisplayed method");

		return BracketType;
	}

	public boolean isPlayerGroupListDisplayed() {
		log.info("Starting of isPlayerGroupListDisplayed method");
		hardWait(2);
		boolean isPlayerGroupListDisplayed = false;

		if (btnPlayGroupMixed.isDisplayed() && btnPlayGroupOpen.isDisplayed() && btnPlayGroupMen.isDisplayed()
				&& btnPlayGroupWomen.isDisplayed()) {

			isPlayerGroupListDisplayed = true;
		}

		log.info("Ending of isPlayerGroupListDisplayed method");

		return isPlayerGroupListDisplayed;
	}

	public void clickOnMixedMatchGroupButton() {
		log.info("Starting of clickOnMixedMatchGroupButton method");

		elementClick(btnPlayGroupMixed);

		log.info("Ending of clickOnMixedMatchGroupButton method");
	}

	public void clickOnOpenMatchButton() {
		log.info("Starting of clickOnOpenMatchButton method");

		elementClick(btnPlayGroupOpen);

		log.info("Ending of clickOnOpenMatchButton method");
	}

	public boolean isSelectedPlayerGroupTypeDisplayed() {
		log.info("Starting of isSelectedPlayerGroupTypeDisplayed method");
		hardWait(2);
		boolean PlayerGroupType = false;
		try {
			if (txtBoxPlayerGroup.getAttribute("value").equals("MIXED")) {
				System.out.println(txtBoxPlayerGroup.getAttribute("value").equals("MIXED"));
				PlayerGroupType = true;
			} else if (txtBoxPlayerGroup.getAttribute("value").equals("OPEN")) {
				System.out.println(txtBoxPlayerGroup.getAttribute("value").equals("OPEN"));
				PlayerGroupType = true;
			} else if (txtBoxPlayerGroup.getAttribute("value").equals("MEN")) {
				System.out.println(txtBoxPlayerGroup.getAttribute("value").equals("MEN"));
				PlayerGroupType = true;
			} else {
				PlayerGroupType = txtBoxPlayerGroup.getAttribute("value").equals("WOMEN");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("Ending of isSelectedPlayerGroupTypeDisplayed method");

		return PlayerGroupType;
	}

	public boolean isDeleteBracketDisplayed() {

		log.info("Starting of isDeleteBracketDisplayed method");

		boolean isDeleteBracketDisplayed = false;
		try {
			if (btnDelteBracket.isDisplayed()) {
				isDeleteBracketDisplayed = true;
			}
		} catch (Exception e) {
			isDeleteBracketDisplayed = false;
		}
		log.info("Ending of isDeleteBracketDisplayed method");

		return isDeleteBracketDisplayed;
	}

	public boolean isEnteredMinimumAgeDisplayed(String minage) {
		log.info("Starting of isEnteredMinimumAgeDisplayed method");

		boolean isEnteredMinimumAgeDisplayed = false;
		try {
			if (txtAgeRangeMinimum.getAttribute("value").equals(minage)) {
				System.out.println(txtAgeRangeMinimum.getAttribute("value").equals(minage));
				isEnteredMinimumAgeDisplayed = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("Ending of isEnteredMinimumAgeDisplayed method");

		return isEnteredMinimumAgeDisplayed;
	}

	public boolean isEnteredMaximumAgeDisplayed(String maxage) {
		log.info("Starting of isEnteredMaximumAgeDisplayed method");

		boolean MaximumAge = false;
		try {
			if (txtAgeRangeMaximum.getAttribute("value").equals(maxage)) {
				System.out.println(txtAgeRangeMaximum.getAttribute("value").equals(maxage));
				MaximumAge = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("Ending of isEnteredMaximumAgeDisplayed method");

		return MaximumAge;
	}
	
	public boolean isEnteredMinimumRatingRangeDisplayed(String minrating) {
		log.info("Starting of isEnteredMinimumRatingRangeDisplayed method");

		boolean MinimumRatingRange = false;
		try {
			if (txtRatingRangeMinimum.getAttribute("value").equals(minrating)) {
				System.out.println(txtRatingRangeMinimum.getAttribute("value").equals(minrating));
				MinimumRatingRange = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("Ending of isEnteredMinimumRatingRangeDisplayed method");

		return MinimumRatingRange;
	}

	public boolean isEnteredMaximumRatingRangeDisplayed(String maxrating) {
		log.info("Starting of isEnteredMaximumRatingRangeDisplayed method");

		boolean MaximumRatingRange = false;
		try {
			if (txtRatingRangeMaximum.getAttribute("value").equals(maxrating)) {
				System.out.println(txtRatingRangeMaximum.getAttribute("value").equals(maxrating));
				MaximumRatingRange = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("Ending of isEnteredMaximumRatingRangeDisplayed method");

		return MaximumRatingRange;
	}

	public boolean isEventTypeListDisplayed() {
		log.info("Starting of isEventTypeListDisplayed method");
        hardWait(2);
		boolean isEventTypeListDisplayed = false;

		if (btnRoundRobin.isDisplayed() && btnWaterfall.isDisplayed()) {

			isEventTypeListDisplayed = true;
		}

		log.info("Ending of isEventTypeListDisplayed method");

		return isEventTypeListDisplayed;
	}

	public void clickOnRoundRobinEventTypeButton() {
		log.info("Starting of clickOnRoundRobinEventTypeButton method");

		elementClick(btnRoundRobin);

		log.info("Ending of clickOnRoundRobinEventTypeButton method");
	}

	public boolean isSelectedEventTypeDisplayed() {
		log.info("Starting of isSelectedEventTypeDisplayed method");

		boolean EventType = false;
		try {
			if (drpEventType.getAttribute("value").equals("ROUND_ROBIN")) {
				System.out.println(txtRoundRobin.getAttribute("value").equals("ROUND_ROBIN"));
				EventType = true;
			} else {
				EventType = drpEventType.getAttribute("value").equals("COMPASS");
				System.out.println(txtRoundRobin.getAttribute("value").equals("COMPASS"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("Ending of isSelectedEventTypeDisplayed method");

		return EventType;
	}

	public boolean isTimeZoneListDisplayed() {
		log.info("Starting of isTimeZoneListDisplayed method");

		boolean isTimeZoneListDisplayed = false;

		if (btnCoordinatedUniversalTime.isDisplayed() && btnHawaiiTime.isDisplayed()
				&& btnAlaskanStandardTime.isDisplayed() && btnPacificStandardTime.isDisplayed()
				&& btnArizona.isDisplayed() && btnCentralAmericaTimeTime.isDisplayed()
				&& btnCentalAmericaTimeZone.isDisplayed() && btnSaskatchewanTime.isDisplayed()
				&& btnEasternTime.isDisplayed()) {

			isTimeZoneListDisplayed = true;
		}

		log.info("Ending of isEventTypeListDisplayed method");

		return isTimeZoneListDisplayed;
	}

	public void clickOnCentalAmericanTimeZoneButton() {
		log.info("Starting of clickOnCentalAmericanTimeZoneButton method");

		elementClick(btnCentalAmericaTimeZone);

		log.info("Ending of clickOnCentalAmericanTimeZoneButton method");
	}

	public boolean isSelectedTimeZoneDisplayed() {
		log.info("Starting of isSelectedTimeZoneDisplayed method");

		boolean TimeZone = false;
		try {
			if (btnCentralAmericaTimeTime.getAttribute("value").equals("America/Belize")) {
				System.out.println(btnCentralAmericaTimeTime.getAttribute("value").equals("America/Belize"));
				TimeZone = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("Ending of isSelectedTimeZoneDisplayed method");

		return TimeZone;
	}

	public boolean isEnteredClubMemberPriceDisplayed() {
		log.info("Starting of isEnteredClubMemberPriceDisplayed method");

		boolean BracketClubMemberPrice = false;
		try {
			if (txtBracketPriceClubMemberPrice.getAttribute("value").equals("0")) {
				System.out.println(txtBracketPriceClubMemberPrice.getAttribute("value").equals("0"));
				BracketClubMemberPrice = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("Ending of isEnteredClubMemberPriceDisplayed method");

		return BracketClubMemberPrice;
	}

	public boolean isEnteredClubNonMemberPriceDisplayed() {
		log.info("Starting of isEnteredClubNonMemberPriceDisplayed method");

		boolean BracketClubNonMemberPrice = false;
		try {
			if (txtBracketPriceNonClubMemberPrice.getAttribute("value").equals("0")) {
				System.out.println(txtBracketPriceNonClubMemberPrice.getAttribute("value").equals("0"));
				BracketClubNonMemberPrice = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("Ending of isEnteredClubNonMemberPriceDisplayed method");

		return BracketClubNonMemberPrice;
	}

	public boolean isNumberOfTeamsCountDisplayed() {
		log.info("Starting of isNumberOfTeamsCountDisplayed method");

		boolean NumberOfTeamsCount = false;
		try {
			if (txtNumberOfTerms.getAttribute("value").equals("5")) {
				System.out.println(txtNumberOfTerms.getAttribute("value").equals("5"));
				NumberOfTeamsCount = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("Ending of isNumberOfTeamsCountDisplayed method");

		return NumberOfTeamsCount;
	}

	public boolean isWaitListCountDisplayed() {
		log.info("Starting of isWaitListCountDisplayed method");

		boolean WaitListCount = false;
		try {
			if (txtWaitlist.getAttribute("value").equals("3")) {
				System.out.println(txtWaitlist.getAttribute("value").equals("3"));
				WaitListCount = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("Ending of isWaitListCountDisplayed method");

		return WaitListCount;
	}

	public boolean isAutoGenerateButtonEnabled() {
		log.info("Starting of isAutoGenerateButtonEnabled method");
		hardWait(2);
		this.waitForElementToBeVisible(btnAutoGenerate);
		log.info("Ending of isAutoGenerateButtonEnabled method");

		return btnAutoGenerate.isEnabled();
	}

	public void clickonBracket1Button() {
		log.info("Starting of clickonBracket1Button method");

		clickOnElementUsingActionClass(drpBracket1);

		log.info("Ending of clickonBracket1Button method");
	}

	public void scrollUp() {
		log.info("Starting of scrollUp method");
		hardWait(2);
		 this.scrollDown(-1300);
		 hardWait(2);
		log.info("Ending of scrollUp method");
	}

	
	public void scrollDown() {
		log.info("Starting of scrollDown method");
		hardWait(2);
		 this.scrollDown(700);

		log.info("Ending of scrollDown method");
	}
	
	public void clickonTypeDropdown() {
		log.info("Starting of clickonTypeDropdown method");
	
		 this.scrollUp();
		 this.waitForElementToBeVisible(drpType);
			try {
				drpType.click();
		} catch (Exception e) {
			
			clickOnWebElement(drpType);
		}
		hardWait(2);
		
		log.info("Ending of clickonTypeDropdown�method");
}

	public void clickonPlayGroupDropdown() {
		log.info("Starting of clickonPlayGroupDropdown method");

		try {
			this.waitForElementToBeVisible(drpPlayerGroup);
			drpPlayerGroup.click();
		} catch (Exception e) {
			clickOnElementUsingActionClass(drpPlayerGroup);
		}

		log.info("Ending of clickonPlayGroupDropdown method");
	}

	public void setAgeRangeMinimum(String ageRangeMinimum) {
		log.info("Starting of setAgeRangeMinimum method");

		this.txtAgeRangeMinimum.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		try {
			clickOnElementUsingActionClass(txtAgeRangeMinimum);
		} catch (Exception e) {
			elementClick(txtAgeRangeMinimum);
		}

		txtAgeRangeMinimum.sendKeys(ageRangeMinimum);

		log.info("Ending of setAgeRangeMinimum method");

	}

	public void setAgeRangeMaximum(String ageRangeMaximum) {
		log.info("Starting of setAgeRangeMaximum method");

		this.txtAgeRangeMaximum.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		try {
			clickOnElementUsingActionClass(txtAgeRangeMaximum);
		} catch (Exception e) {
			elementClick(txtAgeRangeMaximum);
		}

		txtAgeRangeMaximum.sendKeys(ageRangeMaximum);

		log.info("Ending of setAgeRangeMaximum method");

	}

	public void setRatingRangeMinimum(String ageRatingRangeMinimum) {
		log.info("Starting of setRangeRangeMinimum method");

		this.txtRatingRangeMinimum.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);

		try {
			clickOnElementUsingActionClass(txtRatingRangeMinimum);
		} catch (Exception e) {
			elementClick(txtRatingRangeMinimum);
		}

		txtRatingRangeMinimum.sendKeys(ageRatingRangeMinimum);

		log.info("Ending of setRangeRangeMinimum method");

	}

	public void setRatingRangeMaximum(String ageRatingRangeMaximum) {
		log.info("Starting of setRangeRangeMaximum method");

		this.txtRatingRangeMaximum.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);

		try {
			clickOnElementUsingActionClass(txtRatingRangeMaximum);
		} catch (Exception e) {
			elementClick(txtRatingRangeMaximum);
		}

		txtRatingRangeMaximum.sendKeys(ageRatingRangeMaximum);

		log.info("Ending of setRangeRangeMaximum method");

	}

	public void clickOnAutoGenerate() {
		log.info("Starting of clickOnAutoGenerate method");
		hardWait(2);
		btnAutoGenerate.click();

		log.info("Ending of clickOnAutoGenerate method");
	}

	public void clickOnEventTypeDropdown() {
		log.info("Starting of clickOnEventTypeDropdown method");

		clickOnElementUsingActionClass(drpEventType);

		log.info("Ending of clickOnEventTypeDropdown method");
	}

	public void clickOnOkButton() {
		log.info("Starting of clickOnOkButton method");
		try {
			btnOk.click();
		} catch (Exception e) {
			elementClick(btnOk);
		}
		log.info("Ending of clickOnOkButton�method");
	}

	public void clickOnEventTypeWaterfallDropdown() {
		log.info("Starting of clickOnEventTypeWaterfallDropdown method");

		clickOnElementUsingActionClass(drpEventType);

		elementClick(btnWaterfall);

		log.info("Ending of clickOnEventTypeWaterfallDropdown method");
	}

	public void setNumberOfCourt(String numberOfCourts) {
		log.info("Starting of setNumberOfCourt method");

		txtNumberOfCourts.click();

		this.txtNumberOfCourts.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);

		txtNumberOfCourts.sendKeys(numberOfCourts);

		log.info("Ending of setNumberOfCourt method");

	}

	public void clickOnRegistrationStartDate() {
		log.info("Starting of clickOnRegistrationStartDate method");

		hardWait(2);
		try {

			clickOnElementUsingActionClass(btnRegistrationStartDate);
		} catch (Exception e) {

			btnRegistrationStartDate.click();
		}
		elementClick(btnRegistrationCompetitionStartDateNextYearSelectDate);

		clickOnElementUsingActionClass(btnRegistrationEndDateNextYearSelectDateTime);

		clickOnElementUsingActionClass(btnRegistrationEndDateNextYearSelectDateTimeMinutes);
		 
		log.info("Ending of clickOnRegistrationStartDate method");
	}

	public void clickOnRegistrationEndDate() {
		log.info("Starting of clickOnRegistrationEndDate method");

		hardWait(2);
		try {
			clickOnElementUsingActionClass(btnRegistrationEndDate);
			hardWait(2);
			
		} catch (Exception e) {
			btnRegistrationEndDate.click();			
			// .click();
			e.printStackTrace();
		}

		hardWait(2);
		clickOnElementUsingActionClass(drpRegistrationEndDate);

		clickOnElementUsingActionClass(btnRegistrationEndDateNextYear);

		elementClick(btnRegistrationCompetitionStartDateNextYearSelectDate);

		clickOnElementUsingActionClass(btnRegistrationEndDateNextYearSelectDateTime);

		clickOnElementUsingActionClass(btnRegistrationEndDateNextYearSelectDateTimeMinutes);
		
		log.info("Ending of clickOnRegistrationEndDate method");
	}

	public void clickOnCompetitionStartDate() {
		log.info("Starting of clickOnCompetitionStartDate method");
		hardWait(2);
		try {
			clickOnElementUsingActionClass(btnRegistrationCompetitionStartDate);
			hardWait(2);
			//btnRegistrationCompetitionStartDate.click();
		} catch (Exception e) {
			e.printStackTrace();

		}
		hardWait(2);
		clickOnElementUsingActionClass(drpRegistrationEndDate);

		hardWait(2);

		elementClick(btnRegistrationCompetitionStartDateNextYear);

		elementClick(btnRegistrationCompetitionStartDateNextYearSelectDate);

		clickOnElementUsingActionClass(btnRegistrationEndDateNextYearSelectDateTime);

		clickOnElementUsingActionClass(btnRegistrationEndDateNextYearSelectDateTimeMinutes);
		 
		log.info("Ending of clickOnCompetitionStartDate method");
	}

	public void clickOnCompetitionEndDate() {
		log.info("Starting of clickOnCompetitionEndDate method");
		hardWait(2);
		try {

			clickOnElementUsingActionClass(btnRegistrationCompetitionEndDate);
			hardWait(2);
			//btnRegistrationCompetitionEndDate.click();
		} catch (Exception e) {
			e.printStackTrace();

		}
		hardWait(2);
		clickOnElementUsingActionClass(drpRegistrationEndDate);

		hardWait(2);

		elementClick(btnRegistrationCompetitionEndDateNextYear);

		clickOnElementUsingActionClass(btnRegistrationCompetitionStartDateNextYearSelectDate);

		clickOnElementUsingActionClass(btnRegistrationEndDateNextYearSelectDateTime);

		clickOnElementUsingActionClass(btnRegistrationEndDateNextYearSelectDateTimeMinutes);

		log.info("Ending of clickOnCompetitionEndDate method");
	}

	public void clickOnTimeZoneDropdown() {
		log.info("Starting of clickOnTimeZoneDropdown method");
		hardWait(2);
		try {
		clickOnElementUsingActionClass(drpTimeZone);
		}catch(Exception e) {
		drpTimeZone.click();
		}
		elementClick(btnArizona);

		log.info("Ending of clickOnTimeZoneDropdown method");

	}

	public void setBracketPriceClubMemberPrice(String clubMemberPrice) {
		log.info("Starting of setBracketPriceClubMemberPrice method");

		txtBracketPriceClubMemberPrice.click();

		txtBracketPriceClubMemberPrice.sendKeys(clubMemberPrice);

		log.info("Ending of setBracketPriceClubMemberPrice�method");

	}

	public void setBracketPriceNonClubMemberPrice(String nonclubMemberPrice) {
		log.info("Starting of setBracketPriceNonClubMemberPrice method");

		txtBracketPriceNonClubMemberPrice.click();

		txtBracketPriceNonClubMemberPrice.sendKeys(nonclubMemberPrice);

		log.info("Ending of setBracketPriceNonClubMemberPrice method");

	}

	public void setNumberOfTerms(String numberOfTerms) {
		log.info("Starting of setNumberOfTerms method");

		txtNumberOfTerms.click();

		this.txtNumberOfTerms.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);

		txtNumberOfTerms.sendKeys(numberOfTerms);

		log.info("Ending of setNumberOfTerms method");

	}

	public void setWaitlist(String waitlist) {
		log.info("Starting of setWaitlist method");

		txtWaitlist.click();

		this.txtWaitlist.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);

		txtWaitlist.sendKeys(waitlist);

		log.info("Ending of setWaitlist method");

	}

	public boolean isAutoGenerateButtonDisabled() {
		log.info("Starting of isAutoGenerateButtonDisabled method");
		hardWait(2);
		log.info("Ending of isAutoGenerateButtonDisabled method");

		return btnAutoGenerateDisabled.isDisplayed();
	}

	public boolean isNumberOfCourtsValidationDisplayed() {
		log.info("Starting of isNumberOfCourtsValidationDisplayed method");
		log.info("Ending of isNumberOfCourtsValidationDisplayed method");

		return lblNumberOfCourtsValidation.isDisplayed();
	}

	public boolean isNumberOfCourtsWaterFallValidationDisplayed() {
		log.info("Starting of isNumberOfCourtsValidationDisplayed method");
		log.info("Ending of isNumberOfCourtsValidationDisplayed method");

		return txtNumberOfTerms.isDisplayed();
	}

	public void setRegistrationStartDate() {
		log.info("Starting of setRegistrationStartDate method");
		scrollDown(200);
		clickOnWebElement(txtRegistrationStartDate);

		LocalDateTime dateTime = LocalDateTime.now();
		int date = dateTime.getDayOfYear();
		dateTime.plusDays(1);
		int minutes = dateTime.getMinute();

		SimpleDateFormat simpleformat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss Z");
		simpleformat = new SimpleDateFormat("h");
		String strHour = simpleformat.format(new Date());
		System.out.println("Hour in h format = " + strHour);

		driver.findElement(By.xpath("//button[text()='" + date + "']")).click();

		driver.findElement(By.xpath("//span[text()='" + strHour + "']")).click();

		driver.findElement(By.xpath("//span[text()='" + minutes + "']")).click();

		driver.findElement(By.xpath("//span[text()='AM']")).click();

		/*
		 * this.txtRegistrationStartDate.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
		 * 
		 * txtRegistrationStartDate.sendKeys(registrationStartDate);
		 */

		log.info("Ending of setRegistrationStartDate method");

	}

	public boolean isRegestrationInvalidMsgDisplayed() {
		log.info("Starting of isRegestrationInvalidMsgDisplayed method");

		boolean isRegestrationInvalidMsgDisplayed = false;

		if (msgRegStartDateRequired.isDisplayed() && msgRegEndDateRequired.isDisplayed()) {

			isRegestrationInvalidMsgDisplayed = true;
		}

		log.info("Ending of isRegestrationInvalidMsgDisplayed method");

		return isRegestrationInvalidMsgDisplayed;
	}

	public boolean isRegestrationEndDatewithPreviousDateOfStartDateMsgDisplayed() {
		log.info("Starting of isRegestrationEndDatewithPreviousDateOfStartDateMsgDisplayed method");

		log.info("Ending of isRegestrationInvalidMsgDisplayed method");

		return msgRegEndDateofPrevStartDate.isDisplayed();
	}

	public boolean isCompetitionInvalidMsgDisplayed() {
		log.info("Starting of isCompetitionInvalidMsgDisplayed method");

		boolean isCompetitionInvalidMsgDisplayed = false;

		if (msgCompStartDateRequired.isDisplayed() && msgCompEndDateRequired.isDisplayed()) {

			isCompetitionInvalidMsgDisplayed = true;
		}

		log.info("Ending of isRegestrationInvalidMsgDisplayed method");

		return isCompetitionInvalidMsgDisplayed;
	}

	public boolean isCompetitionEndDatewithPreviousDateOfStartDateMsgDisplayed() {
		log.info("Starting of isCompetitionEndDatewithPreviousDateOfStartDateMsgDisplayed method");

		log.info("Ending of isCompetitionEndDatewithPreviousDateOfStartDateMsgDisplayed method");

		return msgCompEndDateofPrevStartDate.isDisplayed();
	}

	public boolean isComStartDateHighRegEndDateDisplayed() {
		log.info("Starting of isComStartDateHighRegEndDateDisplayed method");

		log.info("Ending of isComStartDateHighRegEndDateDisplayed method");

		return msgCompStartDateHighRegEndDate.isDisplayed();
	}

	public boolean isNumberOfTeamsDisplayed() {
		log.info("Starting of isNumberOfTeamsDisplayed method");

		log.info("Ending of isNumberOfTeamsDisplayed method");

		return txtNumberOfTerms.isEnabled();
	}

	public void setRegistrationEndDate(String registrationEndDate) {
		log.info("Starting of setRegistrationEndDate method");

		clickOnWebElement(txtRegistrationEndDate);

		this.txtRegistrationEndDate.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);

		txtRegistrationEndDate.sendKeys(registrationEndDate);

		log.info("Ending of setRegistrationEndDate method");

	}

	public void setCompetitionStartDate(String competitionStartDate) {
		log.info("Starting of setCompetitionStartDate method");

		txtCompetitionStartDate.click();

		this.txtCompetitionStartDate.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);

		txtCompetitionStartDate.sendKeys(competitionStartDate);

		log.info("Ending of setCompetitionStartDate method");

	}

	public void setCompetitionEndDate(String competitionEndDate) {
		log.info("Starting of setCompetitionEndDate method");

		txtCompetitionEndDate.click();

		this.txtCompetitionEndDate.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);

		txtCompetitionEndDate.sendKeys(competitionEndDate);

		log.info("Ending of setCompetitionEndDate method");

	}

	public void clickonGoBackButton() {
		log.info("Starting of clickonGoBackButton method");

		btnGoBack.click();

		log.info("Ending of clickonGoBackButton�method");

	}

	public boolean isBracketTypeLabelDisplayed() {
		log.info("Starting of isBracketTypeLabelDisplayed method");
		log.info("Ending of isBracketTypeLabelDisplayed method");

		return lblType.isDisplayed();
	}

	public boolean isPalyerGroupLabelDisplayed() {
		log.info("Starting of isPalyerGroupLabelDisplayed method");
		log.info("Ending of isPalyerGroupLabelDisplayed method");

		return lblPlayerGroup.isDisplayed();
	}

	public boolean isTimeZoneLabelDisplayed() {
		log.info("Starting of isTimeZoneLabelDisplayed method");
		log.info("Ending of isTimeZoneLabelDisplayed method");

		return lblTimeZone.isDisplayed();
	}
	public boolean isNumberOfTeamsLabelDisplayed() {
		log.info("Starting of isNumberOfTeamsLabelDisplayed method");
		log.info("Ending of isNumberOfTeamsLabelDisplayed method");

		return lblNumberOfTeams.isDisplayed();
	}
	
	public String getTimeZoneInEventDetails() {
		log.info("Starting of getTimeZoneInEventDetails method");
		// System.out.println(getText(txtTimeZoneInEventDetails));
		log.info("Ending of getTimeZoneInEventDetails method");

		return txtTimeZoneInEventDetails.getText();
	}

	public String getTimeZoneText() {
		log.info("Starting of getTimeZoneText method");
		// System.out.println(getText(txtCentalAmericaTimeZone));
		log.info("Ending of getTimeZoneText method");

		return txtArizonaTimeZone.getText();
	}

	
}
