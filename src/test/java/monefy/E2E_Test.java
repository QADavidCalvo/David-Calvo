package monefy;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import monefy.driver.DriverController;
import monefy.pageObjects.CurrentBalanceScreen;
import monefy.pageObjects.DrawerScreen;
import monefy.pageObjects.ExpensesAndIncomesScreen;
import monefy.pageObjects.NewTransferScreen;
import monefy.pageObjects.OptionsScreen;
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

  ToolbarScreen toolbar = new ToolbarScreen();
  DrawerScreen drawer = new DrawerScreen();
  OptionsScreen optionsScreen = new OptionsScreen();
  SummaryScreen summaryScreen = new SummaryScreen();
  CurrentBalanceScreen currentBalanceScreen = new CurrentBalanceScreen();
  ExpensesAndIncomesScreen expensesAndIncomesScreen = new ExpensesAndIncomesScreen();
  NewTransferScreen newTransferScreen = new NewTransferScreen();

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
