package cucumber.msdc.pages.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
@author Shahnaaz Rahamatullah
@version 1.0
 */
public class LoginPageElements extends KeyElements{

	private static final String LOGINPAGE_ELEMENT_IDENTIFIER="elementidentifier//loginpage.properties";
	
	public LoginPageElements(WebDriver webDriver){
		super(webDriver,LOGINPAGE_ELEMENT_IDENTIFIER);
		webDriver.get(elementIdentifier.getString("url"));	
	}

	protected WebElement getUserName(){
	return	webDriver.findElement(By.id(elementIdentifier.getString("username_identifier")));
	
	}

	protected WebElement getPassword(){
		return webDriver.findElement(By.id(elementIdentifier.getString("password_identifier")));
	}

	protected WebElement getSignInButton(){
		return webDriver.findElement(By.id(elementIdentifier.getString("signin_identifier")));
	}

	protected WebElement getSubmitButton(){
		
		return webDriver.findElement(By.id(elementIdentifier.getString("submit_identifier")));
	}

	protected String getUserNameValue(){
		return elementIdentifier.getString("username");
	}

	protected String getPasswordValue(){
		return elementIdentifier.getString("password");
	}

}
