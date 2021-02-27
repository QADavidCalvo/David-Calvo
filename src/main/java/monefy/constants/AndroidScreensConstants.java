package monefy.constants;

public class AndroidScreensConstants {

  // Toolbar
  public static final String TOOLBAR_CONTAINER = "//android.view.ViewGroup[contains(@resource-id,'toolbar')]";
  public static final String TOOLBAR_MENU_BUTTON = TOOLBAR_CONTAINER + "/android.widget.ImageButton";
  public static final String TOOLBAR_SEARCH_BUTTON = TOOLBAR_CONTAINER + "//*[contains(@resource-id,'menu_search')]";
  public static final String TOOLBAR_TRANSFER_BUTTON = TOOLBAR_CONTAINER + "//*[contains(@resource-id,'transfer_menu_item')]";
  public static final String TOOLBAR_OPTIONS_BUTTON = TOOLBAR_CONTAINER + "//*[contains(@resource-id,'overflow')]";

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

