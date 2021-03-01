package monefy.pageObjects;

import org.openqa.selenium.By;

import monefy.constants.AndroidScreensConstants;

public class ConfigurationScreen extends AndroidScreensConstants {

  public void openConfigurationPanel() {
    if (!isConfigurationPanelDisplayed()) driver.findElement(By.xpath(TOOLBAR_CONFIGURATION_BUTTON)).click();
  }

  public void closeConfigurationPanel() {
    if (isConfigurationPanelDisplayed()) driver.findElement(By.xpath(TOOLBAR_CONFIGURATION_BUTTON)).click();
  }

  public boolean isConfigurationPanelDisplayed() {
    return driver.findElements(By.id(CONFIGURATION_ACCOUNT_BUTTON)).size() != 0;
  }

  public void goToCategoriesList() {
    openConfigurationPanel();
    driver.findElement(By.id(CONFIGURATION_CATEGORIES_BUTTON)).click();
  }

  public void goToAccountsList() {
    openConfigurationPanel();
    if (driver.findElements(By.id(DATE_SETTINGS_PANEL)).size() == 0) driver.findElement(By.id(CONFIGURATION_ACCOUNT_BUTTON)).click();
  }

  public void goToCurrenciesList() {
    openConfigurationPanel();
    driver.findElement(By.id(CONFIGURATION_CURRENCIES_BUTTON)).click();
  }

  public void goToConfigurationScreen() {
    openConfigurationPanel();
    driver.findElement(By.id(CONFIGURATION_SETTINGS_BUTTON)).click();
  }
}
