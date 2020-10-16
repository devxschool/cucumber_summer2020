package application;

public class BankerDemo {

    public static void main(String[] args) {

        Chase alexChaseAccount = new Chase();
        alexChaseAccount.deposit(1000);

        Chase belaChaseAccount = new Chase();
        belaChaseAccount.deposit(2000);


        transferFunds(alexChaseAccount, belaChaseAccount, 800);
        System.out.println(alexChaseAccount.getBalance());
        System.out.println(belaChaseAccount.getBalance());


        BankOfAmerica johnBankOfAmericaAccount = new BankOfAmerica();
        johnBankOfAmericaAccount.deposit(2000);//2200

        System.out.println();
        transferFunds(johnBankOfAmericaAccount, alexChaseAccount, 800);
        System.out.println(alexChaseAccount.getBalance());
        System.out.println(johnBankOfAmericaAccount.getBalance());
    }

    /**
     *  Putting interface types in params enable these Bank sender and reciepent params(arguments) to be able to be used with any class that implements
     *  Bank interface.
     * @param sender -> put bankAccount of a sender
     * @param recipient -> put bankAccout of a recipient
     */
    public static void transferFunds(Bank sender, Bank recipient, double transferAmount) {
        sender.withDraw(transferAmount);
        recipient.deposit(transferAmount);
    }
}
