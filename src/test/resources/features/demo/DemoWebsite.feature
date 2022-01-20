@lambdatest
Feature: Lambda Test Checkers

  Scenario: Valid Login
    Given I go to Homepage
    Then I should see correct title page for Homepage
    And I login with valid credential

  Scenario: Invalid Login
    Given I go to Homepage
    Then I should see correct title page for Homepage
    And I login with invalid credential

  Scenario: Checkout item
    Given I go to Homepage
    And I login with valid credential
    When I add products to cart
    And I proceed to checkout without checking TOC
    Then I should see TOC warning
    When I proceed to checkout after checking TOC
    Then I should be at payment section
    And I logout from website