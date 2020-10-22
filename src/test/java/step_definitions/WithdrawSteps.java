package step_definitions;

import application.BankBase;
import cucumber.api.java.en.Then;

public class WithdrawSteps {

    @Then("^all accounts are reset$")
    public void all_accounts_are_reset() {
        //cache -> clear the cache of application before every test.
        BankBase.allBankRecords.clear();
    }
}
