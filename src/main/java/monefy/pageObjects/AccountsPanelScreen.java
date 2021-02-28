package monefy.pageObjects;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import monefy.constants.AndroidScreensConstants;
import monefy.driver.DriverController;

public class AccountsPanelScreen extends DriverController {

  public void closeAccountsPanel() {
    driver.findElement(By.id(AndroidScreensConstants.ACCOUNTS_CLOSE_BUTTON)).click();
  }

  public void pressAddAccountButton() {
    driver.findElement(By.id(AndroidScreensConstants.ACCOUNTS_ADD_BUTTON)).click();
  }

  public boolean isAccountWithName(String name) {
    return getIndexOfAccountByName(getAccountsName(), name) >= 0;
  }

  public boolean isAccountWithBalance(String name) {
    try {
      String accountBalanceText = getAccountsBalance().get(getIndexOfAccountByName(getAccountsName(), name)).getText().replaceAll("€", "");
      Double accountBalanceValue = NumberFormat.getInstance(Locale.ENGLISH).parse(accountBalanceText).doubleValue();
      return Double.compare(accountBalanceValue, Double.valueOf(0.0)) > 0;
    } catch (ParseException e) {
      return false;
    }
  }

  public void goToAccountWithName(String name) {
    List<MobileElement> accounts = getAccountsName();
    accounts.get(getIndexOfAccountByName(accounts, name)).click();
  }

  private int getIndexOfAccountByName(List<MobileElement> accounts, String name) {
    for (int index = 0; index < accounts.size(); index++) {
      if (accounts.get(index).getText().toLowerCase().equals(name.toLowerCase())) return index;
    }
    return -1;
  }

  private List<MobileElement> getAccountsName() {
    return driver.findElements(By.xpath(AndroidScreensConstants.ACCOUNTS_NAME_TEXT));
  }

  private List<MobileElement> getAccountsBalance() {
    return driver.findElements(By.xpath(AndroidScreensConstants.ACCOUNTS_AMOUNT_TEXT));
  }


}
