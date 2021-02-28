package monefy.constants;

public class AndroidScreensConstants {

  // Toolbar
  public static final String TOOLBAR_CONTAINER = "//android.view.ViewGroup[contains(@resource-id,'toolbar')]";
  public static final String TOOLBAR_MENU_BUTTON = TOOLBAR_CONTAINER + "/android.widget.ImageButton";
  public static final String TOOLBAR_SEARCH_BUTTON = TOOLBAR_CONTAINER + "//*[contains(@resource-id,'menu_search')]";
  public static final String TOOLBAR_TRANSFER_BUTTON = TOOLBAR_CONTAINER + "//*[contains(@resource-id,'transfer_menu_item')]";
  public static final String TOOLBAR_CONFIGURATION_BUTTON = TOOLBAR_CONTAINER + "//*[contains(@resource-id,'overflow')]";

  // Configuration screen
  public static final String CONFIGURATION_CATEGORIES_BUTTON = "categories_panel";
  public static final String CONFIGURATION_ACCOUNT_BUTTON = "accounts_panel";
  public static final String CONFIGURATION_CURRENCIES_BUTTON = "currency_panel";
  public static final String CONFIGURATION_SETTINGS_BUTTON = "settings_panel";

  // Accounts screen
  public static final String ACCOUNTS_CLOSE_BUTTON = "accounts_button";
  public static final String ACCOUNTS_LIST = "//*[contains(@resource-id,'accounts_list')]";
  public static final String ACCOUNTS_ADD_BUTTON = ACCOUNTS_LIST + "//*[contains(@resource-id,'AddCategory')]/..";
  public static final String ACCOUNTS_NAME_TEXT = ACCOUNTS_LIST + "//*[contains(@resource-id,'Name')]";
  public static final String ACCOUNTS_AMOUNT_TEXT = ACCOUNTS_LIST + "//*[contains(@resource-id,'Amount')]";
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

