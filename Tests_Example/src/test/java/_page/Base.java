package _page;

import org.openqa.selenium.WebDriver;

public class Base {
	protected WebDriver driver;
	
	public void open(WebDriver driver) {
		this.driver = driver;
		driver.get(url)
	};
	
}
