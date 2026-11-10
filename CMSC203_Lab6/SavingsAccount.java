/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: A savings account that extends BankAccount. It earns
 * interest, and several savings accounts can share one account number,
 * told apart by the number after the dash.
 * Platform/compiler: Eclipse
 * Name: Aser Wondemu
 */

/** A bank account that earns interest. */
public class SavingsAccount extends BankAccount {

    /** Annual interest rate (2.5%). */
    private double rate = 0.025;

    /** Which savings account this is under the same account number. */
    private int savingsNumber = 0;

    /** Hides the accountNumber in BankAccount. */
    private String accountNumber;

    /**
     * Creates the first savings account for a person.
     *
     * @param name the owner of the account
     * @param amount the beginning balance
     */
    public SavingsAccount(String name, double amount) {
        super(name, amount);
        accountNumber = super.getAccountNumber() + "-" + savingsNumber;
    }

    /**
     * Copy constructor: creates another savings account for the same
     * person, with the next savings number.
     *
     * @param oldAccount the original savings account
     * @param amount the beginning balance of the new account
     */
    public SavingsAccount(SavingsAccount oldAccount, double amount) {
        super(oldAccount, amount);
        savingsNumber = oldAccount.savingsNumber + 1;
        accountNumber = super.getAccountNumber() + "-" + savingsNumber;
    }

    /**
     * Calculates one month of interest and deposits it.
     */
    public void postInterest() {
        double interest = getBalance() * rate / 12;
        deposit(interest);
    }

    /**
     * @return the savings account number, like 100002-0
     */
    @Override
    public String getAccountNumber() {
        return accountNumber;
    }
}
