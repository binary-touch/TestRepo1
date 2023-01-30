package com.dupr.pages.clubs;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BFindBys;
import com.dupr.pages.DUPRBaseAutomationPage;

public class MyClubsPage   extends DUPRBaseAutomationPage  {

	private static final Logger log = LogManager.getLogger(MyClubsPage.class);

	@B2BFindBy(xpath = "//h4[text()='My Clubs']")
	private WebElement tabMyClubs;

	@B2BFindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-u7hjsa']")
	private WebElement iconBackArrow;

	@B2BFindBy(xpath = "//h3[text()='Clubs']")
	private WebElement lblClubs;

	@B2BFindBy(xpath = "//h2[text()='My Clubs']")
	private WebElement lblMyClubs;

	@B2BFindBy(xpath = "//button[text()='Browse Clubs']")
	private WebElement btnBrowseClubs;

	@B2BFindBy(xpath = "//h5[text()='Memberships']")
	private WebElement txtMemberships;

	@B2BFindBys(@B2BFindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-6 css-iol86l']"))
	public List<WebElement> lstClubs;
	
	@B2BFindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-6 css-iol86l']/div[1]")
	private WebElement tabFirstClubCard;

	public MyClubsPage(WebDriver driver) {
		super(driver);
	
	}

	public void clickOnMyClubsTab() {
		log.info("Starting of clickOnMyClubsTab method");

		clickOnElement(tabMyClubs);
		// tabMyClubs.click();

		log.info("Ending of clickOnMyClubsTab method");
	}

	public boolean isClubsPageContains() {
		log.info("Starting of isClubsPageContains method");

		boolean isClubsPageContains = false;
		if (isDisplayed(iconBackArrow) && isDisplayed(lblClubs) && isDisplayed(lblMyClubs)) {

			isClubsPageContains = true;
		}

		log.info("Ending of isClubsPageContains method");

		return isClubsPageContains;
	}

	public boolean isClubsAvailableOnClubsPage() {
		log.info("Starting of isClubsAvailableOnClubsPage method");

		boolean isClubsAvailableOnClubsPage = false;

		try {
			if (isDisplayed(txtMemberships) == true) {

				isClubsAvailableOnClubsPage = true;
			}
		} catch (Exception e) {

			isClubsAvailableOnClubsPage = false;
			log.info("User has not joined in any clubs");

		}

		log.info("Ending of isClubsAvailableOnClubsPage method");

		return isClubsAvailableOnClubsPage;
	}

	public void clickOnBrowseClubsButton() {
		log.info("Starting of clickOnBrowseClubsButton method");

		clickOnWebElement(btnBrowseClubs);

		log.info("Ending of clickOnBrowseClubsButton method");
	}
	
	public void clickOnBackArrowIcon() {
		log.info("Starting of clickOnBackArrowIcon method");

		clickOnWebElement(iconBackArrow);

		log.info("Ending of clickOnBackArrowIcon method");
	}
	
	public void clickOnClubCard() {
		log.info("Starting of clickOnClubCard method");		

		try {
			if (isDisplayed(tabFirstClubCard) == true) {

				clickOnWebElement(tabFirstClubCard);
			}
		} catch (Exception e) {
			
			log.info("User has not joined in any clubs");

		}

		log.info("Ending of clickOnClubCard method");		
	}
}
