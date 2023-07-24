package code;

import java.io.File;     
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;


public class Process extends DriverSetup {
	
	public void searchSelection() throws InterruptedException {
		TimeUnit.SECONDS.sleep(3);
		WebElement text = driver.findElement(By.xpath("//input[@type='text']"));
		text.sendKeys(Searchtext);
		TimeUnit.SECONDS.sleep(3);

		driver.findElement(By.id("selector-option-0")).click();
	}

	public void searchResults() throws InterruptedException {

		String result = driver.findElement(By.xpath("//div[@class='q-box qu-borderBottom qu-pt--small qu-pb--small qu-bg--raised']//div[@class='q-text qu-dynamicFontSize--regular qu-medium qu-color--gray_dark qu-passColorToLinks']")).getText();
		// System.out.println(result);
		if (result.contains("Results for Testing")) {

			System.out.println("the text is verified");

		} else

			System.out.println("the text is not verified");

		TimeUnit.SECONDS.sleep(3);
	}

	public void signIn() throws InterruptedException {
		WebElement signInLink = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div[2]/div/div[2]/div/button"));
		signInLink.click();
		TimeUnit.SECONDS.sleep(3);

	}

	public  void signUpWithEmail() throws InterruptedException {
		WebElement signUpWithEmailLink = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div/span/span[4]/div"));
		signUpWithEmailLink.click();
		TimeUnit.SECONDS.sleep(3);

		// validation
		if (signUpWithEmailLink.isEnabled()) {
			System.out.println("Sign Up button enabled");
		} else {
			System.out.println("Sign Up button disabled");
		}
		TimeUnit.SECONDS.sleep(3);

		// details
		WebElement nameField = driver.findElement(By.id("profile-name"));
		nameField.sendKeys(name);
		TimeUnit.SECONDS.sleep(3);

		// Enter an invalid email in the email field (ex: abc@abc)

		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys(email);
		TimeUnit.SECONDS.sleep(3);
	}

	public void screenShots() throws IOException, InterruptedException {
		File firstSrc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\2269360\\eclipse-workspace\\QuoraSearch\\src\\Screenshot\\img.png");
		FileHandler.copy(firstSrc, dest);
		System.out.println("Error message is captured");
		TimeUnit.SECONDS.sleep(4);

	}

}
