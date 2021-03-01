package monefy.constants;

import monefy.driver.DriverController;

public class AndroidScreensConstants extends DriverController {

  // Toolbar
  public static final String TOOLBAR_CONTAINER = "//android.view.ViewGroup[contains(@resource-id,'toolbar')]";
  public static final String TOOLBAR_MENU_BUTTON = TOOLBAR_CONTAINER + "/android.widget.ImageButton";
  public static final String TOOLBAR_SEARCH_BUTTON = TOOLBAR_CONTAINER + "//*[contains(@resource-id,'menu_search')]";
  public static final String TOOLBAR_TRANSFER_BUTTON = TOOLBAR_CONTAINER + "//*[contains(@resource-id,'transfer_menu_item')]";
  public static final String TOOLBAR_CONFIGURATION_BUTTON = TOOLBAR_CONTAINER + "//*[contains(@resource-id,'overflow')]";

  // Date settings screen
  public static final String DATE_SETTINGS_PANEL = "left_drawer";
  public static final String DATE_SETTINGS_ACCOUNT_SELECTOR = "left_drawer";
  public static final String DATE_SETTINGS_ACCOUNTS_LIST_OPTION = "//android.widget.ListView/android.widget.LinearLayout";
  public static final String DATE_SETTINGS_ACCOUNTS_LIST_TITLE = DATE_SETTINGS_ACCOUNTS_LIST_OPTION + "//*[contains(@resource-id,'title')]";
  public static final String DATE_SETTINGS_PERIOD_DAY_OPTION = "day_period_button";
  public static final String DATE_SETTINGS_PERIOD_WEEK_OPTION = "week_period_button";
  public static final String DATE_SETTINGS_PERIOD_MONTH_OPTION = "month_period_button";
  public static final String DATE_SETTINGS_PERIOD_YEAR_OPTION = "year_period_button";
  public static final String DATE_SETTINGS_PERIOD_ALL_OPTION = "all_period_button";
  public static final String DATE_SETTINGS_PERIOD_INTERVAL_OPTION = "custom_period_button";
  public static final String DATE_SETTINGS_PERIOD_DATE_OPTION = "show_datepicker_button";

  // Search screen
  public static final String SEARCH_BACK_BUTTON = "action_back";
  public static final String SEARCH_TEXT_FIELD = "et_search";
  public static final String SEARCH_VOICE_BUTTON = "action_voice";

  // Configuration screen
  public static final String CONFIGURATION_CATEGORIES_BUTTON = "categories_panel";
  public static final String CONFIGURATION_ACCOUNT_BUTTON = "accounts_panel";
  public static final String CONFIGURATION_CURRENCIES_BUTTON = "currency_panel";
  public static final String CONFIGURATION_SETTINGS_BUTTON = "settings_panel";

  // Accounts screen
  public static final String ACCOUNTS_CLOSE_BUTTON = "accounts_button";
  public static final String ACCOUNTS_ADD_BUTTON = "//*[contains(@resource-id,'relativeLayoutManageCategoriesListItemType')]/*[contains(@resource-id,'AddCategory')]/..";
  public static final String ACCOUNTS_LIST = "//*[contains(@resource-id,'relativeLayoutManageCategoriesListItem')]/*[contains(@resource-id,'imageViewCategoryImage')]/..";
  public static final String ACCOUNTS_NAME_TEXT = ACCOUNTS_LIST + "//*[contains(@resource-id,'textViewName')]";
  public static final String ACCOUNTS_AMOUNT_TEXT = ACCOUNTS_LIST + "//*[contains(@resource-id,'textViewAmount')]";
  public static final String ACCOUNTS_ACCOUNT_NAME_FIELD = "editTextCategoryName";
  public static final String ACCOUNTS_ACCOUNT_INITIALBALANCE_FIELD = "initialAmount";
  public static final String ACCOUNTS_ACCOUNT_CATEGORIES_CELLS = "//*[contains(@resource-id,'gridViewCategoryImages')]/android.widget.FrameLayout";
  public static final String ACCOUNTS_SAVE_BUTTON = "save";
  public static final String ACCOUNTS_BACK_BUTTON = "//*[contains(@resource-id,'toolbar')]/android.widget.ImageButton";

  // Summary screen
  public static final String SUMMARY_TOTALEXPENSES_AMOUNT_TEXT = "expense_amount_text";
  public static final String SUMMARY_TOTALINCOMES_AMOUNT_TEXT = "income_amount_text";
  public static final String SUMMARY_CURRENTBALANCE_CONTAINER = "balance_container";
  public static final String SUMMARY_CURRENTBALANCE_AMOUNT_TEXT = "balance_amount";

  // Add expenses and incomes buttons
  public static final String ADD_EXPENSES_BUTTON = "expense_button";
  public static final String ADD_INCOMES_BUTTON = "income_button";

  // New expenses and incomes screen
  public static final String EXPENSESANDINCOMES_ACCOUNT_SELECTOR = "account_spinner";
  public static final String EXPENSESANDINCOMES_ACCOUNT_OPTIONS = "//android.widget.ListView//*[contains(@resource-id,'title')]";
  public static final String EXPENSESANDINCOMES_AMOUNT_TEXT_FIELD = "amount_text";
  public static final String EXPENSESANDINCOMES_AMOUNT_CLEAR_BUTTON = "buttonKeyboardClear";
  public static final String EXPENSESANDINCOMES_NOTE_TEXT_FIELD = "textViewNote";
  public static final String EXPENSESANDINCOMES_CATEGORIES_CELLS = "//*[contains(@resource-id,'gridViewCategories')]/android.widget.FrameLayout";
  public static final String EXPENSESANDINCOMES_CATEGORIES_NAME = "textCategoryName";

  // Balance screen
  public static final String BALANCE_SORTING_BUTTON = "buttonChooseListSortingMode";
  public static final String BALANCE_TRANSACTION_DATE = "textViewDate";
  public static final String BALANCE_TRANSACTION_COUNT_VALUE = "textViewTransactionsCount";
  public static final String BALANCE_TRANSACTION_CATEGORY_NAME = "textViewCategoryName";
  public static final String BALANCE_TRANSACTION_AMOUNT_VALUE = "textViewTransactionAmount";
  public static final String BALANCE_TRANSACTION_WHOLEAMOUNT_VALUE = "textViewWholeAmount";

  // New transfer screen
  public static final String TRANSFER_AMOUNT_TEXT_FIELD = "amount_text";
  public static final String TRANSFER_AMOUNT_CLEAR_BUTTON = "buttonKeyboardClear";
  public static final String TRANSFER_NOTE_TEXT_FIELD = "textViewNote";
  public static final String TRANSFER_ACCOUNTFROM_SELECTOR = "spinnerAccountFrom";
  public static final String TRANSFER_ACCOUNTTO_SELECTOR = "spinnerAccountTo";
  public static final String TRANSFER_ACCOUNTS_OPTIONS = "//android.widget.ListView//*[contains(@resource-id,'title')]";
  public static final String TRANSFER_SHOWKEYBOARD_BUTTON = "show_keyboard_fab";

  // Amounts keyboard
  public static final String KEYBOARD_KEY_BUTTON = "buttonKeyboard";
  public static final String KEYBOARD_ACTION_BUTTON = "keyboard_action_button";
}

