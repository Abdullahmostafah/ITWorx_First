import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Educational {


    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://swinji.azurewebsites.net");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS );

        driver.findElement(By.id("Email")).sendKeys("testregister@aaa.com");
        driver.findElement(By.id("inputPassword")).sendKeys("Wakram_123");
        driver.findElement(By.id("btnLogin")).click();
        Thread.sleep(3000);

        driver.findElement(By.id("btnMyCoursesList")).click();
        driver.findElement(By.id("btnListAddCourse")).click();
        driver.findElement(By.name("courseName")).sendKeys("algebra");
        WebElement Grade = driver.findElement(By.name("courseGrade"));
        Select grade = new Select(Grade);
        grade.selectByValue("number:3");
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/fieldset[1]/div[4]/div[2]/div[4]/div[3]/div[1]/div[1]/div[1]/span[1]/span[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/fieldset[1]/div[4]/div[2]/div[4]/div[3]/div[1]/div[1]/ul[1]/li[1]/div[3]/span[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/fieldset[1]/div[4]/div[2]/div[5]/div[2]/div[1]/label[1]/em[1]")).click();
        driver.findElement(By.id("btnSaveAsDraftCourse")).click();
        driver.findElement(By.id("btnMyCoursesList")).click();
        driver.switchTo().alert().accept();


        driver.findElement(By.id("btnMyCoursesList")).click();
        driver.findElement(By.id("txtCourseSearch")).sendKeys("Math");
        driver.findElement(By.id("txtCourseSearch")).submit();
        //String study = "algebra";
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'Math')]"));
        if ( list.size() > 0){
            System.out.println("Text: " + "Math" + " is present.");
        } else {
            System.out.println("Text: " + "Math" + " is not present.");
        }
        System.out.println(list.size());

        Thread.sleep(3000);
        driver.quit();
    }
}
