package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath=("//input[@name='username']")) WebElement username;
	@FindBy(xpath=("//input[@name='password']")) WebElement password;
	@FindBy(xpath=("//button[@type='submit']")) WebElement signinbutton;
	
	public LoginPage enterusernameandpassword(String username1,String passwd)
	{
		username.sendKeys(username1);
		password.sendKeys(passwd);
		return this;
	}
	
	public HomePage signinbuttonclick()
	{
		signinbutton.click();
		return new HomePage(driver);
	}
	
}
