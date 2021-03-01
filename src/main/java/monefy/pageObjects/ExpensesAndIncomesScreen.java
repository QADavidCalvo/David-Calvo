package monefy.pageObjects;

import java.util.List;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;

public class ExpensesAndIncomesScreen extends AmountKeyboardScreen {

  public void goToAddExpensesScreen() {
    if (!isExpensesAndIncomesScreenDisplayed()) driver.findElement(By.id(ADD_EXPENSES_BUTTON)).click();
  }

  public void goToAddIncomesScreen() {
    if (!isExpensesAndIncomesScreenDisplayed()) driver.findElement(By.id(ADD_INCOMES_BUTTON)).click();
  }

  public boolean isExpensesAndIncomesScreenDisplayed() {
    return driver.findElements(By.id(EXPENSESANDINCOMES_AMOUNT_TEXT_FIELD)).size() != 0;
  }

  public void clearAmount() {
    driver.findElement(By.id(EXPENSESANDINCOMES_AMOUNT_CLEAR_BUTTON)).click();
  }

  public void setAmount(String amount) {
    clearAmount();
    typeValue(amount);
  }

  public void selectAccount(String account) {
    driver.findElement(By.id(EXPENSESANDINCOMES_ACCOUNT_SELECTOR)).click();
    driver.findElements(By.xpath(EXPENSESANDINCOMES_ACCOUNT_OPTIONS)).get(account.toLowerCase().equals("efectivo") ? 0 : 1).click();
  }

  public void addNote(String text) {
    driver.findElement(By.id(EXPENSESANDINCOMES_NOTE_TEXT_FIELD)).setValue(text);
    driver.hideKeyboard();
  }

  public void chooseCategory(String category) {
    pressActionButton();
    List<MobileElement> list = driver.findElements(By.id(EXPENSESANDINCOMES_CATEGORIES_NAME));
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getText().toLowerCase().contains(category.toLowerCase())) {
        driver.findElements(By.xpath(EXPENSESANDINCOMES_CATEGORIES_CELLS)).get(i).click();
        break;
      }
    }
  }
}
