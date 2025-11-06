Feature: ParaBank

#  @Google
#  Scenario: Verify Google homepage title
#    Given I open Google homepage
#    Then The page title should contain "Google"

  @Bank1
  Scenario Outline: New user registration
    Given Open ParaBank application
    When User click on register
    And Fill all the mandatory fields "<First Name>", "<Last Name>", "<Address>", "<City>", "<State>", "<Zip Code>", "<Phone>", "<SSN>", "<Username>", "<Password>"
    And User clicks on register
    Then User is created or not created successfully "<Message>"
    Examples:
      | First Name | Last Name | Address | City   | State  | Zip Code | Phone      | SSN     | Username | Password | Confirm Password | Message                                                       |
      | test1      | test1     | testad  | testct | testst | 12345    | 1234123412 | 1234567 | test1    | test1    | test1            | Your account was created successfully. You are now logged in. |


  @Bank
  Scenario: login ParaBank
    Given Open ParaBank application
    When Login to application
    Then Verify user successfully logged into application




