package application;

public class BankOfAmerica  implements  Bank {

    private double balance = 200;

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if(amount < 0 || amount > 20000) {
            System.err.println("Invalid amount, can not be deposited");
        }
        else {
            balance += amount;
        }
    }

    public void withDraw(double amount) {
        if(amount < 0 || amount > 5000) {
            System.err.println("Invalid amount, can not be withdrawn");
        }
        else {
            if(balance < amount){
                System.err.println("Insufficient funds");
            }
            else {
                balance -= amount;
            }
        }
    }
}
