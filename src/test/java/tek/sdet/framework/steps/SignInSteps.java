package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class SignInSteps extends CommonUtility {

	POMFactory factory = new POMFactory();
	//syntax 
	//@annotation("Value from step")
	//public void methodName(){}
	@Given("User is on retail website")
	public void userIsOnRetailWebsite() {
		
		String actualTitle= getTitle();
		String expectedTitle= "React App";
		Assert.assertEquals(actualTitle, expectedTitle);
		Assert.assertTrue(isElementDisplayed(factory.homePage().retailLogo));
		logger.info("user is on retail website");
	}
	@When("User click on Sign in option")
	public void userClickOnSignInOption() {
	  click(factory.homePage().signInOption);
	  logger.info("user clicked on Sign In option");
	}
	@And("User enter email {string} and password {string}")
	public void userEnterEmailAndPassword(String emailValue, String passWordValue) {
	   sendText(factory.signInPage().emailField,emailValue);
	   sendText(factory.signInPage().passwordField,passWordValue);
	   logger.info("user entered email and password");
	}
	@When("User click on login button")
	public void userClickOnLoginButton() {
	  click(factory.signInPage().loginButton);
	  logger.info("user clicked on login button");
	}
	@Then("User should be logged in into Account")
	public void userShouldBeLoggedInIntoAccount() {
	   waitTillPresence(factory.homePage().accountOption);
	   
	   Assert.assertTrue(isElementDisplayed(factory.homePage().accountOption));
	   Assert.assertTrue(isElementDisplayed(factory.homePage().ordersOption));
	   Assert.assertTrue(isElementDisplayed(factory.homePage().logOutOption));
	   logger.info("user logged in into account");
	}
	
	//create new account
	@When("User click on Create New Account button")
	public void userClickOnCreateNewAccountButton() {
	   click(factory.signInPage().newAccountBttn);
	   logger.info("Create New Account button was clicked successfully");
	}
	@When("User fill the signUp information with below data")
	public void userFillTheSignUpInformationWithBelowData(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> newUserInfo = dataTable.asMaps(String.class, String.class);
		sendText(factory.signInPage().nameInputField, newUserInfo.get(0).get("name"));
		sendText(factory.signInPage().emailInputField, newUserInfo.get(0).get("email"));
		sendText(factory.signInPage().passwordInputField, newUserInfo.get(0).get("password"));
		sendText(factory.signInPage().confirmPasswordInputField, newUserInfo.get(0).get("confirmPassword"));
		logger.info("User entered new account information successfully");
	}
	@When("User click on SignUp button")
	public void userClickOnSignUpButton() {
	    click(factory.signInPage().signUpBttn);
	    logger.info("Sign Up button was clicked successfully");
	}
	@Then("User should be logged into account page")
	public void userShouldBeLoggedIntoAccountPage() {
	    
	}
	
}
