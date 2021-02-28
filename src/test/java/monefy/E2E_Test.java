package monefy;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import monefy.driver.DriverController;
import monefy.pageObjects.AccountsEditionScreen;
import monefy.pageObjects.AccountsPanelScreen;
import monefy.pageObjects.ConfigurationScreen;
import monefy.pageObjects.CurrentBalanceScreen;
import monefy.pageObjects.DrawerScreen;
import monefy.pageObjects.ExpensesAndIncomesScreen;
import monefy.pageObjects.NewTransferScreen;
import monefy.pageObjects.SummaryScreen;
import monefy.pageObjects.ToolbarScreen;

public class E2E_Test {

  @BeforeAll
  public static void setUp() {
    DriverController.initDriver();
  }

  @AfterAll
  public static void tearDown() {
    // AllureReport.generateReport();
    DriverController.stopDriver();
  }

  DrawerScreen drawer = new DrawerScreen();
  ToolbarScreen toolbar = new ToolbarScreen();
  ConfigurationScreen configurationScreen = new ConfigurationScreen();
  AccountsPanelScreen accountsPanelScreen = new AccountsPanelScreen();
  AccountsEditionScreen accountsEditionScreen = new AccountsEditionScreen();
  SummaryScreen summaryScreen = new SummaryScreen();
  CurrentBalanceScreen currentBalanceScreen = new CurrentBalanceScreen();
  ExpensesAndIncomesScreen expensesAndIncomesScreen = new ExpensesAndIncomesScreen();
  NewTransferScreen newTransferScreen = new NewTransferScreen();

  @Severity(SeverityLevel.MINOR)
  @ParameterizedTest
  @MethodSource("ADD_NEW_ACCOUNT")
  public void monefy_01_addNewAccount_isNewAccountSet(String accountName, String accountBalance, int accountImage) {
    // Given
    toolbar.pressConfigurationButton();
    configurationScreen.pressAccountsButton();

    // When
    accountsPanelScreen.pressAddAccountButton();
    accountsEditionScreen.addAccountName(accountName);
    accountsEditionScreen.addAccountInitialBalance(accountBalance);
    accountsEditionScreen.addAccountImage(accountImage);
    accountsEditionScreen.saveAccountSettings();

    // Then
    accountsPanelScreen.isAccountWithName(accountName);
  }

  @Severity(SeverityLevel.NORMAL)
  @ParameterizedTest
  @MethodSource("ADD_ACCOUNT_BALANCE")
  public void monefy_02_addBalanceToAccount_isAccountWithBalanceSet(String accountName, String accountBalance) {
    // Given
    toolbar.pressConfigurationButton();
    configurationScreen.pressAccountsButton();

    // When
    accountsPanelScreen.editAccount(accountName);
    accountsEditionScreen.addAccountInitialBalance(accountBalance);
    accountsEditionScreen.closeAccountSettings();

    // And
    toolbar.pressConfigurationButton();
    configurationScreen.pressAccountsButton();

    // Then
    accountsPanelScreen.isAccountWithBalance(accountName);
  }

  @Severity(SeverityLevel.BLOCKER)
  @ParameterizedTest
  @MethodSource("EXPENSES_DATA")
  public void monefy_01_addNewExpense_isExpensesUpdatedInSummaryScreen(String note, String account, String amount, String category) {
    // Given
    Double currentExpensesAmount = summaryScreen.getTotalExpensesAmount();

    // When
    summaryScreen.pressAddExpensesButton();
    expensesAndIncomesScreen.addNote(note);
    expensesAndIncomesScreen.selectAccount(account);
    expensesAndIncomesScreen.setAmount(amount);
    expensesAndIncomesScreen.chooseCategory(category);

    // Then
    assertTrue(Double.compare(summaryScreen.getTotalExpensesAmount(), 0.00) > currentExpensesAmount);
  }

  @Severity(SeverityLevel.BLOCKER)
  @ParameterizedTest
  @MethodSource("INCOMES_DATA")
  public void monefy_02_addNewIncome_isIncomesUpdatedInSummaryScreen(String note, String account, String amount, String category) {
    // Given
    Double currentIncomesAmount = summaryScreen.getTotalIncomesAmount();

    // When
    summaryScreen.pressAddIncomesButton();
    expensesAndIncomesScreen.addNote(note);
    expensesAndIncomesScreen.selectAccount(account);
    expensesAndIncomesScreen.setAmount(amount);
    expensesAndIncomesScreen.chooseCategory(category);

    // Then
    assertTrue(Double.compare(summaryScreen.getTotalIncomesAmount(), 0.00) > currentIncomesAmount);
  }

  @Severity(SeverityLevel.NORMAL)
  @ParameterizedTest
  @MethodSource("TRANSFERS_DATA")
  public void monefy_03_doNewTransfer_isTransfersUpdatedInSummaryScreen(String note, String accountOrigin, String accountDestiny, String amount) {
    // Given
    toolbar.pressNewTransferButton();

    // When
    newTransferScreen.addNote(note);
    newTransferScreen.selectFromAccount(accountOrigin);
    newTransferScreen.selectToAccount(accountDestiny);
    newTransferScreen.setAmount(amount);
    newTransferScreen.addTransfer();

    // Then
    assertTrue(summaryScreen.isSummaryScreenDisplayed());
  }

  @Severity(SeverityLevel.NORMAL)
  @Test
  public void monefy_04_checkCurrentBalance_isCurrentBalanceDetailsDisplayed() {
    // Given

    // When

    // Then
  }

  @Severity(SeverityLevel.CRITICAL)
  @Test
  public void monefy_05_checkAccountsBalance_isCashAndPaymentCardBalancesDisplayed() {
    // Given

    // When

    // Then
  }

  private static Stream<Arguments> ADD_NEW_ACCOUNT() {
    return Arrays.stream(new Arguments[] {Arguments.of("Banco", "50000", 1)
    });
  }

  private static Stream<Arguments> ADD_ACCOUNT_BALANCE() {
    return Arrays.stream(new Arguments[] {Arguments.of("Efectivo", "500"), Arguments.of("Tarjeta de pago", "2000")
    });
  }

  private static Stream<Arguments> EXPENSES_DATA() {
    return Arrays.stream(new Arguments[] {Arguments.of("Alquiler del piso", "Tarjeta de pago", "750", "Casa")
    });
  }

  private static Stream<Arguments> INCOMES_DATA() {
    return Arrays.stream(new Arguments[] {Arguments.of("Vacaciones de verano", "Efectivo", "50", "Ahorros")
    });
  }

  private static Stream<Arguments> TRANSFERS_DATA() {
    return Arrays.stream(new Arguments[] {Arguments.of("Compra de comida", "Tarjeta de pago", "Efectivo", "20")
    });
  }

}
