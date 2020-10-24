@regression @smoke
Feature: WithDraw with data tables with list of objects

  Scenario: Withdraw after opening account
    Given the user accounts are created
      | accountNumber | routingNumber | balance |
      | 234523453245  | 123456789     | 200     |
      | 114523453123  | 222456789     | 200     |
      | 884523453123  | 882456789     | 200     |
    When the users withdraw
      | accountNumber | withdrawAmount |
      | 234523453245  | 50             |
      | 884523453123  | 100            |
      | 114523453123  | 200            |
    Then the users have the following balances
      | accountNumber | balance |
      | 884523453123  | 100     |
      | 234523453245  | 150     |
      | 114523453123  | 0       |

####Business logic bug.


  #####more of a technical bug.



