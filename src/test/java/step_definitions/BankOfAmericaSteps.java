package step_definitions;

import application.BankBase;
import application.BankOfAmerica;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

/**
 * Modify this Step Def class so that each step can handle any number of rows.
 * ex: you can create any number of accounts.
 *     you can deposit to exact accounts regardless of the position in the dataTables in feature file
 *     you can validate that exact account number has the given balance.
 *
 *     Hint -> you need loop through the List in param. use for each.
 *          -> you need to add bank created in the loop to a new List that you create on class level
 */
public class BankOfAmericaSteps {

    BankBase bankOfAmerica;
    BankBase bankOfAmerica2;

    @Given("^the following user account is created$")
    public void the_following_user_account_is_created(List<Map<String, Long>> accountAndRoutingNums) throws Exception {
        System.out.println(accountAndRoutingNums);
        bankOfAmerica = new BankOfAmerica(accountAndRoutingNums.get(0).get("accountNumber"), accountAndRoutingNums.get(0).get("routingNumber"));
        bankOfAmerica2 = new BankOfAmerica(accountAndRoutingNums.get(1).get("accountNumber"), accountAndRoutingNums.get(1).get("routingNumber"));

        System.out.println("Account number: " + bankOfAmerica.getAccountNumber());
    }

    @When("^the following deposits are made$")
    public void the_following_deposits_are_made(List<Map<String, String>> depositList) throws Throwable {
        System.out.println(depositList.get(0).get("deposit"));
        bankOfAmerica.deposit(Double.parseDouble( depositList.get(0).get("deposit")));
        bankOfAmerica2.deposit(Double.parseDouble( depositList.get(1).get("deposit")));
    }

    @Then("^accounts have the following balances$")
    public void accounts_have_the_following_balances(List<Map<String, String>> balanceList) throws Throwable {
        double actualBalance = bankOfAmerica.getBalance();
        double expectedBalance = Double.parseDouble(balanceList.get(0).get("balance"));
        Assert.assertEquals("balance ", expectedBalance, actualBalance,0.00);
        double actualBalance2 = bankOfAmerica2.getBalance();
        double expectedBalance2 = Double.parseDouble(balanceList.get(1).get("balance"));
        Assert.assertEquals("balance ", expectedBalance2, actualBalance2,0.00);
    }
}