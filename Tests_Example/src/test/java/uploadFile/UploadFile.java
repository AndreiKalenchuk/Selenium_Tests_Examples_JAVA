package uploadFile;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class UploadFile {
	static WebDriver driver;
	static WebDriverWait wait;
		
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/chromedriver79/chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);

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
	}
}
