package step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioOutlineSteps {

    @Given("^user with \"([^\"]*)\" and \"([^\"]*)\" is registered$")
    public void user_with_and_is_registered(String username, String password) throws Throwable {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }

    @When("^user with \"([^\"]*)\" and \"([^\"]*)\" logs in$")
    public void user_with_and_logs_in(String username, String password) throws Throwable {
        System.out.println("Username used to login: " + username);
        System.out.println("Password used to login: " + password);
    }

    @Then("^user should see the \"([^\"]*)\"$")
    public void user_should_see_the(String message) throws Throwable {
        System.out.println("Message " + message);
    }

}
