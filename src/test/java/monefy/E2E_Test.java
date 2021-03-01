package monefy;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import monefy.driver.DriverController;
import monefy.pageObjects.AccountsEditionScreen;
import monefy.pageObjects.AccountsPanelScreen;
import monefy.pageObjects.ConfigurationScreen;
import monefy.pageObjects.DateSettingsScreen;
import monefy.pageObjects.DateSettingsScreen.Period;
import monefy.pageObjects.ExpensesAndIncomesScreen;
import monefy.pageObjects.NewTransferScreen;
import monefy.pageObjects.SpendingsScreen;
import monefy.pageObjects.TransactionsDetailsScreen;
import monefy.pageObjects.TransactionsDetailsScreen.TransactionsSorting;

public class E2E_Test {

  @BeforeAll
  public static void setUp() {
    DriverController.initDriver();
  }

  @AfterAll
  public static void tearDown() {
    DriverController.stopDriver();
  }

  DateSettingsScreen dateSettingsScreen = new DateSettingsScreen();
  ConfigurationScreen configurationScreen = new ConfigurationScreen();
  AccountsPanelScreen accountsPanelScreen = new AccountsPanelScreen();
  AccountsEditionScreen accountsEditionScreen = new AccountsEditionScreen();
  SpendingsScreen spendingsScreen = new SpendingsScreen();
  TransactionsDetailsScreen transactionsDetails = new TransactionsDetailsScreen();
  ExpensesAndIncomesScreen expensesAndIncomesScreen = new ExpensesAndIncomesScreen();
  NewTransferScreen newTransferScreen = new NewTransferScreen();

  @Severity(SeverityLevel.MINOR)
  @ParameterizedTest
  @MethodSource("ADD_NEW_ACCOUNT")
  public void monefy_01_addNewAccount_isNewAccountSet(String accountName, String accountBalance, int accountImage) {
    // Given
    configurationScreen.goToAccountsList();

    // When
    accountsPanelScreen.pressAddAccountButton();
    accountsEditionScreen.addAccountName(accountName);
    accountsEditionScreen.addAccountInitialBalance(accountBalance);
    accountsEditionScreen.addAccountImage(accountImage);
    accountsEditionScreen.saveAccountSettings();

    // Then
    assertTrue(accountsPanelScreen.isAccountWithName(accountName));
  }

  @Severity(SeverityLevel.NORMAL)
  @ParameterizedTest
  @MethodSource("ADD_ACCOUNT_BALANCE")
  public void monefy_02_addBalanceToAccount_isAccountWithBalanceSet(String accountName, String accountBalance) {
    // Given
    configurationScreen.goToAccountsList();

    // When
    accountsPanelScreen.editAccount(accountName);
    accountsEditionScreen.addAccountInitialBalance(accountBalance);
    accountsEditionScreen.closeAccountSettings();

    // And
    configurationScreen.goToAccountsList();

    // Then
    assertTrue(accountsPanelScreen.isAccountWithBalance(accountName));
  }

  @Severity(SeverityLevel.BLOCKER)
  @ParameterizedTest
  @MethodSource("EXPENSES_DATA")
  public void monefy_03_addNewExpense_isExpensesUpdatedInSpendingsScreen(String note, String account, String amount, String category) {
    // Given
    Double initialExpensesAmount = spendingsScreen.getTotalExpensesAmount();

    // When
    expensesAndIncomesScreen.goToAddExpensesScreen();
    expensesAndIncomesScreen.addNote(note);
    expensesAndIncomesScreen.selectAccount(account);
    expensesAndIncomesScreen.setAmount(amount);
    expensesAndIncomesScreen.chooseCategory(category);

    // Then
    assertTrue(Double.compare(spendingsScreen.getTotalExpensesAmount(), initialExpensesAmount) > 0);
  }

  @Severity(SeverityLevel.BLOCKER)
  @ParameterizedTest
  @MethodSource("INCOMES_DATA")
  public void monefy_04_addNewIncome_isIncomesUpdatedInSpendingsScreen(String note, String account, String amount, String category) {
    // Given
    Double initialIncomesAmount = spendingsScreen.getTotalIncomesAmount();

    // When
    expensesAndIncomesScreen.goToAddIncomesScreen();
    expensesAndIncomesScreen.addNote(note);
    expensesAndIncomesScreen.selectAccount(account);
    expensesAndIncomesScreen.setAmount(amount);
    expensesAndIncomesScreen.chooseCategory(category);

    // Then
    assertTrue(Double.compare(spendingsScreen.getTotalIncomesAmount(), initialIncomesAmount) > 0);
  }

  @Severity(SeverityLevel.NORMAL)
  @ParameterizedTest
  @MethodSource("TRANSFERS_DATA")
  public void monefy_05_doNewTransfer_isTransfersUpdatedInSpendingsScreen(String note, String accountOrigin, String accountDestiny, String amount) {
    // Given
    newTransferScreen.goToNewTransferScreen();

    // When
    newTransferScreen.addNote(note);
    newTransferScreen.selectFromAccount(accountOrigin);
    newTransferScreen.selectToAccount(accountDestiny);
    newTransferScreen.setAmount(amount);
    newTransferScreen.addTransfer();

    // Then
    assertTrue(spendingsScreen.isSpendingsScreenDisplayed());
  }

  @Severity(SeverityLevel.NORMAL)
  @ParameterizedTest
  @MethodSource("TRANSACTIONS_DATA")
  public void monefy_06_filterTransactionsByDate_isTransactionsDetailsDisplayed(Period date, TransactionsSorting transactionsSorting) {
    // Given
    dateSettingsScreen.openDateSettingsPanel();
    dateSettingsScreen.filterBy(date);

    // When
    transactionsDetails.goToTransactionsDetailsScreen();
    transactionsDetails.sortBy(transactionsSorting);

    // Then
    assertTrue(transactionsDetails.isTransactionAmountsDisplayed(transactionsSorting));
    transactionsDetails.closeTransactionsDetailsScreen();
  }

  @Severity(SeverityLevel.NORMAL)
  @ParameterizedTest
  @MethodSource("SPENDINGS_DATE")
  public void monefy_07_filterSpendingsByDate_isCurrentBalanceGreaterThanZero(Period date) {
    // Given
    dateSettingsScreen.openDateSettingsPanel();

    // When
    dateSettingsScreen.filterBy(date);

    // Then
    assertTrue(Double.compare(transactionsDetails.getCurrentBalanceAmount(), 0.00) > 0);
  }

  @Severity(SeverityLevel.CRITICAL)
  @ParameterizedTest
  @MethodSource("ACCOUNTS_NAME")
  public void monefy_08_goToAccountsPanel_isAccountWithTotalBalanceDisplayed(String accountName) {
    // Given
    configurationScreen.openConfigurationPanel();

    // When
    configurationScreen.goToAccountsList();

    // Then
    assertAll(() -> assertTrue(accountsPanelScreen.isAccountWithName(accountName)), () -> assertNotNull(accountsPanelScreen.getAccountCurrentBalance(accountName)));
    configurationScreen.closeConfigurationPanel();
  }

  private static Stream<Arguments> ADD_NEW_ACCOUNT() {
    return Arrays.stream(new Arguments[] {Arguments.of("Banco", "50000", 1)});
  }

  private static Stream<Arguments> ADD_ACCOUNT_BALANCE() {
    return Arrays.stream(new Arguments[] {Arguments.of("Efectivo", "500"), Arguments.of("Tarjeta de pago", "2000")});
  }

  private static Stream<Arguments> EXPENSES_DATA() {
    return Arrays.stream(new Arguments[] {Arguments.of("Alquiler del piso", "Tarjeta de pago", "750", "Casa")});
  }

  private static Stream<Arguments> INCOMES_DATA() {
    return Arrays.stream(new Arguments[] {Arguments.of("Vacaciones de verano", "Efectivo", "50", "Ahorros")});
  }

  private static Stream<Arguments> TRANSFERS_DATA() {
    return Arrays.stream(new Arguments[] {Arguments.of("Compra de comida", "Tarjeta de pago", "Efectivo", "20")});
  }

  private static Stream<Arguments> TRANSACTIONS_DATA() {
    return Arrays.stream(new Arguments[] {Arguments.of(Period.MONTH, TransactionsSorting.DATE), Arguments.of(Period.MONTH, TransactionsSorting.CATEGORY)});
  }

  private static Stream<Period> SPENDINGS_DATE() {
    return Stream.of(Period.DAY, Period.MONTH, Period.YEAR);
  }

  private static Stream<String> ACCOUNTS_NAME() {
    return Stream.of("Efectivo", "Tarjeta de pago");
  }

}
