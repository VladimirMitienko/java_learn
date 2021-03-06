package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
      System.setProperty("webdriver.chrome.driver", "/Users/mva/Public/chromedriver_mac64/chromedriver");
      driver = new ChromeDriver();
      driver.get("http://localhost:8080/addressbook/index.php");
      login("admin", "secret");

    }

    private void login(String username, String password) {
      driver.findElement(By.name("user")).click();
      driver.findElement(By.name("user")).clear();
      driver.findElement(By.name("user")).sendKeys(username);
      driver.findElement(By.name("pass")).clear();
      driver.findElement(By.name("pass")).sendKeys(password);
      driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    protected void logout() {
      driver.findElement(By.linkText("Logout")).click();
    }

    protected void returnToGroupPage() {
      driver.findElement(By.linkText("groups")).click();
    }

    protected void fillForm(GroupData groupData) {
      driver.findElement(By.name("group_name")).click();
      driver.findElement(By.name("group_name")).clear();
      driver.findElement(By.name("group_name")).sendKeys(groupData.getName());
      driver.findElement(By.name("group_header")).click();
      driver.findElement(By.name("group_header")).clear();
      driver.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
      driver.findElement(By.name("group_footer")).click();
      driver.findElement(By.name("group_footer")).clear();
      driver.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
      driver.findElement(By.name("submit")).click();
    }

    protected void initGroup() {
      driver.findElement(By.name("new")).click();
    }

    protected void gotoGroup() {
      driver.findElement(By.linkText("groups")).click();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
      driver.quit();
    }

    protected void deleteSelectedGroups() {
      driver.findElement(By.name("delete")).click();
    }

    protected void selectGroup() {
      driver.findElement(By.name("selected[]")).click();
    }
}
