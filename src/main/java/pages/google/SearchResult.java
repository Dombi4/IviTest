package pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResult {

	// поиск и переход по ссылке переданной в аргументе
	public void elementSearch(WebDriver driver, String link) {
		WebElement searchElement = driver.findElement(By.xpath(link));
		searchElement.click();
	}

	// ищет на первых 5 страницах по переданным условиям
	public void searchPGC(WebDriver driver, String link) {
		List<WebElement> resultPage = null;
		for (int i = 0; i < 4; i++) {
			resultPage = driver.findElements(By.xpath(link));
			if (resultPage.size() > 0) break;
			nextPages(driver);
		}
		assert resultPage != null: "Not Link";


	}
// переход на следующую страницу результатов поиска
	public void nextPages(WebDriver driver) {
		WebElement nextP = driver.findElement(By.linkText("Следующая"));
		nextP.click();
	}

	// находим рейтинг приложения на кратком контенте страницы
	public String searchRating(WebDriver driver) {
		WebElement ratingGS = driver.findElement(By.xpath("//div[@class='fG8Fp uo4vr']/span[text()]"));
		String ratingGoogleS = ratingGS.getText();
		String ratingUno = ratingGoogleS.substring(ratingGoogleS.indexOf(" ") + 1);
		return ratingUno;
	}
}
