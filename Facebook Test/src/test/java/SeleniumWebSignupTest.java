import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebSignupTest {
    //import the Selenium Web-Driver
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the Chromedriver is
        System.setProperty("web-driver.chrome.driver", "resources/chromedriver.exe");
        //1. Open your Chrome browser
        driver = new ChromeDriver();
        //2. Input your SeleniumWebSignup Page URL (https://selenium-blog.herokuapp.com)
        driver.get("https://selenium-blog.herokuapp.com");
        // Test1. Verify the user input the right url and his on the right webpage
        if(driver.getCurrentUrl().contains("https://https://selenium-blog.herokuapp.com"))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);
        //3. Maximize the browser

        driver.manage().window().maximize();
        //4. Click on Signup button to open the Signup page

        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
    }

    @Test ()
        public void positiveSignup()throws InterruptedException {
        //Test7.  Verify that user is successfully signed up when valid details are inputted.
        //Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("spirit00");
        //6. Locate the email address field and Input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("spirit@gmail.com");
        //7.  Locate the password field and Input your password on the username field
        driver.findElement(By.id("user_password")).sendKeys("admin");
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 1)
        public void clickUser1Item()throws InterruptedException {
        //9. Click on User1 item on the list page
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        //test2. Verify that when user clicks on the signup button, the user is directed to the signup page
        String expectedUrl = "https://https://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
                if (actualUrl.contains(expectedUrl))
                    //Pass
                    System.out.println("Correct Webpage");else
                    //Fail
                    System.out.println("Wrong Webpage");
            Thread.sleep(5000);
    }

    @Test (priority = 2)
    public void verifyItem() throws InterruptedException {
        //Test9. Search for an item (Using Python with Selenium) and confirm it is present
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
        String expectedPageUrl = "/users/1";
        String actualPageUrl = driver.getCurrentUrl();
                if (actualPageUrl.contains(expectedPageUrl))
                    //Pass
                    System.out.println("Correct User1Page");


                else
                    //Fail
                    System.out.println("Wrong User1Page");
        Thread.sleep(5000);

    }
    @Test (priority = 3)
    public void logoutSuccessfully() {
        //11. Click on Logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        //Test10: Verify that when the user logout, he/she is directed back to the home page
            String expectedTitle = "AlphaBlog";
            String actualTitle = driver.getTitle();
            if(expectedTitle.contains(actualTitle))
                //Pass
                System.out.println("Correct Webpage");
            else
                //Fail
        System.out.println("Wrong Webpage");

    }
    @Test (priority = 4)
    public void negativeSignup() throws InterruptedException {
        //Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //Test3. Verify that user cannot sign up with username less than 3 characters
        // Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("spirit00");
        //6. Locate the email address field and Input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("spirit@gmail.com");
        //7.  Locate the password field and Input your password on the username field
        driver.findElement(By.id("user_password")).sendKeys("admin");
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @AfterTest
    public void closeBrowser() {
        //Quit the browser
        driver.quit();
    }



    }