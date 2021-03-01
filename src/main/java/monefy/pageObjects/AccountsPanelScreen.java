package monefy.pageObjects;

import java.util.List;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import monefy.constants.AndroidScreensConstants;

public class AccountsPanelScreen extends AndroidScreensConstants {

  public void closeAccountsPanel() {
    driver.findElement(By.id(ACCOUNTS_CLOSE_BUTTON)).click();
  }

  public void pressAddAccountButton() {
    driver.findElement(By.xpath(ACCOUNTS_ADD_BUTTON)).click();
  }

  public void editAccount(String name) {
    List<MobileElement> currentAccounts = getAccountsName();
    Integer index = getIndexOfAccountByName(currentAccounts, name);
    if (index >= 0) currentAccounts.get(index).click();
  }

  public boolean isAccountWithName(String name) {
    return getIndexOfAccountByName(getAccountsName(), name) >= 0;
  }

  public String getAccountCurrentBalance(String name) {
    Integer index = getIndexOfAccountByName(getAccountsName(), name);
    return (index >= 0) ? getAccountsBalance().get(index).getText() : null;
  }

  public boolean isAccountWithBalance(String name) {
    return getAccountCurrentBalance(name).equals("0,00 €") || getAccountCurrentBalance(name).equals("€ 0.00");
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
    return driver.findElements(By.xpath(ACCOUNTS_NAME_TEXT));
  }

  private List<MobileElement> getAccountsBalance() {
    return driver.findElements(By.xpath(ACCOUNTS_AMOUNT_TEXT));
  }


}
