package AmazonTestPackage;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		WebElement searchbox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		WebElement searchbtn = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		searchbox.sendKeys("samsung mobile");
		searchbtn.click();
		
		TakesScreenshot tsobj = (TakesScreenshot) driver;
		File fileobj = tsobj.getScreenshotAs(OutputType.FILE);
		File Screenshotobj = new File("Image.png");
		FileUtils.copyFile(fileobj, Screenshotobj); 
		
		//List<WebElement> rows = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		//List<WebElement> rows = driver.findElements(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']"));
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='a-section']//h2//span"));
		//List<WebElement> price = driver.findElements(By.xpath("//div[@class='sg-row']//span[@class='a-price-whole']"));
		List<WebElement> Rupee = driver.findElements(By.xpath("//div[@class='sg-row']//span[@class='a-price-symbol']"));
		
		
		List<WebElement> price = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//div[contains(@class,'price')]//span[@class='a-price-whole']"));
		
		
		System.out.println("Total no of Rows " + rows.size());
		
		for(int i =0;i<rows.size(); i++){
			System.out.println("The Samsun mobile name is: "+ rows.get(i).getText());
			System.out.println("The price is "+Rupee.get(i).getText()+price.get(i).getText());
		}
	}

}
