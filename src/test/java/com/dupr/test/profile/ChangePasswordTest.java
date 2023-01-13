package com.dupr.test.profile;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.profile.ChangePasswordPage;
import com.dupr.pages.profile.ProfilePicturePage;
import com.dupr.test.CommonBaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("DUPR App")
@Feature("Change password")
public class ChangePasswordTest extends CommonBaseTest {

	private static final Logger logger = Logger.getLogger(ChangePasswordTest.class.getName());

	private ChangePasswordPage changePasswordPage = null;
	private ProfilePicturePage profilePicturePage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "validEmail", "validPassword" })
	public void initMethod(String browser, String siteURL, String email, String password) throws Exception {
		logger.info("Starting of initMethod in ChangePasswordTest");

		this.driver = super.getWebDriver(WebDriversEnum.CHANGE_PASSWORD_DRIVER);
		super.initCommonBaseTest(siteURL, email, password);

		this.changePasswordPage = new ChangePasswordPage(this.driver);
		this.profilePicturePage = new ProfilePicturePage(this.driver);

		logger.info("Ending of initMethod in ChangePasswordTest");
	}

	@Test(priority = 1, description = "Verify Security tab in edit profile page", groups = "sanity")
	@Description("Test case #1, Verify Security tab in edit profile page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify Security tab in edit profile page")
	public void verifySecurityTab() {
		logger.info("Starting of verifySecurityTab method");

		profilePicturePage.clickOnOpenSettingsMenu();
		profilePicturePage.clickOnEditProfileButton();
		changePasswordPage.clickOnSecurityTab();

		Assert.assertTrue(changePasswordPage.isChangePasswordPageContains());
		Assert.assertTrue(changePasswordPage.isSaveButtonInDisabledDisplayed());

		logger.info("Ending of verifySecurityTab method");
	}

	@Parameters({ "validPassword" })
	//@Test(priority = 2, description = "Verify change password with valid data ", groups = "sanity")
	@Description("Test case #2, Verify change password with valid data ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify change password with valid data ")
	public void verifyChangePasswordWithValidData(String validPassword) {
		logger.info("Starting of verifyChangePasswordWithValidData method");

		changePasswordPage.setOldPassword(validPassword);
		changePasswordPage.setNewPassword(testDataProp.getProperty("new.password"));
		changePasswordPage.setConfirmPassword(testDataProp.getProperty("new.password"));
		changePasswordPage.clickOnSaveButton();

		Assert.assertTrue(changePasswordPage.isUpdateProfilePopupForSuccessContains());

		changePasswordPage.clickOnOkButton();

		logger.info("Ending of verifyChangePasswordWithValidData method");
	}

	@Test(priority = 3, description = "Verify old password field with less than  minimum characters", groups = "sanity")
	@Description("Test case #3, Verify old password field with less than  minimum characters")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify old password field with less than  minimum characters")
	public void verifyOldPasswordWithLessThanMinimumCharacters() {
		logger.info("Starting of verifyOldPasswordWithLessThanMinimumCharacters method");

		changePasswordPage.hardWait(2);
		changePasswordPage.setOldPassword(testDataProp.getProperty("invalid.email"));

		changePasswordPage.hardWait(2);
		String oldPassworValidationText = changePasswordPage.getOldPasswordValidationText();
		Assert.assertEquals(oldPassworValidationText, expectedAssertionsProp.getProperty("password.length.validation"));

		logger.info("Ending of verifyOldPasswordWithLessThanMinimumCharacters method");
	}

	@Test(priority = 4, description = "Verify old password field without entering any data ", groups = "sanity")
	@Description("Test case #4, Verify old password field without entering any data ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify old password field without entering any data ")
	public void verifyOldPasswordAsEmpty() {
		logger.info("Starting of verifyOldPasswordAsEmpty method");

		driver.navigate().refresh();
		changePasswordPage.clickOnSecurityTab();
		changePasswordPage.setNewPassword(testDataProp.getProperty("new.password"));
		changePasswordPage.setConfirmPassword(testDataProp.getProperty("new.password"));
		changePasswordPage.clickOnSaveButton();

		String oldPassworValidationText = changePasswordPage.getOldPasswordValidationText();
		Assert.assertEquals(oldPassworValidationText,
				expectedAssertionsProp.getProperty("password.required.validation"));

		logger.info("Ending of verifyOldPasswordAsEmpty method");
	}

	@Test(priority = 5, description = "Verify old password field with wrong password", groups = "sanity")
	@Description("Test case #5, Verify old password field with wrong  password")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify old password field with wrong  password")
	public void verifyOldPasswordByWrongPassword() {
		logger.info("Starting of verifyOldPasswordByWrongPassword method");

		changePasswordPage.setOldPassword(testDataProp.getProperty("wrong.old.password"));
		changePasswordPage.setNewPassword(testDataProp.getProperty("new.password"));
		changePasswordPage.setConfirmPassword(testDataProp.getProperty("new.password"));
		changePasswordPage.clickOnSaveButton();

		Assert.assertTrue(changePasswordPage.isUpdateProfilePopupForFailureContains());

		changePasswordPage.clickOnOkButton();

		String invalidPasswordText = changePasswordPage.getInvalidPasswordValidationText();
		Assert.assertEquals(invalidPasswordText, expectedAssertionsProp.getProperty("password.invalid.validation"));

		logger.info("Ending of verifyOldPasswordByWrongPassword method");
	}

	@Parameters({ "validPassword" })
	@Test(priority = 6, description = "Verify new password field with less than minimum characters", groups = "sanity")
	@Description("Test case #6, Verify new password field with less than minimum characters")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify new password field with less than minimum characters")
	public void verifyNewPasswordWithLessThanMinimumCharacters(String validPassword) {
		logger.info("Starting of verifyNewPasswordWithLessThanMinimumCharacters method");

		driver.navigate().refresh();
		changePasswordPage.clickOnSecurityTab();
		changePasswordPage.setOldPassword(validPassword);
		changePasswordPage.setNewPassword(testDataProp.getProperty("invalid.email"));

		String newPasswordValidationText = changePasswordPage.getNewPasswordValidationText();
		Assert.assertEquals(newPasswordValidationText,
				expectedAssertionsProp.getProperty("password.length.validation"));

		logger.info("Ending of verifyNewPasswordWithLessThanMinimumCharacters method");
	}

	@Parameters({ "validPassword" })
	@Test(priority = 7, description = "Verify new password field with only numbers", groups = "sanity")
	@Description("Test case #7, Verify new password field with only numbers")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Verify new password field with only numbers")
	public void verifyNewPasswordWithNumbers(String validPassword) {
		logger.info("Starting of verifyNewPasswordWithNumbers method");

		changePasswordPage.setOldPassword(validPassword);
		changePasswordPage.setNewPassword(testDataProp.getProperty("full.name.with.numbers"));

		String newPasswordValidationText = changePasswordPage.getNewPasswordValidationText();
		Assert.assertEquals(newPasswordValidationText,
				expectedAssertionsProp.getProperty("password.instruction.validation.message"));

		logger.info("Ending of verifyNewPasswordWithNumbers method");
	}

	@Parameters({ "validPassword" })
	@Test(priority = 8, description = "Verify new password field with only special characters", groups = "sanity")
	@Description("Test case #8, Verify new password field with only special characters")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Verify new password field with only special characters")
	public void verifyNewPasswordWithSpecialCharacters(String validPassword) {
		logger.info("Starting of verifyNewPasswordWithSpecialCharacters method");

		changePasswordPage.setOldPassword(validPassword);
		changePasswordPage.setNewPassword(testDataProp.getProperty("full.name.with.special.characters"));

		String newPasswordValidationText = changePasswordPage.getNewPasswordValidationText();
		Assert.assertEquals(newPasswordValidationText,
				expectedAssertionsProp.getProperty("password.instruction.validation.message"));

		logger.info("Ending of verifyNewPasswordWithSpecialCharacters method");
	}

	@Test(priority = 9, description = "Verify Old password field with white spaces ", groups = "sanity")
	@Description("Test case #9, Verify Old password field with white spaces")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9, Verify Old password field with white spaces ")
	public void verifyOldPasswordWithWhiteSpaces() {
		logger.info("Starting of verifyOldPasswordWithWhiteSpaces method");

		driver.navigate().refresh();
		changePasswordPage.clickOnSecurityTab();
		changePasswordPage.setOldPassWordWithWhiteSpaces(testDataProp.getProperty("spaces.value"));

		String oldPasswordValidationText = changePasswordPage.getOldPasswordValidationText();
		Assert.assertEquals(oldPasswordValidationText,
				expectedAssertionsProp.getProperty("white.space.password.validation"));

		logger.info("Ending of verifyOldPasswordWithWhiteSpaces method");
	}

	@Parameters({ "validPassword" })
	@Test(priority = 10, description = "Verify new  password field with white spaces", groups = "sanity")
	@Description("Test case #10, Verify new password field with white spaces")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #10, Verify new password field with white spaces")
	public void verifyNewPasswordWithWhiteSpaces(String validPassword) {
		logger.info("Starting of verifyNewPasswordWithWhiteSpaces method");

		changePasswordPage.setOldPassword(validPassword);
		changePasswordPage.setNewPasswordWithWhiteSpaces(testDataProp.getProperty("spaces.value"));

		String newPasswordValidationText = changePasswordPage.getNewPasswordValidationText();
		Assert.assertEquals(newPasswordValidationText,
				expectedAssertionsProp.getProperty("white.space.password.validation"));

		logger.info("Ending of verifyNewPasswordWithWhiteSpaces method");
	}

	@Parameters({ "validPassword" })
	@Test(priority = 11, description = "Verify validation message shown when Maximum characters exceeded at  New Password field", groups = "sanity")
	@Description("Test case #11,Verify validation message shown when Maximum characters exceeded at  New Password field")
	@Severity(SeverityLevel.NORMAL)
	public void verifyNewPasswordWithMoreThanMaximumCharacters(String validPassword) {
		logger.info("Starting of verifyNewPasswordWithMoreThanMaximumCharacters method");

		changePasswordPage.setOldPassword(validPassword);
		changePasswordPage.setNewPassword(testDataProp.getProperty("more.than.max.characters.in.new.password"));

		String newPasswordValidationText = changePasswordPage.getNewPasswordValidationText();
		Assert.assertEquals(newPasswordValidationText,
				expectedAssertionsProp.getProperty("password.mustnot.exceed.max.characters"));

		logger.info("Ending of verifyNewPasswordWithMoreThanMaximumCharacters method");
	}

	@Parameters({ "validPassword" })
	@Test(priority = 12, description = "Verify confirm password functionality with unmatched data", groups = "sanity")
	@Description("Test case #12,Verify confirm password functionality with unmatched data")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #12,Verify confirm password functionality with unmatched data")
	public void verifyConfirmPasswordWithUnmatchedData(String validPassword) {
		logger.info("Starting of verifyConfirmPasswordWithUnmatchedData method");

		changePasswordPage.setOldPassword(validPassword);
		changePasswordPage.setNewPassword(testDataProp.getProperty("new.password"));
		changePasswordPage.setConfirmPassword(testDataProp.getProperty("password.unmatched"));

		String confirmPasswordValidationText = changePasswordPage.getConfirmPasswordValidationText();
		Assert.assertEquals(confirmPasswordValidationText,
				expectedAssertionsProp.getProperty("please.enter.matching.password"));

		logger.info("Ending of verifyConfirmPasswordWithUnmatchedData method");
	}

	@Parameters({ "validPassword" })
	@Test(priority = 13, description = "Verify eye icon  functionality", groups = "sanity")
	@Description("Test case #13,Verify eye icon  functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #13,Verify eye icon  functionality")
	public void VerifyEyeIcon(String validPassword) {
		logger.info("Starting of VerifyEyeIcon method");

		driver.navigate().refresh();
		changePasswordPage.clickOnSecurityTab();
		changePasswordPage.setOldPassword(validPassword);
		changePasswordPage.clickOnEyeIcon();

		Assert.assertTrue(changePasswordPage.isEyeIconInHiddenMode());

		logger.info("Ending of VerifyEyeIcon method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.CHANGE_PASSWORD_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}
}
