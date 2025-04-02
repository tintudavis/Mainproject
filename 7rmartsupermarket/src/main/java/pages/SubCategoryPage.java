package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.FileUploadUtilities;
import utilities.PageUtilities;

public class SubCategoryPage {

	public WebDriver driver;
	PageUtilities pageutility =new PageUtilities();
	FileUploadUtilities fileuploadutility=new FileUploadUtilities();
	public SubCategoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[@class='small-box-footer'])[4]") WebElement subcategorylink;
	@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newbutton;
	@FindBy(xpath="//select[@class='form-control selectpicker']") WebElement selectcategory;
	@FindBy(xpath="//input[@id='subcategory']") WebElement subcategoryname;
	@FindBy(xpath="//input[@id='main_img']")WebElement  choosefile;
	@FindBy(xpath="//button[@name='create']") WebElement savebutton;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") WebElement savealert;
	@FindBy(xpath="//a[@class='btn btn-default btn-fix']") WebElement cancelbutton;
	
	public SubCategoryPage AddNewsubCategory()
	{
		newbutton.click();
		pageutility.selectbyvisibletext(selectcategory, "veggies");
		subcategoryname.sendKeys("Beetroot");
		return this;
	}
	public SubCategoryPage uploadimage()
	{
		
		fileuploadutility.fileUploadForSendKeys(choosefile, Constant.SUBCATEGORYPATH);
		return this;
	}
	public SubCategoryPage clickSavebutton()
	{
		JavascriptExecutor javaExecutor = (JavascriptExecutor) driver;
		javaExecutor.executeScript("window.scrollBy(0,3000)");
		javaExecutor.executeScript("arguments[0].click();",savebutton);
	
		return this;
	}
	
	public SubCategoryPage clickCancelbutton()
	{
		JavascriptExecutor javaExecutor = (JavascriptExecutor) driver;
		javaExecutor.executeScript("window.scrollBy(0,3000)");
		javaExecutor.executeScript("arguments[0].click();",cancelbutton);
		return this;
	}
	
	
	public boolean isNewSubCategoryAdded()
	{
		return savealert.isDisplayed();
	}
}
