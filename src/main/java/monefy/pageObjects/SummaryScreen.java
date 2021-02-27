package monefy.pageObjects;

import org.openqa.selenium.By;

import monefy.constants.AndroidScreensConstants;
import monefy.driver.DriverController;

public class SummaryScreen extends DriverController {

  public boolean isSummaryScreenDisplayed() {
    return driver.findElement(By.id(AndroidScreensConstants.SUMMARY_TOTALEXPENSES_AMOUNT_TEXT)).isDisplayed();
  }

  public Double getTotalExpensesAmount() {
    return Double.valueOf(driver.findElement(By.id(AndroidScreensConstants.SUMMARY_TOTALEXPENSES_AMOUNT_TEXT)).getText().replace("€", ""));
  }

  public Double getTotalIncomesAmount() {
    return Double.valueOf(driver.findElement(By.id(AndroidScreensConstants.SUMMARY_TOTALINCOMES_AMOUNT_TEXT)).getText().replace("€", ""));
  }

  public Double getCurrentBalanceAmount() {
    return Double.valueOf(driver.findElement(By.id(AndroidScreensConstants.SUMMARY_CURRENTBALANCE_AMOUNT_TEXT)).getText().replace("Balance €", ""));
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

}
