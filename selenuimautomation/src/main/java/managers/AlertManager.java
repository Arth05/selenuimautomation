package managers;

import org.openqa.selenium.Alert;

public class AlertManager {
	
	public static Alert getAlert() {
        return WaitManager.alertIsPresent();
    }
	
	public static void acceptAlert() {
		getAlert().accept();
	}
	
	public static void dismissAlert() {
		getAlert().dismiss();
	}
	
	public static void sendkeysAlert(String text) {
		getAlert().sendKeys(text);
	}
	

}
