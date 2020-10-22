package application;

public interface Bank {

    double getBalance();
    void deposit(double amount);
    void withDraw(double amount);

    /**
     *  Putting interface types in params enable these Bank sender and reciepent params(arguments) to be able to be used with any class that implements
     *  Bank interface.
     * @param sender -> put bankAccount of a sender
     * @param recipient -> put bankAccout of a recipient
     */
     static void transferFunds(Bank sender, Bank recipient, double transferAmount) {
        sender.withDraw(transferAmount);
        recipient.deposit(transferAmount);
    }
}



