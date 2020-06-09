package training;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windows {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\Chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Click Here")).click();
		Set <String> ids= driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parent_id=it.next();
		String child_id=it.next();
		driver.switchTo().window(child_id);
		System.out.println(driver.findElement(By.xpath("//div[@class='example']//following::h3")).getText());
		driver.switchTo().window(parent_id);
		System.out.println(driver.findElement(By.xpath("//div[@class='example']//following::h3")).getText());
		
		

	}

}
