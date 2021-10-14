package Ivi;

import pages.google.ResultPic;
import pages.google.SearchResult;
import pages.google.Main;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.googlePlay.IviPlayMarket;
import pages.wiki.Wiki;

import java.util.concurrent.TimeUnit;

public class RunTest {
	private WebDriver driver;

	// проверка драйвера браузера
	// выполняем при запуске
	@BeforeAll
	public static void chekBS() {
		WebDriverManager.firefoxdriver().setup();
	}

	// неавторизованный пользователь заходит в https://www.google.com/
	// запускаем перед каждым тестом
	@BeforeEach
	public void setup() {
		driver = new FirefoxDriver();
		// неявное ожидание
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// переход на страницу
		driver.get("https://www.google.com/");
		// настройка окна браузера
		driver.manage().window().maximize();
		// инициализируем главную страницу
		Main main = new Main();
		// находим, заполняем, получаем результат
		main.searchInputPl(driver,"Ivi");
	}

	// после каждого теста закрываем драйвер
	@AfterEach
	public void drDown() {
		if (driver != null){
			driver.quit();
		}
	}

	// неавторизованный пользователь заходит в https://www.google.com/
	// ищет ivi переходит в картинки выбирает большие
	// убеждается, что не менее 3 картинок в выдаче ведут на сайт ivi.ru
	@Test
	public void test1() {
		// результаты поиска
		SearchResult searchResult = new SearchResult();
		// переходим в картинки
		searchResult.elementSearch(driver, "//a[@data-hveid][text() = 'Картинки']");
		// переход на страницу картинки
		ResultPic resultPic = new ResultPic();
		// поиск картинок и проверка результата
		resultPic.searchPic(driver);
	}

	// неавторизованный пользователь заходит в https://www.google.com/
	// ищет ivi на первых 5 страницах находит ссылки на приложение ivi в play.google.com
	// убеждается, что рейтинг приложения на кратком контенте страницы совпадает с рейтингом при переходе
	@Test
	public void test2() {
		SearchResult searchResult = new SearchResult();
		// ищет ivi на первых 5 страницах
		searchResult.searchPGC(driver, "//h3[text() = 'Приложения в Google Play – IVI: сериалы, фильмы, мультики']");
		// находим рейтинг приложения на кратком контенте страницы
		String ratingGS = searchResult.searchRating(driver);
		// переходим в play.google.com на страниццу приложения Ivi
 		IviPlayMarket iviPlayMarket = new IviPlayMarket();
		 // получаем рейтинг ivi в play.google.com
		String raitngPM = iviPlayMarket.iviPM(driver);
		// сравниваем рейтинги
		assert ratingGS.equals(raitngPM) : "Rating False";
	}

	// неавторизованный пользователь заходит в https://www.google.com/
	// ищет ivi на первых 5 страницах находит ссылку на статью в wikipedia об ivi
	// убеждается, что в статье есть ссылка на официальный сайт ivi.ru
	@Test
	public void test3() {
		SearchResult searchResult = new SearchResult();
		String link = "//h3[text() = 'Ivi.ru - — Википедия']";
		// ищет ivi в wiki на первых 5 страницах
		searchResult.searchPGC(driver, link);
		// поиск и переход по ссылке
		searchResult.elementSearch(driver, link);
		// переход на страницу ivi в wiki
		Wiki wiki = new Wiki();
		// проверка что в статье есть ссылка на официальный сайт ivi.ru
		wiki.iviToWiki(driver, "//a[@href='https://www.ivi.ru/']");
	}

}
