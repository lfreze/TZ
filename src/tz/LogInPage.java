/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author лена
 */
class LogInPage extends HomePage{

    public LogInPage(FirefoxDriver driver) {
        super(driver);
    }

    MainPage login(String mail, String pass) {
        try{
        (new WebDriverWait(driver, 5000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='email']")));
        addMail(mail);
        addPass(pass);
        submit();
        }
        catch(org.openqa.selenium.NoSuchElementException Ex)
        {
            System.out.println("No massage " + Ex); 
        }
        return new MainPage(driver);
    }

    private void addMail(String mail) {
        try{
        WebElement mailFld = driver.findElement(By.xpath("//*[@id='email']"));
        mailFld.clear();
        mailFld.sendKeys(mail);
        }
        catch(org.openqa.selenium.NoSuchElementException Ex)
        {
            System.out.println(Ex); 
        }
    }

    private void addPass(String pass) {
        try{
        WebElement passFld = driver.findElement(By.xpath("//*[@id='password']"));
        passFld.clear();
        passFld.sendKeys(pass);
        }
        catch(org.openqa.selenium.NoSuchElementException Ex)
        {
            System.out.println(Ex); 
        }
    }

    private void submit() {
        try{
        WebElement signInBtn = driver.findElement(By.xpath("//button[contains(text(),'Sign In!')]"));
        signInBtn.click();
        }
        catch(org.openqa.selenium.NoSuchElementException Ex)
        {
            System.out.println(Ex); 
        }
    }
    
}
