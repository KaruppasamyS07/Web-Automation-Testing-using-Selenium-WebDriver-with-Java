package Selenium;
import java.time.Duration;

import java.util.NoSuchElementException;

import java.util.Scanner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.WebDriverWait;

public class facebookSignUp {
static WebDriver driver;



public static void chromeBrowser() {

System.setProperty("webdriver.chrome.driver", "C:\\Users\\2269530\\chromedriver\\chromedriver.exe");

driver = new ChromeDriver();

}

public static void EdgeBrowser() {

System.setProperty("webdriver.edge.driver", "C:\\Users\\2269300\\Selenium\\webdriver\\chromedriver.exe");

driver = new EdgeDriver();

}

public static void main(String args[]) throws InterruptedException {

System.out.println("Select your browser 1.Chrome 2.Edge");

@SuppressWarnings("resource")

Scanner sc = new Scanner(System.in);

int choice = sc.nextInt();

if (choice == 1)

chromeBrowser();

else

EdgeBrowser();

// maximizing the browser

driver.manage().window().maximize();

// Opening facebook website

driver.get("http://www.fb.com");

WebElement createNewAccount = driver

.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));

createNewAccount.click();



// Sending values to firstname textbox By name

try {

driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Karuppasamy");


} catch (NoSuchElementException e) {

System.out.println("element not found");

}

driver.findElement(By.name("lastname")).sendKeys("S");

driver.findElement(By.name("reg_email__")).sendKeys("987654321");


WebElement days = driver.findElement(By.id("day"));

Select select = new Select(days);

select.selectByVisibleText("27");


WebElement months = driver.findElement(By.id("month"));

Select select1 = new Select(months);

select1.selectByIndex(5);


WebElement years = driver.findElement(By.id("year"));

Select select2 = new Select(years);

select2.selectByValue("2000");

driver.findElement(By.xpath("//input[@type='radio' and @value='1']")).click();

driver.findElement(By.name("websubmit")).click();

WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

// password

wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[1][@class=\"_5633 _5634 _53ij\"]")));

WebElement error1 = driver.findElement(By.xpath("//div[1][@class=\"_5633 _5634 _53ij\"]"));

System.out.println(error1.getText());

Thread.sleep(3000);

// mobile number

driver.findElement(By.name("reg_email__")).click();

Thread.sleep(3000);

WebElement error2 = driver.findElement(By.xpath("//div[1][@class=\"_5633 _5634 _53ij\" and text()='Please enter a valid mobile number or email address.']"));

String errorMsg2 = error2.getText();

System.out.println(errorMsg2);

Thread.sleep(5000);

driver.close();

}

}