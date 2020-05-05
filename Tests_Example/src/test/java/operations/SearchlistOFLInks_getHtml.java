package operations;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class SearchlistOFLInks_getHtml {
	
	private static WebDriver driver;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/driversSelenium/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	static void test() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("https://duckduckgo.com/");
		assertEquals(driver.getTitle(), "DuckDuckGo — Privacy, simplified.");
		driver.findElement(By.id("search_form_input_homepage")).sendKeys("maven", Keys.ENTER);
//		driver.findElement(By.id("search_button_homepage")).click();
		String el = driver.findElement(By.cssSelector("#search_form_input")).getAttribute("value");
		assertEquals(el, "maven");
		List<WebElement> elementsList = driver.findElements(By.tagName("a"));
		for (WebElement link : elementsList)
			System.out.println(link.getText() + " is " + link.getAttribute("href"));
			
//			assetrEquals(link.getAttribute("href"), "https://maven.apache.org/");
//		
//		assertTrue(driver.findElement(By.xpath("//a[@href =\"https://maven.apache.org/\"]")).isDisplayed());
//		
}
	
	@Test
	static void getPageHtml() {
		String body = driver.getPageSource();
		System.out.println(body);
		assertTrue(body.contains("Selenium11"));
	}
	
}
