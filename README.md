# BankingSystem
Here’s a description you can add to your GitHub repository for your Banking System project:

---

Banking System

This project implements a simple console-based banking system that supports the following operations:

- Input Transactions: Allows users to input banking transactions such as deposits and withdrawals for various accounts.
- Define Interest Rules: Enables the definition of interest rules that are applied to the accounts based on the balance at the end of the day.
- Print Statement: Allows users to print out account statements for a specific month, showing all transactions, including any interest applied.

Features:

- Transaction Handling: Users can input transactions with dates, account IDs, transaction types (deposit or withdrawal), and amounts. The system ensures that accounts cannot go into negative balance.
- Interest Calculation: Users can define interest rates which are applied to accounts at the end of the day. The interest is calculated for the specified period and credited to the account at the end of each month.
- Account Statements: The system generates detailed statements that include transactions and interest calculations for a selected month.

Requirements:
- Java 8 or higher
- Maven (for dependency management and building the project)

How to Run:

1. Clone this repository to your local machine.
2. Navigate to the project directory.
3. Open a terminal/command prompt and run `mvn clean install` to build the project.
4. Run the `BankingSystem` class to start the console application.

Testing:
The project includes unit tests and mock tests using **JUnit** and **Mockito** to ensure code quality and proper functionality.

### Example Usage:

Upon launching the application, the following options are presented:

```
Welcome to AwesomeGIC Bank! What would you like to do?
[T/t] Input transactions
[I/i] Define interest rules
[P/p] Print statement
[Q/q] Quit
>
```

Users can:
- Input transactions**: Enter transaction details in the format `<Date> <Account> <Type> <Amount>`.
- Define interest rules**: Define interest rules by entering `<Date> <RuleId> <Rate in %>`.
- Print statement**: Generate account statements by entering `<Account> <YearMonth>`.
