Feature: Deposit some amount to the account.

  Scenario: Deposit amount within allowed range.
    #Precondition -> some setup that needs to happen for this scenario to execute
    #use in past tense
    Given User account with accountNumer 123456789101 and routing number 123456789 is opened
    #Action - execution of the functionality that being testing
    #Present tense
    When User deposits $1000
    #should be, should have
    Then User should have $1000 in account


