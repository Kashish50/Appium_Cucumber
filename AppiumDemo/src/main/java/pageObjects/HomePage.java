package pageObjects;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utilities.BaseClass;

public class HomePage extends BaseClass {
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='android:id/button2']")
	private MobileElement btnOkayAlert;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='android:id/message']")
	private MobileElement txtAlertMsg;
	
	
	public void verifyAlertMessage(String strMsg){
		
		Assert.assertTrue(txtAlertMsg.getText().contains(strMsg), "Verified that Alert Message is correct");
	}
	
	

}
