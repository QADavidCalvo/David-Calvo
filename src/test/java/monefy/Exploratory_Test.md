## Exploratory test

#### Table of Contents
- [Test suite information](#test-suite-information)
- [Test charter 1: Set up accounts](#test-charter-1-set-up-accounts)
- [Test charter 2: Add monthly expenses](#test-charter-2-add-monthly-expenses)
- [Test charter 3: Add monthly incomes](#test-charter-3-add-monthly-incomes)
- [Test charter 4: Do some transfers](#test-charter-4-do-some-transfers)
- [Test charter 5: Check balance details](#test-charter-5-check-balance-details)
- [Test charter 6: Check accounts balance](#test-charter-6-check-accounts-balance)
- [Test charter 7: Backup and restore data](#test-charter-7-backup-and-restore-data)
- [Final observations](#final-observations)

--------------------------------------------------------------------------

### Test suite information

#### Objectives:
- Goal: Set personal spendings to know how much money I have at the end of the month in my accounts and check that all the data is stored properly.
- Risks to mitigate: We want to check that user can manage the payment accounts, the spendings and the current balances, assuring that all the info can be set and calculated properly and no data is lost.
- Test plan: First create a new bank account and add balance to all the accounts, then add expenses, incomes and transfers for the current month, check the balance details and finally do a backup and restore the data.
- Out of scope: The tests are focused only in monthly spendings, so don't spend time configuring other dates.

#### Test:
- Tester: David Calvo Pérez
- Test date: 2021/02/27 10:00
- Tests type: Time-framed exploratory test charters
- Total duration: 1 hour

#### Set up:
- Test app: Monefy Lite v1.9.19.1177 (Store version)
- App language set: Spanish
- Test environment: Production
- Platform: Android
- Test device: Real device (Samsung Galaxy J6+ - Android 10)
- Device network: WIFI

--------------------------------------------------------------------------

### Test charter 1: Set up accounts

#### Information:
- Priority: High
- Requirements: Add accounts, Edit accounts
- Time-frame: 10 minutes

#### Preconditions:
- Have the accounts set by default

#### Exploration:
- Create new account
- Add balance to all accounts

#### Test notes:
- Once the app is opened there are no information about the current accounts shown in the screen, so I needed to find the access to the desired section. I found it after tap on the three vertical dots button at the topbar and after tapp on the accounts option. Once I accessed to the account info I tapped on the + icon to access to a screen where I could add a new account, setting the name "Cuenta bancaria", the initial balance "50.000,00€, and an image for that account. I set to start with that balance since 2021/01/01. After that tapped on the add account button on the header and then the new account appeared in the accounts list with the current balance. Because there were two preconfigured accounts, I added "500€" as initial balance for the cash and "2000€" for the payment card, both starting the first day of this month. Then in the main screen I saw all those amounts added as a green value in the middle of the screen.

--------------------------------------------------------------------------

### Test charter 2: Add monthly expenses

#### Information:
- Priority: Critical
- Requirements: Dates selector, Expenses, Spendings summary
- Time-frame: 10 minutes

#### Preconditions:
- Have accounts set but no expenses previously added

#### Exploration:
- Filter spendings summary by dates
- Add some different expenses
- Check monthly expenses in the spendings summary

#### Test notes:
- By default there are no expenses added in the application. I started filtering the spendings by month, selecting all the accounts and the date from the left drawer that shows after tap on the inverted pyramid at the left of the topbar. Once the monthly spendings was shown, I tapped on the "-" red icon at the bottom-left of the screen and the new expenses screen was shown. Then I added a note "Comida para los gatos", I selected the account "Payment card", I typped on the keyboard the number "30" and then tapped on the action button of the keyboard to access a category selector, then I selected "Mascotas" and the expense was added to the monthly spendings, shown as a percentage at the "Pets" icon and as a red value in the middle of the main screen. After that I added a "Gift" expense just tapping on the gift icon, in that case the category was preselected. And after add it, I saw the percentages of both monthly expenses and tha total amount of the monthly expenses in the middle of the screen. I realized that the balance amount at the bottom of the screen was updated.

--------------------------------------------------------------------------

### Test charter 3: Add monthly incomes

#### Information:
- Priority: Critical
- Requirements: Dates selector, Incomes, Spendings summary
- Time-frame: 10 minutes

#### Preconditions:
- Have accounts set but no incomes previously added

#### Exploration:
- Filter spendings summary by dates
- Add some different incomes
- Check monthly incomes in the spendings summary

#### Test notes:
- By default there are no incomes added in the application. I started filtering the spendings by month, selecting all the accounts and the date from the left drawer that shows after tap on the inverted pyramid at the left of the topbar. Once the monthly spendings was shown, I tapped on the "+" green icon at the bottom-right of the screen and the new incomes screen was shown. Then I added a note "Sueldo", I selected the account "Payment card", I typped on the keyboard the number "1500" and then tapped on the action button of the keyboard to access a category selector, then I selected "Salario" and the income was added to the monthly spendings as an amount added to the overall incomes shown as a green text in the middle of the screen. No icons or percentages were shown for that income. After that I accessed again to the new income screen and I added 20€ of savings in cash and again that income was added to the overall in the monthly spendings. I saw that the balance amount at the bottom of the screen was updated.

--------------------------------------------------------------------------

### Test charter 4: Do some transfers

#### Information:
- Priority: Critical
- Requirements: Dates selector, Transfers, Spendings summary
- Time-frame: 10 minutes

#### Preconditions:
- Have accounts set but no transfers previously added

#### Exploration:
- Filter spendings summary by dates
- Do some transfers to cash and payment card
- Check the transfers in the spendings summary

#### Test notes:
- I wanted to do two transfers, one from cash to bank and another from payment card to cash, so that I accessed to the new transfer screen tapping on the two directions arrows icon at the topbar, I selected the origin and the destiny accounts and I set the amount of that transfers. After apply the data set, I saw a message indicating that the transfer was created successfully and I saw a new red icon with two directions arrows and a percentage indicating that there were transfers created this month and those ones were shown in the middle of the screen added to the total amount of expenses.

--------------------------------------------------------------------------

### Test charter 5: Check balance details

#### Information:
- Priority: Medium
- Requirements: Dates selector, Current balance details, Spendings summary
- Time-frame: 10 minutes

#### Preconditions:
- Have accounts, expenses, incomes and transfers previously set

#### Exploration:
- Filter spendings by month
- Select all the available accounts
- Check the balance details by date and by category

#### Test notes:
- Once I have added some monthly expenses and incomes and did some transfers, I was be able to check the details of the monthly balance. First of all I filtered by all the accounts and by month, then I tapped on the balance amount at the bottom of the screen. Then I saw the category and the amount of all the spendings of that month grouped by date (the expenses shown with a red dot and the incomes with a green dot). After that I tapped on the icon at the top-right of the screen to see the information grouped by category (in yellow the name of the accounts and in green color their balances, and in green color the name of the expenses and incomes, and in green color the incomes and in red the expenses). After that I closed the screen just tapping on the total balance at the top of the screen.

--------------------------------------------------------------------------

### Test charter 6: Check accounts balance

#### Information:
- Priority: High
- Requirements: Dates selector, Accounts current balances, Spendings summary
- Time-frame: 5 minutes

#### Preconditions:
- Have expenses, incomes and transfers previously set

#### Exploration:
- Filter spendings by different dates
- Check current accounts balance

#### Test notes:
- Once I have added some monthly expenses and incomes and did some transfers, I was be able to check the accounts balance updated. First of all I filtered by all the accounts and by month, then I tapped on the three vertical dots button at the topbar and then I tapped on the accounts option. Then I saw the current balance of the three account I have configured (bank account, cash and payment card), I checked that the amount was correct, having into account the initial balance I set and all the spendings I was creating. I changed the dates filtering by date range, day, week, year, etc. to see that the information changed showing the correct amount for each dates.

--------------------------------------------------------------------------

### Test charter 7: Backup and restore data

#### Information:
- Priority: Critical
- Requirements: Configuration, Data backup
- Time-frame: 5 minutes

#### Preconditions:
- Have accounts, expenses, incomes and transfers previously set

#### Exploration:
- Check the backup and restore of the current data.
- Check the deleting of the current local data.

#### Test notes:
- After have accounts, expenses, incomes and transfers set in the application is the moment to do a backup fo this data. To do that, I accessed to the right panel tapping on the three vertical dots button at the topbar and then I tapped on the "Settings" option. A new panel was displayed with some configurations and at the end there were the options to manage the backups of the data. First of all I tapped on the "Create data backup" button, then appeared a popup to allow permissions to store data in the device, and after agree it, a confirmation message appeared, I accepted and then a message was shown indicating that the current data was stored to "//com.monefy//monefy_backup_YYYY_MM_DD_hh_mm_ss", that file can be used to restore the data in another device, but to try the functionality, I just tapped on the "Clear data" button and saw that all the information in the app was deleted, so then I tapped on the "Restore data" button, I selected the most recent backup file from the list of backups done, and I applied it. A confirmation popup appeared warning me that all the data will be replaced, including the Google Drive or Dropbox data), finally after confirm the action and saw a message indicating that the current data was restored sucessfully. All the information set previously appeared again in the app.

--------------------------------------------------------------------------

### Final observations:

During the test I didn't detected any critical error but I saw some usability issues:

1. In some cases the user experience is not clear like when adding a new transfer that the user should need to select the origin and the destiny accounts before add the amount and apply the transfer because there keyboard overlaps those selectors (needing in this case to tap the device's physical back button to close it). So here can be better to have a wizard explaining the steps to do the actions or even having all the fields always shown on the screen.

2. There are Pro features that are not indicated to the user on the screen (like adding a category, add a new currency, etc.), so the user is adviced suddenly just when she tries to do the action and it's frustrating. Those features are indicated in the "About" section but it's not easy to find, so in this case should be better to put a "Pro" label for instance on the actions that needs to have a Pro version.

3. There are sections not translated into Spanish like the Pro features section, some menus in the settings, etc., which give the application a bad image so I suggest fully translate the application in that language before adding it to the list of available languages.

So the application is stable, stores and restores the data successfully, works fine and it's usefull to manage the personal spendings.

--------------------------------------------------------------------------
