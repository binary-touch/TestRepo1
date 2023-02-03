package com.dupr.pages.home;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class SharePage extends DUPRBaseAutomationPage {

	private static final Logger log = LogManager.getLogger(SharePage.class);

	@B2BFindBy(xpath = "//button[@aria-label='twitter']")
	private WebElement iconTwitter;

	@B2BFindBy(xpath = "//button[@aria-label='whatsapp']")
	private WebElement iconWhatsApp;

	@B2BFindBy(xpath = "//button[@aria-label='email']")
	private WebElement iconEmail;

	@B2BFindBy(xpath = "//h4[contains(@class,'MuiTypography-root MuiTypography-h4 MuiTypography-noWrap')]")
	private WebElement lblBracketCard;

	@B2BFindBy(xpath = "//h4[contains(@class,'MuiTypography-root MuiTypography-h4')]")
	private WebElement lblClubEventCard;

	@B2BFindBy(xpath = "//button[contains(text(),'Share')]")
	private WebElement btnShare;

	@B2BFindBy(xpath = "//div[contains(text(),'Edit Profile')]")
	private WebElement btnEditProfile;

	@B2BFindBy(xpath = "//button[contains(text(),'View Public Profile')]")
	private WebElement btnViewProlie;

	public SharePage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public boolean isSharePopUPContains() {
		log.info("Starting of isSharePopUPContains method");

		boolean isSharePopUPContains = false;
		try {
			if (isDisplayed(iconTwitter) && isDisplayed(iconWhatsApp) && isDisplayed(iconEmail)) {

				isSharePopUPContains = true;
			}
		} catch (Exception e) {
			isSharePopUPContains = false;
		}

		log.info("Ending of isSharePopUPContains method");

		return isSharePopUPContains;
	}

	public void clickOnCardLabel() {
		log.info("Starting of clickOnCardLabel method");

		clickOnWebElement(lblBracketCard);

		log.info("Ending of clickOnCardLabel method");
	}

	public void clickOnClubEventCardLabel() {
		log.info("Starting of clickOnClubEventCardLabel method");

		this.hardWait(2);
		clickOnWebElement(lblClubEventCard);

		log.info("Ending of clickOnClubEventCardLabel method");
	}

	public void clickOnShareButton() {
		log.info("Starting of clickOnShareButton method");

		clickOnWebElement(btnShare);
		this.hardWait(2);

		log.info("Ending of clickOnShareButton method");
	}

	public void clickOnEditProfileButton() {
		log.info("Starting of clickOnEditProfileButton method");

		clickOnWebElement(btnEditProfile);
		this.hardWait(4);

		log.info("Ending of clickOnEditProfileButton method");
	}

	public void clickOnViewProfileButton() {
		log.info("Starting of clickOnViewProfileButton method");

		clickOnWebElement(btnViewProlie);
		this.hardWait(3);

		log.info("Ending of clickOnViewProfileButton method");
	}
}
