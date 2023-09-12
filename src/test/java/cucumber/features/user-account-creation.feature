Feature: Address creation
  Scenario Outline: User can add a new address
    Given User is logged in to their homepage
    When User creates an address with <Alias>, <Address>, <City>, <Zip/Postal Code>, <Country>, <Phone>
    Then The address is created with appropriate data: <Alias>, <Address>, <City>, <Zip/Postal Code>, <Country>, <Phone>
    And User can delete the address
    Then The address is not visible in the Addresses page

    Examples:
      | Alias   | Address            | City      | Zip/Postal Code | Country          | Phone           |
      | "Work"  | "20 Oxford Street" | "London"  | 00-000          | "United Kingdom" | "+44 123456789" |