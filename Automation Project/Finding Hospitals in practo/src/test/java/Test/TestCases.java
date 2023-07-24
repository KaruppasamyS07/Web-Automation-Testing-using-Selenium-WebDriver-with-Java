package Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import Pages.HospitalNames;
import Pages.TopCities;
import Pages.CoporateWellness;

public class TestCases {

	private HospitalNames hospitalNames = new HospitalNames();
	private TopCities topCities = new TopCities();
	private CoporateWellness coporateWellness = new CoporateWellness();
	private ExtentReports extendreports;
	private ExtentTest extendTest;

	@BeforeTest(alwaysRun = true)
	@Parameters("browserName")
	public void driverSetup(String browserName) throws IOException {
		hospitalNames.setDriver(browserName);
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "\\reports\\" + browserName + " " + "extentReport.html");
		htmlReporter.config().setDocumentTitle(browserName + " - Finding Hospitals Report");
		htmlReporter.config().setReportName("Test report");
		extendreports = new ExtentReports();
		extendreports.attachReporter(htmlReporter);
	}

	@Test(priority = 1)
	public void selectCity() throws Exception {
		extendTest = extendreports.createTest("Module:1 Display the hospital names");
		try {
			hospitalNames.selectCity();
			extendTest.log(Status.INFO, "Bangalore city is selected Successfully");
		} catch (Exception e) {
			extendTest.log(Status.FAIL, e.getMessage());
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = "selectCity")
	public void cityDropDown() throws Exception {
		try {
			hospitalNames.cityDropDown();
			extendTest.log(Status.INFO, "city dropdown is selected Successfully");
		} catch (Exception e) {
			extendTest.log(Status.FAIL, e.getMessage());
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = "cityDropDown")
	public void selectHospital() throws Exception {
		try {
			hospitalNames.selectHospital();
			extendTest.log(Status.INFO, "hospital is selected Successfully");
		} catch (Exception e) {
			extendTest.log(Status.FAIL, e.getMessage());
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = "selectHospital")
	public void hospitalDropDown() throws Exception {
		try {
			hospitalNames.hospitalDropDown();
			extendTest.log(Status.INFO, "hospital dropdown is selected Successfully");
		} catch (Exception e) {
			extendTest.log(Status.FAIL, e.getMessage());
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = "hospitalDropDown")
	public void validation() throws Exception {
		try {
			hospitalNames.validation();
			extendTest.log(Status.INFO, "search results is validated Successfully");
		} catch (Exception e) {
			extendTest.log(Status.FAIL, e.getMessage());
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = "validation")
	public void printTheValidatedDetails() throws Exception {
		try {
			hospitalNames.printTheValidatedDetails();
			extendTest.log(Status.INFO, "Hospital Names are displayed Successfully");
		} catch (Exception e) {
			extendTest.log(Status.FAIL, e.getMessage());
			throw new Exception(e);
		}
	}

	@Test(priority = 2)
	public void clickDiagnosisPage() throws Exception {
		extendTest = extendreports.createTest("Module:2 Diagnostics page");
		try {
			topCities.clickDiagnosisPage();
			extendTest.log(Status.INFO, "diagnosis button is clicked Successfully");
		} catch (Exception e) {
			extendTest.log(Status.FAIL, e.getMessage());
			throw new Exception(e);
		}

	}

	@Test(dependsOnMethods = "clickDiagnosisPage")
	public void printTheCities() throws Exception {
		try {
			topCities.printTheCities();
			extendTest.log(Status.INFO, "popular city names are displayed Successfully");
		} catch (Exception e) {
			extendTest.log(Status.FAIL, e.getMessage());
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = "printTheCities", groups = { "Diagnostics pages" })
	public void clickTOExitThePage() throws Exception {
		topCities.clickTOExitThePage();
	}

	@Test(priority = 3)
	public void wellNess() throws Exception {
		extendTest = extendreports.createTest("Module:3 Corporate Wellness page");
		try {
			coporateWellness.wellNess();
			extendTest.log(Status.INFO, "WellNess plans button is clicked Successfully");
		} catch (Exception e) {
			extendTest.log(Status.FAIL, e.getMessage());
			throw new Exception(e);
		}
	}

	@Test(dependsOnMethods = "wellNess")
	public void fillDetails() throws Exception {
		try {
			coporateWellness.fillDetails();
			extendTest.log(Status.INFO, "Invalid Details are entered");
			extendTest.log(Status.INFO, "Screenshot is taken Successfully");
		} catch (Exception e) {
			extendTest.log(Status.FAIL, e.getMessage());
			throw new Exception(e);
		}
	}

	@AfterTest(alwaysRun = true)
	public void closeBrowser() throws InterruptedException, IOException {
		TimeUnit.SECONDS.sleep(5);
		extendreports.flush();
		hospitalNames.driverClose();
	}
}
