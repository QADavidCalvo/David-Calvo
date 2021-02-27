package monefy.pageObjects;

import org.openqa.selenium.By;

import monefy.constants.AndroidScreensConstants;

public class NewTransferScreen extends AmountKeyboardScreen {

  public void clearAmount() {
    driver.findElement(By.id(AndroidScreensConstants.TRANSFER_AMOUNT_CLEAR_BUTTON)).click();
  }

  public void setAmount(String amount) {
    clearAmount();
    showKeyboard();
    typeValue(amount);
  }

  public void addNote(String text) {
    driver.findElement(By.id(AndroidScreensConstants.TRANSFER_NOTE_TEXT_FIELD)).setValue(text);
    driver.hideKeyboard();
  }

  public void selectFromAccount(String account) {
    driver.findElement(By.id(AndroidScreensConstants.TRANSFER_ACCOUNTFROM_SELECTOR)).click();
    driver.findElements(By.xpath(AndroidScreensConstants.TRANSFER_ACCOUNTS_OPTIONS)).get(account.toLowerCase().equals("efectivo") ? 0 : 1).click();
  }

  public void selectToAccount(String account) {
    driver.findElement(By.id(AndroidScreensConstants.TRANSFER_ACCOUNTTO_SELECTOR)).click();
    driver.findElements(By.xpath(AndroidScreensConstants.TRANSFER_ACCOUNTS_OPTIONS)).get(account.toLowerCase().equals("efectivo") ? 0 : 1).click();
  }

  public void addTransfer() {
    driver.findElement(By.id(AndroidScreensConstants.KEYBOARD_ACTION_BUTTON)).click();
  }

  public void showKeyboard() {
    driver.findElement(By.id(AndroidScreensConstants.TRANSFER_SHOWKEYBOARD_BUTTON)).click();
  }
}
