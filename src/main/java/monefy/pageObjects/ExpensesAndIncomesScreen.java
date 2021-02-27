package monefy.pageObjects;

import java.util.List;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import monefy.constants.AndroidScreensConstants;

public class ExpensesAndIncomesScreen extends AmountKeyboardScreen {

  public void clearAmount() {
    driver.findElement(By.id(AndroidScreensConstants.EXPENSESANDINCOMES_AMOUNT_CLEAR_BUTTON)).click();
  }

  public void setAmount(String amount) {
    clearAmount();
    typeValue(amount);
  }

  public void selectAccount(String account) {
    driver.findElement(By.id(AndroidScreensConstants.EXPENSESANDINCOMES_ACCOUNT_SELECTOR)).click();
    driver.findElements(By.xpath(AndroidScreensConstants.EXPENSESANDINCOMES_ACCOUNT_OPTIONS)).get(account.toLowerCase().equals("efectivo") ? 0 : 1).click();
  }

  public void addNote(String text) {
    driver.findElement(By.id(AndroidScreensConstants.EXPENSESANDINCOMES_NOTE_TEXT_FIELD)).setValue(text);
    driver.hideKeyboard();
  }

  public void chooseCategory(String category) {
    pressActionButton();
    List<MobileElement> list = driver.findElements(By.id(AndroidScreensConstants.EXPENSESANDINCOMES_CATEGORIES_NAME));
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getText().toLowerCase().contains(category.toLowerCase())) {
        driver.findElements(By.xpath(AndroidScreensConstants.EXPENSESANDINCOMES_CATEGORIES_CELLS)).get(i).click();
        break;
      }
    }
  }
}
