package com.dupr.pages.profile;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.dupr.pages.DUPRBaseAutomationPage;

public class NotificationsPage extends DUPRBaseAutomationPage {

	private static final Logger log = LogManager.getLogger(NotificationsPage.class);

	@B2BFindBy(xpath = "//button[text()='Notifications']")
	private WebElement tabNotifications;

	@B2BFindBy(xpath = "//span[text()='App Notifications']/../span[contains(@class,'MuiSwitch-root MuiSwitch-sizeMedium')]/descendant::input/..")
	private WebElement btnAppNotifications;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiFormGroup-root')]/label[1]/*/span[contains(@class, 'Mui-checked')]")
	private WebElement tglAppNotificationsInEnabled;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiFormGroup-root')]/label[1]/*/span[contains(@class,'PrivateSwitchBase-root MuiSwitch-switchBase MuiSwitch-colorPrimary')]")
	private WebElement tglAppNotificationsInDisabled;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiFormGroup-root')]/label/following-sibling::label/span[contains(@class,'MuiSwitch-root MuiSwitch-sizeMedium')]")
	private WebElement btnEmaillNotifications;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiFormGroup-root')]/label/following-sibling::label/span[contains(@class,'MuiSwitch-root MuiSwitch-sizeMedium')]/span[contains(@class,'Mui-checked')]")
	private WebElement tglEmaillNotificationsInEnabled;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiFormGroup-root')]/label/following-sibling::label/span[contains(@class,'MuiSwitch-root MuiSwitch-sizeMedium')]/span[contains(@class,'PrivateSwitchBase-root MuiSwitch-switchBase MuiSwitch-colorPrimary')]")
	private WebElement tglEmaillNotificationsInDisabled;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiFormGroup-root')]/div//span[contains(@class,'MuiSwitch-root MuiSwitch-sizeMedium')]")
	private WebElement btnSmsNotifications;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiFormGroup-root')]/div//span[contains(@class,'MuiSwitch-root MuiSwitch-sizeMedium')]/span[contains(@class,'Mui-checked')]")
	private WebElement tglSMSNotificationsInEnabled;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiFormGroup-root')]/div//span[contains(@class,'MuiSwitch-root MuiSwitch-sizeMedium')]/span[contains(@class,'PrivateSwitchBase-root MuiSwitch-switchBase MuiSwitch-colorPrimary')]")
	private WebElement tglSMSNotificationsInDisabled;

	@B2BFindBy(xpath = "//button[text()='Save']")
	private WebElement btnSave;

	public NotificationsPage(WebDriver driver) {
		super(driver);

	}

	public void clickOnNotificationsTab() {
		log.info("Starting of clickOnNotificationsTab method");

		explicitWait(tabNotifications);
		clickOnWebElement(tabNotifications);

		log.info("Ending of clickOnNotificationsTab method");
	}

	public boolean isNotifcationsTabContains() {
		log.info("Starting of isNotifcationsTabContains method");

		/*
		 * try { if(tglAppNotificationsInEnabled.isDisplayed()==true) {
		 * System.out.println("App Notifications Are In Enabled State"); } } catch
		 * (Exception e) { clickOnWebElement(tglAppNotificationsInDisabled);
		 * clickOnWebElement(btnSave); }
		 * 
		 * try { if(isDisplayed(tglEmaillNotificationsInEnabled)==true) {
		 * System.out.println("Email Notifications Are In Enabled State"); } } catch
		 * (Exception e) { clickOnWebElement(tglEmaillNotificationsInDisabled);
		 * clickOnWebElement(btnSave); }
		 * 
		 * 
		 * try { if(isDisplayed(tglSMSNotificationsInEnabled)==true) {
		 * System.out.println("Text(SMS) Notifications Are In Enabled State"); } } catch
		 * (Exception e) { clickOnWebElement(tglSMSNotificationsInDisabled);
		 * clickOnWebElement(btnSave); }
		 */
	
	
		boolean isNotifcationsTabContains = false;
		if (isDisplayed(tglAppNotificationsInEnabled) || isDisplayed(tglEmaillNotificationsInEnabled)
				|| isDisplayed(tglSMSNotificationsInEnabled) && !(btnSave.isEnabled()== true))

			isNotifcationsTabContains = true;

		log.info("Ending of isNotifcationsTabContains method");

		return isNotifcationsTabContains;
	}

	public void clickOnAppNotificationsToggle() {
		log.info("Starting of clickOnAppNotificationsToggle method");

		try {
			if (tglAppNotificationsInEnabled.isDisplayed() == true) {
				log.info("App Notifications are enabled");
				btnAppNotifications.click();
				tglAppNotificationsInDisabled.click();
			}
		} catch (Exception e) {
			if (tglAppNotificationsInDisabled.isDisplayed() == true) {
				btnAppNotifications.click();
			}
		}

		log.info("Ending of clickOnAppNotificationsToggle method");
	}

	public void clickOnEmailNotificationsToggle() {
		log.info("Starting of clickOnEmailNotificationsToggle method");

		try {
			if (tglEmaillNotificationsInEnabled.isDisplayed() == true) {
				log.info("App Notifications are enabled");
				btnEmaillNotifications.click();
				tglEmaillNotificationsInDisabled.click();
			}
		} catch (Exception e) {
			if (tglEmaillNotificationsInDisabled.isDisplayed() == true) {
				btnEmaillNotifications.click();
			}
		}

		log.info("Ending of clickOnEmailNotificationsToggle method");
	}

	public void clickOnSMSNotificationsToggle() {
		log.info("Starting of clickOnSMSNotificationsToggle method");

		try {
			if (tglSMSNotificationsInEnabled.isDisplayed() == true) {
				log.info("App Notifications are enabled");
				btnSmsNotifications.click();
				tglSMSNotificationsInDisabled.click();
			}
		} catch (Exception e) {
			if (tglSMSNotificationsInDisabled.isDisplayed() == true) {
				clickOnWebElement(btnSmsNotifications);
			}
		}

		log.info("Ending of clickOnSMSNotificationsToggle method");
	}

	public void clickOnSaveButton() {
		log.info("Starting of clickOnSaveButton method");

		clickOnWebElement(btnSave);

		log.info("Ending of clickOnSaveButton method");
	}

	public boolean isSaveButtonEnabled() {
		log.info("Starting of isSaveButtonEnabled method");

		boolean isSaveButtonEnabled = false;

		try {
			if (this.btnSave.isEnabled() == true) {

				isSaveButtonEnabled = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("Ending of isSaveButtonEnabled method");

		return isSaveButtonEnabled;
	}

	public boolean isEmailNotificationsEnabled() {
		log.info("Starting of isEmailNotificationsEnabled method");

		boolean isEmailNotificationsEnabled = false;

		try {
			if (this.tglEmaillNotificationsInEnabled.isDisplayed() == true) {
				isEmailNotificationsEnabled = true;
			}
		} catch (Exception e) {
			isEmailNotificationsEnabled = false;
		}
		log.info("Ending of isEmailNotificationsEnabled method");

		return isEmailNotificationsEnabled;
	}

	public boolean isSMSNotificationsEnabled() {
		log.info("Starting of isSMSNotificationsEnabled method");

		boolean isSMSNotificationsEnabled = false;
		
		try { 
			if(isDisplayed(tglSMSNotificationsInEnabled)==true) {
			  System.out.println("Text(SMS) Notifications Are In Enabled State"); 
			  }
		} 
		catch(Exception e) { 
			clickOnWebElement(tglSMSNotificationsInDisabled);
			  clickOnWebElement(btnSave);
			  }
		

		try {
			if (this.tglSMSNotificationsInEnabled.isDisplayed() == true) {
				isSMSNotificationsEnabled = true;
			}
		} catch (Exception e) {
			isSMSNotificationsEnabled = false;
		}
		log.info("Ending of isSMSNotificationsEnabled method");

		return isSMSNotificationsEnabled;
	}

	public boolean isAppNotificationsEnabled() {
		log.info("Starting of isAppNotificationsEnabled method");

		boolean isAppNotificationsEnabled = false;

		try {
			if (this.tglAppNotificationsInEnabled.isDisplayed() == true) {

				isAppNotificationsEnabled = true;
			}
		} catch (Exception e) {
			isAppNotificationsEnabled = false;
		}
		log.info("Ending of isAppNotificationsEnabled method");

		return isAppNotificationsEnabled;
	}
}
