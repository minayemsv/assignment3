import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class assignment3 {
   public WebDriver driver;
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\user\\Downloads\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://parabank.parasoft.com/parabank/admin.htm");
    }

    @Test (priority = 1)
    public void logintestcase() {
        driver.findElement(By.xpath("//input[@name = \"username\"]")).sendKeys("minaye.msv"); //Sending name
        driver.findElement(By.xpath("//input[@name = \"password\"]")).sendKeys("18Dekabr2002"); // Sending PWD
        driver.findElement(By.xpath("//input[@class= \"button\"]")).click();
    }

    @Test (priority = 2)
    public void opennewaccount() {
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/ul/li[1]/a")).click();
        Select accounttype = new Select(driver.findElement(By.xpath("//*[@id=\"type\"]")));
        accounttype.selectByValue("0");
        Select amount = new Select(driver.findElement(By.xpath("//*[@id=\"fromAccountId\"]")));
        amount.selectByValue("16674");
        driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div/input")).click();
    }

    @Test (priority = 3)
    public void requestloan() {
        driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[7]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"amount\"]")).sendKeys("1000");
        driver.findElement(By.xpath("//*[@id=\"downPayment\"]")).sendKeys("100");
        Select fromaccount = new Select(driver.findElement(By.xpath("//*[@id=\"fromAccountId\"]")));
        fromaccount.selectByValue("14676");
        driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/form/table/tbody/tr[4]/td[2]/input")).click();
    }
    @Test (priority = 4)
    public void findtransactions() {
        driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[5]/a")).click();
        Select account = new Select(driver.findElement(By.xpath("//*[@id=\"accountId\"]")));
        account.selectByValue("14676");
        driver.findElement(By.xpath("//*[@id=\"criteria.amount\"]")).sendKeys("1000");
        driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div[9]/button")).click();
    }
    @Test (priority = 5)
    public void transferfund() {
        driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[3]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"amount\"]")).sendKeys("100");
        Select fromaccount = new Select(driver.findElement(By.xpath("//*[@id=\"fromAccountId\"]")));
        fromaccount.selectByValue("17007");
        Select toaccount = new Select(driver.findElement(By.xpath("//*[@id=\"toAccountId\"]")));
        toaccount.selectByValue("14676");
        driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div[2]/input")).click();
    }
    @AfterClass
    public void tearDown() {
            driver.close();
        }
}