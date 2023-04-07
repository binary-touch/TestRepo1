package com.dupr.pages.events;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;
import com.dupr.pages.clubs.ClubLogoPage;

public class EditScoreAfterValidationPage extends DUPRBaseAutomationPage {
	private static final Logger log = LogManager.getLogger(ClubLogoPage.class);

	@B2BFindBy(xpath = "(//p[contains(text(), 'Game 3')]//parent::div//child::div//descendant::input)[1]")
	private WebElement lblFirstGameScore;

	@B2BFindBy(xpath = "(//p[contains(text(), 'Game 3')]//parent::div//child::div//descendant::input)[2]")
	private WebElement lblSecondGameScore;

	@B2BFindBy(xpath = "//button[contains(text(),'Edit Scores')]")
	private WebElement btnEditScores;

	@B2BFindBy(xpath = "//h4[contains(text(),'Edit Scores')]")
	private WebElement lblEditScore;

	@B2BFindBy(xpath = "//h5[contains(text(),'Match Date')]")
	private WebElement lblMatchDate;

	@B2BFindBy(xpath = "//button[contains(text(),'Submit')]")
	private WebElement btnSubmit;

	@B2BFindBy(xpath = "//h4[contains(text(),'Edit Scores')]//button/*/*")
	private WebElement iconCross;

	@B2BFindBy(xpath = "(//span[contains(text(),'Game 3')]//parent::div//following::div//descendant::input)[1]")
	private WebElement lblFirstGameScoreEdit;

	@B2BFindBy(xpath = "(//span[contains(text(),'Game 3')]//parent::div//following::div//descendant::input)[2]")
	private WebElement lblSecondGameScoreEdit;

	@B2BFindBy(xpath = "//button[contains(text(),'Submit Scores')]/parent::div/preceding-sibling::h4")
	private WebElement lblSubmittingNewScores;

	@B2BFindBy(xpath = "//button[contains(text(),'Submit Scores')]")
	private WebElement btnSubmitScore;

	@B2BFindBy(xpath = "//button[contains(text(),'Go Back')]")
	private WebElement btnGoBack;

	@B2BFindBy(xpath = "//h4[contains(text(),'Submitting these new scores will affect scheduled matches')]//button/*/*")
	private WebElement iconClose;

	@B2BFindBy(xpath = "//button[contains(text(),'Forfeit')]")
	private WebElement btnForfeit;
	
	@B2BFindBy(xpath = "//h3[text()='Registration Date']/following-sibling::div//h5[text()='End Date & Time']/parent::div/following-sibling::div//input")
	private WebElement txtBoxRegistrationEndDate;
	
	@B2BFindBy(xpath = "//h3[text()='Competition Date']/following-sibling::div//h5[text()='Start Date & Time']/parent::div/following-sibling::div//input")
	private WebElement txtBoxCompetitionStartDate;
	
	@B2BFindBy(xpath = "//button[text()='OK']")
	private WebElement btnOK;

	public EditScoreAfterValidationPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public String getFirstGameScoreText() {
		log.info("Starting of getFirstGameScoreText method");

		this.hardWait(3);
		String FirstGameScore = lblFirstGameScore.getAttribute("value");

		log.info("Ending of getFirstGameScoreText method");

		return FirstGameScore;
	}

	public String getSecondGameScoreText() {
		log.info("Starting of getSecondGameScoreText method");

		String SecondGameScore = lblSecondGameScore.getAttribute("value");

		log.info("Ending of getSecondGameScoreText method");

		return SecondGameScore;
	}

	public void clickOnEditScore() {
		log.info("Starting of clickOnEditScore method");

		clickOnWebElement(btnEditScores);

		log.info("Ending of clickOnEditScore method");
	}
	
	public void clickOnForfeitButon() {
		log.info("Starting of clickOnForfeitButon method");
		try {
			clickUsingActionsClass(btnForfeit);
		} catch (Exception e) {
			clickOnWebElement(btnForfeit);
		}

		log.info("Ending of clickOnForfeitButon method");
	}

	public boolean isEditScoreDisplayed() {
		log.info("Starting of isEditScoreDisplayed method");

		boolean lblState = false;

		try {

			if (lblEditScore.isDisplayed()) {

				lblState = true;
			}

		} catch (Exception e) {
			lblState = false;
		}
		log.info("Ending of isEditScoreDisplayed method");

		return lblState;
	}

	public String getEditScoreText() {
		log.info("Starting of getEditScoreText method");
		log.info("Ending of getEditScoreText method");

		return lblEditScore.getText();
	}

	public String getMatchDateText() {
		log.info("Starting of getMatchDateText method");
		log.info("Ending of getMatchDateText method");

		return lblMatchDate.getText();
	}

	public String getSubmitButtonText() {
		log.info("Starting of getSubmitButtonText method");
		log.info("Ending of getSubmitButtonText method");

		return btnSubmit.getText();
	}

	public boolean isCrossIconDisplayed() {
		log.info("Starting of isCloseIconDisplayed method");
		log.info("Ending of isCloseIconDisplayed method");

		return iconCross.isDisplayed();
	}

	public void setFirstGameScoreEdit(String editFirstGameScore) {
		log.info("Starting of setFirstGameScoreEdit method");

		lblFirstGameScoreEdit.sendKeys(Keys.CONTROL + "A");
		lblFirstGameScoreEdit.sendKeys(Keys.DELETE);
		lblFirstGameScoreEdit.sendKeys(editFirstGameScore);

		log.info("Ending of setFirstGameScoreEdit method");
	}

	public void setSecondGameScoreEdit(String editSecondGameScore) {

		log.info("Starting of setSecondGameScoreEdit method");
		lblSecondGameScoreEdit.sendKeys(Keys.CONTROL + "A");
		lblSecondGameScoreEdit.sendKeys(Keys.DELETE);
		lblSecondGameScoreEdit.sendKeys(editSecondGameScore);

		log.info("Ending of setSecondGameScoreEdit method");
	}

	public void clickOnSubmitButton() {
		log.info("Starting of clickOnSubmitButton method");

		clickOnWebElement(btnSubmit);

		log.info("Ending of clickOnSubmitButton method");
	}

	public String getSubmitScoresButtonText() {
		log.info("Starting of getSubmitScoresButtonText method");
		log.info("Ending of getSubmitScoresButtonText method");

		return btnSubmitScore.getText();
	}

	public boolean getSubmittingNewScoresText() {
		log.info("Starting of getSubmittingNewScoresText method");
		log.info("Ending of getSubmittingNewScoresText method");

		return lblSubmittingNewScores.isDisplayed();
	}

	public boolean isSubmittingNewScoresLabelDisplayed() {
		log.info("Starting of isSubmittingNewScoresLabelDisplayed method");

		boolean lblState = false;

		try {

			if (lblSubmittingNewScores.isDisplayed()) {
				lblState = true;
			}
		} catch (Exception e) {
			lblState = false;
		}
		log.info("Ending of isSubmittingNewScoresLabelDisplayed method");

		return lblState;

	}

	public String getGoBackText() {
		log.info("Starting of getGoBackText method");
		log.info("Ending of getGoBackText method");

		return btnGoBack.getText();
	}

	public boolean isCloseIconDisplayed() {
		log.info("Starting of uploadProfilePicture method");
		log.info("Ending of uploadProfilePicture method");

		return iconClose.isDisplayed();
	}

	public void clickOnGoBack() {
		log.info("Starting of clickOnGoBack method");

		clickOnWebElement(btnGoBack);

		log.info("Ending of clickOnGoBack method");
	}

	public void clickOnSubmitScoreButton() {
		log.info("Starting of clickOnSubmitScoreButton method");

		clickOnWebElement(btnSubmitScore);

		log.info("Ending of clickOnSubmitScoreButton method");
	}

	public boolean isEditButtonDisplayed() {
		log.info("Starting of isEditButtonDisplayed method");
		log.info("Ending of isEditButtonDisplayed method");

		return btnEditScores.isDisplayed();
	}

	public boolean isForfeitButtonDisplayed() {
		log.info("Starting of isForfeitButtonDisplayed method");
		log.info("Ending of isForfeitButtonDisplayed method");

		return btnForfeit.isDisplayed();
	}
	public void setCompetitionStartDate() {
		log.info("Starting of setCompetitionStartDate method");

		scrollDown(200);

		clickOnWebElement(txtBoxCompetitionStartDate);

		int date = this.getCurrentDate();
		String hours = this.getCurrentHour();
		String meridiem = this.getCurrentMeridiem();

		this.clickOnCurrentDate(date);
		try {
			System.out.println(driver.findElement(By.cssSelector("div>span[aria-label='" + hours + " hours']")));
			WebElement currentHourValue = driver
					.findElement(By.cssSelector("div>span[aria-label='" + hours + " hours']"));

			this.hardWait(2);
			Actions action = new Actions(driver);
			action.moveToElement(currentHourValue).contextClick(currentHourValue).build().perform();
		} catch (Exception e) {
			clickOnWebElement(driver.findElement(By.cssSelector("div>span[aria-label='" + hours + " hours']")));
		}		this.clickOnCurrentTime(meridiem);
		
				this.clickOnCurrentTime("05");


		log.info("Ending of setCompetitionStartDate method");
	}
	public void setRegistrationEndDate() {
		log.info("Starting of setRegistrationEndDate method");

		scrollDown(200);

		clickOnWebElement(txtBoxRegistrationEndDate);

		int date = this.getCurrentDate();
		String hours = this.getCurrentHour();
		String meridiem = this.getCurrentMeridiem();

		this.clickOnCurrentDate(date);
		try {
			System.out.println(driver.findElement(By.cssSelector("div>span[aria-label='" + hours + " hours']")));
			WebElement currentHourValue = driver
					.findElement(By.cssSelector("div>span[aria-label='" + hours + " hours']"));

			this.hardWait(2);
			Actions action = new Actions(driver);
			action.moveToElement(currentHourValue).contextClick(currentHourValue).build().perform();
		} catch (Exception e) {
			clickOnWebElement(driver.findElement(By.cssSelector("div>span[aria-label='" + hours + " hours']")));
		}		this.clickOnCurrentTime(meridiem);
		
				this.clickOnCurrentTime("05");


		log.info("Ending of setRegistrationEndDate method");
	}
}
