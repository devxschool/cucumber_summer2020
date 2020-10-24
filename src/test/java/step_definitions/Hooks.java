package step_definitions;

import application.BankBase;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * Hooks will run as long as it's under the step_defs package
 * Hooks are used to perform the operations that are needed for the application to be ready
 * to execute the test. these operations are not related to business logic.
 * But these are more of a technical operations.
 *
 * ex: reset the caches of the application.
 * ex: clear all data in db that was populated by the previous test.
 * ex: bring the browser back to the home after the test is done or before executing the test, to make sure
 * your tests start from an expected page.
 *
 */
public class Hooks {

    private static boolean isExecuted = false;

    //Runs before every single scenario in every feature file
    //Runs before background
   // @Before
    public void beforeHook(){
        System.out.println("Running before hook");
        BankBase.allBankRecords.clear();
    }

    //Runs after every single scenario in every feature file
    //will run after the scenario regardless of the result of the test. pass or fail.
    //so it's guaranteed to run
    @After
    public void afterHook(){
        System.out.println("Running after");
    }


    //will run only before scenarios that have @smoke tag
    @Before("@smoke")
    public void beforeSmoke() {
        System.out.println("Before Smoke");
    }

    @After("@regression")
    public void afterRegression(){

        System.out.println("After Regression");
    }


    //Junit and testNG have beforeClass or beforeSuite.
    //cucumber doesnt have that option.
    //so we need to hack that gap
    @Before
    public void onceBeforeAllTests(){
        if (!isExecuted) {
            System.out.println("Setting up environment before running regression");
            isExecuted = true;
        }
    }
}
