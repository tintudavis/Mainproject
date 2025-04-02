package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.AddCategoryPage;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtilities;
import utilities.FakerUtilities;
import utilities.WaitUtilities;

public class AddCategoryPageTest extends Base{
	
	AdminUserPage adminuserpage;
	FakerUtilities faker=new FakerUtilities();
	
  @Test
  public void verifyIfUserCanAddCategory() throws IOException, AWTException {
	    String userName = ExcelUtilities.getStringData(3, 0, "LoginPage");
		String password = ExcelUtilities.getStringData(3, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterusernameandpassword(userName, password).signinbuttonclick();
		HomePage homepage=new HomePage(driver);
		homepage.clickcategorylink();
		AddCategoryPage addcategorypage=new AddCategoryPage(driver);
		String categoryname=faker.getFakeCategoryName();
		addcategorypage=addcategorypage.clickNewCategorybutton().enterCategoryDetails(categoryname).fileUpload().clickOnSelectGroup().clickOnSaveCategoryButton();
		boolean resultdisplayed=addcategorypage.isNewCategoryAdded();
		Assert.assertTrue(resultdisplayed, Constant.ERROMESSAGEFORADDNEWCATEGORY);
  }

  @Test
  public void verifyIfUserCanClickCancelButton() throws IOException, AWTException
  {
	  String userName = ExcelUtilities.getStringData(3, 0, "LoginPage");
		String password = ExcelUtilities.getStringData(3, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterusernameandpassword(userName, password).signinbuttonclick();
		HomePage homepage=new HomePage(driver);
		homepage.clickcategorylink();
		AddCategoryPage addcategorypage=new AddCategoryPage(driver);
		String categoryname=faker.getFakeCategoryName();
		addcategorypage=addcategorypage.clickNewCategorybutton().enterCategoryDetails(categoryname).fileUpload().clickOnSelectGroup().clickCancelButton();
		boolean resultdisplayed=addcategorypage.isListCategoriesDisplayed();
		Assert.assertTrue(resultdisplayed, Constant.ERRORMESSAGEFORCANCELBUTTON);
  }
  
  @Test
  public void verifyIfUserCanSearchCategory() throws IOException, AWTException
  {
	  String userName = ExcelUtilities.getStringData(3, 0, "LoginPage");
		String password = ExcelUtilities.getStringData(3, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterusernameandpassword(userName, password).signinbuttonclick();
		HomePage homepage=new HomePage(driver);
		homepage.clickcategorylink();
		AddCategoryPage addcategorypage=new AddCategoryPage(driver);
		String categoryname=faker.getFakeCategoryName();
		addcategorypage=addcategorypage.clickSearchbutton(categoryname);
		boolean resultdisplayed=addcategorypage.isSerachCategoryDisplayed();
		Assert.assertTrue(resultdisplayed, Constant.ERRORMESSAGEFORSEARCHCATEGORY);
  }
}
