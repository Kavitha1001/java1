package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilits.ReadData;

public class ProjectSpecificMethods  {

	private static final ThreadLocal<RemoteWebDriver> remoteWebDriver= new ThreadLocal<RemoteWebDriver>();
	public String  excelFileName = "";
	public static ExtentReports extent;
	public static ExtentTest test;

	public String testName, testDescription, testAuthor, testCategory; 

	@BeforeSuite
	public void startReport() {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Report2/result.html");
		reporter.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	@BeforeClass
	public void testcaseDetails() {
		test = extent.createTest(testName,testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
	}

	public int takesnap() throws IOException {
		int ranNum= (int) (Math.random()*99999+1000000);
		File source= getDriver().getScreenshotAs(OutputType.FILE);
		File target= new File("./snaps/img"+ranNum+".png");
		FileUtils.copyFile(source, target);
		return ranNum;
	}
   
 public void reportstep(String stepDesc,String status) throws IOException {
	 MediaEntityModelProvider build= MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/desktop.png").build();
 }

	@AfterSuite
	public void stopReport() {
		extent.flush();
	}
	//setter method for driver

	public void setDriver() {
		remoteWebDriver.set(new ChromeDriver());  
	}

	public RemoteWebDriver getDriver() {
		return remoteWebDriver.get();
	}




	@BeforeMethod
	public void init()
	{
		WebDriverManager.chromedriver().setup();
		setDriver();

		getDriver().get("http://leaftaps.com/opentaps/control/main");
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@AfterMethod
	public void teardown() {

		getDriver().close();
	}

	@DataProvider(name="fetch")
	public String[][] fetchData() throws IOException {

		String[][] data = ReadData.readData(excelFileName);
		return data;
	}



}


