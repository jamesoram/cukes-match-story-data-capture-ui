package cucumber.msdc.pages.utils;

import org.openqa.selenium.WebDriver;

import com.pressassociation.pages.models.LoginPageElements;


/**
@author Shahnaaz Rahamatullah
@version 1.0
 */
public class LoginPage extends LoginPageElements {

	
	public LoginPage(WebDriver webDriver) {
		super(webDriver);
		
	}

	private LoginPage enterUserName(){
		getUserName().sendKeys(getUserNameValue());
		
		return this;
		
	}

	private LoginPage enterPassword(){
		getPassword().sendKeys(getPasswordValue());
		
		return this;
	}

	

	private HomePage clickSubmitButton(){
		getSubmitButton().click();
		return new HomePage(webDriver);
	}

	public HomePage signIn(){
		
		try {
			
			enterUserName();
			enterPassword();
			return clickSubmitButton();
        } catch (RuntimeException e) {
            takeScreenShot(e, "signInError");
        }
		return null;
	
	}
}
