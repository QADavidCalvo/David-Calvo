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

  private static Stream<Arguments> ACCOUNTS_DATA() {
    return Arrays.stream(new Arguments[] {Arguments.of("Banco", "50000", "Bolsa")
    });
  }

  @ParameterizedTest
  @MethodSource("ACCOUNTS_DATA")
  public void monefy_01_addNewAccount_isAccountAdded(String accountName, String accountBalance, String accountImage) {
    // Given
    toolbar.pressConfigurationButton();

    // When
    configurationScreen.pressAccountsButton();
    accountsPanelScreen.pressAddAccountButton();
    accountsEditionScreen.addAccountName(accountName);
    accountsEditionScreen.addAccountBalance(accountBalance);
    accountsEditionScreen.addAccountImage(accountImage);
    accountsEditionScreen.saveAccountSettings();

    // Then
    accountsPanelScreen.isAccountWithBalance(accountName);
  }

  @ParameterizedTest
  public void monefy_02_addBalanceToAccount_isBalanceAdded() {
    // Given

    // When

    // Then
  }

  @Test
  public void monefy_01_addNewExpense_isExpensesUpdatedInSummaryScreen() {
    // Given
    Double currentExpensesAmount = summaryScreen.getTotalExpensesAmount();

    // When
    summaryScreen.pressAddExpensesButton();
    expensesAndIncomesScreen.addNote("Alquiler del piso");
    expensesAndIncomesScreen.selectAccount("Tarjeta de pago");
    expensesAndIncomesScreen.setAmount("750");
    expensesAndIncomesScreen.chooseCategory("Casa");

    // Then
    assertTrue(Double.compare(summaryScreen.getTotalExpensesAmount(), 0.00) > currentExpensesAmount);
  }

  @Test
  public void monefy_02_addNewIncome_isIncomesUpdatedInSummaryScreen() {
    // Given
    Double currentIncomesAmount = summaryScreen.getTotalIncomesAmount();

    // When
    summaryScreen.pressAddIncomesButton();
    expensesAndIncomesScreen.addNote("Dinero para las vacaciones");
    expensesAndIncomesScreen.selectAccount("Efectivo");
    expensesAndIncomesScreen.setAmount("50");
    expensesAndIncomesScreen.chooseCategory("Ahorros");

    // Then
    assertTrue(Double.compare(summaryScreen.getTotalIncomesAmount(), 0.00) > currentIncomesAmount);
  }

  @Test
  public void monefy_03_doNewTransfer_isTransfersUpdatedInSummaryScreen() {
    // Given
    toolbar.pressNewTransferButton();

    // When
    newTransferScreen.addNote("Compra de comida");
    newTransferScreen.selectFromAccount("Tarjeta de pago");
    newTransferScreen.selectToAccount("Efectivo");
    newTransferScreen.setAmount("20");
    newTransferScreen.addTransfer();

    // Then
    assertTrue(summaryScreen.isSummaryScreenDisplayed());
  }

  @Test
  public void monefy_04_checkCurrentBalance_isCurrentBalanceDetailsDisplayed() {
    // Given

    // When

    // Then
  }

  @Test
  public void monefy_05_checkAccountsBalance_isCashAndPaymentCardBalancesDisplayed() {
    // Given

    // When

    // Then
  }

}
