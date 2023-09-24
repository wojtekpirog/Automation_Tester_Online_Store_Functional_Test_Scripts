Feature: Product purchase
  Scenario: User can purchase a product from an online store
    Given User with email wojciechkowalski@gmail.com and password Voyt@$$ is logged in to the homepage
    When User places an order for 5 pieces of sweater of size M
    Then User can see the order confirmation along with its amount