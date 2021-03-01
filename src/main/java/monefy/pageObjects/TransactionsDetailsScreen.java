package monefy.pageObjects;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import monefy.constants.AndroidScreensConstants;

public class TransactionsDetailsScreen extends AndroidScreensConstants {

  public void goToTransactionsDetailsScreen() {
    if (!isTransactionsDetailsScreenDisplayed()) driver.findElement(By.id(SUMMARY_CURRENTBALANCE_CONTAINER)).click();
  }

  public void closeTransactionsDetailsScreen() {
    if (isTransactionsDetailsScreenDisplayed()) driver.findElement(By.id(SUMMARY_CURRENTBALANCE_CONTAINER)).click();
  }

  public boolean isTransactionsDetailsScreenDisplayed() {
    return driver.findElements(By.id(BALANCE_SORTING_BUTTON)).size() != 0;
  }

  public Double getCurrentBalanceAmount() {
    try {
      String value = StringUtils.replaceEach(driver.findElement(By.id(SUMMARY_CURRENTBALANCE_AMOUNT_TEXT)).getText(), new String[] {"Balance", "Saldo", "€", " "}, new String[] {"", "", "", ""});
      return NumberFormat.getInstance(Locale.ENGLISH).parse(value).doubleValue();
    } catch (ParseException e) {
      return null;
    }
  }

  public void sortBy(TransactionsSorting sorting) {
    if (sorting == TransactionsSorting.DATE) {
      sortByDate();
    } else {
      sortByCategory();
    }
  }

  public void sortByDate() {
    if (!isSortedByDate()) driver.findElement(By.id(BALANCE_SORTING_BUTTON)).click();
  }

  public void sortByCategory() {
    if (isSortedByDate()) driver.findElement(By.id(BALANCE_SORTING_BUTTON)).click();
  }

  private boolean isSortedByDate() {
    return driver.findElements(By.id(BALANCE_TRANSACTION_DATE)).size() != 0;
  }

  public boolean isTransactionAmountsDisplayed(TransactionsSorting sorting) {
    return sorting == TransactionsSorting.DATE ? isTransactionsByDateDisplayed() : isTransactionsByCategoryDisplayed();
  }

  public boolean isTransactionsByDateDisplayed() {
    try {
      System.out.println("List of transactions by date:");
      List<MobileElement> transactions = driver.findElements(By.id(BALANCE_TRANSACTION_DATE));
      for (int i = 0; i < transactions.size(); i++) {
        String count = driver.findElements(By.id(BALANCE_TRANSACTION_COUNT_VALUE)).get(i).getText();
        String date = transactions.get(i).getText();
        String amount = driver.findElements(By.id(BALANCE_TRANSACTION_WHOLEAMOUNT_VALUE)).get(i).getText();
        System.out.println(" > " + count + " transactions on " + date + " for " + amount);
      }
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  public boolean isTransactionsByCategoryDisplayed() {
    try {
      System.out.println("List of transactions by category:");
      List<MobileElement> transactions = driver.findElements(By.id(BALANCE_TRANSACTION_CATEGORY_NAME));
      for (int i = 0; i < transactions.size(); i++) {
        String count = driver.findElements(By.id(BALANCE_TRANSACTION_COUNT_VALUE)).get(i).getText();
        String category = transactions.get(i).getText();
        String amount = driver.findElements(By.id(BALANCE_TRANSACTION_WHOLEAMOUNT_VALUE)).get(i).getText();
        System.out.println(" > " + count + " transactions of " + category + " for " + amount);
      }
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public enum TransactionsSorting {
    DATE, CATEGORY;
  }


}
