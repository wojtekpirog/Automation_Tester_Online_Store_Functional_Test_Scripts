Feature: Address creation
  Scenario Outline: User can add a new address
    Given User is logged in to his page
    When User creates an address with <Alias>, <Address>, <City>, <Zip/Postal Code>, <Country>, <Phone>
    Then The address is created with appropriate data

    Examples:
      | Alias             | Address                   | City             | Zip/Postal Code | Country               | Phone        |
      | "Adres Domowy"    | "Żółte Zęby 2/4"          | "Wrocław"        | 00-000          | "United Kingdom"      | 123456789    |