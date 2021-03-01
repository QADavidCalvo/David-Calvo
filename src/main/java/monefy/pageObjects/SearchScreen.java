package monefy.pageObjects;

import org.openqa.selenium.By;

import monefy.constants.AndroidScreensConstants;

public class SearchScreen extends AndroidScreensConstants {

  public void openSearchScreen() {
    if (!isSearchScreenDisplayed()) driver.findElement(By.xpath(TOOLBAR_SEARCH_BUTTON)).click();
  }

  public void closeSearchScreen() {
    if (isSearchScreenDisplayed()) driver.findElement(By.xpath(SEARCH_BACK_BUTTON)).click();
  }

  public boolean isSearchScreenDisplayed() {
    return driver.findElements(By.id(SEARCH_TEXT_FIELD)).size() != 0;
  }

  public void goToNewTransferScreen() {
    driver.findElement(By.id(SEARCH_TEXT_FIELD)).click();
  }

  public void pressSearchByVoiceButton() {
    driver.findElement(By.id(SEARCH_VOICE_BUTTON)).click();
  }

}
