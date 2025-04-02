package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constant;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class LoginPageTest extends Base{
  @Test(groups = {"smoke"})
  @Parameters({"username","password"})
  public void verifycorrectusernamecorrectpassword(String username,String password)
  {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.enterusernameandpassword(username,password);
	  loginpage.signinbuttonclick();
	  String actual=driver.getTitle();
	  System.out.println(actual);
	  String expcted="Dashboard | 7rmart supermarket";
	  Assert.assertEquals(expcted, actual,Constant.ERRORMESSAGEFORLOGIN);
	
  }
  
  @Test(groups ={"smoke"})
  public void verifycorrectusernameincorrectpassword() throws IOException
  { 
	  LoginPage loginpage=new LoginPage(driver);
	  String username=ExcelUtilities.getStringData(1,0,"LoginPage");
	  String password=ExcelUtilities.getStringData(1,1,"LoginPage");
	  loginpage.enterusernameandpassword(username, password);
	  loginpage.signinbuttonclick();
	  String actual=driver.getTitle();
	  String expcted="Dashboard | 7rmart supermarket";
	  Assert.assertEquals(expcted, actual,Constant.ERRORMESSAGEFORLOGIN);
  }
  
  @Test(retryAnalyzer = retry.Retry.class)
  public void verifyincorrectusernamecorrectpassword()
  {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.enterusernameandpassword("adminasdf", "admin");
	  loginpage.signinbuttonclick();
	  String actual=driver.getTitle();
	  String expcted="Dashboard | 7rmart supermarket";
	  Assert.assertEquals(expcted, actual,Constant.ERRORMESSAGEFORLOGIN);
  }
  
  @Test(dataProvider = "credentials")
  public void incorrectusernameincorrectpassword(String username1,String password1)
  {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.enterusernameandpassword(username1, password1);
	  loginpage.signinbuttonclick();
	  String actual=driver.getTitle();
	  String expcted="Dashboard | 7rmart supermarket";
	  Assert.assertEquals(expcted, actual,Constant.ERRORMESSAGEFORLOGIN);
  }
  
  @DataProvider(name="credentials")
  public Object testdata()
  {
	  Object data[][]= {{"admin","admin"},{"adminasdf","admin"},{"admin","adminasdf"},{"adminsdfg","adminsdfgh"}};
	  return data;
  }
}
