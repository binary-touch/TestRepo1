package com.dupr.pages.clubs;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class RemoveMemberPage extends DUPRBaseAutomationPage {
	private static final Logger log = LogManager.getLogger(RemoveMemberPage.class);

	@B2BFindBy(xpath = "//button[text()='Members']")
	private WebElement tabMembers;

	@B2BFindBy(xpath = "//div[contains(@class, 'MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation3')]/div[2]/div[2]//h4[contains(@class,'MuiTypography-root MuiTypography-h4')]")
	private WebElement txtMemberName;

	@B2BFindBy(xpath = "//h6[text()='Singles']")
	private WebElement txtSingles;

	@B2BFindBy(xpath = "//h6[text()='Doubles']")
	private WebElement txtDoubles;

	@B2BFindBy(xpath = "//div[contains(@class, 'MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation3')]//button[@id='composition-button']")
	private WebElement menuKebab;

	@B2BFindBy(xpath = "//span[text()='Remove from Club']")
	private WebElement btnRemove;

	@B2BFindBy(xpath = "//input[@id='Search']")
	private WebElement btnSearch;

	@B2BFindBy(xpath = "//span[text()='No results found!']")
	private WebElement txtNoResults;

	public RemoveMemberPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public void clickOnMembersTab() {
		log.info("Starting of clickOnMembersTab method");

		clickOnWebElement(tabMembers);

		log.info("Ending of clickOnMembersTab method");
	}

	public String getMemberNameTxt() {
		log.info("Starting of getMemberNameTxt method");
		String memberName = getText(txtMemberName);
		System.out.println(memberName);
		log.info("Ending of getMemberNameTxt method");

		return memberName;
	}

	public String getDoublesTxt() {
		log.info("Starting of getDoublesTxt method");
		log.info("Ending of getDoublesTxt method");

		return getText(txtDoubles);
	}

	public Boolean getDoubles() {
		boolean DoublesTxt = false;
		try {
			if (isDisplayed(txtNoResults) == true) {
				DoublesTxt = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return DoublesTxt;
	}

	public String getSinglesTxt() {
		log.info("Starting of getSinglesTxt method");
		log.info("Ending of getSinglesTxt method");

		return getText(txtSingles);

	}

	public boolean isClubMemberContains() {
		log.info("Starting of isClubMemberContains method");

		boolean isClubMemberContains = false;

		if (isDisplayed(btnSearch) && isDisplayed(menuKebab) && isDisplayed(txtDoubles) && isDisplayed(txtSingles)
				&& isDisplayed(txtMemberName)) {

			isClubMemberContains = true;
		}

		log.info("Ending of isClubMemberContains method");

		return isClubMemberContains;
	}

	public void clickOnKebabMenu() {
		log.info("Starting of clickOnKebabMenu method");

		clickOnWebElement(menuKebab);

		log.info("Ending of clickOnKebabMenu method");

	}

	public void clickOnRemoveButton() {
		log.info("Starting of clickOnRemoveButton method");

		clickOnWebElement(btnRemove);

		log.info("Ending of clickOnRemoveButton method");
	}

	public void clickOnSearch(String name) {
		log.info("Starting of clickOnSearch method");

		clickOnWebElement(btnSearch);
		this.hardWait(1);
		this.btnSearch.sendKeys(name);

		log.info("Ending of clickOnSearch method");

	}

	public String getNoResultsTxt() {
		log.info("Starting of getNoResultsTxt method");
		log.info("Ending of getNoResultsTxt method");

		return getText(txtNoResults);
	}
}
