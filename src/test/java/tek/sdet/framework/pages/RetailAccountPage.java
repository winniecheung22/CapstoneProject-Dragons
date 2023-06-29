package tek.sdet.framework.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailAccountPage extends BaseSetup{
	
	public RetailAccountPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(id="profileImage")
	public WebElement profileImage;
	@FindBy(id="nameInput")
	public WebElement nameInput;
	@FindBy(id="personalPhoneInput")
	public WebElement phoneInput;
	@FindBy(id="personalUpdateBtn") 
	public WebElement personalUpdateButton;
	@FindBy(xpath = "//div[text()='Personal Information Updated Successfully']")
	public WebElement personalInfoUpdatedSuccessMessage;
	
	
	//Locator for new payment method
	@FindBy(xpath = "//p[text()='Add a payment method']")
	public WebElement addAPaymentMethodLink;
	@FindBy(id = "cardNumberInput")
	public WebElement cardNumInputField;
	@FindBy (id = "nameOnCardInput")
	public WebElement nameOfTheCardInputField;
	@FindBy (id = "expirationMonthInput")
	public WebElement expirationMonthInputField;
	@FindBy (id = "expirationYearInput")
	public WebElement expirationYearInputField;
	@FindBy (id = "securityCodeInput")
	public WebElement securityCodeInputField;
	@FindBy(id ="paymentSubmitBtn")
	public WebElement addYourCardBttn;
	@FindBy(xpath ="//div[text()='Payment Method added Sucessfully']")
	public WebElement paymentMethodAddedSuccessMessage;
	
	//edit payment method
	@FindBy (xpath = "//div[@class='account__payment']//button[text()='Edit']")
	public WebElement creditDebitCardEditBttn;
	@FindBy(xpath ="//div[text()='Payment Method updated Successfully']")
	public WebElement paymentMethodUpdateSuccessMssg;
	
	/*public void clearCreditDebitCardInfo() {
		cardNumInputField.clear();
		nameOfTheCardInputField.clear();
		clearTextUsingSendKeys(securityCodeInputField);
	}*/
	/*
	@FindBy(xpath ="//div[text()='Order Placed Successfully']")
	public WebElement orderPlaceSuccessfullyMssg;
	@FindBy(xpath ="//img[@alt='Apex Legends' - 1,000 Apex Coins]")
	public WebElement apexLegendsItem;*/
	
	
	
	
	
	
	//remove payment method
	@FindBy(xpath = "//p[@class='account__payment__sub-text']")
	public List<WebElement> cardEndingNum;
	
	@FindBy(xpath = "//button[text()='remove']")
	public WebElement removeCardBttn;
	
	//add address
	@FindBy(xpath ="//div[@class='account__address-new-wrapper']")
	public WebElement addAddressLink;
	@FindBy (id = "countryDropdown")
	public WebElement countryDropdown;
	@FindBy (id = "fullNameInput")
	public WebElement addressNameInputField;
	@FindBy (id = "phoneNumberInput")
	public WebElement addressPhoneInputField;
	@FindBy (id = "streetInput")
	public WebElement addressStreetInputField;
	@FindBy (id = "apartmentInput")
	public WebElement addressAptInputField;
	@FindBy (id = "cityInput")
	public WebElement addressCityInputField;
	@FindBy (name = "state")
	public WebElement addressStateInputField;
	@FindBy (id = "zipCodeInput")
	public WebElement addressZipCodeInputField;
	@FindBy (id = "addressBtn")
	public WebElement addressAddAddressBttn;
	@FindBy (xpath = "//div[text()='Address Added Successfully']")
	public WebElement addressAddedSuccessfullyMssg;
	
	//account edit
	
	@FindBy(xpath = "//button[text()='Edit']")
	public WebElement editAccountAddressBttn;
	@FindBy (xpath = "//div[text()='Address Updated Successfully']")
	public WebElement addressUpdateSuccessfullyMssg;
	
	//remove address
	@FindBy(xpath = "//button[text()='Remove']")
	public WebElement removeAccountAddressBttn;
	
}
