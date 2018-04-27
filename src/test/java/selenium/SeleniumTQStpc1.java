package selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTQStpc1 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSeleniumTQStpc1() throws Exception {
    driver.get("http://localhost:8080/TQStpc1/");
    new Select(driver.findElement(By.id("j_idt5:from"))).selectByVisibleText("EUR");
    driver.findElement(By.id("j_idt5:from")).click();
    new Select(driver.findElement(By.id("j_idt5:to"))).selectByVisibleText("GBP");
    driver.findElement(By.id("j_idt5:to")).click();
    driver.findElement(By.id("j_idt5:amount")).click();
    driver.findElement(By.id("j_idt5:amount")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | id=j_idt5:amount | ]]
    driver.findElement(By.id("j_idt5:amount")).clear();
    driver.findElement(By.id("j_idt5:amount")).sendKeys("1");
    driver.findElement(By.id("j_idt5")).submit();
    driver.findElement(By.name("j_idt5:j_idt13")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
