package monefy.pageObjects;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

import monefy.constants.AndroidScreensConstants;

public class SpendingsScreen extends AndroidScreensConstants {

  public boolean isSpendingsScreenDisplayed() {
    return driver.findElements(By.id(AndroidScreensConstants.SUMMARY_TOTALEXPENSES_AMOUNT_TEXT)).size() != 0;
  }

  public Double getTotalExpensesAmount() {
    try {
      String value = StringUtils.replaceEach(driver.findElement(By.id(AndroidScreensConstants.SUMMARY_TOTALEXPENSES_AMOUNT_TEXT)).getText(), new String[] {"€", " "}, new String[] {"", ""});
      return NumberFormat.getInstance(Locale.ENGLISH).parse(value).doubleValue();
    } catch (ParseException e) {
      return null;
    }
  }

  public Double getTotalIncomesAmount() {
    try {
      String value = StringUtils.replaceEach(driver.findElement(By.id(AndroidScreensConstants.SUMMARY_TOTALINCOMES_AMOUNT_TEXT)).getText(), new String[] {"€", " "}, new String[] {"", ""});
      return NumberFormat.getInstance(Locale.ENGLISH).parse(value).doubleValue();
    } catch (ParseException e) {
      return null;
    }
  }

}
