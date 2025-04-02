package pages;

import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.lang.invoke.ConstantBootstraps;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.FileUploadUtilities;
import utilities.PageUtilities;
import utilities.WaitUtilities;

public class AddCategoryPage {
	
	public WebDriver driver;
	
	PageUtilities pageUtilities = new PageUtilities();
	WaitUtilities waitutility=new WaitUtilities();
	FileUploadUtilities fileuploadutility=new FileUploadUtilities();
	HomePage homepage;
	public AddCategoryPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")	WebElement newbutton;
	@FindBy(xpath = "//input[@name='category']")	WebElement categoryTextField;
	@FindBy(id="134-selectable")	WebElement categorySelect;
	@FindBy(xpath = "//input[@type='file']")	WebElement chooseFile;
	@FindBy(xpath = "(//input[@type='radio'])[1]")	WebElement radioButton1;
	@FindBy(xpath = "(//input[@type='radio'])[2]")	WebElement radioButton2;
	@FindBy(xpath = "(//input[@type='radio'])[3]")	WebElement radioButton3;
	@FindBy(xpath = "(//input[@type='radio'])[4]")	WebElement radioButton4;
	@FindBy(xpath = "//button[@type='submit']")	WebElement saveCategoryButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement saveresult;
	@FindBy(xpath="//a[text()='Cancel']") WebElement cancelbutton;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']") WebElement resetbutton;
	@FindBy(xpath="//li[@class='breadcrumb-item active']") WebElement categorylist;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']") WebElement searchbutton;
	@FindBy(xpath="//input[@placeholder='Category']")WebElement categorynameforsearch;
	@FindBy(xpath="//button[@name='Search']") WebElement searchbuttoncategory;
	@FindBy(xpath="//center[text()='.........RESULT NOT FOUND.......']") WebElement searchcategoryresult;
	
	public AddCategoryPage clickNewCategorybutton()
	{
		newbutton.click();
		return this;
	}

	public AddCategoryPage enterCategoryDetails(String categoryName) {
		categoryTextField.sendKeys(categoryName);
		return this;
	}

	public AddCategoryPage clickOnSelectGroup()
	{
		waitutility.waitForElementTobeClicked(driver, categorySelect);
		categorySelect.click();
		return this;	
	}
	public AddCategoryPage clickOnRadioButton()
	{
		radioButton2.click();
		radioButton4.click();
		return this;
	}

	public AddCategoryPage fileUpload() throws AWTException 
	{
		fileuploadutility.fileUploadForSendKeys(chooseFile, Constant.PATH);
		return this;
	}

	public AddCategoryPage clickOnSaveCategoryButton() 
	{
		JavascriptExecutor javaExecutor = (JavascriptExecutor) driver;
		javaExecutor.executeScript("window.scrollBy(0,3000)");
		javaExecutor.executeScript("arguments[0].click();",saveCategoryButton);
		//javaexec.executeScript("arguments[0].click();",searchbuton);
		//saveCategoryButton.click();
		return this;
	}
	
	public AddCategoryPage clickCancelButton()
	{
		JavascriptExecutor javaExecutor = (JavascriptExecutor) driver;
		javaExecutor.executeScript("window.scrollBy(0,3000)");
		javaExecutor.executeScript("arguments[0].click();",cancelbutton);
		return new AddCategoryPage(driver);
	}
	
	public AddCategoryPage clickResetButton()
	{
		resetbutton.click();
		return this;
	}
	
	public AddCategoryPage clickSearchbutton(String categoryname)
	{
		searchbutton.click();
		categorynameforsearch.sendKeys(categoryname);
		searchbuttoncategory.click();
		return this;
	}
	public boolean isNewCategoryAdded()
	{
		return saveresult.isDisplayed();
	}
	public boolean isListCategoriesDisplayed()
	{
		return categorylist.isDisplayed();
	}
	public boolean isSerachCategoryDisplayed()
	{
		return searchcategoryresult.isDisplayed();
	}
}
