package application;

import org.junit.Test;
import static application.BankerDemo.transferFunds;
import static org.junit.Assert.assertEquals;

public class ChaseTest {
    //creating a new object?
    //we want to test behavior of Chase objects.
    //validating one objects behavior means all other objects created from this class will behave the same
    Chase alexChaseAccount = new Chase();

    @Test
    public void depositWithinAllowedRangeTest(){
        //depositing 1000
        alexChaseAccount.deposit(1000);
        //validating if the balance is 1000; bc newly created account does not have any deposit.
        //delta -> 0.0
        double actual = alexChaseAccount.getBalance();
        assertEquals("Invalid deposit within the allowed range",1000,actual,0.0);
    }


    @Test
    public void depositAboveThresholdLimitTest(){
        //I want to deposit a new value into my method.
        //deposit set threshold.
        alexChaseAccount.deposit(1000000000);
        assertEquals("",0.0,alexChaseAccount.getBalance(),0.0);
    }

    @Test
    public void depositNegativeValueTest(){
        alexChaseAccount.deposit(-10);
        assertEquals(alexChaseAccount.getBalance(),0.0,0.0);
    }

    @Test
    public void withDrawTest(){
        Chase alexChaseAccount = new Chase();
        alexChaseAccount.deposit(1000);
        alexChaseAccount.withDraw(500);
        assertEquals(alexChaseAccount.getBalance(),500,0.0);
        Chase alexChaseAccount1 = new Chase();
        alexChaseAccount1.deposit(-1);
        alexChaseAccount1.withDraw(500);
        assertEquals(alexChaseAccount1.getBalance(),0.0,0.0);
        Chase alexChaseAccount2 = new Chase();
        alexChaseAccount2.deposit(1000);
        alexChaseAccount2.withDraw(50000);
        assertEquals(alexChaseAccount2.getBalance(),1000,0.0);
    }

    @Test
    public void transferTest() {
        Chase alexChaseAccount = new Chase();
        alexChaseAccount.deposit(1000);
        Chase belaChaseAccount = new Chase();
        belaChaseAccount.deposit(2000);
        transferFunds(alexChaseAccount, belaChaseAccount, 800);
        assertEquals(alexChaseAccount.getBalance(), 200, 0.0);
        assertEquals(belaChaseAccount.getBalance(), 2800, 0.0);
    }


    @Test
    public void insufficientFundsTransferTest(){
        Chase alexChaseAccount1 = new Chase();
        alexChaseAccount1.deposit(100);
        Chase belaChaseAccount1 = new Chase();
        belaChaseAccount1.deposit(20);

        transferFunds(alexChaseAccount1, belaChaseAccount1, 150);

        assertEquals(alexChaseAccount1.getBalance(),100,0.0);
        //there is a bug in the application.
        assertEquals(belaChaseAccount1.getBalance(),20,0.0);
    }



}
