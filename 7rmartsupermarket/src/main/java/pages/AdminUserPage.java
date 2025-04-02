package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtilities;
import utilities.WaitUtilities;

public class AdminUserPage
{
	public WebDriver driver;
	PageUtilities pageutilities=new PageUtilities();
	WaitUtilities waitutility=new WaitUtilities();
	
	public AdminUserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=("(//i[@class='fas fa-arrow-circle-right'])[1]")) WebElement adminuser;
	@FindBy(xpath=("//a[@class='btn btn-rounded btn-danger']")) WebElement newuser;
	@FindBy(xpath=("//input[@id='username']")) WebElement username;
	@FindBy(xpath=("//input[@id='password']")) WebElement password;
	@FindBy(xpath=("//select[@id='user_type']"))WebElement usertype;
	@FindBy(xpath=("//button[@name='Create']")) WebElement savebutton;
	@FindBy(xpath=("//div[@class='alert alert-danger alert-dismissible']")) WebElement alertdisplayed;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']") WebElement resetbutton;
	@FindBy(xpath="(//i[@class='fa fa-unlock'])[1]") WebElement unlockbutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement unlockalert;
	
	public AdminUserPage clickadminuserlink()
	{
		waitutility.waitForElementTobeClicked(driver, adminuser);
		adminuser.click();
		return this;
	}
	
	public AdminUserPage clicknewuserbutton()
	{
		newuser.click();
		return this;
	}
	
	public AdminUserPage enteruserdetails()
	{
		username.sendKeys("Tintu");
		password.sendKeys("Tintu");
		//Select select=new Select(usertype);
		//select.selectByContainsVisibleText("Admin");
		pageutilities.selectbyvisibletext(usertype, "Admin");
		return this;
	}
	
	public AdminUserPage savebuttonclick()
	{
		savebutton.click();
		return this;
	}
	public AdminUserPage clickResetButton()
	{
		resetbutton.click();
		return this;
	}
	
	public AdminUserPage clickUnlockButton()
	{
		unlockbutton.click();
		return this;
	}
	public boolean isalertdisplayed()
	{
		return alertdisplayed.isDisplayed();
	}

	public boolean isResetbuttonclicked()
	{
		return resetbutton.isSelected();
	}
	public boolean isUnlockAlertDisplayed()
	{
		return unlockalert.isDisplayed();
	}
}
