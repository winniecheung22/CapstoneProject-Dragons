package tek.sdet.framework.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class RetailOrderSteps extends CommonUtility{
	POMFactory factory = new POMFactory();
	
	@When("User change the category to {string}")
	public void userChangeTheCategoryTo(String smartHome) {
	   selectByVisibleText(factory.retailOrder().allDepartmentDropdown,smartHome);
	   logger.info(smartHome + " Option is selected successfully");
	}
	@When("User search for an item {string}")
	public void userSearchForAnItem(String kasaOutdoorSmartPlug) {
	    sendText(factory.retailOrder().searchInputField, kasaOutdoorSmartPlug);
	    logger.info(kasaOutdoorSmartPlug + " item name was entered successfully");
	}
	@When("User click on Search icon")
	public void userClickOnSearchIcon() {
	   click(factory.retailOrder().searchBtn);
	   logger.info("Search button was clicked successfully");
	}
	@When("User click on item")
	public void userClickOnItem() {
	   click(factory.retailOrder().kasaOutdoorSmartPlugItem);
	   logger.info("Item was clicked successfully");
	}
	@When("User select quantity {string}")
	public void userSelectQuantity(String itemQty) {
	    selectByVisibleText(factory.retailOrder().productQtyDropdown,itemQty);
	    logger.info("Item quantity was selected successfully");
	}
	@When("User click add to Cart button")
	public void userClickAddToCartButton() {
		click(factory.retailOrder().addToCardBttn);
		logger.info("Add to Cart button was clicked successfully");
	}
	@Then("the cart icon quantity should change to {string}")
	public void theCartIconQuantityShouldChangeTo(String itemQtyInTheCart) {
	   Assert.assertEquals(itemQtyInTheCart, factory.retailOrder().cartQtyField.getText());
	   logger.info(itemQtyInTheCart + " quantity was displayed in the cart");
	}
	
	//addItemAndProcToCkout
	@When("User search for an item Apex Legends {string}")
	public void userSearchForAnItemApexLegends(String apexLegends) {
	   sendText(factory.retailOrder().searchInputField, apexLegends);
	   logger.info(apexLegends + " entered successfully");
	}
	
	@When("User click on item Apex Legends")
	public void userClickOnItemApexLegends() {
		click(factory.retailOrder().apexLegendsItem);
		logger.info("Item was clicked Successfully");
	}
	@When("User select Apex Legends quantity {string}")
	public void userSelectApexLegendsQuantity(String itemQty) {
		selectByVisibleText(factory.retailOrder().productQtyDropdown, itemQty);
		logger.info(itemQty + " quantity was selected successfully");
	    
	}
	@Then("the cart icon quantity Apex Legends should change to {string}")
	public void theCartIconQuantityApexLegendsShouldChangeTo(String expectedQty) {
	   Assert.assertEquals(expectedQty, factory.retailOrder().cartQtyField.getText());
	   logger.info(expectedQty + " quantity was validated successfully");
	}
	@Then("User click on Cart option")
	public void userClickOnCartOption() {
	   click(factory.retailOrder().cartBttn);
	   logger.info("Cart button was clicked successfully");
	  
	}
	@Then("User click on Proceed to Checkout button")
	public void userClickOnProceedToCheckoutButton() {
	   click(factory.retailOrder().proceedToCheckoutBttn);
	   logger.info("Proceed to checkout button was clicked successfully");
	}
	@Then("User click on Place Your Order")
	public void userClickOnPlaceYourOrder() {
	    click(factory.retailOrder().placeOrderBttn);
	    logger.info("Place your order button was clicked successfully");
	}

	//cancel order
	@When("User click on Orders section")
	public void userClickOnOrdersSection() {
	   click(factory.retailOrder().orderLink);
	   logger.info("Order link clicked successfully");
	}
	@When("User click on first order in list")
	public void userClickOnFirstOrderInList() {
	    List<WebElement>listOfOrders= factory.retailOrder().listOfOrder;
	    for(int i=0; i< listOfOrders.size(); i++){
	    	if(factory.retailOrder().orderDetailsDisplay.getText().equalsIgnoreCase("Hide Details")) {
	    		if(factory.retailOrder().cancelBttn.isDisplayed()) {
	    			break;
	    		}
	    	}else if(factory.retailOrder().orderDetailsDisplay.getText().equalsIgnoreCase("Show Details")) {
	    		click(factory.retailOrder().orderDetailsDisplay);
	    		if(factory.retailOrder().cancelBttn.isDisplayed()) {
	    			break;
	    		}
	    	}
	    }
	}
	@When("User click on Cancel The Order button")
	public void userClickOnCancelTheOrderButton() {
	    click(factory.retailOrder().cancelBttn);
	    logger.info("Cancel the order button was clicked Successfully");
	}
	@When("User select the cancelation Reason {string}")
	public void userSelectTheCancelationReason(String cancellationReason) {
	  selectByVisibleText(factory.retailOrder().cancellationReason, cancellationReason);
	  logger.info(cancellationReason + " reason was selected successfully");
	}
	@When("User click on Cancel Order button")
	public void userClickOnCancelOrderButton() {
	  click(factory.retailOrder().cancelSubmitBttn);
	  logger.info("Cancel submit button was clicked successfully");
	}
	

	// return order
	@When("User click on Return Items button")
	public void userClickOnReturnItemsButton() {
		click(factory.retailOrder().returnBttn);
	    logger.info("Rerurn Item button was clicked Successfully");
	}
	@When("User select the Return Reason {string}")
	public void userSelectTheReturnReason(String returnReason) {
		selectByVisibleText(factory.retailOrder().returnReason, returnReason);
		  logger.info(returnReason + " reason was selected successfully");
	}
	@When("User select the drop off service {string}")
	public void userSelectTheDropOffService(String returnDropOffInput) {
		selectByVisibleText(factory.retailOrder().returnDropOffInput, returnDropOffInput);
		  logger.info(returnDropOffInput + " reason was selected successfully");
	}
	@When("User click on Return Order button")
	public void userClickOnReturnOrderButton() {
		click(factory.retailOrder().returnOrderBttn);
		  logger.info("Return order button was clicked successfully");
	}
	
	
	//
	@When("User click on Review button")
	public void userClickOnReviewButton() {
		click(factory.retailOrder().reviewBttn);
	    logger.info("Review Item button was clicked Successfully");
	}
	@When("User write Review headline {string} and {string}")
	public void userWriteReviewHeadlineAnd(String headlineInput, String descriptionInput) {
		 sendText(factory.retailOrder().reviewHeadlineInput, headlineInput);
		   logger.info(headlineInput + " entered successfully");
		   sendText(factory.retailOrder().reviewDescriptionInput, descriptionInput);
		   logger.info(descriptionInput + " entered successfully");
	}
	@When("User click Add your Review button")
	public void userClickAddYourReviewButton() {
		click(factory.retailOrder().reviewSubmitBttn);
	    logger.info("Review Submit button was clicked Successfully");
	}

	
}
