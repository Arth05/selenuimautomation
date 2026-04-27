package pageclasses;

import org.openqa.selenium.By;

import managers.ExtentTestManager;
import utils.UIActionUtils;


public class HomePage {
        
	
	public static void nextPage(By page) {
		UIActionUtils.click(page);	
        ExtentTestManager.log.info("Clicked on Link");
			
	}
	
	
	
	
	
}
