package monefy.pageObjects;

import org.openqa.selenium.By;

import monefy.constants.AndroidScreensConstants;
import monefy.driver.DriverController;

public class ConfigurationScreen extends DriverController {

  public void pressCategoriesButton() {
    driver.findElement(By.id(AndroidScreensConstants.CONFIGURATION_CATEGORIES_BUTTON)).click();
  }

  public void pressAccountsButton() {
    driver.findElement(By.id(AndroidScreensConstants.CONFIGURATION_ACCOUNT_BUTTON)).click();
  }

  public void pressCurrenciesButton() {
    driver.findElement(By.id(AndroidScreensConstants.CONFIGURATION_CURRENCIES_BUTTON)).click();
  }

  public void pressSettingsButton() {
    driver.findElement(By.id(AndroidScreensConstants.CONFIGURATION_SETTINGS_BUTTON)).click();
  }
}
