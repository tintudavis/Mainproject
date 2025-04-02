package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	HomePage homepage;
	LoginPage loginpage;
	SubCategoryPage subcategorypage;
	public WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath=("//a[@data-toggle='dropdown']")) WebElement adminuserlinkbutton;
	@FindBy(xpath=("//a[@class='dropdown-item'][2]")) WebElement logoutbutton;
	@FindBy(xpath = "(//a[text()='More info '])[1]") WebElement moreInfo;
	@FindBy(xpath=("(//a[@class='small-box-footer'])[3]")) WebElement categorylink;
	@FindBy(xpath=("//h1[text()='Admin Users']")) WebElement adminpagedisplayed;
	@FindBy(xpath=("//h1[text()='List Categories']"))WebElement categorypagedisplayed;
	@FindBy(xpath=("(//a[@class='small-box-footer'])[4]")) WebElement subcategorylink;
	
	public LoginPage logoutbuttonclick()
	{
		adminuserlinkbutton.click();
		logoutbutton.click();
		return loginpage;
	}
	
	public SubCategoryPage clickOnSubCategoryLink()
	{
		subcategorylink.click();
		return subcategorypage;
	}
	public HomePage moreinfoclick()
	{
		moreInfo.click();
		return homepage;
	}
	public HomePage clickcategorylink()
	{
		categorylink.click();
		return homepage;
	}
	public HomePage clickSubCategorylink()
	{
		subcategorylink.click();
		return homepage;
	}
	
	public boolean isAdminUserPageDisplayed()
	{
		return adminpagedisplayed.isDisplayed();
	}
	
	public boolean isCategoryListPageDisplayed()
	{
		return categorypagedisplayed.isDisplayed();
	}
}
