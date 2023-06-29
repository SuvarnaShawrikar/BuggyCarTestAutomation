package test;
import static org.testng.Assert.assertTrue;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginPage {
	@Test
	/**
	 * Login Method - Implement test for Login
	 * Method to check successful login.
	 * @throws InterruptedException 
	 * @throws URISyntaxException 
	 */
	void loginTestCase() throws InterruptedException, URISyntaxException {
		// Invoke the web browser and navigating to the website.
		URL resource = getClass().getResource("chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",Paths.get(resource.toURI()).toFile().getAbsolutePath());
		WebDriver driver = new ChromeDriver();
		driver.get("https://buggy.justtestit.org/");
		
		// Define variables for login
        String userName = "Buggy1234";
        String password = "Abcd@123";
				
		// Enter Username & password to login.
       	WebElement username = driver.findElement(By.name("login"));
		username.sendKeys(userName);
		WebElement pw = driver.findElement(By.name("password"));
		pw.sendKeys(password);		
		
		// Click on the Login button.
		driver.findElement(By.xpath("/html/body/my-app/header/nav/div/my-login/div/form/button")).click();
		
		voteTestCase(driver);
	}
	/**
	 * 
	 * Since user have already voted for sports car, 
	 * user will be unable to vote for the same car
	 * @param driver
	 * @throws InterruptedException
	 */
	void voteTestCase(WebDriver driver) throws InterruptedException {
		//Click on Popular Make image.
		driver.findElement(By.xpath("/html/body/my-app/div/main/my-home/div/div[1]/div/a/img")).click();
		
		Thread.sleep(5000);
	
		//Select sports car to vote
		driver.findElement(By.xpath("//a[text()='Giulietta']")).click();
				
		Thread.sleep(3000);

		// Check whether the message for voting was successful or not
		WebElement msg = driver.findElement(By.xpath("//p[@class='card-text']"));
		String actualString = msg.getText();
		assertTrue(actualString.contains("Thank you for your vote!"));
		
		//Close the bowser
		driver.close();
				
	}

}
