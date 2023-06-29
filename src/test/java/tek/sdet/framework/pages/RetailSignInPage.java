package tek.sdet.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailSignInPage extends BaseSetup{

	public RetailSignInPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(id = "email")
	public WebElement emailField;
	
	@FindBy(id = "password")
	public WebElement passwordField;
	
	@FindBy(xpath = "//button[text()='Login']")
	public WebElement loginButton;
	
	//create new user
	@FindBy(id = "newAccountBtn")
	public WebElement newAccountBttn;
	@FindBy(id = "nameInput")
	public WebElement nameInputField;
	@FindBy(id = "emailInput")
	public WebElement emailInputField;
	@FindBy(id = "passwordInput")
	public WebElement passwordInputField;
	@FindBy(id = "confirmPasswordInput")
	public WebElement confirmPasswordInputField;
	@FindBy(xpath = "//button[text()='Sign Up']")
	public WebElement signUpBttn;
	
}
