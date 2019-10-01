package com.selenium.project.service;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Service;

@Service
public abstract class SeleniumService {
	
	protected static final int ZERO_SECOND = 0;
	protected static final int ONE_SECOND = 1;

	/**
	 * Create an instance of the driver
	 * 
	 * @return
	 */
	protected WebDriver initWebDriver(String uri) {

		// System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		// WebDriver driver = new ChromeDriver();

		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		driver.get(uri);

		return driver;
	}

	/**
	 * operation responsible for the process
	 * 
	 * @return
	 */
	protected void wait(int segundos) {
		try {
			TimeUnit.SECONDS.sleep(segundos);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected void sendKeyWithDelay(WebElement element, String value, int delay) {
		element.sendKeys(value);
		wait(delay);
	}
	
	protected void sendKeyWithDelay(List<WebElement> element, int index, String value, int delay) {
		element.get(index).sendKeys(value);
		wait(delay);
	}
	
	protected void sendClickWithDelay(WebElement element, int delay) {
		element.click();
		wait(delay);
	}

	protected void dropdownSelectByIndexWithDelay(WebElement element, int index, int delay) {
		Select dropdown = new Select(element);
		dropdown.selectByIndex(index);
		wait(delay);
	}

	protected void dropdownselectByValueWithDelay(WebElement element, String value, int delay) {
		Select dropdown = new Select(element);
		dropdown.selectByValue(value);
		wait(delay);
	}
	
	protected void dropdownselectByValueWithDelay(List<WebElement> element, int index, String value, int delay) {
		Select dropdown = new Select(element.get(index));
		dropdown.selectByValue(value);
		wait(delay);
	}

	protected void executeScriptWithDelay(WebDriver driver, String value, int delay){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(value);
		wait(delay);
	}
}
