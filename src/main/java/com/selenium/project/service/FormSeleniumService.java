package com.selenium.project.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;

@Service
public class FormSeleniumService extends SeleniumService {
	
	public void process() {
		
		WebDriver driver = initWebDriver("http://dicaseprogramacao.com.br/selenium/form/");
		
		sendKeyWithDelay(driver.findElement(By.name("firstName")), "Deibson", ONE_SECOND);
		sendKeyWithDelay(driver.findElement(By.name("lastName")), "Januario", ONE_SECOND);
		sendKeyWithDelay(driver.findElement(By.name("username")), "deibson_daj", ONE_SECOND);
		sendKeyWithDelay(driver.findElement(By.name("email")), "deibson.januario@gmail.com", ONE_SECOND);
		sendKeyWithDelay(driver.findElement(By.name("address")), "Sudoeste", ONE_SECOND);
		sendKeyWithDelay(driver.findElement(By.name("address2")), "Jordão Alto, Recife", ONE_SECOND);
		
		executeScriptWithDelay(driver, "$('select#city').prop('selectedIndex', 2);", ONE_SECOND);
		executeScriptWithDelay(driver, "$('#city').val('recife');", ONE_SECOND);
		
		dropdownSelectByIndexWithDelay(driver.findElement(By.id("state")), 2, ONE_SECOND);
		dropdownselectByValueWithDelay(driver.findElement(By.id("state")), "pernambuco", ONE_SECOND);
		sendKeyWithDelay(driver.findElement(By.name("zip")), "51260130", ONE_SECOND);
		
		sendClickWithDelay(driver.findElement(By.name("same-address")), ONE_SECOND);
		
		executeScriptWithDelay(driver, "$('#save-info').click();", ONE_SECOND);
		executeScriptWithDelay(driver, "$('#debit').click();", ONE_SECOND);
		
		sendKeyWithDelay(driver.findElement(By.name("cc-name")), "deibson anderson", ONE_SECOND);
		sendKeyWithDelay(driver.findElement(By.name("cc-number")), "1234.5678.9101.1121", ONE_SECOND);
		sendKeyWithDelay(driver.findElement(By.name("cc-expiration")), "04/2029", ONE_SECOND);
		sendKeyWithDelay(driver.findElement(By.name("cc-cvv")), "666", ONE_SECOND);
		
		sendClickWithDelay(driver.findElement(By.name("btn-form")), 1);
		
		wait(1);
		
		driver.switchTo().alert().accept();
		
		wait(3);
		
		driver.quit();

	}
	

	

}
