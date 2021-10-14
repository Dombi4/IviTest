package pages.wiki;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Wiki {
	public void iviToWiki(WebDriver driver, String link) {
		WebElement iviLink = driver.findElement(By.xpath(link));
	}
}
