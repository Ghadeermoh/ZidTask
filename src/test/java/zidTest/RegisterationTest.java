package zidTest;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.ExcellUtility;
import zidPages.BaseTest;
import zidPages.RegisterPage;
import zidPages.Utility;

public class RegisterationTest extends BaseTest{
	
	public RegisterPage regPage;
	public Utility utilpage;
	public RegisterationTest() {
		super();
	}
	
	@BeforeTest
	public void Setup() {
		init();
		regPage =new RegisterPage();
		regPage.AlertHandle();
	}
	
	
	 
	@DataProvider 
	public Object[][] getData() throws IOException{
		Object data [][] =ExcellUtility.getData();
		return data;
		
	}
	
	//*********************************
	
	
	@Test(dataProvider = "getData")
	public void VerifyValidReg(String full_name,String mobile ,String email,String password 
			,String ArabStoreName , String EngStoreName ) {
		
	  String check=regPage.Registeration(full_name ,mobile ,email ,password,ArabStoreName , EngStoreName);
	  assertEquals(check, "Zid | الرئيسية");
	}
	
	@AfterMethod
	public void Teardown() {
		driver.quit();
	}

}
