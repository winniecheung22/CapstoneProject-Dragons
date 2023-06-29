package tek.sdet.framework.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.sdet.framework.base.BaseSetup;

public class RetailOrderPage extends BaseSetup{

	public RetailOrderPage() {
		PageFactory.initElements(getDriver(), this);
		
		
	}
	@FindBy(id = "search")
	public WebElement allDepartmentDropdown;
	@FindBy(id = "searchInput")
	public WebElement searchInputField;
	@FindBy(id = "searchBtn")
	public WebElement searchBtn;
	@FindBy(xpath = "//img[@alt='Kasa Outdoor Smart Plug']")
	public WebElement kasaOutdoorSmartPlugItem;
	@FindBy(xpath = "//select[@class='product__select']")
	public WebElement productQtyDropdown;
	@FindBy(xpath = "//span[text()='Add to Cart']")
	public WebElement addToCardBttn;
	@FindBy (xpath = "//span[@id='cartQuantity']")
	public WebElement cartQtyField;
	
	//
	@FindBy(id = "cartBtn")
	public WebElement cartBttn;
	@FindBy(id = "proceedBtn")
	public WebElement proceedToCheckoutBttn;
	@FindBy(id = "placeOrderBtn")
	public WebElement placeOrderBttn;
	@FindBy(xpath = "//div[text()='Order Placed Successfully']")
	public WebElement orderPlaceSuccessfullyMssg;
	@FindBy(xpath = "//img[@alt='Apex Legends - 1,000 Apex Coins']")
	public WebElement apexLegendsItem;
	
	//cancel order
	@FindBy(id = "orderLink")
	public WebElement orderLink;
	@FindBy(xpath = "//div[@class='order__header']")
	public List<WebElement> listOfOrder;
	@FindBy(xpath = "//p[@class='order__header-btn']")
	public WebElement orderDetailsDisplay;
	@FindBy(id="cancelBtn")
	public WebElement cancelBttn;
	@FindBy(id = "reasonInput")
	public WebElement cancellationReason;
	@FindBy(id = "orderSubmitBtn")
	public WebElement cancelSubmitBttn;
	@FindBy(xpath = "//p[text()='Your Order Has Been Cancelled']")
	public WebElement yourOrderCancelMssg;
	
	//Return order
	@FindBy(id="returnBtn")
	public WebElement returnBttn;
	@FindBy(id = "reasonInput")
	public WebElement returnReason;
	@FindBy(id = "dropOffInput")
	public WebElement returnDropOffInput;
	@FindBy(id = "orderSubmitBtn")
	public WebElement returnOrderBttn;
	@FindBy(xpath = "//p[text()='Return was successfull']")
	public WebElement yourOrderReturnMssg;
	
	//add review for order
	@FindBy(id="reviewBtn")
	public WebElement reviewBttn;
	@FindBy(id="headlineInput")
	public WebElement reviewHeadlineInput;
	@FindBy(id="descriptionInput")
	public WebElement reviewDescriptionInput;
	@FindBy(id="reviewSubmitBtn")
	public WebElement reviewSubmitBttn;
	@FindBy(xpath = "//div[text()='Your review was added successfully']")
	public WebElement reviewOrderMssg;
}




