package com.selenium.project.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selenium.project.client.TimeDaysClient;
import com.selenium.project.dto.Day;
import com.selenium.project.dto.TimeDays;

@Service
public class TimeSeleniumService extends SeleniumService {

	@Autowired
	private TimeDaysClient times;

	private static final int INDEX_ZERO = 0;
	private static final int INDEX_ONE = 1;

	public void process() {

		WebDriver driver = initWebDriver("http://dicaseprogramacao.com.br/selenium/time/");

		TimeDays timeDays = times.getDateTimes();

		for (Day day : timeDays.getDays()) {

			sendKeyWithDelay(driver.findElement(By.name("date")), day.getDate(), ZERO_SECOND);
			sendKeyWithDelay(driver.findElement(By.name("user")), "deibson januario", ZERO_SECOND);

			dropdownselectByValueWithDelay(driver.findElements(By.name("project")), INDEX_ZERO, "3", ZERO_SECOND);
			dropdownselectByValueWithDelay(driver.findElements(By.name("task")), INDEX_ZERO, "402", ZERO_SECOND);
			sendKeyWithDelay(driver.findElements(By.name("start")), INDEX_ZERO, day.getFistHour(), ZERO_SECOND);
			sendKeyWithDelay(driver.findElements(By.name("end")), INDEX_ZERO, day.getSecondHour(), ZERO_SECOND);
			sendKeyWithDelay(driver.findElements(By.name("description")), INDEX_ZERO,
					"example selenium day ".concat(day.getDay().toString()), ZERO_SECOND);

			dropdownselectByValueWithDelay(driver.findElements(By.name("project")), INDEX_ONE, "3", ZERO_SECOND);
			dropdownselectByValueWithDelay(driver.findElements(By.name("task")), INDEX_ONE, "402", ZERO_SECOND);
			sendKeyWithDelay(driver.findElements(By.name("start")), INDEX_ONE, day.getThirdHour(), ZERO_SECOND);
			sendKeyWithDelay(driver.findElements(By.name("end")), INDEX_ONE, day.getFourtHour(), ZERO_SECOND);
			sendKeyWithDelay(driver.findElements(By.name("description")), INDEX_ONE,
					"example selenium day".concat(day.getDay().toString()), ZERO_SECOND);

			sendClickWithDelay(driver.findElement(By.name("btn-form")), ONE_SECOND);
			driver.switchTo().alert().accept();
			wait(1);
		}

		driver.quit();

	}

}
