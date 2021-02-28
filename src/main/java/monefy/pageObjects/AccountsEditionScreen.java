package monefy.pageObjects;

import org.openqa.selenium.By;

import monefy.constants.AndroidScreensConstants;
import monefy.driver.DriverController;

public class AccountsEditionScreen extends DriverController {

  public void addAccountName(String accountName) {
    driver.findElement(By.id(AndroidScreensConstants.ACCOUNTS_ACCOUNT_NAME_FIELD)).setValue(accountName);
  }

  public void addAccountInitialBalance(String accountBalance) {
    driver.findElement(By.id(AndroidScreensConstants.ACCOUNTS_ACCOUNT_INITIALBALANCE_FIELD)).setValue(accountBalance);
  }

  public void addAccountImage(Integer accountImage) {
    driver.findElements(By.xpath(AndroidScreensConstants.ACCOUNTS_ACCOUNT_CATEGORIES_CELLS)).get(accountImage - 1).click();
  }

  public void closeAccountSettings() {
    driver.findElement(By.xpath(AndroidScreensConstants.ACCOUNTS_BACK_BUTTON)).click();
  }

  public void saveAccountSettings() {
    driver.findElement(By.id(AndroidScreensConstants.ACCOUNTS_SAVE_BUTTON)).click();
  }

}
