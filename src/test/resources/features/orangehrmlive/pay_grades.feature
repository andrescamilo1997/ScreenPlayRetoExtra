# new feature
# Tags: optional

Feature: pay grades

  me as administrator
  I want to be able to add a new grade and put a currency
  for have my information in order.

  Background:
    Given enter with your credentials and enter the pay grades section

  Scenario: income of pay grades
    When  enters a new degree, and assigns it a currencies
    Then  Currencies are added to a list

  Scenario: income of pay grades
    When  enters a new grade, assigns it a currencies and go back to delete this grade
    Then  grade are deleted to the list