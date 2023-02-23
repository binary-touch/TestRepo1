package com.dupr.pages.events;

import java.time.Duration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class ViewDrawsPage extends DUPRBaseAutomationPage {
	private static final Logger log = LogManager.getLogger(ViewDrawsPage.class);

	@B2BFindBy(xpath = "//button[text()='View Draws']")
	private WebElement btnViewDraws;

	@B2BFindBy(xpath = "//button[text()='Having Trouble?']")
	private WebElement btnHavingTrouble;

	@B2BFindBy(xpath = "//h4[text()='Having Wi-Fi problems or the app not running the way you want?']")
	private WebElement lblWiFiProblem;

	@B2BFindBy(xpath = "//a[text()='click here']")
	private WebElement lnkClickHere;

	@B2BFindBy(xpath = "//button[text()='Download Diagram']")
	private WebElement btnDownloadDiagram;

	@B2BFindBy(xpath = "//button[text()='OK']")
	private WebElement btnOk;

	@B2BFindBy(xpath = "//button[contains(@class,'MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium')]")
	private WebElement iconClose;

	public ViewDrawsPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public void clickOnViewDrawsButton() {
		log.info("Starting of clickOnViewDrawsButton method");

		this.clickOnWebElement(btnViewDraws);

		log.info("Ending of clickOnViewDrawsButton method");
	}

	public void clickOnHavingTroubleButton() {
		log.info("Starting of clickOnHavingTroubleButton method");

		this.clickOnWebElement(btnHavingTrouble);

		log.info("Ending of clickOnHavingTroubleButton method");
	}

	public boolean isHavingTroubleButtonDisplayed() {
		log.info("Starting of isHavingTroubleButtonDisplayed method");

		boolean HavingTrouble = false;

		try {
			if (btnHavingTrouble.isDisplayed()) {
				HavingTrouble = true;
			}
		} catch (Exception e) {
			HavingTrouble = false;
		}

		log.info("Ending of isHavingTroubleButtonDisplayed method");

		return HavingTrouble;
	}

	public String getHavingTroubleText() {
		log.info("Starting of getHavingTroubleText method");
		log.info("Ending of getHavingTroubleText method");

		return getText(btnHavingTrouble);
	}

	public String getHavingWiFiProblemText() {
		log.info("Starting of getHavingWiFiProblemText method");
		log.info("Ending of getHavingWiFiProblemText method");

		return getText(lblWiFiProblem);
	}

	public boolean isHavingWiFiProblemLabelDisplayed() {
		log.info("Starting of isHavingWiFiProblemLabelDisplayed method");

		boolean lblState = false;

		try {
			if (lblWiFiProblem.isDisplayed()) {
				lblState = true;
			}
		} catch (Exception e) {
			lblState = false;
		}
		log.info("Ending of isHavingWiFiProblemLabelDisplayed method");

		return lblState;
	}

	public String getClickHereText() {
		log.info("Starting of getClickHereText method");
		log.info("Ending of getClickHereText method");

		return getText(lnkClickHere);
	}

	public void clickOnClickHereLink() {
		log.info("Starting of clickOnClickHereLink method");

		this.clickOnWebElement(lnkClickHere);

		log.info("Ending of clickOnClickHereLink method");
	}

	public String getDownloadDiagramText() {
		log.info("Starting of getDownloadDiagramText method");
		log.info("Ending of getDownloadDiagramText method");

		return getText(btnDownloadDiagram);
	}

	public void clickOnDownloadDiagramButton() {
		log.info("Starting of clickOnDownloadDiagramButton method");

		this.clickOnWebElement(btnDownloadDiagram);

		log.info("Ending of clickOnDownloadDiagramButton method");
	}

	public String getOkText() {
		log.info("Starting of getOkText method");
		log.info("Ending of getOkText method");

		return getText(btnOk);
	}

	public void clickOnOkButton() {
		log.info("Starting of clickOnOkButton method");

		this.clickOnWebElement(btnOk);

		log.info("Ending of clickOnOkButton method");
	}

	public boolean isCloseIconDisplayed() {
		log.info("Starting of isCloseIconDisplayed method");
		log.info("Ending of isCloseIconDisplayed method");

		return iconClose.isDisplayed();
	}

	public void clickOnCloseIcon() {
		log.info("Starting of clickOnCloseIcon method");

		this.clickOnWebElement(iconClose);

		log.info("Ending of clickOnCloseIcon method");
	}

	public void clickOnHavingTroubleForMultipleTimes() {
		log.info("Starting of clickOnCloseIcon method");

		for (int i = 0; i < 8; i++) {
			this.clickOnWebElement(btnHavingTrouble);
		}

		log.info("Ending of clickOnCloseIcon method");
	}

	public boolean isHavingTroubleButtonIsClickable() {
		log.info("Starting of isHavingTroubleButtonIsClickable method");
		log.info("Ending of isHavingTroubleButtonIsClickable method");

		return this.isClickable(btnHavingTrouble);
	}

	public void clickOnDownloadDiagramForMultipleTimes() {
		log.info("Starting of clickOnDownloadDiagramForMultipleTimes method");

		for (int i = 0; i < 8; i++) {
			this.clickOnWebElement(btnDownloadDiagram);
		}

		log.info("Ending of clickOnDownloadDiagramForMultipleTimes method");
	}

	public boolean isDownloadDiagramButtonIsClickable() {
		log.info("Starting of isDownloadDiagramButtonIsClickable method");
		log.info("Ending of isDownloadDiagramButtonIsClickable method");

		return this.isClickable(btnDownloadDiagram);
	}

	public boolean isClickable(WebElement webElement) {
		log.info("Starting of isClickable method");

		try {

			WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
			webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
			log.info("Ending of isClickable method");

			return true;
		} catch (Exception e) {
			log.info("Ending of isClickable method");
			return false;
		}
	}
}
