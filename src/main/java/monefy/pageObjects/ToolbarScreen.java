package monefy.pageObjects;

import org.openqa.selenium.By;

import monefy.constants.AndroidScreensConstants;
import monefy.driver.DriverController;

public class ToolbarScreen extends DriverController {

  public void pressMenuButton() {
    driver.findElement(By.xpath(AndroidScreensConstants.TOOLBAR_MENU_BUTTON)).click();
  }

  public void pressSearchButton() {
    driver.findElement(By.xpath(AndroidScreensConstants.TOOLBAR_SEARCH_BUTTON)).click();
  }

  public void pressNewTransferButton() {
    driver.findElement(By.xpath(AndroidScreensConstants.TOOLBAR_TRANSFER_BUTTON)).click();
  }

  public void pressConfigurationButton() {
    driver.findElement(By.xpath(AndroidScreensConstants.TOOLBAR_CONFIGURATION_BUTTON)).click();
  }

}
