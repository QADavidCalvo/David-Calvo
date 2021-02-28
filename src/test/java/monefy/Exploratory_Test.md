## Exploratory test

--------------------------------------------------------------------------

### Test suite
#### Objectives:
- Goal: Set personal spendings to know how much money I have at the end of the month in my accounts.
- Risks to mitigate: We want to check that user can manage the payment accounts, the spendings and the current balances, assuring that all the info can be set and calculated properly and no data is lost.
- Test plan: First create a new bank account and add balance to all the accounts, then add expenses and incomes for the current month and do some transfers, check the monthly balance details and finally return to the app to check the current balance in all the accounts.
- Out of scope: The tests are focused only in monthly spendings, so the other time interval spendings (daily, weekly, annual, etc.) are not checked.
- Tests types: Time-framed exploratory test charters
- Total test timebox: 1 hour

#### Set up:
- Test app: Monefy Lite v1.9.19.1177 (Store version)
- App language set: Spanish
- Test environment: Production
- Platform: Android
- Test device: Real device (Samsung Galaxy J6+ - Android 10)
- Device network: WIFI

--------------------------------------------------------------------------

### Test 1: Set up accounts
#### Information:
- Priority: Critical
- Requirements: Add accounts, Edit accounts
- Time-frame: 10m

#### Preconditions:
- Have the accounts set by default

#### Exploration:
- Create new account
- Add balance to all accounts


### Test 2: Add monthly expenses
#### Information:
- Priority: Critical
- Requirements: Dates selector, Expenses, Spendings summary
- Time-frame: 10m

#### Preconditions:
- Have no expenses previously set

#### Exploration:
- Filter spendings summary by dates
- Add some different expenses
- Check monthly expenses in the spendings summary

--------------------------------------------------------------------------

### Test 3: Add monthly incomes
#### Information:
- Priority: High
- Requirements: Dates selector, Incomes, Spendings summary
- Time-frame: 10m

#### Preconditions:
- Have no incomes previously set

#### Exploration:
- Filter spendings summary by dates
- Add some different incomes
- Check monthly incomes in the spendings summary

--------------------------------------------------------------------------

### Test 4: Do some transfers
#### Information:
- Priority: High
- Requirements: Dates selector, Transfers, Spendings summary
- Time-frame: 10m

#### Preconditions:
- Have no transfers previously set

#### Exploration:
- Filter spendings summary by dates
- Do some transfers to cash and payment card
- Check the transfers in the spendings summary

--------------------------------------------------------------------------

### Test 5: Check balance details
#### Information:
- Priority: Critical
- Requirements: Dates selector, Current balance details, Spendings summary
- Time-frame: 10m

#### Preconditions:
- Have expenses, incomes and transfers previously set

#### Exploration:
- Filter spendings by month
- Select all the available accounts
- Add expenses
- Check 

--------------------------------------------------------------------------

### Test 6: Check current balances
#### Information:
- Priority: Critical
- Requirements: Dates selector, Accounts current balances, Spendings summary
- Time-frame: 10m

#### Preconditions:
- Have expenses, incomes and transfers previously set

#### Exploration:
- Filter spendings by month
- Select all the available accounts
- Add expenses
- Check 

--------------------------------------------------------------------------

### Final observations:
During the test I didn't detected any critical error but I saw some usability issues:
1. In some cases the user experience is not clear like when adding a new transfer that the user should need to select the origin and the destiny accounts before add the amount and apply the transfer because there keyboard overlaps those selectors (needing in this case to tap the device's physical back button to close it). So here can be better to have a wizard explaining the steps to do the actions or even having all the fields always shown on the screen.

2. There are Pro features that are not indicated to the user on the screen (like adding a category, add a new currency, etc.), so the user is adviced suddenly just when she tries to do the action and it's frustrating. Those features are indicated in the "About" section but it's not easy to find, so in this case should be better to put a "Pro" label for instance on the actions that needs to have a Pro version.

3. There are sections not translated into Spanish like the Pro features section, some menus in the settings, etc., which give the application a bad image so I suggest fully translate the application in that language before adding it to the list of available languages.


--------------------------------------------------------------------------