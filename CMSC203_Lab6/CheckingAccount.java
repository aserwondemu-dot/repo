/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: A checking account that extends BankAccount. Every
 * withdrawal is charged a fee of 15 cents for clearing the check.
 * Platform/compiler: Eclipse
 * Name: Aser Wondemu
 */

/** A bank account that charges a fee for each check cleared. */
public class CheckingAccount extends BankAccount {

    /** The cost of clearing one check. */
    private static final double FEE = 0.15;

    /**
     * Creates a checking account. The account number gets "-10" added
     * to the end, since all checking accounts end in -10.
     *
     * @param name the owner of the account
     * @param amount the beginning balance
     */
    public CheckingAccount(String name, double amount) {
        super(name, amount);
        setAccountNumber(getAccountNumber() + "-10");
    }

    /**
     * Withdraws the amount plus the check-clearing fee.
     *
     * @param amount the amount to withdraw
     * @return true if there was enough money, false otherwise
     */
    @Override
    public boolean withdraw(double amount) {
        return super.withdraw(amount + FEE);
    }
}
