package pages.googlePlay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IviPlayMarket {
	// переходим в play.google.com на страниццу приложения Ivi
	//получаем рейтинг ivi в play.google.com
	public String iviPM(WebDriver driver) {
		driver.get("https://play.google.com/store/apps/details?id=ru.ivi.client&amp;hl=ru&amp;gl=US");
		WebElement ratingPM = driver.findElement(By.xpath("//div[@class='BHMmbe']"));
		String ratingDuo = ratingPM.getText();
		return ratingDuo;
	}
}
