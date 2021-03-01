package monefy.pageObjects;

import java.util.List;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import monefy.constants.AndroidScreensConstants;

public class DateSettingsScreen extends AndroidScreensConstants {

  public void openDateSettingsPanel() {
    if (!isDateSettingsDisplayed()) driver.findElement(By.xpath(TOOLBAR_MENU_BUTTON)).click();
  }

  public void closeDateSettingsPanel() {
    if (isDateSettingsDisplayed()) driver.findElement(By.xpath(TOOLBAR_MENU_BUTTON)).click();
  }

  public boolean isDateSettingsDisplayed() {
    return driver.findElements(By.id(DATE_SETTINGS_PANEL)).size() != 0;
  }

  public void selectAccount(String accountName) {
    driver.findElement(By.id(DATE_SETTINGS_ACCOUNT_SELECTOR)).click();
    List<MobileElement> accountsTitle = driver.findElements(By.xpath(DATE_SETTINGS_ACCOUNTS_LIST_TITLE));
    for (int i = 0; i < accountsTitle.size(); i++) {
      if (accountsTitle.get(i).getText().toLowerCase().contains(accountName.toLowerCase())) {
        driver.findElements(By.xpath(DATE_SETTINGS_ACCOUNTS_LIST_OPTION)).get(i).click();
        break;
      }
    }
  }

  public void filterBy(Period period) {
    pressIfNotChecked(switch (period) {
      case DAY -> DATE_SETTINGS_PERIOD_DAY_OPTION;
      case WEEK -> DATE_SETTINGS_PERIOD_WEEK_OPTION;
      case MONTH -> DATE_SETTINGS_PERIOD_MONTH_OPTION;
      case YEAR -> DATE_SETTINGS_PERIOD_YEAR_OPTION;
      case ALL -> DATE_SETTINGS_PERIOD_ALL_OPTION;
      case INTERVAL -> DATE_SETTINGS_PERIOD_INTERVAL_OPTION;
      case DATE -> DATE_SETTINGS_PERIOD_DATE_OPTION;
    });
  }

  public void pressIfNotChecked(String element) {
    MobileElement mobileElement = driver.findElement(By.id(element));
    if (mobileElement.getAttribute("checked").equals("false")) {
      mobileElement.click();
    } else {
      closeDateSettingsPanel();
    }
  }

  public enum Period {
    DAY, WEEK, MONTH, YEAR, ALL, INTERVAL, DATE;
  }

}
