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
        (new WebDriverWait(driver, 5000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='email']")));
        addMail(mail);
        addPass(pass);
        submit();
        return new MainPage(driver);
    }

    private void addMail(String mail) {
        WebElement mailFld = driver.findElement(By.xpath("//*[@id='email']"));
        mailFld.clear();
        mailFld.sendKeys(mail);
    }

    private void addPass(String pass) {
        WebElement passFld = driver.findElement(By.xpath("//*[@id='password']"));
        passFld.clear();
        passFld.sendKeys(pass);
    }

    private void submit() {
        WebElement signInBtn = driver.findElement(By.xpath("//button[contains(text(),'Sign In!')]"));
        signInBtn.click();
    }
    
}
