package pages.google;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Main {
 // // находим, заполняем, получаем результат
	public void searchInputPl(WebDriver driver, String searchInputText) {
		WebElement searchInput = driver.findElement(By.xpath("//input[@title='Поиск']"));
		searchInput.sendKeys(searchInputText);
		searchInput.submit();
	}
}
