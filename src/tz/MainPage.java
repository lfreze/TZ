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
class MainPage extends HomePage{

    public MainPage(FirefoxDriver driver) {
        super(driver);
    }
    
    int getValue() {
        try{
        (new WebDriverWait(driver, 5000)).until(ExpectedConditions.presenceOfElementLocated
        (By.id("counter_value")));
       String res =  driver.findElement(By.id("counter_value")).getText();
       return Integer.parseInt(res);
        }
        catch(org.openqa.selenium.NoSuchElementException Ex)
        {
            System.out.println(Ex); 
            return 0;
        }
    }

    void clickIncrement() {
        try{
        driver.findElement(By.xpath("//button[contains(text(),'Increment')]")).click();
        }
        catch(org.openqa.selenium.NoSuchElementException Ex)
        {
            System.out.println(Ex); 
        }
    }

    int getLengthList() {
        int count = 0;
        try
        {
        count = driver.findElements(By.xpath("//div[@class='col-md-6']//li")).size();
        }
        catch(org.openqa.selenium.NoSuchElementException Ex)
        {
            System.out.println("No massage " + Ex); 
        }
        return count;
    }

    void clickAdd() {
        try
        {
        (new WebDriverWait(driver, 5000)).until(ExpectedConditions.presenceOfElementLocated
        (By.xpath("//button[contains(text(),'Add')]")));
        driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
        }
        catch(org.openqa.selenium.NoSuchElementException Ex)
        {
            System.out.println(Ex); 
        }
    }

    boolean isMessagePresent(String message) {
        boolean res = false;
        try
        {
        if(driver.findElement(By.xpath("//p[@class='help-block']")).getText().contains(message))
            res = true;
        }
        catch(org.openqa.selenium.NoSuchElementException Ex)
        {
            System.out.println("No massage " + Ex); 
        }
        return res;
    }

    void addItem(String text) {
        try{
      (new WebDriverWait(driver, 5000)).until(ExpectedConditions.presenceOfElementLocated(By.id("title")));  
      driver.findElement(By.id("title")).clear();
      driver.findElement(By.id("title")).sendKeys(text);
        }
        catch(org.openqa.selenium.NoSuchElementException Ex)
        {
            System.out.println(Ex); 
        }
    }

    boolean isItemPresent(String itemText) {
        try{
        boolean res = false;
        for(int i=1; i<=getLengthList();i++)
        {
            if(driver.findElement(By.xpath("//div[@class='col-md-6']/ol/li["+i+"]")).getText().contains(itemText))
                res = true;
        }
        return res;
        }
        catch(org.openqa.selenium.NoSuchElementException Ex)
        {
            System.out.println(Ex); 
            return false;
        }
            
    }

    void deleteItem(String itemText) {
        try{
        (new WebDriverWait(driver, 5000)).until(ExpectedConditions.presenceOfElementLocated
        (By.xpath("//div[@class='col-md-6']/ol/li[contains(text(),'"+itemText+"')]/a")));  
        driver.findElement(By.xpath("//div[@class='col-md-6']/ol/li[contains(text(),'"+itemText+"')]/a")).click();
        }
        catch(org.openqa.selenium.NoSuchElementException Ex)
        {
            System.out.println(Ex); 
        }
        }
    
}
