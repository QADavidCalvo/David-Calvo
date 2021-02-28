package monefy.pageObjects;

import org.openqa.selenium.By;

import monefy.constants.AndroidScreensConstants;
import monefy.driver.DriverController;

public class AccountsEditionScreen extends DriverController {

  public void addAccountName(String accountName) {
    driver.findElement(By.id(AndroidScreensConstants.ACCOUNTS_ACCOUNT_NAME_FIELD)).setValue(accountName);
  }

  public void addAccountBalance(String accountBalance) {
    driver.findElement(By.id(AndroidScreensConstants.ACCOUNTS_ACCOUNT_BALANCE_FIELD)).setValue(accountBalance);
  }

  public void addAccountImage(String accountImage) {
    driver.findElement(By.id(AndroidScreensConstants.ACCOUNTS_ACCOUNT_IMAGE_FIELD)).setValue(accountImage);
  }

  public void saveAccountSettings() {
    driver.findElement(By.id(AndroidScreensConstants.ACCOUNTS_SAVE_BUTTON)).click();
  }

}
