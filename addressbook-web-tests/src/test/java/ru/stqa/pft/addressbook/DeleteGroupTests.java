package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteGroupTests {
  private WebDriver driver;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "/Users/mva/Public/chromedriver_mac64/chromedriver");
    driver = new ChromeDriver();
  }

  @Test
  public void testDeleteGroup() throws Exception {
    driver.get("http://localhost:8080/addressbook/group.php");
    driver.findElement(By.name("user")).clear();
    driver.findElement(By.name("user")).sendKeys("admin");
    driver.findElement(By.name("pass")).clear();
    driver.findElement(By.name("pass")).sendKeys("secret");
    driver.findElement(By.id("LoginForm")).submit();
    driver.findElement(By.linkText("groups")).click();
    driver.findElement(By.name("selected[]")).click();
    driver.findElement(By.name("delete")).click();
    driver.findElement(By.linkText("group page")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
  }
}