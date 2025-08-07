//This project contains Frames, Handling Alerts, Handling CheckBoxes, Modal PopUp, ScrollDown, Navigation, 
//No Get window handle used currently

package MiniProjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Project01 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://webdriveruniversity.com/IFrame/index.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

// ----------------------- Switch to Iframe ----------------------------
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(iframe);
        
         
// ---------------- Click on all carousel indicators (not actual checkboxes) ----------
        List<WebElement> checkboxes = driver.findElements(By.xpath("//ol[@class='carousel-indicators']/li"));
        for (WebElement checkbox : checkboxes) {
            checkbox.click();
        }

// ---------------- Click the "Find Out More" button --------------------
        WebElement findOutMoreBtn = driver.findElement(By.xpath("//button[@id='button-find-out-more']"));
        findOutMoreBtn.click();

// ---------------- Close the modal popup --------------------
        Thread.sleep(2000); // Let the modal appear
        WebElement closeBtn = driver.findElement(By.xpath("//div[@id='myModal']//button[text()='Close']"));
        closeBtn.click();

// ---------------- Scroll using JavaScript --------------------
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");

        Thread.sleep(5000); 
        
// ---------------- Read "Excellent Customer Service!" --------------------
        WebElement text04 = driver.findElement(By.xpath("//p[normalize-space()='Excellent Customer Service!']"));
        System.out.println(text04.getText());

// ---------------- Switch out of iframe before clicking external links --------------------
   //     driver.switchTo().defaultContent();

// ---------------- Click on next page ***************** "Our Products" --------------------
       
        WebElement products = driver.findElement(By.xpath("//a[normalize-space()='Our Products']"));
        System.out.println(products.getText());
        products.click();

// ----------------- Print the names of all Links / Elements on the page ----------------
        
        List<WebElement> productNames = driver.findElements(By.xpath("//div[@class=\"section-title\"]"));
        System.out.println("List of All Elements: ");
	        for (WebElement product: productNames)
        {
        	System.out.println(product.getText());
        }
     
// ----------------- Click on next page ***************** "Contact Us" ----------------

	     WebElement contact = driver.findElement(By.xpath("//a[normalize-space()=\"Contact Us\"]"));
	     System.out.println(contact.getText());
	     contact.click();	
	     
	        
// ----------------- Submit the empty form ----------------
	     
	     Thread.sleep(5000);

	     WebElement submitEmptyForm = driver.findElement(By.xpath("//input[@value=\"SUBMIT\"]"));
	     submitEmptyForm.click();
	     
	     WebElement body = driver.findElement(By.tagName("body"));
	     System.out.println("❗ Error Text:\n" + body.getText());
	      
	     Thread.sleep(5000);
	     
// -------------- Return to your 'Contact Us Form' again --------------	     
	     
	     driver.navigate().back();
	     
	     Thread.sleep(5000);
	     
// -------------- Fill all the fields in 'Contact Us Form' now --------------	
	     
	     driver.switchTo().frame(driver.findElement(By.id("frame")));


	     driver.findElement(By.xpath("//input[@name=\"first_name\"]")).sendKeys("Jerry");
	     
	     driver.findElement(By.xpath("//input[@name=\"last_name\"]")).sendKeys("Here");

	     driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("jerryhere@gmail.com");

	     driver.findElement(By.xpath("//textarea[@placeholder=\"Comments\"]")).sendKeys("jerry is working here");

	     WebElement submitForm = driver.findElement(By.xpath("//input[@value=\"SUBMIT\"]"));
	     submitForm.click();

	     WebElement formDetails = driver.findElement(By.xpath("//div[@id=\"contact_reply\"]"));
	     System.out.println(formDetails.getText());

	     // Done
	     Thread.sleep(5000);
	     driver.close();
    }
    
}

