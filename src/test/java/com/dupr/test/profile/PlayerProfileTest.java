package com.dupr.test.profile;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.b2b.common.WebDriversEnum;
import com.dupr.pages.profile.EditProfilePage;
import com.dupr.test.CommonBaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("DUPR App")
@Feature("Player profile")
public class PlayerProfileTest extends CommonBaseTest {

	private static final Logger logger = Logger.getLogger(PlayerProfileTest.class.getName());
	private EditProfilePage editProfilePage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "validEmail", "validPassword" })
	public void initMethod(String browser, String siteURL, String email, String password) throws Exception {
		logger.info("Starting of initMethod in PlayerProfileTest");

		this.driver = super.getWebDriver(WebDriversEnum.EDIT_PROFILE_DRIVER);
		super.initCommonBaseTest(siteURL, email, password);

		this.editProfilePage = new EditProfilePage(this.driver);

		logger.info("Ending of initMethod in PlayerProfileTest");
	}

	@Test(priority = 1, description = "Verify profile icon or open settings functionality")
	@Description("Test case #1, Verify profile icon or open settings functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #1, Verify profile icon or open settings functionality")
	public void verifyProfileIconFunctionality() {
		logger.info("Starting of verifyProfileIconFunctionality method");

		editProfilePage.clickOnOpenSettingMenu();
		Assert.assertTrue(editProfilePage.isProfileDropDownContains());

		logger.info("Ending of verifyProfileIconFunctionality method");
	}

	@Test(priority = 2, description = "Verify Edit profile button functionality")
	@Description("Test case #2, Verify Edit profile button functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #2, Verify Edit profile button functionality")
	public void verifyEditProfileFunctionality() {
		logger.info("Starting of verifyEditProfileFunctionality method");

		editProfilePage.clickOnEditProfileButton();
		Assert.assertTrue(editProfilePage.isEditProfilePageContains());

		logger.info("Ending of verifyEditProfileFunctionality method");
	}

	@Test(priority = 3, description = "Verify fields under profile tab")
	@Description("Test case #3, Verify fields under profile tab")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #3, Verify fields under profile tab")
	public void verifyFieldsUnderProfileTab() {
		logger.info("Starting of verifyFieldsUnderProfileTab method");

		Assert.assertTrue(editProfilePage.isProfileTabContains());

		logger.info("Ending of verifyFieldsUnderProfileTab method");
	}

	@Test(priority = 4, description = "Verify Full Name text field without characters")
	@Description("Test case #4, Verify Full Name text field without characters")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #4, Verify Full Name text field without characters")
	public void verifyFullNameFieldWithoutCharacters() {
		logger.info("Starting of verifyFullNameFieldWithoutCharacters method");

		editProfilePage.setFullName("");

		String validationText = editProfilePage.getFullNameValidationText();
		Assert.assertEquals(validationText, expectedAssertionsProp.getProperty("first.name.required.validation"));

		logger.info("Ending of verifyFullNameFieldWithoutCharacters method");
	}

	@Test(priority = 5, description = "Verify Full Name text field with special characters")
	@Description("Test case #5, Verify Full Name text field with special characters")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #5, Verify Full Name text field with special characters")
	public void verifyFullNameFieldWithSpecialCharacters() {
		logger.info("Starting of verifyFullNameFieldWithSpecialCharacters method");

		editProfilePage.setFullName(testDataProp.getProperty("full.name.with.special.characters"));

		String validationText = editProfilePage.getFullNameValidationText();
		Assert.assertEquals(validationText, expectedAssertionsProp.getProperty("fullname.number.validation"));

		logger.info("Ending of verifyFullNameFieldWithSpecialCharacters method");
	}

	@Test(priority = 6, description = "Verify Full Name text field with white spaces")
	@Description("Test case #6, Verify Full Name text field with white spaces")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #6, Verify Full Name text field with white spaces")
	public void verifyFullNameFieldWithWhiteSpaces() {
		logger.info("Starting of verifyFullNameFieldWithWhiteSpaces method");

		editProfilePage.setFullName(testDataProp.getProperty("incorrect.value"));

		String validationText = editProfilePage.getFullNameValidationText();
		Assert.assertEquals(validationText, expectedAssertionsProp.getProperty("only.white.spaces.are.not.allowed"));

		logger.info("Ending of verifyFullNameFieldWithWhiteSpaces method");
	}

	@Test(priority = 7, description = "Verify Full Name text field with more than max characters")
	@Description("Test case #7, Verify Full Name text field with more than max characters")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #7, Verify Full Name text field with more than max characters")
	public void verifyFullNameFieldWithMoreThanMaxCharacters() {
		logger.info("Starting of verifyFullNameFieldWithMoreThanMaxCharacters method");

		editProfilePage.setFullName(editProfilePage.randomAlphabet(52));
		editProfilePage.hardWait(2);

		logger.info("Ending of verifyFullNameFieldWithMoreThanMaxCharacters method");
	}

	@Test(priority = 8, description = "Verify address field with only country name")
	@Description("Test case #8, Verify address field with only country name")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #8, Verify address field with only country name")
	public void verifyAddressFieldWithCountryName() {
		logger.info("Starting of verifyAddressFieldWithCountryName method");

		driver.navigate().refresh();

		Assert.assertFalse(editProfilePage.isSaveEnabled());

		editProfilePage.setAddress(testDataProp.getProperty("location"), testDataProp.getProperty("location"));

		Assert.assertTrue(editProfilePage.isSaveEnabled());

		editProfilePage.clickOnSaveButton();

		Assert.assertTrue(editProfilePage.isUpdateProfilePopupContains());

		editProfilePage.clickOnOkButton();

		logger.info("Ending of verifyAddressFieldWithCountryName method");
	}

	@Test(priority = 9, description = "Verify address field with state and country name")
	@Description("Test case #9, Verify address field with state and country name")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #9, Verify address field with state and  country name")
	public void verifyAddressFieldWithStateAndCountryName() {
		logger.info("Starting of verifyAddressFieldWithStateAndCountryName method");

		editProfilePage.scrollDown(-700);
		editProfilePage.setAddress(testDataProp.getProperty("state.address"),
				testDataProp.getProperty("state.country.address"));

		editProfilePage.clickOnSaveButton();

		Assert.assertEquals(editProfilePage.getCongratulationsLabel(),
				expectedAssertionsProp.getProperty("success.message.congratulation"));

		editProfilePage.clickOnOkButton();

		editProfilePage.hardWait(2);
		Assert.assertFalse(editProfilePage.isSaveEnabled());

		logger.info("Ending of verifyAddressFieldWithStateAndCountryName method");
	}

	@Test(priority = 10, description = "Verify Birth Date field with current date")
	@Description("Test case #10, Verify Birth Date field with current date")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #10, Verify Birth Date field with current date")
	public void verifyBirthDateWithCurrentDate() {
		logger.info("Starting of verifyBirthDateWithCurrentDate method");

		editProfilePage.scrollDown(-650);
		editProfilePage.setCurrentDateAsBirthDate();

		String birthdateValidation = editProfilePage.getBirthDateValidationText();
		Assert.assertEquals(birthdateValidation,
				expectedAssertionsProp.getProperty("minimum.age.two.years.validation"));

		logger.info("Ending of verifyBirthDateWithCurrentDate method");
	}

	@Test(priority = 11, description = "Verify Birth Date field with less than minimum age")
	@Description("Test case #11, Verify Birth Date field with less than minimum age")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #11, Verify Birth Date field with less than minimum age")
	public void verifyBirthDateWithLessThanMinimumAge() {
		logger.info("Starting of verifyBirthDateWithLessThanMinimumAge method");

		editProfilePage.scrollDown(-650);
		editProfilePage.setBirthDateWithLessthanMinimumAge();

		String birthdateValidation = editProfilePage.getBirthDateValidationText();
		Assert.assertEquals(birthdateValidation,
				expectedAssertionsProp.getProperty("minimum.age.two.years.validation"));

		logger.info("Ending of verifyBirthDateWithLessThanMinimumAge method");
	}

	@Test(priority = 12, description = "Verify Birth Date field with minimum age")
	@Description("Test case #12, Verify Birth Date field with minimum age")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #12, Verify Birth Date field with minimum age")
	public void verifyBirthDateWithMinimumAge() {
		logger.info("Starting of verifyBirthDateWithMinimumAge method");

		editProfilePage.scrollDown(-650);
		editProfilePage.setBirthDateMinimumAge();
		editProfilePage.hardWait(3);

		Assert.assertTrue(editProfilePage.isReviewDUPRPoliciesPopupContains());

		editProfilePage.hardWait(5);
		editProfilePage.clickOnReviewPoliciesCheckBox();

		Assert.assertTrue(editProfilePage.isOkButtonEnabled());

		editProfilePage.clickOnOKButton();
		editProfilePage.clickOnSaveButton();

		Assert.assertEquals(editProfilePage.getCongratulationsLabel(),
				expectedAssertionsProp.getProperty("success.message.congratulation"));

		editProfilePage.clickOnOkButton();

		logger.info("Ending of verifyBirthDateWithMinimumAge method");
	}

	@Test(priority = 13, description = "Verify full name ,address and birth date fields with valid data")
	@Description("Test case #13, Verify full name ,address and birth date fields with valid data")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #13, Verify full name ,address and birth date fields with valid data")
	public void verifyFieldsWithValidData() {
		logger.info("Starting of verifyFieldsWithValidData method");

		editProfilePage.scrollDown(-700);
		editProfilePage.setFullName(testDataProp.getProperty("player.name"));
		editProfilePage.setAddress(testDataProp.getProperty("location.city.name"),
				testDataProp.getProperty("city.state.country.address"));
		editProfilePage.setBirthDate();
		editProfilePage.clickOnSaveButton();

		Assert.assertEquals(editProfilePage.getCongratulationsLabel(),
				expectedAssertionsProp.getProperty("success.message.congratulation"));

		editProfilePage.clickOnOkButton();

		Assert.assertFalse(editProfilePage.isSaveEnabled());

		logger.info("Ending of verifyFieldsWithValidData method");
	}

	@Test(priority = 14, description = "Verify DUPR ID field")
	@Description("Test case #14, Verify DUPR ID field")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test case #14, Verify DUPR ID field")
	public void verifyDUPRIDField() {
		logger.info("Starting of verifyDUPRIDField method");

		Assert.assertFalse(editProfilePage.isDUPRIDAutoPopulated());

		logger.info("Ending of verifyDUPRIDField method");
	}

	@Test(priority = 15, description = "Verify Gender drop down functionality")
	@Description("Test case #15, Verify Gender drop down functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #15, Verify Gender drop down functionality")
	public void verifyGenderDropdown() {
		logger.info("Starting of verifyGenderDropdown method");

		editProfilePage.scrollDown(-700);
		editProfilePage.clickOnGenderDropDown();
		editProfilePage.hardWait(3);
		editProfilePage.clickOnGenderDropDownListOption();

		Assert.assertTrue(editProfilePage.isSaveEnabled());
		editProfilePage.clickOnSaveButton();
		editProfilePage.clickOnOkButton();

		logger.info("Ending of verifyGenderDropdown method");
	}

	@Test(priority = 16, description = "Verify default rating functionality")
	@Description("Test case #16, Verify default rating functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #16, Verify default rating functionality")
	public void verifyDefaultRating() {
		logger.info("Starting of verifyDefaultRating method");

		editProfilePage.scrollDown(-700);
		editProfilePage.clickOnDefaultRatingRadioButtons();

		Assert.assertTrue(editProfilePage.isSaveEnabled());

		editProfilePage.clickOnSaveButton();
		editProfilePage.clickOnOkButton();

		logger.info("Ending of verifyDefaultRating method");
	}

	@Test(priority = 17, description = "Verify phone number field with invalid phone number")
	@Description("Test case #17,Verify phone number field with invalid phone number")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #17, Verify phone number field with invalid phone number")
	public void verifyPhoneNumberWithInvalidPhoneNumber() {
		logger.info("Starting of verifyPhoneNumberWithInvalidPhoneNumber method");

		editProfilePage.scrollDown(-500);
		editProfilePage.clickOnCountryCodePhoneNumber(testDataProp.getProperty("country.name.for.phone.number"));
		editProfilePage.hardWait(3);
		editProfilePage.clearPhoneNumber();
		editProfilePage.hardWait(3);
		editProfilePage.setValidPhoneNumber(testDataProp.getProperty("invalid.phone.number"));
		editProfilePage.clickOnSaveButton();
		editProfilePage.clickOnOkButton();
		editProfilePage.hardWait(3);
		Assert.assertTrue(editProfilePage.isVeriyYourMobileNumberPopupContains());

		editProfilePage.setOTP(testDataProp.getProperty("valid.otp"));
		editProfilePage.clickOnVerifyNowButton();

		String otpValidationText = editProfilePage.getOTPValidationText();
		editProfilePage.hardWait(5);
		Assert.assertTrue(otpValidationText.equals(expectedAssertionsProp.getProperty("mobile.successfully.verfied"))
				|| otpValidationText.equals(expectedAssertionsProp.getProperty("incorrect.or.expired.passcode")));

		editProfilePage.clickOnCloseIcon();
		logger.info("Ending of verifyPhoneNumberWithInvalidPhoneNumber method");
	}

	@Test(priority = 18, description = "Verify phone number field with valid phone number")
	@Description("Test case #18, Verify phone number field with valid phone number")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #18, Verify phone number field with valid phone number")
	public void verifyPhoneNumberWithValidPhoneNumber() {
		logger.info("Starting of verifyPhoneNumberWithValidPhoneNumber method");

		editProfilePage.scrollDown(-400);
		editProfilePage.clickOnCountryCodePhoneNumber(testDataProp.getProperty("country.name.for.phone.number"));
		editProfilePage.hardWait(3);
		editProfilePage.clearPhoneNumber();
		editProfilePage.hardWait(4);
		editProfilePage.setValidPhoneNumber(testDataProp.getProperty("invalid.phone.number"));
		editProfilePage.hardWait(2);
		editProfilePage.clickOnSaveButton();
		editProfilePage.hardWait(2);

		Assert.assertEquals(editProfilePage.getCongratulationsLabel(),
				expectedAssertionsProp.getProperty("success.message.congratulation"));

		editProfilePage.clickOnOkButton();
		editProfilePage.clickOnResendCodeButton();

		Assert.assertEquals(editProfilePage.getOTPResendValidationText(),
				expectedAssertionsProp.getProperty("otp.was.sent.to.your.number"));

		editProfilePage.setOTP(testDataProp.getProperty("valid.otp"));
		editProfilePage.clickOnVerifyNowButton();

		editProfilePage.hardWait(2);
		Assert.assertEquals(editProfilePage.getMobileVerifiedText(),
				expectedAssertionsProp.getProperty("mobile.successfully.verfied"));

		editProfilePage.clickOnCloseIcon();

		Assert.assertTrue(editProfilePage.isVerifiedRightMarkIconDisplayed());

		logger.info("Ending of verifyPhoneNumberWithValidPhoneNumber method");
	}

	@Test(priority = 19, description = "Verify Dominant Hand drop down")
	@Description("Test case #19,Verify Dominant Hand drop down")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #19, Verify Dominant Hand drop down")
	public void verifyDominantHandDropdown() {
		logger.info("Starting of verifyDominantHandDropdown method");

		editProfilePage.clickOnDominantHandDropDownListOption();
		editProfilePage.hardWait(3);

		Assert.assertTrue(editProfilePage.isSaveEnabled());
		editProfilePage.clickOnSaveButton();

		editProfilePage.hardWait(3);
		editProfilePage.clickOnOkButton();

		logger.info("Ending of verifyDominantHandDropdown method");
	}

	@Test(priority = 20, description = "Verify Paddle Brand,Shoe Brand,Apparel Brand and Preferred Ball fields ")
	@Description("Test case #20, Verify Paddle Brand,Shoe Brand,Apparel Brand and Preferred Ball fields ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #20, Verify Paddle Brand,Shoe Brand,Apparel Brand and Preferred Ball fields ")
	public void verifyPreferencesSectionFields() {
		logger.info("Starting of verifyPreferencesSectionFields method");

		editProfilePage.setPaddleBrand(testDataProp.getProperty("brand"));
		editProfilePage.setShoeBrand(testDataProp.getProperty("brand"));
		editProfilePage.setApparelBrand(testDataProp.getProperty("brand"));
		editProfilePage.setPreferredBall(testDataProp.getProperty("brand"));

		editProfilePage.clickOnSaveButton();
		editProfilePage.hardWait(3);
		editProfilePage.clickOnOkButton();

		logger.info("Ending of verifyPreferencesSectionFields method");
	}

	@Test(priority = 21, description = "Verify Preferred Side drop down field ")
	@Description("Test case #21,Verify Preferred Side drop down field")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test case #21, Verify Preferred Side drop down field")
	public void verifyPrefferedSideDropdown() {
		logger.info("Starting of verifyPrefferedSideDropdown method");

		editProfilePage.clickOnPreferredSideDropDownListOption();
		editProfilePage.clickOnSaveButton();
		editProfilePage.hardWait(3);
		editProfilePage.clickOnOkButton();

		logger.info("Ending of verifyPrefferedSideDropdown method");
	}

	@AfterClass
	public void quitDriver() {

		try {

			if (this.driver != null) {
				Thread.sleep(5000);
				this.quitDriver(this.driver, WebDriversEnum.EDIT_PROFILE_DRIVER);

				logger.info("Driver quit successfully");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
