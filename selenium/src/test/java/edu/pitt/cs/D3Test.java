package edu.pitt.cs;
import static org.hamcrest.MatcherAssert.assertThat;

// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.MatcherAssert.assertThat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class D3Test {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void tEST1LINKS() {
    driver.get("https://cs1632.appspot.com//");
    {
      List<WebElement> elements = driver.findElements(By.xpath("//a[contains(@href, \'/reset\')]"));
      assert(elements.size() > 0);
    }
    driver.findElement(By.xpath("//a[contains(@href, \'/reset\')]")).click();
    {
      WebElement element = driver.findElement(By.xpath("//a[contains(@href, \'/reset\')]"));
      String attribute = element.getAttribute("href");
      vars.put("link", attribute);
    }
    assertEquals("https://cs1632.appspot.com/reset", vars.get("link").toString());
  }
  @Test
  public void tEST2RESET() {
    driver.get("https://cs1632.appspot.com//");
    js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
    js.executeScript("document.cookie = \"1=true\";document.cookie = \"2=true\";document.cookie = \"3=true\";");
    // Click reset
    driver.findElement(By.xpath("//a[contains(text(),\'Reset\')]")).click();
    assertThat(driver.findElement(By.xpath("//div[@id=\'listing\']/ul/li")).getText(), is("ID 1. Jennyanydots"));
    assertThat(driver.findElement(By.xpath("//div[@id=\'listing\']/ul/li[2]")).getText(), is("ID 2. Old Deuteronomy"));
    assertThat(driver.findElement(By.xpath("//div[@id=\'listing\']/ul/li[3]")).getText(), is("ID 3. Mistoffelees"));
  }
  @Test
  public void tEST3CATALOG() {
    driver.get("https://cs1632.appspot.com//");
    js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
    driver.findElement(By.xpath("//a[contains(@href, \'/\')]")).click();
    {
      WebElement element = driver.findElement(By.cssSelector("li:nth-child(3) > img"));
      String attribute = element.getAttribute("src");
      vars.put("img", attribute);
    }
    assertEquals("https://cs1632.appspot.com/images/cat2.jpg", vars.get("img").toString());
  }

  @Test
  public void tEST4LISTING() {
    driver.get("https://cs1632.appspot.com//");
    js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
    driver.findElement(By.xpath("//a[contains(text(),\'Catalog\')]")).click();
    {
      List<WebElement> elements = driver.findElements(By.xpath("//div[@id=\'listing\']/ul/li[3]"));
      assert(elements.size() > 0);
    }
    {
      List<WebElement> elements = driver.findElements(By.xpath("//div[@id=\'listing\']/ul/li[4]"));
      assert(elements.size() == 0);
    }
    assertThat(driver.findElement(By.xpath("//div[@id=\'listing\']/ul/li[3]")).getText(), is("ID 3. Mistoffelees"));
  }

  @Test
  public void tEST5RENTACAT() {
    driver.get("https://cs1632.appspot.com//");
    js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
    driver.findElement(By.xpath("//a[contains(text(),\'Rent-A-Cat\')]")).click();
    {
      List<WebElement> elements = driver.findElements(By.xpath("//button[contains(.,\'Rent\')]"));
      assert(elements.size() > 0);
    }
    {
      List<WebElement> elements = driver.findElements(By.xpath("//button[contains(.,\'Return\')]"));
      assert(elements.size() > 0);
    }
  }
  @Test
  public void tEST6RENT() {
    driver.get("https://cs1632.appspot.com//");
    js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
    driver.findElement(By.xpath("//a[contains(text(),\'Rent-A-Cat\')]")).click();
    driver.findElement(By.xpath("//input[@id=\'rentID\']")).click();
    driver.findElement(By.xpath("//input[@id=\'rentID\']")).sendKeys("1");
    driver.findElement(By.xpath("//button[@onclick=\'rentSubmit()\']")).click();
    assertThat(driver.findElement(By.xpath("//div[@id=\'listing\']/ul/li")).getText(), is("Rented out"));
    assertThat(driver.findElement(By.xpath("//div[@id=\'listing\']/ul/li[2]")).getText(), is("ID 2. Old Deuteronomy"));
    assertThat(driver.findElement(By.xpath("//div[@id=\'listing\']/ul/li[3]")).getText(), is("ID 3. Mistoffelees"));
    assertThat(driver.findElement(By.xpath("//div[@id=\'rentResult\']")).getText(), is("Success!"));
  }
  @Test
  public void tEST7RETURN() {
    driver.get("https://cs1632.appspot.com//");
    js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
    js.executeScript("document.cookie = \"2=true\";");
    driver.findElement(By.xpath("//a[contains(text(),\'Rent-A-Cat\')]")).click();
    driver.findElement(By.xpath("//input[@id=\'returnID\']")).click();
    driver.findElement(By.xpath("//input[@id=\'returnID\']")).sendKeys("2");
    driver.findElement(By.xpath("//button[@onclick=\'returnSubmit()\']")).click();
    assertThat(driver.findElement(By.xpath("//div[@id=\'listing\']/ul/li")).getText(), is("ID 1. Jennyanydots"));
    assertThat(driver.findElement(By.xpath("//div[@id=\'listing\']/ul/li[2]")).getText(), is("ID 2. Old Deuteronomy"));
    assertThat(driver.findElement(By.xpath("//div[@id=\'listing\']/ul/li[3]")).getText(), is("ID 3. Mistoffelees"));
    assertThat(driver.findElement(By.xpath("//div[@id=\'returnResult\']")).getText(), is("Success!"));
  }
  @Test
  public void tEST8FEEDACAT() {
    driver.get("https://cs1632.appspot.com//");
    js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
    driver.findElement(By.xpath("//a[contains(text(),\'Feed-A-Cat\')]")).click();
    {
      List<WebElement> elements = driver.findElements(By.xpath("//button[contains(.,\'Feed\')]"));
      assert(elements.size() > 0);
    }
  }
  @Test
  public void tEST9FEED() {
    driver.get("https://cs1632.appspot.com//");
    js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
    driver.findElement(By.xpath("//a[contains(text(),\'Feed-A-Cat\')]")).click();
    driver.findElement(By.xpath("//input[@id=\'catnips\']")).click();
    driver.findElement(By.xpath("//input[@id=\'catnips\']")).sendKeys("6");
    driver.findElement(By.xpath("//button[@onclick=\'setTimeout(feedSubmit, 1000)\']")).click();
    {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'feedResult\' and text()=\'Nom, nom, nom.\']")));
    }
    assertThat(driver.findElement(By.xpath("//div[@id=\'feedResult\']")).getText(), is("Nom, nom, nom."));
  }
  @Test
  public void tEST10GREETACAT() {
    driver.get("https://cs1632.appspot.com//");
    js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
    driver.findElement(By.xpath("//a[contains(text(),\'Greet-A-Cat\')]")).click();
    assertThat(driver.findElement(By.xpath("//div[@id=\'greeting\']/h4")).getText(), is("Meow!Meow!Meow!"));
  }
  @Test
  public void tEST11GREETACATWITHNAME() {
    driver.get("https://cs1632.appspot.com//");
    js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
    driver.get("https://cs1632.appspot.com//greet-a-cat/Jennyanydots");
    assertThat(driver.findElement(By.xpath("//div[@id=\'greeting\']/h4")).getText(), is("Meow! from Jennyanydots."));
  }
  @Test
  public void dEFECT1FUNGREETACAT() {
    driver.get("https://cs1632.appspot.com//");
    js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
    driver.findElement(By.xpath("//a[contains(text(),\'Rent-A-Cat\')]")).click();
    driver.findElement(By.xpath("//input[@id=\'rentID\']")).click();
    driver.findElement(By.xpath("//input[@id=\'rentID\']")).sendKeys("1");
    driver.findElement(By.xpath("//button[@onclick=\'rentSubmit()\']")).click();
    driver.findElement(By.xpath("//a[contains(text(),\'Greet-A-Cat\')]")).click();
    driver.findElement(By.xpath("//div[@id=\'greeting\']/h4")).click();
    assertThat(driver.findElement(By.xpath("//div[@id=\'greeting\']/h4")).getText(), is("Meow!Meow!"));
  }
  @Test
  public void dEFECT2FUNGREETACATWITHNAME() {
    driver.get("https://cs1632.appspot.com//");
    js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
    driver.findElement(By.xpath("//a[contains(text(),\'Rent-A-Cat\')]")).click();
    driver.findElement(By.xpath("//input[@id=\'rentID\']")).click();
    driver.findElement(By.xpath("//input[@id=\'rentID\']")).sendKeys("1");
    driver.findElement(By.xpath("//button[@onclick=\'rentSubmit()\']")).click();
    driver.get("https://cs1632.appspot.com//greet-a-cat/Jennyanydots");
    assertThat(driver.findElement(By.xpath("//div[@id=\'greeting\']/h4")).getText(), is("Jennyanydots is not here."));
  }
  @Test
  public void dEFECT3FUNFEED() {
    driver.get("https://cs1632.appspot.com//");
    js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
    driver.findElement(By.xpath("//a[contains(text(),\'Feed-A-Cat\')]")).click();
    driver.findElement(By.xpath("//input[@id=\'catnips\']")).click();
    driver.findElement(By.xpath("//input[@id=\'catnips\']")).sendKeys("0");
    driver.findElement(By.xpath("//button[@onclick=\'setTimeout(feedSubmit, 1000)\']")).click();
    {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'feedResult\' and text()=\'Nom, nom, nom.\']")));
    }
    driver.findElement(By.xpath("//div[@id=\'feedResult\']")).click();
    assertThat(driver.findElement(By.xpath("//div[@id=\'feedResult\']")).getText(), is("Cat fight!"));
  }
}
