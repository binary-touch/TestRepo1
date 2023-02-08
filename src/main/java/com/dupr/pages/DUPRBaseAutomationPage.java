package com.dupr.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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
	
}
