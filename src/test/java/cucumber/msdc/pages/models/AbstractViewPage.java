/**
archanaa
 */
package cucumber.msdc.pages.models;

import org.openqa.selenium.WebDriver;

public abstract class AbstractViewPage {
	
	public static final String I_ICON_TRASH_DRAWER_CANCEL = "i.icon-trash.drawer-cancel";
	public static final String I_ICON_CHEVRON_RIGHT_DRAWER_TRIGGER = "i.icon-chevron-right.drawer-trigger";
	public static final String I_DRAWER_TRIGGER_ICON_CHEVRON_DOWN = "i.drawer-trigger.icon-chevron-down";


	protected final CukesApp cukesApp;
	protected final WebDriver driver;

	public AbstractViewPage(CukesApp app) {
		this.cukesApp = app;
		this.driver = app.getWebDriver();
	}
	
	public WebDriver getWebDriver() {
		return cukesApp.getWebDriver();
	}

}
