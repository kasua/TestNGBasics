package Utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods {

	public static WebDriver driver;

	public static void setUpDriver(String browser, String url) {

		if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {

			// System.setProperty("webdriver.chrome.driver",
			// "C:/Users/amera/Selenium/chromedriver.exe");
			// driver = new ChromeDriver();

			System.setProperty("webdriver.gecko.driver", "src/drivers/geckodriver.exe");
			driver = new FirefoxDriver();

		} else {

			System.out.println("browser given is wrong");
		}

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); // applied for get() and navigate()
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // applied for findElement(), findElements();

		driver.manage().window().maximize();
		driver.get(url);
	}

	/**
	 * This method will select a specified value from a drop down
	 * 
	 * @author Kasu
	 * @param Select element, String text
	 */

	public static void selectValueFromDD(WebElement element, String text) {
		Select select = new Select(element);
		List<WebElement> list = select.getOptions();

		boolean isSelected = false;
		for (WebElement e : list) {
			if (e.getText().equals(text)) {
				select.selectByVisibleText(text);
				System.out.println(text + " is selected");
				isSelected = true;
				break;
			}
		}
		if (!isSelected) {
			System.out.println(text + "is NOT selected");
		}
	}

	/**
	 * This method will select a specified value from a drop down
	 * 
	 * @author Kasu
	 * @param WebElement element, int index
	 */
	public static void selectValueFromDD(WebElement element, int index) {

		Select select = new Select(element);
		List<WebElement> list = select.getOptions();

		if (index > list.size() || index < 0) {
			throw new IndexOutOfBoundsException("Invalid index " + index + " is passed");
		} else {
			select.selectByIndex(index);
			System.out.println("index " + index + " is selected");
		}
	}

	/**
	 * This method will select a specified value from a drop down
	 * 
	 * @author Kasu
	 * @param WebElement element, String value
	 */
	public static void selectValuefromDD(WebElement element, String value) {
		Select select = new Select(element);
		List<WebElement> list = select.getOptions();

		boolean isSelected = false;
		for (WebElement e : list) {
			if (e.getAttribute(value).equals(value)) {
				select.selectByValue(value);
				isSelected = true;
				System.out.println("Attribute Value " + value + " is selected");
				break;
			}
		}
		if (!isSelected) {
			System.out.println("Attribute Value " + value + " is NOT selected");
		}
	}

	/**
	 * This method will accept Alert
	 * 
	 * @author Kasu
	 * @throws NoAlertPresentException if alert is not present
	 */
	public static void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will dismiss Alert
	 * 
	 * @author Kasu
	 * @throws NoAlertPresentException if alert is not present
	 */
	public static void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will return Alert Text
	 * 
	 * @author Kasu
	 * @throws NoAlertPresentException if alert is not present
	 */
	public static String getAlertText() {
		try {
			Alert alert = driver.switchTo().alert();
			return alert.getText();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * This method send String keys into textbox
	 * 
	 * @author Kasu
	 * @param WebElement element, String keys
	 * @exception FrameNotFoundException
	 */
	public static void sendKeys(WebElement element, String keys) {
		element.clear();
		element.sendKeys(keys);
	}

	/**
	 * Method that will switch control to the specified frame
	 * 
	 * @param String frame id or frame name
	 */
	public static void switchToFrame(String idOrName) {
		try {
			driver.switchTo().frame(idOrName);
			System.out.println("Switched to Frame");
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method that will switch control to the specified frame
	 * 
	 * @param int index
	 */
	public static void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
			System.out.println("Switched to Frame");
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method that will switch control to the specified frame
	 * 
	 * @param WebElement element
	 */
	public static void switchToFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);
			System.out.println("Switched to Frame");
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method that will check specified radio button
	 * 
	 * @param List<WebElement> list, String text
	 */
	public static void checkRadioButton(List<WebElement> list, String text) {
		boolean isSelected = false;
		for (WebElement e : list) {
			if (e.isEnabled()) {
				// System.out.println(e.getText());
				if (e.getText().contains(text)) {
					System.out.println(text + " is selected");
					isSelected = true;
					e.click();
					break;
				}
			} else {
				System.out.println("Button is NOT enabled");
			}
		}
		if (!isSelected) {
			System.out.println(text + " is NOT selected");
		}
	}

	/**
	 * Need to facinate Method that will check specified checkbox button
	 * 
	 * @param List<WebElement> list, String text
	 */
	public static void checkCheckBoxes(List<WebElement> list, String text) {
		boolean isSelected = false;
		for (WebElement e : list) {
			if (e.isEnabled()) {
				if (e.getText().contains(text)) {
					System.out.println(text + " is selected");
					isSelected = true;
					e.click();
					break;
				}
			} else {
				
				System.out.println("CheckBox is NOT enabled");
			}
		}
		
		if (!isSelected) {
			System.out.println(text + " is NOT selected");
		}
	}

	/**
	 * This method will click the specified WebElement
	 * 
	 * @author Kasu
	 * @param WebElement element
	 */

	public static void clickElement(WebElement element) {

		if (element.isDisplayed()) {

			element.click();
			}
		}

	/**
	 * This method will close the WebDriver
	 * 
	 * @author Kasu
	 */

	public static void closeDriver() {

		driver.close();
	}

	/**
	 * This method will quit the WebDriver
	 * 
	 * @author Kasu
	 */

	public static void quitDriver() {

		driver.quit();
	}
}
