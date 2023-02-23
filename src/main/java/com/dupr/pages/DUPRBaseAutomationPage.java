package com.dupr.pages;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.b2b.base.B2BBaseAutomationPage;
import com.b2b.support.B2BPageFactory;

public class DUPRBaseAutomationPage extends B2BBaseAutomationPage {
	private static final Logger log = LogManager.getLogger(DUPRBaseAutomationPage.class);

	public static String TEST_FILE_PATH = null;

	public DUPRBaseAutomationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log.info("Starting of DUPRBaseAutomationPage");
		if (TEST_FILE_PATH == null) {
			TEST_FILE_PATH = getTestFilePath();

			log.debug("In Constructor " + TEST_FILE_PATH);
		}
		B2BPageFactory.initElements(driver, this);
		log.info("Ending of DUPRBaseAutomationPage");
	}

	public String randomNumber(int digits) {
		log.info("Starting of randomNumber method");
		log.info("Ending of randomNumber method");

		return String.valueOf(RandomStringUtils.randomNumeric(digits));
	}

	public String randomAlphabet(int noOfAlphabets) {
		log.info("Starting of randomAlphabet method");
		log.info("Ending of randomAlphabet method");

		return String.valueOf(RandomStringUtils.randomAlphabetic(noOfAlphabets));
	}

	public void clickAndDragSliderNode(WebElement webElement) {
		log.info("starting of clickAndDragSliderNode");

		this.implicitWait();
		Actions action = new Actions(driver);
		action.clickAndHold(webElement);
		action.moveByOffset(100, 0).build().perform();

		log.info("Ending of clickAndDragSliderNode");
	}

	public void elementClick(WebElement webElement) {
		log.info("Starting of elementClick method");

		try {
			clickOnWebElement(webElement);
		} catch (Exception e) {
			try {
				clickOnElement(webElement);
			} catch (Exception e2) {
				webElement.click();
			}
		}

		log.info("Ending of elementClick method");
	}

	public void clickOnElementUsingActionClass(WebElement WebElement) {
		log.info("Starting of clickOnElementUsingActionClass method");
		
		Actions action = new Actions(driver);
		action.moveToElement(WebElement).click().build().perform();
		
		log.info("Ending of clickOnElementUsingActionClass method");
	}
	
	public void mouseHoverAndClick(WebElement webElement) {
		log.info("Starting of mouseHoverAndClick method");

		Actions action = new Actions(driver);
		action.moveToElement(webElement).click().build().perform();

		log.info("Ending of mouseHoverAndClick method");
	}
	
	public void clickUsingActionsClass(WebElement webElement) {
		log.info("Starting of clickUsingActionsClass method");

		try {
			clickOnElementUsingActionClass(webElement);
		} catch (Exception e) {
			webElement.click();
		}

		log.info("Ending of clickUsingActionsClass method");
	}
	
	public int getCurrentDate() {
		log.info("Starting of getCurrentDate method");

		LocalDateTime dateTime = LocalDateTime.now();
		int date = dateTime.getDayOfMonth();

		System.out.println("Date Value = " + date);

		log.info("Starting of getCurrentDate method");

		return date;
	}

	public int getFutureDate(int days) {
		log.info("Starting of getFutureDate method");

		LocalDateTime dateTime = LocalDateTime.now();
		LocalDateTime date = dateTime.plusDays(days);
		int dateValue = date.getDayOfMonth();
		System.out.println("Date Value = " + dateValue);

		log.info("Starting of getFutureDate method");

		return dateValue;
	}

	public String getCurrentHour() {
		log.info("Starting of getCurrentHour method");

		SimpleDateFormat simpleformat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a z");

		simpleformat = new SimpleDateFormat("h");
		String strHour = simpleformat.format(new Date());
		System.out.println("Hour in h format = " + strHour);

		log.info("Ending of getCurrentHour method");
		return strHour;
	}

	public String getCurrentMinute() {
		log.info("Starting of getCurrentMinute method");

		SimpleDateFormat simpleformat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a z");

		simpleformat = new SimpleDateFormat("m");
		String strMinutes = simpleformat.format(new Date());
		System.out.println("Minutes format = " + strMinutes);

		log.info("Ending of getCurrentMinute method");
		return strMinutes;
	}

	public String getCurrentMeridiem() {
		log.info("Starting of getCurrentMeridiem method");

		SimpleDateFormat simpleformat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a z");

		simpleformat = new SimpleDateFormat("a");
		String meridiem = simpleformat.format(new Date());
		String meridiemValue = meridiem.toUpperCase();
		System.out.println("Meridiem format = " + meridiemValue);

		log.info("Ending of getCurrentMeridiem method");
		return meridiemValue;
	}

	public String getCurrentZone() {
		log.info("Starting of getCurrentZone method");

		SimpleDateFormat simpleformat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a z");

		simpleformat = new SimpleDateFormat("z");
		String zone = simpleformat.format(new Date());
		System.out.println("Zone format = " + zone);

		log.info("Ending of clickOnRegistrationEndDate method");
		return zone;
	}
	
	public void clickOnCurrentDate(int date) {
		try {
			clickOnElementUsingActionClass(driver.findElement(By.xpath("//button[text()='" + date + "']")));
		} catch (Exception e) {
			driver.findElement(By.xpath("//button[text()='" + date + "']")).click();
		}
	}

	public void clickOnCurrentTime(String strHour) {
		try {
			driver.findElement(By.xpath("//span[text()='" + strHour + "']")).click();
		} catch (Exception e) {
			clickOnElementUsingActionClass(driver.findElement(By.xpath("//span[text()='" + strHour + "']")));
		}
	}
	public void switchToNewTab() {
		log.info("Starting of switchToNewTab method");

		// To Open new window and check Assertions
		ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
		if (tab.size() > 0) {
			driver.switchTo().window(tab.get(1));
		}

		log.info("Ending of switchToNewTab method");
	}

	public void closeTab() {
		log.info("Starting of closeTab method");

		// Recent window will be closed and returns back
		driver.close();
		ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(0));

		log.info("Ending of closeTab method");
	}
	
	public void verticalScroll(WebElement webElement) {
		log.info("Starting of verticalScroll method");

		Actions action = new Actions(driver);
		Actions moveToElement = action.moveToElement(webElement);
		for (int i = 0; i < 5; i++) {

			moveToElement.sendKeys(Keys.DOWN).build().perform();
		}

		log.info("Ending of verticalScroll method");
	}
	
}
