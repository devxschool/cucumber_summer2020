package application;

import static application.Bank.transferFunds;

public class BankerDemo {

    public static void main(String[] args) throws Exception {

        Chase alexChaseAccount = new Chase(123456789101l,123456789);
        alexChaseAccount.deposit(1000);

        Chase belaChaseAccount = new Chase(123456789101l,123456789);
        belaChaseAccount.deposit(2000);


        transferFunds(alexChaseAccount, belaChaseAccount, 800);
        System.out.println(alexChaseAccount.getBalance());
        System.out.println(belaChaseAccount.getBalance());


        BankOfAmerica johnBankOfAmericaAccount = new BankOfAmerica(12345l,12312424l);
        johnBankOfAmericaAccount.deposit(2000);//2200

        System.out.println();
        transferFunds(johnBankOfAmericaAccount, alexChaseAccount, 800);
        System.out.println(alexChaseAccount.getBalance());
        System.out.println(johnBankOfAmericaAccount.getBalance());
    }


}
