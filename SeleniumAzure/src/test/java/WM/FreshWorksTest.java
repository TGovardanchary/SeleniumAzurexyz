package WM;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FreshWorksTest {
	WebDriver driver;

	@BeforeMethod
	@Parameters("browser")
	public void setup(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			// DesiredCapabilities cap = new DesiredCapabilities();
			// cap.setCapability("browserName", "chrome");
			// try {
			// driver = new RemoteWebDriver(new
			// URL("http://13.233.116.37:4444/wd/hub"), cap);
			// } catch (MalformedURLException e) {
			// e.printStackTrace();
			// }
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			// DesiredCapabilities cap = new DesiredCapabilities();
			// cap.setCapability("browserName", "firefox");
			// try {
			// driver = new RemoteWebDriver(new
			// URL("http://13.233.116.37:4444/wd/hub"), cap);
			// } catch (MalformedURLException e) {
			// e.printStackTrace();
			// }

		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");

	}

	
	@Test(priority = 1)
	public void freshWorksTitleTest() {
		System.out.println("running title test...");
		System.out.println(driver.getTitle());
		assertEquals(driver.getTitle(), "Facebook – log in or sign up");
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
