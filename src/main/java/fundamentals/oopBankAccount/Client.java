package fundamentals.oopBankAccount;

import java.util.Arrays;

/**
 * Client  which consists of:
 * constructor: with arguments: name and cnp (for initializing the fields and the  bankingAccount array will be initialized with an empty array or only instantiated)
 * fields: bankingAccounts ( array of max 2 banking accounts), name, cnp
 * methods:
 * 1.addBankAccount( takes one argument, bankAccount obj - if there already exists a banking account of the same type in the array an error message is printed)
 * 2.getSavingAccount( returns the bankAccount obj of type SAVING from the array, if there isn’t a saving account a null object is return along with printing an error message)
 * 3.removeAccountByType (takes a string argument which represents the type of the account to be removed from the array and prints a success message if the operations succeeded or error message if not - where the account did not exist in the array)
 */

public class Client {

    private String name;
    private String cnp;
    private BankAccount bankAccount;
    private BankAccount[] bankAccounts;

    public BankAccount[] getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(BankAccount[] bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public Client(String name, String cnp, BankAccount bankAccount) {
        this.name = name;
        this.cnp = cnp;
        this.bankAccount = bankAccount;
    }

    public Client(String name, String cnp) {
        this.name = name;
        this.cnp = cnp;
        this.bankAccount = new BankAccount();
    }

    public Client() {
        this.bankAccount = new BankAccount();      //instantiem cu new
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", cnp='" + cnp + '\'' +
                ", bankAccount=" + bankAccount +
                ", bankAccounts=" + Arrays.toString(bankAccounts) +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    //1.addBankAccount( takes one argument, bankAccount obj - if there already exists a banking
    // account of the same type in the array an error message is printed)
    public void addBankAccount(BankAccount bankAccount) {
        int index = 0;
        for (int i = 0; i < 2; i++) {
            if (this.bankAccounts[i].getType().equals(bankAccount.getType())) {
                System.out.println("Error: This type of banking account already exists.");
                return;
            }
            index = i;
        }
        this.bankAccounts[index] = bankAccount;
    }

    //2.getSavingAccount( returns the bankAccount obj of type SAVING from the array, if there isn’t a saving account
    // a null object is return along with printing an error message)
    public BankAccount getSavingAccount() {
        for (int i = 0; i < this.bankAccounts.length; i++) {
            if (this.bankAccounts[i].getType().equals("SAVING")) {
                return bankAccounts[i];
            }
        }
        System.out.println("Error: There isn't a saving account.");
        return null;
    }

    // removeAccountByType (takes a string argument which represents the type of the account to be removed from the array
// * and prints a success message if the operations succeeded or error message if not - where the account did not exist
// * in the array)
    public void removeAccountByType(String accountType) {
        boolean removed = false;
        for (int i = 0; i < this.bankAccounts.length; i++) {
            if (this.bankAccounts[i].getType().equals(accountType)) {
                this.bankAccounts[i] = new BankAccount("", "");
                System.out.println("Account removed succesfully.");
                removed = true;
            }
        }
        if (removed == false) {
            System.out.println("Error: This type of banking account does not exist.");
        }
    }
}