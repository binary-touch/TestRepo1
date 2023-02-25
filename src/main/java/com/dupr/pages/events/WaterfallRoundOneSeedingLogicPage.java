package com.dupr.pages.events;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BFindBys;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class WaterfallRoundOneSeedingLogicPage extends DUPRBaseAutomationPage {

	private static final Logger log = LogManager.getLogger(SeedMatchesWaterFallPage.class);

	@B2BFindBys(@B2BFindBy(xpath = "//h2[contains(text(),'Add a Bracket Participant')]/parent::div//h6[contains(text(),'Singles')]/parent::div//h2"))
	private List<WebElement> txtSinglesRating;

	@B2BFindBy(xpath = "//button[text()='Add Participants']")
	private WebElement btnAddParticipants;

	@B2BFindBy(xpath = "//button[text()='Add Participant']")
	private WebElement btnAddParticipant;

	@B2BFindBy(xpath = "//span[text()='No']")
	private WebElement rdoNo;

	@B2BFindBy(xpath = "//button[text()='Add']")
	private WebElement btnAdd;

	@B2BFindBy(xpath = "//button[contains(text(),'Sort')]")
	private WebElement btnSort;

	@B2BFindBy(xpath = "//span[contains(text(),'High to Low Rating')]")
	private WebElement rdoHightToLow;

	@B2BFindBys(@B2BFindBy(xpath = "//div[contains(@class,'infinite-scroll-component__outerdiv')]//h4"))
	private List<WebElement> txtPlayerName;

	@B2BFindBy(id = "Search")
	private WebElement btnsdfghAdd;

	public WaterfallRoundOneSeedingLogicPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	String FirstPlayerName = null;
	String SecondPlayerName = null;
	String ThirdPlayerName = null;
	String FourthPlayerName = null;
	String FifthPlayerName = null;
	String SixthPlayerName = null;
	String SeventhPlayerName = null;
	String EighthPlayerName = null;
	String NinthPlayerName = null;
	String TenthPlayerName = null;
	String EleventhPlayerName = null;
	String TwelfthPlayerName = null;
	String ThirteenthPlayerName = null;
	String FourteenthPlayerName = null;
	String FifteenthPlayerName = null;
	String SixteenthPlayerName = null;
	String MatchOneFirstPlayerName = null;
	String MatchOneSecondPlayerName = null;
	String MatchTwoFirstPlayerName = null;
	String MatchTwoSecondPlayerName = null;
	String MatchThreeFirstPlayerName = null;
	String MatchThreeSecondPlayerName = null;
	String MatchFourFirstPlayerName = null;
	String MatchFourSecondPlayerName = null;
	String MatchFiveFirstPlayerName = null;
	String MatchFiveSecondPlayerName = null;
	String MatchSixFirstPlayerName = null;
	String MatchSixSecondPlayerName = null;
	String MatchSevenFirstPlayerName = null;
	String MatchSevenSecondPlayerName = null;
	String MatchEightFirstPlayerName = null;
	String MatchEightSecondPlayerName = null;

	public void getSinglesRating() {
		log.info("Starting of isQueueTabDisplayed method");

		int s = 0;
		int k = 0;

		for (int j = 0; j < 15; j++) {
			try {
				this.hardWait(3);
				if (btnAddParticipants.isDisplayed() == true) {
					clickOnWebElement(btnAddParticipants);
					this.hardWait(4);
					for (int i = 0; i <= txtSinglesRating.size(); i++) {
						if (txtSinglesRating.get(i).getText().equals("NR") && s < 7) {
							txtSinglesRating.get(i).click();
							s++;
							break;
						} else {
							if (k < 7) {
								if (txtSinglesRating.get(i).getText().equals("NR")) {

									scrollIntoView(txtSinglesRating.get(i));
								} else {
									txtSinglesRating.get(i).click();
									k++;
									break;
								}
							}
						}
					}
					this.hardWait(3);
					clickOnElement(btnAddParticipant);
					this.hardWait(4);
					clickOnWebElement(rdoNo);
					this.hardWait(3);
					clickOnWebElement(btnAdd);
					this.hardWait(5);
				}
			} catch (Exception e) {
				System.out.println();
			}
		}

		log.info("Ending of isQueueTabDisplayed method");

	}

	public void clickOnSortButton() {
		log.info("Starting of clickOnSortButton method");
		try {
			clickUsingActionsClass(btnSort);
		} catch (Exception e) {
			clickOnWebElement(btnSort);
		}

		hardWait(2);
		try {
			clickUsingActionsClass(rdoHightToLow);
		} catch (Exception e) {
			clickOnWebElement(rdoHightToLow);
		}
		hardWait(4);

		log.info("Ending of clickOnSortButton method");
	}

	public void getPlayerName() {
		log.info("Starting of getPlayerName method");
		scrollDown(3000);
		this.hardWait(3);
		for (int i = 0; i < 16; i++) {
			System.out.println(txtPlayerName.size());

			String PlayerName = txtPlayerName.get(i).getText();

			if (i == 0) {
				FirstPlayerName = PlayerName;

			} else if (i == 1) {
				SecondPlayerName = PlayerName;

			} else if (i == 2) {
				ThirdPlayerName = PlayerName;

			} else if (i == 3) {
				FourthPlayerName = PlayerName;

			} else if (i == 4) {
				FifthPlayerName = PlayerName;

			} else if (i == 5) {
				SixthPlayerName = PlayerName;

			} else if (i == 6) {
				SeventhPlayerName = PlayerName;

			} else if (i == 7) {
				EighthPlayerName = PlayerName;

			} else if (i == 8) {
				NinthPlayerName = PlayerName;

			} else if (i == 9) {
				TenthPlayerName = PlayerName;

			} else if (i == 10) {
				EleventhPlayerName = PlayerName;

			} else if (i == 11) {
				TwelfthPlayerName = PlayerName;

			} else if (i == 12) {
				ThirteenthPlayerName = PlayerName;

			} else if (i == 13) {
				FourteenthPlayerName = PlayerName;

			} else if (i == 14) {
				FifteenthPlayerName = PlayerName;

			} else if (i == 15) {
				SixteenthPlayerName = PlayerName;
			}
		}
		scrollDown(-3000);
		log.info("Ending of getPlayerName method");

	}

	public void getRoundOnePlayersName() {
		log.info("Starting of getRoundOnePlayersName method");
		for (int i = 1; i < 9; i++) {

			String RoundOnePlayerOne = driver.findElement(By.xpath(
					"//div[contains(@class,'bg-white rounded shadow-md h-auto')]/*/div[contains(., 'Match #') and contains(., '"
							+ i + "')]/parent::div/following-sibling::div[1]//span"))
					.getText();
			hardWait(2);
			String RoundOnePlayerTwo = driver.findElement(By.xpath(
					"//div[contains(@class,'bg-white rounded shadow-md h-auto')]/*/div[contains(., 'Match #') and contains(., '"
							+ i + "')]/parent::div/following-sibling::div[3]//span"))
					.getText();

			if (i == 1) {
				MatchOneFirstPlayerName = RoundOnePlayerOne;
				MatchOneSecondPlayerName = RoundOnePlayerTwo;
			} else if (i == 2) {
				MatchTwoFirstPlayerName = RoundOnePlayerOne;
				MatchTwoSecondPlayerName = RoundOnePlayerTwo;
				scrollDown(150);
			} else if (i == 3) {
				MatchThreeFirstPlayerName = RoundOnePlayerOne;
				MatchThreeSecondPlayerName = RoundOnePlayerTwo;
				scrollDown(150);
			} else if (i == 4) {
				MatchFourFirstPlayerName = RoundOnePlayerOne;
				MatchFourSecondPlayerName = RoundOnePlayerTwo;
				scrollDown(150);
			} else if (i == 5) {
				MatchFiveFirstPlayerName = RoundOnePlayerOne;
				MatchFiveSecondPlayerName = RoundOnePlayerTwo;
				scrollDown(150);
			} else if (i == 6) {
				MatchSixFirstPlayerName = RoundOnePlayerOne;
				MatchSixSecondPlayerName = RoundOnePlayerTwo;
				scrollDown(150);
			} else if (i == 7) {
				MatchSevenFirstPlayerName = RoundOnePlayerOne;
				MatchSevenSecondPlayerName = RoundOnePlayerTwo;
				scrollDown(150);
			} else if (i == 8) {
				MatchEightFirstPlayerName = RoundOnePlayerOne;
				MatchEightSecondPlayerName = RoundOnePlayerTwo;
			}

			log.info("Ending of getRoundOnePlayersName method");
		}
	}

	public void printnames() {

		System.out.println(FirstPlayerName);
		System.out.println(MatchOneFirstPlayerName);

		System.out.println(SixteenthPlayerName);//
		System.out.println(MatchOneSecondPlayerName);

		System.out.println(EighthPlayerName);
		System.out.println(MatchTwoFirstPlayerName);

		System.out.println(NinthPlayerName);
		System.out.println(MatchTwoSecondPlayerName);

		System.out.println(FourthPlayerName);
		System.out.println(MatchThreeFirstPlayerName);

		System.out.println(ThirteenthPlayerName);//
		System.out.println(MatchThreeSecondPlayerName);

		System.out.println(FifthPlayerName);
		System.out.println(MatchFourFirstPlayerName);

		System.out.println(TwelfthPlayerName);//
		System.out.println(MatchFourSecondPlayerName);

		System.out.println(SecondPlayerName);
		System.out.println(MatchFiveFirstPlayerName);

		System.out.println(FifteenthPlayerName);//
		System.out.println(MatchFiveSecondPlayerName);

		System.out.println(SeventhPlayerName);
		System.out.println(MatchSixFirstPlayerName);

		System.out.println(TenthPlayerName);
		System.out.println(MatchSixSecondPlayerName);

		System.out.println(ThirdPlayerName);
		System.out.println(MatchSevenFirstPlayerName);

		System.out.println(FourteenthPlayerName);//
		System.out.println(MatchSevenSecondPlayerName);

		System.out.println(SixthPlayerName);
		System.out.println(MatchEightFirstPlayerName);

		System.out.println(EleventhPlayerName);//
		System.out.println(MatchEightSecondPlayerName);
	}

	public boolean WaterFallRoundOneSeedingLogic() {
		log.info("Starting of WaterFallRoundOneSeedingLogic method");

		boolean WaterFallRoundOneSeedingLogic = false;

		try {
			if ((MatchOneFirstPlayerName).equals(FirstPlayerName)
					&& (MatchOneSecondPlayerName).equals(SixteenthPlayerName)
					&& (MatchTwoFirstPlayerName).equals(EighthPlayerName)
					&& (MatchTwoSecondPlayerName).equals(NinthPlayerName)
					&& (MatchThreeFirstPlayerName).equals(FourthPlayerName)
					&& (MatchThreeSecondPlayerName).equals(ThirteenthPlayerName)
					&& (MatchFourFirstPlayerName).equals(FifthPlayerName)
					&& (MatchFourSecondPlayerName).equals(TwelfthPlayerName)
					&& (MatchFiveFirstPlayerName).equals(SecondPlayerName)
					&& (MatchFiveSecondPlayerName).equals(FifteenthPlayerName)
					&& (MatchSixFirstPlayerName).equals(SeventhPlayerName)
					&& (MatchSixSecondPlayerName).equals(TenthPlayerName)
					&& (MatchSevenFirstPlayerName).equals(ThirdPlayerName)
					&& (MatchSevenSecondPlayerName).equals(FourteenthPlayerName)
					&& (MatchEightFirstPlayerName).equals(SixthPlayerName)
					&& (MatchEightSecondPlayerName).equals(EleventhPlayerName)) {

				WaterFallRoundOneSeedingLogic = true;

			}
		} catch (Exception e) {
			WaterFallRoundOneSeedingLogic = false;
		}

		log.info("Ending of WaterFallRoundOneSeedingLogic method");

		return WaterFallRoundOneSeedingLogic;
	}
}
