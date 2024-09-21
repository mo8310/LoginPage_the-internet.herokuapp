import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class test {
    public static void main(String[] args) {

        //TC_01 --> login with valid username & valid password
        // 1. open browser
        WebDriver driver1 = new ChromeDriver();
        // 2. Navigate login page
        driver1.navigate().to("https://the-internet.herokuapp.com/login");
        //3. locate Username and enter username
        driver1.findElement(By.id("username")).sendKeys("tomsmith");
        //4. Locate Password and Enter password
        driver1.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        //5. Locate login button and click login button
        driver1.findElement(By.xpath("//button[@type='submit']")).click();
        //6. Assert that welcome message is displayed
        Assert.assertTrue(driver1.findElement(By.className("subheader")).isDisplayed());
        Assert.assertEquals(driver1.getCurrentUrl(),"https://the-internet.herokuapp.com/secure");
        //7. Task
        Assert.assertEquals(driver1.findElement(By.className("subheader")).getText(), "Welcome to the Secure Area. When you are done click logout below.", "The welcome message is incorrect!");
        //8. Close Browser
        driver1.close();


        // TC_02 --> Login with invalid Username & valid password
        //1. open browser
        WebDriver driver2 = new ChromeDriver();
        //2. Navigate login page
        driver2.navigate().to("https://the-internet.herokuapp.com/login");
        //3. Locate invalid Username & enter username
        driver2.findElement(By.id("username")).sendKeys("invalid");
        //4. Locate valid Password & enter password
        driver2.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        //5. Locate Login Button
        driver2.findElement(By.cssSelector("button[type='submit']")).click();
        //6. Task
        Assert.assertEquals(driver2.findElement(By.id("flash")).getText(), "Your username is invalid!\n" + "×", "The message is incorrect!");
        //7. Close Browser
        driver2.close();

        // TC_03 --> Login with valid Username & Invalid password
        //1. Open Browser
        WebDriver driver3 = new ChromeDriver();
        //2. Navigate login page
        driver3.navigate().to("https://the-internet.herokuapp.com/login");
        //3. Locate valid Username & enter username
        driver3.findElement(By.id("username")).sendKeys("tomsmith");
        //4. Locate invalid Password & enter password
        driver3.findElement(By.id("password")).sendKeys("invalid");
        //5. Locate Login button
        driver3.findElement(By.xpath("//button[@type='submit']")).click();
        //6. Task
        Assert.assertEquals(driver3.findElement(By.id("flash")).getText(), "Your password is invalid!\n" + "×", "The message is incorrect!");
        //7. Close Browser
        driver3.close();

    }
}
