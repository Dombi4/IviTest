package pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResultPic {
	// поиск картинок и проверка результата
	public void searchPic(WebDriver driver) {
		List<WebElement> link = driver.findElements(By.xpath("//div[text() = 'ivi.ru']"));
		assert link.size() > 3;
	}
}
