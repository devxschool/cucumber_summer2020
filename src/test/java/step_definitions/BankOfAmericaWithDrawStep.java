package step_definitions;

import application.BankBase;
import application.BankOfAmerica;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import domains.AccountDataHolder;
import domains.BalanceCheckContainer;
import domains.WithdrawDataContainer;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Use List<Object> for data tables
 */
public class BankOfAmericaWithDrawStep {

    List<BankBase> banks = new ArrayList<>();

    @Given("^the user accounts are created$")
    public void the_user_accounts_are_created(List<AccountDataHolder> accountDataHolderList) throws Throwable {
        for (AccountDataHolder accountDataHolder : accountDataHolderList) {
            banks.add(new BankOfAmerica(accountDataHolder.getAccountNumber(), accountDataHolder.getRoutingNumber()));
        }
    }

    //H/W implement Datatable with List of object. and execute withdraw for a specific account.
    @When("^the users withdraw$")
    public void the_users_withdraw(List<WithdrawDataContainer> withdrawDataContainerList) throws Throwable {
        for (BankBase bank : banks) {
            for (WithdrawDataContainer oneWithdrawRow : withdrawDataContainerList) {
                if(bank.getAccountNumber() == oneWithdrawRow.getAccountNumber()) {
                    bank.withDraw(oneWithdrawRow.getWithdrawAmount());
                }
            }
        }
    }

    @Then("^the users have the following balances$")
    public void the_users_have_the_following_balances(List<BalanceCheckContainer> balanceCheckContainers) throws Throwable {
        for (BankBase bank : banks) {
            for (BalanceCheckContainer oneWithdrawRow : balanceCheckContainers) {
                if(bank.getAccountNumber() == oneWithdrawRow.getAccountNumber()) {
                    double actual = bank.getBalance();
                    double expected = oneWithdrawRow.getBalance();
                    Assert.assertEquals(expected,actual,0.0);
                }
            }
        }
    }
}
