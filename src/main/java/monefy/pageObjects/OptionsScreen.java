package monefy.pageObjects;

import org.openqa.selenium.By;

import monefy.constants.AndroidScreensConstants;
import monefy.driver.DriverController;

public class OptionsScreen extends DriverController {

  public void pressMenuButton() {
    driver.findElement(By.xpath(AndroidScreensConstants.TOOLBAR_MENU_BUTTON)).click();
  }
}
