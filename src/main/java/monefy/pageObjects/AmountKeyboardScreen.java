package monefy.pageObjects;

import org.openqa.selenium.By;

import monefy.constants.AndroidScreensConstants;

public class AmountKeyboardScreen extends AndroidScreensConstants {

  public void typeValue(String value) {
    for (String number : value.split("")) pressKey(number);
  }

  private void pressKey(String keyName) {
    driver.findElement(By.id(KEYBOARD_KEY_BUTTON + keyName)).click();
  }

  public void pressActionButton() {
    driver.findElement(By.id(KEYBOARD_ACTION_BUTTON)).click();
  }

}
