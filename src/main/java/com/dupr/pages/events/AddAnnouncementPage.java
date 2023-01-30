package com.dupr.pages.events;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.b2b.support.B2BFindBy;
import com.b2b.support.B2BPageFactory;
import com.dupr.pages.DUPRBaseAutomationPage;

public class AddAnnouncementPage extends DUPRBaseAutomationPage {
	private static final Logger log = LogManager.getLogger(AddAnnouncementPage.class);

	@B2BFindBy(xpath = "//*[contains(@class,'MuiSvgIcon-root MuiSvgIcon-colorPrimary MuiSvgIcon-fontSizeMedium')]")
	private WebElement btnBack;

	@B2BFindBy(xpath = "(//h4[contains(@class,'MuiTypography-root MuiTypography-h4')])")
	private List<WebElement> lblEvent;

	@B2BFindBy(xpath = "//button[text()='Add An Announcement']")
	private WebElement btnAddAnnouncement;

	@B2BFindBy(xpath = "//h3[text()='Send An Announcement']")
	private WebElement lblSendAnnouncement;

	@B2BFindBy(xpath = "//h5[text()='Subject']")
	private WebElement lblSubject;

	@B2BFindBy(xpath = "//h5[text()='Subject']/parent::div/following-sibling::div/*//textarea[1]")
	private WebElement txtTitle;

	@B2BFindBy(xpath = "//div[contains(@class,'MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-fullWidth MuiInputBase-formControl MuiInputBase-multiline')]//*")
	private WebElement txtTitleMsg;

	@B2BFindBy(xpath = "//div[contains(@class,'text-editor rdw-editor-main')]")
	private WebElement txtDescription;

	@B2BFindBy(xpath = "//div[contains(@class,'text-editor rdw-editor-main')]//span//*")
	private WebElement txtBoxDescriptionMsg;

	@B2BFindBy(xpath = "//button[text()='Send']")
	private WebElement btnSend;

	@B2BFindBy(xpath = "//button[text()='Send' and @disabled]")
	private WebElement btnSendDisabled;

	@B2BFindBy(xpath = "//div[@title='Bold']")
	private WebElement btnBold;

	@B2BFindBy(xpath = "//div[@title='Italic']")
	private WebElement btnItalic;

	@B2BFindBy(xpath = "//div[@title='Underline']")
	private WebElement btnUnderline;

	@B2BFindBy(xpath = "//p[text()='Title is required']")
	private WebElement txtTitleRequired;

	@B2BFindBy(xpath = "//p[text()='Minimum 10 characters.']")
	private WebElement txtMinimumChar;

	@B2BFindBy(xpath = "//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']/span")
	private WebElement txtFontStyle;

	@B2BFindBy(xpath = "//h4[text()='Event Announcement']")
	private WebElement lblEventAnnouncement;

	@B2BFindBy(xpath = "//h4[text()='Congratulations!']")
	private WebElement lblCongrats;

	@B2BFindBy(xpath = "//p[contains(@class,'MuiTypography-root MuiTypography-body1 css-107ewxd')]")
	private WebElement lblEventCreated;

	@B2BFindBy(xpath = "//h4//button[@type='button']//*")
	private WebElement iconClose;

	@B2BFindBy(xpath = "//button[text()='Announcements']")
	private WebElement tabAnnouncements;

	@B2BFindBy(xpath = "//button[text()='Edit']")
	private List<WebElement> lstBtnEdit;

	@B2BFindBy(xpath = "//button[text()='Edit']")
	private WebElement btnEdit;

	@B2BFindBy(xpath = "//div[contains(@class,'infinite-scroll-component__outerdiv')]//h4")
	private WebElement lblAnnouncementTitle;

	@B2BFindBy(xpath = "//div[contains(@class,'infinite-scroll-component__outerdiv')]//p")
	private WebElement lblAnnouncementSentTime;

	@B2BFindBy(xpath = "//div[contains(@class,'infinite-scroll-component__outerdiv')]//h6")
	private WebElement lblAnnouncementDesc;

	public AddAnnouncementPage(WebDriver driver) {
		super(driver);
		B2BPageFactory.initElements(driver, this);
	}

	public void clickOnEventLabel() {
		log.info("Starting of clickOnEventLabel method");

		for (int i = 1; i < lblEvent.size(); i++) {
			this.hardWait(3);
			driver.findElement(
					By.xpath((("(//h4[contains(@class,'MuiTypography-root MuiTypography-h4')])[" + i + "]")))).click();

			this.hardWait(3);
			try {
				if ((isDisplayed(btnAddAnnouncement) == true)) {
					clickOnElement(btnAddAnnouncement);
					break;
				}
			} catch (Exception e) {
				clickOnElement(btnBack);
			}
		}
		log.info("Ending of clickOnEventLabel method");
	}

	public String getSendAnnouncementText() {
		log.info("Starting of getSendAnnouncementText method");
		log.info("Ending of getSendAnnouncementText method");

		return getText(lblSendAnnouncement);
	}

	public String getSubjectText() {
		log.info("Starting of getSubjectText method");
		log.info("Ending of getSubjectText method");

		return getText(lblSubject);
	}

	public boolean isSendAnnouncementPageContains() {
		log.info("Starting of isSendAnnouncementPageContains method");

		boolean isSendAnnouncementPageContains = false;
		try {
			log.debug(isDisplayed(btnBack));
			log.debug(isDisplayed(lblSubject));
			log.debug(isDisplayed(txtTitle));
			log.debug(isDisplayed(txtDescription));
			log.debug(isDisplayed(btnSend));
			log.debug(isDisplayed(btnBold));
			log.debug(isDisplayed(btnItalic));
			log.debug(isDisplayed(btnItalic));
		} catch (Exception e) {
			System.out.println("Failed: " + e.getMessage());
		}
		try {
			if (isDisplayed(btnBack) && isDisplayed(lblSubject) && isDisplayed(txtTitle) && isDisplayed(txtDescription)
					&& isDisplayed(btnSend) && isDisplayed(btnBold) && isDisplayed(btnItalic)
					&& isDisplayed(btnUnderline)) {
				isSendAnnouncementPageContains = true;
			}

		} catch (Exception e) {
			isSendAnnouncementPageContains = false;
		}

		log.info("Ending of isSendAnnoucementPageContains method");

		return isSendAnnouncementPageContains;
	}

	public boolean isTitleFieldEmpty() {
		log.info("Starting of isTitleFieldEmpty method");
		log.info("Ending of isTitleFieldEmpty method");

		return txtTitle.getText().isEmpty();
	}

	public String getValidationOfTitleTxt() {
		log.info("Starting of getValidationOfTitleTxt method");
		log.info("Ending of getValidationOfTitleTxt method");

		return getText(txtTitleRequired);
	}

	public boolean isDescriptionFieldEmpty() {
		log.info("Starting of isDescriptionFieldEmpty method");
		log.info("Ending of isDescriptionFieldEmpty method");

		return txtDescription.getText().isEmpty();
	}

	public boolean isSendButtonDisabled() {
		log.info("Starting of isSendButtonDisabled method");
		log.info("Ending of isSendButtonDisabled method");

		return isDisplayed(btnSendDisabled);
	}

	public void clickOnAddAnnouncementButton() {
		log.info("Starting of clickOnAddAnnouncementButton method");

		clickOnElement(btnAddAnnouncement);

		log.info("Ending of clickOnAddAnnouncementButton method");
	}

	public void clickOnBackButton() {
		log.info("Starting of clickOnBackButton method");

		clickOnElement(btnBack);

		log.info("Ending of clickOnBackButton method");
	}

	public void clickOnBoldButton() {
		log.info("Starting of clickOnBoldButton method");

		clickOnElement(btnBold);

		log.info("Ending of clickOnBoldButton method");
	}

	public void clickOnItalicButton() {
		log.info("Starting of clickOnItalicButton method");

		clickOnElement(btnItalic);

		log.info("Ending of clickOnItalicButton method");
	}

	public void clickOnUnderlineButton() {
		log.info("Starting of clickOnUnderlineButton method");

		clickOnElement(btnUnderline);

		log.info("Ending of clickOnUnderlineButton method");
	}

	public void setDescription(String description) {
		log.info("Starting of setDescription method");

		clickOnElement(txtDescription);
		this.hardWait(2);
		this.txtBoxDescriptionMsg.sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
		this.txtBoxDescriptionMsg.sendKeys(description);

		log.info("Ending of setDescription method");
	}

	public String getMinimumCharactersTxt() {
		log.info("Starting of getMinimumCharactersTxt method");
		log.info("Ending of getMinimumCharactersTxt method");

		return txtMinimumChar.getText();
	}

	public boolean isMinimumCharactersText() {
		log.info("Starting of isMinimumCharactersText method");

		boolean validationMsg = false;
		try {
			if (isDisplayed(txtMinimumChar)) {
				validationMsg = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("Ending of isMinimumCharactersText method");

		return validationMsg;
	}

	public boolean isSendButtonEnabled() {
		log.info("Starting of isSendButtonEnabled method");
		log.info("Ending of isSendButtonEnabled method");

		return btnSend.isEnabled();
	}

	public void clickOnSendButton() {
		log.info("Starting of clickOnSendButton method");

		clickOnWebElement(btnSend);

		log.info("Ending of clickOnSendButton method");
	}

	public void clickOnTextFormattingButtons() {
		log.info("Starting of clickOnTextFormattingButtons method");

		hardWait(2);
		this.txtBoxDescriptionMsg.sendKeys(Keys.CONTROL + "a");

		elementClick(btnBold);
		elementClick(btnItalic);
		elementClick(btnUnderline);
		hardWait(2);

		log.info("Ending of clickOnTextFormattingButtons method");
	}

	public void clickOnBoldTextFormattingButton() {
		log.info("Starting of clickOnBoldTextFormattingButton method");

		hardWait(2);
		this.txtBoxDescriptionMsg.sendKeys(Keys.CONTROL + "a");

		elementClick(btnBold);

		log.info("Ending of clickOnBoldTextFormattingButton method");
	}

	public boolean isBoldFontStyleDisplayed() {
		log.info("Starting of isBoldFontStyleDisplayed method");

		boolean fontStyle = false;
		try {
			if (txtFontStyle.getAttribute("style").equals("font-weight: bold;")) {
				fontStyle = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("Ending of isBoldFontStyleDisplayed method");

		return fontStyle;
	}

	public void clickOnItalicTextFormattingButton() {
		log.info("Starting of clickOnItalicTextFormattingButton method");

		hardWait(2);
		this.txtBoxDescriptionMsg.sendKeys(Keys.CONTROL + "a");
		elementClick(btnItalic);

		log.info("Ending of clickOnItalicTextFormattingButton method");
	}

	public boolean isItalicFontStyleDisplayed() {
		log.info("Starting of isItalicFontStyleDisplayed method");

		boolean fontStyle = false;
		try {
			if (txtFontStyle.getAttribute("style").equals("font-style: italic;")) {
				fontStyle = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("Ending of isItalicFontStyleDisplayed method");

		return fontStyle;
	}

	public void clickOnUnderLineTextFormattingButton() {
		log.info("Starting of clickonUnderLineTextFormattingButton method");

		hardWait(2);
		this.txtBoxDescriptionMsg.sendKeys(Keys.CONTROL + "a");
		elementClick(btnUnderline);

		log.info("Ending of clickonUnderLineTextFormattingButton method");
	}

	public boolean isUnderlineFontStyleDisplayed() {
		log.info("Starting of isUnderlineFontStyleDisplayed method");

		boolean fontStyle = false;
		try {
			if (txtFontStyle.getAttribute("style").equals("text-decoration: underline;")) {
				fontStyle = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("Ending of isUnderlineFontStyleDisplayed method");

		return fontStyle;
	}

	public boolean isBoldUnderlineFontStylesDisplayed() {
		log.info("Starting of isBoldUnderlineFontStylesDisplayed method");

		boolean fontStyle = false;
		try {
			if (txtFontStyle.getAttribute("style").equals("font-weight: bold; text-decoration: underline;")) {
				fontStyle = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("Ending of isBoldUnderlineFontStylesDisplayed method");

		return fontStyle;
	}

	public boolean isItalicUnderlineFontStylesDisplayed() {
		log.info("Starting of isItalicUnderlineFontStylesDisplayed method");

		boolean fontStyle = false;
		try {
			if (txtFontStyle.getAttribute("style").equals("font-style: italic; text-decoration: underline;")) {
				fontStyle = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("Ending of isItalicUnderlineFontStylesDisplayed method");

		return fontStyle;
	}

	public boolean isBoldItalicFontStylesDisplayed() {
		log.info("Starting of isBoldItalicFontStylesDisplayed method");

		boolean fontStyle = false;
		try {
			if (txtFontStyle.getAttribute("style").equals("font-weight: bold; font-style: italic;")) {
				fontStyle = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("Ending of isBoldItalicFontStylesDisplayed method");

		return fontStyle;
	}

	public boolean isBoldItalicUnderlineFontStylesDisplayed() {
		log.info("Starting of isBoldItalicUnderlineFontStylesDisplayed method");

		boolean fontStyle = false;
		try {
			if (txtFontStyle.getAttribute("style")
					.equals("font-weight: bold; font-style: italic; text-decoration: underline;")) {
				fontStyle = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("Ending of isBoldItalicUnderlineFontStylesDisplayed method");

		return fontStyle;
	}

	public void clickOnBoldAndUnderLineTextFormattingButton() {
		log.info("Starting of clickOnBoldAndUnderLineTextFormattingButton method");

		hardWait(2);
		this.txtBoxDescriptionMsg.sendKeys(Keys.CONTROL + "a");

		elementClick(btnBold);
		elementClick(btnUnderline);

		log.info("Ending of clickOnBoldAndUnderLineTextFormattingButton method");
	}

	public void clickOnItalicAndUnderLineTextFormattingButton() {
		log.info("Starting of clickOnItalicAndUnderLineTextFormattingButton method");

		hardWait(2);
		this.txtBoxDescriptionMsg.sendKeys(Keys.CONTROL + "a");

		elementClick(btnItalic);
		elementClick(btnUnderline);
		hardWait(2);

		log.info("Ending of clickOnItalicAndUnderLineTextFormattingButton method");
	}

	public void clickOnBoldAndItalicTextFormattingButton() {
		log.info("Starting of clickOnBoldAndItalicTextFormattingButton method");

		hardWait(2);
		this.txtBoxDescriptionMsg.sendKeys(Keys.CONTROL + "a");

		elementClick(btnBold);
		elementClick(btnItalic);

		log.info("Ending of clickOnBoldAndItalicTextFormattingButton method");
	}

	public boolean isEventAnnouncementPopUpContains() {
		log.info("Starting of isEventAnnouncementPopUpContains method");

		boolean isEventAnnouncementPopUpContains = false;
		try {
			log.debug(isDisplayed(lblEventAnnouncement));
			log.debug(isDisplayed(lblCongrats));
			log.debug(isDisplayed(iconClose));
			log.debug(isDisplayed(lblEventCreated));

		} catch (Exception e) {
			log.debug("Failed: " + e.getMessage());
		}
		try {
			if (isDisplayed(lblEventAnnouncement) && isDisplayed(lblCongrats) && isDisplayed(iconClose)
					&& isDisplayed(lblEventCreated)) {
				isEventAnnouncementPopUpContains = true;
			}

		} catch (Exception e) {
			isEventAnnouncementPopUpContains = false;
		}

		log.info("Ending of isEventAnnouncementPopUpContains method");

		return isEventAnnouncementPopUpContains;
	}

	public String getEventAnnouncementText() {
		log.info("Starting of getEventAnnouncementText method");
		log.info("Ending of getEventAnnouncementText method");

		return getText(lblEventAnnouncement);
	}

	public String getCongratulationsText() {
		log.info("Starting of getCongratulationsText method");
		log.info("Ending of getCongratulationsText method");

		return getText(lblCongrats);
	}

	public String getEventCreatedText() {
		log.info("Starting of getEventCreatedText method");
		log.info("Ending of getEventCreatedText method");

		return getText(lblEventCreated);
	}

	public void setTitle(String title) {
		log.info("Starting of setTitle method");

		clickOnElement(txtTitle);
		this.txtTitle.sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);

		this.txtTitle.sendKeys(title+randomNumber(2));

		log.info("Ending of setTitle method");
	}

	public void clickOnCloseIcon() {
		log.info("Starting of clickOnCloseIcon method");

		clickOnElement(iconClose);

		log.info("Ending of clickOnCloseIcon method");
	}

	public void clickOnAnnouncementsTab() {
		log.info("Starting of clickOnAnnouncementsTab method");

		this.scrollDown(150);
		clickOnElement(tabAnnouncements);

		log.info("Ending of clickOnAnnouncementsTab method");
	}

	public boolean isAnnouncementCardContains() {
		log.info("Starting of isAnnouncementCardContains method");

		boolean isAnnouncementCardContains = false;
		try {
			log.debug(isDisplayed(btnEdit));
			log.debug(isDisplayed(lblAnnouncementTitle));
			log.debug(isDisplayed(lblAnnouncementSentTime));
			log.debug(isDisplayed(lblAnnouncementDesc));

		} catch (Exception e) {
			log.debug("Failed: " + e.getMessage());
		}
		try {
			if (isDisplayed(btnEdit) && isDisplayed(lblAnnouncementTitle) && isDisplayed(lblAnnouncementSentTime)
					&& isDisplayed(lblAnnouncementDesc)) {
				isAnnouncementCardContains = true;
			}

		} catch (Exception e) {
			isAnnouncementCardContains = false;
		}

		log.info("Ending of isAnnouncementCardContains method");

		return isAnnouncementCardContains;
	}

	public boolean isEditButtonListDisplayed() {
		log.info("Starting of isEditButtonListDisplayed method");

		boolean isEditButtonListDisplayed = false;
		try {
			if (lstBtnEdit.size() >= 1)
				isEditButtonListDisplayed = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("Ending of isEditButtonListDisplayed method");

		return isEditButtonListDisplayed;
	}

	public void clickOnBrowserBackButton() {
		log.info("Starting of clickOnBrowserBackButton method");

		this.driver.navigate().back();
		this.hardWait(3);

		log.info("Ending of clickOnBrowserBackButton method");
	}

	public void clickOnEditBuuton() {
		log.info("Starting of clickOnEditBuuton method");

		clickOnElement(btnEdit);

		log.info("Ending of clickOnEditBuuton method");
	}
}
