package Pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import Base.BaseClass;

public class TopCities extends BaseClass {
	private By bookDiagnosticTestsButton_xpath = By.xpath("//span[text()='Book Diagnostic Tests']");
	private By cities_xpath = By.xpath("//div[@class='u-bg--white u-marginb--std']//ul/li");
	private By exitPageButton_xpath = By.xpath("//div[@class='u-bg--white u-marginb--std']//ul/li");

	public void clickDiagnosisPage() throws InterruptedException {
		TimeUnit.SECONDS.sleep(5);
		driver.navigate().back();

		WebElement bookDiagnosis = wait
				.until(ExpectedConditions.presenceOfElementLocated(bookDiagnosticTestsButton_xpath));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", bookDiagnosis);
		TimeUnit.SECONDS.sleep(3);
		bookDiagnosis.click();
	}

	public void printTheCities() throws InterruptedException, IOException {
		System.out.println("----------------");
		System.out.println("The Popular Cities are :");
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(cities_xpath)));
		List<WebElement> popularCities = driver.findElements(cities_xpath);
		for (int i = 0; i < popularCities.size(); i++)
			System.out.println(popularCities.get(i).getText());
		System.out.println();
		TimeUnit.SECONDS.sleep(3);
		screenshot("Popular Cities");
	}

	public void clickTOExitThePage() {
		driver.findElement(exitPageButton_xpath).click();
		driver.navigate().back();
		System.out.println("Book Diagnosis Page passed");
		System.out.println("-----------------------------");
	}
}
