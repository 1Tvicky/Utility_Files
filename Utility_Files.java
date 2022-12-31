package com.Base_Class;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Utility_Files {
	
	public static WebDriver driver;
	
	public static WebDriver browserlaunch(String browsername) {
		if (browsername.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", 
					"C:\\Users\\HP\\eclipse-workspace\\Selenium_Project\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if (browsername.equalsIgnoreCase("Edge")) {
			
			System.setProperty("webdriver.edge.driver", 
					"C:\\Users\\HP\\eclipse-workspace\\Selenium_Project\\Driver");
			driver = new EdgeDriver();
		}else if (browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.firefox.driver",
					"C:\\Users\\HP\\eclipse-workspace\\Selenium_Project\\Driver");
			driver = new FirefoxDriver();
			
		}
		return driver;
		}
        public  static  void urllaunch(String url ) {
		driver.get(url);
    	}
        public static void max() {
        	driver.manage().window().maximize();
        }
        public static String title() {
			
        	String title = driver.getTitle();
        	return title;
			
        }
        public static  void sendvalues(WebElement element,String values) {
        	element.sendKeys(values);

		}

        public static void clickOnelement(WebElement element) {
        	element.click();
		}

        public static  void screenshot(String path) throws IOException {
        	
        	TakesScreenshot ts = (TakesScreenshot)driver;
        	File src = ts.getScreenshotAs(OutputType.FILE);
        	File des = new File(path);
        	FileUtils.copyFile(src, des);
        	
		}
        
        public static void dropdown_Index(WebElement element, int index) {
           
    		Select s = new Select(element);
    		s.selectByIndex(index);
    		
    	}
        public static void dropdown_Value(WebElement element, String name) {
    		// TODO Auto-generated method stub
     
    		Select s = new Select(element);
    		s.selectByValue(name);
    	}
    	
    	public static void dropdown_Text(WebElement element, String Text) {
    		// TODO Auto-generated method stub
    		Select s = new Select(element);
    		s.selectByVisibleText(Text);
    	}
    	public static void okay() {
    		driver.switchTo().alert().accept();

    	}
    	public static void clear(WebElement element) {
    		// TODO Auto-generated method stub
           element.clear();
    	}
    	




}
