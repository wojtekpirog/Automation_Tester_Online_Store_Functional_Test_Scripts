Feature: Product purchase
  Scenario: User can purchase a product from an online store
    Given User is logged in to their homepage
    When User places an order for a specific product
    Then User can see the order confirmation along with its amount