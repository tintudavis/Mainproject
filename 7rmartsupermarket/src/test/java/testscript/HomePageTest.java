package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class HomePageTest extends Base{
	HomePage homepage;
	LoginPage loginpage;
	AdminUserPage adminuserpage;
  @Test
  public void verifyifusercanlogout() throws IOException 
  {  
	  String userName = ExcelUtilities.getStringData(3, 0, "LoginPage");
	  String password = ExcelUtilities.getStringData(3, 1, "LoginPage");
	  LoginPage loginPage = new LoginPage(driver);
	  loginPage.enterusernameandpassword(userName, password).signinbuttonclick();
	  HomePage homepage=new HomePage(driver);
	  loginpage=homepage.logoutbuttonclick();
	  String actual=driver.getTitle();
	  System.out.println(actual);
	  String expcted="Login | 7rmart supermarket";
	  Assert.assertEquals(expcted, actual,Constant.ERRORMESSAGEFORLOGOUT);
  }
  @Test
    public void verifyAdminUserMoreInfoClick() throws IOException
  {
	  String userName = ExcelUtilities.getStringData(3, 0, "LoginPage");
	  String password = ExcelUtilities.getStringData(3, 1, "LoginPage");
	  LoginPage loginPage = new LoginPage(driver);
	  loginPage.enterusernameandpassword(userName, password).signinbuttonclick();
	  HomePage homepage=new HomePage(driver);
	  homepage.moreinfoclick();
	  Boolean adminpagedisplayed=homepage.isAdminUserPageDisplayed();
	  Assert.assertTrue(adminpagedisplayed, Constant.ERRORMESSAGEFORADMINMOREINFOCLICK);
  }
  
  @Test
  public void verifycategoryMoreInfoClick() throws IOException
{
	  String userName = ExcelUtilities.getStringData(3, 0, "LoginPage");
	  String password = ExcelUtilities.getStringData(3, 1, "LoginPage");
	  LoginPage loginPage = new LoginPage(driver);
	  loginPage.enterusernameandpassword(userName, password).signinbuttonclick();
	  HomePage homepage=new HomePage(driver);
	  homepage.clickcategorylink();
	  Boolean categorylistpagedisplayed=homepage.isCategoryListPageDisplayed();
	  Assert.assertTrue(categorylistpagedisplayed, Constant.ERRORMESSAGEFORCATEGORYMOREINFOCLICK);
}
  
}
