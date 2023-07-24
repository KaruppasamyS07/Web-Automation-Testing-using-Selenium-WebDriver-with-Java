package Pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import Base.BaseClass;

public class CoporateWellness extends BaseClass {

	private By firstName_xpath = By.xpath("//form/div[1]/input[@placeholder='Name']");
	private By organizationName_xpath = By.xpath("//form/div[2]/input[@placeholder='Organization Name']");
	private By contactNumber_xpath = By.xpath("//input[@placeholder='Contact Number'][1]");
	private By emailId_xpath = By.xpath("//input[@placeholder='Official Email ID'][1]");
	private By organizationSize = By.id("organizationSize");
	private By interestedIn_xpath = By.id("interestedIn");

	public void wellNess() throws InterruptedException {
		TimeUnit.SECONDS.sleep(5);
		WebElement corportate = driver.findElement(By.xpath("//span[text()='Wellness Plans']"));
		corportate.click();
		windowHandle(1);
	}

	public void fillDetails() throws IOException, InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(firstName_xpath))
				.sendKeys(sheet.getRow(1).getCell(2).getStringCellValue());
		driver.findElement(organizationName_xpath).sendKeys(sheet.getRow(1).getCell(3).getStringCellValue());
		driver.findElement(contactNumber_xpath).sendKeys("" + (long) sheet.getRow(1).getCell(4).getNumericCellValue());
		driver.findElement(emailId_xpath).sendKeys(sheet.getRow(1).getCell(5).getStringCellValue());
		new Select(driver.findElement(organizationSize)).selectByVisibleText("<500");
		new Select(driver.findElement(interestedIn_xpath)).selectByVisibleText("Taking a demo");
		screenshot("CoporateWellness page");
		System.out.println("Corporate Wellness page passed");
		System.out.println("-----------------------------");
		System.out.println();
	}

}
