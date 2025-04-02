package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtilities;

public class SubCategoryPageTest extends Base{
  @Test
  public void verifyIfUserCanAddSubCategory() throws IOException 
  {
	    String userName = ExcelUtilities.getStringData(3, 0, "LoginPage");
		String password = ExcelUtilities.getStringData(3, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterusernameandpassword(userName, password).signinbuttonclick();
		HomePage homepage=new HomePage(driver);
		homepage.clickOnSubCategoryLink();
		SubCategoryPage subcategorypage=new SubCategoryPage(driver);
		subcategorypage.AddNewsubCategory().uploadimage().clickSavebutton();
		boolean resultdisplayed=subcategorypage.isNewSubCategoryAdded();
		Assert.assertTrue(resultdisplayed, Constant.ERROMESSAGEFORADDNEWSUBCATEGORY);
  }
  
  @Test
  public void verifyIfUserCanCancelSubCategoryDetails() throws IOException 
  {
	  String userName = ExcelUtilities.getStringData(3, 0, "LoginPage");
		String password = ExcelUtilities.getStringData(3, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterusernameandpassword(userName, password).signinbuttonclick();
		HomePage homepage=new HomePage(driver);
		homepage.clickOnSubCategoryLink();
		SubCategoryPage subcategorypage=new SubCategoryPage(driver);
		String expected="List Sub Categories | 7rmart supermarket";
		subcategorypage.AddNewsubCategory().uploadimage().clickCancelbutton();
		String actual=driver.getTitle();
		System.out.println(actual);
		Assert.assertEquals(expected, actual,Constant.ERRORMESSAGEFORCANCELBUTTON);
  }
}
