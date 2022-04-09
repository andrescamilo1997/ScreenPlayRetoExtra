# new feature
# Tags: optional

Feature: delete currency
  me as administrator
  I want to be able to delete the currency that I have added
  To have better control and only have what you need

  Scenario: delete the created currency
    Given enter with your credentials and Currencies were created
    When  delete created currencies
    Then  displays a No records found message