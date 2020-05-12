package headlessBrowser;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.ChromeDriverManager;

class HeadlessChrome {
	static WebDriver driver;
	static WebDriverWait wait;
	private static TakesScreenshot ts;

	@BeforeAll
	static void setUpBeforeClass() {
		Class<? extends WebDriver> driverClass = ChromeDriver.class;
		ChromeDriverManager.getInstance(driverClass).setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		driver = new ChromeDriver(chromeOptions);
		wait = new WebDriverWait(driver, 10);
		ts = (TakesScreenshot) driver;
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	void test() {
		driver.get("https://google.com/imghp");
		WebElement imageBtn = driver.findElement(By.cssSelector("[aria-label=\"Search by image\"]"));
		wait.until(ExpectedConditions.elementToBeClickable(imageBtn));
		imageBtn.click();
		WebElement uploadImage = driver.findElement(By.linkText("Upload an image"));
		wait.until(ExpectedConditions.elementToBeClickable(uploadImage));
		uploadImage.click();
		WebElement chouseFileBtn = driver.findElement(By.id("awyMjb"));
		String imgName = "ci3.png";
		chouseFileBtn.sendKeys("C:\\Users\\andre\\Desktop\\" + imgName);
		WebElement getSearchValue = driver.findElement(By.xpath("//a[@class=\"Gj7ine\"]/div"));
		wait.until(ExpectedConditions.visibilityOf(getSearchValue));
		assertEquals(imgName, getSearchValue.getText());
		
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("hh_mm_ss");
		String fileName = format.format(date) + ".png";
		File screenshot = (ts.getScreenshotAs(OutputType.FILE));
		try {
			FileUtils.copyFile(screenshot, new File("C:\\Screenshots\\" + fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
