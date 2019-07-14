package com.expleo.seleniumtest;

import org.junit.jupiter.api.Assertions;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CurrencyConverterTest {

	public static WebDriver driver;
	
	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void test() {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println(System.getProperty("user.dir"));

		// Launch the URL
		driver.get("http://www.xe.com/currencyconverter/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		// Accept Cookie
		driver.findElement(By.xpath("//button[@class='privacy-basic-button privacy-basic-button-submit']")).click();
		String[] currencies = { "JPY", "GBP", "EUR", "CAD", "AUD" };

		for (String currency : currencies) {

			// Click on From button
			driver.findElement(By.xpath("//*[@id='converterForm']//form//div[2]/div/div/div[1]")).click();
			// Select USD as base currency
			driver.findElement(By.id("from")).sendKeys("USD" + Keys.TAB);
			
			// Click on To button
			driver.findElement(By.xpath("//*[@id='converterForm']//form//div[3]/div/div/div[1]")).click();
			driver.findElement(By.xpath("//*[@id='converterForm']//form//span[contains(text()," + "'" + currency + "')]")).click();

			// Click on Submit button
			driver.findElement(By.xpath("//*[@id='converterForm']//form//button[2]")).click();

			// Get the currency amount and name
			String toAmount = driver.findElement(By.xpath("//span[@class='converterresult-toAmount']")).getText();
			String currencyName = driver.findElement(By.xpath("//span[@class='converterresult-toCurrency']")).getText();
			
			String expectedConversion = toAmount + " " + currencyName;
			
			String conversion = driver.findElement(By.xpath("//div[@id='converterResult']//section//div[contains(text()," + "'" + currency + "')][2]")).getText();
			
			// Full Conversion Text
			System.out.println(conversion);
			String[] convertedCurrency = conversion.split("=");
			Assertions.assertEquals(expectedConversion.trim(), convertedCurrency[1].trim());
			
			driver.navigate().back();
		}
	}

}
