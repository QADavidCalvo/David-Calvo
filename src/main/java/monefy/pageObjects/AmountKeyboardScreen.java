package monefy.pageObjects;

import org.openqa.selenium.By;

import monefy.constants.AndroidScreensConstants;
import monefy.driver.DriverController;

public class AmountKeyboardScreen extends DriverController {

  public void typeValue(String value) {
    for (String number : value.split("")) pressKey(number);
  }

  private void pressKey(String keyName) {
    driver.findElement(By.id(AndroidScreensConstants.KEYBOARD_KEY_BUTTON + keyName)).click();
  }

  public void pressActionButton() {
    driver.findElement(By.id(AndroidScreensConstants.KEYBOARD_ACTION_BUTTON)).click();
  }

}
