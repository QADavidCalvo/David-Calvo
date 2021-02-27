package monefy.pageObjects;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.openqa.selenium.By;

import monefy.constants.AndroidScreensConstants;
import monefy.driver.DriverController;

public class SummaryScreen extends DriverController {

  public boolean isSummaryScreenDisplayed() {
    return driver.findElement(By.id(AndroidScreensConstants.SUMMARY_TOTALEXPENSES_AMOUNT_TEXT)).isDisplayed();
  }

  public Double getTotalExpensesAmount() {
    return parseAmount(driver.findElement(By.id(AndroidScreensConstants.SUMMARY_TOTALEXPENSES_AMOUNT_TEXT)).getText().replace("€", ""));
  }

  public Double getTotalIncomesAmount() {
    return parseAmount(driver.findElement(By.id(AndroidScreensConstants.SUMMARY_TOTALINCOMES_AMOUNT_TEXT)).getText().replace("€", ""));
  }

  public Double getCurrentBalanceAmount() {
    return parseAmount(driver.findElement(By.id(AndroidScreensConstants.SUMMARY_CURRENTBALANCE_AMOUNT_TEXT)).getText().replace("Balance €", ""));
  }

  public void goToBalanceDetailsScreen() {
    driver.findElement(By.id(AndroidScreensConstants.SUMMARY_CURRENTBALANCE_CONTAINER)).click();
  }

  public void pressAddExpensesButton() {
    driver.findElement(By.id(AndroidScreensConstants.ADD_EXPENSES_BUTTON)).click();
  }

  public void pressAddIncomesButton() {
    driver.findElement(By.id(AndroidScreensConstants.ADD_INCOMES_BUTTON)).click();
  }

  private Double parseAmount(String value) {
    try {
      return NumberFormat.getInstance(Locale.ENGLISH).parse(value).doubleValue();
    } catch (ParseException e) {
      return null;
    }
  }

}
