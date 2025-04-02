package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.LoginPage;
import pages.AdminUserPage;
import pages.SearchPage;
import utilities.ExcelUtilities;

public class SearchPageTest extends Base{
  @Test
  public void verifyIfUserIsableToSearch() throws IOException
  {
	  LoginPage loginpage=new LoginPage(driver);
	  String username=ExcelUtilities.getStringData(3,0,"LoginPage");
	  String password=ExcelUtilities.getStringData(3,1,"LoginPage");
	  loginpage.enterusernameandpassword(username, password).signinbuttonclick();
	  AdminUserPage adminuser=new AdminUserPage(driver);
	  adminuser.clickadminuserlink();
	  SearchPage searchpage=new SearchPage(driver);
	  searchpage.searchuser("Ann","Staff");
	  boolean resultdisplayed=searchpage.isResultDisplayed();
	  Assert.assertFalse(resultdisplayed, Constant.ERRORMESSAGEFORSEARCHUSER);
  }
}
