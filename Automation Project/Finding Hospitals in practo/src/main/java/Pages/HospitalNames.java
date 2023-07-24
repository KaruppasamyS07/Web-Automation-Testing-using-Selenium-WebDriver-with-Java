package Pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseClass;

public class HospitalNames extends BaseClass {
	List<Float> ratingNew;
	List<String> allHoursNew;
	List<String> hospitalNamesNew;

	private By city_xpath = By.xpath("//input[@data-qa-id='omni-searchbox-locality']");
	private By cityDropDown_xpath = By
			.xpath("//div[@data-qa-id='omni-suggestion-city'][1]//span[@class='c-omni-suggestion-item__content']");
	private By hospital_xpath = By.xpath("//input[@data-qa-id='omni-searchbox-keyword']");
	private By hospitalDropDown_xpath = By
			.xpath("//div[@class='c-omni-suggestion-group']/div[2]/span//div[text()='Hospital']");
	private By hospitalNames_xpath = By.xpath("//div[@class='c-estb-info']/a");
	private By allHours_xpath = By.xpath("//span[@class='uv2-spacer--lg-left']//span");
	private By rating_xpath = By.xpath("//div[@class='text-1']/SPAN[1]");

	public void selectCity() {
		WebElement city = driver.findElement(city_xpath);
		city.clear();
		new Actions(driver).doubleClick(city).sendKeys(sheet.getRow(1).getCell(0).getStringCellValue()).build().perform();
	
	}

	public void cityDropDown() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(cityDropDown_xpath)).click();
	}

	public void selectHospital() {
		WebElement hospital = driver.findElement(hospital_xpath);
		hospital.clear();
		hospital.sendKeys(sheet.getRow(1).getCell(1).getStringCellValue());
	}

	public void hospitalDropDown() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(hospitalDropDown_xpath)).click();
	}

	public void validation() throws InterruptedException, IOException {
		TimeUnit.SECONDS.sleep(3);
		screenshot("Hospital results");
		// scroll
		for (int p = 1; p <= 4; p++) {
			String s = String.format("(//div[@class=\'c-estb-card\'])[%d]/div[2]/div[1]/a", p * 10);
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(s)));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)", "");
			js.executeScript("window.scrollBy(0,1700)", "");
		}

		List<WebElement> hospitalNames = wait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(hospitalNames_xpath));
		List<WebElement> allHours = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(allHours_xpath));
		List<WebElement> rating = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(rating_xpath));

		// Declaring 3 arrayList for hospitalName, rating, hour
		ratingNew = new ArrayList<Float>();
		allHoursNew = new ArrayList<String>();
		hospitalNamesNew = new ArrayList<String>();

		for (WebElement hour : allHours) {
			String value1 = hour.getText();
			allHoursNew.add(value1);
		}
		for (WebElement ratings : rating) {
			String texts = ratings.getText();
			Float value = Float.parseFloat(texts);
			ratingNew.add((float) value);
		}
		for (WebElement element2 : hospitalNames) {
			String value2 = element2.getText();
			hospitalNamesNew.add(value2);
		}
	}

	public void printTheValidatedDetails() throws InterruptedException {
		System.out.println("-----------------------");
		System.out.println("The 24/7 Hospitals are\n");

		for (int i = 0; i < ratingNew.size(); i++) {
			if (allHoursNew.get(i).equals("MON - SUN 00:00AM - 11:59PM") && ratingNew.get(i) > 3.5)
				System.out.println(hospitalNamesNew.get(i));
		}
		System.out.println("\nFinding Hospitals Page Passed");
		
	}
}
