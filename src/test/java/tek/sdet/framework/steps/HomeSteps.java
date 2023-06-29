package tek.sdet.framework.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class HomeSteps extends CommonUtility {
	POMFactory factory = new POMFactory();

	// verify shop by department
	@When("User click on All section")
	public void userClickOnAllSection() {
		click(factory.homePage().hamburgerBttn);
		logger.info("Shop by Departments are presents");
		// click(factory.homePage().allDepartmentsBttn);
		// logger.info("All Departments button clicked successfully");
	}

	@Then("below options are present in Shop by Department sidebar")
	public void belowOptionsArePresentInShopByDepartmentSidebar(DataTable Options) {
		List<List<String>> allOptionsDisplay = Options.asLists(String.class);
		Assert.assertTrue(isElementDisplayed(
				getDriver().findElement(By.xpath("//span[text()='" + allOptionsDisplay.get(0).get(0) + "']"))));
		logger.info("options Electronics, Computers, Smart Home, Sports, and Automative are present");
	}

	// validate departments' options
	@When("User on {string}")
	public void userOn(String string) {
		List<WebElement> dept = factory.homePage().allDepartments;
		for (WebElement elements : dept) {
			elements.click();
			break;
		}

	}

	@Then("below options are present in department")
	public void belowOptionsArePresentInDepartment(DataTable dataTable) {
		List<List<String>> options = dataTable.asLists(String.class);
		List<WebElement> depts = factory.homePage().allDepartments;
		for (int i = 0; i < options.get(0).size(); i++) {
			for (WebElement elements : depts) {
				if (elements.getText().equals(options.get(0).get(i))) {
					Assert.assertTrue(elements.isDisplayed());
					logger.info(elements.getText() + " is present");
				}
			}
		}
	}
}
