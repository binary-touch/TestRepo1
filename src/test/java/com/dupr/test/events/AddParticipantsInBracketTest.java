package com.dupr.test.events;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.events.AddParticipantsInBracketsPage;
import com.dupr.test.DUPRBaseAutomationTest;

public class AddParticipantsInBracketTest extends DUPRBaseAutomationTest {

	private static final Logger logger = Logger.getLogger(AddParticipantsInBracketTest.class.getName());

	private AddParticipantsInBracketsPage addParticipantsPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "directorEmail", "directorPassword" })
	public void initMethod(String browser, String siteURL, String email, String password) throws Exception {
		logger.info("Starting of initMethod in AddParticipantsInBracketTest");

		this.driver = super.getWebDriver(WebDriversEnum.ADD_PARTICIPANTS_DRIVER);
		this.siteLogin(siteURL, email, password, this.driver);

		this.addParticipantsPage = new AddParticipantsInBracketsPage(this.driver);

		logger.info("Ending of initMethod in AddParticipantsInBracketTest");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.ADD_PARTICIPANTS_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
