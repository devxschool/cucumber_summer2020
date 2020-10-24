@regression
Feature: Scenario Outline feature



  ##cucumber advantage is reusibility
  #implement the step once dynamically and resuse it in many other test scenarios
  #in order to run the same scenario against different test data
  #and avoid repetition we can use scenario outline and example table




  #Scenario outline helps us run the same test case against different set of test data

  Scenario Outline: Multiple tests
    Given user with "<usernameRegistered>" and "<passwordRegistered>" is registered
    When user with "<username>" and "<password>" logs in
    Then user should see the "<message>"

    Examples:
      | usernameRegistered | passwordRegistered | username          | password | message                |
      | JohnDoe@gmail.com  | 123pass            | JohnDoe@gmail.com | 123pass  | HomePage               |
      | JohnDoe@gmail.com  | 123pass            | JohnDoe@gmail.com | 12pass   | password error page    |
      | JohnDoe@gmail.com  | 123pass            | John@gmail.com    | 123pass  | no username error page |
      | JohnDoe@gmail.com  | 123pass            | JohnDoe@gmail.com |          | input password         |





#  Scenario: Login functionality positive
#    When user with "JohnDoe@gmail.com" and "123pass" logs in
#    Then user should be navigated to "homepage"
#
#
#  Scenario: Login with invalid password
#      When user with "JohnDoe@gmail.com" and "12pass" logs in
#      Then user should be navigated to "password error page"
#
#
#  Scenario: Login with invalid username
#    When user with "John@gmail.com" and "123pass" logs in
#    Then user should be navigated to "no username error page"
#
#
#  Scenario: Login with no passowrd
#    When user with "JohnDoe@gmail.com" and " " logs in
#    Then user should be navigated to "input password"






