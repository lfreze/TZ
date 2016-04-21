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
class HomePage {
    FirefoxDriver driver;

    HomePage(FirefoxDriver driver) {
        this.driver = driver;
    }

    LogInPage logInClick() {
        driver.findElement(By.xpath("//a[contains(text(),'Register/Login')]")).click();
        return new LogInPage(driver);
    }
    
}
