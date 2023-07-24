package Base;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BaseClass {

	public static RemoteWebDriver driver;
	public static WebDriverWait wait;
	public static String browserName;
	public static Properties properties;
	private static XSSFWorkbook workBook;
	public static XSSFSheet sheet;

	public void setDriver(String browserName) throws IOException {
		properties = new Properties();
		properties.load(
				new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties"));

		BaseClass.browserName = browserName;

		switch (browserName) {
		case "chrome":
			chromeDriverSetup();
			break;
		case "edge":
			edgeDriverSetup();
			break;
		default:
			System.out.println("Invalid Input");
		}
		openUrl();
		checkServerResponse();
	}

	private void chromeDriverSetup() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\drivers\\newchromedriver.exe");
		driver = new ChromeDriver();
	}

	private void edgeDriverSetup() {
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\drivers\\msedgedriver.exe");
		driver = new EdgeDriver();
	}

	private void openUrl() throws IOException {
		driver.get(properties.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 30);
		excelUtils();
	}

	private void checkServerResponse() throws MalformedURLException, IOException, ProtocolException {
		URL url = new URL(driver.getCurrentUrl());
		HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
		int responseCode = httpConnection.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK)
			System.out.println(responseCode + " - Server response is good \n");
		else
			System.out.println(responseCode + " - Server response is not good \n");
	}

	private void excelUtils() throws IOException {
		FileInputStream excelFile = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\Invalid Details.xlsx");
		workBook = new XSSFWorkbook(excelFile);
		sheet = workBook.getSheet("Invalid details");
	}

	public void windowHandle(int windowIndex) {
		Set<String> tabs = driver.getWindowHandles();
		ArrayList<String> windows = new ArrayList<>(tabs);
		driver.switchTo().window(windows.get(windowIndex));
	}

	public void screenshot(String imageName) throws IOException, InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File screenshotfile = screenshot.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshotfile, new File(
				System.getProperty("user.dir") + "\\Screenshot\\" + imageName + " (" + browserName + ")" + ".png"));
	}

	public void driverClose() throws InterruptedException, IOException {
		TimeUnit.SECONDS.sleep(5);
		workBook.close();
		driver.quit();

	}
}
