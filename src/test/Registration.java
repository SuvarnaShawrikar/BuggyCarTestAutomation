package test;
import static org.testng.Assert.assertTrue;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * Class contains four test scenarios one for validating Positive Registration Work flow 
 * and for validating Password as per requirement, 
 * User password needs to be set with minimum 8 characters (1 Uppercase + 1 lowercase + 1 special character)
 * Work flow
 * 
 * @author Suvarna
 *
 */
public class Registration {
	@Test
	/**
	 * Registration Method - Implement test for Registration and then call Login
	 * Method to check successful login.
	 */
	void positiveRegistrationTestCase() throws URISyntaxException {

		// Invoke the web browser and navigating to the website.
		URL resource = getClass().getResource("chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",Paths.get(resource.toURI()).toFile().getAbsolutePath());
		WebDriver driver = new ChromeDriver();
		driver.get("https://buggy.justtestit.org/");
		
		// Click on Register button.
		WebElement register = driver.findElement(By.xpath("/html/body/my-app/header/nav/div/my-login/div/form/a"));
		register.click();
		
		// Define variables for registration
        String userName = "User"+System.currentTimeMillis();
        String firstName = "John";
        String lastName = "Doe";
        String password = "Password@123";
        		
        // Enter Username, Firstname, Lastname & password on registration form.
       	WebElement username = driver.findElement(By.id("username"));
		username.sendKeys(userName);
		WebElement firstname = driver.findElement(By.id("firstName"));
		firstname.sendKeys(firstName);
		WebElement lastname = driver.findElement(By.id("lastName"));
		lastname.sendKeys(lastName);
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.sendKeys(password);
		WebElement conPwd = driver.findElement(By.name("confirmPassword"));
		conPwd.sendKeys(password);
		
		// Click on the registration button to register as new user.
		driver.findElement(By.xpath("/html/body/my-app/div/main/my-register/div/div/form/button")).click();
		
		//Wait after registration to validate result.
		wait(driver);
			
		// Check whether the message on the registration was successful or not
		WebElement successMessage = driver.findElement(By.cssSelector("body > my-app > div > main > my-register > div > div > form > div.result.alert.alert-success"));
        String actualString = successMessage.getText();
        System.out.println("Success Message: " + actualString);
		assertTrue(actualString.contains("Registration is successful"));
		
		// Call login method
		login(driver, userName, password);
 
        // Close the browser
        driver.quit();
	
	}
	
	/**
	 * Login Method - Enters correct Credentials check if the user's first name is
	 * correctly displayed once logged in (i.e. Hi FirstName!) 
	 * @param driver
	 * @param username
	 * @param password
	 *
	 */
	void login(WebDriver driver, String username, String password) {
		// Wait for element to load.
		wait(driver);
	
	// Enter valid username & password and check whether login is successful.
	driver.findElement(By.xpath("/html/body/my-app/header/nav/div/my-login/div/form/div/input[1]")).sendKeys(username);
	driver.findElement(By.xpath("/html/body/my-app/header/nav/div/my-login/div/form/div/input[2]")).sendKeys(password);
	
	// Click on login button.
	driver.findElement(By.xpath("/html/body/my-app/header/nav/div/my-login/div/form/button")).click();
	
	}
	
	@Test
	/**
	 * Test whether password shows the error messages when
	 * password doesn't meet the requirement (Upper Case has not been specified).
	 * @throws URISyntaxException 
	 * 
	 */
	void negativeRegistrationTestCase() throws URISyntaxException {
		// Invoke the web browser and navigating to the website.
		URL resource = getClass().getResource("chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",Paths.get(resource.toURI()).toFile().getAbsolutePath());
				WebDriver driver = new ChromeDriver();
				driver.get("https://buggy.justtestit.org/");
				
				// Find the xpath for register and click on it.
				WebElement register = driver.findElement(By.xpath("/html/body/my-app/header/nav/div/my-login/div/form/a"));
				register.click();
				
				// Define variables for registration
		        String userName = "User";
		        String firstName = "John";
		        String lastName = "Doe";
		        String password = "password@123";
		        		
		        // Enter Username, Firstname, Lastname & password on registration form.
		       	WebElement username = driver.findElement(By.id("username"));
				username.sendKeys(userName);
				WebElement firstname = driver.findElement(By.id("firstName"));
				firstname.sendKeys(firstName);
				WebElement lastname = driver.findElement(By.id("lastName"));
				lastname.sendKeys(lastName);
				WebElement pwd = driver.findElement(By.id("password"));
				pwd.sendKeys(password);
				WebElement conPwd = driver.findElement(By.name("confirmPassword"));
				conPwd.sendKeys(password);
				
				// Click on the registration button.
				driver.findElement(By.xpath("/html/body/my-app/div/main/my-register/div/div/form/button")).click();
				
				//Wait after registration to validate result.
				wait(driver);
				
				// Check whether the message on the registration was successful or not
				WebElement errorMessage = driver.findElement(By.cssSelector("body > my-app > div > main > my-register > div > div > form > div.result.alert.alert-danger"));
		        String actualString = errorMessage.getText();
		        System.out.println("Error Message: " + actualString);
				assertTrue(actualString.contains("InvalidPasswordException: Password did not conform with policy: Password must have uppercase characters"));
				
				//Close Browser
				driver.quit();
	}

	@Test
	/**
	 * Test whether password shows the error messages when
	 * password doesn't meet the specification (Special character has not been specified).
	 * @throws URISyntaxException 
	 * 
	 */
	void PasswordValidationTestCase() throws URISyntaxException {
		// Invoke the web browser and navigating to the website.
		URL resource = getClass().getResource("chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",Paths.get(resource.toURI()).toFile().getAbsolutePath());
				WebDriver driver = new ChromeDriver();
				driver.get("https://buggy.justtestit.org/");
				
				// Find the xpath for register and click on it.
				WebElement register = driver.findElement(By.xpath("/html/body/my-app/header/nav/div/my-login/div/form/a"));
				register.click();
				
				// Define variables for registration
		        String userName = "User";
		        String firstName = "John";
		        String lastName = "Doe";
		        String password = "Password123";
		        		
		        // Enter Username, Firstname, Lastname & password on registration form.
		       	WebElement username = driver.findElement(By.id("username"));
				username.sendKeys(userName);
				WebElement firstname = driver.findElement(By.id("firstName"));
				firstname.sendKeys(firstName);
				WebElement lastname = driver.findElement(By.id("lastName"));
				lastname.sendKeys(lastName);
				WebElement pwd = driver.findElement(By.id("password"));
				pwd.sendKeys(password);
				WebElement conPwd = driver.findElement(By.name("confirmPassword"));
				conPwd.sendKeys(password);
				
				// Click on the registration button.
				driver.findElement(By.xpath("/html/body/my-app/div/main/my-register/div/div/form/button")).click();
				
				//Wait after registration to validate result.
				wait(driver);
				
				// Check whether the message on the registration was successful or not
				WebElement errorMessage = driver.findElement(By.cssSelector("body > my-app > div > main > my-register > div > div > form > div.result.alert.alert-danger"));
		        String actualString = errorMessage.getText();
		        System.out.println("Error Message: " + actualString);
				assertTrue(actualString.contains("InvalidPasswordException: Password did not conform with policy: Password must have symbol characters"));
				
				//Close Browser
				driver.quit();
	}
	@Test
	/**
	 * Duplicat Profile not allowed
	 * Test whether username already exixts.
	 * @throws URISyntaxException 
	 * 
	 *
	 */
	void duplicateProfileTestCase() throws URISyntaxException {
		// Invoke the web browser and navigating to the website.
		URL resource = getClass().getResource("chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",Paths.get(resource.toURI()).toFile().getAbsolutePath());
				WebDriver driver = new ChromeDriver();
				driver.get("https://buggy.justtestit.org/");
				
				// Find the xpath for register and click on it.
				WebElement register = driver.findElement(By.xpath("/html/body/my-app/header/nav/div/my-login/div/form/a"));
				register.click();
				
				// Define variables for registration
		        String userName = "User";
		        String firstName = "John";
		        String lastName = "Doe";
		        String password = "Password@123";
		        		
		        // Enter Username, Firstname, Lastname & password on registration form.
		       	WebElement username = driver.findElement(By.id("username"));
				username.sendKeys(userName);
				WebElement firstname = driver.findElement(By.id("firstName"));
				firstname.sendKeys(firstName);
				WebElement lastname = driver.findElement(By.id("lastName"));
				lastname.sendKeys(lastName);
				WebElement pwd = driver.findElement(By.id("password"));
				pwd.sendKeys(password);
				WebElement conPwd = driver.findElement(By.name("confirmPassword"));
				conPwd.sendKeys(password);
				
				// Click on the registration button.
				driver.findElement(By.xpath("/html/body/my-app/div/main/my-register/div/div/form/button")).click();
				
				//Wait after registration to validate result.
				wait(driver);
		
		// Check whether the message on the registration was successful or not
		WebElement errorMessage = driver.findElement(By.cssSelector("body > my-app > div > main > my-register > div > div > form > div.result.alert.alert-danger"));
        String actualString = errorMessage.getText();
        System.out.println("Error Message: " + actualString);
		assertTrue(actualString.contains("UsernameExistsException: User already exists"));
		
		//Close Browser
		driver.quit();
	}
	
	void wait(WebDriver driver){
			try{
				Thread.sleep(3000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		
	}
	
	

		
	
}