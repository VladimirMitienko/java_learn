package ru.stqa.pft.addressbook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class ChromeTest {

  WebDriver driver;

  @BeforeAll
  static void setupClass() {
    WebDriverManager.chromedriver().setup();
  }

  @BeforeEach
  void setupTest() {
    driver = new ChromeDriver();
    driver.get("http://localhost:8080/addressbook/index.php");
    login("admin", "secret");
  }

  private void login(String username, String password) {
    driver.manage().window().setSize(new Dimension(1680, 1025));
    driver.findElement(By.name("user")).sendKeys(username);
    driver.findElement(By.name("pass")).sendKeys(password);
    driver.findElement(By.cssSelector("input:nth-child(7)")).click();
  }

  @AfterEach
  void teardown() {
    if (driver != null) {
      driver.quit();
    }
  }

  @Test
  void testGroupCreation() {
    goToGroupPage();
    initGroup();
    fillGroup(new GroupData("test1", "test2", "test3"));
    submitGroup();
    returnToGroupPage();
    // Your test logic here
  }

  private void returnToGroupPage() {
    driver.findElement(By.linkText("Logout")).click();
  }

  private void submitGroup() {
    driver.findElement(By.linkText("groups")).click();
  }

  private void fillGroup(GroupData groupData) {
    driver.findElement(By.name("group_name")).click();
    driver.findElement(By.name("group_name")).sendKeys(groupData.getName());
    driver.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    driver.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    driver.findElement(By.name("submit")).click();
  }

  private void initGroup() {
    driver.findElement(By.name("new")).click();
  }

  private void goToGroupPage() {
    driver.findElement(By.linkText("groups")).click();
  }

}