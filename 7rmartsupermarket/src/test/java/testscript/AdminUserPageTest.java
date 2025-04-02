package testscript;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import constants.Constant;
import pages.LoginPage;
import utilities.ExcelUtilities;
import pages.AdminUserPage;
import pages.HomePage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class AdminUserPageTest extends Base{
	HomePage homepage;
	AdminUserPage adminuserpage;
  @Test
  public void verifyIfUsercanAddNewuser() throws IOException
  {
	  String userName = ExcelUtilities.getStringData(3, 0, "LoginPage");
	  String password = ExcelUtilities.getStringData(3, 1, "LoginPage");
	  LoginPage loginPage = new LoginPage(driver);
	  loginPage.enterusernameandpassword(userName, password).signinbuttonclick().moreinfoclick();
	  AdminUserPage adminuserpage=new AdminUserPage(driver);
	  adminuserpage.clicknewuserbutton().enteruserdetails().savebuttonclick();
	  Boolean alertdisplayed=adminuserpage.isalertdisplayed();
	  Assert.assertTrue(alertdisplayed, Constant.ERRORMESSAGEFOREXISTINGUSER);
	
  }
  @Test
  public void verifyIfUserCanClickResetButton() throws IOException
  {
	  String userName = ExcelUtilities.getStringData(3, 0, "LoginPage");
	  String password = ExcelUtilities.getStringData(3, 1, "LoginPage");
	  LoginPage loginPage = new LoginPage(driver);
	  loginPage.enterusernameandpassword(userName, password).signinbuttonclick().moreinfoclick();
	  AdminUserPage adminuserpage=new AdminUserPage(driver);
	  adminuserpage.clicknewuserbutton().enteruserdetails().clickResetButton();
	  Boolean alertdisplayed=adminuserpage.isResetbuttonclicked();
	  Assert.assertTrue(alertdisplayed, Constant.ERRORMESSAGEFORRESETBUTTONCLICK);
  }
 
  @Test  
  public void verifyIfUserCanChangeUserStatus() throws IOException
  {
	  String userName = ExcelUtilities.getStringData(3, 0, "LoginPage");
	  String password = ExcelUtilities.getStringData(3, 1, "LoginPage");
	  LoginPage loginPage = new LoginPage(driver);
	  loginPage.enterusernameandpassword(userName, password).signinbuttonclick().moreinfoclick();
	  AdminUserPage adminuserpage=new AdminUserPage(driver);
	  adminuserpage.clickUnlockButton();
	  boolean alertdisplayed=adminuserpage.isResetbuttonclicked();
	  Assert.assertFalse(alertdisplayed, Constant.ERRORMESSAGEFORUNLOCKUSER);
  }
  
}
