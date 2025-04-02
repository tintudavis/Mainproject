package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchPage 
{
	public WebDriver driver;
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=("//a[@onclick='click_button(2)']")) WebElement searchbutton1;
	@FindBy(xpath=("//input[@id='un']")) WebElement username;
	@FindBy(xpath=("//select[@id='ut']")) WebElement usertype;
	@FindBy(xpath=("//button[@name='Search']")) WebElement searchbutton2;
	@FindBy(xpath=("//center[text()='.........RESULT NOT FOUND.......']")) WebElement result;
	
	
	public SearchPage searchuser(String uname,String utype)
	{
		searchbutton1.click();
		username.sendKeys(uname);
		Select select=new Select(usertype);
		select.selectByContainsVisibleText(utype);
		searchbutton2.click();
		return this;
	}
	
	public boolean isResultDisplayed()
	{
		return result.isDisplayed();
	}
}
