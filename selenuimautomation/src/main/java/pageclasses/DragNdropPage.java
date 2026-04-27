package pageclasses;

import org.openqa.selenium.WebElement;

import managers.ExtentTestManager;
import utils.UIActionUtils;

public class DragNdropPage {
	
	public static void performAction(WebElement source, WebElement target) {
		UIActionUtils.initAction(source, target);
		ExtentTestManager.log.info("Performed Drag and Drop action");
	}

}
