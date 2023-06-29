package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class RetailAccountSteps extends CommonUtility{
	POMFactory factory = new POMFactory();
	
	//update user info
	@When("User click on Account option")
	public void userClickOnAccountOption() {
		click(factory.homePage().accountOption);
		logger.info("user clicked on Account option");
	 
	}
	@When("User update Name {string} and Phone {string}")
	public void userUpdateNameAndPhone(String nameValue, String phoneValue) {
		clearTextUsingSendKeys(factory.accountPage().nameInput);
		sendText(factory.accountPage().nameInput,nameValue);
		clearTextUsingSendKeys(factory.accountPage().phoneInput);
		sendText(factory.accountPage().phoneInput,phoneValue);
		logger.info("user updated the name and the phone value");

	}
	@When("User click on Update button")
	public void userClickOnUpdateButton() {
		click(factory.accountPage().personalUpdateButton);
		logger.info("user clicked on update button");
	    
	}
	@Then("user profile information should be updated")
	public void userProfileInformationShouldBeUpdated() {
		waitTillPresence(factory.accountPage().personalInfoUpdatedSuccessMessage);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().personalInfoUpdatedSuccessMessage));
		logger.info("user profile information updated");
	}
	
	
	//add new payment 
	@When("User click on Add a payment method link")
	public void userClickOnAddAPaymentMethodLink() {
		click(factory.accountPage().addAPaymentMethodLink);
		logger.info("user successfully click on add payment method link");
	}
	@When("User fill Debit or credit card information")
	public void userFillDebitOrCreditCardInformation(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> paymentInfo = dataTable.asMaps(String.class, String.class);
		sendText(factory.accountPage().cardNumInputField, paymentInfo.get(0).get("cardNumber"));
		sendText(factory.accountPage().nameOfTheCardInputField, paymentInfo.get(0).get("nameOnCard"));
		selectByVisibleText(factory.accountPage().expirationMonthInputField, paymentInfo.get(0).get("expirationMonth"));
		selectByVisibleText(factory.accountPage().expirationYearInputField, paymentInfo.get(0).get("expirationYear"));
		sendText(factory.accountPage().securityCodeInputField, paymentInfo.get(0).get("securityCode"));
		logger.info("User entered card payment information successfully");
	}
	@When("User click on Add your card button")
	public void userClickOnAddYourCardButton() {
		click(factory.accountPage().addYourCardBttn);
		logger.info("Add your card button was clicked successfully");
	}
	@Then("a message should be displayed {string}") 
	public void aMessageShouldBeDisplayed(String expectedMssg) {
		if(expectedMssg.contains("Payment Method added Sucessfully")) {
			waitTillPresence(factory.accountPage().paymentMethodAddedSuccessMessage);
			Assert.assertEquals(expectedMssg, factory.accountPage().paymentMethodAddedSuccessMessage.getText());
			logger.info(expectedMssg + " is displayed");
	
		}else if(expectedMssg.contains("Address Added")) {
			waitTillPresence(factory.accountPage().addressAddedSuccessfullyMssg);
			Assert.assertEquals(expectedMssg, factory.accountPage().addressAddedSuccessfullyMssg.getText());
			logger.info(expectedMssg + "is displayed");
		} else if(expectedMssg.contains("Payment Method updated")) {
			waitTillPresence(factory.accountPage().paymentMethodAddedSuccessMessage);
			Assert.assertEquals(expectedMssg, factory.accountPage().paymentMethodAddedSuccessMessage);
			logger.info("Payment Method Updated Mssg was Verified Successfully");

		}else if(expectedMssg.contains("Address Updated")) {
			waitTillPresence(factory.accountPage().addressUpdateSuccessfullyMssg);
			Assert.assertEquals(expectedMssg, factory.accountPage().addressUpdateSuccessfullyMssg.getText());
			logger.info(expectedMssg + "is displayed");
		}
		//Retail Order Page
		else if(expectedMssg.contains("Order Placed")) {
			waitTillPresence(factory.retailOrder().orderPlaceSuccessfullyMssg);
			Assert.assertEquals(expectedMssg, factory.retailOrder().orderPlaceSuccessfullyMssg.getText() );
			logger.info(expectedMssg + " message was verified successfully");
		}else if(expectedMssg.contains("Your review was added successfully")) {
			waitTillPresence(factory.retailOrder().reviewOrderMssg);
			Assert.assertEquals(expectedMssg, factory.retailOrder().reviewOrderMssg.getText() );
			logger.info(expectedMssg + " message was verified successfully");
		}else if(expectedMssg.contains("Return was successfull")) {
			waitTillPresence(factory.retailOrder().yourOrderReturnMssg);
			Assert.assertEquals(expectedMssg, factory.retailOrder().yourOrderReturnMssg.getText() );
			logger.info(expectedMssg + " message was verified successfully");
		}else if(expectedMssg.contains("Your Order Has Been Cancelled")) {
			waitTillPresence(factory.retailOrder().yourOrderCancelMssg);
			Assert.assertEquals(expectedMssg, factory.retailOrder().yourOrderCancelMssg.getText() );
			logger.info(expectedMssg + " message was verified successfully");
		}
		
	}
	
	
	//edit payment method
	@When("User click on Edit option of card section")
	public void userClickOnEditOptionOfCardSection() {
	    click(factory.accountPage().creditDebitCardEditBttn);
	    logger.info("Edit button was clicked successfully");
	}
	@When("user edit information with below data")
	public void userEditInformationWithBelowData(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		clearTextUsingSendKeys(factory.accountPage().cardNumInputField);
		clearTextUsingSendKeys(factory.accountPage().nameOfTheCardInputField);
		clearTextUsingSendKeys(factory.accountPage().securityCodeInputField);
		sendText(factory.accountPage().cardNumInputField,data.get(0).get("cardNumber"));
		sendText(factory.accountPage().nameOfTheCardInputField,data.get(0).get("nameOnCard"));
		selectByVisibleText(factory.accountPage().expirationMonthInputField,data.get(0).get("expirationMonth"));
		selectByVisibleText(factory.accountPage().expirationYearInputField, data.get(0).get("expirationYear"));
		sendText(factory.accountPage().securityCodeInputField, data.get(0).get("securityCode"));
		logger.info("Credit card information has been updated");
	}
	@When("user click on Update Your Card button")
	public void userClickOnUpdateYourCardButton() {
	   click(factory.accountPage().addYourCardBttn);
	   logger.info("Update button was click successfully");
	}
	
	
	//Remove Payment Method
	@When("User select the card ending with {string}")
	public void userSelectTheCardEndingWith(String string) {
		List<WebElement> cards = factory.accountPage().cardEndingNum;
		for(WebElement card : cards) {
			if(card.getText().contains(string)) {
				System.out.println(card.getText());
				click(card);
				logger.info(string + " is selected");
				break;
			}
		}
	}
	@When("User click on remove option of card section")
	public void userClickOnRemoveOptionOfCardSection() {
		click(factory.accountPage().removeCardBttn);
		logger.info("Remove button clicked successfully");
	}
	@Then("payment details should be removed")
	public void paymentDetailsShouldBeRemoved() {
		logger.info("Payment method removed");
	}

	//add address
	@When("User click on Add address option")
	public void userClickOnAddAddressOption() {
		click(factory.accountPage().addAddressLink);
		logger.info("Add Address Link Clicked Successfully");
	}
	@When("user fill new address form with below information")
	public void userFillNewAddressFormWithBelowInformation(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> userInfo = dataTable.asMaps(String.class, String.class);
		selectByVisibleText(factory.accountPage().countryDropdown, userInfo.get(0).get("country"));
		sendText(factory.accountPage().addressNameInputField, userInfo.get(0).get("fullName"));
		sendText(factory.accountPage().addressPhoneInputField, userInfo.get(0).get("phoneNumber"));
		sendText(factory.accountPage().addressStreetInputField, userInfo.get(0).get("streetAddress"));
		sendText(factory.accountPage().addressAptInputField,userInfo.get(0).get("apt"));
		sendText(factory.accountPage().addressCityInputField, userInfo.get(0).get("city"));
		selectByVisibleText(factory.accountPage().addressStateInputField, userInfo.get(0).get("state"));
		sendText(factory.accountPage().addressZipCodeInputField, userInfo.get(0).get("zipCode"));
		logger.info("User entered address detail successfully");
	}
	@When("User click Add Your Address button")
	public void userClickAddYourAddressButton() {
		click(factory.accountPage().addressAddAddressBttn);
		logger.info("Add Address button was clicked successfully");
	}
	
	//edit address
	@When("User click on edit address option")
	public void userClickOnEditAddressOption() {
		click(factory.accountPage().editAccountAddressBttn);
		logger.info("Edit Address Link Clicked Successfully");
	}
	@When("User click update Your Address button")
	public void userClickUpdateYourAddressButton() {
		click(factory.accountPage().addressAddAddressBttn);
		logger.info("Add Address button was clicked successfully");
	}
	@Then("a message should be displayed ‘Address Updated Successfully’")
	public void aMessageShouldBeDisplayedAddressUpdatedSuccessfully() {

	}

	//remove address
	@When("User click on remove option of Address section")
	public void userClickOnRemoveOptionOfAddressSection() {
		click(factory.accountPage().removeAccountAddressBttn);
		logger.info("Remove Address Link Clicked Successfully");
	}
	@Then("Address details should be removed")
	public void addressDetailsShouldBeRemoved() {
		logger.info("Account Address removed");
	}

	
}
