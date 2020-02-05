package utilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	
	DeviceDesiredCapabilities cd;
	AppiumDriver<MobileElement> driver;
	URL url;
	
	@BeforeTest
	public void Setup(){
		
		
		ObjectMapper om = new ObjectMapper();
	//	File jsonFile =new File("C\\:Users\\kashish.pasrija\\Selenium_Udemy\\AppiumDemo\\src\\test\\resources\\JsonFiles\\device.json");
		
		File jsonFile =new File("src/test/resources/JsonFiles/device.json");
		try {
			cd = om.readValue(jsonFile, DeviceDesiredCapabilities.class);
			
		} catch (JsonParseException e) {
			
			e.printStackTrace();
		} catch (JsonMappingException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME,cd.getPlatformName());
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,cd.getPlatformVersion());
		caps.setCapability(MobileCapabilityType.DEVICE_NAME,cd.getDeviceName());
		caps.setCapability(MobileCapabilityType.APP,cd.getApp());
	//	caps.setCapability(MobileCapabilityType.BROWSER_NAME,cd.getBrowserName());
		
		caps.setCapability("appPackage",cd.getAppPackage());
		caps.setCapability("appActivity",cd.getAppActivity());
		
		
		
		
		try {
			
			this.url =new URL(cd.getUrl());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		driver = new AppiumDriver<MobileElement>(url,caps);
		driver = new AndroidDriver<MobileElement>(url,caps);
		
		
	}
	
	@Test
	public void sampleTest(){
		System.out.println("Appium Has Started !!!!");
	}
	
	
	@AfterTest
	public void tearDown(){
		
	}

}
