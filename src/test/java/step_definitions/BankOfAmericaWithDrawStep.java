package step_definitions;

import application.BankBase;
import application.BankOfAmerica;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import domains.AccountDataHolder;
import org.junit.Assert;

import java.util.List;

/**
 * Use List<Object> for data tables
 */
public class BankOfAmericaWithDrawStep {

    BankBase bankOfAmerica1;
    BankBase bankOfAmerica2;
    BankBase bankOfAmerica3;

    @Given("^the user accounts are created$")
    public void the_user_accounts_are_created(List<AccountDataHolder> accountDataHolderList) throws Throwable {
        System.out.println(accountDataHolderList.get(1).getRoutingNumber());
        System.out.println(accountDataHolderList.get(2).getAccountNumber());


        bankOfAmerica1 = new BankOfAmerica(accountDataHolderList.get(0).getAccountNumber(), accountDataHolderList.get(0).getRoutingNumber());
        Assert.assertEquals(accountDataHolderList.get(0).getBalance(), bankOfAmerica1.getBalance(), 0.0);

        bankOfAmerica2 = new BankOfAmerica(accountDataHolderList.get(1).getAccountNumber(), accountDataHolderList.get(1).getRoutingNumber());
        Assert.assertEquals(accountDataHolderList.get(1).getBalance(), bankOfAmerica2.getBalance(), 0.0);

        bankOfAmerica3 = new BankOfAmerica(accountDataHolderList.get(2).getAccountNumber(), accountDataHolderList.get(2).getRoutingNumber());
        Assert.assertEquals(accountDataHolderList.get(2).getBalance(), bankOfAmerica3.getBalance(), 0.0);
    }

    //H/W implement Datatable with List of object. and execute withdraw for a specific account.
    @When("^the users withdraw$")
    public void the_users_withdraw(DataTable arg1) throws Throwable {

    }

    @Then("^the users have the following balances$")
    public void the_users_have_the_following_balances(DataTable arg1) throws Throwable {

    }
}
