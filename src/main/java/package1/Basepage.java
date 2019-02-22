package package1;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Basepage {
	public static WebDriver driver;
	public String browser = "chrome";
	public Basepage() {
		if (driver == null) {
			if (browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver","C:\\Users\\Meghraj\\Downloads\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\Meghraj\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver");
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.get("http://automationpractice.com/index.php");
		}
	}
	public void clickElement(WebElement element) {
		element.click();
		}
	public String getTxtAttribute(WebElement element) {
		return element.getAttribute("value");
	}
	public void setText(WebElement element, String name) {
		if (name != null){
			element.click();
		    element.clear();
			element.sendKeys(name);
		}
	}
	public boolean isElementVisible(WebElement element){
		try {
			WebDriverWait wait = new WebDriverWait(driver, 90);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public String getTitle() {
		return driver.getTitle();
	}	
	public void navigateBack(){
		driver.navigate().back();
	}
	public void quitDriver(){
		driver.quit();
	}
	public void mouseHover(WebElement element){
		Actions ac=new Actions(driver);
		ac.moveToElement(element).build().perform();
		ac.contextClick(element).sendKeys(Keys.ARROW_DOWN).build().perform();
	}
}
