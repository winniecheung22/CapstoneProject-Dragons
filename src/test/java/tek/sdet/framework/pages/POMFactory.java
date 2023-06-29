package tek.sdet.framework.pages;

import tek.sdet.framework.base.BaseSetup;

public class POMFactory extends BaseSetup {

	private RetailHomePage homePage;
	private RetailSignInPage signInPage;
	private RetailAccountPage accountPage;
	private RetailOrderPage retailOrder;
	
	public POMFactory() {
		this.homePage = new RetailHomePage();
		this.signInPage=new RetailSignInPage();
		this.accountPage= new RetailAccountPage();
		this.retailOrder= new RetailOrderPage();
	}

	public RetailHomePage homePage() {
		return this.homePage;
	}
	public RetailSignInPage signInPage() {
		return this.signInPage;
	}
	public RetailAccountPage accountPage() {
		return this.accountPage;
	}
	public RetailOrderPage retailOrder() {
		return this.retailOrder;
	}
}