/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tz;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import static junit.framework.Assert.assertTrue;
import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author лена
 */
public class ListTests extends TestCase{
    public FirefoxDriver driver;
    String basePage = "https://buggy.auroraplatform.com/";

    ListTests(String testName) {
        super(testName);
    }
      
	@BeforeClass
	public void setUp() throws MalformedURLException{
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(basePage);
                driver.manage().window().maximize();
		
	}
	
	@AfterClass
	public void tearDown(){
		driver.close();
		
	}
    
    @Test
	public void testList() throws InterruptedException{
		HomePage homePage = new HomePage(driver);
		LogInPage loginPage = homePage.logInClick();
                MainPage mainPage = loginPage.login("lfreze@gmail.com", "131313");
                int count = mainPage.getLengthList();
                mainPage.clickAdd();
                String message = "Field must be between 3 and 40 characters long.";
                if((!mainPage.isMessagePresent(message))||(mainPage.getLengthList() != count))
                    System.out.println("Item is added or no massege " + message);
                mainPage.addItem("aa");
                mainPage.clickAdd();
                if((!mainPage.isMessagePresent(message))||(mainPage.getLengthList() != count))
                    System.out.println("Item is added or no massege " + message);
                mainPage.addItem("qwertyuiopasdfghjklzxcvbnmqwertyuiopasdfg");
                mainPage.clickAdd();
                if((!mainPage.isMessagePresent(message))||(mainPage.getLengthList() != count))
                    System.out.println("Item is added or no massege " + message);
                String itemText = "List1";
                mainPage.addItem(itemText);
                mainPage.clickAdd();
                if((!mainPage.isItemPresent(itemText))||(mainPage.getLengthList() != (count+1)))
                    System.out.println("Item isn't added");
                mainPage.deleteItem(itemText);
                if((mainPage.isItemPresent(itemText))||(mainPage.getLengthList() != count))
                    System.out.println("Item isn't deleted");
                else
                    System.out.println("testList passed");
	}

}
