package code;

import java.io.FileInputStream;     
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class DriverSetup {

	 static WebDriver driver;
	static String url,Searchtext,name,email,chromeDriverPath,edgeDriverPath;

	public void readInputs() throws InterruptedException, IOException {
		// taking the input

		System.out.println("Select your browser: 1.Chrome 2. Edge");

		Scanner sc = new Scanner(System.in);
	
		int choice = sc.nextInt();
		sc.close();
		loadProperties();

		if (choice == 1)

			chromeBrowser();

		else 

			MicrosoftEdgeBrowser();
		
		openUrl(); 
	}
	
	public void chromeBrowser() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",chromeDriverPath);

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		TimeUnit.SECONDS.sleep(4);

	}

	// edge Browser setup

	public void MicrosoftEdgeBrowser() throws InterruptedException {

		System.setProperty("webdriver.edge.driver",edgeDriverPath);

		driver = new EdgeDriver();
		driver.manage().window().maximize();
		TimeUnit.SECONDS.sleep(4);
	}

	public static void openUrl() throws InterruptedException {
		
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	}
	public static void loadProperties() throws IOException {

		Properties prop = new Properties();

		FileInputStream readFile = new FileInputStream("C:\\Users\\2269360\\eclipse-workspace\\QuoraSearch\\src\\code\\config.properties");

		prop.load(readFile);

		url = prop.getProperty("url");

		Searchtext = prop.getProperty("Searchtext");
		name = prop.getProperty("name");
		email = prop.getProperty("email");

		chromeDriverPath = prop.getProperty("chromeDriverPath");

		edgeDriverPath = prop.getProperty("edgeDriverPath");

		}
	public void quit() {
		driver.quit();
	}
}
